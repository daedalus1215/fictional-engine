package com.food.order.ordering.system.order.service.service.messaging.mapper;

import com.food.ordering.system.application.order.service.domain.entity.Order;
import com.food.ordering.system.application.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.kafka.order.avro.model.PaymentRequestAvroModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMessagingDataMapper {
    public PaymentRequestAvroModel orderCreatedEventToPaymentRequestAvroModel(OrderCreatedEvent orderCreatedEvent) {
        Order order = orderCreatedEvent.getOrder();
        return PaymentRequestAvroModel.bu
    }
}
