package com.pb.tcs.crossref;

/** Transport port for stage-12 cross-ref push (FR-403). */
public interface CrossRefPublisher {

    void publish(CrossRefPushMessage message);

    class PublishException extends RuntimeException {
        public PublishException(String message) {
            super(message);
        }

        public PublishException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
