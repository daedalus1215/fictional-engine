package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import com.food.ordering.system.payment.service.domain.entity.CreditHistory;
import com.food.ordering.system.payment.service.domain.entity.Payment;
import com.food.ordering.system.payment.service.domain.events.PaymentCancelledEvent;
import com.food.ordering.system.payment.service.domain.events.PaymentCompletedEvent;
import com.food.ordering.system.payment.service.domain.events.PaymentEvent;
import com.food.ordering.system.payment.service.domain.events.PaymentFailedEvent;

import java.util.List;

public interface PaymentDomainService {
    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventDomainEventPublisher,
                                            DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages,
                                          DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainEventPublisher,
                                          DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

}
