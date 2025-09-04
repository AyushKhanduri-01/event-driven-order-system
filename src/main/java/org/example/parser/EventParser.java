package org.example.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.event.*;

/**
 * EventParser is responsible for parsing JSON strings into BaseEvent objects.
 *
 * Uses Jackson ObjectMapper with a custom deserializer (EventDeserializer) to handle polymorphic deserialization of different event types.
 */
public class EventParser {
   private static final ObjectMapper mapper = new ObjectMapper();
   private static SimpleModule module = new SimpleModule();

    static{
        module.addDeserializer(BaseEvent.class,new EventDeserializer());
        mapper.registerModule(module);
        mapper.registerModule(new JavaTimeModule());
    }
    public static BaseEvent parse(String eventline) throws JsonProcessingException {

        try {
              return mapper.readValue(eventline,BaseEvent.class);
        }
        catch (Exception e){
            System.out.println("Failed to parse event: " + e.getMessage());
            return null;
        }
    }
}
