package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.domain.event.EmptyEvent;
import com.food.ordering.system.domain.exception.OrderNotFoundException;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.restaurantapproval.OrderPaidRestaurantMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderPaymentSaga implements SagaStep<PaymentResponse, OrderPaidEvent, EmptyEvent> {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final OrderPaidRestaurantMessagePublisher orderPaidRestaurantMessagePublisher;

    public OrderPaymentSaga(OrderDomainService orderDomainService, OrderRepository orderRepository, OrderPaidRestaurantMessagePublisher orderPaidRestaurantMessagePublisher) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.orderPaidRestaurantMessagePublisher = orderPaidRestaurantMessagePublisher;
    }

    @Override
    @Transactional
    public OrderPaidEvent process(PaymentResponse data) {
        log.info("Completing payment for order with id: {}", data.getOrderId());
        final Order order = findOrder(data.getOrderId());
        final OrderPaidEvent orderPaidEvent = orderDomainService.payOrder(order, orderPaidRestaurantMessagePublisher);

        orderRepository.save(order);

        log.info("Order with id: {} is paid", order.getId().getValue());

        return orderPaidEvent;
    }

    private Order findOrder(String orderId) {
        Optional<Order> orderById = orderRepository.findById(new OrderId(UUID.fromString(orderId)));
        if (orderById.isEmpty()) {
            log.error("Order with id: {} could not be found!", orderId);
            throw new OrderNotFoundException("Order with id " + orderId + " could not be found!");
        }
        return orderById.get();
    }

    @Override
    @Transactional
    public EmptyEvent rollback(PaymentResponse data) {
        log.info("Cancelling order with id: {}", data.getOrderId());
        final Order order = findOrder(data.getOrderId());

        orderDomainService.cancelOrder(order, data.getFailureMessages());
        orderRepository.save(order);

        log.info("Order with id: {} is cancelled", order.getId().getValue());

        return EmptyEvent.INSTANCE;
    }
}
