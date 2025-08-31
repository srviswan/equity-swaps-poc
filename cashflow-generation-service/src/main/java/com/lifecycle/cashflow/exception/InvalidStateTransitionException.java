package com.lifecycle.cashflow.exception;

/**
 * Exception thrown when an invalid state transition is attempted on a cashflow.
 * 
 * This exception is used to enforce business rules around cashflow lifecycle management.
 */
public class InvalidStateTransitionException extends RuntimeException {
    
    /**
     * Constructs a new InvalidStateTransitionException with the specified detail message.
     * 
     * @param message the detail message
     */
    public InvalidStateTransitionException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new InvalidStateTransitionException with the specified detail message and cause.
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public InvalidStateTransitionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs a new InvalidStateTransitionException with the specified cause.
     * 
     * @param cause the cause
     */
    public InvalidStateTransitionException(Throwable cause) {
        super(cause);
    }
}
