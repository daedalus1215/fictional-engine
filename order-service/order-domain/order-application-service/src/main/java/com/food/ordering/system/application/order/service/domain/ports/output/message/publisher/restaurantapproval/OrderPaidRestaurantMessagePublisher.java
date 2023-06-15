package com.food.ordering.system.application.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.food.ordering.system.application.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.application.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
