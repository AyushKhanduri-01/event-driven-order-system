package org.example.event;

import java.time.Instant;

/**
 * Represents a "Payment Received" event in the system.
 * Inherits common event properties from BaseEvent.
 */

public class PaymentReceivedEvent extends BaseEvent {
    private String orderId;
    private double amountPaid;


    public PaymentReceivedEvent(){}
    public PaymentReceivedEvent(String eventId, Instant timestamp, String eventType, String orderId, double amountPaid) {
        super(eventId, timestamp, "PaymentReceived");
        this.orderId=orderId;
        this.amountPaid=amountPaid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "PaymentReceivedEvent{" +
                "eventId='" + getEventId() + '\'' +
                ", timestamp=" + getTimestamp() +
                ", eventType='" + getEventType() + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }


}
