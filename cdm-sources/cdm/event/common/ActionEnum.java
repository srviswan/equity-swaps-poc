package cdm.event.common;

import cdm.event.common.ActionEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumeration values to specify the actions associated with transactions.
 * @version 6.0.0
 */
@RosettaEnum("ActionEnum")
public enum ActionEnum {

	/**
	 * A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
	 */
	@RosettaEnumValue(value = "New") 
	NEW("New", null),
	
	/**
	 * A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
	 */
	@RosettaEnumValue(value = "Correct") 
	CORRECT("Correct", null),
	
	/**
	 * A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
	 */
	@RosettaEnumValue(value = "Cancel") 
	CANCEL("Cancel", null)
;
	private static Map<String, ActionEnum> values;
	static {
        Map<String, ActionEnum> map = new ConcurrentHashMap<>();
		for (ActionEnum instance : ActionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ActionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ActionEnum fromDisplayName(String name) {
		ActionEnum value = values.get(name);
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
