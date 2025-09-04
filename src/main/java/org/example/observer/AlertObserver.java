package org.example.observer;

import org.example.event.BaseEvent;
import org.example.model.Order;
import org.example.model.OrderStatus;

/**
 * AlertObserver is responsible for sending alerts when critical order changes occur.
 * Critical changes include:
 *  - Order is CANCELLED
 *  - Order is SHIPPED
 * Implements the Observer interface, so it can be notified of events and order updates.
 */
public class AlertObserver implements Observer{
    public void update(BaseEvent event, Order order) {
        if(order.getStatus() == OrderStatus.CANCELLED || order.getStatus() == OrderStatus.SHIPPED) {
            System.out.println("[ALERT] Sending alert for Order " + order.getOrderId() +
                    ": Status changed to " + order.getStatus());
        }
    }
}
