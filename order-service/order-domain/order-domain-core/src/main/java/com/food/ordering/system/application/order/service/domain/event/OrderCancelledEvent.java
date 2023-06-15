package com.food.ordering.system.application.order.service.domain.event;

import com.food.ordering.system.application.domain.event.DomainEvent;
import com.food.ordering.system.application.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent implements DomainEvent<Order> {

    private final Order order;
    private final ZonedDateTime date;

    public OrderCancelledEvent(Order order, ZonedDateTime date) {
        this.order = order;
        this.date = date;
    }
}
