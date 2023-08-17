package com.food.ordering.system.restaurant.service.domain;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    public RestaurantDomainService restaurantDomainService() {
        return new RestaurantDomainServiceImpl();
    }

}
