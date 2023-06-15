package com.food.ordering.system.application.order.service.domain.ports.output.repository;

import com.food.ordering.system.application.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);

}
