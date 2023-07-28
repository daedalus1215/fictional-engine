package com.food.ordering.system.payment.service.domain.entity;

import com.food.ordering.system.application.domain.entity.AggregateRoot;
import com.food.ordering.system.application.domain.valueobject.CustomerId;
import com.food.ordering.system.application.domain.valueobject.Money;
import com.food.ordering.system.application.domain.valueobject.OrderId;
import com.food.ordering.system.application.domain.valueobject.PaymentStatus;
import com.food.ordering.system.payment.service.domain.valueobject.PaymentId;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class Payment extends AggregateRoot<PaymentId> {
    private final OrderId orderId;
    private final CustomerId customerId;
    private final Money price;

    private PaymentStatus paymentStatus;
    private ZonedDateTime createdAt;

    public void initializePayment() {
        setId(new PaymentId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public void validatePayment(List<String> failureMessages) {
        if (price == null || !price.isGreaterThanZero()) {
            failureMessages.add("Total price must be greater than zero!");
        }
    }

    public void updateStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    private Payment(Builder builder) {
        super();
        this.setId(builder.id);
        orderId = builder.orderId;
        customerId = builder.customerId;
        price = builder.price;
        paymentStatus = builder.paymentStatus;
        createdAt = builder.createdAt;
    }


    public static final class Builder {
        private PaymentId id;
        private final OrderId orderId;
        private final CustomerId customerId;
        private final Money price;
        private PaymentStatus paymentStatus;
        private ZonedDateTime createdAt;

        public Builder(OrderId orderId, CustomerId customerId, Money price) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.price = price;
        }

        public Builder id(PaymentId val) {
            id = val;
            return this;
        }

        public Builder paymentStatus(PaymentStatus val) {
            paymentStatus = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {
            createdAt = val;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
