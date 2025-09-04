package org.example.processor;

import org.example.event.PaymentReceivedEvent;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.observer.ObserverManager;
import org.example.database.OrdersData;

/**
 * EventHandler for handling PaymentReceivedBaseEvent.
 *
 * Responsible for updating the payment status of an order, adjusting the remaining amount,
 * and notifying all observers about the payment event.
 */
public class PaymentReceivedHandler extends BaseEventHandler<PaymentReceivedEvent> {

    public PaymentReceivedHandler(OrdersData ordersData, ObserverManager observerManager) {
        super(ordersData, observerManager);
    }

    @Override
    public void handle(PaymentReceivedEvent event) {
        Order order =  ordersData.getOrder(event.getOrderId()).orElseThrow(()->new RuntimeException("Order not found"));

        if (event.getAmountPaid() >= order.getRemainingAmount()) {
            order.setStatus(OrderStatus.PAID);
            order.setRemainingAmount(0.0);

        } else {
            order.setRemainingAmount(order.getRemainingAmount() - event.getAmountPaid());
            order.setStatus(OrderStatus.PARTIALLY_PAID); // PARTIALLY_PAID
        }
        order.getEventHistory().add(event);
        observerManager.notifyObservers(event, order);
    }
}
