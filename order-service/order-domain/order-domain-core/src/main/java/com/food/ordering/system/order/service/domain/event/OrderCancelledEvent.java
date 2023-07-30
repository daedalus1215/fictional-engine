package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent implements DomainEvent<Order> {

    private final Order order;
    private final ZonedDateTime date;

    public OrderCancelledEvent(Order order, ZonedDateTime date) {
        this.order = order;
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public ZonedDateTime getCreatedAt() {
        return date;
    }
}
