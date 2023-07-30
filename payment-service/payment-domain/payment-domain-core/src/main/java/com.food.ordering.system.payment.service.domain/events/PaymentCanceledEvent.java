package com.food.ordering.system.payment.service.domain.events;

import com.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

public class PaymentCanceledEvent extends PaymentEvent {
    public PaymentCanceledEvent(Payment payment, ZonedDateTime createdAt, List<String> failureMessages) {
        super(payment, createdAt, failureMessages);
    }
}
