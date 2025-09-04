package org.example.processor;

import org.example.event.OrderCreatedEvent;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

import java.util.ArrayList;
import java.util.List;

/**
 * EventHandler for handling OrderCreatedBaseEvent.
 *
 * Responsible for creating a new Order in the system, initializing its status and event history,
 * and notifying all observers about the new order.
 */
public class OrderCreatedHandler extends BaseEventHandler<OrderCreatedEvent> {

    public OrderCreatedHandler(OrdersData ordersData, ObserverManager observerManager) {
        super(ordersData, observerManager);
    }

    @Override
    public void handle(OrderCreatedEvent event) {
        Order order = new Order(
                event.getOrderId(),
                event.getCustomerId(),
                event.getItems(),
                event.getTotalAmount(),
                OrderStatus.PENDING,
                new ArrayList<>(List.of(event))
        );
        order.getEventHistory().add(event); // adEventHistory()
        ordersData.addOrders(event.getOrderId(),order);
        observerManager.notifyObservers(event, order);
    }
}
