# CDM Reset Implementation Guide

## 🎯 **Overview**

Reset functionality in CDM (Common Domain Model) is a critical component for handling floating rate instruments, interest rate swaps, and other financial products where rates need to be periodically updated. This guide explains how Reset is implemented in CDM.

## 📊 **Core Reset Components**

### **1. ResetDates - Main Reset Class**

The `ResetDates` class is the primary CDM class for handling reset functionality:

```java
@RosettaDataType(value="ResetDates", builder=ResetDates.ResetDatesBuilderImpl.class, version="6.0.0")
public interface ResetDates extends RosettaModelObject, GlobalKey {
    
    // Key Components:
    ReferenceWithMetaCalculationPeriodDates getCalculationPeriodDatesReference();
    ResetRelativeToEnum getResetRelativeTo();
    InitialFixingDate getInitialFixingDate();
    RelativeDateOffset getFixingDates();
    AdjustableDate getFinalFixingDate();
    Offset getRateCutOffDaysOffset();
    ResetFrequency getResetFrequency();
    BusinessDayAdjustments getResetDatesAdjustments();
}
```

#### **Key Features:**
- **Calculation Period Reference**: Links to calculation period dates
- **Reset Relative To**: Whether resets occur relative to start or end of calculation period
- **Initial Fixing Date**: First fixing date for the instrument
- **Fixing Dates**: Schedule for rate observations
- **Final Fixing Date**: Last fixing date (for credit derivatives)
- **Rate Cut-Off**: Business days offset for rate cut-off
- **Reset Frequency**: How often resets occur
- **Business Day Adjustments**: Holiday and business day conventions

### **2. ResetFrequency - Frequency Configuration**

```java
public interface ResetFrequency extends Frequency {
    WeeklyRollConventionEnum getWeeklyRollConvention();
}
```

#### **Supported Frequencies:**
- **Daily**: Daily resets
- **Weekly**: Weekly resets with specific day of week
- **Monthly**: Monthly resets
- **Quarterly**: Quarterly resets
- **Semi-Annual**: Semi-annual resets
- **Annual**: Annual resets
- **Term**: Single reset for entire term

### **3. ResetRelativeToEnum - Reset Timing**

```java
public enum ResetRelativeToEnum {
    CALCULATION_PERIOD_START_DATE("CalculationPeriodStartDate"),
    CALCULATION_PERIOD_END_DATE("CalculationPeriodEndDate")
}
```

#### **Reset Timing Options:**
- **CALCULATION_PERIOD_START_DATE**: Resets occur relative to period start
- **CALCULATION_PERIOD_END_DATE**: Resets occur relative to period end

## 🔄 **Reset Processing Functions**

### **1. ProcessFloatingRateReset - Main Processing Function**

The `ProcessFloatingRateReset` class handles different types of reset processing:

```java
public class ProcessFloatingRateReset implements RosettaFunction {
    
    public FloatingRateSettingDetails evaluate(
        InterestRatePayout interestRatePayout, 
        CalculationPeriodBase calcPeriod, 
        FloatingRateIndexProcessingTypeEnum processingType) {
        
        switch (processingType) {
            case SCREEN:
                return processFloatingRateResetScreen.evaluate(interestRatePayout, calcPeriod, processingType);
            case MODULAR:
                return processFloatingRateResetModular.evaluate(interestRatePayout, calcPeriod, processingType);
            case OIS:
                return processFloatingRateResetOIS.evaluate(interestRatePayout, calcPeriod, processingType);
            case OVERNIGHT_AVG:
                return processFloatingRateResetOvernightAvg.evaluate(interestRatePayout, calcPeriod, processingType);
            case COMPOUND_INDEX:
                return processFloatingRateResetCompoundIndex.evaluate(interestRatePayout, calcPeriod, processingType);
        }
    }
}
```

#### **Processing Types:**

1. **SCREEN**: Standard screen rate processing
2. **MODULAR**: Modular calculated rate processing
3. **OIS**: Overnight Index Swap processing
4. **OVERNIGHT_AVG**: Overnight averaging processing
5. **COMPOUND_INDEX**: Compound index processing

### **2. DetermineFloatingRateReset - Reset Determination**

```java
public class DetermineFloatingRateReset implements RosettaFunction {
    
    public ResetDates evaluate(InterestRatePayout interestRatePayout) {
        // Determines reset dates based on payout configuration
    }
}
```

### **3. DetermineResetDate - Date Calculation**

```java
public class DetermineResetDate implements RosettaFunction {
    
    public Date evaluate(ResetDates resetDates, CalculationPeriodBase calcPeriod) {
        // Calculates specific reset dates
    }
}
```

