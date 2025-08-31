package com.lifecycle.cashflow.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Actor System that manages multiple actors and provides routing capabilities.
 * 
 * This system provides:
 * - Actor lifecycle management
 * - Message routing between actors
 * - Supervision and error handling
 * - Resource cleanup
 */
public class ActorSystem {
    
    private static final Logger logger = LoggerFactory.getLogger(ActorSystem.class);
    
    private final String name;
    private final ConcurrentMap<String, Actor<?, ?>> actors;
    private final AtomicBoolean running;
    
    public ActorSystem(String name) {
        this.name = name;
        this.actors = new ConcurrentHashMap<>();
        this.running = new AtomicBoolean(true);
        
        logger.info("Actor system '{}' created", name);
    }
    
    /**
     * Create and register a new actor.
     * 
     * @param name Actor name
     * @param actor The actor instance
     * @return The created actor
     */
    public <T, S> Actor<T, S> createActor(String name, Actor<T, S> actor) {
        if (!running.get()) {
            throw new IllegalStateException("Actor system is not running");
        }
        
        if (actors.containsKey(name)) {
            throw new IllegalArgumentException("Actor with name '" + name + "' already exists");
        }
        
        actors.put(name, actor);
        logger.info("Actor '{}' created and registered in system '{}'", name, this.name);
        
        return actor;
    }
    
    /**
     * Get an actor by name.
     * 
     * @param name Actor name
     * @return The actor, or null if not found
     */
    @SuppressWarnings("unchecked")
    public <T, S> Actor<T, S> getActor(String name) {
        return (Actor<T, S>) actors.get(name);
    }
    
    /**
     * Send a message to an actor using the tell pattern.
     * 
     * @param actorName Name of the target actor
     * @param message Message to send
     * @return Mono that completes when the message is sent
     */
    public <T> Mono<Void> tell(String actorName, T message) {
        Actor<T, ?> actor = getActor(actorName);
        if (actor == null) {
            return Mono.error(new IllegalArgumentException("Actor '" + actorName + "' not found"));
        }
        
        return actor.tell(message);
    }
    
    /**
     * Send a message to an actor using the ask pattern.
     * 
     * @param actorName Name of the target actor
     * @param message Message to send
     * @param responseType Expected response type
     * @return Mono with the response
     */
    public <T, R> Mono<R> ask(String actorName, T message, Class<R> responseType) {
        Actor<T, ?> actor = getActor(actorName);
        if (actor == null) {
            return Mono.error(new IllegalArgumentException("Actor '" + actorName + "' not found"));
        }
        
        return actor.ask(message, responseType);
    }
    
    /**
     * Stop a specific actor.
     * 
     * @param actorName Name of the actor to stop
     * @return Mono that completes when the actor is stopped
     */
    public Mono<Void> stopActor(String actorName) {
        Actor<?, ?> actor = actors.remove(actorName);
        if (actor == null) {
            return Mono.error(new IllegalArgumentException("Actor '" + actorName + "' not found"));
        }
        
        logger.info("Stopping actor '{}' in system '{}'", actorName, this.name);
        return actor.stop();
    }
    
    /**
     * Stop all actors and the actor system.
     * 
     * @return Mono that completes when all actors are stopped
     */
    public Mono<Void> shutdown() {
        if (running.compareAndSet(true, false)) {
            logger.info("Shutting down actor system '{}'", name);
            
            // Stop all actors concurrently
            List<Mono<Void>> stopOperations = actors.values().stream()
                    .map(actor -> {
                        try {
                            return actor.stop();
                        } catch (Exception e) {
                            logger.error("Error stopping actor '{}'", actor.getName(), e);
                            return Mono.<Void>empty();
                        }
                    })
                    .toList();
            
            return Mono.when(stopOperations)
                    .doFinally(signalType -> {
                        actors.clear();
                        logger.info("Actor system '{}' shutdown completed", name);
                    })
                    .then();
        }
        
        return Mono.empty();
    }
    
    /**
     * Check if the actor system is running.
     * 
     * @return true if the system is running
     */
    public boolean isRunning() {
        return running.get();
    }
    
    /**
     * Get the name of the actor system.
     * 
     * @return System name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the number of actors in the system.
     * 
     * @return Number of actors
     */
    public int getActorCount() {
        return actors.size();
    }
    
    /**
     * Get all actor names in the system.
     * 
     * @return Array of actor names
     */
    public String[] getActorNames() {
        return actors.keySet().toArray(new String[0]);
    }
}
