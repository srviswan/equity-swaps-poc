# CDM Instruction Microservice Architecture

## 🏗️ **Architecture Overview**

This project implements a **microservice architecture** for handling CDM (Common Domain Model) primitive instructions. The architecture consists of two main microservices:

1. **Instruction Service** - Main orchestrator service
2. **Handler Service** - Specialized instruction processors

## 📊 **Architecture Diagram**

```
┌─────────────────────────────────────────────────────────────────┐
│                    Client Applications                        │
└─────────────────────┬─────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│              Instruction Service (Port: 8081)                 │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │              Instruction Controller                    │   │
│  │  • /api/v1/instructions/process                      │   │
│  │  • /api/v1/instructions/process/async                │   │
│  │  • /api/v1/instructions/process/timeout              │   │
│  │  • /api/v1/instructions/health                       │   │
│  │  • /api/v1/instructions/info                         │   │
│  └─────────────────────────────────────────────────────────┘   │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │            Instruction Processor Service               │   │
│  │  • Validates requests                                 │   │
│  │  • Routes to appropriate handlers                     │   │
│  │  • Manages timeouts and async processing              │   │
│  └─────────────────────────────────────────────────────────┘   │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │            Handler Service Client                     │   │
│  │  • Feign client for service communication             │   │
│  │  • Circuit breaker and fallback support              │   │
│  └─────────────────────────────────────────────────────────┘   │
└─────────────────────┬─────────────────────────────────────────┘
                      │
                      ▼
┌─────────────────────────────────────────────────────────────────┐
│              Handler Service (Port: 8082)                     │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │                Handler Controller                      │   │
│  │  • /api/v1/handlers/contract-formation               │   │
│  │  • /api/v1/handlers/execution                        │   │
│  │  • /api/v1/handlers/exercise                         │   │
│  │  • /api/v1/handlers/reset                            │   │
│  │  • /api/v1/handlers/party-change                     │   │
│  │  • /api/v1/handlers/split                            │   │
│  │  • /api/v1/handlers/quantity-change                  │   │
│  │  • /api/v1/handlers/terms-change                     │   │
│  │  • /api/v1/handlers/transfer                         │   │
│  │  • /api/v1/handlers/index-transition                 │   │
│  │  • /api/v1/handlers/stock-split                      │   │
│  │  • /api/v1/handlers/observation                      │   │
│  │  • /api/v1/handlers/valuation                        │   │
│  │  • /api/v1/handlers/health                           │   │
│  │  • /api/v1/handlers/info                             │   │
│  └─────────────────────────────────────────────────────────┘   │
│  ┌─────────────────────────────────────────────────────────┐   │
│  │                 Handler Service                       │   │
│  │  • Specialized instruction processors                 │   │
│  │  • CDM integration                                    │   │
│  │  • Business logic implementation                      │   │
│  └─────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────┘
```

## 🎯 **Service Responsibilities**

### **1. Instruction Service (Port: 8081)**

**Primary Responsibilities:**
- **Request Orchestration**: Receives instruction requests and routes them to appropriate handlers
- **Validation**: Validates instruction requests before processing
- **Service Discovery**: Uses Eureka for service discovery
- **Load Balancing**: Distributes requests across handler instances
- **Circuit Breaker**: Implements fallback mechanisms for handler failures
- **Async Processing**: Supports asynchronous instruction processing
- **Timeout Management**: Handles request timeouts gracefully

**Key Endpoints:**
```
POST /api/v1/instructions/process
POST /api/v1/instructions/process/async
POST /api/v1/instructions/process/timeout
GET  /api/v1/instructions/health
GET  /api/v1/instructions/info
GET  /api/v1/instructions/types
GET  /api/v1/instructions/priorities
```

### **2. Handler Service (Port: 8082)**

**Primary Responsibilities:**
- **Specialized Processing**: Handles specific instruction types
- **CDM Integration**: Processes CDM primitive instructions
- **Business Logic**: Implements domain-specific processing logic
- **State Management**: Manages instruction processing state
- **Error Handling**: Provides detailed error responses
- **Performance Monitoring**: Tracks processing metrics

