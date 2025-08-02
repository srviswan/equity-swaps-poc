package cdm.base.staticdata.party;

import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values for the natural person&#39;s role.
 * @version 6.0.0
 */
@RosettaEnum("NaturalPersonRoleEnum")
public enum NaturalPersonRoleEnum {

	/**
	 * The person who arranged with a client to execute the trade.
	 */
	@RosettaEnumValue(value = "Broker") 
	BROKER("Broker", null),
	
	/**
	 * Acquirer of the legal title to the financial instrument.
	 */
	@RosettaEnumValue(value = "Buyer") 
	BUYER("Buyer", null),
	
	/**
	 * The party or person with legal responsibility for authorization of the execution of the transaction.
	 */
	@RosettaEnumValue(value = "DecisionMaker") 
	DECISION_MAKER("DecisionMaker", null),
	
	/**
	 * Person within the firm who is responsible for execution of the transaction.
	 */
	@RosettaEnumValue(value = "ExecutionWithinFirm") 
	EXECUTION_WITHIN_FIRM("ExecutionWithinFirm", null),
	
	/**
	 * Person who is responsible for making the investment decision.
	 */
	@RosettaEnumValue(value = "InvestmentDecisionMaker") 
	INVESTMENT_DECISION_MAKER("InvestmentDecisionMaker", null),
	
	/**
	 * Seller of the legal title to the financial instrument.
	 */
	@RosettaEnumValue(value = "Seller") 
	SELLER("Seller", null),
	
	/**
	 * The person who executed the trade.
	 */
	@RosettaEnumValue(value = "Trader") 
	TRADER("Trader", null)
;
	private static Map<String, NaturalPersonRoleEnum> values;
	static {
        Map<String, NaturalPersonRoleEnum> map = new ConcurrentHashMap<>();
		for (NaturalPersonRoleEnum instance : NaturalPersonRoleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	NaturalPersonRoleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static NaturalPersonRoleEnum fromDisplayName(String name) {
		NaturalPersonRoleEnum value = values.get(name);
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
