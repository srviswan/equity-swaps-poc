package cdm.legaldocumentation.common;

import cdm.legaldocumentation.common.LegalAgreementPublisherEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import com.rosetta.model.lib.annotations.RosettaSynonym;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the legal agreement publisher.
 * @version 6.0.0
 */
@RosettaEnum("LegalAgreementPublisherEnum")
public enum LegalAgreementPublisherEnum {

	/**
	 * Association Française des Banques.
	 */
	@RosettaEnumValue(value = "AFB") 
	AFB("AFB", null),
	
	/**
	 * BNY Mellon
	 */
	@RosettaEnumValue(value = "BNYM") 
	BNYM("BNYM", null),
	
	/**
	 * ISDA and Clearstream
	 */
	@RosettaEnumValue(value = "ISDAClearstream") 
	ISDA_CLEARSTREAM("ISDAClearstream", null),
	
	/**
	 * Emerging Markets Traders Association
	 */
	@RosettaEnumValue(value = "EMTA") 
	EMTA("EMTA", null),
	
	/**
	 * The Foreign Exchange Committee
	 */
	@RosettaEnumValue(value = "TheFXCommittee") 
	THE_FX_COMMITTEE("TheFXCommittee", null),
	
	/**
	 * ISDA and Euroclear
	 */
	@RosettaEnumValue(value = "ISDAEuroclear") 
	ISDA_EUROCLEAR("ISDAEuroclear", null),
	
	/**
	 * International Swaps and Derivatives Association, Inc.
	 */
	@RosettaSynonym(value = "ISDA", source = "AcadiaSoft_AM_1_0")
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	/**
	 * International Securities Lending Association
	 */
	@RosettaEnumValue(value = "ISLA") 
	ISLA("ISLA", null),
	
	/**
	 * JP Morgan
	 */
	@RosettaEnumValue(value = "JPMorgan") 
	JP_MORGAN("JPMorgan", null),
	
	/**
	 * International Capital Markets Association
	 */
	@RosettaEnumValue(value = "ICMA") 
	ICMA("ICMA", null)
;
	private static Map<String, LegalAgreementPublisherEnum> values;
	static {
        Map<String, LegalAgreementPublisherEnum> map = new ConcurrentHashMap<>();
		for (LegalAgreementPublisherEnum instance : LegalAgreementPublisherEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	LegalAgreementPublisherEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static LegalAgreementPublisherEnum fromDisplayName(String name) {
		LegalAgreementPublisherEnum value = values.get(name);
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
