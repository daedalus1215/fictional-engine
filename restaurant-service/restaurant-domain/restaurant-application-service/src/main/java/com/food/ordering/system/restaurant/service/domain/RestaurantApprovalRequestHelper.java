package com.food.ordering.system.restaurant.service.domain;

import com.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import com.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;
import com.food.ordering.system.restaurant.service.domain.event.OrderApprovedEvent;
import com.food.ordering.system.restaurant.service.domain.event.OrderRejectedEvent;
import com.food.ordering.system.restaurant.service.domain.exception.RestaurantNotFoundException;
import com.food.ordering.system.restaurant.service.domain.mapper.RestaurantDataMapper;
import com.food.ordering.system.restaurant.service.domain.ports.output.repository.OrderApprovalRepository;
import com.food.ordering.system.restaurant.service.domain.ports.output.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class RestaurantApprovalRequestHelper {
    private final RestaurantDomainService restaurantDomainService;
    private final RestaurantDataMapper restaurantDataMapper;
    private final RestaurantRepository restaurantRepository;
    private final OrderApprovalRepository orderApprovalRepository;
    private final DomainEventPublisher<OrderApprovedEvent> orderApprovedMessagePublisher;
    private final DomainEventPublisher<OrderRejectedEvent> orderRejectedMessagePublisher;

    public RestaurantApprovalRequestHelper(RestaurantDomainService restaurantDomainService,
                                           RestaurantDataMapper restaurantDataMapper,
                                           RestaurantRepository restaurantRepository,
                                           OrderApprovalRepository orderApprovalRepository,
                                           DomainEventPublisher<OrderApprovedEvent> orderApprovedMessagePublisher,
                                           DomainEventPublisher<OrderRejectedEvent> orderRejectedMessagePublisher) {
        this.restaurantDomainService = restaurantDomainService;
        this.restaurantDataMapper = restaurantDataMapper;
        this.restaurantRepository = restaurantRepository;
        this.orderApprovalRepository = orderApprovalRepository;
        this.orderApprovedMessagePublisher = orderApprovedMessagePublisher;
        this.orderRejectedMessagePublisher = orderRejectedMessagePublisher;
    }

    @Transactional
    public OrderApprovalEvent persistOrderApproval(RestaurantApprovalRequest request) {
        log.info("Processing restaurant approval for order id: {}", request.getOrderId());
        final ArrayList<String> failureMessages = new ArrayList<>();
        final Restaurant restaurant = findRestaurant(request);
        final OrderApprovalEvent orderApprovalEvent = restaurantDomainService.validateOrder(
                restaurant,
                failureMessages,
                orderApprovedMessagePublisher,
                orderRejectedMessagePublisher);
        orderApprovalRepository.save(restaurant.getOrderApproval());
        return orderApprovalEvent;
    }

    private Restaurant findRestaurant(RestaurantApprovalRequest request) {
        final Restaurant restaurant = restaurantDataMapper.restaurantApprovalRequestToRestaurant(request);
        final Optional<Restaurant> restaurantInformation = restaurantRepository.findRestaurantInformation(restaurant);
        if (restaurantInformation.isEmpty()) {
            log.error("Restaurant with id "
                    + restaurant.getId().getValue()
                    + " not found!");
            throw new RestaurantNotFoundException("Restaurant with id "
                    + restaurant.getId().getValue()
                    + " not found!");
        }

        final Restaurant restaurantEntity = restaurantInformation.get();
        restaurant.setActive(restaurantEntity.isActive());
        restaurantEntity.getOrderDetail().getProducts().forEach(product -> {
            restaurantEntity.getOrderDetail().getProducts().forEach(p -> {
                if (p.getId().equals(product.getId())) {
                    product.updateWithConfirmedNamePriceAndAvailability(p.getName(), p.getPrice(), p.isAvailable());
                }
            });
        });

        restaurant.getOrderDetail().setId(new OrderId(UUID.fromString(request.getOrderId())));

        return restaurant;
    }
}
