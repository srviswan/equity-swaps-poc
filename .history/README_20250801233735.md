# Trade Capture Service

A microservice for processing raw equity cash trades from Solace queue, validating, enriching with reference data, applying economic and non-economic rules, and generating fully developed contracts for the instruction service.

## 🏗️ Architecture

### Overview
The Trade Capture Service is designed as a robust, fault-tolerant microservice that processes raw trade messages from upstream systems via Solace queue and transforms them into enriched contracts ready for the instruction service.

### Key Components

#### 1. **Message Processing Pipeline**
- **Solace JMS Integration**: Receives raw trade messages from Solace queue
- **Spring Integration**: Orchestrates message flow through processing pipeline
- **Fault Tolerance**: Circuit breaker, retry logic, and graceful degradation

#### 2. **Processing Services**
- **TradeValidationService**: Validates raw trades for data quality and business rules
- **ReferenceDataEnrichmentService**: Enriches trades with book, product, counterparty data
- **EconomicRulesEnrichmentService**: Applies pricing, risk metrics, and economic calculations
- **NonEconomicRulesEnrichmentService**: Applies compliance, regulatory, and operational rules
- **ContractGenerationService**: Generates final enriched contracts

#### 3. **Data Models**
- **RawTrade**: Represents raw trade data from upstream systems
- **EnrichedContract**: Represents fully developed contract for instruction service

## 🚀 Features

### Core Functionality
- ✅ **Raw Trade Processing**: Receives and processes raw equity cash trades
- ✅ **Data Validation**: Comprehensive validation of trade data
- ✅ **Reference Data Enrichment**: Enriches with book, product, counterparty information
- ✅ **Economic Rules**: Applies pricing, risk metrics, and economic calculations
- ✅ **Non-Economic Rules**: Applies compliance, regulatory, and operational rules
- ✅ **Contract Generation**: Creates fully developed contracts
- ✅ **Instruction Service Integration**: Sends contracts to instruction service

### Technical Features
- ✅ **Fault Tolerance**: Circuit breaker, retry logic, timeout handling
- ✅ **Caching**: Reference data caching for performance
- ✅ **Monitoring**: Health checks, metrics, and observability
- ✅ **Validation**: Bean validation and business rule validation
- ✅ **Async Processing**: Non-blocking message processing
- ✅ **Configuration**: Externalized configuration management

## 📋 Prerequisites

- Java 11+
- Maven 3.6+
- Solace Message Broker (for production)
- H2 Database (for development)

## 🛠️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd trade-capture-service
```

### 2. Build the Application
```bash
mvn clean install
```

### 3. Configure Environment Variables
```bash
# Solace Configuration
export SOLACE_HOST=localhost
export SOLACE_PORT=55555
export SOLACE_USERNAME=default
export SOLACE_PASSWORD=default
export SOLACE_VPN=default
export SOLACE_QUEUE_NAME=raw-trades-queue

# Instruction Service Configuration
export INSTRUCTION_SERVICE_URL=http://localhost:8081

# Environment
export ENVIRONMENT=development
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

## 🔧 Configuration

### Application Properties
The service is configured via `application.yml` with the following key sections:

#### Solace Configuration
```yaml
solace:
  host: ${SOLACE_HOST:localhost}
  port: ${SOLACE_PORT:55555}
  username: ${SOLACE_USERNAME:default}
  password: ${SOLACE_PASSWORD:default}
  vpn: ${SOLACE_VPN:default}
  queue:
    name: ${SOLACE_QUEUE_NAME:raw-trades-queue}
```

#### Processing Configuration
```yaml
trade:
  capture:
    processing:
      batch-size: 100
      max-threads: 10
      timeout: 30000
      retry-attempts: 3
    validation:
      enabled: true
      strict-mode: false
    enrichment:
      reference-data:
        enabled: true
        cache-enabled: true
      economic-rules:
        enabled: true
      non-economic-rules:
        enabled: true
```

## 📡 API Endpoints

### Health Check
```http
GET /trade-capture-service/api/v1/trade-capture/health
```

### Manual Trade Processing
```http
POST /trade-capture-service/api/v1/trade-capture/process
Content-Type: application/json

{
  "tradeId": "TRADE_001",
  "instrumentId": "AAPL",
  "counterpartyId": "BANK_A",
  "traderId": "TRADER_001",
  "side": "BUY",
  "quantity": 100,
  "price": 150.50,
  "currency": "USD",
  "tradeDate": "2024-01-15",
  "settlementDate": "2024-01-17"
}
```

### Service Information
```http
GET /trade-capture-service/api/v1/trade-capture/info
```

