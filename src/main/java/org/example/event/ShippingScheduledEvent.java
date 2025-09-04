package org.example.event;

import java.time.Instant;
import java.time.LocalDate;

/**
 * Represents a "Shipping Scheduled" event in the system.
 * Inherits common event properties from BaseEvent.
 */

public class ShippingScheduledEvent extends BaseEvent {
    private String orderId;
    private LocalDate shippingDate;

    public ShippingScheduledEvent(){}
    public ShippingScheduledEvent(String eventId, Instant timestamp, String eventType, String orderId, LocalDate shippingDate) {
        super(eventId, timestamp, eventType);
        this.orderId = orderId;
        this.shippingDate = shippingDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String toString() {
        return "ShippingScheduledEvent{" +
                "eventId='" + getEventId() + '\'' +
                ", timestamp=" + getTimestamp() +
                ", eventType='" + getEventType() + '\'' +
                ", orderId='" + orderId + '\'' +
                ", shippingDate=" + shippingDate +
                '}';
    }
}
