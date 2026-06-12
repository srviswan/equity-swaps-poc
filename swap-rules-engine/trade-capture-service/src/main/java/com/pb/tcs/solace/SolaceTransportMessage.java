package com.pb.tcs.solace;

import com.pb.tcs.ingress.TransportMessage;
import com.solacesystems.jcsmp.BytesMessage;
import com.solacesystems.jcsmp.BytesXMLMessage;
import com.solacesystems.jcsmp.XMLMessage;
import java.nio.ByteBuffer;

/**
 * JCSMP adapter for one delivered message. ACK = client-ack accept; NACK =
 * {@code settle(FAILED)} so the broker redelivers (and DLQs after max-redelivery, F0.2).
 */
final class SolaceTransportMessage implements TransportMessage {

    private final BytesXMLMessage message;

    SolaceTransportMessage(BytesXMLMessage message) {
        this.message = message;
    }

    @Override
    public byte[] payload() {
        if (message instanceof BytesMessage bytes && bytes.getData() != null) {
            return bytes.getData();
        }
        ByteBuffer attachment = message.getAttachmentByteBuffer();
        if (attachment != null && attachment.remaining() > 0) {
            byte[] data = new byte[attachment.remaining()];
            attachment.get(data);
            return data;
        }
        return new byte[0];
    }

    @Override
    public int deliveryAttempt() {
        try {
            return Math.max(1, message.getDeliveryCount());
        } catch (UnsupportedOperationException e) {
            // broker/queue without delivery-count support: coarse fallback
            return message.getRedelivered() ? 2 : 1;
        }
    }

    @Override
    public void ack() {
        message.ackMessage();
    }

    @Override
    public void nack() {
        try {
            message.settle(XMLMessage.Outcome.FAILED);
        } catch (Exception e) {
            throw new IllegalStateException("NACK settle failed", e);
        }
    }
}
