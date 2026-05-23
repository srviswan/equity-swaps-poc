let currentTrade = null;
let currentResult = null;

function renderPresets() {
  const row = $("presetRow");
  Object.entries(TRADE_PRESETS).forEach(([key, t]) => {
    const labelMap = {
      "usd-tier1": "USD · Tier-1 · Manual",
      "usd-auto":  "USD · Tier-2 · Auto",
      "eur-auto":  "EUR · Tier-2 · Auto",
      "unknown":   "Unknown book (no match)"
    };
    row.appendChild(el("button", {
      cls: "preset",
      text: labelMap[key],
      onClick: () => loadPreset(key)
    }));
  });
}

function renderQuickForm(trade) {
  const f = $("quickForm");
  f.innerHTML = "";
  const widths = {
    tradeId: 2, productType: 1, book: 1, currency: 1, clientTier: 1, source: 1,
    notional: 1, tradeDate: 1, securityId: 2
  };
  const schema = META.trade;
  const fields = schema && schema.fields
    ? schema.fields.filter(fd => fd.type !== "OBJECT" && fd.type !== "MAP")
    : Object.keys(widths).map(k => ({ path: k, type: "STRING", enumRef: null, operators: [], writable: false, nullable: true, description: "" }));

  fields.forEach(fd => {
    const wrap = el("div", { cls: "field w" + (widths[fd.path] || 1) });
    const label = el("label", { text: fd.path });
    if (fd.description) label.title = fd.description;
    wrap.appendChild(label);
    const inp = valueInputFor(fd, trade[fd.path] ?? "", (v) => {
      let val = v;
      if (fd.type === "DECIMAL" && v !== "") val = Number(v);
      else if (fd.type === "INTEGER" && v !== "") val = parseInt(v, 10);
      else if (fd.type === "BOOLEAN") val = v === "" ? null : v === "true";
      currentTrade[fd.path] = val;
      $("rawTradeInput").value = JSON.stringify(currentTrade, null, 2);
    });
    wrap.appendChild(inp);
    f.appendChild(wrap);
  });
}

function loadPreset(key) {
  currentTrade = JSON.parse(JSON.stringify(TRADE_PRESETS[key]));
  $("rawTradeInput").value = JSON.stringify(currentTrade, null, 2);
  renderQuickForm(currentTrade);
}

$("rawTradeInput").addEventListener("input", () => {
  try {
    currentTrade = JSON.parse($("rawTradeInput").value);
    renderQuickForm(currentTrade);
  } catch (_) { /* ignore until valid */ }
});

$("enrichBtn").addEventListener("click", async () => {
  let trade;
  try { trade = JSON.parse($("rawTradeInput").value); }
  catch (e) { return toast("Invalid JSON", true); }
  currentTrade = trade;
  $("enrichBtn").disabled = true;
  $("enrichTiming").textContent = "running…";
  const t0 = performance.now();
  try {
    const result = await api("/enrich", { method: "POST", body: JSON.stringify(trade) });
    currentResult = result;
    const elapsed = (performance.now() - t0).toFixed(1);
    $("enrichTiming").textContent = `client round-trip ${elapsed}ms · server snapshot ${result.trace.snapshotVersion.substring(0,8)}`;
    renderResult(result);
  } catch (e) {
    toast(e.message, true);
    $("enrichTiming").textContent = "";
  } finally {
    $("enrichBtn").disabled = false;
  }
});

function renderResult(result) {
  $("resultCard").style.display = "block";
  $("traceCard").style.display = "block";

  // result meta
  const m = $("resultMeta");
  m.innerHTML = "";
  m.appendChild(el("span", { cls: "meta-pill", text: result.trace.decisions.length + " decision(s)" }));
  m.appendChild(el("span", { cls: "meta-pill", text: result.trace.unresolved.length + " unresolved" }));

  // swap grid - card per target
  renderSwapGrid(result.swap, result.trace);

  // trace timeline
  renderTraceTimeline(result.trace);

  // unresolved + near-miss
  if (result.trace.unresolved.length > 0) {
    $("unresolvedCard").style.display = "block";
    renderUnresolved(result.trace.unresolved);
  } else {
    $("unresolvedCard").style.display = "none";
  }
}

