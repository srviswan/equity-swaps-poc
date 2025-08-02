package cdm.base.datetime;

import cdm.base.datetime.PeriodExtendedEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify a time period containing the additional value of Term.
 * @version 6.0.0
 */
@RosettaEnum("PeriodExtendedEnum")
public enum PeriodExtendedEnum {

	/**
	 * Hour
	 */
	@RosettaEnumValue(value = "H") 
	H("H", null),
	
	/**
	 * Day
	 */
	@RosettaEnumValue(value = "D") 
	D("D", null),
	
	/**
	 * Week
	 */
	@RosettaEnumValue(value = "W") 
	W("W", null),
	
	/**
	 * Month
	 */
	@RosettaEnumValue(value = "M") 
	M("M", null),
	
	/**
	 * Year
	 */
	@RosettaEnumValue(value = "Y") 
	Y("Y", null),
	
	/**
	 * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
	 */
	@RosettaEnumValue(value = "T") 
	T("T", null),
	
	/**
	 * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
	 */
	@RosettaEnumValue(value = "C") 
	C("C", null)
;
	private static Map<String, PeriodExtendedEnum> values;
	static {
        Map<String, PeriodExtendedEnum> map = new ConcurrentHashMap<>();
		for (PeriodExtendedEnum instance : PeriodExtendedEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PeriodExtendedEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PeriodExtendedEnum fromDisplayName(String name) {
		PeriodExtendedEnum value = values.get(name);
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
