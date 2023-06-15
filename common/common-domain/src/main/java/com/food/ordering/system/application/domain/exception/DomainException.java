package com.food.ordering.system.application.domain.exception;

/**
 * With Domain specific exceptions extending this DomainException we know, right off the bat if there is a DomainException
 * then the exception was thrown in Domain Logic.
 */
public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