function renderSwapGrid(swap, trace) {
  const g = $("swapGrid");
  g.innerHTML = "";
  // group decisions by target
  const targetToRules = {};
  trace.decisions.forEach(d => {
    targetToRules[d.target] = targetToRules[d.target] || [];
    if (!targetToRules[d.target].some(r => r.ruleId === d.ruleId)) {
      targetToRules[d.target].push({ ruleId: d.ruleId, category: d.category });
    }
  });
  const slices = [
    { key: "swapContract", target: "SWAP_CONTRACT", icon: "📄" },
    { key: "interestLeg", target: "INTEREST_LEG", icon: "%" },
    { key: "equityLeg", target: "EQUITY_LEG", icon: "$" },
    { key: "schedule", target: "SCHEDULE", icon: "📅" },
    { key: "divPassthrough", target: "DIV_PASSTHROUGH", icon: "₪" },
    { key: "workflowStatus", target: "WORKFLOW", icon: "✓", isScalar: true },
    { key: "routingDestination", target: "ROUTING", icon: "➡", isScalar: true }
  ];
  slices.forEach(s => {
    const value = swap[s.key];
    const card = el("div", { cls: "swap-slice" });
    const head = el("div", { cls: "swap-slice-head" });
    head.appendChild(el("span", { cls: "icon", text: s.icon }));
    head.appendChild(el("span", { cls: "slice-name", text: s.target }));
    card.appendChild(head);
    const body = el("div", { cls: "swap-slice-body" });
    if (value == null || (typeof value === "object" && Object.keys(value).length === 0)) {
      body.appendChild(el("div", { cls: "slice-empty", text: "— no value —" }));
    } else if (typeof value === "object") {
      Object.entries(value).forEach(([k, v]) => {
        const row = el("div", { cls: "kv" });
        row.appendChild(el("span", { cls: "k", text: k }));
        row.appendChild(el("span", { cls: "v", text: String(v) }));
        body.appendChild(row);
      });
    } else {
      const row = el("div", { cls: "kv" });
      row.appendChild(el("span", { cls: "k", text: s.key }));
      row.appendChild(el("span", { cls: "v", text: String(value) }));
      body.appendChild(row);
    }
    card.appendChild(body);
    const rules = targetToRules[s.target] || [];
    if (rules.length) {
      const tail = el("div", { cls: "swap-slice-tail" });
      tail.appendChild(el("span", { cls: "muted", text: "from " }));
      rules.forEach(r => tail.appendChild(el("span", { cls: "chip cat-" + r.category.toLowerCase(), text: r.ruleId })));
      card.appendChild(tail);
    }
    g.appendChild(card);
  });
}

function renderTraceTimeline(trace) {
  const tl = $("traceTimeline");
  tl.innerHTML = "";
  $("traceCount").textContent = trace.decisions.length + " applied";
  if (trace.decisions.length === 0) {
    tl.appendChild(el("div", { cls: "muted pad", text: "No rules applied." }));
    return;
  }
  trace.decisions.forEach(d => {
    const item = el("div", { cls: "timeline-item " + d.category.toLowerCase() });
    const head = el("div", { cls: "ti-head" });
    head.appendChild(el("span", { cls: "seq", text: d.seq }));
    head.appendChild(el("span", { cls: "rule-id", text: `${d.ruleId} v${d.ruleVersion}` }));
    head.appendChild(el("span", { cls: "chip cat-" + d.category.toLowerCase(), text: d.category }));
    head.appendChild(el("span", { cls: "muted", text: `→ ${d.target}` }));
    item.appendChild(head);

    const meta = el("div", { cls: "ti-meta" });
    meta.textContent = `${d.strategy} · specificity ${d.specificity.toFixed(1)}` +
      (d.matchedCriteria && d.matchedCriteria.length ? ` · matched [${d.matchedCriteria.join(", ")}]` : "");
    item.appendChild(meta);

    d.paths.forEach(p => {
      const ch = el("div", { cls: "change" });
      ch.appendChild(el("span", { cls: "path", text: p }));
      ch.appendChild(el("span", { text: "  " }));
      if (d.before) {
        ch.appendChild(el("span", { cls: "before", text: d.before }));
        ch.appendChild(el("span", { cls: "arrow", text: " → " }));
      } else {
        ch.appendChild(el("span", { cls: "before", text: "∅" }));
        ch.appendChild(el("span", { cls: "arrow", text: " → " }));
      }
      ch.appendChild(el("span", { cls: "after", text: d.after ?? "∅" }));
      item.appendChild(ch);
    });
    tl.appendChild(item);
  });
}

