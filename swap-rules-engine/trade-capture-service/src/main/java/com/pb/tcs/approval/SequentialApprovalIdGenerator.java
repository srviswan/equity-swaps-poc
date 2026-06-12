package com.pb.tcs.approval;

import java.util.concurrent.atomic.AtomicLong;

/** Test-friendly sequential approval id generator. */
public final class SequentialApprovalIdGenerator implements ApprovalIdGenerator {

    private final AtomicLong seq = new AtomicLong();

    @Override
    public String next() {
        return "APR-" + seq.incrementAndGet();
    }
}
