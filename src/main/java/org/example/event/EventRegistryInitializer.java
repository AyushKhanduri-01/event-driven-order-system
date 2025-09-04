package org.example.event;

/**
 * EventRegistryInitializer is responsible for registering all the known events in the EventRegistry when the application starts.
 *
 * By centralizing event registration here, we can easily add new events in the future without modifying other parts of the system (like the parser or processor).
 */
public class EventRegistryInitializer {
    static {
        EventRegistry.registerEvent("OrderCreated", OrderCreatedEvent.class);
        EventRegistry.registerEvent("PaymentReceived", PaymentReceivedEvent.class);
        EventRegistry.registerEvent("ShippingScheduled", ShippingScheduledEvent.class);
        EventRegistry.registerEvent("OrderCancelled", OrderCancelledEvent.class);

    }
}
