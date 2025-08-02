package cdm.product.template;

import cdm.product.template.OptionExerciseStyleEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
 * @version 6.0.0
 */
@RosettaEnum("OptionExerciseStyleEnum")
public enum OptionExerciseStyleEnum {

	/**
	 * Single Exercise
	 */
	@RosettaEnumValue(value = "European") 
	EUROPEAN("European", null),
	
	/**
	 * Multiple specified exercise dates
	 */
	@RosettaEnumValue(value = "Bermuda") 
	BERMUDA("Bermuda", null),
	
	/**
	 * Continuous exercise over a range of dates
	 */
	@RosettaEnumValue(value = "American") 
	AMERICAN("American", null)
;
	private static Map<String, OptionExerciseStyleEnum> values;
	static {
        Map<String, OptionExerciseStyleEnum> map = new ConcurrentHashMap<>();
		for (OptionExerciseStyleEnum instance : OptionExerciseStyleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	OptionExerciseStyleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static OptionExerciseStyleEnum fromDisplayName(String name) {
		OptionExerciseStyleEnum value = values.get(name);
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
