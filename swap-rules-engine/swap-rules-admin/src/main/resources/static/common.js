const API_BASE = "/api/v1";

const RULE_CATEGORIES = ["ECONOMIC", "NON_ECONOMIC", "BUSINESS", "WORKFLOW", "ROUTING", "VALIDATION"];
const ENRICHMENT_TARGETS = ["SWAP_CONTRACT","INTEREST_LEG","EQUITY_LEG","SCHEDULE","DIV_PASSTHROUGH","LEGAL_ENTITY","DOCUMENTATION","WORKFLOW","ROUTING"];
const EVALUATION_MODES = ["LAYERED", "FIRST_MATCH", "ALL_MATCH"];
const RULE_STATUSES = ["DRAFT", "PUBLISHED", "RETIRED"];
const OPERATORS = ["EQ","NE","GT","LT","GTE","LTE","IN","NOT_IN","CONTAINS","STARTS_WITH","REGEX","EXISTS","NOT_EXISTS"];
const OVERRIDE_POLICIES = ["NEVER", "ALWAYS", "IF_NULL"];

const TRADE_FIELDS = ["productType", "book", "currency", "clientTier", "source", "notional", "tradeDate", "securityId"];

const TRADE_PRESETS = {
  "usd-tier1": {
    tradeId: "T-USD-T1-001",
    productType: "EQUITY_SWAP",
    book: "EQ_SWAP",
    currency: "USD",
    clientTier: "TIER_1",
    source: "MANUAL",
    notional: 5000000,
    tradeDate: "2026-05-23",
    securityId: "US0378331005"
  },
  "usd-auto": {
    tradeId: "T-USD-AUTO-002",
    productType: "EQUITY_SWAP",
    book: "EQ_SWAP",
    currency: "USD",
    clientTier: "TIER_2",
    source: "AUTO",
    notional: 1000000,
    tradeDate: "2026-05-23",
    securityId: "US0378331005"
  },
  "eur-auto": {
    tradeId: "T-EUR-AUTO-003",
    productType: "EQUITY_SWAP",
    book: "EQ_SWAP",
    currency: "EUR",
    clientTier: "TIER_2",
    source: "AUTO",
    notional: 2000000,
    tradeDate: "2026-05-23",
    securityId: "DE0007164600"
  },
  "unknown": {
    tradeId: "T-UNKNOWN-004",
    productType: "EQUITY_SWAP",
    book: "UNKNOWN_BOOK",
    currency: "JPY",
    clientTier: "TIER_3",
    source: "AUTO",
    notional: 100000,
    tradeDate: "2026-05-23",
    securityId: "JP3633400001"
  }
};

function $(id) { return document.getElementById(id); }

function el(tag, opts = {}, children = []) {
  const e = document.createElement(tag);
  if (opts.cls) e.className = opts.cls;
  if (opts.text !== undefined) e.textContent = opts.text;
  if (opts.html !== undefined) e.innerHTML = opts.html;
  if (opts.attrs) Object.entries(opts.attrs).forEach(([k, v]) => e.setAttribute(k, v));
  if (opts.onClick) e.addEventListener("click", opts.onClick);
  children.forEach(c => c && e.appendChild(c));
  return e;
}

function toast(msg, error = false) {
  const t = el("div", { cls: "toast" + (error ? " error" : ""), text: msg });
  document.body.appendChild(t);
  setTimeout(() => t.remove(), 3500);
}

async function api(path, opts = {}) {
  const resp = await fetch(API_BASE + path, {
    headers: { "Content-Type": "application/json", ...(opts.headers || {}) },
    ...opts
  });
  if (!resp.ok) {
    const text = await resp.text();
    throw new Error(`${resp.status}: ${text.substring(0, 240)}`);
  }
  const ct = resp.headers.get("content-type") || "";
  if (ct.includes("application/json")) return resp.json();
  return resp.text();
}

async function refreshSnapshotBadge() {
  const el = document.getElementById("snapshotText");
  if (!el) return;
  try {
    const snap = await api("/snapshot");
    el.textContent = `${snap.totalRules} rules · ${snap.checksum}`;
  } catch (e) {
    el.textContent = "snapshot unavailable";
  }
}

function dropdown(name, options, current) {
  const sel = el("select", { attrs: { name } });
  options.forEach(o => {
    const opt = document.createElement("option");
    opt.value = o;
    opt.textContent = o;
    if (o === current) opt.selected = true;
    sel.appendChild(opt);
  });
  return sel;
}

