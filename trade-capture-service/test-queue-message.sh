#!/bin/bash

echo "Starting Trade Capture Service with JMS..."
mvn spring-boot:run > service.log 2>&1 &
SERVICE_PID=$!

echo "Waiting for service to start..."
sleep 30

echo "Testing JMS Queue Message Sending..."

# Test 1: Send message via REST endpoint (if available)
echo "Test 1: Sending message via REST endpoint..."
curl -X POST http://localhost:8083/trade-capture-service/api/v1/trade-capture/send-to-queue \
  -H "Content-Type: application/json" \
  -d '{
    "tradeId": "QUEUE-TEST-001",
    "instrumentId": "MSFT",
    "counterpartyId": "TEST-COUNTERPARTY",
    "traderId": "TEST-TRADER",
    "side": "SELL",
    "quantity": 500,
    "price": 300.75,
    "currency": "USD",
    "tradeDate": "2025-08-01",
    "settlementDate": "2025-08-03",
    "bookId": "TEST-BOOK"
  }'

echo ""
echo "Test 2: Checking service logs for JMS activity..."
tail -f service.log &
LOG_PID=$!

echo "Service PID: $SERVICE_PID"
echo "Log PID: $LOG_PID"
echo "Press Ctrl+C to stop"

# Keep the script running
wait $SERVICE_PID 