**Supported Instruction Types:**
- **Contract Formation**: Contract creation and legal agreement handling
- **Execution**: Trade execution processing
- **Exercise**: Option exercise processing
- **Reset**: Rate reset processing
- **Party Change**: Party modification processing
- **Split**: Trade splitting and allocation
- **Quantity Change**: Quantity modification processing
- **Terms Change**: Contract terms modification
- **Transfer**: Ownership transfer processing
- **Index Transition**: Index transition processing
- **Stock Split**: Stock split processing
- **Observation**: Market observation processing
- **Valuation**: Valuation processing

## 🔄 **Request Flow**

### **1. Synchronous Processing Flow**

```
Client Request
     ↓
Instruction Service (Validation)
     ↓
Handler Service Client (Feign)
     ↓
Handler Service (Processing)
     ↓
CDM Processing
     ↓
Response
```

### **2. Asynchronous Processing Flow**

```
Client Request
     ↓
Instruction Service (Validation)
     ↓
Async Processing (CompletableFuture)
     ↓
Handler Service (Background Processing)
     ↓
Future Response
```

### **3. Timeout Processing Flow**

```
Client Request
     ↓
Instruction Service (Validation)
     ↓
Timeout Processing (with timeout)
     ↓
Handler Service (Processing)
     ↓
Timeout Response or Success
```

## 📋 **API Specifications**

### **Instruction Request Model**

```json
{
  "instructionId": "uuid-string",
  "instructionType": "EXECUTION",
  "instructionData": "{\"product\":\"...\",\"counterparty\":\"...\"}",
  "priority": "NORMAL",
  "sourceSystem": "TRADING_SYSTEM",
  "requestTimestamp": "2024-01-01T10:00:00",
  "correlationId": "correlation-uuid"
}
```

### **Instruction Response Model**

```json
{
  "instructionId": "uuid-string",
  "status": "SUCCESS",
  "result": "Processing result data",
  "errorMessage": null,
  "processingTime": 150,
  "handlerService": "EXECUTION_HANDLER",
  "responseTimestamp": "2024-01-01T10:00:01",
  "correlationId": "correlation-uuid",
  "validationErrors": null
}
```

## 🛠️ **Technology Stack**

### **Framework & Libraries**
- **Spring Boot 2.7.18**: Application framework
- **Spring Cloud 2021.0.8**: Microservice features
- **Spring Cloud OpenFeign**: Service communication
- **Spring Cloud Netflix Eureka**: Service discovery
- **Spring Boot Actuator**: Monitoring and metrics
- **Spring Boot Validation**: Request validation

### **CDM Integration**
- **CDM Java 7.0.0-dev.14**: Common Domain Model
- **Gson**: JSON processing
- **SLF4J**: Logging framework

### **Development Tools**
- **Maven**: Build and dependency management
- **Spring Boot Maven Plugin**: Application packaging
- **Prometheus**: Metrics collection

## 🚀 **Deployment Architecture**

### **Development Environment**
```
┌─────────────────┐    ┌─────────────────┐
│   Eureka Server │    │  Instruction    │
│   (Port: 8761)  │◄──►│   Service       │
└─────────────────┘    │  (Port: 8081)   │
                       └─────────────────┘
                                │
                                ▼
                       ┌─────────────────┐
                       │   Handler       │
                       │   Service       │
                       │  (Port: 8082)   │
                       └─────────────────┘
```

### **Production Environment**
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Load Balancer │    │  Instruction    │    │   Handler       │
│   (HAProxy/Nginx)│◄──►│   Service       │◄──►│   Service       │
│                 │    │  (Multiple      │    │  (Multiple      │
│                 │    │   Instances)    │    │   Instances)    │
└─────────────────┘    └─────────────────┘    └─────────────────┘
                                │                       │
                                ▼                       ▼
                       ┌─────────────────┐    ┌─────────────────┐
                       │   Eureka        │    │   Database      │
                       │   Server        │    │   (Optional)    │
                       │  (Multiple      │    │                 │
                       │   Instances)    │    │                 │
                       └─────────────────┘    └─────────────────┘
