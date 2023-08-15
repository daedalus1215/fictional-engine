package com.food.ordering.system.dataaccess.restaurant.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class RestaurantDataAccessException extends DomainException {
    public RestaurantDataAccessException(String message) {
        super(message);
    }

    public RestaurantDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
