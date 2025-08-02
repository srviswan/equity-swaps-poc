# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MasterConfirmationTypeEnum']

class MasterConfirmationTypeEnum(Enum):
    """
    The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints.
    """
    DJ_CDX_EM = "DJ.CDX.EM"
    """
    Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation.
    """
    DJ_CDX_EM_DIV = "DJ.CDX.EM.DIV"
    """
    Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation.
    """
    DJ_CDX_NA = "DJ.CDX.NA"
    """
    Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO.
    """
    DJ_I_TRAXX_EUROPE = "DJ.iTraxx.Europe"
    """
    Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement.
    """
    EQUITY_AMERICAS = "EquityAmericas"
    """
    A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement.
    """
    EQUITY_ASIA = "EquityAsia"
    """
    A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement.
    """
    EQUITY_EUROPEAN = "EquityEuropean"
    """
    A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement.
    """
    ISDA_1999_CREDIT = "ISDA1999Credit"
    """
    ISDA 1999 Master Credit Derivatives Confirmation Agreement
    """
    ISDA_2003_CREDIT_ASIA = "ISDA2003CreditAsia"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND = "ISDA2003CreditAustraliaNewZealand"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_EUROPEAN = "ISDA2003CreditEuropean"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_JAPAN = "ISDA2003CreditJapan"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_NORTH_AMERICAN = "ISDA2003CreditNorthAmerican"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_SINGAPORE = "ISDA2003CreditSingapore"
    """
    ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2003_CREDIT_SOVEREIGN_ASIA = "ISDA2003CreditSovereignAsia"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE = "ISDA2003CreditSovereignCentralAndEasternEurope"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_CREDIT_SOVEREIGN_JAPAN = "ISDA2003CreditSovereignJapan"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA = "ISDA2003CreditSovereignLatinAmerica"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST = "ISDA2003CreditSovereignMiddleEast"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE = "ISDA2003CreditSovereignWesternEurope"
    """
    ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    """
    ISDA_2003_STANDARD_CREDIT_ASIA = "ISDA2003StandardCreditAsia"
    """
    Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
    """
    ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND = "ISDA2003StandardCreditAustraliaNewZealand"
    """
    Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign.
    """
    ISDA_2003_STANDARD_CREDIT_EUROPEAN = "ISDA2003StandardCreditEuropean"
    """
    Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
    """
    ISDA_2003_STANDARD_CREDIT_JAPAN = "ISDA2003StandardCreditJapan"
    """
    Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
    """
    ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN = "ISDA2003StandardCreditNorthAmerican"
    """
    Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
    """
    ISDA_2003_STANDARD_CREDIT_SINGAPORE = "ISDA2003StandardCreditSingapore"
    """
    Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign.
    """
    ISDA_2004_CREDIT_SOVEREIGN_ASIA = "ISDA2004CreditSovereignAsia"
    """
    ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = "ISDA2004CreditSovereignEmergingEuropeanAndMiddleEastern"
    """
    ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2004_CREDIT_SOVEREIGN_JAPAN = "ISDA2004CreditSovereignJapan"
    """
    ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN = "ISDA2004CreditSovereignLatinAmerican"
    """
    ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = "ISDA2004CreditSovereignWesternEuropean"
    """
    ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement.
    """
    ISDA_2004_EQUITY_AMERICAS_INTERDEALER = "ISDA2004EquityAmericasInterdealer"
    """
    The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1 = "ISDA2004EquityAmericasInterdealerRev1"
    """
    The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA = "ISDA2004StandardCreditSovereignAsia"
    """
    Dummy MCA value mirroring the matrix term values StandardAsiaSovereign.
    """
    ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = "ISDA2004StandardCreditSovereignEmergingEuropeanAndMiddleEastern"
    """
    Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
    """
    ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN = "ISDA2004StandardCreditSovereignJapan"
    """
    Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
    """
    ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN = "ISDA2004StandardCreditSovereignLatinAmerican"
    """
    Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
    """
    ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = "ISDA2004StandardCreditSovereignWesternEuropean"
    """
    Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
    """
    ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER = "ISDA2005EquityAsiaExcludingJapanInterdealer"
    """
    ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2 = "ISDA2005EquityAsiaExcludingJapanInterdealerRev2"
    """
    Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2005_EQUITY_JAPANESE_INTERDEALER = "ISDA2005EquityJapaneseInterdealer"
    """
    The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2006_VARIANCE_SWAP_JAPANESE = "ISDA2006VarianceSwapJapanese"
    """
    ISDA 2006 Variance Swap Japanese Confirmation Agreement applies.
    """
    ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER = "ISDA2006VarianceSwapJapaneseInterdealer"
    """
    ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies.
    """
    ISDA_2007_EQUITY_EUROPEAN = "ISDA2007EquityEuropean"
    """
    The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_AMERICAS = "ISDA2007VarianceSwapAmericas"
    """
    The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN = "ISDA2007VarianceSwapAsiaExcludingJapan"
    """
    The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1 = "ISDA2007VarianceSwapAsiaExcludingJapanRev1"
    """
    The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2 = "ISDA2007VarianceSwapAsiaExcludingJapanRev2"
    """
    The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_EUROPEAN = "ISDA2007VarianceSwapEuropean"
    """
    The ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    """
    ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1 = "ISDA2007VarianceSwapEuropeanRev1"
    """
    The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    """
    ISDA_2008_DIVIDEND_SWAP_JAPAN = "ISDA2008DividendSwapJapan"
    """
    The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
    """
    ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1 = "ISDA2008DividendSwapJapaneseRev1"
    """
    The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_AMERICAS = "ISDA2008EquityAmericas"
    """
    The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN = "ISDA2008EquityAsiaExcludingJapan"
    """
    The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1 = "ISDA2008EquityAsiaExcludingJapanRev1"
    """
    The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2008_EQUITY_JAPAN = "ISDA2008EquityJapan"
    """
    The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_EQUITY_AMERICAS = "ISDA2009EquityAmericas"
    """
    The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_EQUITY_EUROPEAN_INTERDEALER = "ISDA2009EquityEuropeanInterdealer"
    """
    The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2009_EQUITY_PAN_ASIA = "ISDA2009EquityPanAsia"
    """
    2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2010_EQUITY_EMEA_INTERDEALER = "ISDA2010EquityEMEAInterdealer"
    """
    The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
    """
    ISDA_2013_VOLATILITY_SWAP_AMERICAS = "ISDA2013VolatilitySwapAmericas"
    """
    The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies.
    """
    ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN = "ISDA2013VolatilitySwapAsiaExcludingJapan"
    """
    The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies.
    """
    ISDA_2013_VOLATILITY_SWAP_EUROPEAN = "ISDA2013VolatilitySwapEuropean"
    """
    The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies.
    """
    ISDA_2013_VOLATILITY_SWAP_JAPANESE = "ISDA2013VolatilitySwapJapanese"
    """
    The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies.
    """
    _2003_CREDIT_INDEX = "2003CreditIndex"
    """
    Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies.
    """
    _2004_EQUITY_EUROPEAN_INTERDEALER = "2004EquityEuropeanInterdealer"
    """
    A privately negotiated European Interdealer Master Confirmation Agreement applies.
    """
    _2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER = "2005VarianceSwapEuropeanInterdealer"
    """
    A privately negotiated European Interdealer Master Confirmation Agreement applies.
    """
    _2006_DIVIDEND_SWAP_EUROPEAN = "2006DividendSwapEuropean"
    """
    A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies.
    """
    _2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER = "2006DividendSwapEuropeanInterdealer"
    """
    A European Interdealer Master Confirmation Agreement not defined by ISDA applies.
    """
    _2014_CREDIT_ASIA = "2014CreditAsia"
    """
    Dummy MCA value mirroring the matrix term value AsiaCorporate.
    """
    _2014_CREDIT_ASIA_FINANCIAL = "2014CreditAsiaFinancial"
    """
    Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate.
    """
    _2014_CREDIT_AUSTRALIA_NEW_ZEALAND = "2014CreditAustraliaNewZealand"
    """
    Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate.
    """
    _2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL = "2014CreditAustraliaNewZealandFinancial"
    """
    Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate.
    """
    _2014_CREDIT_EUROPEAN = "2014CreditEuropean"
    """
    Dummy MCA value mirroring the matrix term value EuropeanCorporate.
    """
    _2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL = "2014CreditEuropeanCoCoFinancial"
    """
    Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate.
    """
    _2014_CREDIT_EUROPEAN_FINANCIAL = "2014CreditEuropeanFinancial"
    """
    Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate.
    """
    _2014_CREDIT_JAPAN = "2014CreditJapan"
    """
    Dummy MCA value mirroring the matrix term value JapanCorporate.
    """
    _2014_CREDIT_JAPAN_FINANCIAL = "2014CreditJapanFinancial"
    """
    Dummy MCA value mirroring the matrix term value JapanFinancialCorporate.
    """
    _2014_CREDIT_NORTH_AMERICAN = "2014CreditNorthAmerican"
    """
    Dummy MCA value mirroring the matrix term value NorthAmericanCorporate.
    """
    _2014_CREDIT_NORTH_AMERICAN_FINANCIAL = "2014CreditNorthAmericanFinancial"
    """
    Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate.
    """
    _2014_CREDIT_SINGAPORE = "2014CreditSingapore"
    """
    Dummy MCA value mirroring the matrix term values SingaporeCorporate.
    """
    _2014_CREDIT_SINGAPORE_FINANCIAL = "2014CreditSingaporeFinancial"
    """
    Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate.
    """
    _2014_CREDIT_SOVEREIGN_ASIA = "2014CreditSovereignAsia"
    """
    Dummy MCA value mirroring the matrix term value AsiaSovereign.
    """
    _2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = "2014CreditSovereignEmergingEuropeanAndMiddleEastern"
    """
    Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign.
    """
    _2014_CREDIT_SOVEREIGN_JAPAN = "2014CreditSovereignJapan"
    """
    Dummy MCA value mirroring the matrix term value JapanSovereign.
    """
    _2014_CREDIT_SOVEREIGN_LATIN_AMERICAN = "2014CreditSovereignLatinAmerican"
    """
    Dummy MCA value mirroring the matrix term value LatinAmericaSovereign.
    """
    _2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = "2014CreditSovereignWesternEuropean"
    """
    Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign.
    """
    _2014_STANDARD_CREDIT_ASIA = "2014StandardCreditAsia"
    """
    Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
    """
    _2014_STANDARD_CREDIT_ASIA_FINANCIAL = "2014StandardCreditAsiaFinancial"
    """
    Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND = "2014StandardCreditAustraliaNewZealand"
    """
    Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate.
    """
    _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL = "2014StandardCreditAustraliaNewZealandFinancial"
    """
    Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_EUROPEAN = "2014StandardCreditEuropean"
    """
    Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
    """
    _2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL = "2014StandardCreditEuropeanCoCoFinancial"
    """
    Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL = "2014StandardCreditEuropeanFinancial"
    """
    Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_JAPAN = "2014StandardCreditJapan"
    """
    Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
    """
    _2014_STANDARD_CREDIT_JAPAN_FINANCIAL = "2014StandardCreditJapanFinancial"
    """
    Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_NORTH_AMERICAN = "2014StandardCreditNorthAmerican"
    """
    Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
    """
    _2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL = "2014StandardCreditNorthAmericanFinancial"
    """
    Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_SINGAPORE = "2014StandardCreditSingapore"
    """
    Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate.
    """
    _2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL = "2014StandardCreditSingaporeFinancial"
    """
    Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate.
    """
    _2014_STANDARD_CREDIT_SOVEREIGN_ASIA = "2014StandardCreditSovereignAsia"
    """
    Dummy MCA value mirroring the matrix term value StandardAsiaSovereign.
    """
    _2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = "2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern"
    """
    Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
    """
    _2014_STANDARD_CREDIT_SOVEREIGN_JAPAN = "2014StandardCreditSovereignJapan"
    """
    Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
    """
    _2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN = "2014StandardCreditSovereignLatinAmerican"
    """
    Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
    """
    _2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = "2014StandardCreditSovereignWesternEuropean"
    """
    Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
    """
