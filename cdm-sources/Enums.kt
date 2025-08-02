/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
package org.isda.cdm.kotlin

import kotlinx.serialization.*

/** 
 * The enumeration values to qualify the type of account. 
 */
@Serializable
enum class AccountTypeEnum {
  /** 
   * Aggregate client account, as defined under ESMA MiFIR. 
   */
  @SerialName("AGGREGATE_CLIENT")
  AGGREGATE_CLIENT,
  /** 
   * The account contains trading activity or positions that belong to a client of the firm that opened the account. 
   */
  @SerialName("CLIENT")
  CLIENT,
  /** 
   * The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account. 
   */
  @SerialName("HOUSE")
  HOUSE
  ;
}

/** 
 * The enumeration values to specify the actions associated with transactions. 
 */
@Serializable
enum class ActionEnum {
  /** 
   * A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1. 
   */
  @SerialName("CANCEL")
  CANCEL,
  /** 
   * A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1. 
   */
  @SerialName("CORRECT")
  CORRECT,
  /** 
   * A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1. 
   */
  @SerialName("NEW")
  NEW
  ;
}

/** 
 * Enumeration for the different types of affirmation status. 
 */
@Serializable
enum class AffirmationStatusEnum {
  @SerialName("AFFIRMED")
  AFFIRMED,
  @SerialName("UNAFFIRMED")
  UNAFFIRMED
  ;
}

/** 
 * If there is an alternative to interest amounts, how is it specified? 
 */
@Serializable
enum class AlternativeToInterestAmountEnum {
  /** 
   * The standard calculation of the Interest Amount is replaced with the amount of interest the secured party actually receives in relation to the Cash collateral. 
   */
  @SerialName("ACTUAL_AMOUNT_RECEIVED")
  ACTUAL_AMOUNT_RECEIVED,
  /** 
   * An other alternative option outside these choices that can be described as an alternative provision. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Interest amount is not transferred if transfer would create or increase a delivery amount. 
   */
  @SerialName("STANDARD")
  STANDARD,
  /** 
   * Interest amount is not transferred if transfer would create or increase a delivery amount. (This is the 'Standard' provision). However, interest Amount will be transferred if Delivery Amount is below Minimum Transfer Amount. 
   */
  @SerialName("TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA")
  TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA
  ;
}

/** 
 * Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference. 
 */
@Serializable
enum class AncillaryRoleEnum {
  /** 
   * Specifies the party responsible for deciding the fallback rate. 
   */
  @SerialName("CALCULATION_AGENT_FALLBACK")
  CALCULATION_AGENT_FALLBACK,
  /** 
   * Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition. 
   */
  @SerialName("CALCULATION_AGENT_INDEPENDENT")
  CALCULATION_AGENT_INDEPENDENT,
  /** 
   * Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination. 
   */
  @SerialName("CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION")
  CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION,
  /** 
   * Specifies the party responsible for performing calculation agent duties associated with an optional early termination. 
   */
  @SerialName("CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION")
  CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION,
  /** 
   * Specifies the party which determines additional disruption events. 
   */
  @SerialName("DISRUPTION_EVENTS_DETERMINING_PARTY")
  DISRUPTION_EVENTS_DETERMINING_PARTY,
  /** 
   * Specifies the party to which notice of a cancelable provision exercise should be given. 
   */
  @SerialName("EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION")
  EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION,
  /** 
   * Specifies the party to which notice of a extendible provision exercise should be given. 
   */
  @SerialName("EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION")
  EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION,
  /** 
   * Specifies the party to which notice of a manual exercise should be given. 
   */
  @SerialName("EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL")
  EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL,
  /** 
   * Specifies the party to which notice of a optional early termination exercise should be given. 
   */
  @SerialName("EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION")
  EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION,
  /** 
   * Specifies the party which determines if dividends are extraordinary in relation to normal levels. 
   */
  @SerialName("EXTRAORDINARY_DIVIDENDS_PARTY")
  EXTRAORDINARY_DIVIDENDS_PARTY,
  /** 
   * Specifies the clearing organization (CCP, DCO) which the trade should be cleared. 
   */
  @SerialName("PREDETERMINED_CLEARING_ORGANIZATION_PARTY")
  PREDETERMINED_CLEARING_ORGANIZATION_PARTY
  ;
}

/** 
 * An arithmetic operator that can be passed to a function 
 */
@Serializable
enum class ArithmeticOperationEnum {
  /** 
   * Addition of 2 values 
   */
  @SerialName("ADD")
  ADD,
  /** 
   * Division of 1st value by 2nd value 
   */
  @SerialName("DIVIDE")
  DIVIDE,
  /** 
   * Maximum of 2 values 
   */
  @SerialName("MAX")
  MAX,
  /** 
   * Minimum of 2 values 
   */
  @SerialName("MIN")
  MIN,
  /** 
   * Multiplication of 2 values 
   */
  @SerialName("MULTIPLY")
  MULTIPLY,
  /** 
   * Subtraction of 2nd value from 1st value 
   */
  @SerialName("SUBTRACT")
  SUBTRACT
  ;
}

/** 
 * The enumerated values to specify the FpML asset class categorization. 
 */
@Serializable
enum class AssetClassEnum {
  /** 
   * Commodity. 
   */
  @SerialName("COMMODITY")
  COMMODITY,
  /** 
   * Credit. 
   */
  @SerialName("CREDIT")
  CREDIT,
  /** 
   * Equity. 
   */
  @SerialName("EQUITY")
  EQUITY,
  /** 
   * ForeignExchange. 
   */
  @SerialName("FOREIGN_EXCHANGE")
  FOREIGN_EXCHANGE,
  /** 
   * InterestRate. 
   */
  @SerialName("INTEREST_RATE")
  INTEREST_RATE,
  /** 
   * Money Market Assets like CP and CD. 
   */
  @SerialName("MONEY_MARKET")
  MONEY_MARKET
  ;
}

/** 
 * Extends product identifiers with additional identifier sources for Assets. 
 */
@Serializable
enum class AssetIdTypeEnum {
  /** 
   * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities. 
   */
  @SerialName("BBGID")
  BBGID,
  /** 
   * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange. 
   */
  @SerialName("BBGTICKER")
  BBGTICKER,
  /** 
   * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada. 
   */
  @SerialName("CUSIP")
  CUSIP,
  /** 
   * The identifier follows the symbology set by the clearing house which clears the asset. 
   */
  @SerialName("CLEARING_CODE")
  CLEARING_CODE,
  /** 
   * Used to identify the currency of a Cash Asset. 
   */
  @SerialName("CURRENCY_CODE")
  CURRENCY_CODE,
  /** 
   * The identifier follows the symbology set by the exchange which lists the asset. 
   */
  @SerialName("EXCHANGE_CODE")
  EXCHANGE_CODE,
  /** 
   * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument. 
   */
  @SerialName("FIGI")
  FIGI,
  /** 
   * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract. 
   */
  @SerialName("ISDACRP")
  ISDACRP,
  /** 
   * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166. 
   */
  @SerialName("ISIN")
  ISIN,
  /** 
   * The name of the product. 
   */
  @SerialName("NAME")
  NAME,
  /** 
   * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded. 
   */
  @SerialName("RIC")
  RIC,
  /** 
   * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well. 
   */
  @SerialName("SEDOL")
  SEDOL,
  /** 
   * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges. 
   */
  @SerialName("SICOVAM")
  SICOVAM,
  /** 
   * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data. 
   */
  @SerialName("UPI")
  UPI,
  /** 
   * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities. 
   */
  @SerialName("WERTPAPIER")
  WERTPAPIER
  ;
}

/** 
 * An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout. 
 */
@Serializable
enum class AssetPayoutTradeTypeEnum {
  /** 
   * In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo. 
   */
  @SerialName("Buy/Sell-Back")
  BUY_SELL_BACK,
  /** 
   * In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller. 
   */
  @SerialName("REPO")
  REPO
  ;
}

/** 
 * The qualification of the type of asset transfer. 
 */
@Serializable
enum class AssetTransferTypeEnum {
  /** 
   * The transfer of assets takes place without a corresponding exchange of payment. 
   */
  @SerialName("FREE_OF_PAYMENT")
  FREE_OF_PAYMENT
  ;
}

/** 
 * Represents an enumeration list to identify the asset type. 
 */
@Serializable
enum class AssetTypeEnum {
  /** 
   * Indentifies cash in a currency form. 
   */
  @SerialName("CASH")
  CASH,
  /** 
   * Indentifies basic good used in commerce that is interchangeable with other goods of the same type. 
   */
  @SerialName("COMMODITY")
  COMMODITY,
  /** 
   * Indentifies other asset types. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Indentifies negotiable financial instrument of monetary value with an issue ownership position. 
   */
  @SerialName("SECURITY")
  SECURITY
  ;
}

/** 
 * Enumeration to describe the type of AvailableInventory 
 */
@Serializable
enum class AvailableInventoryTypeEnum {
  /** 
   * Where a lender is broadcasting the securities that they have available to lend 
   */
  @SerialName("AVAILABLE_TO_LEND")
  AVAILABLE_TO_LEND,
  /** 
   * Where a party is asking a lender if they have specific securities available for them to borrow 
   */
  @SerialName("REQUEST_TO_BORROW")
  REQUEST_TO_BORROW
  ;
}

/** 
 * Indicates the type of equity average trading volume (single) the highest amount on one exchange, or (consolidated) volumes across more than one exchange. 
 */
@Serializable
enum class AverageTradingVolumeMethodologyEnum {
  /** 
   * Consolidated volume across more than one exchange. 
   */
  @SerialName("CONSOLIDATED")
  CONSOLIDATED,
  /** 
   * Single, the highest amount on one exchange. 
   */
  @SerialName("SINGLE")
  SINGLE
  ;
}

/** 
 * Specifies enumerations for the type of averaging calculation. 
 */
@Serializable
enum class AveragingCalculationMethodEnum {
  /** 
   * Refers to the calculation of an average by taking the sum of observations divided by the count of observations. 
   */
  @SerialName("ARITHMETIC")
  ARITHMETIC,
  /** 
   * Refers to the calculation of an average by taking the nth root of the product of n observations. 
   */
  @SerialName("GEOMETRIC")
  GEOMETRIC,
  /** 
   * Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations. 
   */
  @SerialName("HARMONIC")
  HARMONIC
  ;
}

/** 
 * The enumerated values to specify the type of averaging used in an Asian option. 
 */
@Serializable
enum class AveragingInOutEnum {
  /** 
   * The average price is used to derive both the strike and the expiration price. 
   */
  @SerialName("BOTH")
  BOTH,
  /** 
   * The average price is used to derive the strike price. Also known as 'Asian strike' style option. 
   */
  @SerialName("IN")
  IN,
  /** 
   * The average price is used to derive the expiration price. Also known as 'Asian price' style option. 
   */
  @SerialName("OUT")
  OUT
  ;
}

/** 
 * The enumerated values to specify the method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts. 
 */
@Serializable
enum class AveragingWeightingMethodEnum {
  /** 
   * The arithmetic mean of the relevant rates for each reset date. 
   */
  @SerialName("UNWEIGHTED")
  UNWEIGHTED,
  /** 
   * The arithmetic mean of the relevant rates in effect for each day in a calculation period calculated by multiplying each relevant rate by the number of days such relevant rate is in effect, determining the sum of such products and dividing such sum by the number of days in the calculation period. 
   */
  @SerialName("WEIGHTED")
  WEIGHTED
  ;
}

/** 
 * Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles. 
 */
@Serializable
enum class BankHolidayTreatmentEnum {
  /** 
   * Bank holidays treated as weekdays. 
   */
  @SerialName("AS_WEEKDAY")
  AS_WEEKDAY,
  /** 
   * Bank holidays treated as weekends. 
   */
  @SerialName("AS_WEEKEND")
  AS_WEEKEND
  ;
}

/** 
 * The enumerated values to specify the business centers. 
 */
@Serializable
enum class BusinessCenterEnum {
  /** 
   * Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii)) 
   */
  @SerialName("AEAB")
  AEAB,
  /** 
   * Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i)) 
   */
  @SerialName("AEAD")
  AEAD,
  /** 
   * Dubai, United Arab Emirates 
   */
  @SerialName("AEDU")
  AEDU,
  /** 
   * Yerevan, Armenia 
   */
  @SerialName("AMYE")
  AMYE,
  /** 
   * Luanda, Angola 
   */
  @SerialName("AOLU")
  AOLU,
  /** 
   * Buenos Aires, Argentina 
   */
  @SerialName("ARBA")
  ARBA,
  /** 
   * Vienna, Austria 
   */
  @SerialName("ATVI")
  ATVI,
  /** 
   * Adelaide, Australia 
   */
  @SerialName("AUAD")
  AUAD,
  /** 
   * Brisbane, Australia 
   */
  @SerialName("AUBR")
  AUBR,
  /** 
   * Canberra, Australia 
   */
  @SerialName("AUCA")
  AUCA,
  /** 
   * Darwin, Australia 
   */
  @SerialName("AUDA")
  AUDA,
  /** 
   * Melbourne, Australia 
   */
  @SerialName("AUME")
  AUME,
  /** 
   * Perth, Australia 
   */
  @SerialName("AUPE")
  AUPE,
  /** 
   * Sydney, Australia 
   */
  @SerialName("AUSY")
  AUSY,
  /** 
   * Baku, Azerbaijan 
   */
  @SerialName("AZBA")
  AZBA,
  /** 
   * Bridgetown, Barbados 
   */
  @SerialName("BBBR")
  BBBR,
  /** 
   * Dhaka, Bangladesh 
   */
  @SerialName("BDDH")
  BDDH,
  /** 
   * Brussels, Belgium 
   */
  @SerialName("BEBR")
  BEBR,
  /** 
   * Sofia, Bulgaria 
   */
  @SerialName("BGSO")
  BGSO,
  /** 
   * Manama, Bahrain 
   */
  @SerialName("BHMA")
  BHMA,
  /** 
   * Hamilton, Bermuda 
   */
  @SerialName("BMHA")
  BMHA,
  /** 
   * Bandar Seri Begawan, Brunei 
   */
  @SerialName("BNBS")
  BNBS,
  /** 
   * La Paz, Bolivia 
   */
  @SerialName("BOLP")
  BOLP,
  /** 
   * Brazil Business Day. 
   */
  @SerialName("BRBD")
  BRBD,
  /** 
   * Brasilia, Brazil. 
   */
  @SerialName("BRBR")
  BRBR,
  /** 
   * Rio de Janeiro, Brazil. 
   */
  @SerialName("BRRJ")
  BRRJ,
  /** 
   * Sao Paulo, Brazil. 
   */
  @SerialName("BRSP")
  BRSP,
  /** 
   * Nassau, Bahamas 
   */
  @SerialName("BSNA")
  BSNA,
  /** 
   * Gaborone, Botswana 
   */
  @SerialName("BWGA")
  BWGA,
  /** 
   * Minsk, Belarus 
   */
  @SerialName("BYMI")
  BYMI,
  /** 
   * Calgary, Canada 
   */
  @SerialName("CACL")
  CACL,
  /** 
   * Fredericton, Canada. 
   */
  @SerialName("CAFR")
  CAFR,
  /** 
   * Montreal, Canada 
   */
  @SerialName("CAMO")
  CAMO,
  /** 
   * Ottawa, Canada 
   */
  @SerialName("CAOT")
  CAOT,
  /** 
   * Toronto, Canada 
   */
  @SerialName("CATO")
  CATO,
  /** 
   * Vancouver, Canada 
   */
  @SerialName("CAVA")
  CAVA,
  /** 
   * Winnipeg, Canada 
   */
  @SerialName("CAWI")
  CAWI,
  /** 
   * Basel, Switzerland 
   */
  @SerialName("CHBA")
  CHBA,
  /** 
   * Geneva, Switzerland 
   */
  @SerialName("CHGE")
  CHGE,
  /** 
   * Zurich, Switzerland 
   */
  @SerialName("CHZU")
  CHZU,
  /** 
   * Abidjan, Cote d'Ivoire 
   */
  @SerialName("CIAB")
  CIAB,
  /** 
   * Santiago, Chile 
   */
  @SerialName("CLSA")
  CLSA,
  /** 
   * Yaounde, Cameroon 
   */
  @SerialName("CMYA")
  CMYA,
  /** 
   * Beijing, China 
   */
  @SerialName("CNBE")
  CNBE,
  /** 
   * Shanghai, China 
   */
  @SerialName("CNSH")
  CNSH,
  /** 
   * Bogota, Colombia 
   */
  @SerialName("COBO")
  COBO,
  /** 
   * San Jose, Costa Rica 
   */
  @SerialName("CRSJ")
  CRSJ,
  /** 
   * Willemstad, Curacao 
   */
  @SerialName("CWWI")
  CWWI,
  /** 
   * Nicosia, Cyprus 
   */
  @SerialName("CYNI")
  CYNI,
  /** 
   * Prague, Czech Republic 
   */
  @SerialName("CZPR")
  CZPR,
  /** 
   * Cologne, Germany 
   */
  @SerialName("DECO")
  DECO,
  /** 
   * Dusseldorf, Germany 
   */
  @SerialName("DEDU")
  DEDU,
  /** 
   * Frankfurt, Germany 
   */
  @SerialName("DEFR")
  DEFR,
  /** 
   * Hannover, Germany 
   */
  @SerialName("DEHA")
  DEHA,
  /** 
   * Hamburg, Germany 
   */
  @SerialName("DEHH")
  DEHH,
  /** 
   * Leipzig, Germany 
   */
  @SerialName("DELE")
  DELE,
  /** 
   * Mainz, Germany 
   */
  @SerialName("DEMA")
  DEMA,
  /** 
   * Munich, Germany 
   */
  @SerialName("DEMU")
  DEMU,
  /** 
   * Stuttgart, Germany 
   */
  @SerialName("DEST")
  DEST,
  /** 
   * Copenhagen, Denmark 
   */
  @SerialName("DKCO")
  DKCO,
  /** 
   * Santo Domingo, Dominican Republic 
   */
  @SerialName("DOSD")
  DOSD,
  /** 
   * Algiers, Algeria 
   */
  @SerialName("DZAL")
  DZAL,
  /** 
   * Guayaquil, Ecuador 
   */
  @SerialName("ECGU")
  ECGU,
  /** 
   * Tallinn, Estonia 
   */
  @SerialName("EETA")
  EETA,
  /** 
   * Cairo, Egypt 
   */
  @SerialName("EGCA")
  EGCA,
  /** 
   * ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions) 
   */
  @SerialName("ESAS")
  ESAS,
  /** 
   * Barcelona, Spain 
   */
  @SerialName("ESBA")
  ESBA,
  /** 
   * Madrid, Spain 
   */
  @SerialName("ESMA")
  ESMA,
  /** 
   * San Sebastian, Spain 
   */
  @SerialName("ESSS")
  ESSS,
  /** 
   * Addis Ababa, Ethiopia 
   */
  @SerialName("ETAA")
  ETAA,
  /** 
   * Publication dates for ICE Swap rates based on EUR-EURIBOR rates 
   */
  @SerialName("EUR-ICESWAP")
  EUR_ICESWAP,
  /** 
   * TARGET Settlement Day 
   */
  @SerialName("EUTA")
  EUTA,
  /** 
   * Helsinki, Finland 
   */
  @SerialName("FIHE")
  FIHE,
  /** 
   * Paris, France 
   */
  @SerialName("FRPA")
  FRPA,
  /** 
   * Edinburgh, Scotland 
   */
  @SerialName("GBED")
  GBED,
  /** 
   * London, United Kingdom 
   */
  @SerialName("GBLO")
  GBLO,
  /** 
   * Publication dates for GBP ICE Swap rates 
   */
  @SerialName("GBP-ICESWAP")
  GBP_ICESWAP,
  /** 
   * Tbilisi, Georgia 
   */
  @SerialName("GETB")
  GETB,
  /** 
   * Saint Peter Port, Guernsey 
   */
  @SerialName("GGSP")
  GGSP,
  /** 
   * Accra, Ghana 
   */
  @SerialName("GHAC")
  GHAC,
  /** 
   * Gibraltar, Gibraltar 
   */
  @SerialName("GIGI")
  GIGI,
  /** 
   * Banjul, Gambia 
   */
  @SerialName("GMBA")
  GMBA,
  /** 
   * Conakry, Guinea 
   */
  @SerialName("GNCO")
  GNCO,
  /** 
   * Athens, Greece 
   */
  @SerialName("GRAT")
  GRAT,
  /** 
   * Guatemala City, Guatemala 
   */
  @SerialName("GTGC")
  GTGC,
  /** 
   * Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.] 
   */
  @SerialName("GUGC")
  GUGC,
  /** 
   * Hong Kong, Hong Kong 
   */
  @SerialName("HKHK")
  HKHK,
  /** 
   * Tegucigalpa, Honduras 
   */
  @SerialName("HNTE")
  HNTE,
  /** 
   * Zagreb, Republic of Croatia 
   */
  @SerialName("HRZA")
  HRZA,
  /** 
   * Budapest, Hungary 
   */
  @SerialName("HUBU")
  HUBU,
  /** 
   * Jakarta, Indonesia 
   */
  @SerialName("IDJA")
  IDJA,
  /** 
   * Dublin, Ireland 
   */
  @SerialName("IEDU")
  IEDU,
  /** 
   * Jerusalem, Israel 
   */
  @SerialName("ILJE")
  ILJE,
  /** 
   * Publication dates of the ILS-TELBOR index. 
   */
  @SerialName("ILS-TELBOR")
  ILS_TELBOR,
  /** 
   * Tel Aviv, Israel 
   */
  @SerialName("ILTA")
  ILTA,
  /** 
   * Ahmedabad, India 
   */
  @SerialName("INAH")
  INAH,
  /** 
   * Bangalore, India 
   */
  @SerialName("INBA")
  INBA,
  /** 
   * Chennai, India 
   */
  @SerialName("INCH")
  INCH,
  /** 
   * Hyderabad, India 
   */
  @SerialName("INHY")
  INHY,
  /** 
   * Kolkata, India 
   */
  @SerialName("INKO")
  INKO,
  /** 
   * Mumbai, India 
   */
  @SerialName("INMU")
  INMU,
  /** 
   * New Delhi, India 
   */
  @SerialName("INND")
  INND,
  /** 
   * Baghdad, Iraq 
   */
  @SerialName("IQBA")
  IQBA,
  /** 
   * Teheran, Iran 
   */
  @SerialName("IRTE")
  IRTE,
  /** 
   * Reykjavik, Iceland 
   */
  @SerialName("ISRE")
  ISRE,
  /** 
   * Milan, Italy 
   */
  @SerialName("ITMI")
  ITMI,
  /** 
   * Rome, Italy 
   */
  @SerialName("ITRO")
  ITRO,
  /** 
   * Turin, Italy 
   */
  @SerialName("ITTU")
  ITTU,
  /** 
   * St. Helier, Channel Islands, Jersey 
   */
  @SerialName("JESH")
  JESH,
  /** 
   * Kingston, Jamaica 
   */
  @SerialName("JMKI")
  JMKI,
  /** 
   * Amman, Jordan 
   */
  @SerialName("JOAM")
  JOAM,
  /** 
   * Tokyo, Japan 
   */
  @SerialName("JPTO")
  JPTO,
  /** 
   * Nairobi, Kenya 
   */
  @SerialName("KENA")
  KENA,
  /** 
   * Phnom Penh, Cambodia 
   */
  @SerialName("KHPP")
  KHPP,
  /** 
   * Seoul, Republic of Korea 
   */
  @SerialName("KRSE")
  KRSE,
  /** 
   * Kuwait City, Kuwait 
   */
  @SerialName("KWKC")
  KWKC,
  /** 
   * George Town, Cayman Islands 
   */
  @SerialName("KYGE")
  KYGE,
  /** 
   * Almaty, Kazakhstan 
   */
  @SerialName("KZAL")
  KZAL,
  /** 
   * Vientiane, Laos 
   */
  @SerialName("LAVI")
  LAVI,
  /** 
   * Beirut, Lebanon 
   */
  @SerialName("LBBE")
  LBBE,
  /** 
   * Colombo, Sri Lanka 
   */
  @SerialName("LKCO")
  LKCO,
  /** 
   * Luxembourg, Luxembourg 
   */
  @SerialName("LULU")
  LULU,
  /** 
   * Riga, Latvia 
   */
  @SerialName("LVRI")
  LVRI,
  /** 
   * Casablanca, Morocco 
   */
  @SerialName("MACA")
  MACA,
  /** 
   * Rabat, Morocco 
   */
  @SerialName("MARA")
  MARA,
  /** 
   * Monaco, Monaco 
   */
  @SerialName("MCMO")
  MCMO,
  /** 
   * Ulan Bator, Mongolia 
   */
  @SerialName("MNUB")
  MNUB,
  /** 
   * Macau, Macao 
   */
  @SerialName("MOMA")
  MOMA,
  /** 
   * Valletta, Malta 
   */
  @SerialName("MTVA")
  MTVA,
  /** 
   * Port Louis, Mauritius 
   */
  @SerialName("MUPL")
  MUPL,
  /** 
   * Male, Maldives 
   */
  @SerialName("MVMA")
  MVMA,
  /** 
   * Lilongwe, Malawi 
   */
  @SerialName("MWLI")
  MWLI,
  /** 
   * Mexico City, Mexico 
   */
  @SerialName("MXMC")
  MXMC,
  /** 
   * Kuala Lumpur, Malaysia 
   */
  @SerialName("MYKL")
  MYKL,
  /** 
   * Labuan, Malaysia 
   */
  @SerialName("MYLA")
  MYLA,
  /** 
   * Maputo, Mozambique 
   */
  @SerialName("MZMA")
  MZMA,
  /** 
   * Windhoek, Namibia 
   */
  @SerialName("NAWI")
  NAWI,
  /** 
   * Abuja, Nigeria 
   */
  @SerialName("NGAB")
  NGAB,
  /** 
   * Lagos, Nigeria 
   */
  @SerialName("NGLA")
  NGLA,
  /** 
   * Amsterdam, Netherlands 
   */
  @SerialName("NLAM")
  NLAM,
  /** 
   * Rotterdam, Netherlands 
   */
  @SerialName("NLRO")
  NLRO,
  /** 
   * Oslo, Norway 
   */
  @SerialName("NOOS")
  NOOS,
  /** 
   * Kathmandu, Nepal 
   */
  @SerialName("NPKA")
  NPKA,
  /** 
   * New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7) 
   */
  @SerialName("NYFD")
  NYFD,
  /** 
   * New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8) 
   */
  @SerialName("NYSE")
  NYSE,
  /** 
   * Auckland, New Zealand 
   */
  @SerialName("NZAU")
  NZAU,
  /** 
   * Wellington, New Zealand 
   */
  @SerialName("NZWE")
  NZWE,
  /** 
   * Muscat, Oman 
   */
  @SerialName("OMMU")
  OMMU,
  /** 
   * Panama City, Panama 
   */
  @SerialName("PAPC")
  PAPC,
  /** 
   * Lima, Peru 
   */
  @SerialName("PELI")
  PELI,
  /** 
   * Manila, Philippines 
   */
  @SerialName("PHMA")
  PHMA,
  /** 
   * Makati, Philippines 
   */
  @SerialName("PHMK")
  PHMK,
  /** 
   * Karachi, Pakistan 
   */
  @SerialName("PKKA")
  PKKA,
  /** 
   * Warsaw, Poland 
   */
  @SerialName("PLWA")
  PLWA,
  /** 
   * San Juan, Puerto Rico 
   */
  @SerialName("PRSJ")
  PRSJ,
  /** 
   * Lisbon, Portugal 
   */
  @SerialName("PTLI")
  PTLI,
  /** 
   * Doha, Qatar 
   */
  @SerialName("QADO")
  QADO,
  /** 
   * Bucharest, Romania 
   */
  @SerialName("ROBU")
  ROBU,
  /** 
   * Belgrade, Serbia 
   */
  @SerialName("RSBE")
  RSBE,
  /** 
   * Moscow, Russian Federation 
   */
  @SerialName("RUMO")
  RUMO,
  /** 
   * Abha, Saudi Arabia 
   */
  @SerialName("SAAB")
  SAAB,
  /** 
   * Jeddah, Saudi Arabia 
   */
  @SerialName("SAJE")
  SAJE,
  /** 
   * Riyadh, Saudi Arabia 
   */
  @SerialName("SARI")
  SARI,
  /** 
   * Stockholm, Sweden 
   */
  @SerialName("SEST")
  SEST,
  /** 
   * Singapore, Singapore 
   */
  @SerialName("SGSI")
  SGSI,
  /** 
   * Ljubljana, Slovenia 
   */
  @SerialName("SILJ")
  SILJ,
  /** 
   * Bratislava, Slovakia 
   */
  @SerialName("SKBR")
  SKBR,
  /** 
   * Freetown, Sierra Leone 
   */
  @SerialName("SLFR")
  SLFR,
  /** 
   * Dakar, Senegal 
   */
  @SerialName("SNDA")
  SNDA,
  /** 
   * San Salvador, El Salvador 
   */
  @SerialName("SVSS")
  SVSS,
  /** 
   * Bangkok, Thailand 
   */
  @SerialName("THBA")
  THBA,
  /** 
   * Tunis, Tunisia 
   */
  @SerialName("TNTU")
  TNTU,
  /** 
   * Ankara, Turkey 
   */
  @SerialName("TRAN")
  TRAN,
  /** 
   * Istanbul, Turkey 
   */
  @SerialName("TRIS")
  TRIS,
  /** 
   * Port of Spain, Trinidad and Tobago 
   */
  @SerialName("TTPS")
  TTPS,
  /** 
   * Taipei, Taiwan 
   */
  @SerialName("TWTA")
  TWTA,
  /** 
   * Dar es Salaam, Tanzania 
   */
  @SerialName("TZDA")
  TZDA,
  /** 
   * Dodoma, Tanzania 
   */
  @SerialName("TZDO")
  TZDO,
  /** 
   * Kiev, Ukraine 
   */
  @SerialName("UAKI")
  UAKI,
  /** 
   * Kampala, Uganda 
   */
  @SerialName("UGKA")
  UGKA,
  /** 
   * Boston, Massachusetts, United States 
   */
  @SerialName("USBO")
  USBO,
  /** 
   * Chicago, United States 
   */
  @SerialName("USCH")
  USCH,
  /** 
   * Charlotte, North Carolina, United States 
   */
  @SerialName("USCR")
  USCR,
  /** 
   * Washington, District of Columbia, United States 
   */
  @SerialName("USDC")
  USDC,
  /** 
   * Denver, United States 
   */
  @SerialName("USDN")
  USDN,
  /** 
   * Detroit, Michigan, United States 
   */
  @SerialName("USDT")
  USDT,
  /** 
   * Publication dates for ICE Swap rates based on USD-LIBOR rates 
   */
  @SerialName("USD-ICESWAP")
  USD_ICESWAP,
  /** 
   * Publication dates for the USD-Municipal Swap Index 
   */
  @SerialName("USD-MUNI")
  USD_MUNI,
  /** 
   * U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11) 
   */
  @SerialName("USGS")
  USGS,
  /** 
   * Honolulu, Hawaii, United States 
   */
  @SerialName("USHL")
  USHL,
  /** 
   * Houston, United States 
   */
  @SerialName("USHO")
  USHO,
  /** 
   * Los Angeles, United States 
   */
  @SerialName("USLA")
  USLA,
  /** 
   * Mobile, Alabama, United States 
   */
  @SerialName("USMB")
  USMB,
  /** 
   * Minneapolis, United States 
   */
  @SerialName("USMN")
  USMN,
  /** 
   * New York, United States 
   */
  @SerialName("USNY")
  USNY,
  /** 
   * Portland, Oregon, United States 
   */
  @SerialName("USPO")
  USPO,
  /** 
   * Sacramento, California, United States 
   */
  @SerialName("USSA")
  USSA,
  /** 
   * Seattle, United States 
   */
  @SerialName("USSE")
  USSE,
  /** 
   * San Francisco, United States 
   */
  @SerialName("USSF")
  USSF,
  /** 
   * Wichita, United States 
   */
  @SerialName("USWT")
  USWT,
  /** 
   * Montevideo, Uruguay 
   */
  @SerialName("UYMO")
  UYMO,
  /** 
   * Tashkent, Uzbekistan 
   */
  @SerialName("UZTA")
  UZTA,
  /** 
   * Caracas, Venezuela 
   */
  @SerialName("VECA")
  VECA,
  /** 
   * Road Town, Virgin Islands (British) 
   */
  @SerialName("VGRT")
  VGRT,
  /** 
   * Hanoi, Vietnam 
   */
  @SerialName("VNHA")
  VNHA,
  /** 
   * Ho Chi Minh (formerly Saigon), Vietnam 
   */
  @SerialName("VNHC")
  VNHC,
  /** 
   * Aden, Yemen 
   */
  @SerialName("YEAD")
  YEAD,
  /** 
   * Johannesburg, South Africa 
   */
  @SerialName("ZAJO")
  ZAJO,
  /** 
   * Lusaka, Zambia 
   */
  @SerialName("ZMLU")
  ZMLU,
  /** 
   * Harare, Zimbabwe 
   */
  @SerialName("ZWHA")
  ZWHA
  ;
}

/** 
 * The enumerated values to specify the convention for adjusting any relevant date if it would otherwise fall on a day that is not a valid business day. 
 */
@Serializable
enum class BusinessDayConventionEnum {
  /** 
   * The non-business date will be adjusted to the first following day that is a business day 
   */
  @SerialName("FOLLOWING")
  FOLLOWING,
  /** 
   * Per 2000 ISDA Definitions, Section 4.11. FRN Convention; Eurodollar Convention. FRN is included here as a type of business day convention although it does not strictly fall within ISDA's definition of a Business Day Convention and does not conform to the simple definition given above. 
   */
  @SerialName("FRN")
  FRN,
  /** 
   * The non-business date will be adjusted to the first following day that is a business day unless that day falls in the next calendar month, in which case that date will be the first preceding day that is a business day. 
   */
  @SerialName("MODFOLLOWING")
  MODFOLLOWING,
  /** 
   * The non-business date will be adjusted to the first preceding day that is a business day unless that day falls in the previous calendar month, in which case that date will be the first following day that us a business day. 
   */
  @SerialName("MODPRECEDING")
  MODPRECEDING,
  /** 
   * The non-business date will be adjusted to the nearest day that is a business day - i.e. if the non-business day falls on any day other than a Sunday or a Monday, it will be the first preceding day that is a business day, and will be the first following business day if it falls on a Sunday or a Monday. 
   */
  @SerialName("NEAREST")
  NEAREST,
  /** 
   * The date will not be adjusted if it falls on a day that is not a business day. 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * The date adjustments conventions are defined elsewhere, so it is not required to specify them here. 
   */
  @SerialName("NOT_APPLICABLE")
  NOT_APPLICABLE,
  /** 
   * The non-business day will be adjusted to the first preceding day that is a business day. 
   */
  @SerialName("PRECEDING")
  PRECEDING
  ;
}

/** 
 * What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7. 
 */
@Serializable
enum class CalculationMethodEnum {
  /** 
   * Averaging, i.e. arithmetic averaging. 
   */
  @SerialName("AVERAGING")
  AVERAGING,
  /** 
   * A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula. 
   */
  @SerialName("COMPOUNDED_INDEX")
  COMPOUNDED_INDEX,
  /** 
   * Compounding, i.e. geometric averaging following an ISDA defined formula. 
   */
  @SerialName("COMPOUNDING")
  COMPOUNDING
  ;
}

/** 
 *  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7. 
 */
@Serializable
enum class CalculationShiftMethodEnum {
  /** 
   * Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days. 
   */
  @SerialName("LOOKBACK")
  LOOKBACK,
  /** 
   * calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style. 
   */
  @SerialName("NO_SHIFT")
  NO_SHIFT,
  /** 
   * the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period. 
   */
  @SerialName("OBSERVATION_PERIOD_SHIFT")
  OBSERVATION_PERIOD_SHIFT,
  /** 
   * Calculations cut the rate off several business days prior to rate setting (Lockout). 
   */
  @SerialName("RATE_CUT_OFF")
  RATE_CUT_OFF
  ;
}

/** 
 * Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call. 
 */
@Serializable
enum class CallTypeEnum {
  /** 
   * Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement. 
   */
  @SerialName("EXPECTED_CALL")
  EXPECTED_CALL,
  /** 
   * Identifies an actionable Margin Call. 
   */
  @SerialName("MARGIN_CALL")
  MARGIN_CALL,
  /** 
   * Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent. 
   */
  @SerialName("NOTIFICATION")
  NOTIFICATION
  ;
}

/** 
 * Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction. 
 */
@Serializable
enum class CallingPartyEnum {
  /** 
   * As defined in Master Agreement. 
   */
  @SerialName("AS_DEFINED_IN_MASTER_AGREEMENT")
  AS_DEFINED_IN_MASTER_AGREEMENT,
  /** 
   * Either, Buyer or Seller to the repo transaction. 
   */
  @SerialName("EITHER")
  EITHER,
  /** 
   * Initial buyer to the repo transaction. 
   */
  @SerialName("INITIAL_BUYER")
  INITIAL_BUYER,
  /** 
   * Initial seller to the repo transaction. 
   */
  @SerialName("INITIAL_SELLER")
  INITIAL_SELLER
  ;
}

/** 
 * Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities. 
 */
@Serializable
enum class CapacityUnitEnum {
  /** 
   * Denotes Allowances as standard unit. 
   */
  @SerialName("ALW")
  ALW,
  /** 
   * Denotes a Barrel as a standard unit. 
   */
  @SerialName("BBL")
  BBL,
  /** 
   * Denotes Billion Cubic Feet as a standard unit. 
   */
  @SerialName("BCF")
  BCF,
  /** 
   * Denotes Board Feet as a standard unit. 
   */
  @SerialName("BDFT")
  BDFT,
  /** 
   * Denotes Cubic Meters as a standard unit. 
   */
  @SerialName("CBM")
  CBM,
  /** 
   * Denotes Certified Emissions Reduction as a standard unit. 
   */
  @SerialName("CER")
  CER,
  /** 
   * Denotes Climate Reserve Tonnes as a standard unit. 
   */
  @SerialName("CRT")
  CRT,
  /** 
   * Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX). 
   */
  @SerialName("DAG")
  DAG,
  /** 
   * Denotes a single day as a standard unit used in time charter trades. 
   */
  @SerialName("DAY")
  DAY,
  /** 
   * Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture. 
   */
  @SerialName("DMTU")
  DMTU,
  /** 
   * Denotes Environmental Credit as a standard unit. 
   */
  @SerialName("ENVCRD")
  ENVCRD,
  /** 
   * Denotes Environmental Offset as a standard unit. 
   */
  @SerialName("ENVOFST")
  ENVOFST,
  /** 
   * Denotes a 40 ft. Equivalent Unit container as a standard unit. 
   */
  @SerialName("FEU")
  FEU,
  /** 
   * Denotes a Gram as a standard unit. 
   */
  @SerialName("G")
  G,
  /** 
   * Denotes a GB Bushel as a standard unit. 
   */
  @SerialName("GBBSH")
  GBBSH,
  /** 
   * Denotes a GB British Thermal Unit as a standard unit. 
   */
  @SerialName("GBBTU")
  GBBTU,
  /** 
   * Denotes a GB Hundredweight unit as standard unit. 
   */
  @SerialName("GBCWT")
  GBCWT,
  /** 
   * Denotes a GB Gallon unit as standard unit. 
   */
  @SerialName("GBGAL")
  GBGAL,
  /** 
   * Denotes a Thousand GB British Thermal Units as a standard unit. 
   */
  @SerialName("GBMBTU")
  GBMBTU,
  /** 
   * Denotes a Million GB British Thermal Units as a standard unit. 
   */
  @SerialName("GBMMBTU")
  GBMMBTU,
  /** 
   * Denotes a GB Ton as a standard unit. 
   */
  @SerialName("GBT")
  GBT,
  /** 
   * Denotes a GB Thermal Unit as a standard unit. 
   */
  @SerialName("GBTHM")
  GBTHM,
  /** 
   * Denotes a Gigajoule as a standard unit. 
   */
  @SerialName("GJ")
  GJ,
  /** 
   * Denotes a Gigawatt as a standard unit. 
   */
  @SerialName("GW")
  GW,
  /** 
   * Denotes a Gigawatt-hour as a standard unit. 
   */
  @SerialName("GWH")
  GWH,
  /** 
   * Denotes a Hectolitre as a standard unit. 
   */
  @SerialName("HL")
  HL,
  /** 
   * Denotes a 100-troy ounces Gold Bar as a standard unit. 
   */
  @SerialName("HOGB")
  HOGB,
  /** 
   * Denotes an ISO British Thermal Unit as a standard unit. 
   */
  @SerialName("ISOBTU")
  ISOBTU,
  /** 
   * Denotes a Thousand ISO British Thermal Unit as a standard unit. 
   */
  @SerialName("ISOMBTU")
  ISOMBTU,
  /** 
   * Denotes a Million ISO British Thermal Unit as a standard unit. 
   */
  @SerialName("ISOMMBTU")
  ISOMMBTU,
  /** 
   * Denotes an ISO Thermal Unit as a standard unit. 
   */
  @SerialName("ISOTHM")
  ISOTHM,
  /** 
   * Denotes a Joule as a standard unit. 
   */
  @SerialName("J")
  J,
  /** 
   * Denotes a Kilogram as a standard unit. 
   */
  @SerialName("KG")
  KG,
  /** 
   * Denotes a Kilolitre as a standard unit. 
   */
  @SerialName("KL")
  KL,
  /** 
   * Denotes a Kilowatt as a standard unit. 
   */
  @SerialName("KW")
  KW,
  /** 
   * Denotes a Kilowatt-day as a standard unit. 
   */
  @SerialName("KWD")
  KWD,
  /** 
   * Denotes a Kilowatt-hour as a standard unit. 
   */
  @SerialName("KWH")
  KWH,
  /** 
   * Denotes a Kilowatt-month as a standard unit. 
   */
  @SerialName("KWM")
  KWM,
  /** 
   * Denotes a Kilowatt-minute as a standard unit. 
   */
  @SerialName("KWMIN")
  KWMIN,
  /** 
   * Denotes a Kilowatt-year as a standard unit. 
   */
  @SerialName("KWY")
  KWY,
  /** 
   * Denotes a Litre as a standard unit. 
   */
  @SerialName("L")
  L,
  /** 
   * Denotes a Pound as a standard unit. 
   */
  @SerialName("LB")
  LB,
  /** 
   * Denotes a Thousand Barrels as a standard unit. 
   */
  @SerialName("MB")
  MB,
  /** 
   * Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit. 
   */
  @SerialName("MBF")
  MBF,
  /** 
   * Denotes a Megajoule as a standard unit. 
   */
  @SerialName("MJ")
  MJ,
  /** 
   * Denotes a Million Barrels as a standard unit. 
   */
  @SerialName("MMBBL")
  MMBBL,
  /** 
   * Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit. 
   */
  @SerialName("MMBF")
  MMBF,
  /** 
   * Denotes a Thousand square feet as a standard unit. 
   */
  @SerialName("MSF")
  MSF,
  /** 
   * Denotes a Metric Ton as a standard unit. 
   */
  @SerialName("MT")
  MT,
  /** 
   * Denotes a Megawatt as a standard unit. 
   */
  @SerialName("MW")
  MW,
  /** 
   * Denotes a Megawatt-day as a standard unit. 
   */
  @SerialName("MWD")
  MWD,
  /** 
   * Denotes a Megawatt-hour as a standard unit. 
   */
  @SerialName("MWH")
  MWH,
  /** 
   * Denotes a Megawatt-month as a standard unit. 
   */
  @SerialName("MWM")
  MWM,
  /** 
   * Denotes a Megawatt-minute as a standard unit. 
   */
  @SerialName("MWMIN")
  MWMIN,
  /** 
   * Denotes a Megawatt-year as a standard unit. 
   */
  @SerialName("MWY")
  MWY,
  /** 
   * Denotes a Troy Ounce as a standard unit. 
   */
  @SerialName("OZT")
  OZT,
  /** 
   * Denotes a Standard Gold Bar as a standard unit. 
   */
  @SerialName("SGB")
  SGB,
  /** 
   * Denotes a 20 ft. Equivalent Unit container as a standard unit. 
   */
  @SerialName("TEU")
  TEU,
  /** 
   * Denotes a US Bushel as a standard unit. 
   */
  @SerialName("USBSH")
  USBSH,
  /** 
   * Denotes a US British Thermal Unit as a standard unit. 
   */
  @SerialName("USBTU")
  USBTU,
  /** 
   * Denotes US Hundredweight unit as a standard unit. 
   */
  @SerialName("USCWT")
  USCWT,
  /** 
   * Denotes a US Gallon unit as a standard unit. 
   */
  @SerialName("USGAL")
  USGAL,
  /** 
   * Denotes a Thousand US British Thermal Units as a standard unit. 
   */
  @SerialName("USMBTU")
  USMBTU,
  /** 
   * Denotes a Million US British Thermal Units as a standard unit. 
   */
  @SerialName("USMMBTU")
  USMMBTU,
  /** 
   * Denotes a US Ton as a standard unit. 
   */
  @SerialName("UST")
  UST,
  /** 
   * Denotes a US Thermal Unit as a standard unit. 
   */
  @SerialName("USTHM")
  USTHM
  ;
}

/** 
 * Provides a list of possible types of cash prices, applicable when PriceTypeEnum is itself of type CashPrice. 
 */
@Serializable
enum class CashPriceTypeEnum {
  /** 
   * Denotes a discount factor expressed as a decimal, e.g. 0.95. 
   */
  @SerialName("DISCOUNT")
  DISCOUNT,
  /** 
   * A generic term for describing a non-scheduled cashflow that can be associated either with the initial contract, with some later corrections to it (e.g. a correction to the day count fraction that has a cashflow impact) or with some lifecycle events. Fees that are specifically associated with termination and partial termination, increase, amendment, and exercise events are qualified accordingly. 
   */
  @SerialName("FEE")
  FEE,
  /** 
   * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified. 
   */
  @SerialName("PREMIUM")
  PREMIUM
  ;
}

/** 
 * Defines the different cash settlement methods for a product where cash settlement is applicable. 
 */
@Serializable
enum class CashSettlementMethodEnum {
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b). 
   */
  @SerialName("CASH_PRICE_ALTERNATE_METHOD")
  CASH_PRICE_ALTERNATE_METHOD,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a). 
   */
  @SerialName("CASH_PRICE_METHOD")
  CASH_PRICE_METHOD,
  /** 
   * An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6. 
   */
  @SerialName("COLLATERALIZED_CASH_PRICE_METHOD")
  COLLATERALIZED_CASH_PRICE_METHOD,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23). 
   */
  @SerialName("CROSS_CURRENCY_METHOD")
  CROSS_CURRENCY_METHOD,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3. 
   */
  @SerialName("MID_MARKET_CALCULATION_AGENT_DETERMINATION")
  MID_MARKET_CALCULATION_AGENT_DETERMINATION,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1. 
   */
  @SerialName("MID_MARKET_INDICATIVE_QUOTATIONS")
  MID_MARKET_INDICATIVE_QUOTATIONS,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2. 
   */
  @SerialName("MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE")
  MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c). 
   */
  @SerialName("PAR_YIELD_CURVE_ADJUSTED_METHOD")
  PAR_YIELD_CURVE_ADJUSTED_METHOD,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e). 
   */
  @SerialName("PAR_YIELD_CURVE_UNADJUSTED_METHOD")
  PAR_YIELD_CURVE_UNADJUSTED_METHOD,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5 
   */
  @SerialName("REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION")
  REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4. 
   */
  @SerialName("REPLACEMENT_VALUE_FIRM_QUOTATIONS")
  REPLACEMENT_VALUE_FIRM_QUOTATIONS,
  /** 
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d). 
   */
  @SerialName("ZERO_COUPON_YIELD_ADJUSTED_METHOD")
  ZERO_COUPON_YIELD_ADJUSTED_METHOD
  ;
}

/** 
 * The enumerated values to specify what led to the contract or execution closure. 
 */
@Serializable
enum class ClosedStateEnum {
  /** 
   * The execution or contract has been allocated. 
   */
  @SerialName("ALLOCATED")
  ALLOCATED,
  /** 
   * The execution or contract has been cancelled. 
   */
  @SerialName("CANCELLED")
  CANCELLED,
  /** 
   * The (option) contract has been exercised. 
   */
  @SerialName("EXERCISED")
  EXERCISED,
  /** 
   * The (option) contract has expired without being exercised. 
   */
  @SerialName("EXPIRED")
  EXPIRED,
  /** 
   * The contract has reached its contractual termination date. 
   */
  @SerialName("MATURED")
  MATURED,
  /** 
   * The contract has been novated. This state applies to the stepped-out contract component of the novation event. 
   */
  @SerialName("NOVATED")
  NOVATED,
  /** 
   * The contract has been subject of an early termination event. 
   */
  @SerialName("TERMINATED")
  TERMINATED
  ;
}

/** 
 * How is collateral interest to be handled? 
 */
@Serializable
enum class CollateralInterestHandlingEnum {
  /** 
   *  Adjust the collateral balance to include the interest amount  
   */
  @SerialName("ADJUST")
  ADJUST,
  /** 
   *  Transfer the interest each period  
   */
  @SerialName("TRANSFER")
  TRANSFER,
  /** 
   *  Transfer the interest if it meets certain criteria, or otherwise adjust the collateral balance to reflect the interest amount   
   */
  @SerialName("TRANSFER_OR_ADJUST")
  TRANSFER_OR_ADJUST
  ;
}

/** 
 * The enumerated values to specify the type of margin for which a legal agreement is named. 
 */
@Serializable
enum class CollateralMarginTypeEnum {
  /** 
   * Denotes a margin agreement that is identified for use with Initial Margin/IM. 
   */
  @SerialName("INITIAL_MARGIN")
  INITIAL_MARGIN,
  /** 
   * Denotes a margin agreement that is identified for use with Variation Margin/VM. 
   */
  @SerialName("VARIATION_MARGIN")
  VARIATION_MARGIN
  ;
}

/** 
 * Represents the enumeration list to identify the settlement status of the collateral. 
 */
@Serializable
enum class CollateralStatusEnum {
  /** 
   * Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement. 
   */
  @SerialName("FULL_AMOUNT")
  FULL_AMOUNT,
  /** 
   * Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s. 
   */
  @SerialName("IN_TRANSIT_AMOUNT")
  IN_TRANSIT_AMOUNT,
  /** 
   * Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s. 
   */
  @SerialName("SETTLED_AMOUNT")
  SETTLED_AMOUNT
  ;
}

/** 
 * Specifies the types of collateral that are accepted by the Lender 
 */
@Serializable
enum class CollateralTypeEnum {
  /** 
   * Security Lending Trades against Cash collateral 
   */
  @SerialName("CASH")
  CASH,
  /** 
   * Security Lending Trades against CashPool collateral 
   */
  @SerialName("CASH_POOL")
  CASH_POOL,
  /** 
   * Security Lending Trades against NonCash collateral 
   */
  @SerialName("NON_CASH")
  NON_CASH
  ;
}

@Serializable
enum class CommodityBusinessCalendarEnum {
  /** 
   * Abu Dhabi Securities Exchange https://www.adx.ae/ 
   */
  @SerialName("ADSM")
  ADSM,
  /** 
   * Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer 
   */
  @SerialName("AGRUS-FMB")
  AGRUS_FMB,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("APPI")
  APPI,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ARGUS-CRUDE")
  ARGUS_CRUDE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ARGUS-EUROPEAN-GAS")
  ARGUS_EUROPEAN_GAS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ARGUS-EUROPEAN-PRODUCTS")
  ARGUS_EUROPEAN_PRODUCTS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ARGUS-INTERNATIONAL-LPG")
  ARGUS_INTERNATIONAL_LPG,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ARGUS-MCCLOSKEYS-COAL-REPORT")
  ARGUS_MCCLOSKEYS_COAL_REPORT,
  /** 
   * The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products 
   */
  @SerialName("ARGUS-US-PRODUCTS")
  ARGUS_US_PRODUCTS,
  /** 
   * Australian Securities Exchange http://www.asx.com.au/ 
   */
  @SerialName("ASX")
  ASX,
  /** 
   * Australian Wheat Board. www.awb.com.au 
   */
  @SerialName("AWB")
  AWB,
  /** 
   * Australian Wool Exchange. http://www.awex.com.au/home.html 
   */
  @SerialName("AWEX")
  AWEX,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("BALTIC-EXCHANGE")
  BALTIC_EXCHANGE,
  /** 
   * The business calendar of the Bank Negara Malaysia Policy Committee. 
   */
  @SerialName("BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE")
  BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE,
  /** 
   * The business calendar for the Belpex power exchange (www.belpex.be). 
   */
  @SerialName("BELPEX")
  BELPEX,
  /** 
   * BlueNext Power Market. 
   */
  @SerialName("BLUENEXT")
  BLUENEXT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("BM&F")
  BM_F,
  /** 
   * The settlement business calendar for Bursa Malaysia. 
   */
  @SerialName("BURSA-MALAYSIA-SETTLEMENT")
  BURSA_MALAYSIA_SETTLEMENT,
  /** 
   * The trading business calendar for Bursa Malaysia. 
   */
  @SerialName("BURSA-MALAYSIA-TRADING")
  BURSA_MALAYSIA_TRADING,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CANADIAN-GAS-PRICE-REPORTER")
  CANADIAN_GAS_PRICE_REPORTER,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CBOT-SOFT")
  CBOT_SOFT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CMAI-AROMATICS-MARKET-REPORT")
  CMAI_AROMATICS_MARKET_REPORT,
  /** 
   * CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai 
   */
  @SerialName("CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT")
  CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CMAI-METHANOL-MARKET-REPORT")
  CMAI_METHANOL_MARKET_REPORT,
  /** 
   * CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai 
   */
  @SerialName("CMAI-MONOMERS-MARKET-REPORT")
  CMAI_MONOMERS_MARKET_REPORT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CME-DAIRY")
  CME_DAIRY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CME-NON-DAIRY-SOFT")
  CME_NON_DAIRY_SOFT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("COMEX")
  COMEX,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CRU")
  CRU,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("CRU-LONG")
  CRU_LONG,
  /** 
   * The business calendar for statistical publications by the by the United States Department of Energy (DOE). 
   */
  @SerialName("DEPARTMENT-OF-ENERGY")
  DEPARTMENT_OF_ENERGY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("DEWITT-BENZENE-DERIVATIVES")
  DEWITT_BENZENE_DERIVATIVES,
  /** 
   * Dubai Mercantile Exchange. http://www.dubaimerc.com/ 
   */
  @SerialName("DME")
  DME,
  /** 
   * Dow Jones US Calendar. http://www.dowjones.com/ 
   */
  @SerialName("DOW-JONES")
  DOW_JONES,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("DOW-JONES-ENERGY-SERVICE")
  DOW_JONES_ENERGY_SERVICE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("DOW_JONES_POWER")
  DOW_JONES_POWER,
  /** 
   * European Energy Exchange-Coal 
   */
  @SerialName("EEX-COAL")
  EEX_COAL,
  /** 
   * European Energy Exchange-Emissions Rights 
   */
  @SerialName("EEX-EMISSIONS")
  EEX_EMISSIONS,
  /** 
   * European Energy Exchange-Gas 
   */
  @SerialName("EEX-GAS")
  EEX_GAS,
  /** 
   * European Energy Exchange-Power 
   */
  @SerialName("EEX-POWER")
  EEX_POWER,
  /** 
   * TBD. 
   */
  @SerialName("EURONEX-MATIF")
  EURONEX_MATIF,
  /** 
   * FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp 
   */
  @SerialName("FERTECON")
  FERTECON,
  /** 
   * Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek 
   */
  @SerialName("FERTILIZER-WEEK")
  FERTILIZER_WEEK,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("GAS-DAILY")
  GAS_DAILY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("GAS-DAILY-PRICE-GUIDE")
  GAS_DAILY_PRICE_GUIDE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("GLOBALCOAL")
  GLOBALCOAL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("HEREN-REPORT")
  HEREN_REPORT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ICE/10X-DAILY")
  ICE_10X_DAILY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ICE/10X-MONTHLY")
  ICE_10X_MONTHLY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ICE-CANADA")
  ICE_CANADA,
  /** 
   * European Climate Exchange. 
   */
  @SerialName("ICE-ECX")
  ICE_ECX,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ICE-GAS")
  ICE_GAS,
  /** 
   * The business calendar oil and refined product contracts on ICE Futures Europe. 
   */
  @SerialName("ICE-OIL")
  ICE_OIL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("ICE-US-AGRICULTURAL")
  ICE_US_AGRICULTURAL,
  /** 
   * The business calendar for publication of ICIS Benzene (Europe) data. 
   */
  @SerialName("ICIS-PRICING-BENZENE-(EUROPE)")
  ICIS_PRICING_BENZENE__EUROPE_,
  /** 
   * The business calendar for publication of ICIS Ethylene (Europe) data. 
   */
  @SerialName("ICIS-PRICING-ETHYLENE-(EUROPE)")
  ICIS_PRICING_ETHYLENE__EUROPE_,
  /** 
   * The business calendar for publication of ICIS Polyproylene (Europe) data. 
   */
  @SerialName("ICIS-PRICING-POLYPROPYLENE-(EUROPE)")
  ICIS_PRICING_POLYPROPYLENE__EUROPE_,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("INSIDE-FERC")
  INSIDE_FERC,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("JAPAN-MOF-TSRR")
  JAPAN_MOF_TSRR,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("KCBOT")
  KCBOT,
  /** 
   * The banking business calendar in Kuala Lumpur. 
   */
  @SerialName("KUALA-LUMPUR-BANK")
  KUALA_LUMPUR_BANK,
  /** 
   * The business calendar for the Labuan Bank (Malaysia). 
   */
  @SerialName("LABUAN-BANK")
  LABUAN_BANK,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("LIFFE-LONDON-SOFT")
  LIFFE_LONDON_SOFT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("LME")
  LME,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("LONDON-BULLION-MARKET")
  LONDON_BULLION_MARKET,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("LONDON-BULLION-MARKET-GOLD-A.M-ONLY")
  LONDON_BULLION_MARKET_GOLD_A_M_ONLY,
  /** 
   * The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium. 
   */
  @SerialName("LONDON-PLATINUM-PALLADIUM-MARKET")
  LONDON_PLATINUM_PALLADIUM_MARKET,
  /** 
   * Minneapolis Grain Exchange http://www.mgex.com/ 
   */
  @SerialName("MGEX")
  MGEX,
  /** 
   * The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex). 
   */
  @SerialName("N2EX")
  N2EX,
  /** 
   * NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities 
   */
  @SerialName("NASDAQ-OMX")
  NASDAQ_OMX,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NATURAL-GAS-WEEK")
  NATURAL_GAS_WEEK,
  /** 
   * Per 2005 ISDA Commodity Definitions, Article XIV. 
   */
  @SerialName("NERC")
  NERC,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NGI")
  NGI,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NGX")
  NGX,
  /** 
   * The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php 
   */
  @SerialName("NUCLEAR-MARKET-REVIEW")
  NUCLEAR_MARKET_REVIEW,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NYMEX-ELECTRICITY")
  NYMEX_ELECTRICITY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NYMEX-GAS")
  NYMEX_GAS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NYMEX-NATURAL-GAS")
  NYMEX_NATURAL_GAS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("NYMEX-OIL")
  NYMEX_OIL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("OFFICIAL-BOARD-MARKETS")
  OFFICIAL_BOARD_MARKETS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("OPIS-LP-GAS")
  OPIS_LP_GAS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("OPIS-PROPANE")
  OPIS_PROPANE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PAPER-PACKAGING-MONITOR")
  PAPER_PACKAGING_MONITOR,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PAPER-TRADER")
  PAPER_TRADER,
  /** 
   * Pertamina-Indonesia. http://www.pertamina.com/ 
   */
  @SerialName("PERTAMINA")
  PERTAMINA,
  /** 
   * PetroChemWire Publication Calendar. http://www.petrochemwire.com/ 
   */
  @SerialName("PETROCHEMWIRE")
  PETROCHEMWIRE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PIX-PULP-BENCHMARK-INDICES")
  PIX_PULP_BENCHMARK_INDICES,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-APAG-MARKETSCAN")
  PLATTS_APAG_MARKETSCAN,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-BUNKERWIRE")
  PLATTS_BUNKERWIRE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-CLEAN-TANKERWIRE")
  PLATTS_CLEAN_TANKERWIRE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-CRUDE-OIL-MARKETWIRE")
  PLATTS_CRUDE_OIL_MARKETWIRE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-DIRTY-TANKERWIRE")
  PLATTS_DIRTY_TANKERWIRE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-EUROPEAN-GAS")
  PLATTS_EUROPEAN_GAS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-EUROPEAN-MARKETSCAN")
  PLATTS_EUROPEAN_MARKETSCAN,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-METALS-ALERT")
  PLATTS_METALS_ALERT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-OILGRAM")
  PLATTS_OILGRAM,
  /** 
   * The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore 
   */
  @SerialName("PLATTS-TSI-IRON-ORE")
  PLATTS_TSI_IRON_ORE,
  /** 
   * The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices 
   */
  @SerialName("PLATTS-TSI-SCRAP")
  PLATTS_TSI_SCRAP,
  /** 
   * The Steel Index. http://www.thesteelindex.com/en/price-specifications 
   */
  @SerialName("PLATTS-TSI-STEEL")
  PLATTS_TSI_STEEL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PLATTS-US-MARKETSCAN")
  PLATTS_US_MARKETSCAN,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PULP-AND-PAPER-INTERNATIONAL")
  PULP_AND_PAPER_INTERNATIONAL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("PULP-AND-PAPER-WEEK")
  PULP_AND_PAPER_WEEK,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("RIM-PRODUCTS-INTELLIGENCE-DAILY")
  RIM_PRODUCTS_INTELLIGENCE_DAILY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("SAFEX-SOFT")
  SAFEX_SOFT,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("SFE-SOFT")
  SFE_SOFT,
  /** 
   * Singapore Exchange. www.sgx.com 
   */
  @SerialName("SGX")
  SGX,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("SICOM")
  SICOM,
  /** 
   * Standard and Poor's GSCI. http://us.spindices.com/index-family/commodities/sp-gsci 
   */
  @SerialName("SP-GSCI")
  SP_GSCI,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("STATISTICHES-BUNDESAMT")
  STATISTICHES_BUNDESAMT,
  /** 
   * Tokyo Grain Exchange. www.tge.or.jp 
   */
  @SerialName("TGE")
  TGE,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("TOCOM-OIL")
  TOCOM_OIL,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("TOCOM-PRECIOUS")
  TOCOM_PRECIOUS,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("TOCOM-SOFT")
  TOCOM_SOFT,
  /** 
   * The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx 
   */
  @SerialName("UX-WEEKLY")
  UX_WEEKLY,
  /** 
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices. 
   */
  @SerialName("WORLD-PULP-MONTHLY")
  WORLD_PULP_MONTHLY
  ;
}

/** 
 * Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. 
 */
@Serializable
enum class CommodityInformationPublisherEnum {
  @SerialName("ARGUS")
  ARGUS,
  @SerialName("ARGUS_AMERICAS_CRUDE_REPORT")
  ARGUS_AMERICAS_CRUDE_REPORT,
  @SerialName("ARGUS_BIOFUEL_REPORT")
  ARGUS_BIOFUEL_REPORT,
  @SerialName("ARGUS_CRUDE_REPORT")
  ARGUS_CRUDE_REPORT,
  @SerialName("ARGUS_EUROPEAN_PRODUCTS_REPORT")
  ARGUS_EUROPEAN_PRODUCTS_REPORT,
  @SerialName("ARGUS_FMB")
  ARGUS_FMB,
  @SerialName("ARGUS_INTERNATIONAL_LPG_REPORT")
  ARGUS_INTERNATIONAL_LPG_REPORT,
  @SerialName("ARGUS_LPG")
  ARGUS_LPG,
  @SerialName("ARGUS_MC_CLOSKEYS")
  ARGUS_MC_CLOSKEYS,
  @SerialName("ARGUS_NAT_GAS")
  ARGUS_NAT_GAS,
  @SerialName("ASSOC_BANKS_SINGAPORE")
  ASSOC_BANKS_SINGAPORE,
  @SerialName("BLUENEXT")
  BLUENEXT,
  @SerialName("BALTIC_EXCHANGE")
  BALTIC_EXCHANGE,
  @SerialName("BAND_D")
  BAND_D,
  @SerialName("BANK_OF_CANADA")
  BANK_OF_CANADA,
  @SerialName("BANK_OF_ENGLAND")
  BANK_OF_ENGLAND,
  @SerialName("BANK_OF_JAPAN")
  BANK_OF_JAPAN,
  @SerialName("BLOOMBERG")
  BLOOMBERG,
  @SerialName("CAISO")
  CAISO,
  @SerialName("CMAI_AROMATICS_MARKET_REPORT")
  CMAI_AROMATICS_MARKET_REPORT,
  @SerialName("CMAI_WEEKLY_METHANOL_MARKET_REPORT")
  CMAI_WEEKLY_METHANOL_MARKET_REPORT,
  @SerialName("CRU_STEEL_LONG_PRODUCT_MONITOR")
  CRU_STEEL_LONG_PRODUCT_MONITOR,
  @SerialName("CRU_STEEL_SHEET_PRODUCTS_MONITOR")
  CRU_STEEL_SHEET_PRODUCTS_MONITOR,
  @SerialName("CANADIAN_GAS_PRICE_REPORTER")
  CANADIAN_GAS_PRICE_REPORTER,
  @SerialName("CANADIAN_GAS_REPORTER")
  CANADIAN_GAS_REPORTER,
  @SerialName("CHEMICAL_MARKETS_ASSOCIATION")
  CHEMICAL_MARKETS_ASSOCIATION,
  @SerialName("DOW_JONES_ENERGY_SERVICE")
  DOW_JONES_ENERGY_SERVICE,
  @SerialName("DOW_JONES_ENERGY_SERVICE_SCREEN")
  DOW_JONES_ENERGY_SERVICE_SCREEN,
  @SerialName("DOW_JONES_NAT_GAS")
  DOW_JONES_NAT_GAS,
  @SerialName("EEX")
  EEX,
  @SerialName("ERCOT")
  ERCOT,
  @SerialName("EURONEXMATIF")
  EURONEXMATIF,
  @SerialName("EURO_CENTRAL_BANK")
  EURO_CENTRAL_BANK,
  @SerialName("FERTECON")
  FERTECON,
  @SerialName("FHLBSF")
  FHLBSF,
  @SerialName("FEDERAL_RESERVE")
  FEDERAL_RESERVE,
  @SerialName("FERTILIZER_WEEK")
  FERTILIZER_WEEK,
  @SerialName("GME")
  GME,
  @SerialName("GAS_DAILY")
  GAS_DAILY,
  @SerialName("GAS_DAILY_PRICE_GUIDE")
  GAS_DAILY_PRICE_GUIDE,
  @SerialName("GLOBAL_COALE")
  GLOBAL_COALE,
  @SerialName("HEREN_REPORT")
  HEREN_REPORT,
  @SerialName("ICE")
  ICE,
  @SerialName("ICE_10_X_DAILY_NATURAL_GAS")
  ICE_10_X_DAILY_NATURAL_GAS,
  @SerialName("ICE_10_X_DAILY_POWER")
  ICE_10_X_DAILY_POWER,
  @SerialName("ICE_10_X_MONTHLY")
  ICE_10_X_MONTHLY,
  @SerialName("ICE_DAY_AHEAD_INDEX")
  ICE_DAY_AHEAD_INDEX,
  @SerialName("ICEECX")
  ICEECX,
  @SerialName("ICIS")
  ICIS,
  @SerialName("IPE")
  IPE,
  @SerialName("ISDA")
  ISDA,
  @SerialName("ISO_NEW_ENGLAND")
  ISO_NEW_ENGLAND,
  @SerialName("INSIDE_FERC")
  INSIDE_FERC,
  @SerialName("JAPANMOFTSRR")
  JAPANMOFTSRR,
  @SerialName("LEBA")
  LEBA,
  @SerialName("LONDONPLATINUMPALLADIUMMARKET")
  LONDONPLATINUMPALLADIUMMARKET,
  @SerialName("LONDON_BULLION_MARKET_ASSOCIATION")
  LONDON_BULLION_MARKET_ASSOCIATION,
  @SerialName("MISO")
  MISO,
  @SerialName("MEGAWATT_DAILY")
  MEGAWATT_DAILY,
  @SerialName("METAL_BULLETIN")
  METAL_BULLETIN,
  @SerialName("NGI_BIDWEEK_SURVEY")
  NGI_BIDWEEK_SURVEY,
  @SerialName("NYISO")
  NYISO,
  @SerialName("NATURAL_GAS_WEEK")
  NATURAL_GAS_WEEK,
  @SerialName("OBM")
  OBM,
  @SerialName("OMEL")
  OMEL,
  @SerialName("OPIS")
  OPIS,
  @SerialName("PIX")
  PIX,
  @SerialName("PJM")
  PJM,
  @SerialName("PPM")
  PPM,
  @SerialName("PPM_EUROPE")
  PPM_EUROPE,
  @SerialName("PPW")
  PPW,
  @SerialName("PAPER_TRADER")
  PAPER_TRADER,
  @SerialName("PLATTS_ASIA_PACIFIC")
  PLATTS_ASIA_PACIFIC,
  @SerialName("PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN")
  PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN,
  @SerialName("PLATTS_CLEAN_TANKERWIRE")
  PLATTS_CLEAN_TANKERWIRE,
  @SerialName("PLATTS_COAL_TRADER")
  PLATTS_COAL_TRADER,
  @SerialName("PLATTS_CRUDE_OIL_MARKETWIRE")
  PLATTS_CRUDE_OIL_MARKETWIRE,
  @SerialName("PLATTS_DIRTY_TAKERWIRE")
  PLATTS_DIRTY_TAKERWIRE,
  @SerialName("PLATTS_ENGR")
  PLATTS_ENGR,
  @SerialName("PLATTS_EUROPEAN")
  PLATTS_EUROPEAN,
  @SerialName("PLATTS_EUROPEAN_MARKETSCAN")
  PLATTS_EUROPEAN_MARKETSCAN,
  @SerialName("PLATTS_GAS_DAILY")
  PLATTS_GAS_DAILY,
  @SerialName("PLATTS_GAS_DAILY_PRICE_GUIDE")
  PLATTS_GAS_DAILY_PRICE_GUIDE,
  @SerialName("PLATTS_INSIDE_FERC")
  PLATTS_INSIDE_FERC,
  @SerialName("PLATTS_LPG")
  PLATTS_LPG,
  @SerialName("PLATTS_MARKETWIRE")
  PLATTS_MARKETWIRE,
  @SerialName("PLATTS_MEGAWATT_DAILY")
  PLATTS_MEGAWATT_DAILY,
  @SerialName("PLATTS_METALS_ALERT")
  PLATTS_METALS_ALERT,
  @SerialName("PLATTS_OILGRAM")
  PLATTS_OILGRAM,
  @SerialName("PLATTS_OILGRAM_BUNKERWIRE")
  PLATTS_OILGRAM_BUNKERWIRE,
  @SerialName("PLATTS_POLYMERSCAN")
  PLATTS_POLYMERSCAN,
  @SerialName("PLATTS_TSI_IRON_ORE")
  PLATTS_TSI_IRON_ORE,
  @SerialName("PLATTS_US")
  PLATTS_US,
  @SerialName("PLATTS_US_MARKETSCAN")
  PLATTS_US_MARKETSCAN,
  @SerialName("RIM_INTELLIGENCE_PRODUCTS")
  RIM_INTELLIGENCE_PRODUCTS,
  @SerialName("RESERVE_BANK_AUSTRALIA")
  RESERVE_BANK_AUSTRALIA,
  @SerialName("RESERVE_BANK_NEW_ZEALAND")
  RESERVE_BANK_NEW_ZEALAND,
  @SerialName("REUTERS")
  REUTERS,
  @SerialName("REUTERS_SCREEN")
  REUTERS_SCREEN,
  @SerialName("SEA_PAC")
  SEA_PAC,
  @SerialName("TSI_SCRAP")
  TSI_SCRAP,
  @SerialName("TSI_STEEL")
  TSI_STEEL,
  @SerialName("TELERATE")
  TELERATE,
  @SerialName("TELERATE_SCREEN")
  TELERATE_SCREEN,
  @SerialName("UXWEEKLY")
  UXWEEKLY,
  @SerialName("WORLD_CRUDE_REPORT")
  WORLD_CRUDE_REPORT,
  @SerialName("WORLD_PULP_MONTHLY")
  WORLD_PULP_MONTHLY
  ;
}

/** 
 * Defines the enumerated values to specify the nature of a location identifier. 
 */
@Serializable
enum class CommodityLocationIdentifierTypeEnum {
  /** 
   * The hub code of the buyer. 
   */
  @SerialName("BUYER_HUB")
  BUYER_HUB,
  /** 
   * The physical or virtual point at which the commodity will be delivered. 
   */
  @SerialName("DELIVERY_POINT")
  DELIVERY_POINT,
  /** 
   * The zone covering potential delivery points for the commodity 
   */
  @SerialName("DELIVERY_ZONE")
  DELIVERY_ZONE,
  /** 
   * The physical or virtual point at which the commodity enters a transportation system. 
   */
  @SerialName("ENTRY_POINT")
  ENTRY_POINT,
  /** 
   * Identification of the border(s) or border point(s) of a transportation contract. 
   */
  @SerialName("INTERCONNECTION_POINT")
  INTERCONNECTION_POINT,
  /** 
   * The hub code of the seller. 
   */
  @SerialName("SELLER_HUB")
  SELLER_HUB,
  /** 
   * The physical or virtual point at which the commodity is withdrawn from a transportation system. 
   */
  @SerialName("WITHDRAWAL_POINT")
  WITHDRAWAL_POINT
  ;
}

/** 
 * The enumeration values to specify the Commodity Reference Prices specified in the Annex to the 2005 ISDA Commodity Definitions. 
 */
@Serializable
enum class CommodityReferencePriceEnum {
  /** 
   * Per 2005 ISDA Commodity Definitions, Sub-Annex A, Section 7.1 Commodity Reference Prices, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ALUMINIUM ALLOY-LME 15 MONTH")
  ALUMINIUM_ALLOY_LME_15_MONTH,
  /** 
   * A code for the NYMEX Central Appalachian Coal commodity 
   */
  @SerialName("COAL-CENTRAL APPALACHIAN-NYMEX")
  COAL_CENTRAL_APPALACHIAN_NYMEX,
  /** 
   * A code for the ICE Futures U.S. (‘ICUS’) Cocoa commodity 
   */
  @SerialName("COCOA-ICE")
  COCOA_ICE,
  /** 
   * A code for the ICUS Coffee C commodity 
   */
  @SerialName("COFFEE ARABICA-ICE")
  COFFEE_ARABICA_ICE,
  /** 
   * A code for the ICUS Coffee C commodity 
   */
  @SerialName("COFFEE ROBUSTA-ICE")
  COFFEE_ROBUSTA_ICE,
  /** 
   * A code for the COMEX (‘CMX’) Copper Grade #1 commodity 
   */
  @SerialName("COPPER-COMEX")
  COPPER_COMEX,
  /** 
   * A code for the Chicago Board of Trade (‘CBOT’) Corn commodity 
   */
  @SerialName("CORN-CBOT")
  CORN_CBOT,
  /** 
   * A code for the ICUS Cotton No. 2 commodity 
   */
  @SerialName("COTTON NO. 2-ICE")
  COTTON_NO__2_ICE,
  /** 
   * A code for the CBOT Ethanol commodity 
   */
  @SerialName("ETHANOL-CBOT")
  ETHANOL_CBOT,
  /** 
   * A code for the CME Feeder Cattle commodity 
   */
  @SerialName("FEEDER CATTLE-CME")
  FEEDER_CATTLE_CME,
  /** 
   * A code for the ICUS Frozen Concentrated Orange Juice commodity 
   */
  @SerialName("FROZEN CONCENTRATED ORANGE JUICE NO. 1-ICE")
  FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE,
  /** 
   * A code for the NYMEX Gasoline Blendstock (RBOB) commodity 
   */
  @SerialName("GASOLINE-RBOB-NEW YORK-ICE")
  GASOLINE_RBOB_NEW_YORK_ICE,
  /** 
   * A code for the NYMEX Gasoline Blendstock (RBOB) commodity 
   */
  @SerialName("GASOLINE-RBOB-NEW YORK-NYMEX")
  GASOLINE_RBOB_NEW_YORK_NYMEX,
  /** 
   * A code for the CMX Gold commodity 
   */
  @SerialName("GOLD-COMEX")
  GOLD_COMEX,
  /** 
   * A code for the NYMEX No. 2 Heating Oil, New York Harbor commodity 
   */
  @SerialName("HEATING OIL-NEW YORK-NYMEX")
  HEATING_OIL_NEW_YORK_NYMEX,
  /** 
   * A code for the CME Lean Hogs commodity 
   */
  @SerialName("LEAN HOGS-CME")
  LEAN_HOGS_CME,
  /** 
   * A code for the CME Live Cattle commodity 
   */
  @SerialName("LIVE CATTLE-CME")
  LIVE_CATTLE_CME,
  /** 
   * A code for the CME Random Length Lumber commodity 
   */
  @SerialName("LUMBER-CME")
  LUMBER_CME,
  /** 
   * A code for the CME Milk Class III commodity 
   */
  @SerialName("MILK-CLASS III-CME")
  MILK_CLASS_III_CME,
  /** 
   * A code for the CME Non Fat Dry Milk commodity 
   */
  @SerialName("MILK-NONFAT-DRY-CME")
  MILK_NONFAT_DRY_CME,
  /** 
   * A code for the NYMEX Natural Gas commodity 
   */
  @SerialName("NATURAL GAS-NYMEX")
  NATURAL_GAS_NYMEX,
  /** 
   * A code for the NYMEX Panhandle Basis Swap commodity 
   */
  @SerialName("NATURAL GAS-PEPL (TEXOK MAINLINE)-INSIDE FERC")
  NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC,
  /** 
   * A code for the NYMEX Waha Basis Swap commodity 
   */
  @SerialName("NATURAL GAS-W. TEXAS (WAHA)-INSIDE FERC")
  NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC,
  /** 
   * A code for the CBOT Oats commodity 
   */
  @SerialName("OATS-CBOT")
  OATS_CBOT,
  /** 
   * A code for the NYMEX Crude Oil, Light Sweet commodity 
   */
  @SerialName("OIL-WTI-NYMEX")
  OIL_WTI_NYMEX,
  /** 
   * A code for the NYMEX Palladium commodity 
   */
  @SerialName("PALLADIUM-NYMEX")
  PALLADIUM_NYMEX,
  /** 
   * A code for the NYMEX Platinum commodity 
   */
  @SerialName("PLATINUM-NYMEX")
  PLATINUM_NYMEX,
  /** 
   * A code for the CBOT Rough Rice commodity 
   */
  @SerialName("RICE-CBOT")
  RICE_CBOT,
  /** 
   * A code for the CMX Silver commodity 
   */
  @SerialName("SILVER-COMEX")
  SILVER_COMEX,
  /** 
   * A code for the CBOT Soybeans commodity 
   */
  @SerialName("SOYBEANS-CBOT")
  SOYBEANS_CBOT,
  /** 
   * A code for the CBOT Soybean Meal commodity 
   */
  @SerialName("SOYBEAN MEAL-CBOT")
  SOYBEAN_MEAL_CBOT,
  /** 
   * A code for the CBOT Soybean Oil commodity 
   */
  @SerialName("SOYBEAN OIL-CBOT")
  SOYBEAN_OIL_CBOT,
  /** 
   * A code for the ICUS Sugar No. 11 commodity 
   */
  @SerialName("SUGAR # 11 (WORLD)-ICE")
  SUGAR___11__WORLD__ICE,
  /** 
   * A code for the ICUS Sugar No. 16 commodity 
   */
  @SerialName("SUGAR # 16 (US)-ICE")
  SUGAR___16__US__ICE,
  /** 
   * A code for the CBOT Wheat commodity 
   */
  @SerialName("WHEAT-CBOT")
  WHEAT_CBOT,
  /** 
   * A code for the Kansas City Board of Trade (‘KCBT’)Wheat commodity 
   */
  @SerialName("WHEAT HRW-KCBOT")
  WHEAT_HRW_KCBOT,
  /** 
   * A code for the Wheat commodity 
   */
  @SerialName("WHEAT RED SPRING-MGE")
  WHEAT_RED_SPRING_MGE
  ;
}

@Serializable
enum class CompareOp {
  @SerialName("EQUALS")
  EQUALS,
  @SerialName("GREATER_THAN")
  GREATER_THAN,
  @SerialName("GREATER_THAN_OR_EQUALS")
  GREATER_THAN_OR_EQUALS,
  @SerialName("LESS_THAN")
  LESS_THAN,
  @SerialName("LESS_THAN_OR_EQUALS")
  LESS_THAN_OR_EQUALS
  ;
}

/** 
 * The enumerated values to specify the type of compounding, e.g. flat, straight. 
 */
@Serializable
enum class CompoundingMethodEnum {
  /** 
   * Flat compounding. Compounding excludes the spread. Note that the first compounding period has it's interest calculated including any spread then subsequent periods compound this at a rate excluding the spread. 
   */
  @SerialName("FLAT")
  FLAT,
  /** 
   * No compounding is to be applied. 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * Spread Exclusive compounding. 
   */
  @SerialName("SPREAD_EXCLUSIVE")
  SPREAD_EXCLUSIVE,
  /** 
   * Straight compounding. Compounding includes the spread. 
   */
  @SerialName("STRAIGHT")
  STRAIGHT
  ;
}

/** 
 * The enumerated values to specify how the compounding calculation is done 
 */
@Serializable
enum class CompoundingTypeEnum {
  /** 
   * Compounding is done only on business days, i.e. not compounded each day on weekends or holidays. 
   */
  @SerialName("BUSINESS")
  BUSINESS,
  /** 
   * Compounding is done on each calendar day. 
   */
  @SerialName("CALENDAR")
  CALENDAR,
  /** 
   * Compounding is not applicable 
   */
  @SerialName("NONE")
  NONE
  ;
}

/** 
 * Represents the enumerated values to identify where a concentration limit is applied. 
 */
@Serializable
enum class ConcentrationLimitTypeEnum {
  /** 
   * Specifies a limit on a single asset in the portfolio 
   */
  @SerialName("ASSET")
  ASSET,
  /** 
   * Specifies a limit on all cash valued in the base currency of the portfolio. 
   */
  @SerialName("BASE_CURRENCY_EQUIVALENT")
  BASE_CURRENCY_EQUIVALENT,
  /** 
   * Specifies a limit on a single industry sector in the portfolio. 
   */
  @SerialName("INDUSTRY_SECTOR")
  INDUSTRY_SECTOR,
  /** 
   * Specifies a limit of the issue compared to the outstanding amount of the asset on the market. 
   */
  @SerialName("ISSUE_OUTSTANDING_AMOUNT")
  ISSUE_OUTSTANDING_AMOUNT,
  /** 
   * Specifies a limit on a single issuer in the portfolio. 
   */
  @SerialName("ISSUER")
  ISSUER,
  /** 
   * Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market. 
   */
  @SerialName("MARKET_CAPITALISATION")
  MARKET_CAPITALISATION,
  /** 
   * Specifies a limit on a single exchange in the portfolio. 
   */
  @SerialName("PRIMARY_EXCHANGE")
  PRIMARY_EXCHANGE,
  /** 
   * Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level. 
   */
  @SerialName("ULTIMATE_PARENT_INSTITUTION")
  ULTIMATE_PARENT_INSTITUTION
  ;
}

/** 
 * Enumeration for the different types of confirmation status. 
 */
@Serializable
enum class ConfirmationStatusEnum {
  @SerialName("CONFIRMED")
  CONFIRMED,
  @SerialName("UNCONFIRMED")
  UNCONFIRMED
  ;
}

/** 
 * The enumerated values to specify a set of standard contract definitions relevant to the transaction. 
 */
@Serializable
enum class ContractualDefinitionsEnum {
  /** 
   * ISDA 1991 Interest Rate Definitions 
   */
  @SerialName("ISDA_1991_INTEREST_RATE")
  ISDA_1991_INTEREST_RATE,
  /** 
   * ISDA 1993 Commodity Derivatives Definitions 
   */
  @SerialName("ISDA_1993_COMMODITY_DERIVATIVES")
  ISDA_1993_COMMODITY_DERIVATIVES,
  /** 
   * ISDA 1996 Equity Derivatives Definitions 
   */
  @SerialName("ISDA_1996_EQUITY_DERIVATIVES")
  ISDA_1996_EQUITY_DERIVATIVES,
  /** 
   * ISDA 1997 Bullion Definitions 
   */
  @SerialName("ISDA_1997_BULLION")
  ISDA_1997_BULLION,
  /** 
   * ISDA 1997 Government Bond Option Definitions 
   */
  @SerialName("ISDA_1997_GOVERNMENT_BOND_OPTION")
  ISDA_1997_GOVERNMENT_BOND_OPTION,
  /** 
   * ISDA 1998 FX and Currency Option Definitions 
   */
  @SerialName("ISDA_1998_FX_AND_CURRENCY_OPTION")
  ISDA_1998_FX_AND_CURRENCY_OPTION,
  /** 
   * ISDA 1999 Credit Derivatives Definitions 
   */
  @SerialName("ISDA_1999_CREDIT_DERIVATIVES")
  ISDA_1999_CREDIT_DERIVATIVES,
  /** 
   * ISDA 2000 Definitions 
   */
  @SerialName("ISDA2000")
  ISDA2000,
  /** 
   * ISDA 2002 Equity Derivatives Definitions 
   */
  @SerialName("ISDA_2002_EQUITY_DERIVATIVES")
  ISDA_2002_EQUITY_DERIVATIVES,
  /** 
   * ISDA 2003 Credit Derivatives Definitions 
   */
  @SerialName("ISDA_2003_CREDIT_DERIVATIVES")
  ISDA_2003_CREDIT_DERIVATIVES,
  /** 
   * ISDA 2004 Novation Definitions 
   */
  @SerialName("ISDA_2004_NOVATION")
  ISDA_2004_NOVATION,
  /** 
   * ISDA 2005 Commodity Definitions 
   */
  @SerialName("ISDA_2005_COMMODITY")
  ISDA_2005_COMMODITY,
  /** 
   * ISDA 2006 Definitions 
   */
  @SerialName("ISDA2006")
  ISDA2006,
  /** 
   * ISDA 2006 Inflation Derivatives Definitions 
   */
  @SerialName("ISDA_2006_INFLATION_DERIVATIVES")
  ISDA_2006_INFLATION_DERIVATIVES,
  /** 
   * ISDA 2008 Inflation Derivatives Definitions 
   */
  @SerialName("ISDA_2008_INFLATION_DERIVATIVES")
  ISDA_2008_INFLATION_DERIVATIVES,
  /** 
   * ISDA 2011 Equity Derivatives Definitions 
   */
  @SerialName("ISDA_2011_EQUITY_DERIVATIVES")
  ISDA_2011_EQUITY_DERIVATIVES,
  /** 
   * ISDA 2014 Credit Derivatives Definitions 
   */
  @SerialName("ISDA_2014_CREDIT_DERIVATIVES")
  ISDA_2014_CREDIT_DERIVATIVES,
  /** 
   * ISDA 2021 Interest Rate Derivatives Definitions 
   */
  @SerialName("ISDA_2021_INTEREST_RATE_DERIVATIVES")
  ISDA_2021_INTEREST_RATE_DERIVATIVES,
  /** 
   * ISDA 2022 Verified Carbon Credit Transactions Definitions 
   */
  @SerialName("ISDA_2022_VERIFIED_CARBON_CREDIT")
  ISDA_2022_VERIFIED_CARBON_CREDIT,
  /** 
   * ISDA 2023 Digital Asset Derivatives Definitions 
   */
  @SerialName("ISDA_2023_DIGITAL_ASSET_DERIVATIVES")
  ISDA_2023_DIGITAL_ASSET_DERIVATIVES
  ;
}

/** 
 * The enumerated values to define the supplements to a base set of ISDA Definitions that are applicable to the transaction. 
 */
@Serializable
enum class ContractualSupplementTypeEnum {
  /** 
   * Standard Terms Supplement for ABX Transactions. 
   */
  @SerialName("ABX")
  ABX,
  /** 
   * Standard Terms Supplement for Asset-Backed Tranche Transactions. 
   */
  @SerialName("ABX_TRANCHE")
  ABX_TRANCHE,
  /** 
   * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Leveraged Loans. 
   */
  @SerialName("CD_SON_LEVERAGED_LOANS")
  CD_SON_LEVERAGED_LOANS,
  /** 
   * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement. 
   */
  @SerialName("CD_SON_MBS")
  CD_SON_MBS,
  /** 
   * Standard Terms Supplement for CDX Untranched Transactions. 
   */
  @SerialName("CDX")
  CDX,
  /** 
   * Standard Terms Supplement for CDX Emerging Markets Untranched Transactions. 
   */
  @SerialName("CDX_EMERGING_MARKETS")
  CDX_EMERGING_MARKETS,
  /** 
   * Standard Terms Supplement for CDX Emerging Markets Diversified Untranched Transactions.. 
   */
  @SerialName("CDX_EMERGING_MARKETS_DIVERSIFIED")
  CDX_EMERGING_MARKETS_DIVERSIFIED,
  /** 
   * Standard Terms Supplement for CDX Swaption Transactions. 
   */
  @SerialName("CDX_SWAPTION")
  CDX_SWAPTION,
  /** 
   * Standard Terms Supplement for Dow Jones CDX Tranche Transactions. 
   */
  @SerialName("CDX_TRANCHE")
  CDX_TRANCHE,
  /** 
   * Standard Terms Supplement for CMBX Transactions. 
   */
  @SerialName("CMBX")
  CMBX,
  /** 
   * Standard Terms Supplement for Single Name European CMBS Transactions. 
   */
  @SerialName("EUROPEAN_CMBS")
  EUROPEAN_CMBS,
  /** 
   * Standard Terms Supplement for Single Name European RMBS Transactions. 
   */
  @SerialName("EUROPEAN_RMBS")
  EUROPEAN_RMBS,
  /** 
   * Standard Terms Supplement for IOS Transactions. 
   */
  @SerialName("IOS")
  IOS,
  /** 
   * Supplement to the 1999 ISDA Credit Derivatives Definitions Relating to Convertible, Exchangeable or Accreting Obligations dated November 9, 2001. 
   */
  @SerialName("ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS")
  ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS,
  /** 
   * Restructuring Supplement to the 1999 ISDA Credit Derivatives Definitions dated May 11, 2001. 
   */
  @SerialName("ISDA_1999_CREDIT_RESTRUCTURING")
  ISDA_1999_CREDIT_RESTRUCTURING,
  /** 
   * Supplement Relating to Successor and Credit Events to the 1999 ISDA Credit Derivatives Definitions dated November 28, 2001. 
   */
  @SerialName("ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS")
  ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS,
  /** 
   * Additional Provisions for LPN dated December 6, 2007. 
   */
  @SerialName("ISDA_2003_ADDITIONAL_PROVISIONS_LPN")
  ISDA_2003_ADDITIONAL_PROVISIONS_LPN,
  /** 
   * Additional Provisions for Contingent Credit Spread Transactions dated August 15, 2008. 
   */
  @SerialName("ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION")
  ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION,
  /** 
   * 2005 Matrix Supplement to the 2003 ISDA Credit Derivatives. 
   */
  @SerialName("ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT")
  ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT,
  /** 
   * Additional Provisions for the Argentine Republic: Excluded Obligations and Excluded Deliverable Obligations dated December 21, 2005. 
   */
  @SerialName("ISDA_2003_CREDIT_ARGENTINE_REPUBLIC")
  ISDA_2003_CREDIT_ARGENTINE_REPUBLIC,
  /** 
   * ISDA Credit Derivatives Determinations Committees and Auction Settlement Supplement to the 2003 ISDA Credit Derivatives Definitions (published on [TBD]). 
   */
  @SerialName("ISDA_2003_CREDIT_AUCTION_SUPPLEMENT")
  ISDA_2003_CREDIT_AUCTION_SUPPLEMENT,
  /** 
   * May 2003 Supplement to the 2003 ISDA Credit Derivatives Definitions. 
   */
  @SerialName("ISDA_2003_CREDIT_MAY_2003")
  ISDA_2003_CREDIT_MAY_2003,
  /** 
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated May 9, 2003. 
   */
  @SerialName("ISDA_2003_CREDIT_MONOLINE_INSURERS")
  ISDA_2003_CREDIT_MONOLINE_INSURERS,
  /** 
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated January 21, 2005. 
   */
  @SerialName("ISDA_2003_CREDIT_MONOLINE_INSURERS_2005")
  ISDA_2003_CREDIT_MONOLINE_INSURERS_2005,
  /** 
   * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY")
  ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY,
  /** 
   * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated February 14, 2005.  
   */
  @SerialName("ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005")
  ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005,
  /** 
   * Additional Provisions for the Russian Federation: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_RUSSIAN_FEDERATION")
  ISDA_2003_CREDIT_RUSSIAN_FEDERATION,
  /** 
   * Additional Provisions for Credit Derivative Transactions - U.S. Municipal Entity as Reference Entity dated September 17, 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_US_MUNICIPALS")
  ISDA_2003_CREDIT_US_MUNICIPALS,
  /** 
   * Additional Provisions for STMicroelectronics NV dated December 6, 2007. 
   */
  @SerialName("ISDA_2003_ST_MICROELECTRONICS_NV")
  ISDA_2003_ST_MICROELECTRONICS_NV,
  /** 
   * 2007 Full Lookthrough Depository Receipt Supplement to the 2002 Equity Derivatives Definitions. 
   */
  @SerialName("ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT")
  ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,
  /** 
   * 2007 Partial Lookthrough Depository Receipt Supplement to the 2002 ISDA Equity Derivatives Definitions. 
   */
  @SerialName("ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT")
  ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,
  /** 
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer. 
   */
  @SerialName("ISDA_CREDIT_MONOLINE_INSURERS")
  ISDA_CREDIT_MONOLINE_INSURERS,
  /** 
   * Additional Provisions for Fixed Recovery Credit Default Swap Transactions 
   */
  @SerialName("ISDA_DELIVERY_RESTRICTIONS")
  ISDA_DELIVERY_RESTRICTIONS,
  /** 
   * Additional Provisions for Fixed Recovery Credit Default Swap Transactions. 
   */
  @SerialName("ISDA_FIXED_RECOVERY")
  ISDA_FIXED_RECOVERY,
  /** 
   * Additional Provisions for LPN Reference Entities. 
   */
  @SerialName("ISDALPN_REFERENCE_ENTITIES")
  ISDALPN_REFERENCE_ENTITIES,
  /** 
   * Canadian Supplement to the 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement dated March 29, 2004. 
   */
  @SerialName("ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT")
  ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT,
  /** 
   * Additional Provisions for Recovery Lock Credit Default Swap Transactions. 
   */
  @SerialName("ISDA_RECOVERY_LOCK")
  ISDA_RECOVERY_LOCK,
  /** 
   * Additional Provisions for Secured Deliverable Obligation Characteristic. 
   */
  @SerialName("ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC")
  ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC,
  /** 
   * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Transactions. 
   */
  @SerialName("LCDX")
  LCDX,
  /** 
   * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Tranche Transactions. 
   */
  @SerialName("LCDX_TRANCHE")
  LCDX_TRANCHE,
  /** 
   * Standard Terms Supplement for MBX Transactions. 
   */
  @SerialName("MBX")
  MBX,
  /** 
   * Standard Terms Supplement for Municipal CDX Untranched Transactions. 
   */
  @SerialName("MCDX")
  MCDX,
  /** 
   * Standard Terms Supplement for PO Index Transactions. 
   */
  @SerialName("PO")
  PO,
  /** 
   * Standard Terms Supplement for PrimeX Transactions. 
   */
  @SerialName("PRIME_X")
  PRIME_X,
  /** 
   * Standard Terms Supplement for Standard CDX Tranche Transactions. 
   */
  @SerialName("STANDARD_CDX_TRANCHE")
  STANDARD_CDX_TRANCHE,
  /** 
   * Standard Syndicated Secured Loan Credit Default Swap Standard Terms Supplement. 
   */
  @SerialName("STANDARD_LCDS")
  STANDARD_LCDS,
  /** 
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions. 
   */
  @SerialName("STANDARD_LCDS_BULLET")
  STANDARD_LCDS_BULLET,
  /** 
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions. 
   */
  @SerialName("STANDARD_LCDX_BULLET")
  STANDARD_LCDX_BULLET,
  /** 
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions. 
   */
  @SerialName("STANDARD_LCDX_BULLET_TRANCHE")
  STANDARD_LCDX_BULLET_TRANCHE,
  /** 
   * Standard Terms Supplement for Standard iTraxx Europe Tranched Transactions. 
   */
  @SerialName("STANDARDI_TRAXX_EUROPE_TRANCHE")
  STANDARDI_TRAXX_EUROPE_TRANCHE,
  /** 
   * Syndicated Secured Loan Credit Default Swap Standard Terms Supplement. 
   */
  @SerialName("SYNDICATED_SECURED_LOAN_CDS")
  SYNDICATED_SECURED_LOAN_CDS,
  /** 
   * Standard Terms Supplement for TRX Transactions. 
   */
  @SerialName("TRX")
  TRX,
  /** 
   * Standard Terms Supplement for TRX.II Transactions. 
   */
  @SerialName("TRX.II")
  TRX_II,
  /** 
   * Standard Terms Supplement for iTraxx Asia Excluding Japan. 
   */
  @SerialName("I_TRAXX_ASIA_EX_JAPAN")
  I_TRAXX_ASIA_EX_JAPAN,
  /** 
   * Standard Terms Supplement for iTraxx Asia Ex-Japan Swaption Transactions. 
   */
  @SerialName("I_TRAXX_ASIA_EX_JAPAN_SWAPTION")
  I_TRAXX_ASIA_EX_JAPAN_SWAPTION,
  /** 
   * Standard Terms Supplement for iTraxx Asia Excluding Japan Tranched Transactions. 
   */
  @SerialName("I_TRAXX_ASIA_EX_JAPAN_TRANCHE")
  I_TRAXX_ASIA_EX_JAPAN_TRANCHE,
  /** 
   * Standard Terms Supplement for iTraxx Australia. 
   */
  @SerialName("I_TRAXX_AUSTRALIA")
  I_TRAXX_AUSTRALIA,
  /** 
   * Standard Terms Supplement for iTraxx Australia Swaption Transactions. 
   */
  @SerialName("I_TRAXX_AUSTRALIA_SWAPTION")
  I_TRAXX_AUSTRALIA_SWAPTION,
  /** 
   * Standard Terms Supplement for iTraxx Australia Tranched Transactions. 
   */
  @SerialName("I_TRAXX_AUSTRALIA_TRANCHE")
  I_TRAXX_AUSTRALIA_TRANCHE,
  /** 
   * Standard Terms Supplement for iTraxx CJ. 
   */
  @SerialName("I_TRAXX_CJ")
  I_TRAXX_CJ,
  /** 
   * Standard Terms Supplement for iTraxx CJ Tranched Transactions. 
   */
  @SerialName("I_TRAXX_CJ_TRANCHE")
  I_TRAXX_CJ_TRANCHE,
  /** 
   * Standard Terms Supplement for iTraxx Europe Transactions. 
   */
  @SerialName("I_TRAXX_EUROPE")
  I_TRAXX_EUROPE,
  /** 
   * Standard Terms Supplement for iTraxx Europe Dealer Form. 
   */
  @SerialName("I_TRAXX_EUROPE_DEALER")
  I_TRAXX_EUROPE_DEALER,
  /** 
   * Standard Terms Supplement for iTraxx Europe Non-Dealer Form. 
   */
  @SerialName("I_TRAXX_EUROPE_NON_DEALER")
  I_TRAXX_EUROPE_NON_DEALER,
  /** 
   * Standard Terms Supplement for iTraxx Europe Swaption Transactions. 
   */
  @SerialName("I_TRAXX_EUROPE_SWAPTION")
  I_TRAXX_EUROPE_SWAPTION,
  /** 
   * Standard Terms Supplement for iTraxx Europe Tranched Transactions. 
   */
  @SerialName("I_TRAXX_EUROPE_TRANCHE")
  I_TRAXX_EUROPE_TRANCHE,
  /** 
   * Standard Terms Supplement for iTraxx Japan. 
   */
  @SerialName("I_TRAXX_JAPAN")
  I_TRAXX_JAPAN,
  /** 
   * Standard Terms Supplement for iTraxx Japan Swaption Transactions. 
   */
  @SerialName("I_TRAXX_JAPAN_SWAPTION")
  I_TRAXX_JAPAN_SWAPTION,
  /** 
   * Standard Terms Supplement for iTraxx Japan Tranched Transactions. 
   */
  @SerialName("I_TRAXX_JAPAN_TRANCHE")
  I_TRAXX_JAPAN_TRANCHE,
  /** 
   * Standard Terms Supplement for iTraxx LevX. 
   */
  @SerialName("I_TRAXX_LEV_X")
  I_TRAXX_LEV_X,
  /** 
   * Standard Terms Supplement for iTraxx SDI 75 Dealer Transactions. 
   */
  @SerialName("I_TRAXX_SDI_75_DEALER")
  I_TRAXX_SDI_75_DEALER,
  /** 
   * Standard Terms Supplement for iTraxx SDI 75 Non-Dealer Transactions. 
   */
  @SerialName("I_TRAXX_SDI_75_NON_DEALER")
  I_TRAXX_SDI_75_NON_DEALER,
  /** 
   * Standard Terms Supplement for iTraxx SovX. 
   */
  @SerialName("I_TRAXX_SOV_X")
  I_TRAXX_SOV_X
  ;
}

/** 
 * The enumerated values to specify the origin of a corporate action transfer. 
 */
@Serializable
enum class CorporateActionTypeEnum {
  /** 
   * Corporate action triggered by a bonus issue. A bonus issue or bonus share is a free share of stock given to current shareholders in a company, based upon the number of shares that the shareholder already owns. While the issue of bonus shares increases the total number of shares issued and owned, it does not change the value of the company. The value maps closely to the ISO code (BONU) defined as a bonus, scrip or capitalisation issue. Security holders receive additional assets free of payment from the issuer, in proportion to their holding. 
   */
  @SerialName("BONUS_ISSUE")
  BONUS_ISSUE,
  /** 
   * Corporate action triggered by the distribution of a cash dividend. 
   */
  @SerialName("CASH_DIVIDEND")
  CASH_DIVIDEND,
  /** 
   * Corporate action triggered by a Class Action. An action where an individual represents a group in a court claim. The judgment from the suit is for all the members of the group (class). The value maps closely to the ISO code (CLSA) defined as the situation where interested parties seek restitution for financial loss. The security holder may be offered the opportunity to join a class action proceeding and would need to respond with an instruction. 
   */
  @SerialName("CLASS_ACTION")
  CLASS_ACTION,
  /** 
   * Corporate action triggered by the removal of a security from a stock exchange. 
   */
  @SerialName("DELISTING")
  DELISTING,
  /** 
   * Corporate action triggered by an early redemption. The value maps closely to the ISO code (MCAL) defined as the redemption of an entire issue outstanding of securities, for example, bonds, preferred equity, funds, by the issuer or its agent, for example, asset manager, before final maturity. 
   */
  @SerialName("EARLY_REDEMPTION")
  EARLY_REDEMPTION,
  /** 
   * Corporate action triggered by a liquidation. When a business or firm is terminated or bankrupt, its assets are sold (liquidated) and the proceeds pay creditors. Any leftovers are distributed to shareholders. The value maps closely to the ISO code (LIQU) defined as a distribution of cash, assets or both. Debt may be paid in order of priority based on preferred claims to assets specified by the security. 
   */
  @SerialName("LIQUIDATION")
  LIQUIDATION,
  /** 
   * Corporate action triggered by a merger. Mergers and acquisitions (abbreviated M&A) is an aspect of corporate strategy, corporate finance and management dealing with the buying, selling, dividing and combining of different companies and similar entities that can help an enterprise grow rapidly in its sector or location of origin, or a new field or new location, without creating a subsidiary, other child entity or using a joint venture. The distinction between a merger and an acquisition has become increasingly blurred in various respects (particularly in terms of the ultimate economic outcome), although it has not completely disappeared in all situations. The value maps closely to the ISO code (MRGR) defined as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities. 
   */
  @SerialName("MERGER")
  MERGER,
  /** 
   * Corporate action triggered by a reverse split. A reverse stock split or reverse split is a process by a company of issuing to each shareholder in that company a smaller number of new shares in proportion to that shareholder's original shares that are subsequently canceled. A reverse stock split is also called a stock merge. The reduction in the number of issued shares is accompanied by a proportional increase in the share price. The value maps closely to the ISO code (SPLR) defined as a decrease in a company's number of outstanding equities without any change in the shareholder's equity or the aggregate market value at the time of the split. Equity price and nominal value are increased accordingly. 
   */
  @SerialName("REVERSE_STOCK_SPLIT")
  REVERSE_STOCK_SPLIT,
  /** 
   * Corporate action triggered by an issuance to shareholders of rights to purchase additional shares at a discount. 
   */
  @SerialName("RIGHTS_ISSUE")
  RIGHTS_ISSUE,
  /** 
   * Corporate action triggered by a spin Off. A spin-out, also known as a spin-off or a starburst, refers to a type of corporate action where a company splits off sections of itself as a separate business. The value maps closely to the ISO code (SOFF) defined as a a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares. Spin-off represents a form of divestiture usually resulting in an independent company or in an existing company. For example, demerger, distribution, unbundling. 
   */
  @SerialName("SPIN_OFF")
  SPIN_OFF,
  /** 
   * Corporate action triggered by the distribution of a stock dividend. 
   */
  @SerialName("STOCK_DIVIDEND")
  STOCK_DIVIDEND,
  /** 
   * Corporate action triggered by a change in the code used to trade the security. 
   */
  @SerialName("STOCK_IDENTIFIER_CHANGE")
  STOCK_IDENTIFIER_CHANGE,
  /** 
   * Corporate action triggered by a change in the name used to trade the security. 
   */
  @SerialName("STOCK_NAME_CHANGE")
  STOCK_NAME_CHANGE,
  /** 
   * Corporate action triggered by a Stock Reclassification. 
   */
  @SerialName("STOCK_RECLASSIFICATION")
  STOCK_RECLASSIFICATION,
  /** 
   * Corporate action triggered by a stock split. A stock split or stock divide increases the number of shares in a public company. The price is adjusted such that the before and after market capitalization of the company remains the same and dilutiondoes not occur. The value maps closely to the ISO code (SPLF) defined as a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares. 
   */
  @SerialName("STOCK_SPLIT")
  STOCK_SPLIT,
  /** 
   * Corporate action triggered by a takeover. A takeover is the purchase of onecompany (the target) by another (the acquirer, or bidder). The value maps to the ISO code (TEND) but is finer grained than TEND which emcompasses Tender/Acquisition/Takeover/Purchase Offer/Buyback. ISO defines the TEND code as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities. 
   */
  @SerialName("TAKEOVER")
  TAKEOVER
  ;
}

/** 
 * Defines the enumerated values to specify the two counterparties to the transaction. 
 */
@Serializable
enum class CounterpartyRoleEnum {
  @SerialName("PARTY_1")
  PARTY_1,
  @SerialName("PARTY_2")
  PARTY_2
  ;
}

/** 
 * Represents the enumerated values to specify a credit event type. 
 */
@Serializable
enum class CreditEventTypeEnum {
  /** 
   * The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as 'technically' a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy. 
   */
  @SerialName("BANKRUPTCY")
  BANKRUPTCY,
  /** 
   * Results from the fact that the rating of the reference obligation is downgraded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades. 
   */
  @SerialName("DISTRESSED_RATINGS_DOWNGRADE")
  DISTRESSED_RATINGS_DOWNGRADE,
  /** 
   * This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregrate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay. 
   */
  @SerialName("FAILURE_TO_PAY")
  FAILURE_TO_PAY,
  /** 
   * Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest. 
   */
  @SerialName("FAILURE_TO_PAY_INTEREST")
  FAILURE_TO_PAY_INTEREST,
  /** 
   * Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal. 
   */
  @SerialName("FAILURE_TO_PAY_PRINCIPAL")
  FAILURE_TO_PAY_PRINCIPAL,
  /** 
   * A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention. 
   */
  @SerialName("GOVERNMENTAL_INTERVENTION")
  GOVERNMENTAL_INTERVENTION,
  /** 
   * Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation. 
   */
  @SerialName("IMPLIED_WRITEDOWN")
  IMPLIED_WRITEDOWN,
  /** 
   * Results from the fact that the underlier fails to make principal payments as expected. 
   */
  @SerialName("MATURITY_EXTENSION")
  MATURITY_EXTENSION,
  /** 
   * One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration. 
   */
  @SerialName("OBLIGATION_ACCELERATION")
  OBLIGATION_ACCELERATION,
  /** 
   * One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default. 
   */
  @SerialName("OBLIGATION_DEFAULT")
  OBLIGATION_DEFAULT,
  /** 
   * The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium. 
   */
  @SerialName("REPUDIATION_MORATORIUM")
  REPUDIATION_MORATORIUM,
  /** 
   * A restructuring is an event that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring. 
   */
  @SerialName("RESTRUCTURING")
  RESTRUCTURING,
  /** 
   * Results from the fact that the underlier writes down its outstanding principal amount. 
   */
  @SerialName("WRITEDOWN")
  WRITEDOWN
  ;
}

/** 
 * The enumeration values to qualify the type of credit limits. 
 */
@Serializable
enum class CreditLimitTypeEnum {
  /** 
   * The type of credit line expressed in CS01. The sensitivity with respect to changes in the CDS spread. 
   */
  @SerialName("CS01")
  CS01,
  /** 
   * The type of credit line expressed in DV01. The dollar value of a one basis point decrease in interest rates. It shows the change in a bond's price compared to a decrease in the bond's yield. 
   */
  @SerialName("DV01")
  DV01,
  /** 
   * The type of credit line expressed in Initial Margin value. 
   */
  @SerialName("IM")
  IM,
  /** 
   * The type of credit line expressed as a Net Present Value. 
   */
  @SerialName("NPV")
  NPV,
  /** 
   * The type of credit line expressed in Notional amount. 
   */
  @SerialName("NOTIONAL")
  NOTIONAL,
  /** 
   * The type of credit line expressed in PV01. The value of a one dollar or one basis point annuity. 
   */
  @SerialName("PV01")
  PV01
  ;
}

/** 
 * Identifies an agency rating as a simple scale boundary of minimum or maximum. 
 */
@Serializable
enum class CreditNotationBoundaryEnum {
  /** 
   * Denotes a maxiumum boundary 
   */
  @SerialName("MAXIMUM")
  MAXIMUM,
  /** 
   * Denotes a minumum boundary 
   */
  @SerialName("MINIMUM")
  MINIMUM
  ;
}

/** 
 * Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available. 
 */
@Serializable
enum class CreditNotationMismatchResolutionEnum {
  /** 
   * Denotes the average credit notation if several notations are listed. 
   */
  @SerialName("AVERAGE")
  AVERAGE,
  /** 
   * Denotes the highest credit notation if several notations are listed. 
   */
  @SerialName("HIGHEST")
  HIGHEST,
  /** 
   * Denotes the lowest credit notation if several notations are listed. 
   */
  @SerialName("LOWEST")
  LOWEST,
  /** 
   * Utilised where bespoke language represents the label characteristics of the rating. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed. 
   */
  @SerialName("REFERENCE_AGENCY")
  REFERENCE_AGENCY,
  /** 
   * Denotes the second best credit notation if several notations are listed. 
   */
  @SerialName("SECOND_BEST")
  SECOND_BEST
  ;
}

/** 
 * Represents the enumerated values to specify the rating agencies. 
 */
@Serializable
enum class CreditRatingAgencyEnum {
  /** 
   * A. M. Best 
   */
  @SerialName("AM_BEST")
  AM_BEST,
  /** 
   * Canadian Bond Rating Service 
   */
  @SerialName("CBRS")
  CBRS,
  /** 
   * Dominion Bond Rating Service 
   */
  @SerialName("DBRS")
  DBRS,
  /** 
   * Fitch 
   */
  @SerialName("FITCH")
  FITCH,
  /** 
   * Japan Credit Rating Agency, Ltd. 
   */
  @SerialName("JAPANAGENCY")
  JAPANAGENCY,
  /** 
   * Moody's 
   */
  @SerialName("MOODYS")
  MOODYS,
  /** 
   * Rating And Investment Information, Inc. 
   */
  @SerialName("RATING_AND_INVESTMENT_INFORMATION")
  RATING_AND_INVESTMENT_INFORMATION,
  /** 
   * Standard And Poor's 
   */
  @SerialName("STANDARD_AND_POORS")
  STANDARD_AND_POORS
  ;
}

/** 
 * Represents the enumerated values to specify the credit watch rating. 
 */
@Serializable
enum class CreditRatingCreditWatchEnum {
  /** 
   * Denotes a rating may be raised, lowered, or affirmed. 
   */
  @SerialName("DEVELOPING")
  DEVELOPING,
  /** 
   * Denotes a rating may be lowered. 
   */
  @SerialName("NEGATIVE")
  NEGATIVE,
  /** 
   * Denotes a rating may be raised. 
   */
  @SerialName("POSITIVE")
  POSITIVE
  ;
}

/** 
 * Represents the enumerated values to specify the credit rating outlook. 
 */
@Serializable
enum class CreditRatingOutlookEnum {
  /** 
   * Denotes a rating may be raised, lowered, or affirmed. 
   */
  @SerialName("DEVELOPING")
  DEVELOPING,
  /** 
   * Denotes a rating may be lowered. 
   */
  @SerialName("NEGATIVE")
  NEGATIVE,
  /** 
   * Denotes a rating may be raised. 
   */
  @SerialName("POSITIVE")
  POSITIVE,
  /** 
   * Denotes a rating is not likely to change. 
   */
  @SerialName("STABLE")
  STABLE
  ;
}

/** 
 * Represents an enumeration list to identify tranched or untranched credit risk. 
 */
@Serializable
enum class CreditRiskEnum {
  /** 
   * Indicates tranched credit risk, including securitizations. 
   */
  @SerialName("TRANCHED_CREDIT_RISK")
  TRANCHED_CREDIT_RISK,
  /** 
   * Indicates tranched credit risk, including repackagings. 
   */
  @SerialName("UNTRANCHED_CREDIT_RISK")
  UNTRANCHED_CREDIT_RISK
  ;
}

/** 
 * Seniority of debt instruments comprising the index. 
 */
@Serializable
enum class CreditSeniorityEnum {
  /** 
   * Other as defined under EMIR. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC). 
   */
  @SerialName("SENIOR_LOSS_ABSORBING_CAPACITY")
  SENIOR_LOSS_ABSORBING_CAPACITY,
  /** 
   * Senior domestic (RED Tier Code: SECDOM). 
   */
  @SerialName("SENIOR_SEC")
  SENIOR_SEC,
  /** 
   * Senior foreign (RED Tier Code: SNRFOR). 
   */
  @SerialName("SENIOR_UN_SEC")
  SENIOR_UN_SEC,
  /** 
   * Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2). 
   */
  @SerialName("SUB_LOWER_TIER_2")
  SUB_LOWER_TIER_2,
  /** 
   * Subordinate Tier 1 (RED Tier Code: PREFT1). 
   */
  @SerialName("SUB_TIER_1")
  SUB_TIER_1,
  /** 
   * Subordinate, Tier 3. 
   */
  @SerialName("SUB_TIER_3")
  SUB_TIER_3,
  /** 
   * Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2). 
   */
  @SerialName("SUB_UPPER_TIER_2")
  SUB_UPPER_TIER_2
  ;
}

/** 
 * The enumerated values to specify the type of Credit Support Agreement governing the transaction. 
 */
@Serializable
enum class CreditSupportAgreementTypeEnum {
  /** 
   * A Collateral Transfer Agreement 
   */
  @SerialName("COLLATERAL_TRANSFER_AGREEMENT")
  COLLATERAL_TRANSFER_AGREEMENT,
  /** 
   * A Credit Support Annex legal agreement. 
   */
  @SerialName("CREDIT_SUPPORT_ANNEX")
  CREDIT_SUPPORT_ANNEX,
  /** 
   * A Credit Support Deed legal agreement. 
   */
  @SerialName("CREDIT_SUPPORT_DEED")
  CREDIT_SUPPORT_DEED
  ;
}

/** 
 * The enumerated values to specify the Credit Support Document Terms 
 */
@Serializable
enum class CreditSupportDocumentTermsEnum {
  /** 
   * Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement. 
   */
  @SerialName("ANY")
  ANY,
  /** 
   * No Credit Support Document is specified. 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * A specified Credit Support Document is provided 
   */
  @SerialName("SPECIFIED")
  SPECIFIED
  ;
}

/** 
 * The enumerated values to specify the Credit Support Provider Terms 
 */
@Serializable
enum class CreditSupportProviderTermsEnum {
  /** 
   * Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support. 
   */
  @SerialName("ANY")
  ANY,
  /** 
   * No Credit Support Provider is specified. 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * A specified Credit Support Provider is provided 
   */
  @SerialName("SPECIFIED")
  SPECIFIED
  ;
}

/** 
 * How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1  
 */
@Serializable
enum class CsaTypeEnum {
  /** 
   * Thre is an existing Credit Support Annex 
   */
  @SerialName("ExistingCSA")
  EXISTING_CSA,
  /** 
   * There is no CSA applicable 
   */
  @SerialName("NoCSA")
  NO_CSA,
  /** 
   * There is a bilateral Credit Support Annex specific to the transaction 
   */
  @SerialName("ReferenceVMCSA")
  REFERENCE_VMCSA
  ;
}

/** 
 * Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016. 
 */
@Serializable
enum class CurrencyCodeEnum {
  /** 
   * UAE Dirham 
   */
  @SerialName("AED")
  AED,
  /** 
   * Afghani 
   */
  @SerialName("AFN")
  AFN,
  /** 
   * Lek 
   */
  @SerialName("ALL")
  ALL,
  /** 
   * Armenian Dram 
   */
  @SerialName("AMD")
  AMD,
  /** 
   * Netherlands Antillean Guilder 
   */
  @SerialName("ANG")
  ANG,
  /** 
   * Kwanza 
   */
  @SerialName("AOA")
  AOA,
  /** 
   * Argentine Peso 
   */
  @SerialName("ARS")
  ARS,
  /** 
   * Australian Dollar 
   */
  @SerialName("AUD")
  AUD,
  /** 
   * Aruban Florin 
   */
  @SerialName("AWG")
  AWG,
  /** 
   * Azerbaijan Manat 
   */
  @SerialName("AZN")
  AZN,
  /** 
   * Convertible Mark 
   */
  @SerialName("BAM")
  BAM,
  /** 
   * Barbados Dollar 
   */
  @SerialName("BBD")
  BBD,
  /** 
   * Taka 
   */
  @SerialName("BDT")
  BDT,
  /** 
   * Bulgarian Lev 
   */
  @SerialName("BGN")
  BGN,
  /** 
   * Bahraini Dinar 
   */
  @SerialName("BHD")
  BHD,
  /** 
   * Burundi Franc 
   */
  @SerialName("BIF")
  BIF,
  /** 
   * Bermudian Dollar 
   */
  @SerialName("BMD")
  BMD,
  /** 
   * Brunei Dollar 
   */
  @SerialName("BND")
  BND,
  /** 
   * Boliviano 
   */
  @SerialName("BOB")
  BOB,
  /** 
   * Mvdol 
   */
  @SerialName("BOV")
  BOV,
  /** 
   * Brazilian Real 
   */
  @SerialName("BRL")
  BRL,
  /** 
   * Bahamian Dollar 
   */
  @SerialName("BSD")
  BSD,
  /** 
   * Ngultrum 
   */
  @SerialName("BTN")
  BTN,
  /** 
   * Pula 
   */
  @SerialName("BWP")
  BWP,
  /** 
   * Belarusian Ruble 
   */
  @SerialName("BYN")
  BYN,
  /** 
   * Belize Dollar 
   */
  @SerialName("BZD")
  BZD,
  /** 
   * Canadian Dollar 
   */
  @SerialName("CAD")
  CAD,
  /** 
   * Congolese Franc 
   */
  @SerialName("CDF")
  CDF,
  /** 
   * WIR Euro 
   */
  @SerialName("CHE")
  CHE,
  /** 
   * Swiss Franc 
   */
  @SerialName("CHF")
  CHF,
  /** 
   * WIR Franc 
   */
  @SerialName("CHW")
  CHW,
  /** 
   * Unidad de Fomento 
   */
  @SerialName("CLF")
  CLF,
  /** 
   * Chilean Peso 
   */
  @SerialName("CLP")
  CLP,
  /** 
   * Offshore Chinese Yuan traded in Hong Kong. 
   */
  @SerialName("CNH")
  CNH,
  /** 
   * Offshore Chinese Yuan traded in Taiwan. 
   */
  @SerialName("CNT")
  CNT,
  /** 
   * Yuan Renminbi 
   */
  @SerialName("CNY")
  CNY,
  /** 
   * Colombian Peso 
   */
  @SerialName("COP")
  COP,
  /** 
   * Unidad de Valor Real 
   */
  @SerialName("COU")
  COU,
  /** 
   * Costa Rican Colon 
   */
  @SerialName("CRC")
  CRC,
  /** 
   * Peso Convertible 
   */
  @SerialName("CUC")
  CUC,
  /** 
   * Cuban Peso 
   */
  @SerialName("CUP")
  CUP,
  /** 
   * Cabo Verde Escudo 
   */
  @SerialName("CVE")
  CVE,
  /** 
   * Czech Koruna 
   */
  @SerialName("CZK")
  CZK,
  /** 
   * Djibouti Franc 
   */
  @SerialName("DJF")
  DJF,
  /** 
   * Danish Krone 
   */
  @SerialName("DKK")
  DKK,
  /** 
   * Dominican Peso 
   */
  @SerialName("DOP")
  DOP,
  /** 
   * Algerian Dinar 
   */
  @SerialName("DZD")
  DZD,
  /** 
   * Egyptian Pound 
   */
  @SerialName("EGP")
  EGP,
  /** 
   * Nakfa 
   */
  @SerialName("ERN")
  ERN,
  /** 
   * Ethiopian Birr 
   */
  @SerialName("ETB")
  ETB,
  /** 
   * Euro 
   */
  @SerialName("EUR")
  EUR,
  /** 
   * Fiji Dollar 
   */
  @SerialName("FJD")
  FJD,
  /** 
   * Falkland Islands Pound 
   */
  @SerialName("FKP")
  FKP,
  /** 
   * Pound Sterling 
   */
  @SerialName("GBP")
  GBP,
  /** 
   * Lari 
   */
  @SerialName("GEL")
  GEL,
  /** 
   * Guernsey Pound. 
   */
  @SerialName("GGP")
  GGP,
  /** 
   * Ghana Cedi 
   */
  @SerialName("GHS")
  GHS,
  /** 
   * Gibraltar Pound 
   */
  @SerialName("GIP")
  GIP,
  /** 
   * Dalasi 
   */
  @SerialName("GMD")
  GMD,
  /** 
   * Guinean Franc 
   */
  @SerialName("GNF")
  GNF,
  /** 
   * Quetzal 
   */
  @SerialName("GTQ")
  GTQ,
  /** 
   * Guyana Dollar 
   */
  @SerialName("GYD")
  GYD,
  /** 
   * Hong Kong Dollar 
   */
  @SerialName("HKD")
  HKD,
  /** 
   * Lempira 
   */
  @SerialName("HNL")
  HNL,
  /** 
   * Gourde 
   */
  @SerialName("HTG")
  HTG,
  /** 
   * Forint 
   */
  @SerialName("HUF")
  HUF,
  /** 
   * Rupiah 
   */
  @SerialName("IDR")
  IDR,
  /** 
   * New Israeli Sheqel 
   */
  @SerialName("ILS")
  ILS,
  /** 
   * Isle of Man Pound. 
   */
  @SerialName("IMP")
  IMP,
  /** 
   * Indian Rupee 
   */
  @SerialName("INR")
  INR,
  /** 
   * Iraqi Dinar 
   */
  @SerialName("IQD")
  IQD,
  /** 
   * Iranian Rial 
   */
  @SerialName("IRR")
  IRR,
  /** 
   * Iceland Krona 
   */
  @SerialName("ISK")
  ISK,
  /** 
   * Jersey Pound. 
   */
  @SerialName("JEP")
  JEP,
  /** 
   * Jamaican Dollar 
   */
  @SerialName("JMD")
  JMD,
  /** 
   * Jordanian Dinar 
   */
  @SerialName("JOD")
  JOD,
  /** 
   * Yen 
   */
  @SerialName("JPY")
  JPY,
  /** 
   * Kenyan Shilling 
   */
  @SerialName("KES")
  KES,
  /** 
   * Som 
   */
  @SerialName("KGS")
  KGS,
  /** 
   * Riel 
   */
  @SerialName("KHR")
  KHR,
  /** 
   * Tuvaluan Dollar. 
   */
  @SerialName("KID")
  KID,
  /** 
   * Comorian Franc  
   */
  @SerialName("KMF")
  KMF,
  /** 
   * North Korean Won 
   */
  @SerialName("KPW")
  KPW,
  /** 
   * Won 
   */
  @SerialName("KRW")
  KRW,
  /** 
   * Kuwaiti Dinar 
   */
  @SerialName("KWD")
  KWD,
  /** 
   * Cayman Islands Dollar 
   */
  @SerialName("KYD")
  KYD,
  /** 
   * Tenge 
   */
  @SerialName("KZT")
  KZT,
  /** 
   * Lao Kip 
   */
  @SerialName("LAK")
  LAK,
  /** 
   * Lebanese Pound 
   */
  @SerialName("LBP")
  LBP,
  /** 
   * Sri Lanka Rupee 
   */
  @SerialName("LKR")
  LKR,
  /** 
   * Liberian Dollar 
   */
  @SerialName("LRD")
  LRD,
  /** 
   * Loti 
   */
  @SerialName("LSL")
  LSL,
  /** 
   * Libyan Dinar 
   */
  @SerialName("LYD")
  LYD,
  /** 
   * Moroccan Dirham 
   */
  @SerialName("MAD")
  MAD,
  /** 
   * Monegasque Franc. 
   */
  @SerialName("MCF")
  MCF,
  /** 
   * Moldovan Leu 
   */
  @SerialName("MDL")
  MDL,
  /** 
   * Malagasy Ariary 
   */
  @SerialName("MGA")
  MGA,
  /** 
   * Denar 
   */
  @SerialName("MKD")
  MKD,
  /** 
   * Kyat 
   */
  @SerialName("MMK")
  MMK,
  /** 
   * Tugrik 
   */
  @SerialName("MNT")
  MNT,
  /** 
   * Pataca 
   */
  @SerialName("MOP")
  MOP,
  /** 
   * Ouguiya 
   */
  @SerialName("MRU")
  MRU,
  /** 
   * Mauritius Rupee 
   */
  @SerialName("MUR")
  MUR,
  /** 
   * Rufiyaa 
   */
  @SerialName("MVR")
  MVR,
  /** 
   * Malawi Kwacha 
   */
  @SerialName("MWK")
  MWK,
  /** 
   * Mexican Peso 
   */
  @SerialName("MXN")
  MXN,
  /** 
   * Mexican Unidad de Inversion (UDI) 
   */
  @SerialName("MXV")
  MXV,
  /** 
   * Malaysian Ringgit 
   */
  @SerialName("MYR")
  MYR,
  /** 
   * Mozambique Metical 
   */
  @SerialName("MZN")
  MZN,
  /** 
   * Namibia Dollar 
   */
  @SerialName("NAD")
  NAD,
  /** 
   * Naira 
   */
  @SerialName("NGN")
  NGN,
  /** 
   * Cordoba Oro 
   */
  @SerialName("NIO")
  NIO,
  /** 
   * Norwegian Krone 
   */
  @SerialName("NOK")
  NOK,
  /** 
   * Nepalese Rupee 
   */
  @SerialName("NPR")
  NPR,
  /** 
   * New Zealand Dollar 
   */
  @SerialName("NZD")
  NZD,
  /** 
   * Rial Omani 
   */
  @SerialName("OMR")
  OMR,
  /** 
   * Balboa 
   */
  @SerialName("PAB")
  PAB,
  /** 
   * Sol 
   */
  @SerialName("PEN")
  PEN,
  /** 
   * Kina 
   */
  @SerialName("PGK")
  PGK,
  /** 
   * Philippine Peso 
   */
  @SerialName("PHP")
  PHP,
  /** 
   * Pakistan Rupee 
   */
  @SerialName("PKR")
  PKR,
  /** 
   * Zloty 
   */
  @SerialName("PLN")
  PLN,
  /** 
   * Guarani 
   */
  @SerialName("PYG")
  PYG,
  /** 
   * Qatari Rial 
   */
  @SerialName("QAR")
  QAR,
  /** 
   * Romanian Leu 
   */
  @SerialName("RON")
  RON,
  /** 
   * Serbian Dinar 
   */
  @SerialName("RSD")
  RSD,
  /** 
   * Russian Ruble 
   */
  @SerialName("RUB")
  RUB,
  /** 
   * Rwanda Franc 
   */
  @SerialName("RWF")
  RWF,
  /** 
   * Saudi Riyal 
   */
  @SerialName("SAR")
  SAR,
  /** 
   * Solomon Islands Dollar 
   */
  @SerialName("SBD")
  SBD,
  /** 
   * Seychelles Rupee 
   */
  @SerialName("SCR")
  SCR,
  /** 
   * Sudanese Pound 
   */
  @SerialName("SDG")
  SDG,
  /** 
   * Swedish Krona 
   */
  @SerialName("SEK")
  SEK,
  /** 
   * Singapore Dollar 
   */
  @SerialName("SGD")
  SGD,
  /** 
   * Saint Helena Pound 
   */
  @SerialName("SHP")
  SHP,
  /** 
   * Leone 
   */
  @SerialName("SLE")
  SLE,
  /** 
   * Sammarinese Lira. 
   */
  @SerialName("SML")
  SML,
  /** 
   * Somali Shilling 
   */
  @SerialName("SOS")
  SOS,
  /** 
   * Surinam Dollar 
   */
  @SerialName("SRD")
  SRD,
  /** 
   * South Sudanese Pound 
   */
  @SerialName("SSP")
  SSP,
  /** 
   * Dobra 
   */
  @SerialName("STN")
  STN,
  /** 
   * El Salvador Colon 
   */
  @SerialName("SVC")
  SVC,
  /** 
   * Syrian Pound 
   */
  @SerialName("SYP")
  SYP,
  /** 
   * Lilangeni 
   */
  @SerialName("SZL")
  SZL,
  /** 
   * Baht 
   */
  @SerialName("THB")
  THB,
  /** 
   * Somoni 
   */
  @SerialName("TJS")
  TJS,
  /** 
   * Turkmenistan New Manat 
   */
  @SerialName("TMT")
  TMT,
  /** 
   * Tunisian Dinar 
   */
  @SerialName("TND")
  TND,
  /** 
   * Pa’anga 
   */
  @SerialName("TOP")
  TOP,
  /** 
   * Turkish Lira 
   */
  @SerialName("TRY")
  TRY,
  /** 
   * Trinidad and Tobago Dollar 
   */
  @SerialName("TTD")
  TTD,
  /** 
   * New Taiwan Dollar 
   */
  @SerialName("TWD")
  TWD,
  /** 
   * Tanzanian Shilling 
   */
  @SerialName("TZS")
  TZS,
  /** 
   * Hryvnia 
   */
  @SerialName("UAH")
  UAH,
  /** 
   * Uganda Shilling 
   */
  @SerialName("UGX")
  UGX,
  /** 
   * US Dollar 
   */
  @SerialName("USD")
  USD,
  /** 
   * US Dollar (Next day) 
   */
  @SerialName("USN")
  USN,
  /** 
   * Uruguay Peso en Unidades Indexadas (UI) 
   */
  @SerialName("UYI")
  UYI,
  /** 
   * Peso Uruguayo 
   */
  @SerialName("UYU")
  UYU,
  /** 
   * Unidad Previsional 
   */
  @SerialName("UYW")
  UYW,
  /** 
   * Uzbekistan Sum 
   */
  @SerialName("UZS")
  UZS,
  /** 
   * Vatican Lira. 
   */
  @SerialName("VAL")
  VAL,
  /** 
   * Bolívar Soberano 
   */
  @SerialName("VED")
  VED,
  /** 
   * Bolívar Soberano 
   */
  @SerialName("VES")
  VES,
  /** 
   * Dong 
   */
  @SerialName("VND")
  VND,
  /** 
   * Vatu 
   */
  @SerialName("VUV")
  VUV,
  /** 
   * Tala 
   */
  @SerialName("WST")
  WST,
  /** 
   * CFA Franc BEAC 
   */
  @SerialName("XAF")
  XAF,
  /** 
   * Silver 
   */
  @SerialName("XAG")
  XAG,
  /** 
   * Gold 
   */
  @SerialName("XAU")
  XAU,
  /** 
   * Bond Markets Unit European Composite Unit (EURCO) 
   */
  @SerialName("XBA")
  XBA,
  /** 
   * Bond Markets Unit European Monetary Unit (E.M.U.-6) 
   */
  @SerialName("XBB")
  XBB,
  /** 
   * Bond Markets Unit European Unit of Account 9 (E.U.A.-9) 
   */
  @SerialName("XBC")
  XBC,
  /** 
   * Bond Markets Unit European Unit of Account 17 (E.U.A.-17) 
   */
  @SerialName("XBD")
  XBD,
  /** 
   * East Caribbean Dollar 
   */
  @SerialName("XCD")
  XCD,
  /** 
   * SDR (Special Drawing Right) 
   */
  @SerialName("XDR")
  XDR,
  /** 
   * CFA Franc BCEAO 
   */
  @SerialName("XOF")
  XOF,
  /** 
   * Palladium 
   */
  @SerialName("XPD")
  XPD,
  /** 
   * CFP Franc 
   */
  @SerialName("XPF")
  XPF,
  /** 
   * Platinum 
   */
  @SerialName("XPT")
  XPT,
  /** 
   * Sucre 
   */
  @SerialName("XSU")
  XSU,
  /** 
   * Codes specifically reserved for testing purposes 
   */
  @SerialName("XTS")
  XTS,
  /** 
   * ADB Unit of Account 
   */
  @SerialName("XUA")
  XUA,
  /** 
   * The codes assigned for transactions where no currency is involved 
   */
  @SerialName("XXX")
  XXX,
  /** 
   * Yemeni Rial 
   */
  @SerialName("YER")
  YER,
  /** 
   * Rand 
   */
  @SerialName("ZAR")
  ZAR,
  /** 
   * Zambian Kwacha 
   */
  @SerialName("ZMW")
  ZMW,
  /** 
   * Zimbabwe Gold 
   */
  @SerialName("ZWG")
  ZWG
  ;
}

/** 
 * The enumerated values to specify the day count fraction. 
 */
@Serializable
enum class DayCountFractionEnum {
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (v), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (e) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (d). 
   */
  @SerialName("ACT/360")
  ACT_360,
  /** 
   * Per CFTC definitions. 
   */
  @SerialName("ACT/364")
  ACT_364,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ix), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (i). 
   */
  @SerialName("ACT/365L")
  ACT_365L,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iv), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (d) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (c). 
   */
  @SerialName("ACT/365.FIXED")
  ACT_365_FIXED,
  /** 
   * The Fixed/Floating Amount will be calculated in accordance with the 'BASE EXACT/EXACT' day count fraction, as defined in the 'Definitions Communes plusieurs Additifs Techniques' published by the Association Francaise des Banques in September 1994. 
   */
  @SerialName("ACT/ACT.AFB")
  ACT_ACT_AFB,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (c). This day count fraction code is applicable for transactions booked under the 2021 ISDA Definitions and the 2006 ISDA Definitions. Transactions under the 2000 ISDA Definitions should use the ACT/ACT.ISMA code instead. 
   */
  @SerialName("ACT/ACT.ICMA")
  ACT_ACT_ICMA,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (b) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (b). Note that going from FpML 2.0 Recommendation to the FpML 3.0 Trial Recommendation the code in FpML 2.0 'ACT/365.ISDA' became 'ACT/ACT.ISDA'. 
   */
  @SerialName("ACT/ACT.ISDA")
  ACT_ACT_ISDA,
  /** 
   * The Fixed/Floating Amount will be calculated in accordance with Rule 251 of the statutes, by-laws, rules and recommendations of the International Securities Market Association, as published in April 1999, as applied to straight and convertible bonds issued after December 31, 1998, as though the Fixed/Floating Amount were the interest coupon on such a bond. This day count fraction code is applicable for transactions booked under the 2000 ISDA Definitions. Transactions under the 2021 ISDA Definitions and the 2006 ISDA Definitions should use the ACT/ACT.ICMA code instead. 
   */
  @SerialName("ACT/ACT.ISMA")
  ACT_ACT_ISMA,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (x). Supercedes BUS/252, the number of Business Days in the Calculation Period or Compounding Period in respect of which payment is being made divided by 252. 
   */
  @SerialName("CAL/252")
  CAL_252,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (xi), the calculation mechanics are driven deterministically by the Calculation Period Frequency (i.e. 0.25 if it is three months, 0.5 if it is 6 months, 1 if it is a year), except that if the first Calculation Period or the final Calculation Period is less than the Calculation Period Frequency, Actual/Actual (ISDA) shall apply to that Calculation Period 
   */
  @SerialName("RBA Bond Basis")
  RBA_BOND_BASIS,
  /** 
   * Per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (a) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (a). 
   */
  @SerialName("1/1")
  _1_1,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (g) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (f). Note that the algorithm defined for this day count fraction has changed between the 2000 ISDA Definitions and 2006 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change. 
   */
  @SerialName("30E/360")
  _30E_360,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (viii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (h). Note the algorithm for this day count fraction under the 2006 ISDA Definitions is designed to yield the same results in practice as the version of the 30E/360 day count fraction defined in the 2000 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change. 
   */
  @SerialName("30E/360.ISDA")
  _30E_360_ISDA,
  /** 
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vi), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (f) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (e). 
   */
  @SerialName("30/360")
  _30_360
  ;
}

/** 
 * Denotes the method by which the pricing days are distributed across the pricing period. 
 */
@Serializable
enum class DayDistributionEnum {
  @SerialName("ALL")
  ALL,
  @SerialName("FIRST")
  FIRST,
  @SerialName("LAST")
  LAST,
  @SerialName("PENULTIMATE")
  PENULTIMATE
  ;
}

/** 
 * The enumerated values to specify a day of the seven-day week. 
 */
@Serializable
enum class DayOfWeekEnum {
  /** 
   * Friday 
   */
  @SerialName("FRI")
  FRI,
  /** 
   * Monday 
   */
  @SerialName("MON")
  MON,
  /** 
   * Saturday 
   */
  @SerialName("SAT")
  SAT,
  /** 
   * Sunday 
   */
  @SerialName("SUN")
  SUN,
  /** 
   * Thursday 
   */
  @SerialName("THU")
  THU,
  /** 
   * Tuesday 
   */
  @SerialName("TUE")
  TUE,
  /** 
   * Wednesday 
   */
  @SerialName("WED")
  WED
  ;
}

/** 
 * Lists the enumerated values to specify the day type classification used in counting the number of days between two dates. 
 */
@Serializable
enum class DayTypeEnum {
  /** 
   * Applies when calculating the number of days between two dates the count includes only business days. 
   */
  @SerialName("BUSINESS")
  BUSINESS,
  /** 
   * Applies when calculating the number of days between two dates the count includes all calendar days. 
   */
  @SerialName("CALENDAR")
  CALENDAR,
  /** 
   * Applies when calculating the number of days between two dates the count includes only currency business days. 
   */
  @SerialName("CURRENCY_BUSINESS")
  CURRENCY_BUSINESS,
  /** 
   * Applies when calculating the number of days between two dates the count includes only stock exchange business days. 
   */
  @SerialName("EXCHANGE_BUSINESS")
  EXCHANGE_BUSINESS,
  /** 
   * Applies when calculating the number of days between two dates the count includes only scheduled trading days. 
   */
  @SerialName("SCHEDULED_TRADING_DAY")
  SCHEDULED_TRADING_DAY
  ;
}

/** 
 * Represents an enumeration list that identifies the type of debt. 
 */
@Serializable
enum class DebtClassEnum {
  /** 
   * Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations. 
   */
  @SerialName("ASSET_BACKED")
  ASSET_BACKED,
  /** 
   * Identifies a debt instrument that can be converted into common shares. 
   */
  @SerialName("CONVERTIBLE")
  CONVERTIBLE,
  /** 
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer. 
   */
  @SerialName("HOLDER_CONVERTIBLE")
  HOLDER_CONVERTIBLE,
  /** 
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer. 
   */
  @SerialName("HOLDER_EXCHANGEABLE")
  HOLDER_EXCHANGEABLE,
  /** 
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible. 
   */
  @SerialName("ISSUER_CONVERTIBLE")
  ISSUER_CONVERTIBLE,
  /** 
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable. 
   */
  @SerialName("ISSUER_EXCHANGEABLE")
  ISSUER_EXCHANGEABLE,
  /** 
   * Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital. 
   */
  @SerialName("REG_CAP")
  REG_CAP,
  /** 
   * Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer. 
   */
  @SerialName("STRUCTURED")
  STRUCTURED,
  /** 
   * Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics. 
   */
  @SerialName("VANILLA")
  VANILLA
  ;
}

/** 
 * Represents an enumeration list that specifies the general rule for periodic interest rate payment. 
 */
@Serializable
enum class DebtInterestEnum {
  /** 
   * Denotes payment calculated with reference to a fixed interest rate. 
   */
  @SerialName("FIXED")
  FIXED,
  /** 
   * Denotes payment calculated with reference to a floating interest rate. 
   */
  @SerialName("FLOATING")
  FLOATING,
  /** 
   * Denotes payment calculated with reference to one or more price or other indices (other than inflation rates). 
   */
  @SerialName("INDEX_LINKED")
  INDEX_LINKED,
  /** 
   * Denotes payment calculated with reference to one or more specified inflation rates. 
   */
  @SerialName("INFLATION_LINKED")
  INFLATION_LINKED,
  /** 
   * Denotes a stripped bond representing only the interest component. 
   */
  @SerialName("INTEREST_ONLY")
  INTEREST_ONLY,
  /** 
   * Denotes payment calculated with reference to the inverse of a floating interest rate. 
   */
  @SerialName("INVERSE_FLOATING")
  INVERSE_FLOATING,
  /** 
   * Denotes payment calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices. 
   */
  @SerialName("OTHER_STRUCTURED")
  OTHER_STRUCTURED,
  /** 
   * Denotes a zero coupon bond that does not pay intetrest. 
   */
  @SerialName("ZERO_COUPON")
  ZERO_COUPON
  ;
}

/** 
 * Represents an enumeration list that specifies the general rule for repayment of principal. 
 */
@Serializable
enum class DebtPrincipalEnum {
  /** 
   * Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity. 
   */
  @SerialName("AMORTISING")
  AMORTISING,
  /** 
   * Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable. 
   */
  @SerialName("BULLET")
  BULLET,
  /** 
   * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer. 
   */
  @SerialName("CALLABLE")
  CALLABLE,
  /** 
   * Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates). 
   */
  @SerialName("INDEX_LINKED")
  INDEX_LINKED,
  /** 
   * Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates. 
   */
  @SerialName("INFLATION_LINKED")
  INFLATION_LINKED,
  /** 
   * Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices. 
   */
  @SerialName("OTHER_STRUCTURED")
  OTHER_STRUCTURED,
  /** 
   * Denotes a stripped bond representing only the principal component. 
   */
  @SerialName("PRINCIPAL_ONLY")
  PRINCIPAL_ONLY,
  /** 
   * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder. 
   */
  @SerialName("PUTTABLE")
  PUTTABLE
  ;
}

/** 
 * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor). 
 */
@Serializable
enum class DebtSeniorityEnum {
  /** 
   * Denotes debt which is secured over assets of the issuer or a related party (eg guarantor). 
   */
  @SerialName("SECURED")
  SECURED,
  /** 
   * Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer. 
   */
  @SerialName("SENIOR")
  SENIOR,
  /** 
   * Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met. 
   */
  @SerialName("SUBORDINATED")
  SUBORDINATED
  ;
}

/** 
 * The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language. 
 */
@Serializable
enum class DeliveryAmountElectionEnum {
  /** 
   * The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.` 
   */
  @SerialName("LAST_AND_ANY_LOCAL_BUSINESS_DAY")
  LAST_AND_ANY_LOCAL_BUSINESS_DAY,
  /** 
   * The delivery only includes `Transfer on last Local Business Day. 
   */
  @SerialName("LAST_LOCAL_BUSINESS_DAY")
  LAST_LOCAL_BUSINESS_DAY
  ;
}

/** 
 * Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities. 
 */
@Serializable
enum class DeliveryMethodEnum {
  /** 
   * Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other. 
   */
  @SerialName("DELIVERY_VERSUS_PAYMENT")
  DELIVERY_VERSUS_PAYMENT,
  /** 
   * Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa. 
   */
  @SerialName("FREE_OF_PAYMENT")
  FREE_OF_PAYMENT,
  /** 
   * Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment. 
   */
  @SerialName("PRE_DELIVERY")
  PRE_DELIVERY,
  /** 
   * Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment. 
   */
  @SerialName("PRE_PAYMENT")
  PRE_PAYMENT
  ;
}

@Serializable
enum class DeliveryNearbyTypeEnum {
  /** 
   * Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0. 
   */
  @SerialName("CALCULATION_PERIOD")
  CALCULATION_PERIOD,
  /** 
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month. 
   */
  @SerialName("NEARBY_MONTH")
  NEARBY_MONTH,
  /** 
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week. 
   */
  @SerialName("NEARBY_WEEK")
  NEARBY_WEEK
  ;
}

/** 
 * The enumerated values to specify the method according to which an amount or a date is determined. 
 */
@Serializable
enum class DeterminationMethodEnum {
  /** 
   * Agreed separately between the parties. 
   */
  @SerialName("AGREED_INITIAL_PRICE")
  AGREED_INITIAL_PRICE,
  /** 
   * As specified in Master Confirmation. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_CONFIRMATION")
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,
  /** 
   * Determined by the Calculation Agent. 
   */
  @SerialName("CALCULATION_AGENT")
  CALCULATION_AGENT,
  /** 
   * Official Closing Price. 
   */
  @SerialName("CLOSING_PRICE")
  CLOSING_PRICE,
  /** 
   * Determined by the Currency of Equity Dividends. 
   */
  @SerialName("DIVIDEND_CURRENCY")
  DIVIDEND_CURRENCY,
  /** 
   * The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation. 
   */
  @SerialName("EXPIRING_CONTRACT_LEVEL")
  EXPIRING_CONTRACT_LEVEL,
  /** 
   * Determined by the Hedging Party. 
   */
  @SerialName("HEDGE_EXECUTION")
  HEDGE_EXECUTION,
  /** 
   * Issuer Payment Currency. 
   */
  @SerialName("ISSUER_PAYMENT_CURRENCY")
  ISSUER_PAYMENT_CURRENCY,
  /** 
   * Net Asset Value. 
   */
  @SerialName("NAV")
  NAV,
  /** 
   * OSP Price. 
   */
  @SerialName("OSP_PRICE")
  OSP_PRICE,
  /** 
   * Opening Price of the Market. 
   */
  @SerialName("OPEN_PRICE")
  OPEN_PRICE,
  /** 
   * Settlement Currency. 
   */
  @SerialName("SETTLEMENT_CURRENCY")
  SETTLEMENT_CURRENCY,
  /** 
   * Date on which the strike is determined in respect of a forward starting swap. 
   */
  @SerialName("STRIKE_DATE_DETERMINATION")
  STRIKE_DATE_DETERMINATION,
  /** 
   * Official TWAP Price. 
   */
  @SerialName("TWAP_PRICE")
  TWAP_PRICE,
  /** 
   * Official VWAP Price. 
   */
  @SerialName("VWAP_PRICE")
  VWAP_PRICE,
  /** 
   * Price determined at valuation time. 
   */
  @SerialName("VALUATION_TIME")
  VALUATION_TIME
  ;
}

/** 
 * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations. 
 */
@Serializable
enum class DiscountingTypeEnum {
  /** 
   * As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated. 
   */
  @SerialName("AFMA")
  AFMA,
  /** 
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b). 
   */
  @SerialName("FRA")
  FRA,
  /** 
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e). 
   */
  @SerialName("FRA_YIELD")
  FRA_YIELD,
  /** 
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a). 
   */
  @SerialName("STANDARD")
  STANDARD
  ;
}

/** 
 * The enumerated values to specify whether the dividend is paid with respect to the Dividend Period. 
 */
@Serializable
enum class DividendAmountTypeEnum {
  /** 
   * The Amount is determined as provided in the relevant Master Confirmation. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_CONFIRMATION")
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,
  /** 
   * The ex-date for a dividend occurs during a dividend period. 
   */
  @SerialName("EX_AMOUNT")
  EX_AMOUNT,
  /** 
   * The payment date for a dividend occurs during a dividend period. 
   */
  @SerialName("PAID_AMOUNT")
  PAID_AMOUNT,
  /** 
   * The record date for a dividend occurs during a dividend period. 
   */
  @SerialName("RECORD_AMOUNT")
  RECORD_AMOUNT
  ;
}

/** 
 * The enumerated values to specify how the composition of Dividends is to be determined. 
 */
@Serializable
enum class DividendCompositionEnum {
  /** 
   * The Calculation Agent determines the composition of dividends (subject to conditions). 
   */
  @SerialName("CALCULATION_AGENT_ELECTION")
  CALCULATION_AGENT_ELECTION,
  /** 
   * The Equity Amount Receiver determines the composition of dividends (subject to conditions). 
   */
  @SerialName("EQUITY_AMOUNT_RECEIVER_ELECTION")
  EQUITY_AMOUNT_RECEIVER_ELECTION
  ;
}

/** 
 * The enumerated values to specify the date by reference to which the dividend will be paid. 
 */
@Serializable
enum class DividendDateReferenceEnum {
  /** 
   * The dividend date will be specified ad-hoc by the parties, typically on the dividend ex-date. 
   */
  @SerialName("AD_HOC_DATE")
  AD_HOC_DATE,
  /** 
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Ex Dividend'', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange. 
   */
  @SerialName("CASH_SETTLE_PAYMENT_DATE_EX_DIV")
  CASH_SETTLE_PAYMENT_DATE_EX_DIV,
  /** 
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Issuer Payment', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the issuer pays the relevant dividend to a holder of record provided that in the case where the Equity Amount Payer is the party specified to be the sole Hedging Party and the Hedging Party has not received the Dividend Amount by such date, then the date falling a number of Currency Business Days as specified in the Cash Settlement Payment Date after actual receipt by the Hedging Party of the Received Ex Amount or Paid Ex Amount (as applicable). 
   */
  @SerialName("CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT")
  CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT,
  /** 
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange. 
   */
  @SerialName("CASH_SETTLEMENT_PAYMENT_DATE")
  CASH_SETTLEMENT_PAYMENT_DATE,
  /** 
   * Total of dividends which go ex, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange. 
   */
  @SerialName("CUMULATIVE_EQUITY_EX_DIV")
  CUMULATIVE_EQUITY_EX_DIV,
  /** 
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Ex Date, unless the Dividend Ex Date is between the Equity Valuation and Payment Date in which case the dividend is deferred to the following Equity Payment Date 
   */
  @SerialName("CUMULATIVE_EQUITY_EX_DIV_BEFORE_RESET")
  CUMULATIVE_EQUITY_EX_DIV_BEFORE_RESET,
  /** 
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share. 
   */
  @SerialName("CUMULATIVE_EQUITY_PAID")
  CUMULATIVE_EQUITY_PAID,
  /** 
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date 
   */
  @SerialName("CUMULATIVE_EQUITY_PAID_BEFORE_RESET")
  CUMULATIVE_EQUITY_PAID_BEFORE_RESET,
  /** 
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date 
   */
  @SerialName("CUMULATIVE_EQUITY_PAID_INCL_RESET")
  CUMULATIVE_EQUITY_PAID_INCL_RESET,
  /** 
   * Total of dividends which go ex, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange, or where the date on which the Shares commence trading ex-dividend is a Payment Date, such Payment Date. 
   */
  @SerialName("CUMULATIVE_INTEREST_EX_DIV")
  CUMULATIVE_INTEREST_EX_DIV,
  /** 
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share. 
   */
  @SerialName("CUMULATIVE_INTEREST_PAID")
  CUMULATIVE_INTEREST_PAID,
  /** 
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date. 
   */
  @SerialName("CUMULATIVE_INTEREST_PAID_BEFORE_RESET")
  CUMULATIVE_INTEREST_PAID_BEFORE_RESET,
  /** 
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date. 
   */
  @SerialName("CUMULATIVE_INTEREST_PAID_INCL_RESET")
  CUMULATIVE_INTEREST_PAID_INCL_RESET,
  /** 
   * Date on which the dividend will be paid by the issuer. 
   */
  @SerialName("DIVIDEND_PAYMENT_DATE")
  DIVIDEND_PAYMENT_DATE,
  /** 
   * In respect of each Dividend Period, the relevant Dividend Valuation Date. 
   */
  @SerialName("DIVIDEND_VALUATION_DATE")
  DIVIDEND_VALUATION_DATE,
  /** 
   * Equity payment date of the swap. 
   */
  @SerialName("EQUITY_PAYMENT_DATE")
  EQUITY_PAYMENT_DATE,
  /** 
   * Date on which a holder of the security is entitled to the dividend. 
   */
  @SerialName("EX_DATE")
  EX_DATE,
  /** 
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Floating Amount Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the first Payment Date falling at least one Settlement Cycle after the date that the Shares have commenced trading 'ex' the relevant dividend on the Exchange. 
   */
  @SerialName("FLOATING_AMOUNT_PAYMENT_DATE")
  FLOATING_AMOUNT_PAYMENT_DATE,
  /** 
   * The next payment date of the swap. 
   */
  @SerialName("FOLLOWING_PAYMENT_DATE")
  FOLLOWING_PAYMENT_DATE,
  /** 
   * Date on which the dividend will be recorded in the books of the paying agent. 
   */
  @SerialName("RECORD_DATE")
  RECORD_DATE,
  /** 
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Share Payment', then the Dividend Payment Date in respect of a Dividend Amount shall fall on a date on or before the date that is two (or any other number that is specified in the Transaction Supplement) Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares. 
   */
  @SerialName("SHARE_PAYMENT")
  SHARE_PAYMENT,
  /** 
   * Termination date of the swap. 
   */
  @SerialName("TERMINATION_DATE")
  TERMINATION_DATE,
  /** 
   * Trade date of the swap 
   */
  @SerialName("TRADE_DATE")
  TRADE_DATE,
  /** 
   * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until trade is fully unwound. 
   */
  @SerialName("UNWIND_EX_DIV")
  UNWIND_EX_DIV,
  /** 
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both. 
   */
  @SerialName("UNWIND_OR_EQUITY_EX_DIV")
  UNWIND_OR_EQUITY_EX_DIV,
  /** 
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both. 
   */
  @SerialName("UNWIND_OR_EQUITY_PAID")
  UNWIND_OR_EQUITY_PAID,
  /** 
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Ex Date. This will be whichever date comes first or a combination of both. 
   */
  @SerialName("UNWIND_OR_INTEREST_EX_DIV")
  UNWIND_OR_INTEREST_EX_DIV,
  /** 
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both. 
   */
  @SerialName("UNWIND_OR_INTEREST_PAID")
  UNWIND_OR_INTEREST_PAID,
  /** 
   * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until trade is fully unwound. 
   */
  @SerialName("UNWIND_PAID")
  UNWIND_PAID
  ;
}

/** 
 * The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend. 
 */
@Serializable
enum class DividendEntitlementEnum {
  /** 
   * Dividend entitlement is on the dividend ex-date. 
   */
  @SerialName("EX_DATE")
  EX_DATE,
  /** 
   * Dividend entitlement is on the dividend record date. 
   */
  @SerialName("RECORD_DATE")
  RECORD_DATE
  ;
}

/** 
 * 2002 ISDA Equity Derivatives Definitions: First Period, Second Period | 
 */
@Serializable
enum class DividendPeriodEnum {
  /** 
   * 2002 ISDA Equity Derivatives Definitions: First Period means each period from, and including, one Cash Settlement Payment Date or Settlement Date, as the case may be, to, but excluding, the next following Cash Settlement Payment Date or Settlement Date, as the case may be, except that (i) the initial Dividend Period will commence on, and include, the Clearance System Business Day that is one Settlement Cycle following the Trade Date and (ii) the final Dividend Period will end on, but exclude, the final Cash Settlement Payment Date or Settlement Date, as the case may be. 
   */
  @SerialName("FIRST_PERIOD")
  FIRST_PERIOD,
  /** 
   * 2002 ISDA Equity Derivatives Definitions: Second Period means each period from, but excluding, one Valuation Date to, and including, the next Valuation Date, except that (i) the initial Dividend Period will commence on, but exclude, the Trade Date and (ii) the final Dividend Period will end on, and include, the final Valuation Date or, in respect of a Physically-settled Forward Transaction to which Variable Obligation is not applicable, the date that is one Settlement Cycle prior to the Settlement Date. 
   */
  @SerialName("SECOND_PERIOD")
  SECOND_PERIOD
  ;
}

/** 
 * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM. 
 */
@Serializable
enum class EU_EMIR_EligibleCollateralEnum {
  /** 
   * Denotes Cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits. 
   */
  @SerialName("EU_EMIR_TYPE_A")
  EU_EMIR_TYPE_A,
  /** 
   *  Denotes gold in the form of allocated pure gold bullion of recognised good delivery. 
   */
  @SerialName("EU_EMIR_TYPE_B")
  EU_EMIR_TYPE_B,
  /** 
   *  Denotes debt securities issued by Member States' central governments or central banks. 
   */
  @SerialName("EU_EMIR_TYPE_C")
  EU_EMIR_TYPE_C,
  /** 
   *  Denotes debt securities issued by Member States' regional governments or local authorities whose exposures are treated as exposures to the central government of that Member State in accordance with Article 115(2) of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_D")
  EU_EMIR_TYPE_D,
  /** 
   *  Denotes debt securities issued by Member States' public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of that Member State in accordance with Article 116(4) of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_E")
  EU_EMIR_TYPE_E,
  /** 
   *  Denotes debt securities issued by Member States' regional governments or local authorities other than those referred to in (TypeD.) 
   */
  @SerialName("EU_EMIR_TYPE_F")
  EU_EMIR_TYPE_F,
  /** 
   *  Denotes debt securities issued by Member States' public sector entities other than those referred to in (TypeE). 
   */
  @SerialName("EU_EMIR_TYPE_G")
  EU_EMIR_TYPE_G,
  /** 
   *  Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_H")
  EU_EMIR_TYPE_H,
  /** 
   *  Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_I")
  EU_EMIR_TYPE_I,
  /** 
   *  Denotes debt securities issued by third countries' governments or central banks. 
   */
  @SerialName("EU_EMIR_TYPE_J")
  EU_EMIR_TYPE_J,
  /** 
   *  Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE). 
   */
  @SerialName("EU_EMIR_TYPE_K")
  EU_EMIR_TYPE_K,
  /** 
   *  Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE). 
   */
  @SerialName("EU_EMIR_TYPE_L")
  EU_EMIR_TYPE_L,
  /** 
   *  Denotes debt securities issued by credit institutions or investment firms including bonds referred to in Article 52(4) of Directive 2009/65/EC of the European Parliament and of the Council. 
   */
  @SerialName("EU_EMIR_TYPE_M")
  EU_EMIR_TYPE_M,
  /** 
   *  Denotes corporate bonds. 
   */
  @SerialName("EU_EMIR_TYPE_N")
  EU_EMIR_TYPE_N,
  /** 
   *  Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation. 
   */
  @SerialName("EU_EMIR_TYPE_O")
  EU_EMIR_TYPE_O,
  /** 
   *  Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_P")
  EU_EMIR_TYPE_P,
  /** 
   *  Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013. 
   */
  @SerialName("EU_EMIR_TYPE_Q")
  EU_EMIR_TYPE_Q,
  /** 
   *  Denotes shares or units in undertakings for collective investments in transferable securities (UCITS), provided that the conditions set out in Article 5 of EU Regulation 2016/2251 are met. 
   */
  @SerialName("EU_EMIR_TYPE_R")
  EU_EMIR_TYPE_R
  ;
}

/** 
 * The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation. 
 */
@Serializable
enum class EntityTypeEnum {
  /** 
   * Entity Type of Asian. 
   */
  @SerialName("ASIAN")
  ASIAN,
  /** 
   * Entity Type of Australian and New Zealand. 
   */
  @SerialName("AUSTRALIAN_AND_NEW_ZEALAND")
  AUSTRALIAN_AND_NEW_ZEALAND,
  /** 
   * Entity Type of European Emerging Markets. 
   */
  @SerialName("EUROPEAN_EMERGING_MARKETS")
  EUROPEAN_EMERGING_MARKETS,
  /** 
   * Entity Type of Japanese. 
   */
  @SerialName("JAPANESE")
  JAPANESE,
  /** 
   * Entity Type of North American High Yield. 
   */
  @SerialName("NORTH_AMERICAN_HIGH_YIELD")
  NORTH_AMERICAN_HIGH_YIELD,
  /** 
   * Entity Type of North American Insurance. 
   */
  @SerialName("NORTH_AMERICAN_INSURANCE")
  NORTH_AMERICAN_INSURANCE,
  /** 
   * Entity Type of North American Investment Grade. 
   */
  @SerialName("NORTH_AMERICAN_INVESTMENT_GRADE")
  NORTH_AMERICAN_INVESTMENT_GRADE,
  /** 
   * Entity Type of Singaporean. 
   */
  @SerialName("SINGAPOREAN")
  SINGAPOREAN,
  /** 
   * Entity Type of Western European. 
   */
  @SerialName("WESTERN_EUROPEAN")
  WESTERN_EUROPEAN,
  /** 
   * Entity Type of Western European Insurance. 
   */
  @SerialName("WESTERN_EUROPEAN_INSURANCE")
  WESTERN_EUROPEAN_INSURANCE
  ;
}

/** 
 * Represents an enumeration list to identify the type of Equity. 
 */
@Serializable
enum class EquityTypeEnum {
  /** 
   * Identifies an Equity of Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation. 
   */
  @SerialName("NON_CONVERTIBLE_PREFERENCE")
  NON_CONVERTIBLE_PREFERENCE,
  /** 
   * Identifies an Equity of Common stocks and shares. 
   */
  @SerialName("ORDINARY")
  ORDINARY
  ;
}

/** 
 * The enumeration values to qualify the intent associated with a transaction event. 
 */
@Serializable
enum class EventIntentEnum {
  /** 
   * The intent is to allocate one or more trades as part of an allocated block trade. 
   */
  @SerialName("ALLOCATION")
  ALLOCATION,
  /** 
   * The intent is to designate a stand-alone cash transfer as a result of Trade contracual terms e.g. incurred by payout for instance a Performance Amount or a Floating Rate Amount. The particular CashFlow at stake shall be further specified in priceTransferEnum or transferTypeEnum. For clarity, such intentEnum value shall not be used whenever a cash transfer is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. Decrease with Fees, Cross-Currency Notional Reset, etc. or any other Event whenever including a cash transfer with other features. For clarity, a principal payment related to a Principal Exhange is excluded as well, because a dedicated intentEnum value exists for this event i.e. PrincipalExchange value. 
   */
  @SerialName("CASH_FLOW")
  CASH_FLOW,
  /** 
   * The intent is to clear the contract. 
   */
  @SerialName("CLEARING")
  CLEARING,
  /** 
   * The intent is to compress multiple trades as part of a netting or compression event. 
   */
  @SerialName("COMPRESSION")
  COMPRESSION,
  /** 
   * The intent is to form a contract from an execution. 
   */
  @SerialName("CONTRACT_FORMATION")
  CONTRACT_FORMATION,
  /** 
   * The intent is to amend the terms of the contract through renegotiation. 
   */
  @SerialName("CONTRACT_TERMS_AMENDMENT")
  CONTRACT_TERMS_AMENDMENT,
  /** 
   * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum. 
   */
  @SerialName("CORPORATE_ACTION_ADJUSTMENT")
  CORPORATE_ACTION_ADJUSTMENT,
  /** 
   * The intent is to take into effect the occurrence of a Credit Event. 
   */
  @SerialName("CREDIT_EVENT")
  CREDIT_EVENT,
  /** 
   * The intent is to Decrease the quantity or notional of the contract. 
   */
  @SerialName("DECREASE")
  DECREASE,
  /** 
   * The intent is to fully unwind the Trade, as a result of the application of Trade contractual terms (e.g. an obligation to do so before Termination Date as part of any kind of Early Termination terms) as defined within the CDM EarlyTerminationProvision data type. Accordingly, increase and decrease of positions which result from negotiation by the parties shall not be designated by such intentEnum. For clarity, partial exercise of an option before its expiration date is excluded as well, though related to Trade contract terms, because a dedicated intentEnum value exists for this event i.e. OptionExercise value. 
   */
  @SerialName("EARLY_TERMINATION_PROVISION")
  EARLY_TERMINATION_PROVISION,
  /** 
   * The intent is to Increase the quantity or notional of the contract. 
   */
  @SerialName("INCREASE")
  INCREASE,
  /** 
   * The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any).  
   */
  @SerialName("INDEX_TRANSITION")
  INDEX_TRANSITION,
  /** 
   * The intent is to increase or to decrease the notional of the Trade, in accordance with Notional Reset features e.g. could apply for Cross Currency Swaps, Equity Performance Swaps, etc. 
   */
  @SerialName("NOTIONAL_RESET")
  NOTIONAL_RESET,
  /** 
   * The intent is to increase or to decrease the notional of the Trade, in accordance with Step features attached to a Payout Quantity. 
   */
  @SerialName("NOTIONAL_STEP")
  NOTIONAL_STEP,
  /** 
   * The intent is to novate the contract. 
   */
  @SerialName("NOVATION")
  NOVATION,
  /** 
   * The intent is to record any kind of stand-alone obervervations e.g. internal data recording, usage of CDM for recording and/or exchanging data as part of pricing 'consensus' processing, etc. For clarity, such intentEnum value shall not be used whenever an observation is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. CashFlow to which an observation of prices is associated, etc. 
   */
  @SerialName("OBSERVATION_RECORD")
  OBSERVATION_RECORD,
  /** 
   * The intent is to Exercise a contract that is made of one or several option payout legs. For clarity, such intentEnum value shall not be used whenever an optional right is exercised in relation with a Trade which composition includes other types of payout legs e.g. right to call or to cancel before Termination Date as part of any kind of Early Termination terms other than genuine bermuda or american style features described in option payout.  
   */
  @SerialName("OPTION_EXERCISE")
  OPTION_EXERCISE,
  /** 
   * The intent is to cancel the trade through exercise of an optional right as defined within the CDM OptionProvision data type. 
   */
  @SerialName("OPTIONAL_CANCELLATION")
  OPTIONAL_CANCELLATION,
  /** 
   * The intent is to extend the trade through exercise of an optional right as defined within the CDM OptionProvision data type. 
   */
  @SerialName("OPTIONAL_EXTENSION")
  OPTIONAL_EXTENSION,
  /** 
   * The intent is to rebalance a portfolio, by inserting new derivatives transactions into portfolios of participants to reduce risks linked to those trades. These are offsetting trades that rebalance relationships between different counterparties when it comes to exposure of portfolios to certain types of risk, such as interest rate risk. 
   */
  @SerialName("PORTFOLIO_REBALANCING")
  PORTFOLIO_REBALANCING,
  /** 
   * The intent is to pay or to receive a cash transfer, in accordance with Principal Exchange features. 
   */
  @SerialName("PRINCIPAL_EXCHANGE")
  PRINCIPAL_EXCHANGE,
  /** 
   * The intent is to reallocate one or more trades as part of an allocated block trade. 
   */
  @SerialName("REALLOCATION")
  REALLOCATION,
  /** 
   * The intent is to close a repo transaction through repurchase. 
   */
  @SerialName("REPURCHASE")
  REPURCHASE
  ;
}

/** 
 * The enumeration values to qualify the timestamps that can be associated with a lifecycle event. The reason for such approach is that the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. Implementers are expected to evaluate the current enumeration values to determine whether those meet their requirements. If not, they are expected to engage with the CDM team to evaluate the addition of further value(s) to this enumeration, which will then participate to the development of a compendium for further evaluation at a later point in order to determine whether this modeling is appropriate. 
 */
@Serializable
enum class EventTimestampQualificationEnum {
  /** 
   * The date and time on which trade was confirmed as cleared. 
   */
  @SerialName("CLEARING_CONFIRMATION_DATE_TIME")
  CLEARING_CONFIRMATION_DATE_TIME,
  /** 
   * The date and time on the trade was cleared. 
   */
  @SerialName("CLEARING_DATE_TIME")
  CLEARING_DATE_TIME,
  /** 
   * The date and time on which trade was received by Clearing Body. 
   */
  @SerialName("CLEARING_RECEIPT_DATE_TIME")
  CLEARING_RECEIPT_DATE_TIME,
  /** 
   * The date and time on which the event was submitted for clearing. 
   */
  @SerialName("CLEARING_SUBMISSION_DATE_TIME")
  CLEARING_SUBMISSION_DATE_TIME,
  /** 
   * The date and time on which the event was confirmed. 
   */
  @SerialName("CONFIRMATION_DATE_TIME")
  CONFIRMATION_DATE_TIME,
  /** 
   * The date and time on which the event was created. 
   */
  @SerialName("EVENT_CREATION_DATE_TIME")
  EVENT_CREATION_DATE_TIME,
  /** 
   * The date and time on which the event will be considered expired. 
   */
  @SerialName("EVENT_EXPIRATION_DATE_TIME")
  EVENT_EXPIRATION_DATE_TIME,
  /** 
   * The date and time on which the event was processed. 
   */
  @SerialName("EVENT_PROCESSING_DATE_TIME")
  EVENT_PROCESSING_DATE_TIME,
  /** 
   * The date and time on which the event was sent. 
   */
  @SerialName("EVENT_SENT_DATE_TIME")
  EVENT_SENT_DATE_TIME,
  /** 
   * The date and time on which the event was submitted. 
   */
  @SerialName("EVENT_SUBMITTED_DATE_TIME")
  EVENT_SUBMITTED_DATE_TIME,
  /** 
   * The date and time on which the trade execution was performed. 
   */
  @SerialName("EXECUTION_DATE_TIME")
  EXECUTION_DATE_TIME,
  /** 
   * The date and time on which the transaction has been created. This timestamp is specified as such by the CME ClearPort Matched IRS Trade submission API specification: 'The transaction date time of the trade. Represents the date & time on which the trade was initially generated either by CME Clearing or firm. The transaction date time may be assigned by CME Clearing at the point the trade is reported as cleared. Transaction date time can also be provided by an external submitter of the trade at the point the trade is submitted.' 
   */
  @SerialName("TRANSACTION_CREATION_DATE_TIME")
  TRANSACTION_CREATION_DATE_TIME
  ;
}

/** 
 * The enumerated values to specify the Execution Location of a Security Agreement 
 */
@Serializable
enum class ExecutionLocationEnum {
  /** 
   * The Agreement was executed outside of Belgium 
   */
  @SerialName("EXECUTED_IN_BELGIUM")
  EXECUTED_IN_BELGIUM,
  /** 
   * The Agreement was executed outside of Belgium 
   */
  @SerialName("EXECUTED_OUTSIDE_BELGIUM")
  EXECUTED_OUTSIDE_BELGIUM,
  /** 
   * An alternative approach is described in the document as follows. 
   */
  @SerialName("OTHER_LOCATION")
  OTHER_LOCATION
  ;
}

/** 
 * The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ... 
 */
@Serializable
enum class ExecutionTypeEnum {
  /** 
   * Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message. 
   */
  @SerialName("ELECTRONIC")
  ELECTRONIC,
  /** 
   * Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM. 
   */
  @SerialName("OFF_FACILITY")
  OFF_FACILITY,
  /** 
   * Execution via a platform that may or may not be covered by a regulatory defintion. OnVenue is intended to distinguish trades executed on a trading platform from those executed via phone, email or messaging apps. The role and details of the venue are included in the party attribute of the trade. The general rule is that if the parties utilitzed the services of the platform to execute the trade then it would be considered OnVenue. 
   */
  @SerialName("ON_VENUE")
  ON_VENUE
  ;
}

/** 
 * Defines the principal party to the trade that has the right to exercise. 
 */
@Serializable
enum class ExerciseNoticeGiverEnum {
  /** 
   * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_AGREEMENT")
  AS_SPECIFIED_IN_MASTER_AGREEMENT,
  /** 
   * Specifies that both the option buyer and option seller has the right to exercise. 
   */
  @SerialName("BOTH")
  BOTH,
  /** 
   * Specifies that only the option buyer has the right to exercise. 
   */
  @SerialName("BUYER")
  BUYER,
  /** 
   * Specifies that only the option seller has the right to exercise. 
   */
  @SerialName("SELLER")
  SELLER
  ;
}

/** 
 * The time of day at which the equity option expires, for example the official closing time of the exchange. 
 */
@Serializable
enum class ExpirationTimeTypeEnum {
  /** 
   * The time is determined as provided in the relevant Master Confirmation. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_CONFIRMATION")
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,
  /** 
   * The official closing time of the exchange on the valuation date. 
   */
  @SerialName("CLOSE")
  CLOSE,
  /** 
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlyer. 
   */
  @SerialName("DERIVATIVES_CLOSE")
  DERIVATIVES_CLOSE,
  /** 
   * The time at which the official settlement price is determined. 
   */
  @SerialName("OSP")
  OSP,
  /** 
   * The official opening time of the exchange on the valuation date. 
   */
  @SerialName("OPEN")
  OPEN,
  /** 
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate) 
   */
  @SerialName("SPECIFIC_TIME")
  SPECIFIC_TIME,
  /** 
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange. 
   */
  @SerialName("XETRA")
  XETRA
  ;
}

/** 
 * Specifies the fallback provisions in respect to the applicable Futures Price Valuation. 
 */
@Serializable
enum class FPVFinalPriceElectionFallbackEnum {
  /** 
   * In respect of the Early Final Valuation Date, the provisions for FPV Close shall apply. 
   */
  @SerialName("FPV_CLOSE")
  FPV_CLOSE,
  /** 
   * In respect of the Early Final Valuation Date, the provisions for FPV Hedge Execution shall apply. 
   */
  @SerialName("FPV_HEDGE_EXECUTION")
  FPV_HEDGE_EXECUTION
  ;
}

/** 
 * The enumerated values to specify an event that has given rise to a fee. 
 */
@Serializable
enum class FeeTypeEnum {
  /** 
   * A cash flow resulting from the assignment of a contract to a new counterparty. 
   */
  @SerialName("ASSIGNMENT")
  ASSIGNMENT,
  /** 
   * The brokerage commission. 
   */
  @SerialName("BROKERAGE_COMMISSION")
  BROKERAGE_COMMISSION,
  /** 
   * A cash flow associated with a corporate action 
   */
  @SerialName("CORPORATE_ACTION")
  CORPORATE_ACTION,
  /** 
   * A cash flow associated with a credit event. 
   */
  @SerialName("CREDIT_EVENT")
  CREDIT_EVENT,
  /** 
   * A cash flow associated with an increase lifecycle event. 
   */
  @SerialName("INCREASE")
  INCREASE,
  /** 
   * The novation fee. 
   */
  @SerialName("NOVATION")
  NOVATION,
  /** 
   * A cash flow associated with a partial termination lifecycle event. 
   */
  @SerialName("PARTIAL_TERMINATION")
  PARTIAL_TERMINATION,
  /** 
   * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified. 
   */
  @SerialName("PREMIUM")
  PREMIUM,
  /** 
   * A cash flow associated with a renegotiation lifecycle event. 
   */
  @SerialName("RENEGOTIATION")
  RENEGOTIATION,
  /** 
   * A cash flow associated with a termination lifecycle event. 
   */
  @SerialName("TERMINATION")
  TERMINATION,
  /** 
   * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price. 
   */
  @SerialName("UPFRONT")
  UPFRONT
  ;
}

/** 
 * To be specified only for products that embed a redemption payment. 
 */
@Serializable
enum class FinalPrincipalExchangeCalculationEnum {
  /** 
   * If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base). 
   */
  @SerialName("FLOORED")
  FLOORED,
  /** 
   * If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base. 
   */
  @SerialName("NON_FLOORED")
  NON_FLOORED
  ;
}

/** 
 * Provides enumerated values for financial units, generally used in the context of defining quantities for securities. 
 */
@Serializable
enum class FinancialUnitEnum {
  /** 
   * Denotes financial contracts, such as listed futures and options. 
   */
  @SerialName("CONTRACT")
  CONTRACT,
  /** 
   * Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount. 
   */
  @SerialName("CONTRACTUAL_PRODUCT")
  CONTRACTUAL_PRODUCT,
  /** 
   * Denotes a price expressed in index points, e.g. for a stock index. 
   */
  @SerialName("INDEX_UNIT")
  INDEX_UNIT,
  /** 
   * Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month. 
   */
  @SerialName("LOG_NORMAL_VOLATILITY")
  LOG_NORMAL_VOLATILITY,
  /** 
   * Denotes the number of units of financial stock shares. 
   */
  @SerialName("SHARE")
  SHARE,
  /** 
   * Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names. 
   */
  @SerialName("VALUE_PER_DAY")
  VALUE_PER_DAY,
  /** 
   * Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk. 
   */
  @SerialName("VALUE_PER_PERCENT")
  VALUE_PER_PERCENT,
  /** 
   * Denotes a quantity (expressed as a decimal value) represented the weight of a component in a basket. 
   */
  @SerialName("WEIGHT")
  WEIGHT
  ;
}

/** 
 * 3rd level ISDA FRO category. 
 */
@Serializable
enum class FloatingRateIndexCalculationMethodEnum {
  @SerialName("All-In Compounded Index")
  ALL_IN_COMPOUNDED,
  /** 
   * A calculation methodology using the arithmetic mean. 
   */
  @SerialName("Overnight Averaging")
  AVERAGE,
  @SerialName("Compounded Index")
  COMPOUNDED,
  /** 
   * A calculation methodology using the ISDA-defined OIS compounding formula. 
   */
  @SerialName("OIS Compounding")
  OIS_COMPOUND
  ;
}

/** 
 * Top level ISDA FRO category. 
 */
@Serializable
enum class FloatingRateIndexCategoryEnum {
  /** 
   * The rate is calculated by the calculation agents from multiple observations. 
   */
  @SerialName("Calculated Rate")
  CALCULATED,
  /** 
   * The rate is obtained by polling several other banks. 
   */
  @SerialName("Reference Banks Rate")
  REFERENCE_BANKS,
  /** 
   * The rate is observed directly from a screen. 
   */
  @SerialName("Screen Rate")
  SCREEN_RATE
  ;
}

/** 
 * The enumerated values to specify the list of floating rate index. 
 */
@Serializable
enum class FloatingRateIndexEnum {
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AED-EBOR-Reuters")
  AED_EBOR_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AED-EIBOR")
  AED_EIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-AONIA")
  AUD_AONIA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-AONIA-OIS-COMPOUND")
  AUD_AONIA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-AONIA-OIS-COMPOUND-SwapMarker")
  AUD_AONIA_OIS_COMPOUND_SWAP_MARKER,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-AONIA-OIS Compound")
  AUD_AONIA_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBR-AUBBSW")
  AUD_BBR_AUBBSW,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBR-BBSW")
  AUD_BBR_BBSW,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBR-BBSW-Bloomberg")
  AUD_BBR_BBSW_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBR-BBSY (BID)")
  AUD_BBR_BBSY__BID_,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBR-ISDC")
  AUD_BBR_ISDC,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBSW")
  AUD_BBSW,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBSW Quarterly Swap Rate ICAP")
  AUD_BBSW_QUARTERLY_SWAP_RATE_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBSW Semi Annual Swap Rate ICAP")
  AUD_BBSW_SEMI_ANNUAL_SWAP_RATE_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-BBSY Bid")
  AUD_BBSY_BID,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-LIBOR-BBA")
  AUD_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-LIBOR-BBA-Bloomberg")
  AUD_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-LIBOR-Reference Banks")
  AUD_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Quarterly Swap Rate-ICAP")
  AUD_QUARTERLY_SWAP_RATE_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Quarterly Swap Rate-ICAP-Reference Banks")
  AUD_QUARTERLY_SWAP_RATE_ICAP_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  AUD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")
  AUD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Semi-Annual Swap Rate-ICAP-Reference Banks")
  AUD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Semi-annual Swap Rate-ICAP")
  AUD_SEMI_ANNUAL_SWAP_RATE_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("AUD-Swap Rate-Reuters")
  AUD_SWAP_RATE_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("BRL-CDI")
  BRL_CDI,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-CDOR")
  CAD_BA_CDOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-CDOR-Bloomberg")
  CAD_BA_CDOR_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-ISDD")
  CAD_BA_ISDD,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-Reference Banks")
  CAD_BA_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-Reuters")
  CAD_BA_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-BA-Telerate")
  CAD_BA_TELERATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CDOR")
  CAD_CDOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CORRA")
  CAD_CORRA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CORRA CanDeal TMX Term")
  CAD_CORRA_CAN_DEAL_TMX_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CORRA Compounded Index")
  CAD_CORRA_COMPOUNDED_INDEX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CORRA-OIS-COMPOUND")
  CAD_CORRA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-CORRA-OIS Compound")
  CAD_CORRA_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-ISDA-Swap Rate")
  CAD_ISDA_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-LIBOR-BBA")
  CAD_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-LIBOR-BBA-Bloomberg")
  CAD_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-LIBOR-BBA-SwapMarker")
  CAD_LIBOR_BBA_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-LIBOR-Reference Banks")
  CAD_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-REPO-CORRA")
  CAD_REPO_CORRA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-TBILL-ISDD")
  CAD_TBILL_ISDD,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-TBILL-Reference Banks")
  CAD_TBILL_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-TBILL-Reuters")
  CAD_TBILL_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CAD-TBILL-Telerate")
  CAD_TBILL_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-3M LIBOR SWAP-CME vs LCH-ICAP")
  CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP")
  CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-6M LIBORSWAP-CME vs LCH-ICAP-Bloomberg")
  CHF_6_M_LIBORSWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-6M LIBOR SWAP-CME vs LCH-ICAP")
  CHF_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP")
  CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-Annual Swap Rate")
  CHF_ANNUAL_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-Annual Swap Rate-11:00-ICAP")
  CHF_ANNUAL_SWAP_RATE_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-Annual Swap Rate-Reference Banks")
  CHF_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-Basis Swap-3m vs 6m-LIBOR-11:00-ICAP")
  CHF_BASIS_SWAP_3_M_VS_6_M_LIBOR_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-ISDAFIX-Swap Rate")
  CHF_ISDAFIX_SWAP_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-LIBOR")
  CHF_LIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-LIBOR-BBA")
  CHF_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-LIBOR-BBA-Bloomberg")
  CHF_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-LIBOR-ISDA")
  CHF_LIBOR_ISDA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-LIBOR-Reference Banks")
  CHF_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-OIS-11:00-ICAP")
  CHF_OIS_11_00_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON")
  CHF_SARON,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 12M")
  CHF_SARON_AVERAGE_12_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 1M")
  CHF_SARON_AVERAGE_1_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 1W")
  CHF_SARON_AVERAGE_1_W,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 2M")
  CHF_SARON_AVERAGE_2_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 3M")
  CHF_SARON_AVERAGE_3_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 6M")
  CHF_SARON_AVERAGE_6_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Average 9M")
  CHF_SARON_AVERAGE_9_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON Compounded Index")
  CHF_SARON_COMPOUNDED_INDEX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON-OIS-COMPOUND")
  CHF_SARON_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-SARON-OIS Compound")
  CHF_SARON_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF-TOIS-OIS-COMPOUND")
  CHF_TOIS_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CHF USD-Basis Swaps-11:00-ICAP")
  CHF_USD_BASIS_SWAPS_11_00_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CLP-ICP")
  CLP_ICP,
  /** 
   * Refers to the Indice Camara Promedio ('ICP') rate for Chilean Pesos which, for a Reset Date, is determined and published by the Asociacion de Bancos e Instituciones Financieras de Chile A.G. ('ABIF') in accordance with the 'Reglamento Indice de Camara Promedio' of the ABIF as published in the Diario Oficial de la Republica de Chile (the 'ICP Rules') and which is reported on the ABIF website by not later than 10:00 a.m., Santiago time, on that Reset Date. 
   */
  @SerialName("CLP-TNA")
  CLP_TNA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CL-CLICP-Bloomberg")
  CL_CLICP_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNH-HIBOR")
  CNH_HIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNH-HIBOR-Reference Banks")
  CNH_HIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNH-HIBOR-TMA")
  CNH_HIBOR_TMA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY 7-Repo Compounding Date")
  CNY_7_REPO_COMPOUNDING_DATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-CNREPOFIX=CFXS-Reuters")
  CNY_CNREPOFIX_CFXS_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Deposit Rate")
  CNY_DEPOSIT_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Fixing Repo Rate")
  CNY_FIXING_REPO_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-LPR")
  CNY_LPR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-PBOCB-Reuters")
  CNY_PBOCB_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Quarterly 7D Repo NDS Rate Tradition")
  CNY_QUARTERLY_7_D_REPO_NDS_RATE_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION")
  CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION-Reference Banks")
  CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-SHIBOR")
  CNY_SHIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-SHIBOR-OIS Compound")
  CNY_SHIBOR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.. 
   */
  @SerialName("CNY-SHIBOR-Reuters")
  CNY_SHIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Semi-Annual Swap Rate-11:00-BGCANTOR")
  CNY_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Semi-Annual Swap Rate-Reference Banks")
  CNY_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CNY-Shibor-OIS-Compounding")
  CNY_SHIBOR_OIS_COMPOUNDING,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("COP-IBR-OIS-COMPOUND")
  COP_IBR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("COP-IBR-OIS Compound")
  COP_IBR_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-Annual Swap Rate-11:00-BGCANTOR")
  CZK_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-Annual Swap Rate-Reference Banks")
  CZK_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-CZEONIA")
  CZK_CZEONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-CZEONIA-OIS Compound")
  CZK_CZEONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-PRIBOR")
  CZK_PRIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-PRIBOR-PRBO")
  CZK_PRIBOR_PRBO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("CZK-PRIBOR-Reference Banks")
  CZK_PRIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR")
  DKK_CIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR2")
  DKK_CIBOR2,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR2-Bloomberg")
  DKK_CIBOR_2_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR2-DKNA13")
  DKK_CIBOR2_DKNA13,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR-DKNA13")
  DKK_CIBOR_DKNA13,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR-DKNA13-Bloomberg")
  DKK_CIBOR_DKNA_13_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CIBOR-Reference Banks")
  DKK_CIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CITA")
  DKK_CITA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-CITA-DKNA14-COMPOUND")
  DKK_CITA_DKNA14_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-DESTR")
  DKK_DESTR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-DESTR Compounded Index")
  DKK_DESTR_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-DESTR-OIS Compound")
  DKK_DESTR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-DKKOIS-OIS-COMPOUND")
  DKK_DKKOIS_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("DKK-Tom Next-OIS Compound")
  DKK_TOM_NEXT_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP")
  EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP")
  EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP")
  EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP")
  EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00")
  EUR_ANNUAL_SWAP_RATE_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00-BGCANTOR")
  EUR_ANNUAL_SWAP_RATE_10_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00-Bloomberg")
  EUR_ANNUAL_SWAP_RATE_10_00_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00-ICAP")
  EUR_ANNUAL_SWAP_RATE_10_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00-SwapMarker")
  EUR_ANNUAL_SWAP_RATE_10_00_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-10:00-TRADITION")
  EUR_ANNUAL_SWAP_RATE_10_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-11:00")
  EUR_ANNUAL_SWAP_RATE_11_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-11:00-Bloomberg")
  EUR_ANNUAL_SWAP_RATE_11_00_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-11:00-ICAP")
  EUR_ANNUAL_SWAP_RATE_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-11:00-SwapMarker")
  EUR_ANNUAL_SWAP_RATE_11_00_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-3 Month")
  EUR_ANNUAL_SWAP_RATE_3_MONTH,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-3 Month-SwapMarker")
  EUR_ANNUAL_SWAP_RATE_3_MONTH_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-4:15-TRADITION")
  EUR_ANNUAL_SWAP_RATE_4_15_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-Annual Swap Rate-Reference Banks")
  EUR_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR Basis Swap-EONIA vs 3m EUR+IBOR Swap Rates-A/360-10:00-ICAP")
  EUR_BASIS_SWAP_EONIA_VS_3_M_EUR_IBOR_SWAP_RATES_A_360_10_00_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-CNO TEC10")
  EUR_CNO_TEC10,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA")
  EUR_EONIA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-AVERAGE")
  EUR_EONIA_AVERAGE_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-Average")
  EUR_EONIA_AVERAGE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-10:00-BGCANTOR")
  EUR_EONIA_OIS_10_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-10:00-ICAP")
  EUR_EONIA_OIS_10_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-10:00-TRADITION")
  EUR_EONIA_OIS_10_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-11:00-ICAP")
  EUR_EONIA_OIS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-4:15-TRADITION")
  EUR_EONIA_OIS_4_15_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-COMPOUND")
  EUR_EONIA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS-COMPOUND-Bloomberg")
  EUR_EONIA_OIS_COMPOUND_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-OIS Compound")
  EUR_EONIA_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EONIA-Swap-Index")
  EUR_EONIA_SWAP_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR")
  EUR_EURIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR-Act/365")
  EUR_EURIBOR_ACT_365,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR-Act/365-Bloomberg")
  EUR_EURIBOR_ACT_365_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR EURIBOR-Annual Bond Swap vs 1m-11:00-ICAP")
  EUR_EURIBOR_ANNUAL_BOND_SWAP_VS_1_M_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR EURIBOR-Basis Swap-1m vs 3m-Euribor-11:00-ICAP")
  EUR_EURIBOR_BASIS_SWAP_1_M_VS_3_M_EURIBOR_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR EURIBOR-Basis Swap-3m vs 6m-11:00-ICAP")
  EUR_EURIBOR_BASIS_SWAP_3_M_VS_6_M_11_00_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR ICE Swap Rate-11:00")
  EUR_EURIBOR_ICE_SWAP_RATE_11_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR ICE Swap Rate-12:00")
  EUR_EURIBOR_ICE_SWAP_RATE_12_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR-Reference Banks")
  EUR_EURIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR-Reuters")
  EUR_EURIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURIBOR-Telerate")
  EUR_EURIBOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURONIA-OIS-COMPOUND")
  EUR_EURONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EURONIA-OIS Compound")
  EUR_EURONIA_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR")
  EUR_EURO_STR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Average 12M")
  EUR_EURO_STR_AVERAGE_12_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Average 1M")
  EUR_EURO_STR_AVERAGE_1_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Average 1W")
  EUR_EURO_STR_AVERAGE_1_W,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Average 3M")
  EUR_EURO_STR_AVERAGE_3_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Average 6M")
  EUR_EURO_STR_AVERAGE_6_M,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR-COMPOUND")
  EUR_EURO_STR_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Compounded Index")
  EUR_EURO_STR_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR FTSE Term")
  EUR_EURO_STR_FTSE_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index 0 Floor")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index 0 Floor 2D Lag")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index 0 Floor 5D Lag")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index 2D Lag")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Compounded Index 5D Lag")
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR ICE Swap Rate")
  EUR_EURO_STR_ICE_SWAP_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR-OIS Compound")
  EUR_EURO_STR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-EuroSTR Term")
  EUR_EURO_STR_TERM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-ISDA-EURIBOR Swap Rate-11:00")
  EUR_ISDA_EURIBOR_SWAP_RATE_11_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-ISDA-EURIBOR Swap Rate-12:00")
  EUR_ISDA_EURIBOR_SWAP_RATE_12_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-ISDA-LIBOR Swap Rate-10:00")
  EUR_ISDA_LIBOR_SWAP_RATE_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-ISDA-LIBOR Swap Rate-11:00")
  EUR_ISDA_LIBOR_SWAP_RATE_11_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-LIBOR")
  EUR_LIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-LIBOR-BBA")
  EUR_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-LIBOR-BBA-Bloomberg")
  EUR_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-LIBOR-Reference Banks")
  EUR_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TAM-CDC")
  EUR_TAM_CDC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC10-CNO")
  EUR_TEC10_CNO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC10-CNO-SwapMarker")
  EUR_TEC_10_CNO_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC10-Reference Banks")
  EUR_TEC_10_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC5-CNO")
  EUR_TEC5_CNO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC5-CNO-SwapMarker")
  EUR_TEC_5_CNO_SWAP_MARKER,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TEC5-Reference Banks")
  EUR_TEC_5_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR-TMM-CDC-COMPOUND")
  EUR_TMM_CDC_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("EUR USD-Basis Swaps-11:00-ICAP")
  EUR_USD_BASIS_SWAPS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-6M LIBOR SWAP-CME vs LCH-ICAP")
  GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP")
  GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-ISDA-Swap Rate")
  GBP_ISDA_SWAP_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR")
  GBP_LIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR-BBA")
  GBP_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR-BBA-Bloomberg")
  GBP_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR ICE Swap Rate")
  GBP_LIBOR_ICE_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR-ISDA")
  GBP_LIBOR_ISDA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-LIBOR-Reference Banks")
  GBP_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-RONIA")
  GBP_RONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-RONIA-OIS Compound")
  GBP_RONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA")
  GBP_SONIA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA-COMPOUND")
  GBP_SONIA_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA Compounded Index")
  GBP_SONIA_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA FTSE Term")
  GBP_SONIA_FTSE_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index")
  GBP_SONIA_ICE_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index 0 Floor")
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index 0 Floor 2D Lag")
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index 0 Floor 5D Lag")
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index 2D Lag")
  GBP_SONIA_ICE_COMPOUNDED_INDEX_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Compounded Index 5D Lag")
  GBP_SONIA_ICE_COMPOUNDED_INDEX_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Swap Rate")
  GBP_SONIA_ICE_SWAP_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA ICE Term")
  GBP_SONIA_ICE_TERM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA-OIS-11:00-ICAP")
  GBP_SONIA_OIS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA-OIS-11:00-TRADITION")
  GBP_SONIA_OIS_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA-OIS-4:15-TRADITION")
  GBP_SONIA_OIS_4_15_TRADITION,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA-OIS Compound")
  GBP_SONIA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-SONIA Swap Rate")
  GBP_SONIA_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi-Annual Swap Rate")
  GBP_SEMI_ANNUAL_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi-Annual Swap Rate-11:00-ICAP")
  GBP_SEMI_ANNUAL_SWAP_RATE_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi Annual Swap Rate-11:00-TRADITION")
  GBP_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi Annual Swap Rate-4:15-TRADITION")
  GBP_SEMI_ANNUAL_SWAP_RATE_4_15_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi-Annual Swap Rate-Reference Banks")
  GBP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-Semi-Annual Swap Rate-SwapMarker26")
  GBP_SEMI_ANNUAL_SWAP_RATE_SWAP_MARKER_26,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-UK Base Rate")
  GBP_UK_BASE_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP USD-Basis Swaps-11:00-ICAP")
  GBP_USD_BASIS_SWAPS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-WMBA-RONIA-COMPOUND")
  GBP_WMBA_RONIA_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GBP-WMBA-SONIA-COMPOUND")
  GBP_WMBA_SONIA_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GRD-ATHIBOR-ATHIBOR")
  GRD_ATHIBOR_ATHIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GRD-ATHIBOR-Reference Banks")
  GRD_ATHIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GRD-ATHIBOR-Telerate")
  GRD_ATHIBOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GRD-ATHIMID-Reference Banks")
  GRD_ATHIMID_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("GRD-ATHIMID-Reuters")
  GRD_ATHIMID_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR")
  HKD_HIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-HIBOR=")
  HKD_HIBOR_HIBOR_,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-HIBOR-Bloomberg")
  HKD_HIBOR_HIBOR_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-HKAB")
  HKD_HIBOR_HKAB,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-HKAB-Bloomberg")
  HKD_HIBOR_HKAB_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-ISDC")
  HKD_HIBOR_ISDC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HIBOR-Reference Banks")
  HKD_HIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HONIA")
  HKD_HONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HONIA-OIS Compound")
  HKD_HONIA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-HONIX-OIS-COMPOUND")
  HKD_HONIX_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-ISDA-Swap Rate-11:00")
  HKD_ISDA_SWAP_RATE_11_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-ISDA-Swap Rate-4:00")
  HKD_ISDA_SWAP_RATE_4_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Annual Swap Rate-11:00-TRADITION")
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Annual Swap Rate-4:00-BGCANTOR")
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_4_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Annual Swap Rate-Reference Banks")
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Quarterly Swap Rate-11:00-ICAP")
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Quarterly Swap Rate-4:00-ICAP")
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_4_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HKD-Quarterly-Quarterly Swap Rate-Reference Banks")
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HUF-BUBOR")
  HUF_BUBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HUF-BUBOR-Reference Banks")
  HUF_BUBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HUF-BUBOR-Reuters")
  HUF_BUBOR_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HUF-HUFONIA")
  HUF_HUFONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("HUF-HUFONIA-OIS Compound")
  HUF_HUFONIA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-IDMA-Bloomberg")
  IDR_IDMA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-IDRFIX")
  IDR_IDRFIX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-INDONIA")
  IDR_INDONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-INDONIA-OIS Compound")
  IDR_INDONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-JIBOR")
  IDR_JIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-JIBOR-Reuters")
  IDR_JIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-SBI-Reuters")
  IDR_SBI_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-SOR-Reference Banks")
  IDR_SOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-SOR-Reuters")
  IDR_SOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-SOR-Telerate")
  IDR_SOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-Semi-Annual Swap Rate-11:00-BGCANTOR")
  IDR_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")
  IDR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("IDR-Semi-Annual Swap Rate-Reference Banks")
  IDR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ILS-SHIR")
  ILS_SHIR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ILS-SHIR-OIS Compound")
  ILS_SHIR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ILS-TELBOR")
  ILS_TELBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ILS-TELBOR01-Reuters")
  ILS_TELBOR_01_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ILS-TELBOR-Reference Banks")
  ILS_TELBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-BMK")
  INR_BMK,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-CMT")
  INR_CMT,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-FBIL-MIBOR-OIS-COMPOUND")
  INR_FBIL_MIBOR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-INBMK-REUTERS")
  INR_INBMK_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MIBOR OIS")
  INR_MIBOR_OIS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MIBOR-OIS-COMPOUND")
  INR_MIBOR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MIBOR-OIS Compound")
  INR_MIBOR_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MIFOR")
  INR_MIFOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MIOIS")
  INR_MIOIS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-MITOR-OIS-COMPOUND")
  INR_MITOR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-Modified MIFOR")
  INR_MODIFIED_MIFOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-Reference Banks")
  INR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-Semi-Annual Swap Rate-11:30-BGCANTOR")
  INR_SEMI_ANNUAL_SWAP_RATE_11_30_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")
  INR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("INR-Semi-Annual Swap Rate-Reference Banks")
  INR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ISK-REIBOR")
  ISK_REIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ISK-REIBOR-Reference Banks")
  ISK_REIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ISK-REIBOR-Reuters")
  ISK_REIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-Annual Swap Rate-11:00-TRADITION")
  JPY_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-Annual Swap Rate-3:00-TRADITION")
  JPY_ANNUAL_SWAP_RATE_3_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-BBSF-Bloomberg-10:00")
  JPY_BBSF_BLOOMBERG_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-BBSF-Bloomberg-15:00")
  JPY_BBSF_BLOOMBERG_15_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-Euroyen TIBOR")
  JPY_EUROYEN_TIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-ISDA-Swap Rate-10:00")
  JPY_ISDA_SWAP_RATE_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-ISDA-Swap Rate-15:00")
  JPY_ISDA_SWAP_RATE_15_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR")
  JPY_LIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR-BBA")
  JPY_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR-BBA-Bloomberg")
  JPY_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR-FRASETT")
  JPY_LIBOR_FRASETT,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR-ISDA")
  JPY_LIBOR_ISDA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR-Reference Banks")
  JPY_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR TSR-10:00")
  JPY_LIBOR_TSR_10_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LIBOR TSR-15:00")
  JPY_LIBOR_TSR_15_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LTPR MHBK")
  JPY_LTPR_MHBK,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LTPR-MHCB")
  JPY_LTPR_MHCB,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-LTPR-TBC")
  JPY_LTPR_TBC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-MUTANCALL-TONAR")
  JPY_MUTANCALL_TONAR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-OIS-11:00-ICAP")
  JPY_OIS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-OIS-11:00-TRADITION")
  JPY_OIS_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-OIS-3:00-TRADITION")
  JPY_OIS_3_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-Quoting Banks-LIBOR")
  JPY_QUOTING_BANKS_LIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-STPR-Quoting Banks")
  JPY_STPR_QUOTING_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR")
  JPY_TIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-17096")
  JPY_TIBOR_17096,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-17097")
  JPY_TIBOR_17097,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-DTIBOR01")
  JPY_TIBOR_DTIBOR01,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM")
  JPY_TIBOR_TIBM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM-Reference Banks")
  JPY_TIBOR_TIBM_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM (10 Banks)")
  JPY_TIBOR_TIBM_10_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM (5 Banks)")
  JPY_TIBOR_TIBM_5_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM (All Banks)")
  JPY_TIBOR_TIBM_ALL_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-TIBM (All Banks)-Bloomberg")
  JPY_TIBOR_TIBM_ALL_BANKS_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TIBOR-ZTIBOR")
  JPY_TIBOR_ZTIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA")
  JPY_TONA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA Average 180D")
  JPY_TONA_AVERAGE_180_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA Average 30D")
  JPY_TONA_AVERAGE_30_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA Average 90D")
  JPY_TONA_AVERAGE_90_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA Compounded Index")
  JPY_TONA_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index")
  JPY_TONA_ICE_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index 0 Floor")
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index 0 Floor 2D Lag")
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index 0 Floor 5D Lag")
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index 2D Lag")
  JPY_TONA_ICE_COMPOUNDED_INDEX_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA ICE Compounded Index 5D Lag")
  JPY_TONA_ICE_COMPOUNDED_INDEX_5_D_LAG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA-OIS-COMPOUND")
  JPY_TONA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA-OIS Compound")
  JPY_TONA_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA TSR-10:00")
  JPY_TONA_TSR_10_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TONA TSR-15:00")
  JPY_TONA_TSR_15_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TORF QUICK")
  JPY_TORF_QUICK,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TSR-Reference Banks")
  JPY_TSR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TSR-Reuters-10:00")
  JPY_TSR_REUTERS_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TSR-Reuters-15:00")
  JPY_TSR_REUTERS_15_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TSR-Telerate-10:00")
  JPY_TSR_TELERATE_10_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY-TSR-Telerate-15:00")
  JPY_TSR_TELERATE_15_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("JPY USD-Basis Swaps-11:00-ICAP")
  JPY_USD_BASIS_SWAPS_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-Bond-3222")
  KRW_BOND_3222,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-CD-3220")
  KRW_CD_3220,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-CD 91D")
  KRW_CD_91D,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-CD-KSDA-Bloomberg")
  KRW_CD_KSDA_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-KOFR")
  KRW_KOFR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-KOFR-OIS Compound")
  KRW_KOFR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("KRW-Quarterly Annual Swap Rate-3:30-ICAP")
  KRW_QUARTERLY_ANNUAL_SWAP_RATE_3_30_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE")
  MXN_TIIE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE-Banxico")
  MXN_TIIE_BANXICO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE-Banxico-Bloomberg")
  MXN_TIIE_BANXICO_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE-Banxico-Reference Banks")
  MXN_TIIE_BANXICO_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE ON")
  MXN_TIIE_ON,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE ON-OIS Compound")
  MXN_TIIE_ON_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MXN-TIIE-Reference Banks")
  MXN_TIIE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-KLIBOR")
  MYR_KLIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-KLIBOR-BNM")
  MYR_KLIBOR_BNM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-KLIBOR-Reference Banks")
  MYR_KLIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-MYOR")
  MYR_MYOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-MYOR-OIS Compound")
  MYR_MYOR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-Quarterly Swap Rate-11:00-TRADITION")
  MYR_QUARTERLY_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("MYR-Quarterly Swap Rate-TRADITION-Reference Banks")
  MYR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR")
  NOK_NIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR-NIBR")
  NOK_NIBOR_NIBR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR-NIBR-Bloomberg")
  NOK_NIBOR_NIBR_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR-NIBR-Reference Banks")
  NOK_NIBOR_NIBR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR-OIBOR")
  NOK_NIBOR_OIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NIBOR-Reference Banks")
  NOK_NIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NOWA")
  NOK_NOWA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NOK-NOWA-OIS Compound")
  NOK_NOWA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BBR-BID")
  NZD_BBR_BID,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BBR-FRA")
  NZD_BBR_FRA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BBR-ISDC")
  NZD_BBR_ISDC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BBR-Reference Banks")
  NZD_BBR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BBR-Telerate")
  NZD_BBR_TELERATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BKBM Bid")
  NZD_BKBM_BID,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BKBM FRA")
  NZD_BKBM_FRA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-BKBM FRA Swap Rate ICAP")
  NZD_BKBM_FRA_SWAP_RATE_ICAP,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-NZIONA")
  NZD_NZIONA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-NZIONA-OIS-COMPOUND")
  NZD_NZIONA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-NZIONA-OIS Compound")
  NZD_NZIONA_OIS_COMPOUND_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  NZD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")
  NZD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-Swap Rate-ICAP")
  NZD_SWAP_RATE_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("NZD-Swap Rate-ICAP-Reference Banks")
  NZD_SWAP_RATE_ICAP_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-ORR")
  PHP_ORR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-PHIREF")
  PHP_PHIREF,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-PHIREF-BAP")
  PHP_PHIREF_BAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-PHIREF-Bloomberg")
  PHP_PHIREF_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-PHIREF-Reference Banks")
  PHP_PHIREF_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-Semi-Annual Swap Rate-11:00-BGCANTOR")
  PHP_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PHP-Semi-Annual Swap Rate-Reference Banks")
  PHP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-POLONIA")
  PLN_POLONIA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-POLONIA-OIS-COMPOUND")
  PLN_POLONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-POLONIA-OIS Compound")
  PLN_POLONIA_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIBID")
  PLN_WIBID,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIBOR")
  PLN_WIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIBOR-Reference Banks")
  PLN_WIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIBOR-WIBO")
  PLN_WIBOR_WIBO,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIRON")
  PLN_WIRON,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLN-WIRON-OIS Compound")
  PLN_WIRON_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLZ-WIBOR-Reference Banks")
  PLZ_WIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("PLZ-WIBOR-WIBO")
  PLZ_WIBOR_WIBO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("REPOFUNDS RATE-FRANCE-OIS-COMPOUND")
  REPOFUNDS_RATE_FRANCE_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("REPOFUNDS RATE-GERMANY-OIS-COMPOUND")
  REPOFUNDS_RATE_GERMANY_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("REPOFUNDS RATE-ITALY-OIS-COMPOUND")
  REPOFUNDS_RATE_ITALY_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RON-Annual Swap Rate-11:00-BGCANTOR")
  RON_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RON-Annual Swap Rate-Reference Banks")
  RON_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RON-RBOR-Reuters")
  RON_RBOR_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RON-ROBID")
  RON_ROBID,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RON-ROBOR")
  RON_ROBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Annual Swap Rate-11:00-BGCANTOR")
  RUB_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Annual Swap Rate-12:45-TRADITION")
  RUB_ANNUAL_SWAP_RATE_12_45_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Annual Swap Rate-4:15-TRADITION")
  RUB_ANNUAL_SWAP_RATE_4_15_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Annual Swap Rate-Reference Banks")
  RUB_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Annual Swap Rate-TRADITION-Reference Banks")
  RUB_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-Key Rate CBRF")
  RUB_KEY_RATE_CBRF,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-MOSPRIME-NFEA")
  RUB_MOSPRIME_NFEA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-MOSPRIME-Reference Banks")
  RUB_MOSPRIME_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-MosPrime")
  RUB_MOS_PRIME,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-RUONIA")
  RUB_RUONIA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-RUONIA-OIS-COMPOUND")
  RUB_RUONIA_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("RUB-RUONIA-OIS Compound")
  RUB_RUONIA_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SAR-SAIBOR")
  SAR_SAIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SAR-SRIOR-Reference Banks")
  SAR_SRIOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SAR-SRIOR-SUAA")
  SAR_SRIOR_SUAA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-Annual Swap Rate")
  SEK_ANNUAL_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-Annual Swap Rate-SESWFI")
  SEK_ANNUAL_SWAP_RATE_SESWFI,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SIOR-OIS-COMPOUND")
  SEK_SIOR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-STIBOR")
  SEK_STIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-STIBOR-Bloomberg")
  SEK_STIBOR_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-STIBOR-OIS Compound")
  SEK_STIBOR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-STIBOR-Reference Banks")
  SEK_STIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-STIBOR-SIDE")
  SEK_STIBOR_SIDE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR")
  SEK_SWESTR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Average 1M")
  SEK_SWESTR_AVERAGE_1_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Average 1W")
  SEK_SWESTR_AVERAGE_1_W,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Average 2M")
  SEK_SWESTR_AVERAGE_2_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Average 3M")
  SEK_SWESTR_AVERAGE_3_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Average 6M")
  SEK_SWESTR_AVERAGE_6_M,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR Compounded Index")
  SEK_SWESTR_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SEK-SWESTR-OIS Compound")
  SEK_SWESTR_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SIBOR")
  SGD_SIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SIBOR-Reference Banks")
  SGD_SIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SIBOR-Reuters")
  SGD_SIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SIBOR-Telerate")
  SGD_SIBOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SONAR-OIS-COMPOUND")
  SGD_SONAR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SONAR-OIS-VWAP-COMPOUND")
  SGD_SONAR_OIS_VWAP_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR")
  SGD_SOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SORA")
  SGD_SORA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SORA-COMPOUND")
  SGD_SORA_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SORA-OIS Compound")
  SGD_SORA_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR-Reference Banks")
  SGD_SOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR-Reuters")
  SGD_SOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR-Telerate")
  SGD_SOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR-VWAP")
  SGD_SOR_VWAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-SOR-VWAP-Reference Banks")
  SGD_SOR_VWAP_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Currency Basis Swap Rate-11:00-Tullett Prebon")
  SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_11_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Currency Basis Swap Rate-16:00-Tullett Prebon")
  SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_16_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-11.00-TRADITION")
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-11:00-Tullett Prebon")
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-16:00-Tullett Prebon")
  SGD_SEMI_ANNUAL_SWAP_RATE_16_00_TULLETT_PREBON,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-ICAP")
  SGD_SEMI_ANNUAL_SWAP_RATE_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-ICAP-Reference Banks")
  SGD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-Reference Banks")
  SGD_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SGD-Semi-Annual Swap Rate-TRADITION-Reference Banks")
  SGD_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SKK-BRIBOR-BRBO")
  SKK_BRIBOR_BRBO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SKK-BRIBOR-Bloomberg")
  SKK_BRIBOR_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SKK-BRIBOR-NBSK07")
  SKK_BRIBOR_NBSK07,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("SKK-BRIBOR-Reference Banks")
  SKK_BRIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-SOR-Reference Banks")
  THB_SOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-SOR-Reuters")
  THB_SOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-SOR-Telerate")
  THB_SOR_TELERATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-Semi-Annual Swap Rate-11:00-BGCANTOR")
  THB_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-Semi-Annual Swap Rate-Reference Banks")
  THB_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THBFIX")
  THB_THBFIX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THBFIX-Reference Banks")
  THB_THBFIX_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THBFIX-Reuters")
  THB_THBFIX_REUTERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THOR")
  THB_THOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THOR-COMPOUND")
  THB_THOR_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("THB-THOR-OIS Compound")
  THB_THOR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY Annual Swap Rate-11:00-TRADITION")
  TRY_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-Annual Swap Rate-11:15-BGCANTOR")
  TRY_ANNUAL_SWAP_RATE_11_15_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-Annual Swap Rate-Reference Banks")
  TRY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-Semi-Annual Swap Rate-TRADITION-Reference Banks")
  TRY_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TLREF")
  TRY_TLREF,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TLREF-OIS-COMPOUND")
  TRY_TLREF_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TLREF-OIS Compound")
  TRY_TLREF_OIS_COMPOUND_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TRLIBOR")
  TRY_TRLIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TRYIBOR-Reference Banks")
  TRY_TRYIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TRY-TRYIBOR-Reuters")
  TRY_TRYIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")
  TWD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-Quarterly-Annual Swap Rate-Reference Banks")
  TWD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-Reference Dealers")
  TWD_REFERENCE_DEALERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-Reuters-6165")
  TWD_REUTERS_6165,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TAIBIR01")
  TWD_TAIBIR01,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TAIBIR02")
  TWD_TAIBIR02,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TAIBOR")
  TWD_TAIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TAIBOR-Bloomberg")
  TWD_TAIBOR_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TAIBOR-Reuters")
  TWD_TAIBOR_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-TWCPBA")
  TWD_TWCPBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("TWD-Telerate-6165")
  TWD_TELERATE_6165,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("UK Base Rate")
  UK_BASE_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-3M LIBOR SWAP-CME vs LCH-ICAP")
  USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-6M LIBOR SWAP-CME vs LCH-ICAP")
  USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AMERIBOR")
  USD_AMERIBOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AMERIBOR Average 30D")
  USD_AMERIBOR_AVERAGE_30_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AMERIBOR Average 90D")
  USD_AMERIBOR_AVERAGE_90_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AMERIBOR Term")
  USD_AMERIBOR_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AMERIBOR Term Structure")
  USD_AMERIBOR_TERM_STRUCTURE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-AXI Term")
  USD_AXI_TERM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Annual Swap Rate-11:00-BGCANTOR")
  USD_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Annual Swap Rate-11:00-TRADITION")
  USD_ANNUAL_SWAP_RATE_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Annual Swap Rate-4:00-TRADITION")
  USD_ANNUAL_SWAP_RATE_4_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-BA-H.15")
  USD_BA_H_15,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-BA-Reference Dealers")
  USD_BA_REFERENCE_DEALERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-BMA Municipal Swap Index")
  USD_BMA_MUNICIPAL_SWAP_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-BSBY")
  USD_BSBY,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CD-H.15")
  USD_CD_H_15,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CD-Reference Dealers")
  USD_CD_REFERENCE_DEALERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMS-Reference Banks")
  USD_CMS_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMS-Reference Banks-ICAP SwapPX")
  USD_CMS_REFERENCE_BANKS_ICAP_SWAP_PX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMS-Reuters")
  USD_CMS_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMS-Telerate")
  USD_CMS_TELERATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMT")
  USD_CMT,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMT Average 1W")
  USD_CMT_AVERAGE_1_W,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMT-T7051")
  USD_CMT_T7051,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CMT-T7052")
  USD_CMT_T7052,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-COF11-FHLBSF")
  USD_COF11_FHLBSF,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-COF11-Reuters")
  USD_COF_11_REUTERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-COF11-Telerate")
  USD_COF_11_TELERATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-COFI")
  USD_COFI,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CP-H.15")
  USD_CP_H_15,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CP-Money Market Yield")
  USD_CP_MONEY_MARKET_YIELD,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CP-Reference Dealers")
  USD_CP_REFERENCE_DEALERS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-CRITR")
  USD_CRITR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-FFCB-DISCO")
  USD_FFCB_DISCO,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-FXI Term")
  USD_FXI_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds")
  USD_FEDERAL_FUNDS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds-H.15")
  USD_FEDERAL_FUNDS_H_15,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds-H.15-Bloomberg")
  USD_FEDERAL_FUNDS_H_15_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds-H.15-OIS-COMPOUND")
  USD_FEDERAL_FUNDS_H_15_OIS_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds-OIS Compound")
  USD_FEDERAL_FUNDS_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Federal Funds-Reference Dealers")
  USD_FEDERAL_FUNDS_REFERENCE_DEALERS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-ISDAFIX3-Swap Rate")
  USD_ISDAFIX_3_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-ISDAFIX3-Swap Rate-3:00")
  USD_ISDAFIX_3_SWAP_RATE_3_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-ISDA-Swap Rate")
  USD_ISDA_SWAP_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-ISDA-Swap Rate-3:00")
  USD_ISDA_SWAP_RATE_3_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR")
  USD_LIBOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR-BBA")
  USD_LIBOR_BBA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR-BBA-Bloomberg")
  USD_LIBOR_BBA_BLOOMBERG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR ICE Swap Rate-11:00")
  USD_LIBOR_ICE_SWAP_RATE_11_00,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR ICE Swap Rate-15:00")
  USD_LIBOR_ICE_SWAP_RATE_15_00,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR-ISDA")
  USD_LIBOR_ISDA,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR-LIBO")
  USD_LIBOR_LIBO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-LIBOR-Reference Banks")
  USD_LIBOR_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Municipal Swap Index")
  USD_MUNICIPAL_SWAP_INDEX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Municipal Swap Libor Ratio-11:00-ICAP")
  USD_MUNICIPAL_SWAP_LIBOR_RATIO_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Municipal Swap Rate-11:00-ICAP")
  USD_MUNICIPAL_SWAP_RATE_11_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-11:00-BGCANTOR")
  USD_OIS_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-11:00-LON-ICAP")
  USD_OIS_11_00_LON_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-11:00-NY-ICAP")
  USD_OIS_11_00_NY_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-11:00-TRADITION")
  USD_OIS_11_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-3:00-BGCANTOR")
  USD_OIS_3_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-3:00-NY-ICAP")
  USD_OIS_3_00_NY_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-OIS-4:00-TRADITION")
  USD_OIS_4_00_TRADITION,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Overnight Bank Funding Rate")
  USD_OVERNIGHT_BANK_FUNDING_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Prime")
  USD_PRIME,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Prime-H.15")
  USD_PRIME_H_15,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Prime-Reference Banks")
  USD_PRIME_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SIBOR-Reference Banks")
  USD_SIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SIBOR-SIBO")
  USD_SIBOR_SIBO,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SIFMA Municipal Swap Index")
  USD_SIFMA_MUNICIPAL_SWAP_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR")
  USD_SOFR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR Average 180D")
  USD_SOFR_AVERAGE_180_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR Average 30D")
  USD_SOFR_AVERAGE_30_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR Average 90D")
  USD_SOFR_AVERAGE_90_D,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR CME Term")
  USD_SOFR_CME_TERM,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR-COMPOUND")
  USD_SOFR_COMPOUND,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR Compounded Index")
  USD_SOFR_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index")
  USD_SOFR_ICE_COMPOUNDED_INDEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index 0 Floor")
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index 0 Floor 2D Lag")
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index 0 Floor 5D Lag")
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index 2D Lag")
  USD_SOFR_ICE_COMPOUNDED_INDEX_2_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Compounded Index 5D Lag")
  USD_SOFR_ICE_COMPOUNDED_INDEX_5_D_LAG,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Swap Rate")
  USD_SOFR_ICE_SWAP_RATE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Swap Rate Spreads")
  USD_SOFR_ICE_SWAP_RATE_SPREADS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR ICE Term")
  USD_SOFR_ICE_TERM,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SOFR-OIS Compound")
  USD_SOFR_OIS_COMPOUND,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-S&P Index-High Grade")
  USD_S_P_INDEX_HIGH_GRADE,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-SandP Index High Grade")
  USD_SAND_P_INDEX_HIGH_GRADE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD Swap Rate-BCMP1")
  USD_SWAP_RATE_BCMP_1,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TBILL Auction High Rate")
  USD_TBILL_AUCTION_HIGH_RATE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TBILL-H.15")
  USD_TBILL_H_15,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TBILL-H.15-Bloomberg")
  USD_TBILL_H_15_BLOOMBERG,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TBILL-Secondary Market")
  USD_TBILL_SECONDARY_MARKET,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TBILL Secondary Market-Bond Equivalent Yield")
  USD_TBILL_SECONDARY_MARKET_BOND_EQUIVALENT_YIELD,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TIBOR-ISDC")
  USD_TIBOR_ISDC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-TIBOR-Reference Banks")
  USD_TIBOR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury-19901-3:00-ICAP")
  USD_TREASURY_19901_3_00_ICAP,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD Treasury Rate-BCMP1")
  USD_TREASURY_RATE_BCMP_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury Rate-ICAP BrokerTec")
  USD_TREASURY_RATE_ICAP_BROKER_TEC,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury Rate-SwapMarker100")
  USD_TREASURY_RATE_SWAP_MARKER_100,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury Rate-SwapMarker99")
  USD_TREASURY_RATE_SWAP_MARKER_99,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury Rate-T19901")
  USD_TREASURY_RATE_T_19901,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("USD-Treasury Rate-T500")
  USD_TREASURY_RATE_T_500,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("VND-Semi-Annual Swap Rate-11:00-BGCANTOR")
  VND_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("VND-Semi-Annual Swap Rate-Reference Banks")
  VND_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-DEPOSIT-Reference Banks")
  ZAR_DEPOSIT_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-DEPOSIT-SAFEX")
  ZAR_DEPOSIT_SAFEX,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-JIBAR")
  ZAR_JIBAR,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-JIBAR-Reference Banks")
  ZAR_JIBAR_REFERENCE_BANKS,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-JIBAR-SAFEX")
  ZAR_JIBAR_SAFEX,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-PRIME-AVERAGE")
  ZAR_PRIME_AVERAGE,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-PRIME-AVERAGE-Reference Banks")
  ZAR_PRIME_AVERAGE_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-Prime Average")
  ZAR_PRIME_AVERAGE_1,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-Quarterly Swap Rate-1:00-TRADITION")
  ZAR_QUARTERLY_SWAP_RATE_1_00_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-Quarterly Swap Rate-5:30-TRADITION")
  ZAR_QUARTERLY_SWAP_RATE_5_30_TRADITION,
  /** 
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-Quarterly Swap Rate-TRADITION-Reference Banks")
  ZAR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-ZARONIA")
  ZAR_ZARONIA,
  /** 
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction. 
   */
  @SerialName("ZAR-ZARONIA-OIS Compound")
  ZAR_ZARONIA_OIS_COMPOUND
  ;
}

/** 
 * This enumeration provides guidance on how to process a given floating rate index.  It's based on the ISDA Floating Rate Index information, but transforms it into the specific categories needed for calculation  
 */
@Serializable
enum class FloatingRateIndexProcessingTypeEnum {
  /** 
   * A published index calculated using compounding; the implied rate must be backed out. 
   */
  @SerialName("COMPOUND_INDEX")
  COMPOUND_INDEX,
  /** 
   * These are calculated by the calculation agent based on deal-specific parameters (e.g. lookback compound based on an RFR). 
   */
  @SerialName("MODULAR")
  MODULAR,
  /** 
   * These are calculated by the calculation agent based on a standard OIS FRO definition. 
   */
  @SerialName("OIS")
  OIS,
  /** 
   * These are calculated by the calculation agent based on a standard overnight averaging FRO definition. 
   */
  @SerialName("OVERNIGHT_AVG")
  OVERNIGHT_AVG,
  /** 
   * These must be looked up using a manual process 
   */
  @SerialName("REF_BANKS")
  REF_BANKS,
  /** 
   * These values are just looked up from the screen and applied. 
   */
  @SerialName("SCREEN")
  SCREEN
  ;
}

/** 
 * Second level ISDA FRO category. 
 */
@Serializable
enum class FloatingRateIndexStyleEnum {
  /** 
   * An ISDA-defined calculated rate done using arithmetic averaging. 
   */
  @SerialName("Average FRO")
  AVERAGE_FRO,
  /** 
   * An ISDA-defined calculated rate done using arithmetic averaging. 
   */
  @SerialName("Compounded FRO")
  COMPOUNDED_FRO,
  /** 
   * A published index calculated using compounding. 
   */
  @SerialName("Compounded Index")
  COMPOUNDED_INDEX,
  /** 
   * A published index using a methodology defined by the publisher, e.g. S&P 500. 
   */
  @SerialName("Index")
  INDEX,
  @SerialName("Other")
  OTHER,
  @SerialName("Overnight Rate")
  OVERNIGHT,
  /** 
   *  A published rate computed using an averaging methodology. 
   */
  @SerialName("Published Average Rate")
  PUBLISHED_AVERAGE,
  @SerialName("Specified Formula")
  SPECIFIED_FORMULA,
  /** 
   * A rate representing the market rate for swaps of a given maturity. 
   */
  @SerialName("Swap Rate")
  SWAP_RATE,
  /** 
   * A rate specified over a given term, such as a libor-type rate. 
   */
  @SerialName("Term Rate")
  TERM_RATE
  ;
}

/** 
 * Represents an enumeration list to identify the fund product type. 
 */
@Serializable
enum class FundProductTypeEnum {
  /** 
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange. 
   */
  @SerialName("EXCHANGE_TRADED_FUND")
  EXCHANGE_TRADED_FUND,
  /** 
   * Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity. 
   */
  @SerialName("MONEY_MARKET_FUND")
  MONEY_MARKET_FUND,
  /** 
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager. 
   */
  @SerialName("MUTUAL_FUND")
  MUTUAL_FUND,
  /** 
   * Denotes a fund that is not an Exchange Traded Fund, Money Market Fund or Mutual Fund. 
   */
  @SerialName("OTHER_FUND")
  OTHER_FUND
  ;
}

/** 
 * The enumerated values to specify the law governing the contract or legal document. 
 */
@Serializable
enum class GoverningLawEnum {
  /** 
   * The Governing Law is determined by reference to the relevant master agreement. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_AGREEMENT")
  AS_SPECIFIED_IN_MASTER_AGREEMENT,
  /** 
   * Belgian law 
   */
  @SerialName("BE")
  BE,
  /** 
   * Alberta law 
   */
  @SerialName("CAAB")
  CAAB,
  /** 
   * British Columbia Law 
   */
  @SerialName("CABC")
  CABC,
  /** 
   * Manitoba law 
   */
  @SerialName("CAMN")
  CAMN,
  /** 
   * Ontario law 
   */
  @SerialName("CAON")
  CAON,
  /** 
   * Quebec law 
   */
  @SerialName("CAQC")
  CAQC,
  /** 
   * German law 
   */
  @SerialName("DE")
  DE,
  /** 
   * French law 
   */
  @SerialName("FR")
  FR,
  /** 
   * English law 
   */
  @SerialName("GBEN")
  GBEN,
  /** 
   * The law of the island of Guernsey 
   */
  @SerialName("GBGY")
  GBGY,
  /** 
   * The law of the Isle of Man 
   */
  @SerialName("GBIM")
  GBIM,
  /** 
   * The law of the island of Jersey 
   */
  @SerialName("GBJY")
  GBJY,
  /** 
   * Scottish law 
   */
  @SerialName("GBSC")
  GBSC,
  /** 
   * Irish law 
   */
  @SerialName("IE")
  IE,
  /** 
   * Japanese law 
   */
  @SerialName("JP")
  JP,
  /** 
   * Luxembourg law 
   */
  @SerialName("LU")
  LU,
  /** 
   * As agreed in the ISDA Master Agreement 
   */
  @SerialName("RELATED_MASTER_AGREEMENT")
  RELATED_MASTER_AGREEMENT,
  /** 
   * Californian law 
   */
  @SerialName("USCA")
  USCA,
  /** 
   * Delaware law 
   */
  @SerialName("USDE")
  USDE,
  /** 
   * Illinois law 
   */
  @SerialName("USIL")
  USIL,
  /** 
   * New York law 
   */
  @SerialName("USNY")
  USNY
  ;
}

/** 
 * Represents the enumeration indicators to specify if an asset or group of assets valuation is based on any valuation treatment haircut. 
 */
@Serializable
enum class HaircutIndicatorEnum {
  /** 
   * Indicates Post haircut value 
   */
  @SerialName("POST_HAIRCUT")
  POST_HAIRCUT,
  /** 
   * Indicates Pre haircut value 
   */
  @SerialName("PRE_HAIRCUT")
  PRE_HAIRCUT
  ;
}

/** 
 * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO). The set of codes in this enumerated list is sourced from ISO Standard 3166 (ISO-3166-1alpha-2)(https://www.iso.org/iso-3166-country-codes.html) as at 14-Aug-23. 
 */
@Serializable
enum class ISOCountryCodeEnum {
  /** 
   * Andorra 
   */
  @SerialName("AD")
  AD,
  /** 
   * United Arab Emirates (the) 
   */
  @SerialName("AE")
  AE,
  /** 
   * Afghanistan 
   */
  @SerialName("AF")
  AF,
  /** 
   * Antigua and Barbuda 
   */
  @SerialName("AG")
  AG,
  /** 
   * Anguilla 
   */
  @SerialName("AI")
  AI,
  /** 
   * Albania 
   */
  @SerialName("AL")
  AL,
  /** 
   * Armenia 
   */
  @SerialName("AM")
  AM,
  /** 
   * Angola 
   */
  @SerialName("AO")
  AO,
  /** 
   * Antarctica 
   */
  @SerialName("AQ")
  AQ,
  /** 
   * Argentina 
   */
  @SerialName("AR")
  AR,
  /** 
   * American Samoa 
   */
  @SerialName("AS")
  AS,
  /** 
   * Austria 
   */
  @SerialName("AT")
  AT,
  /** 
   * Australia 
   */
  @SerialName("AU")
  AU,
  /** 
   * Aruba 
   */
  @SerialName("AW")
  AW,
  /** 
   * Aland Islands 
   */
  @SerialName("AX")
  AX,
  /** 
   * Azerbaijan 
   */
  @SerialName("AZ")
  AZ,
  /** 
   * Bosnia and Herzegovina 
   */
  @SerialName("BA")
  BA,
  /** 
   * Barbados 
   */
  @SerialName("BB")
  BB,
  /** 
   * Bangladesh 
   */
  @SerialName("BD")
  BD,
  /** 
   * Belgium 
   */
  @SerialName("BE")
  BE,
  /** 
   * Burkina Faso 
   */
  @SerialName("BF")
  BF,
  /** 
   * Bulgaria 
   */
  @SerialName("BG")
  BG,
  /** 
   * Bahrain 
   */
  @SerialName("BH")
  BH,
  /** 
   * Burundi 
   */
  @SerialName("BI")
  BI,
  /** 
   * Benin 
   */
  @SerialName("BJ")
  BJ,
  /** 
   * Saint Barthlemy 
   */
  @SerialName("BL")
  BL,
  /** 
   * Bermuda 
   */
  @SerialName("BM")
  BM,
  /** 
   * Brunei Darussalam 
   */
  @SerialName("BN")
  BN,
  /** 
   * Bolivia (Plurinational State of) 
   */
  @SerialName("BO")
  BO,
  /** 
   * Bonaire, Sint Eustatius and Saba 
   */
  @SerialName("BQ")
  BQ,
  /** 
   * Brazil 
   */
  @SerialName("BR")
  BR,
  /** 
   * Bahamas (the) 
   */
  @SerialName("BS")
  BS,
  /** 
   * Bhutan 
   */
  @SerialName("BT")
  BT,
  /** 
   * Bouvet Island 
   */
  @SerialName("BV")
  BV,
  /** 
   * Botswana 
   */
  @SerialName("BW")
  BW,
  /** 
   * Belarus 
   */
  @SerialName("BY")
  BY,
  /** 
   * Belize 
   */
  @SerialName("BZ")
  BZ,
  /** 
   * Canada 
   */
  @SerialName("CA")
  CA,
  /** 
   * Cocos (Keeling) Islands (the) 
   */
  @SerialName("CC")
  CC,
  /** 
   * Congo (the Democratic Republic of the) 
   */
  @SerialName("CD")
  CD,
  /** 
   * Central African Republic (the) 
   */
  @SerialName("CF")
  CF,
  /** 
   * Congo (the) 
   */
  @SerialName("CG")
  CG,
  /** 
   * Switzerland 
   */
  @SerialName("CH")
  CH,
  /** 
   * Cte d'Ivoire 
   */
  @SerialName("CI")
  CI,
  /** 
   * Cook Islands (the) 
   */
  @SerialName("CK")
  CK,
  /** 
   * Chile 
   */
  @SerialName("CL")
  CL,
  /** 
   * Cameroon 
   */
  @SerialName("CM")
  CM,
  /** 
   * China 
   */
  @SerialName("CN")
  CN,
  /** 
   * Colombia 
   */
  @SerialName("CO")
  CO,
  /** 
   * Costa Rica 
   */
  @SerialName("CR")
  CR,
  /** 
   * Cuba 
   */
  @SerialName("CU")
  CU,
  /** 
   * Cabo Verde 
   */
  @SerialName("CV")
  CV,
  /** 
   * Curaao 
   */
  @SerialName("CW")
  CW,
  /** 
   * Christmas Island 
   */
  @SerialName("CX")
  CX,
  /** 
   * Cyprus 
   */
  @SerialName("CY")
  CY,
  /** 
   * Czechia 
   */
  @SerialName("CZ")
  CZ,
  /** 
   * Germany 
   */
  @SerialName("DE")
  DE,
  /** 
   * Djibouti 
   */
  @SerialName("DJ")
  DJ,
  /** 
   * Denmark 
   */
  @SerialName("DK")
  DK,
  /** 
   * Dominica 
   */
  @SerialName("DM")
  DM,
  /** 
   * Dominican Republic (the) 
   */
  @SerialName("DO")
  DO,
  /** 
   * Algeria 
   */
  @SerialName("DZ")
  DZ,
  /** 
   * Ecuador 
   */
  @SerialName("EC")
  EC,
  /** 
   * Estonia 
   */
  @SerialName("EE")
  EE,
  /** 
   * Egypt 
   */
  @SerialName("EG")
  EG,
  /** 
   * Western Sahara* 
   */
  @SerialName("EH")
  EH,
  /** 
   * Eritrea 
   */
  @SerialName("ER")
  ER,
  /** 
   * Spain 
   */
  @SerialName("ES")
  ES,
  /** 
   * Ethiopia 
   */
  @SerialName("ET")
  ET,
  /** 
   * Finland 
   */
  @SerialName("FI")
  FI,
  /** 
   * Fiji 
   */
  @SerialName("FJ")
  FJ,
  /** 
   * Falkland Islands (the) [Malvinas] 
   */
  @SerialName("FK")
  FK,
  /** 
   * Micronesia (Federated States of) 
   */
  @SerialName("FM")
  FM,
  /** 
   * Faroe Islands (the) 
   */
  @SerialName("FO")
  FO,
  /** 
   * France 
   */
  @SerialName("FR")
  FR,
  /** 
   * Gabon 
   */
  @SerialName("GA")
  GA,
  /** 
   * United Kingdom of Great Britain and Northern Ireland (the) 
   */
  @SerialName("GB")
  GB,
  /** 
   * Grenada 
   */
  @SerialName("GD")
  GD,
  /** 
   * Georgia 
   */
  @SerialName("GE")
  GE,
  /** 
   * French Guiana 
   */
  @SerialName("GF")
  GF,
  /** 
   * Guernsey 
   */
  @SerialName("GG")
  GG,
  /** 
   * Ghana 
   */
  @SerialName("GH")
  GH,
  /** 
   * Gibraltar 
   */
  @SerialName("GI")
  GI,
  /** 
   * Greenland 
   */
  @SerialName("GL")
  GL,
  /** 
   * Gambia (the) 
   */
  @SerialName("GM")
  GM,
  /** 
   * Guinea 
   */
  @SerialName("GN")
  GN,
  /** 
   * Guadeloupe 
   */
  @SerialName("GP")
  GP,
  /** 
   * Equatorial Guinea 
   */
  @SerialName("GQ")
  GQ,
  /** 
   * Greece 
   */
  @SerialName("GR")
  GR,
  /** 
   * South Georgia and the South Sandwich Islands 
   */
  @SerialName("GS")
  GS,
  /** 
   * Guatemala 
   */
  @SerialName("GT")
  GT,
  /** 
   * Guam 
   */
  @SerialName("GU")
  GU,
  /** 
   * Guinea-Bissau 
   */
  @SerialName("GW")
  GW,
  /** 
   * Guyana 
   */
  @SerialName("GY")
  GY,
  /** 
   * Hong Kong 
   */
  @SerialName("HK")
  HK,
  /** 
   * Heard Island and McDonald Islands 
   */
  @SerialName("HM")
  HM,
  /** 
   * Honduras 
   */
  @SerialName("HN")
  HN,
  /** 
   * Croatia 
   */
  @SerialName("HR")
  HR,
  /** 
   * Haiti 
   */
  @SerialName("HT")
  HT,
  /** 
   * Hungary 
   */
  @SerialName("HU")
  HU,
  /** 
   * Indonesia 
   */
  @SerialName("ID")
  ID,
  /** 
   * Ireland 
   */
  @SerialName("IE")
  IE,
  /** 
   * Israel 
   */
  @SerialName("IL")
  IL,
  /** 
   * Isle of Man 
   */
  @SerialName("IM")
  IM,
  /** 
   * India 
   */
  @SerialName("IN")
  IN,
  /** 
   * British Indian Ocean Territory (the) 
   */
  @SerialName("IO")
  IO,
  /** 
   * Iraq 
   */
  @SerialName("IQ")
  IQ,
  /** 
   * Iran (Islamic Republic of) 
   */
  @SerialName("IR")
  IR,
  /** 
   * Iceland 
   */
  @SerialName("IS")
  IS,
  /** 
   * Italy 
   */
  @SerialName("IT")
  IT,
  /** 
   * Jersey 
   */
  @SerialName("JE")
  JE,
  /** 
   * Jamaica 
   */
  @SerialName("JM")
  JM,
  /** 
   * Jordan 
   */
  @SerialName("JO")
  JO,
  /** 
   * Japan 
   */
  @SerialName("JP")
  JP,
  /** 
   * Kenya 
   */
  @SerialName("KE")
  KE,
  /** 
   * Kyrgyzstan 
   */
  @SerialName("KG")
  KG,
  /** 
   * Cambodia 
   */
  @SerialName("KH")
  KH,
  /** 
   * Kiribati 
   */
  @SerialName("KI")
  KI,
  /** 
   * Comoros (the) 
   */
  @SerialName("KM")
  KM,
  /** 
   * Saint Kitts and Nevis 
   */
  @SerialName("KN")
  KN,
  /** 
   * Korea (the Democratic People's Republic of) 
   */
  @SerialName("KP")
  KP,
  /** 
   * Korea (the Republic of) 
   */
  @SerialName("KR")
  KR,
  /** 
   * Kuwait 
   */
  @SerialName("KW")
  KW,
  /** 
   * Cayman Islands (the) 
   */
  @SerialName("KY")
  KY,
  /** 
   * Kazakhstan 
   */
  @SerialName("KZ")
  KZ,
  /** 
   * Lao People's Democratic Republic (the) 
   */
  @SerialName("LA")
  LA,
  /** 
   * Lebanon 
   */
  @SerialName("LB")
  LB,
  /** 
   * Saint Lucia 
   */
  @SerialName("LC")
  LC,
  /** 
   * Liechtenstein 
   */
  @SerialName("LI")
  LI,
  /** 
   * Sri Lanka 
   */
  @SerialName("LK")
  LK,
  /** 
   * Liberia 
   */
  @SerialName("LR")
  LR,
  /** 
   * Lesotho 
   */
  @SerialName("LS")
  LS,
  /** 
   * Lithuania 
   */
  @SerialName("LT")
  LT,
  /** 
   * Luxembourg 
   */
  @SerialName("LU")
  LU,
  /** 
   * Latvia 
   */
  @SerialName("LV")
  LV,
  /** 
   * Libya 
   */
  @SerialName("LY")
  LY,
  /** 
   * Morocco 
   */
  @SerialName("MA")
  MA,
  /** 
   * Monaco 
   */
  @SerialName("MC")
  MC,
  /** 
   * Moldova (the Republic of) 
   */
  @SerialName("MD")
  MD,
  /** 
   * Montenegro 
   */
  @SerialName("ME")
  ME,
  /** 
   * Saint Martin (French part) 
   */
  @SerialName("MF")
  MF,
  /** 
   * Madagascar 
   */
  @SerialName("MG")
  MG,
  /** 
   * Marshall Islands (the) 
   */
  @SerialName("MH")
  MH,
  /** 
   * North Macedonia 
   */
  @SerialName("MK")
  MK,
  /** 
   * Mali 
   */
  @SerialName("ML")
  ML,
  /** 
   * Myanmar 
   */
  @SerialName("MM")
  MM,
  /** 
   * Mongolia 
   */
  @SerialName("MN")
  MN,
  /** 
   * Macao 
   */
  @SerialName("MO")
  MO,
  /** 
   * Northern Mariana Islands (the) 
   */
  @SerialName("MP")
  MP,
  /** 
   * Martinique 
   */
  @SerialName("MQ")
  MQ,
  /** 
   * Mauritania 
   */
  @SerialName("MR")
  MR,
  /** 
   * Montserrat 
   */
  @SerialName("MS")
  MS,
  /** 
   * Malta 
   */
  @SerialName("MT")
  MT,
  /** 
   * Mauritius 
   */
  @SerialName("MU")
  MU,
  /** 
   * Maldives 
   */
  @SerialName("MV")
  MV,
  /** 
   * Malawi 
   */
  @SerialName("MW")
  MW,
  /** 
   * Mexico 
   */
  @SerialName("MX")
  MX,
  /** 
   * Malaysia 
   */
  @SerialName("MY")
  MY,
  /** 
   * Mozambique 
   */
  @SerialName("MZ")
  MZ,
  /** 
   * Namibia 
   */
  @SerialName("NA")
  NA,
  /** 
   * New Caledonia 
   */
  @SerialName("NC")
  NC,
  /** 
   * Niger (the) 
   */
  @SerialName("NE")
  NE,
  /** 
   * Norfolk Island 
   */
  @SerialName("NF")
  NF,
  /** 
   * Nigeria 
   */
  @SerialName("NG")
  NG,
  /** 
   * Nicaragua 
   */
  @SerialName("NI")
  NI,
  /** 
   * Netherlands (Kingdom of the) 
   */
  @SerialName("NL")
  NL,
  /** 
   * Norway 
   */
  @SerialName("NO")
  NO,
  /** 
   * Nepal 
   */
  @SerialName("NP")
  NP,
  /** 
   * Nauru 
   */
  @SerialName("NR")
  NR,
  /** 
   * Niue 
   */
  @SerialName("NU")
  NU,
  /** 
   * New Zealand 
   */
  @SerialName("NZ")
  NZ,
  /** 
   * Oman 
   */
  @SerialName("OM")
  OM,
  /** 
   * Panama 
   */
  @SerialName("PA")
  PA,
  /** 
   * Peru 
   */
  @SerialName("PE")
  PE,
  /** 
   * French Polynesia 
   */
  @SerialName("PF")
  PF,
  /** 
   * Papua New Guinea 
   */
  @SerialName("PG")
  PG,
  /** 
   * Philippines (the) 
   */
  @SerialName("PH")
  PH,
  /** 
   * Pakistan 
   */
  @SerialName("PK")
  PK,
  /** 
   * Poland 
   */
  @SerialName("PL")
  PL,
  /** 
   * Saint Pierre and Miquelon 
   */
  @SerialName("PM")
  PM,
  /** 
   * Pitcairn 
   */
  @SerialName("PN")
  PN,
  /** 
   * Puerto Rico 
   */
  @SerialName("PR")
  PR,
  /** 
   * Palestine, State of 
   */
  @SerialName("PS")
  PS,
  /** 
   * Portugal 
   */
  @SerialName("PT")
  PT,
  /** 
   * Palau 
   */
  @SerialName("PW")
  PW,
  /** 
   * Paraguay 
   */
  @SerialName("PY")
  PY,
  /** 
   * Qatar 
   */
  @SerialName("QA")
  QA,
  /** 
   * Runion 
   */
  @SerialName("RE")
  RE,
  /** 
   * Romania 
   */
  @SerialName("RO")
  RO,
  /** 
   * Serbia 
   */
  @SerialName("RS")
  RS,
  /** 
   * Russian Federation (the) 
   */
  @SerialName("RU")
  RU,
  /** 
   * Rwanda 
   */
  @SerialName("RW")
  RW,
  /** 
   * Saudi Arabia 
   */
  @SerialName("SA")
  SA,
  /** 
   * Solomon Islands 
   */
  @SerialName("SB")
  SB,
  /** 
   * Seychelles 
   */
  @SerialName("SC")
  SC,
  /** 
   * Sudan (the) 
   */
  @SerialName("SD")
  SD,
  /** 
   * Sweden 
   */
  @SerialName("SE")
  SE,
  /** 
   * Singapore 
   */
  @SerialName("SG")
  SG,
  /** 
   * Saint Helena, Ascension and Tristan da Cunha 
   */
  @SerialName("SH")
  SH,
  /** 
   * Slovenia 
   */
  @SerialName("SI")
  SI,
  /** 
   * Svalbard and Jan Mayen 
   */
  @SerialName("SJ")
  SJ,
  /** 
   * Slovakia 
   */
  @SerialName("SK")
  SK,
  /** 
   * Sierra Leone 
   */
  @SerialName("SL")
  SL,
  /** 
   * San Marino 
   */
  @SerialName("SM")
  SM,
  /** 
   * Senegal 
   */
  @SerialName("SN")
  SN,
  /** 
   * Somalia 
   */
  @SerialName("SO")
  SO,
  /** 
   * Suriname 
   */
  @SerialName("SR")
  SR,
  /** 
   * South Sudan 
   */
  @SerialName("SS")
  SS,
  /** 
   * Sao Tome and Principe 
   */
  @SerialName("ST")
  ST,
  /** 
   * El Salvador 
   */
  @SerialName("SV")
  SV,
  /** 
   * Sint Maarten (Dutch part) 
   */
  @SerialName("SX")
  SX,
  /** 
   * Syrian Arab Republic (the) 
   */
  @SerialName("SY")
  SY,
  /** 
   * Eswatini 
   */
  @SerialName("SZ")
  SZ,
  /** 
   * Turks and Caicos Islands (the) 
   */
  @SerialName("TC")
  TC,
  /** 
   * Chad 
   */
  @SerialName("TD")
  TD,
  /** 
   * French Southern Territories (the) 
   */
  @SerialName("TF")
  TF,
  /** 
   * Togo 
   */
  @SerialName("TG")
  TG,
  /** 
   * Thailand 
   */
  @SerialName("TH")
  TH,
  /** 
   * Tajikistan 
   */
  @SerialName("TJ")
  TJ,
  /** 
   * Tokelau 
   */
  @SerialName("TK")
  TK,
  /** 
   * Timor-Leste 
   */
  @SerialName("TL")
  TL,
  /** 
   * Turkmenistan 
   */
  @SerialName("TM")
  TM,
  /** 
   * Tunisia 
   */
  @SerialName("TN")
  TN,
  /** 
   * Tonga 
   */
  @SerialName("TO")
  TO,
  /** 
   * Trkiye 
   */
  @SerialName("TR")
  TR,
  /** 
   * Trinidad and Tobago 
   */
  @SerialName("TT")
  TT,
  /** 
   * Tuvalu 
   */
  @SerialName("TV")
  TV,
  /** 
   * Taiwan (Province of China) 
   */
  @SerialName("TW")
  TW,
  /** 
   * Tanzania, the United Republic of 
   */
  @SerialName("TZ")
  TZ,
  /** 
   * Ukraine 
   */
  @SerialName("UA")
  UA,
  /** 
   * Uganda 
   */
  @SerialName("UG")
  UG,
  /** 
   * United States Minor Outlying Islands (the) 
   */
  @SerialName("UM")
  UM,
  /** 
   * United States of America (the) 
   */
  @SerialName("US")
  US,
  /** 
   * Uruguay 
   */
  @SerialName("UY")
  UY,
  /** 
   * Uzbekistan 
   */
  @SerialName("UZ")
  UZ,
  /** 
   * Holy See (the) 
   */
  @SerialName("VA")
  VA,
  /** 
   * Saint Vincent and the Grenadines 
   */
  @SerialName("VC")
  VC,
  /** 
   * Venezuela (Bolivarian Republic of) 
   */
  @SerialName("VE")
  VE,
  /** 
   * Virgin Islands (British) 
   */
  @SerialName("VG")
  VG,
  /** 
   * Virgin Islands (U.S.) 
   */
  @SerialName("VI")
  VI,
  /** 
   * Viet Nam 
   */
  @SerialName("VN")
  VN,
  /** 
   * Vanuatu 
   */
  @SerialName("VU")
  VU,
  /** 
   * Wallis and Futuna 
   */
  @SerialName("WF")
  WF,
  /** 
   * Samoa 
   */
  @SerialName("WS")
  WS,
  /** 
   * Yemen 
   */
  @SerialName("YE")
  YE,
  /** 
   * Mayotte 
   */
  @SerialName("YT")
  YT,
  /** 
   * South Africa 
   */
  @SerialName("ZA")
  ZA,
  /** 
   * Zambia 
   */
  @SerialName("ZM")
  ZM,
  /** 
   * Zimbabwe 
   */
  @SerialName("ZW")
  ZW
  ;
}

/** 
 * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO).  The set of codes in this enumerated list is sourced from ISO Standard 4217 (https://www.currency-iso.org/en/home/tables/table-a1.html), as of 29-Aug-18. 
 */
@Serializable
enum class ISOCurrencyCodeEnum {
  /** 
   * UAE Dirham 
   */
  @SerialName("AED")
  AED,
  /** 
   * Afghani 
   */
  @SerialName("AFN")
  AFN,
  /** 
   * Lek 
   */
  @SerialName("ALL")
  ALL,
  /** 
   * Armenian Dram 
   */
  @SerialName("AMD")
  AMD,
  /** 
   * Netherlands Antillean Guilder 
   */
  @SerialName("ANG")
  ANG,
  /** 
   * Kwanza 
   */
  @SerialName("AOA")
  AOA,
  /** 
   * Argentine Peso 
   */
  @SerialName("ARS")
  ARS,
  /** 
   * Australian Dollar 
   */
  @SerialName("AUD")
  AUD,
  /** 
   * Aruban Florin 
   */
  @SerialName("AWG")
  AWG,
  /** 
   * Azerbaijan Manat 
   */
  @SerialName("AZN")
  AZN,
  /** 
   * Convertible Mark 
   */
  @SerialName("BAM")
  BAM,
  /** 
   * Barbados Dollar 
   */
  @SerialName("BBD")
  BBD,
  /** 
   * Taka 
   */
  @SerialName("BDT")
  BDT,
  /** 
   * Bulgarian Lev 
   */
  @SerialName("BGN")
  BGN,
  /** 
   * Bahraini Dinar 
   */
  @SerialName("BHD")
  BHD,
  /** 
   * Burundi Franc 
   */
  @SerialName("BIF")
  BIF,
  /** 
   * Bermudian Dollar 
   */
  @SerialName("BMD")
  BMD,
  /** 
   * Brunei Dollar 
   */
  @SerialName("BND")
  BND,
  /** 
   * Boliviano 
   */
  @SerialName("BOB")
  BOB,
  /** 
   * Mvdol 
   */
  @SerialName("BOV")
  BOV,
  /** 
   * Brazilian Real 
   */
  @SerialName("BRL")
  BRL,
  /** 
   * Bahamian Dollar 
   */
  @SerialName("BSD")
  BSD,
  /** 
   * Ngultrum 
   */
  @SerialName("BTN")
  BTN,
  /** 
   * Pula 
   */
  @SerialName("BWP")
  BWP,
  /** 
   * Belarusian Ruble 
   */
  @SerialName("BYN")
  BYN,
  /** 
   * Belize Dollar 
   */
  @SerialName("BZD")
  BZD,
  /** 
   * Canadian Dollar 
   */
  @SerialName("CAD")
  CAD,
  /** 
   * Congolese Franc 
   */
  @SerialName("CDF")
  CDF,
  /** 
   * WIR Euro 
   */
  @SerialName("CHE")
  CHE,
  /** 
   * Swiss Franc 
   */
  @SerialName("CHF")
  CHF,
  /** 
   * WIR Franc 
   */
  @SerialName("CHW")
  CHW,
  /** 
   * Unidad de Fomento 
   */
  @SerialName("CLF")
  CLF,
  /** 
   * Chilean Peso 
   */
  @SerialName("CLP")
  CLP,
  /** 
   * Yuan Renminbi 
   */
  @SerialName("CNY")
  CNY,
  /** 
   * Colombian Peso 
   */
  @SerialName("COP")
  COP,
  /** 
   * Unidad de Valor Real 
   */
  @SerialName("COU")
  COU,
  /** 
   * Costa Rican Colon 
   */
  @SerialName("CRC")
  CRC,
  /** 
   * Peso Convertible 
   */
  @SerialName("CUC")
  CUC,
  /** 
   * Cuban Peso 
   */
  @SerialName("CUP")
  CUP,
  /** 
   * Cabo Verde Escudo 
   */
  @SerialName("CVE")
  CVE,
  /** 
   * Czech Koruna 
   */
  @SerialName("CZK")
  CZK,
  /** 
   * Djibouti Franc 
   */
  @SerialName("DJF")
  DJF,
  /** 
   * Danish Krone 
   */
  @SerialName("DKK")
  DKK,
  /** 
   * Dominican Peso 
   */
  @SerialName("DOP")
  DOP,
  /** 
   * Algerian Dinar 
   */
  @SerialName("DZD")
  DZD,
  /** 
   * Egyptian Pound 
   */
  @SerialName("EGP")
  EGP,
  /** 
   * Nakfa 
   */
  @SerialName("ERN")
  ERN,
  /** 
   * Ethiopian Birr 
   */
  @SerialName("ETB")
  ETB,
  /** 
   * Euro 
   */
  @SerialName("EUR")
  EUR,
  /** 
   * Fiji Dollar 
   */
  @SerialName("FJD")
  FJD,
  /** 
   * Falkland Islands Pound 
   */
  @SerialName("FKP")
  FKP,
  /** 
   * Pound Sterling 
   */
  @SerialName("GBP")
  GBP,
  /** 
   * Lari 
   */
  @SerialName("GEL")
  GEL,
  /** 
   * Ghana Cedi 
   */
  @SerialName("GHS")
  GHS,
  /** 
   * Gibraltar Pound 
   */
  @SerialName("GIP")
  GIP,
  /** 
   * Dalasi 
   */
  @SerialName("GMD")
  GMD,
  /** 
   * Guinean Franc 
   */
  @SerialName("GNF")
  GNF,
  /** 
   * Quetzal 
   */
  @SerialName("GTQ")
  GTQ,
  /** 
   * Guyana Dollar 
   */
  @SerialName("GYD")
  GYD,
  /** 
   * Hong Kong Dollar 
   */
  @SerialName("HKD")
  HKD,
  /** 
   * Lempira 
   */
  @SerialName("HNL")
  HNL,
  /** 
   * Gourde 
   */
  @SerialName("HTG")
  HTG,
  /** 
   * Forint 
   */
  @SerialName("HUF")
  HUF,
  /** 
   * Rupiah 
   */
  @SerialName("IDR")
  IDR,
  /** 
   * New Israeli Sheqel 
   */
  @SerialName("ILS")
  ILS,
  /** 
   * Indian Rupee 
   */
  @SerialName("INR")
  INR,
  /** 
   * Iraqi Dinar 
   */
  @SerialName("IQD")
  IQD,
  /** 
   * Iranian Rial 
   */
  @SerialName("IRR")
  IRR,
  /** 
   * Iceland Krona 
   */
  @SerialName("ISK")
  ISK,
  /** 
   * Jamaican Dollar 
   */
  @SerialName("JMD")
  JMD,
  /** 
   * Jordanian Dinar 
   */
  @SerialName("JOD")
  JOD,
  /** 
   * Yen 
   */
  @SerialName("JPY")
  JPY,
  /** 
   * Kenyan Shilling 
   */
  @SerialName("KES")
  KES,
  /** 
   * Som 
   */
  @SerialName("KGS")
  KGS,
  /** 
   * Riel 
   */
  @SerialName("KHR")
  KHR,
  /** 
   * Comorian Franc  
   */
  @SerialName("KMF")
  KMF,
  /** 
   * North Korean Won 
   */
  @SerialName("KPW")
  KPW,
  /** 
   * Won 
   */
  @SerialName("KRW")
  KRW,
  /** 
   * Kuwaiti Dinar 
   */
  @SerialName("KWD")
  KWD,
  /** 
   * Cayman Islands Dollar 
   */
  @SerialName("KYD")
  KYD,
  /** 
   * Tenge 
   */
  @SerialName("KZT")
  KZT,
  /** 
   * Lao Kip 
   */
  @SerialName("LAK")
  LAK,
  /** 
   * Lebanese Pound 
   */
  @SerialName("LBP")
  LBP,
  /** 
   * Sri Lanka Rupee 
   */
  @SerialName("LKR")
  LKR,
  /** 
   * Liberian Dollar 
   */
  @SerialName("LRD")
  LRD,
  /** 
   * Loti 
   */
  @SerialName("LSL")
  LSL,
  /** 
   * Libyan Dinar 
   */
  @SerialName("LYD")
  LYD,
  /** 
   * Moroccan Dirham 
   */
  @SerialName("MAD")
  MAD,
  /** 
   * Moldovan Leu 
   */
  @SerialName("MDL")
  MDL,
  /** 
   * Malagasy Ariary 
   */
  @SerialName("MGA")
  MGA,
  /** 
   * Denar 
   */
  @SerialName("MKD")
  MKD,
  /** 
   * Kyat 
   */
  @SerialName("MMK")
  MMK,
  /** 
   * Tugrik 
   */
  @SerialName("MNT")
  MNT,
  /** 
   * Pataca 
   */
  @SerialName("MOP")
  MOP,
  /** 
   * Ouguiya 
   */
  @SerialName("MRU")
  MRU,
  /** 
   * Mauritius Rupee 
   */
  @SerialName("MUR")
  MUR,
  /** 
   * Rufiyaa 
   */
  @SerialName("MVR")
  MVR,
  /** 
   * Malawi Kwacha 
   */
  @SerialName("MWK")
  MWK,
  /** 
   * Mexican Peso 
   */
  @SerialName("MXN")
  MXN,
  /** 
   * Mexican Unidad de Inversion (UDI) 
   */
  @SerialName("MXV")
  MXV,
  /** 
   * Malaysian Ringgit 
   */
  @SerialName("MYR")
  MYR,
  /** 
   * Mozambique Metical 
   */
  @SerialName("MZN")
  MZN,
  /** 
   * Namibia Dollar 
   */
  @SerialName("NAD")
  NAD,
  /** 
   * Naira 
   */
  @SerialName("NGN")
  NGN,
  /** 
   * Cordoba Oro 
   */
  @SerialName("NIO")
  NIO,
  /** 
   * Norwegian Krone 
   */
  @SerialName("NOK")
  NOK,
  /** 
   * Nepalese Rupee 
   */
  @SerialName("NPR")
  NPR,
  /** 
   * New Zealand Dollar 
   */
  @SerialName("NZD")
  NZD,
  /** 
   * Rial Omani 
   */
  @SerialName("OMR")
  OMR,
  /** 
   * Balboa 
   */
  @SerialName("PAB")
  PAB,
  /** 
   * Sol 
   */
  @SerialName("PEN")
  PEN,
  /** 
   * Kina 
   */
  @SerialName("PGK")
  PGK,
  /** 
   * Philippine Peso 
   */
  @SerialName("PHP")
  PHP,
  /** 
   * Pakistan Rupee 
   */
  @SerialName("PKR")
  PKR,
  /** 
   * Zloty 
   */
  @SerialName("PLN")
  PLN,
  /** 
   * Guarani 
   */
  @SerialName("PYG")
  PYG,
  /** 
   * Qatari Rial 
   */
  @SerialName("QAR")
  QAR,
  /** 
   * Romanian Leu 
   */
  @SerialName("RON")
  RON,
  /** 
   * Serbian Dinar 
   */
  @SerialName("RSD")
  RSD,
  /** 
   * Russian Ruble 
   */
  @SerialName("RUB")
  RUB,
  /** 
   * Rwanda Franc 
   */
  @SerialName("RWF")
  RWF,
  /** 
   * Saudi Riyal 
   */
  @SerialName("SAR")
  SAR,
  /** 
   * Solomon Islands Dollar 
   */
  @SerialName("SBD")
  SBD,
  /** 
   * Seychelles Rupee 
   */
  @SerialName("SCR")
  SCR,
  /** 
   * Sudanese Pound 
   */
  @SerialName("SDG")
  SDG,
  /** 
   * Swedish Krona 
   */
  @SerialName("SEK")
  SEK,
  /** 
   * Singapore Dollar 
   */
  @SerialName("SGD")
  SGD,
  /** 
   * Saint Helena Pound 
   */
  @SerialName("SHP")
  SHP,
  /** 
   * Leone 
   */
  @SerialName("SLE")
  SLE,
  /** 
   * Somali Shilling 
   */
  @SerialName("SOS")
  SOS,
  /** 
   * Surinam Dollar 
   */
  @SerialName("SRD")
  SRD,
  /** 
   * South Sudanese Pound 
   */
  @SerialName("SSP")
  SSP,
  /** 
   * Dobra 
   */
  @SerialName("STN")
  STN,
  /** 
   * El Salvador Colon 
   */
  @SerialName("SVC")
  SVC,
  /** 
   * Syrian Pound 
   */
  @SerialName("SYP")
  SYP,
  /** 
   * Lilangeni 
   */
  @SerialName("SZL")
  SZL,
  /** 
   * Baht 
   */
  @SerialName("THB")
  THB,
  /** 
   * Somoni 
   */
  @SerialName("TJS")
  TJS,
  /** 
   * Turkmenistan New Manat 
   */
  @SerialName("TMT")
  TMT,
  /** 
   * Tunisian Dinar 
   */
  @SerialName("TND")
  TND,
  /** 
   * Pa’anga 
   */
  @SerialName("TOP")
  TOP,
  /** 
   * Turkish Lira 
   */
  @SerialName("TRY")
  TRY,
  /** 
   * Trinidad and Tobago Dollar 
   */
  @SerialName("TTD")
  TTD,
  /** 
   * New Taiwan Dollar 
   */
  @SerialName("TWD")
  TWD,
  /** 
   * Tanzanian Shilling 
   */
  @SerialName("TZS")
  TZS,
  /** 
   * Hryvnia 
   */
  @SerialName("UAH")
  UAH,
  /** 
   * Uganda Shilling 
   */
  @SerialName("UGX")
  UGX,
  /** 
   * US Dollar 
   */
  @SerialName("USD")
  USD,
  /** 
   * US Dollar (Next day) 
   */
  @SerialName("USN")
  USN,
  /** 
   * Uruguay Peso en Unidades Indexadas (UI) 
   */
  @SerialName("UYI")
  UYI,
  /** 
   * Peso Uruguayo 
   */
  @SerialName("UYU")
  UYU,
  /** 
   * Unidad Previsional 
   */
  @SerialName("UYW")
  UYW,
  /** 
   * Uzbekistan Sum 
   */
  @SerialName("UZS")
  UZS,
  /** 
   * Bolívar Soberano 
   */
  @SerialName("VED")
  VED,
  /** 
   * Bolívar Soberano 
   */
  @SerialName("VES")
  VES,
  /** 
   * Dong 
   */
  @SerialName("VND")
  VND,
  /** 
   * Vatu 
   */
  @SerialName("VUV")
  VUV,
  /** 
   * Tala 
   */
  @SerialName("WST")
  WST,
  /** 
   * CFA Franc BEAC 
   */
  @SerialName("XAF")
  XAF,
  /** 
   * Silver 
   */
  @SerialName("XAG")
  XAG,
  /** 
   * Gold 
   */
  @SerialName("XAU")
  XAU,
  /** 
   * Bond Markets Unit European Composite Unit (EURCO) 
   */
  @SerialName("XBA")
  XBA,
  /** 
   * Bond Markets Unit European Monetary Unit (E.M.U.-6) 
   */
  @SerialName("XBB")
  XBB,
  /** 
   * Bond Markets Unit European Unit of Account 9 (E.U.A.-9) 
   */
  @SerialName("XBC")
  XBC,
  /** 
   * Bond Markets Unit European Unit of Account 17 (E.U.A.-17) 
   */
  @SerialName("XBD")
  XBD,
  /** 
   * East Caribbean Dollar 
   */
  @SerialName("XCD")
  XCD,
  /** 
   * SDR (Special Drawing Right) 
   */
  @SerialName("XDR")
  XDR,
  /** 
   * CFA Franc BCEAO 
   */
  @SerialName("XOF")
  XOF,
  /** 
   * Palladium 
   */
  @SerialName("XPD")
  XPD,
  /** 
   * CFP Franc 
   */
  @SerialName("XPF")
  XPF,
  /** 
   * Platinum 
   */
  @SerialName("XPT")
  XPT,
  /** 
   * Sucre 
   */
  @SerialName("XSU")
  XSU,
  /** 
   * Codes specifically reserved for testing purposes 
   */
  @SerialName("XTS")
  XTS,
  /** 
   * ADB Unit of Account 
   */
  @SerialName("XUA")
  XUA,
  /** 
   * The codes assigned for transactions where no currency is involved 
   */
  @SerialName("XXX")
  XXX,
  /** 
   * Yemeni Rial 
   */
  @SerialName("YER")
  YER,
  /** 
   * Rand 
   */
  @SerialName("ZAR")
  ZAR,
  /** 
   * Zambian Kwacha 
   */
  @SerialName("ZMW")
  ZMW,
  /** 
   * Zimbabwe Gold 
   */
  @SerialName("ZWG")
  ZWG
  ;
}

/** 
 * The enumerated values to specify the CDX index annex source. 
 */
@Serializable
enum class IndexAnnexSourceEnum {
  /** 
   * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices. 
   */
  @SerialName("MASTER_CONFIRMATION")
  MASTER_CONFIRMATION,
  /** 
   * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices. 
   */
  @SerialName("PUBLISHER")
  PUBLISHER
  ;
}

/** 
 * The enumerated values to specify the consequences of Index Events. 
 */
@Serializable
enum class IndexEventConsequenceEnum {
  /** 
   * Calculation Agent Adjustment. 
   */
  @SerialName("CALCULATION_AGENT_ADJUSTMENT")
  CALCULATION_AGENT_ADJUSTMENT,
  /** 
   * Cancellation and Payment. 
   */
  @SerialName("CANCELLATION_AND_PAYMENT")
  CANCELLATION_AND_PAYMENT,
  /** 
   * Negotiated Close Out. 
   */
  @SerialName("NEGOTIATED_CLOSE_OUT")
  NEGOTIATED_CLOSE_OUT,
  /** 
   * Related Exchange. 
   */
  @SerialName("RELATED_EXCHANGE")
  RELATED_EXCHANGE
  ;
}

/** 
 * Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap 
 */
@Serializable
enum class InflationCalculationMethodEnum {
  /** 
   * (Inflation Index Final / Inflation Index Base). Inflation Index Final is inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interpolation). Inflation Index Base subject to the Calculation Style. Used in inflation asset swaps to calculate the inflation coupons and principal exchange. 
   */
  @SerialName("RATIO")
  RATIO,
  /** 
   * (Inflation Index Final / Inflation Index Base -1). Inflation Index Final is the inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Used in market standard ZC Inflation swaps. 
   */
  @SerialName("RETURN")
  RETURN,
  /** 
   * Inflation Index Final - Inflation Index Base). Inflation Index Final is Index for Ref month the Lag months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Typically used for fixing locks. 
   */
  @SerialName("SPREAD")
  SPREAD
  ;
}

/** 
 * Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon). 
 */
@Serializable
enum class InflationCalculationStyleEnum {
  /** 
   * YearOnYear means Inflation Index Base is the inflation index for Reference Month that is 12 months prior to Inflation Index Final (subject to interpolation). Inflation Index Base is cashflow dependent. 
   */
  @SerialName("YEAR_ON_YEAR")
  YEAR_ON_YEAR,
  /** 
   * ZeroCoupon means Inflation Index Base used in the CalculationMethod is the inflation index for the Reference Month that is the lag number of months prior to Effective Date in the case of a swap, or Bond Interest Accrual Date in the case of an Asset Swap (subject to interpolation). Inflation Index Base has the same value for each inflation cashflow and Principal Exchange calculation within the trade. 
   */
  @SerialName("ZERO_COUPON")
  ZERO_COUPON
  ;
}

/** 
 * The enumerated values to specify the list of inflation rate indices. 
 */
@Serializable
enum class InflationRateIndexEnum {
  /** 
   * Australia: AUD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("AUD-CPI")
  AUD_CPI,
  /** 
   * Austria: AUS - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("AUS-CPI")
  AUS_CPI,
  /** 
   * Austria: AUS - Non-revised Harmonised Indices of Consumer Prices (HICP) 
   */
  @SerialName("AUS-HICP")
  AUS_HICP,
  /** 
   * Belgium: BLG - Non-revised Consumer Price Index - General Index (CPI) 
   */
  @SerialName("BLG-CPI-GI")
  BLG_CPI_GI,
  /** 
   * Belgium: BLG - Non-revised Consumer Price Index - Health Index (CPI) 
   */
  @SerialName("BLG-CPI-HI")
  BLG_CPI_HI,
  /** 
   * Belgium: BLG - Non-revised Harmonised Consumer Price Index (HICP) 
   */
  @SerialName("BLG-HICP")
  BLG_HICP,
  /** 
   * Brazil: BRL - Non-revised Price Index (IGP-M) 
   */
  @SerialName("BRL-IGPM")
  BRL_IGPM,
  /** 
   * Brazil: BRL - Non-revised Consumer Price Index (IPCA) 
   */
  @SerialName("BRL-IPCA")
  BRL_IPCA,
  /** 
   * Canada: CAD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("CAD-CPI")
  CAD_CPI,
  /** 
   * Chile: CLP - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("CLP-CPI")
  CLP_CPI,
  /** 
   * China: CNY - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("CNY-CPI")
  CNY_CPI,
  /** 
   * Czech Republic: CZK - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("CZK-CPI")
  CZK_CPI,
  /** 
   * Denmark: DEK - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("DEK-CPI")
  DEK_CPI,
  /** 
   * Denmark: DEK - Non-revised Harmonised Consumer Price Index (HICP) 
   */
  @SerialName("DEK-HICP")
  DEK_HICP,
  /** 
   * Germany: DEM - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("DEM-CPI")
  DEM_CPI,
  /** 
   * Germany: DEM - Non-revised Consumer Price Index for North Rhine-Westphalia 
   */
  @SerialName("DEM-CPI-NRW")
  DEM_CPI_NRW,
  /** 
   * Germany: DEM - Non-revised Harmonised Consumer Price Index (HICP) 
   */
  @SerialName("DEM-HICP")
  DEM_HICP,
  /** 
   * Spain: ESP - National-Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("ESP-CPI")
  ESP_CPI,
  /** 
   * Spain: ESP - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("ESP-HICP")
  ESP_HICP,
  /** 
   * Spain: ESP - National-Revised Consumer Price Index (CPI). 
   */
  @SerialName("ESP-R-CPI")
  ESP_R_CPI,
  /** 
   * Spain: ESP - Harmonised-Revised Consumer Price Index (HICP) 
   */
  @SerialName("ESP-R-HICP")
  ESP_R_HICP,
  /** 
   * European Union: EUR - All Items-Non-revised Consumer Price Index 
   */
  @SerialName("EUR-AI-CPI")
  EUR_AI_CPI,
  /** 
   * European Union: EUR - All Items-Revised Consumer Price Index 
   */
  @SerialName("EUR-AI-R-CPI")
  EUR_AI_R_CPI,
  /** 
   * European Union: EUR - Excluding Tobacco-Non-revised Consumer Price Index 
   */
  @SerialName("EUR-EXT-CPI")
  EUR_EXT_CPI,
  /** 
   * European Union: EUR - Excluding Tobacco-Revised Consumer Price Index 
   */
  @SerialName("EUR-EXT-R-CPI")
  EUR_EXT_R_CPI,
  /** 
   * Finland: FIN - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("FIN-CPI")
  FIN_CPI,
  /** 
   * Finland: FIN - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("FIN-HICP")
  FIN_HICP,
  /** 
   * France: FRC - Excluding Tobacco-Non-Revised Consumer Price Index 
   */
  @SerialName("FRC-EXT-CPI")
  FRC_EXT_CPI,
  /** 
   * France: FRC - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("FRC-HICP")
  FRC_HICP,
  /** 
   * Greece: GRD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("GRD-CPI")
  GRD_CPI,
  /** 
   * Greece: GRD - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("GRD-HICP")
  GRD_HICP,
  /** 
   * Hong Kong: HKD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("HKD-CPI")
  HKD_CPI,
  /** 
   * Hungary: HUF - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("HUF-CPI")
  HUF_CPI,
  /** 
   * Indonesia: IDR - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("IDR-CPI")
  IDR_CPI,
  /** 
   * Israel: ILS - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("ILS-CPI")
  ILS_CPI,
  /** 
   * Ireland: IRL - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("IRL-CPI")
  IRL_CPI,
  /** 
   * Ireland: IRL - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("IRL-HICP")
  IRL_HICP,
  /** 
   * Iceland: ISK - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("ISK-CPI")
  ISK_CPI,
  /** 
   * Iceland: ISK - Harmonised Consumer Price Index (HICP) 
   */
  @SerialName("ISK-HICP")
  ISK_HICP,
  /** 
   * Italy: ITL - Inflation for Blue Collar Workers and Employees-Excluding Tobacco Consumer Price Index 
   */
  @SerialName("ITL-BC-EXT-CPI")
  ITL_BC_EXT_CPI,
  /** 
   * Italy: ITL - Inflation for Blue Collar Workers and Employees-Including Tobacco Consumer Price Index 
   */
  @SerialName("ITL-BC-INT-CPI")
  ITL_BC_INT_CPI,
  /** 
   * Italy: ITL - Non-revised Harmonised Consumer Price Index (HICP) 
   */
  @SerialName("ITL-HICP")
  ITL_HICP,
  /** 
   * Italy: ITL - Whole Community - Excluding Tobacco Consumer Price Index 
   */
  @SerialName("ITL-WC-EXT-CPI")
  ITL_WC_EXT_CPI,
  /** 
   * Italy: ITL - Whole Community - Including Tobacco Consumer Price Index 
   */
  @SerialName("ITL-WC-INT-CPI")
  ITL_WC_INT_CPI,
  /** 
   * Japan: JPY - Non-revised Consumer Price Index Nationwide General Excluding Fresh Food (CPI) 
   */
  @SerialName("JPY-CPI-EXF")
  JPY_CPI_EXF,
  /** 
   * South Korea: KRW - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("KRW-CPI")
  KRW_CPI,
  /** 
   * Luxembourg: LUX - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("LUX-CPI")
  LUX_CPI,
  /** 
   * Luxembourg: LUX - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("LUX-HICP")
  LUX_HICP,
  /** 
   * Mexico: MXN - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("MXN-CPI")
  MXN_CPI,
  /** 
   * Mexico: MXN - Unidad de Inversion Index (UDI) 
   */
  @SerialName("MXN-UDI")
  MXN_UDI,
  /** 
   * Malaysia: MYR - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("MYR-CPI")
  MYR_CPI,
  /** 
   * Netherlands: NLG - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("NLG-CPI")
  NLG_CPI,
  /** 
   * Netherlands: NLG - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("NLG-HICP")
  NLG_HICP,
  /** 
   * Norway: NOK - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("NOK-CPI")
  NOK_CPI,
  /** 
   * New Zealand: NZD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("NZD-CPI")
  NZD_CPI,
  /** 
   * Peru: PER - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("PER-CPI")
  PER_CPI,
  /** 
   * Poland: PLN - Non-Revised Consumer Price Index (CPI) 
   */
  @SerialName("PLN-CPI")
  PLN_CPI,
  /** 
   * Portugal: POR - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("POR-CPI")
  POR_CPI,
  /** 
   * Portugal: POR - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("POR-HICP")
  POR_HICP,
  /** 
   * Russia: RUB - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("RUB-CPI")
  RUB_CPI,
  /** 
   * Sweden: SEK - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("SEK-CPI")
  SEK_CPI,
  /** 
   * Singapore: SGD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("SGD-CPI")
  SGD_CPI,
  /** 
   * Switzerland: SWF - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("SWF-CPI")
  SWF_CPI,
  /** 
   * Turkey: TRY - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("TRY-CPI")
  TRY_CPI,
  /** 
   * Taiwan: TWD - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("TWD-CPI")
  TWD_CPI,
  /** 
   * United Kingdom: GBP - Non-revised Consumer Prices Index including Housing (UKCPIH) 
   */
  @SerialName("UK-CPIH")
  UK_CPIH,
  /** 
   * United Kingdom: GBP - Harmonised-Non-revised Consumer Price Index (HICP) 
   */
  @SerialName("UK-HICP")
  UK_HICP,
  /** 
   * United Kingdom: GBP - Non-revised Retail Price Index (UKRPI) 
   */
  @SerialName("UK-RPI")
  UK_RPI,
  /** 
   * United Kingdom: GBP - Non-revised Retail Price Index Excluding Mortgage Interest Payments (UKRPIX) 
   */
  @SerialName("UK-RPIX")
  UK_RPIX,
  /** 
   * United States: USA - Non-revised Consumer Price Index - Urban (CPI-U) 
   */
  @SerialName("USA-CPI-U")
  USA_CPI_U,
  /** 
   * South Africa: ZAR - Non-revised Consumer Price Index (CPI) 
   */
  @SerialName("ZAR-CPI")
  ZAR_CPI,
  /** 
   * South Africa: ZAR - Non-revised Consumer Price Index Excluding Mortgages (CPIX) 
   */
  @SerialName("ZAR-CPIX")
  ZAR_CPIX
  ;
}

/** 
 * The enumerated values to specify the list of information providers. 
 */
@Serializable
enum class InformationProviderEnum {
  /** 
   * The Association of Banks in Singapore. 
   */
  @SerialName("ASSOC_BANKS_SINGAPORE")
  ASSOC_BANKS_SINGAPORE,
  /** 
   * The central bank of Chile. 
   */
  @SerialName("BANCO_CENTRAL_CHILE")
  BANCO_CENTRAL_CHILE,
  /** 
   * The central bank of Canada. 
   */
  @SerialName("BANK_OF_CANADA")
  BANK_OF_CANADA,
  /** 
   * The Bank Of England. 
   */
  @SerialName("BANK_OF_ENGLAND")
  BANK_OF_ENGLAND,
  /** 
   * The central bank of Japan. 
   */
  @SerialName("BANK_OF_JAPAN")
  BANK_OF_JAPAN,
  /** 
   * Bloomberg LP. 
   */
  @SerialName("BLOOMBERG")
  BLOOMBERG,
  /** 
   * The European Central Bank. 
   */
  @SerialName("EURO_CENTRAL_BANK")
  EURO_CENTRAL_BANK,
  /** 
   * The Federal Home Loan Bank of San Francisco, or its successor. 
   */
  @SerialName("FHLBSF")
  FHLBSF,
  /** 
   * The Federal Reserve, the central bank of the United States. 
   */
  @SerialName("FEDERAL_RESERVE")
  FEDERAL_RESERVE,
  /** 
   * ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate. 
   */
  @SerialName("ICESWAP")
  ICESWAP,
  /** 
   * International Swaps and Derivatives Association, Inc. 
   */
  @SerialName("ISDA")
  ISDA,
  /** 
   * Refinitiv, formerly Thomson Reuters Financial & Risk. 
   */
  @SerialName("REFINITIV")
  REFINITIV,
  /** 
   * The Reserve Bank of Australia. 
   */
  @SerialName("RESERVE_BANK_AUSTRALIA")
  RESERVE_BANK_AUSTRALIA,
  /** 
   * The Reserve Bank of New Zealand. 
   */
  @SerialName("RESERVE_BANK_NEW_ZEALAND")
  RESERVE_BANK_NEW_ZEALAND,
  /** 
   * Reuters Group Plc. 
   */
  @SerialName("REUTERS")
  REUTERS,
  /** 
   * South African Futures Exchange, or its successor. 
   */
  @SerialName("SAFEX")
  SAFEX,
  /** 
   * The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR. 
   */
  @SerialName("TOKYOSWAP")
  TOKYOSWAP,
  /** 
   * Telerate, Inc. 
   */
  @SerialName("TELERATE")
  TELERATE
  ;
}

/** 
 * The enumeration values indicating the BusinessEvent function associated input instructions. 
 */
@Serializable
enum class InstructionFunctionEnum {
  @SerialName("COMPRESSION")
  COMPRESSION,
  @SerialName("CONTRACT_FORMATION")
  CONTRACT_FORMATION,
  @SerialName("EXECUTION")
  EXECUTION,
  @SerialName("QUANTITY_CHANGE")
  QUANTITY_CHANGE,
  @SerialName("RENEGOTIATION")
  RENEGOTIATION
  ;
}

/** 
 * Represents an enumeration list to indentify the type of an instrument. 
 */
@Serializable
enum class InstrumentTypeEnum {
  /** 
   * Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD). 
   */
  @SerialName("CERTIFICATE")
  CERTIFICATE,
  /** 
   * Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset. 
   */
  @SerialName("DEBT")
  DEBT,
  /** 
   * Identifies an instrument as an Equity value of holding of shares in listed company. 
   */
  @SerialName("EQUITY")
  EQUITY,
  /** 
   * Identifies an instrument as representing holding in an investment fund. 
   */
  @SerialName("FUND")
  FUND,
  /** 
   * Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods. 
   */
  @SerialName("LETTER_OF_CREDIT")
  LETTER_OF_CREDIT,
  /** 
   * Identifies an instrument as a listed derivative on an exchange. 
   */
  @SerialName("LISTED_DERIVATIVE")
  LISTED_DERIVATIVE,
  /** 
   * Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent. 
   */
  @SerialName("WARRANT")
  WARRANT
  ;
}

/** 
 * The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives. 
 */
@Serializable
enum class InterestShortfallCapEnum {
  @SerialName("FIXED")
  FIXED,
  @SerialName("VARIABLE")
  VARIABLE
  ;
}

/** 
 * The enumerated values to specify the interpolation method, e.g. linear. 
 */
@Serializable
enum class InterpolationMethodEnum {
  /** 
   * Linear Interpolation applicable. 
   */
  @SerialName("LINEAR")
  LINEAR,
  /** 
   * Linear Interpolation applicable. 
   */
  @SerialName("LINEAR_ZERO_YIELD")
  LINEAR_ZERO_YIELD,
  /** 
   * No Interpolation applicable. 
   */
  @SerialName("NONE")
  NONE
  ;
}

/** 
 * Represents an enumeration list to identify the type of entity issuing the asset. 
 */
@Serializable
enum class IssuerTypeEnum {
  /** 
   * Specifies debt issued Securities by corporate bodies including Banks. 
   */
  @SerialName("CORPORATE")
  CORPORATE,
  /** 
   * Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal. 
   */
  @SerialName("FUND")
  FUND,
  /** 
   * Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government. 
   */
  @SerialName("QUASI_GOVERNMENT")
  QUASI_GOVERNMENT,
  /** 
   * Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities. 
   */
  @SerialName("REGIONAL_GOVERNMENT")
  REGIONAL_GOVERNMENT,
  /** 
   * Specifies Sovereign, Government Debt Securities including Central Banks. 
   */
  @SerialName("SOVEREIGN_CENTRAL_BANK")
  SOVEREIGN_CENTRAL_BANK,
  /** 
   * Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations. 
   */
  @SerialName("SPECIAL_PURPOSE_VEHICLE")
  SPECIAL_PURPOSE_VEHICLE,
  /** 
   * Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks. 
   */
  @SerialName("SUPRA_NATIONAL")
  SUPRA_NATIONAL
  ;
}

/** 
 * The enumerated values to specify the legal agreement publisher. 
 */
@Serializable
enum class LegalAgreementPublisherEnum {
  /** 
   * Association Française des Banques. 
   */
  @SerialName("AFB")
  AFB,
  /** 
   * BNY Mellon 
   */
  @SerialName("BNYM")
  BNYM,
  /** 
   * Emerging Markets Traders Association 
   */
  @SerialName("EMTA")
  EMTA,
  /** 
   * International Capital Markets Association 
   */
  @SerialName("ICMA")
  ICMA,
  /** 
   * International Swaps and Derivatives Association, Inc. 
   */
  @SerialName("ISDA")
  ISDA,
  /** 
   * ISDA and Clearstream 
   */
  @SerialName("ISDA_CLEARSTREAM")
  ISDA_CLEARSTREAM,
  /** 
   * ISDA and Euroclear 
   */
  @SerialName("ISDA_EUROCLEAR")
  ISDA_EUROCLEAR,
  /** 
   * International Securities Lending Association 
   */
  @SerialName("ISLA")
  ISLA,
  /** 
   * JP Morgan 
   */
  @SerialName("JP_MORGAN")
  JP_MORGAN,
  /** 
   * The Foreign Exchange Committee 
   */
  @SerialName("THE_FX_COMMITTEE")
  THE_FX_COMMITTEE
  ;
}

/** 
 * The enumerated values to specify the legal agreement type. 
 */
@Serializable
enum class LegalAgreementTypeEnum {
  /** 
   * A Broker Confirmation. 
   */
  @SerialName("BROKER_CONFIRMATION")
  BROKER_CONFIRMATION,
  /** 
   * A Transaction Confirmation. 
   */
  @SerialName("CONFIRMATION")
  CONFIRMATION,
  /** 
   * A Credit Support Agreement. 
   */
  @SerialName("CREDIT_SUPPORT_AGREEMENT")
  CREDIT_SUPPORT_AGREEMENT,
  /** 
   * A Master Agreement. 
   */
  @SerialName("MASTER_AGREEMENT")
  MASTER_AGREEMENT,
  /** 
   * A Master Confirmation. 
   */
  @SerialName("MASTER_CONFIRMATION")
  MASTER_CONFIRMATION,
  /** 
   * Another type of agreement. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * A Security Agreement related to a Collateral Transfer Agreement (CTA). 
   */
  @SerialName("SECURITY_AGREEMENT")
  SECURITY_AGREEMENT
  ;
}

/** 
 * The enumerated values to specify the length unit in the Resource type. 
 */
@Serializable
enum class LengthUnitEnum {
  @SerialName("PAGES")
  PAGES,
  @SerialName("TIME_UNIT")
  TIME_UNIT
  ;
}

/** 
 * The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification. 
 */
@Serializable
enum class LimitLevelEnum {
  /** 
   * The limit is set in relation to the proprietary business undertaken by the clearing counterparty. 
   */
  @SerialName("ACCOUNT")
  ACCOUNT,
  /** 
   * The limit is set in relation to the customer business undertaken by the clearing counterparty. 
   */
  @SerialName("CUSTOMER")
  CUSTOMER,
  /** 
   * The limit is set at the account level in relation to the clearing counterparty. 
   */
  @SerialName("HOUSE")
  HOUSE
  ;
}

/** 
 * Specifies the load type of the delivery. 
 */
@Serializable
enum class LoadTypeEnum {
  /** 
   * Base load 
   */
  @SerialName("BASE_LOAD")
  BASE_LOAD,
  /** 
   * Block Hours 
   */
  @SerialName("BLOCK_HOURS")
  BLOCK_HOURS,
  /** 
   * Gas Day 
   */
  @SerialName("GAS_DAY")
  GAS_DAY,
  /** 
   * Off-peak load 
   */
  @SerialName("OFF_PEAK")
  OFF_PEAK,
  /** 
   * Other 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Peak load 
   */
  @SerialName("PEAK_LOAD")
  PEAK_LOAD,
  /** 
   * Shaped 
   */
  @SerialName("SHAPED")
  SHAPED
  ;
}

/** 
 * Represents the enumeration values to identify the collateral action instruction. 
 */
@Serializable
enum class MarginCallActionEnum {
  /** 
   * Indicates an instruction of a new collateral asset delivery. 
   */
  @SerialName("DELIVERY")
  DELIVERY,
  /** 
   * Indicates an instruction for a return of a principals collateral asset delivery. 
   */
  @SerialName("RETURN")
  RETURN
  ;
}

/** 
 * Represents the enumeration values to define the response type to a margin call. 
 */
@Serializable
enum class MarginCallResponseTypeEnum {
  /** 
   * Specifies a 'Full Agreement' to Margin Call. 
   */
  @SerialName("AGREEIN_FULL")
  AGREEIN_FULL,
  /** 
   * Specifies a 'Full Dispute' to a Margin call. 
   */
  @SerialName("DISPUTE")
  DISPUTE,
  /** 
   * Specifies a 'Partial agreement' to Margin Call. 
   */
  @SerialName("PARTIALLY_AGREE")
  PARTIALLY_AGREE
  ;
}

/** 
 * This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction. 
 */
@Serializable
enum class MarginTypeEnum {
  /** 
   * When the margin type is Cash, the margin factor is applied to the cash value of the transaction. 
   */
  @SerialName("CASH")
  CASH,
  /** 
   * When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the 'instrument' case, the haircut would be applied to the securities. 
   */
  @SerialName("INSTRUMENT")
  INSTRUMENT
  ;
}

/** 
 * The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction. 
 */
@Serializable
enum class MarketDisruptionEnum {
  /** 
   * As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions. 
   */
  @SerialName("MODIFIED_POSTPONEMENT")
  MODIFIED_POSTPONEMENT,
  /** 
   * As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions. 
   */
  @SerialName("OMISSION")
  OMISSION,
  /** 
   * As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions. 
   */
  @SerialName("POSTPONEMENT")
  POSTPONEMENT
  ;
}

@Serializable
enum class MasterAgreementClauseIdentifierEnum {
  /** 
   * Date of Agreement 
   */
  @SerialName("ISLA_GMSLA_001")
  ISLA_GMSLA_001,
  /** 
   * Parties 
   */
  @SerialName("ISLA_GMSLA_002")
  ISLA_GMSLA_002,
  /** 
   * Specific Roles 
   */
  @SerialName("ISLA_GMSLA_003")
  ISLA_GMSLA_003,
  /** 
   * Eligible Collateral 
   */
  @SerialName("ISLA_GMSLA_004")
  ISLA_GMSLA_004,
  /** 
   * Margin 
   */
  @SerialName("ISLA_GMSLA_005")
  ISLA_GMSLA_005,
  /** 
   * Aggregation 
   */
  @SerialName("ISLA_GMSLA_006")
  ISLA_GMSLA_006,
  /** 
   * Collateral Disapplication 
   */
  @SerialName("ISLA_GMSLA_007")
  ISLA_GMSLA_007,
  /** 
   * Settlement Netting 
   */
  @SerialName("ISLA_GMSLA_008")
  ISLA_GMSLA_008,
  /** 
   * Notification Time 
   */
  @SerialName("ISLA_GMSLA_009")
  ISLA_GMSLA_009,
  /** 
   * Indemnity 
   */
  @SerialName("ISLA_GMSLA_010")
  ISLA_GMSLA_010,
  /** 
   * Base Currency 
   */
  @SerialName("ISLA_GMSLA_011")
  ISLA_GMSLA_011,
  /** 
   * Places of Business 
   */
  @SerialName("ISLA_GMSLA_012")
  ISLA_GMSLA_012,
  /** 
   * Value 
   */
  @SerialName("ISLA_GMSLA_013")
  ISLA_GMSLA_013,
  /** 
   * Automatic Early Termination 
   */
  @SerialName("ISLA_GMSLA_014")
  ISLA_GMSLA_014,
  /** 
   * Designated Offices 
   */
  @SerialName("ISLA_GMSLA_015")
  ISLA_GMSLA_015,
  /** 
   * Address for Notices 
   */
  @SerialName("ISLA_GMSLA_016")
  ISLA_GMSLA_016,
  /** 
   * Process Agent 
   */
  @SerialName("ISLA_GMSLA_017")
  ISLA_GMSLA_017,
  /** 
   * Party Acting as Agent 
   */
  @SerialName("ISLA_GMSLA_018")
  ISLA_GMSLA_018,
  /** 
   * Pooled Principal Transactions  
   */
  @SerialName("ISLA_GMSLA_019")
  ISLA_GMSLA_019,
  /** 
   * Party Preparing the Agreement  
   */
  @SerialName("ISLA_GMSLA_020")
  ISLA_GMSLA_020,
  /** 
   * Default Interest Rate 
   */
  @SerialName("ISLA_GMSLA_021")
  ISLA_GMSLA_021,
  /** 
   * Existing Transactions 
   */
  @SerialName("ISLA_GMSLA_022")
  ISLA_GMSLA_022,
  /** 
   * Automation 
   */
  @SerialName("ISLA_GMSLA_023")
  ISLA_GMSLA_023,
  /** 
   * Act of Insolvency 
   */
  @SerialName("ISLA_GMSLA_024")
  ISLA_GMSLA_024,
  /** 
   * Buy-In 
   */
  @SerialName("ISLA_GMSLA_025")
  ISLA_GMSLA_025,
  /** 
   * Currency Conversions 
   */
  @SerialName("ISLA_GMSLA_026")
  ISLA_GMSLA_026,
  /** 
   * Scope 
   */
  @SerialName("ISLA_GMSLA_027")
  ISLA_GMSLA_027,
  /** 
   * Collateral Delivery Timings 
   */
  @SerialName("ISLA_GMSLA_028")
  ISLA_GMSLA_028,
  /** 
   * Delivery 
   */
  @SerialName("ISLA_GMSLA_029")
  ISLA_GMSLA_029,
  /** 
   * Substitution of Collateral 
   */
  @SerialName("ISLA_GMSLA_030")
  ISLA_GMSLA_030,
  /** 
   * Manufactured Payments 
   */
  @SerialName("ISLA_GMSLA_031")
  ISLA_GMSLA_031,
  /** 
   * Corporate Actions 
   */
  @SerialName("ISLA_GMSLA_032")
  ISLA_GMSLA_032,
  /** 
   * Payment of Rates 
   */
  @SerialName("ISLA_GMSLA_033")
  ISLA_GMSLA_033,
  /** 
   * Rate Applicable to Loaned Securities 
   */
  @SerialName("ISLA_GMSLA_034")
  ISLA_GMSLA_034,
  /** 
   * Lender's Right to Terminate a Loan 
   */
  @SerialName("ISLA_GMSLA_035")
  ISLA_GMSLA_035,
  /** 
   * Borrower's Right to Terminate a Loan 
   */
  @SerialName("ISLA_GMSLA_036")
  ISLA_GMSLA_036,
  /** 
   * Failure to Deliver Event of Default 
   */
  @SerialName("ISLA_GMSLA_037")
  ISLA_GMSLA_037,
  /** 
   * Failure to Redeliver 
   */
  @SerialName("ISLA_GMSLA_038")
  ISLA_GMSLA_038,
  /** 
   * Assets Transferred to a Trustee 
   */
  @SerialName("ISLA_GMSLA_039")
  ISLA_GMSLA_039,
  /** 
   * Suspension Event of Default 
   */
  @SerialName("ISLA_GMSLA_040")
  ISLA_GMSLA_040,
  /** 
   * Costs and Expenses 
   */
  @SerialName("ISLA_GMSLA_041")
  ISLA_GMSLA_041,
  /** 
   * Set-Off 
   */
  @SerialName("ISLA_GMSLA_042")
  ISLA_GMSLA_042,
  /** 
   * Default Market Value Fallbacks 
   */
  @SerialName("ISLA_GMSLA_043")
  ISLA_GMSLA_043,
  /** 
   * Assignment 
   */
  @SerialName("ISLA_GMSLA_044")
  ISLA_GMSLA_044,
  /** 
   * Telephone Recordings 
   */
  @SerialName("ISLA_GMSLA_045")
  ISLA_GMSLA_045,
  /** 
   * Waiver of Immunity 
   */
  @SerialName("ISLA_GMSLA_046")
  ISLA_GMSLA_046,
  /** 
   * Agreement to Deliver Documents 
   */
  @SerialName("ISLA_GMSLA_047")
  ISLA_GMSLA_047,
  /** 
   * Collateral Transfer Details 
   */
  @SerialName("ISLA_GMSLA_048")
  ISLA_GMSLA_048,
  /** 
   * Confidentiality 
   */
  @SerialName("ISLA_GMSLA_049")
  ISLA_GMSLA_049,
  /** 
   * Correction 
   */
  @SerialName("ISLA_GMSLA_050")
  ISLA_GMSLA_050,
  /** 
   * Minimum Collateral Transfer Amount 
   */
  @SerialName("ISLA_GMSLA_051")
  ISLA_GMSLA_051,
  /** 
   * Non-Reliance Representation 
   */
  @SerialName("ISLA_GMSLA_052")
  ISLA_GMSLA_052,
  /** 
   * Records and Statements 
   */
  @SerialName("ISLA_GMSLA_053")
  ISLA_GMSLA_053,
  /** 
   * Recovery and Resolution 
   */
  @SerialName("ISLA_GMSLA_054")
  ISLA_GMSLA_054,
  /** 
   * Security Agreement Details 
   */
  @SerialName("ISLA_GMSLA_055")
  ISLA_GMSLA_055,
  /** 
   * Triparty Services 
   */
  @SerialName("ISLA_GMSLA_056")
  ISLA_GMSLA_056
  ;
}

/** 
 * The enumerated values to specify the type of the master agreement governing the transaction. 
 */
@Serializable
enum class MasterAgreementTypeEnum {
  /** 
   * AFB Master Agreement for Foreign Exchange and Derivatives Transactions 
   */
  @SerialName("AFB")
  AFB,
  /** 
   * A Bespoke (custom) Master Agreement, including one-off agreements for transactions 
   */
  @SerialName("BESPOKE")
  BESPOKE,
  /** 
   * Clearing Master Agreement 
   */
  @SerialName("CMA")
  CMA,
  /** 
   * Contrato Marco de Operaciones Financieras 
   */
  @SerialName("CMOF")
  CMOF,
  /** 
   * EEI Master Power Purchase and Sale Agreement 
   */
  @SerialName("EEI_POWER")
  EEI_POWER,
  /** 
   * EFET General Agreement Concerning the Delivery and Acceptance of Electricity 
   */
  @SerialName("EFET_ELECTRICITY")
  EFET_ELECTRICITY,
  /** 
   * EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas 
   */
  @SerialName("EFET_GAS")
  EFET_GAS,
  /** 
   * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union) 
   */
  @SerialName("EMA")
  EMA,
  /** 
   * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise) 
   */
  @SerialName("FBF")
  FBF,
  /** 
   * ICMA Global Master Agreement for REPO Trades 
   */
  @SerialName("GMRA")
  GMRA,
  /** 
   * ISLA Global Master Agreement for Securities Lending 
   */
  @SerialName("GMSLA")
  GMSLA,
  /** 
   * FOA Grid Trade Master Agreement 
   */
  @SerialName("GTMA")
  GTMA,
  /** 
   * GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas 
   */
  @SerialName("GAS_EDI")
  GAS_EDI,
  /** 
   * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities 
   */
  @SerialName("GERMAN")
  GERMAN,
  /** 
   * International Currency Options Market Master Agreement 
   */
  @SerialName("ICOM")
  ICOM,
  /** 
   * International Emissions Trading Association Emissions Reduction Purchase Agreement 
   */
  @SerialName("IETA-ERPA")
  IETA_ERPA,
  /** 
   * International Emissions Trading Association Emissions Trading Master Agreement 
   */
  @SerialName("IETA-ETMA")
  IETA_ETMA,
  /** 
   * International Emissions Trading Association International Emissions Trading Master Agreement 
   */
  @SerialName("IETA-IETMA")
  IETA_IETMA,
  /** 
   * International Foreign Exchange Master Agreement 
   */
  @SerialName("IFEMA")
  IFEMA,
  /** 
   * International Foreign Exchange and Options Master Agreement 
   */
  @SerialName("IFEOMA")
  IFEOMA,
  /** 
   * ISDA-FIA Cleared Derivatives Execution Agreement 
   */
  @SerialName("ISDAFIA-CDEA")
  ISDAFIA_CDEA,
  /** 
   * ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA) 
   */
  @SerialName("ISDAIIFM-TMA")
  ISDAIIFM_TMA,
  /** 
   * ISDA Master Agreement 
   */
  @SerialName("ISDA_MASTER")
  ISDA_MASTER,
  /** 
   * Master agreement of Japan Securities Clearing Corporation 
   */
  @SerialName("JSCC")
  JSCC,
  /** 
   * International Bullion Master Agreement Terms published by the London Bullion Market Association 
   */
  @SerialName("LBMA")
  LBMA,
  /** 
   * Leadership in Energy Automated Processing 
   */
  @SerialName("LEAP")
  LEAP,
  /** 
   * CTA Master Coal Purchase and Sales Agreement 
   */
  @SerialName("MCPSA")
  MCPSA,
  /** 
   * NAESB Base Contract for Sale and Purchase of Natural Gas 
   */
  @SerialName("NAESB_GAS")
  NAESB_GAS,
  /** 
   * Short Term Flat NBP Trading Terms and Conditions 
   */
  @SerialName("NBP")
  NBP,
  /** 
   * Standard Documentation for Derivative Transactions on the Russian Financial Markets 
   */
  @SerialName("RUSSIAN_DERIVATIVES")
  RUSSIAN_DERIVATIVES,
  /** 
   * Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market 
   */
  @SerialName("RUSSIAN_REPO")
  RUSSIAN_REPO,
  /** 
   * globalCOAL Standard Coal Trading Agreement 
   */
  @SerialName("S_CO_TA")
  S_CO_TA,
  /** 
   * Swiss Master Agreement for OTC Derivatives Instruments 
   */
  @SerialName("SWISS")
  SWISS,
  /** 
   * TTF Hub Natural Gas Trading Terms and Conditions 
   */
  @SerialName("TTF")
  TTF,
  /** 
   * Zeebrugge Hub Natural Gas Trading Terms and Conditions 
   */
  @SerialName("ZBT")
  ZBT
  ;
}

@Serializable
enum class MasterAgreementVariantIdentifierEnum {
  /** 
   * Agreement is Undated 
   */
  @SerialName("ISLA_GMSLA_001_01")
  ISLA_GMSLA_001_01,
  /** 
   * Agreement is Dated 
   */
  @SerialName("ISLA_GMSLA_001_02")
  ISLA_GMSLA_001_02,
  /** 
   * Name and Place of Incorporation 
   */
  @SerialName("ISLA_GMSLA_002_01")
  ISLA_GMSLA_002_01,
  /** 
   * Names and Place of Incorporation plus Additional Information 
   */
  @SerialName("ISLA_GMSLA_002_02")
  ISLA_GMSLA_002_02,
  /** 
   * Defining the Party's Role as Lender or Borrower 
   */
  @SerialName("ISLA_GMSLA_002_03")
  ISLA_GMSLA_002_03,
  /** 
   * Non-specific Roles 
   */
  @SerialName("ISLA_GMSLA_003_01")
  ISLA_GMSLA_003_01,
  /** 
   * Specific Roles 
   */
  @SerialName("ISLA_GMSLA_003_02")
  ISLA_GMSLA_003_02,
  /** 
   * GMSLA Schedule 
   */
  @SerialName("ISLA_GMSLA_004_01")
  ISLA_GMSLA_004_01,
  /** 
   * Outside of GMSLA 
   */
  @SerialName("ISLA_GMSLA_004_02")
  ISLA_GMSLA_004_02,
  /** 
   * Additional Criteria 
   */
  @SerialName("ISLA_GMSLA_004_03")
  ISLA_GMSLA_004_03,
  /** 
   * GMSLA Schedule 
   */
  @SerialName("ISLA_GMSLA_005_01")
  ISLA_GMSLA_005_01,
  /** 
   * Outside of GMSLA 
   */
  @SerialName("ISLA_GMSLA_005_02")
  ISLA_GMSLA_005_02,
  /** 
   * Aggregation Applies 
   */
  @SerialName("ISLA_GMSLA_006_01")
  ISLA_GMSLA_006_01,
  /** 
   * Aggregation Does Not Apply 
   */
  @SerialName("ISLA_GMSLA_006_02")
  ISLA_GMSLA_006_02,
  /** 
   * Aggregation Applies Separately to Loan Groups 
   */
  @SerialName("ISLA_GMSLA_006_03")
  ISLA_GMSLA_006_03,
  /** 
   * Aggregation Applies to Some but Not All Loans 
   */
  @SerialName("ISLA_GMSLA_006_04")
  ISLA_GMSLA_006_04,
  /** 
   * Neither Aggregation nor Loan by Loan Applies 
   */
  @SerialName("ISLA_GMSLA_006_05")
  ISLA_GMSLA_006_05,
  /** 
   * Standard 
   */
  @SerialName("ISLA_GMSLA_007_01")
  ISLA_GMSLA_007_01,
  /** 
   * Collateral Disapplied 
   */
  @SerialName("ISLA_GMSLA_007_02")
  ISLA_GMSLA_007_02,
  /** 
   * Netting of Collateral Shall Apply 
   */
  @SerialName("ISLA_GMSLA_008_01")
  ISLA_GMSLA_008_01,
  /** 
   * Netting of Collateral Shall Not Apply 
   */
  @SerialName("ISLA_GMSLA_008_02")
  ISLA_GMSLA_008_02,
  /** 
   * Netting of Collateral Shall Apply with Multiple Payments or Delivery Options 
   */
  @SerialName("ISLA_GMSLA_008_03")
  ISLA_GMSLA_008_03,
  /** 
   * Netting of Collateral Shall Apply Separately per Group of Loans 
   */
  @SerialName("ISLA_GMSLA_008_04")
  ISLA_GMSLA_008_04,
  /** 
   * Specified Time 
   */
  @SerialName("ISLA_GMSLA_009_01")
  ISLA_GMSLA_009_01,
  /** 
   * Notification Time by Collateral Type 
   */
  @SerialName("ISLA_GMSLA_009_02")
  ISLA_GMSLA_009_02,
  /** 
   * Notification Time as Agreed 
   */
  @SerialName("ISLA_GMSLA_009_03")
  ISLA_GMSLA_009_03,
  /** 
   * No Notification Time 
   */
  @SerialName("ISLA_GMSLA_009_04")
  ISLA_GMSLA_009_04,
  /** 
   * Indemnity Applies 
   */
  @SerialName("ISLA_GMSLA_010_01")
  ISLA_GMSLA_010_01,
  /** 
   * Indemnity does not Apply 
   */
  @SerialName("ISLA_GMSLA_010_02")
  ISLA_GMSLA_010_02,
  /** 
   * Single Base Currency 
   */
  @SerialName("ISLA_GMSLA_011_01")
  ISLA_GMSLA_011_01,
  /** 
   * Single Base Currency with Fallback 
   */
  @SerialName("ISLA_GMSLA_011_02")
  ISLA_GMSLA_011_02,
  /** 
   * Single Base Currency with Multiple Fallback Options 
   */
  @SerialName("ISLA_GMSLA_011_03")
  ISLA_GMSLA_011_03,
  /** 
   * Locations are Specified Without Reference to Party 
   */
  @SerialName("ISLA_GMSLA_012_01")
  ISLA_GMSLA_012_01,
  /** 
   * Locations are Specified Separately per Party 
   */
  @SerialName("ISLA_GMSLA_012_02")
  ISLA_GMSLA_012_02,
  /** 
   * Not all Places of Business Have to be Open 
   */
  @SerialName("ISLA_GMSLA_012_03")
  ISLA_GMSLA_012_03,
  /** 
   * Standard Bid Price 
   */
  @SerialName("ISLA_GMSLA_013_01")
  ISLA_GMSLA_013_01,
  /** 
   * Standard Mid Price 
   */
  @SerialName("ISLA_GMSLA_013_02")
  ISLA_GMSLA_013_02,
  /** 
   * 2018 Standard 
   */
  @SerialName("ISLA_GMSLA_013_03")
  ISLA_GMSLA_013_03,
  /** 
   * Borrowers Agreement to Pricing Source 
   */
  @SerialName("ISLA_GMSLA_013_04")
  ISLA_GMSLA_013_04,
  /** 
   * Pre-agreed Pricing Source 
   */
  @SerialName("ISLA_GMSLA_013_05")
  ISLA_GMSLA_013_05,
  /** 
   * Time Variation 
   */
  @SerialName("ISLA_GMSLA_013_06")
  ISLA_GMSLA_013_06,
  /** 
   * Automatic Early Termination does not Apply 
   */
  @SerialName("ISLA_GMSLA_014_01")
  ISLA_GMSLA_014_01,
  /** 
   * Automatic Early Termination Applies 
   */
  @SerialName("ISLA_GMSLA_014_02")
  ISLA_GMSLA_014_02,
  /** 
   * Automatic Early Termination Applies in Modified Form) 
   */
  @SerialName("ISLA_GMSLA_014_03")
  ISLA_GMSLA_014_03,
  /** 
   * Automatic Early Termination is specified separately for each Principal 
   */
  @SerialName("ISLA_GMSLA_014_04")
  ISLA_GMSLA_014_04,
  /** 
   * Automatic Early Termination is not applicable unless required due to the systems of law 
   */
  @SerialName("ISLA_GMSLA_014_05")
  ISLA_GMSLA_014_05,
  /** 
   * Party Specifies a Single Designated Office 
   */
  @SerialName("ISLA_GMSLA_015_01")
  ISLA_GMSLA_015_01,
  /** 
   * Party Specifies Multiple Designated Offices 
   */
  @SerialName("ISLA_GMSLA_015_02")
  ISLA_GMSLA_015_02,
  /** 
   * 2000 Standard 
   */
  @SerialName("ISLA_GMSLA_016_01")
  ISLA_GMSLA_016_01,
  /** 
   * 2010 Standard 
   */
  @SerialName("ISLA_GMSLA_016_02")
  ISLA_GMSLA_016_02,
  /** 
   * 2018 Standard 
   */
  @SerialName("ISLA_GMSLA_016_03")
  ISLA_GMSLA_016_03,
  /** 
   * Plus Email 
   */
  @SerialName("ISLA_GMSLA_016_04")
  ISLA_GMSLA_016_04,
  /** 
   * Separate Address for Legal and Operational Notices 
   */
  @SerialName("ISLA_GMSLA_016_05")
  ISLA_GMSLA_016_05,
  /** 
   * Special Instructions 
   */
  @SerialName("ISLA_GMSLA_016_06")
  ISLA_GMSLA_016_06,
  /** 
   * No Process Agent 
   */
  @SerialName("ISLA_GMSLA_017_01")
  ISLA_GMSLA_017_01,
  /** 
   * Process Agent Specified 
   */
  @SerialName("ISLA_GMSLA_017_02")
  ISLA_GMSLA_017_02,
  /** 
   * Process Agent to be Appointed 
   */
  @SerialName("ISLA_GMSLA_017_03")
  ISLA_GMSLA_017_03,
  /** 
   * A Party will not act as Agent 
   */
  @SerialName("ISLA_GMSLA_018_01")
  ISLA_GMSLA_018_01,
  /** 
   * A Party may act as Agent 
   */
  @SerialName("ISLA_GMSLA_018_02")
  ISLA_GMSLA_018_02,
  /** 
   * A Party will always act as Agent 
   */
  @SerialName("ISLA_GMSLA_018_03")
  ISLA_GMSLA_018_03,
  /** 
   * Pooled Principal Transactions Shall Not Apply 
   */
  @SerialName("ISLA_GMSLA_019_01")
  ISLA_GMSLA_019_01,
  /** 
   * Pooled Principal Transactions Shall  Apply 
   */
  @SerialName("ISLA_GMSLA_019_02")
  ISLA_GMSLA_019_02,
  /** 
   * Pooled Principal Transactions May Apply 
   */
  @SerialName("ISLA_GMSLA_019_03")
  ISLA_GMSLA_019_03,
  /** 
   * Simple Election 
   */
  @SerialName("ISLA_GMSLA_020_01")
  ISLA_GMSLA_020_01,
  /** 
   * Election with Modifications 
   */
  @SerialName("ISLA_GMSLA_020_02")
  ISLA_GMSLA_020_02,
  /** 
   * Term Rate 
   */
  @SerialName("ISLA_GMSLA_021_01")
  ISLA_GMSLA_021_01,
  /** 
   * Overnight Rate 
   */
  @SerialName("ISLA_GMSLA_021_02")
  ISLA_GMSLA_021_02,
  /** 
   * Risk Free Rate 
   */
  @SerialName("ISLA_GMSLA_021_03")
  ISLA_GMSLA_021_03,
  /** 
   * Non-Defaulting Party Election 
   */
  @SerialName("ISLA_GMSLA_021_04")
  ISLA_GMSLA_021_04,
  /** 
   * Spread 
   */
  @SerialName("ISLA_GMSLA_021_05")
  ISLA_GMSLA_021_05,
  /** 
   * Agreement Covers Existing Loans 
   */
  @SerialName("ISLA_GMSLA_022_01")
  ISLA_GMSLA_022_01,
  /** 
   * Agreement Does Not Cover Existing Loans 
   */
  @SerialName("ISLA_GMSLA_022_02")
  ISLA_GMSLA_022_02,
  /** 
   * Automation Does Not Apply 
   */
  @SerialName("ISLA_GMSLA_023_01")
  ISLA_GMSLA_023_01,
  /** 
   * Automation May Apply 
   */
  @SerialName("ISLA_GMSLA_023_02")
  ISLA_GMSLA_023_02,
  /** 
   * Standard Pre-Print 
   */
  @SerialName("ISLA_GMSLA_024_01")
  ISLA_GMSLA_024_01,
  /** 
   * Grace Period Amendment 
   */
  @SerialName("ISLA_GMSLA_024_02")
  ISLA_GMSLA_024_02,
  /** 
   * Jurisdictional Amendments 
   */
  @SerialName("ISLA_GMSLA_024_03")
  ISLA_GMSLA_024_03,
  /** 
   * Transferor Pays Costs and Expenses 
   */
  @SerialName("ISLA_GMSLA_025_01")
  ISLA_GMSLA_025_01,
  /** 
   * Transferor Pays Costs and Expenses other than those arising from Negligence 
   */
  @SerialName("ISLA_GMSLA_025_02")
  ISLA_GMSLA_025_02,
  /** 
   * Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in 
   */
  @SerialName("ISLA_GMSLA_025_03")
  ISLA_GMSLA_025_03,
  /** 
   * Buy-in Expanded to Cover Buy-in Exercised by an Exchange 
   */
  @SerialName("ISLA_GMSLA_025_04")
  ISLA_GMSLA_025_04,
  /** 
   * Standard 
   */
  @SerialName("ISLA_GMSLA_026_01")
  ISLA_GMSLA_026_01,
  /** 
   * Selecting Party other than Lender 
   */
  @SerialName("ISLA_GMSLA_026_02")
  ISLA_GMSLA_026_02,
  /** 
   * Variation of Exchange Rate Source 
   */
  @SerialName("ISLA_GMSLA_026_03")
  ISLA_GMSLA_026_03,
  /** 
   * Standard Scope 
   */
  @SerialName("ISLA_GMSLA_027_01")
  ISLA_GMSLA_027_01,
  /** 
   * Limited Scope 
   */
  @SerialName("ISLA_GMSLA_027_02")
  ISLA_GMSLA_027_02,
  /** 
   * Same Day 
   */
  @SerialName("ISLA_GMSLA_028_01")
  ISLA_GMSLA_028_01,
  /** 
   * Alternative Delivery Time 
   */
  @SerialName("ISLA_GMSLA_028_02")
  ISLA_GMSLA_028_02,
  /** 
   * Same Day with Notification Time 
   */
  @SerialName("ISLA_GMSLA_028_03")
  ISLA_GMSLA_028_03,
  /** 
   * Alternative Delivery Time with Notification Time 
   */
  @SerialName("ISLA_GMSLA_028_04")
  ISLA_GMSLA_028_04,
  /** 
   * Asset Dependent 
   */
  @SerialName("ISLA_GMSLA_028_05")
  ISLA_GMSLA_028_05,
  /** 
   * Simultaneous delivery of securities and collateral 
   */
  @SerialName("ISLA_GMSLA_029_01")
  ISLA_GMSLA_029_01,
  /** 
   * Collateral Delivery as specified in the Security Agreement 
   */
  @SerialName("ISLA_GMSLA_029_02")
  ISLA_GMSLA_029_02,
  /** 
   * Lender to Deliver Securities once Collateral is Delivered 
   */
  @SerialName("ISLA_GMSLA_029_03")
  ISLA_GMSLA_029_03,
  /** 
   * Borrower Request 
   */
  @SerialName("ISLA_GMSLA_030_01")
  ISLA_GMSLA_030_01,
  /** 
   * Borrower Request/Lender Consent 
   */
  @SerialName("ISLA_GMSLA_030_02")
  ISLA_GMSLA_030_02,
  /** 
   * Lender or Borrower Request 
   */
  @SerialName("ISLA_GMSLA_030_03")
  ISLA_GMSLA_030_03,
  /** 
   * Pre-approval of Alternative Collateral 
   */
  @SerialName("ISLA_GMSLA_030_04")
  ISLA_GMSLA_030_04,
  /** 
   * Manufactured Payment of Amount Such Party Would Be Entitled to Receive 
   */
  @SerialName("ISLA_GMSLA_031_01")
  ISLA_GMSLA_031_01,
  /** 
   * Manufactured Payment of Amount Such Lender Would Be Entitled to Receive 
   */
  @SerialName("ISLA_GMSLA_031_02")
  ISLA_GMSLA_031_02,
  /** 
   * Manufactured Payment Only in Relation to Loaned Securities 
   */
  @SerialName("ISLA_GMSLA_031_03")
  ISLA_GMSLA_031_03,
  /** 
   * Additional Sum to Be Paid to Cover Tax Relief 
   */
  @SerialName("ISLA_GMSLA_031_04")
  ISLA_GMSLA_031_04,
  /** 
   * Notice Requirement 
   */
  @SerialName("ISLA_GMSLA_031_05")
  ISLA_GMSLA_031_05,
  /** 
   * Standard 
   */
  @SerialName("ISLA_GMSLA_032_01")
  ISLA_GMSLA_032_01,
  /** 
   * Reasonable Notice Defined 
   */
  @SerialName("ISLA_GMSLA_032_02")
  ISLA_GMSLA_032_02,
  /** 
   * No Right to Instruct 
   */
  @SerialName("ISLA_GMSLA_032_03")
  ISLA_GMSLA_032_03,
  /** 
   * Payment Within a Week 
   */
  @SerialName("ISLA_GMSLA_033_01")
  ISLA_GMSLA_033_01,
  /** 
   * Payment Within 10 Days 
   */
  @SerialName("ISLA_GMSLA_033_02")
  ISLA_GMSLA_033_02,
  /** 
   * Payment Upon Maturity 
   */
  @SerialName("ISLA_GMSLA_033_03")
  ISLA_GMSLA_033_03,
  /** 
   * Such Rate as Agreed 
   */
  @SerialName("ISLA_GMSLA_034_01")
  ISLA_GMSLA_034_01,
  /** 
   * VAT Added 
   */
  @SerialName("ISLA_GMSLA_034_02")
  ISLA_GMSLA_034_02,
  /** 
   * No Deduction 
   */
  @SerialName("ISLA_GMSLA_034_03")
  ISLA_GMSLA_034_03,
  /** 
   * No Rate Payable 
   */
  @SerialName("ISLA_GMSLA_034_04")
  ISLA_GMSLA_034_04,
  /** 
   * Lender May Terminate a Loan at any Time 
   */
  @SerialName("ISLA_GMSLA_035_01")
  ISLA_GMSLA_035_01,
  /** 
   * Lender May Not Terminate a Loan 
   */
  @SerialName("ISLA_GMSLA_035_02")
  ISLA_GMSLA_035_02,
  /** 
   * Borrower May Terminate a Loan at Any Time 
   */
  @SerialName("ISLA_GMSLA_036_01")
  ISLA_GMSLA_036_01,
  /** 
   * Borrower May Terminate a Loan Subject to Notice 
   */
  @SerialName("ISLA_GMSLA_036_02")
  ISLA_GMSLA_036_02,
  /** 
   * Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions 
   */
  @SerialName("ISLA_GMSLA_036_03")
  ISLA_GMSLA_036_03,
  /** 
   * Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term 
   */
  @SerialName("ISLA_GMSLA_036_04")
  ISLA_GMSLA_036_04,
  /** 
   * Failure to Deliver Event of Default Applies 
   */
  @SerialName("ISLA_GMSLA_037_01")
  ISLA_GMSLA_037_01,
  /** 
   * Failure to Deliver Event of Default does not Apply 
   */
  @SerialName("ISLA_GMSLA_037_02")
  ISLA_GMSLA_037_02,
  /** 
   * Failure to Deliver Event of Default does not Apply to Lender 
   */
  @SerialName("ISLA_GMSLA_037_03")
  ISLA_GMSLA_037_03,
  /** 
   * 2000 Standard 
   */
  @SerialName("ISLA_GMSLA_038_01")
  ISLA_GMSLA_038_01,
  /** 
   * 2010 Standard 
   */
  @SerialName("ISLA_GMSLA_038_02")
  ISLA_GMSLA_038_02,
  /** 
   * 2018 Standard 
   */
  @SerialName("ISLA_GMSLA_038_03")
  ISLA_GMSLA_038_03,
  /** 
   * 2000 Modified No Lender Close Out 
   */
  @SerialName("ISLA_GMSLA_038_04")
  ISLA_GMSLA_038_04,
  /** 
   * 2000 Standard 
   */
  @SerialName("ISLA_GMSLA_039_01")
  ISLA_GMSLA_039_01,
  /** 
   * 2010/2018 Standard 
   */
  @SerialName("ISLA_GMSLA_039_02")
  ISLA_GMSLA_039_02,
  /** 
   * Hybrid 
   */
  @SerialName("ISLA_GMSLA_039_03")
  ISLA_GMSLA_039_03,
  /** 
   * 2000 Standard 
   */
  @SerialName("ISLA_GMSLA_040_01")
  ISLA_GMSLA_040_01,
  /** 
   * 2010/2018 Standard 
   */
  @SerialName("ISLA_GMSLA_040_02")
  ISLA_GMSLA_040_02,
  /** 
   * Hybrid 
   */
  @SerialName("ISLA_GMSLA_040_03")
  ISLA_GMSLA_040_03,
  /** 
   * Standard Costs and Expenses 
   */
  @SerialName("ISLA_GMSLA_041_01")
  ISLA_GMSLA_041_01,
  /** 
   * Limitation of Costs and Expenses 
   */
  @SerialName("ISLA_GMSLA_041_02")
  ISLA_GMSLA_041_02,
  /** 
   * Expansion of Costs and Expenses 
   */
  @SerialName("ISLA_GMSLA_041_03")
  ISLA_GMSLA_041_03,
  /** 
   * No Contractual Set-Off 
   */
  @SerialName("ISLA_GMSLA_042_01")
  ISLA_GMSLA_042_01,
  /** 
   * Simple Contractual Set-Off 
   */
  @SerialName("ISLA_GMSLA_042_02")
  ISLA_GMSLA_042_02,
  /** 
   * Set-Off with Unascertained Obligations Amendment 
   */
  @SerialName("ISLA_GMSLA_042_03")
  ISLA_GMSLA_042_03,
  /** 
   * Standard Paragraph 11.2(a) 
   */
  @SerialName("ISLA_GMSLA_043_01")
  ISLA_GMSLA_043_01,
  /** 
   * Amended Paragraph 11.2,(a) applies 
   */
  @SerialName("ISLA_GMSLA_043_02")
  ISLA_GMSLA_043_02,
  /** 
   * Consent 
   */
  @SerialName("ISLA_GMSLA_044_01")
  ISLA_GMSLA_044_01,
  /** 
   * Consent with Standard Exclusions 
   */
  @SerialName("ISLA_GMSLA_044_02")
  ISLA_GMSLA_044_02,
  /** 
   * Consent with Additional Exclusions 
   */
  @SerialName("ISLA_GMSLA_044_03")
  ISLA_GMSLA_044_03,
  /** 
   * Pre-approved Assignments 
   */
  @SerialName("ISLA_GMSLA_044_04")
  ISLA_GMSLA_044_04,
  /** 
   * Parties May Record All Conversations 
   */
  @SerialName("ISLA_GMSLA_045_01")
  ISLA_GMSLA_045_01,
  /** 
   * Parties Agree to Obtain Consent 
   */
  @SerialName("ISLA_GMSLA_045_02")
  ISLA_GMSLA_045_02,
  /** 
   * Parties Limit the Conversations that May be Recorded 
   */
  @SerialName("ISLA_GMSLA_045_03")
  ISLA_GMSLA_045_03,
  /** 
   * Submission as Evidence 
   */
  @SerialName("ISLA_GMSLA_045_04")
  ISLA_GMSLA_045_04,
  /** 
   * Standard Waiver of Immunity Applies 
   */
  @SerialName("ISLA_GMSLA_046_01")
  ISLA_GMSLA_046_01,
  /** 
   * Waiver of Immunity may Not Apply 
   */
  @SerialName("ISLA_GMSLA_046_02")
  ISLA_GMSLA_046_02,
  /** 
   * No Additional Documentation Required 
   */
  @SerialName("ISLA_GMSLA_047_01")
  ISLA_GMSLA_047_01,
  /** 
   * Additional Documentation Required 
   */
  @SerialName("ISLA_GMSLA_047_02")
  ISLA_GMSLA_047_02,
  /** 
   * Collateral Transfer Details not included 
   */
  @SerialName("ISLA_GMSLA_048_01")
  ISLA_GMSLA_048_01,
  /** 
   * Collateral Transfer Details included 
   */
  @SerialName("ISLA_GMSLA_048_02")
  ISLA_GMSLA_048_02,
  /** 
   * Confidentiality Clause 
   */
  @SerialName("ISLA_GMSLA_049_01")
  ISLA_GMSLA_049_01,
  /** 
   * Permitted Disclosure Clause 
   */
  @SerialName("ISLA_GMSLA_049_02")
  ISLA_GMSLA_049_02,
  /** 
   * Paragraph 20.1 Amended to Refer  Paragraph 6 
   */
  @SerialName("ISLA_GMSLA_050_01")
  ISLA_GMSLA_050_01,
  /** 
   * Paragraph 27.2 Amended to refer to the 2010 GMSLA 
   */
  @SerialName("ISLA_GMSLA_050_02")
  ISLA_GMSLA_050_02,
  /** 
   * MCTA  Delivery only 
   */
  @SerialName("ISLA_GMSLA_051_01")
  ISLA_GMSLA_051_01,
  /** 
   * MCTA  Delivery and Re-Delivery 
   */
  @SerialName("ISLA_GMSLA_051_02")
  ISLA_GMSLA_051_02,
  /** 
   * MCTA  Drops to Zero for a Defaulting Party 
   */
  @SerialName("ISLA_GMSLA_051_03")
  ISLA_GMSLA_051_03,
  /** 
   * No Non-Reliance Representation 
   */
  @SerialName("ISLA_GMSLA_052_01")
  ISLA_GMSLA_052_01,
  /** 
   * Non-Reliance Representation Added 
   */
  @SerialName("ISLA_GMSLA_052_02")
  ISLA_GMSLA_052_02,
  /** 
   * No Records and Statements Clause 
   */
  @SerialName("ISLA_GMSLA_053_01")
  ISLA_GMSLA_053_01,
  /** 
   * Records and Statements Clause Added 
   */
  @SerialName("ISLA_GMSLA_053_02")
  ISLA_GMSLA_053_02,
  /** 
   * Recovery and Resolution not Included 
   */
  @SerialName("ISLA_GMSLA_054_01")
  ISLA_GMSLA_054_01,
  /** 
   * Recovery and Resolution Included in GMSLA 
   */
  @SerialName("ISLA_GMSLA_054_02")
  ISLA_GMSLA_054_02,
  /** 
   * Recovery and Resolution Included by Protocol 
   */
  @SerialName("ISLA_GMSLA_054_03")
  ISLA_GMSLA_054_03,
  /** 
   * Recovery and Resolution Incorporated by Reference 
   */
  @SerialName("ISLA_GMSLA_054_04")
  ISLA_GMSLA_054_04,
  /** 
   * Security Agreement Details Included 
   */
  @SerialName("ISLA_GMSLA_055_01")
  ISLA_GMSLA_055_01,
  /** 
   * Triparty Services Not Referenced 
   */
  @SerialName("ISLA_GMSLA_056_01")
  ISLA_GMSLA_056_01,
  /** 
   * Triparty Services May Apply 
   */
  @SerialName("ISLA_GMSLA_056_02")
  ISLA_GMSLA_056_02
  ;
}

/** 
 * The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction. 
 */
@Serializable
enum class MasterConfirmationAnnexTypeEnum {
  /** 
   * The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER")
  ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,
  /** 
   * The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER")
  ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,
  /** 
   * The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN")
  ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN,
  /** 
   * The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN")
  ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN,
  /** 
   * The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER")
  ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,
  /** 
   * The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER")
  ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,
  /** 
   * The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_OPTION_EUROPEAN")
  ISDA_2007_VARIANCE_OPTION_EUROPEAN,
  /** 
   * The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN")
  ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN,
  /** 
   * The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1")
  ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1,
  /** 
   * The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN")
  ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN,
  /** 
   * The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1")
  ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1,
  /** 
   * The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_OPTION_JAPAN")
  ISDA_2008_EQUITY_OPTION_JAPAN,
  /** 
   * The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN")
  ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN,
  /** 
   * The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_EQUITY_EUROPEAN_IS")
  ISDA_2009_EQUITY_EUROPEAN_IS,
  /** 
   * The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS")
  ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS,
  /** 
   * The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_INDEX_SHARE_OPTION_AMERICAS")
  ISDA_2009_INDEX_SHARE_OPTION_AMERICAS,
  /** 
   * The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER")
  ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER,
  /** 
   * The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER")
  ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER,
  /** 
   * The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_SHARE_SWAP_PAN_ASIA")
  ISDA_2009_SHARE_SWAP_PAN_ASIA,
  /** 
   * The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER")
  ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER,
  /** 
   * The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER")
  ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER
  ;
}

/** 
 * The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints. 
 */
@Serializable
enum class MasterConfirmationTypeEnum {
  /** 
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation. 
   */
  @SerialName("DJ.CDX.EM")
  DJ_CDX_EM,
  /** 
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation. 
   */
  @SerialName("DJ.CDX.EM.DIV")
  DJ_CDX_EM_DIV,
  /** 
   * Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO. 
   */
  @SerialName("DJ.CDX.NA")
  DJ_CDX_NA,
  /** 
   * Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement. 
   */
  @SerialName("DJ.iTraxx.Europe")
  DJ_I_TRAXX_EUROPE,
  /** 
   * A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement. 
   */
  @SerialName("EQUITY_AMERICAS")
  EQUITY_AMERICAS,
  /** 
   * A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement. 
   */
  @SerialName("EQUITY_ASIA")
  EQUITY_ASIA,
  /** 
   * A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement. 
   */
  @SerialName("EQUITY_EUROPEAN")
  EQUITY_EUROPEAN,
  /** 
   * ISDA 1999 Master Credit Derivatives Confirmation Agreement 
   */
  @SerialName("ISDA_1999_CREDIT")
  ISDA_1999_CREDIT,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_ASIA")
  ISDA_2003_CREDIT_ASIA,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND")
  ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_EUROPEAN")
  ISDA_2003_CREDIT_EUROPEAN,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_JAPAN")
  ISDA_2003_CREDIT_JAPAN,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_NORTH_AMERICAN")
  ISDA_2003_CREDIT_NORTH_AMERICAN,
  /** 
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2003_CREDIT_SINGAPORE")
  ISDA_2003_CREDIT_SINGAPORE,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_ASIA")
  ISDA_2003_CREDIT_SOVEREIGN_ASIA,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE")
  ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_JAPAN")
  ISDA_2003_CREDIT_SOVEREIGN_JAPAN,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA")
  ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST")
  ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST,
  /** 
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004. 
   */
  @SerialName("ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE")
  ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_ASIA")
  ISDA_2003_STANDARD_CREDIT_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND")
  ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_EUROPEAN")
  ISDA_2003_STANDARD_CREDIT_EUROPEAN,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_JAPAN")
  ISDA_2003_STANDARD_CREDIT_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN")
  ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign. 
   */
  @SerialName("ISDA_2003_STANDARD_CREDIT_SINGAPORE")
  ISDA_2003_STANDARD_CREDIT_SINGAPORE,
  /** 
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2004_CREDIT_SOVEREIGN_ASIA")
  ISDA_2004_CREDIT_SOVEREIGN_ASIA,
  /** 
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN")
  ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,
  /** 
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2004_CREDIT_SOVEREIGN_JAPAN")
  ISDA_2004_CREDIT_SOVEREIGN_JAPAN,
  /** 
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN")
  ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN,
  /** 
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement. 
   */
  @SerialName("ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN")
  ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,
  /** 
   * The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2004_EQUITY_AMERICAS_INTERDEALER")
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER,
  /** 
   * The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1")
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAsiaSovereign. 
   */
  @SerialName("ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA")
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign. 
   */
  @SerialName("ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN")
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign. 
   */
  @SerialName("ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN")
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign. 
   */
  @SerialName("ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN")
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign. 
   */
  @SerialName("ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN")
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,
  /** 
   * ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER")
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER,
  /** 
   * Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2")
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2,
  /** 
   * The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2005_EQUITY_JAPANESE_INTERDEALER")
  ISDA_2005_EQUITY_JAPANESE_INTERDEALER,
  /** 
   * ISDA 2006 Variance Swap Japanese Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2006_VARIANCE_SWAP_JAPANESE")
  ISDA_2006_VARIANCE_SWAP_JAPANESE,
  /** 
   * ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER")
  ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER,
  /** 
   * The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_EQUITY_EUROPEAN")
  ISDA_2007_EQUITY_EUROPEAN,
  /** 
   * The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_AMERICAS")
  ISDA_2007_VARIANCE_SWAP_AMERICAS,
  /** 
   * The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN")
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN,
  /** 
   * The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1")
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1,
  /** 
   * The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2")
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2,
  /** 
   * The ISDA 2007 European Variance Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_EUROPEAN")
  ISDA_2007_VARIANCE_SWAP_EUROPEAN,
  /** 
   * The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1")
  ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1,
  /** 
   * The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_DIVIDEND_SWAP_JAPAN")
  ISDA_2008_DIVIDEND_SWAP_JAPAN,
  /** 
   * The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1")
  ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1,
  /** 
   * The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_AMERICAS")
  ISDA_2008_EQUITY_AMERICAS,
  /** 
   * The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN")
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN,
  /** 
   * The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1")
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1,
  /** 
   * The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2008_EQUITY_JAPAN")
  ISDA_2008_EQUITY_JAPAN,
  /** 
   * The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_EQUITY_AMERICAS")
  ISDA_2009_EQUITY_AMERICAS,
  /** 
   * The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_EQUITY_EUROPEAN_INTERDEALER")
  ISDA_2009_EQUITY_EUROPEAN_INTERDEALER,
  /** 
   * 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2009_EQUITY_PAN_ASIA")
  ISDA_2009_EQUITY_PAN_ASIA,
  /** 
   * The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2010_EQUITY_EMEA_INTERDEALER")
  ISDA_2010_EQUITY_EMEA_INTERDEALER,
  /** 
   * The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2013_VOLATILITY_SWAP_AMERICAS")
  ISDA_2013_VOLATILITY_SWAP_AMERICAS,
  /** 
   * The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN")
  ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN,
  /** 
   * The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2013_VOLATILITY_SWAP_EUROPEAN")
  ISDA_2013_VOLATILITY_SWAP_EUROPEAN,
  /** 
   * The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies. 
   */
  @SerialName("ISDA_2013_VOLATILITY_SWAP_JAPANESE")
  ISDA_2013_VOLATILITY_SWAP_JAPANESE,
  /** 
   * Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies. 
   */
  @SerialName("2003CreditIndex")
  _2003_CREDIT_INDEX,
  /** 
   * A privately negotiated European Interdealer Master Confirmation Agreement applies. 
   */
  @SerialName("2004EquityEuropeanInterdealer")
  _2004_EQUITY_EUROPEAN_INTERDEALER,
  /** 
   * A privately negotiated European Interdealer Master Confirmation Agreement applies. 
   */
  @SerialName("2005VarianceSwapEuropeanInterdealer")
  _2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER,
  /** 
   * A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies. 
   */
  @SerialName("2006DividendSwapEuropean")
  _2006_DIVIDEND_SWAP_EUROPEAN,
  /** 
   * A European Interdealer Master Confirmation Agreement not defined by ISDA applies. 
   */
  @SerialName("2006DividendSwapEuropeanInterdealer")
  _2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER,
  /** 
   * Dummy MCA value mirroring the matrix term value AsiaCorporate. 
   */
  @SerialName("2014CreditAsia")
  _2014_CREDIT_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate. 
   */
  @SerialName("2014CreditAsiaFinancial")
  _2014_CREDIT_ASIA_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate. 
   */
  @SerialName("2014CreditAustraliaNewZealand")
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND,
  /** 
   * Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate. 
   */
  @SerialName("2014CreditAustraliaNewZealandFinancial")
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value EuropeanCorporate. 
   */
  @SerialName("2014CreditEuropean")
  _2014_CREDIT_EUROPEAN,
  /** 
   * Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate. 
   */
  @SerialName("2014CreditEuropeanCoCoFinancial")
  _2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate. 
   */
  @SerialName("2014CreditEuropeanFinancial")
  _2014_CREDIT_EUROPEAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value JapanCorporate. 
   */
  @SerialName("2014CreditJapan")
  _2014_CREDIT_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value JapanFinancialCorporate. 
   */
  @SerialName("2014CreditJapanFinancial")
  _2014_CREDIT_JAPAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value NorthAmericanCorporate. 
   */
  @SerialName("2014CreditNorthAmerican")
  _2014_CREDIT_NORTH_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate. 
   */
  @SerialName("2014CreditNorthAmericanFinancial")
  _2014_CREDIT_NORTH_AMERICAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term values SingaporeCorporate. 
   */
  @SerialName("2014CreditSingapore")
  _2014_CREDIT_SINGAPORE,
  /** 
   * Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate. 
   */
  @SerialName("2014CreditSingaporeFinancial")
  _2014_CREDIT_SINGAPORE_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value AsiaSovereign. 
   */
  @SerialName("2014CreditSovereignAsia")
  _2014_CREDIT_SOVEREIGN_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign. 
   */
  @SerialName("2014CreditSovereignEmergingEuropeanAndMiddleEastern")
  _2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,
  /** 
   * Dummy MCA value mirroring the matrix term value JapanSovereign. 
   */
  @SerialName("2014CreditSovereignJapan")
  _2014_CREDIT_SOVEREIGN_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value LatinAmericaSovereign. 
   */
  @SerialName("2014CreditSovereignLatinAmerican")
  _2014_CREDIT_SOVEREIGN_LATIN_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign. 
   */
  @SerialName("2014CreditSovereignWesternEuropean")
  _2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate. 
   */
  @SerialName("2014StandardCreditAsia")
  _2014_STANDARD_CREDIT_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate. 
   */
  @SerialName("2014StandardCreditAsiaFinancial")
  _2014_STANDARD_CREDIT_ASIA_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate. 
   */
  @SerialName("2014StandardCreditAustraliaNewZealand")
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate. 
   */
  @SerialName("2014StandardCreditAustraliaNewZealandFinancial")
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate. 
   */
  @SerialName("2014StandardCreditEuropean")
  _2014_STANDARD_CREDIT_EUROPEAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate. 
   */
  @SerialName("2014StandardCreditEuropeanCoCoFinancial")
  _2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate. 
   */
  @SerialName("2014StandardCreditEuropeanFinancial")
  _2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate. 
   */
  @SerialName("2014StandardCreditJapan")
  _2014_STANDARD_CREDIT_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate. 
   */
  @SerialName("2014StandardCreditJapanFinancial")
  _2014_STANDARD_CREDIT_JAPAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate. 
   */
  @SerialName("2014StandardCreditNorthAmerican")
  _2014_STANDARD_CREDIT_NORTH_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate. 
   */
  @SerialName("2014StandardCreditNorthAmericanFinancial")
  _2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate. 
   */
  @SerialName("2014StandardCreditSingapore")
  _2014_STANDARD_CREDIT_SINGAPORE,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate. 
   */
  @SerialName("2014StandardCreditSingaporeFinancial")
  _2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardAsiaSovereign. 
   */
  @SerialName("2014StandardCreditSovereignAsia")
  _2014_STANDARD_CREDIT_SOVEREIGN_ASIA,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign. 
   */
  @SerialName("2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern")
  _2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,
  /** 
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign. 
   */
  @SerialName("2014StandardCreditSovereignJapan")
  _2014_STANDARD_CREDIT_SOVEREIGN_JAPAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign. 
   */
  @SerialName("2014StandardCreditSovereignLatinAmerican")
  _2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN,
  /** 
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign. 
   */
  @SerialName("2014StandardCreditSovereignWesternEuropean")
  _2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN
  ;
}

/** 
 * The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix. 
 */
@Serializable
enum class MatrixTermEnum {
  /** 
   * Matrix Transaction Type of ASIA CORPORATE. 
   */
  @SerialName("ASIA_CORPORATE")
  ASIA_CORPORATE,
  /** 
   * Matrix Transaction Type of ASIA FINANCIAL CORPORATE. 
   */
  @SerialName("ASIA_FINANCIAL_CORPORATE")
  ASIA_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of ASIA SOVEREIGN. 
   */
  @SerialName("ASIA_SOVEREIGN")
  ASIA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of AUSTRALIA CORPORATE. 
   */
  @SerialName("AUSTRALIA_CORPORATE")
  AUSTRALIA_CORPORATE,
  /** 
   * Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE. 
   */
  @SerialName("AUSTRALIA_FINANCIAL_CORPORATE")
  AUSTRALIA_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of AUSTRALIA SOVEREIGN. 
   */
  @SerialName("AUSTRALIA_SOVEREIGN")
  AUSTRALIA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN. 
   */
  @SerialName("EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN")
  EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,
  /** 
   * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE. 
   */
  @SerialName("EMERGING_EUROPEAN_CORPORATE")
  EMERGING_EUROPEAN_CORPORATE,
  /** 
   * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN. 
   */
  @SerialName("EMERGING_EUROPEAN_CORPORATE_LPN")
  EMERGING_EUROPEAN_CORPORATE_LPN,
  /** 
   * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE. 
   */
  @SerialName("EMERGING_EUROPEAN_FINANCIAL_CORPORATE")
  EMERGING_EUROPEAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN. 
   */
  @SerialName("EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN")
  EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN,
  /** 
   * Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE. 
   */
  @SerialName("EUROPEAN_CO_CO_FINANCIAL_CORPORATE")
  EUROPEAN_CO_CO_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of EUROPEAN CORPORATE. 
   */
  @SerialName("EUROPEAN_CORPORATE")
  EUROPEAN_CORPORATE,
  /** 
   * Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE. 
   */
  @SerialName("EUROPEAN_FINANCIAL_CORPORATE")
  EUROPEAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE. 
   */
  @SerialName("EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE")
  EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE,
  /** 
   * The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets. 
   */
  @SerialName("IVS_1_OPEN_MARKETS")
  IVS_1_OPEN_MARKETS,
  /** 
   * Matrix Transaction Type of JAPAN CORPORATE. 
   */
  @SerialName("JAPAN_CORPORATE")
  JAPAN_CORPORATE,
  /** 
   * Matrix Transaction Type of JAPAN FINANCIAL CORPORATE. 
   */
  @SerialName("JAPAN_FINANCIAL_CORPORATE")
  JAPAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of JAPAN SOVEREIGN. 
   */
  @SerialName("JAPAN_SOVEREIGN")
  JAPAN_SOVEREIGN,
  /** 
   * Matrix Transaction Type of LATIN AMERICA CORPORATE. 
   */
  @SerialName("LATIN_AMERICA_CORPORATE")
  LATIN_AMERICA_CORPORATE,
  /** 
   * Matrix Transaction Type of LATIN AMERICA CORPORATE B. 
   */
  @SerialName("LATIN_AMERICA_CORPORATE_BOND")
  LATIN_AMERICA_CORPORATE_BOND,
  /** 
   * Matrix Transaction Type of LATIN AMERICA CORPORATE BL. 
   */
  @SerialName("LATIN_AMERICA_CORPORATE_BOND_OR_LOAN")
  LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,
  /** 
   * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B. 
   */
  @SerialName("LATIN_AMERICA_FINANCIAL_CORPORATE_BOND")
  LATIN_AMERICA_FINANCIAL_CORPORATE_BOND,
  /** 
   * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL. 
   */
  @SerialName("LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN")
  LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN,
  /** 
   * Matrix Transaction Type of LATIN AMERICA SOVEREIGN. 
   */
  @SerialName("LATIN_AMERICA_SOVEREIGN")
  LATIN_AMERICA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of NEW ZEALAND CORPORATE. 
   */
  @SerialName("NEW_ZEALAND_CORPORATE")
  NEW_ZEALAND_CORPORATE,
  /** 
   * Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE. 
   */
  @SerialName("NEW_ZEALAND_FINANCIAL_CORPORATE")
  NEW_ZEALAND_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of NEW ZEALAND SOVEREIGN. 
   */
  @SerialName("NEW_ZEALAND_SOVEREIGN")
  NEW_ZEALAND_SOVEREIGN,
  /** 
   * Matrix Transaction Type of NORTH AMERICAN CORPORATE. 
   */
  @SerialName("NORTH_AMERICAN_CORPORATE")
  NORTH_AMERICAN_CORPORATE,
  /** 
   * Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE. 
   */
  @SerialName("NORTH_AMERICAN_FINANCIAL_CORPORATE")
  NORTH_AMERICAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of SINGAPORE CORPORATE. 
   */
  @SerialName("SINGAPORE_CORPORATE")
  SINGAPORE_CORPORATE,
  /** 
   * Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE. 
   */
  @SerialName("SINGAPORE_FINANCIAL_CORPORATE")
  SINGAPORE_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of SINGAPORE SOVEREIGN. 
   */
  @SerialName("SINGAPORE_SOVEREIGN")
  SINGAPORE_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD ASIA CORPORATE. 
   */
  @SerialName("STANDARD_ASIA_CORPORATE")
  STANDARD_ASIA_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_ASIA_FINANCIAL_CORPORATE")
  STANDARD_ASIA_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD ASIA SOVEREIGN. 
   */
  @SerialName("STANDARD_ASIA_SOVEREIGN")
  STANDARD_ASIA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE. 
   */
  @SerialName("STANDARD_AUSTRALIA_CORPORATE")
  STANDARD_AUSTRALIA_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_AUSTRALIA_FINANCIAL_CORPORATE")
  STANDARD_AUSTRALIA_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN. 
   */
  @SerialName("STANDARD_AUSTRALIA_SOVEREIGN")
  STANDARD_AUSTRALIA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN. 
   */
  @SerialName("STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN")
  STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE. 
   */
  @SerialName("STANDARD_EMERGING_EUROPEAN_CORPORATE")
  STANDARD_EMERGING_EUROPEAN_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN. 
   */
  @SerialName("STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN")
  STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN,
  /** 
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE")
  STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN. 
   */
  @SerialName("STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN")
  STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN,
  /** 
   * Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE")
  STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD EUROPEAN CORPORATE. 
   */
  @SerialName("STANDARD_EUROPEAN_CORPORATE")
  STANDARD_EUROPEAN_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_EUROPEAN_FINANCIAL_CORPORATE")
  STANDARD_EUROPEAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE")
  STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD JAPAN CORPORATE. 
   */
  @SerialName("STANDARD_JAPAN_CORPORATE")
  STANDARD_JAPAN_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_JAPAN_FINANCIAL_CORPORATE")
  STANDARD_JAPAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD JAPAN SOVEREIGN. 
   */
  @SerialName("STANDARD_JAPAN_SOVEREIGN")
  STANDARD_JAPAN_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B. 
   */
  @SerialName("STANDARD_LATIN_AMERICA_CORPORATE_BOND")
  STANDARD_LATIN_AMERICA_CORPORATE_BOND,
  /** 
   * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL. 
   */
  @SerialName("STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN")
  STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,
  /** 
   * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B. 
   */
  @SerialName("STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND")
  STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND,
  /** 
   * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL. 
   */
  @SerialName("STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN")
  STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN,
  /** 
   * Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN. 
   */
  @SerialName("STANDARD_LATIN_AMERICA_SOVEREIGN")
  STANDARD_LATIN_AMERICA_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE. 
   */
  @SerialName("STANDARD_NEW_ZEALAND_CORPORATE")
  STANDARD_NEW_ZEALAND_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE")
  STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN. 
   */
  @SerialName("STANDARD_NEW_ZEALAND_SOVEREIGN")
  STANDARD_NEW_ZEALAND_SOVEREIGN,
  /** 
   * Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE. 
   */
  @SerialName("STANDARD_NORTH_AMERICAN_CORPORATE")
  STANDARD_NORTH_AMERICAN_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE")
  STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD SINGAPORE CORPORATE. 
   */
  @SerialName("STANDARD_SINGAPORE_CORPORATE")
  STANDARD_SINGAPORE_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_SINGAPORE_FINANCIAL_CORPORATE")
  STANDARD_SINGAPORE_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN. 
   */
  @SerialName("STANDARD_SINGAPORE_SOVEREIGN")
  STANDARD_SINGAPORE_SOVEREIGN,
  /** 
   * Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE. 
   */
  @SerialName("STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE")
  STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE. 
   */
  @SerialName("STANDARD_SUKUK_FINANCIAL_CORPORATE")
  STANDARD_SUKUK_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT. 
   */
  @SerialName("STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT")
  STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT,
  /** 
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND. 
   */
  @SerialName("STANDARD_US_MUNICIPAL_GENERAL_FUND")
  STANDARD_US_MUNICIPAL_GENERAL_FUND,
  /** 
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE. 
   */
  @SerialName("STANDARD_US_MUNICIPAL_REVENUE")
  STANDARD_US_MUNICIPAL_REVENUE,
  /** 
   * Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN. 
   */
  @SerialName("STANDARD_WESTERN_EUROPEAN_SOVEREIGN")
  STANDARD_WESTERN_EUROPEAN_SOVEREIGN,
  /** 
   * Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE. 
   */
  @SerialName("SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE")
  SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,
  /** 
   * Matrix Transaction Type of SUKUK CORPORATE. 
   */
  @SerialName("SUKUK_CORPORATE")
  SUKUK_CORPORATE,
  /** 
   * Matrix Transaction Type of SUKUK FINANCIAL CORPORATE. 
   */
  @SerialName("SUKUK_FINANCIAL_CORPORATE")
  SUKUK_FINANCIAL_CORPORATE,
  /** 
   * Matrix Transaction Type of SUKUK SOVEREIGN. 
   */
  @SerialName("SUKUK_SOVEREIGN")
  SUKUK_SOVEREIGN,
  /** 
   * Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT. 
   */
  @SerialName("US_MUNICIPAL_FULL_FAITH_AND_CREDIT")
  US_MUNICIPAL_FULL_FAITH_AND_CREDIT,
  /** 
   * Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND. 
   */
  @SerialName("US_MUNICIPAL_GENERAL_FUND")
  US_MUNICIPAL_GENERAL_FUND,
  /** 
   * Matrix Transaction Type of U.S. MUNICIPAL REVENUE. 
   */
  @SerialName("US_MUNICIPAL_REVENUE")
  US_MUNICIPAL_REVENUE,
  /** 
   * Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN. 
   */
  @SerialName("WESTERN_EUROPEAN_SOVEREIGN")
  WESTERN_EUROPEAN_SOVEREIGN
  ;
}

/** 
 * The enumerated values to specify the identification the form of applicable matrix. 
 */
@Serializable
enum class MatrixTypeEnum {
  /** 
   * The ISDA-published Credit Derivatives Physical Settlement Matrix. 
   */
  @SerialName("CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")
  CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX,
  /** 
   * The ISDA-published Equity Derivatives Matrix. 
   */
  @SerialName("EQUITY_DERIVATIVES_MATRIX")
  EQUITY_DERIVATIVES_MATRIX,
  /** 
   * The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions. 
   */
  @SerialName("SETTLEMENT_MATRIX")
  SETTLEMENT_MATRIX
  ;
}

/** 
 * Represents an enumeration list to identify the Maturity. 
 */
@Serializable
enum class MaturityTypeEnum {
  /** 
   * Denotes a period from issuance date until now. 
   */
  @SerialName("FROM_ISSUANCE")
  FROM_ISSUANCE,
  /** 
   * Denotes a period from issuance until maturity date. 
   */
  @SerialName("ORIGINAL_MATURITY")
  ORIGINAL_MATURITY,
  /** 
   * Denotes a period from now until maturity date. 
   */
  @SerialName("REMAINING_MATURITY")
  REMAINING_MATURITY
  ;
}

@Serializable
enum class MoneyMarketTypeEnum {
  @SerialName("CERTIFICATE_OF_DEPOSIT")
  CERTIFICATE_OF_DEPOSIT,
  @SerialName("COMMERCIAL_PAPER")
  COMMERCIAL_PAPER
  ;
}

/** 
 * Defines the consequences of nationalization, insolvency and delisting events relating to the underlying. 
 */
@Serializable
enum class NationalizationOrInsolvencyOrDelistingEventEnum {
  /** 
   * The trade is terminated. 
   */
  @SerialName("CANCELLATION_AND_PAYMENT")
  CANCELLATION_AND_PAYMENT,
  /** 
   * The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues. 
   */
  @SerialName("NEGOTIATED_CLOSEOUT")
  NEGOTIATED_CLOSEOUT
  ;
}

/** 
 * The enumerated values for the natural person's role. 
 */
@Serializable
enum class NaturalPersonRoleEnum {
  /** 
   * The person who arranged with a client to execute the trade. 
   */
  @SerialName("BROKER")
  BROKER,
  /** 
   * Acquirer of the legal title to the financial instrument. 
   */
  @SerialName("BUYER")
  BUYER,
  /** 
   * The party or person with legal responsibility for authorization of the execution of the transaction. 
   */
  @SerialName("DECISION_MAKER")
  DECISION_MAKER,
  /** 
   * Person within the firm who is responsible for execution of the transaction. 
   */
  @SerialName("EXECUTION_WITHIN_FIRM")
  EXECUTION_WITHIN_FIRM,
  /** 
   * Person who is responsible for making the investment decision. 
   */
  @SerialName("INVESTMENT_DECISION_MAKER")
  INVESTMENT_DECISION_MAKER,
  /** 
   * Seller of the legal title to the financial instrument. 
   */
  @SerialName("SELLER")
  SELLER,
  /** 
   * The person who executed the trade. 
   */
  @SerialName("TRADER")
  TRADER
  ;
}

/** 
 * The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate). 
 */
@Serializable
enum class NegativeInterestRateTreatmentEnum {
  /** 
   * Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c). 
   */
  @SerialName("NEGATIVE_INTEREST_RATE_METHOD")
  NEGATIVE_INTEREST_RATE_METHOD,
  /** 
   * Per 2021 ISDA Definitions section 6.8.6 
   */
  @SerialName("ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD")
  ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD,
  /** 
   * Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e). 
   */
  @SerialName("ZERO_INTEREST_RATE_METHOD")
  ZERO_INTEREST_RATE_METHOD
  ;
}

/** 
 * The enumerated values to specify the treatment of Non-Cash Dividends. 
 */
@Serializable
enum class NonCashDividendTreatmentEnum {
  /** 
   * Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend. 
   */
  @SerialName("CASH_EQUIVALENT")
  CASH_EQUIVALENT,
  /** 
   * The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions. 
   */
  @SerialName("POTENTIAL_ADJUSTMENT_EVENT")
  POTENTIAL_ADJUSTMENT_EVENT
  ;
}

/** 
 * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap. 
 */
@Serializable
enum class NotionalAdjustmentEnum {
  /** 
   * The adjustments to the number of units are governed by an execution clause. 
   */
  @SerialName("EXECUTION")
  EXECUTION,
  /** 
   * The adjustments to the number of units are governed by a portfolio rebalancing clause. 
   */
  @SerialName("PORTFOLIO_REBALANCING")
  PORTFOLIO_REBALANCING,
  /** 
   * The adjustments to the number of units are not governed by any specific clause. 
   */
  @SerialName("STANDARD")
  STANDARD
  ;
}

/** 
 * The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply. 
 */
@Serializable
enum class ObligationCategoryEnum {
  /** 
   * ISDA term 'Bond'. 
   */
  @SerialName("BOND")
  BOND,
  /** 
   * ISDA term 'Bond or Loan'. 
   */
  @SerialName("BOND_OR_LOAN")
  BOND_OR_LOAN,
  /** 
   * ISDA term 'Borrowed Money'. 
   */
  @SerialName("BORROWED_MONEY")
  BORROWED_MONEY,
  /** 
   * ISDA term 'Loan'. 
   */
  @SerialName("LOAN")
  LOAN,
  /** 
   * ISDA term 'Payment'. 
   */
  @SerialName("PAYMENT")
  PAYMENT,
  /** 
   * ISDA term 'Reference Obligations Only'. 
   */
  @SerialName("REFERENCE_OBLIGATIONS_ONLY")
  REFERENCE_OBLIGATIONS_ONLY
  ;
}

/** 
 * The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7. 
 */
@Serializable
enum class ObservationPeriodDatesEnum {
  /** 
   * Calculations occur relative to a previously defined reset date, e.g. for a fallback rate. 
   */
  @SerialName("FIXING_DATE")
  FIXING_DATE,
  /** 
   * Calculations occur relative to the first day of a calculation period. 
   */
  @SerialName("SET_IN_ADVANCE")
  SET_IN_ADVANCE,
  /** 
   * Calculations occur relative to the last day of a calculation period (set in arrears). 
   */
  @SerialName("STANDARD")
  STANDARD
  ;
}

/** 
 * The enumerated values to specify the option exercise style. i.e., European, Bermuda or American. 
 */
@Serializable
enum class OptionExerciseStyleEnum {
  /** 
   * Continuous exercise over a range of dates 
   */
  @SerialName("AMERICAN")
  AMERICAN,
  /** 
   * Multiple specified exercise dates 
   */
  @SerialName("BERMUDA")
  BERMUDA,
  /** 
   * Single Exercise 
   */
  @SerialName("EUROPEAN")
  EUROPEAN
  ;
}

/** 
 * The enumerated values to specify the type or strategy of the option. 
 */
@Serializable
enum class OptionTypeEnum {
  /** 
   * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price. 
   */
  @SerialName("CALL")
  CALL,
  /** 
   * A 'payer' option: If you buy a 'payer' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price payer and receive float. 
   */
  @SerialName("PAYER")
  PAYER,
  /** 
   * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price. 
   */
  @SerialName("PUT")
  PUT,
  /** 
   * A 'receiver' option: If you buy a 'receiver' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price receiver and pay float. 
   */
  @SerialName("RECEIVER")
  RECEIVER,
  /** 
   * A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date 
   */
  @SerialName("STRADDLE")
  STRADDLE
  ;
}

/** 
 * The enumerated values to specify how a calculation agent will be determined. 
 */
@Serializable
enum class PartyDeterminationEnum {
  /** 
   * The Calculation Agent is determined by reference to the relevant master agreement. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_AGREEMENT")
  AS_SPECIFIED_IN_MASTER_AGREEMENT,
  /** 
   * The Calculation Agent is determined by reference to the relevant standard terms supplement. 
   */
  @SerialName("AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT")
  AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT,
  /** 
   * Both parties with joined rights to be a calculation agent. 
   */
  @SerialName("BOTH")
  BOTH,
  /** 
   * The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d). 
   */
  @SerialName("EXERCISING_PARTY")
  EXERCISING_PARTY,
  /** 
   * The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e). 
   */
  @SerialName("NON_EXERCISING_PARTY")
  NON_EXERCISING_PARTY
  ;
}

/** 
 * The enumeration values associated with party identifier sources. 
 */
@Serializable
enum class PartyIdentifierTypeEnum {
  /** 
   * The Bank Identifier Code. 
   */
  @SerialName("BIC")
  BIC,
  /** 
   * The ISO 17442:2012 Legal Entity Identifier. 
   */
  @SerialName("LEI")
  LEI,
  /** 
   * The ISO 10383 Market Identifier Code (MIC). 
   */
  @SerialName("MIC")
  MIC
  ;
}

/** 
 * The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party. 
 */
@Serializable
enum class PartyRoleEnum {
  /** 
   * Organization responsible for preparing the accounting for the trade. 
   */
  @SerialName("ACCOUNTANT")
  ACCOUNTANT,
  /** 
   * An agent who lends securities of its principals under stock lending arrangements. 
   */
  @SerialName("AGENT_LENDER")
  AGENT_LENDER,
  /** 
   * The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations. 
   */
  @SerialName("ALLOCATION_AGENT")
  ALLOCATION_AGENT,
  /** 
   * The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent. 
   */
  @SerialName("ARRANGING_BROKER")
  ARRANGING_BROKER,
  /** 
   * The party specified in the related confirmation as Barrier Determination Agent. 
   */
  @SerialName("BARRIER_DETERMINATION_AGENT")
  BARRIER_DETERMINATION_AGENT,
  /** 
   * The party that lends out securities under stock lending arrangements via an Agent Lender. 
   */
  @SerialName("BENEFICIAL_OWNER")
  BENEFICIAL_OWNER,
  /** 
   * Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of 'Beneficiary' at the partyTradeInformation level. 
   */
  @SerialName("BENEFICIARY")
  BENEFICIARY,
  /** 
   * The entity for which the organization supporting the trade's processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn't need to be reported but a firm still wants to specify their own side. 
   */
  @SerialName("BOOKING_PARTY")
  BOOKING_PARTY,
  /** 
   * The party that borrows securities under stock lending arrangements. 
   */
  @SerialName("BORROWER")
  BORROWER,
  /** 
   * Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the 'Buy side'; for that, see the 'Client' role. Corresponds to 'Buyer' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9. 
   */
  @SerialName("BUYER")
  BUYER,
  /** 
   * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to 'buyer decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Buy side'; for that, see the 'Client Decision Maker' role. 
   */
  @SerialName("BUYER_DECISION_MAKER")
  BUYER_DECISION_MAKER,
  /** 
   * The party that provides credit support under English Law. 
   */
  @SerialName("CHARGOR")
  CHARGOR,
  /** 
   * An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term 'client' refers to the organization's role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process. 
   */
  @SerialName("CLEARING_CLIENT")
  CLEARING_CLIENT,
  /** 
   * A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions. 
   */
  @SerialName("CLEARING_EXCEPTION_PARTY")
  CLEARING_EXCEPTION_PARTY,
  /** 
   * Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use 'Clearing Broker' as synonym. 
   */
  @SerialName("CLEARING_FIRM")
  CLEARING_FIRM,
  /** 
   * The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called 'ClearingService'. Some implementations also use the term 'Clearer'. 
   */
  @SerialName("CLEARING_ORGANIZATION")
  CLEARING_ORGANIZATION,
  /** 
   * Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances. 
   */
  @SerialName("CLIENT")
  CLIENT,
  /** 
   * The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument. 
   */
  @SerialName("CLIENT_DECISION_MAKER")
  CLIENT_DECISION_MAKER,
  /** 
   * Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data. 
   */
  @SerialName("CONFIRMATION_PLATFORM")
  CONFIRMATION_PLATFORM,
  /** 
   * A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate. 
   */
  @SerialName("CONTRACTUAL_PARTY")
  CONTRACTUAL_PARTY,
  /** 
   * Organization officially attached to the counterparty. e.g. partner, branch, subsidiary. 
   */
  @SerialName("COUNTER_PARTY_AFFILIATE")
  COUNTER_PARTY_AFFILIATE,
  /** 
   * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party. 
   */
  @SerialName("COUNTER_PARTY_ULTIMATE_PARENT")
  COUNTER_PARTY_ULTIMATE_PARENT,
  /** 
   * An economic counterparty to the trade. Synonym: principal. 
   */
  @SerialName("COUNTERPARTY")
  COUNTERPARTY,
  /** 
   * Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation). 
   */
  @SerialName("CREDIT_SUPPORT_PROVIDER")
  CREDIT_SUPPORT_PROVIDER,
  /** 
   * Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal. 
   */
  @SerialName("CUSTODIAN")
  CUSTODIAN,
  /** 
   * Entity submitting the transaction report to the competent authority. 
   */
  @SerialName("DATA_SUBMITTER")
  DATA_SUBMITTER,
  /** 
   * The party referenced is specified in the contract confirmation as Determination Party. 
   */
  @SerialName("DETERMINING_PARTY")
  DETERMINING_PARTY,
  /** 
   * Organization that is disputing the trade or transaction. 
   */
  @SerialName("DISPUTING_PARTY")
  DISPUTING_PARTY,
  /** 
   * A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate. 
   */
  @SerialName("DOCUMENT_REPOSITORY")
  DOCUMENT_REPOSITORY,
  /** 
   * The (generally sell-side) organization that executed the trade; the price-making party. 
   */
  @SerialName("EXECUTING_BROKER")
  EXECUTING_BROKER,
  /** 
   * Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent. 
   */
  @SerialName("EXECUTING_ENTITY")
  EXECUTING_ENTITY,
  /** 
   * The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different. 
   */
  @SerialName("EXECUTION_AGENT")
  EXECUTION_AGENT,
  /** 
   * The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue. 
   */
  @SerialName("EXECUTION_FACILITY")
  EXECUTION_FACILITY,
  /** 
   * Organization that backs (guarantees) the credit risk of the trade. 
   */
  @SerialName("GUARANTOR")
  GUARANTOR,
  /** 
   * The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract. 
   */
  @SerialName("HEDGING_PARTY")
  HEDGING_PARTY,
  /** 
   * The party that lends out securities under stock lending arrangements as principal. 
   */
  @SerialName("LENDER")
  LENDER,
  /** 
   * The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm. 
   */
  @SerialName("ORDER_TRANSMITTER")
  ORDER_TRANSMITTER,
  /** 
   * The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR 
   */
  @SerialName("PTRR_SERVICE_PROVIDER")
  PTRR_SERVICE_PROVIDER,
  /** 
   * The party that provides credit support under New York Law. 
   */
  @SerialName("PLEDGOR")
  PLEDGOR,
  /** 
   * The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism). 
   */
  @SerialName("PRIME_BROKER")
  PRIME_BROKER,
  /** 
   * The trade repository at which the trade was reported previous to the current trade repository. 
   */
  @SerialName("PRIOR_TRADE_REPOSITORY")
  PRIOR_TRADE_REPOSITORY,
  /** 
   * The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade. 
   */
  @SerialName("PUBLICATION_VENUE")
  PUBLICATION_VENUE,
  /** 
   * The party with the regulatory responsibility to report this trade. 
   */
  @SerialName("REPORTING_PARTY")
  REPORTING_PARTY,
  /** 
   * Organization officially attached to the reporting party  e.g. partner, branch, subsidiary. 
   */
  @SerialName("REPORTING_PARTY_AFFILIATE")
  REPORTING_PARTY_AFFILIATE,
  /** 
   * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party. 
   */
  @SerialName("REPORTING_PARTY_ULTIMATE_PARENT")
  REPORTING_PARTY_ULTIMATE_PARENT,
  /** 
   * The party that receives credit support under New York or English Law. 
   */
  @SerialName("SECURED_PARTY")
  SECURED_PARTY,
  /** 
   * A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the 'Sell side'; for that, see the 'Executing Broker' role. Corresponds to 'Seller' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16. 
   */
  @SerialName("SELLER")
  SELLER,
  /** 
   * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to 'seller decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Sell side'; for that, see the 'Trader' person role. 
   */
  @SerialName("SELLER_DECISION_MAKER")
  SELLER_DECISION_MAKER,
  /** 
   * The organization that makes or receives payments on behalf of the given principal party. 
   */
  @SerialName("SETTLEMENT_AGENT")
  SETTLEMENT_AGENT,
  /** 
   * A third-party providing custody, settlement, segregation and reporting services. 
   */
  @SerialName("THIRD_PARTY_CUSTODIAN")
  THIRD_PARTY_CUSTODIAN,
  /** 
   * An organization that maintains records of the trade for regulatory reporting purposes. 
   */
  @SerialName("TRADE_REPOSITORY")
  TRADE_REPOSITORY,
  /** 
   * The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR. 
   */
  @SerialName("TRADE_SOURCE")
  TRADE_SOURCE,
  /** 
   * The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory. 
   */
  @SerialName("TRADING_MANAGER")
  TRADING_MANAGER,
  /** 
   * An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions. 
   */
  @SerialName("TRADING_PARTNER")
  TRADING_PARTNER,
  /** 
   * A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services. 
   */
  @SerialName("TRIPARTY_AGENT")
  TRIPARTY_AGENT
  ;
}

/** 
 * The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date. 
 */
@Serializable
enum class PayRelativeToEnum {
  /** 
   * Payments will occur relative to the last day of each calculation period. 
   */
  @SerialName("CALCULATION_PERIOD_END_DATE")
  CALCULATION_PERIOD_END_DATE,
  /** 
   * Payments will occur relative to the first day of each calculation period. 
   */
  @SerialName("CALCULATION_PERIOD_START_DATE")
  CALCULATION_PERIOD_START_DATE,
  /** 
   * Payments will occur relative to the last Pricing Date of each Calculation Period. 
   */
  @SerialName("LAST_PRICING_DATE")
  LAST_PRICING_DATE,
  /** 
   * Payments will occur relative to the reset date. 
   */
  @SerialName("RESET_DATE")
  RESET_DATE,
  /** 
   * Payments will occur relative to the valuation date. 
   */
  @SerialName("VALUATION_DATE")
  VALUATION_DATE
  ;
}

/** 
 * The enumerated values to specify an interest rate stream payer or receiver party. 
 */
@Serializable
enum class PayerReceiverEnum {
  /** 
   * The party identified as the stream payer. 
   */
  @SerialName("PAYER")
  PAYER,
  /** 
   * The party identified as the stream receiver. 
   */
  @SerialName("RECEIVER")
  RECEIVER
  ;
}

/** 
 * The enumerated values to specify the origin of a performance transfer 
 */
@Serializable
enum class PerformanceTransferTypeEnum {
  @SerialName("COMMODITY")
  COMMODITY,
  @SerialName("CORRELATION")
  CORRELATION,
  @SerialName("DIVIDEND")
  DIVIDEND,
  @SerialName("EQUITY")
  EQUITY,
  @SerialName("INTEREST")
  INTEREST,
  @SerialName("VARIANCE")
  VARIANCE,
  @SerialName("VOLATILITY")
  VOLATILITY
  ;
}

/** 
 * The enumerated values to specify the period, e.g. day, week. 
 */
@Serializable
enum class PeriodEnum {
  /** 
   * Day 
   */
  @SerialName("D")
  D,
  /** 
   * Month 
   */
  @SerialName("M")
  M,
  /** 
   * Week 
   */
  @SerialName("W")
  W,
  /** 
   * Year 
   */
  @SerialName("Y")
  Y
  ;
}

/** 
 * The enumerated values to specify a time period containing the additional value of Term. 
 */
@Serializable
enum class PeriodExtendedEnum {
  /** 
   * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period. 
   */
  @SerialName("C")
  C,
  /** 
   * Day 
   */
  @SerialName("D")
  D,
  /** 
   * Hour 
   */
  @SerialName("H")
  H,
  /** 
   * Month 
   */
  @SerialName("M")
  M,
  /** 
   * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade. 
   */
  @SerialName("T")
  T,
  /** 
   * Week 
   */
  @SerialName("W")
  W,
  /** 
   * Year 
   */
  @SerialName("Y")
  Y
  ;
}

/** 
 * The enumeration values to specify a time period containing additional values such as Term. 
 */
@Serializable
enum class PeriodTimeEnum {
  /** 
   * Period measured in hours. 
   */
  @SerialName("HOUR")
  HOUR,
  /** 
   * Period measured in minutes. 
   */
  @SerialName("MINUTE")
  MINUTE,
  /** 
   * Period measured in seconds. 
   */
  @SerialName("SECOND")
  SECOND
  ;
}

/** 
 * The enumeration values associated with person identifier sources. 
 */
@Serializable
enum class PersonIdentifierTypeEnum {
  /** 
   * Alien Registration Number, number assigned by a social security agency to identify a non-resident person. 
   */
  @SerialName("ARNU")
  ARNU,
  /** 
   * Passport Number, number assigned by an authority to identify the passport number of a person. 
   */
  @SerialName("CCPT")
  CCPT,
  /** 
   * Customer Identification Number, number assigned by an issuer to identify a customer. 
   */
  @SerialName("CUST")
  CUST,
  /** 
   * Drivers License Number, number assigned by an authority to identify a driver's license. 
   */
  @SerialName("DRLC")
  DRLC,
  /** 
   * Employee Identification Number, number assigned by a registration authority to an employee. 
   */
  @SerialName("EMPL")
  EMPL,
  /** 
   * National Identity Number, number assigned by an authority to identify the national identity number of a person.. 
   */
  @SerialName("NIDN")
  NIDN,
  /** 
   * Natural Person Identifier. To identify the person who is acting as private individual, not as business entity. Used for regulatory reporting. 
   */
  @SerialName("NPID")
  NPID,
  /** 
   * Privacy Law Identifier. It refers to the DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf 
   */
  @SerialName("PLID")
  PLID,
  /** 
   * Social Security Number, number assigned by an authority to identify the social security number of a person. 
   */
  @SerialName("SOSE")
  SOSE,
  /** 
   * Tax Identification Number, number assigned by a tax authority to identify a person. 
   */
  @SerialName("TXID")
  TXID
  ;
}

@Serializable
enum class PositionEventIntentEnum {
  /** 
   * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum. 
   */
  @SerialName("CORPORATE_ACTION_ADJUSTMENT")
  CORPORATE_ACTION_ADJUSTMENT,
  /** 
   * The intent is to Decrease the quantity of the position. 
   */
  @SerialName("DECREASE")
  DECREASE,
  /** 
   * The intent is to Increase the quantity of the position. 
   */
  @SerialName("INCREASE")
  INCREASE,
  /** 
   * The intent is to Exercise a position or part of a position. 
   */
  @SerialName("OPTION_EXERCISE")
  OPTION_EXERCISE,
  /** 
   * The intent is to form a position from a fully formed contract. 
   */
  @SerialName("POSITION_CREATION")
  POSITION_CREATION,
  /** 
   * The intent is to transfer the position to another clearing member. 
   */
  @SerialName("TRANSFER")
  TRANSFER,
  /** 
   * The intent is to update the valuation of the position. 
   */
  @SerialName("VALUATION")
  VALUATION
  ;
}

/** 
 * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc 
 */
@Serializable
enum class PositionStatusEnum {
  /** 
   * The position has been cancelled, in case of a cancellation event following an execution. 
   */
  @SerialName("CANCELLED")
  CANCELLED,
  /** 
   * The position has been closed, in case of a termination event. 
   */
  @SerialName("CLOSED")
  CLOSED,
  /** 
   * The position has been executed, which is the point at which risk has been transferred. 
   */
  @SerialName("EXECUTED")
  EXECUTED,
  /** 
   * Contract has been formed, in case position is on a contractual product. 
   */
  @SerialName("FORMED")
  FORMED,
  /** 
   * The position has settled, in case product is subject to settlement after execution, such as securities. 
   */
  @SerialName("SETTLED")
  SETTLED
  ;
}

/** 
 * The enumerated values to specify the premium type for forward start options. 
 */
@Serializable
enum class PremiumTypeEnum {
  @SerialName("FIXED")
  FIXED,
  @SerialName("POST_PAID")
  POST_PAID,
  @SerialName("PRE_PAID")
  PRE_PAID,
  @SerialName("VARIABLE")
  VARIABLE
  ;
}

/** 
 * Enumerated values to specify whether the price is expressed in absolute or relative terms. 
 */
@Serializable
enum class PriceExpressionEnum {
  /** 
   * The price is expressed as an absolute amount. 
   */
  @SerialName("ABSOLUTE_TERMS")
  ABSOLUTE_TERMS,
  /** 
   * Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value. 
   */
  @SerialName("PAR_VALUE_FRACTION")
  PAR_VALUE_FRACTION,
  /** 
   * Denotes a price expressed per number of options. 
   */
  @SerialName("PER_OPTION")
  PER_OPTION,
  /** 
   * The price is expressed in percentage of the notional amount. 
   */
  @SerialName("PERCENTAGE_OF_NOTIONAL")
  PERCENTAGE_OF_NOTIONAL
  ;
}

@Serializable
enum class PriceOperandEnum {
  @SerialName("ACCRUED_INTEREST")
  ACCRUED_INTEREST,
  @SerialName("COMMISSION")
  COMMISSION,
  @SerialName("FORWARD_POINT")
  FORWARD_POINT
  ;
}

@Serializable
enum class PriceTimingEnum {
  /** 
   * The last price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day. 
   */
  @SerialName("CLOSING_PRICE")
  CLOSING_PRICE,
  /** 
   * The first price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day. 
   */
  @SerialName("OPENING_PRICE")
  OPENING_PRICE
  ;
}

/** 
 * Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations. 
 */
@Serializable
enum class PriceTypeEnum {
  /** 
   * Denotes a price expressed as a cash amount in a given currency to purchase a unit of an asset (e.g. a security or a commodity). 
   */
  @SerialName("ASSET_PRICE")
  ASSET_PRICE,
  /** 
   * Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500. 
   */
  @SerialName("CASH_PRICE")
  CASH_PRICE,
  /** 
   * Denotes a price expressed as the weighted average of all pairwise correlation coefficients. 
   */
  @SerialName("CORRELATION")
  CORRELATION,
  /** 
   * Denotes a price expressed as the dividend payment from a index or share. 
   */
  @SerialName("DIVIDEND")
  DIVIDEND,
  /** 
   * Denotes a rate to convert one currency or other measure of value to another. Foreign Exchange rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP. 
   */
  @SerialName("EXCHANGE_RATE")
  EXCHANGE_RATE,
  /** 
   * Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount. 
   */
  @SerialName("INTEREST_RATE")
  INTEREST_RATE,
  /** 
   * Denotes a price expressed as the the arithmetic average of the squared differences from the mean value of an observable price. 
   */
  @SerialName("VARIANCE")
  VARIANCE,
  /** 
   * Denotes a price expressed as the the square root of the arithmetic average of the squared differences from the mean value of an observable price. 
   */
  @SerialName("VOLATILITY")
  VOLATILITY
  ;
}

/** 
 * Provides the enumerated values to specify the product identifier source. 
 */
@Serializable
enum class ProductIdTypeEnum {
  /** 
   * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities. 
   */
  @SerialName("BBGID")
  BBGID,
  /** 
   * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange. 
   */
  @SerialName("BBGTICKER")
  BBGTICKER,
  /** 
   * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada. 
   */
  @SerialName("CUSIP")
  CUSIP,
  /** 
   * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument. 
   */
  @SerialName("FIGI")
  FIGI,
  /** 
   * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract. 
   */
  @SerialName("ISDACRP")
  ISDACRP,
  /** 
   * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166. 
   */
  @SerialName("ISIN")
  ISIN,
  /** 
   * The name of the product. 
   */
  @SerialName("NAME")
  NAME,
  /** 
   * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded. 
   */
  @SerialName("RIC")
  RIC,
  /** 
   * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well. 
   */
  @SerialName("SEDOL")
  SEDOL,
  /** 
   * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges. 
   */
  @SerialName("SICOVAM")
  SICOVAM,
  /** 
   * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data. 
   */
  @SerialName("UPI")
  UPI,
  /** 
   * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities. 
   */
  @SerialName("WERTPAPIER")
  WERTPAPIER
  ;
}

/** 
 * The enumerated values to specify the types of listed derivative options. 
 */
@Serializable
enum class PutCallEnum {
  /** 
   * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price. 
   */
  @SerialName("CALL")
  CALL,
  /** 
   * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price. 
   */
  @SerialName("PUT")
  PUT
  ;
}

/** 
 * Represents the enumerated values to specify a logical quantification, i.e. either All or Any. 
 */
@Serializable
enum class QuantifierEnum {
  /** 
   * Specifies that the condition in the scope of the quantifier is true of every member of the domain i.e. every one of the elements in scope. 
   */
  @SerialName("ALL")
  ALL,
  /** 
   * Specifies that the condition in the scope of the quantifier is true of at least one member of the domain i.e. one or more of the elements in scope. 
   */
  @SerialName("ANY")
  ANY
  ;
}

/** 
 * Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number. 
 */
@Serializable
enum class QuantityChangeDirectionEnum {
  /** 
   * When the quantity should go down by the specified amount. 
   */
  @SerialName("DECREASE")
  DECREASE,
  /** 
   * When the quantity should go up by the specified amount. 
   */
  @SerialName("INCREASE")
  INCREASE,
  /** 
   * When the quantity should be replaced by the specified amount. 
   */
  @SerialName("REPLACE")
  REPLACE
  ;
}

/** 
 * The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank. 
 */
@Serializable
enum class QuotationRateTypeEnum {
  /** 
   * An ask rate. 
   */
  @SerialName("ASK")
  ASK,
  /** 
   * A bid rate. 
   */
  @SerialName("BID")
  BID,
  /** 
   * If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount. 
   */
  @SerialName("EXERCISING_PARTY_PAYS")
  EXERCISING_PARTY_PAYS,
  /** 
   * A mid-market rate. 
   */
  @SerialName("MID")
  MID
  ;
}

/** 
 * The enumerated values to specify the side from which perspective a value is quoted. 
 */
@Serializable
enum class QuotationSideEnum {
  /** 
   * Denotes a value as the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("AFTERNOON")
  AFTERNOON,
  /** 
   * Denotes a value 'asked' by a seller for an asset, i.e. the value at which a seller is willing to sell. 
   */
  @SerialName("ASK")
  ASK,
  /** 
   * Denotes a value 'bid' by a buyer for an asset, i.e. the value a buyer is willing to pay. 
   */
  @SerialName("BID")
  BID,
  /** 
   * Denotes a value as the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("CLOSING")
  CLOSING,
  /** 
   * Denotes a value as the High price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("HIGH")
  HIGH,
  /** 
   * Denotes a value as the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("INDEX")
  INDEX,
  /** 
   * Denotes a value as the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("LOCATIONAL_MARGINAL")
  LOCATIONAL_MARGINAL,
  /** 
   * Denotes a value as the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("LOW")
  LOW,
  /** 
   * Denotes a value as the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MARGINAL_HOURLY")
  MARGINAL_HOURLY,
  /** 
   * Denotes a value as the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MARKET_CLEARING")
  MARKET_CLEARING,
  /** 
   * Denotes a value as the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MEAN_OF_BID_AND_ASK")
  MEAN_OF_BID_AND_ASK,
  /** 
   * Denotes a value as the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MEAN_OF_HIGH_AND_LOW")
  MEAN_OF_HIGH_AND_LOW,
  /** 
   * Denotes a value as the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MID")
  MID,
  /** 
   * Denotes a value as the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("MORNING")
  MORNING,
  /** 
   * Denotes a value as the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("NATIONAL_SINGLE")
  NATIONAL_SINGLE,
  /** 
   * Denotes a value as the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("OSP")
  OSP,
  /** 
   * Denotes a value as the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("OFFICIAL")
  OFFICIAL,
  /** 
   * Denotes a value as the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("OPENING")
  OPENING,
  /** 
   * Denotes a value as the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("SETTLEMENT")
  SETTLEMENT,
  /** 
   * Denotes a value as the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation. 
   */
  @SerialName("SPOT")
  SPOT,
  /** 
   * Denotes a value as the Non-volume Weighted Average of prices effective on the Pricing Date. 
   */
  @SerialName("UN_WEIGHTED_AVERAGE")
  UN_WEIGHTED_AVERAGE,
  /** 
   * Denotes a value as the Volume Weighted Average of prices effective on the Pricing Date. 
   */
  @SerialName("WEIGHTED_AVERAGE")
  WEIGHTED_AVERAGE
  ;
}

/** 
 * The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg. 
 */
@Serializable
enum class QuotationStyleEnum {
  /** 
   * When quotation style is 'PointsUpFront', the initialPoints element of the Credit Default Swap feeLeg should be populated 
   */
  @SerialName("POINTS_UP_FRONT")
  POINTS_UP_FRONT,
  /** 
   * When quotation style is 'Price', the marketPrice element of the Credit Default Swap feeLeg should be populated 
   */
  @SerialName("PRICE")
  PRICE,
  /** 
   * When quotation style is 'TradedSpread', the marketFixedRate element of the Credit Default Swap feeLeg should be populated 
   */
  @SerialName("TRADED_SPREAD")
  TRADED_SPREAD
  ;
}

/** 
 * The enumerated values to specify how an exchange rate is quoted. 
 */
@Serializable
enum class QuoteBasisEnum {
  /** 
   * The amount of currency1 for one unit of currency2 
   */
  @SerialName("CURRENCY_1_PER_CURRENCY_2")
  CURRENCY_1_PER_CURRENCY_2,
  /** 
   * The amount of currency2 for one unit of currency1 
   */
  @SerialName("CURRENCY_2_PER_CURRENCY_1")
  CURRENCY_2_PER_CURRENCY_1
  ;
}

/** 
 * The enumerated values to specify the methods for converting rates from one basis to another. 
 */
@Serializable
enum class RateTreatmentEnum {
  /** 
   * Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g). 
   */
  @SerialName("BOND_EQUIVALENT_YIELD")
  BOND_EQUIVALENT_YIELD,
  /** 
   * Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h). 
   */
  @SerialName("MONEY_MARKET_YIELD")
  MONEY_MARKET_YIELD
  ;
}

/** 
 * Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to 'Issuer', the rating in the 
 Issuer Criteria has priority or is used if there is no Asset criteria. If set to 'Asset', the rating in the Asset Criteria has priority or is used if there is no Issuer rating. 
 */
@Serializable
enum class RatingPriorityResolutionEnum {
  /** 
   * Denotes that the Asset Criteria has priority. 
   */
  @SerialName("ASSET")
  ASSET,
  /** 
   * Denotes that average rating should be used if several criteria apply. 
   */
  @SerialName("AVERAGE")
  AVERAGE,
  /** 
   * Denotes that highest rating should be used if several criteria apply. 
   */
  @SerialName("HIGHEST")
  HIGHEST,
  /** 
   * Denotes that the Issuer Criteria has priority. 
   */
  @SerialName("ISSUER")
  ISSUER,
  /** 
   * Denotes that lowest rating should be used if several criteria apply. 
   */
  @SerialName("LOWEST")
  LOWEST
  ;
}

/** 
 * The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors. 
 */
@Serializable
enum class RealisedVarianceMethodEnum {
  /** 
   * For a return on day T, the observed prices on both T and T-1 must be in range 
   */
  @SerialName("BOTH")
  BOTH,
  /** 
   * For a return on day T, the observed price on T must be in range. 
   */
  @SerialName("LAST")
  LAST,
  /** 
   * For a return on day T, the observed price on T-1 must be in range. 
   */
  @SerialName("PREVIOUS")
  PREVIOUS
  ;
}

/** 
 * The enumeration of the account level for the billing summary. 
 */
@Serializable
enum class RecordAmountTypeEnum {
  @SerialName("ACCOUNT_TOTAL")
  ACCOUNT_TOTAL,
  @SerialName("GRAND_TOTAL")
  GRAND_TOTAL,
  @SerialName("PARENT_TOTAL")
  PARENT_TOTAL
  ;
}

/** 
 * Represents the enumeration values to specify the role of the party in relation to a regulatory initial margin call. 
 */
@Serializable
enum class RegIMRoleEnum {
  /** 
   * Indicates 'Pledgor' party of initial margin call. 
   */
  @SerialName("PLEDGOR")
  PLEDGOR,
  /** 
   * Indicates 'Secured' party of initial margin call. 
   */
  @SerialName("SECURED")
  SECURED
  ;
}

/** 
 * Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation. 
 */
@Serializable
enum class RegMarginTypeEnum {
  /** 
   * Indicates Non Regulatory Initial margin or independent amount 
   */
  @SerialName("NON_REG_IM")
  NON_REG_IM,
  /** 
   * Indicates Regulatory Initial Margin 
   */
  @SerialName("REG_IM")
  REG_IM,
  /** 
   * Indicates Variation Margin 
   */
  @SerialName("VM")
  VM
  ;
}

/** 
 * A duration code for a Repo (or Securities Lending) transaction. There are many business and market rules that are derived from the duration of the transaction. 
 */
@Serializable
enum class RepoDurationEnum {
  /** 
   * Indicates that a contract is classified as overnight, meaning that there is one business day difference between the start and end date of the contract. Business rule: When the repo is overnight, the number of business days between the spot and forward value dates must be one. Forward leg must be specified. 
   */
  @SerialName("OVERNIGHT")
  OVERNIGHT,
  /** 
   * Indicates that a contract is a regular term contract, with a start date and an end date. Business rule: When the repo is 'Term', both spot and forward legs must be specified. 
   */
  @SerialName("TERM")
  TERM
  ;
}

/** 
 * The enumerated values to specify whether resets occur relative to the first or last day of a calculation period. 
 */
@Serializable
enum class ResetRelativeToEnum {
  /** 
   * Resets occur relative to the last day of a calculation period. 
   */
  @SerialName("CALCULATION_PERIOD_END_DATE")
  CALCULATION_PERIOD_END_DATE,
  /** 
   * Resets occur relative to the first day of a calculation period. 
   */
  @SerialName("CALCULATION_PERIOD_START_DATE")
  CALCULATION_PERIOD_START_DATE
  ;
}

/** 
 * The enumerated values to specify the type of a resource (e.g. document). 
 */
@Serializable
enum class ResourceTypeEnum {
  /** 
   * Document describing the legal terms of a transaction. 
   */
  @SerialName("CONFIRMATION")
  CONFIRMATION,
  /** 
   * Document providing supplemental material economic terms to the FpML data representation. The initial intended usage is to fulfill the CFTC Part 45 rule requirement to report ‘Any other terms(s) of the swap matched or affirmed by the counterparties in verifying the swap’ when the reporting is done via the generic FpML representation. 
   */
  @SerialName("SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS")
  SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS,
  /** 
   * Document describing the economic characteristics of a transaction. 
   */
  @SerialName("TERM_SHEET")
  TERM_SHEET
  ;
}

/** 
 * The enumerated values to specify the form of the restructuring credit event that is applicable to the credit default swap. 
 */
@Serializable
enum class RestructuringEnum {
  /** 
   * Restructuring (Section 4.7) and Modified Restructuring Maturity Limitation and Conditionally Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply. 
   */
  @SerialName("MOD_MOD_R")
  MOD_MOD_R,
  /** 
   * Restructuring (Section 4.7) and Restructuring Maturity Limitation and Fully Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply. 
   */
  @SerialName("MOD_R")
  MOD_R,
  /** 
   * Restructuring as defined in the applicable ISDA Credit Derivatives Definitions. (2003 or 2014). 
   */
  @SerialName("R")
  R
  ;
}

/** 
 * The enumerated values to specify the type of return associated the equity payout. 
 */
@Serializable
enum class ReturnTypeEnum {
  /** 
   * Price return, i.e. excluding dividends. 
   */
  @SerialName("PRICE")
  PRICE,
  /** 
   * Total return, i.e. including dividend and price components. 
   */
  @SerialName("TOTAL")
  TOTAL
  ;
}

/** 
 * The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month. 
 */
@Serializable
enum class RollConventionEnum {
  /** 
   * Rolls on month end dates irrespective of the length of the month and the previous roll day. 
   */
  @SerialName("EOM")
  EOM,
  /** 
   * Rolling weekly on a Friday 
   */
  @SerialName("FRI")
  FRI,
  /** 
   * Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions. 
   */
  @SerialName("FRN")
  FRN,
  /** 
   * IMM Settlement Dates. The third Wednesday of the (delivery) month. 
   */
  @SerialName("IMM")
  IMM,
  /** 
   * The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement. 
   */
  @SerialName("IMMAUD")
  IMMAUD,
  /** 
   * The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers' Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification. 
   */
  @SerialName("IMMCAD")
  IMMCAD,
  /** 
   * The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month. 
   */
  @SerialName("IMMNZD")
  IMMNZD,
  /** 
   * Rolling weekly on a Monday. 
   */
  @SerialName("MON")
  MON,
  /** 
   * The roll convention is not required. For example, in the case of a daily calculation frequency. 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * Rolling weekly on a Saturday 
   */
  @SerialName("SAT")
  SAT,
  /** 
   * Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month 
   */
  @SerialName("SFE")
  SFE,
  /** 
   * Rolling weekly on a Sunday 
   */
  @SerialName("SUN")
  SUN,
  /** 
   * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday. 
   */
  @SerialName("TBILL")
  TBILL,
  /** 
   * Rolling weekly on a Thursday 
   */
  @SerialName("THU")
  THU,
  /** 
   * Rolling weekly on a Tuesday 
   */
  @SerialName("TUE")
  TUE,
  /** 
   * Rolling weekly on a Wednesday 
   */
  @SerialName("WED")
  WED,
  /** 
   * Rolls on the 1st day of the month. 
   */
  @SerialName("1")
  _1,
  /** 
   * Rolls on the 10th day of the month. 
   */
  @SerialName("10")
  _10,
  /** 
   * Rolls on the 11th day of the month. 
   */
  @SerialName("11")
  _11,
  /** 
   * Rolls on the 12th day of the month. 
   */
  @SerialName("12")
  _12,
  /** 
   * Rolls on the 13th day of the month. 
   */
  @SerialName("13")
  _13,
  /** 
   * Rolls on the 14th day of the month. 
   */
  @SerialName("14")
  _14,
  /** 
   * Rolls on the 15th day of the month. 
   */
  @SerialName("15")
  _15,
  /** 
   * Rolls on the 16th day of the month. 
   */
  @SerialName("16")
  _16,
  /** 
   * Rolls on the 17th day of the month. 
   */
  @SerialName("17")
  _17,
  /** 
   * Rolls on the 18th day of the month. 
   */
  @SerialName("18")
  _18,
  /** 
   * Rolls on the 19th day of the month. 
   */
  @SerialName("19")
  _19,
  /** 
   * Rolls on the 2nd day of the month. 
   */
  @SerialName("2")
  _2,
  /** 
   * Rolls on the 20th day of the month. 
   */
  @SerialName("20")
  _20,
  /** 
   * Rolls on the 21st day of the month. 
   */
  @SerialName("21")
  _21,
  /** 
   * Rolls on the 22nd day of the month. 
   */
  @SerialName("22")
  _22,
  /** 
   * Rolls on the 23rd day of the month. 
   */
  @SerialName("23")
  _23,
  /** 
   * Rolls on the 24th day of the month. 
   */
  @SerialName("24")
  _24,
  /** 
   * Rolls on the 25th day of the month. 
   */
  @SerialName("25")
  _25,
  /** 
   * Rolls on the 26th day of the month. 
   */
  @SerialName("26")
  _26,
  /** 
   * Rolls on the 27th day of the month. 
   */
  @SerialName("27")
  _27,
  /** 
   * Rolls on the 28th day of the month. 
   */
  @SerialName("28")
  _28,
  /** 
   * Rolls on the 29th day of the month. 
   */
  @SerialName("29")
  _29,
  /** 
   * Rolls on the 3rd day of the month. 
   */
  @SerialName("3")
  _3,
  /** 
   * Rolls on the 30th day of the month. 
   */
  @SerialName("30")
  _30,
  /** 
   * Rolls on the 4th day of the month. 
   */
  @SerialName("4")
  _4,
  /** 
   * Rolls on the 5th day of the month. 
   */
  @SerialName("5")
  _5,
  /** 
   * Rolls on the 6th day of the month. 
   */
  @SerialName("6")
  _6,
  /** 
   * Rolls on the 7th day of the month. 
   */
  @SerialName("7")
  _7,
  /** 
   * Rolls on the 8th day of the month. 
   */
  @SerialName("8")
  _8,
  /** 
   * Rolls on the 9th day of the month. 
   */
  @SerialName("9")
  _9
  ;
}

/** 
 * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element. 
 */
@Serializable
enum class RollSourceCalendarEnum {
  @SerialName("FUTURE")
  FUTURE,
  @SerialName("LISTED_OPTION")
  LISTED_OPTION
  ;
}

/** 
 * The enumerated values to specify the rounding direction and precision to be used in the rounding of a number.  Used by function cdm.base.math.RoundToPrecision. 
 */
@Serializable
enum class RoundingDirectionEnum {
  /** 
   * A fractional number will be rounded down to the specified number of decimal places (the precision). For example, 5.29 and 5.25 rounded down to 1 decimal place are 5.2 and 5.2 respectively. 
   */
  @SerialName("DOWN")
  DOWN,
  /** 
   * A fractional number will be rounded either up or down to the specified number of decimal places (the precision) depending on its value. For example, 5.24 would be rounded down to 5.2 and 5.25 would be rounded up to 5.3 if a precision of 1 decimal place were specified. 
   */
  @SerialName("NEAREST")
  NEAREST,
  /** 
   * A fractional number will be rounded up to the specified number of decimal places (the precision). For example, 5.21 and 5.25 rounded up to 1 decimal place are 5.3 and 5.3 respectively. 
   */
  @SerialName("UP")
  UP
  ;
}

/** 
 * How often is rounding performed 
 */
@Serializable
enum class RoundingFrequencyEnum {
  /** 
   * Rounding is done on each day 
   */
  @SerialName("DAILY")
  DAILY,
  /** 
   * Rounding is done only at the end of the period 
   */
  @SerialName("PERIOD_END")
  PERIOD_END
  ;
}

/** 
 * The enumerated values to specify the rounding direction when rounding of a number to nearest.  Used by function cdm.base.math.RoundToNearest. 
 */
@Serializable
enum class RoundingModeEnum {
  /** 
   * A number will be rounded down to the specified nearest number. For example, 529 rounded down to the nearest 10 is 520. 
   */
  @SerialName("DOWN")
  DOWN,
  /** 
   * A number will be rounded up to the specified nearest number. For example, 521 rounded up to the nearest 10 is 530. 
   */
  @SerialName("UP")
  UP
  ;
}

/** 
 * The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events. 
 */
@Serializable
enum class ScheduledTransferEnum {
  /** 
   * A cash flow corresponding to a corporate action event. 
   */
  @SerialName("CORPORATE_ACTION")
  CORPORATE_ACTION,
  /** 
   * A cash flow corresponding to the periodic accrued interests. 
   */
  @SerialName("COUPON")
  COUPON,
  /** 
   * A cashflow resulting from a credit event. 
   */
  @SerialName("CREDIT_EVENT")
  CREDIT_EVENT,
  /** 
   * A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument. 
   */
  @SerialName("DIVIDEND_RETURN")
  DIVIDEND_RETURN,
  /** 
   * A cash flow associated with an exercise lifecycle event. 
   */
  @SerialName("EXERCISE")
  EXERCISE,
  /** 
   * A cash flow corresponding to the return of the fixed interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap. 
   */
  @SerialName("FIXED_RATE_RETURN")
  FIXED_RATE_RETURN,
  /** 
   * A cash flow corresponding to the return of the floating interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap. 
   */
  @SerialName("FLOATING_RATE_RETURN")
  FLOATING_RATE_RETURN,
  /** 
   * A cash flow corresponding to the compensation for missing assets due to the rounding of digits in the original number of assets to be delivered as per payout calculation. 
   */
  @SerialName("FRACTIONAL_AMOUNT")
  FRACTIONAL_AMOUNT,
  /** 
   * A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap. 
   */
  @SerialName("INTEREST_RETURN")
  INTEREST_RETURN,
  /** 
   * Net interest across payout components. Applicable to products such as interest rate swaps. 
   */
  @SerialName("NET_INTEREST")
  NET_INTEREST,
  /** 
   * A cash flow corresponding to a performance return.  The settlementOrigin attribute on the Transfer should point to the relevant Payout defining the performance calculation. 
   */
  @SerialName("PERFORMANCE")
  PERFORMANCE,
  /** 
   * A cashflow which amount typically corresponds to the notional amount of the contract for various business reasons e.g. PhysicalSettlement, PrincipalExchange etc. else to a portion of the notional amount interim payments e.g. for the purpose of resetting the Notional Amount of a Cross Currency Swap variying leg, as part of a final Principal Exchange related to a Non-Deliverable currency leg, etc. 
   */
  @SerialName("PRINCIPAL_PAYMENT")
  PRINCIPAL_PAYMENT
  ;
}

/** 
 * The enumerated values to specify the relevant settled entity matrix source. 
 */
@Serializable
enum class SettledEntityMatrixSourceEnum {
  /** 
   * The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation. 
   */
  @SerialName("CONFIRMATION_ANNEX")
  CONFIRMATION_ANNEX,
  /** 
   * The term is not applicable. 
   */
  @SerialName("NOT_APPLICABLE")
  NOT_APPLICABLE,
  /** 
   * The Settled Entity Matrix published by the Index Publisher. 
   */
  @SerialName("PUBLISHER")
  PUBLISHER
  ;
}

/** 
 * Defines the settlement centre for a securities transaction. 
 */
@Serializable
enum class SettlementCentreEnum {
  /** 
   * ClearStream Banking Luxembourg 
   */
  @SerialName("CLEARSTREAM_BANKING_LUXEMBOURG")
  CLEARSTREAM_BANKING_LUXEMBOURG,
  /** 
   * Euroclear Bank 
   */
  @SerialName("EUROCLEAR_BANK")
  EUROCLEAR_BANK
  ;
}

/** 
 * The enumerated values to specify the settlement rate options as specified in the Annex A to the 1998 FX and Currency Options Definitions. 
 */
@Serializable
enum class SettlementRateOptionEnum {
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Buenos Aires and New York) which appears on the Reuters Screen BNAR Page at the close of business in Buenos Aires on that Rate Calculation Date. 
   */
  @SerialName("ARS.BNAR/ARS01")
  ARS_BNAR_ARS01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Indicative Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Argentine Peso/U.S. Dollar markets for the purpose of determining the EMTA ARS Indicative Survey Rate). 
   */
  @SerialName("ARS.EMTA.INDICATIVE.SURVEY.RATE/ARS04")
  ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Industry Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions in Buenos Aires that are active participants in the Argentine Peso/U.S. Dollar spot markets for the purpose of determining the EMTA ARS Industry Survey Rate). 
   */
  @SerialName("ARS.EMTA.INDUSTRY.SURVEY.RATE/ARS03")
  ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the volume weighted average Argentine Peso/U.S. Dollar Rate of all trades executed in the electronic market for a Rate Calculation Day expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, reported by the Mercado Abierto Electronico (the 'MAE') at approximately 3:00 pm, Buenos Aires time, and published on the FOREX-MAE Page as the 'PPN' rate ('Promedio Ponderado Noticiado') on www.mae.com.ar on that Rate Calculation Date. 
   */
  @SerialName("ARS.MAE/ARS05")
  ARS_MAE_ARS05,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day quoted by Banco de la Nacion (in accordance with the Convertibility Law of March 27, 1991 and Regulatory Decree No. 529/91 of April 1, 1991, as may be amended from time to time) for that Rate Calculation Date. 
   */
  @SerialName("ARS.OFFICIAL.RATE/ARS02")
  ARS_OFFICIAL_RATE_ARS02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) which appears on the Reuters Screen BRBY Page under the caption 'INTBK FLTING (LAST)' at approximately 11:00 a.m., Sao Paulo time, on that Rate Calculation Date. 
   */
  @SerialName("BRL.BRBY/BRL01")
  BRL_BRBY_BRL01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 12:00 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Indicative Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Brazilian Real/U.S. Dollar markets for the purpose of determining the EMTA BRL Indicative Survey Rate). 
   */
  @SerialName("BRL.EMTA.INDICATIVE.SURVEY.RATE/BRL13")
  BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 3:45 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Industry Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions in Brazil that are active participants in the Brazilian Real/U.S. Dollar spot markets for the purpose of determining the EMTA BRL Industry Survey Rate). 
   */
  @SerialName("BRL.EMTA.INDUSTRY.SURVEY.RATE/BRL12")
  BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil in the 'Diario Oficial da Uniao' on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("BRL.OFFICIAL.RATE/BRL02")
  BRL_OFFICIAL_RATE_BRL02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("BRL.PCOT-COMMERCIAL/BRL03")
  BRL_PCOT_COMMERCIAL_BRL03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("BRL.PCOT-FLOATING/BRL04")
  BRL_PCOT_FLOATING_BRL04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX-800 ('Consulta de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidade' or 'Rates for Accounting Purposes') by approximately 6:00 p.m., Sao Paulo time, on that Rate Calculation Date. 
   */
  @SerialName("BRL.PTAX/BRL09")
  BRL_PTAX_BRL09,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date. 23 
   */
  @SerialName("BRL.PTAX-COMMERCIAL.BRFR/BRL06")
  BRL_PTAX_COMMERCIAL_BRFR_BRL06,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'L' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Livre' and commonly known as 'Comercial') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date. 
   */
  @SerialName("BRL.PTAX-COMMERCIAL/BRL05")
  BRL_PTAX_COMMERCIAL_BRL05,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on the SISBACEN Data System which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("BRL.PTAX-FLOATING.BRFR/BRL08")
  BRL_PTAX_FLOATING_BRFR_BRL08,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'F' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Flutuante') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date. 
   */
  @SerialName("BRL.PTAX-FLOATING/BRL07")
  BRL_PTAX_FLOATING_BRL07,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen BCCH Page under the caption 'OBSERVADO' at 10:00 a.m., Santiago time, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("CLP.BCCH/CLP01")
  CLP_BCCH_CLP01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILD-INFORMAL/CLP02")
  CLP_CHILD_INFORMAL_CLP02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILD-INTERBANK/CLP03")
  CLP_CHILD_INTERBANK_CLP03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILD Page on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILD-OBSERVADO/CLP04")
  CLP_CHILD_OBSERVADO_CLP04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILG-INFORMAL/CLP05")
  CLP_CHILG_INFORMAL_CLP05,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILG-INTERBANK/CLP06")
  CLP_CHILG_INTERBANK_CLP06,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILG Page under 'OBSERVADO' at the Specified Time, if any, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("CLP.CHILG-OBSERVADO/CLP07")
  CLP_CHILG_OBSERVADO_CLP07,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar 'observado' rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Banco Central de Chile (www.bcentral.cl) as the 'Dolar Observado' (Dollar Observado) rate by not later than 10:30 a.m., Santiago time, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("CLP.DOLAR.OBS/CLP10")
  CLP_DOLAR_OBS_CLP10,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Santiago time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA CLP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chilean Peso/U.S. Dollar markets for the purpose of determining the EMTA CLP Indicative Survey Rate). 
   */
  @SerialName("CLP.EMTA.INDICATIVE.SURVEY.RATE/CLP11")
  CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate, expressed as the amount of Chilean Pesos per one U.S. Dollar (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York), calculated in accordance with Title I, Chapter 1 Number 6 of the Compendium of International Exchange Norms of the Banco Central de Chile and published by the Banco Central de Chile at the Specified Time, if any, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("CLP.OFFICIAL.RATE/CLP08")
  CLP_OFFICIAL_RATE_CLP08,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Telerate Page 38942 opposite the caption 'Observado' at the Specified Time, if any, on the first Business Day following the Rate Calculation Date. 
   */
  @SerialName("CLP.TELERATE.38942/CLP09")
  CLP_TELERATE_38942_CLP09,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar official fixing rate, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days reported by the People's Bank of China, Beijing, People's Republic of China, which appears on the Reuters Screen 'SAEC' Page opposite the symbol 'USDCNY=' at approximately 9:15 a.m., Beijing time, on that Rate Calculation Date. 
   */
  @SerialName("CNY.SAEC/CNY01")
  CNY_SAEC_CNY01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC CNY Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chinese Renminbi/U.S. Dollar markets for the purpose of determining the SFEMC CNY Indicative Survey Rate). 
   */
  @SerialName("CNY.SFEMC.INDICATIVE.SURVEY.RATE/CNY02")
  CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day (unless such day is not a Business Day in New York, then for settlement on the first succeeding day that is a Business Day in Bogota and New York) reported by the Colombian Banking Superintendency which appears on the Reuters Screen CO/COL03 Page opposite the caption 'TRCM' ('Tasa de Cierre Representative del Mercado' or closing market price) at 12:00 noon, Bogota time, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("COP.CO/COL03/COP01")
  COP_CO_COL03_COP01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:30 a.m., Bogota time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA COP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Colombian Peso/U.S. Dollar markets for the purpose of determining the EMTA COP Indicative Survey Rate). 
   */
  @SerialName("COP.EMTA.INDICATIVE.SURVEY.RATE/COP03")
  COP_EMTA_INDICATIVE_SURVEY_RATE_COP03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day reported by the Colombian Financial Superintendency (www.banrep.gov.co) as the 'Tasa Representativa del Mercado (TRM)' (also referred to as the 'Tasa de Cambio Representativa del Mercado' (TCRM)) by not later than 10:30 a.m., Bogota time, on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("COP.TRM/COP02")
  COP_TRM_COP02,
  /** 
   * the Spot Rate for a Rate Calculation Date will be the Reference Currency/U.S. Dollar exchange rate, expressed as the amount of Reference Currency per one U.S. Dollar, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's price of a Specified Company's American Depositary Receipt or American Depositary Receipts (the 'ADR' or 'ADRs', as appropriate) and the price of the local share or shares of such Specified Company of the same type and in the same quantity represented by such ADR or ADRs, as the case may be (the 'Share' or 'Shares', as appropriate). The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of (A) in the case where one ADR represents less than one Share, its bid and offer price (in the Reference Currency) for one Share and its bid and offer price (in U.S. Dollars) for the number of ADRs which represent such Share and (B) in all other cases, its bid and offer price (in the Reference Currency) for the Share or Shares, as the case may be, and its bid and offer price (in U.S. Dollars) for one ADR. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (1) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Share or Shares, as the case may be, and (2) the arithmetic mean of the midpoint of the bid and offer prices quoted in U.S. Dollars by each Reference Dealer for such ADR or ADRs, as the case may be, subject to an adjustment, if any, by the Calculation Agent to reduce the effect of momentary disparities in the prices of the Share or Shares and the ADR or ADRs, as appropriate. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent. 
   */
  @SerialName("CURRENCY-IMPLIED.RATE.(ADR)/CURA1")
  CURRENCY_IMPLIED_RATE__ADR__CURA1,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency exchange rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date for that day's price of Local Assets. The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of its bid and offer price (in both the Reference Currency and the Settlement Currency) for an amount of Local Assets whose face value equals the Specified Amount. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (A) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Local Assets and (B) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Settlement Currency by each Reference Dealer for such Local Assets. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent. 
   */
  @SerialName("CURRENCY-IMPLIED.RATE.(LOCAL.ASSET)/CURA2")
  CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency Specified Rate, expressed as the amount of the Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date agreed upon by the parties on or prior to that Rate Calculation Date (or, if different, the day on which rates for that date would, in the ordinary course, be published or announced). 
   */
  @SerialName("CURRENCY-MUTUAL.AGREEMENT/CURA3")
  CURRENCY_MUTUAL_AGREEMENT_CURA3,
  /** 
   * The Spot Rate for a Rate Calculation Date will be determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date. The Calculation Agent will request the Specified Office of each of the Reference Dealers to provide a firm quotation of its Specified Rate for a transaction where the amount of Reference Currency equals the Specified Amount. If four quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates, without regard to the Specified Rates having the highest and lowest value. If exactly three quotations are provided, the rate for a Rate Calculation Date will be the Specified Rate provided by the Reference Dealer that remains after disregarding the Specified Rates having the highest and lowest values. For this purpose, if more than one quotation has the same highest value or lowest value, then the Specified Rate of one of such quotations shall be disregarded. If exactly two quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates. If only one quotation is provided, the rate for a Rate Calculation Date will be the Specified Rate quoted by that Reference Dealer. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on that Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent. 
   */
  @SerialName("CURRENCY-REFERENCE.DEALERS/CURA4")
  CURRENCY_REFERENCE_DEALERS_CURA4,
  /** 
   * The Spot Rate for a Rate Calculation Date will be determined by the Calculation Agent on the basis of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, in a legal and customary wholesale market in which there is no, or minimal, Governmental Authority controls or interference, except as a participant in such market. 
   */
  @SerialName("CURRENCY-WHOLESALE.MARKET/CURA5")
  CURRENCY_WHOLESALE_MARKET_CURA5,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Ecuadorian Sucre/U.S. Dollar Specified Rate, expressed as the amount of Ecuadorian Sucres per one U.S. Dollar, for settlement in one Business Day (where such day is a Business Day in Guayaquil and New York) which appears on Reuters Screen DNRP Page at 12:00 noon, Guayaquil time, on that Rate Calculation Date. 
   */
  @SerialName("ECS.DNRP/ECS01")
  ECS_DNRP_ECS01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'IDR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("IDR.ABS/IDR01")
  IDR_ABS_IDR01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar weighted average spot rate in the interbank market based on traded IDR/USD spot foreign exchange transactions during a specified time period which are captured on a real time basis, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, published by Bank Indonesia at approximately 10:00 a.m., Jakarta time, on that Rate Calculation Date as the Jakarta Interbank Spot Dollar Rate USD - IDR on Bank Indonesia's website or otherwise made available by Bank Indonesia (or its successor as administrator). 
   */
  @SerialName("IDR.JISDOR/IDR04")
  IDR_JISDOR_IDR04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC IDR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indonesian Rupiah/U.S. Dollar markets for the purpose of determining the SFEMC IDR Indicative Survey Rate). 
   */
  @SerialName("IDR.SFEMC.INDICATIVE.SURVEY.RATE/IDR02")
  IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar implied spot rate expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of that rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("IDR.VWAP/IDR03")
  IDR_VWAP_IDR03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BOIJ Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date. 
   */
  @SerialName("ILS.BOIJ/ILS01")
  ILS_BOIJ_ILS01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen FXIL Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date. 
   */
  @SerialName("ILS.FXIL/ILS02")
  ILS_FXIL_ILS02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, reported by Financial Benchmarks India Pvt. Ltd. (www.fbil.org.in) at approximately 1:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date. 
   */
  @SerialName("INR.FBIL/INR01")
  INR_FBIL_INR01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days reported by the Reserve Bank of India which appears on the Reuters Screen RBIB Page at approximately 12:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date. 
   */
  @SerialName("INR.RBIB/INR01")
  INR_RBIB_INR01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC INR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indian Rupee/U.S. Dollar markets for the purpose of determining the SFEMC INR Indicative Survey Rate). 
   */
  @SerialName("INR.SFEMC.INDICATIVE.SURVEY.RATE/INR02")
  INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen KEBEY Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("KRW.KEBEY/KRW01")
  KRW_KEBEY_KRW01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on the Reuters Screen KFTC18 Page to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable. 
   */
  @SerialName("KRW.KFTC18/KRW02")
  KRW_KFTC18_KRW02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC KRW Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Korean Won/U.S. Dollar markets for the purpose of determining the SFEMC KRW Indicative Survey Rate). 
   */
  @SerialName("KRW.SFEMC.INDICATIVE.SURVEY.RATE/KRW04")
  KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on Telerate Page 45644 to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable. 
   */
  @SerialName("KRW.TELERATE.45644/KRW03")
  KRW_TELERATE_45644_KRW03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 1:00 p.m., Almaty time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA KZT Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Kazakhstan Tenge/U.S. Dollar markets for the purpose of determining the EMTA KZT Indicative Survey Rate). 
   */
  @SerialName("KZT.EMTA.INDICATIVE.SURVEY.RATE/KZT02")
  KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar weighted average rate, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day reported by the Kazakhstan Stock Exchange (www.kase.kz) at approximately 11:00 am, Almaty time, on that Rate Calculation Date. 
   */
  @SerialName("KZT.KASE/KZT01")
  KZT_KASE_KZT01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Lebanese Pound/U.S. Dollar Specified Rate, expressed as the amount of Lebanese Pounds per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BDLX Page as of 12:00 noon, Beirut time, on that Rate Calculation Date. 
   */
  @SerialName("LBP.BDLX/LBP01")
  LBP_BDLX_LBP01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Moroccan Dirham/U.S. Dollar Specified Rate, expressed as the amount of Moroccan Dirham per one U.S. Dollar, for settlement in two Business Days reported by the Central Bank of Morocco as of 1:00 p.m., Rabat time, on that Rate Calculation Date. 
   */
  @SerialName("MAD.OFFICIAL.RATE/MAD01")
  MAD_OFFICIAL_RATE_MAD01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Mexican Pesos/U.S. Dollar Specified rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on the Reuters Screen BNMX Page opposite the caption 'Fix' at the close of business in Mexico City on that Rate Calculation Date. 
   */
  @SerialName("MXP.BNMX/MXP01")
  MXP_BNMX_MXP01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by Banco de Mexico in the Official Gazette of the Federation pursuant to the 'Disposiciones aplicables a la determinacion del tipo de Cambio para solventar obligaciones denominadas en moneda extranjera pagaderas en la Republica Mexicana' (Rules applicable to determine the exchange rate to pay obligations denominated in foreign currency payable in Mexico) on the first Business Day following that Rate Calculation Date. 
   */
  @SerialName("MXP.FIXING.RATE/MXP02")
  MXP_FIXING_RATE_MXP02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on Reuters Screen MEX01 Page under the heading 'MXNFIX=RR', at the close of business in Mexico City on that Rate Calculation Date. 
   */
  @SerialName("MXP.MEX01/MXP03")
  MXP_MEX01_MXP03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by the Bolsa Mexicana de Valores, S.A. de C.V. (as established in Section 2 of the 'Resolution concerning the exchange rate applicable for calculating the Mexican Peso equivalent of principal and interest of Mexican Treasury Notes denominated in foreign currency and payable in Mexican Pesos' published in the Diario Oficial de la Federacion on November 11, 1991) in the Movimiento Diario del Mercado de Valores de la Bolsa Mexicana de Valores, S.A. de C.V. under the heading 'Movimiento Diario del Mercado de Valores' on that Rate Calculation Date. 
   */
  @SerialName("MXP.PUBLISHED/MXP04")
  MXP_PUBLISHED_MXP04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore, which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'MYR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("MYR.ABS/MYR01")
  MYR_ABS_MYR01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar reference rate, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, calculated and reported by Bank Negara Malaysia as its Kuala Lumpur USD/MYR Reference Rate, which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 3:30 p.m., Kuala Lumpur time, on that Rate Calculation Date. 
   */
  @SerialName("MYR.KL.REF/MYR04")
  MYR_KL_REF_MYR04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by Persatuan Pasaran Kewangan Malaysia (ACI - Malaysia), which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 11:10 a.m., Kuala Lumpur time, on that Rate Calculation Date. 
   */
  @SerialName("MYR.PPKM/MYR03")
  MYR_PPKM_MYR03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC MYR Indicative Survey Methodology (which means a methodology, dated as of July 15, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Malaysian Ringgit/U.S. Dollar markets for the purpose of determining the SFEMC MYR Indicative Survey Rate). 
   */
  @SerialName("MYR.SFEMC.INDICATIVE.SURVEY.RATE/MYR02")
  MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Peruvian Soles per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Lima time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA PEN Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Peruvian Sol/U.S. Dollar markets for the purpose of determining the EMTA PEN Indicative Survey Rate). 
   */
  @SerialName("PEN.EMTA.INDICATIVE.SURVEY.RATE/PEN04")
  PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar average exchange rate in the interbank market expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day reported by the Banco Central de Reserva del Peru (www.bcrp.gob.pe) as the 'Tipo de Cambio Interbancario Promedio' at approximately 2:00 p.m., Lima time, on that Rate Calculation Date. 
   */
  @SerialName("PEN.INTERBANK.AVE/PEN05")
  PEN_INTERBANK_AVE_PEN05,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar fixing rate (mid market last), expressed as the amount of Peruvian Sols per one U.S. Dollar, for settlement on that same day which appears on the Reuters Screen PDSB Page opposite the caption 'PEN=' as of 12:00 noon, Lima time, on that Rate Calculation Date. 
   */
  @SerialName("PEN.PDSB/PEN01")
  PEN_PDSB_PEN01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the midpoint of the Peruvian Sol/U.S. Dollar closing weighted average bid and offer ('compra y venta') exchange rates expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day, reported by the Superintendencia de Banca, Seguros y AFP (www.sbs.gob.pe) of the Republic of Peru at approximately 5:00 p.m., Lima time, on that Rate Calculation Date. 
   */
  @SerialName("PEN.WT.AVE/PEN03")
  PEN_WT_AVE_PEN03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, sponsored by Bankers Association of the Philippines (www.bap.org.ph) as its 'BAP AM Weighted Average Rate' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date. 
   */
  @SerialName("PHP.BAPPESO/PHP06")
  PHP_BAPPESO_PHP06,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Philippine Dealing System PDEX which appears on the Reuters Screen PDSPESO Page to the right of the caption 'AM WT AVE' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date. 
   */
  @SerialName("PHP.PDSPESO/PHP06")
  PHP_PDSPESO_PHP06,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Reuters Screen PHPESO Page at approximately 11:00 a.m., Manila time, on that Rate Calculation Date. 
   */
  @SerialName("PHP.PHPESO/PHP01")
  PHP_PHPESO_PHP01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PHP Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Philippine Peso/U.S. Dollar markets for the purpose of determining the SFEMC PHP Indicative Survey Rate). 
   */
  @SerialName("PHP.SFEMC.INDICATIVE.SURVEY.RATE/PHP05")
  PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 15439 at approximately 11:00 a.m., Manila time, on that Rate Calculation Date. 
   */
  @SerialName("PHP.TELERATE.15439/PHP03")
  PHP_TELERATE_15439_PHP03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 2920 at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("PHP.TELERATE.2920/PHP02")
  PHP_TELERATE_2920_PHP02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar reference rate expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days reported by the State Bank of Pakistan (www.sbp.org.pk) at approximately 2:30 pm, Karachi time, on that Rate Calculation Date. 
   */
  @SerialName("PKR.SBPK/PKR01")
  PKR_SBPK_PKR01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. Singapore time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PKR Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Pakistani Rupee/U.S. Dollar markets for the purpose of determining the SFEMC PKR Indicative Survey Rate). 
   */
  @SerialName("PKR.SFEMC.INDICATIVE.SURVEY.RATE/PKR02")
  PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar Specified Rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPQ Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("PLZ.NBPQ/PLZ01")
  PLZ_NBPQ_PLZ01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar fixing rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPR Page at the Specified Time, if any, on that Rate Calculation Date. 
   */
  @SerialName("PLZ.NBPR/PLZ02")
  PLZ_NBPR_PLZ02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, calculated by the Chicago Mercantile Exchange ('CME') and as published on CME's website, which appears on the Reuters Screen EMTA Page, at approximately 1:30 p.m., Moscow time, on that Rate Calculation Date. The Spot Rate shall be calculated by the CME pursuant to the Chicago Mercantile Exchange / EMTA, Inc. Daily Russian Ruble Per U.S. Dollar Reference Rate Methodology (which means a methodology, effective as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions in Russia that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the RUB CME-EMTA Rate). 
   */
  @SerialName("RUB.CME-EMTA/RUB03")
  RUB_CME_EMTA_RUB03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, as published on EMTA's web site (www.emta.org) at approximately 2:45 p.m., Moscow time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA RUB Indicative Survey Methodology (which means a methodology dated as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the EMTA RUB Indicative Survey Rate). 
   */
  @SerialName("RUB.EMTA.INDICATIVE.SURVEY.RATE/RUB04")
  RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MICEXFRX Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date. 
   */
  @SerialName("RUB.MICEXFRX/RUB01")
  RUB_MICEXFRX_RUB01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MMVB Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date. 
   */
  @SerialName("RUB.MMVB/RUB02")
  RUB_MMVB_RUB02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Singapore Dollar/U.S. Dollar spot rate expressed as the amount of Singapore Dollar per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("SGD.VWAP/SGD3")
  SGD_VWAP_SGD3,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Slovak Koruna/U.S. Dollar Specified Rate, expressed as the amount of Slovak Koruna per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Slovakia which appears on the Reuters Screen NBSB Page as of 11:40 a.m., Bratislava time, on that Rate Calculation Date. 
   */
  @SerialName("SKK.NBSB/SKK01")
  SKK_NBSB_SKK01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Thai Baht/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Thai Bhaht per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'THB' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("THB.ABS/THB01")
  THB_ABS_THB01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Thai Baht / U.S. Dollar spot rate expressed as the amount of Thai Baht per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("THB.VWAP/THB01")
  THB_VWAP_THB01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC TWD Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Taiwanese Dollar/U.S. Dollar markets for the purpose of determining the SFEMC TWD Indicative Survey Rate). 
   */
  @SerialName("TWD.SFEMC.INDICATIVE.SURVEY.RATE/TWD04")
  TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Reuters Screen TAIFX1 Page under the heading 'Spot' as of 11:00 a.m. Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time on that Rate Calculation Date. 
   */
  @SerialName("TWD.TAIFX1/TWD03")
  TWD_TAIFX1_TWD03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Telerate Page 6161 under the heading 'Spot' as of 11:00 a.m., Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time, on that Rate Calculation Date. 
   */
  @SerialName("TWD.TELERATE.6161/TWD01")
  TWD_TELERATE_6161_TWD01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen TFEMA Page as of 11:00 a.m., Taipei time, on that Rate Calculation Date. 
   */
  @SerialName("TWD.TFEMA/TWD02")
  TWD_TFEMA_TWD02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 2:00 p.m., Kiev time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA UAH Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Ukrainian Hryvnia / U.S. Dollar markets for the purpose of determining the EMTA UAH Indicative Survey Rate). 
   */
  @SerialName("UAH.EMTA.INDICATIVE.SURVEY.RATE/UAH03")
  UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day calculated by Thomson Reuters pursuant to the EMTA UAH Industry Survey Methodology, which rate appears on EMTA's website (www.emta.org) and on Thomson Reuters Page EMTAUAHFIX at approximately 11:30 am, Kiev time, on that Rate Calculation Date. The 'EMTA UAH Industry Survey Methodology' as used herein means the methodology dated as of March 16, 2009, for a centralized industry wide survey of financial institutions in the Ukrainian Hryvnia/U.S. Dollar spot market for the purposes of determining the EMTA UAH Industry Survey Rate. 
   */
  @SerialName("UAH.EMTA.INDUSTRY.SURVEY.RATE/UAH02")
  UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar spot rate, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day reported by GFI Brokers on Thomson Reuters Page GFIU by 9:30 am, London time, on that Rate Calculation Date. 
   */
  @SerialName("UAH.GFI/UAH01")
  UAH_GFI_UAH01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the midpoint of the Venezuelan Bolivar /U.S. Dollar Tipo de Cambio De Referencia buying and selling rates, expressed as the amount of Venezuelan Bolivar per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central de Venezuela (www.bcv.org.ve) at approximately 5:00 p.m., Caracas time, on that Rate Calculation Date. 
   */
  @SerialName("VEF.FIX/VEF01")
  VEF_FIX_VEF01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days reported by the Association of Banks in Singapore, which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'VND' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date. 
   */
  @SerialName("VND.ABS/VND01")
  VND_ABS_VND01,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days which appears on Reuters Screen VNDFIX=VN Page under the caption 'Spot' and to the right of the caption 'Average' at approximately 11:00 am, Hanoi time, on that Rate Calculation Date. 
   */
  @SerialName("VND.FX/VND02")
  VND_FX_VND02,
  /** 
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon as thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC VND Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Vietnamese Dong/U.S. Dollar markets for the purpose of determining the SFEMC VND Indicative Survey Rate). 
   */
  @SerialName("VND.SFEMC.INDICATIVE.SURVEY.RATE/VND03")
  VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03
  ;
}

/** 
 * The enumeration values to specify how the option is to be settled when exercised. 
 */
@Serializable
enum class SettlementTypeEnum {
  /** 
   * The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties. 
   */
  @SerialName("CASH")
  CASH,
  /** 
   * Allow use of either Cash or Physical settlement without prior Election. 
   */
  @SerialName("CASH_OR_PHYSICAL")
  CASH_OR_PHYSICAL,
  /** 
   * Allow Election of either Cash or Physical settlement. 
   */
  @SerialName("ELECTION")
  ELECTION,
  /** 
   * The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share. 
   */
  @SerialName("PHYSICAL")
  PHYSICAL
  ;
}

/** 
 * The enumerated values to specify the consequences of extraordinary events relating to the underlying. 
 */
@Serializable
enum class ShareExtraordinaryEventEnum {
  /** 
   * The trade continues such that the underlying now consists of the New Shares and/or the Other Consideration, if any, and the proceeds of any redemption, if any, that the holder of the underlying Shares would have been entitled to. 
   */
  @SerialName("ALTERNATIVE_OBLIGATION")
  ALTERNATIVE_OBLIGATION,
  /** 
   * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments may not be made to account solely for changes in volatility, expected dividends, stock loan rate or liquidity. 
   */
  @SerialName("CALCULATION_AGENT")
  CALCULATION_AGENT,
  /** 
   * The trade is cancelled and a cancellation fee will be paid by one party to the other. 
   */
  @SerialName("CANCELLATION_AND_PAYMENT")
  CANCELLATION_AND_PAYMENT,
  /** 
   * If this is a Share-for-Combined merger event (Shares are replaced with New Shares and Other Consideration), then different treatment can be applied to each component if the parties have specified this. 
   */
  @SerialName("COMPONENT")
  COMPONENT,
  /** 
   * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments to account for changes in volatility, expected dividends, stock loan rate or liquidity are allowed. 
   */
  @SerialName("MODIFIED_CALCULATION_AGENT")
  MODIFIED_CALCULATION_AGENT,
  /** 
   * The trade will be adjusted by the Calculation Agent in accordance with the adjustments made by any exchange on which options on the underlying are listed. 
   */
  @SerialName("OPTIONS_EXCHANGE")
  OPTIONS_EXCHANGE,
  /** 
   * Applies to Basket Transactions. The portion of the Basket made up by the affected Share will be cancelled and a cancellation fee will be paid from one party to the other. The remainder of the trade continues. 
   */
  @SerialName("PARTIAL_CANCELLATION_AND_PAYMENT")
  PARTIAL_CANCELLATION_AND_PAYMENT
  ;
}

/** 
 * The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined. 
 */
@Serializable
enum class SpecifiedEntityClauseEnum {
  @SerialName("BANKRUPTCY")
  BANKRUPTCY,
  @SerialName("CREDIT_EVENT_UPON_MERGER")
  CREDIT_EVENT_UPON_MERGER,
  @SerialName("CROSS_DEFAULT")
  CROSS_DEFAULT,
  @SerialName("DEFAULT_UNDER_SPECIFIED_TRANSACTION")
  DEFAULT_UNDER_SPECIFIED_TRANSACTION
  ;
}

/** 
 * The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified. 
 */
@Serializable
enum class SpecifiedEntityTermsEnum {
  /** 
   * Any Affiliate is a Specified Entity. 
   */
  @SerialName("ANY_AFFILIATE")
  ANY_AFFILIATE,
  /** 
   * Any Material Subsidiary. 
   */
  @SerialName("MATERIAL_SUBSIDIARY")
  MATERIAL_SUBSIDIARY,
  /** 
   * The Specified Entity is provided. 
   */
  @SerialName("NAMED_SPECIFIED_ENTITY")
  NAMED_SPECIFIED_ENTITY,
  /** 
   * No Specified Entity is provided 
   */
  @SerialName("NONE")
  NONE,
  /** 
   * Non standard Specified Entity terms are provided. 
   */
  @SerialName("OTHER_SPECIFIED_ENTITY")
  OTHER_SPECIFIED_ENTITY
  ;
}

/** 
 * Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated. 
 */
@Serializable
enum class SpreadCalculationMethodEnum {
  @SerialName("PAR_PAR")
  PAR_PAR,
  @SerialName("PROCEEDS")
  PROCEEDS
  ;
}

/** 
 * The enumerated values to specify a long or short spread value. 
 */
@Serializable
enum class SpreadScheduleTypeEnum {
  /** 
   * Represents a Long Spread Schedule. Spread schedules defined as 'Long' will be applied to Long Positions. 
   */
  @SerialName("LONG")
  LONG,
  /** 
   * Represents a Short Spread Schedule. Spread schedules defined as 'Short' will be applied to Short Positions. 
   */
  @SerialName("SHORT")
  SHORT
  ;
}

/** 
 * The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting. 
 */
@Serializable
enum class StandardSettlementStyleEnum {
  /** 
   * This trade is a candidate for settlement netting. 
   */
  @SerialName("NET")
  NET,
  /** 
   * These trades have been paired and are a candidate for settlement netting. 
   */
  @SerialName("PAIR_AND_NET")
  PAIR_AND_NET,
  /** 
   * This trade will settle using standard predetermined funds settlement instructions. 
   */
  @SerialName("STANDARD")
  STANDARD,
  /** 
   * This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting. 
   */
  @SerialName("STANDARD_AND_NET")
  STANDARD_AND_NET
  ;
}

@Serializable
enum class StandardizedScheduleAssetClassEnum {
  @SerialName("COMMODITY")
  COMMODITY,
  @SerialName("CREDIT")
  CREDIT,
  @SerialName("EQUITY")
  EQUITY,
  @SerialName("FOREIGN_EXCHANGE")
  FOREIGN_EXCHANGE,
  @SerialName("INTEREST_RATES")
  INTEREST_RATES
  ;
}

@Serializable
enum class StandardizedScheduleProductClassEnum {
  @SerialName("BASIS_SWAP")
  BASIS_SWAP,
  @SerialName("CONTRACT_FOR_DIFFERENCE")
  CONTRACT_FOR_DIFFERENCE,
  @SerialName("CORRELATION_SWAP")
  CORRELATION_SWAP,
  @SerialName("CREDIT_NTH_TO_DEFAULT")
  CREDIT_NTH_TO_DEFAULT,
  @SerialName("CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND")
  CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND,
  @SerialName("CROSS_CURRENCY_SWAP")
  CROSS_CURRENCY_SWAP,
  @SerialName("DELIVERABLE_FORWARD")
  DELIVERABLE_FORWARD,
  @SerialName("DELIVERABLE_OPTION")
  DELIVERABLE_OPTION,
  @SerialName("DELIVERABLE_OPTION_F")
  DELIVERABLE_OPTION_F,
  @SerialName("DELIVERABLE_SWAP")
  DELIVERABLE_SWAP,
  @SerialName("DIVIDEND_SWAP")
  DIVIDEND_SWAP,
  @SerialName("FIXED_FLOAT_SWAP")
  FIXED_FLOAT_SWAP,
  @SerialName("FORWARD")
  FORWARD,
  @SerialName("FORWARD_RATE_AGREEMENT")
  FORWARD_RATE_AGREEMENT,
  @SerialName("IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG")
  IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG,
  @SerialName("INDEX_CDS")
  INDEX_CDS,
  @SerialName("INDEX_TRANCHE")
  INDEX_TRANCHE,
  @SerialName("NON_DELIVERABLE_CROSS_CURRENCY_SWAP")
  NON_DELIVERABLE_CROSS_CURRENCY_SWAP,
  @SerialName("NON_DELIVERABLE_FORWARD")
  NON_DELIVERABLE_FORWARD,
  @SerialName("NON_DELIVERABLE_OPTION")
  NON_DELIVERABLE_OPTION,
  @SerialName("OPTION")
  OPTION,
  @SerialName("SINGLE_NAME_CREDIT_DEFAULT_SWAP")
  SINGLE_NAME_CREDIT_DEFAULT_SWAP,
  @SerialName("SWAP")
  SWAP,
  @SerialName("SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS")
  SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS,
  @SerialName("SWAPS_AND_PORTFOLIO_SWAPS")
  SWAPS_AND_PORTFOLIO_SWAPS,
  @SerialName("SWAPTION")
  SWAPTION,
  @SerialName("SWAPTION_STRADDLE")
  SWAPTION_STRADDLE,
  @SerialName("VARIANCE_SWAP")
  VARIANCE_SWAP,
  @SerialName("VOLATILITY_SWAP")
  VOLATILITY_SWAP
  ;
}

/** 
 * The enumerated values to specify how to deal with a non standard calculation period within a swap stream. 
 */
@Serializable
enum class StubPeriodTypeEnum {
  /** 
   * If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period. 
   */
  @SerialName("LONG_FINAL")
  LONG_FINAL,
  /** 
   * If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period. 
   */
  @SerialName("LONG_INITIAL")
  LONG_INITIAL,
  /** 
   * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream. 
   */
  @SerialName("SHORT_FINAL")
  SHORT_FINAL,
  /** 
   * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream. 
   */
  @SerialName("SHORT_INITIAL")
  SHORT_INITIAL
  ;
}

/** 
 * Represents an enumeration list to identify the type of supranational entity issuing the asset. 
 */
@Serializable
enum class SupraNationalIssuerTypeEnum {
  /** 
   * Specifies International Financial Institution. 
   */
  @SerialName("INTERNATIONAL_ORGANISATION")
  INTERNATIONAL_ORGANISATION,
  /** 
   * Specifies Multilateral Bank or Multilateral Development Bank. 
   */
  @SerialName("MULTILATERAL_BANK")
  MULTILATERAL_BANK
  ;
}

/** 
 * Represents the enumerated values to specify taxonomy sources. 
 */
@Serializable
enum class TaxonomySourceEnum {
  /** 
   * Represents the ISO 10962 Classification of Financial Instruments code. 
   */
  @SerialName("CFI")
  CFI,
  /** 
   * Represents the EMIR Article 9 Asset Definition Identifier code. 
   */
  @SerialName("EMIR")
  EMIR,
  /** 
   * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. 
   */
  @SerialName("EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")
  EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,
  /** 
   * Represents the ISDA Collateral Asset Definition Identifier code. 
   */
  @SerialName("ICAD")
  ICAD,
  /** 
   * Represents the ISDA product taxonomy. 
   */
  @SerialName("ISDA")
  ISDA,
  /** 
   * Represents the Monetary Authority of Singapore (MAS) as a taxonomy source. 
   */
  @SerialName("MAS")
  MAS,
  /** 
   * Denotes a user-specific scheme or taxonomy or other external sources not listed here. 
   */
  @SerialName("OTHER")
  OTHER,
  /** 
   * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities.Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM. 
   */
  @SerialName("UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")
  UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,
  /** 
   * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules. 
   */
  @SerialName("US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS")
  US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS
  ;
}

/** 
 * The enumerated values to specify the type of telephone number, e.g. work vs. mobile. 
 */
@Serializable
enum class TelephoneTypeEnum {
  /** 
   * A number used primarily for work-related facsimile transmissions. 
   */
  @SerialName("FAX")
  FAX,
  /** 
   * A number on a mobile telephone that is often or usually used for work-related calls. This type of number can be used for urgent work related business when a work number is not sufficient to contact the person or firm. 
   */
  @SerialName("MOBILE")
  MOBILE,
  /** 
   * A number used primarily for non work-related calls. (Normally this type of number would be used only as an emergency backup number, not as a regular course of business). 
   */
  @SerialName("PERSONAL")
  PERSONAL,
  /** 
   * A number used primarily for work-related calls. Includes home office numbers used primarily for work purposes. 
   */
  @SerialName("WORK")
  WORK
  ;
}

@Serializable
enum class TerminationCurrencyConditionEnum {
  /** 
   * A currency that is freely available. 
   */
  @SerialName("FREELY_AVAILABLE")
  FREELY_AVAILABLE,
  /** 
   * A currency in which payments would be due under one or more Transactions. 
   */
  @SerialName("PAYMENTS_DUE")
  PAYMENTS_DUE,
  /** 
   * A currency in which payments would be due under one or more Transactions and that is freely available. 
   */
  @SerialName("PAYMENTS_DUE_AND_FREELY_AVAILABLE")
  PAYMENTS_DUE_AND_FREELY_AVAILABLE,
  /** 
   * Termination Currency Conditions are specified. 
   */
  @SerialName("SPECIFIED")
  SPECIFIED
  ;
}

/** 
 * The enumerated values to specify points in the day when option exercise and valuation can occur. 
 */
@Serializable
enum class TimeTypeEnum {
  /** 
   * The time is determined as provided in the relevant Master Confirmation. 
   */
  @SerialName("AS_SPECIFIED_IN_MASTER_CONFIRMATION")
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,
  /** 
   * The official closing time of the exchange on the valuation date. 
   */
  @SerialName("CLOSE")
  CLOSE,
  /** 
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier. 
   */
  @SerialName("DERIVATIVES_CLOSE")
  DERIVATIVES_CLOSE,
  /** 
   * The time at which the official settlement price is determined. 
   */
  @SerialName("OSP")
  OSP,
  /** 
   * The official opening time of the exchange on the valuation date. 
   */
  @SerialName("OPEN")
  OPEN,
  /** 
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate). 
   */
  @SerialName("SPECIFIC_TIME")
  SPECIFIC_TIME,
  /** 
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange. 
   */
  @SerialName("XETRA")
  XETRA
  ;
}

/** 
 * The enumeration values to qualify the allowed units of time. 
 */
@Serializable
enum class TimeUnitEnum {
  /** 
   * Day 
   */
  @SerialName("DAY")
  DAY,
  /** 
   * Hour 
   */
  @SerialName("HOUR")
  HOUR,
  /** 
   * Minute 
   */
  @SerialName("MINUTE")
  MINUTE,
  /** 
   * Month 
   */
  @SerialName("MONTH")
  MONTH,
  /** 
   * Second 
   */
  @SerialName("SECOND")
  SECOND,
  /** 
   * Week 
   */
  @SerialName("WEEK")
  WEEK,
  /** 
   * Year 
   */
  @SerialName("YEAR")
  YEAR
  ;
}

/** 
 * Defines the enumerated values to specify the nature of a trade identifier. 
 */
@Serializable
enum class TradeIdentifierTypeEnum {
  @SerialName("UNIQUE_SWAP_IDENTIFIER")
  UNIQUE_SWAP_IDENTIFIER,
  @SerialName("UNIQUE_TRANSACTION_IDENTIFIER")
  UNIQUE_TRANSACTION_IDENTIFIER
  ;
}

/** 
 * The enumeration values to specify how the transfer will settle, e.g. DvP. 
 */
@Serializable
enum class TransferSettlementEnum {
  /** 
   * Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk. 
   */
  @SerialName("DELIVERY_VERSUS_DELIVERY")
  DELIVERY_VERSUS_DELIVERY,
  /** 
   * Settlement in which the transfer of the asset and the cash settlement are simultaneous. 
   */
  @SerialName("DELIVERY_VERSUS_PAYMENT")
  DELIVERY_VERSUS_PAYMENT,
  /** 
   * No central settlement. 
   */
  @SerialName("NOT_CENTRAL_SETTLEMENT")
  NOT_CENTRAL_SETTLEMENT,
  /** 
   * Simultaneous transfer of cashflows. 
   */
  @SerialName("PAYMENT_VERSUS_PAYMENT")
  PAYMENT_VERSUS_PAYMENT
  ;
}

/** 
 * The enumeration values to specify the transfer status. 
 */
@Serializable
enum class TransferStatusEnum {
  /** 
   * The transfer is disputed. 
   */
  @SerialName("DISPUTED")
  DISPUTED,
  /** 
   * The transfer has been instructed. 
   */
  @SerialName("INSTRUCTED")
  INSTRUCTED,
  /** 
   * The transfer has been netted into a separate Transfer. 
   */
  @SerialName("NETTED")
  NETTED,
  /** 
   * The transfer is pending instruction. 
   */
  @SerialName("PENDING")
  PENDING,
  /** 
   * The transfer has been settled. 
   */
  @SerialName("SETTLED")
  SETTLED
  ;
}

/** 
 * The enumerated values to specify the time of day which would be considered for valuing the knock event. 
 */
@Serializable
enum class TriggerTimeTypeEnum {
  /** 
   * At any time during the Knock Determination period (continuous barrier). 
   */
  @SerialName("ANYTIME")
  ANYTIME,
  /** 
   * The close of trading on a day would be considered for valuation. 
   */
  @SerialName("CLOSING")
  CLOSING
  ;
}

/** 
 * The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate. 
 */
@Serializable
enum class TriggerTypeEnum {
  /** 
   * The underlier price must be equal to the Trigger level. 
   */
  @SerialName("EQUAL")
  EQUAL,
  /** 
   * The underlier price must be equal to or greater than the Trigger level. 
   */
  @SerialName("EQUAL_OR_GREATER")
  EQUAL_OR_GREATER,
  /** 
   * The underlier price must be equal to or less than the Trigger level. 
   */
  @SerialName("EQUAL_OR_LESS")
  EQUAL_OR_LESS,
  /** 
   * The underlier price must be greater than the Trigger level. 
   */
  @SerialName("GREATER")
  GREATER,
  /** 
   * The underlier price must be less than the Trigger level. 
   */
  @SerialName("LESS")
  LESS
  ;
}

/** 
 * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM. 
 */
@Serializable
enum class UK_EMIR_EligibleCollateralEnum {
  /** 
   * Denotes cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits. 
   */
  @SerialName("UK_EMIR_TYPE_A")
  UK_EMIR_TYPE_A,
  /** 
   * Denotes gold in the form of allocated pure gold bullion of recognised good delivery. 
   */
  @SerialName("UK_EMIR_TYPE_B")
  UK_EMIR_TYPE_B,
  /** 
   * Denotes debt securities issued by the central government of the United Kingdom or the Bank of England. 
   */
  @SerialName("UK_EMIR_TYPE_C")
  UK_EMIR_TYPE_C,
  /** 
   * Denotes debt securities issued by United Kingdom regional governments or local authorities whose exposures are treated as exposures to the central government of the United Kingdom in accordance with Article 115(2) of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_D")
  UK_EMIR_TYPE_D,
  /** 
   * Denotes debt securities issued by United Kingdom public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of the United Kingdom in accordance with Article 116(4) of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_E")
  UK_EMIR_TYPE_E,
  /** 
   * Denotes debt securities issued by United Kingdom regional governments or local authorities other than those referred to in (TypeD). 
   */
  @SerialName("UK_EMIR_TYPE_F")
  UK_EMIR_TYPE_F,
  /** 
   * Denotes debt securities issued by United Kingdom public sector entities other than those referred to in (TypeE). 
   */
  @SerialName("UK_EMIR_TYPE_G")
  UK_EMIR_TYPE_G,
  /** 
   * Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_H")
  UK_EMIR_TYPE_H,
  /** 
   * Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_I")
  UK_EMIR_TYPE_I,
  /** 
   * Denotes debt securities issued by third countries' governments or central banks. 
   */
  @SerialName("UK_EMIR_TYPE_J")
  UK_EMIR_TYPE_J,
  /** 
   * Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE). 
   */
  @SerialName("UK_EMIR_TYPE_K")
  UK_EMIR_TYPE_K,
  /** 
   * Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE). 
   */
  @SerialName("UK_EMIR_TYPE_L")
  UK_EMIR_TYPE_L,
  /** 
   * Denotes debt securities issued by credit institutions or investment firms including bonds admitted to the register of regulated covered bonds maintained under Regulation 7(1)(b) of the Regulated Covered Bonds Regulations 2008 (SI 2008/346). 
   */
  @SerialName("UK_EMIR_TYPE_M")
  UK_EMIR_TYPE_M,
  /** 
   * Denotes corporate bonds. 
   */
  @SerialName("UK_EMIR_TYPE_N")
  UK_EMIR_TYPE_N,
  /** 
   * Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation. 
   */
  @SerialName("UK_EMIR_TYPE_O")
  UK_EMIR_TYPE_O,
  /** 
   * Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_P")
  UK_EMIR_TYPE_P,
  /** 
   * Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013. 
   */
  @SerialName("UK_EMIR_TYPE_Q")
  UK_EMIR_TYPE_Q,
  /** 
   * Denotes shares or units in undertakings for UK UCITS, provided that the conditions set out in Article 5 of EU Regulation 2016/2251 (as modified by the Technical Standards (European Market Infrastructure) (EU Exit) (No. 3) Instrument 2019) are met. 
   */
  @SerialName("UK_EMIR_TYPE_R")
  UK_EMIR_TYPE_R
  ;
}

/** 
 * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules. 
 */
@Serializable
enum class US_CFTC_PR_EligibleCollateralEnum {
  /** 
   * Denotes immediately available cash funds denominated in USD, a major currency, a currency of settlement for the uncleared swap. 
   */
  @SerialName("US_CFTC_PR_TYPE_1")
  US_CFTC_PR_TYPE_1,
  /** 
   * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury. 
   */
  @SerialName("US_CFTC_PR_TYPE_2")
  US_CFTC_PR_TYPE_2,
  /** 
   * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, a U.S. government agency (other than the U.S. Department of Treasury) whose obligations are fully guaranteed by the full faith and credit of the United States government. 
   */
  @SerialName("US_CFTC_PR_TYPE_3")
  US_CFTC_PR_TYPE_3,
  /** 
   * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator. 
   */
  @SerialName("US_CFTC_PR_TYPE_4")
  US_CFTC_PR_TYPE_4,
  /** 
   * Denotes a publicly traded debt security issued by, or an asset-backed security fully guaranteed as to the timely payment of principal and interest by, a U.S. Government-sponsored enterprise that is operating with capital support or another form of direct financial assistance received from the U.S. government that enables the repayments of the U.S. Government-sponsored enterprise's eligible securities. 
   */
  @SerialName("US_CFTC_PR_TYPE_5_A")
  US_CFTC_PR_TYPE_5_A,
  /** 
   * Denotes a publicly traded debt security, but not an asset backed security, that is investment grade and issued by a U.S. Government-sponsored enterprise that is not operating with capital support or another form of direct financial assistance received from the U.S. government. 
   */
  @SerialName("US_CFTC_PR_TYPE_5_B")
  US_CFTC_PR_TYPE_5_B,
  /** 
   * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the Bank for International Settlements, the International Monetary Fund, or a multilateral development bank. 
   */
  @SerialName("US_CFTC_PR_TYPE_6")
  US_CFTC_PR_TYPE_6,
  /** 
   * Denotes publicly-traded debt, but not an asset backed security, that is investment grade and is not a debt security issued by a  U.S. Government-sponsored enterprise. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer. 
   */
  @SerialName("US_CFTC_PR_TYPE_7")
  US_CFTC_PR_TYPE_7,
  /** 
   * Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer. 
   */
  @SerialName("US_CFTC_PR_TYPE_8_A")
  US_CFTC_PR_TYPE_8_A,
  /** 
   *  Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 1500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer. 
   */
  @SerialName("US_CFTC_PR_TYPE_8_B")
  US_CFTC_PR_TYPE_8_B,
  /** 
   * Denotes a publicly traded common equity security that is included in an index that a regulated swap entity's supervisor in a foreign jurisdiction recognizes for purposes of including publicly traded common equity as initial margin under applicable regulatory policy, if held in that foreign jurisdiction. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer. 
   */
  @SerialName("US_CFTC_PR_TYPE_8_C")
  US_CFTC_PR_TYPE_8_C,
  /** 
   * Denotes securities in the form of redeemable securities in a pooled investment fund representing the security-holder's proportional interest in the fund's net assets and that are issued and redeemed only on the basis of the market value of the fund's net assets prepared each business day after the security-holder makes its investment commitment or redemption request to the fund, if the fund's investments are limited to the following: (A) securities that are issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury, and immediately-available cash funds denominated in U.S. dollars; or (B) securities denominated in a common currency and issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator, and immediately-available cash funds denominated in the same currency; and (C) assets of the fund may not be transferred through securities lending, securities borrowing, repurchase agreements, reverse repurchase agreements, or other means that involve the fund having rights to acquire the same or similar assets from the transferee. 
   */
  @SerialName("US_CFTC_PR_TYPE_9")
  US_CFTC_PR_TYPE_9,
  /** 
   * Denotes Gold. 
   */
  @SerialName("US_CTFC_PR_TYPE_10")
  US_CTFC_PR_TYPE_10
  ;
}

/** 
 * The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. 
 */
@Serializable
enum class ValuationMethodEnum {
  @SerialName("AVERAGE_BLENDED_HIGHEST")
  AVERAGE_BLENDED_HIGHEST,
  @SerialName("AVERAGE_BLENDED_MARKET")
  AVERAGE_BLENDED_MARKET,
  @SerialName("AVERAGE_HIGHEST")
  AVERAGE_HIGHEST,
  @SerialName("AVERAGE_MARKET")
  AVERAGE_MARKET,
  @SerialName("BLENDED_HIGHEST")
  BLENDED_HIGHEST,
  @SerialName("BLENDED_MARKET")
  BLENDED_MARKET,
  @SerialName("HIGHEST")
  HIGHEST,
  @SerialName("MARKET")
  MARKET
  ;
}

/** 
 * Source for the valuation of the transaction by the valuation party. 
 */
@Serializable
enum class ValuationSourceEnum {
  /** 
   * Central Counterparty's Valuation 
   */
  @SerialName("CENTRAL_COUNTERPARTY")
  CENTRAL_COUNTERPARTY
  ;
}

/** 
 * Method used for the valuation of the transaction by the valuation party. 
 */
@Serializable
enum class ValuationTypeEnum {
  /** 
   * Mark-to-Market 
   */
  @SerialName("MARK_TO_MARKET")
  MARK_TO_MARKET,
  /** 
   * Mark-to-Model 
   */
  @SerialName("MARK_TO_MODEL")
  MARK_TO_MODEL
  ;
}

@Serializable
enum class WarehouseIdentityEnum {
  /** 
   * The DTCC Trade Information Warehouse Gold service 
   */
  @SerialName("DTCC_TIW_GOLD")
  DTCC_TIW_GOLD
  ;
}

/** 
 * Provides enumerated values for weather units, generally used in the context of defining quantities for commodities. 
 */
@Serializable
enum class WeatherUnitEnum {
  /** 
   * Denotes Cooling Degree Days as a standard unit. 
   */
  @SerialName("CDD")
  CDD,
  /** 
   * Denotes Critical Precipitation Day as a standard unit. 
   */
  @SerialName("CPD")
  CPD,
  /** 
   * Heating Degree Day as a standard unit. 
   */
  @SerialName("HDD")
  HDD
  ;
}

/** 
 * The enumerated values to specify the weekly roll day. 
 */
@Serializable
enum class WeeklyRollConventionEnum {
  /** 
   * Friday 
   */
  @SerialName("FRI")
  FRI,
  /** 
   * Monday 
   */
  @SerialName("MON")
  MON,
  /** 
   * Saturday 
   */
  @SerialName("SAT")
  SAT,
  /** 
   * Sunday 
   */
  @SerialName("SUN")
  SUN,
  /** 
   * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday 
   */
  @SerialName("TBILL")
  TBILL,
  /** 
   * Thursday 
   */
  @SerialName("THU")
  THU,
  /** 
   * Tuesday 
   */
  @SerialName("TUE")
  TUE,
  /** 
   * Wednesday 
   */
  @SerialName("WED")
  WED
  ;
}

@Serializable
enum class WorkflowStatusEnum {
  @SerialName("ACCEPTED")
  ACCEPTED,
  @SerialName("AFFIRMED")
  AFFIRMED,
  @SerialName("ALLEGED")
  ALLEGED,
  @SerialName("AMENDED")
  AMENDED,
  @SerialName("CANCELLED")
  CANCELLED,
  @SerialName("CERTAIN")
  CERTAIN,
  @SerialName("CLEARED")
  CLEARED,
  @SerialName("CONFIRMED")
  CONFIRMED,
  @SerialName("PENDING")
  PENDING,
  @SerialName("REJECTED")
  REJECTED,
  @SerialName("SUBMITTED")
  SUBMITTED,
  @SerialName("TERMINATED")
  TERMINATED,
  @SerialName("UNCERTAIN")
  UNCERTAIN,
  @SerialName("UNCONFIRMED")
  UNCONFIRMED
  ;
}
