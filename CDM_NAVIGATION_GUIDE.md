# CDM Source Navigation Guide

## ✅ **Setup Complete**

The CDM source files have been successfully added to your classpath and are now available for navigation in your IDE.

## 📁 **Available CDM Sources**

### **1. Local Extracted Sources**
- **Location**: `./cdm-sources/` (in your project directory)
- **Content**: 1000+ Java classes, JSON schemas, and Rosetta model files
- **Size**: ~17MB of source files

### **2. Maven Dependencies**
- **CDM Java**: `org.finos.cdm:cdm-java:7.0.0-dev.14`
- **GSON**: `com.google.code.gson:gson:2.10.1`
- **SLF4J**: `org.slf4j:slf4j-api:1.7.36`

## 🔍 **How to Navigate CDM Sources**

### **Method 1: IDE Navigation (Recommended)**

#### **VS Code**
1. **Open the project** in VS Code
2. **Browse files** in the file explorer:
   - `cdm-sources/cdm/product/template/` - Product templates
   - `cdm-sources/cdm/legaldocumentation/master/` - Legal documentation
   - `cdm-sources/cdm/product/asset/` - Asset classes
   - `cdm-sources/cdm/product/common/settlement/` - Settlement classes

3. **Use Go to Definition** (F12) on CDM classes in your code
4. **Use Find All References** (Shift+F12) to see usage

#### **IntelliJ IDEA**
1. **Import as Maven project**
2. **Navigate to CDM classes** using Ctrl+N (Go to Class)
3. **Browse sources** in the Project view
4. **Use Ctrl+Click** to navigate to definitions

#### **Eclipse**
1. **Import as Maven project**
2. **Browse Package Explorer** for CDM classes
3. **Use F3** to go to definition
4. **Use Ctrl+Shift+G** to find references

### **Method 2: Command Line Navigation**

#### **Use the Navigation Script**
```bash
# Run the interactive navigation script
./navigate-cdm.sh
```

#### **Direct File Exploration**
```bash
# Find equity swap related files
find cdm-sources -name "*.java" | grep -i "equity\|swap"

# List all product template classes
find cdm-sources/cdm/product/template -name "*.java"

# View specific file
head -30 cdm-sources/cdm/product/template/Product.java
```

## 🏗️ **Key CDM Classes for Equity Swaps**

### **Product Templates**
- `cdm/product/template/Product.java` - Main product class
- `cdm/product/template/AssetLeg.java` - Asset leg definitions
- `cdm/product/template/TradeLot.java` - Trade lot definitions
- `cdm/product/template/EconomicTerms.java` - Economic terms

### **Legal Documentation**
- `cdm/legaldocumentation/master/EquitySwapMasterConfirmation2018.java`
- `cdm/legaldocumentation/master/EquityMasterConfirmation.java`
- `cdm/legaldocumentation/master/EquityCorporateEvents.java`

### **Asset Classes**
- `cdm/product/asset/DividendReturnTerms.java` - Dividend handling
- `cdm/product/asset/FloatingRate.java` - Floating rate definitions
- `cdm/product/asset/FixedRateSpecification.java` - Fixed rate specs

### **Settlement Classes**
- `cdm/product/common/settlement/CashSettlementTerms.java`
- `cdm/product/common/settlement/PaymentDates.java`
- `cdm/product/common/settlement/SettlementTerms.java`

## 💻 **Using CDM Classes in Your Code**

### **Example: Import CDM Classes**
```java
import cdm.product.template.Product;
import cdm.product.template.AssetLeg;
import cdm.product.asset.DividendReturnTerms;
import cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018;
```

### **Example: Create Equity Swap Structure**
```java
// Create equity swap product
Product equitySwap = Product.builder()
    .setAssetLeg(AssetLeg.builder()
        .setDividendReturnTerms(DividendReturnTerms.builder()
            .build())
        .build())
    .build();
```

## 🔧 **IDE Configuration**

### **VS Code Settings** (`.vscode/settings.json`)
```json
{
    "java.project.sourcePaths": [
        "synthetics-common/src/main/java",
        "synthetics-position-service/src/main/java",
        "cdm-sources"
    ],
    "java.project.referencedLibraries": [
        "~/.m2/repository/org/finos/cdm/cdm-java/7.0.0-dev.14/cdm-java-7.0.0-dev.14.jar"
    ]
}
```

### **Maven Configuration** (Updated POM files)
- **Parent POM**: Includes CDM version property
- **Module POMs**: Include CDM dependency and build configuration

## 📋 **Quick Reference Commands**

### **Find Specific Classes**
```bash
# Find equity swap classes
find cdm-sources -name "*.java" | grep -i "equity\|swap"

# Find product template classes
find cdm-sources/cdm/product/template -name "*.java"

# Search for specific class name
find cdm-sources -name "*.java" | xargs grep -l "Product"
```

### **View File Contents**
```bash
# View Product.java
head -50 cdm-sources/cdm/product/template/Product.java

# View EquitySwapMasterConfirmation2018.java
head -50 cdm-sources/cdm/legaldocumentation/master/EquitySwapMasterConfirmation2018.java
```

### **Count Files**
```bash
# Count total Java files
find cdm-sources -name "*.java" | wc -l

# Count equity/swap related files
find cdm-sources -name "*.java" | grep -i "equity\|swap" | wc -l
```

## 🎯 **Next Steps**

1. **Explore the CDM classes** in your IDE
2. **Use the navigation script** (`./navigate-cdm.sh`) for quick exploration
3. **Import CDM classes** in your Java code
4. **Reference the JSON schemas** for data validation
5. **Check the Rosetta model files** for understanding the domain model

## 📚 **Additional Resources**

- **CDM Website**: https://www.cdm.rosetta-technology.io/
- **GitHub Repository**: https://github.com/finos/common-domain-model
- **Maven Central**: https://central.sonatype.com/artifact/org.finos.cdm/cdm-java
- **Documentation**: `CDM_SOURCE_FILES.md` (comprehensive source file guide)

---

**✅ Your CDM sources are now ready for navigation and development!** 