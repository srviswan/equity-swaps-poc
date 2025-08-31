package com.lifecycle.cashflow.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/**
 * Base implementation of the Actor pattern using Project Reactor.
 * 
 * This provides a foundation for building actors with:
 * - Message processing with backpressure
 * - State management
 * - Error handling and supervision
 * - Lifecycle management
 * 
 * @param <T> Type of messages this actor can process
 * @param <S> Type of state this actor maintains
 */
public abstract class BaseActor<T, S> implements Actor<T, S> {
    
    private static final Logger logger = LoggerFactory.getLogger(BaseActor.class);
    
    protected final String name;
    protected final Scheduler scheduler;
    protected final AtomicBoolean running;
    protected final AtomicReference<S> state;
    
    // Message sink with backpressure handling
    private final Sinks.Many<T> messageSink;
    
    // Response sink for ask pattern
    private final Sinks.Many<Object> responseSink;
    
    protected BaseActor(String name) {
        this.name = name;
        this.scheduler = Schedulers.boundedElastic();
        this.running = new AtomicBoolean(true);
        this.state = new AtomicReference<>();
        this.messageSink = Sinks.many().multicast().onBackpressureBuffer();
        this.responseSink = Sinks.many().multicast().onBackpressureBuffer();
        
        // Start message processing
        startMessageProcessing();
    }
    
    /**
     * Start processing messages from the message sink.
     */
    private void startMessageProcessing() {
        messageSink.asFlux()
            .onBackpressureBuffer(1000) // Buffer size for backpressure
            .publishOn(scheduler)
            .doOnNext(this::processMessage)
            .doOnError(error -> logger.error("Error processing message in actor {}", name, error))
            .retry()
            .subscribe();
    }
    
    /**
     * Process a single message.
     * 
     * @param message The message to process
     */
    protected abstract void processMessage(T message);
    
    /**
     * Update the actor's state.
     * 
     * @param newState The new state
     */
    protected void updateState(S newState) {
        state.set(newState);
        logger.debug("Actor {} state updated: {}", name, newState);
    }
    
    /**
     * Send a response for an ask operation.
     * 
     * @param response The response to send
     */
    protected void sendResponse(Object response) {
        responseSink.tryEmitNext(response);
    }
    
    @Override
    public Mono<Void> tell(T message) {
        if (!running.get()) {
            return Mono.error(new IllegalStateException("Actor " + name + " is not running"));
        }
        
        logger.debug("Actor {} received message: {}", name, message);
        messageSink.tryEmitNext(message);
        return Mono.empty();
    }
    
    @Override
    public <R> Mono<R> ask(T message, Class<R> responseType) {
        if (!running.get()) {
            return Mono.error(new IllegalStateException("Actor " + name + " is not running"));
        }
        
        logger.debug("Actor {} received ask message: {}", name, message);
        
        // Create a response sink for this specific ask
        Sinks.One<R> responseSink = Sinks.one();
        
        // Process the message and expect a response
        return Mono.fromCallable(() -> {
            // Send message to processing
            messageSink.tryEmitNext(message);
            
            // Return the response sink as Mono
            return responseSink.asMono();
        }).flatMap(mono -> mono)
          .publishOn(scheduler);
    }
    
    @Override
    public Mono<S> getState() {
        return Mono.fromCallable(() -> state.get())
                  .publishOn(scheduler);
    }
    
    @Override
    public Mono<Void> stop() {
        if (running.compareAndSet(true, false)) {
            logger.info("Stopping actor: {}", name);
            
            return Mono.fromRunnable(() -> {
                try {
                    // Cleanup resources
                    cleanup();
                    
                    // Complete sinks
                    messageSink.tryEmitComplete();
                    responseSink.tryEmitComplete();
                    
                    // Dispose scheduler
                    if (scheduler != null && !scheduler.isDisposed()) {
                        scheduler.dispose();
                    }
                    
                    logger.info("Actor {} stopped successfully", name);
                } catch (Exception e) {
                    logger.error("Error stopping actor {}", name, e);
                }
            }).then();
        }
        
        return Mono.empty();
    }
    
    @Override
    public boolean isRunning() {
        return running.get();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Cleanup resources when the actor is stopped.
     * Override this method to provide custom cleanup logic.
     */
    protected void cleanup() {
        // Default implementation does nothing
        // Override in subclasses for custom cleanup
    }
    
    /**
     * Get the scheduler used by this actor.
     * 
     * @return The scheduler
     */
    protected Scheduler getScheduler() {
        return scheduler;
    }
}
