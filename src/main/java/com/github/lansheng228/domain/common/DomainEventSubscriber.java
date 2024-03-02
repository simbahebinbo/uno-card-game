package com.github.lansheng228.domain.common;

public interface DomainEventSubscriber {
    void handleEvent(DomainEvent event);
}
