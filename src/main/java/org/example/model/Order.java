package org.example.model;

import org.example.event.BaseEvent;

import java.util.List;

/*
 * Represents an Order in the system.
 * Each order has a unique ID, customer info, list of items, total amount, remaining amount to be paid,
 * current status, and a history of events that have affected this order.
 */
public class Order {
    private String  orderId;
    private String customerId;
    private List<Item> items;
    private Double totalAmount;
    private Double remainingAmount;
    private OrderStatus status;
    private List<BaseEvent> eventHistory;

    public Order(String orderId, String customerId, List<Item> items, Double totalAmount, OrderStatus status,List<BaseEvent> eventHistory) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.remainingAmount = totalAmount;
        this.status = status;
        this.eventHistory=eventHistory;

    }

    public String getOrderId() {
        return orderId;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<BaseEvent> getEventHistory() {
        return eventHistory;
    }

    public void setEventHistory(List<BaseEvent> eventHistory) {
        this.eventHistory = eventHistory;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", orderStatus=" + status +
                ", eventHistory=" + eventHistory +
                '}';
    }
}
