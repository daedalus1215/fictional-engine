package com.food.ordering.system.restaurant.service.domain.mapper;

import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.domain.valueobject.OrderStatus;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.food.ordering.system.restaurant.service.domain.entity.OrderDetail;
import com.food.ordering.system.restaurant.service.domain.entity.Product;
import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class RestaurantDataMapper {
    public Restaurant restaurantApprovalRequestAvroModelToRestaurant(RestaurantApprovalRequest request) {
        return Restaurant.builder()
                .id(new RestaurantId(UUID.fromString(request.getRestaurantId())))
                .orderDetail(OrderDetail.builder()
                        .orderId(new OrderId(UUID.fromString(request.getOrderId())))
                        .products(request.getProducts().stream().map(product -> Product.builder()
                                        .id(product.getId())
                                        .quantity(product.getQuantity())
                                        .build())
                                .collect(toList()))
                        .totalAmount(new Money(request.getPrice()))
                        .orderStatus(OrderStatus.valueOf(request.getRestaurantOrderStatus().name()))
                        .build())
                .build();
    }
}
