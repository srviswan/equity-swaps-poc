package com.pb.tcs.approval;

/** Mints APR-* identifiers for Approval Service correlation. */
public interface ApprovalIdGenerator {

    String next();
}
