package cdm.event.common;

import cdm.event.common.ValuationTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Method used for the valuation of the transaction by the valuation party.
 * @version 6.0.0
 */
@RosettaEnum("ValuationTypeEnum")
public enum ValuationTypeEnum {

	/**
	 * Mark-to-Market
	 */
	@RosettaEnumValue(value = "MarkToMarket") 
	MARK_TO_MARKET("MarkToMarket", null),
	
	/**
	 * Mark-to-Model
	 */
	@RosettaEnumValue(value = "MarkToModel") 
	MARK_TO_MODEL("MarkToModel", null)
;
	private static Map<String, ValuationTypeEnum> values;
	static {
        Map<String, ValuationTypeEnum> map = new ConcurrentHashMap<>();
		for (ValuationTypeEnum instance : ValuationTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ValuationTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ValuationTypeEnum fromDisplayName(String name) {
		ValuationTypeEnum value = values.get(name);
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