```

## 🔧 **Configuration**

### **Instruction Service Configuration**

```yaml
server:
  port: 8081

spring:
  application:
    name: synthetics-instruction-service
  
  cloud:
    openfeign:
      client:
        config:
          default:
            connectTimeout: 5000
            readTimeout: 10000

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

app:
  instruction:
    timeout:
      default: 30
      max: 300
    validation:
      enabled: true
```

### **Handler Service Configuration**

```yaml
server:
  port: 8082

spring:
  application:
    name: synthetics-handler-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/

app:
  handler:
    timeout:
      default: 30
      max: 300
    validation:
      enabled: true
```

## 📊 **Monitoring & Observability**

### **Health Checks**
- **Instruction Service**: `/api/v1/instructions/health`
- **Handler Service**: `/api/v1/handlers/health`

### **Metrics Endpoints**
- **Actuator Health**: `/actuator/health`
- **Application Info**: `/actuator/info`
- **Metrics**: `/actuator/metrics`
- **Prometheus**: `/actuator/prometheus`

### **Logging**
- **Structured Logging**: JSON format for production
- **Log Levels**: DEBUG for development, INFO for production
- **Correlation IDs**: Request tracing across services

## 🔒 **Security Considerations**

### **Authentication & Authorization**
- **JWT Tokens**: For service-to-service communication
- **API Keys**: For external client access
- **Role-based Access**: Different permissions for different instruction types

### **Data Protection**
- **Request Validation**: Input sanitization and validation
- **Error Handling**: Secure error messages (no sensitive data)
- **Audit Logging**: Complete request/response logging

## 🚀 **Getting Started**

### **1. Prerequisites**
```bash
# Java 8 or higher
java -version

# Maven 3.6 or higher
mvn -version

# Eureka Server (optional for development)
# Download and run Eureka Server
```

### **2. Build the Project**
```bash
# Build all modules
mvn clean install

# Build specific module
mvn clean install -pl synthetics-instruction-service
mvn clean install -pl synthetics-handler-service
```

### **3. Run the Services**
```bash
# Start Handler Service
cd synthetics-handler-service
mvn spring-boot:run

# Start Instruction Service (in new terminal)
cd synthetics-instruction-service
mvn spring-boot:run
```

### **4. Test the Services**
```bash
# Test Handler Service Health
curl http://localhost:8082/api/v1/handlers/health

# Test Instruction Service Health
curl http://localhost:8081/api/v1/instructions/health

# Test Instruction Processing
curl -X POST http://localhost:8081/api/v1/instructions/process \
  -H "Content-Type: application/json" \
  -d '{
    "instructionType": "EXECUTION",
    "instructionData": "{\"product\":\"EQUITY_SWAP\",\"counterparty\":\"BANK_A\"}",
    "priority": "NORMAL",
    "sourceSystem": "TRADING_SYSTEM"
  }'
```

## 🔮 **Future Enhancements**

### **1. Advanced Features**
- **Event Sourcing**: Complete audit trail of instruction processing
- **CQRS**: Separate read and write models for better performance
- **Saga Pattern**: Distributed transaction management
- **Event Streaming**: Kafka integration for real-time processing

### **2. Scalability Improvements**
- **Horizontal Scaling**: Multiple instances of each service
- **Database Sharding**: Distributed data storage
- **Caching**: Redis for frequently accessed data
- **CDN**: Content delivery for static resources

### **3. Advanced Monitoring**
- **Distributed Tracing**: Jaeger or Zipkin integration
- **Advanced Metrics**: Custom business metrics
- **Alerting**: Prometheus AlertManager integration
- **Dashboard**: Grafana dashboards for monitoring

### **4. Security Enhancements**
- **OAuth2**: Advanced authentication
- **API Gateway**: Kong or Zuul for API management
- **Rate Limiting**: Request throttling
- **Encryption**: End-to-end encryption

---

**Version**: 1.0.0  
**Last Updated**: 2024  
**Status**: ✅ Complete Microservice Architecture Documentation 