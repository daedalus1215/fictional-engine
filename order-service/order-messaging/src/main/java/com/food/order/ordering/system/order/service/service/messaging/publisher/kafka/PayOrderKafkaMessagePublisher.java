package com.food.order.ordering.system.order.service.service.messaging.publisher.kafka;

import com.food.order.ordering.system.order.service.service.messaging.mapper.OrderMessagingDataMapper;
import com.food.ordering.system.application.kafka.producer.KafkaMessageHelper;
import com.food.ordering.system.application.kafka.producer.service.KafkaProducer;
import com.food.ordering.system.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.food.ordering.system.order.service.domain.config.OrderServiceConfigData;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.restaurantapproval.OrderPaidRestaurantMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayOrderKafkaMessagePublisher implements OrderPaidRestaurantMessagePublisher {
    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, RestaurantApprovalRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PayOrderKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper, OrderServiceConfigData orderServiceConfigData, KafkaProducer<String, RestaurantApprovalRequestAvroModel> kafkaProducer, KafkaMessageHelper kafkaMessageHelper) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(OrderPaidEvent domainEvent) {
        final String orderId = domainEvent.getOrder().getId().getValue().toString();
        try {
            final RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel = orderMessagingDataMapper.orderPaidEventToRestaurantApprovalRequestAvroModel(domainEvent);
            kafkaProducer.send(orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                    orderId,
                    restaurantApprovalRequestAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                            restaurantApprovalRequestAvroModel,
                            orderId,
                            "RestaurantApprovalRequestAvroModel")
            );

            log.info("ReqstaurantApprovalRequestAvroModel sent to kafka for order id: {}", orderId);
        } catch (Exception e) {
            log.error("Error while sending RestaurantApprovalRequestAvroModel message"
                    + " to kafka with order id: {}, error: {}", orderId, e.getMessage());
        }
    }
}