### Processing Statistics
```http
GET /trade-capture-service/api/v1/trade-capture/stats
```

### Sample Trade
```http
GET /trade-capture-service/api/v1/trade-capture/sample-trade
```

## 🔄 Processing Pipeline

### 1. Message Reception
- Raw trade messages received from Solace queue
- Messages validated for format and completeness
- Correlation IDs assigned for tracking

### 2. Trade Validation
- Bean validation using JSR-303 annotations
- Business rule validation (dates, quantities, prices)
- Cross-field validation (notional amounts)
- Currency and instrument validation

### 3. Reference Data Enrichment
- **Instrument Data**: Name, type, ISIN, currency
- **Counterparty Data**: Name, type, country
- **Book Data**: Name, type, desk
- **Trader Data**: Name, desk, location

### 4. Economic Rules Application
- **Pricing Rules**: Mid price, spread, price impact, fair value
- **Risk Metrics**: VaR, position size, concentration risk, liquidity risk
- **P&L Calculations**: Unrealized P&L, realized P&L, total P&L
- **Cost Calculations**: Commission, fees, transaction costs
- **Market Value**: Current market value, market value change

### 5. Non-Economic Rules Application
- **Compliance Rules**: Insider trading, market abuse, conflicts of interest
- **Regulatory Rules**: MiFID II, EMIR, Dodd-Frank, Basel III
- **Operational Rules**: Settlement instructions, custody arrangements
- **Business Rules**: Client suitability, product suitability, trading authorization
- **Validation Rules**: Data quality, business logic, cross-field validation

### 6. Contract Generation
- Final contract validation and completeness checks
- Metadata generation and processing status updates
- Final business rules application
- Contract readiness verification

### 7. Instruction Service Integration
- HTTP POST to instruction service
- Retry logic with exponential backoff
- Health check integration
- Error handling and logging

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn test -Dtest=*IntegrationTest
```

### Manual Testing
```bash
# Get sample trade
curl -X GET http://localhost:8083/trade-capture-service/api/v1/trade-capture/sample-trade

# Process trade manually
curl -X POST http://localhost:8083/trade-capture-service/api/v1/trade-capture/process \
  -H "Content-Type: application/json" \
  -d @sample-trade.json
```

## 📊 Monitoring

### Health Checks
- Application health: `/actuator/health`
- JMS health: `/actuator/health/jms`
- Database health: `/actuator/health/db`

### Metrics
- Prometheus metrics: `/actuator/prometheus`
- Application metrics: `/actuator/metrics`

### Logging
- Structured logging with correlation IDs
- Performance metrics and processing times
- Error tracking and alerting

## 🔒 Security

### Authentication
- Solace authentication via username/password
- SSL/TLS support for secure connections

### Authorization
- Role-based access control (RBAC)
- API key authentication for REST endpoints

### Data Protection
- Sensitive data encryption
- Audit logging for compliance
- Data retention policies

## 🚀 Deployment

### Docker
```dockerfile
FROM openjdk:11-jre-slim
COPY target/trade-capture-service-1.0.0.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Kubernetes
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: trade-capture-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: trade-capture-service
  template:
    metadata:
      labels:
        app: trade-capture-service
    spec:
      containers:
      - name: trade-capture-service
        image: trade-capture-service:1.0.0
        ports:
        - containerPort: 8083
        env:
        - name: SOLACE_HOST
          valueFrom:
            configMapKeyRef:
              name: trade-capture-config
              key: solace.host
```

## 🔧 Troubleshooting

### Common Issues

#### 1. Solace Connection Issues
- Verify Solace broker is running and accessible
- Check VPN, username, and password configuration
- Ensure queue exists and is properly configured

#### 2. Instruction Service Connection Issues
- Verify instruction service is running on configured URL
- Check network connectivity and firewall rules
- Review instruction service logs for errors

#### 3. Processing Failures
- Check application logs for validation errors
- Verify reference data services are available
- Review business rule configurations

### Log Analysis
```bash
# View application logs
tail -f logs/trade-capture-service.log

# Search for errors
grep "ERROR" logs/trade-capture-service.log

# Search for specific trade
grep "TRADE_001" logs/trade-capture-service.log
```

## 📈 Performance

### Optimization Tips
- Enable reference data caching
- Configure appropriate thread pool sizes
- Monitor and tune JVM parameters
- Use connection pooling for external services

### Scaling
- Horizontal scaling with multiple instances
- Load balancing across instances
- Database connection pooling
- Message queue partitioning

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation wiki

---

**Version**: 1.0.0  
**Last Updated**: January 2024  
**Maintainer**: Development Team 