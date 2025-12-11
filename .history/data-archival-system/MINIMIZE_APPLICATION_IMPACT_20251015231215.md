# 🛡️ Minimizing Application Impact When Adding archival_flag Column

## 🎯 **Strategy Overview**

Adding `archival_flag` to production tables requires a **phased approach** to minimize application impact. Here's a comprehensive strategy:

## 📋 **Phase 1: Pre-Implementation Planning**

### **1.1 Application Impact Assessment**
```sql
-- Identify all applications accessing the table
SELECT 
    OBJECT_NAME(object_id) as table_name,
    COUNT(*) as access_count
FROM sys.dm_exec_cached_plans cp
CROSS APPLY sys.dm_exec_sql_text(cp.plan_handle) st
WHERE st.text LIKE '%Position%' -- Replace with your table name
GROUP BY OBJECT_NAME(object_id);
```

### **1.2 Schema Change Impact Analysis**
```sql
-- Check current table structure
SELECT 
    COLUMN_NAME,
    DATA_TYPE,
    IS_NULLABLE,
    COLUMN_DEFAULT
FROM INFORMATION_SCHEMA.COLUMNS 
WHERE TABLE_NAME = 'Position' 
ORDER BY ORDINAL_POSITION;
```

## 🔧 **Phase 2: Column Addition Strategy**

### **2.1 Option A: Add Column with Default (Recommended)**
```sql
-- Add column with default value - minimal impact
ALTER TABLE dbo.Position 
ADD archival_flag BIT NOT NULL DEFAULT 0;

-- Create index for performance
CREATE INDEX IX_Position_ArchivalFlag 
ON dbo.Position(archival_flag) 
INCLUDE (basketId, positionId, businessDate);
```

**Benefits:**
- ✅ **No application changes required** initially
- ✅ **Existing queries continue to work**
- ✅ **Default value handles new records**
- ✅ **Minimal performance impact**

### **2.2 Option B: Add Column as NULLABLE First**
```sql
-- Add as nullable first, then make NOT NULL
ALTER TABLE dbo.Position 
ADD archival_flag BIT NULL;

-- Update existing records
UPDATE dbo.Position 
SET archival_flag = 0 
WHERE archival_flag IS NULL;

-- Make NOT NULL
ALTER TABLE dbo.Position 
ALTER COLUMN archival_flag BIT NOT NULL;
```

## 🚀 **Phase 3: Application Layer Adaptation**

### **3.1 Backward Compatibility Strategy**

#### **A. Application Code Changes (Gradual)**
```java
// Before: Original entity
public class Position {
    private UUID basketId;
    private Long positionId;
    private LocalDate businessDate;
    private UUID contractId;
    private BigDecimal quantity;
    private BigDecimal price;
    // No archival_flag yet
}

// After: Updated entity with backward compatibility
public class Position {
    private UUID basketId;
    private Long positionId;
    private LocalDate businessDate;
    private UUID contractId;
    private BigDecimal quantity;
    private BigDecimal price;
    
    // New field with default value
    private Boolean archivalFlag = false; // Default to false
    
    // Backward compatibility methods
    public Boolean getArchivalFlag() {
        return archivalFlag != null ? archivalFlag : false;
    }
    
    public void setArchivalFlag(Boolean archivalFlag) {
        this.archivalFlag = archivalFlag != null ? archivalFlag : false;
    }
}
```

#### **B. Database Access Layer Changes**
```java
// Before: Original query
@Query("SELECT p FROM Position p WHERE p.contractId = :contractId")
List<Position> findByContractId(@Param("contractId") UUID contractId);

// After: Updated query (backward compatible)
@Query("SELECT p FROM Position p WHERE p.contractId = :contractId AND (p.archivalFlag = false OR p.archivalFlag IS NULL)")
List<Position> findActiveByContractId(@Param("contractId") UUID contractId);

// New query for archival operations
@Query("SELECT p FROM Position p WHERE p.archivalFlag = true")
List<Position> findArchivalEligible();
```

### **3.2 API Layer Changes**

#### **A. REST API Backward Compatibility**
```java
// Before: Original API
@GetMapping("/positions/{contractId}")
public ResponseEntity<List<Position>> getPositions(@PathVariable UUID contractId) {
    List<Position> positions = positionService.findByContractId(contractId);
    return ResponseEntity.ok(positions);
}

// After: Updated API with backward compatibility
@GetMapping("/positions/{contractId}")
public ResponseEntity<List<Position>> getPositions(@PathVariable UUID contractId) {
    // Only return non-archived positions by default
    List<Position> positions = positionService.findActiveByContractId(contractId);
    return ResponseEntity.ok(positions);
}

// New API for archival operations
@GetMapping("/positions/{contractId}/all")
public ResponseEntity<List<Position>> getAllPositions(@PathVariable UUID contractId) {
    List<Position> positions = positionService.findByContractId(contractId);
    return ResponseEntity.ok(positions);
}
```

