package com.pb.tcs.solace;

import com.pb.tcs.ingress.IngressConsumer;
import com.solacesystems.jcsmp.BytesXMLMessage;
import com.solacesystems.jcsmp.ConsumerFlowProperties;
import com.solacesystems.jcsmp.EndpointProperties;
import com.solacesystems.jcsmp.FlowReceiver;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.Queue;
import com.solacesystems.jcsmp.XMLMessage;
import com.solacesystems.jcsmp.XMLMessageListener;

/**
 * JCSMP binding for the partitioned ingress queue (F0.2): client-ACK mode, explicit settlement
 * outcomes for NACK support, prefetch-bounded window. One instance per partition assignment;
 * the broker serializes per partition key — the listener thread runs the pipeline directly.
 */
public final class SolacePartitionConsumer implements AutoCloseable {

    private final JCSMPSession session;
    private final FlowReceiver flow;

    private SolacePartitionConsumer(JCSMPSession session, FlowReceiver flow) {
        this.session = session;
        this.flow = flow;
    }

    public static SolacePartitionConsumer connect(
            SolaceConnectionConfig config, IngressConsumer ingress) throws JCSMPException {
        JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, config.host());
        properties.setProperty(JCSMPProperties.VPN_NAME, config.vpn());
        properties.setProperty(JCSMPProperties.USERNAME, config.username());
        properties.setProperty(JCSMPProperties.PASSWORD, config.password());
        JCSMPSession session = JCSMPFactory.onlyInstance().createSession(properties);
        session.connect();

        Queue queue = JCSMPFactory.onlyInstance().createQueue(config.queue());
        ConsumerFlowProperties flowProperties = new ConsumerFlowProperties();
        flowProperties.setEndpoint(queue);
        flowProperties.setAckMode(JCSMPProperties.SUPPORTED_MESSAGE_ACK_CLIENT);
        flowProperties.setTransportWindowSize(config.prefetch());
        flowProperties.addRequiredSettlementOutcomes(XMLMessage.Outcome.FAILED);

        FlowReceiver flow =
                session.createFlow(
                        new XMLMessageListener() {
                            @Override
                            public void onReceive(BytesXMLMessage message) {
                                // IngressConsumer contains all exceptions and owns ACK/NACK.
                                ingress.onMessage(new SolaceTransportMessage(message));
                            }

                            @Override
                            public void onException(JCSMPException e) {
                                // flow-level transport error; broker redelivers unacked messages
                            }
                        },
                        flowProperties,
                        new EndpointProperties());
        flow.start();
        return new SolacePartitionConsumer(session, flow);
    }

    @Override
    public void close() {
        flow.stop();
        flow.close();
        session.closeSession();
    }
}
