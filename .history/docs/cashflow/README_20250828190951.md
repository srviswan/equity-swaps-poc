# Cash Flow Generation Service - Architectural Documentation

## Overview

The **Cash Flow Generation Service** is a core microservice responsible for generating, managing, and tracking cashflows throughout their complete lifecycle. This service leverages Java 21 virtual threads, Spring Boot 3.3+ reactive capabilities, and advanced partitioning strategies to handle high-volume cashflow processing.

## Architecture Principles

- **Thread Partitioning**: Contract + Underlier (SecurityId) + Calculation Type based isolation
- **Reactive Processing**: Project Reactor for high-volume streams with backpressure handling
- **Calculation Separation**: Interest and equity calculations processed independently
- **High Performance**: 100K+ concurrent operations with virtual threads
- **Data Consistency**: ACID operations within partitions, preventing race conditions

## Service Capabilities

### **Cashflow Types**
- **INTEREST**: Daily accruals with rate management and business day adjustments
- **DIVIDEND**: Dividend entitlements and payment calculations
- **PERFORMANCE**: Unrealized P&L calculations for equity returns
- **FEES**: Management fees, performance fees, and other charges

### **Processing States**
- **ACCRUED**: Initial state with daily accrual tracking
- **REALIZED_DEFERRED**: Deferred due to business rules or regulatory requirements
- **REALIZED_UNSETTLED**: Realized but not yet settled
- **REALIZED_SETTLED**: Fully settled and confirmed

## Documentation Structure

### **1. Architecture & Design** ✅
- [System Architecture](architecture/system-architecture.md) - High-level system design and components
- [Thread Partitioning Strategy](architecture/thread-partitioning.md) - Detailed partitioning approach
- [Reactive Architecture](architecture/reactive-architecture.md) - Project Reactor and WebFlux design
- [Data Flow Diagrams](architecture/data-flow-diagrams.md) - Cashflow processing workflows

### **2. API & Integration**
- [API Specification](../CASHFLOW_MANAGEMENT_SERVICE_OPENAPI.yaml) - Complete OpenAPI specification
- [Integration Patterns](integration/integration-patterns.md) - Service-to-service communication
- [Event Schema](integration/event-schema.md) - Kafka event definitions and schemas
- [External Service Contracts](integration/external-contracts.md) - Market data and payment system interfaces

### **3. Data Models & Database** ✅
- [Domain Models](data/domain-models.md) - Core business entities and relationships
- [Database Schema](data/database-schema.md) - PostgreSQL table structures and indexes
- [Data Migration](data/data-migration.md) - Schema evolution and migration strategies
- [Data Partitioning](data/data-partitioning.md) - Database partitioning strategies

### **4. Implementation & Code**
- [Service Implementation](implementation/service-implementation.md) - Core service classes and logic
- [Repository Layer](implementation/repository-layer.md) - Data access patterns and implementations
- [Configuration](implementation/configuration.md) - Spring Boot and application configuration
- [Testing Strategy](implementation/testing-strategy.md) - Unit, integration, and performance testing

### **5. Deployment & Operations**
- [Deployment Architecture](deployment/deployment-architecture.md) - Container and orchestration setup
- [Configuration Management](deployment/configuration-management.md) - Environment-specific configurations
- [Monitoring & Observability](deployment/monitoring-observability.md) - Metrics, logging, and alerting
- [Performance Tuning](deployment/performance-tuning.md) - Optimization strategies and benchmarks

### **6. Business Logic**
- [Calculation Engines](business/calculation-engines.md) - Interest, equity, and performance calculations
- [Business Rules](business/business-rules.md) - Validation rules and business logic
- [Workflow Management](business/workflow-management.md) - Cashflow lifecycle and state transitions
- [Error Handling](business/error-handling.md) - Exception handling and recovery strategies

## Technology Stack

### **Runtime & Framework**
- **Java 21**: Latest LTS with virtual threads and pattern matching
- **Spring Boot 3.3+**: Latest version with reactive programming support
- **Spring WebFlux**: Non-blocking reactive web framework
- **Project Reactor**: Reactive streams for high-volume processing

### **Database & Caching**
- **PostgreSQL**: Primary database with JSONB support and partitioning
- **Redis**: Caching for market data and calculations
- **R2DBC**: Reactive database connectivity

