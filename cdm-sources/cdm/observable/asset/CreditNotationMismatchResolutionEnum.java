package cdm.observable.asset;

import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
 * @version 6.0.0
 */
@RosettaEnum("CreditNotationMismatchResolutionEnum")
public enum CreditNotationMismatchResolutionEnum {

	/**
	 * Denotes the lowest credit notation if several notations are listed.
	 */
	@RosettaEnumValue(value = "Lowest") 
	LOWEST("Lowest", null),
	
	/**
	 * Denotes the highest credit notation if several notations are listed.
	 */
	@RosettaEnumValue(value = "Highest") 
	HIGHEST("Highest", null),
	
	/**
	 * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
	 */
	@RosettaEnumValue(value = "ReferenceAgency") 
	REFERENCE_AGENCY("ReferenceAgency", null),
	
	/**
	 * Denotes the average credit notation if several notations are listed.
	 */
	@RosettaEnumValue(value = "Average") 
	AVERAGE("Average", null),
	
	/**
	 * Denotes the second best credit notation if several notations are listed.
	 */
	@RosettaEnumValue(value = "SecondBest") 
	SECOND_BEST("SecondBest", null),
	
	/**
	 * Utilised where bespoke language represents the label characteristics of the rating.
	 */
	@RosettaEnumValue(value = "Other") 
	OTHER("Other", null)
;
	private static Map<String, CreditNotationMismatchResolutionEnum> values;
	static {
        Map<String, CreditNotationMismatchResolutionEnum> map = new ConcurrentHashMap<>();
		for (CreditNotationMismatchResolutionEnum instance : CreditNotationMismatchResolutionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CreditNotationMismatchResolutionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CreditNotationMismatchResolutionEnum fromDisplayName(String name) {
		CreditNotationMismatchResolutionEnum value = values.get(name);
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