function categoryChip(cat) {
  return el("span", { cls: "chip cat-" + cat.toLowerCase(), text: cat });
}

function copyToClipboard(text) {
  navigator.clipboard.writeText(text).then(() => toast("Copied"));
}

// ====================== Schema + Enumeration runtime ======================
// Cached on first access. Call refreshSchemas()/refreshEnums() to force re-fetch.
const META = { trade: null, swap: null, enums: null, enumIdx: null };

async function loadSchemas(force = false) {
  if (!force && META.trade && META.swap) return META;
  const [trade, swap] = await Promise.all([api("/schema/trade"), api("/schema/swap")]);
  META.trade = trade;
  META.swap = swap;
  return META;
}

async function loadEnums(force = false) {
  if (!force && META.enums) return META.enums;
  const list = await api("/enumerations");
  META.enums = list;
  META.enumIdx = {};
  list.forEach(e => { META.enumIdx[e.code] = e; });
  return list;
}

async function refreshEnumsRemote() {
  await api("/enumerations/refresh", { method: "POST" });
  return await loadEnums(true);
}

function getEnum(code) {
  if (!META.enumIdx) return null;
  return META.enumIdx[code] || null;
}

function fieldByPath(schema, path) {
  return (schema?.fields || []).find(f => f.path === path) || null;
}

function leafFields(schema) {
  return (schema?.fields || []).filter(f => f.type !== "OBJECT" && f.type !== "MAP");
}

function writableLeafFields(schema) {
  return leafFields(schema).filter(f => f.writable);
}

// Build a dropdown of all addressable paths in a schema (one entry per leaf).
function fieldPathSelect(schema, currentPath, opts = {}) {
  const sel = el("select", { cls: "field-select" });
  const placeholder = document.createElement("option");
  placeholder.value = "";
  placeholder.textContent = "— select field —";
  sel.appendChild(placeholder);
  const fields = opts.writableOnly ? writableLeafFields(schema) : leafFields(schema);
  fields.forEach(f => {
    const o = document.createElement("option");
    o.value = f.path;
    o.textContent = `${f.path}  ·  ${f.type}${f.enumRef ? "  (" + f.enumRef + ")" : ""}`;
    if (f.description) o.title = f.description;
    if (f.path === currentPath) o.selected = true;
    sel.appendChild(o);
  });
  return sel;
}

// Render an input appropriate for the field's type & enum binding.
function valueInputFor(field, currentValue, onChange) {
  if (!field) {
    const inp = el("input", { attrs: { type: "text", value: currentValue ?? "", placeholder: "value" } });
    inp.addEventListener("input", () => onChange(inp.value));
    return inp;
  }
  if (field.enumRef) {
    const e = getEnum(field.enumRef);
    if (e) {
      const sel = el("select", { cls: "value-select" });
      const ph = document.createElement("option");
      ph.value = "";
      ph.textContent = `— pick ${field.enumRef} —`;
      sel.appendChild(ph);
      (e.values || []).filter(v => v.active !== false).forEach(v => {
        const o = document.createElement("option");
        o.value = v.code;
        o.textContent = v.label === v.code ? v.code : `${v.code} — ${v.label}`;
        if (String(currentValue ?? "") === v.code) o.selected = true;
        sel.appendChild(o);
      });
      sel.addEventListener("change", () => onChange(sel.value));
      return sel;
    }
  }
  switch (field.type) {
    case "DATE": {
      const inp = el("input", { attrs: { type: "date", value: currentValue ?? "" } });
      inp.addEventListener("input", () => onChange(inp.value));
      return inp;
    }
    case "DECIMAL":
    case "INTEGER": {
      const inp = el("input", { attrs: { type: "number", step: field.type === "DECIMAL" ? "any" : "1", value: currentValue ?? "" } });
      inp.addEventListener("input", () => onChange(inp.value));
      return inp;
    }
    case "BOOLEAN": {
      const sel = el("select");
      ["", "true", "false"].forEach(v => {
        const o = document.createElement("option");
        o.value = v;
        o.textContent = v === "" ? "— pick —" : v;
        if (String(currentValue ?? "") === v) o.selected = true;
        sel.appendChild(o);
      });
      sel.addEventListener("change", () => onChange(sel.value));
      return sel;
    }
    default: {
      const inp = el("input", { attrs: { type: "text", value: currentValue ?? "", placeholder: "value" } });
      inp.addEventListener("input", () => onChange(inp.value));
      return inp;
    }
  }
}

