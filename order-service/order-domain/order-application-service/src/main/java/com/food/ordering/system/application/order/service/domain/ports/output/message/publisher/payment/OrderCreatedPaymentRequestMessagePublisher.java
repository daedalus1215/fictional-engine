package com.food.ordering.system.application.order.service.domain.ports.output.message.publisher.payment;

import com.food.ordering.system.application.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.application.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
