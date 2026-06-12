package com.pb.tcs.recon;

import java.util.List;
import java.util.Optional;

/** Persistence port over {@code recon_run} / {@code recon_break} (FR-708). */
public interface ReconStore {

    ReconRun saveRun(ReconRun run);

    Optional<ReconRun> findRunByIdempotencyKey(String idempotencyKey);

    Optional<ReconRun> findRunById(long runId);

    ReconBreak saveBreak(ReconBreak breakRow);

    List<ReconBreak> findBreaksByRunId(long runId);

    Optional<ReconBreak> findBreakById(long breakId);

    List<ReconBreak> findOpenBreaks(ReconType type, String allocationId, String swapRef);

    List<ReconBreak> findOpenBreaks();

    void updateBreak(ReconBreak breakRow);
}
