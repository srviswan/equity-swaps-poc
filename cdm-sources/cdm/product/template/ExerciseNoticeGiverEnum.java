package cdm.product.template;

import cdm.product.template.ExerciseNoticeGiverEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the principal party to the trade that has the right to exercise.
 * @version 6.0.0
 */
@RosettaEnum("ExerciseNoticeGiverEnum")
public enum ExerciseNoticeGiverEnum {

	/**
	 * Specifies that only the option buyer has the right to exercise.
	 */
	@RosettaEnumValue(value = "Buyer") 
	BUYER("Buyer", null),
	
	/**
	 * Specifies that only the option seller has the right to exercise.
	 */
	@RosettaEnumValue(value = "Seller") 
	SELLER("Seller", null),
	
	/**
	 * Specifies that both the option buyer and option seller has the right to exercise.
	 */
	@RosettaEnumValue(value = "Both") 
	BOTH("Both", null),
	
	/**
	 * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
	 */
	@RosettaEnumValue(value = "AsSpecifiedInMasterAgreement") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AsSpecifiedInMasterAgreement", null)
;
	private static Map<String, ExerciseNoticeGiverEnum> values;
	static {
        Map<String, ExerciseNoticeGiverEnum> map = new ConcurrentHashMap<>();
		for (ExerciseNoticeGiverEnum instance : ExerciseNoticeGiverEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	ExerciseNoticeGiverEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static ExerciseNoticeGiverEnum fromDisplayName(String name) {
		ExerciseNoticeGiverEnum value = values.get(name);
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
