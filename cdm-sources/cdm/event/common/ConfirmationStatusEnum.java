package cdm.event.common;

import cdm.event.common.ConfirmationStatusEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration for the different types of confirmation status.
 * @version 6.0.0
 */
@RosettaEnum("ConfirmationStatusEnum")
public enum ConfirmationStatusEnum {

	@RosettaEnumValue(value = "Confirmed") 
	CONFIRMED("Confirmed", null),
	
	@RosettaEnumValue(value = "Unconfirmed") 
	UNCONFIRMED("Unconfirmed", null)
;
	private static Map<String, ConfirmationStatusEnum> values;
	static {
        Map<String, ConfirmationStatusEnum> map = new ConcurrentHashMap<>();
		for (ConfirmationStatusEnum instance : ConfirmationStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ConfirmationStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ConfirmationStatusEnum fromDisplayName(String name) {
		ConfirmationStatusEnum value = values.get(name);
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