#### **B. DTO Layer Changes**
```java
// Before: Original DTO
public class PositionDTO {
    private UUID basketId;
    private Long positionId;
    private LocalDate businessDate;
    private UUID contractId;
    private BigDecimal quantity;
    private BigDecimal price;
}

// After: Updated DTO with optional field
public class PositionDTO {
    private UUID basketId;
    private Long positionId;
    private LocalDate businessDate;
    private UUID contractId;
    private BigDecimal quantity;
    private BigDecimal price;
    
    // Optional field - only included when needed
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean archivalFlag;
}
```

## 🔄 **Phase 4: Gradual Migration Strategy**

### **4.1 Feature Flags Approach**
```java
@Service
public class PositionService {
    
    @Value("${archival.flag.enabled:false}")
    private boolean archivalFlagEnabled;
    
    public List<Position> findByContractId(UUID contractId) {
        if (archivalFlagEnabled) {
            return positionRepository.findActiveByContractId(contractId);
        } else {
            return positionRepository.findByContractId(contractId);
        }
    }
}
```

### **4.2 Configuration-Based Approach**
```yaml
# application.yml
archival:
  flag:
    enabled: false  # Start with false
    include-archived: false  # Don't include archived by default
```

## 📊 **Phase 5: Performance Optimization**

### **5.1 Index Strategy**
```sql
-- Create covering index for archival queries
CREATE INDEX IX_Position_ArchivalFlag_Covering 
ON dbo.Position(archival_flag) 
INCLUDE (basketId, positionId, businessDate, contractId, quantity, price);

-- Create filtered index for active records
CREATE INDEX IX_Position_Active 
ON dbo.Position(contractId, businessDate) 
WHERE archival_flag = 0;
```

### **5.2 Query Optimization**
```sql
-- Before: Full table scan
SELECT * FROM dbo.Position WHERE contractId = @contractId;

-- After: Indexed query
SELECT * FROM dbo.Position 
WHERE contractId = @contractId 
AND archival_flag = 0;
```

## 🛡️ **Phase 6: Risk Mitigation**

### **6.1 Rollback Strategy**
```sql
-- Rollback plan: Remove column if needed
-- Step 1: Remove index
DROP INDEX IX_Position_ArchivalFlag ON dbo.Position;

-- Step 2: Remove column
ALTER TABLE dbo.Position DROP COLUMN archival_flag;
```

### **6.2 Monitoring and Validation**
```sql
-- Monitor column usage
SELECT 
    OBJECT_NAME(object_id) as table_name,
    COUNT(*) as query_count
FROM sys.dm_exec_cached_plans cp
CROSS APPLY sys.dm_exec_sql_text(cp.plan_handle) st
WHERE st.text LIKE '%archival_flag%'
GROUP BY OBJECT_NAME(object_id);
```

## 🎯 **Implementation Timeline**

### **Week 1: Planning**
- [ ] Impact assessment
- [ ] Application inventory
- [ ] Rollback plan

### **Week 2: Column Addition**
- [ ] Add column with default
- [ ] Create indexes
- [ ] Validate performance

### **Week 3: Application Updates**
- [ ] Update entity classes
- [ ] Update repository queries
- [ ] Update API endpoints

### **Week 4: Testing & Validation**
- [ ] Integration testing
- [ ] Performance testing
- [ ] User acceptance testing

### **Week 5: Production Deployment**
- [ ] Deploy application changes
- [ ] Monitor performance
- [ ] Validate functionality

## 🔧 **Best Practices**

### **1. Default Values**
```sql
-- Always use explicit default values
ALTER TABLE dbo.Position 
ADD archival_flag BIT NOT NULL DEFAULT 0;
```

### **2. Index Strategy**
```sql
-- Create indexes immediately after column addition
CREATE INDEX IX_Position_ArchivalFlag 
ON dbo.Position(archival_flag);
```

### **3. Application Compatibility**
```java
// Use default values in application code
private Boolean archivalFlag = false; // Default to false
```

### **4. API Versioning**
```java
// Use API versioning for backward compatibility
@GetMapping("/v1/positions/{contractId}")
public ResponseEntity<List<Position>> getPositionsV1(@PathVariable UUID contractId) {
    // Original behavior
}

@GetMapping("/v2/positions/{contractId}")
public ResponseEntity<List<Position>> getPositionsV2(@PathVariable UUID contractId) {
    // New behavior with archival_flag
}
```

## 🎉 **Success Criteria**

- ✅ **Zero downtime** during column addition
- ✅ **No application failures** during migration
- ✅ **Performance maintained** or improved
- ✅ **Backward compatibility** preserved
- ✅ **Rollback capability** maintained

## 📋 **Checklist**

- [ ] Impact assessment completed
- [ ] Rollback plan documented
- [ ] Application changes tested
- [ ] Performance benchmarks established
- [ ] Monitoring in place
- [ ] Team training completed
- [ ] Go-live plan approved

This strategy ensures **minimal application impact** while adding the `archival_flag` column to your production tables.
