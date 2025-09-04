package org.example.processor;
import org.example.event.OrderCancelledEvent;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

/**
 * EventHandler for handling OrderCancelledBaseEvent.
 *
 * Updates the order status to CANCELLED, records the event in the order's history,
 * and notifies all registered observers about the change.
 */
public class OrderCancelledHandler extends BaseEventHandler<OrderCancelledEvent> {
    public OrderCancelledHandler(OrdersData ordersData, ObserverManager observerManager) {
        super(ordersData, observerManager);
    }

    @Override
    public void handle(OrderCancelledEvent event) {
        Order order =  ordersData.getOrder(event.getOrderId()).orElseThrow(()->new RuntimeException("not found"));
        order.setStatus(OrderStatus.CANCELLED);
        order.getEventHistory().add(event);
        observerManager.notifyObservers(event, order);
    }

}
