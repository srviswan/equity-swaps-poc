package cdm.observable.asset;

import cdm.observable.asset.FeeTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify an event that has given rise to a fee.
 * @version 6.0.0
 */
@RosettaEnum("FeeTypeEnum")
public enum FeeTypeEnum {

	/**
	 * A cash flow resulting from the assignment of a contract to a new counterparty.
	 */
	@RosettaEnumValue(value = "Assignment") 
	ASSIGNMENT("Assignment", null),
	
	/**
	 * The brokerage commission.
	 */
	@RosettaEnumValue(value = "BrokerageCommission") 
	BROKERAGE_COMMISSION("BrokerageCommission", null),
	
	/**
	 * A cash flow associated with an increase lifecycle event.
	 */
	@RosettaEnumValue(value = "Increase") 
	INCREASE("Increase", null),
	
	/**
	 * The novation fee.
	 */
	@RosettaEnumValue(value = "Novation") 
	NOVATION("Novation", null),
	
	/**
	 * A cash flow associated with a partial termination lifecycle event.
	 */
	@RosettaEnumValue(value = "PartialTermination") 
	PARTIAL_TERMINATION("PartialTermination", null),
	
	/**
	 * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
	 */
	@RosettaEnumValue(value = "Premium") 
	PREMIUM("Premium", null),
	
	/**
	 * A cash flow associated with a renegotiation lifecycle event.
	 */
	@RosettaEnumValue(value = "Renegotiation") 
	RENEGOTIATION("Renegotiation", null),
	
	/**
	 * A cash flow associated with a termination lifecycle event.
	 */
	@RosettaEnumValue(value = "Termination") 
	TERMINATION("Termination", null),
	
	/**
	 * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
	 */
	@RosettaEnumValue(value = "Upfront") 
	UPFRONT("Upfront", null),
	
	/**
	 * A cash flow associated with a credit event.
	 */
	@RosettaEnumValue(value = "CreditEvent") 
	CREDIT_EVENT("CreditEvent", null),
	
	/**
	 * A cash flow associated with a corporate action
	 */
	@RosettaEnumValue(value = "CorporateAction") 
	CORPORATE_ACTION("CorporateAction", null)
;
	private static Map<String, FeeTypeEnum> values;
	static {
        Map<String, FeeTypeEnum> map = new ConcurrentHashMap<>();
		for (FeeTypeEnum instance : FeeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	FeeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static FeeTypeEnum fromDisplayName(String name) {
		FeeTypeEnum value = values.get(name);
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