## 📅 **Reset Date Calculation**

### **1. Basic Reset Date Structure**

```java
ResetDates.builder()
    .calculationPeriodDatesReference(calculationPeriodDatesRef)
    .resetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE)
    .initialFixingDate(initialFixingDate)
    .fixingDates(RelativeDateOffset.builder()
        .periodMultiplier(-2)
        .period(PeriodEnum.D)
        .build())
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(3)
        .period(PeriodEnum.M)
        .build())
    .resetDatesAdjustments(BusinessDayAdjustments.builder()
        .businessDayConvention(BusinessDayConventionEnum.FOLLOWING)
        .build())
    .build();
```

### **2. Reset Frequency Examples**

#### **Daily Reset:**
```java
ResetFrequency.builder()
    .periodMultiplier(1)
    .period(PeriodEnum.D)
    .build()
```

#### **Weekly Reset (Monday):**
```java
ResetFrequency.builder()
    .periodMultiplier(1)
    .period(PeriodEnum.W)
    .weeklyRollConvention(WeeklyRollConventionEnum.MONDAY)
    .build()
```

#### **Monthly Reset:**
```java
ResetFrequency.builder()
    .periodMultiplier(1)
    .period(PeriodEnum.M)
    .build()
```

#### **Quarterly Reset:**
```java
ResetFrequency.builder()
    .periodMultiplier(3)
    .period(PeriodEnum.M)
    .build()
```

## 💰 **Rate Cut-Off Functionality**

### **Rate Cut-Off Implementation**

The rate cut-off feature allows for early rate fixing:

```java
Offset rateCutOffDaysOffset = Offset.builder()
    .periodMultiplier(-2)  // 2 business days before period end
    .period(PeriodEnum.D)
    .dayType(DayTypeEnum.BUSINESS)
    .build();
```

#### **Rate Cut-Off Logic:**
- **Negative Offset**: Days before period end
- **Business Days**: Only business days count
- **Rate Application**: Same rate applied from cut-off to period end

## 🔧 **Reset Processing Workflow**

### **1. Reset Date Generation**

```java
// Step 1: Generate reset dates based on frequency
List<Date> resetDates = generateResetDates(resetFrequency, calculationPeriod);

// Step 2: Apply business day adjustments
List<Date> adjustedResetDates = applyBusinessDayAdjustments(resetDates, resetDatesAdjustments);

// Step 3: Calculate fixing dates
List<Date> fixingDates = calculateFixingDates(adjustedResetDates, fixingDatesOffset);
```

### **2. Rate Observation Process**

```java
// Step 1: Determine observation dates
List<Date> observationDates = determineObservationDates(fixingDates);

// Step 2: Collect rate observations
List<RateObservation> observations = collectRateObservations(observationDates, rateIndex);

// Step 3: Apply rate cut-off if applicable
List<RateObservation> finalObservations = applyRateCutOff(observations, rateCutOffDaysOffset);
```

### **3. Rate Calculation**

```java
// Step 1: Calculate period rates
List<PeriodRate> periodRates = calculatePeriodRates(finalObservations, calculationMethod);

// Step 2: Apply averaging if multiple resets per period
Rate averageRate = calculateAverageRate(periodRates, averagingMethod);

// Step 3: Apply spread and margin
Rate finalRate = applySpreadAndMargin(averageRate, spread, margin);
```

## 📊 **Reset Types and Use Cases**

### **1. Standard Floating Rate Reset**

```java
// Standard LIBOR reset
ResetDates standardReset = ResetDates.builder()
    .resetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE)
    .fixingDates(RelativeDateOffset.builder()
        .periodMultiplier(-2)
        .period(PeriodEnum.D)
        .build())
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(3)
        .period(PeriodEnum.M)
        .build())
    .build();
```

### **2. Daily Reset with Averaging**

```java
// Daily reset with monthly averaging
ResetDates dailyReset = ResetDates.builder()
    .resetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE)
    .fixingDates(RelativeDateOffset.builder()
        .periodMultiplier(-1)
        .period(PeriodEnum.D)
        .build())
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(1)
        .period(PeriodEnum.D)
        .build())
    .build();
```

### **3. Overnight Rate Reset**

```java
// Overnight rate reset (e.g., SOFR)
ResetDates overnightReset = ResetDates.builder()
    .resetRelativeTo(ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE)
    .fixingDates(RelativeDateOffset.builder()
        .periodMultiplier(0)
        .period(PeriodEnum.D)
        .build())
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(1)
        .period(PeriodEnum.D)
        .build())
    .build();
```

## 🔍 **Reset Validation**

### **1. ResetDatesValidator**

