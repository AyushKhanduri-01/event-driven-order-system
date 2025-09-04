package org.example.observer;

import org.example.event.BaseEvent;
import org.example.model.Order;
import java.util.ArrayList;
import java.util.List;

/**
 * ObserverManager manages all observers in the system.
 *
 * It allows adding new observers, removing observer, and notifying all registered observers whenever an order-related event occurs.
 *
 * Uses a static list so that observers are shared across all instances.
 */
public class ObserverManager {
    private static final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(BaseEvent event, Order order) {
        for (Observer observer : observers) {
            observer.update(event, order);
        }
    }
}
