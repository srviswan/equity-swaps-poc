// ====================== State ======================
const studio = {
  rules: [],
  templates: [],
  fragments: [],
  view: "rules"
};

const main = document.getElementById("studioMain");

// ====================== View routing ======================
async function loadView(view) {
  studio.view = view;
  document.querySelectorAll(".nav-item").forEach(n =>
    n.classList.toggle("active", n.dataset.view === view)
  );
  await Promise.all([loadRules(), loadTemplates(), loadFragments(), loadSchemas(), loadEnums()]);
  refreshEnumBadge();
  if (view === "snapshot") return showSnapshot();
  if (view === "rules") return showRulesList();
  if (view === "templates") return showTemplatesList();
  if (view === "fragments") return showFragmentsList();
  if (view === "enumerations") return showEnumerationsView();
  if (view === "simulate") return showSimulate();
}

function refreshEnumBadge() {
  const t = document.getElementById("enumText");
  if (!t) return;
  if (!META.enums) { t.textContent = "enums: unavailable"; return; }
  t.textContent = `enums: ${META.enums.length}`;
}

document.getElementById("refreshEnumsBtn")?.addEventListener("click", async () => {
  try {
    await refreshEnumsRemote();
    refreshEnumBadge();
    toast("Enumerations refreshed");
    if (studio.view === "enumerations") showEnumerationsView();
  } catch (e) { toast(e.message, true); }
});

document.querySelectorAll(".nav-item").forEach(n =>
  n.addEventListener("click", () => loadView(n.dataset.view))
);

document.getElementById("publishBtn").addEventListener("click", async () => {
  try {
    await api("/snapshots/publish", { method: "POST" });
    toast("Snapshot published");
    refreshSnapshotBadge();
    if (studio.view === "snapshot") showSnapshot();
  } catch (e) { toast(e.message, true); }
});

// ====================== Data loading ======================
async function loadRules() {
  try { studio.rules = await api("/rules"); } catch (e) { toast(e.message, true); studio.rules = []; }
}
async function loadTemplates() {
  try { studio.templates = await api("/templates"); } catch (e) { studio.templates = []; }
}
async function loadFragments() {
  try { studio.fragments = await api("/fragments"); } catch (e) { studio.fragments = []; }
}

// ====================== Snapshot view ======================
async function showSnapshot() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-snapshot-view").content.cloneNode(true));
  try {
    const snap = await api("/snapshot");
    const sum = document.getElementById("snapshotSummary");
    [
      ["Snapshot ID", snap.snapshotId.substring(0,8)+"…"],
      ["Checksum", snap.checksum],
      ["Total rules", snap.totalRules],
      ["Buckets", snap.buckets.length],
      ["Published at", new Date(snap.publishedAt).toLocaleString()]
    ].forEach(([l,v]) => {
      const s = el("div", { cls: "stat" });
      s.appendChild(el("div", { cls: "label", text: l }));
      s.appendChild(el("div", { cls: "value", text: v }));
      sum.appendChild(s);
    });
    const dupHost = document.getElementById("snapshotDuplicationStrip");
    if (dupHost) {
      const findings = snap.duplicationFindings || [];
      if (findings.length === 0) {
        dupHost.innerHTML = "";
      } else {
        const worst = findings.some(f => f.severity === "ERROR") ? "ERROR" : "WARNING";
        renderDuplicationStrip(dupHost, { level: worst, findings, canonicalHash: snap.checksum }, null);
      }
    }
    const wrap = document.getElementById("snapshotBuckets");
    const maxSpec = Math.max(...snap.buckets.flatMap(b => b.rules.map(r => r.specificity)), 1);
    snap.buckets.forEach(b => {
      const bucket = el("div", { cls: "bucket open" });
      const head = el("div", { cls: "bucket-header" });
      const left = el("div");
      left.appendChild(el("span", { cls: "chip cat-" + b.category.toLowerCase(), text: b.category }));
      left.appendChild(el("span", { text: " " + b.target + " " }));
      left.appendChild(el("span", { cls: "tag mode", text: b.evaluationMode }));
      head.appendChild(left);
      head.appendChild(el("span", { cls: "muted", text: b.ruleCount + " rule(s)" }));
      head.addEventListener("click", () => bucket.classList.toggle("open"));
      bucket.appendChild(head);
      const rules = el("div", { cls: "bucket-rules" });
      b.rules.forEach(r => {
        const row = el("div", { cls: "rule" });
        row.appendChild(el("div", { text: r.ruleId + " — " + r.name }));
        const wrap2 = el("div");
        const bar = el("span", { cls: "specificity-bar" });
        bar.style.width = Math.max(20, (r.specificity / maxSpec) * 120) + "px";
        wrap2.appendChild(bar);
        wrap2.appendChild(el("span", { text: " " + r.specificity.toFixed(1) }));
        row.appendChild(wrap2);
        row.appendChild(el("div", { text: "pri " + r.priority }));
        rules.appendChild(row);
      });
      bucket.appendChild(rules);
      wrap.appendChild(bucket);
    });
  } catch (e) { toast(e.message, true); }
}

