package org.example.model;

import javax.swing.text.PlainDocument;
import java.nio.channels.AcceptPendingException;

/**
 * Represents the possible statuses of an Order in the system.
 * Used to track the lifecycle of an order from creation to completion or cancellation.
 */
public enum OrderStatus {
    PENDING,
    PAID,
    PARTIALLY_PAID,
    SHIPPED,
    CANCELLED
}
