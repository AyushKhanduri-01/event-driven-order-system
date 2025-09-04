package org.example.parser;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.example.event.BaseEvent;
import org.example.event.EventRegistry;

import java.io.IOException;

/**
 * Custom Jackson deserializer for BaseEvent.
 *
 * Allows polymorphic deserialization of different event types based on the "eventType" field in JSON.
 *
 * For example, if eventType="OrderCreated", it will deserialize the JSON into OrderCreatedEvent class.
 */
public class EventDeserializer extends StdDeserializer<BaseEvent> {

    public EventDeserializer(){
        super(BaseEvent.class);
    }
    @Override
    public BaseEvent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        String eventType = node.get("eventType").asText();

        Class<? extends BaseEvent> eventClass = EventRegistry.getEventClass(eventType);
        if (eventClass != null) {
            return p.getCodec().treeToValue(node, eventClass);
        } else {
            System.out.println("Unknown event type: " + eventType);
            return null;
        }
    }
}

