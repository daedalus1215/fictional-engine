package com.food.ordering.system.restaurant.service.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.OrderApprovalStatus;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.restaurant.service.domain.valueobject.OrderApprovalId;

import java.util.Objects;

public class OrderApproval extends BaseEntity<OrderApprovalId> {
    private final RestaurantId restaurantId;
    private final OrderId orderId;
    private final OrderApprovalStatus approvalStatus;

    public OrderApproval(RestaurantId restaurantId, OrderId orderId, OrderApprovalStatus approvalStatus) {
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.approvalStatus = approvalStatus;
    }

    private OrderApproval(Builder builder) {
        this.setId(builder.orderApprovalId);
        restaurantId = builder.restaurantId;
        orderId = builder.orderId;
        approvalStatus = builder.approvalStatus;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderApproval that = (OrderApproval) o;
        return restaurantId.equals(that.restaurantId) && orderId.equals(that.orderId) && approvalStatus == that.approvalStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), restaurantId, orderId, approvalStatus);
    }

    public static final class Builder {
        private OrderApprovalId orderApprovalId;
        private RestaurantId restaurantId;
        private OrderId orderId;
        private OrderApprovalStatus approvalStatus;

        public Builder(RestaurantId restaurantId, OrderId orderId, OrderApprovalStatus approvalStatus) {
            this.restaurantId = restaurantId;
            this.orderId = orderId;
            this.approvalStatus = approvalStatus;
        }

        public Builder() {
        }

        public Builder id(OrderApprovalId val) {
            orderApprovalId = val;
            return this;
        }

        public OrderApproval build() {
            return new OrderApproval(this);
        }
    }
}
