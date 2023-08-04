package com.food.ordering.system.payment.service.domain.events;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

public class PaymentFailedEvent extends PaymentEvent {
    private final DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher;

    public PaymentFailedEvent(Payment payment, ZonedDateTime createdAt, List<String> failureMessages, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher) {
        super(payment, createdAt, failureMessages);
        this.paymentFailedEventDomainEventPublisher = paymentFailedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        this.paymentFailedEventDomainEventPublisher.publish(this);
    }
}
