package cdm.base.datetime;

import cdm.base.datetime.DayOfWeekEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify a day of the seven-day week.
 * @version 6.0.0
 */
@RosettaEnum("DayOfWeekEnum")
public enum DayOfWeekEnum {

	/**
	 * Monday
	 */
	@RosettaEnumValue(value = "MON") 
	MON("MON", null),
	
	/**
	 * Tuesday
	 */
	@RosettaEnumValue(value = "TUE") 
	TUE("TUE", null),
	
	/**
	 * Wednesday
	 */
	@RosettaEnumValue(value = "WED") 
	WED("WED", null),
	
	/**
	 * Thursday
	 */
	@RosettaEnumValue(value = "THU") 
	THU("THU", null),
	
	/**
	 * Friday
	 */
	@RosettaEnumValue(value = "FRI") 
	FRI("FRI", null),
	
	/**
	 * Saturday
	 */
	@RosettaEnumValue(value = "SAT") 
	SAT("SAT", null),
	
	/**
	 * Sunday
	 */
	@RosettaEnumValue(value = "SUN") 
	SUN("SUN", null)
;
	private static Map<String, DayOfWeekEnum> values;
	static {
        Map<String, DayOfWeekEnum> map = new ConcurrentHashMap<>();
		for (DayOfWeekEnum instance : DayOfWeekEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DayOfWeekEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DayOfWeekEnum fromDisplayName(String name) {
		DayOfWeekEnum value = values.get(name);
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
