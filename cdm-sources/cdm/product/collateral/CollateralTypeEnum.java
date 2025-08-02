package cdm.product.collateral;

import cdm.product.collateral.CollateralTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Specifies the types of collateral that are accepted by the Lender
 * @version 6.0.0
 */
@RosettaEnum("CollateralTypeEnum")
public enum CollateralTypeEnum {

	/**
	 * Security Lending Trades against Cash collateral
	 */
	@RosettaEnumValue(value = "Cash") 
	CASH("Cash", null),
	
	/**
	 * Security Lending Trades against NonCash collateral
	 */
	@RosettaEnumValue(value = "NonCash") 
	NON_CASH("NonCash", null),
	
	/**
	 * Security Lending Trades against CashPool collateral
	 */
	@RosettaEnumValue(value = "CashPool") 
	CASH_POOL("CashPool", null)
;
	private static Map<String, CollateralTypeEnum> values;
	static {
        Map<String, CollateralTypeEnum> map = new ConcurrentHashMap<>();
		for (CollateralTypeEnum instance : CollateralTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CollateralTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CollateralTypeEnum fromDisplayName(String name) {
		CollateralTypeEnum value = values.get(name);
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
