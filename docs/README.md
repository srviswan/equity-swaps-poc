# Equity Swaps Lifecycle Management System - Documentation

## Overview
This documentation folder contains the comprehensive architecture and design documents for building an equity swaps lifecycle management system based on CDM (Common Domain Model) principles.

## Document Structure

### 1. Architecture & Design
- [System Architecture Overview](architecture/system-overview.md) - High-level system architecture
- [Bounded Contexts](architecture/bounded-contexts.md) - Domain-driven design boundaries
- [Event-Driven Architecture](architecture/event-driven-architecture.md) - Event flow and routing
- [CDM Alignment](architecture/cdm-alignment.md) - Common Domain Model compliance
- [CDM Rosetta Analysis](CDM_ROSETTA_ANALYSIS.md) - FINOS CDM Rosetta structure analysis
- [CDM Payout Structure Analysis](CDM_PAYOUT_STRUCTURE_ANALYSIS.md) - FINOS CDM Payout structure analysis
- [Cashflow Data Structure Design](CASHFLOW_DATA_STRUCTURE_DESIGN.md) - CDM-aligned cashflow data structures
- [Performance Payout Database Design](PERFORMANCE_PAYOUT_DATABASE_DESIGN.md) - PostgreSQL schema for Performance Payout
- [Cash Flow Management Service Implementation Plan](CASHFLOW_MANAGEMENT_SERVICE_IMPLEMENTATION_PLAN.md) - Implementation roadmap and architecture
- [Cash Flow Management Service OpenAPI](CASHFLOW_MANAGEMENT_SERVICE_OPENAPI.yaml) - Complete API specification

### 2. Domain Models
- [Entity Models](domain/entity-models.md) - Core business entities and relationships
- [Event Models](domain/event-models.md) - Lifecycle events and state transitions
- [State Management](domain/state-management.md) - Trade state lifecycle management

### 3. Microservices Design
- [Service Architecture](microservices/service-architecture.md) - Microservices breakdown
- [API Specifications](microservices/api-specifications.md) - REST API contracts
- [Data Contracts](microservices/data-contracts.md) - Service-to-service communication

### 4. Implementation
- [Technology Stack](implementation/technology-stack.md) - Technology choices and rationale
- [Development Guidelines](implementation/development-guidelines.md) - Coding standards and patterns
- [Deployment Strategy](implementation/deployment-strategy.md) - Infrastructure and deployment

### 5. Business Logic
- [Trade Lifecycle](business/trade-lifecycle.md) - Trade processing workflows
- [Position Management](business/position-management.md) - Position tracking and management
- [Cashflow Management](business/cashflow-management.md) - Payment and settlement logic
- [Risk Management](business/risk-management.md) - Risk calculation and monitoring

## Getting Started
1. Start with [System Architecture Overview](architecture/system-overview.md)
2. Review [Bounded Contexts](architecture/bounded-contexts.md) for domain understanding
3. Examine [Entity Models](domain/entity-models.md) for data structure
4. Review [Event Models](domain/event-models.md) for lifecycle understanding

## Contributing
When adding new documents or updating existing ones, please:
- Follow the established folder structure
- Use consistent markdown formatting
- Include diagrams where helpful
- Reference CDM specifications when applicable
- Update this README with new document links
