package org.example.observer;

import org.example.event.BaseEvent;
import org.example.model.Order;

/**
 * LoggerObserver logs all events and order status changes to the console.
 * Implements the Observer interface, so it can be notified of events and order updates.
 */
public class LoggerObserver implements Observer{
    public void update(BaseEvent event, Order order){
        System.out.println("[LOGGER] Order : " + order.getOrderId() +
                " " + event.getEventType() +
                " due to event " + event.getEventId() +
                ". Status: " + order.getStatus());
    }
}
