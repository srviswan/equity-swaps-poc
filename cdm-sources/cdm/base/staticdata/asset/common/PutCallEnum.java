package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.PutCallEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the types of listed derivative options.
 * @version 6.0.0
 */
@RosettaEnum("PutCallEnum")
public enum PutCallEnum {

	/**
	 * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
	 */
	@RosettaEnumValue(value = "Put") 
	PUT("Put", null),
	
	/**
	 * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
	 */
	@RosettaEnumValue(value = "Call") 
	CALL("Call", null)
;
	private static Map<String, PutCallEnum> values;
	static {
        Map<String, PutCallEnum> map = new ConcurrentHashMap<>();
		for (PutCallEnum instance : PutCallEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PutCallEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PutCallEnum fromDisplayName(String name) {
		PutCallEnum value = values.get(name);
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
