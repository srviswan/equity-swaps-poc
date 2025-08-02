/**
  * This file is auto-generated from the ISDA Common Domain Model, do not edit.
  * Version: 6.0.0
  */
package org.isda.cdm

import com.fasterxml.jackson.core.`type`.TypeReference

/**
  * The enumeration values to qualify the type of account.
  */
object AccountTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Aggregate client account, as defined under ESMA MiFIR.
    */
  val AGGREGATE_CLIENT = Value
  
  /**
    * The account contains trading activity or positions that belong to a client of the firm that opened the account.
    */
  val CLIENT = Value
  
  /**
    * The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
    */
  val HOUSE = Value
}

/**
  * The enumeration values to specify the actions associated with transactions.
  */
object ActionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
    */
  val CANCEL = Value
  
  /**
    * A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
    */
  val CORRECT = Value
  
  /**
    * A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
    */
  val NEW = Value
}

/**
  * Enumeration for the different types of affirmation status.
  */
object AffirmationStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val AFFIRMED = Value
  
  val UNAFFIRMED = Value
}

/**
  * If there is an alternative to interest amounts, how is it specified?
  */
object AlternativeToInterestAmountEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The standard calculation of the Interest Amount is replaced with the amount of interest the secured party actually receives in relation to the Cash collateral.
    */
  val ACTUAL_AMOUNT_RECEIVED = Value
  
  /**
    * An other alternative option outside these choices that can be described as an alternative provision.
    */
  val OTHER = Value
  
  /**
    * Interest amount is not transferred if transfer would create or increase a delivery amount.
    */
  val STANDARD = Value
  
  /**
    * Interest amount is not transferred if transfer would create or increase a delivery amount. (This is the 'Standard' provision). However, interest Amount will be transferred if Delivery Amount is below Minimum Transfer Amount.
    */
  val TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA = Value
}

/**
  * Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
  */
object AncillaryRoleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies the party responsible for deciding the fallback rate.
    */
  val CALCULATION_AGENT_FALLBACK = Value
  
  /**
    * Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition.
    */
  val CALCULATION_AGENT_INDEPENDENT = Value
  
  /**
    * Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination.
    */
  val CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION = Value
  
  /**
    * Specifies the party responsible for performing calculation agent duties associated with an optional early termination.
    */
  val CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION = Value
  
  /**
    * Specifies the party which determines additional disruption events.
    */
  val DISRUPTION_EVENTS_DETERMINING_PARTY = Value
  
  /**
    * Specifies the party to which notice of a cancelable provision exercise should be given.
    */
  val EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION = Value
  
  /**
    * Specifies the party to which notice of a extendible provision exercise should be given.
    */
  val EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION = Value
  
  /**
    * Specifies the party to which notice of a manual exercise should be given.
    */
  val EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL = Value
  
  /**
    * Specifies the party to which notice of a optional early termination exercise should be given.
    */
  val EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION = Value
  
  /**
    * Specifies the party which determines if dividends are extraordinary in relation to normal levels.
    */
  val EXTRAORDINARY_DIVIDENDS_PARTY = Value
  
  /**
    * Specifies the clearing organization (CCP, DCO) which the trade should be cleared.
    */
  val PREDETERMINED_CLEARING_ORGANIZATION_PARTY = Value
}

/**
  * An arithmetic operator that can be passed to a function
  */
object ArithmeticOperationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Addition of 2 values
    */
  val ADD = Value
  
  /**
    * Division of 1st value by 2nd value
    */
  val DIVIDE = Value
  
  /**
    * Maximum of 2 values
    */
  val MAX = Value
  
  /**
    * Minimum of 2 values
    */
  val MIN = Value
  
  /**
    * Multiplication of 2 values
    */
  val MULTIPLY = Value
  
  /**
    * Subtraction of 2nd value from 1st value
    */
  val SUBTRACT = Value
}

/**
  * The enumerated values to specify the FpML asset class categorization.
  */
object AssetClassEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Commodity.
    */
  val COMMODITY = Value
  
  /**
    * Credit.
    */
  val CREDIT = Value
  
  /**
    * Equity.
    */
  val EQUITY = Value
  
  /**
    * ForeignExchange.
    */
  val FOREIGN_EXCHANGE = Value
  
  /**
    * InterestRate.
    */
  val INTEREST_RATE = Value
  
  /**
    * Money Market Assets like CP and CD.
    */
  val MONEY_MARKET = Value
}

/**
  * Extends product identifiers with additional identifier sources for Assets.
  */
object AssetIdTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
    */
  val BBGID = Value
  
  /**
    * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
    */
  val BBGTICKER = Value
  
  /**
    * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
    */
  val CUSIP = Value
  
  /**
    * The identifier follows the symbology set by the clearing house which clears the asset.
    */
  val CLEARING_CODE = Value
  
  /**
    * Used to identify the currency of a Cash Asset.
    */
  val CURRENCY_CODE = Value
  
  /**
    * The identifier follows the symbology set by the exchange which lists the asset.
    */
  val EXCHANGE_CODE = Value
  
  /**
    * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
    */
  val FIGI = Value
  
  /**
    * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
    */
  val ISDACRP = Value
  
  /**
    * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
    */
  val ISIN = Value
  
  /**
    * The name of the product.
    */
  val NAME = Value
  
  /**
    * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
    */
  val OTHER = Value
  
  /**
    * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
    */
  val RIC = Value
  
  /**
    * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well.
    */
  val SEDOL = Value
  
  /**
    * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
    */
  val SICOVAM = Value
  
  /**
    * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
    */
  val UPI = Value
  
  /**
    * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
    */
  val WERTPAPIER = Value
}

/**
  * An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout.
  */
object AssetPayoutTradeTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo.
    */
  val BUY_SELL_BACK = Value("Buy/Sell-Back")
  
  /**
    * In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller.
    */
  val REPO = Value
}

/**
  * The qualification of the type of asset transfer.
  */
object AssetTransferTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The transfer of assets takes place without a corresponding exchange of payment.
    */
  val FREE_OF_PAYMENT = Value
}

/**
  * Represents an enumeration list to identify the asset type.
  */
object AssetTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indentifies cash in a currency form.
    */
  val CASH = Value
  
  /**
    * Indentifies basic good used in commerce that is interchangeable with other goods of the same type.
    */
  val COMMODITY = Value
  
  /**
    * Indentifies other asset types.
    */
  val OTHER = Value
  
  /**
    * Indentifies negotiable financial instrument of monetary value with an issue ownership position.
    */
  val SECURITY = Value
}

/**
  * Enumeration to describe the type of AvailableInventory
  */
object AvailableInventoryTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Where a lender is broadcasting the securities that they have available to lend
    */
  val AVAILABLE_TO_LEND = Value
  
  /**
    * Where a party is asking a lender if they have specific securities available for them to borrow
    */
  val REQUEST_TO_BORROW = Value
}

/**
  * Indicates the type of equity average trading volume (single) the highest amount on one exchange, or (consolidated) volumes across more than one exchange.
  */
object AverageTradingVolumeMethodologyEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Consolidated volume across more than one exchange.
    */
  val CONSOLIDATED = Value
  
  /**
    * Single, the highest amount on one exchange.
    */
  val SINGLE = Value
}

/**
  * Specifies enumerations for the type of averaging calculation.
  */
object AveragingCalculationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
    */
  val ARITHMETIC = Value
  
  /**
    * Refers to the calculation of an average by taking the nth root of the product of n observations.
    */
  val GEOMETRIC = Value
  
  /**
    * Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
    */
  val HARMONIC = Value
}

/**
  * The enumerated values to specify the type of averaging used in an Asian option.
  */
object AveragingInOutEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The average price is used to derive both the strike and the expiration price.
    */
  val BOTH = Value
  
  /**
    * The average price is used to derive the strike price. Also known as 'Asian strike' style option.
    */
  val IN = Value
  
  /**
    * The average price is used to derive the expiration price. Also known as 'Asian price' style option.
    */
  val OUT = Value
}

/**
  * The enumerated values to specify the method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts.
  */
object AveragingWeightingMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The arithmetic mean of the relevant rates for each reset date.
    */
  val UNWEIGHTED = Value
  
  /**
    * The arithmetic mean of the relevant rates in effect for each day in a calculation period calculated by multiplying each relevant rate by the number of days such relevant rate is in effect, determining the sum of such products and dividing such sum by the number of days in the calculation period.
    */
  val WEIGHTED = Value
}

/**
  * Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles.
  */
object BankHolidayTreatmentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Bank holidays treated as weekdays.
    */
  val AS_WEEKDAY = Value
  
  /**
    * Bank holidays treated as weekends.
    */
  val AS_WEEKEND = Value
}

/**
  * The enumerated values to specify the business centers.
  */
object BusinessCenterEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii))
    */
  val AEAB = Value
  
  /**
    * Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i))
    */
  val AEAD = Value
  
  /**
    * Dubai, United Arab Emirates
    */
  val AEDU = Value
  
  /**
    * Yerevan, Armenia
    */
  val AMYE = Value
  
  /**
    * Luanda, Angola
    */
  val AOLU = Value
  
  /**
    * Buenos Aires, Argentina
    */
  val ARBA = Value
  
  /**
    * Vienna, Austria
    */
  val ATVI = Value
  
  /**
    * Adelaide, Australia
    */
  val AUAD = Value
  
  /**
    * Brisbane, Australia
    */
  val AUBR = Value
  
  /**
    * Canberra, Australia
    */
  val AUCA = Value
  
  /**
    * Darwin, Australia
    */
  val AUDA = Value
  
  /**
    * Melbourne, Australia
    */
  val AUME = Value
  
  /**
    * Perth, Australia
    */
  val AUPE = Value
  
  /**
    * Sydney, Australia
    */
  val AUSY = Value
  
  /**
    * Baku, Azerbaijan
    */
  val AZBA = Value
  
  /**
    * Bridgetown, Barbados
    */
  val BBBR = Value
  
  /**
    * Dhaka, Bangladesh
    */
  val BDDH = Value
  
  /**
    * Brussels, Belgium
    */
  val BEBR = Value
  
  /**
    * Sofia, Bulgaria
    */
  val BGSO = Value
  
  /**
    * Manama, Bahrain
    */
  val BHMA = Value
  
  /**
    * Hamilton, Bermuda
    */
  val BMHA = Value
  
  /**
    * Bandar Seri Begawan, Brunei
    */
  val BNBS = Value
  
  /**
    * La Paz, Bolivia
    */
  val BOLP = Value
  
  /**
    * Brazil Business Day.
    */
  val BRBD = Value
  
  /**
    * Brasilia, Brazil.
    */
  val BRBR = Value
  
  /**
    * Rio de Janeiro, Brazil.
    */
  val BRRJ = Value
  
  /**
    * Sao Paulo, Brazil.
    */
  val BRSP = Value
  
  /**
    * Nassau, Bahamas
    */
  val BSNA = Value
  
  /**
    * Gaborone, Botswana
    */
  val BWGA = Value
  
  /**
    * Minsk, Belarus
    */
  val BYMI = Value
  
  /**
    * Calgary, Canada
    */
  val CACL = Value
  
  /**
    * Fredericton, Canada.
    */
  val CAFR = Value
  
  /**
    * Montreal, Canada
    */
  val CAMO = Value
  
  /**
    * Ottawa, Canada
    */
  val CAOT = Value
  
  /**
    * Toronto, Canada
    */
  val CATO = Value
  
  /**
    * Vancouver, Canada
    */
  val CAVA = Value
  
  /**
    * Winnipeg, Canada
    */
  val CAWI = Value
  
  /**
    * Basel, Switzerland
    */
  val CHBA = Value
  
  /**
    * Geneva, Switzerland
    */
  val CHGE = Value
  
  /**
    * Zurich, Switzerland
    */
  val CHZU = Value
  
  /**
    * Abidjan, Cote d'Ivoire
    */
  val CIAB = Value
  
  /**
    * Santiago, Chile
    */
  val CLSA = Value
  
  /**
    * Yaounde, Cameroon
    */
  val CMYA = Value
  
  /**
    * Beijing, China
    */
  val CNBE = Value
  
  /**
    * Shanghai, China
    */
  val CNSH = Value
  
  /**
    * Bogota, Colombia
    */
  val COBO = Value
  
  /**
    * San Jose, Costa Rica
    */
  val CRSJ = Value
  
  /**
    * Willemstad, Curacao
    */
  val CWWI = Value
  
  /**
    * Nicosia, Cyprus
    */
  val CYNI = Value
  
  /**
    * Prague, Czech Republic
    */
  val CZPR = Value
  
  /**
    * Cologne, Germany
    */
  val DECO = Value
  
  /**
    * Dusseldorf, Germany
    */
  val DEDU = Value
  
  /**
    * Frankfurt, Germany
    */
  val DEFR = Value
  
  /**
    * Hannover, Germany
    */
  val DEHA = Value
  
  /**
    * Hamburg, Germany
    */
  val DEHH = Value
  
  /**
    * Leipzig, Germany
    */
  val DELE = Value
  
  /**
    * Mainz, Germany
    */
  val DEMA = Value
  
  /**
    * Munich, Germany
    */
  val DEMU = Value
  
  /**
    * Stuttgart, Germany
    */
  val DEST = Value
  
  /**
    * Copenhagen, Denmark
    */
  val DKCO = Value
  
  /**
    * Santo Domingo, Dominican Republic
    */
  val DOSD = Value
  
  /**
    * Algiers, Algeria
    */
  val DZAL = Value
  
  /**
    * Guayaquil, Ecuador
    */
  val ECGU = Value
  
  /**
    * Tallinn, Estonia
    */
  val EETA = Value
  
  /**
    * Cairo, Egypt
    */
  val EGCA = Value
  
  /**
    * ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
    */
  val ESAS = Value
  
  /**
    * Barcelona, Spain
    */
  val ESBA = Value
  
  /**
    * Madrid, Spain
    */
  val ESMA = Value
  
  /**
    * San Sebastian, Spain
    */
  val ESSS = Value
  
  /**
    * Addis Ababa, Ethiopia
    */
  val ETAA = Value
  
  /**
    * Publication dates for ICE Swap rates based on EUR-EURIBOR rates
    */
  val EUR_ICESWAP = Value("EUR-ICESWAP")
  
  /**
    * TARGET Settlement Day
    */
  val EUTA = Value
  
  /**
    * Helsinki, Finland
    */
  val FIHE = Value
  
  /**
    * Paris, France
    */
  val FRPA = Value
  
  /**
    * Edinburgh, Scotland
    */
  val GBED = Value
  
  /**
    * London, United Kingdom
    */
  val GBLO = Value
  
  /**
    * Publication dates for GBP ICE Swap rates
    */
  val GBP_ICESWAP = Value("GBP-ICESWAP")
  
  /**
    * Tbilisi, Georgia
    */
  val GETB = Value
  
  /**
    * Saint Peter Port, Guernsey
    */
  val GGSP = Value
  
  /**
    * Accra, Ghana
    */
  val GHAC = Value
  
  /**
    * Gibraltar, Gibraltar
    */
  val GIGI = Value
  
  /**
    * Banjul, Gambia
    */
  val GMBA = Value
  
  /**
    * Conakry, Guinea
    */
  val GNCO = Value
  
  /**
    * Athens, Greece
    */
  val GRAT = Value
  
  /**
    * Guatemala City, Guatemala
    */
  val GTGC = Value
  
  /**
    * Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.]
    */
  val GUGC = Value
  
  /**
    * Hong Kong, Hong Kong
    */
  val HKHK = Value
  
  /**
    * Tegucigalpa, Honduras
    */
  val HNTE = Value
  
  /**
    * Zagreb, Republic of Croatia
    */
  val HRZA = Value
  
  /**
    * Budapest, Hungary
    */
  val HUBU = Value
  
  /**
    * Jakarta, Indonesia
    */
  val IDJA = Value
  
  /**
    * Dublin, Ireland
    */
  val IEDU = Value
  
  /**
    * Jerusalem, Israel
    */
  val ILJE = Value
  
  /**
    * Publication dates of the ILS-TELBOR index.
    */
  val ILS_TELBOR = Value("ILS-TELBOR")
  
  /**
    * Tel Aviv, Israel
    */
  val ILTA = Value
  
  /**
    * Ahmedabad, India
    */
  val INAH = Value
  
  /**
    * Bangalore, India
    */
  val INBA = Value
  
  /**
    * Chennai, India
    */
  val INCH = Value
  
  /**
    * Hyderabad, India
    */
  val INHY = Value
  
  /**
    * Kolkata, India
    */
  val INKO = Value
  
  /**
    * Mumbai, India
    */
  val INMU = Value
  
  /**
    * New Delhi, India
    */
  val INND = Value
  
  /**
    * Baghdad, Iraq
    */
  val IQBA = Value
  
  /**
    * Teheran, Iran
    */
  val IRTE = Value
  
  /**
    * Reykjavik, Iceland
    */
  val ISRE = Value
  
  /**
    * Milan, Italy
    */
  val ITMI = Value
  
  /**
    * Rome, Italy
    */
  val ITRO = Value
  
  /**
    * Turin, Italy
    */
  val ITTU = Value
  
  /**
    * St. Helier, Channel Islands, Jersey
    */
  val JESH = Value
  
  /**
    * Kingston, Jamaica
    */
  val JMKI = Value
  
  /**
    * Amman, Jordan
    */
  val JOAM = Value
  
  /**
    * Tokyo, Japan
    */
  val JPTO = Value
  
  /**
    * Nairobi, Kenya
    */
  val KENA = Value
  
  /**
    * Phnom Penh, Cambodia
    */
  val KHPP = Value
  
  /**
    * Seoul, Republic of Korea
    */
  val KRSE = Value
  
  /**
    * Kuwait City, Kuwait
    */
  val KWKC = Value
  
  /**
    * George Town, Cayman Islands
    */
  val KYGE = Value
  
  /**
    * Almaty, Kazakhstan
    */
  val KZAL = Value
  
  /**
    * Vientiane, Laos
    */
  val LAVI = Value
  
  /**
    * Beirut, Lebanon
    */
  val LBBE = Value
  
  /**
    * Colombo, Sri Lanka
    */
  val LKCO = Value
  
  /**
    * Luxembourg, Luxembourg
    */
  val LULU = Value
  
  /**
    * Riga, Latvia
    */
  val LVRI = Value
  
  /**
    * Casablanca, Morocco
    */
  val MACA = Value
  
  /**
    * Rabat, Morocco
    */
  val MARA = Value
  
  /**
    * Monaco, Monaco
    */
  val MCMO = Value
  
  /**
    * Ulan Bator, Mongolia
    */
  val MNUB = Value
  
  /**
    * Macau, Macao
    */
  val MOMA = Value
  
  /**
    * Valletta, Malta
    */
  val MTVA = Value
  
  /**
    * Port Louis, Mauritius
    */
  val MUPL = Value
  
  /**
    * Male, Maldives
    */
  val MVMA = Value
  
  /**
    * Lilongwe, Malawi
    */
  val MWLI = Value
  
  /**
    * Mexico City, Mexico
    */
  val MXMC = Value
  
  /**
    * Kuala Lumpur, Malaysia
    */
  val MYKL = Value
  
  /**
    * Labuan, Malaysia
    */
  val MYLA = Value
  
  /**
    * Maputo, Mozambique
    */
  val MZMA = Value
  
  /**
    * Windhoek, Namibia
    */
  val NAWI = Value
  
  /**
    * Abuja, Nigeria
    */
  val NGAB = Value
  
  /**
    * Lagos, Nigeria
    */
  val NGLA = Value
  
  /**
    * Amsterdam, Netherlands
    */
  val NLAM = Value
  
  /**
    * Rotterdam, Netherlands
    */
  val NLRO = Value
  
  /**
    * Oslo, Norway
    */
  val NOOS = Value
  
  /**
    * Kathmandu, Nepal
    */
  val NPKA = Value
  
  /**
    * New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7)
    */
  val NYFD = Value
  
  /**
    * New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8)
    */
  val NYSE = Value
  
  /**
    * Auckland, New Zealand
    */
  val NZAU = Value
  
  /**
    * Wellington, New Zealand
    */
  val NZWE = Value
  
  /**
    * Muscat, Oman
    */
  val OMMU = Value
  
  /**
    * Panama City, Panama
    */
  val PAPC = Value
  
  /**
    * Lima, Peru
    */
  val PELI = Value
  
  /**
    * Manila, Philippines
    */
  val PHMA = Value
  
  /**
    * Makati, Philippines
    */
  val PHMK = Value
  
  /**
    * Karachi, Pakistan
    */
  val PKKA = Value
  
  /**
    * Warsaw, Poland
    */
  val PLWA = Value
  
  /**
    * San Juan, Puerto Rico
    */
  val PRSJ = Value
  
  /**
    * Lisbon, Portugal
    */
  val PTLI = Value
  
  /**
    * Doha, Qatar
    */
  val QADO = Value
  
  /**
    * Bucharest, Romania
    */
  val ROBU = Value
  
  /**
    * Belgrade, Serbia
    */
  val RSBE = Value
  
  /**
    * Moscow, Russian Federation
    */
  val RUMO = Value
  
  /**
    * Abha, Saudi Arabia
    */
  val SAAB = Value
  
  /**
    * Jeddah, Saudi Arabia
    */
  val SAJE = Value
  
  /**
    * Riyadh, Saudi Arabia
    */
  val SARI = Value
  
  /**
    * Stockholm, Sweden
    */
  val SEST = Value
  
  /**
    * Singapore, Singapore
    */
  val SGSI = Value
  
  /**
    * Ljubljana, Slovenia
    */
  val SILJ = Value
  
  /**
    * Bratislava, Slovakia
    */
  val SKBR = Value
  
  /**
    * Freetown, Sierra Leone
    */
  val SLFR = Value
  
  /**
    * Dakar, Senegal
    */
  val SNDA = Value
  
  /**
    * San Salvador, El Salvador
    */
  val SVSS = Value
  
  /**
    * Bangkok, Thailand
    */
  val THBA = Value
  
  /**
    * Tunis, Tunisia
    */
  val TNTU = Value
  
  /**
    * Ankara, Turkey
    */
  val TRAN = Value
  
  /**
    * Istanbul, Turkey
    */
  val TRIS = Value
  
  /**
    * Port of Spain, Trinidad and Tobago
    */
  val TTPS = Value
  
  /**
    * Taipei, Taiwan
    */
  val TWTA = Value
  
  /**
    * Dar es Salaam, Tanzania
    */
  val TZDA = Value
  
  /**
    * Dodoma, Tanzania
    */
  val TZDO = Value
  
  /**
    * Kiev, Ukraine
    */
  val UAKI = Value
  
  /**
    * Kampala, Uganda
    */
  val UGKA = Value
  
  /**
    * Boston, Massachusetts, United States
    */
  val USBO = Value
  
  /**
    * Chicago, United States
    */
  val USCH = Value
  
  /**
    * Charlotte, North Carolina, United States
    */
  val USCR = Value
  
  /**
    * Washington, District of Columbia, United States
    */
  val USDC = Value
  
  /**
    * Denver, United States
    */
  val USDN = Value
  
  /**
    * Detroit, Michigan, United States
    */
  val USDT = Value
  
  /**
    * Publication dates for ICE Swap rates based on USD-LIBOR rates
    */
  val USD_ICESWAP = Value("USD-ICESWAP")
  
  /**
    * Publication dates for the USD-Municipal Swap Index
    */
  val USD_MUNI = Value("USD-MUNI")
  
  /**
    * U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
    */
  val USGS = Value
  
  /**
    * Honolulu, Hawaii, United States
    */
  val USHL = Value
  
  /**
    * Houston, United States
    */
  val USHO = Value
  
  /**
    * Los Angeles, United States
    */
  val USLA = Value
  
  /**
    * Mobile, Alabama, United States
    */
  val USMB = Value
  
  /**
    * Minneapolis, United States
    */
  val USMN = Value
  
  /**
    * New York, United States
    */
  val USNY = Value
  
  /**
    * Portland, Oregon, United States
    */
  val USPO = Value
  
  /**
    * Sacramento, California, United States
    */
  val USSA = Value
  
  /**
    * Seattle, United States
    */
  val USSE = Value
  
  /**
    * San Francisco, United States
    */
  val USSF = Value
  
  /**
    * Wichita, United States
    */
  val USWT = Value
  
  /**
    * Montevideo, Uruguay
    */
  val UYMO = Value
  
  /**
    * Tashkent, Uzbekistan
    */
  val UZTA = Value
  
  /**
    * Caracas, Venezuela
    */
  val VECA = Value
  
  /**
    * Road Town, Virgin Islands (British)
    */
  val VGRT = Value
  
  /**
    * Hanoi, Vietnam
    */
  val VNHA = Value
  
  /**
    * Ho Chi Minh (formerly Saigon), Vietnam
    */
  val VNHC = Value
  
  /**
    * Aden, Yemen
    */
  val YEAD = Value
  
  /**
    * Johannesburg, South Africa
    */
  val ZAJO = Value
  
  /**
    * Lusaka, Zambia
    */
  val ZMLU = Value
  
  /**
    * Harare, Zimbabwe
    */
  val ZWHA = Value
}

/**
  * The enumerated values to specify the convention for adjusting any relevant date if it would otherwise fall on a day that is not a valid business day.
  */
object BusinessDayConventionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The non-business date will be adjusted to the first following day that is a business day
    */
  val FOLLOWING = Value
  
  /**
    * Per 2000 ISDA Definitions, Section 4.11. FRN Convention; Eurodollar Convention. FRN is included here as a type of business day convention although it does not strictly fall within ISDA's definition of a Business Day Convention and does not conform to the simple definition given above.
    */
  val FRN = Value
  
  /**
    * The non-business date will be adjusted to the first following day that is a business day unless that day falls in the next calendar month, in which case that date will be the first preceding day that is a business day.
    */
  val MODFOLLOWING = Value
  
  /**
    * The non-business date will be adjusted to the first preceding day that is a business day unless that day falls in the previous calendar month, in which case that date will be the first following day that us a business day.
    */
  val MODPRECEDING = Value
  
  /**
    * The non-business date will be adjusted to the nearest day that is a business day - i.e. if the non-business day falls on any day other than a Sunday or a Monday, it will be the first preceding day that is a business day, and will be the first following business day if it falls on a Sunday or a Monday.
    */
  val NEAREST = Value
  
  /**
    * The date will not be adjusted if it falls on a day that is not a business day.
    */
  val NONE = Value
  
  /**
    * The date adjustments conventions are defined elsewhere, so it is not required to specify them here.
    */
  val NOT_APPLICABLE = Value
  
  /**
    * The non-business day will be adjusted to the first preceding day that is a business day.
    */
  val PRECEDING = Value
}

/**
  * What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
  */
object CalculationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Averaging, i.e. arithmetic averaging.
    */
  val AVERAGING = Value
  
  /**
    * A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula.
    */
  val COMPOUNDED_INDEX = Value
  
  /**
    * Compounding, i.e. geometric averaging following an ISDA defined formula.
    */
  val COMPOUNDING = Value
}

/**
  *  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
  */
object CalculationShiftMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days.
    */
  val LOOKBACK = Value
  
  /**
    * calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style.
    */
  val NO_SHIFT = Value
  
  /**
    * the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period.
    */
  val OBSERVATION_PERIOD_SHIFT = Value
  
  /**
    * Calculations cut the rate off several business days prior to rate setting (Lockout).
    */
  val RATE_CUT_OFF = Value
}

/**
  * Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call.
  */
object CallTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement.
    */
  val EXPECTED_CALL = Value
  
  /**
    * Identifies an actionable Margin Call.
    */
  val MARGIN_CALL = Value
  
  /**
    * Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent.
    */
  val NOTIFICATION = Value
}

/**
  * Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
  */
object CallingPartyEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * As defined in Master Agreement.
    */
  val AS_DEFINED_IN_MASTER_AGREEMENT = Value
  
  /**
    * Either, Buyer or Seller to the repo transaction.
    */
  val EITHER = Value
  
  /**
    * Initial buyer to the repo transaction.
    */
  val INITIAL_BUYER = Value
  
  /**
    * Initial seller to the repo transaction.
    */
  val INITIAL_SELLER = Value
}

/**
  * Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
  */
object CapacityUnitEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes Allowances as standard unit.
    */
  val ALW = Value
  
  /**
    * Denotes a Barrel as a standard unit.
    */
  val BBL = Value
  
  /**
    * Denotes Billion Cubic Feet as a standard unit.
    */
  val BCF = Value
  
  /**
    * Denotes Board Feet as a standard unit.
    */
  val BDFT = Value
  
  /**
    * Denotes Cubic Meters as a standard unit.
    */
  val CBM = Value
  
  /**
    * Denotes Certified Emissions Reduction as a standard unit.
    */
  val CER = Value
  
  /**
    * Denotes Climate Reserve Tonnes as a standard unit.
    */
  val CRT = Value
  
  /**
    * Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
    */
  val DAG = Value
  
  /**
    * Denotes a single day as a standard unit used in time charter trades.
    */
  val DAY = Value
  
  /**
    * Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
    */
  val DMTU = Value
  
  /**
    * Denotes Environmental Credit as a standard unit.
    */
  val ENVCRD = Value
  
  /**
    * Denotes Environmental Offset as a standard unit.
    */
  val ENVOFST = Value
  
  /**
    * Denotes a 40 ft. Equivalent Unit container as a standard unit.
    */
  val FEU = Value
  
  /**
    * Denotes a Gram as a standard unit.
    */
  val G = Value
  
  /**
    * Denotes a GB Bushel as a standard unit.
    */
  val GBBSH = Value
  
  /**
    * Denotes a GB British Thermal Unit as a standard unit.
    */
  val GBBTU = Value
  
  /**
    * Denotes a GB Hundredweight unit as standard unit.
    */
  val GBCWT = Value
  
  /**
    * Denotes a GB Gallon unit as standard unit.
    */
  val GBGAL = Value
  
  /**
    * Denotes a Thousand GB British Thermal Units as a standard unit.
    */
  val GBMBTU = Value
  
  /**
    * Denotes a Million GB British Thermal Units as a standard unit.
    */
  val GBMMBTU = Value
  
  /**
    * Denotes a GB Ton as a standard unit.
    */
  val GBT = Value
  
  /**
    * Denotes a GB Thermal Unit as a standard unit.
    */
  val GBTHM = Value
  
  /**
    * Denotes a Gigajoule as a standard unit.
    */
  val GJ = Value
  
  /**
    * Denotes a Gigawatt as a standard unit.
    */
  val GW = Value
  
  /**
    * Denotes a Gigawatt-hour as a standard unit.
    */
  val GWH = Value
  
  /**
    * Denotes a Hectolitre as a standard unit.
    */
  val HL = Value
  
  /**
    * Denotes a 100-troy ounces Gold Bar as a standard unit.
    */
  val HOGB = Value
  
  /**
    * Denotes an ISO British Thermal Unit as a standard unit.
    */
  val ISOBTU = Value
  
  /**
    * Denotes a Thousand ISO British Thermal Unit as a standard unit.
    */
  val ISOMBTU = Value
  
  /**
    * Denotes a Million ISO British Thermal Unit as a standard unit.
    */
  val ISOMMBTU = Value
  
  /**
    * Denotes an ISO Thermal Unit as a standard unit.
    */
  val ISOTHM = Value
  
  /**
    * Denotes a Joule as a standard unit.
    */
  val J = Value
  
  /**
    * Denotes a Kilogram as a standard unit.
    */
  val KG = Value
  
  /**
    * Denotes a Kilolitre as a standard unit.
    */
  val KL = Value
  
  /**
    * Denotes a Kilowatt as a standard unit.
    */
  val KW = Value
  
  /**
    * Denotes a Kilowatt-day as a standard unit.
    */
  val KWD = Value
  
  /**
    * Denotes a Kilowatt-hour as a standard unit.
    */
  val KWH = Value
  
  /**
    * Denotes a Kilowatt-month as a standard unit.
    */
  val KWM = Value
  
  /**
    * Denotes a Kilowatt-minute as a standard unit.
    */
  val KWMIN = Value
  
  /**
    * Denotes a Kilowatt-year as a standard unit.
    */
  val KWY = Value
  
  /**
    * Denotes a Litre as a standard unit.
    */
  val L = Value
  
  /**
    * Denotes a Pound as a standard unit.
    */
  val LB = Value
  
  /**
    * Denotes a Thousand Barrels as a standard unit.
    */
  val MB = Value
  
  /**
    * Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
    */
  val MBF = Value
  
  /**
    * Denotes a Megajoule as a standard unit.
    */
  val MJ = Value
  
  /**
    * Denotes a Million Barrels as a standard unit.
    */
  val MMBBL = Value
  
  /**
    * Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
    */
  val MMBF = Value
  
  /**
    * Denotes a Thousand square feet as a standard unit.
    */
  val MSF = Value
  
  /**
    * Denotes a Metric Ton as a standard unit.
    */
  val MT = Value
  
  /**
    * Denotes a Megawatt as a standard unit.
    */
  val MW = Value
  
  /**
    * Denotes a Megawatt-day as a standard unit.
    */
  val MWD = Value
  
  /**
    * Denotes a Megawatt-hour as a standard unit.
    */
  val MWH = Value
  
  /**
    * Denotes a Megawatt-month as a standard unit.
    */
  val MWM = Value
  
  /**
    * Denotes a Megawatt-minute as a standard unit.
    */
  val MWMIN = Value
  
  /**
    * Denotes a Megawatt-year as a standard unit.
    */
  val MWY = Value
  
  /**
    * Denotes a Troy Ounce as a standard unit.
    */
  val OZT = Value
  
  /**
    * Denotes a Standard Gold Bar as a standard unit.
    */
  val SGB = Value
  
  /**
    * Denotes a 20 ft. Equivalent Unit container as a standard unit.
    */
  val TEU = Value
  
  /**
    * Denotes a US Bushel as a standard unit.
    */
  val USBSH = Value
  
  /**
    * Denotes a US British Thermal Unit as a standard unit.
    */
  val USBTU = Value
  
  /**
    * Denotes US Hundredweight unit as a standard unit.
    */
  val USCWT = Value
  
  /**
    * Denotes a US Gallon unit as a standard unit.
    */
  val USGAL = Value
  
  /**
    * Denotes a Thousand US British Thermal Units as a standard unit.
    */
  val USMBTU = Value
  
  /**
    * Denotes a Million US British Thermal Units as a standard unit.
    */
  val USMMBTU = Value
  
  /**
    * Denotes a US Ton as a standard unit.
    */
  val UST = Value
  
  /**
    * Denotes a US Thermal Unit as a standard unit.
    */
  val USTHM = Value
}

/**
  * Provides a list of possible types of cash prices, applicable when PriceTypeEnum is itself of type CashPrice.
  */
object CashPriceTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a discount factor expressed as a decimal, e.g. 0.95.
    */
  val DISCOUNT = Value
  
  /**
    * A generic term for describing a non-scheduled cashflow that can be associated either with the initial contract, with some later corrections to it (e.g. a correction to the day count fraction that has a cashflow impact) or with some lifecycle events. Fees that are specifically associated with termination and partial termination, increase, amendment, and exercise events are qualified accordingly.
    */
  val FEE = Value
  
  /**
    * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
    */
  val PREMIUM = Value
}

/**
  * Defines the different cash settlement methods for a product where cash settlement is applicable.
  */
object CashSettlementMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
    */
  val CASH_PRICE_ALTERNATE_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
    */
  val CASH_PRICE_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
    */
  val COLLATERALIZED_CASH_PRICE_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
    */
  val CROSS_CURRENCY_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
    */
  val MID_MARKET_CALCULATION_AGENT_DETERMINATION = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
    */
  val MID_MARKET_INDICATIVE_QUOTATIONS = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
    */
  val MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
    */
  val PAR_YIELD_CURVE_ADJUSTED_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
    */
  val PAR_YIELD_CURVE_UNADJUSTED_METHOD = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
    */
  val REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
    */
  val REPLACEMENT_VALUE_FIRM_QUOTATIONS = Value
  
  /**
    * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
    */
  val ZERO_COUPON_YIELD_ADJUSTED_METHOD = Value
}

/**
  * The enumerated values to specify what led to the contract or execution closure.
  */
object ClosedStateEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The execution or contract has been allocated.
    */
  val ALLOCATED = Value
  
  /**
    * The execution or contract has been cancelled.
    */
  val CANCELLED = Value
  
  /**
    * The (option) contract has been exercised.
    */
  val EXERCISED = Value
  
  /**
    * The (option) contract has expired without being exercised.
    */
  val EXPIRED = Value
  
  /**
    * The contract has reached its contractual termination date.
    */
  val MATURED = Value
  
  /**
    * The contract has been novated. This state applies to the stepped-out contract component of the novation event.
    */
  val NOVATED = Value
  
  /**
    * The contract has been subject of an early termination event.
    */
  val TERMINATED = Value
}

/**
  * How is collateral interest to be handled?
  */
object CollateralInterestHandlingEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    *  Adjust the collateral balance to include the interest amount 
    */
  val ADJUST = Value
  
  /**
    *  Transfer the interest each period 
    */
  val TRANSFER = Value
  
  /**
    *  Transfer the interest if it meets certain criteria, or otherwise adjust the collateral balance to reflect the interest amount  
    */
  val TRANSFER_OR_ADJUST = Value
}

/**
  * The enumerated values to specify the type of margin for which a legal agreement is named.
  */
object CollateralMarginTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a margin agreement that is identified for use with Initial Margin/IM.
    */
  val INITIAL_MARGIN = Value
  
  /**
    * Denotes a margin agreement that is identified for use with Variation Margin/VM.
    */
  val VARIATION_MARGIN = Value
}

/**
  * Represents the enumeration list to identify the settlement status of the collateral.
  */
object CollateralStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement.
    */
  val FULL_AMOUNT = Value
  
  /**
    * Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s.
    */
  val IN_TRANSIT_AMOUNT = Value
  
  /**
    * Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s.
    */
  val SETTLED_AMOUNT = Value
}

/**
  * Specifies the types of collateral that are accepted by the Lender
  */
object CollateralTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Security Lending Trades against Cash collateral
    */
  val CASH = Value
  
  /**
    * Security Lending Trades against CashPool collateral
    */
  val CASH_POOL = Value
  
  /**
    * Security Lending Trades against NonCash collateral
    */
  val NON_CASH = Value
}

object CommodityBusinessCalendarEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Abu Dhabi Securities Exchange https://www.adx.ae/
    */
  val ADSM = Value
  
  /**
    * Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer
    */
  val AGRUS_FMB = Value("AGRUS-FMB")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val APPI = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ARGUS_CRUDE = Value("ARGUS-CRUDE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ARGUS_EUROPEAN_GAS = Value("ARGUS-EUROPEAN-GAS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ARGUS_EUROPEAN_PRODUCTS = Value("ARGUS-EUROPEAN-PRODUCTS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ARGUS_INTERNATIONAL_LPG = Value("ARGUS-INTERNATIONAL-LPG")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ARGUS_MCCLOSKEYS_COAL_REPORT = Value("ARGUS-MCCLOSKEYS-COAL-REPORT")
  
  /**
    * The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products
    */
  val ARGUS_US_PRODUCTS = Value("ARGUS-US-PRODUCTS")
  
  /**
    * Australian Securities Exchange http://www.asx.com.au/
    */
  val ASX = Value
  
  /**
    * Australian Wheat Board. www.awb.com.au
    */
  val AWB = Value
  
  /**
    * Australian Wool Exchange. http://www.awex.com.au/home.html
    */
  val AWEX = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val BALTIC_EXCHANGE = Value("BALTIC-EXCHANGE")
  
  /**
    * The business calendar of the Bank Negara Malaysia Policy Committee.
    */
  val BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE = Value("BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE")
  
  /**
    * The business calendar for the Belpex power exchange (www.belpex.be).
    */
  val BELPEX = Value
  
  /**
    * BlueNext Power Market.
    */
  val BLUENEXT = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val BM_F = Value("BM&F")
  
  /**
    * The settlement business calendar for Bursa Malaysia.
    */
  val BURSA_MALAYSIA_SETTLEMENT = Value("BURSA-MALAYSIA-SETTLEMENT")
  
  /**
    * The trading business calendar for Bursa Malaysia.
    */
  val BURSA_MALAYSIA_TRADING = Value("BURSA-MALAYSIA-TRADING")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CANADIAN_GAS_PRICE_REPORTER = Value("CANADIAN-GAS-PRICE-REPORTER")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CBOT_SOFT = Value("CBOT-SOFT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CMAI_AROMATICS_MARKET_REPORT = Value("CMAI-AROMATICS-MARKET-REPORT")
  
  /**
    * CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
    */
  val CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT = Value("CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CMAI_METHANOL_MARKET_REPORT = Value("CMAI-METHANOL-MARKET-REPORT")
  
  /**
    * CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
    */
  val CMAI_MONOMERS_MARKET_REPORT = Value("CMAI-MONOMERS-MARKET-REPORT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CME_DAIRY = Value("CME-DAIRY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CME_NON_DAIRY_SOFT = Value("CME-NON-DAIRY-SOFT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val COMEX = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CRU = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val CRU_LONG = Value("CRU-LONG")
  
  /**
    * The business calendar for statistical publications by the by the United States Department of Energy (DOE).
    */
  val DEPARTMENT_OF_ENERGY = Value("DEPARTMENT-OF-ENERGY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val DEWITT_BENZENE_DERIVATIVES = Value("DEWITT-BENZENE-DERIVATIVES")
  
  /**
    * Dubai Mercantile Exchange. http://www.dubaimerc.com/
    */
  val DME = Value
  
  /**
    * Dow Jones US Calendar. http://www.dowjones.com/
    */
  val DOW_JONES = Value("DOW-JONES")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val DOW_JONES_ENERGY_SERVICE = Value("DOW-JONES-ENERGY-SERVICE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val DOW_JONES_POWER = Value
  
  /**
    * European Energy Exchange-Coal
    */
  val EEX_COAL = Value("EEX-COAL")
  
  /**
    * European Energy Exchange-Emissions Rights
    */
  val EEX_EMISSIONS = Value("EEX-EMISSIONS")
  
  /**
    * European Energy Exchange-Gas
    */
  val EEX_GAS = Value("EEX-GAS")
  
  /**
    * European Energy Exchange-Power
    */
  val EEX_POWER = Value("EEX-POWER")
  
  /**
    * TBD.
    */
  val EURONEX_MATIF = Value("EURONEX-MATIF")
  
  /**
    * FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp
    */
  val FERTECON = Value
  
  /**
    * Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek
    */
  val FERTILIZER_WEEK = Value("FERTILIZER-WEEK")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val GAS_DAILY = Value("GAS-DAILY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val GAS_DAILY_PRICE_GUIDE = Value("GAS-DAILY-PRICE-GUIDE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val GLOBALCOAL = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val HEREN_REPORT = Value("HEREN-REPORT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ICE_10X_DAILY = Value("ICE/10X-DAILY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ICE_10X_MONTHLY = Value("ICE/10X-MONTHLY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ICE_CANADA = Value("ICE-CANADA")
  
  /**
    * European Climate Exchange.
    */
  val ICE_ECX = Value("ICE-ECX")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ICE_GAS = Value("ICE-GAS")
  
  /**
    * The business calendar oil and refined product contracts on ICE Futures Europe.
    */
  val ICE_OIL = Value("ICE-OIL")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val ICE_US_AGRICULTURAL = Value("ICE-US-AGRICULTURAL")
  
  /**
    * The business calendar for publication of ICIS Benzene (Europe) data.
    */
  val ICIS_PRICING_BENZENE__EUROPE_ = Value("ICIS-PRICING-BENZENE-(EUROPE)")
  
  /**
    * The business calendar for publication of ICIS Ethylene (Europe) data.
    */
  val ICIS_PRICING_ETHYLENE__EUROPE_ = Value("ICIS-PRICING-ETHYLENE-(EUROPE)")
  
  /**
    * The business calendar for publication of ICIS Polyproylene (Europe) data.
    */
  val ICIS_PRICING_POLYPROPYLENE__EUROPE_ = Value("ICIS-PRICING-POLYPROPYLENE-(EUROPE)")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val INSIDE_FERC = Value("INSIDE-FERC")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val JAPAN_MOF_TSRR = Value("JAPAN-MOF-TSRR")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val KCBOT = Value
  
  /**
    * The banking business calendar in Kuala Lumpur.
    */
  val KUALA_LUMPUR_BANK = Value("KUALA-LUMPUR-BANK")
  
  /**
    * The business calendar for the Labuan Bank (Malaysia).
    */
  val LABUAN_BANK = Value("LABUAN-BANK")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val LIFFE_LONDON_SOFT = Value("LIFFE-LONDON-SOFT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val LME = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val LONDON_BULLION_MARKET = Value("LONDON-BULLION-MARKET")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val LONDON_BULLION_MARKET_GOLD_A_M_ONLY = Value("LONDON-BULLION-MARKET-GOLD-A.M-ONLY")
  
  /**
    * The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium.
    */
  val LONDON_PLATINUM_PALLADIUM_MARKET = Value("LONDON-PLATINUM-PALLADIUM-MARKET")
  
  /**
    * Minneapolis Grain Exchange http://www.mgex.com/
    */
  val MGEX = Value
  
  /**
    * The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex).
    */
  val N2EX = Value
  
  /**
    * NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities
    */
  val NASDAQ_OMX = Value("NASDAQ-OMX")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NATURAL_GAS_WEEK = Value("NATURAL-GAS-WEEK")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Article XIV.
    */
  val NERC = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NGI = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NGX = Value
  
  /**
    * The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php
    */
  val NUCLEAR_MARKET_REVIEW = Value("NUCLEAR-MARKET-REVIEW")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NYMEX_ELECTRICITY = Value("NYMEX-ELECTRICITY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NYMEX_GAS = Value("NYMEX-GAS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NYMEX_NATURAL_GAS = Value("NYMEX-NATURAL-GAS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val NYMEX_OIL = Value("NYMEX-OIL")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val OFFICIAL_BOARD_MARKETS = Value("OFFICIAL-BOARD-MARKETS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val OPIS_LP_GAS = Value("OPIS-LP-GAS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val OPIS_PROPANE = Value("OPIS-PROPANE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PAPER_PACKAGING_MONITOR = Value("PAPER-PACKAGING-MONITOR")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PAPER_TRADER = Value("PAPER-TRADER")
  
  /**
    * Pertamina-Indonesia. http://www.pertamina.com/
    */
  val PERTAMINA = Value
  
  /**
    * PetroChemWire Publication Calendar. http://www.petrochemwire.com/
    */
  val PETROCHEMWIRE = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PIX_PULP_BENCHMARK_INDICES = Value("PIX-PULP-BENCHMARK-INDICES")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_APAG_MARKETSCAN = Value("PLATTS-APAG-MARKETSCAN")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_BUNKERWIRE = Value("PLATTS-BUNKERWIRE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_CLEAN_TANKERWIRE = Value("PLATTS-CLEAN-TANKERWIRE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_CRUDE_OIL_MARKETWIRE = Value("PLATTS-CRUDE-OIL-MARKETWIRE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_DIRTY_TANKERWIRE = Value("PLATTS-DIRTY-TANKERWIRE")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_EUROPEAN_GAS = Value("PLATTS-EUROPEAN-GAS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_EUROPEAN_MARKETSCAN = Value("PLATTS-EUROPEAN-MARKETSCAN")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_METALS_ALERT = Value("PLATTS-METALS-ALERT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_OILGRAM = Value("PLATTS-OILGRAM")
  
  /**
    * The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore
    */
  val PLATTS_TSI_IRON_ORE = Value("PLATTS-TSI-IRON-ORE")
  
  /**
    * The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices
    */
  val PLATTS_TSI_SCRAP = Value("PLATTS-TSI-SCRAP")
  
  /**
    * The Steel Index. http://www.thesteelindex.com/en/price-specifications
    */
  val PLATTS_TSI_STEEL = Value("PLATTS-TSI-STEEL")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PLATTS_US_MARKETSCAN = Value("PLATTS-US-MARKETSCAN")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PULP_AND_PAPER_INTERNATIONAL = Value("PULP-AND-PAPER-INTERNATIONAL")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val PULP_AND_PAPER_WEEK = Value("PULP-AND-PAPER-WEEK")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val RIM_PRODUCTS_INTELLIGENCE_DAILY = Value("RIM-PRODUCTS-INTELLIGENCE-DAILY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val SAFEX_SOFT = Value("SAFEX-SOFT")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val SFE_SOFT = Value("SFE-SOFT")
  
  /**
    * Singapore Exchange. www.sgx.com
    */
  val SGX = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val SICOM = Value
  
  /**
    * Standard and Poor's GSCI. http://us.spindices.com/index-family/commodities/sp-gsci
    */
  val SP_GSCI = Value("SP-GSCI")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val STATISTICHES_BUNDESAMT = Value("STATISTICHES-BUNDESAMT")
  
  /**
    * Tokyo Grain Exchange. www.tge.or.jp
    */
  val TGE = Value
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val TOCOM_OIL = Value("TOCOM-OIL")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val TOCOM_PRECIOUS = Value("TOCOM-PRECIOUS")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val TOCOM_SOFT = Value("TOCOM-SOFT")
  
  /**
    * The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx
    */
  val UX_WEEKLY = Value("UX-WEEKLY")
  
  /**
    * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    */
  val WORLD_PULP_MONTHLY = Value("WORLD-PULP-MONTHLY")
}

/**
  * Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg.
  */
object CommodityInformationPublisherEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ARGUS = Value
  
  val ARGUS_AMERICAS_CRUDE_REPORT = Value
  
  val ARGUS_BIOFUEL_REPORT = Value
  
  val ARGUS_CRUDE_REPORT = Value
  
  val ARGUS_EUROPEAN_PRODUCTS_REPORT = Value
  
  val ARGUS_FMB = Value
  
  val ARGUS_INTERNATIONAL_LPG_REPORT = Value
  
  val ARGUS_LPG = Value
  
  val ARGUS_MC_CLOSKEYS = Value
  
  val ARGUS_NAT_GAS = Value
  
  val ASSOC_BANKS_SINGAPORE = Value
  
  val BLUENEXT = Value
  
  val BALTIC_EXCHANGE = Value
  
  val BAND_D = Value
  
  val BANK_OF_CANADA = Value
  
  val BANK_OF_ENGLAND = Value
  
  val BANK_OF_JAPAN = Value
  
  val BLOOMBERG = Value
  
  val CAISO = Value
  
  val CMAI_AROMATICS_MARKET_REPORT = Value
  
  val CMAI_WEEKLY_METHANOL_MARKET_REPORT = Value
  
  val CRU_STEEL_LONG_PRODUCT_MONITOR = Value
  
  val CRU_STEEL_SHEET_PRODUCTS_MONITOR = Value
  
  val CANADIAN_GAS_PRICE_REPORTER = Value
  
  val CANADIAN_GAS_REPORTER = Value
  
  val CHEMICAL_MARKETS_ASSOCIATION = Value
  
  val DOW_JONES_ENERGY_SERVICE = Value
  
  val DOW_JONES_ENERGY_SERVICE_SCREEN = Value
  
  val DOW_JONES_NAT_GAS = Value
  
  val EEX = Value
  
  val ERCOT = Value
  
  val EURONEXMATIF = Value
  
  val EURO_CENTRAL_BANK = Value
  
  val FERTECON = Value
  
  val FHLBSF = Value
  
  val FEDERAL_RESERVE = Value
  
  val FERTILIZER_WEEK = Value
  
  val GME = Value
  
  val GAS_DAILY = Value
  
  val GAS_DAILY_PRICE_GUIDE = Value
  
  val GLOBAL_COALE = Value
  
  val HEREN_REPORT = Value
  
  val ICE = Value
  
  val ICE_10_X_DAILY_NATURAL_GAS = Value
  
  val ICE_10_X_DAILY_POWER = Value
  
  val ICE_10_X_MONTHLY = Value
  
  val ICE_DAY_AHEAD_INDEX = Value
  
  val ICEECX = Value
  
  val ICIS = Value
  
  val IPE = Value
  
  val ISDA = Value
  
  val ISO_NEW_ENGLAND = Value
  
  val INSIDE_FERC = Value
  
  val JAPANMOFTSRR = Value
  
  val LEBA = Value
  
  val LONDONPLATINUMPALLADIUMMARKET = Value
  
  val LONDON_BULLION_MARKET_ASSOCIATION = Value
  
  val MISO = Value
  
  val MEGAWATT_DAILY = Value
  
  val METAL_BULLETIN = Value
  
  val NGI_BIDWEEK_SURVEY = Value
  
  val NYISO = Value
  
  val NATURAL_GAS_WEEK = Value
  
  val OBM = Value
  
  val OMEL = Value
  
  val OPIS = Value
  
  val PIX = Value
  
  val PJM = Value
  
  val PPM = Value
  
  val PPM_EUROPE = Value
  
  val PPW = Value
  
  val PAPER_TRADER = Value
  
  val PLATTS_ASIA_PACIFIC = Value
  
  val PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN = Value
  
  val PLATTS_CLEAN_TANKERWIRE = Value
  
  val PLATTS_COAL_TRADER = Value
  
  val PLATTS_CRUDE_OIL_MARKETWIRE = Value
  
  val PLATTS_DIRTY_TAKERWIRE = Value
  
  val PLATTS_ENGR = Value
  
  val PLATTS_EUROPEAN = Value
  
  val PLATTS_EUROPEAN_MARKETSCAN = Value
  
  val PLATTS_GAS_DAILY = Value
  
  val PLATTS_GAS_DAILY_PRICE_GUIDE = Value
  
  val PLATTS_INSIDE_FERC = Value
  
  val PLATTS_LPG = Value
  
  val PLATTS_MARKETWIRE = Value
  
  val PLATTS_MEGAWATT_DAILY = Value
  
  val PLATTS_METALS_ALERT = Value
  
  val PLATTS_OILGRAM = Value
  
  val PLATTS_OILGRAM_BUNKERWIRE = Value
  
  val PLATTS_POLYMERSCAN = Value
  
  val PLATTS_TSI_IRON_ORE = Value
  
  val PLATTS_US = Value
  
  val PLATTS_US_MARKETSCAN = Value
  
  val RIM_INTELLIGENCE_PRODUCTS = Value
  
  val RESERVE_BANK_AUSTRALIA = Value
  
  val RESERVE_BANK_NEW_ZEALAND = Value
  
  val REUTERS = Value
  
  val REUTERS_SCREEN = Value
  
  val SEA_PAC = Value
  
  val TSI_SCRAP = Value
  
  val TSI_STEEL = Value
  
  val TELERATE = Value
  
  val TELERATE_SCREEN = Value
  
  val UXWEEKLY = Value
  
  val WORLD_CRUDE_REPORT = Value
  
  val WORLD_PULP_MONTHLY = Value
}

/**
  * Defines the enumerated values to specify the nature of a location identifier.
  */
object CommodityLocationIdentifierTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The hub code of the buyer.
    */
  val BUYER_HUB = Value
  
  /**
    * The physical or virtual point at which the commodity will be delivered.
    */
  val DELIVERY_POINT = Value
  
  /**
    * The zone covering potential delivery points for the commodity
    */
  val DELIVERY_ZONE = Value
  
  /**
    * The physical or virtual point at which the commodity enters a transportation system.
    */
  val ENTRY_POINT = Value
  
  /**
    * Identification of the border(s) or border point(s) of a transportation contract.
    */
  val INTERCONNECTION_POINT = Value
  
  /**
    * The hub code of the seller.
    */
  val SELLER_HUB = Value
  
  /**
    * The physical or virtual point at which the commodity is withdrawn from a transportation system.
    */
  val WITHDRAWAL_POINT = Value
}

/**
  * The enumeration values to specify the Commodity Reference Prices specified in the Annex to the 2005 ISDA Commodity Definitions.
  */
object CommodityReferencePriceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Per 2005 ISDA Commodity Definitions, Sub-Annex A, Section 7.1 Commodity Reference Prices, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ALUMINIUM_ALLOY_LME_15_MONTH = Value("ALUMINIUM ALLOY-LME 15 MONTH")
  
  /**
    * A code for the NYMEX Central Appalachian Coal commodity
    */
  val COAL_CENTRAL_APPALACHIAN_NYMEX = Value("COAL-CENTRAL APPALACHIAN-NYMEX")
  
  /**
    * A code for the ICE Futures U.S. (‘ICUS’) Cocoa commodity
    */
  val COCOA_ICE = Value("COCOA-ICE")
  
  /**
    * A code for the ICUS Coffee C commodity
    */
  val COFFEE_ARABICA_ICE = Value("COFFEE ARABICA-ICE")
  
  /**
    * A code for the ICUS Coffee C commodity
    */
  val COFFEE_ROBUSTA_ICE = Value("COFFEE ROBUSTA-ICE")
  
  /**
    * A code for the COMEX (‘CMX’) Copper Grade #1 commodity
    */
  val COPPER_COMEX = Value("COPPER-COMEX")
  
  /**
    * A code for the Chicago Board of Trade (‘CBOT’) Corn commodity
    */
  val CORN_CBOT = Value("CORN-CBOT")
  
  /**
    * A code for the ICUS Cotton No. 2 commodity
    */
  val COTTON_NO__2_ICE = Value("COTTON NO. 2-ICE")
  
  /**
    * A code for the CBOT Ethanol commodity
    */
  val ETHANOL_CBOT = Value("ETHANOL-CBOT")
  
  /**
    * A code for the CME Feeder Cattle commodity
    */
  val FEEDER_CATTLE_CME = Value("FEEDER CATTLE-CME")
  
  /**
    * A code for the ICUS Frozen Concentrated Orange Juice commodity
    */
  val FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE = Value("FROZEN CONCENTRATED ORANGE JUICE NO. 1-ICE")
  
  /**
    * A code for the NYMEX Gasoline Blendstock (RBOB) commodity
    */
  val GASOLINE_RBOB_NEW_YORK_ICE = Value("GASOLINE-RBOB-NEW YORK-ICE")
  
  /**
    * A code for the NYMEX Gasoline Blendstock (RBOB) commodity
    */
  val GASOLINE_RBOB_NEW_YORK_NYMEX = Value("GASOLINE-RBOB-NEW YORK-NYMEX")
  
  /**
    * A code for the CMX Gold commodity
    */
  val GOLD_COMEX = Value("GOLD-COMEX")
  
  /**
    * A code for the NYMEX No. 2 Heating Oil, New York Harbor commodity
    */
  val HEATING_OIL_NEW_YORK_NYMEX = Value("HEATING OIL-NEW YORK-NYMEX")
  
  /**
    * A code for the CME Lean Hogs commodity
    */
  val LEAN_HOGS_CME = Value("LEAN HOGS-CME")
  
  /**
    * A code for the CME Live Cattle commodity
    */
  val LIVE_CATTLE_CME = Value("LIVE CATTLE-CME")
  
  /**
    * A code for the CME Random Length Lumber commodity
    */
  val LUMBER_CME = Value("LUMBER-CME")
  
  /**
    * A code for the CME Milk Class III commodity
    */
  val MILK_CLASS_III_CME = Value("MILK-CLASS III-CME")
  
  /**
    * A code for the CME Non Fat Dry Milk commodity
    */
  val MILK_NONFAT_DRY_CME = Value("MILK-NONFAT-DRY-CME")
  
  /**
    * A code for the NYMEX Natural Gas commodity
    */
  val NATURAL_GAS_NYMEX = Value("NATURAL GAS-NYMEX")
  
  /**
    * A code for the NYMEX Panhandle Basis Swap commodity
    */
  val NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC = Value("NATURAL GAS-PEPL (TEXOK MAINLINE)-INSIDE FERC")
  
  /**
    * A code for the NYMEX Waha Basis Swap commodity
    */
  val NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC = Value("NATURAL GAS-W. TEXAS (WAHA)-INSIDE FERC")
  
  /**
    * A code for the CBOT Oats commodity
    */
  val OATS_CBOT = Value("OATS-CBOT")
  
  /**
    * A code for the NYMEX Crude Oil, Light Sweet commodity
    */
  val OIL_WTI_NYMEX = Value("OIL-WTI-NYMEX")
  
  /**
    * A code for the NYMEX Palladium commodity
    */
  val PALLADIUM_NYMEX = Value("PALLADIUM-NYMEX")
  
  /**
    * A code for the NYMEX Platinum commodity
    */
  val PLATINUM_NYMEX = Value("PLATINUM-NYMEX")
  
  /**
    * A code for the CBOT Rough Rice commodity
    */
  val RICE_CBOT = Value("RICE-CBOT")
  
  /**
    * A code for the CMX Silver commodity
    */
  val SILVER_COMEX = Value("SILVER-COMEX")
  
  /**
    * A code for the CBOT Soybeans commodity
    */
  val SOYBEANS_CBOT = Value("SOYBEANS-CBOT")
  
  /**
    * A code for the CBOT Soybean Meal commodity
    */
  val SOYBEAN_MEAL_CBOT = Value("SOYBEAN MEAL-CBOT")
  
  /**
    * A code for the CBOT Soybean Oil commodity
    */
  val SOYBEAN_OIL_CBOT = Value("SOYBEAN OIL-CBOT")
  
  /**
    * A code for the ICUS Sugar No. 11 commodity
    */
  val SUGAR___11__WORLD__ICE = Value("SUGAR # 11 (WORLD)-ICE")
  
  /**
    * A code for the ICUS Sugar No. 16 commodity
    */
  val SUGAR___16__US__ICE = Value("SUGAR # 16 (US)-ICE")
  
  /**
    * A code for the CBOT Wheat commodity
    */
  val WHEAT_CBOT = Value("WHEAT-CBOT")
  
  /**
    * A code for the Kansas City Board of Trade (‘KCBT’)Wheat commodity
    */
  val WHEAT_HRW_KCBOT = Value("WHEAT HRW-KCBOT")
  
  /**
    * A code for the Wheat commodity
    */
  val WHEAT_RED_SPRING_MGE = Value("WHEAT RED SPRING-MGE")
}

object CompareOp extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val EQUALS = Value
  
  val GREATER_THAN = Value
  
  val GREATER_THAN_OR_EQUALS = Value
  
  val LESS_THAN = Value
  
  val LESS_THAN_OR_EQUALS = Value
}

/**
  * The enumerated values to specify the type of compounding, e.g. flat, straight.
  */
object CompoundingMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Flat compounding. Compounding excludes the spread. Note that the first compounding period has it's interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
    */
  val FLAT = Value
  
  /**
    * No compounding is to be applied.
    */
  val NONE = Value
  
  /**
    * Spread Exclusive compounding.
    */
  val SPREAD_EXCLUSIVE = Value
  
  /**
    * Straight compounding. Compounding includes the spread.
    */
  val STRAIGHT = Value
}

/**
  * The enumerated values to specify how the compounding calculation is done
  */
object CompoundingTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Compounding is done only on business days, i.e. not compounded each day on weekends or holidays.
    */
  val BUSINESS = Value
  
  /**
    * Compounding is done on each calendar day.
    */
  val CALENDAR = Value
  
  /**
    * Compounding is not applicable
    */
  val NONE = Value
}

/**
  * Represents the enumerated values to identify where a concentration limit is applied.
  */
object ConcentrationLimitTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies a limit on a single asset in the portfolio
    */
  val ASSET = Value
  
  /**
    * Specifies a limit on all cash valued in the base currency of the portfolio.
    */
  val BASE_CURRENCY_EQUIVALENT = Value
  
  /**
    * Specifies a limit on a single industry sector in the portfolio.
    */
  val INDUSTRY_SECTOR = Value
  
  /**
    * Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
    */
  val ISSUE_OUTSTANDING_AMOUNT = Value
  
  /**
    * Specifies a limit on a single issuer in the portfolio.
    */
  val ISSUER = Value
  
  /**
    * Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
    */
  val MARKET_CAPITALISATION = Value
  
  /**
    * Specifies a limit on a single exchange in the portfolio.
    */
  val PRIMARY_EXCHANGE = Value
  
  /**
    * Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level.
    */
  val ULTIMATE_PARENT_INSTITUTION = Value
}

/**
  * Enumeration for the different types of confirmation status.
  */
object ConfirmationStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val CONFIRMED = Value
  
  val UNCONFIRMED = Value
}

/**
  * The enumerated values to specify a set of standard contract definitions relevant to the transaction.
  */
object ContractualDefinitionsEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * ISDA 1991 Interest Rate Definitions
    */
  val ISDA_1991_INTEREST_RATE = Value
  
  /**
    * ISDA 1993 Commodity Derivatives Definitions
    */
  val ISDA_1993_COMMODITY_DERIVATIVES = Value
  
  /**
    * ISDA 1996 Equity Derivatives Definitions
    */
  val ISDA_1996_EQUITY_DERIVATIVES = Value
  
  /**
    * ISDA 1997 Bullion Definitions
    */
  val ISDA_1997_BULLION = Value
  
  /**
    * ISDA 1997 Government Bond Option Definitions
    */
  val ISDA_1997_GOVERNMENT_BOND_OPTION = Value
  
  /**
    * ISDA 1998 FX and Currency Option Definitions
    */
  val ISDA_1998_FX_AND_CURRENCY_OPTION = Value
  
  /**
    * ISDA 1999 Credit Derivatives Definitions
    */
  val ISDA_1999_CREDIT_DERIVATIVES = Value
  
  /**
    * ISDA 2000 Definitions
    */
  val ISDA2000 = Value
  
  /**
    * ISDA 2002 Equity Derivatives Definitions
    */
  val ISDA_2002_EQUITY_DERIVATIVES = Value
  
  /**
    * ISDA 2003 Credit Derivatives Definitions
    */
  val ISDA_2003_CREDIT_DERIVATIVES = Value
  
  /**
    * ISDA 2004 Novation Definitions
    */
  val ISDA_2004_NOVATION = Value
  
  /**
    * ISDA 2005 Commodity Definitions
    */
  val ISDA_2005_COMMODITY = Value
  
  /**
    * ISDA 2006 Definitions
    */
  val ISDA2006 = Value
  
  /**
    * ISDA 2006 Inflation Derivatives Definitions
    */
  val ISDA_2006_INFLATION_DERIVATIVES = Value
  
  /**
    * ISDA 2008 Inflation Derivatives Definitions
    */
  val ISDA_2008_INFLATION_DERIVATIVES = Value
  
  /**
    * ISDA 2011 Equity Derivatives Definitions
    */
  val ISDA_2011_EQUITY_DERIVATIVES = Value
  
  /**
    * ISDA 2014 Credit Derivatives Definitions
    */
  val ISDA_2014_CREDIT_DERIVATIVES = Value
  
  /**
    * ISDA 2021 Interest Rate Derivatives Definitions
    */
  val ISDA_2021_INTEREST_RATE_DERIVATIVES = Value
  
  /**
    * ISDA 2022 Verified Carbon Credit Transactions Definitions
    */
  val ISDA_2022_VERIFIED_CARBON_CREDIT = Value
  
  /**
    * ISDA 2023 Digital Asset Derivatives Definitions
    */
  val ISDA_2023_DIGITAL_ASSET_DERIVATIVES = Value
}

/**
  * The enumerated values to define the supplements to a base set of ISDA Definitions that are applicable to the transaction.
  */
object ContractualSupplementTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Standard Terms Supplement for ABX Transactions.
    */
  val ABX = Value
  
  /**
    * Standard Terms Supplement for Asset-Backed Tranche Transactions.
    */
  val ABX_TRANCHE = Value
  
  /**
    * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Leveraged Loans.
    */
  val CD_SON_LEVERAGED_LOANS = Value
  
  /**
    * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
    */
  val CD_SON_MBS = Value
  
  /**
    * Standard Terms Supplement for CDX Untranched Transactions.
    */
  val CDX = Value
  
  /**
    * Standard Terms Supplement for CDX Emerging Markets Untranched Transactions.
    */
  val CDX_EMERGING_MARKETS = Value
  
  /**
    * Standard Terms Supplement for CDX Emerging Markets Diversified Untranched Transactions..
    */
  val CDX_EMERGING_MARKETS_DIVERSIFIED = Value
  
  /**
    * Standard Terms Supplement for CDX Swaption Transactions.
    */
  val CDX_SWAPTION = Value
  
  /**
    * Standard Terms Supplement for Dow Jones CDX Tranche Transactions.
    */
  val CDX_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for CMBX Transactions.
    */
  val CMBX = Value
  
  /**
    * Standard Terms Supplement for Single Name European CMBS Transactions.
    */
  val EUROPEAN_CMBS = Value
  
  /**
    * Standard Terms Supplement for Single Name European RMBS Transactions.
    */
  val EUROPEAN_RMBS = Value
  
  /**
    * Standard Terms Supplement for IOS Transactions.
    */
  val IOS = Value
  
  /**
    * Supplement to the 1999 ISDA Credit Derivatives Definitions Relating to Convertible, Exchangeable or Accreting Obligations dated November 9, 2001.
    */
  val ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS = Value
  
  /**
    * Restructuring Supplement to the 1999 ISDA Credit Derivatives Definitions dated May 11, 2001.
    */
  val ISDA_1999_CREDIT_RESTRUCTURING = Value
  
  /**
    * Supplement Relating to Successor and Credit Events to the 1999 ISDA Credit Derivatives Definitions dated November 28, 2001.
    */
  val ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS = Value
  
  /**
    * Additional Provisions for LPN dated December 6, 2007.
    */
  val ISDA_2003_ADDITIONAL_PROVISIONS_LPN = Value
  
  /**
    * Additional Provisions for Contingent Credit Spread Transactions dated August 15, 2008.
    */
  val ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION = Value
  
  /**
    * 2005 Matrix Supplement to the 2003 ISDA Credit Derivatives.
    */
  val ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT = Value
  
  /**
    * Additional Provisions for the Argentine Republic: Excluded Obligations and Excluded Deliverable Obligations dated December 21, 2005.
    */
  val ISDA_2003_CREDIT_ARGENTINE_REPUBLIC = Value
  
  /**
    * ISDA Credit Derivatives Determinations Committees and Auction Settlement Supplement to the 2003 ISDA Credit Derivatives Definitions (published on [TBD]).
    */
  val ISDA_2003_CREDIT_AUCTION_SUPPLEMENT = Value
  
  /**
    * May 2003 Supplement to the 2003 ISDA Credit Derivatives Definitions.
    */
  val ISDA_2003_CREDIT_MAY_2003 = Value
  
  /**
    * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated May 9, 2003.
    */
  val ISDA_2003_CREDIT_MONOLINE_INSURERS = Value
  
  /**
    * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated January 21, 2005.
    */
  val ISDA_2003_CREDIT_MONOLINE_INSURERS_2005 = Value
  
  /**
    * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
    */
  val ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY = Value
  
  /**
    * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated February 14, 2005. 
    */
  val ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005 = Value
  
  /**
    * Additional Provisions for the Russian Federation: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
    */
  val ISDA_2003_CREDIT_RUSSIAN_FEDERATION = Value
  
  /**
    * Additional Provisions for Credit Derivative Transactions - U.S. Municipal Entity as Reference Entity dated September 17, 2004.
    */
  val ISDA_2003_CREDIT_US_MUNICIPALS = Value
  
  /**
    * Additional Provisions for STMicroelectronics NV dated December 6, 2007.
    */
  val ISDA_2003_ST_MICROELECTRONICS_NV = Value
  
  /**
    * 2007 Full Lookthrough Depository Receipt Supplement to the 2002 Equity Derivatives Definitions.
    */
  val ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT = Value
  
  /**
    * 2007 Partial Lookthrough Depository Receipt Supplement to the 2002 ISDA Equity Derivatives Definitions.
    */
  val ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT = Value
  
  /**
    * Additional Provisions for Physically Settled Default Swaps Monoline Insurer.
    */
  val ISDA_CREDIT_MONOLINE_INSURERS = Value
  
  /**
    * Additional Provisions for Fixed Recovery Credit Default Swap Transactions
    */
  val ISDA_DELIVERY_RESTRICTIONS = Value
  
  /**
    * Additional Provisions for Fixed Recovery Credit Default Swap Transactions.
    */
  val ISDA_FIXED_RECOVERY = Value
  
  /**
    * Additional Provisions for LPN Reference Entities.
    */
  val ISDALPN_REFERENCE_ENTITIES = Value
  
  /**
    * Canadian Supplement to the 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement dated March 29, 2004.
    */
  val ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT = Value
  
  /**
    * Additional Provisions for Recovery Lock Credit Default Swap Transactions.
    */
  val ISDA_RECOVERY_LOCK = Value
  
  /**
    * Additional Provisions for Secured Deliverable Obligation Characteristic.
    */
  val ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC = Value
  
  /**
    * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Transactions.
    */
  val LCDX = Value
  
  /**
    * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Tranche Transactions.
    */
  val LCDX_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for MBX Transactions.
    */
  val MBX = Value
  
  /**
    * Standard Terms Supplement for Municipal CDX Untranched Transactions.
    */
  val MCDX = Value
  
  /**
    * Standard Terms Supplement for PO Index Transactions.
    */
  val PO = Value
  
  /**
    * Standard Terms Supplement for PrimeX Transactions.
    */
  val PRIME_X = Value
  
  /**
    * Standard Terms Supplement for Standard CDX Tranche Transactions.
    */
  val STANDARD_CDX_TRANCHE = Value
  
  /**
    * Standard Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
    */
  val STANDARD_LCDS = Value
  
  /**
    * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
    */
  val STANDARD_LCDS_BULLET = Value
  
  /**
    * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
    */
  val STANDARD_LCDX_BULLET = Value
  
  /**
    * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
    */
  val STANDARD_LCDX_BULLET_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for Standard iTraxx Europe Tranched Transactions.
    */
  val STANDARDI_TRAXX_EUROPE_TRANCHE = Value
  
  /**
    * Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
    */
  val SYNDICATED_SECURED_LOAN_CDS = Value
  
  /**
    * Standard Terms Supplement for TRX Transactions.
    */
  val TRX = Value
  
  /**
    * Standard Terms Supplement for TRX.II Transactions.
    */
  val TRX_II = Value("TRX.II")
  
  /**
    * Standard Terms Supplement for iTraxx Asia Excluding Japan.
    */
  val I_TRAXX_ASIA_EX_JAPAN = Value
  
  /**
    * Standard Terms Supplement for iTraxx Asia Ex-Japan Swaption Transactions.
    */
  val I_TRAXX_ASIA_EX_JAPAN_SWAPTION = Value
  
  /**
    * Standard Terms Supplement for iTraxx Asia Excluding Japan Tranched Transactions.
    */
  val I_TRAXX_ASIA_EX_JAPAN_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for iTraxx Australia.
    */
  val I_TRAXX_AUSTRALIA = Value
  
  /**
    * Standard Terms Supplement for iTraxx Australia Swaption Transactions.
    */
  val I_TRAXX_AUSTRALIA_SWAPTION = Value
  
  /**
    * Standard Terms Supplement for iTraxx Australia Tranched Transactions.
    */
  val I_TRAXX_AUSTRALIA_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for iTraxx CJ.
    */
  val I_TRAXX_CJ = Value
  
  /**
    * Standard Terms Supplement for iTraxx CJ Tranched Transactions.
    */
  val I_TRAXX_CJ_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for iTraxx Europe Transactions.
    */
  val I_TRAXX_EUROPE = Value
  
  /**
    * Standard Terms Supplement for iTraxx Europe Dealer Form.
    */
  val I_TRAXX_EUROPE_DEALER = Value
  
  /**
    * Standard Terms Supplement for iTraxx Europe Non-Dealer Form.
    */
  val I_TRAXX_EUROPE_NON_DEALER = Value
  
  /**
    * Standard Terms Supplement for iTraxx Europe Swaption Transactions.
    */
  val I_TRAXX_EUROPE_SWAPTION = Value
  
  /**
    * Standard Terms Supplement for iTraxx Europe Tranched Transactions.
    */
  val I_TRAXX_EUROPE_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for iTraxx Japan.
    */
  val I_TRAXX_JAPAN = Value
  
  /**
    * Standard Terms Supplement for iTraxx Japan Swaption Transactions.
    */
  val I_TRAXX_JAPAN_SWAPTION = Value
  
  /**
    * Standard Terms Supplement for iTraxx Japan Tranched Transactions.
    */
  val I_TRAXX_JAPAN_TRANCHE = Value
  
  /**
    * Standard Terms Supplement for iTraxx LevX.
    */
  val I_TRAXX_LEV_X = Value
  
  /**
    * Standard Terms Supplement for iTraxx SDI 75 Dealer Transactions.
    */
  val I_TRAXX_SDI_75_DEALER = Value
  
  /**
    * Standard Terms Supplement for iTraxx SDI 75 Non-Dealer Transactions.
    */
  val I_TRAXX_SDI_75_NON_DEALER = Value
  
  /**
    * Standard Terms Supplement for iTraxx SovX.
    */
  val I_TRAXX_SOV_X = Value
}

/**
  * The enumerated values to specify the origin of a corporate action transfer.
  */
object CorporateActionTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Corporate action triggered by a bonus issue. A bonus issue or bonus share is a free share of stock given to current shareholders in a company, based upon the number of shares that the shareholder already owns. While the issue of bonus shares increases the total number of shares issued and owned, it does not change the value of the company. The value maps closely to the ISO code (BONU) defined as a bonus, scrip or capitalisation issue. Security holders receive additional assets free of payment from the issuer, in proportion to their holding.
    */
  val BONUS_ISSUE = Value
  
  /**
    * Corporate action triggered by the distribution of a cash dividend.
    */
  val CASH_DIVIDEND = Value
  
  /**
    * Corporate action triggered by a Class Action. An action where an individual represents a group in a court claim. The judgment from the suit is for all the members of the group (class). The value maps closely to the ISO code (CLSA) defined as the situation where interested parties seek restitution for financial loss. The security holder may be offered the opportunity to join a class action proceeding and would need to respond with an instruction.
    */
  val CLASS_ACTION = Value
  
  /**
    * Corporate action triggered by the removal of a security from a stock exchange.
    */
  val DELISTING = Value
  
  /**
    * Corporate action triggered by an early redemption. The value maps closely to the ISO code (MCAL) defined as the redemption of an entire issue outstanding of securities, for example, bonds, preferred equity, funds, by the issuer or its agent, for example, asset manager, before final maturity.
    */
  val EARLY_REDEMPTION = Value
  
  /**
    * Corporate action triggered by a liquidation. When a business or firm is terminated or bankrupt, its assets are sold (liquidated) and the proceeds pay creditors. Any leftovers are distributed to shareholders. The value maps closely to the ISO code (LIQU) defined as a distribution of cash, assets or both. Debt may be paid in order of priority based on preferred claims to assets specified by the security.
    */
  val LIQUIDATION = Value
  
  /**
    * Corporate action triggered by a merger. Mergers and acquisitions (abbreviated M&A) is an aspect of corporate strategy, corporate finance and management dealing with the buying, selling, dividing and combining of different companies and similar entities that can help an enterprise grow rapidly in its sector or location of origin, or a new field or new location, without creating a subsidiary, other child entity or using a joint venture. The distinction between a merger and an acquisition has become increasingly blurred in various respects (particularly in terms of the ultimate economic outcome), although it has not completely disappeared in all situations. The value maps closely to the ISO code (MRGR) defined as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
    */
  val MERGER = Value
  
  /**
    * Corporate action triggered by a reverse split. A reverse stock split or reverse split is a process by a company of issuing to each shareholder in that company a smaller number of new shares in proportion to that shareholder's original shares that are subsequently canceled. A reverse stock split is also called a stock merge. The reduction in the number of issued shares is accompanied by a proportional increase in the share price. The value maps closely to the ISO code (SPLR) defined as a decrease in a company's number of outstanding equities without any change in the shareholder's equity or the aggregate market value at the time of the split. Equity price and nominal value are increased accordingly.
    */
  val REVERSE_STOCK_SPLIT = Value
  
  /**
    * Corporate action triggered by an issuance to shareholders of rights to purchase additional shares at a discount.
    */
  val RIGHTS_ISSUE = Value
  
  /**
    * Corporate action triggered by a spin Off. A spin-out, also known as a spin-off or a starburst, refers to a type of corporate action where a company splits off sections of itself as a separate business. The value maps closely to the ISO code (SOFF) defined as a a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares. Spin-off represents a form of divestiture usually resulting in an independent company or in an existing company. For example, demerger, distribution, unbundling.
    */
  val SPIN_OFF = Value
  
  /**
    * Corporate action triggered by the distribution of a stock dividend.
    */
  val STOCK_DIVIDEND = Value
  
  /**
    * Corporate action triggered by a change in the code used to trade the security.
    */
  val STOCK_IDENTIFIER_CHANGE = Value
  
  /**
    * Corporate action triggered by a change in the name used to trade the security.
    */
  val STOCK_NAME_CHANGE = Value
  
  /**
    * Corporate action triggered by a Stock Reclassification.
    */
  val STOCK_RECLASSIFICATION = Value
  
  /**
    * Corporate action triggered by a stock split. A stock split or stock divide increases the number of shares in a public company. The price is adjusted such that the before and after market capitalization of the company remains the same and dilutiondoes not occur. The value maps closely to the ISO code (SPLF) defined as a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares.
    */
  val STOCK_SPLIT = Value
  
  /**
    * Corporate action triggered by a takeover. A takeover is the purchase of onecompany (the target) by another (the acquirer, or bidder). The value maps to the ISO code (TEND) but is finer grained than TEND which emcompasses Tender/Acquisition/Takeover/Purchase Offer/Buyback. ISO defines the TEND code as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
    */
  val TAKEOVER = Value
}

/**
  * Defines the enumerated values to specify the two counterparties to the transaction.
  */
object CounterpartyRoleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val PARTY_1 = Value
  
  val PARTY_2 = Value
}

/**
  * Represents the enumerated values to specify a credit event type.
  */
object CreditEventTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as 'technically' a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
    */
  val BANKRUPTCY = Value
  
  /**
    * Results from the fact that the rating of the reference obligation is downgraded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
    */
  val DISTRESSED_RATINGS_DOWNGRADE = Value
  
  /**
    * This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregrate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
    */
  val FAILURE_TO_PAY = Value
  
  /**
    * Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
    */
  val FAILURE_TO_PAY_INTEREST = Value
  
  /**
    * Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
    */
  val FAILURE_TO_PAY_PRINCIPAL = Value
  
  /**
    * A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
    */
  val GOVERNMENTAL_INTERVENTION = Value
  
  /**
    * Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
    */
  val IMPLIED_WRITEDOWN = Value
  
  /**
    * Results from the fact that the underlier fails to make principal payments as expected.
    */
  val MATURITY_EXTENSION = Value
  
  /**
    * One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
    */
  val OBLIGATION_ACCELERATION = Value
  
  /**
    * One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
    */
  val OBLIGATION_DEFAULT = Value
  
  /**
    * The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
    */
  val REPUDIATION_MORATORIUM = Value
  
  /**
    * A restructuring is an event that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
    */
  val RESTRUCTURING = Value
  
  /**
    * Results from the fact that the underlier writes down its outstanding principal amount.
    */
  val WRITEDOWN = Value
}

/**
  * The enumeration values to qualify the type of credit limits.
  */
object CreditLimitTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The type of credit line expressed in CS01. The sensitivity with respect to changes in the CDS spread.
    */
  val CS01 = Value
  
  /**
    * The type of credit line expressed in DV01. The dollar value of a one basis point decrease in interest rates. It shows the change in a bond's price compared to a decrease in the bond's yield.
    */
  val DV01 = Value
  
  /**
    * The type of credit line expressed in Initial Margin value.
    */
  val IM = Value
  
  /**
    * The type of credit line expressed as a Net Present Value.
    */
  val NPV = Value
  
  /**
    * The type of credit line expressed in Notional amount.
    */
  val NOTIONAL = Value
  
  /**
    * The type of credit line expressed in PV01. The value of a one dollar or one basis point annuity.
    */
  val PV01 = Value
}

/**
  * Identifies an agency rating as a simple scale boundary of minimum or maximum.
  */
object CreditNotationBoundaryEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a maxiumum boundary
    */
  val MAXIMUM = Value
  
  /**
    * Denotes a minumum boundary
    */
  val MINIMUM = Value
}

/**
  * Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
  */
object CreditNotationMismatchResolutionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes the average credit notation if several notations are listed.
    */
  val AVERAGE = Value
  
  /**
    * Denotes the highest credit notation if several notations are listed.
    */
  val HIGHEST = Value
  
  /**
    * Denotes the lowest credit notation if several notations are listed.
    */
  val LOWEST = Value
  
  /**
    * Utilised where bespoke language represents the label characteristics of the rating.
    */
  val OTHER = Value
  
  /**
    * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
    */
  val REFERENCE_AGENCY = Value
  
  /**
    * Denotes the second best credit notation if several notations are listed.
    */
  val SECOND_BEST = Value
}

/**
  * Represents the enumerated values to specify the rating agencies.
  */
object CreditRatingAgencyEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A. M. Best
    */
  val AM_BEST = Value
  
  /**
    * Canadian Bond Rating Service
    */
  val CBRS = Value
  
  /**
    * Dominion Bond Rating Service
    */
  val DBRS = Value
  
  /**
    * Fitch
    */
  val FITCH = Value
  
  /**
    * Japan Credit Rating Agency, Ltd.
    */
  val JAPANAGENCY = Value
  
  /**
    * Moody's
    */
  val MOODYS = Value
  
  /**
    * Rating And Investment Information, Inc.
    */
  val RATING_AND_INVESTMENT_INFORMATION = Value
  
  /**
    * Standard And Poor's
    */
  val STANDARD_AND_POORS = Value
}

/**
  * Represents the enumerated values to specify the credit watch rating.
  */
object CreditRatingCreditWatchEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a rating may be raised, lowered, or affirmed.
    */
  val DEVELOPING = Value
  
  /**
    * Denotes a rating may be lowered.
    */
  val NEGATIVE = Value
  
  /**
    * Denotes a rating may be raised.
    */
  val POSITIVE = Value
}

/**
  * Represents the enumerated values to specify the credit rating outlook.
  */
object CreditRatingOutlookEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a rating may be raised, lowered, or affirmed.
    */
  val DEVELOPING = Value
  
  /**
    * Denotes a rating may be lowered.
    */
  val NEGATIVE = Value
  
  /**
    * Denotes a rating may be raised.
    */
  val POSITIVE = Value
  
  /**
    * Denotes a rating is not likely to change.
    */
  val STABLE = Value
}

/**
  * Represents an enumeration list to identify tranched or untranched credit risk.
  */
object CreditRiskEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates tranched credit risk, including securitizations.
    */
  val TRANCHED_CREDIT_RISK = Value
  
  /**
    * Indicates tranched credit risk, including repackagings.
    */
  val UNTRANCHED_CREDIT_RISK = Value
}

/**
  * Seniority of debt instruments comprising the index.
  */
object CreditSeniorityEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Other as defined under EMIR.
    */
  val OTHER = Value
  
  /**
    * Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC).
    */
  val SENIOR_LOSS_ABSORBING_CAPACITY = Value
  
  /**
    * Senior domestic (RED Tier Code: SECDOM).
    */
  val SENIOR_SEC = Value
  
  /**
    * Senior foreign (RED Tier Code: SNRFOR).
    */
  val SENIOR_UN_SEC = Value
  
  /**
    * Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2).
    */
  val SUB_LOWER_TIER_2 = Value
  
  /**
    * Subordinate Tier 1 (RED Tier Code: PREFT1).
    */
  val SUB_TIER_1 = Value
  
  /**
    * Subordinate, Tier 3.
    */
  val SUB_TIER_3 = Value
  
  /**
    * Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2).
    */
  val SUB_UPPER_TIER_2 = Value
}

/**
  * The enumerated values to specify the type of Credit Support Agreement governing the transaction.
  */
object CreditSupportAgreementTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A Collateral Transfer Agreement
    */
  val COLLATERAL_TRANSFER_AGREEMENT = Value
  
  /**
    * A Credit Support Annex legal agreement.
    */
  val CREDIT_SUPPORT_ANNEX = Value
  
  /**
    * A Credit Support Deed legal agreement.
    */
  val CREDIT_SUPPORT_DEED = Value
}

/**
  * The enumerated values to specify the Credit Support Document Terms
  */
object CreditSupportDocumentTermsEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement.
    */
  val ANY = Value
  
  /**
    * No Credit Support Document is specified.
    */
  val NONE = Value
  
  /**
    * A specified Credit Support Document is provided
    */
  val SPECIFIED = Value
}

/**
  * The enumerated values to specify the Credit Support Provider Terms
  */
object CreditSupportProviderTermsEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support.
    */
  val ANY = Value
  
  /**
    * No Credit Support Provider is specified.
    */
  val NONE = Value
  
  /**
    * A specified Credit Support Provider is provided
    */
  val SPECIFIED = Value
}

/**
  * How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1 
  */
object CsaTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Thre is an existing Credit Support Annex
    */
  val EXISTING_CSA = Value("ExistingCSA")
  
  /**
    * There is no CSA applicable
    */
  val NO_CSA = Value("NoCSA")
  
  /**
    * There is a bilateral Credit Support Annex specific to the transaction
    */
  val REFERENCE_VMCSA = Value("ReferenceVMCSA")
}

/**
  * Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016.
  */
object CurrencyCodeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * UAE Dirham
    */
  val AED = Value
  
  /**
    * Afghani
    */
  val AFN = Value
  
  /**
    * Lek
    */
  val ALL = Value
  
  /**
    * Armenian Dram
    */
  val AMD = Value
  
  /**
    * Netherlands Antillean Guilder
    */
  val ANG = Value
  
  /**
    * Kwanza
    */
  val AOA = Value
  
  /**
    * Argentine Peso
    */
  val ARS = Value
  
  /**
    * Australian Dollar
    */
  val AUD = Value
  
  /**
    * Aruban Florin
    */
  val AWG = Value
  
  /**
    * Azerbaijan Manat
    */
  val AZN = Value
  
  /**
    * Convertible Mark
    */
  val BAM = Value
  
  /**
    * Barbados Dollar
    */
  val BBD = Value
  
  /**
    * Taka
    */
  val BDT = Value
  
  /**
    * Bulgarian Lev
    */
  val BGN = Value
  
  /**
    * Bahraini Dinar
    */
  val BHD = Value
  
  /**
    * Burundi Franc
    */
  val BIF = Value
  
  /**
    * Bermudian Dollar
    */
  val BMD = Value
  
  /**
    * Brunei Dollar
    */
  val BND = Value
  
  /**
    * Boliviano
    */
  val BOB = Value
  
  /**
    * Mvdol
    */
  val BOV = Value
  
  /**
    * Brazilian Real
    */
  val BRL = Value
  
  /**
    * Bahamian Dollar
    */
  val BSD = Value
  
  /**
    * Ngultrum
    */
  val BTN = Value
  
  /**
    * Pula
    */
  val BWP = Value
  
  /**
    * Belarusian Ruble
    */
  val BYN = Value
  
  /**
    * Belize Dollar
    */
  val BZD = Value
  
  /**
    * Canadian Dollar
    */
  val CAD = Value
  
  /**
    * Congolese Franc
    */
  val CDF = Value
  
  /**
    * WIR Euro
    */
  val CHE = Value
  
  /**
    * Swiss Franc
    */
  val CHF = Value
  
  /**
    * WIR Franc
    */
  val CHW = Value
  
  /**
    * Unidad de Fomento
    */
  val CLF = Value
  
  /**
    * Chilean Peso
    */
  val CLP = Value
  
  /**
    * Offshore Chinese Yuan traded in Hong Kong.
    */
  val CNH = Value
  
  /**
    * Offshore Chinese Yuan traded in Taiwan.
    */
  val CNT = Value
  
  /**
    * Yuan Renminbi
    */
  val CNY = Value
  
  /**
    * Colombian Peso
    */
  val COP = Value
  
  /**
    * Unidad de Valor Real
    */
  val COU = Value
  
  /**
    * Costa Rican Colon
    */
  val CRC = Value
  
  /**
    * Peso Convertible
    */
  val CUC = Value
  
  /**
    * Cuban Peso
    */
  val CUP = Value
  
  /**
    * Cabo Verde Escudo
    */
  val CVE = Value
  
  /**
    * Czech Koruna
    */
  val CZK = Value
  
  /**
    * Djibouti Franc
    */
  val DJF = Value
  
  /**
    * Danish Krone
    */
  val DKK = Value
  
  /**
    * Dominican Peso
    */
  val DOP = Value
  
  /**
    * Algerian Dinar
    */
  val DZD = Value
  
  /**
    * Egyptian Pound
    */
  val EGP = Value
  
  /**
    * Nakfa
    */
  val ERN = Value
  
  /**
    * Ethiopian Birr
    */
  val ETB = Value
  
  /**
    * Euro
    */
  val EUR = Value
  
  /**
    * Fiji Dollar
    */
  val FJD = Value
  
  /**
    * Falkland Islands Pound
    */
  val FKP = Value
  
  /**
    * Pound Sterling
    */
  val GBP = Value
  
  /**
    * Lari
    */
  val GEL = Value
  
  /**
    * Guernsey Pound.
    */
  val GGP = Value
  
  /**
    * Ghana Cedi
    */
  val GHS = Value
  
  /**
    * Gibraltar Pound
    */
  val GIP = Value
  
  /**
    * Dalasi
    */
  val GMD = Value
  
  /**
    * Guinean Franc
    */
  val GNF = Value
  
  /**
    * Quetzal
    */
  val GTQ = Value
  
  /**
    * Guyana Dollar
    */
  val GYD = Value
  
  /**
    * Hong Kong Dollar
    */
  val HKD = Value
  
  /**
    * Lempira
    */
  val HNL = Value
  
  /**
    * Gourde
    */
  val HTG = Value
  
  /**
    * Forint
    */
  val HUF = Value
  
  /**
    * Rupiah
    */
  val IDR = Value
  
  /**
    * New Israeli Sheqel
    */
  val ILS = Value
  
  /**
    * Isle of Man Pound.
    */
  val IMP = Value
  
  /**
    * Indian Rupee
    */
  val INR = Value
  
  /**
    * Iraqi Dinar
    */
  val IQD = Value
  
  /**
    * Iranian Rial
    */
  val IRR = Value
  
  /**
    * Iceland Krona
    */
  val ISK = Value
  
  /**
    * Jersey Pound.
    */
  val JEP = Value
  
  /**
    * Jamaican Dollar
    */
  val JMD = Value
  
  /**
    * Jordanian Dinar
    */
  val JOD = Value
  
  /**
    * Yen
    */
  val JPY = Value
  
  /**
    * Kenyan Shilling
    */
  val KES = Value
  
  /**
    * Som
    */
  val KGS = Value
  
  /**
    * Riel
    */
  val KHR = Value
  
  /**
    * Tuvaluan Dollar.
    */
  val KID = Value
  
  /**
    * Comorian Franc 
    */
  val KMF = Value
  
  /**
    * North Korean Won
    */
  val KPW = Value
  
  /**
    * Won
    */
  val KRW = Value
  
  /**
    * Kuwaiti Dinar
    */
  val KWD = Value
  
  /**
    * Cayman Islands Dollar
    */
  val KYD = Value
  
  /**
    * Tenge
    */
  val KZT = Value
  
  /**
    * Lao Kip
    */
  val LAK = Value
  
  /**
    * Lebanese Pound
    */
  val LBP = Value
  
  /**
    * Sri Lanka Rupee
    */
  val LKR = Value
  
  /**
    * Liberian Dollar
    */
  val LRD = Value
  
  /**
    * Loti
    */
  val LSL = Value
  
  /**
    * Libyan Dinar
    */
  val LYD = Value
  
  /**
    * Moroccan Dirham
    */
  val MAD = Value
  
  /**
    * Monegasque Franc.
    */
  val MCF = Value
  
  /**
    * Moldovan Leu
    */
  val MDL = Value
  
  /**
    * Malagasy Ariary
    */
  val MGA = Value
  
  /**
    * Denar
    */
  val MKD = Value
  
  /**
    * Kyat
    */
  val MMK = Value
  
  /**
    * Tugrik
    */
  val MNT = Value
  
  /**
    * Pataca
    */
  val MOP = Value
  
  /**
    * Ouguiya
    */
  val MRU = Value
  
  /**
    * Mauritius Rupee
    */
  val MUR = Value
  
  /**
    * Rufiyaa
    */
  val MVR = Value
  
  /**
    * Malawi Kwacha
    */
  val MWK = Value
  
  /**
    * Mexican Peso
    */
  val MXN = Value
  
  /**
    * Mexican Unidad de Inversion (UDI)
    */
  val MXV = Value
  
  /**
    * Malaysian Ringgit
    */
  val MYR = Value
  
  /**
    * Mozambique Metical
    */
  val MZN = Value
  
  /**
    * Namibia Dollar
    */
  val NAD = Value
  
  /**
    * Naira
    */
  val NGN = Value
  
  /**
    * Cordoba Oro
    */
  val NIO = Value
  
  /**
    * Norwegian Krone
    */
  val NOK = Value
  
  /**
    * Nepalese Rupee
    */
  val NPR = Value
  
  /**
    * New Zealand Dollar
    */
  val NZD = Value
  
  /**
    * Rial Omani
    */
  val OMR = Value
  
  /**
    * Balboa
    */
  val PAB = Value
  
  /**
    * Sol
    */
  val PEN = Value
  
  /**
    * Kina
    */
  val PGK = Value
  
  /**
    * Philippine Peso
    */
  val PHP = Value
  
  /**
    * Pakistan Rupee
    */
  val PKR = Value
  
  /**
    * Zloty
    */
  val PLN = Value
  
  /**
    * Guarani
    */
  val PYG = Value
  
  /**
    * Qatari Rial
    */
  val QAR = Value
  
  /**
    * Romanian Leu
    */
  val RON = Value
  
  /**
    * Serbian Dinar
    */
  val RSD = Value
  
  /**
    * Russian Ruble
    */
  val RUB = Value
  
  /**
    * Rwanda Franc
    */
  val RWF = Value
  
  /**
    * Saudi Riyal
    */
  val SAR = Value
  
  /**
    * Solomon Islands Dollar
    */
  val SBD = Value
  
  /**
    * Seychelles Rupee
    */
  val SCR = Value
  
  /**
    * Sudanese Pound
    */
  val SDG = Value
  
  /**
    * Swedish Krona
    */
  val SEK = Value
  
  /**
    * Singapore Dollar
    */
  val SGD = Value
  
  /**
    * Saint Helena Pound
    */
  val SHP = Value
  
  /**
    * Leone
    */
  val SLE = Value
  
  /**
    * Sammarinese Lira.
    */
  val SML = Value
  
  /**
    * Somali Shilling
    */
  val SOS = Value
  
  /**
    * Surinam Dollar
    */
  val SRD = Value
  
  /**
    * South Sudanese Pound
    */
  val SSP = Value
  
  /**
    * Dobra
    */
  val STN = Value
  
  /**
    * El Salvador Colon
    */
  val SVC = Value
  
  /**
    * Syrian Pound
    */
  val SYP = Value
  
  /**
    * Lilangeni
    */
  val SZL = Value
  
  /**
    * Baht
    */
  val THB = Value
  
  /**
    * Somoni
    */
  val TJS = Value
  
  /**
    * Turkmenistan New Manat
    */
  val TMT = Value
  
  /**
    * Tunisian Dinar
    */
  val TND = Value
  
  /**
    * Pa’anga
    */
  val TOP = Value
  
  /**
    * Turkish Lira
    */
  val TRY = Value
  
  /**
    * Trinidad and Tobago Dollar
    */
  val TTD = Value
  
  /**
    * New Taiwan Dollar
    */
  val TWD = Value
  
  /**
    * Tanzanian Shilling
    */
  val TZS = Value
  
  /**
    * Hryvnia
    */
  val UAH = Value
  
  /**
    * Uganda Shilling
    */
  val UGX = Value
  
  /**
    * US Dollar
    */
  val USD = Value
  
  /**
    * US Dollar (Next day)
    */
  val USN = Value
  
  /**
    * Uruguay Peso en Unidades Indexadas (UI)
    */
  val UYI = Value
  
  /**
    * Peso Uruguayo
    */
  val UYU = Value
  
  /**
    * Unidad Previsional
    */
  val UYW = Value
  
  /**
    * Uzbekistan Sum
    */
  val UZS = Value
  
  /**
    * Vatican Lira.
    */
  val VAL = Value
  
  /**
    * Bolívar Soberano
    */
  val VED = Value
  
  /**
    * Bolívar Soberano
    */
  val VES = Value
  
  /**
    * Dong
    */
  val VND = Value
  
  /**
    * Vatu
    */
  val VUV = Value
  
  /**
    * Tala
    */
  val WST = Value
  
  /**
    * CFA Franc BEAC
    */
  val XAF = Value
  
  /**
    * Silver
    */
  val XAG = Value
  
  /**
    * Gold
    */
  val XAU = Value
  
  /**
    * Bond Markets Unit European Composite Unit (EURCO)
    */
  val XBA = Value
  
  /**
    * Bond Markets Unit European Monetary Unit (E.M.U.-6)
    */
  val XBB = Value
  
  /**
    * Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
    */
  val XBC = Value
  
  /**
    * Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
    */
  val XBD = Value
  
  /**
    * East Caribbean Dollar
    */
  val XCD = Value
  
  /**
    * SDR (Special Drawing Right)
    */
  val XDR = Value
  
  /**
    * CFA Franc BCEAO
    */
  val XOF = Value
  
  /**
    * Palladium
    */
  val XPD = Value
  
  /**
    * CFP Franc
    */
  val XPF = Value
  
  /**
    * Platinum
    */
  val XPT = Value
  
  /**
    * Sucre
    */
  val XSU = Value
  
  /**
    * Codes specifically reserved for testing purposes
    */
  val XTS = Value
  
  /**
    * ADB Unit of Account
    */
  val XUA = Value
  
  /**
    * The codes assigned for transactions where no currency is involved
    */
  val XXX = Value
  
  /**
    * Yemeni Rial
    */
  val YER = Value
  
  /**
    * Rand
    */
  val ZAR = Value
  
  /**
    * Zambian Kwacha
    */
  val ZMW = Value
  
  /**
    * Zimbabwe Gold
    */
  val ZWG = Value
}

/**
  * The enumerated values to specify the day count fraction.
  */
object DayCountFractionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (v), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (e) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (d).
    */
  val ACT_360 = Value("ACT/360")
  
  /**
    * Per CFTC definitions.
    */
  val ACT_364 = Value("ACT/364")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ix), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (i).
    */
  val ACT_365L = Value("ACT/365L")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iv), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (d) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (c).
    */
  val ACT_365_FIXED = Value("ACT/365.FIXED")
  
  /**
    * The Fixed/Floating Amount will be calculated in accordance with the 'BASE EXACT/EXACT' day count fraction, as defined in the 'Definitions Communes plusieurs Additifs Techniques' published by the Association Francaise des Banques in September 1994.
    */
  val ACT_ACT_AFB = Value("ACT/ACT.AFB")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (c). This day count fraction code is applicable for transactions booked under the 2021 ISDA Definitions and the 2006 ISDA Definitions. Transactions under the 2000 ISDA Definitions should use the ACT/ACT.ISMA code instead.
    */
  val ACT_ACT_ICMA = Value("ACT/ACT.ICMA")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (b) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (b). Note that going from FpML 2.0 Recommendation to the FpML 3.0 Trial Recommendation the code in FpML 2.0 'ACT/365.ISDA' became 'ACT/ACT.ISDA'.
    */
  val ACT_ACT_ISDA = Value("ACT/ACT.ISDA")
  
  /**
    * The Fixed/Floating Amount will be calculated in accordance with Rule 251 of the statutes, by-laws, rules and recommendations of the International Securities Market Association, as published in April 1999, as applied to straight and convertible bonds issued after December 31, 1998, as though the Fixed/Floating Amount were the interest coupon on such a bond. This day count fraction code is applicable for transactions booked under the 2000 ISDA Definitions. Transactions under the 2021 ISDA Definitions and the 2006 ISDA Definitions should use the ACT/ACT.ICMA code instead.
    */
  val ACT_ACT_ISMA = Value("ACT/ACT.ISMA")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (x). Supercedes BUS/252, the number of Business Days in the Calculation Period or Compounding Period in respect of which payment is being made divided by 252.
    */
  val CAL_252 = Value("CAL/252")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (xi), the calculation mechanics are driven deterministically by the Calculation Period Frequency (i.e. 0.25 if it is three months, 0.5 if it is 6 months, 1 if it is a year), except that if the first Calculation Period or the final Calculation Period is less than the Calculation Period Frequency, Actual/Actual (ISDA) shall apply to that Calculation Period
    */
  val RBA_BOND_BASIS = Value("RBA Bond Basis")
  
  /**
    * Per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (a) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (a).
    */
  val _1_1 = Value("1/1")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (g) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (f). Note that the algorithm defined for this day count fraction has changed between the 2000 ISDA Definitions and 2006 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
    */
  val _30E_360 = Value("30E/360")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (viii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (h). Note the algorithm for this day count fraction under the 2006 ISDA Definitions is designed to yield the same results in practice as the version of the 30E/360 day count fraction defined in the 2000 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
    */
  val _30E_360_ISDA = Value("30E/360.ISDA")
  
  /**
    * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vi), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (f) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (e).
    */
  val _30_360 = Value("30/360")
}

/**
  * Denotes the method by which the pricing days are distributed across the pricing period.
  */
object DayDistributionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ALL = Value
  
  val FIRST = Value
  
  val LAST = Value
  
  val PENULTIMATE = Value
}

/**
  * The enumerated values to specify a day of the seven-day week.
  */
object DayOfWeekEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Friday
    */
  val FRI = Value
  
  /**
    * Monday
    */
  val MON = Value
  
  /**
    * Saturday
    */
  val SAT = Value
  
  /**
    * Sunday
    */
  val SUN = Value
  
  /**
    * Thursday
    */
  val THU = Value
  
  /**
    * Tuesday
    */
  val TUE = Value
  
  /**
    * Wednesday
    */
  val WED = Value
}

/**
  * Lists the enumerated values to specify the day type classification used in counting the number of days between two dates.
  */
object DayTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Applies when calculating the number of days between two dates the count includes only business days.
    */
  val BUSINESS = Value
  
  /**
    * Applies when calculating the number of days between two dates the count includes all calendar days.
    */
  val CALENDAR = Value
  
  /**
    * Applies when calculating the number of days between two dates the count includes only currency business days.
    */
  val CURRENCY_BUSINESS = Value
  
  /**
    * Applies when calculating the number of days between two dates the count includes only stock exchange business days.
    */
  val EXCHANGE_BUSINESS = Value
  
  /**
    * Applies when calculating the number of days between two dates the count includes only scheduled trading days.
    */
  val SCHEDULED_TRADING_DAY = Value
}

/**
  * Represents an enumeration list that identifies the type of debt.
  */
object DebtClassEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations.
    */
  val ASSET_BACKED = Value
  
  /**
    * Identifies a debt instrument that can be converted into common shares.
    */
  val CONVERTIBLE = Value
  
  /**
    * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer.
    */
  val HOLDER_CONVERTIBLE = Value
  
  /**
    * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer.
    */
  val HOLDER_EXCHANGEABLE = Value
  
  /**
    * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
    */
  val ISSUER_CONVERTIBLE = Value
  
  /**
    * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable.
    */
  val ISSUER_EXCHANGEABLE = Value
  
  /**
    * Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
    */
  val REG_CAP = Value
  
  /**
    * Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
    */
  val STRUCTURED = Value
  
  /**
    * Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
    */
  val VANILLA = Value
}

/**
  * Represents an enumeration list that specifies the general rule for periodic interest rate payment.
  */
object DebtInterestEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes payment calculated with reference to a fixed interest rate.
    */
  val FIXED = Value
  
  /**
    * Denotes payment calculated with reference to a floating interest rate.
    */
  val FLOATING = Value
  
  /**
    * Denotes payment calculated with reference to one or more price or other indices (other than inflation rates).
    */
  val INDEX_LINKED = Value
  
  /**
    * Denotes payment calculated with reference to one or more specified inflation rates.
    */
  val INFLATION_LINKED = Value
  
  /**
    * Denotes a stripped bond representing only the interest component.
    */
  val INTEREST_ONLY = Value
  
  /**
    * Denotes payment calculated with reference to the inverse of a floating interest rate.
    */
  val INVERSE_FLOATING = Value
  
  /**
    * Denotes payment calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
    */
  val OTHER_STRUCTURED = Value
  
  /**
    * Denotes a zero coupon bond that does not pay intetrest.
    */
  val ZERO_COUPON = Value
}

/**
  * Represents an enumeration list that specifies the general rule for repayment of principal.
  */
object DebtPrincipalEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
    */
  val AMORTISING = Value
  
  /**
    * Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
    */
  val BULLET = Value
  
  /**
    * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
    */
  val CALLABLE = Value
  
  /**
    * Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
    */
  val INDEX_LINKED = Value
  
  /**
    * Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
    */
  val INFLATION_LINKED = Value
  
  /**
    * Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
    */
  val OTHER_STRUCTURED = Value
  
  /**
    * Denotes a stripped bond representing only the principal component.
    */
  val PRINCIPAL_ONLY = Value
  
  /**
    * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
    */
  val PUTTABLE = Value
}

/**
  * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
  */
object DebtSeniorityEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes debt which is secured over assets of the issuer or a related party (eg guarantor).
    */
  val SECURED = Value
  
  /**
    * Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer.
    */
  val SENIOR = Value
  
  /**
    * Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met.
    */
  val SUBORDINATED = Value
}

/**
  * The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language.
  */
object DeliveryAmountElectionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.`
    */
  val LAST_AND_ANY_LOCAL_BUSINESS_DAY = Value
  
  /**
    * The delivery only includes `Transfer on last Local Business Day.
    */
  val LAST_LOCAL_BUSINESS_DAY = Value
}

/**
  * Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
  */
object DeliveryMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other.
    */
  val DELIVERY_VERSUS_PAYMENT = Value
  
  /**
    * Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa.
    */
  val FREE_OF_PAYMENT = Value
  
  /**
    * Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment.
    */
  val PRE_DELIVERY = Value
  
  /**
    * Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment.
    */
  val PRE_PAYMENT = Value
}

object DeliveryNearbyTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
    */
  val CALCULATION_PERIOD = Value
  
  /**
    * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
    */
  val NEARBY_MONTH = Value
  
  /**
    * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
    */
  val NEARBY_WEEK = Value
}

/**
  * The enumerated values to specify the method according to which an amount or a date is determined.
  */
object DeterminationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Agreed separately between the parties.
    */
  val AGREED_INITIAL_PRICE = Value
  
  /**
    * As specified in Master Confirmation.
    */
  val AS_SPECIFIED_IN_MASTER_CONFIRMATION = Value
  
  /**
    * Determined by the Calculation Agent.
    */
  val CALCULATION_AGENT = Value
  
  /**
    * Official Closing Price.
    */
  val CLOSING_PRICE = Value
  
  /**
    * Determined by the Currency of Equity Dividends.
    */
  val DIVIDEND_CURRENCY = Value
  
  /**
    * The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
    */
  val EXPIRING_CONTRACT_LEVEL = Value
  
  /**
    * Determined by the Hedging Party.
    */
  val HEDGE_EXECUTION = Value
  
  /**
    * Issuer Payment Currency.
    */
  val ISSUER_PAYMENT_CURRENCY = Value
  
  /**
    * Net Asset Value.
    */
  val NAV = Value
  
  /**
    * OSP Price.
    */
  val OSP_PRICE = Value
  
  /**
    * Opening Price of the Market.
    */
  val OPEN_PRICE = Value
  
  /**
    * Settlement Currency.
    */
  val SETTLEMENT_CURRENCY = Value
  
  /**
    * Date on which the strike is determined in respect of a forward starting swap.
    */
  val STRIKE_DATE_DETERMINATION = Value
  
  /**
    * Official TWAP Price.
    */
  val TWAP_PRICE = Value
  
  /**
    * Official VWAP Price.
    */
  val VWAP_PRICE = Value
  
  /**
    * Price determined at valuation time.
    */
  val VALUATION_TIME = Value
}

/**
  * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
  */
object DiscountingTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
    */
  val AFMA = Value
  
  /**
    * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
    */
  val FRA = Value
  
  /**
    * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
    */
  val FRA_YIELD = Value
  
  /**
    * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
    */
  val STANDARD = Value
}

/**
  * The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
  */
object DividendAmountTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Amount is determined as provided in the relevant Master Confirmation.
    */
  val AS_SPECIFIED_IN_MASTER_CONFIRMATION = Value
  
  /**
    * The ex-date for a dividend occurs during a dividend period.
    */
  val EX_AMOUNT = Value
  
  /**
    * The payment date for a dividend occurs during a dividend period.
    */
  val PAID_AMOUNT = Value
  
  /**
    * The record date for a dividend occurs during a dividend period.
    */
  val RECORD_AMOUNT = Value
}

/**
  * The enumerated values to specify how the composition of Dividends is to be determined.
  */
object DividendCompositionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Calculation Agent determines the composition of dividends (subject to conditions).
    */
  val CALCULATION_AGENT_ELECTION = Value
  
  /**
    * The Equity Amount Receiver determines the composition of dividends (subject to conditions).
    */
  val EQUITY_AMOUNT_RECEIVER_ELECTION = Value
}

/**
  * The enumerated values to specify the date by reference to which the dividend will be paid.
  */
object DividendDateReferenceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The dividend date will be specified ad-hoc by the parties, typically on the dividend ex-date.
    */
  val AD_HOC_DATE = Value
  
  /**
    * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Ex Dividend'', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange.
    */
  val CASH_SETTLE_PAYMENT_DATE_EX_DIV = Value
  
  /**
    * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Issuer Payment', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the issuer pays the relevant dividend to a holder of record provided that in the case where the Equity Amount Payer is the party specified to be the sole Hedging Party and the Hedging Party has not received the Dividend Amount by such date, then the date falling a number of Currency Business Days as specified in the Cash Settlement Payment Date after actual receipt by the Hedging Party of the Received Ex Amount or Paid Ex Amount (as applicable).
    */
  val CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT = Value
  
  /**
    * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange.
    */
  val CASH_SETTLEMENT_PAYMENT_DATE = Value
  
  /**
    * Total of dividends which go ex, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange.
    */
  val CUMULATIVE_EQUITY_EX_DIV = Value
  
  /**
    * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Ex Date, unless the Dividend Ex Date is between the Equity Valuation and Payment Date in which case the dividend is deferred to the following Equity Payment Date
    */
  val CUMULATIVE_EQUITY_EX_DIV_BEFORE_RESET = Value
  
  /**
    * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
    */
  val CUMULATIVE_EQUITY_PAID = Value
  
  /**
    * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
    */
  val CUMULATIVE_EQUITY_PAID_BEFORE_RESET = Value
  
  /**
    * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
    */
  val CUMULATIVE_EQUITY_PAID_INCL_RESET = Value
  
  /**
    * Total of dividends which go ex, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange, or where the date on which the Shares commence trading ex-dividend is a Payment Date, such Payment Date.
    */
  val CUMULATIVE_INTEREST_EX_DIV = Value
  
  /**
    * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
    */
  val CUMULATIVE_INTEREST_PAID = Value
  
  /**
    * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
    */
  val CUMULATIVE_INTEREST_PAID_BEFORE_RESET = Value
  
  /**
    * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
    */
  val CUMULATIVE_INTEREST_PAID_INCL_RESET = Value
  
  /**
    * Date on which the dividend will be paid by the issuer.
    */
  val DIVIDEND_PAYMENT_DATE = Value
  
  /**
    * In respect of each Dividend Period, the relevant Dividend Valuation Date.
    */
  val DIVIDEND_VALUATION_DATE = Value
  
  /**
    * Equity payment date of the swap.
    */
  val EQUITY_PAYMENT_DATE = Value
  
  /**
    * Date on which a holder of the security is entitled to the dividend.
    */
  val EX_DATE = Value
  
  /**
    * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Floating Amount Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the first Payment Date falling at least one Settlement Cycle after the date that the Shares have commenced trading 'ex' the relevant dividend on the Exchange.
    */
  val FLOATING_AMOUNT_PAYMENT_DATE = Value
  
  /**
    * The next payment date of the swap.
    */
  val FOLLOWING_PAYMENT_DATE = Value
  
  /**
    * Date on which the dividend will be recorded in the books of the paying agent.
    */
  val RECORD_DATE = Value
  
  /**
    * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Share Payment', then the Dividend Payment Date in respect of a Dividend Amount shall fall on a date on or before the date that is two (or any other number that is specified in the Transaction Supplement) Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
    */
  val SHARE_PAYMENT = Value
  
  /**
    * Termination date of the swap.
    */
  val TERMINATION_DATE = Value
  
  /**
    * Trade date of the swap
    */
  val TRADE_DATE = Value
  
  /**
    * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until trade is fully unwound.
    */
  val UNWIND_EX_DIV = Value
  
  /**
    * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
    */
  val UNWIND_OR_EQUITY_EX_DIV = Value
  
  /**
    * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
    */
  val UNWIND_OR_EQUITY_PAID = Value
  
  /**
    * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Ex Date. This will be whichever date comes first or a combination of both.
    */
  val UNWIND_OR_INTEREST_EX_DIV = Value
  
  /**
    * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
    */
  val UNWIND_OR_INTEREST_PAID = Value
  
  /**
    * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until trade is fully unwound.
    */
  val UNWIND_PAID = Value
}

/**
  * The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend.
  */
object DividendEntitlementEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Dividend entitlement is on the dividend ex-date.
    */
  val EX_DATE = Value
  
  /**
    * Dividend entitlement is on the dividend record date.
    */
  val RECORD_DATE = Value
}

/**
  * 2002 ISDA Equity Derivatives Definitions: First Period, Second Period |
  */
object DividendPeriodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * 2002 ISDA Equity Derivatives Definitions: First Period means each period from, and including, one Cash Settlement Payment Date or Settlement Date, as the case may be, to, but excluding, the next following Cash Settlement Payment Date or Settlement Date, as the case may be, except that (i) the initial Dividend Period will commence on, and include, the Clearance System Business Day that is one Settlement Cycle following the Trade Date and (ii) the final Dividend Period will end on, but exclude, the final Cash Settlement Payment Date or Settlement Date, as the case may be.
    */
  val FIRST_PERIOD = Value
  
  /**
    * 2002 ISDA Equity Derivatives Definitions: Second Period means each period from, but excluding, one Valuation Date to, and including, the next Valuation Date, except that (i) the initial Dividend Period will commence on, but exclude, the Trade Date and (ii) the final Dividend Period will end on, and include, the final Valuation Date or, in respect of a Physically-settled Forward Transaction to which Variable Obligation is not applicable, the date that is one Settlement Cycle prior to the Settlement Date.
    */
  val SECOND_PERIOD = Value
}

/**
  * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
  */
object EU_EMIR_EligibleCollateralEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes Cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
    */
  val EU_EMIR_TYPE_A = Value
  
  /**
    *  Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
    */
  val EU_EMIR_TYPE_B = Value
  
  /**
    *  Denotes debt securities issued by Member States' central governments or central banks.
    */
  val EU_EMIR_TYPE_C = Value
  
  /**
    *  Denotes debt securities issued by Member States' regional governments or local authorities whose exposures are treated as exposures to the central government of that Member State in accordance with Article 115(2) of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_D = Value
  
  /**
    *  Denotes debt securities issued by Member States' public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of that Member State in accordance with Article 116(4) of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_E = Value
  
  /**
    *  Denotes debt securities issued by Member States' regional governments or local authorities other than those referred to in (TypeD.)
    */
  val EU_EMIR_TYPE_F = Value
  
  /**
    *  Denotes debt securities issued by Member States' public sector entities other than those referred to in (TypeE).
    */
  val EU_EMIR_TYPE_G = Value
  
  /**
    *  Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_H = Value
  
  /**
    *  Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_I = Value
  
  /**
    *  Denotes debt securities issued by third countries' governments or central banks.
    */
  val EU_EMIR_TYPE_J = Value
  
  /**
    *  Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
    */
  val EU_EMIR_TYPE_K = Value
  
  /**
    *  Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
    */
  val EU_EMIR_TYPE_L = Value
  
  /**
    *  Denotes debt securities issued by credit institutions or investment firms including bonds referred to in Article 52(4) of Directive 2009/65/EC of the European Parliament and of the Council.
    */
  val EU_EMIR_TYPE_M = Value
  
  /**
    *  Denotes corporate bonds.
    */
  val EU_EMIR_TYPE_N = Value
  
  /**
    *  Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
    */
  val EU_EMIR_TYPE_O = Value
  
  /**
    *  Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_P = Value
  
  /**
    *  Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
    */
  val EU_EMIR_TYPE_Q = Value
  
  /**
    *  Denotes shares or units in undertakings for collective investments in transferable securities (UCITS), provided that the conditions set out in Article 5 of EU Regulation 2016/2251 are met.
    */
  val EU_EMIR_TYPE_R = Value
}

/**
  * The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation.
  */
object EntityTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Entity Type of Asian.
    */
  val ASIAN = Value
  
  /**
    * Entity Type of Australian and New Zealand.
    */
  val AUSTRALIAN_AND_NEW_ZEALAND = Value
  
  /**
    * Entity Type of European Emerging Markets.
    */
  val EUROPEAN_EMERGING_MARKETS = Value
  
  /**
    * Entity Type of Japanese.
    */
  val JAPANESE = Value
  
  /**
    * Entity Type of North American High Yield.
    */
  val NORTH_AMERICAN_HIGH_YIELD = Value
  
  /**
    * Entity Type of North American Insurance.
    */
  val NORTH_AMERICAN_INSURANCE = Value
  
  /**
    * Entity Type of North American Investment Grade.
    */
  val NORTH_AMERICAN_INVESTMENT_GRADE = Value
  
  /**
    * Entity Type of Singaporean.
    */
  val SINGAPOREAN = Value
  
  /**
    * Entity Type of Western European.
    */
  val WESTERN_EUROPEAN = Value
  
  /**
    * Entity Type of Western European Insurance.
    */
  val WESTERN_EUROPEAN_INSURANCE = Value
}

/**
  * Represents an enumeration list to identify the type of Equity.
  */
object EquityTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Identifies an Equity of Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation.
    */
  val NON_CONVERTIBLE_PREFERENCE = Value
  
  /**
    * Identifies an Equity of Common stocks and shares.
    */
  val ORDINARY = Value
}

/**
  * The enumeration values to qualify the intent associated with a transaction event.
  */
object EventIntentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The intent is to allocate one or more trades as part of an allocated block trade.
    */
  val ALLOCATION = Value
  
  /**
    * The intent is to designate a stand-alone cash transfer as a result of Trade contracual terms e.g. incurred by payout for instance a Performance Amount or a Floating Rate Amount. The particular CashFlow at stake shall be further specified in priceTransferEnum or transferTypeEnum. For clarity, such intentEnum value shall not be used whenever a cash transfer is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. Decrease with Fees, Cross-Currency Notional Reset, etc. or any other Event whenever including a cash transfer with other features. For clarity, a principal payment related to a Principal Exhange is excluded as well, because a dedicated intentEnum value exists for this event i.e. PrincipalExchange value.
    */
  val CASH_FLOW = Value
  
  /**
    * The intent is to clear the contract.
    */
  val CLEARING = Value
  
  /**
    * The intent is to compress multiple trades as part of a netting or compression event.
    */
  val COMPRESSION = Value
  
  /**
    * The intent is to form a contract from an execution.
    */
  val CONTRACT_FORMATION = Value
  
  /**
    * The intent is to amend the terms of the contract through renegotiation.
    */
  val CONTRACT_TERMS_AMENDMENT = Value
  
  /**
    * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
    */
  val CORPORATE_ACTION_ADJUSTMENT = Value
  
  /**
    * The intent is to take into effect the occurrence of a Credit Event.
    */
  val CREDIT_EVENT = Value
  
  /**
    * The intent is to Decrease the quantity or notional of the contract.
    */
  val DECREASE = Value
  
  /**
    * The intent is to fully unwind the Trade, as a result of the application of Trade contractual terms (e.g. an obligation to do so before Termination Date as part of any kind of Early Termination terms) as defined within the CDM EarlyTerminationProvision data type. Accordingly, increase and decrease of positions which result from negotiation by the parties shall not be designated by such intentEnum. For clarity, partial exercise of an option before its expiration date is excluded as well, though related to Trade contract terms, because a dedicated intentEnum value exists for this event i.e. OptionExercise value.
    */
  val EARLY_TERMINATION_PROVISION = Value
  
  /**
    * The intent is to Increase the quantity or notional of the contract.
    */
  val INCREASE = Value
  
  /**
    * The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any). 
    */
  val INDEX_TRANSITION = Value
  
  /**
    * The intent is to increase or to decrease the notional of the Trade, in accordance with Notional Reset features e.g. could apply for Cross Currency Swaps, Equity Performance Swaps, etc.
    */
  val NOTIONAL_RESET = Value
  
  /**
    * The intent is to increase or to decrease the notional of the Trade, in accordance with Step features attached to a Payout Quantity.
    */
  val NOTIONAL_STEP = Value
  
  /**
    * The intent is to novate the contract.
    */
  val NOVATION = Value
  
  /**
    * The intent is to record any kind of stand-alone obervervations e.g. internal data recording, usage of CDM for recording and/or exchanging data as part of pricing 'consensus' processing, etc. For clarity, such intentEnum value shall not be used whenever an observation is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. CashFlow to which an observation of prices is associated, etc.
    */
  val OBSERVATION_RECORD = Value
  
  /**
    * The intent is to Exercise a contract that is made of one or several option payout legs. For clarity, such intentEnum value shall not be used whenever an optional right is exercised in relation with a Trade which composition includes other types of payout legs e.g. right to call or to cancel before Termination Date as part of any kind of Early Termination terms other than genuine bermuda or american style features described in option payout. 
    */
  val OPTION_EXERCISE = Value
  
  /**
    * The intent is to cancel the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
    */
  val OPTIONAL_CANCELLATION = Value
  
  /**
    * The intent is to extend the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
    */
  val OPTIONAL_EXTENSION = Value
  
  /**
    * The intent is to rebalance a portfolio, by inserting new derivatives transactions into portfolios of participants to reduce risks linked to those trades. These are offsetting trades that rebalance relationships between different counterparties when it comes to exposure of portfolios to certain types of risk, such as interest rate risk.
    */
  val PORTFOLIO_REBALANCING = Value
  
  /**
    * The intent is to pay or to receive a cash transfer, in accordance with Principal Exchange features.
    */
  val PRINCIPAL_EXCHANGE = Value
  
  /**
    * The intent is to reallocate one or more trades as part of an allocated block trade.
    */
  val REALLOCATION = Value
  
  /**
    * The intent is to close a repo transaction through repurchase.
    */
  val REPURCHASE = Value
}

/**
  * The enumeration values to qualify the timestamps that can be associated with a lifecycle event. The reason for such approach is that the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. Implementers are expected to evaluate the current enumeration values to determine whether those meet their requirements. If not, they are expected to engage with the CDM team to evaluate the addition of further value(s) to this enumeration, which will then participate to the development of a compendium for further evaluation at a later point in order to determine whether this modeling is appropriate.
  */
object EventTimestampQualificationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The date and time on which trade was confirmed as cleared.
    */
  val CLEARING_CONFIRMATION_DATE_TIME = Value
  
  /**
    * The date and time on the trade was cleared.
    */
  val CLEARING_DATE_TIME = Value
  
  /**
    * The date and time on which trade was received by Clearing Body.
    */
  val CLEARING_RECEIPT_DATE_TIME = Value
  
  /**
    * The date and time on which the event was submitted for clearing.
    */
  val CLEARING_SUBMISSION_DATE_TIME = Value
  
  /**
    * The date and time on which the event was confirmed.
    */
  val CONFIRMATION_DATE_TIME = Value
  
  /**
    * The date and time on which the event was created.
    */
  val EVENT_CREATION_DATE_TIME = Value
  
  /**
    * The date and time on which the event will be considered expired.
    */
  val EVENT_EXPIRATION_DATE_TIME = Value
  
  /**
    * The date and time on which the event was processed.
    */
  val EVENT_PROCESSING_DATE_TIME = Value
  
  /**
    * The date and time on which the event was sent.
    */
  val EVENT_SENT_DATE_TIME = Value
  
  /**
    * The date and time on which the event was submitted.
    */
  val EVENT_SUBMITTED_DATE_TIME = Value
  
  /**
    * The date and time on which the trade execution was performed.
    */
  val EXECUTION_DATE_TIME = Value
  
  /**
    * The date and time on which the transaction has been created. This timestamp is specified as such by the CME ClearPort Matched IRS Trade submission API specification: 'The transaction date time of the trade. Represents the date & time on which the trade was initially generated either by CME Clearing or firm. The transaction date time may be assigned by CME Clearing at the point the trade is reported as cleared. Transaction date time can also be provided by an external submitter of the trade at the point the trade is submitted.'
    */
  val TRANSACTION_CREATION_DATE_TIME = Value
}

/**
  * The enumerated values to specify the Execution Location of a Security Agreement
  */
object ExecutionLocationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Agreement was executed outside of Belgium
    */
  val EXECUTED_IN_BELGIUM = Value
  
  /**
    * The Agreement was executed outside of Belgium
    */
  val EXECUTED_OUTSIDE_BELGIUM = Value
  
  /**
    * An alternative approach is described in the document as follows.
    */
  val OTHER_LOCATION = Value
}

/**
  * The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ...
  */
object ExecutionTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message.
    */
  val ELECTRONIC = Value
  
  /**
    * Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
    */
  val OFF_FACILITY = Value
  
  /**
    * Execution via a platform that may or may not be covered by a regulatory defintion. OnVenue is intended to distinguish trades executed on a trading platform from those executed via phone, email or messaging apps. The role and details of the venue are included in the party attribute of the trade. The general rule is that if the parties utilitzed the services of the platform to execute the trade then it would be considered OnVenue.
    */
  val ON_VENUE = Value
}

/**
  * Defines the principal party to the trade that has the right to exercise.
  */
object ExerciseNoticeGiverEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
    */
  val AS_SPECIFIED_IN_MASTER_AGREEMENT = Value
  
  /**
    * Specifies that both the option buyer and option seller has the right to exercise.
    */
  val BOTH = Value
  
  /**
    * Specifies that only the option buyer has the right to exercise.
    */
  val BUYER = Value
  
  /**
    * Specifies that only the option seller has the right to exercise.
    */
  val SELLER = Value
}

/**
  * The time of day at which the equity option expires, for example the official closing time of the exchange.
  */
object ExpirationTimeTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The time is determined as provided in the relevant Master Confirmation.
    */
  val AS_SPECIFIED_IN_MASTER_CONFIRMATION = Value
  
  /**
    * The official closing time of the exchange on the valuation date.
    */
  val CLOSE = Value
  
  /**
    * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlyer.
    */
  val DERIVATIVES_CLOSE = Value
  
  /**
    * The time at which the official settlement price is determined.
    */
  val OSP = Value
  
  /**
    * The official opening time of the exchange on the valuation date.
    */
  val OPEN = Value
  
  /**
    * The time specified in the element equityExpirationTime or valuationTime (as appropriate)
    */
  val SPECIFIC_TIME = Value
  
  /**
    * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
    */
  val XETRA = Value
}

/**
  * Specifies the fallback provisions in respect to the applicable Futures Price Valuation.
  */
object FPVFinalPriceElectionFallbackEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * In respect of the Early Final Valuation Date, the provisions for FPV Close shall apply.
    */
  val FPV_CLOSE = Value
  
  /**
    * In respect of the Early Final Valuation Date, the provisions for FPV Hedge Execution shall apply.
    */
  val FPV_HEDGE_EXECUTION = Value
}

/**
  * The enumerated values to specify an event that has given rise to a fee.
  */
object FeeTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A cash flow resulting from the assignment of a contract to a new counterparty.
    */
  val ASSIGNMENT = Value
  
  /**
    * The brokerage commission.
    */
  val BROKERAGE_COMMISSION = Value
  
  /**
    * A cash flow associated with a corporate action
    */
  val CORPORATE_ACTION = Value
  
  /**
    * A cash flow associated with a credit event.
    */
  val CREDIT_EVENT = Value
  
  /**
    * A cash flow associated with an increase lifecycle event.
    */
  val INCREASE = Value
  
  /**
    * The novation fee.
    */
  val NOVATION = Value
  
  /**
    * A cash flow associated with a partial termination lifecycle event.
    */
  val PARTIAL_TERMINATION = Value
  
  /**
    * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
    */
  val PREMIUM = Value
  
  /**
    * A cash flow associated with a renegotiation lifecycle event.
    */
  val RENEGOTIATION = Value
  
  /**
    * A cash flow associated with a termination lifecycle event.
    */
  val TERMINATION = Value
  
  /**
    * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
    */
  val UPFRONT = Value
}

/**
  * To be specified only for products that embed a redemption payment.
  */
object FinalPrincipalExchangeCalculationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base).
    */
  val FLOORED = Value
  
  /**
    * If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base.
    */
  val NON_FLOORED = Value
}

/**
  * Provides enumerated values for financial units, generally used in the context of defining quantities for securities.
  */
object FinancialUnitEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes financial contracts, such as listed futures and options.
    */
  val CONTRACT = Value
  
  /**
    * Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount.
    */
  val CONTRACTUAL_PRODUCT = Value
  
  /**
    * Denotes a price expressed in index points, e.g. for a stock index.
    */
  val INDEX_UNIT = Value
  
  /**
    * Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month.
    */
  val LOG_NORMAL_VOLATILITY = Value
  
  /**
    * Denotes the number of units of financial stock shares.
    */
  val SHARE = Value
  
  /**
    * Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names.
    */
  val VALUE_PER_DAY = Value
  
  /**
    * Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk.
    */
  val VALUE_PER_PERCENT = Value
  
  /**
    * Denotes a quantity (expressed as a decimal value) represented the weight of a component in a basket.
    */
  val WEIGHT = Value
}

/**
  * 3rd level ISDA FRO category.
  */
object FloatingRateIndexCalculationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ALL_IN_COMPOUNDED = Value("All-In Compounded Index")
  
  /**
    * A calculation methodology using the arithmetic mean.
    */
  val AVERAGE = Value("Overnight Averaging")
  
  val COMPOUNDED = Value("Compounded Index")
  
  /**
    * A calculation methodology using the ISDA-defined OIS compounding formula.
    */
  val OIS_COMPOUND = Value("OIS Compounding")
}

/**
  * Top level ISDA FRO category.
  */
object FloatingRateIndexCategoryEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The rate is calculated by the calculation agents from multiple observations.
    */
  val CALCULATED = Value("Calculated Rate")
  
  /**
    * The rate is obtained by polling several other banks.
    */
  val REFERENCE_BANKS = Value("Reference Banks Rate")
  
  /**
    * The rate is observed directly from a screen.
    */
  val SCREEN_RATE = Value("Screen Rate")
}

/**
  * The enumerated values to specify the list of floating rate index.
  */
object FloatingRateIndexEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AED_EBOR_REUTERS = Value("AED-EBOR-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AED_EIBOR = Value("AED-EIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_AONIA = Value("AUD-AONIA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_AONIA_OIS_COMPOUND = Value("AUD-AONIA-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_AONIA_OIS_COMPOUND_SWAP_MARKER = Value("AUD-AONIA-OIS-COMPOUND-SwapMarker")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AUD_AONIA_OIS_COMPOUND_1 = Value("AUD-AONIA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBR_AUBBSW = Value("AUD-BBR-AUBBSW")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBR_BBSW = Value("AUD-BBR-BBSW")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBR_BBSW_BLOOMBERG = Value("AUD-BBR-BBSW-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBR_BBSY__BID_ = Value("AUD-BBR-BBSY (BID)")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBR_ISDC = Value("AUD-BBR-ISDC")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBSW = Value("AUD-BBSW")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBSW_QUARTERLY_SWAP_RATE_ICAP = Value("AUD-BBSW Quarterly Swap Rate ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBSW_SEMI_ANNUAL_SWAP_RATE_ICAP = Value("AUD-BBSW Semi Annual Swap Rate ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val AUD_BBSY_BID = Value("AUD-BBSY Bid")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_LIBOR_BBA = Value("AUD-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_LIBOR_BBA_BLOOMBERG = Value("AUD-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_LIBOR_REFERENCE_BANKS = Value("AUD-LIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_QUARTERLY_SWAP_RATE_ICAP = Value("AUD-Quarterly Swap Rate-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_QUARTERLY_SWAP_RATE_ICAP_REFERENCE_BANKS = Value("AUD-Quarterly Swap Rate-ICAP-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("AUD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS = Value("AUD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS = Value("AUD-Semi-Annual Swap Rate-ICAP-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_SEMI_ANNUAL_SWAP_RATE_ICAP = Value("AUD-Semi-annual Swap Rate-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val AUD_SWAP_RATE_REUTERS = Value("AUD-Swap Rate-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val BRL_CDI = Value("BRL-CDI")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_CDOR = Value("CAD-BA-CDOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_CDOR_BLOOMBERG = Value("CAD-BA-CDOR-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_ISDD = Value("CAD-BA-ISDD")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_REFERENCE_BANKS = Value("CAD-BA-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_REUTERS = Value("CAD-BA-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_BA_TELERATE = Value("CAD-BA-Telerate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CAD_CDOR = Value("CAD-CDOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_CORRA = Value("CAD-CORRA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_CORRA_CAN_DEAL_TMX_TERM = Value("CAD-CORRA CanDeal TMX Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_CORRA_COMPOUNDED_INDEX = Value("CAD-CORRA Compounded Index")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_CORRA_OIS_COMPOUND = Value("CAD-CORRA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_CORRA_OIS_COMPOUND_1 = Value("CAD-CORRA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_ISDA_SWAP_RATE = Value("CAD-ISDA-Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_LIBOR_BBA = Value("CAD-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_LIBOR_BBA_BLOOMBERG = Value("CAD-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_LIBOR_BBA_SWAP_MARKER = Value("CAD-LIBOR-BBA-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_LIBOR_REFERENCE_BANKS = Value("CAD-LIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_REPO_CORRA = Value("CAD-REPO-CORRA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_TBILL_ISDD = Value("CAD-TBILL-ISDD")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_TBILL_REFERENCE_BANKS = Value("CAD-TBILL-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_TBILL_REUTERS = Value("CAD-TBILL-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CAD_TBILL_TELERATE = Value("CAD-TBILL-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP = Value("CHF-3M LIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("CHF-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP = Value("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG = Value("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_6_M_LIBORSWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("CHF-6M LIBORSWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP = Value("CHF-6M LIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP = Value("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG = Value("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_ANNUAL_SWAP_RATE = Value("CHF-Annual Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_ANNUAL_SWAP_RATE_11_00_ICAP = Value("CHF-Annual Swap Rate-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("CHF-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_BASIS_SWAP_3_M_VS_6_M_LIBOR_11_00_ICAP = Value("CHF-Basis Swap-3m vs 6m-LIBOR-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_ISDAFIX_SWAP_RATE = Value("CHF-ISDAFIX-Swap Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_LIBOR = Value("CHF-LIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_LIBOR_BBA = Value("CHF-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_LIBOR_BBA_BLOOMBERG = Value("CHF-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_LIBOR_ISDA = Value("CHF-LIBOR-ISDA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_LIBOR_REFERENCE_BANKS = Value("CHF-LIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_OIS_11_00_ICAP = Value("CHF-OIS-11:00-ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON = Value("CHF-SARON")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_12_M = Value("CHF-SARON Average 12M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_1_M = Value("CHF-SARON Average 1M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_1_W = Value("CHF-SARON Average 1W")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_2_M = Value("CHF-SARON Average 2M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_3_M = Value("CHF-SARON Average 3M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_6_M = Value("CHF-SARON Average 6M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_AVERAGE_9_M = Value("CHF-SARON Average 9M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_COMPOUNDED_INDEX = Value("CHF-SARON Compounded Index")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_OIS_COMPOUND = Value("CHF-SARON-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CHF_SARON_OIS_COMPOUND_1 = Value("CHF-SARON-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_TOIS_OIS_COMPOUND = Value("CHF-TOIS-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CHF_USD_BASIS_SWAPS_11_00_ICAP = Value("CHF USD-Basis Swaps-11:00-ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CLP_ICP = Value("CLP-ICP")
  
  /**
    * Refers to the Indice Camara Promedio ('ICP') rate for Chilean Pesos which, for a Reset Date, is determined and published by the Asociacion de Bancos e Instituciones Financieras de Chile A.G. ('ABIF') in accordance with the 'Reglamento Indice de Camara Promedio' of the ABIF as published in the Diario Oficial de la Republica de Chile (the 'ICP Rules') and which is reported on the ABIF website by not later than 10:00 a.m., Santiago time, on that Reset Date.
    */
  val CLP_TNA = Value("CLP-TNA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CL_CLICP_BLOOMBERG = Value("CL-CLICP-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNH_HIBOR = Value("CNH-HIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNH_HIBOR_REFERENCE_BANKS = Value("CNH-HIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNH_HIBOR_TMA = Value("CNH-HIBOR-TMA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_7_REPO_COMPOUNDING_DATE = Value("CNY 7-Repo Compounding Date")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_CNREPOFIX_CFXS_REUTERS = Value("CNY-CNREPOFIX=CFXS-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_DEPOSIT_RATE = Value("CNY-Deposit Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_FIXING_REPO_RATE = Value("CNY-Fixing Repo Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_LPR = Value("CNY-LPR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_PBOCB_REUTERS = Value("CNY-PBOCB-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_QUARTERLY_7_D_REPO_NDS_RATE_TRADITION = Value("CNY-Quarterly 7D Repo NDS Rate Tradition")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION = Value("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_SHIBOR = Value("CNY-SHIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CNY_SHIBOR_OIS_COMPOUND = Value("CNY-SHIBOR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction..
    */
  val CNY_SHIBOR_REUTERS = Value("CNY-SHIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("CNY-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("CNY-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CNY_SHIBOR_OIS_COMPOUNDING = Value("CNY-Shibor-OIS-Compounding")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val COP_IBR_OIS_COMPOUND = Value("COP-IBR-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val COP_IBR_OIS_COMPOUND_1 = Value("COP-IBR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CZK_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("CZK-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CZK_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("CZK-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CZK_CZEONIA = Value("CZK-CZEONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CZK_CZEONIA_OIS_COMPOUND = Value("CZK-CZEONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val CZK_PRIBOR = Value("CZK-PRIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CZK_PRIBOR_PRBO = Value("CZK-PRIBOR-PRBO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val CZK_PRIBOR_REFERENCE_BANKS = Value("CZK-PRIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR = Value("DKK-CIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR2 = Value("DKK-CIBOR2")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR_2_BLOOMBERG = Value("DKK-CIBOR2-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR2_DKNA13 = Value("DKK-CIBOR2-DKNA13")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR_DKNA13 = Value("DKK-CIBOR-DKNA13")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR_DKNA_13_BLOOMBERG = Value("DKK-CIBOR-DKNA13-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CIBOR_REFERENCE_BANKS = Value("DKK-CIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_CITA = Value("DKK-CITA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_CITA_DKNA14_COMPOUND = Value("DKK-CITA-DKNA14-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_DESTR = Value("DKK-DESTR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_DESTR_COMPOUNDED_INDEX = Value("DKK-DESTR Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_DESTR_OIS_COMPOUND = Value("DKK-DESTR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val DKK_DKKOIS_OIS_COMPOUND = Value("DKK-DKKOIS-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val DKK_TOM_NEXT_OIS_COMPOUND = Value("DKK-Tom Next-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP = Value("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP = Value("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG = Value("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP = Value("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP = Value("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG = Value("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00 = Value("EUR-Annual Swap Rate-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00_BGCANTOR = Value("EUR-Annual Swap Rate-10:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00_BLOOMBERG = Value("EUR-Annual Swap Rate-10:00-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00_ICAP = Value("EUR-Annual Swap Rate-10:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00_SWAP_MARKER = Value("EUR-Annual Swap Rate-10:00-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_10_00_TRADITION = Value("EUR-Annual Swap Rate-10:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_11_00 = Value("EUR-Annual Swap Rate-11:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_11_00_BLOOMBERG = Value("EUR-Annual Swap Rate-11:00-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_11_00_ICAP = Value("EUR-Annual Swap Rate-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_11_00_SWAP_MARKER = Value("EUR-Annual Swap Rate-11:00-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_3_MONTH = Value("EUR-Annual Swap Rate-3 Month")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_3_MONTH_SWAP_MARKER = Value("EUR-Annual Swap Rate-3 Month-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_4_15_TRADITION = Value("EUR-Annual Swap Rate-4:15-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("EUR-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_BASIS_SWAP_EONIA_VS_3_M_EUR_IBOR_SWAP_RATES_A_360_10_00_ICAP = Value("EUR Basis Swap-EONIA vs 3m EUR+IBOR Swap Rates-A/360-10:00-ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_CNO_TEC10 = Value("EUR-CNO TEC10")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA = Value("EUR-EONIA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_AVERAGE_1 = Value("EUR-EONIA-AVERAGE")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_AVERAGE = Value("EUR-EONIA-Average")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_10_00_BGCANTOR = Value("EUR-EONIA-OIS-10:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_10_00_ICAP = Value("EUR-EONIA-OIS-10:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_10_00_TRADITION = Value("EUR-EONIA-OIS-10:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_11_00_ICAP = Value("EUR-EONIA-OIS-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_4_15_TRADITION = Value("EUR-EONIA-OIS-4:15-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_COMPOUND = Value("EUR-EONIA-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_COMPOUND_BLOOMBERG = Value("EUR-EONIA-OIS-COMPOUND-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_OIS_COMPOUND_1 = Value("EUR-EONIA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EONIA_SWAP_INDEX = Value("EUR-EONIA-Swap-Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR = Value("EUR-EURIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_ACT_365 = Value("EUR-EURIBOR-Act/365")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_ACT_365_BLOOMBERG = Value("EUR-EURIBOR-Act/365-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_ANNUAL_BOND_SWAP_VS_1_M_11_00_ICAP = Value("EUR EURIBOR-Annual Bond Swap vs 1m-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_BASIS_SWAP_1_M_VS_3_M_EURIBOR_11_00_ICAP = Value("EUR EURIBOR-Basis Swap-1m vs 3m-Euribor-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_BASIS_SWAP_3_M_VS_6_M_11_00_ICAP = Value("EUR EURIBOR-Basis Swap-3m vs 6m-11:00-ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_ICE_SWAP_RATE_11_00 = Value("EUR-EURIBOR ICE Swap Rate-11:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_ICE_SWAP_RATE_12_00 = Value("EUR-EURIBOR ICE Swap Rate-12:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_REFERENCE_BANKS = Value("EUR-EURIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_REUTERS = Value("EUR-EURIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURIBOR_TELERATE = Value("EUR-EURIBOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURONIA_OIS_COMPOUND = Value("EUR-EURONIA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURONIA_OIS_COMPOUND_1 = Value("EUR-EURONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR = Value("EUR-EuroSTR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_AVERAGE_12_M = Value("EUR-EuroSTR Average 12M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_AVERAGE_1_M = Value("EUR-EuroSTR Average 1M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_AVERAGE_1_W = Value("EUR-EuroSTR Average 1W")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_AVERAGE_3_M = Value("EUR-EuroSTR Average 3M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_AVERAGE_6_M = Value("EUR-EuroSTR Average 6M")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_COMPOUND = Value("EUR-EuroSTR-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_COMPOUNDED_INDEX = Value("EUR-EuroSTR Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_FTSE_TERM = Value("EUR-EuroSTR FTSE Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX = Value("EUR-EuroSTR ICE Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR = Value("EUR-EuroSTR ICE Compounded Index 0 Floor")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG = Value("EUR-EuroSTR ICE Compounded Index 0 Floor 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG = Value("EUR-EuroSTR ICE Compounded Index 0 Floor 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX_2_D_LAG = Value("EUR-EuroSTR ICE Compounded Index 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_COMPOUNDED_INDEX_5_D_LAG = Value("EUR-EuroSTR ICE Compounded Index 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_ICE_SWAP_RATE = Value("EUR-EuroSTR ICE Swap Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_OIS_COMPOUND = Value("EUR-EuroSTR-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_EURO_STR_TERM = Value("EUR-EuroSTR Term")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ISDA_EURIBOR_SWAP_RATE_11_00 = Value("EUR-ISDA-EURIBOR Swap Rate-11:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ISDA_EURIBOR_SWAP_RATE_12_00 = Value("EUR-ISDA-EURIBOR Swap Rate-12:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ISDA_LIBOR_SWAP_RATE_10_00 = Value("EUR-ISDA-LIBOR Swap Rate-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_ISDA_LIBOR_SWAP_RATE_11_00 = Value("EUR-ISDA-LIBOR Swap Rate-11:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val EUR_LIBOR = Value("EUR-LIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_LIBOR_BBA = Value("EUR-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_LIBOR_BBA_BLOOMBERG = Value("EUR-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_LIBOR_REFERENCE_BANKS = Value("EUR-LIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TAM_CDC = Value("EUR-TAM-CDC")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC10_CNO = Value("EUR-TEC10-CNO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC_10_CNO_SWAP_MARKER = Value("EUR-TEC10-CNO-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC_10_REFERENCE_BANKS = Value("EUR-TEC10-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC5_CNO = Value("EUR-TEC5-CNO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC_5_CNO_SWAP_MARKER = Value("EUR-TEC5-CNO-SwapMarker")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TEC_5_REFERENCE_BANKS = Value("EUR-TEC5-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_TMM_CDC_COMPOUND = Value("EUR-TMM-CDC-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val EUR_USD_BASIS_SWAPS_11_00_ICAP = Value("EUR USD-Basis Swaps-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP = Value("GBP-6M LIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("GBP-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP = Value("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG = Value("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_ISDA_SWAP_RATE = Value("GBP-ISDA-Swap Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR = Value("GBP-LIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR_BBA = Value("GBP-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR_BBA_BLOOMBERG = Value("GBP-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR_ICE_SWAP_RATE = Value("GBP-LIBOR ICE Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR_ISDA = Value("GBP-LIBOR-ISDA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_LIBOR_REFERENCE_BANKS = Value("GBP-LIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_RONIA = Value("GBP-RONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_RONIA_OIS_COMPOUND = Value("GBP-RONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA = Value("GBP-SONIA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_COMPOUND = Value("GBP-SONIA-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_COMPOUNDED_INDEX = Value("GBP-SONIA Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_FTSE_TERM = Value("GBP-SONIA FTSE Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX = Value("GBP-SONIA ICE Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR = Value("GBP-SONIA ICE Compounded Index 0 Floor")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG = Value("GBP-SONIA ICE Compounded Index 0 Floor 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG = Value("GBP-SONIA ICE Compounded Index 0 Floor 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX_2_D_LAG = Value("GBP-SONIA ICE Compounded Index 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_COMPOUNDED_INDEX_5_D_LAG = Value("GBP-SONIA ICE Compounded Index 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_SWAP_RATE = Value("GBP-SONIA ICE Swap Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_ICE_TERM = Value("GBP-SONIA ICE Term")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_OIS_11_00_ICAP = Value("GBP-SONIA-OIS-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_OIS_11_00_TRADITION = Value("GBP-SONIA-OIS-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_OIS_4_15_TRADITION = Value("GBP-SONIA-OIS-4:15-TRADITION")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_OIS_COMPOUND = Value("GBP-SONIA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SONIA_SWAP_RATE = Value("GBP-SONIA Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE = Value("GBP-Semi-Annual Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE_11_00_ICAP = Value("GBP-Semi-Annual Swap Rate-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("GBP-Semi Annual Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE_4_15_TRADITION = Value("GBP-Semi Annual Swap Rate-4:15-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("GBP-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_SEMI_ANNUAL_SWAP_RATE_SWAP_MARKER_26 = Value("GBP-Semi-Annual Swap Rate-SwapMarker26")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val GBP_UK_BASE_RATE = Value("GBP-UK Base Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_USD_BASIS_SWAPS_11_00_ICAP = Value("GBP USD-Basis Swaps-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_WMBA_RONIA_COMPOUND = Value("GBP-WMBA-RONIA-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GBP_WMBA_SONIA_COMPOUND = Value("GBP-WMBA-SONIA-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GRD_ATHIBOR_ATHIBOR = Value("GRD-ATHIBOR-ATHIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GRD_ATHIBOR_REFERENCE_BANKS = Value("GRD-ATHIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GRD_ATHIBOR_TELERATE = Value("GRD-ATHIBOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GRD_ATHIMID_REFERENCE_BANKS = Value("GRD-ATHIMID-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val GRD_ATHIMID_REUTERS = Value("GRD-ATHIMID-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR = Value("HKD-HIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_HIBOR_ = Value("HKD-HIBOR-HIBOR=")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_HIBOR_BLOOMBERG = Value("HKD-HIBOR-HIBOR-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_HKAB = Value("HKD-HIBOR-HKAB")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_HKAB_BLOOMBERG = Value("HKD-HIBOR-HKAB-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_ISDC = Value("HKD-HIBOR-ISDC")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HIBOR_REFERENCE_BANKS = Value("HKD-HIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HONIA = Value("HKD-HONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val HKD_HONIA_OIS_COMPOUND = Value("HKD-HONIA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_HONIX_OIS_COMPOUND = Value("HKD-HONIX-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_ISDA_SWAP_RATE_11_00 = Value("HKD-ISDA-Swap Rate-11:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_ISDA_SWAP_RATE_4_00 = Value("HKD-ISDA-Swap Rate-4:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("HKD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("HKD-Quarterly-Annual Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_ANNUAL_SWAP_RATE_4_00_BGCANTOR = Value("HKD-Quarterly-Annual Swap Rate-4:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("HKD-Quarterly-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_QUARTERLY_SWAP_RATE_11_00_ICAP = Value("HKD-Quarterly-Quarterly Swap Rate-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_QUARTERLY_SWAP_RATE_4_00_ICAP = Value("HKD-Quarterly-Quarterly Swap Rate-4:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HKD_QUARTERLY_QUARTERLY_SWAP_RATE_REFERENCE_BANKS = Value("HKD-Quarterly-Quarterly Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val HUF_BUBOR = Value("HUF-BUBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HUF_BUBOR_REFERENCE_BANKS = Value("HUF-BUBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val HUF_BUBOR_REUTERS = Value("HUF-BUBOR-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val HUF_HUFONIA = Value("HUF-HUFONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val HUF_HUFONIA_OIS_COMPOUND = Value("HUF-HUFONIA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_IDMA_BLOOMBERG = Value("IDR-IDMA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_IDRFIX = Value("IDR-IDRFIX")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val IDR_INDONIA = Value("IDR-INDONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val IDR_INDONIA_OIS_COMPOUND = Value("IDR-INDONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val IDR_JIBOR = Value("IDR-JIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_JIBOR_REUTERS = Value("IDR-JIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SBI_REUTERS = Value("IDR-SBI-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SOR_REFERENCE_BANKS = Value("IDR-SOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SOR_REUTERS = Value("IDR-SOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SOR_TELERATE = Value("IDR-SOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("IDR-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON = Value("IDR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val IDR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("IDR-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ILS_SHIR = Value("ILS-SHIR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ILS_SHIR_OIS_COMPOUND = Value("ILS-SHIR-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ILS_TELBOR = Value("ILS-TELBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ILS_TELBOR_01_REUTERS = Value("ILS-TELBOR01-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ILS_TELBOR_REFERENCE_BANKS = Value("ILS-TELBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_BMK = Value("INR-BMK")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_CMT = Value("INR-CMT")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_FBIL_MIBOR_OIS_COMPOUND = Value("INR-FBIL-MIBOR-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_INBMK_REUTERS = Value("INR-INBMK-REUTERS")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val INR_MIBOR_OIS = Value("INR-MIBOR OIS")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_MIBOR_OIS_COMPOUND = Value("INR-MIBOR-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val INR_MIBOR_OIS_COMPOUND_1 = Value("INR-MIBOR-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_MIFOR = Value("INR-MIFOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_MIOIS = Value("INR-MIOIS")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_MITOR_OIS_COMPOUND = Value("INR-MITOR-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_MODIFIED_MIFOR = Value("INR-Modified MIFOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_REFERENCE_BANKS = Value("INR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_SEMI_ANNUAL_SWAP_RATE_11_30_BGCANTOR = Value("INR-Semi-Annual Swap Rate-11:30-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON = Value("INR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val INR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("INR-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ISK_REIBOR = Value("ISK-REIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ISK_REIBOR_REFERENCE_BANKS = Value("ISK-REIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ISK_REIBOR_REUTERS = Value("ISK-REIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("JPY-Annual Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_ANNUAL_SWAP_RATE_3_00_TRADITION = Value("JPY-Annual Swap Rate-3:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_BBSF_BLOOMBERG_10_00 = Value("JPY-BBSF-Bloomberg-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_BBSF_BLOOMBERG_15_00 = Value("JPY-BBSF-Bloomberg-15:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_EUROYEN_TIBOR = Value("JPY-Euroyen TIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_ISDA_SWAP_RATE_10_00 = Value("JPY-ISDA-Swap Rate-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_ISDA_SWAP_RATE_15_00 = Value("JPY-ISDA-Swap Rate-15:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR = Value("JPY-LIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_BBA = Value("JPY-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_BBA_BLOOMBERG = Value("JPY-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_FRASETT = Value("JPY-LIBOR-FRASETT")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_ISDA = Value("JPY-LIBOR-ISDA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_REFERENCE_BANKS = Value("JPY-LIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_TSR_10_00 = Value("JPY-LIBOR TSR-10:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_LIBOR_TSR_15_00 = Value("JPY-LIBOR TSR-15:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_LTPR_MHBK = Value("JPY-LTPR MHBK")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LTPR_MHCB = Value("JPY-LTPR-MHCB")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_LTPR_TBC = Value("JPY-LTPR-TBC")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_MUTANCALL_TONAR = Value("JPY-MUTANCALL-TONAR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_OIS_11_00_ICAP = Value("JPY-OIS-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_OIS_11_00_TRADITION = Value("JPY-OIS-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_OIS_3_00_TRADITION = Value("JPY-OIS-3:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_QUOTING_BANKS_LIBOR = Value("JPY-Quoting Banks-LIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_STPR_QUOTING_BANKS = Value("JPY-STPR-Quoting Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR = Value("JPY-TIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_17096 = Value("JPY-TIBOR-17096")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_17097 = Value("JPY-TIBOR-17097")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_DTIBOR01 = Value("JPY-TIBOR-DTIBOR01")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM = Value("JPY-TIBOR-TIBM")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM_REFERENCE_BANKS = Value("JPY-TIBOR-TIBM-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM_10_BANKS = Value("JPY-TIBOR-TIBM (10 Banks)")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM_5_BANKS = Value("JPY-TIBOR-TIBM (5 Banks)")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM_ALL_BANKS = Value("JPY-TIBOR-TIBM (All Banks)")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_TIBM_ALL_BANKS_BLOOMBERG = Value("JPY-TIBOR-TIBM (All Banks)-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TIBOR_ZTIBOR = Value("JPY-TIBOR-ZTIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA = Value("JPY-TONA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_AVERAGE_180_D = Value("JPY-TONA Average 180D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_AVERAGE_30_D = Value("JPY-TONA Average 30D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_AVERAGE_90_D = Value("JPY-TONA Average 90D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_COMPOUNDED_INDEX = Value("JPY-TONA Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX = Value("JPY-TONA ICE Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR = Value("JPY-TONA ICE Compounded Index 0 Floor")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG = Value("JPY-TONA ICE Compounded Index 0 Floor 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG = Value("JPY-TONA ICE Compounded Index 0 Floor 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX_2_D_LAG = Value("JPY-TONA ICE Compounded Index 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_ICE_COMPOUNDED_INDEX_5_D_LAG = Value("JPY-TONA ICE Compounded Index 5D Lag")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_OIS_COMPOUND = Value("JPY-TONA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_OIS_COMPOUND_1 = Value("JPY-TONA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_TSR_10_00 = Value("JPY-TONA TSR-10:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TONA_TSR_15_00 = Value("JPY-TONA TSR-15:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TORF_QUICK = Value("JPY-TORF QUICK")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TSR_REFERENCE_BANKS = Value("JPY-TSR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TSR_REUTERS_10_00 = Value("JPY-TSR-Reuters-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TSR_REUTERS_15_00 = Value("JPY-TSR-Reuters-15:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TSR_TELERATE_10_00 = Value("JPY-TSR-Telerate-10:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_TSR_TELERATE_15_00 = Value("JPY-TSR-Telerate-15:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val JPY_USD_BASIS_SWAPS_11_00_ICAP = Value("JPY USD-Basis Swaps-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val KRW_BOND_3222 = Value("KRW-Bond-3222")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val KRW_CD_3220 = Value("KRW-CD-3220")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val KRW_CD_91D = Value("KRW-CD 91D")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val KRW_CD_KSDA_BLOOMBERG = Value("KRW-CD-KSDA-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val KRW_KOFR = Value("KRW-KOFR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val KRW_KOFR_OIS_COMPOUND = Value("KRW-KOFR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val KRW_QUARTERLY_ANNUAL_SWAP_RATE_3_30_ICAP = Value("KRW-Quarterly Annual Swap Rate-3:30-ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE = Value("MXN-TIIE")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_BANXICO = Value("MXN-TIIE-Banxico")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_BANXICO_BLOOMBERG = Value("MXN-TIIE-Banxico-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_BANXICO_REFERENCE_BANKS = Value("MXN-TIIE-Banxico-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_ON = Value("MXN-TIIE ON")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_ON_OIS_COMPOUND = Value("MXN-TIIE ON-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MXN_TIIE_REFERENCE_BANKS = Value("MXN-TIIE-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MYR_KLIBOR = Value("MYR-KLIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MYR_KLIBOR_BNM = Value("MYR-KLIBOR-BNM")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MYR_KLIBOR_REFERENCE_BANKS = Value("MYR-KLIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MYR_MYOR = Value("MYR-MYOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val MYR_MYOR_OIS_COMPOUND = Value("MYR-MYOR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MYR_QUARTERLY_SWAP_RATE_11_00_TRADITION = Value("MYR-Quarterly Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val MYR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("MYR-Quarterly Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR = Value("NOK-NIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR_NIBR = Value("NOK-NIBOR-NIBR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR_NIBR_BLOOMBERG = Value("NOK-NIBOR-NIBR-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR_NIBR_REFERENCE_BANKS = Value("NOK-NIBOR-NIBR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR_OIBOR = Value("NOK-NIBOR-OIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NIBOR_REFERENCE_BANKS = Value("NOK-NIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NOK_NOWA = Value("NOK-NOWA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NOK_NOWA_OIS_COMPOUND = Value("NOK-NOWA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_BBR_BID = Value("NZD-BBR-BID")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_BBR_FRA = Value("NZD-BBR-FRA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_BBR_ISDC = Value("NZD-BBR-ISDC")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_BBR_REFERENCE_BANKS = Value("NZD-BBR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_BBR_TELERATE = Value("NZD-BBR-Telerate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NZD_BKBM_BID = Value("NZD-BKBM Bid")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NZD_BKBM_FRA = Value("NZD-BKBM FRA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NZD_BKBM_FRA_SWAP_RATE_ICAP = Value("NZD-BKBM FRA Swap Rate ICAP")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_NZIONA = Value("NZD-NZIONA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_NZIONA_OIS_COMPOUND = Value("NZD-NZIONA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val NZD_NZIONA_OIS_COMPOUND_1 = Value("NZD-NZIONA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("NZD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS = Value("NZD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_SWAP_RATE_ICAP = Value("NZD-Swap Rate-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val NZD_SWAP_RATE_ICAP_REFERENCE_BANKS = Value("NZD-Swap Rate-ICAP-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PHP_ORR = Value("PHP-ORR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PHP_PHIREF = Value("PHP-PHIREF")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PHP_PHIREF_BAP = Value("PHP-PHIREF-BAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PHP_PHIREF_BLOOMBERG = Value("PHP-PHIREF-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PHP_PHIREF_REFERENCE_BANKS = Value("PHP-PHIREF-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PHP_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("PHP-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PHP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("PHP-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_POLONIA = Value("PLN-POLONIA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PLN_POLONIA_OIS_COMPOUND = Value("PLN-POLONIA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_POLONIA_OIS_COMPOUND_1 = Value("PLN-POLONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIBID = Value("PLN-WIBID")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIBOR = Value("PLN-WIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIBOR_REFERENCE_BANKS = Value("PLN-WIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIBOR_WIBO = Value("PLN-WIBOR-WIBO")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIRON = Value("PLN-WIRON")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val PLN_WIRON_OIS_COMPOUND = Value("PLN-WIRON-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PLZ_WIBOR_REFERENCE_BANKS = Value("PLZ-WIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val PLZ_WIBOR_WIBO = Value("PLZ-WIBOR-WIBO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val REPOFUNDS_RATE_FRANCE_OIS_COMPOUND = Value("REPOFUNDS RATE-FRANCE-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val REPOFUNDS_RATE_GERMANY_OIS_COMPOUND = Value("REPOFUNDS RATE-GERMANY-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val REPOFUNDS_RATE_ITALY_OIS_COMPOUND = Value("REPOFUNDS RATE-ITALY-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RON_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("RON-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RON_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("RON-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RON_RBOR_REUTERS = Value("RON-RBOR-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RON_ROBID = Value("RON-ROBID")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RON_ROBOR = Value("RON-ROBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("RUB-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_ANNUAL_SWAP_RATE_12_45_TRADITION = Value("RUB-Annual Swap Rate-12:45-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_ANNUAL_SWAP_RATE_4_15_TRADITION = Value("RUB-Annual Swap Rate-4:15-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("RUB-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("RUB-Annual Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RUB_KEY_RATE_CBRF = Value("RUB-Key Rate CBRF")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_MOSPRIME_NFEA = Value("RUB-MOSPRIME-NFEA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_MOSPRIME_REFERENCE_BANKS = Value("RUB-MOSPRIME-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RUB_MOS_PRIME = Value("RUB-MosPrime")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RUB_RUONIA = Value("RUB-RUONIA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val RUB_RUONIA_OIS_COMPOUND = Value("RUB-RUONIA-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val RUB_RUONIA_OIS_COMPOUND_1 = Value("RUB-RUONIA-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SAR_SAIBOR = Value("SAR-SAIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SAR_SRIOR_REFERENCE_BANKS = Value("SAR-SRIOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SAR_SRIOR_SUAA = Value("SAR-SRIOR-SUAA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_ANNUAL_SWAP_RATE = Value("SEK-Annual Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_ANNUAL_SWAP_RATE_SESWFI = Value("SEK-Annual Swap Rate-SESWFI")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SIOR_OIS_COMPOUND = Value("SEK-SIOR-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SEK_STIBOR = Value("SEK-STIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_STIBOR_BLOOMBERG = Value("SEK-STIBOR-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SEK_STIBOR_OIS_COMPOUND = Value("SEK-STIBOR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_STIBOR_REFERENCE_BANKS = Value("SEK-STIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_STIBOR_SIDE = Value("SEK-STIBOR-SIDE")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR = Value("SEK-SWESTR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_AVERAGE_1_M = Value("SEK-SWESTR Average 1M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_AVERAGE_1_W = Value("SEK-SWESTR Average 1W")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_AVERAGE_2_M = Value("SEK-SWESTR Average 2M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_AVERAGE_3_M = Value("SEK-SWESTR Average 3M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_AVERAGE_6_M = Value("SEK-SWESTR Average 6M")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_COMPOUNDED_INDEX = Value("SEK-SWESTR Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SEK_SWESTR_OIS_COMPOUND = Value("SEK-SWESTR-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SGD_SIBOR = Value("SGD-SIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SIBOR_REFERENCE_BANKS = Value("SGD-SIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SIBOR_REUTERS = Value("SGD-SIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SIBOR_TELERATE = Value("SGD-SIBOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SONAR_OIS_COMPOUND = Value("SGD-SONAR-OIS-COMPOUND")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SONAR_OIS_VWAP_COMPOUND = Value("SGD-SONAR-OIS-VWAP-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR = Value("SGD-SOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SORA = Value("SGD-SORA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SORA_COMPOUND = Value("SGD-SORA-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val SGD_SORA_OIS_COMPOUND = Value("SGD-SORA-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR_REFERENCE_BANKS = Value("SGD-SOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR_REUTERS = Value("SGD-SOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR_TELERATE = Value("SGD-SOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR_VWAP = Value("SGD-SOR-VWAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SOR_VWAP_REFERENCE_BANKS = Value("SGD-SOR-VWAP-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_11_00_TULLETT_PREBON = Value("SGD-Semi-Annual Currency Basis Swap Rate-11:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_16_00_TULLETT_PREBON = Value("SGD-Semi-Annual Currency Basis Swap Rate-16:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("SGD-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("SGD-Semi-Annual Swap Rate-11.00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TULLETT_PREBON = Value("SGD-Semi-Annual Swap Rate-11:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_16_00_TULLETT_PREBON = Value("SGD-Semi-Annual Swap Rate-16:00-Tullett Prebon")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_ICAP = Value("SGD-Semi-Annual Swap Rate-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS = Value("SGD-Semi-Annual Swap Rate-ICAP-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("SGD-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SGD_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("SGD-Semi-Annual Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SKK_BRIBOR_BRBO = Value("SKK-BRIBOR-BRBO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SKK_BRIBOR_BLOOMBERG = Value("SKK-BRIBOR-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SKK_BRIBOR_NBSK07 = Value("SKK-BRIBOR-NBSK07")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val SKK_BRIBOR_REFERENCE_BANKS = Value("SKK-BRIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_SOR_REFERENCE_BANKS = Value("THB-SOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_SOR_REUTERS = Value("THB-SOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_SOR_TELERATE = Value("THB-SOR-Telerate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("THB-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("THB-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val THB_THBFIX = Value("THB-THBFIX")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_THBFIX_REFERENCE_BANKS = Value("THB-THBFIX-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_THBFIX_REUTERS = Value("THB-THBFIX-Reuters")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_THOR = Value("THB-THOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val THB_THOR_COMPOUND = Value("THB-THOR-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val THB_THOR_OIS_COMPOUND = Value("THB-THOR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("TRY Annual Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_ANNUAL_SWAP_RATE_11_15_BGCANTOR = Value("TRY-Annual Swap Rate-11:15-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("TRY-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("TRY-Semi-Annual Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val TRY_TLREF = Value("TRY-TLREF")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_TLREF_OIS_COMPOUND = Value("TRY-TLREF-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val TRY_TLREF_OIS_COMPOUND_1 = Value("TRY-TLREF-OIS Compound")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val TRY_TRLIBOR = Value("TRY-TRLIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_TRYIBOR_REFERENCE_BANKS = Value("TRY-TRYIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TRY_TRYIBOR_REUTERS = Value("TRY-TRYIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("TWD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("TWD-Quarterly-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_REFERENCE_DEALERS = Value("TWD-Reference Dealers")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_REUTERS_6165 = Value("TWD-Reuters-6165")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TAIBIR01 = Value("TWD-TAIBIR01")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TAIBIR02 = Value("TWD-TAIBIR02")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val TWD_TAIBOR = Value("TWD-TAIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TAIBOR_BLOOMBERG = Value("TWD-TAIBOR-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TAIBOR_REUTERS = Value("TWD-TAIBOR-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TWCPBA = Value("TWD-TWCPBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val TWD_TELERATE_6165 = Value("TWD-Telerate-6165")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val UK_BASE_RATE = Value("UK Base Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP = Value("USD-3M LIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("USD-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP = Value("USD-6M LIBOR SWAP-CME vs LCH-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG = Value("USD-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_AMERIBOR = Value("USD-AMERIBOR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_AMERIBOR_AVERAGE_30_D = Value("USD-AMERIBOR Average 30D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_AMERIBOR_AVERAGE_90_D = Value("USD-AMERIBOR Average 90D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_AMERIBOR_TERM = Value("USD-AMERIBOR Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_AMERIBOR_TERM_STRUCTURE = Value("USD-AMERIBOR Term Structure")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_AXI_TERM = Value("USD-AXI Term")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("USD-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ANNUAL_SWAP_RATE_11_00_TRADITION = Value("USD-Annual Swap Rate-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ANNUAL_SWAP_RATE_4_00_TRADITION = Value("USD-Annual Swap Rate-4:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_BA_H_15 = Value("USD-BA-H.15")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_BA_REFERENCE_DEALERS = Value("USD-BA-Reference Dealers")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_BMA_MUNICIPAL_SWAP_INDEX = Value("USD-BMA Municipal Swap Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_BSBY = Value("USD-BSBY")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CD_H_15 = Value("USD-CD-H.15")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CD_REFERENCE_DEALERS = Value("USD-CD-Reference Dealers")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMS_REFERENCE_BANKS = Value("USD-CMS-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMS_REFERENCE_BANKS_ICAP_SWAP_PX = Value("USD-CMS-Reference Banks-ICAP SwapPX")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMS_REUTERS = Value("USD-CMS-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMS_TELERATE = Value("USD-CMS-Telerate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_CMT = Value("USD-CMT")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_CMT_AVERAGE_1_W = Value("USD-CMT Average 1W")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMT_T7051 = Value("USD-CMT-T7051")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CMT_T7052 = Value("USD-CMT-T7052")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_COF11_FHLBSF = Value("USD-COF11-FHLBSF")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_COF_11_REUTERS = Value("USD-COF11-Reuters")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_COF_11_TELERATE = Value("USD-COF11-Telerate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_COFI = Value("USD-COFI")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CP_H_15 = Value("USD-CP-H.15")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_CP_MONEY_MARKET_YIELD = Value("USD-CP-Money Market Yield")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CP_REFERENCE_DEALERS = Value("USD-CP-Reference Dealers")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_CRITR = Value("USD-CRITR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_FFCB_DISCO = Value("USD-FFCB-DISCO")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_FXI_TERM = Value("USD-FXI Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS = Value("USD-Federal Funds")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS_H_15 = Value("USD-Federal Funds-H.15")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS_H_15_BLOOMBERG = Value("USD-Federal Funds-H.15-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS_H_15_OIS_COMPOUND = Value("USD-Federal Funds-H.15-OIS-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS_OIS_COMPOUND = Value("USD-Federal Funds-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_FEDERAL_FUNDS_REFERENCE_DEALERS = Value("USD-Federal Funds-Reference Dealers")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ISDAFIX_3_SWAP_RATE = Value("USD-ISDAFIX3-Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ISDAFIX_3_SWAP_RATE_3_00 = Value("USD-ISDAFIX3-Swap Rate-3:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ISDA_SWAP_RATE = Value("USD-ISDA-Swap Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_ISDA_SWAP_RATE_3_00 = Value("USD-ISDA-Swap Rate-3:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR = Value("USD-LIBOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_BBA = Value("USD-LIBOR-BBA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_BBA_BLOOMBERG = Value("USD-LIBOR-BBA-Bloomberg")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_ICE_SWAP_RATE_11_00 = Value("USD-LIBOR ICE Swap Rate-11:00")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_ICE_SWAP_RATE_15_00 = Value("USD-LIBOR ICE Swap Rate-15:00")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_ISDA = Value("USD-LIBOR-ISDA")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_LIBO = Value("USD-LIBOR-LIBO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_LIBOR_REFERENCE_BANKS = Value("USD-LIBOR-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_MUNICIPAL_SWAP_INDEX = Value("USD-Municipal Swap Index")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_MUNICIPAL_SWAP_LIBOR_RATIO_11_00_ICAP = Value("USD-Municipal Swap Libor Ratio-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_MUNICIPAL_SWAP_RATE_11_00_ICAP = Value("USD-Municipal Swap Rate-11:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_11_00_BGCANTOR = Value("USD-OIS-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_11_00_LON_ICAP = Value("USD-OIS-11:00-LON-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_11_00_NY_ICAP = Value("USD-OIS-11:00-NY-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_11_00_TRADITION = Value("USD-OIS-11:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_3_00_BGCANTOR = Value("USD-OIS-3:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_3_00_NY_ICAP = Value("USD-OIS-3:00-NY-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OIS_4_00_TRADITION = Value("USD-OIS-4:00-TRADITION")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_OVERNIGHT_BANK_FUNDING_RATE = Value("USD-Overnight Bank Funding Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_PRIME = Value("USD-Prime")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_PRIME_H_15 = Value("USD-Prime-H.15")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_PRIME_REFERENCE_BANKS = Value("USD-Prime-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SIBOR_REFERENCE_BANKS = Value("USD-SIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SIBOR_SIBO = Value("USD-SIBOR-SIBO")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SIFMA_MUNICIPAL_SWAP_INDEX = Value("USD-SIFMA Municipal Swap Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR = Value("USD-SOFR")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_AVERAGE_180_D = Value("USD-SOFR Average 180D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_AVERAGE_30_D = Value("USD-SOFR Average 30D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_AVERAGE_90_D = Value("USD-SOFR Average 90D")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_CME_TERM = Value("USD-SOFR CME Term")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_COMPOUND = Value("USD-SOFR-COMPOUND")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_COMPOUNDED_INDEX = Value("USD-SOFR Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX = Value("USD-SOFR ICE Compounded Index")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR = Value("USD-SOFR ICE Compounded Index 0 Floor")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG = Value("USD-SOFR ICE Compounded Index 0 Floor 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG = Value("USD-SOFR ICE Compounded Index 0 Floor 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX_2_D_LAG = Value("USD-SOFR ICE Compounded Index 2D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_COMPOUNDED_INDEX_5_D_LAG = Value("USD-SOFR ICE Compounded Index 5D Lag")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_SWAP_RATE = Value("USD-SOFR ICE Swap Rate")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_SWAP_RATE_SPREADS = Value("USD-SOFR ICE Swap Rate Spreads")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_ICE_TERM = Value("USD-SOFR ICE Term")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_SOFR_OIS_COMPOUND = Value("USD-SOFR-OIS Compound")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_S_P_INDEX_HIGH_GRADE = Value("USD-S&P Index-High Grade")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_SAND_P_INDEX_HIGH_GRADE = Value("USD-SandP Index High Grade")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_SWAP_RATE_BCMP_1 = Value("USD Swap Rate-BCMP1")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_TBILL_AUCTION_HIGH_RATE = Value("USD-TBILL Auction High Rate")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TBILL_H_15 = Value("USD-TBILL-H.15")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TBILL_H_15_BLOOMBERG = Value("USD-TBILL-H.15-Bloomberg")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TBILL_SECONDARY_MARKET = Value("USD-TBILL-Secondary Market")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val USD_TBILL_SECONDARY_MARKET_BOND_EQUIVALENT_YIELD = Value("USD-TBILL Secondary Market-Bond Equivalent Yield")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TIBOR_ISDC = Value("USD-TIBOR-ISDC")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TIBOR_REFERENCE_BANKS = Value("USD-TIBOR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_19901_3_00_ICAP = Value("USD-Treasury-19901-3:00-ICAP")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_BCMP_1 = Value("USD Treasury Rate-BCMP1")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_ICAP_BROKER_TEC = Value("USD-Treasury Rate-ICAP BrokerTec")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_SWAP_MARKER_100 = Value("USD-Treasury Rate-SwapMarker100")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_SWAP_MARKER_99 = Value("USD-Treasury Rate-SwapMarker99")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_T_19901 = Value("USD-Treasury Rate-T19901")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val USD_TREASURY_RATE_T_500 = Value("USD-Treasury Rate-T500")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val VND_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR = Value("VND-Semi-Annual Swap Rate-11:00-BGCANTOR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val VND_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS = Value("VND-Semi-Annual Swap Rate-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_DEPOSIT_REFERENCE_BANKS = Value("ZAR-DEPOSIT-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_DEPOSIT_SAFEX = Value("ZAR-DEPOSIT-SAFEX")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ZAR_JIBAR = Value("ZAR-JIBAR")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_JIBAR_REFERENCE_BANKS = Value("ZAR-JIBAR-Reference Banks")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_JIBAR_SAFEX = Value("ZAR-JIBAR-SAFEX")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_PRIME_AVERAGE = Value("ZAR-PRIME-AVERAGE")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_PRIME_AVERAGE_REFERENCE_BANKS = Value("ZAR-PRIME-AVERAGE-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ZAR_PRIME_AVERAGE_1 = Value("ZAR-Prime Average")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_QUARTERLY_SWAP_RATE_1_00_TRADITION = Value("ZAR-Quarterly Swap Rate-1:00-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_QUARTERLY_SWAP_RATE_5_30_TRADITION = Value("ZAR-Quarterly Swap Rate-5:30-TRADITION")
  
  /**
    * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
    */
  val ZAR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS = Value("ZAR-Quarterly Swap Rate-TRADITION-Reference Banks")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ZAR_ZARONIA = Value("ZAR-ZARONIA")
  
  /**
    * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
    */
  val ZAR_ZARONIA_OIS_COMPOUND = Value("ZAR-ZARONIA-OIS Compound")
}

/**
  * This enumeration provides guidance on how to process a given floating rate index.  It's based on the ISDA Floating Rate Index information, but transforms it into the specific categories needed for calculation 
  */
object FloatingRateIndexProcessingTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A published index calculated using compounding; the implied rate must be backed out.
    */
  val COMPOUND_INDEX = Value
  
  /**
    * These are calculated by the calculation agent based on deal-specific parameters (e.g. lookback compound based on an RFR).
    */
  val MODULAR = Value
  
  /**
    * These are calculated by the calculation agent based on a standard OIS FRO definition.
    */
  val OIS = Value
  
  /**
    * These are calculated by the calculation agent based on a standard overnight averaging FRO definition.
    */
  val OVERNIGHT_AVG = Value
  
  /**
    * These must be looked up using a manual process
    */
  val REF_BANKS = Value
  
  /**
    * These values are just looked up from the screen and applied.
    */
  val SCREEN = Value
}

/**
  * Second level ISDA FRO category.
  */
object FloatingRateIndexStyleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * An ISDA-defined calculated rate done using arithmetic averaging.
    */
  val AVERAGE_FRO = Value("Average FRO")
  
  /**
    * An ISDA-defined calculated rate done using arithmetic averaging.
    */
  val COMPOUNDED_FRO = Value("Compounded FRO")
  
  /**
    * A published index calculated using compounding.
    */
  val COMPOUNDED_INDEX = Value("Compounded Index")
  
  /**
    * A published index using a methodology defined by the publisher, e.g. S&P 500.
    */
  val INDEX = Value("Index")
  
  val OTHER = Value("Other")
  
  val OVERNIGHT = Value("Overnight Rate")
  
  /**
    *  A published rate computed using an averaging methodology.
    */
  val PUBLISHED_AVERAGE = Value("Published Average Rate")
  
  val SPECIFIED_FORMULA = Value("Specified Formula")
  
  /**
    * A rate representing the market rate for swaps of a given maturity.
    */
  val SWAP_RATE = Value("Swap Rate")
  
  /**
    * A rate specified over a given term, such as a libor-type rate.
    */
  val TERM_RATE = Value("Term Rate")
}

/**
  * Represents an enumeration list to identify the fund product type.
  */
object FundProductTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange.
    */
  val EXCHANGE_TRADED_FUND = Value
  
  /**
    * Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity.
    */
  val MONEY_MARKET_FUND = Value
  
  /**
    * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager.
    */
  val MUTUAL_FUND = Value
  
  /**
    * Denotes a fund that is not an Exchange Traded Fund, Money Market Fund or Mutual Fund.
    */
  val OTHER_FUND = Value
}

/**
  * The enumerated values to specify the law governing the contract or legal document.
  */
object GoverningLawEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Governing Law is determined by reference to the relevant master agreement.
    */
  val AS_SPECIFIED_IN_MASTER_AGREEMENT = Value
  
  /**
    * Belgian law
    */
  val BE = Value
  
  /**
    * Alberta law
    */
  val CAAB = Value
  
  /**
    * British Columbia Law
    */
  val CABC = Value
  
  /**
    * Manitoba law
    */
  val CAMN = Value
  
  /**
    * Ontario law
    */
  val CAON = Value
  
  /**
    * Quebec law
    */
  val CAQC = Value
  
  /**
    * German law
    */
  val DE = Value
  
  /**
    * French law
    */
  val FR = Value
  
  /**
    * English law
    */
  val GBEN = Value
  
  /**
    * The law of the island of Guernsey
    */
  val GBGY = Value
  
  /**
    * The law of the Isle of Man
    */
  val GBIM = Value
  
  /**
    * The law of the island of Jersey
    */
  val GBJY = Value
  
  /**
    * Scottish law
    */
  val GBSC = Value
  
  /**
    * Irish law
    */
  val IE = Value
  
  /**
    * Japanese law
    */
  val JP = Value
  
  /**
    * Luxembourg law
    */
  val LU = Value
  
  /**
    * As agreed in the ISDA Master Agreement
    */
  val RELATED_MASTER_AGREEMENT = Value
  
  /**
    * Californian law
    */
  val USCA = Value
  
  /**
    * Delaware law
    */
  val USDE = Value
  
  /**
    * Illinois law
    */
  val USIL = Value
  
  /**
    * New York law
    */
  val USNY = Value
}

/**
  * Represents the enumeration indicators to specify if an asset or group of assets valuation is based on any valuation treatment haircut.
  */
object HaircutIndicatorEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates Post haircut value
    */
  val POST_HAIRCUT = Value
  
  /**
    * Indicates Pre haircut value
    */
  val PRE_HAIRCUT = Value
}

/**
  * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO). The set of codes in this enumerated list is sourced from ISO Standard 3166 (ISO-3166-1alpha-2)(https://www.iso.org/iso-3166-country-codes.html) as at 14-Aug-23.
  */
object ISOCountryCodeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Andorra
    */
  val AD = Value
  
  /**
    * United Arab Emirates (the)
    */
  val AE = Value
  
  /**
    * Afghanistan
    */
  val AF = Value
  
  /**
    * Antigua and Barbuda
    */
  val AG = Value
  
  /**
    * Anguilla
    */
  val AI = Value
  
  /**
    * Albania
    */
  val AL = Value
  
  /**
    * Armenia
    */
  val AM = Value
  
  /**
    * Angola
    */
  val AO = Value
  
  /**
    * Antarctica
    */
  val AQ = Value
  
  /**
    * Argentina
    */
  val AR = Value
  
  /**
    * American Samoa
    */
  val AS = Value
  
  /**
    * Austria
    */
  val AT = Value
  
  /**
    * Australia
    */
  val AU = Value
  
  /**
    * Aruba
    */
  val AW = Value
  
  /**
    * Aland Islands
    */
  val AX = Value
  
  /**
    * Azerbaijan
    */
  val AZ = Value
  
  /**
    * Bosnia and Herzegovina
    */
  val BA = Value
  
  /**
    * Barbados
    */
  val BB = Value
  
  /**
    * Bangladesh
    */
  val BD = Value
  
  /**
    * Belgium
    */
  val BE = Value
  
  /**
    * Burkina Faso
    */
  val BF = Value
  
  /**
    * Bulgaria
    */
  val BG = Value
  
  /**
    * Bahrain
    */
  val BH = Value
  
  /**
    * Burundi
    */
  val BI = Value
  
  /**
    * Benin
    */
  val BJ = Value
  
  /**
    * Saint Barthlemy
    */
  val BL = Value
  
  /**
    * Bermuda
    */
  val BM = Value
  
  /**
    * Brunei Darussalam
    */
  val BN = Value
  
  /**
    * Bolivia (Plurinational State of)
    */
  val BO = Value
  
  /**
    * Bonaire, Sint Eustatius and Saba
    */
  val BQ = Value
  
  /**
    * Brazil
    */
  val BR = Value
  
  /**
    * Bahamas (the)
    */
  val BS = Value
  
  /**
    * Bhutan
    */
  val BT = Value
  
  /**
    * Bouvet Island
    */
  val BV = Value
  
  /**
    * Botswana
    */
  val BW = Value
  
  /**
    * Belarus
    */
  val BY = Value
  
  /**
    * Belize
    */
  val BZ = Value
  
  /**
    * Canada
    */
  val CA = Value
  
  /**
    * Cocos (Keeling) Islands (the)
    */
  val CC = Value
  
  /**
    * Congo (the Democratic Republic of the)
    */
  val CD = Value
  
  /**
    * Central African Republic (the)
    */
  val CF = Value
  
  /**
    * Congo (the)
    */
  val CG = Value
  
  /**
    * Switzerland
    */
  val CH = Value
  
  /**
    * Cte d'Ivoire
    */
  val CI = Value
  
  /**
    * Cook Islands (the)
    */
  val CK = Value
  
  /**
    * Chile
    */
  val CL = Value
  
  /**
    * Cameroon
    */
  val CM = Value
  
  /**
    * China
    */
  val CN = Value
  
  /**
    * Colombia
    */
  val CO = Value
  
  /**
    * Costa Rica
    */
  val CR = Value
  
  /**
    * Cuba
    */
  val CU = Value
  
  /**
    * Cabo Verde
    */
  val CV = Value
  
  /**
    * Curaao
    */
  val CW = Value
  
  /**
    * Christmas Island
    */
  val CX = Value
  
  /**
    * Cyprus
    */
  val CY = Value
  
  /**
    * Czechia
    */
  val CZ = Value
  
  /**
    * Germany
    */
  val DE = Value
  
  /**
    * Djibouti
    */
  val DJ = Value
  
  /**
    * Denmark
    */
  val DK = Value
  
  /**
    * Dominica
    */
  val DM = Value
  
  /**
    * Dominican Republic (the)
    */
  val DO = Value
  
  /**
    * Algeria
    */
  val DZ = Value
  
  /**
    * Ecuador
    */
  val EC = Value
  
  /**
    * Estonia
    */
  val EE = Value
  
  /**
    * Egypt
    */
  val EG = Value
  
  /**
    * Western Sahara*
    */
  val EH = Value
  
  /**
    * Eritrea
    */
  val ER = Value
  
  /**
    * Spain
    */
  val ES = Value
  
  /**
    * Ethiopia
    */
  val ET = Value
  
  /**
    * Finland
    */
  val FI = Value
  
  /**
    * Fiji
    */
  val FJ = Value
  
  /**
    * Falkland Islands (the) [Malvinas]
    */
  val FK = Value
  
  /**
    * Micronesia (Federated States of)
    */
  val FM = Value
  
  /**
    * Faroe Islands (the)
    */
  val FO = Value
  
  /**
    * France
    */
  val FR = Value
  
  /**
    * Gabon
    */
  val GA = Value
  
  /**
    * United Kingdom of Great Britain and Northern Ireland (the)
    */
  val GB = Value
  
  /**
    * Grenada
    */
  val GD = Value
  
  /**
    * Georgia
    */
  val GE = Value
  
  /**
    * French Guiana
    */
  val GF = Value
  
  /**
    * Guernsey
    */
  val GG = Value
  
  /**
    * Ghana
    */
  val GH = Value
  
  /**
    * Gibraltar
    */
  val GI = Value
  
  /**
    * Greenland
    */
  val GL = Value
  
  /**
    * Gambia (the)
    */
  val GM = Value
  
  /**
    * Guinea
    */
  val GN = Value
  
  /**
    * Guadeloupe
    */
  val GP = Value
  
  /**
    * Equatorial Guinea
    */
  val GQ = Value
  
  /**
    * Greece
    */
  val GR = Value
  
  /**
    * South Georgia and the South Sandwich Islands
    */
  val GS = Value
  
  /**
    * Guatemala
    */
  val GT = Value
  
  /**
    * Guam
    */
  val GU = Value
  
  /**
    * Guinea-Bissau
    */
  val GW = Value
  
  /**
    * Guyana
    */
  val GY = Value
  
  /**
    * Hong Kong
    */
  val HK = Value
  
  /**
    * Heard Island and McDonald Islands
    */
  val HM = Value
  
  /**
    * Honduras
    */
  val HN = Value
  
  /**
    * Croatia
    */
  val HR = Value
  
  /**
    * Haiti
    */
  val HT = Value
  
  /**
    * Hungary
    */
  val HU = Value
  
  /**
    * Indonesia
    */
  val ID = Value
  
  /**
    * Ireland
    */
  val IE = Value
  
  /**
    * Israel
    */
  val IL = Value
  
  /**
    * Isle of Man
    */
  val IM = Value
  
  /**
    * India
    */
  val IN = Value
  
  /**
    * British Indian Ocean Territory (the)
    */
  val IO = Value
  
  /**
    * Iraq
    */
  val IQ = Value
  
  /**
    * Iran (Islamic Republic of)
    */
  val IR = Value
  
  /**
    * Iceland
    */
  val IS = Value
  
  /**
    * Italy
    */
  val IT = Value
  
  /**
    * Jersey
    */
  val JE = Value
  
  /**
    * Jamaica
    */
  val JM = Value
  
  /**
    * Jordan
    */
  val JO = Value
  
  /**
    * Japan
    */
  val JP = Value
  
  /**
    * Kenya
    */
  val KE = Value
  
  /**
    * Kyrgyzstan
    */
  val KG = Value
  
  /**
    * Cambodia
    */
  val KH = Value
  
  /**
    * Kiribati
    */
  val KI = Value
  
  /**
    * Comoros (the)
    */
  val KM = Value
  
  /**
    * Saint Kitts and Nevis
    */
  val KN = Value
  
  /**
    * Korea (the Democratic People's Republic of)
    */
  val KP = Value
  
  /**
    * Korea (the Republic of)
    */
  val KR = Value
  
  /**
    * Kuwait
    */
  val KW = Value
  
  /**
    * Cayman Islands (the)
    */
  val KY = Value
  
  /**
    * Kazakhstan
    */
  val KZ = Value
  
  /**
    * Lao People's Democratic Republic (the)
    */
  val LA = Value
  
  /**
    * Lebanon
    */
  val LB = Value
  
  /**
    * Saint Lucia
    */
  val LC = Value
  
  /**
    * Liechtenstein
    */
  val LI = Value
  
  /**
    * Sri Lanka
    */
  val LK = Value
  
  /**
    * Liberia
    */
  val LR = Value
  
  /**
    * Lesotho
    */
  val LS = Value
  
  /**
    * Lithuania
    */
  val LT = Value
  
  /**
    * Luxembourg
    */
  val LU = Value
  
  /**
    * Latvia
    */
  val LV = Value
  
  /**
    * Libya
    */
  val LY = Value
  
  /**
    * Morocco
    */
  val MA = Value
  
  /**
    * Monaco
    */
  val MC = Value
  
  /**
    * Moldova (the Republic of)
    */
  val MD = Value
  
  /**
    * Montenegro
    */
  val ME = Value
  
  /**
    * Saint Martin (French part)
    */
  val MF = Value
  
  /**
    * Madagascar
    */
  val MG = Value
  
  /**
    * Marshall Islands (the)
    */
  val MH = Value
  
  /**
    * North Macedonia
    */
  val MK = Value
  
  /**
    * Mali
    */
  val ML = Value
  
  /**
    * Myanmar
    */
  val MM = Value
  
  /**
    * Mongolia
    */
  val MN = Value
  
  /**
    * Macao
    */
  val MO = Value
  
  /**
    * Northern Mariana Islands (the)
    */
  val MP = Value
  
  /**
    * Martinique
    */
  val MQ = Value
  
  /**
    * Mauritania
    */
  val MR = Value
  
  /**
    * Montserrat
    */
  val MS = Value
  
  /**
    * Malta
    */
  val MT = Value
  
  /**
    * Mauritius
    */
  val MU = Value
  
  /**
    * Maldives
    */
  val MV = Value
  
  /**
    * Malawi
    */
  val MW = Value
  
  /**
    * Mexico
    */
  val MX = Value
  
  /**
    * Malaysia
    */
  val MY = Value
  
  /**
    * Mozambique
    */
  val MZ = Value
  
  /**
    * Namibia
    */
  val NA = Value
  
  /**
    * New Caledonia
    */
  val NC = Value
  
  /**
    * Niger (the)
    */
  val NE = Value
  
  /**
    * Norfolk Island
    */
  val NF = Value
  
  /**
    * Nigeria
    */
  val NG = Value
  
  /**
    * Nicaragua
    */
  val NI = Value
  
  /**
    * Netherlands (Kingdom of the)
    */
  val NL = Value
  
  /**
    * Norway
    */
  val NO = Value
  
  /**
    * Nepal
    */
  val NP = Value
  
  /**
    * Nauru
    */
  val NR = Value
  
  /**
    * Niue
    */
  val NU = Value
  
  /**
    * New Zealand
    */
  val NZ = Value
  
  /**
    * Oman
    */
  val OM = Value
  
  /**
    * Panama
    */
  val PA = Value
  
  /**
    * Peru
    */
  val PE = Value
  
  /**
    * French Polynesia
    */
  val PF = Value
  
  /**
    * Papua New Guinea
    */
  val PG = Value
  
  /**
    * Philippines (the)
    */
  val PH = Value
  
  /**
    * Pakistan
    */
  val PK = Value
  
  /**
    * Poland
    */
  val PL = Value
  
  /**
    * Saint Pierre and Miquelon
    */
  val PM = Value
  
  /**
    * Pitcairn
    */
  val PN = Value
  
  /**
    * Puerto Rico
    */
  val PR = Value
  
  /**
    * Palestine, State of
    */
  val PS = Value
  
  /**
    * Portugal
    */
  val PT = Value
  
  /**
    * Palau
    */
  val PW = Value
  
  /**
    * Paraguay
    */
  val PY = Value
  
  /**
    * Qatar
    */
  val QA = Value
  
  /**
    * Runion
    */
  val RE = Value
  
  /**
    * Romania
    */
  val RO = Value
  
  /**
    * Serbia
    */
  val RS = Value
  
  /**
    * Russian Federation (the)
    */
  val RU = Value
  
  /**
    * Rwanda
    */
  val RW = Value
  
  /**
    * Saudi Arabia
    */
  val SA = Value
  
  /**
    * Solomon Islands
    */
  val SB = Value
  
  /**
    * Seychelles
    */
  val SC = Value
  
  /**
    * Sudan (the)
    */
  val SD = Value
  
  /**
    * Sweden
    */
  val SE = Value
  
  /**
    * Singapore
    */
  val SG = Value
  
  /**
    * Saint Helena, Ascension and Tristan da Cunha
    */
  val SH = Value
  
  /**
    * Slovenia
    */
  val SI = Value
  
  /**
    * Svalbard and Jan Mayen
    */
  val SJ = Value
  
  /**
    * Slovakia
    */
  val SK = Value
  
  /**
    * Sierra Leone
    */
  val SL = Value
  
  /**
    * San Marino
    */
  val SM = Value
  
  /**
    * Senegal
    */
  val SN = Value
  
  /**
    * Somalia
    */
  val SO = Value
  
  /**
    * Suriname
    */
  val SR = Value
  
  /**
    * South Sudan
    */
  val SS = Value
  
  /**
    * Sao Tome and Principe
    */
  val ST = Value
  
  /**
    * El Salvador
    */
  val SV = Value
  
  /**
    * Sint Maarten (Dutch part)
    */
  val SX = Value
  
  /**
    * Syrian Arab Republic (the)
    */
  val SY = Value
  
  /**
    * Eswatini
    */
  val SZ = Value
  
  /**
    * Turks and Caicos Islands (the)
    */
  val TC = Value
  
  /**
    * Chad
    */
  val TD = Value
  
  /**
    * French Southern Territories (the)
    */
  val TF = Value
  
  /**
    * Togo
    */
  val TG = Value
  
  /**
    * Thailand
    */
  val TH = Value
  
  /**
    * Tajikistan
    */
  val TJ = Value
  
  /**
    * Tokelau
    */
  val TK = Value
  
  /**
    * Timor-Leste
    */
  val TL = Value
  
  /**
    * Turkmenistan
    */
  val TM = Value
  
  /**
    * Tunisia
    */
  val TN = Value
  
  /**
    * Tonga
    */
  val TO = Value
  
  /**
    * Trkiye
    */
  val TR = Value
  
  /**
    * Trinidad and Tobago
    */
  val TT = Value
  
  /**
    * Tuvalu
    */
  val TV = Value
  
  /**
    * Taiwan (Province of China)
    */
  val TW = Value
  
  /**
    * Tanzania, the United Republic of
    */
  val TZ = Value
  
  /**
    * Ukraine
    */
  val UA = Value
  
  /**
    * Uganda
    */
  val UG = Value
  
  /**
    * United States Minor Outlying Islands (the)
    */
  val UM = Value
  
  /**
    * United States of America (the)
    */
  val US = Value
  
  /**
    * Uruguay
    */
  val UY = Value
  
  /**
    * Uzbekistan
    */
  val UZ = Value
  
  /**
    * Holy See (the)
    */
  val VA = Value
  
  /**
    * Saint Vincent and the Grenadines
    */
  val VC = Value
  
  /**
    * Venezuela (Bolivarian Republic of)
    */
  val VE = Value
  
  /**
    * Virgin Islands (British)
    */
  val VG = Value
  
  /**
    * Virgin Islands (U.S.)
    */
  val VI = Value
  
  /**
    * Viet Nam
    */
  val VN = Value
  
  /**
    * Vanuatu
    */
  val VU = Value
  
  /**
    * Wallis and Futuna
    */
  val WF = Value
  
  /**
    * Samoa
    */
  val WS = Value
  
  /**
    * Yemen
    */
  val YE = Value
  
  /**
    * Mayotte
    */
  val YT = Value
  
  /**
    * South Africa
    */
  val ZA = Value
  
  /**
    * Zambia
    */
  val ZM = Value
  
  /**
    * Zimbabwe
    */
  val ZW = Value
}

/**
  * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO).  The set of codes in this enumerated list is sourced from ISO Standard 4217 (https://www.currency-iso.org/en/home/tables/table-a1.html), as of 29-Aug-18.
  */
object ISOCurrencyCodeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * UAE Dirham
    */
  val AED = Value
  
  /**
    * Afghani
    */
  val AFN = Value
  
  /**
    * Lek
    */
  val ALL = Value
  
  /**
    * Armenian Dram
    */
  val AMD = Value
  
  /**
    * Netherlands Antillean Guilder
    */
  val ANG = Value
  
  /**
    * Kwanza
    */
  val AOA = Value
  
  /**
    * Argentine Peso
    */
  val ARS = Value
  
  /**
    * Australian Dollar
    */
  val AUD = Value
  
  /**
    * Aruban Florin
    */
  val AWG = Value
  
  /**
    * Azerbaijan Manat
    */
  val AZN = Value
  
  /**
    * Convertible Mark
    */
  val BAM = Value
  
  /**
    * Barbados Dollar
    */
  val BBD = Value
  
  /**
    * Taka
    */
  val BDT = Value
  
  /**
    * Bulgarian Lev
    */
  val BGN = Value
  
  /**
    * Bahraini Dinar
    */
  val BHD = Value
  
  /**
    * Burundi Franc
    */
  val BIF = Value
  
  /**
    * Bermudian Dollar
    */
  val BMD = Value
  
  /**
    * Brunei Dollar
    */
  val BND = Value
  
  /**
    * Boliviano
    */
  val BOB = Value
  
  /**
    * Mvdol
    */
  val BOV = Value
  
  /**
    * Brazilian Real
    */
  val BRL = Value
  
  /**
    * Bahamian Dollar
    */
  val BSD = Value
  
  /**
    * Ngultrum
    */
  val BTN = Value
  
  /**
    * Pula
    */
  val BWP = Value
  
  /**
    * Belarusian Ruble
    */
  val BYN = Value
  
  /**
    * Belize Dollar
    */
  val BZD = Value
  
  /**
    * Canadian Dollar
    */
  val CAD = Value
  
  /**
    * Congolese Franc
    */
  val CDF = Value
  
  /**
    * WIR Euro
    */
  val CHE = Value
  
  /**
    * Swiss Franc
    */
  val CHF = Value
  
  /**
    * WIR Franc
    */
  val CHW = Value
  
  /**
    * Unidad de Fomento
    */
  val CLF = Value
  
  /**
    * Chilean Peso
    */
  val CLP = Value
  
  /**
    * Yuan Renminbi
    */
  val CNY = Value
  
  /**
    * Colombian Peso
    */
  val COP = Value
  
  /**
    * Unidad de Valor Real
    */
  val COU = Value
  
  /**
    * Costa Rican Colon
    */
  val CRC = Value
  
  /**
    * Peso Convertible
    */
  val CUC = Value
  
  /**
    * Cuban Peso
    */
  val CUP = Value
  
  /**
    * Cabo Verde Escudo
    */
  val CVE = Value
  
  /**
    * Czech Koruna
    */
  val CZK = Value
  
  /**
    * Djibouti Franc
    */
  val DJF = Value
  
  /**
    * Danish Krone
    */
  val DKK = Value
  
  /**
    * Dominican Peso
    */
  val DOP = Value
  
  /**
    * Algerian Dinar
    */
  val DZD = Value
  
  /**
    * Egyptian Pound
    */
  val EGP = Value
  
  /**
    * Nakfa
    */
  val ERN = Value
  
  /**
    * Ethiopian Birr
    */
  val ETB = Value
  
  /**
    * Euro
    */
  val EUR = Value
  
  /**
    * Fiji Dollar
    */
  val FJD = Value
  
  /**
    * Falkland Islands Pound
    */
  val FKP = Value
  
  /**
    * Pound Sterling
    */
  val GBP = Value
  
  /**
    * Lari
    */
  val GEL = Value
  
  /**
    * Ghana Cedi
    */
  val GHS = Value
  
  /**
    * Gibraltar Pound
    */
  val GIP = Value
  
  /**
    * Dalasi
    */
  val GMD = Value
  
  /**
    * Guinean Franc
    */
  val GNF = Value
  
  /**
    * Quetzal
    */
  val GTQ = Value
  
  /**
    * Guyana Dollar
    */
  val GYD = Value
  
  /**
    * Hong Kong Dollar
    */
  val HKD = Value
  
  /**
    * Lempira
    */
  val HNL = Value
  
  /**
    * Gourde
    */
  val HTG = Value
  
  /**
    * Forint
    */
  val HUF = Value
  
  /**
    * Rupiah
    */
  val IDR = Value
  
  /**
    * New Israeli Sheqel
    */
  val ILS = Value
  
  /**
    * Indian Rupee
    */
  val INR = Value
  
  /**
    * Iraqi Dinar
    */
  val IQD = Value
  
  /**
    * Iranian Rial
    */
  val IRR = Value
  
  /**
    * Iceland Krona
    */
  val ISK = Value
  
  /**
    * Jamaican Dollar
    */
  val JMD = Value
  
  /**
    * Jordanian Dinar
    */
  val JOD = Value
  
  /**
    * Yen
    */
  val JPY = Value
  
  /**
    * Kenyan Shilling
    */
  val KES = Value
  
  /**
    * Som
    */
  val KGS = Value
  
  /**
    * Riel
    */
  val KHR = Value
  
  /**
    * Comorian Franc 
    */
  val KMF = Value
  
  /**
    * North Korean Won
    */
  val KPW = Value
  
  /**
    * Won
    */
  val KRW = Value
  
  /**
    * Kuwaiti Dinar
    */
  val KWD = Value
  
  /**
    * Cayman Islands Dollar
    */
  val KYD = Value
  
  /**
    * Tenge
    */
  val KZT = Value
  
  /**
    * Lao Kip
    */
  val LAK = Value
  
  /**
    * Lebanese Pound
    */
  val LBP = Value
  
  /**
    * Sri Lanka Rupee
    */
  val LKR = Value
  
  /**
    * Liberian Dollar
    */
  val LRD = Value
  
  /**
    * Loti
    */
  val LSL = Value
  
  /**
    * Libyan Dinar
    */
  val LYD = Value
  
  /**
    * Moroccan Dirham
    */
  val MAD = Value
  
  /**
    * Moldovan Leu
    */
  val MDL = Value
  
  /**
    * Malagasy Ariary
    */
  val MGA = Value
  
  /**
    * Denar
    */
  val MKD = Value
  
  /**
    * Kyat
    */
  val MMK = Value
  
  /**
    * Tugrik
    */
  val MNT = Value
  
  /**
    * Pataca
    */
  val MOP = Value
  
  /**
    * Ouguiya
    */
  val MRU = Value
  
  /**
    * Mauritius Rupee
    */
  val MUR = Value
  
  /**
    * Rufiyaa
    */
  val MVR = Value
  
  /**
    * Malawi Kwacha
    */
  val MWK = Value
  
  /**
    * Mexican Peso
    */
  val MXN = Value
  
  /**
    * Mexican Unidad de Inversion (UDI)
    */
  val MXV = Value
  
  /**
    * Malaysian Ringgit
    */
  val MYR = Value
  
  /**
    * Mozambique Metical
    */
  val MZN = Value
  
  /**
    * Namibia Dollar
    */
  val NAD = Value
  
  /**
    * Naira
    */
  val NGN = Value
  
  /**
    * Cordoba Oro
    */
  val NIO = Value
  
  /**
    * Norwegian Krone
    */
  val NOK = Value
  
  /**
    * Nepalese Rupee
    */
  val NPR = Value
  
  /**
    * New Zealand Dollar
    */
  val NZD = Value
  
  /**
    * Rial Omani
    */
  val OMR = Value
  
  /**
    * Balboa
    */
  val PAB = Value
  
  /**
    * Sol
    */
  val PEN = Value
  
  /**
    * Kina
    */
  val PGK = Value
  
  /**
    * Philippine Peso
    */
  val PHP = Value
  
  /**
    * Pakistan Rupee
    */
  val PKR = Value
  
  /**
    * Zloty
    */
  val PLN = Value
  
  /**
    * Guarani
    */
  val PYG = Value
  
  /**
    * Qatari Rial
    */
  val QAR = Value
  
  /**
    * Romanian Leu
    */
  val RON = Value
  
  /**
    * Serbian Dinar
    */
  val RSD = Value
  
  /**
    * Russian Ruble
    */
  val RUB = Value
  
  /**
    * Rwanda Franc
    */
  val RWF = Value
  
  /**
    * Saudi Riyal
    */
  val SAR = Value
  
  /**
    * Solomon Islands Dollar
    */
  val SBD = Value
  
  /**
    * Seychelles Rupee
    */
  val SCR = Value
  
  /**
    * Sudanese Pound
    */
  val SDG = Value
  
  /**
    * Swedish Krona
    */
  val SEK = Value
  
  /**
    * Singapore Dollar
    */
  val SGD = Value
  
  /**
    * Saint Helena Pound
    */
  val SHP = Value
  
  /**
    * Leone
    */
  val SLE = Value
  
  /**
    * Somali Shilling
    */
  val SOS = Value
  
  /**
    * Surinam Dollar
    */
  val SRD = Value
  
  /**
    * South Sudanese Pound
    */
  val SSP = Value
  
  /**
    * Dobra
    */
  val STN = Value
  
  /**
    * El Salvador Colon
    */
  val SVC = Value
  
  /**
    * Syrian Pound
    */
  val SYP = Value
  
  /**
    * Lilangeni
    */
  val SZL = Value
  
  /**
    * Baht
    */
  val THB = Value
  
  /**
    * Somoni
    */
  val TJS = Value
  
  /**
    * Turkmenistan New Manat
    */
  val TMT = Value
  
  /**
    * Tunisian Dinar
    */
  val TND = Value
  
  /**
    * Pa’anga
    */
  val TOP = Value
  
  /**
    * Turkish Lira
    */
  val TRY = Value
  
  /**
    * Trinidad and Tobago Dollar
    */
  val TTD = Value
  
  /**
    * New Taiwan Dollar
    */
  val TWD = Value
  
  /**
    * Tanzanian Shilling
    */
  val TZS = Value
  
  /**
    * Hryvnia
    */
  val UAH = Value
  
  /**
    * Uganda Shilling
    */
  val UGX = Value
  
  /**
    * US Dollar
    */
  val USD = Value
  
  /**
    * US Dollar (Next day)
    */
  val USN = Value
  
  /**
    * Uruguay Peso en Unidades Indexadas (UI)
    */
  val UYI = Value
  
  /**
    * Peso Uruguayo
    */
  val UYU = Value
  
  /**
    * Unidad Previsional
    */
  val UYW = Value
  
  /**
    * Uzbekistan Sum
    */
  val UZS = Value
  
  /**
    * Bolívar Soberano
    */
  val VED = Value
  
  /**
    * Bolívar Soberano
    */
  val VES = Value
  
  /**
    * Dong
    */
  val VND = Value
  
  /**
    * Vatu
    */
  val VUV = Value
  
  /**
    * Tala
    */
  val WST = Value
  
  /**
    * CFA Franc BEAC
    */
  val XAF = Value
  
  /**
    * Silver
    */
  val XAG = Value
  
  /**
    * Gold
    */
  val XAU = Value
  
  /**
    * Bond Markets Unit European Composite Unit (EURCO)
    */
  val XBA = Value
  
  /**
    * Bond Markets Unit European Monetary Unit (E.M.U.-6)
    */
  val XBB = Value
  
  /**
    * Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
    */
  val XBC = Value
  
  /**
    * Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
    */
  val XBD = Value
  
  /**
    * East Caribbean Dollar
    */
  val XCD = Value
  
  /**
    * SDR (Special Drawing Right)
    */
  val XDR = Value
  
  /**
    * CFA Franc BCEAO
    */
  val XOF = Value
  
  /**
    * Palladium
    */
  val XPD = Value
  
  /**
    * CFP Franc
    */
  val XPF = Value
  
  /**
    * Platinum
    */
  val XPT = Value
  
  /**
    * Sucre
    */
  val XSU = Value
  
  /**
    * Codes specifically reserved for testing purposes
    */
  val XTS = Value
  
  /**
    * ADB Unit of Account
    */
  val XUA = Value
  
  /**
    * The codes assigned for transactions where no currency is involved
    */
  val XXX = Value
  
  /**
    * Yemeni Rial
    */
  val YER = Value
  
  /**
    * Rand
    */
  val ZAR = Value
  
  /**
    * Zambian Kwacha
    */
  val ZMW = Value
  
  /**
    * Zimbabwe Gold
    */
  val ZWG = Value
}

/**
  * The enumerated values to specify the CDX index annex source.
  */
object IndexAnnexSourceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
    */
  val MASTER_CONFIRMATION = Value
  
  /**
    * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
    */
  val PUBLISHER = Value
}

/**
  * The enumerated values to specify the consequences of Index Events.
  */
object IndexEventConsequenceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Calculation Agent Adjustment.
    */
  val CALCULATION_AGENT_ADJUSTMENT = Value
  
  /**
    * Cancellation and Payment.
    */
  val CANCELLATION_AND_PAYMENT = Value
  
  /**
    * Negotiated Close Out.
    */
  val NEGOTIATED_CLOSE_OUT = Value
  
  /**
    * Related Exchange.
    */
  val RELATED_EXCHANGE = Value
}

/**
  * Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
  */
object InflationCalculationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * (Inflation Index Final / Inflation Index Base). Inflation Index Final is inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interpolation). Inflation Index Base subject to the Calculation Style. Used in inflation asset swaps to calculate the inflation coupons and principal exchange.
    */
  val RATIO = Value
  
  /**
    * (Inflation Index Final / Inflation Index Base -1). Inflation Index Final is the inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Used in market standard ZC Inflation swaps.
    */
  val RETURN = Value
  
  /**
    * Inflation Index Final - Inflation Index Base). Inflation Index Final is Index for Ref month the Lag months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Typically used for fixing locks.
    */
  val SPREAD = Value
}

/**
  * Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
  */
object InflationCalculationStyleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * YearOnYear means Inflation Index Base is the inflation index for Reference Month that is 12 months prior to Inflation Index Final (subject to interpolation). Inflation Index Base is cashflow dependent.
    */
  val YEAR_ON_YEAR = Value
  
  /**
    * ZeroCoupon means Inflation Index Base used in the CalculationMethod is the inflation index for the Reference Month that is the lag number of months prior to Effective Date in the case of a swap, or Bond Interest Accrual Date in the case of an Asset Swap (subject to interpolation). Inflation Index Base has the same value for each inflation cashflow and Principal Exchange calculation within the trade.
    */
  val ZERO_COUPON = Value
}

/**
  * The enumerated values to specify the list of inflation rate indices.
  */
object InflationRateIndexEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Australia: AUD - Non-revised Consumer Price Index (CPI)
    */
  val AUD_CPI = Value("AUD-CPI")
  
  /**
    * Austria: AUS - Non-revised Consumer Price Index (CPI)
    */
  val AUS_CPI = Value("AUS-CPI")
  
  /**
    * Austria: AUS - Non-revised Harmonised Indices of Consumer Prices (HICP)
    */
  val AUS_HICP = Value("AUS-HICP")
  
  /**
    * Belgium: BLG - Non-revised Consumer Price Index - General Index (CPI)
    */
  val BLG_CPI_GI = Value("BLG-CPI-GI")
  
  /**
    * Belgium: BLG - Non-revised Consumer Price Index - Health Index (CPI)
    */
  val BLG_CPI_HI = Value("BLG-CPI-HI")
  
  /**
    * Belgium: BLG - Non-revised Harmonised Consumer Price Index (HICP)
    */
  val BLG_HICP = Value("BLG-HICP")
  
  /**
    * Brazil: BRL - Non-revised Price Index (IGP-M)
    */
  val BRL_IGPM = Value("BRL-IGPM")
  
  /**
    * Brazil: BRL - Non-revised Consumer Price Index (IPCA)
    */
  val BRL_IPCA = Value("BRL-IPCA")
  
  /**
    * Canada: CAD - Non-revised Consumer Price Index (CPI)
    */
  val CAD_CPI = Value("CAD-CPI")
  
  /**
    * Chile: CLP - Non-revised Consumer Price Index (CPI)
    */
  val CLP_CPI = Value("CLP-CPI")
  
  /**
    * China: CNY - Non-revised Consumer Price Index (CPI)
    */
  val CNY_CPI = Value("CNY-CPI")
  
  /**
    * Czech Republic: CZK - Non-revised Consumer Price Index (CPI)
    */
  val CZK_CPI = Value("CZK-CPI")
  
  /**
    * Denmark: DEK - Non-revised Consumer Price Index (CPI)
    */
  val DEK_CPI = Value("DEK-CPI")
  
  /**
    * Denmark: DEK - Non-revised Harmonised Consumer Price Index (HICP)
    */
  val DEK_HICP = Value("DEK-HICP")
  
  /**
    * Germany: DEM - Non-revised Consumer Price Index (CPI)
    */
  val DEM_CPI = Value("DEM-CPI")
  
  /**
    * Germany: DEM - Non-revised Consumer Price Index for North Rhine-Westphalia
    */
  val DEM_CPI_NRW = Value("DEM-CPI-NRW")
  
  /**
    * Germany: DEM - Non-revised Harmonised Consumer Price Index (HICP)
    */
  val DEM_HICP = Value("DEM-HICP")
  
  /**
    * Spain: ESP - National-Non-revised Consumer Price Index (CPI)
    */
  val ESP_CPI = Value("ESP-CPI")
  
  /**
    * Spain: ESP - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val ESP_HICP = Value("ESP-HICP")
  
  /**
    * Spain: ESP - National-Revised Consumer Price Index (CPI).
    */
  val ESP_R_CPI = Value("ESP-R-CPI")
  
  /**
    * Spain: ESP - Harmonised-Revised Consumer Price Index (HICP)
    */
  val ESP_R_HICP = Value("ESP-R-HICP")
  
  /**
    * European Union: EUR - All Items-Non-revised Consumer Price Index
    */
  val EUR_AI_CPI = Value("EUR-AI-CPI")
  
  /**
    * European Union: EUR - All Items-Revised Consumer Price Index
    */
  val EUR_AI_R_CPI = Value("EUR-AI-R-CPI")
  
  /**
    * European Union: EUR - Excluding Tobacco-Non-revised Consumer Price Index
    */
  val EUR_EXT_CPI = Value("EUR-EXT-CPI")
  
  /**
    * European Union: EUR - Excluding Tobacco-Revised Consumer Price Index
    */
  val EUR_EXT_R_CPI = Value("EUR-EXT-R-CPI")
  
  /**
    * Finland: FIN - Non-revised Consumer Price Index (CPI)
    */
  val FIN_CPI = Value("FIN-CPI")
  
  /**
    * Finland: FIN - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val FIN_HICP = Value("FIN-HICP")
  
  /**
    * France: FRC - Excluding Tobacco-Non-Revised Consumer Price Index
    */
  val FRC_EXT_CPI = Value("FRC-EXT-CPI")
  
  /**
    * France: FRC - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val FRC_HICP = Value("FRC-HICP")
  
  /**
    * Greece: GRD - Non-revised Consumer Price Index (CPI)
    */
  val GRD_CPI = Value("GRD-CPI")
  
  /**
    * Greece: GRD - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val GRD_HICP = Value("GRD-HICP")
  
  /**
    * Hong Kong: HKD - Non-revised Consumer Price Index (CPI)
    */
  val HKD_CPI = Value("HKD-CPI")
  
  /**
    * Hungary: HUF - Non-revised Consumer Price Index (CPI)
    */
  val HUF_CPI = Value("HUF-CPI")
  
  /**
    * Indonesia: IDR - Non-revised Consumer Price Index (CPI)
    */
  val IDR_CPI = Value("IDR-CPI")
  
  /**
    * Israel: ILS - Non-revised Consumer Price Index (CPI)
    */
  val ILS_CPI = Value("ILS-CPI")
  
  /**
    * Ireland: IRL - Non-revised Consumer Price Index (CPI)
    */
  val IRL_CPI = Value("IRL-CPI")
  
  /**
    * Ireland: IRL - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val IRL_HICP = Value("IRL-HICP")
  
  /**
    * Iceland: ISK - Non-revised Consumer Price Index (CPI)
    */
  val ISK_CPI = Value("ISK-CPI")
  
  /**
    * Iceland: ISK - Harmonised Consumer Price Index (HICP)
    */
  val ISK_HICP = Value("ISK-HICP")
  
  /**
    * Italy: ITL - Inflation for Blue Collar Workers and Employees-Excluding Tobacco Consumer Price Index
    */
  val ITL_BC_EXT_CPI = Value("ITL-BC-EXT-CPI")
  
  /**
    * Italy: ITL - Inflation for Blue Collar Workers and Employees-Including Tobacco Consumer Price Index
    */
  val ITL_BC_INT_CPI = Value("ITL-BC-INT-CPI")
  
  /**
    * Italy: ITL - Non-revised Harmonised Consumer Price Index (HICP)
    */
  val ITL_HICP = Value("ITL-HICP")
  
  /**
    * Italy: ITL - Whole Community - Excluding Tobacco Consumer Price Index
    */
  val ITL_WC_EXT_CPI = Value("ITL-WC-EXT-CPI")
  
  /**
    * Italy: ITL - Whole Community - Including Tobacco Consumer Price Index
    */
  val ITL_WC_INT_CPI = Value("ITL-WC-INT-CPI")
  
  /**
    * Japan: JPY - Non-revised Consumer Price Index Nationwide General Excluding Fresh Food (CPI)
    */
  val JPY_CPI_EXF = Value("JPY-CPI-EXF")
  
  /**
    * South Korea: KRW - Non-revised Consumer Price Index (CPI)
    */
  val KRW_CPI = Value("KRW-CPI")
  
  /**
    * Luxembourg: LUX - Non-revised Consumer Price Index (CPI)
    */
  val LUX_CPI = Value("LUX-CPI")
  
  /**
    * Luxembourg: LUX - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val LUX_HICP = Value("LUX-HICP")
  
  /**
    * Mexico: MXN - Non-revised Consumer Price Index (CPI)
    */
  val MXN_CPI = Value("MXN-CPI")
  
  /**
    * Mexico: MXN - Unidad de Inversion Index (UDI)
    */
  val MXN_UDI = Value("MXN-UDI")
  
  /**
    * Malaysia: MYR - Non-revised Consumer Price Index (CPI)
    */
  val MYR_CPI = Value("MYR-CPI")
  
  /**
    * Netherlands: NLG - Non-revised Consumer Price Index (CPI)
    */
  val NLG_CPI = Value("NLG-CPI")
  
  /**
    * Netherlands: NLG - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val NLG_HICP = Value("NLG-HICP")
  
  /**
    * Norway: NOK - Non-revised Consumer Price Index (CPI)
    */
  val NOK_CPI = Value("NOK-CPI")
  
  /**
    * New Zealand: NZD - Non-revised Consumer Price Index (CPI)
    */
  val NZD_CPI = Value("NZD-CPI")
  
  /**
    * Peru: PER - Non-revised Consumer Price Index (CPI)
    */
  val PER_CPI = Value("PER-CPI")
  
  /**
    * Poland: PLN - Non-Revised Consumer Price Index (CPI)
    */
  val PLN_CPI = Value("PLN-CPI")
  
  /**
    * Portugal: POR - Non-revised Consumer Price Index (CPI)
    */
  val POR_CPI = Value("POR-CPI")
  
  /**
    * Portugal: POR - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val POR_HICP = Value("POR-HICP")
  
  /**
    * Russia: RUB - Non-revised Consumer Price Index (CPI)
    */
  val RUB_CPI = Value("RUB-CPI")
  
  /**
    * Sweden: SEK - Non-revised Consumer Price Index (CPI)
    */
  val SEK_CPI = Value("SEK-CPI")
  
  /**
    * Singapore: SGD - Non-revised Consumer Price Index (CPI)
    */
  val SGD_CPI = Value("SGD-CPI")
  
  /**
    * Switzerland: SWF - Non-revised Consumer Price Index (CPI)
    */
  val SWF_CPI = Value("SWF-CPI")
  
  /**
    * Turkey: TRY - Non-revised Consumer Price Index (CPI)
    */
  val TRY_CPI = Value("TRY-CPI")
  
  /**
    * Taiwan: TWD - Non-revised Consumer Price Index (CPI)
    */
  val TWD_CPI = Value("TWD-CPI")
  
  /**
    * United Kingdom: GBP - Non-revised Consumer Prices Index including Housing (UKCPIH)
    */
  val UK_CPIH = Value("UK-CPIH")
  
  /**
    * United Kingdom: GBP - Harmonised-Non-revised Consumer Price Index (HICP)
    */
  val UK_HICP = Value("UK-HICP")
  
  /**
    * United Kingdom: GBP - Non-revised Retail Price Index (UKRPI)
    */
  val UK_RPI = Value("UK-RPI")
  
  /**
    * United Kingdom: GBP - Non-revised Retail Price Index Excluding Mortgage Interest Payments (UKRPIX)
    */
  val UK_RPIX = Value("UK-RPIX")
  
  /**
    * United States: USA - Non-revised Consumer Price Index - Urban (CPI-U)
    */
  val USA_CPI_U = Value("USA-CPI-U")
  
  /**
    * South Africa: ZAR - Non-revised Consumer Price Index (CPI)
    */
  val ZAR_CPI = Value("ZAR-CPI")
  
  /**
    * South Africa: ZAR - Non-revised Consumer Price Index Excluding Mortgages (CPIX)
    */
  val ZAR_CPIX = Value("ZAR-CPIX")
}

/**
  * The enumerated values to specify the list of information providers.
  */
object InformationProviderEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Association of Banks in Singapore.
    */
  val ASSOC_BANKS_SINGAPORE = Value
  
  /**
    * The central bank of Chile.
    */
  val BANCO_CENTRAL_CHILE = Value
  
  /**
    * The central bank of Canada.
    */
  val BANK_OF_CANADA = Value
  
  /**
    * The Bank Of England.
    */
  val BANK_OF_ENGLAND = Value
  
  /**
    * The central bank of Japan.
    */
  val BANK_OF_JAPAN = Value
  
  /**
    * Bloomberg LP.
    */
  val BLOOMBERG = Value
  
  /**
    * The European Central Bank.
    */
  val EURO_CENTRAL_BANK = Value
  
  /**
    * The Federal Home Loan Bank of San Francisco, or its successor.
    */
  val FHLBSF = Value
  
  /**
    * The Federal Reserve, the central bank of the United States.
    */
  val FEDERAL_RESERVE = Value
  
  /**
    * ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate.
    */
  val ICESWAP = Value
  
  /**
    * International Swaps and Derivatives Association, Inc.
    */
  val ISDA = Value
  
  /**
    * Refinitiv, formerly Thomson Reuters Financial & Risk.
    */
  val REFINITIV = Value
  
  /**
    * The Reserve Bank of Australia.
    */
  val RESERVE_BANK_AUSTRALIA = Value
  
  /**
    * The Reserve Bank of New Zealand.
    */
  val RESERVE_BANK_NEW_ZEALAND = Value
  
  /**
    * Reuters Group Plc.
    */
  val REUTERS = Value
  
  /**
    * South African Futures Exchange, or its successor.
    */
  val SAFEX = Value
  
  /**
    * The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR.
    */
  val TOKYOSWAP = Value
  
  /**
    * Telerate, Inc.
    */
  val TELERATE = Value
}

/**
  * The enumeration values indicating the BusinessEvent function associated input instructions.
  */
object InstructionFunctionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val COMPRESSION = Value
  
  val CONTRACT_FORMATION = Value
  
  val EXECUTION = Value
  
  val QUANTITY_CHANGE = Value
  
  val RENEGOTIATION = Value
}

/**
  * Represents an enumeration list to indentify the type of an instrument.
  */
object InstrumentTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
    */
  val CERTIFICATE = Value
  
  /**
    * Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
    */
  val DEBT = Value
  
  /**
    * Identifies an instrument as an Equity value of holding of shares in listed company.
    */
  val EQUITY = Value
  
  /**
    * Identifies an instrument as representing holding in an investment fund.
    */
  val FUND = Value
  
  /**
    * Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
    */
  val LETTER_OF_CREDIT = Value
  
  /**
    * Identifies an instrument as a listed derivative on an exchange.
    */
  val LISTED_DERIVATIVE = Value
  
  /**
    * Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
    */
  val WARRANT = Value
}

/**
  * The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives.
  */
object InterestShortfallCapEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val FIXED = Value
  
  val VARIABLE = Value
}

/**
  * The enumerated values to specify the interpolation method, e.g. linear.
  */
object InterpolationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Linear Interpolation applicable.
    */
  val LINEAR = Value
  
  /**
    * Linear Interpolation applicable.
    */
  val LINEAR_ZERO_YIELD = Value
  
  /**
    * No Interpolation applicable.
    */
  val NONE = Value
}

/**
  * Represents an enumeration list to identify the type of entity issuing the asset.
  */
object IssuerTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies debt issued Securities by corporate bodies including Banks.
    */
  val CORPORATE = Value
  
  /**
    * Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
    */
  val FUND = Value
  
  /**
    * Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
    */
  val QUASI_GOVERNMENT = Value
  
  /**
    * Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities.
    */
  val REGIONAL_GOVERNMENT = Value
  
  /**
    * Specifies Sovereign, Government Debt Securities including Central Banks.
    */
  val SOVEREIGN_CENTRAL_BANK = Value
  
  /**
    * Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations.
    */
  val SPECIAL_PURPOSE_VEHICLE = Value
  
  /**
    * Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks.
    */
  val SUPRA_NATIONAL = Value
}

/**
  * The enumerated values to specify the legal agreement publisher.
  */
object LegalAgreementPublisherEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Association Française des Banques.
    */
  val AFB = Value
  
  /**
    * BNY Mellon
    */
  val BNYM = Value
  
  /**
    * Emerging Markets Traders Association
    */
  val EMTA = Value
  
  /**
    * International Capital Markets Association
    */
  val ICMA = Value
  
  /**
    * International Swaps and Derivatives Association, Inc.
    */
  val ISDA = Value
  
  /**
    * ISDA and Clearstream
    */
  val ISDA_CLEARSTREAM = Value
  
  /**
    * ISDA and Euroclear
    */
  val ISDA_EUROCLEAR = Value
  
  /**
    * International Securities Lending Association
    */
  val ISLA = Value
  
  /**
    * JP Morgan
    */
  val JP_MORGAN = Value
  
  /**
    * The Foreign Exchange Committee
    */
  val THE_FX_COMMITTEE = Value
}

/**
  * The enumerated values to specify the legal agreement type.
  */
object LegalAgreementTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A Broker Confirmation.
    */
  val BROKER_CONFIRMATION = Value
  
  /**
    * A Transaction Confirmation.
    */
  val CONFIRMATION = Value
  
  /**
    * A Credit Support Agreement.
    */
  val CREDIT_SUPPORT_AGREEMENT = Value
  
  /**
    * A Master Agreement.
    */
  val MASTER_AGREEMENT = Value
  
  /**
    * A Master Confirmation.
    */
  val MASTER_CONFIRMATION = Value
  
  /**
    * Another type of agreement.
    */
  val OTHER = Value
  
  /**
    * A Security Agreement related to a Collateral Transfer Agreement (CTA).
    */
  val SECURITY_AGREEMENT = Value
}

/**
  * The enumerated values to specify the length unit in the Resource type.
  */
object LengthUnitEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val PAGES = Value
  
  val TIME_UNIT = Value
}

/**
  * The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification.
  */
object LimitLevelEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The limit is set in relation to the proprietary business undertaken by the clearing counterparty.
    */
  val ACCOUNT = Value
  
  /**
    * The limit is set in relation to the customer business undertaken by the clearing counterparty.
    */
  val CUSTOMER = Value
  
  /**
    * The limit is set at the account level in relation to the clearing counterparty.
    */
  val HOUSE = Value
}

/**
  * Specifies the load type of the delivery.
  */
object LoadTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Base load
    */
  val BASE_LOAD = Value
  
  /**
    * Block Hours
    */
  val BLOCK_HOURS = Value
  
  /**
    * Gas Day
    */
  val GAS_DAY = Value
  
  /**
    * Off-peak load
    */
  val OFF_PEAK = Value
  
  /**
    * Other
    */
  val OTHER = Value
  
  /**
    * Peak load
    */
  val PEAK_LOAD = Value
  
  /**
    * Shaped
    */
  val SHAPED = Value
}

/**
  * Represents the enumeration values to identify the collateral action instruction.
  */
object MarginCallActionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates an instruction of a new collateral asset delivery.
    */
  val DELIVERY = Value
  
  /**
    * Indicates an instruction for a return of a principals collateral asset delivery.
    */
  val RETURN = Value
}

/**
  * Represents the enumeration values to define the response type to a margin call.
  */
object MarginCallResponseTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies a 'Full Agreement' to Margin Call.
    */
  val AGREEIN_FULL = Value
  
  /**
    * Specifies a 'Full Dispute' to a Margin call.
    */
  val DISPUTE = Value
  
  /**
    * Specifies a 'Partial agreement' to Margin Call.
    */
  val PARTIALLY_AGREE = Value
}

/**
  * This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
  */
object MarginTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
    */
  val CASH = Value
  
  /**
    * When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the 'instrument' case, the haircut would be applied to the securities.
    */
  val INSTRUMENT = Value
}

/**
  * The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
  */
object MarketDisruptionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
    */
  val MODIFIED_POSTPONEMENT = Value
  
  /**
    * As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
    */
  val OMISSION = Value
  
  /**
    * As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
    */
  val POSTPONEMENT = Value
}

object MasterAgreementClauseIdentifierEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Date of Agreement
    */
  val ISLA_GMSLA_001 = Value
  
  /**
    * Parties
    */
  val ISLA_GMSLA_002 = Value
  
  /**
    * Specific Roles
    */
  val ISLA_GMSLA_003 = Value
  
  /**
    * Eligible Collateral
    */
  val ISLA_GMSLA_004 = Value
  
  /**
    * Margin
    */
  val ISLA_GMSLA_005 = Value
  
  /**
    * Aggregation
    */
  val ISLA_GMSLA_006 = Value
  
  /**
    * Collateral Disapplication
    */
  val ISLA_GMSLA_007 = Value
  
  /**
    * Settlement Netting
    */
  val ISLA_GMSLA_008 = Value
  
  /**
    * Notification Time
    */
  val ISLA_GMSLA_009 = Value
  
  /**
    * Indemnity
    */
  val ISLA_GMSLA_010 = Value
  
  /**
    * Base Currency
    */
  val ISLA_GMSLA_011 = Value
  
  /**
    * Places of Business
    */
  val ISLA_GMSLA_012 = Value
  
  /**
    * Value
    */
  val ISLA_GMSLA_013 = Value
  
  /**
    * Automatic Early Termination
    */
  val ISLA_GMSLA_014 = Value
  
  /**
    * Designated Offices
    */
  val ISLA_GMSLA_015 = Value
  
  /**
    * Address for Notices
    */
  val ISLA_GMSLA_016 = Value
  
  /**
    * Process Agent
    */
  val ISLA_GMSLA_017 = Value
  
  /**
    * Party Acting as Agent
    */
  val ISLA_GMSLA_018 = Value
  
  /**
    * Pooled Principal Transactions 
    */
  val ISLA_GMSLA_019 = Value
  
  /**
    * Party Preparing the Agreement 
    */
  val ISLA_GMSLA_020 = Value
  
  /**
    * Default Interest Rate
    */
  val ISLA_GMSLA_021 = Value
  
  /**
    * Existing Transactions
    */
  val ISLA_GMSLA_022 = Value
  
  /**
    * Automation
    */
  val ISLA_GMSLA_023 = Value
  
  /**
    * Act of Insolvency
    */
  val ISLA_GMSLA_024 = Value
  
  /**
    * Buy-In
    */
  val ISLA_GMSLA_025 = Value
  
  /**
    * Currency Conversions
    */
  val ISLA_GMSLA_026 = Value
  
  /**
    * Scope
    */
  val ISLA_GMSLA_027 = Value
  
  /**
    * Collateral Delivery Timings
    */
  val ISLA_GMSLA_028 = Value
  
  /**
    * Delivery
    */
  val ISLA_GMSLA_029 = Value
  
  /**
    * Substitution of Collateral
    */
  val ISLA_GMSLA_030 = Value
  
  /**
    * Manufactured Payments
    */
  val ISLA_GMSLA_031 = Value
  
  /**
    * Corporate Actions
    */
  val ISLA_GMSLA_032 = Value
  
  /**
    * Payment of Rates
    */
  val ISLA_GMSLA_033 = Value
  
  /**
    * Rate Applicable to Loaned Securities
    */
  val ISLA_GMSLA_034 = Value
  
  /**
    * Lender's Right to Terminate a Loan
    */
  val ISLA_GMSLA_035 = Value
  
  /**
    * Borrower's Right to Terminate a Loan
    */
  val ISLA_GMSLA_036 = Value
  
  /**
    * Failure to Deliver Event of Default
    */
  val ISLA_GMSLA_037 = Value
  
  /**
    * Failure to Redeliver
    */
  val ISLA_GMSLA_038 = Value
  
  /**
    * Assets Transferred to a Trustee
    */
  val ISLA_GMSLA_039 = Value
  
  /**
    * Suspension Event of Default
    */
  val ISLA_GMSLA_040 = Value
  
  /**
    * Costs and Expenses
    */
  val ISLA_GMSLA_041 = Value
  
  /**
    * Set-Off
    */
  val ISLA_GMSLA_042 = Value
  
  /**
    * Default Market Value Fallbacks
    */
  val ISLA_GMSLA_043 = Value
  
  /**
    * Assignment
    */
  val ISLA_GMSLA_044 = Value
  
  /**
    * Telephone Recordings
    */
  val ISLA_GMSLA_045 = Value
  
  /**
    * Waiver of Immunity
    */
  val ISLA_GMSLA_046 = Value
  
  /**
    * Agreement to Deliver Documents
    */
  val ISLA_GMSLA_047 = Value
  
  /**
    * Collateral Transfer Details
    */
  val ISLA_GMSLA_048 = Value
  
  /**
    * Confidentiality
    */
  val ISLA_GMSLA_049 = Value
  
  /**
    * Correction
    */
  val ISLA_GMSLA_050 = Value
  
  /**
    * Minimum Collateral Transfer Amount
    */
  val ISLA_GMSLA_051 = Value
  
  /**
    * Non-Reliance Representation
    */
  val ISLA_GMSLA_052 = Value
  
  /**
    * Records and Statements
    */
  val ISLA_GMSLA_053 = Value
  
  /**
    * Recovery and Resolution
    */
  val ISLA_GMSLA_054 = Value
  
  /**
    * Security Agreement Details
    */
  val ISLA_GMSLA_055 = Value
  
  /**
    * Triparty Services
    */
  val ISLA_GMSLA_056 = Value
}

/**
  * The enumerated values to specify the type of the master agreement governing the transaction.
  */
object MasterAgreementTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * AFB Master Agreement for Foreign Exchange and Derivatives Transactions
    */
  val AFB = Value
  
  /**
    * A Bespoke (custom) Master Agreement, including one-off agreements for transactions
    */
  val BESPOKE = Value
  
  /**
    * Clearing Master Agreement
    */
  val CMA = Value
  
  /**
    * Contrato Marco de Operaciones Financieras
    */
  val CMOF = Value
  
  /**
    * EEI Master Power Purchase and Sale Agreement
    */
  val EEI_POWER = Value
  
  /**
    * EFET General Agreement Concerning the Delivery and Acceptance of Electricity
    */
  val EFET_ELECTRICITY = Value
  
  /**
    * EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
    */
  val EFET_GAS = Value
  
  /**
    * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
    */
  val EMA = Value
  
  /**
    * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
    */
  val FBF = Value
  
  /**
    * ICMA Global Master Agreement for REPO Trades
    */
  val GMRA = Value
  
  /**
    * ISLA Global Master Agreement for Securities Lending
    */
  val GMSLA = Value
  
  /**
    * FOA Grid Trade Master Agreement
    */
  val GTMA = Value
  
  /**
    * GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas
    */
  val GAS_EDI = Value
  
  /**
    * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
    */
  val GERMAN = Value
  
  /**
    * International Currency Options Market Master Agreement
    */
  val ICOM = Value
  
  /**
    * International Emissions Trading Association Emissions Reduction Purchase Agreement
    */
  val IETA_ERPA = Value("IETA-ERPA")
  
  /**
    * International Emissions Trading Association Emissions Trading Master Agreement
    */
  val IETA_ETMA = Value("IETA-ETMA")
  
  /**
    * International Emissions Trading Association International Emissions Trading Master Agreement
    */
  val IETA_IETMA = Value("IETA-IETMA")
  
  /**
    * International Foreign Exchange Master Agreement
    */
  val IFEMA = Value
  
  /**
    * International Foreign Exchange and Options Master Agreement
    */
  val IFEOMA = Value
  
  /**
    * ISDA-FIA Cleared Derivatives Execution Agreement
    */
  val ISDAFIA_CDEA = Value("ISDAFIA-CDEA")
  
  /**
    * ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA)
    */
  val ISDAIIFM_TMA = Value("ISDAIIFM-TMA")
  
  /**
    * ISDA Master Agreement
    */
  val ISDA_MASTER = Value
  
  /**
    * Master agreement of Japan Securities Clearing Corporation
    */
  val JSCC = Value
  
  /**
    * International Bullion Master Agreement Terms published by the London Bullion Market Association
    */
  val LBMA = Value
  
  /**
    * Leadership in Energy Automated Processing
    */
  val LEAP = Value
  
  /**
    * CTA Master Coal Purchase and Sales Agreement
    */
  val MCPSA = Value
  
  /**
    * NAESB Base Contract for Sale and Purchase of Natural Gas
    */
  val NAESB_GAS = Value
  
  /**
    * Short Term Flat NBP Trading Terms and Conditions
    */
  val NBP = Value
  
  /**
    * Standard Documentation for Derivative Transactions on the Russian Financial Markets
    */
  val RUSSIAN_DERIVATIVES = Value
  
  /**
    * Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market
    */
  val RUSSIAN_REPO = Value
  
  /**
    * globalCOAL Standard Coal Trading Agreement
    */
  val S_CO_TA = Value
  
  /**
    * Swiss Master Agreement for OTC Derivatives Instruments
    */
  val SWISS = Value
  
  /**
    * TTF Hub Natural Gas Trading Terms and Conditions
    */
  val TTF = Value
  
  /**
    * Zeebrugge Hub Natural Gas Trading Terms and Conditions
    */
  val ZBT = Value
}

object MasterAgreementVariantIdentifierEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Agreement is Undated
    */
  val ISLA_GMSLA_001_01 = Value
  
  /**
    * Agreement is Dated
    */
  val ISLA_GMSLA_001_02 = Value
  
  /**
    * Name and Place of Incorporation
    */
  val ISLA_GMSLA_002_01 = Value
  
  /**
    * Names and Place of Incorporation plus Additional Information
    */
  val ISLA_GMSLA_002_02 = Value
  
  /**
    * Defining the Party's Role as Lender or Borrower
    */
  val ISLA_GMSLA_002_03 = Value
  
  /**
    * Non-specific Roles
    */
  val ISLA_GMSLA_003_01 = Value
  
  /**
    * Specific Roles
    */
  val ISLA_GMSLA_003_02 = Value
  
  /**
    * GMSLA Schedule
    */
  val ISLA_GMSLA_004_01 = Value
  
  /**
    * Outside of GMSLA
    */
  val ISLA_GMSLA_004_02 = Value
  
  /**
    * Additional Criteria
    */
  val ISLA_GMSLA_004_03 = Value
  
  /**
    * GMSLA Schedule
    */
  val ISLA_GMSLA_005_01 = Value
  
  /**
    * Outside of GMSLA
    */
  val ISLA_GMSLA_005_02 = Value
  
  /**
    * Aggregation Applies
    */
  val ISLA_GMSLA_006_01 = Value
  
  /**
    * Aggregation Does Not Apply
    */
  val ISLA_GMSLA_006_02 = Value
  
  /**
    * Aggregation Applies Separately to Loan Groups
    */
  val ISLA_GMSLA_006_03 = Value
  
  /**
    * Aggregation Applies to Some but Not All Loans
    */
  val ISLA_GMSLA_006_04 = Value
  
  /**
    * Neither Aggregation nor Loan by Loan Applies
    */
  val ISLA_GMSLA_006_05 = Value
  
  /**
    * Standard
    */
  val ISLA_GMSLA_007_01 = Value
  
  /**
    * Collateral Disapplied
    */
  val ISLA_GMSLA_007_02 = Value
  
  /**
    * Netting of Collateral Shall Apply
    */
  val ISLA_GMSLA_008_01 = Value
  
  /**
    * Netting of Collateral Shall Not Apply
    */
  val ISLA_GMSLA_008_02 = Value
  
  /**
    * Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
    */
  val ISLA_GMSLA_008_03 = Value
  
  /**
    * Netting of Collateral Shall Apply Separately per Group of Loans
    */
  val ISLA_GMSLA_008_04 = Value
  
  /**
    * Specified Time
    */
  val ISLA_GMSLA_009_01 = Value
  
  /**
    * Notification Time by Collateral Type
    */
  val ISLA_GMSLA_009_02 = Value
  
  /**
    * Notification Time as Agreed
    */
  val ISLA_GMSLA_009_03 = Value
  
  /**
    * No Notification Time
    */
  val ISLA_GMSLA_009_04 = Value
  
  /**
    * Indemnity Applies
    */
  val ISLA_GMSLA_010_01 = Value
  
  /**
    * Indemnity does not Apply
    */
  val ISLA_GMSLA_010_02 = Value
  
  /**
    * Single Base Currency
    */
  val ISLA_GMSLA_011_01 = Value
  
  /**
    * Single Base Currency with Fallback
    */
  val ISLA_GMSLA_011_02 = Value
  
  /**
    * Single Base Currency with Multiple Fallback Options
    */
  val ISLA_GMSLA_011_03 = Value
  
  /**
    * Locations are Specified Without Reference to Party
    */
  val ISLA_GMSLA_012_01 = Value
  
  /**
    * Locations are Specified Separately per Party
    */
  val ISLA_GMSLA_012_02 = Value
  
  /**
    * Not all Places of Business Have to be Open
    */
  val ISLA_GMSLA_012_03 = Value
  
  /**
    * Standard Bid Price
    */
  val ISLA_GMSLA_013_01 = Value
  
  /**
    * Standard Mid Price
    */
  val ISLA_GMSLA_013_02 = Value
  
  /**
    * 2018 Standard
    */
  val ISLA_GMSLA_013_03 = Value
  
  /**
    * Borrowers Agreement to Pricing Source
    */
  val ISLA_GMSLA_013_04 = Value
  
  /**
    * Pre-agreed Pricing Source
    */
  val ISLA_GMSLA_013_05 = Value
  
  /**
    * Time Variation
    */
  val ISLA_GMSLA_013_06 = Value
  
  /**
    * Automatic Early Termination does not Apply
    */
  val ISLA_GMSLA_014_01 = Value
  
  /**
    * Automatic Early Termination Applies
    */
  val ISLA_GMSLA_014_02 = Value
  
  /**
    * Automatic Early Termination Applies in Modified Form)
    */
  val ISLA_GMSLA_014_03 = Value
  
  /**
    * Automatic Early Termination is specified separately for each Principal
    */
  val ISLA_GMSLA_014_04 = Value
  
  /**
    * Automatic Early Termination is not applicable unless required due to the systems of law
    */
  val ISLA_GMSLA_014_05 = Value
  
  /**
    * Party Specifies a Single Designated Office
    */
  val ISLA_GMSLA_015_01 = Value
  
  /**
    * Party Specifies Multiple Designated Offices
    */
  val ISLA_GMSLA_015_02 = Value
  
  /**
    * 2000 Standard
    */
  val ISLA_GMSLA_016_01 = Value
  
  /**
    * 2010 Standard
    */
  val ISLA_GMSLA_016_02 = Value
  
  /**
    * 2018 Standard
    */
  val ISLA_GMSLA_016_03 = Value
  
  /**
    * Plus Email
    */
  val ISLA_GMSLA_016_04 = Value
  
  /**
    * Separate Address for Legal and Operational Notices
    */
  val ISLA_GMSLA_016_05 = Value
  
  /**
    * Special Instructions
    */
  val ISLA_GMSLA_016_06 = Value
  
  /**
    * No Process Agent
    */
  val ISLA_GMSLA_017_01 = Value
  
  /**
    * Process Agent Specified
    */
  val ISLA_GMSLA_017_02 = Value
  
  /**
    * Process Agent to be Appointed
    */
  val ISLA_GMSLA_017_03 = Value
  
  /**
    * A Party will not act as Agent
    */
  val ISLA_GMSLA_018_01 = Value
  
  /**
    * A Party may act as Agent
    */
  val ISLA_GMSLA_018_02 = Value
  
  /**
    * A Party will always act as Agent
    */
  val ISLA_GMSLA_018_03 = Value
  
  /**
    * Pooled Principal Transactions Shall Not Apply
    */
  val ISLA_GMSLA_019_01 = Value
  
  /**
    * Pooled Principal Transactions Shall  Apply
    */
  val ISLA_GMSLA_019_02 = Value
  
  /**
    * Pooled Principal Transactions May Apply
    */
  val ISLA_GMSLA_019_03 = Value
  
  /**
    * Simple Election
    */
  val ISLA_GMSLA_020_01 = Value
  
  /**
    * Election with Modifications
    */
  val ISLA_GMSLA_020_02 = Value
  
  /**
    * Term Rate
    */
  val ISLA_GMSLA_021_01 = Value
  
  /**
    * Overnight Rate
    */
  val ISLA_GMSLA_021_02 = Value
  
  /**
    * Risk Free Rate
    */
  val ISLA_GMSLA_021_03 = Value
  
  /**
    * Non-Defaulting Party Election
    */
  val ISLA_GMSLA_021_04 = Value
  
  /**
    * Spread
    */
  val ISLA_GMSLA_021_05 = Value
  
  /**
    * Agreement Covers Existing Loans
    */
  val ISLA_GMSLA_022_01 = Value
  
  /**
    * Agreement Does Not Cover Existing Loans
    */
  val ISLA_GMSLA_022_02 = Value
  
  /**
    * Automation Does Not Apply
    */
  val ISLA_GMSLA_023_01 = Value
  
  /**
    * Automation May Apply
    */
  val ISLA_GMSLA_023_02 = Value
  
  /**
    * Standard Pre-Print
    */
  val ISLA_GMSLA_024_01 = Value
  
  /**
    * Grace Period Amendment
    */
  val ISLA_GMSLA_024_02 = Value
  
  /**
    * Jurisdictional Amendments
    */
  val ISLA_GMSLA_024_03 = Value
  
  /**
    * Transferor Pays Costs and Expenses
    */
  val ISLA_GMSLA_025_01 = Value
  
  /**
    * Transferor Pays Costs and Expenses other than those arising from Negligence
    */
  val ISLA_GMSLA_025_02 = Value
  
  /**
    * Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
    */
  val ISLA_GMSLA_025_03 = Value
  
  /**
    * Buy-in Expanded to Cover Buy-in Exercised by an Exchange
    */
  val ISLA_GMSLA_025_04 = Value
  
  /**
    * Standard
    */
  val ISLA_GMSLA_026_01 = Value
  
  /**
    * Selecting Party other than Lender
    */
  val ISLA_GMSLA_026_02 = Value
  
  /**
    * Variation of Exchange Rate Source
    */
  val ISLA_GMSLA_026_03 = Value
  
  /**
    * Standard Scope
    */
  val ISLA_GMSLA_027_01 = Value
  
  /**
    * Limited Scope
    */
  val ISLA_GMSLA_027_02 = Value
  
  /**
    * Same Day
    */
  val ISLA_GMSLA_028_01 = Value
  
  /**
    * Alternative Delivery Time
    */
  val ISLA_GMSLA_028_02 = Value
  
  /**
    * Same Day with Notification Time
    */
  val ISLA_GMSLA_028_03 = Value
  
  /**
    * Alternative Delivery Time with Notification Time
    */
  val ISLA_GMSLA_028_04 = Value
  
  /**
    * Asset Dependent
    */
  val ISLA_GMSLA_028_05 = Value
  
  /**
    * Simultaneous delivery of securities and collateral
    */
  val ISLA_GMSLA_029_01 = Value
  
  /**
    * Collateral Delivery as specified in the Security Agreement
    */
  val ISLA_GMSLA_029_02 = Value
  
  /**
    * Lender to Deliver Securities once Collateral is Delivered
    */
  val ISLA_GMSLA_029_03 = Value
  
  /**
    * Borrower Request
    */
  val ISLA_GMSLA_030_01 = Value
  
  /**
    * Borrower Request/Lender Consent
    */
  val ISLA_GMSLA_030_02 = Value
  
  /**
    * Lender or Borrower Request
    */
  val ISLA_GMSLA_030_03 = Value
  
  /**
    * Pre-approval of Alternative Collateral
    */
  val ISLA_GMSLA_030_04 = Value
  
  /**
    * Manufactured Payment of Amount Such Party Would Be Entitled to Receive
    */
  val ISLA_GMSLA_031_01 = Value
  
  /**
    * Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
    */
  val ISLA_GMSLA_031_02 = Value
  
  /**
    * Manufactured Payment Only in Relation to Loaned Securities
    */
  val ISLA_GMSLA_031_03 = Value
  
  /**
    * Additional Sum to Be Paid to Cover Tax Relief
    */
  val ISLA_GMSLA_031_04 = Value
  
  /**
    * Notice Requirement
    */
  val ISLA_GMSLA_031_05 = Value
  
  /**
    * Standard
    */
  val ISLA_GMSLA_032_01 = Value
  
  /**
    * Reasonable Notice Defined
    */
  val ISLA_GMSLA_032_02 = Value
  
  /**
    * No Right to Instruct
    */
  val ISLA_GMSLA_032_03 = Value
  
  /**
    * Payment Within a Week
    */
  val ISLA_GMSLA_033_01 = Value
  
  /**
    * Payment Within 10 Days
    */
  val ISLA_GMSLA_033_02 = Value
  
  /**
    * Payment Upon Maturity
    */
  val ISLA_GMSLA_033_03 = Value
  
  /**
    * Such Rate as Agreed
    */
  val ISLA_GMSLA_034_01 = Value
  
  /**
    * VAT Added
    */
  val ISLA_GMSLA_034_02 = Value
  
  /**
    * No Deduction
    */
  val ISLA_GMSLA_034_03 = Value
  
  /**
    * No Rate Payable
    */
  val ISLA_GMSLA_034_04 = Value
  
  /**
    * Lender May Terminate a Loan at any Time
    */
  val ISLA_GMSLA_035_01 = Value
  
  /**
    * Lender May Not Terminate a Loan
    */
  val ISLA_GMSLA_035_02 = Value
  
  /**
    * Borrower May Terminate a Loan at Any Time
    */
  val ISLA_GMSLA_036_01 = Value
  
  /**
    * Borrower May Terminate a Loan Subject to Notice
    */
  val ISLA_GMSLA_036_02 = Value
  
  /**
    * Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
    */
  val ISLA_GMSLA_036_03 = Value
  
  /**
    * Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
    */
  val ISLA_GMSLA_036_04 = Value
  
  /**
    * Failure to Deliver Event of Default Applies
    */
  val ISLA_GMSLA_037_01 = Value
  
  /**
    * Failure to Deliver Event of Default does not Apply
    */
  val ISLA_GMSLA_037_02 = Value
  
  /**
    * Failure to Deliver Event of Default does not Apply to Lender
    */
  val ISLA_GMSLA_037_03 = Value
  
  /**
    * 2000 Standard
    */
  val ISLA_GMSLA_038_01 = Value
  
  /**
    * 2010 Standard
    */
  val ISLA_GMSLA_038_02 = Value
  
  /**
    * 2018 Standard
    */
  val ISLA_GMSLA_038_03 = Value
  
  /**
    * 2000 Modified No Lender Close Out
    */
  val ISLA_GMSLA_038_04 = Value
  
  /**
    * 2000 Standard
    */
  val ISLA_GMSLA_039_01 = Value
  
  /**
    * 2010/2018 Standard
    */
  val ISLA_GMSLA_039_02 = Value
  
  /**
    * Hybrid
    */
  val ISLA_GMSLA_039_03 = Value
  
  /**
    * 2000 Standard
    */
  val ISLA_GMSLA_040_01 = Value
  
  /**
    * 2010/2018 Standard
    */
  val ISLA_GMSLA_040_02 = Value
  
  /**
    * Hybrid
    */
  val ISLA_GMSLA_040_03 = Value
  
  /**
    * Standard Costs and Expenses
    */
  val ISLA_GMSLA_041_01 = Value
  
  /**
    * Limitation of Costs and Expenses
    */
  val ISLA_GMSLA_041_02 = Value
  
  /**
    * Expansion of Costs and Expenses
    */
  val ISLA_GMSLA_041_03 = Value
  
  /**
    * No Contractual Set-Off
    */
  val ISLA_GMSLA_042_01 = Value
  
  /**
    * Simple Contractual Set-Off
    */
  val ISLA_GMSLA_042_02 = Value
  
  /**
    * Set-Off with Unascertained Obligations Amendment
    */
  val ISLA_GMSLA_042_03 = Value
  
  /**
    * Standard Paragraph 11.2(a)
    */
  val ISLA_GMSLA_043_01 = Value
  
  /**
    * Amended Paragraph 11.2,(a) applies
    */
  val ISLA_GMSLA_043_02 = Value
  
  /**
    * Consent
    */
  val ISLA_GMSLA_044_01 = Value
  
  /**
    * Consent with Standard Exclusions
    */
  val ISLA_GMSLA_044_02 = Value
  
  /**
    * Consent with Additional Exclusions
    */
  val ISLA_GMSLA_044_03 = Value
  
  /**
    * Pre-approved Assignments
    */
  val ISLA_GMSLA_044_04 = Value
  
  /**
    * Parties May Record All Conversations
    */
  val ISLA_GMSLA_045_01 = Value
  
  /**
    * Parties Agree to Obtain Consent
    */
  val ISLA_GMSLA_045_02 = Value
  
  /**
    * Parties Limit the Conversations that May be Recorded
    */
  val ISLA_GMSLA_045_03 = Value
  
  /**
    * Submission as Evidence
    */
  val ISLA_GMSLA_045_04 = Value
  
  /**
    * Standard Waiver of Immunity Applies
    */
  val ISLA_GMSLA_046_01 = Value
  
  /**
    * Waiver of Immunity may Not Apply
    */
  val ISLA_GMSLA_046_02 = Value
  
  /**
    * No Additional Documentation Required
    */
  val ISLA_GMSLA_047_01 = Value
  
  /**
    * Additional Documentation Required
    */
  val ISLA_GMSLA_047_02 = Value
  
  /**
    * Collateral Transfer Details not included
    */
  val ISLA_GMSLA_048_01 = Value
  
  /**
    * Collateral Transfer Details included
    */
  val ISLA_GMSLA_048_02 = Value
  
  /**
    * Confidentiality Clause
    */
  val ISLA_GMSLA_049_01 = Value
  
  /**
    * Permitted Disclosure Clause
    */
  val ISLA_GMSLA_049_02 = Value
  
  /**
    * Paragraph 20.1 Amended to Refer  Paragraph 6
    */
  val ISLA_GMSLA_050_01 = Value
  
  /**
    * Paragraph 27.2 Amended to refer to the 2010 GMSLA
    */
  val ISLA_GMSLA_050_02 = Value
  
  /**
    * MCTA  Delivery only
    */
  val ISLA_GMSLA_051_01 = Value
  
  /**
    * MCTA  Delivery and Re-Delivery
    */
  val ISLA_GMSLA_051_02 = Value
  
  /**
    * MCTA  Drops to Zero for a Defaulting Party
    */
  val ISLA_GMSLA_051_03 = Value
  
  /**
    * No Non-Reliance Representation
    */
  val ISLA_GMSLA_052_01 = Value
  
  /**
    * Non-Reliance Representation Added
    */
  val ISLA_GMSLA_052_02 = Value
  
  /**
    * No Records and Statements Clause
    */
  val ISLA_GMSLA_053_01 = Value
  
  /**
    * Records and Statements Clause Added
    */
  val ISLA_GMSLA_053_02 = Value
  
  /**
    * Recovery and Resolution not Included
    */
  val ISLA_GMSLA_054_01 = Value
  
  /**
    * Recovery and Resolution Included in GMSLA
    */
  val ISLA_GMSLA_054_02 = Value
  
  /**
    * Recovery and Resolution Included by Protocol
    */
  val ISLA_GMSLA_054_03 = Value
  
  /**
    * Recovery and Resolution Incorporated by Reference
    */
  val ISLA_GMSLA_054_04 = Value
  
  /**
    * Security Agreement Details Included
    */
  val ISLA_GMSLA_055_01 = Value
  
  /**
    * Triparty Services Not Referenced
    */
  val ISLA_GMSLA_056_01 = Value
  
  /**
    * Triparty Services May Apply
    */
  val ISLA_GMSLA_056_02 = Value
}

/**
  * The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction.
  */
object MasterConfirmationAnnexTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER = Value
  
  /**
    * The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER = Value
  
  /**
    * The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies.
    */
  val ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN = Value
  
  /**
    * The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN = Value
  
  /**
    * The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER = Value
  
  /**
    * The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER = Value
  
  /**
    * The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_OPTION_EUROPEAN = Value
  
  /**
    * The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1 = Value
  
  /**
    * The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1 = Value
  
  /**
    * The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_OPTION_JAPAN = Value
  
  /**
    * The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_EQUITY_EUROPEAN_IS = Value
  
  /**
    * The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS = Value
  
  /**
    * The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_INDEX_SHARE_OPTION_AMERICAS = Value
  
  /**
    * The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER = Value
  
  /**
    * The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER = Value
  
  /**
    * The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_SHARE_SWAP_PAN_ASIA = Value
  
  /**
    * The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER = Value
  
  /**
    * The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER = Value
}

/**
  * The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints.
  */
object MasterConfirmationTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation.
    */
  val DJ_CDX_EM = Value("DJ.CDX.EM")
  
  /**
    * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation.
    */
  val DJ_CDX_EM_DIV = Value("DJ.CDX.EM.DIV")
  
  /**
    * Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO.
    */
  val DJ_CDX_NA = Value("DJ.CDX.NA")
  
  /**
    * Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement.
    */
  val DJ_I_TRAXX_EUROPE = Value("DJ.iTraxx.Europe")
  
  /**
    * A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement.
    */
  val EQUITY_AMERICAS = Value
  
  /**
    * A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement.
    */
  val EQUITY_ASIA = Value
  
  /**
    * A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement.
    */
  val EQUITY_EUROPEAN = Value
  
  /**
    * ISDA 1999 Master Credit Derivatives Confirmation Agreement
    */
  val ISDA_1999_CREDIT = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_ASIA = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_EUROPEAN = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_JAPAN = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_NORTH_AMERICAN = Value
  
  /**
    * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2003_CREDIT_SINGAPORE = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_ASIA = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_JAPAN = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST = Value
  
  /**
    * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
    */
  val ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
    */
  val ISDA_2003_STANDARD_CREDIT_ASIA = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign.
    */
  val ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND = Value
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
    */
  val ISDA_2003_STANDARD_CREDIT_EUROPEAN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
    */
  val ISDA_2003_STANDARD_CREDIT_JAPAN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
    */
  val ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign.
    */
  val ISDA_2003_STANDARD_CREDIT_SINGAPORE = Value
  
  /**
    * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2004_CREDIT_SOVEREIGN_ASIA = Value
  
  /**
    * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = Value
  
  /**
    * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2004_CREDIT_SOVEREIGN_JAPAN = Value
  
  /**
    * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN = Value
  
  /**
    * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement.
    */
  val ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = Value
  
  /**
    * The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2004_EQUITY_AMERICAS_INTERDEALER = Value
  
  /**
    * The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1 = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAsiaSovereign.
    */
  val ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA = Value
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
    */
  val ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
    */
  val ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
    */
  val ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN = Value
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
    */
  val ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = Value
  
  /**
    * ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER = Value
  
  /**
    * Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2 = Value
  
  /**
    * The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2005_EQUITY_JAPANESE_INTERDEALER = Value
  
  /**
    * ISDA 2006 Variance Swap Japanese Confirmation Agreement applies.
    */
  val ISDA_2006_VARIANCE_SWAP_JAPANESE = Value
  
  /**
    * ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies.
    */
  val ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER = Value
  
  /**
    * The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2007_EQUITY_EUROPEAN = Value
  
  /**
    * The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_AMERICAS = Value
  
  /**
    * The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1 = Value
  
  /**
    * The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2 = Value
  
  /**
    * The ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_EUROPEAN = Value
  
  /**
    * The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
    */
  val ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1 = Value
  
  /**
    * The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
    */
  val ISDA_2008_DIVIDEND_SWAP_JAPAN = Value
  
  /**
    * The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
    */
  val ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1 = Value
  
  /**
    * The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_AMERICAS = Value
  
  /**
    * The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1 = Value
  
  /**
    * The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2008_EQUITY_JAPAN = Value
  
  /**
    * The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_EQUITY_AMERICAS = Value
  
  /**
    * The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_EQUITY_EUROPEAN_INTERDEALER = Value
  
  /**
    * 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2009_EQUITY_PAN_ASIA = Value
  
  /**
    * The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
    */
  val ISDA_2010_EQUITY_EMEA_INTERDEALER = Value
  
  /**
    * The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies.
    */
  val ISDA_2013_VOLATILITY_SWAP_AMERICAS = Value
  
  /**
    * The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies.
    */
  val ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN = Value
  
  /**
    * The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies.
    */
  val ISDA_2013_VOLATILITY_SWAP_EUROPEAN = Value
  
  /**
    * The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies.
    */
  val ISDA_2013_VOLATILITY_SWAP_JAPANESE = Value
  
  /**
    * Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies.
    */
  val _2003_CREDIT_INDEX = Value("2003CreditIndex")
  
  /**
    * A privately negotiated European Interdealer Master Confirmation Agreement applies.
    */
  val _2004_EQUITY_EUROPEAN_INTERDEALER = Value("2004EquityEuropeanInterdealer")
  
  /**
    * A privately negotiated European Interdealer Master Confirmation Agreement applies.
    */
  val _2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER = Value("2005VarianceSwapEuropeanInterdealer")
  
  /**
    * A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies.
    */
  val _2006_DIVIDEND_SWAP_EUROPEAN = Value("2006DividendSwapEuropean")
  
  /**
    * A European Interdealer Master Confirmation Agreement not defined by ISDA applies.
    */
  val _2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER = Value("2006DividendSwapEuropeanInterdealer")
  
  /**
    * Dummy MCA value mirroring the matrix term value AsiaCorporate.
    */
  val _2014_CREDIT_ASIA = Value("2014CreditAsia")
  
  /**
    * Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate.
    */
  val _2014_CREDIT_ASIA_FINANCIAL = Value("2014CreditAsiaFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate.
    */
  val _2014_CREDIT_AUSTRALIA_NEW_ZEALAND = Value("2014CreditAustraliaNewZealand")
  
  /**
    * Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate.
    */
  val _2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL = Value("2014CreditAustraliaNewZealandFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value EuropeanCorporate.
    */
  val _2014_CREDIT_EUROPEAN = Value("2014CreditEuropean")
  
  /**
    * Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate.
    */
  val _2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL = Value("2014CreditEuropeanCoCoFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate.
    */
  val _2014_CREDIT_EUROPEAN_FINANCIAL = Value("2014CreditEuropeanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value JapanCorporate.
    */
  val _2014_CREDIT_JAPAN = Value("2014CreditJapan")
  
  /**
    * Dummy MCA value mirroring the matrix term value JapanFinancialCorporate.
    */
  val _2014_CREDIT_JAPAN_FINANCIAL = Value("2014CreditJapanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value NorthAmericanCorporate.
    */
  val _2014_CREDIT_NORTH_AMERICAN = Value("2014CreditNorthAmerican")
  
  /**
    * Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate.
    */
  val _2014_CREDIT_NORTH_AMERICAN_FINANCIAL = Value("2014CreditNorthAmericanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term values SingaporeCorporate.
    */
  val _2014_CREDIT_SINGAPORE = Value("2014CreditSingapore")
  
  /**
    * Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate.
    */
  val _2014_CREDIT_SINGAPORE_FINANCIAL = Value("2014CreditSingaporeFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value AsiaSovereign.
    */
  val _2014_CREDIT_SOVEREIGN_ASIA = Value("2014CreditSovereignAsia")
  
  /**
    * Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign.
    */
  val _2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = Value("2014CreditSovereignEmergingEuropeanAndMiddleEastern")
  
  /**
    * Dummy MCA value mirroring the matrix term value JapanSovereign.
    */
  val _2014_CREDIT_SOVEREIGN_JAPAN = Value("2014CreditSovereignJapan")
  
  /**
    * Dummy MCA value mirroring the matrix term value LatinAmericaSovereign.
    */
  val _2014_CREDIT_SOVEREIGN_LATIN_AMERICAN = Value("2014CreditSovereignLatinAmerican")
  
  /**
    * Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign.
    */
  val _2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = Value("2014CreditSovereignWesternEuropean")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
    */
  val _2014_STANDARD_CREDIT_ASIA = Value("2014StandardCreditAsia")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_ASIA_FINANCIAL = Value("2014StandardCreditAsiaFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate.
    */
  val _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND = Value("2014StandardCreditAustraliaNewZealand")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL = Value("2014StandardCreditAustraliaNewZealandFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
    */
  val _2014_STANDARD_CREDIT_EUROPEAN = Value("2014StandardCreditEuropean")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL = Value("2014StandardCreditEuropeanCoCoFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL = Value("2014StandardCreditEuropeanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
    */
  val _2014_STANDARD_CREDIT_JAPAN = Value("2014StandardCreditJapan")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_JAPAN_FINANCIAL = Value("2014StandardCreditJapanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
    */
  val _2014_STANDARD_CREDIT_NORTH_AMERICAN = Value("2014StandardCreditNorthAmerican")
  
  /**
    * Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL = Value("2014StandardCreditNorthAmericanFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate.
    */
  val _2014_STANDARD_CREDIT_SINGAPORE = Value("2014StandardCreditSingapore")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate.
    */
  val _2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL = Value("2014StandardCreditSingaporeFinancial")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardAsiaSovereign.
    */
  val _2014_STANDARD_CREDIT_SOVEREIGN_ASIA = Value("2014StandardCreditSovereignAsia")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
    */
  val _2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN = Value("2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern")
  
  /**
    * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
    */
  val _2014_STANDARD_CREDIT_SOVEREIGN_JAPAN = Value("2014StandardCreditSovereignJapan")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
    */
  val _2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN = Value("2014StandardCreditSovereignLatinAmerican")
  
  /**
    * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
    */
  val _2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN = Value("2014StandardCreditSovereignWesternEuropean")
}

/**
  * The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix.
  */
object MatrixTermEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Matrix Transaction Type of ASIA CORPORATE.
    */
  val ASIA_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
    */
  val ASIA_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of ASIA SOVEREIGN.
    */
  val ASIA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of AUSTRALIA CORPORATE.
    */
  val AUSTRALIA_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
    */
  val AUSTRALIA_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of AUSTRALIA SOVEREIGN.
    */
  val AUSTRALIA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
    */
  val EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
    */
  val EMERGING_EUROPEAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
    */
  val EMERGING_EUROPEAN_CORPORATE_LPN = Value
  
  /**
    * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
    */
  val EMERGING_EUROPEAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
    */
  val EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN = Value
  
  /**
    * Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
    */
  val EUROPEAN_CO_CO_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of EUROPEAN CORPORATE.
    */
  val EUROPEAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
    */
  val EUROPEAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
    */
  val EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE = Value
  
  /**
    * The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets.
    */
  val IVS_1_OPEN_MARKETS = Value
  
  /**
    * Matrix Transaction Type of JAPAN CORPORATE.
    */
  val JAPAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
    */
  val JAPAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of JAPAN SOVEREIGN.
    */
  val JAPAN_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA CORPORATE.
    */
  val LATIN_AMERICA_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA CORPORATE B.
    */
  val LATIN_AMERICA_CORPORATE_BOND = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
    */
  val LATIN_AMERICA_CORPORATE_BOND_OR_LOAN = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
    */
  val LATIN_AMERICA_FINANCIAL_CORPORATE_BOND = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
    */
  val LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN = Value
  
  /**
    * Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
    */
  val LATIN_AMERICA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of NEW ZEALAND CORPORATE.
    */
  val NEW_ZEALAND_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
    */
  val NEW_ZEALAND_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
    */
  val NEW_ZEALAND_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of NORTH AMERICAN CORPORATE.
    */
  val NORTH_AMERICAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
    */
  val NORTH_AMERICAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SINGAPORE CORPORATE.
    */
  val SINGAPORE_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
    */
  val SINGAPORE_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SINGAPORE SOVEREIGN.
    */
  val SINGAPORE_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD ASIA CORPORATE.
    */
  val STANDARD_ASIA_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
    */
  val STANDARD_ASIA_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
    */
  val STANDARD_ASIA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
    */
  val STANDARD_AUSTRALIA_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
    */
  val STANDARD_AUSTRALIA_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
    */
  val STANDARD_AUSTRALIA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
    */
  val STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
    */
  val STANDARD_EMERGING_EUROPEAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
    */
  val STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN = Value
  
  /**
    * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
    */
  val STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
    */
  val STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN = Value
  
  /**
    * Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
    */
  val STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
    */
  val STANDARD_EUROPEAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
    */
  val STANDARD_EUROPEAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
    */
  val STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD JAPAN CORPORATE.
    */
  val STANDARD_JAPAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
    */
  val STANDARD_JAPAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
    */
  val STANDARD_JAPAN_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
    */
  val STANDARD_LATIN_AMERICA_CORPORATE_BOND = Value
  
  /**
    * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
    */
  val STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN = Value
  
  /**
    * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
    */
  val STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND = Value
  
  /**
    * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
    */
  val STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN = Value
  
  /**
    * Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
    */
  val STANDARD_LATIN_AMERICA_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
    */
  val STANDARD_NEW_ZEALAND_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
    */
  val STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
    */
  val STANDARD_NEW_ZEALAND_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
    */
  val STANDARD_NORTH_AMERICAN_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
    */
  val STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
    */
  val STANDARD_SINGAPORE_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
    */
  val STANDARD_SINGAPORE_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
    */
  val STANDARD_SINGAPORE_SOVEREIGN = Value
  
  /**
    * Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
    */
  val STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
    */
  val STANDARD_SUKUK_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
    */
  val STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT = Value
  
  /**
    * Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
    */
  val STANDARD_US_MUNICIPAL_GENERAL_FUND = Value
  
  /**
    * Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
    */
  val STANDARD_US_MUNICIPAL_REVENUE = Value
  
  /**
    * Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
    */
  val STANDARD_WESTERN_EUROPEAN_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
    */
  val SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SUKUK CORPORATE.
    */
  val SUKUK_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
    */
  val SUKUK_FINANCIAL_CORPORATE = Value
  
  /**
    * Matrix Transaction Type of SUKUK SOVEREIGN.
    */
  val SUKUK_SOVEREIGN = Value
  
  /**
    * Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
    */
  val US_MUNICIPAL_FULL_FAITH_AND_CREDIT = Value
  
  /**
    * Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
    */
  val US_MUNICIPAL_GENERAL_FUND = Value
  
  /**
    * Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
    */
  val US_MUNICIPAL_REVENUE = Value
  
  /**
    * Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
    */
  val WESTERN_EUROPEAN_SOVEREIGN = Value
}

/**
  * The enumerated values to specify the identification the form of applicable matrix.
  */
object MatrixTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The ISDA-published Credit Derivatives Physical Settlement Matrix.
    */
  val CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX = Value
  
  /**
    * The ISDA-published Equity Derivatives Matrix.
    */
  val EQUITY_DERIVATIVES_MATRIX = Value
  
  /**
    * The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions.
    */
  val SETTLEMENT_MATRIX = Value
}

/**
  * Represents an enumeration list to identify the Maturity.
  */
object MaturityTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a period from issuance date until now.
    */
  val FROM_ISSUANCE = Value
  
  /**
    * Denotes a period from issuance until maturity date.
    */
  val ORIGINAL_MATURITY = Value
  
  /**
    * Denotes a period from now until maturity date.
    */
  val REMAINING_MATURITY = Value
}

object MoneyMarketTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val CERTIFICATE_OF_DEPOSIT = Value
  
  val COMMERCIAL_PAPER = Value
}

/**
  * Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
  */
object NationalizationOrInsolvencyOrDelistingEventEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The trade is terminated.
    */
  val CANCELLATION_AND_PAYMENT = Value
  
  /**
    * The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
    */
  val NEGOTIATED_CLOSEOUT = Value
}

/**
  * The enumerated values for the natural person's role.
  */
object NaturalPersonRoleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The person who arranged with a client to execute the trade.
    */
  val BROKER = Value
  
  /**
    * Acquirer of the legal title to the financial instrument.
    */
  val BUYER = Value
  
  /**
    * The party or person with legal responsibility for authorization of the execution of the transaction.
    */
  val DECISION_MAKER = Value
  
  /**
    * Person within the firm who is responsible for execution of the transaction.
    */
  val EXECUTION_WITHIN_FIRM = Value
  
  /**
    * Person who is responsible for making the investment decision.
    */
  val INVESTMENT_DECISION_MAKER = Value
  
  /**
    * Seller of the legal title to the financial instrument.
    */
  val SELLER = Value
  
  /**
    * The person who executed the trade.
    */
  val TRADER = Value
}

/**
  * The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
  */
object NegativeInterestRateTreatmentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c).
    */
  val NEGATIVE_INTEREST_RATE_METHOD = Value
  
  /**
    * Per 2021 ISDA Definitions section 6.8.6
    */
  val ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD = Value
  
  /**
    * Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e).
    */
  val ZERO_INTEREST_RATE_METHOD = Value
}

/**
  * The enumerated values to specify the treatment of Non-Cash Dividends.
  */
object NonCashDividendTreatmentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
    */
  val CASH_EQUIVALENT = Value
  
  /**
    * The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
    */
  val POTENTIAL_ADJUSTMENT_EVENT = Value
}

/**
  * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
  */
object NotionalAdjustmentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The adjustments to the number of units are governed by an execution clause.
    */
  val EXECUTION = Value
  
  /**
    * The adjustments to the number of units are governed by a portfolio rebalancing clause.
    */
  val PORTFOLIO_REBALANCING = Value
  
  /**
    * The adjustments to the number of units are not governed by any specific clause.
    */
  val STANDARD = Value
}

/**
  * The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply.
  */
object ObligationCategoryEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * ISDA term 'Bond'.
    */
  val BOND = Value
  
  /**
    * ISDA term 'Bond or Loan'.
    */
  val BOND_OR_LOAN = Value
  
  /**
    * ISDA term 'Borrowed Money'.
    */
  val BORROWED_MONEY = Value
  
  /**
    * ISDA term 'Loan'.
    */
  val LOAN = Value
  
  /**
    * ISDA term 'Payment'.
    */
  val PAYMENT = Value
  
  /**
    * ISDA term 'Reference Obligations Only'.
    */
  val REFERENCE_OBLIGATIONS_ONLY = Value
}

/**
  * The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
  */
object ObservationPeriodDatesEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
    */
  val FIXING_DATE = Value
  
  /**
    * Calculations occur relative to the first day of a calculation period.
    */
  val SET_IN_ADVANCE = Value
  
  /**
    * Calculations occur relative to the last day of a calculation period (set in arrears).
    */
  val STANDARD = Value
}

/**
  * The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
  */
object OptionExerciseStyleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Continuous exercise over a range of dates
    */
  val AMERICAN = Value
  
  /**
    * Multiple specified exercise dates
    */
  val BERMUDA = Value
  
  /**
    * Single Exercise
    */
  val EUROPEAN = Value
}

/**
  * The enumerated values to specify the type or strategy of the option.
  */
object OptionTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
    */
  val CALL = Value
  
  /**
    * A 'payer' option: If you buy a 'payer' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price payer and receive float.
    */
  val PAYER = Value
  
  /**
    * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
    */
  val PUT = Value
  
  /**
    * A 'receiver' option: If you buy a 'receiver' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price receiver and pay float.
    */
  val RECEIVER = Value
  
  /**
    * A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
    */
  val STRADDLE = Value
}

/**
  * The enumerated values to specify how a calculation agent will be determined.
  */
object PartyDeterminationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Calculation Agent is determined by reference to the relevant master agreement.
    */
  val AS_SPECIFIED_IN_MASTER_AGREEMENT = Value
  
  /**
    * The Calculation Agent is determined by reference to the relevant standard terms supplement.
    */
  val AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT = Value
  
  /**
    * Both parties with joined rights to be a calculation agent.
    */
  val BOTH = Value
  
  /**
    * The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d).
    */
  val EXERCISING_PARTY = Value
  
  /**
    * The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e).
    */
  val NON_EXERCISING_PARTY = Value
}

/**
  * The enumeration values associated with party identifier sources.
  */
object PartyIdentifierTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Bank Identifier Code.
    */
  val BIC = Value
  
  /**
    * The ISO 17442:2012 Legal Entity Identifier.
    */
  val LEI = Value
  
  /**
    * The ISO 10383 Market Identifier Code (MIC).
    */
  val MIC = Value
}

/**
  * The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party.
  */
object PartyRoleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Organization responsible for preparing the accounting for the trade.
    */
  val ACCOUNTANT = Value
  
  /**
    * An agent who lends securities of its principals under stock lending arrangements.
    */
  val AGENT_LENDER = Value
  
  /**
    * The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations.
    */
  val ALLOCATION_AGENT = Value
  
  /**
    * The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent.
    */
  val ARRANGING_BROKER = Value
  
  /**
    * The party specified in the related confirmation as Barrier Determination Agent.
    */
  val BARRIER_DETERMINATION_AGENT = Value
  
  /**
    * The party that lends out securities under stock lending arrangements via an Agent Lender.
    */
  val BENEFICIAL_OWNER = Value
  
  /**
    * Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of 'Beneficiary' at the partyTradeInformation level.
    */
  val BENEFICIARY = Value
  
  /**
    * The entity for which the organization supporting the trade's processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn't need to be reported but a firm still wants to specify their own side.
    */
  val BOOKING_PARTY = Value
  
  /**
    * The party that borrows securities under stock lending arrangements.
    */
  val BORROWER = Value
  
  /**
    * Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the 'Buy side'; for that, see the 'Client' role. Corresponds to 'Buyer' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9.
    */
  val BUYER = Value
  
  /**
    * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to 'buyer decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Buy side'; for that, see the 'Client Decision Maker' role.
    */
  val BUYER_DECISION_MAKER = Value
  
  /**
    * The party that provides credit support under English Law.
    */
  val CHARGOR = Value
  
  /**
    * An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term 'client' refers to the organization's role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process.
    */
  val CLEARING_CLIENT = Value
  
  /**
    * A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions.
    */
  val CLEARING_EXCEPTION_PARTY = Value
  
  /**
    * Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use 'Clearing Broker' as synonym.
    */
  val CLEARING_FIRM = Value
  
  /**
    * The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called 'ClearingService'. Some implementations also use the term 'Clearer'.
    */
  val CLEARING_ORGANIZATION = Value
  
  /**
    * Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances.
    */
  val CLIENT = Value
  
  /**
    * The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument.
    */
  val CLIENT_DECISION_MAKER = Value
  
  /**
    * Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data.
    */
  val CONFIRMATION_PLATFORM = Value
  
  /**
    * A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
    */
  val CONTRACTUAL_PARTY = Value
  
  /**
    * Organization officially attached to the counterparty. e.g. partner, branch, subsidiary.
    */
  val COUNTER_PARTY_AFFILIATE = Value
  
  /**
    * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
    */
  val COUNTER_PARTY_ULTIMATE_PARENT = Value
  
  /**
    * An economic counterparty to the trade. Synonym: principal.
    */
  val COUNTERPARTY = Value
  
  /**
    * Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation).
    */
  val CREDIT_SUPPORT_PROVIDER = Value
  
  /**
    * Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal.
    */
  val CUSTODIAN = Value
  
  /**
    * Entity submitting the transaction report to the competent authority.
    */
  val DATA_SUBMITTER = Value
  
  /**
    * The party referenced is specified in the contract confirmation as Determination Party.
    */
  val DETERMINING_PARTY = Value
  
  /**
    * Organization that is disputing the trade or transaction.
    */
  val DISPUTING_PARTY = Value
  
  /**
    * A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
    */
  val DOCUMENT_REPOSITORY = Value
  
  /**
    * The (generally sell-side) organization that executed the trade; the price-making party.
    */
  val EXECUTING_BROKER = Value
  
  /**
    * Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent.
    */
  val EXECUTING_ENTITY = Value
  
  /**
    * The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different.
    */
  val EXECUTION_AGENT = Value
  
  /**
    * The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue.
    */
  val EXECUTION_FACILITY = Value
  
  /**
    * Organization that backs (guarantees) the credit risk of the trade.
    */
  val GUARANTOR = Value
  
  /**
    * The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract.
    */
  val HEDGING_PARTY = Value
  
  /**
    * The party that lends out securities under stock lending arrangements as principal.
    */
  val LENDER = Value
  
  /**
    * The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm.
    */
  val ORDER_TRANSMITTER = Value
  
  /**
    * The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR
    */
  val PTRR_SERVICE_PROVIDER = Value
  
  /**
    * The party that provides credit support under New York Law.
    */
  val PLEDGOR = Value
  
  /**
    * The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism).
    */
  val PRIME_BROKER = Value
  
  /**
    * The trade repository at which the trade was reported previous to the current trade repository.
    */
  val PRIOR_TRADE_REPOSITORY = Value
  
  /**
    * The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade.
    */
  val PUBLICATION_VENUE = Value
  
  /**
    * The party with the regulatory responsibility to report this trade.
    */
  val REPORTING_PARTY = Value
  
  /**
    * Organization officially attached to the reporting party  e.g. partner, branch, subsidiary.
    */
  val REPORTING_PARTY_AFFILIATE = Value
  
  /**
    * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
    */
  val REPORTING_PARTY_ULTIMATE_PARENT = Value
  
  /**
    * The party that receives credit support under New York or English Law.
    */
  val SECURED_PARTY = Value
  
  /**
    * A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the 'Sell side'; for that, see the 'Executing Broker' role. Corresponds to 'Seller' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16.
    */
  val SELLER = Value
  
  /**
    * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to 'seller decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Sell side'; for that, see the 'Trader' person role.
    */
  val SELLER_DECISION_MAKER = Value
  
  /**
    * The organization that makes or receives payments on behalf of the given principal party.
    */
  val SETTLEMENT_AGENT = Value
  
  /**
    * A third-party providing custody, settlement, segregation and reporting services.
    */
  val THIRD_PARTY_CUSTODIAN = Value
  
  /**
    * An organization that maintains records of the trade for regulatory reporting purposes.
    */
  val TRADE_REPOSITORY = Value
  
  /**
    * The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR.
    */
  val TRADE_SOURCE = Value
  
  /**
    * The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory.
    */
  val TRADING_MANAGER = Value
  
  /**
    * An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions.
    */
  val TRADING_PARTNER = Value
  
  /**
    * A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services.
    */
  val TRIPARTY_AGENT = Value
}

/**
  * The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date.
  */
object PayRelativeToEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Payments will occur relative to the last day of each calculation period.
    */
  val CALCULATION_PERIOD_END_DATE = Value
  
  /**
    * Payments will occur relative to the first day of each calculation period.
    */
  val CALCULATION_PERIOD_START_DATE = Value
  
  /**
    * Payments will occur relative to the last Pricing Date of each Calculation Period.
    */
  val LAST_PRICING_DATE = Value
  
  /**
    * Payments will occur relative to the reset date.
    */
  val RESET_DATE = Value
  
  /**
    * Payments will occur relative to the valuation date.
    */
  val VALUATION_DATE = Value
}

/**
  * The enumerated values to specify an interest rate stream payer or receiver party.
  */
object PayerReceiverEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The party identified as the stream payer.
    */
  val PAYER = Value
  
  /**
    * The party identified as the stream receiver.
    */
  val RECEIVER = Value
}

/**
  * The enumerated values to specify the origin of a performance transfer
  */
object PerformanceTransferTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val COMMODITY = Value
  
  val CORRELATION = Value
  
  val DIVIDEND = Value
  
  val EQUITY = Value
  
  val INTEREST = Value
  
  val VARIANCE = Value
  
  val VOLATILITY = Value
}

/**
  * The enumerated values to specify the period, e.g. day, week.
  */
object PeriodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Day
    */
  val D = Value
  
  /**
    * Month
    */
  val M = Value
  
  /**
    * Week
    */
  val W = Value
  
  /**
    * Year
    */
  val Y = Value
}

/**
  * The enumerated values to specify a time period containing the additional value of Term.
  */
object PeriodExtendedEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
    */
  val C = Value
  
  /**
    * Day
    */
  val D = Value
  
  /**
    * Hour
    */
  val H = Value
  
  /**
    * Month
    */
  val M = Value
  
  /**
    * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
    */
  val T = Value
  
  /**
    * Week
    */
  val W = Value
  
  /**
    * Year
    */
  val Y = Value
}

/**
  * The enumeration values to specify a time period containing additional values such as Term.
  */
object PeriodTimeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Period measured in hours.
    */
  val HOUR = Value
  
  /**
    * Period measured in minutes.
    */
  val MINUTE = Value
  
  /**
    * Period measured in seconds.
    */
  val SECOND = Value
}

/**
  * The enumeration values associated with person identifier sources.
  */
object PersonIdentifierTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Alien Registration Number, number assigned by a social security agency to identify a non-resident person.
    */
  val ARNU = Value
  
  /**
    * Passport Number, number assigned by an authority to identify the passport number of a person.
    */
  val CCPT = Value
  
  /**
    * Customer Identification Number, number assigned by an issuer to identify a customer.
    */
  val CUST = Value
  
  /**
    * Drivers License Number, number assigned by an authority to identify a driver's license.
    */
  val DRLC = Value
  
  /**
    * Employee Identification Number, number assigned by a registration authority to an employee.
    */
  val EMPL = Value
  
  /**
    * National Identity Number, number assigned by an authority to identify the national identity number of a person..
    */
  val NIDN = Value
  
  /**
    * Natural Person Identifier. To identify the person who is acting as private individual, not as business entity. Used for regulatory reporting.
    */
  val NPID = Value
  
  /**
    * Privacy Law Identifier. It refers to the DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
    */
  val PLID = Value
  
  /**
    * Social Security Number, number assigned by an authority to identify the social security number of a person.
    */
  val SOSE = Value
  
  /**
    * Tax Identification Number, number assigned by a tax authority to identify a person.
    */
  val TXID = Value
}

object PositionEventIntentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
    */
  val CORPORATE_ACTION_ADJUSTMENT = Value
  
  /**
    * The intent is to Decrease the quantity of the position.
    */
  val DECREASE = Value
  
  /**
    * The intent is to Increase the quantity of the position.
    */
  val INCREASE = Value
  
  /**
    * The intent is to Exercise a position or part of a position.
    */
  val OPTION_EXERCISE = Value
  
  /**
    * The intent is to form a position from a fully formed contract.
    */
  val POSITION_CREATION = Value
  
  /**
    * The intent is to transfer the position to another clearing member.
    */
  val TRANSFER = Value
  
  /**
    * The intent is to update the valuation of the position.
    */
  val VALUATION = Value
}

/**
  * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
  */
object PositionStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The position has been cancelled, in case of a cancellation event following an execution.
    */
  val CANCELLED = Value
  
  /**
    * The position has been closed, in case of a termination event.
    */
  val CLOSED = Value
  
  /**
    * The position has been executed, which is the point at which risk has been transferred.
    */
  val EXECUTED = Value
  
  /**
    * Contract has been formed, in case position is on a contractual product.
    */
  val FORMED = Value
  
  /**
    * The position has settled, in case product is subject to settlement after execution, such as securities.
    */
  val SETTLED = Value
}

/**
  * The enumerated values to specify the premium type for forward start options.
  */
object PremiumTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val FIXED = Value
  
  val POST_PAID = Value
  
  val PRE_PAID = Value
  
  val VARIABLE = Value
}

/**
  * Enumerated values to specify whether the price is expressed in absolute or relative terms.
  */
object PriceExpressionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The price is expressed as an absolute amount.
    */
  val ABSOLUTE_TERMS = Value
  
  /**
    * Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
    */
  val PAR_VALUE_FRACTION = Value
  
  /**
    * Denotes a price expressed per number of options.
    */
  val PER_OPTION = Value
  
  /**
    * The price is expressed in percentage of the notional amount.
    */
  val PERCENTAGE_OF_NOTIONAL = Value
}

object PriceOperandEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ACCRUED_INTEREST = Value
  
  val COMMISSION = Value
  
  val FORWARD_POINT = Value
}

object PriceTimingEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The last price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
    */
  val CLOSING_PRICE = Value
  
  /**
    * The first price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
    */
  val OPENING_PRICE = Value
}

/**
  * Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations.
  */
object PriceTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a price expressed as a cash amount in a given currency to purchase a unit of an asset (e.g. a security or a commodity).
    */
  val ASSET_PRICE = Value
  
  /**
    * Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500.
    */
  val CASH_PRICE = Value
  
  /**
    * Denotes a price expressed as the weighted average of all pairwise correlation coefficients.
    */
  val CORRELATION = Value
  
  /**
    * Denotes a price expressed as the dividend payment from a index or share.
    */
  val DIVIDEND = Value
  
  /**
    * Denotes a rate to convert one currency or other measure of value to another. Foreign Exchange rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP.
    */
  val EXCHANGE_RATE = Value
  
  /**
    * Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount.
    */
  val INTEREST_RATE = Value
  
  /**
    * Denotes a price expressed as the the arithmetic average of the squared differences from the mean value of an observable price.
    */
  val VARIANCE = Value
  
  /**
    * Denotes a price expressed as the the square root of the arithmetic average of the squared differences from the mean value of an observable price.
    */
  val VOLATILITY = Value
}

/**
  * Provides the enumerated values to specify the product identifier source.
  */
object ProductIdTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
    */
  val BBGID = Value
  
  /**
    * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
    */
  val BBGTICKER = Value
  
  /**
    * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
    */
  val CUSIP = Value
  
  /**
    * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
    */
  val FIGI = Value
  
  /**
    * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
    */
  val ISDACRP = Value
  
  /**
    * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
    */
  val ISIN = Value
  
  /**
    * The name of the product.
    */
  val NAME = Value
  
  /**
    * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
    */
  val OTHER = Value
  
  /**
    * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
    */
  val RIC = Value
  
  /**
    * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well.
    */
  val SEDOL = Value
  
  /**
    * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
    */
  val SICOVAM = Value
  
  /**
    * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
    */
  val UPI = Value
  
  /**
    * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
    */
  val WERTPAPIER = Value
}

/**
  * The enumerated values to specify the types of listed derivative options.
  */
object PutCallEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
    */
  val CALL = Value
  
  /**
    * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
    */
  val PUT = Value
}

/**
  * Represents the enumerated values to specify a logical quantification, i.e. either All or Any.
  */
object QuantifierEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies that the condition in the scope of the quantifier is true of every member of the domain i.e. every one of the elements in scope.
    */
  val ALL = Value
  
  /**
    * Specifies that the condition in the scope of the quantifier is true of at least one member of the domain i.e. one or more of the elements in scope.
    */
  val ANY = Value
}

/**
  * Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number.
  */
object QuantityChangeDirectionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * When the quantity should go down by the specified amount.
    */
  val DECREASE = Value
  
  /**
    * When the quantity should go up by the specified amount.
    */
  val INCREASE = Value
  
  /**
    * When the quantity should be replaced by the specified amount.
    */
  val REPLACE = Value
}

/**
  * The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
  */
object QuotationRateTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * An ask rate.
    */
  val ASK = Value
  
  /**
    * A bid rate.
    */
  val BID = Value
  
  /**
    * If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
    */
  val EXERCISING_PARTY_PAYS = Value
  
  /**
    * A mid-market rate.
    */
  val MID = Value
}

/**
  * The enumerated values to specify the side from which perspective a value is quoted.
  */
object QuotationSideEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes a value as the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val AFTERNOON = Value
  
  /**
    * Denotes a value 'asked' by a seller for an asset, i.e. the value at which a seller is willing to sell.
    */
  val ASK = Value
  
  /**
    * Denotes a value 'bid' by a buyer for an asset, i.e. the value a buyer is willing to pay.
    */
  val BID = Value
  
  /**
    * Denotes a value as the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val CLOSING = Value
  
  /**
    * Denotes a value as the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val HIGH = Value
  
  /**
    * Denotes a value as the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val INDEX = Value
  
  /**
    * Denotes a value as the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val LOCATIONAL_MARGINAL = Value
  
  /**
    * Denotes a value as the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val LOW = Value
  
  /**
    * Denotes a value as the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MARGINAL_HOURLY = Value
  
  /**
    * Denotes a value as the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MARKET_CLEARING = Value
  
  /**
    * Denotes a value as the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MEAN_OF_BID_AND_ASK = Value
  
  /**
    * Denotes a value as the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MEAN_OF_HIGH_AND_LOW = Value
  
  /**
    * Denotes a value as the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MID = Value
  
  /**
    * Denotes a value as the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val MORNING = Value
  
  /**
    * Denotes a value as the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val NATIONAL_SINGLE = Value
  
  /**
    * Denotes a value as the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val OSP = Value
  
  /**
    * Denotes a value as the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val OFFICIAL = Value
  
  /**
    * Denotes a value as the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val OPENING = Value
  
  /**
    * Denotes a value as the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val SETTLEMENT = Value
  
  /**
    * Denotes a value as the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
    */
  val SPOT = Value
  
  /**
    * Denotes a value as the Non-volume Weighted Average of prices effective on the Pricing Date.
    */
  val UN_WEIGHTED_AVERAGE = Value
  
  /**
    * Denotes a value as the Volume Weighted Average of prices effective on the Pricing Date.
    */
  val WEIGHTED_AVERAGE = Value
}

/**
  * The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
  */
object QuotationStyleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * When quotation style is 'PointsUpFront', the initialPoints element of the Credit Default Swap feeLeg should be populated
    */
  val POINTS_UP_FRONT = Value
  
  /**
    * When quotation style is 'Price', the marketPrice element of the Credit Default Swap feeLeg should be populated
    */
  val PRICE = Value
  
  /**
    * When quotation style is 'TradedSpread', the marketFixedRate element of the Credit Default Swap feeLeg should be populated
    */
  val TRADED_SPREAD = Value
}

/**
  * The enumerated values to specify how an exchange rate is quoted.
  */
object QuoteBasisEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The amount of currency1 for one unit of currency2
    */
  val CURRENCY_1_PER_CURRENCY_2 = Value
  
  /**
    * The amount of currency2 for one unit of currency1
    */
  val CURRENCY_2_PER_CURRENCY_1 = Value
}

/**
  * The enumerated values to specify the methods for converting rates from one basis to another.
  */
object RateTreatmentEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g).
    */
  val BOND_EQUIVALENT_YIELD = Value
  
  /**
    * Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h).
    */
  val MONEY_MARKET_YIELD = Value
}

/**
  * Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to 'Issuer', the rating in the 
  Issuer Criteria has priority or is used if there is no Asset criteria. If set to 'Asset', the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
  */
object RatingPriorityResolutionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes that the Asset Criteria has priority.
    */
  val ASSET = Value
  
  /**
    * Denotes that average rating should be used if several criteria apply.
    */
  val AVERAGE = Value
  
  /**
    * Denotes that highest rating should be used if several criteria apply.
    */
  val HIGHEST = Value
  
  /**
    * Denotes that the Issuer Criteria has priority.
    */
  val ISSUER = Value
  
  /**
    * Denotes that lowest rating should be used if several criteria apply.
    */
  val LOWEST = Value
}

/**
  * The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors.
  */
object RealisedVarianceMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * For a return on day T, the observed prices on both T and T-1 must be in range
    */
  val BOTH = Value
  
  /**
    * For a return on day T, the observed price on T must be in range.
    */
  val LAST = Value
  
  /**
    * For a return on day T, the observed price on T-1 must be in range.
    */
  val PREVIOUS = Value
}

/**
  * The enumeration of the account level for the billing summary.
  */
object RecordAmountTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ACCOUNT_TOTAL = Value
  
  val GRAND_TOTAL = Value
  
  val PARENT_TOTAL = Value
}

/**
  * Represents the enumeration values to specify the role of the party in relation to a regulatory initial margin call.
  */
object RegIMRoleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates 'Pledgor' party of initial margin call.
    */
  val PLEDGOR = Value
  
  /**
    * Indicates 'Secured' party of initial margin call.
    */
  val SECURED = Value
}

/**
  * Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation.
  */
object RegMarginTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates Non Regulatory Initial margin or independent amount
    */
  val NON_REG_IM = Value
  
  /**
    * Indicates Regulatory Initial Margin
    */
  val REG_IM = Value
  
  /**
    * Indicates Variation Margin
    */
  val VM = Value
}

/**
  * A duration code for a Repo (or Securities Lending) transaction. There are many business and market rules that are derived from the duration of the transaction.
  */
object RepoDurationEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Indicates that a contract is classified as overnight, meaning that there is one business day difference between the start and end date of the contract. Business rule: When the repo is overnight, the number of business days between the spot and forward value dates must be one. Forward leg must be specified.
    */
  val OVERNIGHT = Value
  
  /**
    * Indicates that a contract is a regular term contract, with a start date and an end date. Business rule: When the repo is 'Term', both spot and forward legs must be specified.
    */
  val TERM = Value
}

/**
  * The enumerated values to specify whether resets occur relative to the first or last day of a calculation period.
  */
object ResetRelativeToEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Resets occur relative to the last day of a calculation period.
    */
  val CALCULATION_PERIOD_END_DATE = Value
  
  /**
    * Resets occur relative to the first day of a calculation period.
    */
  val CALCULATION_PERIOD_START_DATE = Value
}

/**
  * The enumerated values to specify the type of a resource (e.g. document).
  */
object ResourceTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Document describing the legal terms of a transaction.
    */
  val CONFIRMATION = Value
  
  /**
    * Document providing supplemental material economic terms to the FpML data representation. The initial intended usage is to fulfill the CFTC Part 45 rule requirement to report ‘Any other terms(s) of the swap matched or affirmed by the counterparties in verifying the swap’ when the reporting is done via the generic FpML representation.
    */
  val SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS = Value
  
  /**
    * Document describing the economic characteristics of a transaction.
    */
  val TERM_SHEET = Value
}

/**
  * The enumerated values to specify the form of the restructuring credit event that is applicable to the credit default swap.
  */
object RestructuringEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Restructuring (Section 4.7) and Modified Restructuring Maturity Limitation and Conditionally Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
    */
  val MOD_MOD_R = Value
  
  /**
    * Restructuring (Section 4.7) and Restructuring Maturity Limitation and Fully Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
    */
  val MOD_R = Value
  
  /**
    * Restructuring as defined in the applicable ISDA Credit Derivatives Definitions. (2003 or 2014).
    */
  val R = Value
}

/**
  * The enumerated values to specify the type of return associated the equity payout.
  */
object ReturnTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Price return, i.e. excluding dividends.
    */
  val PRICE = Value
  
  /**
    * Total return, i.e. including dividend and price components.
    */
  val TOTAL = Value
}

/**
  * The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month.
  */
object RollConventionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Rolls on month end dates irrespective of the length of the month and the previous roll day.
    */
  val EOM = Value
  
  /**
    * Rolling weekly on a Friday
    */
  val FRI = Value
  
  /**
    * Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions.
    */
  val FRN = Value
  
  /**
    * IMM Settlement Dates. The third Wednesday of the (delivery) month.
    */
  val IMM = Value
  
  /**
    * The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement.
    */
  val IMMAUD = Value
  
  /**
    * The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers' Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification.
    */
  val IMMCAD = Value
  
  /**
    * The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month.
    */
  val IMMNZD = Value
  
  /**
    * Rolling weekly on a Monday.
    */
  val MON = Value
  
  /**
    * The roll convention is not required. For example, in the case of a daily calculation frequency.
    */
  val NONE = Value
  
  /**
    * Rolling weekly on a Saturday
    */
  val SAT = Value
  
  /**
    * Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month
    */
  val SFE = Value
  
  /**
    * Rolling weekly on a Sunday
    */
  val SUN = Value
  
  /**
    * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday.
    */
  val TBILL = Value
  
  /**
    * Rolling weekly on a Thursday
    */
  val THU = Value
  
  /**
    * Rolling weekly on a Tuesday
    */
  val TUE = Value
  
  /**
    * Rolling weekly on a Wednesday
    */
  val WED = Value
  
  /**
    * Rolls on the 1st day of the month.
    */
  val _1 = Value("1")
  
  /**
    * Rolls on the 10th day of the month.
    */
  val _10 = Value("10")
  
  /**
    * Rolls on the 11th day of the month.
    */
  val _11 = Value("11")
  
  /**
    * Rolls on the 12th day of the month.
    */
  val _12 = Value("12")
  
  /**
    * Rolls on the 13th day of the month.
    */
  val _13 = Value("13")
  
  /**
    * Rolls on the 14th day of the month.
    */
  val _14 = Value("14")
  
  /**
    * Rolls on the 15th day of the month.
    */
  val _15 = Value("15")
  
  /**
    * Rolls on the 16th day of the month.
    */
  val _16 = Value("16")
  
  /**
    * Rolls on the 17th day of the month.
    */
  val _17 = Value("17")
  
  /**
    * Rolls on the 18th day of the month.
    */
  val _18 = Value("18")
  
  /**
    * Rolls on the 19th day of the month.
    */
  val _19 = Value("19")
  
  /**
    * Rolls on the 2nd day of the month.
    */
  val _2 = Value("2")
  
  /**
    * Rolls on the 20th day of the month.
    */
  val _20 = Value("20")
  
  /**
    * Rolls on the 21st day of the month.
    */
  val _21 = Value("21")
  
  /**
    * Rolls on the 22nd day of the month.
    */
  val _22 = Value("22")
  
  /**
    * Rolls on the 23rd day of the month.
    */
  val _23 = Value("23")
  
  /**
    * Rolls on the 24th day of the month.
    */
  val _24 = Value("24")
  
  /**
    * Rolls on the 25th day of the month.
    */
  val _25 = Value("25")
  
  /**
    * Rolls on the 26th day of the month.
    */
  val _26 = Value("26")
  
  /**
    * Rolls on the 27th day of the month.
    */
  val _27 = Value("27")
  
  /**
    * Rolls on the 28th day of the month.
    */
  val _28 = Value("28")
  
  /**
    * Rolls on the 29th day of the month.
    */
  val _29 = Value("29")
  
  /**
    * Rolls on the 3rd day of the month.
    */
  val _3 = Value("3")
  
  /**
    * Rolls on the 30th day of the month.
    */
  val _30 = Value("30")
  
  /**
    * Rolls on the 4th day of the month.
    */
  val _4 = Value("4")
  
  /**
    * Rolls on the 5th day of the month.
    */
  val _5 = Value("5")
  
  /**
    * Rolls on the 6th day of the month.
    */
  val _6 = Value("6")
  
  /**
    * Rolls on the 7th day of the month.
    */
  val _7 = Value("7")
  
  /**
    * Rolls on the 8th day of the month.
    */
  val _8 = Value("8")
  
  /**
    * Rolls on the 9th day of the month.
    */
  val _9 = Value("9")
}

/**
  * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
  */
object RollSourceCalendarEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val FUTURE = Value
  
  val LISTED_OPTION = Value
}

/**
  * The enumerated values to specify the rounding direction and precision to be used in the rounding of a number.  Used by function cdm.base.math.RoundToPrecision.
  */
object RoundingDirectionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A fractional number will be rounded down to the specified number of decimal places (the precision). For example, 5.29 and 5.25 rounded down to 1 decimal place are 5.2 and 5.2 respectively.
    */
  val DOWN = Value
  
  /**
    * A fractional number will be rounded either up or down to the specified number of decimal places (the precision) depending on its value. For example, 5.24 would be rounded down to 5.2 and 5.25 would be rounded up to 5.3 if a precision of 1 decimal place were specified.
    */
  val NEAREST = Value
  
  /**
    * A fractional number will be rounded up to the specified number of decimal places (the precision). For example, 5.21 and 5.25 rounded up to 1 decimal place are 5.3 and 5.3 respectively.
    */
  val UP = Value
}

/**
  * How often is rounding performed
  */
object RoundingFrequencyEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Rounding is done on each day
    */
  val DAILY = Value
  
  /**
    * Rounding is done only at the end of the period
    */
  val PERIOD_END = Value
}

/**
  * The enumerated values to specify the rounding direction when rounding of a number to nearest.  Used by function cdm.base.math.RoundToNearest.
  */
object RoundingModeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A number will be rounded down to the specified nearest number. For example, 529 rounded down to the nearest 10 is 520.
    */
  val DOWN = Value
  
  /**
    * A number will be rounded up to the specified nearest number. For example, 521 rounded up to the nearest 10 is 530.
    */
  val UP = Value
}

/**
  * The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events.
  */
object ScheduledTransferEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A cash flow corresponding to a corporate action event.
    */
  val CORPORATE_ACTION = Value
  
  /**
    * A cash flow corresponding to the periodic accrued interests.
    */
  val COUPON = Value
  
  /**
    * A cashflow resulting from a credit event.
    */
  val CREDIT_EVENT = Value
  
  /**
    * A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument.
    */
  val DIVIDEND_RETURN = Value
  
  /**
    * A cash flow associated with an exercise lifecycle event.
    */
  val EXERCISE = Value
  
  /**
    * A cash flow corresponding to the return of the fixed interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    */
  val FIXED_RATE_RETURN = Value
  
  /**
    * A cash flow corresponding to the return of the floating interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    */
  val FLOATING_RATE_RETURN = Value
  
  /**
    * A cash flow corresponding to the compensation for missing assets due to the rounding of digits in the original number of assets to be delivered as per payout calculation.
    */
  val FRACTIONAL_AMOUNT = Value
  
  /**
    * A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    */
  val INTEREST_RETURN = Value
  
  /**
    * Net interest across payout components. Applicable to products such as interest rate swaps.
    */
  val NET_INTEREST = Value
  
  /**
    * A cash flow corresponding to a performance return.  The settlementOrigin attribute on the Transfer should point to the relevant Payout defining the performance calculation.
    */
  val PERFORMANCE = Value
  
  /**
    * A cashflow which amount typically corresponds to the notional amount of the contract for various business reasons e.g. PhysicalSettlement, PrincipalExchange etc. else to a portion of the notional amount interim payments e.g. for the purpose of resetting the Notional Amount of a Cross Currency Swap variying leg, as part of a final Principal Exchange related to a Non-Deliverable currency leg, etc.
    */
  val PRINCIPAL_PAYMENT = Value
}

/**
  * The enumerated values to specify the relevant settled entity matrix source.
  */
object SettledEntityMatrixSourceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation.
    */
  val CONFIRMATION_ANNEX = Value
  
  /**
    * The term is not applicable.
    */
  val NOT_APPLICABLE = Value
  
  /**
    * The Settled Entity Matrix published by the Index Publisher.
    */
  val PUBLISHER = Value
}

/**
  * Defines the settlement centre for a securities transaction.
  */
object SettlementCentreEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * ClearStream Banking Luxembourg
    */
  val CLEARSTREAM_BANKING_LUXEMBOURG = Value
  
  /**
    * Euroclear Bank
    */
  val EUROCLEAR_BANK = Value
}

/**
  * The enumerated values to specify the settlement rate options as specified in the Annex A to the 1998 FX and Currency Options Definitions.
  */
object SettlementRateOptionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Buenos Aires and New York) which appears on the Reuters Screen BNAR Page at the close of business in Buenos Aires on that Rate Calculation Date.
    */
  val ARS_BNAR_ARS01 = Value("ARS.BNAR/ARS01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Indicative Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Argentine Peso/U.S. Dollar markets for the purpose of determining the EMTA ARS Indicative Survey Rate).
    */
  val ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04 = Value("ARS.EMTA.INDICATIVE.SURVEY.RATE/ARS04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Industry Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions in Buenos Aires that are active participants in the Argentine Peso/U.S. Dollar spot markets for the purpose of determining the EMTA ARS Industry Survey Rate).
    */
  val ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03 = Value("ARS.EMTA.INDUSTRY.SURVEY.RATE/ARS03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the volume weighted average Argentine Peso/U.S. Dollar Rate of all trades executed in the electronic market for a Rate Calculation Day expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, reported by the Mercado Abierto Electronico (the 'MAE') at approximately 3:00 pm, Buenos Aires time, and published on the FOREX-MAE Page as the 'PPN' rate ('Promedio Ponderado Noticiado') on www.mae.com.ar on that Rate Calculation Date.
    */
  val ARS_MAE_ARS05 = Value("ARS.MAE/ARS05")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day quoted by Banco de la Nacion (in accordance with the Convertibility Law of March 27, 1991 and Regulatory Decree No. 529/91 of April 1, 1991, as may be amended from time to time) for that Rate Calculation Date.
    */
  val ARS_OFFICIAL_RATE_ARS02 = Value("ARS.OFFICIAL.RATE/ARS02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) which appears on the Reuters Screen BRBY Page under the caption 'INTBK FLTING (LAST)' at approximately 11:00 a.m., Sao Paulo time, on that Rate Calculation Date.
    */
  val BRL_BRBY_BRL01 = Value("BRL.BRBY/BRL01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 12:00 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Indicative Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Brazilian Real/U.S. Dollar markets for the purpose of determining the EMTA BRL Indicative Survey Rate).
    */
  val BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13 = Value("BRL.EMTA.INDICATIVE.SURVEY.RATE/BRL13")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 3:45 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Industry Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions in Brazil that are active participants in the Brazilian Real/U.S. Dollar spot markets for the purpose of determining the EMTA BRL Industry Survey Rate).
    */
  val BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12 = Value("BRL.EMTA.INDUSTRY.SURVEY.RATE/BRL12")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil in the 'Diario Oficial da Uniao' on the first Business Day following that Rate Calculation Date.
    */
  val BRL_OFFICIAL_RATE_BRL02 = Value("BRL.OFFICIAL.RATE/BRL02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
    */
  val BRL_PCOT_COMMERCIAL_BRL03 = Value("BRL.PCOT-COMMERCIAL/BRL03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
    */
  val BRL_PCOT_FLOATING_BRL04 = Value("BRL.PCOT-FLOATING/BRL04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX-800 ('Consulta de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidade' or 'Rates for Accounting Purposes') by approximately 6:00 p.m., Sao Paulo time, on that Rate Calculation Date.
    */
  val BRL_PTAX_BRL09 = Value("BRL.PTAX/BRL09")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date. 23
    */
  val BRL_PTAX_COMMERCIAL_BRFR_BRL06 = Value("BRL.PTAX-COMMERCIAL.BRFR/BRL06")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'L' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Livre' and commonly known as 'Comercial') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
    */
  val BRL_PTAX_COMMERCIAL_BRL05 = Value("BRL.PTAX-COMMERCIAL/BRL05")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on the SISBACEN Data System which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date.
    */
  val BRL_PTAX_FLOATING_BRFR_BRL08 = Value("BRL.PTAX-FLOATING.BRFR/BRL08")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'F' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Flutuante') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
    */
  val BRL_PTAX_FLOATING_BRL07 = Value("BRL.PTAX-FLOATING/BRL07")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen BCCH Page under the caption 'OBSERVADO' at 10:00 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
    */
  val CLP_BCCH_CLP01 = Value("CLP.BCCH/CLP01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val CLP_CHILD_INFORMAL_CLP02 = Value("CLP.CHILD-INFORMAL/CLP02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val CLP_CHILD_INTERBANK_CLP03 = Value("CLP.CHILD-INTERBANK/CLP03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILD Page on the first Business Day following that Rate Calculation Date.
    */
  val CLP_CHILD_OBSERVADO_CLP04 = Value("CLP.CHILD-OBSERVADO/CLP04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val CLP_CHILG_INFORMAL_CLP05 = Value("CLP.CHILG-INFORMAL/CLP05")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val CLP_CHILG_INTERBANK_CLP06 = Value("CLP.CHILG-INTERBANK/CLP06")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILG Page under 'OBSERVADO' at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
    */
  val CLP_CHILG_OBSERVADO_CLP07 = Value("CLP.CHILG-OBSERVADO/CLP07")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar 'observado' rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Banco Central de Chile (www.bcentral.cl) as the 'Dolar Observado' (Dollar Observado) rate by not later than 10:30 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
    */
  val CLP_DOLAR_OBS_CLP10 = Value("CLP.DOLAR.OBS/CLP10")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Santiago time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA CLP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chilean Peso/U.S. Dollar markets for the purpose of determining the EMTA CLP Indicative Survey Rate).
    */
  val CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11 = Value("CLP.EMTA.INDICATIVE.SURVEY.RATE/CLP11")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate, expressed as the amount of Chilean Pesos per one U.S. Dollar (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York), calculated in accordance with Title I, Chapter 1 Number 6 of the Compendium of International Exchange Norms of the Banco Central de Chile and published by the Banco Central de Chile at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
    */
  val CLP_OFFICIAL_RATE_CLP08 = Value("CLP.OFFICIAL.RATE/CLP08")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Telerate Page 38942 opposite the caption 'Observado' at the Specified Time, if any, on the first Business Day following the Rate Calculation Date.
    */
  val CLP_TELERATE_38942_CLP09 = Value("CLP.TELERATE.38942/CLP09")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar official fixing rate, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days reported by the People's Bank of China, Beijing, People's Republic of China, which appears on the Reuters Screen 'SAEC' Page opposite the symbol 'USDCNY=' at approximately 9:15 a.m., Beijing time, on that Rate Calculation Date.
    */
  val CNY_SAEC_CNY01 = Value("CNY.SAEC/CNY01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC CNY Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chinese Renminbi/U.S. Dollar markets for the purpose of determining the SFEMC CNY Indicative Survey Rate).
    */
  val CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02 = Value("CNY.SFEMC.INDICATIVE.SURVEY.RATE/CNY02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day (unless such day is not a Business Day in New York, then for settlement on the first succeeding day that is a Business Day in Bogota and New York) reported by the Colombian Banking Superintendency which appears on the Reuters Screen CO/COL03 Page opposite the caption 'TRCM' ('Tasa de Cierre Representative del Mercado' or closing market price) at 12:00 noon, Bogota time, on the first Business Day following that Rate Calculation Date.
    */
  val COP_CO_COL03_COP01 = Value("COP.CO/COL03/COP01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:30 a.m., Bogota time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA COP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Colombian Peso/U.S. Dollar markets for the purpose of determining the EMTA COP Indicative Survey Rate).
    */
  val COP_EMTA_INDICATIVE_SURVEY_RATE_COP03 = Value("COP.EMTA.INDICATIVE.SURVEY.RATE/COP03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day reported by the Colombian Financial Superintendency (www.banrep.gov.co) as the 'Tasa Representativa del Mercado (TRM)' (also referred to as the 'Tasa de Cambio Representativa del Mercado' (TCRM)) by not later than 10:30 a.m., Bogota time, on the first Business Day following that Rate Calculation Date.
    */
  val COP_TRM_COP02 = Value("COP.TRM/COP02")
  
  /**
    * the Spot Rate for a Rate Calculation Date will be the Reference Currency/U.S. Dollar exchange rate, expressed as the amount of Reference Currency per one U.S. Dollar, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's price of a Specified Company's American Depositary Receipt or American Depositary Receipts (the 'ADR' or 'ADRs', as appropriate) and the price of the local share or shares of such Specified Company of the same type and in the same quantity represented by such ADR or ADRs, as the case may be (the 'Share' or 'Shares', as appropriate). The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of (A) in the case where one ADR represents less than one Share, its bid and offer price (in the Reference Currency) for one Share and its bid and offer price (in U.S. Dollars) for the number of ADRs which represent such Share and (B) in all other cases, its bid and offer price (in the Reference Currency) for the Share or Shares, as the case may be, and its bid and offer price (in U.S. Dollars) for one ADR. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (1) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Share or Shares, as the case may be, and (2) the arithmetic mean of the midpoint of the bid and offer prices quoted in U.S. Dollars by each Reference Dealer for such ADR or ADRs, as the case may be, subject to an adjustment, if any, by the Calculation Agent to reduce the effect of momentary disparities in the prices of the Share or Shares and the ADR or ADRs, as appropriate. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
    */
  val CURRENCY_IMPLIED_RATE__ADR__CURA1 = Value("CURRENCY-IMPLIED.RATE.(ADR)/CURA1")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency exchange rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date for that day's price of Local Assets. The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of its bid and offer price (in both the Reference Currency and the Settlement Currency) for an amount of Local Assets whose face value equals the Specified Amount. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (A) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Local Assets and (B) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Settlement Currency by each Reference Dealer for such Local Assets. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
    */
  val CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2 = Value("CURRENCY-IMPLIED.RATE.(LOCAL.ASSET)/CURA2")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency Specified Rate, expressed as the amount of the Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date agreed upon by the parties on or prior to that Rate Calculation Date (or, if different, the day on which rates for that date would, in the ordinary course, be published or announced).
    */
  val CURRENCY_MUTUAL_AGREEMENT_CURA3 = Value("CURRENCY-MUTUAL.AGREEMENT/CURA3")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date. The Calculation Agent will request the Specified Office of each of the Reference Dealers to provide a firm quotation of its Specified Rate for a transaction where the amount of Reference Currency equals the Specified Amount. If four quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates, without regard to the Specified Rates having the highest and lowest value. If exactly three quotations are provided, the rate for a Rate Calculation Date will be the Specified Rate provided by the Reference Dealer that remains after disregarding the Specified Rates having the highest and lowest values. For this purpose, if more than one quotation has the same highest value or lowest value, then the Specified Rate of one of such quotations shall be disregarded. If exactly two quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates. If only one quotation is provided, the rate for a Rate Calculation Date will be the Specified Rate quoted by that Reference Dealer. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on that Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
    */
  val CURRENCY_REFERENCE_DEALERS_CURA4 = Value("CURRENCY-REFERENCE.DEALERS/CURA4")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be determined by the Calculation Agent on the basis of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, in a legal and customary wholesale market in which there is no, or minimal, Governmental Authority controls or interference, except as a participant in such market.
    */
  val CURRENCY_WHOLESALE_MARKET_CURA5 = Value("CURRENCY-WHOLESALE.MARKET/CURA5")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Ecuadorian Sucre/U.S. Dollar Specified Rate, expressed as the amount of Ecuadorian Sucres per one U.S. Dollar, for settlement in one Business Day (where such day is a Business Day in Guayaquil and New York) which appears on Reuters Screen DNRP Page at 12:00 noon, Guayaquil time, on that Rate Calculation Date.
    */
  val ECS_DNRP_ECS01 = Value("ECS.DNRP/ECS01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'IDR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val IDR_ABS_IDR01 = Value("IDR.ABS/IDR01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar weighted average spot rate in the interbank market based on traded IDR/USD spot foreign exchange transactions during a specified time period which are captured on a real time basis, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, published by Bank Indonesia at approximately 10:00 a.m., Jakarta time, on that Rate Calculation Date as the Jakarta Interbank Spot Dollar Rate USD - IDR on Bank Indonesia's website or otherwise made available by Bank Indonesia (or its successor as administrator).
    */
  val IDR_JISDOR_IDR04 = Value("IDR.JISDOR/IDR04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC IDR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indonesian Rupiah/U.S. Dollar markets for the purpose of determining the SFEMC IDR Indicative Survey Rate).
    */
  val IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02 = Value("IDR.SFEMC.INDICATIVE.SURVEY.RATE/IDR02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar implied spot rate expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of that rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val IDR_VWAP_IDR03 = Value("IDR.VWAP/IDR03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BOIJ Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
    */
  val ILS_BOIJ_ILS01 = Value("ILS.BOIJ/ILS01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen FXIL Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
    */
  val ILS_FXIL_ILS02 = Value("ILS.FXIL/ILS02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, reported by Financial Benchmarks India Pvt. Ltd. (www.fbil.org.in) at approximately 1:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
    */
  val INR_FBIL_INR01 = Value("INR.FBIL/INR01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days reported by the Reserve Bank of India which appears on the Reuters Screen RBIB Page at approximately 12:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
    */
  val INR_RBIB_INR01 = Value("INR.RBIB/INR01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC INR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indian Rupee/U.S. Dollar markets for the purpose of determining the SFEMC INR Indicative Survey Rate).
    */
  val INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02 = Value("INR.SFEMC.INDICATIVE.SURVEY.RATE/INR02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen KEBEY Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val KRW_KEBEY_KRW01 = Value("KRW.KEBEY/KRW01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on the Reuters Screen KFTC18 Page to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
    */
  val KRW_KFTC18_KRW02 = Value("KRW.KFTC18/KRW02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC KRW Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Korean Won/U.S. Dollar markets for the purpose of determining the SFEMC KRW Indicative Survey Rate).
    */
  val KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04 = Value("KRW.SFEMC.INDICATIVE.SURVEY.RATE/KRW04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on Telerate Page 45644 to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
    */
  val KRW_TELERATE_45644_KRW03 = Value("KRW.TELERATE.45644/KRW03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 1:00 p.m., Almaty time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA KZT Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Kazakhstan Tenge/U.S. Dollar markets for the purpose of determining the EMTA KZT Indicative Survey Rate).
    */
  val KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02 = Value("KZT.EMTA.INDICATIVE.SURVEY.RATE/KZT02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar weighted average rate, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day reported by the Kazakhstan Stock Exchange (www.kase.kz) at approximately 11:00 am, Almaty time, on that Rate Calculation Date.
    */
  val KZT_KASE_KZT01 = Value("KZT.KASE/KZT01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Lebanese Pound/U.S. Dollar Specified Rate, expressed as the amount of Lebanese Pounds per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BDLX Page as of 12:00 noon, Beirut time, on that Rate Calculation Date.
    */
  val LBP_BDLX_LBP01 = Value("LBP.BDLX/LBP01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Moroccan Dirham/U.S. Dollar Specified Rate, expressed as the amount of Moroccan Dirham per one U.S. Dollar, for settlement in two Business Days reported by the Central Bank of Morocco as of 1:00 p.m., Rabat time, on that Rate Calculation Date.
    */
  val MAD_OFFICIAL_RATE_MAD01 = Value("MAD.OFFICIAL.RATE/MAD01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Mexican Pesos/U.S. Dollar Specified rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on the Reuters Screen BNMX Page opposite the caption 'Fix' at the close of business in Mexico City on that Rate Calculation Date.
    */
  val MXP_BNMX_MXP01 = Value("MXP.BNMX/MXP01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by Banco de Mexico in the Official Gazette of the Federation pursuant to the 'Disposiciones aplicables a la determinacion del tipo de Cambio para solventar obligaciones denominadas en moneda extranjera pagaderas en la Republica Mexicana' (Rules applicable to determine the exchange rate to pay obligations denominated in foreign currency payable in Mexico) on the first Business Day following that Rate Calculation Date.
    */
  val MXP_FIXING_RATE_MXP02 = Value("MXP.FIXING.RATE/MXP02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on Reuters Screen MEX01 Page under the heading 'MXNFIX=RR', at the close of business in Mexico City on that Rate Calculation Date.
    */
  val MXP_MEX01_MXP03 = Value("MXP.MEX01/MXP03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by the Bolsa Mexicana de Valores, S.A. de C.V. (as established in Section 2 of the 'Resolution concerning the exchange rate applicable for calculating the Mexican Peso equivalent of principal and interest of Mexican Treasury Notes denominated in foreign currency and payable in Mexican Pesos' published in the Diario Oficial de la Federacion on November 11, 1991) in the Movimiento Diario del Mercado de Valores de la Bolsa Mexicana de Valores, S.A. de C.V. under the heading 'Movimiento Diario del Mercado de Valores' on that Rate Calculation Date.
    */
  val MXP_PUBLISHED_MXP04 = Value("MXP.PUBLISHED/MXP04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore, which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'MYR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val MYR_ABS_MYR01 = Value("MYR.ABS/MYR01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar reference rate, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, calculated and reported by Bank Negara Malaysia as its Kuala Lumpur USD/MYR Reference Rate, which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 3:30 p.m., Kuala Lumpur time, on that Rate Calculation Date.
    */
  val MYR_KL_REF_MYR04 = Value("MYR.KL.REF/MYR04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by Persatuan Pasaran Kewangan Malaysia (ACI - Malaysia), which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 11:10 a.m., Kuala Lumpur time, on that Rate Calculation Date.
    */
  val MYR_PPKM_MYR03 = Value("MYR.PPKM/MYR03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC MYR Indicative Survey Methodology (which means a methodology, dated as of July 15, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Malaysian Ringgit/U.S. Dollar markets for the purpose of determining the SFEMC MYR Indicative Survey Rate).
    */
  val MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02 = Value("MYR.SFEMC.INDICATIVE.SURVEY.RATE/MYR02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Peruvian Soles per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Lima time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA PEN Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Peruvian Sol/U.S. Dollar markets for the purpose of determining the EMTA PEN Indicative Survey Rate).
    */
  val PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04 = Value("PEN.EMTA.INDICATIVE.SURVEY.RATE/PEN04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar average exchange rate in the interbank market expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day reported by the Banco Central de Reserva del Peru (www.bcrp.gob.pe) as the 'Tipo de Cambio Interbancario Promedio' at approximately 2:00 p.m., Lima time, on that Rate Calculation Date.
    */
  val PEN_INTERBANK_AVE_PEN05 = Value("PEN.INTERBANK.AVE/PEN05")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar fixing rate (mid market last), expressed as the amount of Peruvian Sols per one U.S. Dollar, for settlement on that same day which appears on the Reuters Screen PDSB Page opposite the caption 'PEN=' as of 12:00 noon, Lima time, on that Rate Calculation Date.
    */
  val PEN_PDSB_PEN01 = Value("PEN.PDSB/PEN01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the midpoint of the Peruvian Sol/U.S. Dollar closing weighted average bid and offer ('compra y venta') exchange rates expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day, reported by the Superintendencia de Banca, Seguros y AFP (www.sbs.gob.pe) of the Republic of Peru at approximately 5:00 p.m., Lima time, on that Rate Calculation Date.
    */
  val PEN_WT_AVE_PEN03 = Value("PEN.WT.AVE/PEN03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, sponsored by Bankers Association of the Philippines (www.bap.org.ph) as its 'BAP AM Weighted Average Rate' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
    */
  val PHP_BAPPESO_PHP06 = Value("PHP.BAPPESO/PHP06")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Philippine Dealing System PDEX which appears on the Reuters Screen PDSPESO Page to the right of the caption 'AM WT AVE' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
    */
  val PHP_PDSPESO_PHP06 = Value("PHP.PDSPESO/PHP06")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Reuters Screen PHPESO Page at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
    */
  val PHP_PHPESO_PHP01 = Value("PHP.PHPESO/PHP01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PHP Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Philippine Peso/U.S. Dollar markets for the purpose of determining the SFEMC PHP Indicative Survey Rate).
    */
  val PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05 = Value("PHP.SFEMC.INDICATIVE.SURVEY.RATE/PHP05")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 15439 at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
    */
  val PHP_TELERATE_15439_PHP03 = Value("PHP.TELERATE.15439/PHP03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 2920 at the Specified Time, if any, on that Rate Calculation Date.
    */
  val PHP_TELERATE_2920_PHP02 = Value("PHP.TELERATE.2920/PHP02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar reference rate expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days reported by the State Bank of Pakistan (www.sbp.org.pk) at approximately 2:30 pm, Karachi time, on that Rate Calculation Date.
    */
  val PKR_SBPK_PKR01 = Value("PKR.SBPK/PKR01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. Singapore time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PKR Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Pakistani Rupee/U.S. Dollar markets for the purpose of determining the SFEMC PKR Indicative Survey Rate).
    */
  val PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02 = Value("PKR.SFEMC.INDICATIVE.SURVEY.RATE/PKR02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar Specified Rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPQ Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val PLZ_NBPQ_PLZ01 = Value("PLZ.NBPQ/PLZ01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar fixing rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPR Page at the Specified Time, if any, on that Rate Calculation Date.
    */
  val PLZ_NBPR_PLZ02 = Value("PLZ.NBPR/PLZ02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, calculated by the Chicago Mercantile Exchange ('CME') and as published on CME's website, which appears on the Reuters Screen EMTA Page, at approximately 1:30 p.m., Moscow time, on that Rate Calculation Date. The Spot Rate shall be calculated by the CME pursuant to the Chicago Mercantile Exchange / EMTA, Inc. Daily Russian Ruble Per U.S. Dollar Reference Rate Methodology (which means a methodology, effective as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions in Russia that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the RUB CME-EMTA Rate).
    */
  val RUB_CME_EMTA_RUB03 = Value("RUB.CME-EMTA/RUB03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, as published on EMTA's web site (www.emta.org) at approximately 2:45 p.m., Moscow time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA RUB Indicative Survey Methodology (which means a methodology dated as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the EMTA RUB Indicative Survey Rate).
    */
  val RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04 = Value("RUB.EMTA.INDICATIVE.SURVEY.RATE/RUB04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MICEXFRX Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
    */
  val RUB_MICEXFRX_RUB01 = Value("RUB.MICEXFRX/RUB01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MMVB Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
    */
  val RUB_MMVB_RUB02 = Value("RUB.MMVB/RUB02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Singapore Dollar/U.S. Dollar spot rate expressed as the amount of Singapore Dollar per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val SGD_VWAP_SGD3 = Value("SGD.VWAP/SGD3")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Slovak Koruna/U.S. Dollar Specified Rate, expressed as the amount of Slovak Koruna per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Slovakia which appears on the Reuters Screen NBSB Page as of 11:40 a.m., Bratislava time, on that Rate Calculation Date.
    */
  val SKK_NBSB_SKK01 = Value("SKK.NBSB/SKK01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Thai Baht/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Thai Bhaht per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'THB' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val THB_ABS_THB01 = Value("THB.ABS/THB01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Thai Baht / U.S. Dollar spot rate expressed as the amount of Thai Baht per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val THB_VWAP_THB01 = Value("THB.VWAP/THB01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC TWD Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Taiwanese Dollar/U.S. Dollar markets for the purpose of determining the SFEMC TWD Indicative Survey Rate).
    */
  val TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04 = Value("TWD.SFEMC.INDICATIVE.SURVEY.RATE/TWD04")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Reuters Screen TAIFX1 Page under the heading 'Spot' as of 11:00 a.m. Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time on that Rate Calculation Date.
    */
  val TWD_TAIFX1_TWD03 = Value("TWD.TAIFX1/TWD03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Telerate Page 6161 under the heading 'Spot' as of 11:00 a.m., Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time, on that Rate Calculation Date.
    */
  val TWD_TELERATE_6161_TWD01 = Value("TWD.TELERATE.6161/TWD01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen TFEMA Page as of 11:00 a.m., Taipei time, on that Rate Calculation Date.
    */
  val TWD_TFEMA_TWD02 = Value("TWD.TFEMA/TWD02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 2:00 p.m., Kiev time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA UAH Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Ukrainian Hryvnia / U.S. Dollar markets for the purpose of determining the EMTA UAH Indicative Survey Rate).
    */
  val UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03 = Value("UAH.EMTA.INDICATIVE.SURVEY.RATE/UAH03")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day calculated by Thomson Reuters pursuant to the EMTA UAH Industry Survey Methodology, which rate appears on EMTA's website (www.emta.org) and on Thomson Reuters Page EMTAUAHFIX at approximately 11:30 am, Kiev time, on that Rate Calculation Date. The 'EMTA UAH Industry Survey Methodology' as used herein means the methodology dated as of March 16, 2009, for a centralized industry wide survey of financial institutions in the Ukrainian Hryvnia/U.S. Dollar spot market for the purposes of determining the EMTA UAH Industry Survey Rate.
    */
  val UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02 = Value("UAH.EMTA.INDUSTRY.SURVEY.RATE/UAH02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar spot rate, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day reported by GFI Brokers on Thomson Reuters Page GFIU by 9:30 am, London time, on that Rate Calculation Date.
    */
  val UAH_GFI_UAH01 = Value("UAH.GFI/UAH01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the midpoint of the Venezuelan Bolivar /U.S. Dollar Tipo de Cambio De Referencia buying and selling rates, expressed as the amount of Venezuelan Bolivar per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central de Venezuela (www.bcv.org.ve) at approximately 5:00 p.m., Caracas time, on that Rate Calculation Date.
    */
  val VEF_FIX_VEF01 = Value("VEF.FIX/VEF01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days reported by the Association of Banks in Singapore, which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'VND' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
    */
  val VND_ABS_VND01 = Value("VND.ABS/VND01")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days which appears on Reuters Screen VNDFIX=VN Page under the caption 'Spot' and to the right of the caption 'Average' at approximately 11:00 am, Hanoi time, on that Rate Calculation Date.
    */
  val VND_FX_VND02 = Value("VND.FX/VND02")
  
  /**
    * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon as thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC VND Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Vietnamese Dong/U.S. Dollar markets for the purpose of determining the SFEMC VND Indicative Survey Rate).
    */
  val VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03 = Value("VND.SFEMC.INDICATIVE.SURVEY.RATE/VND03")
}

/**
  * The enumeration values to specify how the option is to be settled when exercised.
  */
object SettlementTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
    */
  val CASH = Value
  
  /**
    * Allow use of either Cash or Physical settlement without prior Election.
    */
  val CASH_OR_PHYSICAL = Value
  
  /**
    * Allow Election of either Cash or Physical settlement.
    */
  val ELECTION = Value
  
  /**
    * The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
    */
  val PHYSICAL = Value
}

/**
  * The enumerated values to specify the consequences of extraordinary events relating to the underlying.
  */
object ShareExtraordinaryEventEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The trade continues such that the underlying now consists of the New Shares and/or the Other Consideration, if any, and the proceeds of any redemption, if any, that the holder of the underlying Shares would have been entitled to.
    */
  val ALTERNATIVE_OBLIGATION = Value
  
  /**
    * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments may not be made to account solely for changes in volatility, expected dividends, stock loan rate or liquidity.
    */
  val CALCULATION_AGENT = Value
  
  /**
    * The trade is cancelled and a cancellation fee will be paid by one party to the other.
    */
  val CANCELLATION_AND_PAYMENT = Value
  
  /**
    * If this is a Share-for-Combined merger event (Shares are replaced with New Shares and Other Consideration), then different treatment can be applied to each component if the parties have specified this.
    */
  val COMPONENT = Value
  
  /**
    * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments to account for changes in volatility, expected dividends, stock loan rate or liquidity are allowed.
    */
  val MODIFIED_CALCULATION_AGENT = Value
  
  /**
    * The trade will be adjusted by the Calculation Agent in accordance with the adjustments made by any exchange on which options on the underlying are listed.
    */
  val OPTIONS_EXCHANGE = Value
  
  /**
    * Applies to Basket Transactions. The portion of the Basket made up by the affected Share will be cancelled and a cancellation fee will be paid from one party to the other. The remainder of the trade continues.
    */
  val PARTIAL_CANCELLATION_AND_PAYMENT = Value
}

/**
  * The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined.
  */
object SpecifiedEntityClauseEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val BANKRUPTCY = Value
  
  val CREDIT_EVENT_UPON_MERGER = Value
  
  val CROSS_DEFAULT = Value
  
  val DEFAULT_UNDER_SPECIFIED_TRANSACTION = Value
}

/**
  * The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
  */
object SpecifiedEntityTermsEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Any Affiliate is a Specified Entity.
    */
  val ANY_AFFILIATE = Value
  
  /**
    * Any Material Subsidiary.
    */
  val MATERIAL_SUBSIDIARY = Value
  
  /**
    * The Specified Entity is provided.
    */
  val NAMED_SPECIFIED_ENTITY = Value
  
  /**
    * No Specified Entity is provided
    */
  val NONE = Value
  
  /**
    * Non standard Specified Entity terms are provided.
    */
  val OTHER_SPECIFIED_ENTITY = Value
}

/**
  * Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
  */
object SpreadCalculationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val PAR_PAR = Value
  
  val PROCEEDS = Value
}

/**
  * The enumerated values to specify a long or short spread value.
  */
object SpreadScheduleTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Represents a Long Spread Schedule. Spread schedules defined as 'Long' will be applied to Long Positions.
    */
  val LONG = Value
  
  /**
    * Represents a Short Spread Schedule. Spread schedules defined as 'Short' will be applied to Short Positions.
    */
  val SHORT = Value
}

/**
  * The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
  */
object StandardSettlementStyleEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * This trade is a candidate for settlement netting.
    */
  val NET = Value
  
  /**
    * These trades have been paired and are a candidate for settlement netting.
    */
  val PAIR_AND_NET = Value
  
  /**
    * This trade will settle using standard predetermined funds settlement instructions.
    */
  val STANDARD = Value
  
  /**
    * This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
    */
  val STANDARD_AND_NET = Value
}

object StandardizedScheduleAssetClassEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val COMMODITY = Value
  
  val CREDIT = Value
  
  val EQUITY = Value
  
  val FOREIGN_EXCHANGE = Value
  
  val INTEREST_RATES = Value
}

object StandardizedScheduleProductClassEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val BASIS_SWAP = Value
  
  val CONTRACT_FOR_DIFFERENCE = Value
  
  val CORRELATION_SWAP = Value
  
  val CREDIT_NTH_TO_DEFAULT = Value
  
  val CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND = Value
  
  val CROSS_CURRENCY_SWAP = Value
  
  val DELIVERABLE_FORWARD = Value
  
  val DELIVERABLE_OPTION = Value
  
  val DELIVERABLE_OPTION_F = Value
  
  val DELIVERABLE_SWAP = Value
  
  val DIVIDEND_SWAP = Value
  
  val FIXED_FLOAT_SWAP = Value
  
  val FORWARD = Value
  
  val FORWARD_RATE_AGREEMENT = Value
  
  val IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG = Value
  
  val INDEX_CDS = Value
  
  val INDEX_TRANCHE = Value
  
  val NON_DELIVERABLE_CROSS_CURRENCY_SWAP = Value
  
  val NON_DELIVERABLE_FORWARD = Value
  
  val NON_DELIVERABLE_OPTION = Value
  
  val OPTION = Value
  
  val SINGLE_NAME_CREDIT_DEFAULT_SWAP = Value
  
  val SWAP = Value
  
  val SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS = Value
  
  val SWAPS_AND_PORTFOLIO_SWAPS = Value
  
  val SWAPTION = Value
  
  val SWAPTION_STRADDLE = Value
  
  val VARIANCE_SWAP = Value
  
  val VOLATILITY_SWAP = Value
}

/**
  * The enumerated values to specify how to deal with a non standard calculation period within a swap stream.
  */
object StubPeriodTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period.
    */
  val LONG_FINAL = Value
  
  /**
    * If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period.
    */
  val LONG_INITIAL = Value
  
  /**
    * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream.
    */
  val SHORT_FINAL = Value
  
  /**
    * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream.
    */
  val SHORT_INITIAL = Value
}

/**
  * Represents an enumeration list to identify the type of supranational entity issuing the asset.
  */
object SupraNationalIssuerTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Specifies International Financial Institution.
    */
  val INTERNATIONAL_ORGANISATION = Value
  
  /**
    * Specifies Multilateral Bank or Multilateral Development Bank.
    */
  val MULTILATERAL_BANK = Value
}

/**
  * Represents the enumerated values to specify taxonomy sources.
  */
object TaxonomySourceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Represents the ISO 10962 Classification of Financial Instruments code.
    */
  val CFI = Value
  
  /**
    * Represents the EMIR Article 9 Asset Definition Identifier code.
    */
  val EMIR = Value
  
  /**
    * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules.
    */
  val EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS = Value
  
  /**
    * Represents the ISDA Collateral Asset Definition Identifier code.
    */
  val ICAD = Value
  
  /**
    * Represents the ISDA product taxonomy.
    */
  val ISDA = Value
  
  /**
    * Represents the Monetary Authority of Singapore (MAS) as a taxonomy source.
    */
  val MAS = Value
  
  /**
    * Denotes a user-specific scheme or taxonomy or other external sources not listed here.
    */
  val OTHER = Value
  
  /**
    * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities.Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
    */
  val UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS = Value
  
  /**
    * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
    */
  val US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS = Value
}

/**
  * The enumerated values to specify the type of telephone number, e.g. work vs. mobile.
  */
object TelephoneTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A number used primarily for work-related facsimile transmissions.
    */
  val FAX = Value
  
  /**
    * A number on a mobile telephone that is often or usually used for work-related calls. This type of number can be used for urgent work related business when a work number is not sufficient to contact the person or firm.
    */
  val MOBILE = Value
  
  /**
    * A number used primarily for non work-related calls. (Normally this type of number would be used only as an emergency backup number, not as a regular course of business).
    */
  val PERSONAL = Value
  
  /**
    * A number used primarily for work-related calls. Includes home office numbers used primarily for work purposes.
    */
  val WORK = Value
}

object TerminationCurrencyConditionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * A currency that is freely available.
    */
  val FREELY_AVAILABLE = Value
  
  /**
    * A currency in which payments would be due under one or more Transactions.
    */
  val PAYMENTS_DUE = Value
  
  /**
    * A currency in which payments would be due under one or more Transactions and that is freely available.
    */
  val PAYMENTS_DUE_AND_FREELY_AVAILABLE = Value
  
  /**
    * Termination Currency Conditions are specified.
    */
  val SPECIFIED = Value
}

/**
  * The enumerated values to specify points in the day when option exercise and valuation can occur.
  */
object TimeTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The time is determined as provided in the relevant Master Confirmation.
    */
  val AS_SPECIFIED_IN_MASTER_CONFIRMATION = Value
  
  /**
    * The official closing time of the exchange on the valuation date.
    */
  val CLOSE = Value
  
  /**
    * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
    */
  val DERIVATIVES_CLOSE = Value
  
  /**
    * The time at which the official settlement price is determined.
    */
  val OSP = Value
  
  /**
    * The official opening time of the exchange on the valuation date.
    */
  val OPEN = Value
  
  /**
    * The time specified in the element equityExpirationTime or valuationTime (as appropriate).
    */
  val SPECIFIC_TIME = Value
  
  /**
    * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
    */
  val XETRA = Value
}

/**
  * The enumeration values to qualify the allowed units of time.
  */
object TimeUnitEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Day
    */
  val DAY = Value
  
  /**
    * Hour
    */
  val HOUR = Value
  
  /**
    * Minute
    */
  val MINUTE = Value
  
  /**
    * Month
    */
  val MONTH = Value
  
  /**
    * Second
    */
  val SECOND = Value
  
  /**
    * Week
    */
  val WEEK = Value
  
  /**
    * Year
    */
  val YEAR = Value
}

/**
  * Defines the enumerated values to specify the nature of a trade identifier.
  */
object TradeIdentifierTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val UNIQUE_SWAP_IDENTIFIER = Value
  
  val UNIQUE_TRANSACTION_IDENTIFIER = Value
}

/**
  * The enumeration values to specify how the transfer will settle, e.g. DvP.
  */
object TransferSettlementEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
    */
  val DELIVERY_VERSUS_DELIVERY = Value
  
  /**
    * Settlement in which the transfer of the asset and the cash settlement are simultaneous.
    */
  val DELIVERY_VERSUS_PAYMENT = Value
  
  /**
    * No central settlement.
    */
  val NOT_CENTRAL_SETTLEMENT = Value
  
  /**
    * Simultaneous transfer of cashflows.
    */
  val PAYMENT_VERSUS_PAYMENT = Value
}

/**
  * The enumeration values to specify the transfer status.
  */
object TransferStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The transfer is disputed.
    */
  val DISPUTED = Value
  
  /**
    * The transfer has been instructed.
    */
  val INSTRUCTED = Value
  
  /**
    * The transfer has been netted into a separate Transfer.
    */
  val NETTED = Value
  
  /**
    * The transfer is pending instruction.
    */
  val PENDING = Value
  
  /**
    * The transfer has been settled.
    */
  val SETTLED = Value
}

/**
  * The enumerated values to specify the time of day which would be considered for valuing the knock event.
  */
object TriggerTimeTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * At any time during the Knock Determination period (continuous barrier).
    */
  val ANYTIME = Value
  
  /**
    * The close of trading on a day would be considered for valuation.
    */
  val CLOSING = Value
}

/**
  * The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
  */
object TriggerTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The underlier price must be equal to the Trigger level.
    */
  val EQUAL = Value
  
  /**
    * The underlier price must be equal to or greater than the Trigger level.
    */
  val EQUAL_OR_GREATER = Value
  
  /**
    * The underlier price must be equal to or less than the Trigger level.
    */
  val EQUAL_OR_LESS = Value
  
  /**
    * The underlier price must be greater than the Trigger level.
    */
  val GREATER = Value
  
  /**
    * The underlier price must be less than the Trigger level.
    */
  val LESS = Value
}

/**
  * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
  */
object UK_EMIR_EligibleCollateralEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
    */
  val UK_EMIR_TYPE_A = Value
  
  /**
    * Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
    */
  val UK_EMIR_TYPE_B = Value
  
  /**
    * Denotes debt securities issued by the central government of the United Kingdom or the Bank of England.
    */
  val UK_EMIR_TYPE_C = Value
  
  /**
    * Denotes debt securities issued by United Kingdom regional governments or local authorities whose exposures are treated as exposures to the central government of the United Kingdom in accordance with Article 115(2) of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_D = Value
  
  /**
    * Denotes debt securities issued by United Kingdom public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of the United Kingdom in accordance with Article 116(4) of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_E = Value
  
  /**
    * Denotes debt securities issued by United Kingdom regional governments or local authorities other than those referred to in (TypeD).
    */
  val UK_EMIR_TYPE_F = Value
  
  /**
    * Denotes debt securities issued by United Kingdom public sector entities other than those referred to in (TypeE).
    */
  val UK_EMIR_TYPE_G = Value
  
  /**
    * Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_H = Value
  
  /**
    * Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_I = Value
  
  /**
    * Denotes debt securities issued by third countries' governments or central banks.
    */
  val UK_EMIR_TYPE_J = Value
  
  /**
    * Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
    */
  val UK_EMIR_TYPE_K = Value
  
  /**
    * Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
    */
  val UK_EMIR_TYPE_L = Value
  
  /**
    * Denotes debt securities issued by credit institutions or investment firms including bonds admitted to the register of regulated covered bonds maintained under Regulation 7(1)(b) of the Regulated Covered Bonds Regulations 2008 (SI 2008/346).
    */
  val UK_EMIR_TYPE_M = Value
  
  /**
    * Denotes corporate bonds.
    */
  val UK_EMIR_TYPE_N = Value
  
  /**
    * Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
    */
  val UK_EMIR_TYPE_O = Value
  
  /**
    * Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_P = Value
  
  /**
    * Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
    */
  val UK_EMIR_TYPE_Q = Value
  
  /**
    * Denotes shares or units in undertakings for UK UCITS, provided that the conditions set out in Article 5 of EU Regulation 2016/2251 (as modified by the Technical Standards (European Market Infrastructure) (EU Exit) (No. 3) Instrument 2019) are met.
    */
  val UK_EMIR_TYPE_R = Value
}

/**
  * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
  */
object US_CFTC_PR_EligibleCollateralEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes immediately available cash funds denominated in USD, a major currency, a currency of settlement for the uncleared swap.
    */
  val US_CFTC_PR_TYPE_1 = Value
  
  /**
    * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury.
    */
  val US_CFTC_PR_TYPE_2 = Value
  
  /**
    * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, a U.S. government agency (other than the U.S. Department of Treasury) whose obligations are fully guaranteed by the full faith and credit of the United States government.
    */
  val US_CFTC_PR_TYPE_3 = Value
  
  /**
    * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator.
    */
  val US_CFTC_PR_TYPE_4 = Value
  
  /**
    * Denotes a publicly traded debt security issued by, or an asset-backed security fully guaranteed as to the timely payment of principal and interest by, a U.S. Government-sponsored enterprise that is operating with capital support or another form of direct financial assistance received from the U.S. government that enables the repayments of the U.S. Government-sponsored enterprise's eligible securities.
    */
  val US_CFTC_PR_TYPE_5_A = Value
  
  /**
    * Denotes a publicly traded debt security, but not an asset backed security, that is investment grade and issued by a U.S. Government-sponsored enterprise that is not operating with capital support or another form of direct financial assistance received from the U.S. government.
    */
  val US_CFTC_PR_TYPE_5_B = Value
  
  /**
    * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the Bank for International Settlements, the International Monetary Fund, or a multilateral development bank.
    */
  val US_CFTC_PR_TYPE_6 = Value
  
  /**
    * Denotes publicly-traded debt, but not an asset backed security, that is investment grade and is not a debt security issued by a  U.S. Government-sponsored enterprise. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
    */
  val US_CFTC_PR_TYPE_7 = Value
  
  /**
    * Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
    */
  val US_CFTC_PR_TYPE_8_A = Value
  
  /**
    *  Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 1500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
    */
  val US_CFTC_PR_TYPE_8_B = Value
  
  /**
    * Denotes a publicly traded common equity security that is included in an index that a regulated swap entity's supervisor in a foreign jurisdiction recognizes for purposes of including publicly traded common equity as initial margin under applicable regulatory policy, if held in that foreign jurisdiction. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
    */
  val US_CFTC_PR_TYPE_8_C = Value
  
  /**
    * Denotes securities in the form of redeemable securities in a pooled investment fund representing the security-holder's proportional interest in the fund's net assets and that are issued and redeemed only on the basis of the market value of the fund's net assets prepared each business day after the security-holder makes its investment commitment or redemption request to the fund, if the fund's investments are limited to the following: (A) securities that are issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury, and immediately-available cash funds denominated in U.S. dollars; or (B) securities denominated in a common currency and issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator, and immediately-available cash funds denominated in the same currency; and (C) assets of the fund may not be transferred through securities lending, securities borrowing, repurchase agreements, reverse repurchase agreements, or other means that involve the fund having rights to acquire the same or similar assets from the transferee.
    */
  val US_CFTC_PR_TYPE_9 = Value
  
  /**
    * Denotes Gold.
    */
  val US_CTFC_PR_TYPE_10 = Value
}

/**
  * The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement.
  */
object ValuationMethodEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val AVERAGE_BLENDED_HIGHEST = Value
  
  val AVERAGE_BLENDED_MARKET = Value
  
  val AVERAGE_HIGHEST = Value
  
  val AVERAGE_MARKET = Value
  
  val BLENDED_HIGHEST = Value
  
  val BLENDED_MARKET = Value
  
  val HIGHEST = Value
  
  val MARKET = Value
}

/**
  * Source for the valuation of the transaction by the valuation party.
  */
object ValuationSourceEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Central Counterparty's Valuation
    */
  val CENTRAL_COUNTERPARTY = Value
}

/**
  * Method used for the valuation of the transaction by the valuation party.
  */
object ValuationTypeEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Mark-to-Market
    */
  val MARK_TO_MARKET = Value
  
  /**
    * Mark-to-Model
    */
  val MARK_TO_MODEL = Value
}

object WarehouseIdentityEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * The DTCC Trade Information Warehouse Gold service
    */
  val DTCC_TIW_GOLD = Value
}

/**
  * Provides enumerated values for weather units, generally used in the context of defining quantities for commodities.
  */
object WeatherUnitEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Denotes Cooling Degree Days as a standard unit.
    */
  val CDD = Value
  
  /**
    * Denotes Critical Precipitation Day as a standard unit.
    */
  val CPD = Value
  
  /**
    * Heating Degree Day as a standard unit.
    */
  val HDD = Value
}

/**
  * The enumerated values to specify the weekly roll day.
  */
object WeeklyRollConventionEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  /**
    * Friday
    */
  val FRI = Value
  
  /**
    * Monday
    */
  val MON = Value
  
  /**
    * Saturday
    */
  val SAT = Value
  
  /**
    * Sunday
    */
  val SUN = Value
  
  /**
    * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday
    */
  val TBILL = Value
  
  /**
    * Thursday
    */
  val THU = Value
  
  /**
    * Tuesday
    */
  val TUE = Value
  
  /**
    * Wednesday
    */
  val WED = Value
}

object WorkflowStatusEnum extends Enumeration {
  
  class Class extends TypeReference[this.type]
  
  val ACCEPTED = Value
  
  val AFFIRMED = Value
  
  val ALLEGED = Value
  
  val AMENDED = Value
  
  val CANCELLED = Value
  
  val CERTAIN = Value
  
  val CLEARED = Value
  
  val CONFIRMED = Value
  
  val PENDING = Value
  
  val REJECTED = Value
  
  val SUBMITTED = Value
  
  val TERMINATED = Value
  
  val UNCERTAIN = Value
  
  val UNCONFIRMED = Value
}