### **Messaging & Events**
- **Apache Kafka**: Event streaming for cashflow events
- **Spring Cloud Stream**: Stream processing framework
- **Event Sourcing**: Complete audit trail maintenance

### **Monitoring & Observability**
- **Spring Boot Actuator**: Health checks and metrics
- **Prometheus**: Metrics collection and storage
- **Grafana**: Dashboards and visualization
- **ELK Stack**: Logging and analysis

## Performance Characteristics

### **Throughput**
- **Target**: 50,000+ cashflows per minute
- **Concurrency**: 100,000+ virtual threads with partitioning
- **Response Time**: <100ms API response time
- **Availability**: 99.9% uptime target

### **Scalability**
- **Horizontal Scaling**: Multiple service instances
- **Partition Distribution**: Load balancing across partitions
- **Resource Efficiency**: Virtual threads with minimal memory overhead
- **Backpressure Handling**: Automatic flow control for varying load

## Key Architectural Features

### **1. Thread Partitioning Strategy**
- **Partition Key**: `ContractId + SecurityId (Underlier) + CalculationType`
- **Thread Isolation**: All operations for the same partition run in the same thread
- **Data Consistency**: Prevents race conditions and ensures ACID operations within partitions
- **Scalability**: Easy horizontal scaling across multiple service instances

### **2. Reactive Processing**
- **Project Reactor**: High-volume stream processing with backpressure handling
- **Spring WebFlux**: Non-blocking reactive web framework
- **R2DBC**: Reactive database connectivity
- **Event Streaming**: Real-time cashflow updates and notifications

### **3. Calculation Type Separation**
- **Interest Calculations**: Daily accruals with rate management (daily processing)
- **Equity Calculations**: P&L and dividend processing (market-driven)
- **Independent Processing**: No interference between calculation types
- **Different Frequencies**: Batch vs. event-driven processing

## Getting Started

### **Prerequisites**
- Java 21+
- Spring Boot 3.3+
- PostgreSQL 14+
- Redis 6+
- Apache Kafka 3+

### **Quick Start**
1. Review [System Architecture](architecture/system-architecture.md)
2. Understand [Thread Partitioning Strategy](architecture/thread-partitioning.md)
3. Explore [Reactive Architecture](architecture/reactive-architecture.md)
4. Review [Data Flow Diagrams](architecture/data-flow-diagrams.md)
5. Study [Domain Models](data/domain-models.md)

### **Development Setup**
1. Clone the repository
2. Install dependencies: `mvn clean install`
3. Configure database and messaging
4. Run the service: `mvn spring-boot:run`

## Architecture Highlights

### **1. High-Performance Design**
- **Virtual Threads**: Java 21 virtual threads for high-throughput processing
- **Partition-Based Isolation**: Thread partitioning prevents race conditions
- **Reactive Streams**: Non-blocking I/O with automatic backpressure handling
- **Optimized Database**: PostgreSQL with proper indexing and partitioning

### **2. Scalability Features**
- **Horizontal Scaling**: Multiple service instances with load balancing
- **Partition Distribution**: Spread partitions across instances
- **Resource Efficiency**: Minimal memory overhead with virtual threads
- **Auto-scaling**: Kubernetes-based auto-scaling capabilities

### **3. Fault Tolerance**
- **Circuit Breakers**: Automatic failure detection and recovery
- **Retry Mechanisms**: Exponential backoff for transient failures
- **Graceful Degradation**: Service continues with reduced functionality
- **Health Monitoring**: Comprehensive health checks and alerting

## Contributing

### **Architecture Changes**
- Update relevant architectural documents
- Review impact on thread partitioning strategy
- Validate performance implications
- Update API specifications if needed

### **Code Changes**
- Follow established patterns for thread partitioning
- Maintain reactive programming principles
- Ensure proper error handling and recovery
- Update tests and documentation

## Support & Maintenance

### **Documentation Updates**
- Keep architectural documents current with implementation
- Update performance benchmarks regularly
- Maintain API documentation accuracy
- Document any configuration changes

### **Performance Monitoring**
- Track key metrics: throughput, response time, error rates
- Monitor thread partition utilization
- Alert on performance degradation
- Regular capacity planning reviews

---

**Last Updated**: January 2024  
**Version**: 1.0.0  
**Architecture Owner**: Equity Swaps Development Team

**Status**: 🟢 **Core Architecture Complete** - Ready for implementation
