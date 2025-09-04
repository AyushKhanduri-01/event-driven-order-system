package org.example.event;

import java.time.Instant;

/**
 * Represents an "Order Cancelled" event in the system.
 * Inherits common event properties from BaseEvent.
 */

public class OrderCancelledEvent extends BaseEvent {
    private String orderId;
    private String reason;

    public OrderCancelledEvent(){}
    public OrderCancelledEvent(String eventId, Instant timestamp, String eventType, String orderId, String reason) {
        super(eventId, timestamp, eventType);
        this.orderId = orderId;
        this.reason = reason;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "OrderCancelledEvent{" +
                "eventId='" + getEventId() + '\'' +
                ", timestamp=" + getTimestamp() +
                ", eventType='" + getEventType() + '\'' +
                ", orderId='" + orderId + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }


}
