async function api(path, options) {
  const res = await fetch(path, {
    headers: { Accept: "application/json", "Content-Type": "application/json" },
    ...options,
  });
  const text = await res.text();
  let body;
  try { body = text ? JSON.parse(text) : null; } catch { body = text; }
  if (!res.ok) throw new Error(typeof body === "object" ? JSON.stringify(body) : text);
  return body;
}

async function refreshHealth() {
  const el = document.getElementById("health");
  try {
    const h = await api("/actuator/health");
    el.textContent = h.status === "UP" ? "healthy" : h.status;
    el.classList.toggle("up", h.status === "UP");
  } catch (e) {
    el.textContent = "unreachable";
  }
}

document.getElementById("searchBtn").onclick = async () => {
  const allocationId = document.getElementById("allocationId").value.trim();
  const out = document.getElementById("searchOut");
  try {
    const rows = await api(`/api/v1/trades?allocationId=${encodeURIComponent(allocationId)}`);
    out.textContent = JSON.stringify(rows, null, 2);
    if (rows[0]?.ingestionId) {
      document.getElementById("ingestionId").value = rows[0].ingestionId;
    }
  } catch (e) {
    out.textContent = e.message;
  }
};

document.getElementById("journeyBtn").onclick = async () => {
  const id = document.getElementById("ingestionId").value.trim();
  const out = document.getElementById("journeyOut");
  if (!id) { out.textContent = "Enter an ingestion ID"; return; }
  try {
    const j = await api(`/api/v1/trades/${id}/journey`);
    out.textContent = JSON.stringify(j, null, 2);
  } catch (e) {
    out.textContent = e.message;
  }
};

document.getElementById("reconBtn").onclick = async () => {
  const out = document.getElementById("reconOut");
  const body = {
    type: document.getElementById("reconType").value,
    book: document.getElementById("reconBook").value.trim(),
    tradeDate: document.getElementById("reconDate").value,
    asOf: new Date().toISOString(),
  };
  try {
    const run = await api("/api/v1/recon/runs", { method: "POST", body: JSON.stringify(body) });
    const breaks = await api(`/api/v1/recon/runs/${run.runId}/breaks`);
    out.textContent = JSON.stringify({ run, breaks }, null, 2);
  } catch (e) {
    out.textContent = e.message;
  }
};

refreshHealth();
document.getElementById("searchBtn").click();
