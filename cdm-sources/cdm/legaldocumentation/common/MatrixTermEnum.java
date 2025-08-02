package cdm.legaldocumentation.common;

import cdm.legaldocumentation.common.MatrixTermEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix.
 * @version 6.0.0
 */
@RosettaEnum("MatrixTermEnum")
public enum MatrixTermEnum {

	/**
	 * Matrix Transaction Type of ASIA CORPORATE.
	 */
	@RosettaEnumValue(value = "AsiaCorporate") 
	ASIA_CORPORATE("AsiaCorporate", null),
	
	/**
	 * Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "AsiaFinancialCorporate") 
	ASIA_FINANCIAL_CORPORATE("AsiaFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of ASIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "AsiaSovereign") 
	ASIA_SOVEREIGN("AsiaSovereign", null),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA CORPORATE.
	 */
	@RosettaEnumValue(value = "AustraliaCorporate") 
	AUSTRALIA_CORPORATE("AustraliaCorporate", null),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "AustraliaFinancialCorporate") 
	AUSTRALIA_FINANCIAL_CORPORATE("AustraliaFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of AUSTRALIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "AustraliaSovereign") 
	AUSTRALIA_SOVEREIGN("AustraliaSovereign", null),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanAndMiddleEasternSovereign") 
	EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("EmergingEuropeanAndMiddleEasternSovereign", null),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporate") 
	EMERGING_EUROPEAN_CORPORATE("EmergingEuropeanCorporate", null),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanCorporateLPN") 
	EMERGING_EUROPEAN_CORPORATE_LPN("EmergingEuropeanCorporateLPN", null),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanFinancialCorporate") 
	EMERGING_EUROPEAN_FINANCIAL_CORPORATE("EmergingEuropeanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "EmergingEuropeanFinancialCorporateLPN") 
	EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN("EmergingEuropeanFinancialCorporateLPN", null),
	
	/**
	 * Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanCoCoFinancialCorporate") 
	EUROPEAN_CO_CO_FINANCIAL_CORPORATE("EuropeanCoCoFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanCorporate") 
	EUROPEAN_CORPORATE("EuropeanCorporate", null),
	
	/**
	 * Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanFinancialCorporate") 
	EUROPEAN_FINANCIAL_CORPORATE("EuropeanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "EuropeanSeniorNonPreferredFinancialCorporate") 
	EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE("EuropeanSeniorNonPreferredFinancialCorporate", null),
	
	/**
	 * The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets.
	 */
	@RosettaEnumValue(value = "IVS1OpenMarkets") 
	IVS_1_OPEN_MARKETS("IVS1OpenMarkets", null),
	
	/**
	 * Matrix Transaction Type of JAPAN CORPORATE.
	 */
	@RosettaEnumValue(value = "JapanCorporate") 
	JAPAN_CORPORATE("JapanCorporate", null),
	
	/**
	 * Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "JapanFinancialCorporate") 
	JAPAN_FINANCIAL_CORPORATE("JapanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of JAPAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "JapanSovereign") 
	JAPAN_SOVEREIGN("JapanSovereign", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporate") 
	LATIN_AMERICA_CORPORATE("LatinAmericaCorporate", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBond") 
	LATIN_AMERICA_CORPORATE_BOND("LatinAmericaCorporateBond", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "LatinAmericaCorporateBondOrLoan") 
	LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("LatinAmericaCorporateBondOrLoan", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
	 */
	@RosettaEnumValue(value = "LatinAmericaFinancialCorporateBond") 
	LATIN_AMERICA_FINANCIAL_CORPORATE_BOND("LatinAmericaFinancialCorporateBond", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
	 */
	@RosettaEnumValue(value = "LatinAmericaFinancialCorporateBondOrLoan") 
	LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN("LatinAmericaFinancialCorporateBondOrLoan", null),
	
	/**
	 * Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "LatinAmericaSovereign") 
	LATIN_AMERICA_SOVEREIGN("LatinAmericaSovereign", null),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND CORPORATE.
	 */
	@RosettaEnumValue(value = "NewZealandCorporate") 
	NEW_ZEALAND_CORPORATE("NewZealandCorporate", null),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "NewZealandFinancialCorporate") 
	NEW_ZEALAND_FINANCIAL_CORPORATE("NewZealandFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
	 */
	@RosettaEnumValue(value = "NewZealandSovereign") 
	NEW_ZEALAND_SOVEREIGN("NewZealandSovereign", null),
	
	/**
	 * Matrix Transaction Type of NORTH AMERICAN CORPORATE.
	 */
	@RosettaEnumValue(value = "NorthAmericanCorporate") 
	NORTH_AMERICAN_CORPORATE("NorthAmericanCorporate", null),
	
	/**
	 * Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "NorthAmericanFinancialCorporate") 
	NORTH_AMERICAN_FINANCIAL_CORPORATE("NorthAmericanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of SINGAPORE CORPORATE.
	 */
	@RosettaEnumValue(value = "SingaporeCorporate") 
	SINGAPORE_CORPORATE("SingaporeCorporate", null),
	
	/**
	 * Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "SingaporeFinancialCorporate") 
	SINGAPORE_FINANCIAL_CORPORATE("SingaporeFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of SINGAPORE SOVEREIGN.
	 */
	@RosettaEnumValue(value = "SingaporeSovereign") 
	SINGAPORE_SOVEREIGN("SingaporeSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAsiaCorporate") 
	STANDARD_ASIA_CORPORATE("StandardAsiaCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAsiaFinancialCorporate") 
	STANDARD_ASIA_FINANCIAL_CORPORATE("StandardAsiaFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAsiaSovereign") 
	STANDARD_ASIA_SOVEREIGN("StandardAsiaSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAustraliaCorporate") 
	STANDARD_AUSTRALIA_CORPORATE("StandardAustraliaCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardAustraliaFinancialCorporate") 
	STANDARD_AUSTRALIA_FINANCIAL_CORPORATE("StandardAustraliaFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardAustraliaSovereign") 
	STANDARD_AUSTRALIA_SOVEREIGN("StandardAustraliaSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanAndMiddleEasternSovereign") 
	STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN("StandardEmergingEuropeanAndMiddleEasternSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporate") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE("StandardEmergingEuropeanCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanCorporateLPN") 
	STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN("StandardEmergingEuropeanCorporateLPN", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanFinancialCorporate") 
	STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE("StandardEmergingEuropeanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
	 */
	@RosettaEnumValue(value = "StandardEmergingEuropeanFinancialCorporateLPN") 
	STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN("StandardEmergingEuropeanFinancialCorporateLPN", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanCoCoFinancialCorporate") 
	STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE("StandardEuropeanCoCoFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanCorporate") 
	STANDARD_EUROPEAN_CORPORATE("StandardEuropeanCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanFinancialCorporate") 
	STANDARD_EUROPEAN_FINANCIAL_CORPORATE("StandardEuropeanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardEuropeanSeniorNonPreferredFinancialCorporate") 
	STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE("StandardEuropeanSeniorNonPreferredFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardJapanCorporate") 
	STANDARD_JAPAN_CORPORATE("StandardJapanCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardJapanFinancialCorporate") 
	STANDARD_JAPAN_FINANCIAL_CORPORATE("StandardJapanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardJapanSovereign") 
	STANDARD_JAPAN_SOVEREIGN("StandardJapanSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBond") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND("StandardLatinAmericaCorporateBond", null),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaCorporateBondOrLoan") 
	STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN("StandardLatinAmericaCorporateBondOrLoan", null),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaFinancialCorporateBond") 
	STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND("StandardLatinAmericaFinancialCorporateBond", null),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaFinancialCorporateBondOrLoan") 
	STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN("StandardLatinAmericaFinancialCorporateBondOrLoan", null),
	
	/**
	 * Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardLatinAmericaSovereign") 
	STANDARD_LATIN_AMERICA_SOVEREIGN("StandardLatinAmericaSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNewZealandCorporate") 
	STANDARD_NEW_ZEALAND_CORPORATE("StandardNewZealandCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNewZealandFinancialCorporate") 
	STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE("StandardNewZealandFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardNewZealandSovereign") 
	STANDARD_NEW_ZEALAND_SOVEREIGN("StandardNewZealandSovereign", null),
	
	/**
	 * Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNorthAmericanCorporate") 
	STANDARD_NORTH_AMERICAN_CORPORATE("StandardNorthAmericanCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardNorthAmericanFinancialCorporate") 
	STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE("StandardNorthAmericanFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSingaporeCorporate") 
	STANDARD_SINGAPORE_CORPORATE("StandardSingaporeCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSingaporeFinancialCorporate") 
	STANDARD_SINGAPORE_FINANCIAL_CORPORATE("StandardSingaporeFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardSingaporeSovereign") 
	STANDARD_SINGAPORE_SOVEREIGN("StandardSingaporeSovereign", null),
	
	/**
	 * Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSubordinatedEuropeanInsuranceCorporate") 
	STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("StandardSubordinatedEuropeanInsuranceCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "StandardSukukFinancialCorporate") 
	STANDARD_SUKUK_FINANCIAL_CORPORATE("StandardSukukFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalFullFaithAndCredit") 
	STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT("StandardUSMunicipalFullFaithAndCredit", null),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalGeneralFund") 
	STANDARD_US_MUNICIPAL_GENERAL_FUND("StandardUSMunicipalGeneralFund", null),
	
	/**
	 * Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
	 */
	@RosettaEnumValue(value = "StandardUSMunicipalRevenue") 
	STANDARD_US_MUNICIPAL_REVENUE("StandardUSMunicipalRevenue", null),
	
	/**
	 * Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "StandardWesternEuropeanSovereign") 
	STANDARD_WESTERN_EUROPEAN_SOVEREIGN("StandardWesternEuropeanSovereign", null),
	
	/**
	 * Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	@RosettaEnumValue(value = "SubordinatedEuropeanInsuranceCorporate") 
	SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE("SubordinatedEuropeanInsuranceCorporate", null),
	
	/**
	 * Matrix Transaction Type of SUKUK CORPORATE.
	 */
	@RosettaEnumValue(value = "SukukCorporate") 
	SUKUK_CORPORATE("SukukCorporate", null),
	
	/**
	 * Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
	 */
	@RosettaEnumValue(value = "SukukFinancialCorporate") 
	SUKUK_FINANCIAL_CORPORATE("SukukFinancialCorporate", null),
	
	/**
	 * Matrix Transaction Type of SUKUK SOVEREIGN.
	 */
	@RosettaEnumValue(value = "SukukSovereign") 
	SUKUK_SOVEREIGN("SukukSovereign", null),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	@RosettaEnumValue(value = "USMunicipalFullFaithAndCredit") 
	US_MUNICIPAL_FULL_FAITH_AND_CREDIT("USMunicipalFullFaithAndCredit", null),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
	 */
	@RosettaEnumValue(value = "USMunicipalGeneralFund") 
	US_MUNICIPAL_GENERAL_FUND("USMunicipalGeneralFund", null),
	
	/**
	 * Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
	 */
	@RosettaEnumValue(value = "USMunicipalRevenue") 
	US_MUNICIPAL_REVENUE("USMunicipalRevenue", null),
	
	/**
	 * Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
	 */
	@RosettaEnumValue(value = "WesternEuropeanSovereign") 
	WESTERN_EUROPEAN_SOVEREIGN("WesternEuropeanSovereign", null)
;
	private static Map<String, MatrixTermEnum> values;
	static {
        Map<String, MatrixTermEnum> map = new ConcurrentHashMap<>();
		for (MatrixTermEnum instance : MatrixTermEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	MatrixTermEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static MatrixTermEnum fromDisplayName(String name) {
		MatrixTermEnum value = values.get(name);
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