```java
public class ResetDatesValidator implements Validator<ResetDates> {
    
    public ValidationResult validate(ResetDates resetDates) {
        // Validates reset dates configuration
        // Checks for consistency between frequency and relative timing
        // Validates business day adjustments
        // Ensures fixing dates are properly configured
    }
}
```

### **2. Validation Rules**

#### **Frequency Validation:**
- Weekly frequency must specify day of week
- Daily frequency cannot specify relative timing
- Frequency must be consistent with calculation period

#### **Date Validation:**
- Fixing dates must be before reset dates
- Business day adjustments must be valid
- Rate cut-off must be negative offset

#### **Reference Validation:**
- Calculation period dates reference must be valid
- Rate index reference must be valid
- Business centers must be specified

## 🚀 **Advanced Reset Features**

### **1. Multiple Reset Frequencies**

CDM supports multiple reset frequencies within the same instrument:

```java
// Different reset frequencies for different legs
ResetDates leg1Reset = ResetDates.builder()
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(3)
        .period(PeriodEnum.M)
        .build())
    .build();

ResetDates leg2Reset = ResetDates.builder()
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(6)
        .period(PeriodEnum.M)
        .build())
    .build();
```

### **2. Conditional Reset Logic**

```java
// Conditional reset based on market conditions
ResetDates conditionalReset = ResetDates.builder()
    .resetFrequency(ResetFrequency.builder()
        .periodMultiplier(1)
        .period(PeriodEnum.M)
        .build())
    .resetDatesAdjustments(BusinessDayAdjustments.builder()
        .businessDayConvention(BusinessDayConventionEnum.FOLLOWING)
        .businessCenters(Arrays.asList("USNY", "GBLO"))
        .build())
    .build();
```

### **3. Reset with Rate Caps/Floors**

```java
// Reset with rate caps and floors
FloatingRateSettingDetails resetWithCaps = FloatingRateSettingDetails.builder()
    .resetDates(resetDates)
    .rateCap(RateCap.builder()
        .capRate(0.05)
        .build())
    .rateFloor(RateFloor.builder()
        .floorRate(0.01)
        .build())
    .build();
```

## 📋 **Reset Implementation Best Practices**

### **1. Configuration Management**

- **Use Builder Pattern**: Always use CDM builders for configuration
- **Validate Early**: Validate reset configuration at creation time
- **Handle Nulls**: Properly handle optional reset components
- **Business Day Logic**: Implement proper business day adjustments

### **2. Performance Optimization**

- **Cache Reset Dates**: Cache calculated reset dates for performance
- **Batch Processing**: Process multiple resets in batches
- **Lazy Evaluation**: Use lazy evaluation for complex reset calculations
- **Memory Management**: Properly manage memory for large reset schedules

### **3. Error Handling**

- **Validation Errors**: Handle validation errors gracefully
- **Date Errors**: Handle invalid date calculations
- **Rate Errors**: Handle missing or invalid rate observations
- **Business Day Errors**: Handle business day calculation errors

## 🔮 **Future Reset Enhancements**

### **1. Real-Time Reset Processing**

- **Live Rate Feeds**: Real-time rate observation
- **Instant Reset**: Immediate reset processing
- **Dynamic Frequency**: Runtime frequency adjustments
- **Market-Driven Resets**: Market condition-based resets

### **2. AI/ML Integration**

- **Predictive Resets**: ML-based reset timing
- **Rate Prediction**: AI-driven rate forecasting
- **Optimization**: ML-optimized reset schedules
- **Risk Management**: AI-enhanced reset risk management

### **3. Blockchain Integration**

- **Smart Contract Resets**: Blockchain-based reset execution
- **Decentralized Rates**: Decentralized rate observation
- **Automated Resets**: Self-executing reset contracts
- **Transparent Processing**: Transparent reset calculations

## 📊 **Reset Monitoring and Analytics**

### **1. Reset Performance Metrics**

```java
public class ResetPerformanceMetrics {
    private double resetAccuracy;
    private double ratePredictionError;
    private double resetTimingEfficiency;
    private double businessDayAdjustmentImpact;
    
    // Calculate reset performance metrics
    public void calculateMetrics(ResetDates resetDates, List<RateObservation> observations) {
        // Calculate various performance metrics
    }
}
```

### **2. Reset Analytics**

- **Reset Frequency Analysis**: Analyze reset frequency patterns
- **Rate Volatility Impact**: Measure rate volatility on resets
- **Business Day Impact**: Analyze business day adjustment impact
- **Reset Timing Optimization**: Optimize reset timing for best execution

---

**Version**: 1.0.0  
**CDM Version**: 6.0.0  
**Last Updated**: 2024  
**Status**: ✅ Complete Implementation Guide 