package com.food.ordering.system.application.order.service.domain.valueobject;

import com.food.ordering.system.application.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
