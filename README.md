# Muta – Inventory Operational Events

## Overview
This project implements a high-volume, auditable, and scalable operational event system
for recyclable material inventory tracking.

The system follows an event-based approach where inventory is not stored directly,
but derived from immutable operational events, ensuring full traceability and consistency.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Maven

## Architectural Decisions
- Event-based inventory model (event-driven persistence)
- Single Table inheritance strategy for operational events
- SQL-based inventory aggregation (no business logic in application layer)
- Strong consistency using PostgreSQL ACID transactions

## Database Design
Inventory is derived from operational events instead of being updated directly.
This approach guarantees:
- Full auditability of all inventory changes
- Traceability over time
- Deterministic inventory recalculation
- Efficient aggregation over large datasets

### Polymorphism Strategy
A Single Table strategy was chosen to model operational event polymorphism at the database level.
This decision optimizes aggregation queries over millions of rows by avoiding joins
and minimizing query complexity.

Tradeoffs and rejected alternatives are documented in detail in the database section.

## How to Run
```bash
docker-compose up -d
