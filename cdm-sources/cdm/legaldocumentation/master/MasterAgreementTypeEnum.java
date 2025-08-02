package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the type of the master agreement governing the transaction.
 * @version 6.0.0
 */
@RosettaEnum("MasterAgreementTypeEnum")
public enum MasterAgreementTypeEnum {

	/**
	 * AFB Master Agreement for Foreign Exchange and Derivatives Transactions
	 */
	@RosettaEnumValue(value = "AFB") 
	AFB("AFB", null),
	
	/**
	 * A Bespoke (custom) Master Agreement, including one-off agreements for transactions
	 */
	@RosettaEnumValue(value = "Bespoke") 
	BESPOKE("Bespoke", null),
	
	/**
	 * Clearing Master Agreement
	 */
	@RosettaEnumValue(value = "CMA") 
	CMA("CMA", null),
	
	/**
	 * Contrato Marco de Operaciones Financieras
	 */
	@RosettaEnumValue(value = "CMOF") 
	CMOF("CMOF", null),
	
	/**
	 * EEI Master Power Purchase and Sale Agreement
	 */
	@RosettaEnumValue(value = "EEIPower") 
	EEI_POWER("EEIPower", null),
	
	/**
	 * EFET General Agreement Concerning the Delivery and Acceptance of Electricity
	 */
	@RosettaEnumValue(value = "EFETElectricity") 
	EFET_ELECTRICITY("EFETElectricity", null),
	
	/**
	 * EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
	 */
	@RosettaEnumValue(value = "EFETGas") 
	EFET_GAS("EFETGas", null),
	
	/**
	 * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
	 */
	@RosettaEnumValue(value = "EMA") 
	EMA("EMA", null),
	
	/**
	 * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
	 */
	@RosettaEnumValue(value = "FBF") 
	FBF("FBF", null),
	
	/**
	 * GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas
	 */
	@RosettaEnumValue(value = "GasEDI") 
	GAS_EDI("GasEDI", null),
	
	/**
	 * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
	 */
	@RosettaEnumValue(value = "German") 
	GERMAN("German", null),
	
	/**
	 * ICMA Global Master Agreement for REPO Trades
	 */
	@RosettaEnumValue(value = "GMRA") 
	GMRA("GMRA", null),
	
	/**
	 * ISLA Global Master Agreement for Securities Lending
	 */
	@RosettaEnumValue(value = "GMSLA") 
	GMSLA("GMSLA", null),
	
	/**
	 * FOA Grid Trade Master Agreement
	 */
	@RosettaEnumValue(value = "GTMA") 
	GTMA("GTMA", null),
	
	/**
	 * International Currency Options Market Master Agreement
	 */
	@RosettaEnumValue(value = "ICOM") 
	ICOM("ICOM", null),
	
	/**
	 * International Emissions Trading Association Emissions Reduction Purchase Agreement
	 */
	@RosettaEnumValue(value = "IETA_ERPA", displayName = "IETA-ERPA") 
	IETA_ERPA("IETA_ERPA", "IETA-ERPA"),
	
	/**
	 * International Emissions Trading Association Emissions Trading Master Agreement
	 */
	@RosettaEnumValue(value = "IETA_ETMA", displayName = "IETA-ETMA") 
	IETA_ETMA("IETA_ETMA", "IETA-ETMA"),
	
	/**
	 * International Emissions Trading Association International Emissions Trading Master Agreement
	 */
	@RosettaEnumValue(value = "IETA_IETMA", displayName = "IETA-IETMA") 
	IETA_IETMA("IETA_IETMA", "IETA-IETMA"),
	
	/**
	 * International Foreign Exchange Master Agreement
	 */
	@RosettaEnumValue(value = "IFEMA") 
	IFEMA("IFEMA", null),
	
	/**
	 * International Foreign Exchange and Options Master Agreement
	 */
	@RosettaEnumValue(value = "IFEOMA") 
	IFEOMA("IFEOMA", null),
	
	/**
	 * ISDA Master Agreement
	 */
	@RosettaEnumValue(value = "ISDAMaster") 
	ISDA_MASTER("ISDAMaster", null),
	
	/**
	 * ISDA-FIA Cleared Derivatives Execution Agreement
	 */
	@RosettaEnumValue(value = "ISDAFIA_CDEA", displayName = "ISDAFIA-CDEA") 
	ISDAFIA_CDEA("ISDAFIA_CDEA", "ISDAFIA-CDEA"),
	
	/**
	 * ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA)
	 */
	@RosettaEnumValue(value = "ISDAIIFM_TMA", displayName = "ISDAIIFM-TMA") 
	ISDAIIFM_TMA("ISDAIIFM_TMA", "ISDAIIFM-TMA"),
	
	/**
	 * Master agreement of Japan Securities Clearing Corporation
	 */
	@RosettaEnumValue(value = "JSCC") 
	JSCC("JSCC", null),
	
	/**
	 * International Bullion Master Agreement Terms published by the London Bullion Market Association
	 */
	@RosettaEnumValue(value = "LBMA") 
	LBMA("LBMA", null),
	
	/**
	 * Leadership in Energy Automated Processing
	 */
	@RosettaEnumValue(value = "LEAP") 
	LEAP("LEAP", null),
	
	/**
	 * CTA Master Coal Purchase and Sales Agreement
	 */
	@RosettaEnumValue(value = "MCPSA") 
	MCPSA("MCPSA", null),
	
	/**
	 * NAESB Base Contract for Sale and Purchase of Natural Gas
	 */
	@RosettaEnumValue(value = "NAESBGas") 
	NAESB_GAS("NAESBGas", null),
	
	/**
	 * Short Term Flat NBP Trading Terms and Conditions
	 */
	@RosettaEnumValue(value = "NBP") 
	NBP("NBP", null),
	
	/**
	 * Standard Documentation for Derivative Transactions on the Russian Financial Markets
	 */
	@RosettaEnumValue(value = "RussianDerivatives") 
	RUSSIAN_DERIVATIVES("RussianDerivatives", null),
	
	/**
	 * Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market
	 */
	@RosettaEnumValue(value = "RussianRepo") 
	RUSSIAN_REPO("RussianRepo", null),
	
	/**
	 * globalCOAL Standard Coal Trading Agreement
	 */
	@RosettaEnumValue(value = "SCoTA") 
	S_CO_TA("SCoTA", null),
	
	/**
	 * Swiss Master Agreement for OTC Derivatives Instruments
	 */
	@RosettaEnumValue(value = "Swiss") 
	SWISS("Swiss", null),
	
	/**
	 * TTF Hub Natural Gas Trading Terms and Conditions
	 */
	@RosettaEnumValue(value = "TTF") 
	TTF("TTF", null),
	
	/**
	 * Zeebrugge Hub Natural Gas Trading Terms and Conditions
	 */
	@RosettaEnumValue(value = "ZBT") 
	ZBT("ZBT", null)
;
	private static Map<String, MasterAgreementTypeEnum> values;
	static {
        Map<String, MasterAgreementTypeEnum> map = new ConcurrentHashMap<>();
		for (MasterAgreementTypeEnum instance : MasterAgreementTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MasterAgreementTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MasterAgreementTypeEnum fromDisplayName(String name) {
		MasterAgreementTypeEnum value = values.get(name);
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
