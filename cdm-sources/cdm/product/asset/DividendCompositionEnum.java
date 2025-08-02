package cdm.product.asset;

import cdm.product.asset.DividendCompositionEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify how the composition of Dividends is to be determined.
 * @version 6.0.0
 */
@RosettaEnum("DividendCompositionEnum")
public enum DividendCompositionEnum {

	/**
	 * The Equity Amount Receiver determines the composition of dividends (subject to conditions).
	 */
	@RosettaEnumValue(value = "EquityAmountReceiverElection") 
	EQUITY_AMOUNT_RECEIVER_ELECTION("EquityAmountReceiverElection", null),
	
	/**
	 * The Calculation Agent determines the composition of dividends (subject to conditions).
	 */
	@RosettaEnumValue(value = "CalculationAgentElection") 
	CALCULATION_AGENT_ELECTION("CalculationAgentElection", null)
;
	private static Map<String, DividendCompositionEnum> values;
	static {
        Map<String, DividendCompositionEnum> map = new ConcurrentHashMap<>();
		for (DividendCompositionEnum instance : DividendCompositionEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DividendCompositionEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DividendCompositionEnum fromDisplayName(String name) {
		DividendCompositionEnum value = values.get(name);
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
