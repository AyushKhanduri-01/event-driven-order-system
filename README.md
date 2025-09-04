# Event-Driven Order Processing System

A Java-based event-driven architecture system for processing e-commerce order events. The system processes various order-related events (creation, payments, shipping, cancellations) and maintains order state with real-time notifications.

##  Architecture Overview

The system follows an **Event-Driven Architecture** pattern with the following key components:

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Event Source  │───▶│  Event Parser   │───▶│ Event Processor │
│   (events.txt)  │    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                                                        │
                                                        ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Observers     │◀───│ Observer Manager│◀───│ Event Handlers  │
│ (Logger, Alert) │    │                 │    │                 │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                                                        │
                                                        ▼
                                               ┌─────────────────┐
                                               │   Orders Data   │
                                               │   (Repository)  │
                                               └─────────────────┘
```

##  Main Method Flow

The main method in `Main.java` orchestrates the entire event processing pipeline:

### Event Processing Flow:

1. **Initialization Phase**:
   - `HandlerRegistryInitializer`: Registers all event handlers
   - `EventRegistryInitializer`: Registers all event types
   - `ObserverManager`: Sets up logging and alert observers

2. **Event Processing Phase**:
   - Read JSON events from `events.txt`
   - Parse each event using `EventParser`
   - Route to appropriate handler via `EventProcessor`
   - Update order state and notify observers

##  Module Documentation

### 1. Event Module (`org.example.event`)

**Purpose**: Defines the event structure and registration system.

#### Core Classes:

- **`BaseEvent`**: Abstract base class for all events
  - Properties: `eventId`, `timestamp`, `eventType`
  - All specific events extend this class

- **Event Types**:
  - `OrderCreatedEvent`: New order creation
  - `PaymentReceivedEvent`: Payment processing
  - `ShippingScheduledEvent`: Shipping arrangements
  - `OrderCancelledEvent`: Order cancellation

- **`EventRegistry`**: Maps event type names to classes
  - Enables dynamic event type resolution
  - Used by `EventDeserializer` for polymorphic parsing

- **`EventRegistryInitializer`**: Static initializer for event registration
  - Registers all known event types at startup


### 2. Parser Module (`org.example.parser`)

**Purpose**: Handles JSON deserialization of events with polymorphic support.

#### Core Classes:

- **`EventParser`**: Main parsing interface
  - Uses Jackson ObjectMapper with custom deserializer
  - Handles JSON to BaseEvent conversion

- **`EventDeserializer`**: Custom Jackson deserializer
  - Reads `eventType` field from JSON
  - Dynamically deserializes to appropriate event class
  - Uses `EventRegistry` for type resolution

### 3. Processor Module (`org.example.processor`)

**Purpose**: Core event processing logic with handler registration and routing.

#### Core Classes:

- **`EventProcessor`**: Central event processing coordinator
  - Routes events to appropriate handlers
  - Uses `EventHandlerRegistry` for handler lookup

- **`EventHandlerRegistry`**: Handler registration and lookup
  - Maps event classes to their handlers
  - Provides type-safe handler retrieval

- **`BaseEventHandler<T>`**: Abstract base for all event handlers
  - Generic type ensures type safety
  - Provides access to `OrdersData` and `ObserverManager`

- **Specific Handlers**:
  - `OrderCreatedHandler`: Creates new orders, sets initial state
  - `PaymentReceivedHandler`: Updates payment status, calculates remaining amount
  - `ShippingScheduleHandler`: Schedules shipping for paid orders
  - `OrderCancelledHandler`: Cancels orders and updates status

- **`HandlerRegistryInitializer`**: Static initializer for handler registration
  - Registers all event handlers at startup
  - Creates shared instances of `OrdersData` and `ObserverManager`


### 4. Observer Module (`org.example.observer`)

**Purpose**: Implements Observer pattern for real-time notifications.

#### Core Classes:

- **`Observer`**: Interface for notification receivers
  - `update(BaseEvent event, Order order)`: Called when events occur

- **`ObserverManager`**: Manages observer registration and notifications
  - Maintains list of registered observers
  - Notifies all observers when events occur

- **`LoggerObserver`**: Logs all events to console
  - Provides audit trail of all order activities

- **`AlertObserver`**: Handles alert notifications
  - Can be extended for email, SMS, or other alert mechanisms


### 5. Model Module (`org.example.model`)

**Purpose**: Defines core business entities and their relationships.

#### Core Classes:

- **`Order`**: Main business entity
  - Properties: `orderId`, `customerId`, `items`, `totalAmount`, `remainingAmount`, `status`, `eventHistory`
  - Tracks complete order lifecycle and event history

- **`Item`**: Represents order line items
  - Properties: `itemId`, `quantity`

- **`OrderStatus`**: Enum for order states
  - Values: `PENDING`, `PARTIALLY_PAID`, `PAID`, `SHIPPED`, `CANCELLED`


### 6. Database Module (`org.example.database`)

**Purpose**: Provides data persistence layer (in-memory implementation).

#### Core Classes:

- **`OrdersData`**: In-memory order repository
  - `addOrders(String orderId, Order order)`: Store orders
  - `getOrder(String orderId)`: Retrieve orders by ID
  - Uses `HashMap` for fast lookups


## 🛠️ Setup and Usage

### Prerequisites:
- Java 8 or higher
- Maven 3.6 or higher

### Run the Project:

**Windows (Command Prompt):**
```cmd
mvn clean compile
```

### Running the Application:

**Linux/macOS:**
```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

**Windows (Command Prompt):**
```cmd
mvn exec:java -Dexec.mainClass="org.example.Main"
```



**Direct Java execution (after compilation):**

**Linux/macOS:**
```bash
java -cp target/classes org.example.Main
```

**Windows (Command Prompt):**
```cmd
java -cp target\classes org.example.Main
```


##  Extending the System

### Adding New Event Types:
1. Create new event class extending `BaseEvent`
2. Register in `EventRegistryInitializer`
3. Create corresponding handler extending `BaseEventHandler`
4. Register handler in `HandlerRegistryInitializer`

### Adding New Observers:
1. Implement `Observer` interface
2. Register in `ObserverManager` during initialization


##  Key Design Patterns Used

1. **Event-Driven Architecture**: Decoupled event producers and consumers
2. **Observer Pattern**: Real-time notifications for order updates
4. **Strategy Pattern**: Different handlers for different event types
6. **Factory Pattern**: Event creation through deserialization