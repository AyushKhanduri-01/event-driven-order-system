package org.example.database;

import org.example.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * OrdersData acts as an in-memory repository for storing orders.
 *
 * Provides methods to add and retrieve orders by their unique ID.
 *
 * This class is used by the EventProcessor and observers to access order information.
 */
public class OrdersData {
    private final Map<String, Order> orderDatabase = new HashMap<>();

    public void addOrders(String orderId, Order order){
        orderDatabase.put(orderId,order);
    }

    public Optional<Order> getOrder(String orderId){
        return Optional.ofNullable(orderDatabase.get(orderId));
    }
}
