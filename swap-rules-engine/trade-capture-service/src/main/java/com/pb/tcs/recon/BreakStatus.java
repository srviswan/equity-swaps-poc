package com.pb.tcs.recon;

/** FR-704 break lifecycle states. */
public enum BreakStatus {
    DETECTED,
    HEALING,
    ACKNOWLEDGED,
    RESOLVED_AUTO,
    RESOLVED_MANUAL,
    WRITTEN_OFF
}
