package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.copy.CopyStrategy;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Processes one chunk across all in-scope tables in FK order (children → parents for delete),
 * driving the per-table copy → verify → delete state machine and checkpointing each step to
 * {@code archive_chunk_log} for idempotent restart.
 *
 * <ul>
 *   <li>SAME_DB / CROSS_DB: copy + delete in one local transaction (atomic; restart re-runs).
 *   <li>CROSS_SERVER: copy → verify (count + optional checksum) → delete, each checkpointed.
 * </ul>
 */
@Component
public class ChunkProcessor {

    private final Map<String, CopyStrategy> strategiesByTopology;

    public ChunkProcessor(List<CopyStrategy> strategies) {
        this.strategiesByTopology =
                strategies.stream().collect(Collectors.toMap(CopyStrategy::topology, Function.identity()));
    }

    /** Process a chunk; returns rows deleted from source. */
    public long process(WorklistProvider.Chunk chunk) {
        // TODO(phase 2/6): for each table by dependency_level, resolve strategy by topology,
        // copy -> verify -> delete with checkpoints, honouring verification before any delete.
        throw new UnsupportedOperationException("scaffold: chunk processing not yet implemented");
    }

    CopyStrategy strategyFor(String topology) {
        CopyStrategy s = strategiesByTopology.get(topology);
        if (s == null) {
            throw new IllegalArgumentException("No copy strategy for topology: " + topology);
        }
        return s;
    }
}
