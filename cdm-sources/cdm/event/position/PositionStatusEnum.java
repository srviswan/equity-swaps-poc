package cdm.event.position;

import cdm.event.position.PositionStatusEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
 * @version 6.0.0
 */
@RosettaEnum("PositionStatusEnum")
public enum PositionStatusEnum {

	/**
	 * The position has been executed, which is the point at which risk has been transferred.
	 */
	@RosettaEnumValue(value = "Executed") 
	EXECUTED("Executed", null),
	
	/**
	 * Contract has been formed, in case position is on a contractual product.
	 */
	@RosettaEnumValue(value = "Formed") 
	FORMED("Formed", null),
	
	/**
	 * The position has settled, in case product is subject to settlement after execution, such as securities.
	 */
	@RosettaEnumValue(value = "Settled") 
	SETTLED("Settled", null),
	
	/**
	 * The position has been cancelled, in case of a cancellation event following an execution.
	 */
	@RosettaEnumValue(value = "Cancelled") 
	CANCELLED("Cancelled", null),
	
	/**
	 * The position has been closed, in case of a termination event.
	 */
	@RosettaEnumValue(value = "Closed") 
	CLOSED("Closed", null)
;
	private static Map<String, PositionStatusEnum> values;
	static {
        Map<String, PositionStatusEnum> map = new ConcurrentHashMap<>();
		for (PositionStatusEnum instance : PositionStatusEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PositionStatusEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PositionStatusEnum fromDisplayName(String name) {
		PositionStatusEnum value = values.get(name);
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
