package com.pb.tcs.dispatch;

/** Transport port for stage-10 publish (FR-400: network I/O never inside DB transactions). */
public interface DownstreamPublisher {

    void publish(DispatchEnvelope envelope);

    class PublishException extends RuntimeException {
        public PublishException(String message) {
            super(message);
        }

        public PublishException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
