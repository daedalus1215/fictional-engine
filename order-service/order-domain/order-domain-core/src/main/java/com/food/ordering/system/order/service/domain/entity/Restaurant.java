package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.application.domain.entity.AggregateRoot;
import com.food.ordering.system.application.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private final boolean active;

    public Restaurant(List<Product> products, boolean active) {
        this.products = products;
        this.active = active;
    }

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        products = builder.products;
        active = builder.active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isActive() {
        return active;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private RestaurantId restaurantId;
        private List<Product> products;
        private boolean active;

        public Builder() {
        }

        public Builder(List<Product> products, boolean active) {
            this.products = products;
            this.active = active;
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }


        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
