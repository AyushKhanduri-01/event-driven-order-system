package org.example.processor;

import org.example.event.ShippingScheduledEvent;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

/**
 * EventHandler for handling ShippingScheduledBaseEvent.
 *
 * Responsible for updating the order status to SHIPPED,
 * recording the event in the order's history, and notifying observers.
 */
public class ShippingScheduleHandler extends BaseEventHandler<ShippingScheduledEvent> {

    public ShippingScheduleHandler(OrdersData ordersData, ObserverManager observerManager) {
        super(ordersData, observerManager);
    }

    @Override
    public void handle(ShippingScheduledEvent event) {
        Order order =  ordersData.getOrder(event.getOrderId()).orElseThrow(()->new RuntimeException("not found"));
        order.setStatus(OrderStatus.SHIPPED);
        order.getEventHistory().add(event);
        observerManager.notifyObservers(event, order);
    }
}
