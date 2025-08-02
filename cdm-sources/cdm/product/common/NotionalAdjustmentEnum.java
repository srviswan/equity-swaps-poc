package cdm.product.common;

import cdm.product.common.NotionalAdjustmentEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
 * @version 6.0.0
 */
@RosettaEnum("NotionalAdjustmentEnum")
public enum NotionalAdjustmentEnum {

	/**
	 * The adjustments to the number of units are governed by an execution clause.
	 */
	@RosettaEnumValue(value = "Execution") 
	EXECUTION("Execution", null),
	
	/**
	 * The adjustments to the number of units are governed by a portfolio rebalancing clause.
	 */
	@RosettaEnumValue(value = "PortfolioRebalancing") 
	PORTFOLIO_REBALANCING("PortfolioRebalancing", null),
	
	/**
	 * The adjustments to the number of units are not governed by any specific clause.
	 */
	@RosettaEnumValue(value = "Standard") 
	STANDARD("Standard", null)
;
	private static Map<String, NotionalAdjustmentEnum> values;
	static {
        Map<String, NotionalAdjustmentEnum> map = new ConcurrentHashMap<>();
		for (NotionalAdjustmentEnum instance : NotionalAdjustmentEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NotionalAdjustmentEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NotionalAdjustmentEnum fromDisplayName(String name) {
		NotionalAdjustmentEnum value = values.get(name);
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