// ====================== Rules list ======================
function showRulesList() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-rules-view").content.cloneNode(true));
  const cat = document.getElementById("filterCategory");
  RULE_CATEGORIES.forEach(c => cat.appendChild(new Option(c, c)));
  const tgt = document.getElementById("filterTarget");
  ENRICHMENT_TARGETS.forEach(t => tgt.appendChild(new Option(t, t)));
  cat.addEventListener("change", renderRulesList);
  tgt.addEventListener("change", renderRulesList);
  document.getElementById("newRuleBtn").addEventListener("click", () => openRuleEditor(null));
  renderRulesList();
}

function renderRulesList() {
  const cat = document.getElementById("filterCategory").value;
  const tgt = document.getElementById("filterTarget").value;
  const list = document.getElementById("rulesList");
  list.innerHTML = "";
  const filtered = studio.rules.filter(r =>
    (!cat || r.category === cat) && (!tgt || r.target === tgt)
  );
  if (filtered.length === 0) {
    list.appendChild(el("div", { cls: "muted pad", text: "No rules. Click + New rule to create one." }));
    return;
  }
  filtered.sort((a,b) => (a.category+a.target+a.id).localeCompare(b.category+b.target+b.id));
  filtered.forEach(r => {
    const card = el("div", { cls: "rule-card" });
    const head = el("div", { cls: "rc-head" });
    head.appendChild(el("strong", { text: r.id }));
    head.appendChild(el("span", { cls: "muted", text: " v" + r.version }));
    head.appendChild(categoryChip(r.category));
    head.appendChild(el("span", { cls: "chip", text: r.target }));
    head.appendChild(el("span", { cls: "chip status-" + r.status.toLowerCase(), text: r.status }));
    card.appendChild(head);
    if (r.name) card.appendChild(el("div", { cls: "rc-name", text: r.name }));
    const meta = el("div", { cls: "rc-meta" });
    meta.appendChild(el("span", { cls: "muted small", text: "priority " + (r.priority ?? 100) }));
    if (r.includes && r.includes.length) {
      meta.appendChild(el("span", { cls: "muted small", text: " · includes " }));
      r.includes.forEach(i => meta.appendChild(el("span", { cls: "chip", text: i })));
    }
    if (r.apply && r.apply.length) {
      meta.appendChild(el("span", { cls: "muted small", text: " · apply " }));
      r.apply.forEach(i => meta.appendChild(el("span", { cls: "chip", text: i })));
    }
    card.appendChild(meta);
    const actions = el("div", { cls: "rc-actions" });
    actions.appendChild(el("button", { cls: "ghost small", text: "Edit", onClick: () => openRuleEditor(r) }));
    actions.appendChild(el("button", { cls: "ghost small", text: "Clone", onClick: () => openRuleEditor({ ...r, id: r.id + "_COPY", version: 1 }) }));
    card.appendChild(actions);
    list.appendChild(card);
  });
}

