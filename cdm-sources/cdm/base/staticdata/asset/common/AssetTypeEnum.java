package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.AssetTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Represents an enumeration list to identify the asset type.
 * @version 6.0.0
 */
@RosettaEnum("AssetTypeEnum")
public enum AssetTypeEnum {

	/**
	 * Indentifies negotiable financial instrument of monetary value with an issue ownership position.
	 */
	@RosettaEnumValue(value = "Security") 
	SECURITY("Security", null),
	
	/**
	 * Indentifies cash in a currency form.
	 */
	@RosettaEnumValue(value = "Cash") 
	CASH("Cash", null),
	
	/**
	 * Indentifies basic good used in commerce that is interchangeable with other goods of the same type.
	 */
	@RosettaEnumValue(value = "Commodity") 
	COMMODITY("Commodity", null),
	
	/**
	 * Indentifies other asset types.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, AssetTypeEnum> values;
	static {
        Map<String, AssetTypeEnum> map = new ConcurrentHashMap<>();
		for (AssetTypeEnum instance : AssetTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetTypeEnum fromDisplayName(String name) {
		AssetTypeEnum value = values.get(name);
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
