package com.pb.tcs.parity;

import com.pb.tcs.rules.SwapBlotter;
import java.util.Optional;

/** Legacy SwapBlotter source for parity runs (different database in production). */
public interface LegacyBlotterStore {

    Optional<SwapBlotter> findByAllocationId(String allocationId);
}
