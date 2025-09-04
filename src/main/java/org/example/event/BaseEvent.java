package org.example.event;

import jdk.jfr.Event;
import org.example.model.Order;

import java.time.Instant;

/**
 * BaseEvent is the abstract superclass for all events in the system.
 * It defines the common properties that every event should have.
 */
public abstract class BaseEvent {
    private String eventId;
    private Instant timestamp;
    private  String eventType;

    public BaseEvent() {}

    public BaseEvent(String eventId, Instant timestamp, String eventType) {
        this.eventId = eventId;
        this.timestamp = timestamp;
        this.eventType = eventType;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", timestamp=" + timestamp +
                ", eventType='" + eventType + '\'' +
                '}';
    }

}
