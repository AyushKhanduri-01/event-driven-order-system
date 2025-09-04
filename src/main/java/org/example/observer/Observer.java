package org.example.observer;

import org.example.event.BaseEvent;
import org.example.model.Order;

/**
 * Observer interface for the Order/Event system.
 *
 * Any class implementing this interface can subscribe to order updates and get notified when an event occurs or an order status changes.
 */
public interface Observer {
    void update(BaseEvent event, Order order);
}
