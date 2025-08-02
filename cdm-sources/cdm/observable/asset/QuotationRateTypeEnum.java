package cdm.observable.asset;

import cdm.observable.asset.QuotationRateTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
 * @version 6.0.0
 */
@RosettaEnum("QuotationRateTypeEnum")
public enum QuotationRateTypeEnum {

	/**
	 * A bid rate.
	 */
	@RosettaEnumValue(value = "Bid") 
	BID("Bid", null),
	
	/**
	 * An ask rate.
	 */
	@RosettaEnumValue(value = "Ask") 
	ASK("Ask", null),
	
	/**
	 * A mid-market rate.
	 */
	@RosettaEnumValue(value = "Mid") 
	MID("Mid", null),
	
	/**
	 * If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
	 */
	@RosettaEnumValue(value = "ExercisingPartyPays") 
	EXERCISING_PARTY_PAYS("ExercisingPartyPays", null)
;
	private static Map<String, QuotationRateTypeEnum> values;
	static {
        Map<String, QuotationRateTypeEnum> map = new ConcurrentHashMap<>();
		for (QuotationRateTypeEnum instance : QuotationRateTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	QuotationRateTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static QuotationRateTypeEnum fromDisplayName(String name) {
		QuotationRateTypeEnum value = values.get(name);
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
