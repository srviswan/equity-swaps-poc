# 📊 Grafana Dashboard Configuration Guide

## 🚀 Quick Setup

### 1. Access Grafana
- **URL**: http://localhost:3000
- **Username**: `admin`
- **Password**: `admin`

### 2. Auto-Configured Components
✅ **Prometheus Data Source**: Automatically configured  
✅ **Pre-built Dashboards**: 2 dashboards ready to use  
✅ **Metrics Collection**: Active from cashflow service  

## 📈 Available Dashboards

### 1. Cashflow Generation Service Dashboard
**Focus**: Core application metrics
- **HTTP Request Rate**: Requests per second by endpoint
- **JVM Heap Memory Usage**: Memory utilization gauge
- **HTTP Request Latency**: 95th and 50th percentile response times
- **JVM Thread Count**: Active thread monitoring
- **Garbage Collection Activity**: GC pause frequency

### 2. Actor System & Thread Partitioning Dashboard
**Focus**: Architecture-specific metrics
- **Actor System Status**: System health indicator
- **Active Thread Partitions**: Partitioning efficiency
- **Cashflow Generation Request Rate**: Processing throughput
- **Cashflow Generation Duration**: Performance timings
- **Actor Mailbox Sizes**: Message queue monitoring

## 🔧 Available Metrics

### Spring Boot Actuator Metrics
```
# HTTP Metrics
http_server_requests_seconds_count
http_server_requests_seconds_bucket
http_server_requests_seconds_sum

# JVM Metrics
jvm_memory_used_bytes
jvm_memory_max_bytes
jvm_threads_live_threads
jvm_gc_pause_seconds_count

# Application Metrics
up{job="cashflow-service"}
```

### Custom Business Metrics (Planned)
```
# Cashflow Processing
cashflow_generation_requests_total
cashflow_generation_duration_seconds
thread_partitioning_active_partitions
actor_mailbox_size

# Business Logic
cashflow_amount_generated_total
contract_processing_duration_seconds
```

## 🛠️ Manual Configuration Steps

### 1. Data Source Configuration (If Not Auto-Configured)
1. Go to **Configuration** → **Data Sources**
2. Click **Add data source**
3. Select **Prometheus**
4. Set URL: `http://prometheus:9090`
5. Click **Save & Test**

### 2. Import Additional Dashboards
1. Go to **+ Create** → **Import**
2. Use ID: `4701` for JVM (Micrometer) dashboard
3. Use ID: `6756` for Spring Boot 2.1 Statistics dashboard
4. Select **Prometheus** as data source

### 3. Custom Dashboard Creation
1. **+ Create** → **Dashboard**
2. **Add Query**
3. Use PromQL expressions from metrics list above

## 🎯 Key PromQL Queries

### Application Performance
```promql
# Request rate
rate(http_server_requests_seconds_count{job="cashflow-service"}[5m])

# Response time 95th percentile
histogram_quantile(0.95, rate(http_server_requests_seconds_bucket{job="cashflow-service"}[5m]))

# Memory usage percentage
jvm_memory_used_bytes{area="heap"} / jvm_memory_max_bytes{area="heap"} * 100
```

### Business Metrics
```promql
# Cashflow generation rate
rate(cashflow_generation_requests_total[5m])

# Average processing duration
rate(cashflow_generation_duration_seconds_sum[5m]) / rate(cashflow_generation_duration_seconds_count[5m])

# Active partitions
thread_partitioning_active_partitions
```

## 🚨 Alerting (Advanced)

### Critical Alerts
- **Memory Usage > 85%**: `jvm_memory_used_bytes / jvm_memory_max_bytes * 100 > 85`
- **Response Time > 1s**: `histogram_quantile(0.95, rate(http_server_requests_seconds_bucket[5m])) > 1`
- **Error Rate > 5%**: `rate(http_server_requests_seconds_count{status=~"5.."}[5m]) / rate(http_server_requests_seconds_count[5m]) > 0.05`

### Business Alerts
- **Low Processing Rate**: `rate(cashflow_generation_requests_total[5m]) < 1`
- **High Processing Duration**: `cashflow_generation_duration_seconds > 10`

## 🔗 Quick Links
- **Grafana**: http://localhost:3000
- **Prometheus**: http://localhost:9090
- **Cashflow Service**: http://localhost:8080
- **Health Check**: http://localhost:8080/health
- **Metrics Endpoint**: http://localhost:8081/actuator/prometheus

## 🏷️ Dashboard Tags
- `cashflow` - Core cashflow processing metrics
- `spring-boot` - Spring Boot application metrics
- `monitoring` - General monitoring dashboards
- `actor-system` - Actor pattern specific metrics
- `thread-partitioning` - Thread management metrics