async function renderUnresolved(unresolved) {
  const group = $("unresolvedGroup");
  group.innerHTML = "";
  const targets = [...new Set(unresolved.map(u => u.target))];
  for (const target of targets) {
    const card = el("div", { cls: "unresolved-block" });
    const head = el("div", { cls: "ub-head" });
    head.appendChild(el("span", { cls: "ub-target", text: target }));
    head.appendChild(el("span", { cls: "muted", text: "NO_MATCH" }));
    card.appendChild(head);
    const body = el("div", { cls: "ub-body" });
    body.appendChild(el("div", { cls: "muted small", text: "Scoring existing rules…" }));
    card.appendChild(body);
    group.appendChild(card);

    try {
      const results = await api(`/rules/near-miss?target=${target}&top=3`, {
        method: "POST",
        body: JSON.stringify(currentTrade)
      });
      body.innerHTML = "";
      if (results.length === 0) {
        body.appendChild(el("div", { cls: "muted small", text: "No existing rules for this target. Author one from scratch in Studio." }));
        const a = el("a", { cls: "primary small", text: "Author from scratch →", attrs: { href: `/studio.html?new=rule&target=${target}` } });
        body.appendChild(a);
        continue;
      }
      results.forEach(r => {
        const row = el("div", { cls: "nm-row" });
        const left = el("div", { cls: "nm-left" });
        left.appendChild(el("strong", { text: r.ruleId + " v" + r.ruleVersion + " " }));
        left.appendChild(el("span", { cls: "nm-score", text: `${(r.score * 100).toFixed(0)}% match` }));
        if (r.missingCriteria && r.missingCriteria.length) {
          const m = el("div", { cls: "nm-missing" });
          m.appendChild(el("span", { cls: "small muted", text: "missing: " }));
          r.missingCriteria.forEach(mc => m.appendChild(el("span", { cls: "chip danger", text: mc })));
          left.appendChild(m);
        }
        row.appendChild(left);
        row.appendChild(el("button", {
          cls: "primary small",
          text: "Promote to draft →",
          onClick: () => promoteToDraft(r.ruleId, r.ruleVersion)
        }));
        body.appendChild(row);
      });
    } catch (e) {
      body.innerHTML = "";
      body.appendChild(el("div", { cls: "danger small", text: "Near-miss failed: " + e.message }));
    }
  }
}

async function promoteToDraft(ruleId, version) {
  try {
    const draft = await api("/rules/from-candidate", {
      method: "POST",
      body: JSON.stringify({ ruleId, version, trade: currentTrade })
    });
    sessionStorage.setItem("studio.draftRule", JSON.stringify(draft));
    sessionStorage.setItem("studio.draftSource", JSON.stringify({
      from: `near-miss of ${ruleId} v${version}`,
      trade: currentTrade
    }));
    window.location.href = "/studio.html?draft=session";
  } catch (e) {
    toast(e.message, true);
  }
}

// Init
renderPresets();
refreshSnapshotBadge();
setInterval(refreshSnapshotBadge, 15000);

// Schema + enums power the quick form & near-miss draft handoff. Load them, then render.
Promise.all([loadSchemas(), loadEnums()])
  .catch(() => {/* enrich still works without enum data */})
  .finally(() => loadPreset("usd-tier1"));