// ====================== Rule editor ======================
function openRuleEditor(existing) {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-rule-editor").content.cloneNode(true));

  const draft = existing ? JSON.parse(JSON.stringify(existing)) : blankRule();
  document.getElementById("ruleEditorTitle").textContent = existing ? `Edit ${draft.id}` : "New rule";

  const form = document.getElementById("ruleForm");
  RULE_CATEGORIES.forEach(c => document.getElementById("ruleCategory").appendChild(new Option(c, c)));
  ENRICHMENT_TARGETS.forEach(t => document.getElementById("ruleTarget").appendChild(new Option(t, t)));
  EVALUATION_MODES.forEach(m => form.evaluationMode.appendChild(new Option(m, m)));
  RULE_STATUSES.forEach(s => form.status.appendChild(new Option(s, s)));

  form.id.value = draft.id || "";
  form.version.value = draft.version || 1;
  form.name.value = draft.name || "";
  form.category.value = draft.category || "ECONOMIC";
  form.target.value = draft.target || "INTEREST_LEG";
  form.evaluationMode.value = draft.evaluationMode || "";
  form.priority.value = draft.priority ?? 100;
  form.specificityBoost.value = draft.specificityBoost ?? "";
  form.status.value = draft.status || "DRAFT";
  form.effectiveFrom.value = draft.effectiveFrom || "";
  form.effectiveTo.value = draft.effectiveTo || "";

  buildChipPicker("fragmentPicker", studio.fragments.map(f => f.id), draft.includes || [], (v) => { draft.includes = v; updatePreview(); });
  buildChipPicker("templatePicker", studio.templates.map(t => t.id), draft.apply || [], (v) => { draft.apply = v; updatePreview(); });
  buildCriteriaRows("criteriaRows", draft.criteria || [], (v) => { draft.criteria = v; updatePreview(); });
  buildActionRows("actionRows", draft.actions || [], (v) => { draft.actions = v; updatePreview(); });

  document.getElementById("addCriterionBtn").addEventListener("click", () => {
    draft.criteria = [...(draft.criteria || []), { field: "", operator: "EQ", value: "" }];
    buildCriteriaRows("criteriaRows", draft.criteria, (v) => { draft.criteria = v; updatePreview(); });
    updatePreview();
  });
  document.getElementById("addActionBtn").addEventListener("click", () => {
    draft.actions = [...(draft.actions || []), { type: "SET_FIELD", targetPath: "", value: "", overridePolicy: "NEVER" }];
    buildActionRows("actionRows", draft.actions, (v) => { draft.actions = v; updatePreview(); });
    updatePreview();
  });

  form.addEventListener("input", () => {
    Object.assign(draft, readForm(form));
    updatePreview();
  });

  const saveBtn = document.getElementById("saveRuleBtn");
  const dupHost = document.getElementById("ruleDuplicationStrip");
  const inspect = makeInspector("/rules/inspect", () => cleanRule(draft), dupHost, saveBtn);

  function updatePreview() {
    Object.assign(draft, readForm(form));
    const cleaned = cleanRule(draft);
    document.getElementById("rulePreview").textContent = JSON.stringify(cleaned, null, 2);
    document.getElementById("ruleNarrative").innerHTML = "";
    document.getElementById("ruleNarrative").appendChild(narrate(cleaned));
    inspect();
  }

  document.getElementById("cancelRuleBtn").addEventListener("click", () => showRulesList());
  saveBtn.addEventListener("click", async () => {
    try {
      const cleaned = cleanRule(draft);
      await postOrShowConflict("/rules", cleaned, dupHost, saveBtn);
      toast("Rule saved");
      await loadRules();
      showRulesList();
    } catch (e) {
      if (!/^409:/.test(e.message)) toast(e.message, true);
    }
  });
  document.getElementById("simulateRuleBtn").addEventListener("click", async () => {
    const out = document.getElementById("simulationOutput");
    out.textContent = "Simulating…";
    try {
      const trades = Object.values(TRADE_PRESETS);
      const results = await api("/rules/simulate", {
        method: "POST",
        body: JSON.stringify({ draft: cleanRule(draft), trades })
      });
      out.innerHTML = "";
      if (!results.length) {
        out.appendChild(el("div", { cls: "muted small", text: "No diffs across sample trades." }));
        return;
      }
      results.forEach(r => {
        const card = el("div", { cls: "sim-card" });
        const head = el("div", { cls: "small" });
        head.appendChild(el("strong", { text: "trade " + r.tradeId }));
        head.appendChild(el("span", { cls: "muted", text: " · draft applied " + r.draftApplications + " time(s)" }));
        card.appendChild(head);
        if (r.diffs && Object.keys(r.diffs).length) {
          Object.entries(r.diffs).forEach(([path, change]) => {
            const row = el("div", { cls: "kv small" });
            row.appendChild(el("span", { cls: "path", text: path }));
            row.appendChild(el("span", { text: ":  " }));
            row.appendChild(el("span", { cls: "before", text: change.before ?? "∅" }));
            row.appendChild(el("span", { cls: "arrow", text: " → " }));
            row.appendChild(el("span", { cls: "after", text: change.after ?? "∅" }));
            card.appendChild(row);
          });
        } else {
          card.appendChild(el("div", { cls: "muted small", text: "no diff vs current snapshot" }));
        }
        out.appendChild(card);
      });
    } catch (e) { out.textContent = "simulation failed: " + e.message; }
  });

  // prefill from session draft (near-miss handoff)
  const urlDraft = new URLSearchParams(location.search).get("draft");
  if (existing == null && urlDraft === "session") {
    const stored = sessionStorage.getItem("studio.draftRule");
    if (stored) {
      const sd = JSON.parse(stored);
      Object.assign(draft, sd);
      Object.entries(sd).forEach(([k, v]) => {
        if (form[k] != null && typeof v !== "object") form[k].value = v ?? "";
      });
      const meta = JSON.parse(sessionStorage.getItem("studio.draftSource") || "{}");
      document.getElementById("ruleEditorSubtitle").textContent =
        meta.from ? `Drafted from ${meta.from}` : "";
      buildChipPicker("fragmentPicker", studio.fragments.map(f => f.id), draft.includes || [], (v) => { draft.includes = v; updatePreview(); });
      buildChipPicker("templatePicker", studio.templates.map(t => t.id), draft.apply || [], (v) => { draft.apply = v; updatePreview(); });
      buildCriteriaRows("criteriaRows", draft.criteria || [], (v) => { draft.criteria = v; updatePreview(); });
      buildActionRows("actionRows", draft.actions || [], (v) => { draft.actions = v; updatePreview(); });
      sessionStorage.removeItem("studio.draftRule");
      sessionStorage.removeItem("studio.draftSource");
    }
  }

  updatePreview();
}

