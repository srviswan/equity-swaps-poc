package com.lifecycle.cashflow.actor;

import reactor.core.publisher.Mono;

/**
 * Generic Actor interface for message-driven processing.
 * 
 * Actors process messages asynchronously and maintain internal state.
 * They can send messages to other actors and handle backpressure.
 * 
 * @param <T> Type of messages this actor can process
 * @param <S> Type of state this actor maintains
 */
public interface Actor<T, S> {
    
    /**
     * Send a message to this actor.
     * 
     * @param message The message to process
     * @return Mono that completes when the message is queued
     */
    Mono<Void> tell(T message);
    
    /**
     * Send a message and get a response.
     * 
     * @param message The message to process
     * @param responseType The expected response type
     * @return Mono with the response
     */
    <R> Mono<R> ask(T message, Class<R> responseType);
    
    /**
     * Get the current state of the actor.
     * 
     * @return Mono with the current state
     */
    Mono<S> getState();
    
    /**
     * Stop the actor gracefully.
     * 
     * @return Mono that completes when the actor is stopped
     */
    Mono<Void> stop();
    
    /**
     * Check if the actor is running.
     * 
     * @return true if the actor is running
     */
    boolean isRunning();
    
    /**
     * Get the actor's name/identifier.
     * 
     * @return Actor name
     */
    String getName();
}
