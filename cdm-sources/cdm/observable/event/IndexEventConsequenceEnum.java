package cdm.observable.event;

import cdm.observable.event.IndexEventConsequenceEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the consequences of Index Events.
 * @version 6.0.0
 */
@RosettaEnum("IndexEventConsequenceEnum")
public enum IndexEventConsequenceEnum {

	/**
	 * Calculation Agent Adjustment.
	 */
	@RosettaEnumValue(value = "CalculationAgentAdjustment") 
	CALCULATION_AGENT_ADJUSTMENT("CalculationAgentAdjustment", null),
	
	/**
	 * Negotiated Close Out.
	 */
	@RosettaEnumValue(value = "NegotiatedCloseOut") 
	NEGOTIATED_CLOSE_OUT("NegotiatedCloseOut", null),
	
	/**
	 * Cancellation and Payment.
	 */
	@RosettaEnumValue(value = "CancellationAndPayment") 
	CANCELLATION_AND_PAYMENT("CancellationAndPayment", null),
	
	/**
	 * Related Exchange.
	 */
	@RosettaEnumValue(value = "RelatedExchange") 
	RELATED_EXCHANGE("RelatedExchange", null)
;
	private static Map<String, IndexEventConsequenceEnum> values;
	static {
        Map<String, IndexEventConsequenceEnum> map = new ConcurrentHashMap<>();
		for (IndexEventConsequenceEnum instance : IndexEventConsequenceEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	IndexEventConsequenceEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static IndexEventConsequenceEnum fromDisplayName(String name) {
		IndexEventConsequenceEnum value = values.get(name);
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
