package com.food.ordering.system.application.domain.event.publisher;

import com.food.ordering.system.application.domain.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {

    void publish(T domainEvent);
}
