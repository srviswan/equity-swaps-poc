package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Represents an enumeration list to indentify the type of an instrument.
 * @version 6.0.0
 */
@RosettaEnum("InstrumentTypeEnum")
public enum InstrumentTypeEnum {

	/**
	 * Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
	 */
	@RosettaEnumValue(value = "Debt") 
	DEBT("Debt", null),
	
	/**
	 * Identifies an instrument as an Equity value of holding of shares in listed company.
	 */
	@RosettaEnumValue(value = "Equity") 
	EQUITY("Equity", null),
	
	/**
	 * Identifies an instrument as representing holding in an investment fund.
	 */
	@RosettaEnumValue(value = "Fund") 
	FUND("Fund", null),
	
	/**
	 * Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
	 */
	@RosettaEnumValue(value = "Warrant") 
	WARRANT("Warrant", null),
	
	/**
	 * Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
	 */
	@RosettaEnumValue(value = "Certificate") 
	CERTIFICATE("Certificate", null),
	
	/**
	 * Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
	 */
	@RosettaEnumValue(value = "LetterOfCredit") 
	LETTER_OF_CREDIT("LetterOfCredit", null),
	
	/**
	 * Identifies an instrument as a listed derivative on an exchange.
	 */
	@RosettaEnumValue(value = "ListedDerivative") 
	LISTED_DERIVATIVE("ListedDerivative", null)
;
	private static Map<String, InstrumentTypeEnum> values;
	static {
        Map<String, InstrumentTypeEnum> map = new ConcurrentHashMap<>();
		for (InstrumentTypeEnum instance : InstrumentTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InstrumentTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InstrumentTypeEnum fromDisplayName(String name) {
		InstrumentTypeEnum value = values.get(name);
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
