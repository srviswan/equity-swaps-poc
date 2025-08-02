package cdm.product.collateral;

import cdm.product.collateral.RatingPriorityResolutionEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to &#39;Issuer&#39;, the rating in the 
Issuer Criteria has priority or is used if there is no Asset criteria. If set to &#39;Asset&#39;, the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
 * @version 6.0.0
 */
@RosettaEnum("RatingPriorityResolutionEnum")
public enum RatingPriorityResolutionEnum {

	/**
	 * Denotes that the Issuer Criteria has priority.
	 */
	@RosettaEnumValue(value = "Issuer") 
	ISSUER("Issuer", null),
	
	/**
	 * Denotes that the Asset Criteria has priority.
	 */
	@RosettaEnumValue(value = "Asset") 
	ASSET("Asset", null),
	
	/**
	 * Denotes that lowest rating should be used if several criteria apply.
	 */
	@RosettaEnumValue(value = "Lowest") 
	LOWEST("Lowest", null),
	
	/**
	 * Denotes that highest rating should be used if several criteria apply.
	 */
	@RosettaEnumValue(value = "Highest") 
	HIGHEST("Highest", null),
	
	/**
	 * Denotes that average rating should be used if several criteria apply.
	 */
	@RosettaEnumValue(value = "Average") 
	AVERAGE("Average", null)
;
	private static Map<String, RatingPriorityResolutionEnum> values;
	static {
        Map<String, RatingPriorityResolutionEnum> map = new ConcurrentHashMap<>();
		for (RatingPriorityResolutionEnum instance : RatingPriorityResolutionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	RatingPriorityResolutionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static RatingPriorityResolutionEnum fromDisplayName(String name) {
		RatingPriorityResolutionEnum value = values.get(name);
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
