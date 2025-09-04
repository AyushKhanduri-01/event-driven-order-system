package org.example.processor;

import org.example.event.BaseEvent;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

/**
 * Abstract base class for handling different types of events in the system.
 *
 * Uses generics to enforce that subclasses handle a specific type of BaseEvent.
 *
 * Each concrete EventHandler will implement the `handle` method for its event type.
 */
public abstract class BaseEventHandler<T extends BaseEvent> {
    protected OrdersData ordersData;
    protected ObserverManager observerManager;

    public BaseEventHandler(OrdersData ordersData, ObserverManager observerManager) {
        this.ordersData = ordersData;
        this.observerManager = observerManager;
    }

    public abstract void handle(T event);

}