function blankRule() {
  return {
    id: "",
    version: 1,
    name: "",
    category: "ECONOMIC",
    target: "INTEREST_LEG",
    priority: 100,
    enabled: true,
    effectiveFrom: new Date().toISOString().slice(0, 10),
    effectiveTo: null,
    evaluationMode: null,
    specificityBoost: null,
    status: "DRAFT",
    criteria: [],
    includes: [],
    apply: [],
    actions: [],
    overrides: {},
    metadata: {}
  };
}

function readForm(form) {
  const data = {};
  ["id", "name", "category", "target", "evaluationMode", "status", "effectiveFrom", "effectiveTo"].forEach(k => {
    data[k] = form[k]?.value || null;
  });
  data.version = parseInt(form.version.value, 10) || 1;
  data.priority = form.priority.value === "" ? null : parseInt(form.priority.value, 10);
  data.specificityBoost = form.specificityBoost.value === "" ? null : parseFloat(form.specificityBoost.value);
  data.enabled = true;
  return data;
}

function cleanRule(d) {
  return {
    id: d.id,
    version: d.version || 1,
    name: d.name || null,
    category: d.category,
    target: d.target,
    priority: d.priority,
    enabled: d.enabled !== false,
    effectiveFrom: d.effectiveFrom || null,
    effectiveTo: d.effectiveTo || null,
    evaluationMode: d.evaluationMode || null,
    specificityBoost: d.specificityBoost ?? null,
    status: d.status || "DRAFT",
    criteria: (d.criteria || []).filter(c => c.field && c.operator),
    includes: d.includes || [],
    apply: d.apply || [],
    actions: (d.actions || []).filter(a => a.targetPath),
    overrides: d.overrides || {},
    metadata: d.metadata || {}
  };
}

function narrate(rule) {
  const root = el("div");
  const intro = el("p", { cls: "small" });
  intro.appendChild(el("strong", { text: rule.id || "(unnamed)" }));
  intro.appendChild(document.createTextNode(` is a ${rule.category} rule targeting ${rule.target}, evaluated `));
  intro.appendChild(el("strong", { text: rule.evaluationMode || `(default ${defaultModeFor(rule.category)})` }));
  intro.appendChild(document.createTextNode(`. Priority ${rule.priority ?? 100}.`));
  root.appendChild(intro);

  const totalCrits = (rule.criteria?.length || 0) + (rule.includes?.length || 0);
  const totalActions = (rule.actions?.length || 0) + (rule.apply?.length || 0);

  const cnd = el("p", { cls: "small" });
  cnd.appendChild(document.createTextNode("It matches a trade when "));
  if (totalCrits === 0) {
    cnd.appendChild(el("em", { text: "(no criteria — matches everything)" }));
  } else {
    const parts = [];
    if (rule.includes?.length) parts.push(`all criteria in [${rule.includes.join(", ")}] hold`);
    if (rule.criteria?.length) parts.push(rule.criteria.map(c => `${c.field} ${c.operator} ${c.value}`).join(" AND "));
    cnd.appendChild(document.createTextNode(parts.join(" AND ")));
  }
  cnd.appendChild(document.createTextNode("."));
  root.appendChild(cnd);

  const act = el("p", { cls: "small" });
  act.appendChild(document.createTextNode("Then it "));
  if (totalActions === 0) {
    act.appendChild(el("em", { text: "(no actions — nothing happens)" }));
  } else {
    const parts = [];
    if (rule.apply?.length) parts.push(`runs templates [${rule.apply.join(", ")}]`);
    if (rule.actions?.length) parts.push(rule.actions.map(a => `sets ${a.targetPath} = ${JSON.stringify(a.value)} (${a.overridePolicy || "NEVER"})`).join(", "));
    act.appendChild(document.createTextNode(parts.join("; ")));
  }
  act.appendChild(document.createTextNode("."));
  root.appendChild(act);
  return root;
}

function defaultModeFor(cat) {
  return cat === "ECONOMIC" ? "LAYERED" : cat === "VALIDATION" ? "ALL_MATCH" : "FIRST_MATCH";
}

// ====================== Chip pickers / row builders ======================
function buildChipPicker(containerId, available, selected, onChange) {
  const c = document.getElementById(containerId);
  c.innerHTML = "";
  if (available.length === 0) {
    c.appendChild(el("span", { cls: "muted small", text: "(none defined yet)" }));
    return;
  }
  available.forEach(id => {
    const chip = el("button", {
      cls: "chip-picker-item" + (selected.includes(id) ? " active" : ""),
      text: id
    });
    chip.addEventListener("click", (e) => {
      e.preventDefault();
      if (chip.classList.contains("active")) {
        chip.classList.remove("active");
        onChange(selected.filter(s => s !== id));
        selected = selected.filter(s => s !== id);
      } else {
        chip.classList.add("active");
        selected = [...selected, id];
        onChange(selected);
      }
    });
    c.appendChild(chip);
  });
}

