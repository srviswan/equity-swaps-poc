/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MasterConfirmationTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints.
   */
  
  const (
  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation.
   */
  DJ_CDX_EM MasterConfirmationTypeEnum = iota + 1
  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation.
   */
  DJ_CDX_EM_DIV MasterConfirmationTypeEnum = iota + 1
  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO.
   */
  DJ_CDX_NA MasterConfirmationTypeEnum = iota + 1
  /**
   * Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement.
   */
  DJ_I_TRAXX_EUROPE MasterConfirmationTypeEnum = iota + 1
  /**
   * A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement.
   */
  EQUITY_AMERICAS MasterConfirmationTypeEnum = iota + 1
  /**
   * A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement.
   */
  EQUITY_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement.
   */
  EQUITY_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 1999 Master Credit Derivatives Confirmation Agreement
   */
  ISDA_1999_CREDIT MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_NORTH_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_SINGAPORE MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign.
   */
  ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign.
   */
  ISDA_2003_STANDARD_CREDIT_SINGAPORE MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1 MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2 MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_JAPANESE_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2006 Variance Swap Japanese Confirmation Agreement applies.
   */
  ISDA_2006_VARIANCE_SWAP_JAPANESE MasterConfirmationTypeEnum = iota + 1
  /**
   * ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies.
   */
  ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2007_EQUITY_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_AMERICAS MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1 MasterConfirmationTypeEnum = iota + 1
  /**
   * The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2 MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1 MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
   */
  ISDA_2008_DIVIDEND_SWAP_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
   */
  ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1 MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_AMERICAS MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1 MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_AMERICAS MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_EUROPEAN_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_PAN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2010_EQUITY_EMEA_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_AMERICAS MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_JAPANESE MasterConfirmationTypeEnum = iota + 1
  /**
   * Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies.
   */
  _2003_CREDIT_INDEX MasterConfirmationTypeEnum = iota + 1
  /**
   * A privately negotiated European Interdealer Master Confirmation Agreement applies.
   */
  _2004_EQUITY_EUROPEAN_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * A privately negotiated European Interdealer Master Confirmation Agreement applies.
   */
  _2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies.
   */
  _2006_DIVIDEND_SWAP_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * A European Interdealer Master Confirmation Agreement not defined by ISDA applies.
   */
  _2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value AsiaCorporate.
   */
  _2014_CREDIT_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate.
   */
  _2014_CREDIT_ASIA_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate.
   */
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate.
   */
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value EuropeanCorporate.
   */
  _2014_CREDIT_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate.
   */
  _2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate.
   */
  _2014_CREDIT_EUROPEAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value JapanCorporate.
   */
  _2014_CREDIT_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value JapanFinancialCorporate.
   */
  _2014_CREDIT_JAPAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value NorthAmericanCorporate.
   */
  _2014_CREDIT_NORTH_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate.
   */
  _2014_CREDIT_NORTH_AMERICAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values SingaporeCorporate.
   */
  _2014_CREDIT_SINGAPORE MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate.
   */
  _2014_CREDIT_SINGAPORE_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value AsiaSovereign.
   */
  _2014_CREDIT_SOVEREIGN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign.
   */
  _2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value JapanSovereign.
   */
  _2014_CREDIT_SOVEREIGN_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value LatinAmericaSovereign.
   */
  _2014_CREDIT_SOVEREIGN_LATIN_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign.
   */
  _2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
   */
  _2014_STANDARD_CREDIT_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_ASIA_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate.
   */
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
   */
  _2014_STANDARD_CREDIT_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_JAPAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
   */
  _2014_STANDARD_CREDIT_NORTH_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate.
   */
  _2014_STANDARD_CREDIT_SINGAPORE MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardAsiaSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_ASIA MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_JAPAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN MasterConfirmationTypeEnum = iota + 1
  /**
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN MasterConfirmationTypeEnum = iota + 1
  )    
