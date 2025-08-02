package cdm.product.asset;

import cdm.product.asset.IndexAnnexSourceEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the CDX index annex source.
 * @version 6.0.0
 */
@RosettaEnum("IndexAnnexSourceEnum")
public enum IndexAnnexSourceEnum {

	/**
	 * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
	 */
	@RosettaEnumValue(value = "MasterConfirmation") 
	MASTER_CONFIRMATION("MasterConfirmation", null),
	
	/**
	 * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
	 */
	@RosettaEnumValue(value = "Publisher") 
	PUBLISHER("Publisher", null)
;
	private static Map<String, IndexAnnexSourceEnum> values;
	static {
        Map<String, IndexAnnexSourceEnum> map = new ConcurrentHashMap<>();
		for (IndexAnnexSourceEnum instance : IndexAnnexSourceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	IndexAnnexSourceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static IndexAnnexSourceEnum fromDisplayName(String name) {
		IndexAnnexSourceEnum value = values.get(name);
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
