# Secure Digital Payment Platform

A Java-based backend system that simulates a secure, auditable, and idempotent digital payment platform. This project is designed to reflect real-world payment system architecture and software engineering best practices used in enterprise payment platforms.

---

## 🚀 Project Overview

The **Secure Digital Payment Platform** provides a backend service for processing digital payments between wallets. It focuses on **correctness**, **reliability**, **extensibility**, and **observability**—key requirements for financial systems.

The system supports wallet management, multiple payment methods, validation pipelines, transaction auditing, idempotent request handling, and centralized metrics reporting.

---

## ✨ Key Features

- **Wallet creation and balance management**
- **Strategy-based payment processing engine**
- **Validation pipeline using Chain of Responsibility**
- **Full transaction lifecycle tracking (audit trail)**
- **Idempotent payment handling** to prevent duplicate transactions
- **Centralized metrics and reporting**
- **Clean layered architecture** following enterprise standards

---

## 🏗️ Architecture Overview
```
Controller Layer
      ↓
Service Layer
      ↓
Payment Engine (Strategy + Factory)
      ↓
Validation Pipeline (Chain of Responsibility)
      ↓
Repository + Metrics
```

Each layer has a single responsibility, making the system **modular**, **testable**, and **easy to extend**.

---

## 🧠 Design Patterns Used

### Strategy Pattern
Used to support multiple payment methods (e.g., Wallet, Card) without modifying existing logic.

### Factory Pattern
Centralized creation of payment strategies based on payment type.

### Chain of Responsibility
Implements a flexible validation pipeline where each validation rule is isolated and reusable.

### Singleton-style Metrics Collector
Ensures centralized and consistent collection of payment metrics.

---

## 🔐 Security & Reliability

- **Idempotency Keys**: Prevent duplicate payment processing during retries or network failures.
- **UUID-based Identifiers**: Secure, unique transaction and wallet identifiers.
- **Explicit Transaction States**: Each transaction moves through a well-defined lifecycle:
```
  INITIATED → VALIDATED → PROCESSING → SUCCESS / FAILED
```
- **Failure Reason Tracking**: Failed transactions store the reason for auditing and debugging.

---

## 🧾 Transaction Audit

Every payment request is recorded, including:

- Transaction ID
- Source and destination wallets
- Amount
- Status
- Failure reason (if any)
- Timestamp

This ensures **full traceability**, which is critical for financial systems.

---

## 📊 Metrics & Reporting

The system collects operational metrics such as:

- Total number of transactions
- Successful transactions
- Failed transactions
- Total amount processed

### Metrics Endpoint
```
GET /metrics/summary
```

**Sample Response:**
```json
{
  "totalTransactions": 20,
  "successfulTransactions": 17,
  "failedTransactions": 3,
  "totalAmountProcessed": 82500.0
}
```

---

## 📌 API Endpoints

### Wallet APIs
```
POST /wallet/create
POST /wallet/add-balance
GET  /wallet/{walletId}
```

### Payment API
```
POST /payment/process
Headers:
  Idempotency-Key: <unique-key>
```

### Transaction API
```
GET /transaction/{transactionId}
```

### Metrics API
```
GET /metrics/summary
```

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **H2** (In-memory database)
- **RESTful APIs**

---

## ▶️ How to Run the Project

### Prerequisites

- Java 17+
- Maven

### Run Command
```bash
mvn clean spring-boot:run
```

The application will start on the default Spring Boot port.

---

## 🧪 Example Payment Flow

1. Create two wallets
2. Add balance to the source wallet
3. Call `/payment/process` with a unique `Idempotency-Key`
4. Fetch transaction details using transaction ID
5. View system metrics

---

## 🔮 Future Enhancements

- Persistent database (PostgreSQL / MySQL)
- Authentication and authorization
- Distributed idempotency using Redis
- Asynchronous payment processing
- Monitoring with Prometheus and Grafana
- Unit and integration test coverage

---

## 👨‍💻 Author

Built as a backend-focused project to demonstrate:

- Software engineering fundamentals
- Enterprise design patterns
- Secure payment system design
- Clean, maintainable Java code

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

Feel free to check the [issues page](issues).

---

## ⭐ Show Your Support

Give a ⭐️ if this project helped you learn something new!
