package com.food.ordering.system.application.order.service.domain.entity;

import com.food.ordering.system.application.domain.entity.BaseEntity;
import com.food.ordering.system.application.domain.valueobject.Money;
import com.food.ordering.system.application.domain.valueobject.OrderId;
import com.food.ordering.system.application.order.service.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderItem orderItem;
    private final Product product;
    private final int quantity;

    private final Money price;

    private final Money subTotal;

    public static Builder builder() {
        return new Builder();
    }

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId);
        product = builder.product;
        quantity = builder.quantity;
        price = builder.price;
        subTotal = builder.subTotal;
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subTotal);
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderItem = orderItem;
        super.setId(orderItemId);

    }

    public static final class Builder {
        private OrderItemId orderItemId;
        private Product product;
        private int quantity;
        private Money price;
        private Money subTotal;

        public Builder() {
        }

        public Builder(Product product, int quantity, Money price, Money subTotal) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
            this.subTotal = subTotal;
        }

        public Builder product(Product product) {
            this.product = product;
            return this;
        }

        public Builder id(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }

        public Builder price(Money price) {
            this.price = price;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder subTotal(Money subTotal) {
            this.subTotal = subTotal;
            return this;
        }
    }
}
