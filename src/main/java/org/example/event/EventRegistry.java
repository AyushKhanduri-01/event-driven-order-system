package org.example.event;

import java.util.HashMap;
import java.util.Map;

/*
 * EventRegistry is used to maintain a mapping between event names (as Strings) and their
 * corresponding event classes (subclasses of BaseEvent).
 *
 * This allows the system to dynamically look up an event class by its name, making it easy to add new event types in the future without modifying core logic.
 */
public class EventRegistry {

    private static final Map<String, Class<? extends BaseEvent>> event_map = new HashMap<>();
    public static void registerEvent(String eventName, Class<? extends BaseEvent> eventClass){
        event_map.put(eventName,eventClass);
    }

    public static Class<? extends  BaseEvent>  getEventClass(String eventName){
        return event_map.get(eventName);
    }

}
