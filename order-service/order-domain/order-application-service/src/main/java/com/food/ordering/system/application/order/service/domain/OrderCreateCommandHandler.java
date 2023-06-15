package com.food.ordering.system.application.order.service.domain;

import com.food.ordering.system.application.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.application.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.application.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.application.order.service.domain.mapper.OrderDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderCreateCommandHandler {
    private final OrderDataMapper orderDataMapper;
    private final OrderCreateHelper orderCreateHelper;
    private final ApplicationDomainEventPublisher applicationDomainEventPublisher;

    public OrderCreateCommandHandler(OrderDataMapper orderDataMapper,
                                     OrderCreateHelper orderCreateHelper,
                                     ApplicationDomainEventPublisher applicationDomainEventPublisher) {
        this.orderDataMapper = orderDataMapper;
        this.orderCreateHelper = orderCreateHelper;
        this.applicationDomainEventPublisher = applicationDomainEventPublisher;
    }

    /**
     * Using Transactional + TransactionEventListener in the OrderCreatedEventAppListener - The listener method will only
     * be invoked when the Transaction has completed and committed.
     *
     * @param createOrderCommand
     * @return
     */
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getOrderId());
        applicationDomainEventPublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order Created Successfully");
    }
}