function operatorSelect(field, currentOp) {
  const options = field?.operators?.length
    ? field.operators
    : OPERATORS;
  const sel = el("select", { cls: "op-select" });
  options.forEach(o => {
    const opt = document.createElement("option");
    opt.value = o;
    opt.textContent = o;
    if (o === currentOp) opt.selected = true;
    sel.appendChild(opt);
  });
  return sel;
}

// ====================== Duplication inspector ======================
// Calls the server-side /inspect endpoint; renders findings into `hostEl`; toggles `saveBtn`
// disabled state on ERROR severity. Returns the latest report so callers can react.
function debounce(fn, ms = 500) {
  let t = null;
  return (...args) => {
    clearTimeout(t);
    t = setTimeout(() => fn(...args), ms);
  };
}

const SEVERITY_RANK = { OK: 0, WARNING: 1, ERROR: 2 };
const SEVERITY_LABELS = { OK: "No duplicates", WARNING: "Warnings", ERROR: "Cannot save" };

function renderDuplicationStrip(hostEl, report, saveBtn) {
  hostEl.innerHTML = "";
  if (!report) return;
  const level = report.level || "OK";
  const strip = el("div", { cls: "dup-strip dup-" + level.toLowerCase() });
  const head = el("div", { cls: "dup-head" });
  head.appendChild(el("span", { cls: "dup-badge dup-badge-" + level.toLowerCase(), text: SEVERITY_LABELS[level] || level }));
  if (report.canonicalHash) {
    head.appendChild(el("span", { cls: "muted tiny", text: " fingerprint " + report.canonicalHash }));
  }
  strip.appendChild(head);
  (report.findings || []).forEach(f => {
    const row = el("div", { cls: "dup-finding dup-" + (f.severity || "WARNING").toLowerCase() });
    row.appendChild(el("span", { cls: "dup-code", text: f.code }));
    row.appendChild(el("span", { cls: "dup-msg", text: f.message }));
    if (f.hint) row.appendChild(el("span", { cls: "dup-hint", text: f.hint }));
    if (f.conflictId) row.appendChild(el("span", { cls: "chip", text: f.conflictId }));
    strip.appendChild(row);
  });
  hostEl.appendChild(strip);
  if (saveBtn) {
    if (level === "ERROR") {
      saveBtn.disabled = true;
      saveBtn.title = "Resolve the duplication errors before saving";
    } else {
      saveBtn.disabled = false;
      saveBtn.title = "";
    }
  }
  highlightRows(report);
}

function highlightRows(report) {
  document.querySelectorAll(".rl-row.dup-err").forEach(r => r.classList.remove("dup-err"));
  document.querySelectorAll(".rl-row.dup-warn").forEach(r => r.classList.remove("dup-warn"));
  const criteriaContainers = ["criteriaRows", "fragCriteriaRows"];
  const actionContainers = ["actionRows", "tplActionRows"];
  (report.findings || []).forEach(f => {
    const cls = f.severity === "ERROR" ? "dup-err" : "dup-warn";
    (f.inlineCriteriaIndices || []).forEach(i => {
      criteriaContainers.forEach(id => {
        const c = document.getElementById(id);
        if (c && c.children[i]) c.children[i].classList.add(cls);
      });
    });
    (f.inlineActionIndices || []).forEach(i => {
      actionContainers.forEach(id => {
        const c = document.getElementById(id);
        if (c && c.children[i]) c.children[i].classList.add(cls);
      });
    });
  });
}

// Build a debounced inspector closure bound to a host element + save button + endpoint suffix.
// `payloadFn` returns the JSON-ready artifact at call time.
function makeInspector(endpoint, payloadFn, hostEl, saveBtn) {
  const run = debounce(async () => {
    try {
      const report = await api(endpoint, { method: "POST", body: JSON.stringify(payloadFn()) });
      renderDuplicationStrip(hostEl, report, saveBtn);
    } catch (e) {
      hostEl.textContent = "inspect failed: " + e.message;
    }
  }, 450);
  return run;
}

async function postOrShowConflict(endpoint, payload, hostEl, saveBtn) {
  try {
    return await api(endpoint, { method: "POST", body: JSON.stringify(payload) });
  } catch (e) {
    const m = /^(\d{3}):\s*(.*)$/.exec(e.message);
    if (m && m[1] === "409") {
      try {
        const report = JSON.parse(m[2]);
        renderDuplicationStrip(hostEl, report, saveBtn);
      } catch (_) { /* fall through */ }
      toast("Save blocked by duplication errors", true);
      throw e;
    }
    throw e;
  }
}
