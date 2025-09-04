package org.example.processor;

import org.example.event.OrderCancelledEvent;
import org.example.event.OrderCreatedEvent;
import org.example.event.PaymentReceivedEvent;
import org.example.event.ShippingScheduledEvent;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

/**
 * HandlerRegistryInitializer is responsible for initializing and registering
 * all event handlers in the system.
 *
 * This static initializer ensures that each event type has its corresponding
 * EventHandler registered in the HandlerRegistry before any events are processed.
 *
 * By centralizing registration here, we can easily add new events
 * in the future without modifying other parts of the system.
 */
public class HandlerRegistryInitializer {
    static {
        OrdersData ordersData = new OrdersData();
        ObserverManager observerManager = new ObserverManager();
        EventHandlerRegistry.registerEventHandler(OrderCreatedEvent.class,new OrderCreatedHandler(ordersData,observerManager));
        EventHandlerRegistry.registerEventHandler(PaymentReceivedEvent.class,new PaymentReceivedHandler(ordersData,observerManager));
        EventHandlerRegistry.registerEventHandler(OrderCancelledEvent.class,new OrderCancelledHandler(ordersData,observerManager));
        EventHandlerRegistry.registerEventHandler(ShippingScheduledEvent.class,new ShippingScheduleHandler(ordersData,observerManager));

    }
}
