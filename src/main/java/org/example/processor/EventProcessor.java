package org.example.processor;

import org.example.event.*;

/**
 * EventProcessor is the central class responsible for processing all incoming events.
 *
 * Delegates the handling of each event to the appropriate EventHandler registered in HandlerRegistry.
 */
public class EventProcessor {

    EventHandlerRegistry eventHandlerRegistry = new EventHandlerRegistry();
    public void processEvent(BaseEvent event) throws Exception{
        BaseEventHandler baseEventHandler = eventHandlerRegistry.getEventHandler(event);
       baseEventHandler.handle(event);
    }

}
