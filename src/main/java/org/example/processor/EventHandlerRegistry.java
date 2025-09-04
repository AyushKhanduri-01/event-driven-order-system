package org.example.processor;

import org.example.event.BaseEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * HandlerRegistry maintains a mapping between event classes and their corresponding EventHandlers.
 *
 * This allows the EventProcessor to dynamically look up the correct handler for each event type.
 *
 */
public class EventHandlerRegistry {
    private static final Map<Class<? extends BaseEvent>, BaseEventHandler<?>> registry = new HashMap<>();

    public static void registerEventHandler(Class<? extends BaseEvent> eventClass, BaseEventHandler<? > baseEventHandler) {
        registry.put(eventClass, baseEventHandler);
    }

    public <T extends BaseEvent> BaseEventHandler<T> getEventHandler(T event) {
        BaseEventHandler<T> handler = (BaseEventHandler<T>) registry.get(event.getClass());
        if (handler == null) {
            throw new RuntimeException("No handler registered for event: " + event.getClass().getSimpleName());
        }
        return handler;
    }


}