// Build a row of [field-dropdown] [operator-dropdown] [value-input] [remove]. The schema drives
// available paths, operator subset, and the input renderer. {schema} can be either META.trade
// (criteria) or META.swap (actions).
function buildCriteriaRows(containerId, criteria, onChange, schema = META.trade) {
  const c = document.getElementById(containerId);
  c.innerHTML = "";
  if (criteria.length === 0) {
    c.appendChild(el("div", { cls: "muted small", text: "No inline criteria. Click + Add criterion." }));
    return;
  }
  criteria.forEach((cr, i) => {
    const row = el("div", { cls: "rl-row" });
    const field = fieldByPath(schema, cr.field);

    const fld = fieldPathSelect(schema, cr.field);
    fld.addEventListener("change", () => {
      criteria[i].field = fld.value;
      const f = fieldByPath(schema, fld.value);
      // reset op + value when field changes so the row is consistent
      criteria[i].operator = (f?.operators || OPERATORS)[0] || "EQ";
      criteria[i].value = "";
      buildCriteriaRows(containerId, criteria, onChange, schema);
      onChange(criteria);
    });

    const op = operatorSelect(field, cr.operator || "EQ");
    op.addEventListener("change", () => { criteria[i].operator = op.value; onChange(criteria); });

    const val = valueInputFor(field, cr.value, (v) => { criteria[i].value = v; onChange(criteria); });

    const rm = el("button", { cls: "danger small", text: "×", onClick: (e) => {
      e.preventDefault();
      criteria.splice(i, 1);
      buildCriteriaRows(containerId, criteria, onChange, schema);
      onChange(criteria);
    }});
    row.append(fld, op, val, rm);
    if (field?.description) row.appendChild(el("span", { cls: "muted tiny", text: field.description }));
    c.appendChild(row);
  });
}

function buildActionRows(containerId, actions, onChange, schema = META.swap) {
  const c = document.getElementById(containerId);
  c.innerHTML = "";
  if (actions.length === 0) {
    c.appendChild(el("div", { cls: "muted small", text: "No inline actions. Click + Add action." }));
    return;
  }
  actions.forEach((a, i) => {
    const row = el("div", { cls: "rl-row" });
    const field = fieldByPath(schema, a.targetPath);

    const path = fieldPathSelect(schema, a.targetPath, { writableOnly: true });
    path.addEventListener("change", () => {
      actions[i].targetPath = path.value;
      actions[i].value = "";
      buildActionRows(containerId, actions, onChange, schema);
      onChange(actions);
    });

    const val = valueInputFor(field, a.value, (v) => { actions[i].value = v; onChange(actions); });

    const policy = dropdown("policy", OVERRIDE_POLICIES, a.overridePolicy || "NEVER");
    policy.addEventListener("change", () => { actions[i].overridePolicy = policy.value; onChange(actions); });

    const rm = el("button", { cls: "danger small", text: "×", onClick: (e) => {
      e.preventDefault();
      actions.splice(i, 1);
      buildActionRows(containerId, actions, onChange, schema);
      onChange(actions);
    }});
    row.append(path, val, policy, rm);
    if (field?.description) row.appendChild(el("span", { cls: "muted tiny", text: field.description }));
    c.appendChild(row);
  });
}

// ====================== Templates ======================
function showTemplatesList() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-templates-view").content.cloneNode(true));
  document.getElementById("newTemplateBtn").addEventListener("click", () => openTemplateEditor(null));
  const list = document.getElementById("templatesList");
  list.innerHTML = "";
  if (studio.templates.length === 0) {
    list.appendChild(el("div", { cls: "muted pad", text: "No templates yet." }));
    return;
  }
  studio.templates.forEach(t => {
    const card = el("div", { cls: "rule-card" });
    const head = el("div", { cls: "rc-head" });
    head.appendChild(el("strong", { text: t.id }));
    head.appendChild(el("span", { cls: "muted", text: " v" + t.version }));
    head.appendChild(el("span", { cls: "chip", text: t.target }));
    head.appendChild(el("span", { cls: "chip status-" + t.status.toLowerCase(), text: t.status }));
    card.appendChild(head);
    (t.actions || []).forEach(a => {
      const v = typeof a.value === "object" ? JSON.stringify(a.value) : a.value;
      card.appendChild(el("div", { cls: "small", html: `<span class="path">${a.targetPath}</span> ← <span class="after">${v}</span> <span class="muted">(${a.overridePolicy})</span>` }));
    });
    const actions = el("div", { cls: "rc-actions" });
    actions.appendChild(el("button", { cls: "ghost small", text: "Edit", onClick: () => openTemplateEditor(t) }));
    card.appendChild(actions);
    list.appendChild(card);
  });
}

