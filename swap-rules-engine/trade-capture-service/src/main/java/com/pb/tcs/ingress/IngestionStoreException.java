package com.pb.tcs.ingress;

/** Persistence failure — the pipeline maps this to NACK (retry-safe via idempotency, F1.2). */
public class IngestionStoreException extends RuntimeException {

    public IngestionStoreException(String message) {
        super(message);
    }

    public IngestionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
