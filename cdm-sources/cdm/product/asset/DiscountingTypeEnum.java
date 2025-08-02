package cdm.product.asset;

import cdm.product.asset.DiscountingTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
 * @version 6.0.0
 */
@RosettaEnum("DiscountingTypeEnum")
public enum DiscountingTypeEnum {

	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
	 */
	@RosettaEnumValue(value = "Standard") 
	STANDARD("Standard", null),
	
	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
	 */
	@RosettaEnumValue(value = "FRA") 
	FRA("FRA", null),
	
	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
	 */
	@RosettaEnumValue(value = "FRAYield") 
	FRA_YIELD("FRAYield", null),
	
	/**
	 * As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
	 */
	@RosettaEnumValue(value = "AFMA") 
	AFMA("AFMA", null)
;
	private static Map<String, DiscountingTypeEnum> values;
	static {
        Map<String, DiscountingTypeEnum> map = new ConcurrentHashMap<>();
		for (DiscountingTypeEnum instance : DiscountingTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DiscountingTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DiscountingTypeEnum fromDisplayName(String name) {
		DiscountingTypeEnum value = values.get(name);
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