function openTemplateEditor(existing) {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-template-editor").content.cloneNode(true));
  const draft = existing ? JSON.parse(JSON.stringify(existing)) : { id: "", version: 1, target: "INTEREST_LEG", status: "DRAFT", actions: [], metadata: {} };
  document.getElementById("tplTitle").textContent = existing ? `Edit ${draft.id}` : "New template";

  const form = document.getElementById("tplForm");
  ENRICHMENT_TARGETS.forEach(t => document.getElementById("tplTarget").appendChild(new Option(t, t)));
  RULE_STATUSES.forEach(s => document.getElementById("tplStatus").appendChild(new Option(s, s)));
  form.id.value = draft.id;
  form.version.value = draft.version;
  form.target.value = draft.target;
  form.status.value = draft.status;

  const saveBtn = document.getElementById("tplSaveBtn");
  const dupHost = document.getElementById("tplDuplicationStrip");
  const inspect = makeInspector("/templates/inspect", () => draft, dupHost, saveBtn);
  const update = () => {
    draft.id = form.id.value;
    draft.version = parseInt(form.version.value, 10) || 1;
    draft.target = form.target.value;
    draft.status = form.status.value;
    document.getElementById("tplPreview").textContent = JSON.stringify(draft, null, 2);
    inspect();
  };
  form.addEventListener("input", update);
  buildActionRows("tplActionRows", draft.actions, (v) => { draft.actions = v; update(); });
  document.getElementById("tplAddActionBtn").addEventListener("click", () => {
    draft.actions.push({ type: "SET_FIELD", targetPath: "", value: "", overridePolicy: "NEVER" });
    buildActionRows("tplActionRows", draft.actions, (v) => { draft.actions = v; update(); });
    update();
  });
  document.getElementById("tplCancelBtn").addEventListener("click", () => showTemplatesList());
  saveBtn.addEventListener("click", async () => {
    try {
      await postOrShowConflict("/templates", draft, dupHost, saveBtn);
      toast("Template saved");
      await loadTemplates();
      showTemplatesList();
    } catch (e) {
      if (!/^409:/.test(e.message)) toast(e.message, true);
    }
  });
  update();
}

// ====================== Fragments ======================
function showFragmentsList() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-fragments-view").content.cloneNode(true));
  document.getElementById("newFragmentBtn").addEventListener("click", () => openFragmentEditor(null));
  const list = document.getElementById("fragmentsList");
  list.innerHTML = "";
  if (studio.fragments.length === 0) {
    list.appendChild(el("div", { cls: "muted pad", text: "No fragments yet." }));
    return;
  }
  studio.fragments.forEach(f => {
    const card = el("div", { cls: "rule-card" });
    const head = el("div", { cls: "rc-head" });
    head.appendChild(el("strong", { text: f.id }));
    head.appendChild(el("span", { cls: "muted", text: " v" + f.version }));
    head.appendChild(el("span", { cls: "chip status-" + f.status.toLowerCase(), text: f.status }));
    card.appendChild(head);
    (f.criteria || []).forEach(c => {
      card.appendChild(el("div", { cls: "small", text: `${c.field} ${c.operator} ${c.value}` }));
    });
    const actions = el("div", { cls: "rc-actions" });
    actions.appendChild(el("button", { cls: "ghost small", text: "Edit", onClick: () => openFragmentEditor(f) }));
    card.appendChild(actions);
    list.appendChild(card);
  });
}

function openFragmentEditor(existing) {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-fragment-editor").content.cloneNode(true));
  const draft = existing ? JSON.parse(JSON.stringify(existing)) : { id: "", version: 1, status: "DRAFT", criteria: [], metadata: {} };
  document.getElementById("fragTitle").textContent = existing ? `Edit ${draft.id}` : "New fragment";
  const form = document.getElementById("fragForm");
  RULE_STATUSES.forEach(s => document.getElementById("fragStatus").appendChild(new Option(s, s)));
  form.id.value = draft.id;
  form.version.value = draft.version;
  form.status.value = draft.status;

  const saveBtn = document.getElementById("fragSaveBtn");
  const dupHost = document.getElementById("fragDuplicationStrip");
  const inspect = makeInspector("/fragments/inspect", () => draft, dupHost, saveBtn);
  const update = () => {
    draft.id = form.id.value;
    draft.version = parseInt(form.version.value, 10) || 1;
    draft.status = form.status.value;
    document.getElementById("fragPreview").textContent = JSON.stringify(draft, null, 2);
    inspect();
  };
  form.addEventListener("input", update);
  buildCriteriaRows("fragCriteriaRows", draft.criteria, (v) => { draft.criteria = v; update(); });
  document.getElementById("fragAddBtn").addEventListener("click", () => {
    draft.criteria.push({ field: "", operator: "EQ", value: "" });
    buildCriteriaRows("fragCriteriaRows", draft.criteria, (v) => { draft.criteria = v; update(); });
    update();
  });
  document.getElementById("fragCancelBtn").addEventListener("click", () => showFragmentsList());
  saveBtn.addEventListener("click", async () => {
    try {
      await postOrShowConflict("/fragments", draft, dupHost, saveBtn);
      toast("Fragment saved");
      await loadFragments();
      showFragmentsList();
    } catch (e) {
      if (!/^409:/.test(e.message)) toast(e.message, true);
    }
  });
  update();
}

