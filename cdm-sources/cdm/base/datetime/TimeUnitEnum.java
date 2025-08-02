package cdm.base.datetime;

import cdm.base.datetime.TimeUnitEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumeration values to qualify the allowed units of time.
 * @version 6.0.0
 */
@RosettaEnum("TimeUnitEnum")
public enum TimeUnitEnum {

	/**
	 * Second
	 */
	@RosettaEnumValue(value = "Second") 
	SECOND("Second", null),
	
	/**
	 * Minute
	 */
	@RosettaEnumValue(value = "Minute") 
	MINUTE("Minute", null),
	
	/**
	 * Hour
	 */
	@RosettaEnumValue(value = "Hour") 
	HOUR("Hour", null),
	
	/**
	 * Day
	 */
	@RosettaEnumValue(value = "Day") 
	DAY("Day", null),
	
	/**
	 * Week
	 */
	@RosettaEnumValue(value = "Week") 
	WEEK("Week", null),
	
	/**
	 * Month
	 */
	@RosettaEnumValue(value = "Month") 
	MONTH("Month", null),
	
	/**
	 * Year
	 */
	@RosettaEnumValue(value = "Year") 
	YEAR("Year", null)
;
	private static Map<String, TimeUnitEnum> values;
	static {
        Map<String, TimeUnitEnum> map = new ConcurrentHashMap<>();
		for (TimeUnitEnum instance : TimeUnitEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	TimeUnitEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static TimeUnitEnum fromDisplayName(String name) {
		TimeUnitEnum value = values.get(name);
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
