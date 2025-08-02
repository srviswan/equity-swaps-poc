# CDM Source Files Location Guide

## 📁 **CDM Source Files Available**

The CDM (Common Domain Model) source files have been extracted and are available in the following locations:

### **1. Local Extracted Sources**
- **Location**: `./cdm-sources/` (in your project directory)
- **Source**: Extracted from `cdm-java-6.0.0-sources.jar`
- **Size**: ~17MB of source files

### **2. Maven Repository Sources**
- **Location**: `~/.m2/repository/org/finos/cdm/cdm-java/`
- **Available Versions**:
  - `6.0.0/cdm-java-6.0.0-sources.jar` ✅ (Has source files)
  - `7.0.0-dev.14/cdm-java-7.0.0-dev.14.jar` ❌ (No source files)

## 🗂️ **CDM Source File Organization**

### **Core CDM Packages**

#### **1. Product Templates** (`cdm/product/template/`)
```
├── Product.java                    # Main product class
├── AssetLeg.java                   # Asset leg definitions
├── AssetPayout.java               # Asset payout structures
├── EconomicTerms.java             # Economic terms
├── Payout.java                    # Base payout class
├── SettlementPayout.java          # Settlement structures
├── TradeLot.java                  # Trade lot definitions
└── ... (80+ template files)
```

#### **2. Asset Classes** (`cdm/product/asset/`)
```
├── FloatingRate.java              # Floating rate definitions
├── FixedRateSpecification.java    # Fixed rate specifications
├── DividendReturnTerms.java       # Dividend handling
├── InterestRatePayout.java        # Interest rate structures
├── CommodityPayout.java           # Commodity structures
└── ... (100+ asset files)
```

#### **3. Legal Documentation** (`cdm/legaldocumentation/`)
```
├── master/
│   ├── EquitySwapMasterConfirmation2018.java
│   ├── EquityMasterConfirmation.java
│   ├── EquityCorporateEvents.java
│   └── EquityAdditionalTerms.java
├── contract/
│   ├── Agreement.java
│   └── ... (contract structures)
└── ... (legal framework)
```

#### **4. Observable Assets** (`cdm/observable/asset/`)
```
├── Index.java                     # Index definitions
├── Money.java                     # Money/currency structures
├── Price.java                     # Price structures
├── RateObservation.java           # Rate observations
└── ... (observable structures)
```

#### **5. Event Classes** (`cdm/event/`)
```
├── CreditEvents.java              # Credit event handling
├── Observation.java               # Event observations
├── Trigger.java                   # Event triggers
└── ... (event structures)
```

#### **6. Settlement Classes** (`cdm/product/common/settlement/`)
```
├── CashSettlementTerms.java       # Cash settlement
├── PhysicalSettlementTerms.java   # Physical settlement
├── PaymentDates.java              # Payment scheduling
└── ... (settlement structures)
```

## 🔍 **Key Equity Swap Related Files**

### **Equity Swap Specific Classes**
- `cdm/legaldocumentation/master/EquitySwapMasterConfirmation2018.java`
- `cdm/legaldocumentation/master/EquityMasterConfirmation.java`
- `cdm/product/template/AssetLeg.java` (for equity legs)
- `cdm/product/asset/DividendReturnTerms.java` (for dividend handling)

### **Trade and Position Classes**
- `cdm/product/template/TradeLot.java`
- `cdm/product/template/TradableProduct.java`
- `cdm/product/template/Product.java`

## 📋 **How to Access CDM Source Files**

### **Method 1: Browse Local Extracted Files**
```bash
# Navigate to extracted sources
cd cdm-sources/

# Find equity swap related files
find . -name "*.java" | grep -i "equity\|swap"

# View specific file
cat cdm/legaldocumentation/master/EquitySwapMasterConfirmation2018.java
```

### **Method 2: Extract from Maven JAR**
```bash
# Extract sources from Maven repository
jar -xf ~/.m2/repository/org/finos/cdm/cdm-java/6.0.0/cdm-java-6.0.0-sources.jar

# Browse extracted files
ls -la cdm/
```

### **Method 3: IDE Integration**
- **IntelliJ IDEA**: Sources are automatically attached when using Maven
- **Eclipse**: Sources are available through Maven dependency
- **VS Code**: Can browse JAR contents directly

## 🚀 **Using CDM Classes in Your Code**

### **Example: Equity Swap Structure**
```java
import cdm.product.template.Product;
import cdm.product.template.AssetLeg;
import cdm.product.asset.DividendReturnTerms;
import cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018;

// Create equity swap product
Product equitySwap = Product.builder()
    .setAssetLeg(AssetLeg.builder()
        .setDividendReturnTerms(DividendReturnTerms.builder()
            .build())
        .build())
    .build();
```

## 📚 **Additional Resources**

### **Generated Files Available**
- **JSON Schemas**: `cdm-sources/*.schema.json` (1000+ schema files)
- **Rosetta Models**: `cdm-sources/*.rosetta` (Model definitions)
- **Multi-language**: C#, Kotlin, Scala, TypeScript generated files

### **Documentation**
- **CDM Website**: https://www.cdm.rosetta-technology.io/
- **GitHub Repository**: https://github.com/finos/common-domain-model
- **Maven Central**: https://central.sonatype.com/artifact/org.finos.cdm/cdm-java

## ⚠️ **Important Notes**

1. **Version Differences**: 
   - Version 6.0.0 has source files available
   - Version 7.0.0-dev.14 only has compiled classes

2. **Source Availability**: 
   - Always use the `-sources.jar` for source code
   - Regular `.jar` files contain only compiled classes

3. **IDE Integration**: 
   - Most IDEs will automatically download sources when using Maven
   - Sources are cached in `~/.m2/repository/`

## 🎯 **Next Steps**

1. **Explore the extracted sources** in `./cdm-sources/`
2. **Use CDM classes** in your equity swaps implementation
3. **Reference the JSON schemas** for data validation
4. **Check the Rosetta model files** for understanding the domain model

The CDM source files provide a comprehensive foundation for building equity swap applications with standardized financial instrument definitions. 