// ====================== Simulate ======================
function showSimulate() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-simulate-view").content.cloneNode(true));
  const sel = document.getElementById("simDraftSelect");
  const drafts = studio.rules.filter(r => r.status === "DRAFT");
  if (drafts.length === 0) {
    sel.appendChild(new Option("(no draft rules — promote a near-miss or create one)", ""));
  } else {
    drafts.forEach(r => sel.appendChild(new Option(`${r.id} v${r.version} — ${r.name || r.target}`, JSON.stringify(r))));
  }
  const presetRow = document.getElementById("simPresetRow");
  Object.entries(TRADE_PRESETS).forEach(([k, t]) => {
    presetRow.appendChild(el("button", { cls: "preset", text: k, onClick: () => {
      const cur = safeParseTrades();
      cur.push(t);
      document.getElementById("simTradesInput").value = JSON.stringify(cur, null, 2);
    }}));
  });
  document.getElementById("simTradesInput").value = JSON.stringify(Object.values(TRADE_PRESETS), null, 2);
  document.getElementById("simRunBtn").addEventListener("click", async () => {
    const draftJson = sel.value;
    if (!draftJson) return toast("Pick a draft rule", true);
    const out = document.getElementById("simResults");
    out.textContent = "Simulating…";
    try {
      const results = await api("/rules/simulate", {
        method: "POST",
        body: JSON.stringify({ draft: JSON.parse(draftJson), trades: safeParseTrades() })
      });
      out.innerHTML = "";
      if (!results.length) { out.appendChild(el("div", { cls: "muted small", text: "No diffs." })); return; }
      results.forEach(r => {
        const card = el("div", { cls: "sim-card" });
        const head = el("div", { cls: "small" });
        head.appendChild(el("strong", { text: "trade " + r.tradeId }));
        head.appendChild(el("span", { cls: "muted", text: " · draft applied " + r.draftApplications + " time(s)" }));
        card.appendChild(head);
        if (r.diffs && Object.keys(r.diffs).length) {
          Object.entries(r.diffs).forEach(([path, change]) => {
            const row = el("div", { cls: "kv small" });
            row.appendChild(el("span", { cls: "path", text: path }));
            row.appendChild(el("span", { text: ":  " }));
            row.appendChild(el("span", { cls: "before", text: change.before ?? "∅" }));
            row.appendChild(el("span", { cls: "arrow", text: " → " }));
            row.appendChild(el("span", { cls: "after", text: change.after ?? "∅" }));
            card.appendChild(row);
          });
        } else {
          card.appendChild(el("div", { cls: "muted small", text: "no diff vs current snapshot" }));
        }
        out.appendChild(card);
      });
    } catch (e) { out.textContent = "simulation failed: " + e.message; }
  });
}
function safeParseTrades() {
  try { return JSON.parse(document.getElementById("simTradesInput").value); } catch { return []; }
}

// ====================== Enumerations view ======================
function showEnumerationsView() {
  main.innerHTML = "";
  main.appendChild(document.getElementById("tpl-enumerations-view").content.cloneNode(true));
  document.getElementById("enumRefreshBtn").addEventListener("click", async () => {
    try {
      await refreshEnumsRemote();
      refreshEnumBadge();
      toast("Snapshot refreshed");
      showEnumerationsView();
    } catch (e) { toast(e.message, true); }
  });
  document.getElementById("newEnumBtn").addEventListener("click", () => createEnumerationFlow());
  renderEnumList(null);
}

function renderEnumList(selectedCode) {
  const list = document.getElementById("enumList");
  if (!list) return;
  list.innerHTML = "";
  const enums = META.enums || [];
  if (enums.length === 0) {
    list.appendChild(el("div", { cls: "muted pad", text: "No enumerations." }));
    return;
  }
  enums.sort((a, b) => a.code.localeCompare(b.code));
  enums.forEach(e => {
    const item = el("div", {
      cls: "enum-list-item" + (e.code === selectedCode ? " active" : ""),
      onClick: () => renderEnumDetail(e.code)
    });
    item.appendChild(el("div", { cls: "enum-code", text: e.code }));
    item.appendChild(el("div", { cls: "muted tiny", text: e.displayName }));
    item.appendChild(el("div", { cls: "muted tiny", text: `${(e.values || []).length} values · v${e.version}` }));
    list.appendChild(item);
  });
}

