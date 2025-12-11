#!/bin/bash

echo "Starting Trade Capture Service..."
mvn spring-boot:run > service.log 2>&1 &
SERVICE_PID=$!

echo "Waiting for service to start..."
sleep 30

echo "Sending test message to queue via REST API..."
curl -X POST http://localhost:8083/trade-capture-service/api/v1/trade-capture/process \
  -H "Content-Type: application/json" \
  -d '{
    "tradeId": "TEST-TRADE-001",
    "symbol": "AAPL",
    "side": "BUY",
    "quantity": 1000,
    "price": 150.50,
    "currency": "USD",
    "tradeDate": "2025-08-01",
    "settlementDate": "2025-08-03",
    "counterparty": "TEST-COUNTERPARTY",
    "trader": "TEST-TRADER",
    "book": "TEST-BOOK"
  }'

echo ""
echo "Test message sent. Checking service logs..."
echo "Service PID: $SERVICE_PID"
echo "Press Ctrl+C to stop the service"

# Keep the script running to maintain the service
wait $SERVICE_PID 