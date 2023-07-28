package com.food.ordering.system.payment.service.domain.valueobject;

import com.food.ordering.system.application.domain.valueobject.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PaymentId extends BaseId<UUID> {

    public PaymentId(UUID value) {
        super(value);
    }
}
