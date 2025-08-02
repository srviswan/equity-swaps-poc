# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MatrixTermEnum']

class MatrixTermEnum(Enum):
    """
    The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix.
    """
    ASIA_CORPORATE = "AsiaCorporate"
    """
    Matrix Transaction Type of ASIA CORPORATE.
    """
    ASIA_FINANCIAL_CORPORATE = "AsiaFinancialCorporate"
    """
    Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
    """
    ASIA_SOVEREIGN = "AsiaSovereign"
    """
    Matrix Transaction Type of ASIA SOVEREIGN.
    """
    AUSTRALIA_CORPORATE = "AustraliaCorporate"
    """
    Matrix Transaction Type of AUSTRALIA CORPORATE.
    """
    AUSTRALIA_FINANCIAL_CORPORATE = "AustraliaFinancialCorporate"
    """
    Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
    """
    AUSTRALIA_SOVEREIGN = "AustraliaSovereign"
    """
    Matrix Transaction Type of AUSTRALIA SOVEREIGN.
    """
    EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN = "EmergingEuropeanAndMiddleEasternSovereign"
    """
    Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
    """
    EMERGING_EUROPEAN_CORPORATE = "EmergingEuropeanCorporate"
    """
    Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
    """
    EMERGING_EUROPEAN_CORPORATE_LPN = "EmergingEuropeanCorporateLPN"
    """
    Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
    """
    EMERGING_EUROPEAN_FINANCIAL_CORPORATE = "EmergingEuropeanFinancialCorporate"
    """
    Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
    """
    EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN = "EmergingEuropeanFinancialCorporateLPN"
    """
    Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
    """
    EUROPEAN_CO_CO_FINANCIAL_CORPORATE = "EuropeanCoCoFinancialCorporate"
    """
    Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
    """
    EUROPEAN_CORPORATE = "EuropeanCorporate"
    """
    Matrix Transaction Type of EUROPEAN CORPORATE.
    """
    EUROPEAN_FINANCIAL_CORPORATE = "EuropeanFinancialCorporate"
    """
    Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
    """
    EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE = "EuropeanSeniorNonPreferredFinancialCorporate"
    """
    Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
    """
    IVS_1_OPEN_MARKETS = "IVS1OpenMarkets"
    """
    The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets.
    """
    JAPAN_CORPORATE = "JapanCorporate"
    """
    Matrix Transaction Type of JAPAN CORPORATE.
    """
    JAPAN_FINANCIAL_CORPORATE = "JapanFinancialCorporate"
    """
    Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
    """
    JAPAN_SOVEREIGN = "JapanSovereign"
    """
    Matrix Transaction Type of JAPAN SOVEREIGN.
    """
    LATIN_AMERICA_CORPORATE = "LatinAmericaCorporate"
    """
    Matrix Transaction Type of LATIN AMERICA CORPORATE.
    """
    LATIN_AMERICA_CORPORATE_BOND = "LatinAmericaCorporateBond"
    """
    Matrix Transaction Type of LATIN AMERICA CORPORATE B.
    """
    LATIN_AMERICA_CORPORATE_BOND_OR_LOAN = "LatinAmericaCorporateBondOrLoan"
    """
    Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
    """
    LATIN_AMERICA_FINANCIAL_CORPORATE_BOND = "LatinAmericaFinancialCorporateBond"
    """
    Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
    """
    LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN = "LatinAmericaFinancialCorporateBondOrLoan"
    """
    Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
    """
    LATIN_AMERICA_SOVEREIGN = "LatinAmericaSovereign"
    """
    Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
    """
    NEW_ZEALAND_CORPORATE = "NewZealandCorporate"
    """
    Matrix Transaction Type of NEW ZEALAND CORPORATE.
    """
    NEW_ZEALAND_FINANCIAL_CORPORATE = "NewZealandFinancialCorporate"
    """
    Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
    """
    NEW_ZEALAND_SOVEREIGN = "NewZealandSovereign"
    """
    Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
    """
    NORTH_AMERICAN_CORPORATE = "NorthAmericanCorporate"
    """
    Matrix Transaction Type of NORTH AMERICAN CORPORATE.
    """
    NORTH_AMERICAN_FINANCIAL_CORPORATE = "NorthAmericanFinancialCorporate"
    """
    Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
    """
    SINGAPORE_CORPORATE = "SingaporeCorporate"
    """
    Matrix Transaction Type of SINGAPORE CORPORATE.
    """
    SINGAPORE_FINANCIAL_CORPORATE = "SingaporeFinancialCorporate"
    """
    Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
    """
    SINGAPORE_SOVEREIGN = "SingaporeSovereign"
    """
    Matrix Transaction Type of SINGAPORE SOVEREIGN.
    """
    STANDARD_ASIA_CORPORATE = "StandardAsiaCorporate"
    """
    Matrix Transaction Type of STANDARD ASIA CORPORATE.
    """
    STANDARD_ASIA_FINANCIAL_CORPORATE = "StandardAsiaFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
    """
    STANDARD_ASIA_SOVEREIGN = "StandardAsiaSovereign"
    """
    Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
    """
    STANDARD_AUSTRALIA_CORPORATE = "StandardAustraliaCorporate"
    """
    Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
    """
    STANDARD_AUSTRALIA_FINANCIAL_CORPORATE = "StandardAustraliaFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
    """
    STANDARD_AUSTRALIA_SOVEREIGN = "StandardAustraliaSovereign"
    """
    Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
    """
    STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN = "StandardEmergingEuropeanAndMiddleEasternSovereign"
    """
    Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
    """
    STANDARD_EMERGING_EUROPEAN_CORPORATE = "StandardEmergingEuropeanCorporate"
    """
    Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
    """
    STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN = "StandardEmergingEuropeanCorporateLPN"
    """
    Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
    """
    STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE = "StandardEmergingEuropeanFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
    """
    STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN = "StandardEmergingEuropeanFinancialCorporateLPN"
    """
    Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
    """
    STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE = "StandardEuropeanCoCoFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
    """
    STANDARD_EUROPEAN_CORPORATE = "StandardEuropeanCorporate"
    """
    Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
    """
    STANDARD_EUROPEAN_FINANCIAL_CORPORATE = "StandardEuropeanFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
    """
    STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE = "StandardEuropeanSeniorNonPreferredFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
    """
    STANDARD_JAPAN_CORPORATE = "StandardJapanCorporate"
    """
    Matrix Transaction Type of STANDARD JAPAN CORPORATE.
    """
    STANDARD_JAPAN_FINANCIAL_CORPORATE = "StandardJapanFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
    """
    STANDARD_JAPAN_SOVEREIGN = "StandardJapanSovereign"
    """
    Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
    """
    STANDARD_LATIN_AMERICA_CORPORATE_BOND = "StandardLatinAmericaCorporateBond"
    """
    Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
    """
    STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN = "StandardLatinAmericaCorporateBondOrLoan"
    """
    Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
    """
    STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND = "StandardLatinAmericaFinancialCorporateBond"
    """
    Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
    """
    STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN = "StandardLatinAmericaFinancialCorporateBondOrLoan"
    """
    Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
    """
    STANDARD_LATIN_AMERICA_SOVEREIGN = "StandardLatinAmericaSovereign"
    """
    Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
    """
    STANDARD_NEW_ZEALAND_CORPORATE = "StandardNewZealandCorporate"
    """
    Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
    """
    STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE = "StandardNewZealandFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
    """
    STANDARD_NEW_ZEALAND_SOVEREIGN = "StandardNewZealandSovereign"
    """
    Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
    """
    STANDARD_NORTH_AMERICAN_CORPORATE = "StandardNorthAmericanCorporate"
    """
    Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
    """
    STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE = "StandardNorthAmericanFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
    """
    STANDARD_SINGAPORE_CORPORATE = "StandardSingaporeCorporate"
    """
    Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
    """
    STANDARD_SINGAPORE_FINANCIAL_CORPORATE = "StandardSingaporeFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
    """
    STANDARD_SINGAPORE_SOVEREIGN = "StandardSingaporeSovereign"
    """
    Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
    """
    STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE = "StandardSubordinatedEuropeanInsuranceCorporate"
    """
    Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
    """
    STANDARD_SUKUK_FINANCIAL_CORPORATE = "StandardSukukFinancialCorporate"
    """
    Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
    """
    STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT = "StandardUSMunicipalFullFaithAndCredit"
    """
    Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
    """
    STANDARD_US_MUNICIPAL_GENERAL_FUND = "StandardUSMunicipalGeneralFund"
    """
    Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
    """
    STANDARD_US_MUNICIPAL_REVENUE = "StandardUSMunicipalRevenue"
    """
    Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
    """
    STANDARD_WESTERN_EUROPEAN_SOVEREIGN = "StandardWesternEuropeanSovereign"
    """
    Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
    """
    SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE = "SubordinatedEuropeanInsuranceCorporate"
    """
    Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
    """
    SUKUK_CORPORATE = "SukukCorporate"
    """
    Matrix Transaction Type of SUKUK CORPORATE.
    """
    SUKUK_FINANCIAL_CORPORATE = "SukukFinancialCorporate"
    """
    Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
    """
    SUKUK_SOVEREIGN = "SukukSovereign"
    """
    Matrix Transaction Type of SUKUK SOVEREIGN.
    """
    US_MUNICIPAL_FULL_FAITH_AND_CREDIT = "USMunicipalFullFaithAndCredit"
    """
    Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
    """
    US_MUNICIPAL_GENERAL_FUND = "USMunicipalGeneralFund"
    """
    Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
    """
    US_MUNICIPAL_REVENUE = "USMunicipalRevenue"
    """
    Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
    """
    WESTERN_EUROPEAN_SOVEREIGN = "WesternEuropeanSovereign"
    """
    Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
    """