function renderEnumDetail(code) {
  renderEnumList(code);
  const host = document.getElementById("enumDetail");
  host.innerHTML = "";
  host.appendChild(document.getElementById("tpl-enumeration-editor").content.cloneNode(true));
  const e = getEnum(code);
  if (!e) {
    host.innerHTML = "<div class='muted pad'>Enumeration not found.</div>";
    return;
  }
  document.getElementById("enumTitle").textContent = `${e.code} · ${e.displayName}`;
  document.getElementById("enumMetaProvider").textContent = `provider: ${e.providerType}`;
  document.getElementById("enumMetaVersion").textContent = `version: ${e.version}  ·  updated ${new Date(e.updatedAt).toLocaleString()}`;

  const f = document.getElementById("enumDefForm");
  f.displayName.value = e.displayName || "";
  f.description.value = e.description || "";
  f.providerType.value = e.providerType || "DATABASE";
  f.refreshPolicy.value = "MANUAL";
  f.refreshIntervalSeconds.value = "";
  f.sourceConfig.value = "";

  document.getElementById("enumSaveDefBtn").addEventListener("click", async () => {
    try {
      await api("/enumerations", { method: "POST", body: JSON.stringify({
        code: e.code,
        displayName: f.displayName.value,
        description: f.description.value,
        providerType: f.providerType.value || "DATABASE",
        refreshPolicy: f.refreshPolicy.value || "MANUAL",
        refreshIntervalSeconds: f.refreshIntervalSeconds.value ? parseInt(f.refreshIntervalSeconds.value, 10) : null,
        sourceConfig: f.sourceConfig.value || null
      })});
      await refreshEnumsRemote();
      refreshEnumBadge();
      toast("Definition saved");
      renderEnumDetail(code);
    } catch (e2) { toast(e2.message, true); }
  });

  document.getElementById("enumDeleteBtn").addEventListener("click", async () => {
    if (!confirm(`Delete enumeration ${e.code}? All its values will be removed.`)) return;
    try {
      await api(`/enumerations/${encodeURIComponent(e.code)}`, { method: "DELETE" });
      await loadEnums(true);
      refreshEnumBadge();
      showEnumerationsView();
      toast("Deleted");
    } catch (e2) { toast(e2.message, true); }
  });

  document.getElementById("enumAddValueBtn").addEventListener("click", () => {
    const code = prompt("Value code (e.g. USD)");
    if (!code) return;
    const label = prompt("Display label", code) || code;
    api(`/enumerations/${encodeURIComponent(e.code)}/values`, {
      method: "POST",
      body: JSON.stringify({ valueCode: code, displayLabel: label, sortOrder: (e.values || []).length, active: true })
    }).then(async () => {
      await loadEnums(true);
      refreshEnumBadge();
      renderEnumDetail(e.code);
    }).catch(err => toast(err.message, true));
  });

  const body = document.getElementById("enumValuesBody");
  body.innerHTML = "";
  (e.values || []).forEach(v => {
    const tr = el("tr");
    const code = el("input", { attrs: { type: "text", value: v.code, readonly: "readonly" }, cls: "enum-code-cell" });
    const label = el("input", { attrs: { type: "text", value: v.label || "" } });
    const sort = el("input", { attrs: { type: "number", value: v.sortOrder ?? 0, style: "width:64px" } });
    const active = el("input", { attrs: { type: "checkbox" } });
    if (v.active !== false) active.setAttribute("checked", "checked");
    const save = el("button", { cls: "ghost small", text: "Save", onClick: async () => {
      try {
        await api(`/enumerations/${encodeURIComponent(e.code)}/values/${encodeURIComponent(v.code)}`, {
          method: "PUT",
          body: JSON.stringify({
            valueCode: v.code,
            displayLabel: label.value,
            sortOrder: parseInt(sort.value, 10) || 0,
            active: active.checked
          })
        });
        await loadEnums(true);
        refreshEnumBadge();
        renderEnumDetail(e.code);
        toast("Value updated");
      } catch (e2) { toast(e2.message, true); }
    }});
    const del = el("button", { cls: "danger small", text: "×", onClick: async () => {
      if (!confirm(`Remove value ${v.code}?`)) return;
      try {
        await api(`/enumerations/${encodeURIComponent(e.code)}/values/${encodeURIComponent(v.code)}`, { method: "DELETE" });
        await loadEnums(true);
        refreshEnumBadge();
        renderEnumDetail(e.code);
      } catch (e2) { toast(e2.message, true); }
    }});
    [code, label, sort, active].forEach(c => {
      const td = el("td");
      td.appendChild(c);
      tr.appendChild(td);
    });
    const tdA = el("td");
    tdA.append(save, del);
    tr.appendChild(tdA);
    body.appendChild(tr);
  });
}

async function createEnumerationFlow() {
  const code = prompt("Enumeration code (e.g. BROKER)");
  if (!code) return;
  const display = prompt("Display name", code) || code;
  try {
    await api("/enumerations", { method: "POST", body: JSON.stringify({
      code, displayName: display, providerType: "DATABASE", refreshPolicy: "MANUAL"
    })});
    await loadEnums(true);
    refreshEnumBadge();
    showEnumerationsView();
    renderEnumDetail(code);
    toast("Enumeration created");
  } catch (e) { toast(e.message, true); }
}

// ====================== Init ======================
refreshSnapshotBadge();
setInterval(refreshSnapshotBadge, 15000);

// Decide initial view (rule from session takes priority)
const initialView = new URLSearchParams(location.search).get("draft") === "session" ? "rules" : "rules";
loadView(initialView).then(() => {
  if (new URLSearchParams(location.search).get("draft") === "session") {
    openRuleEditor(null);
  } else if (new URLSearchParams(location.search).get("new") === "rule") {
    openRuleEditor({ ...blankRule(), target: new URLSearchParams(location.search).get("target") || "INTEREST_LEG" });
  }
});
