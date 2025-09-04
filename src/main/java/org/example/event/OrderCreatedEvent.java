package org.example.event;

import org.example.model.Item;

import java.time.Instant;
import java.util.List;

/**
 * Represents an "Order Created " event in the system.
 * Inherits common event properties from BaseEvent.
 */

public class OrderCreatedEvent extends BaseEvent {

    private String orderId;
    private String customerId;
    private List<Item> items;
    private double totalAmount;


    public OrderCreatedEvent(){}

    public OrderCreatedEvent(String eventId, Instant timestamp, String eventType, String orderId, String customerId, List<Item> items, double totalAmount) {
        super(eventId, timestamp, eventType);
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "eventId='" + getEventId() + '\'' +
                ", timestamp=" + getTimestamp() +
                ", eventType='" + getEventType() + '\'' +
                ", orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
