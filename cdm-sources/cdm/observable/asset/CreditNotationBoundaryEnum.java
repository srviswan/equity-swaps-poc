package cdm.observable.asset;

import cdm.observable.asset.CreditNotationBoundaryEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Identifies an agency rating as a simple scale boundary of minimum or maximum.
 * @version 6.0.0
 */
@RosettaEnum("CreditNotationBoundaryEnum")
public enum CreditNotationBoundaryEnum {

	/**
	 * Denotes a minumum boundary
	 */
	@RosettaEnumValue(value = "Minimum") 
	MINIMUM("Minimum", null),
	
	/**
	 * Denotes a maxiumum boundary
	 */
	@RosettaEnumValue(value = "Maximum") 
	MAXIMUM("Maximum", null)
;
	private static Map<String, CreditNotationBoundaryEnum> values;
	static {
        Map<String, CreditNotationBoundaryEnum> map = new ConcurrentHashMap<>();
		for (CreditNotationBoundaryEnum instance : CreditNotationBoundaryEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CreditNotationBoundaryEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CreditNotationBoundaryEnum fromDisplayName(String name) {
		CreditNotationBoundaryEnum value = values.get(name);
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
