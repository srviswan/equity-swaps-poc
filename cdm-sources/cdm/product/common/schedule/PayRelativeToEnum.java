package cdm.product.common.schedule;

import cdm.product.common.schedule.PayRelativeToEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date.
 * @version 6.0.0
 */
@RosettaEnum("PayRelativeToEnum")
public enum PayRelativeToEnum {

	/**
	 * Payments will occur relative to the first day of each calculation period.
	 */
	@RosettaEnumValue(value = "CalculationPeriodStartDate") 
	CALCULATION_PERIOD_START_DATE("CalculationPeriodStartDate", null),
	
	/**
	 * Payments will occur relative to the last day of each calculation period.
	 */
	@RosettaEnumValue(value = "CalculationPeriodEndDate") 
	CALCULATION_PERIOD_END_DATE("CalculationPeriodEndDate", null),
	
	/**
	 * Payments will occur relative to the last Pricing Date of each Calculation Period.
	 */
	@RosettaEnumValue(value = "LastPricingDate") 
	LAST_PRICING_DATE("LastPricingDate", null),
	
	/**
	 * Payments will occur relative to the reset date.
	 */
	@RosettaEnumValue(value = "ResetDate") 
	RESET_DATE("ResetDate", null),
	
	/**
	 * Payments will occur relative to the valuation date.
	 */
	@RosettaEnumValue(value = "ValuationDate") 
	VALUATION_DATE("ValuationDate", null)
;
	private static Map<String, PayRelativeToEnum> values;
	static {
        Map<String, PayRelativeToEnum> map = new ConcurrentHashMap<>();
		for (PayRelativeToEnum instance : PayRelativeToEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PayRelativeToEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PayRelativeToEnum fromDisplayName(String name) {
		PayRelativeToEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
