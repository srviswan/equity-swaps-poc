package com.pb.tcs.dispatch;

/** {@code dispatch_record.status} state machine (F0 §F0.3 / FR-400). */
public enum DispatchStatus {
    PENDING,
    CLAIMED,
    SENT,
    FAILED
}
