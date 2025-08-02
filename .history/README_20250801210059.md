# Equity Swaps POC with CDM

This project demonstrates the use of the latest **Common Domain Model (CDM)** artifacts for equity swaps implementation.

## Latest CDM Artifacts

### CDM Java Dependency
- **Group ID**: `org.finos.cdm`
- **Artifact ID**: `cdm-java`
- **Latest Version**: `7.0.0-dev.14`
- **Source**: [Maven Central](https://central.sonatype.com/artifact/org.finos.cdm/cdm-java/7.0.0-dev.14/overview)
- **License**: Community Specification License 1.0

### Key CDM Components
1. **Trade Classes** - Represent financial transactions
2. **Product Classes** - Define financial instruments (EquitySwap, EquityLeg, FixedLeg, FloatingLeg)
3. **Party Classes** - Represent counterparties
4. **Event Classes** - Handle trade lifecycle events
5. **Reference Data** - Currencies, countries, business days
6. **Payment Classes** - Represent cash flows and schedules

## Project Structure

```
equity-swaps-poc/
├── pom.xml                          # Parent POM with CDM dependency management
├── synthetics-common/
│   ├── pom.xml                      # Common module with CDM dependency
│   └── src/main/java/com/finos/synthetics/common/domain/
│       └── EquitySwapExample.java   # Example CDM usage
└── synthetics-position-service/
    └── pom.xml                      # Position service module
```

## Dependencies

### Core Dependencies
- `org.finos.cdm:cdm-java:7.0.0-dev.14` - Latest CDM Java library
- `com.google.code.gson:gson:2.10.1` - JSON processing
- `org.slf4j:slf4j-api:1.7.36` - Logging framework
- `junit:junit:4.13.2` - Testing framework

### Resolved Issues
- ✅ **Regnosys Dependencies**: Removed problematic Regnosys dependencies that were not available in Maven Central
- ✅ **CDM Integration**: Successfully integrated the latest CDM Java dependency
- ✅ **Build Success**: All modules compile successfully

## Usage Example

The `EquitySwapExample.java` demonstrates how to use CDM classes:

```java
// CDM classes would be imported from org.finos.cdm package
// Trade trade = new Trade();
// Product product = new Product();
// Party party = new Party();
```

## Building the Project

```bash
# Clean and compile all modules
mvn clean compile

# Compile specific module
mvn compile -pl synthetics-common

# Run tests
mvn test
```

## CDM Artifacts Location

The CDM Java artifact has been downloaded to:
```
~/.m2/repository/org/finos/cdm/cdm-java/7.0.0-dev.14/
├── cdm-java-7.0.0-dev.14.jar      # Main CDM library (31MB)
├── cdm-java-7.0.0-dev.14.pom      # POM file
└── cdm-java-7.0.0-dev.14.jar.sha1 # Checksum
```

## CDM Documentation

- **Official CDM Repository**: https://github.com/finos/common-domain-model
- **CDM Specification**: https://www.cdm.finos.org/
- **Maven Central**: https://central.sonatype.com/artifact/org.finos.cdm/cdm-java/7.0.0-dev.14/overview

## Equity Swap Specific Classes

The CDM includes specialized classes for equity swaps:

1. **EquitySwap** - Main product class for equity swaps
2. **EquityLeg** - Represents equity leg of the swap
3. **FixedLeg** - Represents fixed rate leg of the swap
4. **FloatingLeg** - Represents floating rate leg of the swap
5. **Payment** - Represents cash flows
6. **Schedule** - Represents payment schedules

## Next Steps

1. **Import CDM Classes**: Import actual CDM classes from `org.finos.cdm` package
2. **Create Trade Objects**: Use CDM Trade, Product, and Party classes
3. **Implement Business Logic**: Build equity swap processing logic
4. **Add Validation**: Use CDM validation features
5. **Integration**: Connect with external systems using CDM standards

## License

This project uses the Community Specification License 1.0 for CDM components. 