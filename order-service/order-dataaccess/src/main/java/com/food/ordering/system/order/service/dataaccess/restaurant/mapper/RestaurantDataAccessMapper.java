package com.food.ordering.system.order.service.dataaccess.restaurant.mapper;

import com.food.ordering.system.application.domain.valueobject.Money;
import com.food.ordering.system.application.domain.valueobject.ProductId;
import com.food.ordering.system.application.domain.valueobject.RestaurantId;
import com.food.ordering.system.order.service.domain.entity.Product;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.food.ordering.system.order.service.dataaccess.restaurant.exception.RestaurantDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class RestaurantDataAccessMapper {
    public List<UUID> restaurantToRestaurantProduct(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity = restaurantEntities.stream()
                .findFirst()
                .orElseThrow(() -> new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream()
                .map(entity -> new Product(new ProductId(entity.getProductId()),
                        entity.getProductName(),
                        new Money(entity.getProductPrice())))
                .collect(toList());

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }
}
