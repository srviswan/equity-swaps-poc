package cdm.observable.asset;

import cdm.observable.asset.InformationProviderEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the list of information providers.
 * @version 6.0.0
 *
 * Body ISDA
 * Corpus Scheme FpML_Coding_Scheme   
 * schemeLocation "http://www.fpml.org/coding-scheme/information-provider"
 *
 * Provision 
 *
 */
@RosettaEnum("InformationProviderEnum")
public enum InformationProviderEnum {

	/**
	 * The Association of Banks in Singapore.
	 */
	@RosettaEnumValue(value = "AssocBanksSingapore") 
	ASSOC_BANKS_SINGAPORE("AssocBanksSingapore", null),
	
	/**
	 * The central bank of Chile.
	 */
	@RosettaEnumValue(value = "BancoCentralChile") 
	BANCO_CENTRAL_CHILE("BancoCentralChile", null),
	
	/**
	 * The central bank of Canada.
	 */
	@RosettaEnumValue(value = "BankOfCanada") 
	BANK_OF_CANADA("BankOfCanada", null),
	
	/**
	 * The Bank Of England.
	 */
	@RosettaEnumValue(value = "BankOfEngland") 
	BANK_OF_ENGLAND("BankOfEngland", null),
	
	/**
	 * The central bank of Japan.
	 */
	@RosettaEnumValue(value = "BankOfJapan") 
	BANK_OF_JAPAN("BankOfJapan", null),
	
	/**
	 * Bloomberg LP.
	 */
	@RosettaEnumValue(value = "Bloomberg") 
	BLOOMBERG("Bloomberg", null),
	
	/**
	 * The European Central Bank.
	 */
	@RosettaEnumValue(value = "EuroCentralBank") 
	EURO_CENTRAL_BANK("EuroCentralBank", null),
	
	/**
	 * The Federal Reserve, the central bank of the United States.
	 */
	@RosettaEnumValue(value = "FederalReserve") 
	FEDERAL_RESERVE("FederalReserve", null),
	
	/**
	 * The Federal Home Loan Bank of San Francisco, or its successor.
	 */
	@RosettaEnumValue(value = "FHLBSF") 
	FHLBSF("FHLBSF", null),
	
	/**
	 * ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate.
	 */
	@RosettaEnumValue(value = "ICESWAP") 
	ICESWAP("ICESWAP", null),
	
	/**
	 * International Swaps and Derivatives Association, Inc.
	 */
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	/**
	 * Refinitiv, formerly Thomson Reuters Financial &amp; Risk.
	 */
	@RosettaEnumValue(value = "Refinitiv") 
	REFINITIV("Refinitiv", null),
	
	/**
	 * The Reserve Bank of Australia.
	 */
	@RosettaEnumValue(value = "ReserveBankAustralia") 
	RESERVE_BANK_AUSTRALIA("ReserveBankAustralia", null),
	
	/**
	 * The Reserve Bank of New Zealand.
	 */
	@RosettaEnumValue(value = "ReserveBankNewZealand") 
	RESERVE_BANK_NEW_ZEALAND("ReserveBankNewZealand", null),
	
	/**
	 * Reuters Group Plc.
	 */
	@RosettaEnumValue(value = "Reuters") 
	REUTERS("Reuters", null),
	
	/**
	 * South African Futures Exchange, or its successor.
	 */
	@RosettaEnumValue(value = "SAFEX") 
	SAFEX("SAFEX", null),
	
	/**
	 * Telerate, Inc.
	 */
	@RosettaEnumValue(value = "Telerate") 
	TELERATE("Telerate", null),
	
	/**
	 * The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR.
	 */
	@RosettaEnumValue(value = "TOKYOSWAP") 
	TOKYOSWAP("TOKYOSWAP", null)
;
	private static Map<String, InformationProviderEnum> values;
	static {
        Map<String, InformationProviderEnum> map = new ConcurrentHashMap<>();
		for (InformationProviderEnum instance : InformationProviderEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	InformationProviderEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static InformationProviderEnum fromDisplayName(String name) {
		InformationProviderEnum value = values.get(name);
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
