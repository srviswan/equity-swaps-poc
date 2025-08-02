package cdm.event.position;

import cdm.event.position.AvailableInventoryTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration to describe the type of AvailableInventory
 * @version 6.0.0
 */
@RosettaEnum("AvailableInventoryTypeEnum")
public enum AvailableInventoryTypeEnum {

	/**
	 * Where a lender is broadcasting the securities that they have available to lend
	 */
	@RosettaEnumValue(value = "AvailableToLend") 
	AVAILABLE_TO_LEND("AvailableToLend", null),
	
	/**
	 * Where a party is asking a lender if they have specific securities available for them to borrow
	 */
	@RosettaEnumValue(value = "RequestToBorrow") 
	REQUEST_TO_BORROW("RequestToBorrow", null)
;
	private static Map<String, AvailableInventoryTypeEnum> values;
	static {
        Map<String, AvailableInventoryTypeEnum> map = new ConcurrentHashMap<>();
		for (AvailableInventoryTypeEnum instance : AvailableInventoryTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AvailableInventoryTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AvailableInventoryTypeEnum fromDisplayName(String name) {
		AvailableInventoryTypeEnum value = values.get(name);
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
