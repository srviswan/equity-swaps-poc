/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */

/**
 * The enumeration values to qualify the type of account.
 */
export enum AccountTypeEnum {

  /**
   * Aggregate client account, as defined under ESMA MiFIR.
   */
  AGGREGATE_CLIENT,

  /**
   * The account contains trading activity or positions that belong to a client of the firm that opened the account.
   */
  CLIENT,

  /**
   * The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
   */
  HOUSE
}
/**
 * The enumeration values to specify the actions associated with transactions.
 */
export enum ActionEnum {

  /**
   * A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
   */
  CANCEL,

  /**
   * A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
   */
  CORRECT,

  /**
   * A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
   */
  NEW
}
/**
 * Enumeration for the different types of affirmation status.
 */
export enum AffirmationStatusEnum {

  AFFIRMED,

  UNAFFIRMED
}
/**
 * If there is an alternative to interest amounts, how is it specified?
 */
export enum AlternativeToInterestAmountEnum {

  /**
   * The standard calculation of the Interest Amount is replaced with the amount of interest the secured party actually receives in relation to the Cash collateral.
   */
  ACTUAL_AMOUNT_RECEIVED,

  /**
   * An other alternative option outside these choices that can be described as an alternative provision.
   */
  OTHER,

  /**
   * Interest amount is not transferred if transfer would create or increase a delivery amount.
   */
  STANDARD,

  /**
   * Interest amount is not transferred if transfer would create or increase a delivery amount. (This is the 'Standard' provision). However, interest Amount will be transferred if Delivery Amount is below Minimum Transfer Amount.
   */
  TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA
}
/**
 * Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 */
export enum AncillaryRoleEnum {

  /**
   * Specifies the party responsible for deciding the fallback rate.
   */
  CALCULATION_AGENT_FALLBACK,

  /**
   * Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition.
   */
  CALCULATION_AGENT_INDEPENDENT,

  /**
   * Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination.
   */
  CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION,

  /**
   * Specifies the party responsible for performing calculation agent duties associated with an optional early termination.
   */
  CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION,

  /**
   * Specifies the party which determines additional disruption events.
   */
  DISRUPTION_EVENTS_DETERMINING_PARTY,

  /**
   * Specifies the party to which notice of a cancelable provision exercise should be given.
   */
  EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION,

  /**
   * Specifies the party to which notice of a extendible provision exercise should be given.
   */
  EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION,

  /**
   * Specifies the party to which notice of a manual exercise should be given.
   */
  EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL,

  /**
   * Specifies the party to which notice of a optional early termination exercise should be given.
   */
  EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION,

  /**
   * Specifies the party which determines if dividends are extraordinary in relation to normal levels.
   */
  EXTRAORDINARY_DIVIDENDS_PARTY,

  /**
   * Specifies the clearing organization (CCP, DCO) which the trade should be cleared.
   */
  PREDETERMINED_CLEARING_ORGANIZATION_PARTY
}
/**
 * An arithmetic operator that can be passed to a function
 */
export enum ArithmeticOperationEnum {

  /**
   * Addition of 2 values
   */
  ADD,

  /**
   * Division of 1st value by 2nd value
   */
  DIVIDE,

  /**
   * Maximum of 2 values
   */
  MAX,

  /**
   * Minimum of 2 values
   */
  MIN,

  /**
   * Multiplication of 2 values
   */
  MULTIPLY,

  /**
   * Subtraction of 2nd value from 1st value
   */
  SUBTRACT
}
/**
 * The enumerated values to specify the FpML asset class categorization.
 */
export enum AssetClassEnum {

  /**
   * Commodity.
   */
  COMMODITY,

  /**
   * Credit.
   */
  CREDIT,

  /**
   * Equity.
   */
  EQUITY,

  /**
   * ForeignExchange.
   */
  FOREIGN_EXCHANGE,

  /**
   * InterestRate.
   */
  INTEREST_RATE,

  /**
   * Money Market Assets like CP and CD.
   */
  MONEY_MARKET
}
/**
 * Extends product identifiers with additional identifier sources for Assets.
 */
export enum AssetIdTypeEnum {

  /**
   * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
   */
  BBGID,

  /**
   * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
   */
  BBGTICKER,

  /**
   * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
   */
  CUSIP,

  /**
   * The identifier follows the symbology set by the clearing house which clears the asset.
   */
  CLEARING_CODE,

  /**
   * Used to identify the currency of a Cash Asset.
   */
  CURRENCY_CODE,

  /**
   * The identifier follows the symbology set by the exchange which lists the asset.
   */
  EXCHANGE_CODE,

  /**
   * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
   */
  FIGI,

  /**
   * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
   */
  ISDACRP,

  /**
   * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
   */
  ISIN,

  /**
   * The name of the product.
   */
  NAME,

  /**
   * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
   */
  OTHER,

  /**
   * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
   */
  RIC,

  /**
   * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well.
   */
  SEDOL,

  /**
   * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
   */
  SICOVAM,

  /**
   * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
   */
  UPI,

  /**
   * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
   */
  WERTPAPIER
}
/**
 * An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout.
 */
export enum AssetPayoutTradeTypeEnum {

  /**
   * In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo.
   */
  BUY_SELL_BACK,

  /**
   * In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller.
   */
  REPO
}
/**
 * The qualification of the type of asset transfer.
 */
export enum AssetTransferTypeEnum {

  /**
   * The transfer of assets takes place without a corresponding exchange of payment.
   */
  FREE_OF_PAYMENT
}
/**
 * Represents an enumeration list to identify the asset type.
 */
export enum AssetTypeEnum {

  /**
   * Indentifies cash in a currency form.
   */
  CASH,

  /**
   * Indentifies basic good used in commerce that is interchangeable with other goods of the same type.
   */
  COMMODITY,

  /**
   * Indentifies other asset types.
   */
  OTHER,

  /**
   * Indentifies negotiable financial instrument of monetary value with an issue ownership position.
   */
  SECURITY
}
/**
 * Enumeration to describe the type of AvailableInventory
 */
export enum AvailableInventoryTypeEnum {

  /**
   * Where a lender is broadcasting the securities that they have available to lend
   */
  AVAILABLE_TO_LEND,

  /**
   * Where a party is asking a lender if they have specific securities available for them to borrow
   */
  REQUEST_TO_BORROW
}
/**
 * Indicates the type of equity average trading volume (single) the highest amount on one exchange, or (consolidated) volumes across more than one exchange.
 */
export enum AverageTradingVolumeMethodologyEnum {

  /**
   * Consolidated volume across more than one exchange.
   */
  CONSOLIDATED,

  /**
   * Single, the highest amount on one exchange.
   */
  SINGLE
}
/**
 * Specifies enumerations for the type of averaging calculation.
 */
export enum AveragingCalculationMethodEnum {

  /**
   * Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
   */
  ARITHMETIC,

  /**
   * Refers to the calculation of an average by taking the nth root of the product of n observations.
   */
  GEOMETRIC,

  /**
   * Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
   */
  HARMONIC
}
/**
 * The enumerated values to specify the type of averaging used in an Asian option.
 */
export enum AveragingInOutEnum {

  /**
   * The average price is used to derive both the strike and the expiration price.
   */
  BOTH,

  /**
   * The average price is used to derive the strike price. Also known as 'Asian strike' style option.
   */
  IN,

  /**
   * The average price is used to derive the expiration price. Also known as 'Asian price' style option.
   */
  OUT
}
/**
 * The enumerated values to specify the method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts.
 */
export enum AveragingWeightingMethodEnum {

  /**
   * The arithmetic mean of the relevant rates for each reset date.
   */
  UNWEIGHTED,

  /**
   * The arithmetic mean of the relevant rates in effect for each day in a calculation period calculated by multiplying each relevant rate by the number of days such relevant rate is in effect, determining the sum of such products and dividing such sum by the number of days in the calculation period.
   */
  WEIGHTED
}
/**
 * Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles.
 */
export enum BankHolidayTreatmentEnum {

  /**
   * Bank holidays treated as weekdays.
   */
  AS_WEEKDAY,

  /**
   * Bank holidays treated as weekends.
   */
  AS_WEEKEND
}
/**
 * The enumerated values to specify the business centers.
 */
export enum BusinessCenterEnum {

  /**
   * Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii))
   */
  AEAB,

  /**
   * Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i))
   */
  AEAD,

  /**
   * Dubai, United Arab Emirates
   */
  AEDU,

  /**
   * Yerevan, Armenia
   */
  AMYE,

  /**
   * Luanda, Angola
   */
  AOLU,

  /**
   * Buenos Aires, Argentina
   */
  ARBA,

  /**
   * Vienna, Austria
   */
  ATVI,

  /**
   * Adelaide, Australia
   */
  AUAD,

  /**
   * Brisbane, Australia
   */
  AUBR,

  /**
   * Canberra, Australia
   */
  AUCA,

  /**
   * Darwin, Australia
   */
  AUDA,

  /**
   * Melbourne, Australia
   */
  AUME,

  /**
   * Perth, Australia
   */
  AUPE,

  /**
   * Sydney, Australia
   */
  AUSY,

  /**
   * Baku, Azerbaijan
   */
  AZBA,

  /**
   * Bridgetown, Barbados
   */
  BBBR,

  /**
   * Dhaka, Bangladesh
   */
  BDDH,

  /**
   * Brussels, Belgium
   */
  BEBR,

  /**
   * Sofia, Bulgaria
   */
  BGSO,

  /**
   * Manama, Bahrain
   */
  BHMA,

  /**
   * Hamilton, Bermuda
   */
  BMHA,

  /**
   * Bandar Seri Begawan, Brunei
   */
  BNBS,

  /**
   * La Paz, Bolivia
   */
  BOLP,

  /**
   * Brazil Business Day.
   */
  BRBD,

  /**
   * Brasilia, Brazil.
   */
  BRBR,

  /**
   * Rio de Janeiro, Brazil.
   */
  BRRJ,

  /**
   * Sao Paulo, Brazil.
   */
  BRSP,

  /**
   * Nassau, Bahamas
   */
  BSNA,

  /**
   * Gaborone, Botswana
   */
  BWGA,

  /**
   * Minsk, Belarus
   */
  BYMI,

  /**
   * Calgary, Canada
   */
  CACL,

  /**
   * Fredericton, Canada.
   */
  CAFR,

  /**
   * Montreal, Canada
   */
  CAMO,

  /**
   * Ottawa, Canada
   */
  CAOT,

  /**
   * Toronto, Canada
   */
  CATO,

  /**
   * Vancouver, Canada
   */
  CAVA,

  /**
   * Winnipeg, Canada
   */
  CAWI,

  /**
   * Basel, Switzerland
   */
  CHBA,

  /**
   * Geneva, Switzerland
   */
  CHGE,

  /**
   * Zurich, Switzerland
   */
  CHZU,

  /**
   * Abidjan, Cote d'Ivoire
   */
  CIAB,

  /**
   * Santiago, Chile
   */
  CLSA,

  /**
   * Yaounde, Cameroon
   */
  CMYA,

  /**
   * Beijing, China
   */
  CNBE,

  /**
   * Shanghai, China
   */
  CNSH,

  /**
   * Bogota, Colombia
   */
  COBO,

  /**
   * San Jose, Costa Rica
   */
  CRSJ,

  /**
   * Willemstad, Curacao
   */
  CWWI,

  /**
   * Nicosia, Cyprus
   */
  CYNI,

  /**
   * Prague, Czech Republic
   */
  CZPR,

  /**
   * Cologne, Germany
   */
  DECO,

  /**
   * Dusseldorf, Germany
   */
  DEDU,

  /**
   * Frankfurt, Germany
   */
  DEFR,

  /**
   * Hannover, Germany
   */
  DEHA,

  /**
   * Hamburg, Germany
   */
  DEHH,

  /**
   * Leipzig, Germany
   */
  DELE,

  /**
   * Mainz, Germany
   */
  DEMA,

  /**
   * Munich, Germany
   */
  DEMU,

  /**
   * Stuttgart, Germany
   */
  DEST,

  /**
   * Copenhagen, Denmark
   */
  DKCO,

  /**
   * Santo Domingo, Dominican Republic
   */
  DOSD,

  /**
   * Algiers, Algeria
   */
  DZAL,

  /**
   * Guayaquil, Ecuador
   */
  ECGU,

  /**
   * Tallinn, Estonia
   */
  EETA,

  /**
   * Cairo, Egypt
   */
  EGCA,

  /**
   * ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
   */
  ESAS,

  /**
   * Barcelona, Spain
   */
  ESBA,

  /**
   * Madrid, Spain
   */
  ESMA,

  /**
   * San Sebastian, Spain
   */
  ESSS,

  /**
   * Addis Ababa, Ethiopia
   */
  ETAA,

  /**
   * Publication dates for ICE Swap rates based on EUR-EURIBOR rates
   */
  EUR_ICESWAP,

  /**
   * TARGET Settlement Day
   */
  EUTA,

  /**
   * Helsinki, Finland
   */
  FIHE,

  /**
   * Paris, France
   */
  FRPA,

  /**
   * Edinburgh, Scotland
   */
  GBED,

  /**
   * London, United Kingdom
   */
  GBLO,

  /**
   * Publication dates for GBP ICE Swap rates
   */
  GBP_ICESWAP,

  /**
   * Tbilisi, Georgia
   */
  GETB,

  /**
   * Saint Peter Port, Guernsey
   */
  GGSP,

  /**
   * Accra, Ghana
   */
  GHAC,

  /**
   * Gibraltar, Gibraltar
   */
  GIGI,

  /**
   * Banjul, Gambia
   */
  GMBA,

  /**
   * Conakry, Guinea
   */
  GNCO,

  /**
   * Athens, Greece
   */
  GRAT,

  /**
   * Guatemala City, Guatemala
   */
  GTGC,

  /**
   * Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.]
   */
  GUGC,

  /**
   * Hong Kong, Hong Kong
   */
  HKHK,

  /**
   * Tegucigalpa, Honduras
   */
  HNTE,

  /**
   * Zagreb, Republic of Croatia
   */
  HRZA,

  /**
   * Budapest, Hungary
   */
  HUBU,

  /**
   * Jakarta, Indonesia
   */
  IDJA,

  /**
   * Dublin, Ireland
   */
  IEDU,

  /**
   * Jerusalem, Israel
   */
  ILJE,

  /**
   * Publication dates of the ILS-TELBOR index.
   */
  ILS_TELBOR,

  /**
   * Tel Aviv, Israel
   */
  ILTA,

  /**
   * Ahmedabad, India
   */
  INAH,

  /**
   * Bangalore, India
   */
  INBA,

  /**
   * Chennai, India
   */
  INCH,

  /**
   * Hyderabad, India
   */
  INHY,

  /**
   * Kolkata, India
   */
  INKO,

  /**
   * Mumbai, India
   */
  INMU,

  /**
   * New Delhi, India
   */
  INND,

  /**
   * Baghdad, Iraq
   */
  IQBA,

  /**
   * Teheran, Iran
   */
  IRTE,

  /**
   * Reykjavik, Iceland
   */
  ISRE,

  /**
   * Milan, Italy
   */
  ITMI,

  /**
   * Rome, Italy
   */
  ITRO,

  /**
   * Turin, Italy
   */
  ITTU,

  /**
   * St. Helier, Channel Islands, Jersey
   */
  JESH,

  /**
   * Kingston, Jamaica
   */
  JMKI,

  /**
   * Amman, Jordan
   */
  JOAM,

  /**
   * Tokyo, Japan
   */
  JPTO,

  /**
   * Nairobi, Kenya
   */
  KENA,

  /**
   * Phnom Penh, Cambodia
   */
  KHPP,

  /**
   * Seoul, Republic of Korea
   */
  KRSE,

  /**
   * Kuwait City, Kuwait
   */
  KWKC,

  /**
   * George Town, Cayman Islands
   */
  KYGE,

  /**
   * Almaty, Kazakhstan
   */
  KZAL,

  /**
   * Vientiane, Laos
   */
  LAVI,

  /**
   * Beirut, Lebanon
   */
  LBBE,

  /**
   * Colombo, Sri Lanka
   */
  LKCO,

  /**
   * Luxembourg, Luxembourg
   */
  LULU,

  /**
   * Riga, Latvia
   */
  LVRI,

  /**
   * Casablanca, Morocco
   */
  MACA,

  /**
   * Rabat, Morocco
   */
  MARA,

  /**
   * Monaco, Monaco
   */
  MCMO,

  /**
   * Ulan Bator, Mongolia
   */
  MNUB,

  /**
   * Macau, Macao
   */
  MOMA,

  /**
   * Valletta, Malta
   */
  MTVA,

  /**
   * Port Louis, Mauritius
   */
  MUPL,

  /**
   * Male, Maldives
   */
  MVMA,

  /**
   * Lilongwe, Malawi
   */
  MWLI,

  /**
   * Mexico City, Mexico
   */
  MXMC,

  /**
   * Kuala Lumpur, Malaysia
   */
  MYKL,

  /**
   * Labuan, Malaysia
   */
  MYLA,

  /**
   * Maputo, Mozambique
   */
  MZMA,

  /**
   * Windhoek, Namibia
   */
  NAWI,

  /**
   * Abuja, Nigeria
   */
  NGAB,

  /**
   * Lagos, Nigeria
   */
  NGLA,

  /**
   * Amsterdam, Netherlands
   */
  NLAM,

  /**
   * Rotterdam, Netherlands
   */
  NLRO,

  /**
   * Oslo, Norway
   */
  NOOS,

  /**
   * Kathmandu, Nepal
   */
  NPKA,

  /**
   * New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7)
   */
  NYFD,

  /**
   * New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8)
   */
  NYSE,

  /**
   * Auckland, New Zealand
   */
  NZAU,

  /**
   * Wellington, New Zealand
   */
  NZWE,

  /**
   * Muscat, Oman
   */
  OMMU,

  /**
   * Panama City, Panama
   */
  PAPC,

  /**
   * Lima, Peru
   */
  PELI,

  /**
   * Manila, Philippines
   */
  PHMA,

  /**
   * Makati, Philippines
   */
  PHMK,

  /**
   * Karachi, Pakistan
   */
  PKKA,

  /**
   * Warsaw, Poland
   */
  PLWA,

  /**
   * San Juan, Puerto Rico
   */
  PRSJ,

  /**
   * Lisbon, Portugal
   */
  PTLI,

  /**
   * Doha, Qatar
   */
  QADO,

  /**
   * Bucharest, Romania
   */
  ROBU,

  /**
   * Belgrade, Serbia
   */
  RSBE,

  /**
   * Moscow, Russian Federation
   */
  RUMO,

  /**
   * Abha, Saudi Arabia
   */
  SAAB,

  /**
   * Jeddah, Saudi Arabia
   */
  SAJE,

  /**
   * Riyadh, Saudi Arabia
   */
  SARI,

  /**
   * Stockholm, Sweden
   */
  SEST,

  /**
   * Singapore, Singapore
   */
  SGSI,

  /**
   * Ljubljana, Slovenia
   */
  SILJ,

  /**
   * Bratislava, Slovakia
   */
  SKBR,

  /**
   * Freetown, Sierra Leone
   */
  SLFR,

  /**
   * Dakar, Senegal
   */
  SNDA,

  /**
   * San Salvador, El Salvador
   */
  SVSS,

  /**
   * Bangkok, Thailand
   */
  THBA,

  /**
   * Tunis, Tunisia
   */
  TNTU,

  /**
   * Ankara, Turkey
   */
  TRAN,

  /**
   * Istanbul, Turkey
   */
  TRIS,

  /**
   * Port of Spain, Trinidad and Tobago
   */
  TTPS,

  /**
   * Taipei, Taiwan
   */
  TWTA,

  /**
   * Dar es Salaam, Tanzania
   */
  TZDA,

  /**
   * Dodoma, Tanzania
   */
  TZDO,

  /**
   * Kiev, Ukraine
   */
  UAKI,

  /**
   * Kampala, Uganda
   */
  UGKA,

  /**
   * Boston, Massachusetts, United States
   */
  USBO,

  /**
   * Chicago, United States
   */
  USCH,

  /**
   * Charlotte, North Carolina, United States
   */
  USCR,

  /**
   * Washington, District of Columbia, United States
   */
  USDC,

  /**
   * Denver, United States
   */
  USDN,

  /**
   * Detroit, Michigan, United States
   */
  USDT,

  /**
   * Publication dates for ICE Swap rates based on USD-LIBOR rates
   */
  USD_ICESWAP,

  /**
   * Publication dates for the USD-Municipal Swap Index
   */
  USD_MUNI,

  /**
   * U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
   */
  USGS,

  /**
   * Honolulu, Hawaii, United States
   */
  USHL,

  /**
   * Houston, United States
   */
  USHO,

  /**
   * Los Angeles, United States
   */
  USLA,

  /**
   * Mobile, Alabama, United States
   */
  USMB,

  /**
   * Minneapolis, United States
   */
  USMN,

  /**
   * New York, United States
   */
  USNY,

  /**
   * Portland, Oregon, United States
   */
  USPO,

  /**
   * Sacramento, California, United States
   */
  USSA,

  /**
   * Seattle, United States
   */
  USSE,

  /**
   * San Francisco, United States
   */
  USSF,

  /**
   * Wichita, United States
   */
  USWT,

  /**
   * Montevideo, Uruguay
   */
  UYMO,

  /**
   * Tashkent, Uzbekistan
   */
  UZTA,

  /**
   * Caracas, Venezuela
   */
  VECA,

  /**
   * Road Town, Virgin Islands (British)
   */
  VGRT,

  /**
   * Hanoi, Vietnam
   */
  VNHA,

  /**
   * Ho Chi Minh (formerly Saigon), Vietnam
   */
  VNHC,

  /**
   * Aden, Yemen
   */
  YEAD,

  /**
   * Johannesburg, South Africa
   */
  ZAJO,

  /**
   * Lusaka, Zambia
   */
  ZMLU,

  /**
   * Harare, Zimbabwe
   */
  ZWHA
}
/**
 * The enumerated values to specify the convention for adjusting any relevant date if it would otherwise fall on a day that is not a valid business day.
 */
export enum BusinessDayConventionEnum {

  /**
   * The non-business date will be adjusted to the first following day that is a business day
   */
  FOLLOWING,

  /**
   * Per 2000 ISDA Definitions, Section 4.11. FRN Convention; Eurodollar Convention. FRN is included here as a type of business day convention although it does not strictly fall within ISDA's definition of a Business Day Convention and does not conform to the simple definition given above.
   */
  FRN,

  /**
   * The non-business date will be adjusted to the first following day that is a business day unless that day falls in the next calendar month, in which case that date will be the first preceding day that is a business day.
   */
  MODFOLLOWING,

  /**
   * The non-business date will be adjusted to the first preceding day that is a business day unless that day falls in the previous calendar month, in which case that date will be the first following day that us a business day.
   */
  MODPRECEDING,

  /**
   * The non-business date will be adjusted to the nearest day that is a business day - i.e. if the non-business day falls on any day other than a Sunday or a Monday, it will be the first preceding day that is a business day, and will be the first following business day if it falls on a Sunday or a Monday.
   */
  NEAREST,

  /**
   * The date will not be adjusted if it falls on a day that is not a business day.
   */
  NONE,

  /**
   * The date adjustments conventions are defined elsewhere, so it is not required to specify them here.
   */
  NOT_APPLICABLE,

  /**
   * The non-business day will be adjusted to the first preceding day that is a business day.
   */
  PRECEDING
}
/**
 * What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 */
export enum CalculationMethodEnum {

  /**
   * Averaging, i.e. arithmetic averaging.
   */
  AVERAGING,

  /**
   * A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula.
   */
  COMPOUNDED_INDEX,

  /**
   * Compounding, i.e. geometric averaging following an ISDA defined formula.
   */
  COMPOUNDING
}
/**
 *  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 */
export enum CalculationShiftMethodEnum {

  /**
   * Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days.
   */
  LOOKBACK,

  /**
   * calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style.
   */
  NO_SHIFT,

  /**
   * the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period.
   */
  OBSERVATION_PERIOD_SHIFT,

  /**
   * Calculations cut the rate off several business days prior to rate setting (Lockout).
   */
  RATE_CUT_OFF
}
/**
 * Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call.
 */
export enum CallTypeEnum {

  /**
   * Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement.
   */
  EXPECTED_CALL,

  /**
   * Identifies an actionable Margin Call.
   */
  MARGIN_CALL,

  /**
   * Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent.
   */
  NOTIFICATION
}
/**
 * Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
 */
export enum CallingPartyEnum {

  /**
   * As defined in Master Agreement.
   */
  AS_DEFINED_IN_MASTER_AGREEMENT,

  /**
   * Either, Buyer or Seller to the repo transaction.
   */
  EITHER,

  /**
   * Initial buyer to the repo transaction.
   */
  INITIAL_BUYER,

  /**
   * Initial seller to the repo transaction.
   */
  INITIAL_SELLER
}
/**
 * Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
 */
export enum CapacityUnitEnum {

  /**
   * Denotes Allowances as standard unit.
   */
  ALW,

  /**
   * Denotes a Barrel as a standard unit.
   */
  BBL,

  /**
   * Denotes Billion Cubic Feet as a standard unit.
   */
  BCF,

  /**
   * Denotes Board Feet as a standard unit.
   */
  BDFT,

  /**
   * Denotes Cubic Meters as a standard unit.
   */
  CBM,

  /**
   * Denotes Certified Emissions Reduction as a standard unit.
   */
  CER,

  /**
   * Denotes Climate Reserve Tonnes as a standard unit.
   */
  CRT,

  /**
   * Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
   */
  DAG,

  /**
   * Denotes a single day as a standard unit used in time charter trades.
   */
  DAY,

  /**
   * Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
   */
  DMTU,

  /**
   * Denotes Environmental Credit as a standard unit.
   */
  ENVCRD,

  /**
   * Denotes Environmental Offset as a standard unit.
   */
  ENVOFST,

  /**
   * Denotes a 40 ft. Equivalent Unit container as a standard unit.
   */
  FEU,

  /**
   * Denotes a Gram as a standard unit.
   */
  G,

  /**
   * Denotes a GB Bushel as a standard unit.
   */
  GBBSH,

  /**
   * Denotes a GB British Thermal Unit as a standard unit.
   */
  GBBTU,

  /**
   * Denotes a GB Hundredweight unit as standard unit.
   */
  GBCWT,

  /**
   * Denotes a GB Gallon unit as standard unit.
   */
  GBGAL,

  /**
   * Denotes a Thousand GB British Thermal Units as a standard unit.
   */
  GBMBTU,

  /**
   * Denotes a Million GB British Thermal Units as a standard unit.
   */
  GBMMBTU,

  /**
   * Denotes a GB Ton as a standard unit.
   */
  GBT,

  /**
   * Denotes a GB Thermal Unit as a standard unit.
   */
  GBTHM,

  /**
   * Denotes a Gigajoule as a standard unit.
   */
  GJ,

  /**
   * Denotes a Gigawatt as a standard unit.
   */
  GW,

  /**
   * Denotes a Gigawatt-hour as a standard unit.
   */
  GWH,

  /**
   * Denotes a Hectolitre as a standard unit.
   */
  HL,

  /**
   * Denotes a 100-troy ounces Gold Bar as a standard unit.
   */
  HOGB,

  /**
   * Denotes an ISO British Thermal Unit as a standard unit.
   */
  ISOBTU,

  /**
   * Denotes a Thousand ISO British Thermal Unit as a standard unit.
   */
  ISOMBTU,

  /**
   * Denotes a Million ISO British Thermal Unit as a standard unit.
   */
  ISOMMBTU,

  /**
   * Denotes an ISO Thermal Unit as a standard unit.
   */
  ISOTHM,

  /**
   * Denotes a Joule as a standard unit.
   */
  J,

  /**
   * Denotes a Kilogram as a standard unit.
   */
  KG,

  /**
   * Denotes a Kilolitre as a standard unit.
   */
  KL,

  /**
   * Denotes a Kilowatt as a standard unit.
   */
  KW,

  /**
   * Denotes a Kilowatt-day as a standard unit.
   */
  KWD,

  /**
   * Denotes a Kilowatt-hour as a standard unit.
   */
  KWH,

  /**
   * Denotes a Kilowatt-month as a standard unit.
   */
  KWM,

  /**
   * Denotes a Kilowatt-minute as a standard unit.
   */
  KWMIN,

  /**
   * Denotes a Kilowatt-year as a standard unit.
   */
  KWY,

  /**
   * Denotes a Litre as a standard unit.
   */
  L,

  /**
   * Denotes a Pound as a standard unit.
   */
  LB,

  /**
   * Denotes a Thousand Barrels as a standard unit.
   */
  MB,

  /**
   * Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
   */
  MBF,

  /**
   * Denotes a Megajoule as a standard unit.
   */
  MJ,

  /**
   * Denotes a Million Barrels as a standard unit.
   */
  MMBBL,

  /**
   * Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
   */
  MMBF,

  /**
   * Denotes a Thousand square feet as a standard unit.
   */
  MSF,

  /**
   * Denotes a Metric Ton as a standard unit.
   */
  MT,

  /**
   * Denotes a Megawatt as a standard unit.
   */
  MW,

  /**
   * Denotes a Megawatt-day as a standard unit.
   */
  MWD,

  /**
   * Denotes a Megawatt-hour as a standard unit.
   */
  MWH,

  /**
   * Denotes a Megawatt-month as a standard unit.
   */
  MWM,

  /**
   * Denotes a Megawatt-minute as a standard unit.
   */
  MWMIN,

  /**
   * Denotes a Megawatt-year as a standard unit.
   */
  MWY,

  /**
   * Denotes a Troy Ounce as a standard unit.
   */
  OZT,

  /**
   * Denotes a Standard Gold Bar as a standard unit.
   */
  SGB,

  /**
   * Denotes a 20 ft. Equivalent Unit container as a standard unit.
   */
  TEU,

  /**
   * Denotes a US Bushel as a standard unit.
   */
  USBSH,

  /**
   * Denotes a US British Thermal Unit as a standard unit.
   */
  USBTU,

  /**
   * Denotes US Hundredweight unit as a standard unit.
   */
  USCWT,

  /**
   * Denotes a US Gallon unit as a standard unit.
   */
  USGAL,

  /**
   * Denotes a Thousand US British Thermal Units as a standard unit.
   */
  USMBTU,

  /**
   * Denotes a Million US British Thermal Units as a standard unit.
   */
  USMMBTU,

  /**
   * Denotes a US Ton as a standard unit.
   */
  UST,

  /**
   * Denotes a US Thermal Unit as a standard unit.
   */
  USTHM
}
/**
 * Provides a list of possible types of cash prices, applicable when PriceTypeEnum is itself of type CashPrice.
 */
export enum CashPriceTypeEnum {

  /**
   * Denotes a discount factor expressed as a decimal, e.g. 0.95.
   */
  DISCOUNT,

  /**
   * A generic term for describing a non-scheduled cashflow that can be associated either with the initial contract, with some later corrections to it (e.g. a correction to the day count fraction that has a cashflow impact) or with some lifecycle events. Fees that are specifically associated with termination and partial termination, increase, amendment, and exercise events are qualified accordingly.
   */
  FEE,

  /**
   * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
   */
  PREMIUM
}
/**
 * Defines the different cash settlement methods for a product where cash settlement is applicable.
 */
export enum CashSettlementMethodEnum {

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
   */
  CASH_PRICE_ALTERNATE_METHOD,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
   */
  CASH_PRICE_METHOD,

  /**
   * An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
   */
  COLLATERALIZED_CASH_PRICE_METHOD,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
   */
  CROSS_CURRENCY_METHOD,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
   */
  MID_MARKET_CALCULATION_AGENT_DETERMINATION,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
   */
  MID_MARKET_INDICATIVE_QUOTATIONS,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
   */
  MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
   */
  PAR_YIELD_CURVE_ADJUSTED_METHOD,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
   */
  PAR_YIELD_CURVE_UNADJUSTED_METHOD,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
   */
  REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
   */
  REPLACEMENT_VALUE_FIRM_QUOTATIONS,

  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
   */
  ZERO_COUPON_YIELD_ADJUSTED_METHOD
}
/**
 * The enumerated values to specify what led to the contract or execution closure.
 */
export enum ClosedStateEnum {

  /**
   * The execution or contract has been allocated.
   */
  ALLOCATED,

  /**
   * The execution or contract has been cancelled.
   */
  CANCELLED,

  /**
   * The (option) contract has been exercised.
   */
  EXERCISED,

  /**
   * The (option) contract has expired without being exercised.
   */
  EXPIRED,

  /**
   * The contract has reached its contractual termination date.
   */
  MATURED,

  /**
   * The contract has been novated. This state applies to the stepped-out contract component of the novation event.
   */
  NOVATED,

  /**
   * The contract has been subject of an early termination event.
   */
  TERMINATED
}
/**
 * How is collateral interest to be handled?
 */
export enum CollateralInterestHandlingEnum {

  /**
   *  Adjust the collateral balance to include the interest amount 
   */
  ADJUST,

  /**
   *  Transfer the interest each period 
   */
  TRANSFER,

  /**
   *  Transfer the interest if it meets certain criteria, or otherwise adjust the collateral balance to reflect the interest amount  
   */
  TRANSFER_OR_ADJUST
}
/**
 * The enumerated values to specify the type of margin for which a legal agreement is named.
 */
export enum CollateralMarginTypeEnum {

  /**
   * Denotes a margin agreement that is identified for use with Initial Margin/IM.
   */
  INITIAL_MARGIN,

  /**
   * Denotes a margin agreement that is identified for use with Variation Margin/VM.
   */
  VARIATION_MARGIN
}
/**
 * Represents the enumeration list to identify the settlement status of the collateral.
 */
export enum CollateralStatusEnum {

  /**
   * Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement.
   */
  FULL_AMOUNT,

  /**
   * Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s.
   */
  IN_TRANSIT_AMOUNT,

  /**
   * Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s.
   */
  SETTLED_AMOUNT
}
/**
 * Specifies the types of collateral that are accepted by the Lender
 */
export enum CollateralTypeEnum {

  /**
   * Security Lending Trades against Cash collateral
   */
  CASH,

  /**
   * Security Lending Trades against CashPool collateral
   */
  CASH_POOL,

  /**
   * Security Lending Trades against NonCash collateral
   */
  NON_CASH
}
export enum CommodityBusinessCalendarEnum {

  /**
   * Abu Dhabi Securities Exchange https://www.adx.ae/
   */
  ADSM,

  /**
   * Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer
   */
  AGRUS_FMB,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  APPI,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ARGUS_CRUDE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ARGUS_EUROPEAN_GAS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ARGUS_EUROPEAN_PRODUCTS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ARGUS_INTERNATIONAL_LPG,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ARGUS_MCCLOSKEYS_COAL_REPORT,

  /**
   * The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products
   */
  ARGUS_US_PRODUCTS,

  /**
   * Australian Securities Exchange http://www.asx.com.au/
   */
  ASX,

  /**
   * Australian Wheat Board. www.awb.com.au
   */
  AWB,

  /**
   * Australian Wool Exchange. http://www.awex.com.au/home.html
   */
  AWEX,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  BALTIC_EXCHANGE,

  /**
   * The business calendar of the Bank Negara Malaysia Policy Committee.
   */
  BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE,

  /**
   * The business calendar for the Belpex power exchange (www.belpex.be).
   */
  BELPEX,

  /**
   * BlueNext Power Market.
   */
  BLUENEXT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  BM_F,

  /**
   * The settlement business calendar for Bursa Malaysia.
   */
  BURSA_MALAYSIA_SETTLEMENT,

  /**
   * The trading business calendar for Bursa Malaysia.
   */
  BURSA_MALAYSIA_TRADING,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CANADIAN_GAS_PRICE_REPORTER,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CBOT_SOFT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CMAI_AROMATICS_MARKET_REPORT,

  /**
   * CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
   */
  CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CMAI_METHANOL_MARKET_REPORT,

  /**
   * CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
   */
  CMAI_MONOMERS_MARKET_REPORT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CME_DAIRY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CME_NON_DAIRY_SOFT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  COMEX,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CRU,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  CRU_LONG,

  /**
   * The business calendar for statistical publications by the by the United States Department of Energy (DOE).
   */
  DEPARTMENT_OF_ENERGY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  DEWITT_BENZENE_DERIVATIVES,

  /**
   * Dubai Mercantile Exchange. http://www.dubaimerc.com/
   */
  DME,

  /**
   * Dow Jones US Calendar. http://www.dowjones.com/
   */
  DOW_JONES,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  DOW_JONES_ENERGY_SERVICE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  DOW_JONES_POWER,

  /**
   * European Energy Exchange-Coal
   */
  EEX_COAL,

  /**
   * European Energy Exchange-Emissions Rights
   */
  EEX_EMISSIONS,

  /**
   * European Energy Exchange-Gas
   */
  EEX_GAS,

  /**
   * European Energy Exchange-Power
   */
  EEX_POWER,

  /**
   * TBD.
   */
  EURONEX_MATIF,

  /**
   * FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp
   */
  FERTECON,

  /**
   * Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek
   */
  FERTILIZER_WEEK,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  GAS_DAILY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  GAS_DAILY_PRICE_GUIDE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  GLOBALCOAL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  HEREN_REPORT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ICE_10X_DAILY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ICE_10X_MONTHLY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ICE_CANADA,

  /**
   * European Climate Exchange.
   */
  ICE_ECX,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ICE_GAS,

  /**
   * The business calendar oil and refined product contracts on ICE Futures Europe.
   */
  ICE_OIL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  ICE_US_AGRICULTURAL,

  /**
   * The business calendar for publication of ICIS Benzene (Europe) data.
   */
  ICIS_PRICING_BENZENE__EUROPE_,

  /**
   * The business calendar for publication of ICIS Ethylene (Europe) data.
   */
  ICIS_PRICING_ETHYLENE__EUROPE_,

  /**
   * The business calendar for publication of ICIS Polyproylene (Europe) data.
   */
  ICIS_PRICING_POLYPROPYLENE__EUROPE_,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  INSIDE_FERC,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  JAPAN_MOF_TSRR,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  KCBOT,

  /**
   * The banking business calendar in Kuala Lumpur.
   */
  KUALA_LUMPUR_BANK,

  /**
   * The business calendar for the Labuan Bank (Malaysia).
   */
  LABUAN_BANK,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  LIFFE_LONDON_SOFT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  LME,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  LONDON_BULLION_MARKET,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  LONDON_BULLION_MARKET_GOLD_A_M_ONLY,

  /**
   * The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium.
   */
  LONDON_PLATINUM_PALLADIUM_MARKET,

  /**
   * Minneapolis Grain Exchange http://www.mgex.com/
   */
  MGEX,

  /**
   * The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex).
   */
  N2EX,

  /**
   * NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities
   */
  NASDAQ_OMX,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NATURAL_GAS_WEEK,

  /**
   * Per 2005 ISDA Commodity Definitions, Article XIV.
   */
  NERC,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NGI,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NGX,

  /**
   * The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php
   */
  NUCLEAR_MARKET_REVIEW,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NYMEX_ELECTRICITY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NYMEX_GAS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NYMEX_NATURAL_GAS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  NYMEX_OIL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  OFFICIAL_BOARD_MARKETS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  OPIS_LP_GAS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  OPIS_PROPANE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PAPER_PACKAGING_MONITOR,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PAPER_TRADER,

  /**
   * Pertamina-Indonesia. http://www.pertamina.com/
   */
  PERTAMINA,

  /**
   * PetroChemWire Publication Calendar. http://www.petrochemwire.com/
   */
  PETROCHEMWIRE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PIX_PULP_BENCHMARK_INDICES,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_APAG_MARKETSCAN,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_BUNKERWIRE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_CLEAN_TANKERWIRE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_CRUDE_OIL_MARKETWIRE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_DIRTY_TANKERWIRE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_EUROPEAN_GAS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_EUROPEAN_MARKETSCAN,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_METALS_ALERT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_OILGRAM,

  /**
   * The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore
   */
  PLATTS_TSI_IRON_ORE,

  /**
   * The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices
   */
  PLATTS_TSI_SCRAP,

  /**
   * The Steel Index. http://www.thesteelindex.com/en/price-specifications
   */
  PLATTS_TSI_STEEL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PLATTS_US_MARKETSCAN,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PULP_AND_PAPER_INTERNATIONAL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  PULP_AND_PAPER_WEEK,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  RIM_PRODUCTS_INTELLIGENCE_DAILY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  SAFEX_SOFT,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  SFE_SOFT,

  /**
   * Singapore Exchange. www.sgx.com
   */
  SGX,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  SICOM,

  /**
   * Standard and Poor's GSCI. http://us.spindices.com/index-family/commodities/sp-gsci
   */
  SP_GSCI,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  STATISTICHES_BUNDESAMT,

  /**
   * Tokyo Grain Exchange. www.tge.or.jp
   */
  TGE,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  TOCOM_OIL,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  TOCOM_PRECIOUS,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  TOCOM_SOFT,

  /**
   * The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx
   */
  UX_WEEKLY,

  /**
   * Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
   */
  WORLD_PULP_MONTHLY
}
/**
 * Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg.
 */
export enum CommodityInformationPublisherEnum {

  ARGUS,

  ARGUS_AMERICAS_CRUDE_REPORT,

  ARGUS_BIOFUEL_REPORT,

  ARGUS_CRUDE_REPORT,

  ARGUS_EUROPEAN_PRODUCTS_REPORT,

  ARGUS_FMB,

  ARGUS_INTERNATIONAL_LPG_REPORT,

  ARGUS_LPG,

  ARGUS_MC_CLOSKEYS,

  ARGUS_NAT_GAS,

  ASSOC_BANKS_SINGAPORE,

  BLUENEXT,

  BALTIC_EXCHANGE,

  BAND_D,

  BANK_OF_CANADA,

  BANK_OF_ENGLAND,

  BANK_OF_JAPAN,

  BLOOMBERG,

  CAISO,

  CMAI_AROMATICS_MARKET_REPORT,

  CMAI_WEEKLY_METHANOL_MARKET_REPORT,

  CRU_STEEL_LONG_PRODUCT_MONITOR,

  CRU_STEEL_SHEET_PRODUCTS_MONITOR,

  CANADIAN_GAS_PRICE_REPORTER,

  CANADIAN_GAS_REPORTER,

  CHEMICAL_MARKETS_ASSOCIATION,

  DOW_JONES_ENERGY_SERVICE,

  DOW_JONES_ENERGY_SERVICE_SCREEN,

  DOW_JONES_NAT_GAS,

  EEX,

  ERCOT,

  EURONEXMATIF,

  EURO_CENTRAL_BANK,

  FERTECON,

  FHLBSF,

  FEDERAL_RESERVE,

  FERTILIZER_WEEK,

  GME,

  GAS_DAILY,

  GAS_DAILY_PRICE_GUIDE,

  GLOBAL_COALE,

  HEREN_REPORT,

  ICE,

  ICE_10_X_DAILY_NATURAL_GAS,

  ICE_10_X_DAILY_POWER,

  ICE_10_X_MONTHLY,

  ICE_DAY_AHEAD_INDEX,

  ICEECX,

  ICIS,

  IPE,

  ISDA,

  ISO_NEW_ENGLAND,

  INSIDE_FERC,

  JAPANMOFTSRR,

  LEBA,

  LONDONPLATINUMPALLADIUMMARKET,

  LONDON_BULLION_MARKET_ASSOCIATION,

  MISO,

  MEGAWATT_DAILY,

  METAL_BULLETIN,

  NGI_BIDWEEK_SURVEY,

  NYISO,

  NATURAL_GAS_WEEK,

  OBM,

  OMEL,

  OPIS,

  PIX,

  PJM,

  PPM,

  PPM_EUROPE,

  PPW,

  PAPER_TRADER,

  PLATTS_ASIA_PACIFIC,

  PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN,

  PLATTS_CLEAN_TANKERWIRE,

  PLATTS_COAL_TRADER,

  PLATTS_CRUDE_OIL_MARKETWIRE,

  PLATTS_DIRTY_TAKERWIRE,

  PLATTS_ENGR,

  PLATTS_EUROPEAN,

  PLATTS_EUROPEAN_MARKETSCAN,

  PLATTS_GAS_DAILY,

  PLATTS_GAS_DAILY_PRICE_GUIDE,

  PLATTS_INSIDE_FERC,

  PLATTS_LPG,

  PLATTS_MARKETWIRE,

  PLATTS_MEGAWATT_DAILY,

  PLATTS_METALS_ALERT,

  PLATTS_OILGRAM,

  PLATTS_OILGRAM_BUNKERWIRE,

  PLATTS_POLYMERSCAN,

  PLATTS_TSI_IRON_ORE,

  PLATTS_US,

  PLATTS_US_MARKETSCAN,

  RIM_INTELLIGENCE_PRODUCTS,

  RESERVE_BANK_AUSTRALIA,

  RESERVE_BANK_NEW_ZEALAND,

  REUTERS,

  REUTERS_SCREEN,

  SEA_PAC,

  TSI_SCRAP,

  TSI_STEEL,

  TELERATE,

  TELERATE_SCREEN,

  UXWEEKLY,

  WORLD_CRUDE_REPORT,

  WORLD_PULP_MONTHLY
}
/**
 * Defines the enumerated values to specify the nature of a location identifier.
 */
export enum CommodityLocationIdentifierTypeEnum {

  /**
   * The hub code of the buyer.
   */
  BUYER_HUB,

  /**
   * The physical or virtual point at which the commodity will be delivered.
   */
  DELIVERY_POINT,

  /**
   * The zone covering potential delivery points for the commodity
   */
  DELIVERY_ZONE,

  /**
   * The physical or virtual point at which the commodity enters a transportation system.
   */
  ENTRY_POINT,

  /**
   * Identification of the border(s) or border point(s) of a transportation contract.
   */
  INTERCONNECTION_POINT,

  /**
   * The hub code of the seller.
   */
  SELLER_HUB,

  /**
   * The physical or virtual point at which the commodity is withdrawn from a transportation system.
   */
  WITHDRAWAL_POINT
}
/**
 * The enumeration values to specify the Commodity Reference Prices specified in the Annex to the 2005 ISDA Commodity Definitions.
 */
export enum CommodityReferencePriceEnum {

  /**
   * Per 2005 ISDA Commodity Definitions, Sub-Annex A, Section 7.1 Commodity Reference Prices, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ALUMINIUM_ALLOY_LME_15_MONTH,

  /**
   * A code for the NYMEX Central Appalachian Coal commodity
   */
  COAL_CENTRAL_APPALACHIAN_NYMEX,

  /**
   * A code for the ICE Futures U.S. (‘ICUS’) Cocoa commodity
   */
  COCOA_ICE,

  /**
   * A code for the ICUS Coffee C commodity
   */
  COFFEE_ARABICA_ICE,

  /**
   * A code for the ICUS Coffee C commodity
   */
  COFFEE_ROBUSTA_ICE,

  /**
   * A code for the COMEX (‘CMX’) Copper Grade #1 commodity
   */
  COPPER_COMEX,

  /**
   * A code for the Chicago Board of Trade (‘CBOT’) Corn commodity
   */
  CORN_CBOT,

  /**
   * A code for the ICUS Cotton No. 2 commodity
   */
  COTTON_NO__2_ICE,

  /**
   * A code for the CBOT Ethanol commodity
   */
  ETHANOL_CBOT,

  /**
   * A code for the CME Feeder Cattle commodity
   */
  FEEDER_CATTLE_CME,

  /**
   * A code for the ICUS Frozen Concentrated Orange Juice commodity
   */
  FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE,

  /**
   * A code for the NYMEX Gasoline Blendstock (RBOB) commodity
   */
  GASOLINE_RBOB_NEW_YORK_ICE,

  /**
   * A code for the NYMEX Gasoline Blendstock (RBOB) commodity
   */
  GASOLINE_RBOB_NEW_YORK_NYMEX,

  /**
   * A code for the CMX Gold commodity
   */
  GOLD_COMEX,

  /**
   * A code for the NYMEX No. 2 Heating Oil, New York Harbor commodity
   */
  HEATING_OIL_NEW_YORK_NYMEX,

  /**
   * A code for the CME Lean Hogs commodity
   */
  LEAN_HOGS_CME,

  /**
   * A code for the CME Live Cattle commodity
   */
  LIVE_CATTLE_CME,

  /**
   * A code for the CME Random Length Lumber commodity
   */
  LUMBER_CME,

  /**
   * A code for the CME Milk Class III commodity
   */
  MILK_CLASS_III_CME,

  /**
   * A code for the CME Non Fat Dry Milk commodity
   */
  MILK_NONFAT_DRY_CME,

  /**
   * A code for the NYMEX Natural Gas commodity
   */
  NATURAL_GAS_NYMEX,

  /**
   * A code for the NYMEX Panhandle Basis Swap commodity
   */
  NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC,

  /**
   * A code for the NYMEX Waha Basis Swap commodity
   */
  NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC,

  /**
   * A code for the CBOT Oats commodity
   */
  OATS_CBOT,

  /**
   * A code for the NYMEX Crude Oil, Light Sweet commodity
   */
  OIL_WTI_NYMEX,

  /**
   * A code for the NYMEX Palladium commodity
   */
  PALLADIUM_NYMEX,

  /**
   * A code for the NYMEX Platinum commodity
   */
  PLATINUM_NYMEX,

  /**
   * A code for the CBOT Rough Rice commodity
   */
  RICE_CBOT,

  /**
   * A code for the CMX Silver commodity
   */
  SILVER_COMEX,

  /**
   * A code for the CBOT Soybeans commodity
   */
  SOYBEANS_CBOT,

  /**
   * A code for the CBOT Soybean Meal commodity
   */
  SOYBEAN_MEAL_CBOT,

  /**
   * A code for the CBOT Soybean Oil commodity
   */
  SOYBEAN_OIL_CBOT,

  /**
   * A code for the ICUS Sugar No. 11 commodity
   */
  SUGAR___11__WORLD__ICE,

  /**
   * A code for the ICUS Sugar No. 16 commodity
   */
  SUGAR___16__US__ICE,

  /**
   * A code for the CBOT Wheat commodity
   */
  WHEAT_CBOT,

  /**
   * A code for the Kansas City Board of Trade (‘KCBT’)Wheat commodity
   */
  WHEAT_HRW_KCBOT,

  /**
   * A code for the Wheat commodity
   */
  WHEAT_RED_SPRING_MGE
}
export enum CompareOp {

  EQUALS,

  GREATER_THAN,

  GREATER_THAN_OR_EQUALS,

  LESS_THAN,

  LESS_THAN_OR_EQUALS
}
/**
 * The enumerated values to specify the type of compounding, e.g. flat, straight.
 */
export enum CompoundingMethodEnum {

  /**
   * Flat compounding. Compounding excludes the spread. Note that the first compounding period has it's interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
   */
  FLAT,

  /**
   * No compounding is to be applied.
   */
  NONE,

  /**
   * Spread Exclusive compounding.
   */
  SPREAD_EXCLUSIVE,

  /**
   * Straight compounding. Compounding includes the spread.
   */
  STRAIGHT
}
/**
 * The enumerated values to specify how the compounding calculation is done
 */
export enum CompoundingTypeEnum {

  /**
   * Compounding is done only on business days, i.e. not compounded each day on weekends or holidays.
   */
  BUSINESS,

  /**
   * Compounding is done on each calendar day.
   */
  CALENDAR,

  /**
   * Compounding is not applicable
   */
  NONE
}
/**
 * Represents the enumerated values to identify where a concentration limit is applied.
 */
export enum ConcentrationLimitTypeEnum {

  /**
   * Specifies a limit on a single asset in the portfolio
   */
  ASSET,

  /**
   * Specifies a limit on all cash valued in the base currency of the portfolio.
   */
  BASE_CURRENCY_EQUIVALENT,

  /**
   * Specifies a limit on a single industry sector in the portfolio.
   */
  INDUSTRY_SECTOR,

  /**
   * Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
   */
  ISSUE_OUTSTANDING_AMOUNT,

  /**
   * Specifies a limit on a single issuer in the portfolio.
   */
  ISSUER,

  /**
   * Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
   */
  MARKET_CAPITALISATION,

  /**
   * Specifies a limit on a single exchange in the portfolio.
   */
  PRIMARY_EXCHANGE,

  /**
   * Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level.
   */
  ULTIMATE_PARENT_INSTITUTION
}
/**
 * Enumeration for the different types of confirmation status.
 */
export enum ConfirmationStatusEnum {

  CONFIRMED,

  UNCONFIRMED
}
/**
 * The enumerated values to specify a set of standard contract definitions relevant to the transaction.
 */
export enum ContractualDefinitionsEnum {

  /**
   * ISDA 1991 Interest Rate Definitions
   */
  ISDA_1991_INTEREST_RATE,

  /**
   * ISDA 1993 Commodity Derivatives Definitions
   */
  ISDA_1993_COMMODITY_DERIVATIVES,

  /**
   * ISDA 1996 Equity Derivatives Definitions
   */
  ISDA_1996_EQUITY_DERIVATIVES,

  /**
   * ISDA 1997 Bullion Definitions
   */
  ISDA_1997_BULLION,

  /**
   * ISDA 1997 Government Bond Option Definitions
   */
  ISDA_1997_GOVERNMENT_BOND_OPTION,

  /**
   * ISDA 1998 FX and Currency Option Definitions
   */
  ISDA_1998_FX_AND_CURRENCY_OPTION,

  /**
   * ISDA 1999 Credit Derivatives Definitions
   */
  ISDA_1999_CREDIT_DERIVATIVES,

  /**
   * ISDA 2000 Definitions
   */
  ISDA2000,

  /**
   * ISDA 2002 Equity Derivatives Definitions
   */
  ISDA_2002_EQUITY_DERIVATIVES,

  /**
   * ISDA 2003 Credit Derivatives Definitions
   */
  ISDA_2003_CREDIT_DERIVATIVES,

  /**
   * ISDA 2004 Novation Definitions
   */
  ISDA_2004_NOVATION,

  /**
   * ISDA 2005 Commodity Definitions
   */
  ISDA_2005_COMMODITY,

  /**
   * ISDA 2006 Definitions
   */
  ISDA2006,

  /**
   * ISDA 2006 Inflation Derivatives Definitions
   */
  ISDA_2006_INFLATION_DERIVATIVES,

  /**
   * ISDA 2008 Inflation Derivatives Definitions
   */
  ISDA_2008_INFLATION_DERIVATIVES,

  /**
   * ISDA 2011 Equity Derivatives Definitions
   */
  ISDA_2011_EQUITY_DERIVATIVES,

  /**
   * ISDA 2014 Credit Derivatives Definitions
   */
  ISDA_2014_CREDIT_DERIVATIVES,

  /**
   * ISDA 2021 Interest Rate Derivatives Definitions
   */
  ISDA_2021_INTEREST_RATE_DERIVATIVES,

  /**
   * ISDA 2022 Verified Carbon Credit Transactions Definitions
   */
  ISDA_2022_VERIFIED_CARBON_CREDIT,

  /**
   * ISDA 2023 Digital Asset Derivatives Definitions
   */
  ISDA_2023_DIGITAL_ASSET_DERIVATIVES
}
/**
 * The enumerated values to define the supplements to a base set of ISDA Definitions that are applicable to the transaction.
 */
export enum ContractualSupplementTypeEnum {

  /**
   * Standard Terms Supplement for ABX Transactions.
   */
  ABX,

  /**
   * Standard Terms Supplement for Asset-Backed Tranche Transactions.
   */
  ABX_TRANCHE,

  /**
   * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Leveraged Loans.
   */
  CD_SON_LEVERAGED_LOANS,

  /**
   * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
   */
  CD_SON_MBS,

  /**
   * Standard Terms Supplement for CDX Untranched Transactions.
   */
  CDX,

  /**
   * Standard Terms Supplement for CDX Emerging Markets Untranched Transactions.
   */
  CDX_EMERGING_MARKETS,

  /**
   * Standard Terms Supplement for CDX Emerging Markets Diversified Untranched Transactions..
   */
  CDX_EMERGING_MARKETS_DIVERSIFIED,

  /**
   * Standard Terms Supplement for CDX Swaption Transactions.
   */
  CDX_SWAPTION,

  /**
   * Standard Terms Supplement for Dow Jones CDX Tranche Transactions.
   */
  CDX_TRANCHE,

  /**
   * Standard Terms Supplement for CMBX Transactions.
   */
  CMBX,

  /**
   * Standard Terms Supplement for Single Name European CMBS Transactions.
   */
  EUROPEAN_CMBS,

  /**
   * Standard Terms Supplement for Single Name European RMBS Transactions.
   */
  EUROPEAN_RMBS,

  /**
   * Standard Terms Supplement for IOS Transactions.
   */
  IOS,

  /**
   * Supplement to the 1999 ISDA Credit Derivatives Definitions Relating to Convertible, Exchangeable or Accreting Obligations dated November 9, 2001.
   */
  ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS,

  /**
   * Restructuring Supplement to the 1999 ISDA Credit Derivatives Definitions dated May 11, 2001.
   */
  ISDA_1999_CREDIT_RESTRUCTURING,

  /**
   * Supplement Relating to Successor and Credit Events to the 1999 ISDA Credit Derivatives Definitions dated November 28, 2001.
   */
  ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS,

  /**
   * Additional Provisions for LPN dated December 6, 2007.
   */
  ISDA_2003_ADDITIONAL_PROVISIONS_LPN,

  /**
   * Additional Provisions for Contingent Credit Spread Transactions dated August 15, 2008.
   */
  ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION,

  /**
   * 2005 Matrix Supplement to the 2003 ISDA Credit Derivatives.
   */
  ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT,

  /**
   * Additional Provisions for the Argentine Republic: Excluded Obligations and Excluded Deliverable Obligations dated December 21, 2005.
   */
  ISDA_2003_CREDIT_ARGENTINE_REPUBLIC,

  /**
   * ISDA Credit Derivatives Determinations Committees and Auction Settlement Supplement to the 2003 ISDA Credit Derivatives Definitions (published on [TBD]).
   */
  ISDA_2003_CREDIT_AUCTION_SUPPLEMENT,

  /**
   * May 2003 Supplement to the 2003 ISDA Credit Derivatives Definitions.
   */
  ISDA_2003_CREDIT_MAY_2003,

  /**
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated May 9, 2003.
   */
  ISDA_2003_CREDIT_MONOLINE_INSURERS,

  /**
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated January 21, 2005.
   */
  ISDA_2003_CREDIT_MONOLINE_INSURERS_2005,

  /**
   * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
   */
  ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY,

  /**
   * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated February 14, 2005. 
   */
  ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005,

  /**
   * Additional Provisions for the Russian Federation: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
   */
  ISDA_2003_CREDIT_RUSSIAN_FEDERATION,

  /**
   * Additional Provisions for Credit Derivative Transactions - U.S. Municipal Entity as Reference Entity dated September 17, 2004.
   */
  ISDA_2003_CREDIT_US_MUNICIPALS,

  /**
   * Additional Provisions for STMicroelectronics NV dated December 6, 2007.
   */
  ISDA_2003_ST_MICROELECTRONICS_NV,

  /**
   * 2007 Full Lookthrough Depository Receipt Supplement to the 2002 Equity Derivatives Definitions.
   */
  ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,

  /**
   * 2007 Partial Lookthrough Depository Receipt Supplement to the 2002 ISDA Equity Derivatives Definitions.
   */
  ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,

  /**
   * Additional Provisions for Physically Settled Default Swaps Monoline Insurer.
   */
  ISDA_CREDIT_MONOLINE_INSURERS,

  /**
   * Additional Provisions for Fixed Recovery Credit Default Swap Transactions
   */
  ISDA_DELIVERY_RESTRICTIONS,

  /**
   * Additional Provisions for Fixed Recovery Credit Default Swap Transactions.
   */
  ISDA_FIXED_RECOVERY,

  /**
   * Additional Provisions for LPN Reference Entities.
   */
  ISDALPN_REFERENCE_ENTITIES,

  /**
   * Canadian Supplement to the 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement dated March 29, 2004.
   */
  ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT,

  /**
   * Additional Provisions for Recovery Lock Credit Default Swap Transactions.
   */
  ISDA_RECOVERY_LOCK,

  /**
   * Additional Provisions for Secured Deliverable Obligation Characteristic.
   */
  ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC,

  /**
   * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Transactions.
   */
  LCDX,

  /**
   * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Tranche Transactions.
   */
  LCDX_TRANCHE,

  /**
   * Standard Terms Supplement for MBX Transactions.
   */
  MBX,

  /**
   * Standard Terms Supplement for Municipal CDX Untranched Transactions.
   */
  MCDX,

  /**
   * Standard Terms Supplement for PO Index Transactions.
   */
  PO,

  /**
   * Standard Terms Supplement for PrimeX Transactions.
   */
  PRIME_X,

  /**
   * Standard Terms Supplement for Standard CDX Tranche Transactions.
   */
  STANDARD_CDX_TRANCHE,

  /**
   * Standard Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
   */
  STANDARD_LCDS,

  /**
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
   */
  STANDARD_LCDS_BULLET,

  /**
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
   */
  STANDARD_LCDX_BULLET,

  /**
   * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
   */
  STANDARD_LCDX_BULLET_TRANCHE,

  /**
   * Standard Terms Supplement for Standard iTraxx Europe Tranched Transactions.
   */
  STANDARDI_TRAXX_EUROPE_TRANCHE,

  /**
   * Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
   */
  SYNDICATED_SECURED_LOAN_CDS,

  /**
   * Standard Terms Supplement for TRX Transactions.
   */
  TRX,

  /**
   * Standard Terms Supplement for TRX.II Transactions.
   */
  TRX_II,

  /**
   * Standard Terms Supplement for iTraxx Asia Excluding Japan.
   */
  I_TRAXX_ASIA_EX_JAPAN,

  /**
   * Standard Terms Supplement for iTraxx Asia Ex-Japan Swaption Transactions.
   */
  I_TRAXX_ASIA_EX_JAPAN_SWAPTION,

  /**
   * Standard Terms Supplement for iTraxx Asia Excluding Japan Tranched Transactions.
   */
  I_TRAXX_ASIA_EX_JAPAN_TRANCHE,

  /**
   * Standard Terms Supplement for iTraxx Australia.
   */
  I_TRAXX_AUSTRALIA,

  /**
   * Standard Terms Supplement for iTraxx Australia Swaption Transactions.
   */
  I_TRAXX_AUSTRALIA_SWAPTION,

  /**
   * Standard Terms Supplement for iTraxx Australia Tranched Transactions.
   */
  I_TRAXX_AUSTRALIA_TRANCHE,

  /**
   * Standard Terms Supplement for iTraxx CJ.
   */
  I_TRAXX_CJ,

  /**
   * Standard Terms Supplement for iTraxx CJ Tranched Transactions.
   */
  I_TRAXX_CJ_TRANCHE,

  /**
   * Standard Terms Supplement for iTraxx Europe Transactions.
   */
  I_TRAXX_EUROPE,

  /**
   * Standard Terms Supplement for iTraxx Europe Dealer Form.
   */
  I_TRAXX_EUROPE_DEALER,

  /**
   * Standard Terms Supplement for iTraxx Europe Non-Dealer Form.
   */
  I_TRAXX_EUROPE_NON_DEALER,

  /**
   * Standard Terms Supplement for iTraxx Europe Swaption Transactions.
   */
  I_TRAXX_EUROPE_SWAPTION,

  /**
   * Standard Terms Supplement for iTraxx Europe Tranched Transactions.
   */
  I_TRAXX_EUROPE_TRANCHE,

  /**
   * Standard Terms Supplement for iTraxx Japan.
   */
  I_TRAXX_JAPAN,

  /**
   * Standard Terms Supplement for iTraxx Japan Swaption Transactions.
   */
  I_TRAXX_JAPAN_SWAPTION,

  /**
   * Standard Terms Supplement for iTraxx Japan Tranched Transactions.
   */
  I_TRAXX_JAPAN_TRANCHE,

  /**
   * Standard Terms Supplement for iTraxx LevX.
   */
  I_TRAXX_LEV_X,

  /**
   * Standard Terms Supplement for iTraxx SDI 75 Dealer Transactions.
   */
  I_TRAXX_SDI_75_DEALER,

  /**
   * Standard Terms Supplement for iTraxx SDI 75 Non-Dealer Transactions.
   */
  I_TRAXX_SDI_75_NON_DEALER,

  /**
   * Standard Terms Supplement for iTraxx SovX.
   */
  I_TRAXX_SOV_X
}
/**
 * The enumerated values to specify the origin of a corporate action transfer.
 */
export enum CorporateActionTypeEnum {

  /**
   * Corporate action triggered by a bonus issue. A bonus issue or bonus share is a free share of stock given to current shareholders in a company, based upon the number of shares that the shareholder already owns. While the issue of bonus shares increases the total number of shares issued and owned, it does not change the value of the company. The value maps closely to the ISO code (BONU) defined as a bonus, scrip or capitalisation issue. Security holders receive additional assets free of payment from the issuer, in proportion to their holding.
   */
  BONUS_ISSUE,

  /**
   * Corporate action triggered by the distribution of a cash dividend.
   */
  CASH_DIVIDEND,

  /**
   * Corporate action triggered by a Class Action. An action where an individual represents a group in a court claim. The judgment from the suit is for all the members of the group (class). The value maps closely to the ISO code (CLSA) defined as the situation where interested parties seek restitution for financial loss. The security holder may be offered the opportunity to join a class action proceeding and would need to respond with an instruction.
   */
  CLASS_ACTION,

  /**
   * Corporate action triggered by the removal of a security from a stock exchange.
   */
  DELISTING,

  /**
   * Corporate action triggered by an early redemption. The value maps closely to the ISO code (MCAL) defined as the redemption of an entire issue outstanding of securities, for example, bonds, preferred equity, funds, by the issuer or its agent, for example, asset manager, before final maturity.
   */
  EARLY_REDEMPTION,

  /**
   * Corporate action triggered by a liquidation. When a business or firm is terminated or bankrupt, its assets are sold (liquidated) and the proceeds pay creditors. Any leftovers are distributed to shareholders. The value maps closely to the ISO code (LIQU) defined as a distribution of cash, assets or both. Debt may be paid in order of priority based on preferred claims to assets specified by the security.
   */
  LIQUIDATION,

  /**
   * Corporate action triggered by a merger. Mergers and acquisitions (abbreviated M&A) is an aspect of corporate strategy, corporate finance and management dealing with the buying, selling, dividing and combining of different companies and similar entities that can help an enterprise grow rapidly in its sector or location of origin, or a new field or new location, without creating a subsidiary, other child entity or using a joint venture. The distinction between a merger and an acquisition has become increasingly blurred in various respects (particularly in terms of the ultimate economic outcome), although it has not completely disappeared in all situations. The value maps closely to the ISO code (MRGR) defined as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
   */
  MERGER,

  /**
   * Corporate action triggered by a reverse split. A reverse stock split or reverse split is a process by a company of issuing to each shareholder in that company a smaller number of new shares in proportion to that shareholder's original shares that are subsequently canceled. A reverse stock split is also called a stock merge. The reduction in the number of issued shares is accompanied by a proportional increase in the share price. The value maps closely to the ISO code (SPLR) defined as a decrease in a company's number of outstanding equities without any change in the shareholder's equity or the aggregate market value at the time of the split. Equity price and nominal value are increased accordingly.
   */
  REVERSE_STOCK_SPLIT,

  /**
   * Corporate action triggered by an issuance to shareholders of rights to purchase additional shares at a discount.
   */
  RIGHTS_ISSUE,

  /**
   * Corporate action triggered by a spin Off. A spin-out, also known as a spin-off or a starburst, refers to a type of corporate action where a company splits off sections of itself as a separate business. The value maps closely to the ISO code (SOFF) defined as a a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares. Spin-off represents a form of divestiture usually resulting in an independent company or in an existing company. For example, demerger, distribution, unbundling.
   */
  SPIN_OFF,

  /**
   * Corporate action triggered by the distribution of a stock dividend.
   */
  STOCK_DIVIDEND,

  /**
   * Corporate action triggered by a change in the code used to trade the security.
   */
  STOCK_IDENTIFIER_CHANGE,

  /**
   * Corporate action triggered by a change in the name used to trade the security.
   */
  STOCK_NAME_CHANGE,

  /**
   * Corporate action triggered by a Stock Reclassification.
   */
  STOCK_RECLASSIFICATION,

  /**
   * Corporate action triggered by a stock split. A stock split or stock divide increases the number of shares in a public company. The price is adjusted such that the before and after market capitalization of the company remains the same and dilutiondoes not occur. The value maps closely to the ISO code (SPLF) defined as a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares.
   */
  STOCK_SPLIT,

  /**
   * Corporate action triggered by a takeover. A takeover is the purchase of onecompany (the target) by another (the acquirer, or bidder). The value maps to the ISO code (TEND) but is finer grained than TEND which emcompasses Tender/Acquisition/Takeover/Purchase Offer/Buyback. ISO defines the TEND code as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
   */
  TAKEOVER
}
/**
 * Defines the enumerated values to specify the two counterparties to the transaction.
 */
export enum CounterpartyRoleEnum {

  PARTY_1,

  PARTY_2
}
/**
 * Represents the enumerated values to specify a credit event type.
 */
export enum CreditEventTypeEnum {

  /**
   * The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as 'technically' a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
   */
  BANKRUPTCY,

  /**
   * Results from the fact that the rating of the reference obligation is downgraded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
   */
  DISTRESSED_RATINGS_DOWNGRADE,

  /**
   * This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregrate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
   */
  FAILURE_TO_PAY,

  /**
   * Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
   */
  FAILURE_TO_PAY_INTEREST,

  /**
   * Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
   */
  FAILURE_TO_PAY_PRINCIPAL,

  /**
   * A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
   */
  GOVERNMENTAL_INTERVENTION,

  /**
   * Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
   */
  IMPLIED_WRITEDOWN,

  /**
   * Results from the fact that the underlier fails to make principal payments as expected.
   */
  MATURITY_EXTENSION,

  /**
   * One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
   */
  OBLIGATION_ACCELERATION,

  /**
   * One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
   */
  OBLIGATION_DEFAULT,

  /**
   * The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
   */
  REPUDIATION_MORATORIUM,

  /**
   * A restructuring is an event that materially impacts the reference entity's obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
   */
  RESTRUCTURING,

  /**
   * Results from the fact that the underlier writes down its outstanding principal amount.
   */
  WRITEDOWN
}
/**
 * The enumeration values to qualify the type of credit limits.
 */
export enum CreditLimitTypeEnum {

  /**
   * The type of credit line expressed in CS01. The sensitivity with respect to changes in the CDS spread.
   */
  CS01,

  /**
   * The type of credit line expressed in DV01. The dollar value of a one basis point decrease in interest rates. It shows the change in a bond's price compared to a decrease in the bond's yield.
   */
  DV01,

  /**
   * The type of credit line expressed in Initial Margin value.
   */
  IM,

  /**
   * The type of credit line expressed as a Net Present Value.
   */
  NPV,

  /**
   * The type of credit line expressed in Notional amount.
   */
  NOTIONAL,

  /**
   * The type of credit line expressed in PV01. The value of a one dollar or one basis point annuity.
   */
  PV01
}
/**
 * Identifies an agency rating as a simple scale boundary of minimum or maximum.
 */
export enum CreditNotationBoundaryEnum {

  /**
   * Denotes a maxiumum boundary
   */
  MAXIMUM,

  /**
   * Denotes a minumum boundary
   */
  MINIMUM
}
/**
 * Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
 */
export enum CreditNotationMismatchResolutionEnum {

  /**
   * Denotes the average credit notation if several notations are listed.
   */
  AVERAGE,

  /**
   * Denotes the highest credit notation if several notations are listed.
   */
  HIGHEST,

  /**
   * Denotes the lowest credit notation if several notations are listed.
   */
  LOWEST,

  /**
   * Utilised where bespoke language represents the label characteristics of the rating.
   */
  OTHER,

  /**
   * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
   */
  REFERENCE_AGENCY,

  /**
   * Denotes the second best credit notation if several notations are listed.
   */
  SECOND_BEST
}
/**
 * Represents the enumerated values to specify the rating agencies.
 */
export enum CreditRatingAgencyEnum {

  /**
   * A. M. Best
   */
  AM_BEST,

  /**
   * Canadian Bond Rating Service
   */
  CBRS,

  /**
   * Dominion Bond Rating Service
   */
  DBRS,

  /**
   * Fitch
   */
  FITCH,

  /**
   * Japan Credit Rating Agency, Ltd.
   */
  JAPANAGENCY,

  /**
   * Moody's
   */
  MOODYS,

  /**
   * Rating And Investment Information, Inc.
   */
  RATING_AND_INVESTMENT_INFORMATION,

  /**
   * Standard And Poor's
   */
  STANDARD_AND_POORS
}
/**
 * Represents the enumerated values to specify the credit watch rating.
 */
export enum CreditRatingCreditWatchEnum {

  /**
   * Denotes a rating may be raised, lowered, or affirmed.
   */
  DEVELOPING,

  /**
   * Denotes a rating may be lowered.
   */
  NEGATIVE,

  /**
   * Denotes a rating may be raised.
   */
  POSITIVE
}
/**
 * Represents the enumerated values to specify the credit rating outlook.
 */
export enum CreditRatingOutlookEnum {

  /**
   * Denotes a rating may be raised, lowered, or affirmed.
   */
  DEVELOPING,

  /**
   * Denotes a rating may be lowered.
   */
  NEGATIVE,

  /**
   * Denotes a rating may be raised.
   */
  POSITIVE,

  /**
   * Denotes a rating is not likely to change.
   */
  STABLE
}
/**
 * Represents an enumeration list to identify tranched or untranched credit risk.
 */
export enum CreditRiskEnum {

  /**
   * Indicates tranched credit risk, including securitizations.
   */
  TRANCHED_CREDIT_RISK,

  /**
   * Indicates tranched credit risk, including repackagings.
   */
  UNTRANCHED_CREDIT_RISK
}
/**
 * Seniority of debt instruments comprising the index.
 */
export enum CreditSeniorityEnum {

  /**
   * Other as defined under EMIR.
   */
  OTHER,

  /**
   * Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC).
   */
  SENIOR_LOSS_ABSORBING_CAPACITY,

  /**
   * Senior domestic (RED Tier Code: SECDOM).
   */
  SENIOR_SEC,

  /**
   * Senior foreign (RED Tier Code: SNRFOR).
   */
  SENIOR_UN_SEC,

  /**
   * Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2).
   */
  SUB_LOWER_TIER_2,

  /**
   * Subordinate Tier 1 (RED Tier Code: PREFT1).
   */
  SUB_TIER_1,

  /**
   * Subordinate, Tier 3.
   */
  SUB_TIER_3,

  /**
   * Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2).
   */
  SUB_UPPER_TIER_2
}
/**
 * The enumerated values to specify the type of Credit Support Agreement governing the transaction.
 */
export enum CreditSupportAgreementTypeEnum {

  /**
   * A Collateral Transfer Agreement
   */
  COLLATERAL_TRANSFER_AGREEMENT,

  /**
   * A Credit Support Annex legal agreement.
   */
  CREDIT_SUPPORT_ANNEX,

  /**
   * A Credit Support Deed legal agreement.
   */
  CREDIT_SUPPORT_DEED
}
/**
 * The enumerated values to specify the Credit Support Document Terms
 */
export enum CreditSupportDocumentTermsEnum {

  /**
   * Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement.
   */
  ANY,

  /**
   * No Credit Support Document is specified.
   */
  NONE,

  /**
   * A specified Credit Support Document is provided
   */
  SPECIFIED
}
/**
 * The enumerated values to specify the Credit Support Provider Terms
 */
export enum CreditSupportProviderTermsEnum {

  /**
   * Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support.
   */
  ANY,

  /**
   * No Credit Support Provider is specified.
   */
  NONE,

  /**
   * A specified Credit Support Provider is provided
   */
  SPECIFIED
}
/**
 * How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1 
 */
export enum CsaTypeEnum {

  /**
   * Thre is an existing Credit Support Annex
   */
  EXISTING_CSA,

  /**
   * There is no CSA applicable
   */
  NO_CSA,

  /**
   * There is a bilateral Credit Support Annex specific to the transaction
   */
  REFERENCE_VMCSA
}
/**
 * Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016.
 */
export enum CurrencyCodeEnum {

  /**
   * UAE Dirham
   */
  AED,

  /**
   * Afghani
   */
  AFN,

  /**
   * Lek
   */
  ALL,

  /**
   * Armenian Dram
   */
  AMD,

  /**
   * Netherlands Antillean Guilder
   */
  ANG,

  /**
   * Kwanza
   */
  AOA,

  /**
   * Argentine Peso
   */
  ARS,

  /**
   * Australian Dollar
   */
  AUD,

  /**
   * Aruban Florin
   */
  AWG,

  /**
   * Azerbaijan Manat
   */
  AZN,

  /**
   * Convertible Mark
   */
  BAM,

  /**
   * Barbados Dollar
   */
  BBD,

  /**
   * Taka
   */
  BDT,

  /**
   * Bulgarian Lev
   */
  BGN,

  /**
   * Bahraini Dinar
   */
  BHD,

  /**
   * Burundi Franc
   */
  BIF,

  /**
   * Bermudian Dollar
   */
  BMD,

  /**
   * Brunei Dollar
   */
  BND,

  /**
   * Boliviano
   */
  BOB,

  /**
   * Mvdol
   */
  BOV,

  /**
   * Brazilian Real
   */
  BRL,

  /**
   * Bahamian Dollar
   */
  BSD,

  /**
   * Ngultrum
   */
  BTN,

  /**
   * Pula
   */
  BWP,

  /**
   * Belarusian Ruble
   */
  BYN,

  /**
   * Belize Dollar
   */
  BZD,

  /**
   * Canadian Dollar
   */
  CAD,

  /**
   * Congolese Franc
   */
  CDF,

  /**
   * WIR Euro
   */
  CHE,

  /**
   * Swiss Franc
   */
  CHF,

  /**
   * WIR Franc
   */
  CHW,

  /**
   * Unidad de Fomento
   */
  CLF,

  /**
   * Chilean Peso
   */
  CLP,

  /**
   * Offshore Chinese Yuan traded in Hong Kong.
   */
  CNH,

  /**
   * Offshore Chinese Yuan traded in Taiwan.
   */
  CNT,

  /**
   * Yuan Renminbi
   */
  CNY,

  /**
   * Colombian Peso
   */
  COP,

  /**
   * Unidad de Valor Real
   */
  COU,

  /**
   * Costa Rican Colon
   */
  CRC,

  /**
   * Peso Convertible
   */
  CUC,

  /**
   * Cuban Peso
   */
  CUP,

  /**
   * Cabo Verde Escudo
   */
  CVE,

  /**
   * Czech Koruna
   */
  CZK,

  /**
   * Djibouti Franc
   */
  DJF,

  /**
   * Danish Krone
   */
  DKK,

  /**
   * Dominican Peso
   */
  DOP,

  /**
   * Algerian Dinar
   */
  DZD,

  /**
   * Egyptian Pound
   */
  EGP,

  /**
   * Nakfa
   */
  ERN,

  /**
   * Ethiopian Birr
   */
  ETB,

  /**
   * Euro
   */
  EUR,

  /**
   * Fiji Dollar
   */
  FJD,

  /**
   * Falkland Islands Pound
   */
  FKP,

  /**
   * Pound Sterling
   */
  GBP,

  /**
   * Lari
   */
  GEL,

  /**
   * Guernsey Pound.
   */
  GGP,

  /**
   * Ghana Cedi
   */
  GHS,

  /**
   * Gibraltar Pound
   */
  GIP,

  /**
   * Dalasi
   */
  GMD,

  /**
   * Guinean Franc
   */
  GNF,

  /**
   * Quetzal
   */
  GTQ,

  /**
   * Guyana Dollar
   */
  GYD,

  /**
   * Hong Kong Dollar
   */
  HKD,

  /**
   * Lempira
   */
  HNL,

  /**
   * Gourde
   */
  HTG,

  /**
   * Forint
   */
  HUF,

  /**
   * Rupiah
   */
  IDR,

  /**
   * New Israeli Sheqel
   */
  ILS,

  /**
   * Isle of Man Pound.
   */
  IMP,

  /**
   * Indian Rupee
   */
  INR,

  /**
   * Iraqi Dinar
   */
  IQD,

  /**
   * Iranian Rial
   */
  IRR,

  /**
   * Iceland Krona
   */
  ISK,

  /**
   * Jersey Pound.
   */
  JEP,

  /**
   * Jamaican Dollar
   */
  JMD,

  /**
   * Jordanian Dinar
   */
  JOD,

  /**
   * Yen
   */
  JPY,

  /**
   * Kenyan Shilling
   */
  KES,

  /**
   * Som
   */
  KGS,

  /**
   * Riel
   */
  KHR,

  /**
   * Tuvaluan Dollar.
   */
  KID,

  /**
   * Comorian Franc 
   */
  KMF,

  /**
   * North Korean Won
   */
  KPW,

  /**
   * Won
   */
  KRW,

  /**
   * Kuwaiti Dinar
   */
  KWD,

  /**
   * Cayman Islands Dollar
   */
  KYD,

  /**
   * Tenge
   */
  KZT,

  /**
   * Lao Kip
   */
  LAK,

  /**
   * Lebanese Pound
   */
  LBP,

  /**
   * Sri Lanka Rupee
   */
  LKR,

  /**
   * Liberian Dollar
   */
  LRD,

  /**
   * Loti
   */
  LSL,

  /**
   * Libyan Dinar
   */
  LYD,

  /**
   * Moroccan Dirham
   */
  MAD,

  /**
   * Monegasque Franc.
   */
  MCF,

  /**
   * Moldovan Leu
   */
  MDL,

  /**
   * Malagasy Ariary
   */
  MGA,

  /**
   * Denar
   */
  MKD,

  /**
   * Kyat
   */
  MMK,

  /**
   * Tugrik
   */
  MNT,

  /**
   * Pataca
   */
  MOP,

  /**
   * Ouguiya
   */
  MRU,

  /**
   * Mauritius Rupee
   */
  MUR,

  /**
   * Rufiyaa
   */
  MVR,

  /**
   * Malawi Kwacha
   */
  MWK,

  /**
   * Mexican Peso
   */
  MXN,

  /**
   * Mexican Unidad de Inversion (UDI)
   */
  MXV,

  /**
   * Malaysian Ringgit
   */
  MYR,

  /**
   * Mozambique Metical
   */
  MZN,

  /**
   * Namibia Dollar
   */
  NAD,

  /**
   * Naira
   */
  NGN,

  /**
   * Cordoba Oro
   */
  NIO,

  /**
   * Norwegian Krone
   */
  NOK,

  /**
   * Nepalese Rupee
   */
  NPR,

  /**
   * New Zealand Dollar
   */
  NZD,

  /**
   * Rial Omani
   */
  OMR,

  /**
   * Balboa
   */
  PAB,

  /**
   * Sol
   */
  PEN,

  /**
   * Kina
   */
  PGK,

  /**
   * Philippine Peso
   */
  PHP,

  /**
   * Pakistan Rupee
   */
  PKR,

  /**
   * Zloty
   */
  PLN,

  /**
   * Guarani
   */
  PYG,

  /**
   * Qatari Rial
   */
  QAR,

  /**
   * Romanian Leu
   */
  RON,

  /**
   * Serbian Dinar
   */
  RSD,

  /**
   * Russian Ruble
   */
  RUB,

  /**
   * Rwanda Franc
   */
  RWF,

  /**
   * Saudi Riyal
   */
  SAR,

  /**
   * Solomon Islands Dollar
   */
  SBD,

  /**
   * Seychelles Rupee
   */
  SCR,

  /**
   * Sudanese Pound
   */
  SDG,

  /**
   * Swedish Krona
   */
  SEK,

  /**
   * Singapore Dollar
   */
  SGD,

  /**
   * Saint Helena Pound
   */
  SHP,

  /**
   * Leone
   */
  SLE,

  /**
   * Sammarinese Lira.
   */
  SML,

  /**
   * Somali Shilling
   */
  SOS,

  /**
   * Surinam Dollar
   */
  SRD,

  /**
   * South Sudanese Pound
   */
  SSP,

  /**
   * Dobra
   */
  STN,

  /**
   * El Salvador Colon
   */
  SVC,

  /**
   * Syrian Pound
   */
  SYP,

  /**
   * Lilangeni
   */
  SZL,

  /**
   * Baht
   */
  THB,

  /**
   * Somoni
   */
  TJS,

  /**
   * Turkmenistan New Manat
   */
  TMT,

  /**
   * Tunisian Dinar
   */
  TND,

  /**
   * Pa’anga
   */
  TOP,

  /**
   * Turkish Lira
   */
  TRY,

  /**
   * Trinidad and Tobago Dollar
   */
  TTD,

  /**
   * New Taiwan Dollar
   */
  TWD,

  /**
   * Tanzanian Shilling
   */
  TZS,

  /**
   * Hryvnia
   */
  UAH,

  /**
   * Uganda Shilling
   */
  UGX,

  /**
   * US Dollar
   */
  USD,

  /**
   * US Dollar (Next day)
   */
  USN,

  /**
   * Uruguay Peso en Unidades Indexadas (UI)
   */
  UYI,

  /**
   * Peso Uruguayo
   */
  UYU,

  /**
   * Unidad Previsional
   */
  UYW,

  /**
   * Uzbekistan Sum
   */
  UZS,

  /**
   * Vatican Lira.
   */
  VAL,

  /**
   * Bolívar Soberano
   */
  VED,

  /**
   * Bolívar Soberano
   */
  VES,

  /**
   * Dong
   */
  VND,

  /**
   * Vatu
   */
  VUV,

  /**
   * Tala
   */
  WST,

  /**
   * CFA Franc BEAC
   */
  XAF,

  /**
   * Silver
   */
  XAG,

  /**
   * Gold
   */
  XAU,

  /**
   * Bond Markets Unit European Composite Unit (EURCO)
   */
  XBA,

  /**
   * Bond Markets Unit European Monetary Unit (E.M.U.-6)
   */
  XBB,

  /**
   * Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
   */
  XBC,

  /**
   * Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
   */
  XBD,

  /**
   * East Caribbean Dollar
   */
  XCD,

  /**
   * SDR (Special Drawing Right)
   */
  XDR,

  /**
   * CFA Franc BCEAO
   */
  XOF,

  /**
   * Palladium
   */
  XPD,

  /**
   * CFP Franc
   */
  XPF,

  /**
   * Platinum
   */
  XPT,

  /**
   * Sucre
   */
  XSU,

  /**
   * Codes specifically reserved for testing purposes
   */
  XTS,

  /**
   * ADB Unit of Account
   */
  XUA,

  /**
   * The codes assigned for transactions where no currency is involved
   */
  XXX,

  /**
   * Yemeni Rial
   */
  YER,

  /**
   * Rand
   */
  ZAR,

  /**
   * Zambian Kwacha
   */
  ZMW,

  /**
   * Zimbabwe Gold
   */
  ZWG
}
/**
 * The enumerated values to specify the day count fraction.
 */
export enum DayCountFractionEnum {

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (v), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (e) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (d).
   */
  ACT_360,

  /**
   * Per CFTC definitions.
   */
  ACT_364,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ix), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (i).
   */
  ACT_365L,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iv), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (d) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (c).
   */
  ACT_365_FIXED,

  /**
   * The Fixed/Floating Amount will be calculated in accordance with the 'BASE EXACT/EXACT' day count fraction, as defined in the 'Definitions Communes plusieurs Additifs Techniques' published by the Association Francaise des Banques in September 1994.
   */
  ACT_ACT_AFB,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (c). This day count fraction code is applicable for transactions booked under the 2021 ISDA Definitions and the 2006 ISDA Definitions. Transactions under the 2000 ISDA Definitions should use the ACT/ACT.ISMA code instead.
   */
  ACT_ACT_ICMA,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (b) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (b). Note that going from FpML 2.0 Recommendation to the FpML 3.0 Trial Recommendation the code in FpML 2.0 'ACT/365.ISDA' became 'ACT/ACT.ISDA'.
   */
  ACT_ACT_ISDA,

  /**
   * The Fixed/Floating Amount will be calculated in accordance with Rule 251 of the statutes, by-laws, rules and recommendations of the International Securities Market Association, as published in April 1999, as applied to straight and convertible bonds issued after December 31, 1998, as though the Fixed/Floating Amount were the interest coupon on such a bond. This day count fraction code is applicable for transactions booked under the 2000 ISDA Definitions. Transactions under the 2021 ISDA Definitions and the 2006 ISDA Definitions should use the ACT/ACT.ICMA code instead.
   */
  ACT_ACT_ISMA,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (x). Supercedes BUS/252, the number of Business Days in the Calculation Period or Compounding Period in respect of which payment is being made divided by 252.
   */
  CAL_252,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (xi), the calculation mechanics are driven deterministically by the Calculation Period Frequency (i.e. 0.25 if it is three months, 0.5 if it is 6 months, 1 if it is a year), except that if the first Calculation Period or the final Calculation Period is less than the Calculation Period Frequency, Actual/Actual (ISDA) shall apply to that Calculation Period
   */
  RBA_BOND_BASIS,

  /**
   * Per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (a) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (a).
   */
  _1_1,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (g) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (f). Note that the algorithm defined for this day count fraction has changed between the 2000 ISDA Definitions and 2006 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
   */
  _30E_360,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (viii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (h). Note the algorithm for this day count fraction under the 2006 ISDA Definitions is designed to yield the same results in practice as the version of the 30E/360 day count fraction defined in the 2000 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
   */
  _30E_360_ISDA,

  /**
   * Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vi), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (f) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (e).
   */
  _30_360
}
/**
 * Denotes the method by which the pricing days are distributed across the pricing period.
 */
export enum DayDistributionEnum {

  ALL,

  FIRST,

  LAST,

  PENULTIMATE
}
/**
 * The enumerated values to specify a day of the seven-day week.
 */
export enum DayOfWeekEnum {

  /**
   * Friday
   */
  FRI,

  /**
   * Monday
   */
  MON,

  /**
   * Saturday
   */
  SAT,

  /**
   * Sunday
   */
  SUN,

  /**
   * Thursday
   */
  THU,

  /**
   * Tuesday
   */
  TUE,

  /**
   * Wednesday
   */
  WED
}
/**
 * Lists the enumerated values to specify the day type classification used in counting the number of days between two dates.
 */
export enum DayTypeEnum {

  /**
   * Applies when calculating the number of days between two dates the count includes only business days.
   */
  BUSINESS,

  /**
   * Applies when calculating the number of days between two dates the count includes all calendar days.
   */
  CALENDAR,

  /**
   * Applies when calculating the number of days between two dates the count includes only currency business days.
   */
  CURRENCY_BUSINESS,

  /**
   * Applies when calculating the number of days between two dates the count includes only stock exchange business days.
   */
  EXCHANGE_BUSINESS,

  /**
   * Applies when calculating the number of days between two dates the count includes only scheduled trading days.
   */
  SCHEDULED_TRADING_DAY
}
/**
 * Represents an enumeration list that identifies the type of debt.
 */
export enum DebtClassEnum {

  /**
   * Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations.
   */
  ASSET_BACKED,

  /**
   * Identifies a debt instrument that can be converted into common shares.
   */
  CONVERTIBLE,

  /**
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer.
   */
  HOLDER_CONVERTIBLE,

  /**
   * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer.
   */
  HOLDER_EXCHANGEABLE,

  /**
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
   */
  ISSUER_CONVERTIBLE,

  /**
   * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable.
   */
  ISSUER_EXCHANGEABLE,

  /**
   * Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
   */
  REG_CAP,

  /**
   * Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
   */
  STRUCTURED,

  /**
   * Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
   */
  VANILLA
}
/**
 * Represents an enumeration list that specifies the general rule for periodic interest rate payment.
 */
export enum DebtInterestEnum {

  /**
   * Denotes payment calculated with reference to a fixed interest rate.
   */
  FIXED,

  /**
   * Denotes payment calculated with reference to a floating interest rate.
   */
  FLOATING,

  /**
   * Denotes payment calculated with reference to one or more price or other indices (other than inflation rates).
   */
  INDEX_LINKED,

  /**
   * Denotes payment calculated with reference to one or more specified inflation rates.
   */
  INFLATION_LINKED,

  /**
   * Denotes a stripped bond representing only the interest component.
   */
  INTEREST_ONLY,

  /**
   * Denotes payment calculated with reference to the inverse of a floating interest rate.
   */
  INVERSE_FLOATING,

  /**
   * Denotes payment calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
   */
  OTHER_STRUCTURED,

  /**
   * Denotes a zero coupon bond that does not pay intetrest.
   */
  ZERO_COUPON
}
/**
 * Represents an enumeration list that specifies the general rule for repayment of principal.
 */
export enum DebtPrincipalEnum {

  /**
   * Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
   */
  AMORTISING,

  /**
   * Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
   */
  BULLET,

  /**
   * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
   */
  CALLABLE,

  /**
   * Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
   */
  INDEX_LINKED,

  /**
   * Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
   */
  INFLATION_LINKED,

  /**
   * Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
   */
  OTHER_STRUCTURED,

  /**
   * Denotes a stripped bond representing only the principal component.
   */
  PRINCIPAL_ONLY,

  /**
   * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
   */
  PUTTABLE
}
/**
 * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
 */
export enum DebtSeniorityEnum {

  /**
   * Denotes debt which is secured over assets of the issuer or a related party (eg guarantor).
   */
  SECURED,

  /**
   * Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer.
   */
  SENIOR,

  /**
   * Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met.
   */
  SUBORDINATED
}
/**
 * The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language.
 */
export enum DeliveryAmountElectionEnum {

  /**
   * The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.`
   */
  LAST_AND_ANY_LOCAL_BUSINESS_DAY,

  /**
   * The delivery only includes `Transfer on last Local Business Day.
   */
  LAST_LOCAL_BUSINESS_DAY
}
/**
 * Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
 */
export enum DeliveryMethodEnum {

  /**
   * Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other.
   */
  DELIVERY_VERSUS_PAYMENT,

  /**
   * Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa.
   */
  FREE_OF_PAYMENT,

  /**
   * Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment.
   */
  PRE_DELIVERY,

  /**
   * Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment.
   */
  PRE_PAYMENT
}
export enum DeliveryNearbyTypeEnum {

  /**
   * Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
   */
  CALCULATION_PERIOD,

  /**
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
   */
  NEARBY_MONTH,

  /**
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
   */
  NEARBY_WEEK
}
/**
 * The enumerated values to specify the method according to which an amount or a date is determined.
 */
export enum DeterminationMethodEnum {

  /**
   * Agreed separately between the parties.
   */
  AGREED_INITIAL_PRICE,

  /**
   * As specified in Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,

  /**
   * Determined by the Calculation Agent.
   */
  CALCULATION_AGENT,

  /**
   * Official Closing Price.
   */
  CLOSING_PRICE,

  /**
   * Determined by the Currency of Equity Dividends.
   */
  DIVIDEND_CURRENCY,

  /**
   * The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
   */
  EXPIRING_CONTRACT_LEVEL,

  /**
   * Determined by the Hedging Party.
   */
  HEDGE_EXECUTION,

  /**
   * Issuer Payment Currency.
   */
  ISSUER_PAYMENT_CURRENCY,

  /**
   * Net Asset Value.
   */
  NAV,

  /**
   * OSP Price.
   */
  OSP_PRICE,

  /**
   * Opening Price of the Market.
   */
  OPEN_PRICE,

  /**
   * Settlement Currency.
   */
  SETTLEMENT_CURRENCY,

  /**
   * Date on which the strike is determined in respect of a forward starting swap.
   */
  STRIKE_DATE_DETERMINATION,

  /**
   * Official TWAP Price.
   */
  TWAP_PRICE,

  /**
   * Official VWAP Price.
   */
  VWAP_PRICE,

  /**
   * Price determined at valuation time.
   */
  VALUATION_TIME
}
/**
 * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
 */
export enum DiscountingTypeEnum {

  /**
   * As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
   */
  AFMA,

  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
   */
  FRA,

  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
   */
  FRA_YIELD,

  /**
   * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
   */
  STANDARD
}
/**
 * The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
 */
export enum DividendAmountTypeEnum {

  /**
   * The Amount is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,

  /**
   * The ex-date for a dividend occurs during a dividend period.
   */
  EX_AMOUNT,

  /**
   * The payment date for a dividend occurs during a dividend period.
   */
  PAID_AMOUNT,

  /**
   * The record date for a dividend occurs during a dividend period.
   */
  RECORD_AMOUNT
}
/**
 * The enumerated values to specify how the composition of Dividends is to be determined.
 */
export enum DividendCompositionEnum {

  /**
   * The Calculation Agent determines the composition of dividends (subject to conditions).
   */
  CALCULATION_AGENT_ELECTION,

  /**
   * The Equity Amount Receiver determines the composition of dividends (subject to conditions).
   */
  EQUITY_AMOUNT_RECEIVER_ELECTION
}
/**
 * The enumerated values to specify the date by reference to which the dividend will be paid.
 */
export enum DividendDateReferenceEnum {

  /**
   * The dividend date will be specified ad-hoc by the parties, typically on the dividend ex-date.
   */
  AD_HOC_DATE,

  /**
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Ex Dividend'', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange.
   */
  CASH_SETTLE_PAYMENT_DATE_EX_DIV,

  /**
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date – Issuer Payment', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the issuer pays the relevant dividend to a holder of record provided that in the case where the Equity Amount Payer is the party specified to be the sole Hedging Party and the Hedging Party has not received the Dividend Amount by such date, then the date falling a number of Currency Business Days as specified in the Cash Settlement Payment Date after actual receipt by the Hedging Party of the Received Ex Amount or Paid Ex Amount (as applicable).
   */
  CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT,

  /**
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Cash Settlement Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading 'ex' the relevant dividend on the Exchange.
   */
  CASH_SETTLEMENT_PAYMENT_DATE,

  /**
   * Total of dividends which go ex, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange.
   */
  CUMULATIVE_EQUITY_EX_DIV,

  /**
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Ex Date, unless the Dividend Ex Date is between the Equity Valuation and Payment Date in which case the dividend is deferred to the following Equity Payment Date
   */
  CUMULATIVE_EQUITY_EX_DIV_BEFORE_RESET,

  /**
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
   */
  CUMULATIVE_EQUITY_PAID,

  /**
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
   */
  CUMULATIVE_EQUITY_PAID_BEFORE_RESET,

  /**
   * Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
   */
  CUMULATIVE_EQUITY_PAID_INCL_RESET,

  /**
   * Total of dividends which go ex, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange, or where the date on which the Shares commence trading ex-dividend is a Payment Date, such Payment Date.
   */
  CUMULATIVE_INTEREST_EX_DIV,

  /**
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
   */
  CUMULATIVE_INTEREST_PAID,

  /**
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
   */
  CUMULATIVE_INTEREST_PAID_BEFORE_RESET,

  /**
   * Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
   */
  CUMULATIVE_INTEREST_PAID_INCL_RESET,

  /**
   * Date on which the dividend will be paid by the issuer.
   */
  DIVIDEND_PAYMENT_DATE,

  /**
   * In respect of each Dividend Period, the relevant Dividend Valuation Date.
   */
  DIVIDEND_VALUATION_DATE,

  /**
   * Equity payment date of the swap.
   */
  EQUITY_PAYMENT_DATE,

  /**
   * Date on which a holder of the security is entitled to the dividend.
   */
  EX_DATE,

  /**
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Floating Amount Payment Date', then the Dividend Payment Date in respect of a Dividend Amount shall be the first Payment Date falling at least one Settlement Cycle after the date that the Shares have commenced trading 'ex' the relevant dividend on the Exchange.
   */
  FLOATING_AMOUNT_PAYMENT_DATE,

  /**
   * The next payment date of the swap.
   */
  FOLLOWING_PAYMENT_DATE,

  /**
   * Date on which the dividend will be recorded in the books of the paying agent.
   */
  RECORD_DATE,

  /**
   * If 'Dividend Payment Date(s)' is specified in the Transaction Supplement as 'Share Payment', then the Dividend Payment Date in respect of a Dividend Amount shall fall on a date on or before the date that is two (or any other number that is specified in the Transaction Supplement) Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
   */
  SHARE_PAYMENT,

  /**
   * Termination date of the swap.
   */
  TERMINATION_DATE,

  /**
   * Trade date of the swap
   */
  TRADE_DATE,

  /**
   * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until trade is fully unwound.
   */
  UNWIND_EX_DIV,

  /**
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
   */
  UNWIND_OR_EQUITY_EX_DIV,

  /**
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
   */
  UNWIND_OR_EQUITY_PAID,

  /**
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Ex Date. This will be whichever date comes first or a combination of both.
   */
  UNWIND_OR_INTEREST_EX_DIV,

  /**
   * Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
   */
  UNWIND_OR_INTEREST_PAID,

  /**
   * Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until trade is fully unwound.
   */
  UNWIND_PAID
}
/**
 * The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend.
 */
export enum DividendEntitlementEnum {

  /**
   * Dividend entitlement is on the dividend ex-date.
   */
  EX_DATE,

  /**
   * Dividend entitlement is on the dividend record date.
   */
  RECORD_DATE
}
/**
 * 2002 ISDA Equity Derivatives Definitions: First Period, Second Period |
 */
export enum DividendPeriodEnum {

  /**
   * 2002 ISDA Equity Derivatives Definitions: First Period means each period from, and including, one Cash Settlement Payment Date or Settlement Date, as the case may be, to, but excluding, the next following Cash Settlement Payment Date or Settlement Date, as the case may be, except that (i) the initial Dividend Period will commence on, and include, the Clearance System Business Day that is one Settlement Cycle following the Trade Date and (ii) the final Dividend Period will end on, but exclude, the final Cash Settlement Payment Date or Settlement Date, as the case may be.
   */
  FIRST_PERIOD,

  /**
   * 2002 ISDA Equity Derivatives Definitions: Second Period means each period from, but excluding, one Valuation Date to, and including, the next Valuation Date, except that (i) the initial Dividend Period will commence on, but exclude, the Trade Date and (ii) the final Dividend Period will end on, and include, the final Valuation Date or, in respect of a Physically-settled Forward Transaction to which Variable Obligation is not applicable, the date that is one Settlement Cycle prior to the Settlement Date.
   */
  SECOND_PERIOD
}
/**
 * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
 */
export enum EU_EMIR_EligibleCollateralEnum {

  /**
   * Denotes Cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
   */
  EU_EMIR_TYPE_A,

  /**
   *  Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
   */
  EU_EMIR_TYPE_B,

  /**
   *  Denotes debt securities issued by Member States' central governments or central banks.
   */
  EU_EMIR_TYPE_C,

  /**
   *  Denotes debt securities issued by Member States' regional governments or local authorities whose exposures are treated as exposures to the central government of that Member State in accordance with Article 115(2) of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_D,

  /**
   *  Denotes debt securities issued by Member States' public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of that Member State in accordance with Article 116(4) of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_E,

  /**
   *  Denotes debt securities issued by Member States' regional governments or local authorities other than those referred to in (TypeD.)
   */
  EU_EMIR_TYPE_F,

  /**
   *  Denotes debt securities issued by Member States' public sector entities other than those referred to in (TypeE).
   */
  EU_EMIR_TYPE_G,

  /**
   *  Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_H,

  /**
   *  Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_I,

  /**
   *  Denotes debt securities issued by third countries' governments or central banks.
   */
  EU_EMIR_TYPE_J,

  /**
   *  Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
   */
  EU_EMIR_TYPE_K,

  /**
   *  Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
   */
  EU_EMIR_TYPE_L,

  /**
   *  Denotes debt securities issued by credit institutions or investment firms including bonds referred to in Article 52(4) of Directive 2009/65/EC of the European Parliament and of the Council.
   */
  EU_EMIR_TYPE_M,

  /**
   *  Denotes corporate bonds.
   */
  EU_EMIR_TYPE_N,

  /**
   *  Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
   */
  EU_EMIR_TYPE_O,

  /**
   *  Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_P,

  /**
   *  Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
   */
  EU_EMIR_TYPE_Q,

  /**
   *  Denotes shares or units in undertakings for collective investments in transferable securities (UCITS), provided that the conditions set out in Article 5 of EU Regulation 2016/2251 are met.
   */
  EU_EMIR_TYPE_R
}
/**
 * The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation.
 */
export enum EntityTypeEnum {

  /**
   * Entity Type of Asian.
   */
  ASIAN,

  /**
   * Entity Type of Australian and New Zealand.
   */
  AUSTRALIAN_AND_NEW_ZEALAND,

  /**
   * Entity Type of European Emerging Markets.
   */
  EUROPEAN_EMERGING_MARKETS,

  /**
   * Entity Type of Japanese.
   */
  JAPANESE,

  /**
   * Entity Type of North American High Yield.
   */
  NORTH_AMERICAN_HIGH_YIELD,

  /**
   * Entity Type of North American Insurance.
   */
  NORTH_AMERICAN_INSURANCE,

  /**
   * Entity Type of North American Investment Grade.
   */
  NORTH_AMERICAN_INVESTMENT_GRADE,

  /**
   * Entity Type of Singaporean.
   */
  SINGAPOREAN,

  /**
   * Entity Type of Western European.
   */
  WESTERN_EUROPEAN,

  /**
   * Entity Type of Western European Insurance.
   */
  WESTERN_EUROPEAN_INSURANCE
}
/**
 * Represents an enumeration list to identify the type of Equity.
 */
export enum EquityTypeEnum {

  /**
   * Identifies an Equity of Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation.
   */
  NON_CONVERTIBLE_PREFERENCE,

  /**
   * Identifies an Equity of Common stocks and shares.
   */
  ORDINARY
}
/**
 * The enumeration values to qualify the intent associated with a transaction event.
 */
export enum EventIntentEnum {

  /**
   * The intent is to allocate one or more trades as part of an allocated block trade.
   */
  ALLOCATION,

  /**
   * The intent is to designate a stand-alone cash transfer as a result of Trade contracual terms e.g. incurred by payout for instance a Performance Amount or a Floating Rate Amount. The particular CashFlow at stake shall be further specified in priceTransferEnum or transferTypeEnum. For clarity, such intentEnum value shall not be used whenever a cash transfer is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. Decrease with Fees, Cross-Currency Notional Reset, etc. or any other Event whenever including a cash transfer with other features. For clarity, a principal payment related to a Principal Exhange is excluded as well, because a dedicated intentEnum value exists for this event i.e. PrincipalExchange value.
   */
  CASH_FLOW,

  /**
   * The intent is to clear the contract.
   */
  CLEARING,

  /**
   * The intent is to compress multiple trades as part of a netting or compression event.
   */
  COMPRESSION,

  /**
   * The intent is to form a contract from an execution.
   */
  CONTRACT_FORMATION,

  /**
   * The intent is to amend the terms of the contract through renegotiation.
   */
  CONTRACT_TERMS_AMENDMENT,

  /**
   * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
   */
  CORPORATE_ACTION_ADJUSTMENT,

  /**
   * The intent is to take into effect the occurrence of a Credit Event.
   */
  CREDIT_EVENT,

  /**
   * The intent is to Decrease the quantity or notional of the contract.
   */
  DECREASE,

  /**
   * The intent is to fully unwind the Trade, as a result of the application of Trade contractual terms (e.g. an obligation to do so before Termination Date as part of any kind of Early Termination terms) as defined within the CDM EarlyTerminationProvision data type. Accordingly, increase and decrease of positions which result from negotiation by the parties shall not be designated by such intentEnum. For clarity, partial exercise of an option before its expiration date is excluded as well, though related to Trade contract terms, because a dedicated intentEnum value exists for this event i.e. OptionExercise value.
   */
  EARLY_TERMINATION_PROVISION,

  /**
   * The intent is to Increase the quantity or notional of the contract.
   */
  INCREASE,

  /**
   * The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any). 
   */
  INDEX_TRANSITION,

  /**
   * The intent is to increase or to decrease the notional of the Trade, in accordance with Notional Reset features e.g. could apply for Cross Currency Swaps, Equity Performance Swaps, etc.
   */
  NOTIONAL_RESET,

  /**
   * The intent is to increase or to decrease the notional of the Trade, in accordance with Step features attached to a Payout Quantity.
   */
  NOTIONAL_STEP,

  /**
   * The intent is to novate the contract.
   */
  NOVATION,

  /**
   * The intent is to record any kind of stand-alone obervervations e.g. internal data recording, usage of CDM for recording and/or exchanging data as part of pricing 'consensus' processing, etc. For clarity, such intentEnum value shall not be used whenever an observation is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. CashFlow to which an observation of prices is associated, etc.
   */
  OBSERVATION_RECORD,

  /**
   * The intent is to Exercise a contract that is made of one or several option payout legs. For clarity, such intentEnum value shall not be used whenever an optional right is exercised in relation with a Trade which composition includes other types of payout legs e.g. right to call or to cancel before Termination Date as part of any kind of Early Termination terms other than genuine bermuda or american style features described in option payout. 
   */
  OPTION_EXERCISE,

  /**
   * The intent is to cancel the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
   */
  OPTIONAL_CANCELLATION,

  /**
   * The intent is to extend the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
   */
  OPTIONAL_EXTENSION,

  /**
   * The intent is to rebalance a portfolio, by inserting new derivatives transactions into portfolios of participants to reduce risks linked to those trades. These are offsetting trades that rebalance relationships between different counterparties when it comes to exposure of portfolios to certain types of risk, such as interest rate risk.
   */
  PORTFOLIO_REBALANCING,

  /**
   * The intent is to pay or to receive a cash transfer, in accordance with Principal Exchange features.
   */
  PRINCIPAL_EXCHANGE,

  /**
   * The intent is to reallocate one or more trades as part of an allocated block trade.
   */
  REALLOCATION,

  /**
   * The intent is to close a repo transaction through repurchase.
   */
  REPURCHASE
}
/**
 * The enumeration values to qualify the timestamps that can be associated with a lifecycle event. The reason for such approach is that the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. Implementers are expected to evaluate the current enumeration values to determine whether those meet their requirements. If not, they are expected to engage with the CDM team to evaluate the addition of further value(s) to this enumeration, which will then participate to the development of a compendium for further evaluation at a later point in order to determine whether this modeling is appropriate.
 */
export enum EventTimestampQualificationEnum {

  /**
   * The date and time on which trade was confirmed as cleared.
   */
  CLEARING_CONFIRMATION_DATE_TIME,

  /**
   * The date and time on the trade was cleared.
   */
  CLEARING_DATE_TIME,

  /**
   * The date and time on which trade was received by Clearing Body.
   */
  CLEARING_RECEIPT_DATE_TIME,

  /**
   * The date and time on which the event was submitted for clearing.
   */
  CLEARING_SUBMISSION_DATE_TIME,

  /**
   * The date and time on which the event was confirmed.
   */
  CONFIRMATION_DATE_TIME,

  /**
   * The date and time on which the event was created.
   */
  EVENT_CREATION_DATE_TIME,

  /**
   * The date and time on which the event will be considered expired.
   */
  EVENT_EXPIRATION_DATE_TIME,

  /**
   * The date and time on which the event was processed.
   */
  EVENT_PROCESSING_DATE_TIME,

  /**
   * The date and time on which the event was sent.
   */
  EVENT_SENT_DATE_TIME,

  /**
   * The date and time on which the event was submitted.
   */
  EVENT_SUBMITTED_DATE_TIME,

  /**
   * The date and time on which the trade execution was performed.
   */
  EXECUTION_DATE_TIME,

  /**
   * The date and time on which the transaction has been created. This timestamp is specified as such by the CME ClearPort Matched IRS Trade submission API specification: 'The transaction date time of the trade. Represents the date & time on which the trade was initially generated either by CME Clearing or firm. The transaction date time may be assigned by CME Clearing at the point the trade is reported as cleared. Transaction date time can also be provided by an external submitter of the trade at the point the trade is submitted.'
   */
  TRANSACTION_CREATION_DATE_TIME
}
/**
 * The enumerated values to specify the Execution Location of a Security Agreement
 */
export enum ExecutionLocationEnum {

  /**
   * The Agreement was executed outside of Belgium
   */
  EXECUTED_IN_BELGIUM,

  /**
   * The Agreement was executed outside of Belgium
   */
  EXECUTED_OUTSIDE_BELGIUM,

  /**
   * An alternative approach is described in the document as follows.
   */
  OTHER_LOCATION
}
/**
 * The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ...
 */
export enum ExecutionTypeEnum {

  /**
   * Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message.
   */
  ELECTRONIC,

  /**
   * Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
   */
  OFF_FACILITY,

  /**
   * Execution via a platform that may or may not be covered by a regulatory defintion. OnVenue is intended to distinguish trades executed on a trading platform from those executed via phone, email or messaging apps. The role and details of the venue are included in the party attribute of the trade. The general rule is that if the parties utilitzed the services of the platform to execute the trade then it would be considered OnVenue.
   */
  ON_VENUE
}
/**
 * Defines the principal party to the trade that has the right to exercise.
 */
export enum ExerciseNoticeGiverEnum {

  /**
   * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
   */
  AS_SPECIFIED_IN_MASTER_AGREEMENT,

  /**
   * Specifies that both the option buyer and option seller has the right to exercise.
   */
  BOTH,

  /**
   * Specifies that only the option buyer has the right to exercise.
   */
  BUYER,

  /**
   * Specifies that only the option seller has the right to exercise.
   */
  SELLER
}
/**
 * The time of day at which the equity option expires, for example the official closing time of the exchange.
 */
export enum ExpirationTimeTypeEnum {

  /**
   * The time is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,

  /**
   * The official closing time of the exchange on the valuation date.
   */
  CLOSE,

  /**
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlyer.
   */
  DERIVATIVES_CLOSE,

  /**
   * The time at which the official settlement price is determined.
   */
  OSP,

  /**
   * The official opening time of the exchange on the valuation date.
   */
  OPEN,

  /**
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate)
   */
  SPECIFIC_TIME,

  /**
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
   */
  XETRA
}
/**
 * Specifies the fallback provisions in respect to the applicable Futures Price Valuation.
 */
export enum FPVFinalPriceElectionFallbackEnum {

  /**
   * In respect of the Early Final Valuation Date, the provisions for FPV Close shall apply.
   */
  FPV_CLOSE,

  /**
   * In respect of the Early Final Valuation Date, the provisions for FPV Hedge Execution shall apply.
   */
  FPV_HEDGE_EXECUTION
}
/**
 * The enumerated values to specify an event that has given rise to a fee.
 */
export enum FeeTypeEnum {

  /**
   * A cash flow resulting from the assignment of a contract to a new counterparty.
   */
  ASSIGNMENT,

  /**
   * The brokerage commission.
   */
  BROKERAGE_COMMISSION,

  /**
   * A cash flow associated with a corporate action
   */
  CORPORATE_ACTION,

  /**
   * A cash flow associated with a credit event.
   */
  CREDIT_EVENT,

  /**
   * A cash flow associated with an increase lifecycle event.
   */
  INCREASE,

  /**
   * The novation fee.
   */
  NOVATION,

  /**
   * A cash flow associated with a partial termination lifecycle event.
   */
  PARTIAL_TERMINATION,

  /**
   * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
   */
  PREMIUM,

  /**
   * A cash flow associated with a renegotiation lifecycle event.
   */
  RENEGOTIATION,

  /**
   * A cash flow associated with a termination lifecycle event.
   */
  TERMINATION,

  /**
   * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
   */
  UPFRONT
}
/**
 * To be specified only for products that embed a redemption payment.
 */
export enum FinalPrincipalExchangeCalculationEnum {

  /**
   * If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base).
   */
  FLOORED,

  /**
   * If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base.
   */
  NON_FLOORED
}
/**
 * Provides enumerated values for financial units, generally used in the context of defining quantities for securities.
 */
export enum FinancialUnitEnum {

  /**
   * Denotes financial contracts, such as listed futures and options.
   */
  CONTRACT,

  /**
   * Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount.
   */
  CONTRACTUAL_PRODUCT,

  /**
   * Denotes a price expressed in index points, e.g. for a stock index.
   */
  INDEX_UNIT,

  /**
   * Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month.
   */
  LOG_NORMAL_VOLATILITY,

  /**
   * Denotes the number of units of financial stock shares.
   */
  SHARE,

  /**
   * Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names.
   */
  VALUE_PER_DAY,

  /**
   * Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk.
   */
  VALUE_PER_PERCENT,

  /**
   * Denotes a quantity (expressed as a decimal value) represented the weight of a component in a basket.
   */
  WEIGHT
}
/**
 * 3rd level ISDA FRO category.
 */
export enum FloatingRateIndexCalculationMethodEnum {

  ALL_IN_COMPOUNDED,

  /**
   * A calculation methodology using the arithmetic mean.
   */
  AVERAGE,

  COMPOUNDED,

  /**
   * A calculation methodology using the ISDA-defined OIS compounding formula.
   */
  OIS_COMPOUND
}
/**
 * Top level ISDA FRO category.
 */
export enum FloatingRateIndexCategoryEnum {

  /**
   * The rate is calculated by the calculation agents from multiple observations.
   */
  CALCULATED,

  /**
   * The rate is obtained by polling several other banks.
   */
  REFERENCE_BANKS,

  /**
   * The rate is observed directly from a screen.
   */
  SCREEN_RATE
}
/**
 * The enumerated values to specify the list of floating rate index.
 */
export enum FloatingRateIndexEnum {

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AED_EBOR_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AED_EIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_AONIA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_AONIA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_AONIA_OIS_COMPOUND_SWAP_MARKER,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AUD_AONIA_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_BBR_AUBBSW,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_BBR_BBSW,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_BBR_BBSW_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_BBR_BBSY__BID_,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_BBR_ISDC,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AUD_BBSW,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AUD_BBSW_QUARTERLY_SWAP_RATE_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AUD_BBSW_SEMI_ANNUAL_SWAP_RATE_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  AUD_BBSY_BID,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_QUARTERLY_SWAP_RATE_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_QUARTERLY_SWAP_RATE_ICAP_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_SEMI_ANNUAL_SWAP_RATE_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  AUD_SWAP_RATE_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  BRL_CDI,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_CDOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_CDOR_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_ISDD,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_BA_TELERATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CAD_CDOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_CORRA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_CORRA_CAN_DEAL_TMX_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_CORRA_COMPOUNDED_INDEX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_CORRA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_CORRA_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_ISDA_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_LIBOR_BBA_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_REPO_CORRA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_TBILL_ISDD,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_TBILL_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_TBILL_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CAD_TBILL_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_6_M_LIBORSWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_ANNUAL_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_ANNUAL_SWAP_RATE_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_BASIS_SWAP_3_M_VS_6_M_LIBOR_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_ISDAFIX_SWAP_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_LIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_LIBOR_ISDA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_OIS_11_00_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_12_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_1_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_1_W,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_2_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_3_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_6_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_AVERAGE_9_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_COMPOUNDED_INDEX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CHF_SARON_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_TOIS_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CHF_USD_BASIS_SWAPS_11_00_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CLP_ICP,

  /**
   * Refers to the Indice Camara Promedio ('ICP') rate for Chilean Pesos which, for a Reset Date, is determined and published by the Asociacion de Bancos e Instituciones Financieras de Chile A.G. ('ABIF') in accordance with the 'Reglamento Indice de Camara Promedio' of the ABIF as published in the Diario Oficial de la Republica de Chile (the 'ICP Rules') and which is reported on the ABIF website by not later than 10:00 a.m., Santiago time, on that Reset Date.
   */
  CLP_TNA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CL_CLICP_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNH_HIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNH_HIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNH_HIBOR_TMA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_7_REPO_COMPOUNDING_DATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_CNREPOFIX_CFXS_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_DEPOSIT_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_FIXING_REPO_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_LPR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_PBOCB_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_QUARTERLY_7_D_REPO_NDS_RATE_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_SHIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CNY_SHIBOR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction..
   */
  CNY_SHIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CNY_SHIBOR_OIS_COMPOUNDING,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  COP_IBR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  COP_IBR_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CZK_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CZK_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CZK_CZEONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CZK_CZEONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  CZK_PRIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CZK_PRIBOR_PRBO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  CZK_PRIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR2,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR_2_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR2_DKNA13,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR_DKNA13,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR_DKNA_13_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_CITA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_CITA_DKNA14_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_DESTR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_DESTR_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_DESTR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  DKK_DKKOIS_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  DKK_TOM_NEXT_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_10_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_11_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_11_00_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_11_00_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_3_MONTH,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_3_MONTH_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_4_15_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_BASIS_SWAP_EONIA_VS_3_M_EUR_IBOR_SWAP_RATES_A_360_10_00_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_CNO_TEC10,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_AVERAGE_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_AVERAGE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_10_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_10_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_10_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_4_15_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_COMPOUND_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EONIA_SWAP_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_ACT_365,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_ACT_365_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_ANNUAL_BOND_SWAP_VS_1_M_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_BASIS_SWAP_1_M_VS_3_M_EURIBOR_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_BASIS_SWAP_3_M_VS_6_M_11_00_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_ICE_SWAP_RATE_11_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_ICE_SWAP_RATE_12_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURIBOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURONIA_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_AVERAGE_12_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_AVERAGE_1_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_AVERAGE_1_W,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_AVERAGE_3_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_AVERAGE_6_M,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_FTSE_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_COMPOUNDED_INDEX_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_ICE_SWAP_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_EURO_STR_TERM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ISDA_EURIBOR_SWAP_RATE_11_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ISDA_EURIBOR_SWAP_RATE_12_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ISDA_LIBOR_SWAP_RATE_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_ISDA_LIBOR_SWAP_RATE_11_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  EUR_LIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TAM_CDC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC10_CNO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC_10_CNO_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC_10_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC5_CNO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC_5_CNO_SWAP_MARKER,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TEC_5_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_TMM_CDC_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  EUR_USD_BASIS_SWAPS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_ISDA_SWAP_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR_ICE_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR_ISDA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_RONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_RONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_FTSE_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_COMPOUNDED_INDEX_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_SWAP_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_ICE_TERM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_OIS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_OIS_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_OIS_4_15_TRADITION,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SONIA_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE_4_15_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_SEMI_ANNUAL_SWAP_RATE_SWAP_MARKER_26,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  GBP_UK_BASE_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_USD_BASIS_SWAPS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_WMBA_RONIA_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GBP_WMBA_SONIA_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GRD_ATHIBOR_ATHIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GRD_ATHIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GRD_ATHIBOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GRD_ATHIMID_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  GRD_ATHIMID_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_HIBOR_,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_HIBOR_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_HKAB,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_HKAB_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_ISDC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  HKD_HONIA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_HONIX_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_ISDA_SWAP_RATE_11_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_ISDA_SWAP_RATE_4_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_4_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_4_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HKD_QUARTERLY_QUARTERLY_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  HUF_BUBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HUF_BUBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  HUF_BUBOR_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  HUF_HUFONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  HUF_HUFONIA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_IDMA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_IDRFIX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  IDR_INDONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  IDR_INDONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  IDR_JIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_JIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SBI_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  IDR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ILS_SHIR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ILS_SHIR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ILS_TELBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ILS_TELBOR_01_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ILS_TELBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_BMK,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_CMT,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_FBIL_MIBOR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_INBMK_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  INR_MIBOR_OIS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_MIBOR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  INR_MIBOR_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_MIFOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_MIOIS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_MITOR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_MODIFIED_MIFOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_SEMI_ANNUAL_SWAP_RATE_11_30_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  INR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ISK_REIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ISK_REIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ISK_REIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_ANNUAL_SWAP_RATE_3_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_BBSF_BLOOMBERG_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_BBSF_BLOOMBERG_15_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_EUROYEN_TIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_ISDA_SWAP_RATE_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_ISDA_SWAP_RATE_15_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_FRASETT,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_ISDA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_TSR_10_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_LIBOR_TSR_15_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_LTPR_MHBK,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LTPR_MHCB,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_LTPR_TBC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_MUTANCALL_TONAR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_OIS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_OIS_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_OIS_3_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_QUOTING_BANKS_LIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_STPR_QUOTING_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_17096,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_17097,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_DTIBOR01,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM_10_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM_5_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM_ALL_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_TIBM_ALL_BANKS_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TIBOR_ZTIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_AVERAGE_180_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_AVERAGE_30_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_AVERAGE_90_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_ICE_COMPOUNDED_INDEX_5_D_LAG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_TSR_10_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TONA_TSR_15_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TORF_QUICK,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TSR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TSR_REUTERS_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TSR_REUTERS_15_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TSR_TELERATE_10_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_TSR_TELERATE_15_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  JPY_USD_BASIS_SWAPS_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  KRW_BOND_3222,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  KRW_CD_3220,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  KRW_CD_91D,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  KRW_CD_KSDA_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  KRW_KOFR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  KRW_KOFR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  KRW_QUARTERLY_ANNUAL_SWAP_RATE_3_30_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_BANXICO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_BANXICO_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_BANXICO_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_ON,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_ON_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MXN_TIIE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MYR_KLIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MYR_KLIBOR_BNM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MYR_KLIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MYR_MYOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  MYR_MYOR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MYR_QUARTERLY_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  MYR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR_NIBR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR_NIBR_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR_NIBR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR_OIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NOK_NOWA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NOK_NOWA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_BBR_BID,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_BBR_FRA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_BBR_ISDC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_BBR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_BBR_TELERATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NZD_BKBM_BID,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NZD_BKBM_FRA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NZD_BKBM_FRA_SWAP_RATE_ICAP,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_NZIONA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_NZIONA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  NZD_NZIONA_OIS_COMPOUND_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_SWAP_RATE_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  NZD_SWAP_RATE_ICAP_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PHP_ORR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PHP_PHIREF,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PHP_PHIREF_BAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PHP_PHIREF_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PHP_PHIREF_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PHP_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PHP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_POLONIA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PLN_POLONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_POLONIA_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_WIBID,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_WIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PLN_WIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PLN_WIBOR_WIBO,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_WIRON,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  PLN_WIRON_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PLZ_WIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  PLZ_WIBOR_WIBO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  REPOFUNDS_RATE_FRANCE_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  REPOFUNDS_RATE_GERMANY_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  REPOFUNDS_RATE_ITALY_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RON_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RON_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RON_RBOR_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RON_ROBID,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RON_ROBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_ANNUAL_SWAP_RATE_12_45_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_ANNUAL_SWAP_RATE_4_15_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RUB_KEY_RATE_CBRF,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_MOSPRIME_NFEA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_MOSPRIME_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RUB_MOS_PRIME,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RUB_RUONIA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  RUB_RUONIA_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  RUB_RUONIA_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SAR_SAIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SAR_SRIOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SAR_SRIOR_SUAA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_ANNUAL_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_ANNUAL_SWAP_RATE_SESWFI,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SIOR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SEK_STIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_STIBOR_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SEK_STIBOR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_STIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_STIBOR_SIDE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_AVERAGE_1_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_AVERAGE_1_W,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_AVERAGE_2_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_AVERAGE_3_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_AVERAGE_6_M,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SEK_SWESTR_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SGD_SIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SIBOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SONAR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SONAR_OIS_VWAP_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SORA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SORA_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  SGD_SORA_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR_VWAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SOR_VWAP_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_11_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_16_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_16_00_TULLETT_PREBON,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SGD_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SKK_BRIBOR_BRBO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SKK_BRIBOR_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SKK_BRIBOR_NBSK07,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  SKK_BRIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_SOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_SOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_SOR_TELERATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  THB_THBFIX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_THBFIX_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_THBFIX_REUTERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_THOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  THB_THOR_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  THB_THOR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_ANNUAL_SWAP_RATE_11_15_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  TRY_TLREF,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_TLREF_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  TRY_TLREF_OIS_COMPOUND_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  TRY_TRLIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_TRYIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TRY_TRYIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_REFERENCE_DEALERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_REUTERS_6165,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TAIBIR01,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TAIBIR02,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  TWD_TAIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TAIBOR_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TAIBOR_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TWCPBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  TWD_TELERATE_6165,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  UK_BASE_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_AMERIBOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_AMERIBOR_AVERAGE_30_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_AMERIBOR_AVERAGE_90_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_AMERIBOR_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_AMERIBOR_TERM_STRUCTURE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_AXI_TERM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ANNUAL_SWAP_RATE_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ANNUAL_SWAP_RATE_4_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_BA_H_15,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_BA_REFERENCE_DEALERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_BMA_MUNICIPAL_SWAP_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_BSBY,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CD_H_15,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CD_REFERENCE_DEALERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMS_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMS_REFERENCE_BANKS_ICAP_SWAP_PX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMS_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMS_TELERATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_CMT,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_CMT_AVERAGE_1_W,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMT_T7051,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CMT_T7052,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_COF11_FHLBSF,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_COF_11_REUTERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_COF_11_TELERATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_COFI,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CP_H_15,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_CP_MONEY_MARKET_YIELD,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CP_REFERENCE_DEALERS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_CRITR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_FFCB_DISCO,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_FXI_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS_H_15,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS_H_15_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS_H_15_OIS_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_FEDERAL_FUNDS_REFERENCE_DEALERS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ISDAFIX_3_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ISDAFIX_3_SWAP_RATE_3_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ISDA_SWAP_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_ISDA_SWAP_RATE_3_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_BBA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_BBA_BLOOMBERG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_ICE_SWAP_RATE_11_00,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_ICE_SWAP_RATE_15_00,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_ISDA,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_LIBO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_LIBOR_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_MUNICIPAL_SWAP_INDEX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_MUNICIPAL_SWAP_LIBOR_RATIO_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_MUNICIPAL_SWAP_RATE_11_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_11_00_LON_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_11_00_NY_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_11_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_3_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_3_00_NY_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OIS_4_00_TRADITION,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_OVERNIGHT_BANK_FUNDING_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_PRIME,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_PRIME_H_15,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_PRIME_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SIBOR_SIBO,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SIFMA_MUNICIPAL_SWAP_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_AVERAGE_180_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_AVERAGE_30_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_AVERAGE_90_D,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_CME_TERM,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_COMPOUND,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX_2_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_COMPOUNDED_INDEX_5_D_LAG,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_SWAP_RATE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_SWAP_RATE_SPREADS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_ICE_TERM,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_SOFR_OIS_COMPOUND,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_S_P_INDEX_HIGH_GRADE,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_SAND_P_INDEX_HIGH_GRADE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_SWAP_RATE_BCMP_1,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_TBILL_AUCTION_HIGH_RATE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TBILL_H_15,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TBILL_H_15_BLOOMBERG,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TBILL_SECONDARY_MARKET,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  USD_TBILL_SECONDARY_MARKET_BOND_EQUIVALENT_YIELD,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TIBOR_ISDC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TIBOR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_19901_3_00_ICAP,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_BCMP_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_ICAP_BROKER_TEC,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_SWAP_MARKER_100,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_SWAP_MARKER_99,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_T_19901,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  USD_TREASURY_RATE_T_500,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  VND_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  VND_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_DEPOSIT_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_DEPOSIT_SAFEX,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ZAR_JIBAR,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_JIBAR_REFERENCE_BANKS,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_JIBAR_SAFEX,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_PRIME_AVERAGE,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_PRIME_AVERAGE_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ZAR_PRIME_AVERAGE_1,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_QUARTERLY_SWAP_RATE_1_00_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_QUARTERLY_SWAP_RATE_5_30_TRADITION,

  /**
   * Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
   */
  ZAR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ZAR_ZARONIA,

  /**
   * Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
   */
  ZAR_ZARONIA_OIS_COMPOUND
}
/**
 * This enumeration provides guidance on how to process a given floating rate index.  It's based on the ISDA Floating Rate Index information, but transforms it into the specific categories needed for calculation 
 */
export enum FloatingRateIndexProcessingTypeEnum {

  /**
   * A published index calculated using compounding; the implied rate must be backed out.
   */
  COMPOUND_INDEX,

  /**
   * These are calculated by the calculation agent based on deal-specific parameters (e.g. lookback compound based on an RFR).
   */
  MODULAR,

  /**
   * These are calculated by the calculation agent based on a standard OIS FRO definition.
   */
  OIS,

  /**
   * These are calculated by the calculation agent based on a standard overnight averaging FRO definition.
   */
  OVERNIGHT_AVG,

  /**
   * These must be looked up using a manual process
   */
  REF_BANKS,

  /**
   * These values are just looked up from the screen and applied.
   */
  SCREEN
}
/**
 * Second level ISDA FRO category.
 */
export enum FloatingRateIndexStyleEnum {

  /**
   * An ISDA-defined calculated rate done using arithmetic averaging.
   */
  AVERAGE_FRO,

  /**
   * An ISDA-defined calculated rate done using arithmetic averaging.
   */
  COMPOUNDED_FRO,

  /**
   * A published index calculated using compounding.
   */
  COMPOUNDED_INDEX,

  /**
   * A published index using a methodology defined by the publisher, e.g. S&P 500.
   */
  INDEX,

  OTHER,

  OVERNIGHT,

  /**
   *  A published rate computed using an averaging methodology.
   */
  PUBLISHED_AVERAGE,

  SPECIFIED_FORMULA,

  /**
   * A rate representing the market rate for swaps of a given maturity.
   */
  SWAP_RATE,

  /**
   * A rate specified over a given term, such as a libor-type rate.
   */
  TERM_RATE
}
/**
 * Represents an enumeration list to identify the fund product type.
 */
export enum FundProductTypeEnum {

  /**
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange.
   */
  EXCHANGE_TRADED_FUND,

  /**
   * Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity.
   */
  MONEY_MARKET_FUND,

  /**
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager.
   */
  MUTUAL_FUND,

  /**
   * Denotes a fund that is not an Exchange Traded Fund, Money Market Fund or Mutual Fund.
   */
  OTHER_FUND
}
/**
 * The enumerated values to specify the law governing the contract or legal document.
 */
export enum GoverningLawEnum {

  /**
   * The Governing Law is determined by reference to the relevant master agreement.
   */
  AS_SPECIFIED_IN_MASTER_AGREEMENT,

  /**
   * Belgian law
   */
  BE,

  /**
   * Alberta law
   */
  CAAB,

  /**
   * British Columbia Law
   */
  CABC,

  /**
   * Manitoba law
   */
  CAMN,

  /**
   * Ontario law
   */
  CAON,

  /**
   * Quebec law
   */
  CAQC,

  /**
   * German law
   */
  DE,

  /**
   * French law
   */
  FR,

  /**
   * English law
   */
  GBEN,

  /**
   * The law of the island of Guernsey
   */
  GBGY,

  /**
   * The law of the Isle of Man
   */
  GBIM,

  /**
   * The law of the island of Jersey
   */
  GBJY,

  /**
   * Scottish law
   */
  GBSC,

  /**
   * Irish law
   */
  IE,

  /**
   * Japanese law
   */
  JP,

  /**
   * Luxembourg law
   */
  LU,

  /**
   * As agreed in the ISDA Master Agreement
   */
  RELATED_MASTER_AGREEMENT,

  /**
   * Californian law
   */
  USCA,

  /**
   * Delaware law
   */
  USDE,

  /**
   * Illinois law
   */
  USIL,

  /**
   * New York law
   */
  USNY
}
/**
 * Represents the enumeration indicators to specify if an asset or group of assets valuation is based on any valuation treatment haircut.
 */
export enum HaircutIndicatorEnum {

  /**
   * Indicates Post haircut value
   */
  POST_HAIRCUT,

  /**
   * Indicates Pre haircut value
   */
  PRE_HAIRCUT
}
/**
 * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO). The set of codes in this enumerated list is sourced from ISO Standard 3166 (ISO-3166-1alpha-2)(https://www.iso.org/iso-3166-country-codes.html) as at 14-Aug-23.
 */
export enum ISOCountryCodeEnum {

  /**
   * Andorra
   */
  AD,

  /**
   * United Arab Emirates (the)
   */
  AE,

  /**
   * Afghanistan
   */
  AF,

  /**
   * Antigua and Barbuda
   */
  AG,

  /**
   * Anguilla
   */
  AI,

  /**
   * Albania
   */
  AL,

  /**
   * Armenia
   */
  AM,

  /**
   * Angola
   */
  AO,

  /**
   * Antarctica
   */
  AQ,

  /**
   * Argentina
   */
  AR,

  /**
   * American Samoa
   */
  AS,

  /**
   * Austria
   */
  AT,

  /**
   * Australia
   */
  AU,

  /**
   * Aruba
   */
  AW,

  /**
   * Aland Islands
   */
  AX,

  /**
   * Azerbaijan
   */
  AZ,

  /**
   * Bosnia and Herzegovina
   */
  BA,

  /**
   * Barbados
   */
  BB,

  /**
   * Bangladesh
   */
  BD,

  /**
   * Belgium
   */
  BE,

  /**
   * Burkina Faso
   */
  BF,

  /**
   * Bulgaria
   */
  BG,

  /**
   * Bahrain
   */
  BH,

  /**
   * Burundi
   */
  BI,

  /**
   * Benin
   */
  BJ,

  /**
   * Saint Barthlemy
   */
  BL,

  /**
   * Bermuda
   */
  BM,

  /**
   * Brunei Darussalam
   */
  BN,

  /**
   * Bolivia (Plurinational State of)
   */
  BO,

  /**
   * Bonaire, Sint Eustatius and Saba
   */
  BQ,

  /**
   * Brazil
   */
  BR,

  /**
   * Bahamas (the)
   */
  BS,

  /**
   * Bhutan
   */
  BT,

  /**
   * Bouvet Island
   */
  BV,

  /**
   * Botswana
   */
  BW,

  /**
   * Belarus
   */
  BY,

  /**
   * Belize
   */
  BZ,

  /**
   * Canada
   */
  CA,

  /**
   * Cocos (Keeling) Islands (the)
   */
  CC,

  /**
   * Congo (the Democratic Republic of the)
   */
  CD,

  /**
   * Central African Republic (the)
   */
  CF,

  /**
   * Congo (the)
   */
  CG,

  /**
   * Switzerland
   */
  CH,

  /**
   * Cte d'Ivoire
   */
  CI,

  /**
   * Cook Islands (the)
   */
  CK,

  /**
   * Chile
   */
  CL,

  /**
   * Cameroon
   */
  CM,

  /**
   * China
   */
  CN,

  /**
   * Colombia
   */
  CO,

  /**
   * Costa Rica
   */
  CR,

  /**
   * Cuba
   */
  CU,

  /**
   * Cabo Verde
   */
  CV,

  /**
   * Curaao
   */
  CW,

  /**
   * Christmas Island
   */
  CX,

  /**
   * Cyprus
   */
  CY,

  /**
   * Czechia
   */
  CZ,

  /**
   * Germany
   */
  DE,

  /**
   * Djibouti
   */
  DJ,

  /**
   * Denmark
   */
  DK,

  /**
   * Dominica
   */
  DM,

  /**
   * Dominican Republic (the)
   */
  DO,

  /**
   * Algeria
   */
  DZ,

  /**
   * Ecuador
   */
  EC,

  /**
   * Estonia
   */
  EE,

  /**
   * Egypt
   */
  EG,

  /**
   * Western Sahara*
   */
  EH,

  /**
   * Eritrea
   */
  ER,

  /**
   * Spain
   */
  ES,

  /**
   * Ethiopia
   */
  ET,

  /**
   * Finland
   */
  FI,

  /**
   * Fiji
   */
  FJ,

  /**
   * Falkland Islands (the) [Malvinas]
   */
  FK,

  /**
   * Micronesia (Federated States of)
   */
  FM,

  /**
   * Faroe Islands (the)
   */
  FO,

  /**
   * France
   */
  FR,

  /**
   * Gabon
   */
  GA,

  /**
   * United Kingdom of Great Britain and Northern Ireland (the)
   */
  GB,

  /**
   * Grenada
   */
  GD,

  /**
   * Georgia
   */
  GE,

  /**
   * French Guiana
   */
  GF,

  /**
   * Guernsey
   */
  GG,

  /**
   * Ghana
   */
  GH,

  /**
   * Gibraltar
   */
  GI,

  /**
   * Greenland
   */
  GL,

  /**
   * Gambia (the)
   */
  GM,

  /**
   * Guinea
   */
  GN,

  /**
   * Guadeloupe
   */
  GP,

  /**
   * Equatorial Guinea
   */
  GQ,

  /**
   * Greece
   */
  GR,

  /**
   * South Georgia and the South Sandwich Islands
   */
  GS,

  /**
   * Guatemala
   */
  GT,

  /**
   * Guam
   */
  GU,

  /**
   * Guinea-Bissau
   */
  GW,

  /**
   * Guyana
   */
  GY,

  /**
   * Hong Kong
   */
  HK,

  /**
   * Heard Island and McDonald Islands
   */
  HM,

  /**
   * Honduras
   */
  HN,

  /**
   * Croatia
   */
  HR,

  /**
   * Haiti
   */
  HT,

  /**
   * Hungary
   */
  HU,

  /**
   * Indonesia
   */
  ID,

  /**
   * Ireland
   */
  IE,

  /**
   * Israel
   */
  IL,

  /**
   * Isle of Man
   */
  IM,

  /**
   * India
   */
  IN,

  /**
   * British Indian Ocean Territory (the)
   */
  IO,

  /**
   * Iraq
   */
  IQ,

  /**
   * Iran (Islamic Republic of)
   */
  IR,

  /**
   * Iceland
   */
  IS,

  /**
   * Italy
   */
  IT,

  /**
   * Jersey
   */
  JE,

  /**
   * Jamaica
   */
  JM,

  /**
   * Jordan
   */
  JO,

  /**
   * Japan
   */
  JP,

  /**
   * Kenya
   */
  KE,

  /**
   * Kyrgyzstan
   */
  KG,

  /**
   * Cambodia
   */
  KH,

  /**
   * Kiribati
   */
  KI,

  /**
   * Comoros (the)
   */
  KM,

  /**
   * Saint Kitts and Nevis
   */
  KN,

  /**
   * Korea (the Democratic People's Republic of)
   */
  KP,

  /**
   * Korea (the Republic of)
   */
  KR,

  /**
   * Kuwait
   */
  KW,

  /**
   * Cayman Islands (the)
   */
  KY,

  /**
   * Kazakhstan
   */
  KZ,

  /**
   * Lao People's Democratic Republic (the)
   */
  LA,

  /**
   * Lebanon
   */
  LB,

  /**
   * Saint Lucia
   */
  LC,

  /**
   * Liechtenstein
   */
  LI,

  /**
   * Sri Lanka
   */
  LK,

  /**
   * Liberia
   */
  LR,

  /**
   * Lesotho
   */
  LS,

  /**
   * Lithuania
   */
  LT,

  /**
   * Luxembourg
   */
  LU,

  /**
   * Latvia
   */
  LV,

  /**
   * Libya
   */
  LY,

  /**
   * Morocco
   */
  MA,

  /**
   * Monaco
   */
  MC,

  /**
   * Moldova (the Republic of)
   */
  MD,

  /**
   * Montenegro
   */
  ME,

  /**
   * Saint Martin (French part)
   */
  MF,

  /**
   * Madagascar
   */
  MG,

  /**
   * Marshall Islands (the)
   */
  MH,

  /**
   * North Macedonia
   */
  MK,

  /**
   * Mali
   */
  ML,

  /**
   * Myanmar
   */
  MM,

  /**
   * Mongolia
   */
  MN,

  /**
   * Macao
   */
  MO,

  /**
   * Northern Mariana Islands (the)
   */
  MP,

  /**
   * Martinique
   */
  MQ,

  /**
   * Mauritania
   */
  MR,

  /**
   * Montserrat
   */
  MS,

  /**
   * Malta
   */
  MT,

  /**
   * Mauritius
   */
  MU,

  /**
   * Maldives
   */
  MV,

  /**
   * Malawi
   */
  MW,

  /**
   * Mexico
   */
  MX,

  /**
   * Malaysia
   */
  MY,

  /**
   * Mozambique
   */
  MZ,

  /**
   * Namibia
   */
  NA,

  /**
   * New Caledonia
   */
  NC,

  /**
   * Niger (the)
   */
  NE,

  /**
   * Norfolk Island
   */
  NF,

  /**
   * Nigeria
   */
  NG,

  /**
   * Nicaragua
   */
  NI,

  /**
   * Netherlands (Kingdom of the)
   */
  NL,

  /**
   * Norway
   */
  NO,

  /**
   * Nepal
   */
  NP,

  /**
   * Nauru
   */
  NR,

  /**
   * Niue
   */
  NU,

  /**
   * New Zealand
   */
  NZ,

  /**
   * Oman
   */
  OM,

  /**
   * Panama
   */
  PA,

  /**
   * Peru
   */
  PE,

  /**
   * French Polynesia
   */
  PF,

  /**
   * Papua New Guinea
   */
  PG,

  /**
   * Philippines (the)
   */
  PH,

  /**
   * Pakistan
   */
  PK,

  /**
   * Poland
   */
  PL,

  /**
   * Saint Pierre and Miquelon
   */
  PM,

  /**
   * Pitcairn
   */
  PN,

  /**
   * Puerto Rico
   */
  PR,

  /**
   * Palestine, State of
   */
  PS,

  /**
   * Portugal
   */
  PT,

  /**
   * Palau
   */
  PW,

  /**
   * Paraguay
   */
  PY,

  /**
   * Qatar
   */
  QA,

  /**
   * Runion
   */
  RE,

  /**
   * Romania
   */
  RO,

  /**
   * Serbia
   */
  RS,

  /**
   * Russian Federation (the)
   */
  RU,

  /**
   * Rwanda
   */
  RW,

  /**
   * Saudi Arabia
   */
  SA,

  /**
   * Solomon Islands
   */
  SB,

  /**
   * Seychelles
   */
  SC,

  /**
   * Sudan (the)
   */
  SD,

  /**
   * Sweden
   */
  SE,

  /**
   * Singapore
   */
  SG,

  /**
   * Saint Helena, Ascension and Tristan da Cunha
   */
  SH,

  /**
   * Slovenia
   */
  SI,

  /**
   * Svalbard and Jan Mayen
   */
  SJ,

  /**
   * Slovakia
   */
  SK,

  /**
   * Sierra Leone
   */
  SL,

  /**
   * San Marino
   */
  SM,

  /**
   * Senegal
   */
  SN,

  /**
   * Somalia
   */
  SO,

  /**
   * Suriname
   */
  SR,

  /**
   * South Sudan
   */
  SS,

  /**
   * Sao Tome and Principe
   */
  ST,

  /**
   * El Salvador
   */
  SV,

  /**
   * Sint Maarten (Dutch part)
   */
  SX,

  /**
   * Syrian Arab Republic (the)
   */
  SY,

  /**
   * Eswatini
   */
  SZ,

  /**
   * Turks and Caicos Islands (the)
   */
  TC,

  /**
   * Chad
   */
  TD,

  /**
   * French Southern Territories (the)
   */
  TF,

  /**
   * Togo
   */
  TG,

  /**
   * Thailand
   */
  TH,

  /**
   * Tajikistan
   */
  TJ,

  /**
   * Tokelau
   */
  TK,

  /**
   * Timor-Leste
   */
  TL,

  /**
   * Turkmenistan
   */
  TM,

  /**
   * Tunisia
   */
  TN,

  /**
   * Tonga
   */
  TO,

  /**
   * Trkiye
   */
  TR,

  /**
   * Trinidad and Tobago
   */
  TT,

  /**
   * Tuvalu
   */
  TV,

  /**
   * Taiwan (Province of China)
   */
  TW,

  /**
   * Tanzania, the United Republic of
   */
  TZ,

  /**
   * Ukraine
   */
  UA,

  /**
   * Uganda
   */
  UG,

  /**
   * United States Minor Outlying Islands (the)
   */
  UM,

  /**
   * United States of America (the)
   */
  US,

  /**
   * Uruguay
   */
  UY,

  /**
   * Uzbekistan
   */
  UZ,

  /**
   * Holy See (the)
   */
  VA,

  /**
   * Saint Vincent and the Grenadines
   */
  VC,

  /**
   * Venezuela (Bolivarian Republic of)
   */
  VE,

  /**
   * Virgin Islands (British)
   */
  VG,

  /**
   * Virgin Islands (U.S.)
   */
  VI,

  /**
   * Viet Nam
   */
  VN,

  /**
   * Vanuatu
   */
  VU,

  /**
   * Wallis and Futuna
   */
  WF,

  /**
   * Samoa
   */
  WS,

  /**
   * Yemen
   */
  YE,

  /**
   * Mayotte
   */
  YT,

  /**
   * South Africa
   */
  ZA,

  /**
   * Zambia
   */
  ZM,

  /**
   * Zimbabwe
   */
  ZW
}
/**
 * The enumerated values to specify standard currency codes according to the International Standards Organization (ISO).  The set of codes in this enumerated list is sourced from ISO Standard 4217 (https://www.currency-iso.org/en/home/tables/table-a1.html), as of 29-Aug-18.
 */
export enum ISOCurrencyCodeEnum {

  /**
   * UAE Dirham
   */
  AED,

  /**
   * Afghani
   */
  AFN,

  /**
   * Lek
   */
  ALL,

  /**
   * Armenian Dram
   */
  AMD,

  /**
   * Netherlands Antillean Guilder
   */
  ANG,

  /**
   * Kwanza
   */
  AOA,

  /**
   * Argentine Peso
   */
  ARS,

  /**
   * Australian Dollar
   */
  AUD,

  /**
   * Aruban Florin
   */
  AWG,

  /**
   * Azerbaijan Manat
   */
  AZN,

  /**
   * Convertible Mark
   */
  BAM,

  /**
   * Barbados Dollar
   */
  BBD,

  /**
   * Taka
   */
  BDT,

  /**
   * Bulgarian Lev
   */
  BGN,

  /**
   * Bahraini Dinar
   */
  BHD,

  /**
   * Burundi Franc
   */
  BIF,

  /**
   * Bermudian Dollar
   */
  BMD,

  /**
   * Brunei Dollar
   */
  BND,

  /**
   * Boliviano
   */
  BOB,

  /**
   * Mvdol
   */
  BOV,

  /**
   * Brazilian Real
   */
  BRL,

  /**
   * Bahamian Dollar
   */
  BSD,

  /**
   * Ngultrum
   */
  BTN,

  /**
   * Pula
   */
  BWP,

  /**
   * Belarusian Ruble
   */
  BYN,

  /**
   * Belize Dollar
   */
  BZD,

  /**
   * Canadian Dollar
   */
  CAD,

  /**
   * Congolese Franc
   */
  CDF,

  /**
   * WIR Euro
   */
  CHE,

  /**
   * Swiss Franc
   */
  CHF,

  /**
   * WIR Franc
   */
  CHW,

  /**
   * Unidad de Fomento
   */
  CLF,

  /**
   * Chilean Peso
   */
  CLP,

  /**
   * Yuan Renminbi
   */
  CNY,

  /**
   * Colombian Peso
   */
  COP,

  /**
   * Unidad de Valor Real
   */
  COU,

  /**
   * Costa Rican Colon
   */
  CRC,

  /**
   * Peso Convertible
   */
  CUC,

  /**
   * Cuban Peso
   */
  CUP,

  /**
   * Cabo Verde Escudo
   */
  CVE,

  /**
   * Czech Koruna
   */
  CZK,

  /**
   * Djibouti Franc
   */
  DJF,

  /**
   * Danish Krone
   */
  DKK,

  /**
   * Dominican Peso
   */
  DOP,

  /**
   * Algerian Dinar
   */
  DZD,

  /**
   * Egyptian Pound
   */
  EGP,

  /**
   * Nakfa
   */
  ERN,

  /**
   * Ethiopian Birr
   */
  ETB,

  /**
   * Euro
   */
  EUR,

  /**
   * Fiji Dollar
   */
  FJD,

  /**
   * Falkland Islands Pound
   */
  FKP,

  /**
   * Pound Sterling
   */
  GBP,

  /**
   * Lari
   */
  GEL,

  /**
   * Ghana Cedi
   */
  GHS,

  /**
   * Gibraltar Pound
   */
  GIP,

  /**
   * Dalasi
   */
  GMD,

  /**
   * Guinean Franc
   */
  GNF,

  /**
   * Quetzal
   */
  GTQ,

  /**
   * Guyana Dollar
   */
  GYD,

  /**
   * Hong Kong Dollar
   */
  HKD,

  /**
   * Lempira
   */
  HNL,

  /**
   * Gourde
   */
  HTG,

  /**
   * Forint
   */
  HUF,

  /**
   * Rupiah
   */
  IDR,

  /**
   * New Israeli Sheqel
   */
  ILS,

  /**
   * Indian Rupee
   */
  INR,

  /**
   * Iraqi Dinar
   */
  IQD,

  /**
   * Iranian Rial
   */
  IRR,

  /**
   * Iceland Krona
   */
  ISK,

  /**
   * Jamaican Dollar
   */
  JMD,

  /**
   * Jordanian Dinar
   */
  JOD,

  /**
   * Yen
   */
  JPY,

  /**
   * Kenyan Shilling
   */
  KES,

  /**
   * Som
   */
  KGS,

  /**
   * Riel
   */
  KHR,

  /**
   * Comorian Franc 
   */
  KMF,

  /**
   * North Korean Won
   */
  KPW,

  /**
   * Won
   */
  KRW,

  /**
   * Kuwaiti Dinar
   */
  KWD,

  /**
   * Cayman Islands Dollar
   */
  KYD,

  /**
   * Tenge
   */
  KZT,

  /**
   * Lao Kip
   */
  LAK,

  /**
   * Lebanese Pound
   */
  LBP,

  /**
   * Sri Lanka Rupee
   */
  LKR,

  /**
   * Liberian Dollar
   */
  LRD,

  /**
   * Loti
   */
  LSL,

  /**
   * Libyan Dinar
   */
  LYD,

  /**
   * Moroccan Dirham
   */
  MAD,

  /**
   * Moldovan Leu
   */
  MDL,

  /**
   * Malagasy Ariary
   */
  MGA,

  /**
   * Denar
   */
  MKD,

  /**
   * Kyat
   */
  MMK,

  /**
   * Tugrik
   */
  MNT,

  /**
   * Pataca
   */
  MOP,

  /**
   * Ouguiya
   */
  MRU,

  /**
   * Mauritius Rupee
   */
  MUR,

  /**
   * Rufiyaa
   */
  MVR,

  /**
   * Malawi Kwacha
   */
  MWK,

  /**
   * Mexican Peso
   */
  MXN,

  /**
   * Mexican Unidad de Inversion (UDI)
   */
  MXV,

  /**
   * Malaysian Ringgit
   */
  MYR,

  /**
   * Mozambique Metical
   */
  MZN,

  /**
   * Namibia Dollar
   */
  NAD,

  /**
   * Naira
   */
  NGN,

  /**
   * Cordoba Oro
   */
  NIO,

  /**
   * Norwegian Krone
   */
  NOK,

  /**
   * Nepalese Rupee
   */
  NPR,

  /**
   * New Zealand Dollar
   */
  NZD,

  /**
   * Rial Omani
   */
  OMR,

  /**
   * Balboa
   */
  PAB,

  /**
   * Sol
   */
  PEN,

  /**
   * Kina
   */
  PGK,

  /**
   * Philippine Peso
   */
  PHP,

  /**
   * Pakistan Rupee
   */
  PKR,

  /**
   * Zloty
   */
  PLN,

  /**
   * Guarani
   */
  PYG,

  /**
   * Qatari Rial
   */
  QAR,

  /**
   * Romanian Leu
   */
  RON,

  /**
   * Serbian Dinar
   */
  RSD,

  /**
   * Russian Ruble
   */
  RUB,

  /**
   * Rwanda Franc
   */
  RWF,

  /**
   * Saudi Riyal
   */
  SAR,

  /**
   * Solomon Islands Dollar
   */
  SBD,

  /**
   * Seychelles Rupee
   */
  SCR,

  /**
   * Sudanese Pound
   */
  SDG,

  /**
   * Swedish Krona
   */
  SEK,

  /**
   * Singapore Dollar
   */
  SGD,

  /**
   * Saint Helena Pound
   */
  SHP,

  /**
   * Leone
   */
  SLE,

  /**
   * Somali Shilling
   */
  SOS,

  /**
   * Surinam Dollar
   */
  SRD,

  /**
   * South Sudanese Pound
   */
  SSP,

  /**
   * Dobra
   */
  STN,

  /**
   * El Salvador Colon
   */
  SVC,

  /**
   * Syrian Pound
   */
  SYP,

  /**
   * Lilangeni
   */
  SZL,

  /**
   * Baht
   */
  THB,

  /**
   * Somoni
   */
  TJS,

  /**
   * Turkmenistan New Manat
   */
  TMT,

  /**
   * Tunisian Dinar
   */
  TND,

  /**
   * Pa’anga
   */
  TOP,

  /**
   * Turkish Lira
   */
  TRY,

  /**
   * Trinidad and Tobago Dollar
   */
  TTD,

  /**
   * New Taiwan Dollar
   */
  TWD,

  /**
   * Tanzanian Shilling
   */
  TZS,

  /**
   * Hryvnia
   */
  UAH,

  /**
   * Uganda Shilling
   */
  UGX,

  /**
   * US Dollar
   */
  USD,

  /**
   * US Dollar (Next day)
   */
  USN,

  /**
   * Uruguay Peso en Unidades Indexadas (UI)
   */
  UYI,

  /**
   * Peso Uruguayo
   */
  UYU,

  /**
   * Unidad Previsional
   */
  UYW,

  /**
   * Uzbekistan Sum
   */
  UZS,

  /**
   * Bolívar Soberano
   */
  VED,

  /**
   * Bolívar Soberano
   */
  VES,

  /**
   * Dong
   */
  VND,

  /**
   * Vatu
   */
  VUV,

  /**
   * Tala
   */
  WST,

  /**
   * CFA Franc BEAC
   */
  XAF,

  /**
   * Silver
   */
  XAG,

  /**
   * Gold
   */
  XAU,

  /**
   * Bond Markets Unit European Composite Unit (EURCO)
   */
  XBA,

  /**
   * Bond Markets Unit European Monetary Unit (E.M.U.-6)
   */
  XBB,

  /**
   * Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
   */
  XBC,

  /**
   * Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
   */
  XBD,

  /**
   * East Caribbean Dollar
   */
  XCD,

  /**
   * SDR (Special Drawing Right)
   */
  XDR,

  /**
   * CFA Franc BCEAO
   */
  XOF,

  /**
   * Palladium
   */
  XPD,

  /**
   * CFP Franc
   */
  XPF,

  /**
   * Platinum
   */
  XPT,

  /**
   * Sucre
   */
  XSU,

  /**
   * Codes specifically reserved for testing purposes
   */
  XTS,

  /**
   * ADB Unit of Account
   */
  XUA,

  /**
   * The codes assigned for transactions where no currency is involved
   */
  XXX,

  /**
   * Yemeni Rial
   */
  YER,

  /**
   * Rand
   */
  ZAR,

  /**
   * Zambian Kwacha
   */
  ZMW,

  /**
   * Zimbabwe Gold
   */
  ZWG
}
/**
 * The enumerated values to specify the CDX index annex source.
 */
export enum IndexAnnexSourceEnum {

  /**
   * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
   */
  MASTER_CONFIRMATION,

  /**
   * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
   */
  PUBLISHER
}
/**
 * The enumerated values to specify the consequences of Index Events.
 */
export enum IndexEventConsequenceEnum {

  /**
   * Calculation Agent Adjustment.
   */
  CALCULATION_AGENT_ADJUSTMENT,

  /**
   * Cancellation and Payment.
   */
  CANCELLATION_AND_PAYMENT,

  /**
   * Negotiated Close Out.
   */
  NEGOTIATED_CLOSE_OUT,

  /**
   * Related Exchange.
   */
  RELATED_EXCHANGE
}
/**
 * Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
 */
export enum InflationCalculationMethodEnum {

  /**
   * (Inflation Index Final / Inflation Index Base). Inflation Index Final is inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interpolation). Inflation Index Base subject to the Calculation Style. Used in inflation asset swaps to calculate the inflation coupons and principal exchange.
   */
  RATIO,

  /**
   * (Inflation Index Final / Inflation Index Base -1). Inflation Index Final is the inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Used in market standard ZC Inflation swaps.
   */
  RETURN,

  /**
   * Inflation Index Final - Inflation Index Base). Inflation Index Final is Index for Ref month the Lag months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Typically used for fixing locks.
   */
  SPREAD
}
/**
 * Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
 */
export enum InflationCalculationStyleEnum {

  /**
   * YearOnYear means Inflation Index Base is the inflation index for Reference Month that is 12 months prior to Inflation Index Final (subject to interpolation). Inflation Index Base is cashflow dependent.
   */
  YEAR_ON_YEAR,

  /**
   * ZeroCoupon means Inflation Index Base used in the CalculationMethod is the inflation index for the Reference Month that is the lag number of months prior to Effective Date in the case of a swap, or Bond Interest Accrual Date in the case of an Asset Swap (subject to interpolation). Inflation Index Base has the same value for each inflation cashflow and Principal Exchange calculation within the trade.
   */
  ZERO_COUPON
}
/**
 * The enumerated values to specify the list of inflation rate indices.
 */
export enum InflationRateIndexEnum {

  /**
   * Australia: AUD - Non-revised Consumer Price Index (CPI)
   */
  AUD_CPI,

  /**
   * Austria: AUS - Non-revised Consumer Price Index (CPI)
   */
  AUS_CPI,

  /**
   * Austria: AUS - Non-revised Harmonised Indices of Consumer Prices (HICP)
   */
  AUS_HICP,

  /**
   * Belgium: BLG - Non-revised Consumer Price Index - General Index (CPI)
   */
  BLG_CPI_GI,

  /**
   * Belgium: BLG - Non-revised Consumer Price Index - Health Index (CPI)
   */
  BLG_CPI_HI,

  /**
   * Belgium: BLG - Non-revised Harmonised Consumer Price Index (HICP)
   */
  BLG_HICP,

  /**
   * Brazil: BRL - Non-revised Price Index (IGP-M)
   */
  BRL_IGPM,

  /**
   * Brazil: BRL - Non-revised Consumer Price Index (IPCA)
   */
  BRL_IPCA,

  /**
   * Canada: CAD - Non-revised Consumer Price Index (CPI)
   */
  CAD_CPI,

  /**
   * Chile: CLP - Non-revised Consumer Price Index (CPI)
   */
  CLP_CPI,

  /**
   * China: CNY - Non-revised Consumer Price Index (CPI)
   */
  CNY_CPI,

  /**
   * Czech Republic: CZK - Non-revised Consumer Price Index (CPI)
   */
  CZK_CPI,

  /**
   * Denmark: DEK - Non-revised Consumer Price Index (CPI)
   */
  DEK_CPI,

  /**
   * Denmark: DEK - Non-revised Harmonised Consumer Price Index (HICP)
   */
  DEK_HICP,

  /**
   * Germany: DEM - Non-revised Consumer Price Index (CPI)
   */
  DEM_CPI,

  /**
   * Germany: DEM - Non-revised Consumer Price Index for North Rhine-Westphalia
   */
  DEM_CPI_NRW,

  /**
   * Germany: DEM - Non-revised Harmonised Consumer Price Index (HICP)
   */
  DEM_HICP,

  /**
   * Spain: ESP - National-Non-revised Consumer Price Index (CPI)
   */
  ESP_CPI,

  /**
   * Spain: ESP - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  ESP_HICP,

  /**
   * Spain: ESP - National-Revised Consumer Price Index (CPI).
   */
  ESP_R_CPI,

  /**
   * Spain: ESP - Harmonised-Revised Consumer Price Index (HICP)
   */
  ESP_R_HICP,

  /**
   * European Union: EUR - All Items-Non-revised Consumer Price Index
   */
  EUR_AI_CPI,

  /**
   * European Union: EUR - All Items-Revised Consumer Price Index
   */
  EUR_AI_R_CPI,

  /**
   * European Union: EUR - Excluding Tobacco-Non-revised Consumer Price Index
   */
  EUR_EXT_CPI,

  /**
   * European Union: EUR - Excluding Tobacco-Revised Consumer Price Index
   */
  EUR_EXT_R_CPI,

  /**
   * Finland: FIN - Non-revised Consumer Price Index (CPI)
   */
  FIN_CPI,

  /**
   * Finland: FIN - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  FIN_HICP,

  /**
   * France: FRC - Excluding Tobacco-Non-Revised Consumer Price Index
   */
  FRC_EXT_CPI,

  /**
   * France: FRC - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  FRC_HICP,

  /**
   * Greece: GRD - Non-revised Consumer Price Index (CPI)
   */
  GRD_CPI,

  /**
   * Greece: GRD - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  GRD_HICP,

  /**
   * Hong Kong: HKD - Non-revised Consumer Price Index (CPI)
   */
  HKD_CPI,

  /**
   * Hungary: HUF - Non-revised Consumer Price Index (CPI)
   */
  HUF_CPI,

  /**
   * Indonesia: IDR - Non-revised Consumer Price Index (CPI)
   */
  IDR_CPI,

  /**
   * Israel: ILS - Non-revised Consumer Price Index (CPI)
   */
  ILS_CPI,

  /**
   * Ireland: IRL - Non-revised Consumer Price Index (CPI)
   */
  IRL_CPI,

  /**
   * Ireland: IRL - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  IRL_HICP,

  /**
   * Iceland: ISK - Non-revised Consumer Price Index (CPI)
   */
  ISK_CPI,

  /**
   * Iceland: ISK - Harmonised Consumer Price Index (HICP)
   */
  ISK_HICP,

  /**
   * Italy: ITL - Inflation for Blue Collar Workers and Employees-Excluding Tobacco Consumer Price Index
   */
  ITL_BC_EXT_CPI,

  /**
   * Italy: ITL - Inflation for Blue Collar Workers and Employees-Including Tobacco Consumer Price Index
   */
  ITL_BC_INT_CPI,

  /**
   * Italy: ITL - Non-revised Harmonised Consumer Price Index (HICP)
   */
  ITL_HICP,

  /**
   * Italy: ITL - Whole Community - Excluding Tobacco Consumer Price Index
   */
  ITL_WC_EXT_CPI,

  /**
   * Italy: ITL - Whole Community - Including Tobacco Consumer Price Index
   */
  ITL_WC_INT_CPI,

  /**
   * Japan: JPY - Non-revised Consumer Price Index Nationwide General Excluding Fresh Food (CPI)
   */
  JPY_CPI_EXF,

  /**
   * South Korea: KRW - Non-revised Consumer Price Index (CPI)
   */
  KRW_CPI,

  /**
   * Luxembourg: LUX - Non-revised Consumer Price Index (CPI)
   */
  LUX_CPI,

  /**
   * Luxembourg: LUX - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  LUX_HICP,

  /**
   * Mexico: MXN - Non-revised Consumer Price Index (CPI)
   */
  MXN_CPI,

  /**
   * Mexico: MXN - Unidad de Inversion Index (UDI)
   */
  MXN_UDI,

  /**
   * Malaysia: MYR - Non-revised Consumer Price Index (CPI)
   */
  MYR_CPI,

  /**
   * Netherlands: NLG - Non-revised Consumer Price Index (CPI)
   */
  NLG_CPI,

  /**
   * Netherlands: NLG - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  NLG_HICP,

  /**
   * Norway: NOK - Non-revised Consumer Price Index (CPI)
   */
  NOK_CPI,

  /**
   * New Zealand: NZD - Non-revised Consumer Price Index (CPI)
   */
  NZD_CPI,

  /**
   * Peru: PER - Non-revised Consumer Price Index (CPI)
   */
  PER_CPI,

  /**
   * Poland: PLN - Non-Revised Consumer Price Index (CPI)
   */
  PLN_CPI,

  /**
   * Portugal: POR - Non-revised Consumer Price Index (CPI)
   */
  POR_CPI,

  /**
   * Portugal: POR - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  POR_HICP,

  /**
   * Russia: RUB - Non-revised Consumer Price Index (CPI)
   */
  RUB_CPI,

  /**
   * Sweden: SEK - Non-revised Consumer Price Index (CPI)
   */
  SEK_CPI,

  /**
   * Singapore: SGD - Non-revised Consumer Price Index (CPI)
   */
  SGD_CPI,

  /**
   * Switzerland: SWF - Non-revised Consumer Price Index (CPI)
   */
  SWF_CPI,

  /**
   * Turkey: TRY - Non-revised Consumer Price Index (CPI)
   */
  TRY_CPI,

  /**
   * Taiwan: TWD - Non-revised Consumer Price Index (CPI)
   */
  TWD_CPI,

  /**
   * United Kingdom: GBP - Non-revised Consumer Prices Index including Housing (UKCPIH)
   */
  UK_CPIH,

  /**
   * United Kingdom: GBP - Harmonised-Non-revised Consumer Price Index (HICP)
   */
  UK_HICP,

  /**
   * United Kingdom: GBP - Non-revised Retail Price Index (UKRPI)
   */
  UK_RPI,

  /**
   * United Kingdom: GBP - Non-revised Retail Price Index Excluding Mortgage Interest Payments (UKRPIX)
   */
  UK_RPIX,

  /**
   * United States: USA - Non-revised Consumer Price Index - Urban (CPI-U)
   */
  USA_CPI_U,

  /**
   * South Africa: ZAR - Non-revised Consumer Price Index (CPI)
   */
  ZAR_CPI,

  /**
   * South Africa: ZAR - Non-revised Consumer Price Index Excluding Mortgages (CPIX)
   */
  ZAR_CPIX
}
/**
 * The enumerated values to specify the list of information providers.
 */
export enum InformationProviderEnum {

  /**
   * The Association of Banks in Singapore.
   */
  ASSOC_BANKS_SINGAPORE,

  /**
   * The central bank of Chile.
   */
  BANCO_CENTRAL_CHILE,

  /**
   * The central bank of Canada.
   */
  BANK_OF_CANADA,

  /**
   * The Bank Of England.
   */
  BANK_OF_ENGLAND,

  /**
   * The central bank of Japan.
   */
  BANK_OF_JAPAN,

  /**
   * Bloomberg LP.
   */
  BLOOMBERG,

  /**
   * The European Central Bank.
   */
  EURO_CENTRAL_BANK,

  /**
   * The Federal Home Loan Bank of San Francisco, or its successor.
   */
  FHLBSF,

  /**
   * The Federal Reserve, the central bank of the United States.
   */
  FEDERAL_RESERVE,

  /**
   * ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate.
   */
  ICESWAP,

  /**
   * International Swaps and Derivatives Association, Inc.
   */
  ISDA,

  /**
   * Refinitiv, formerly Thomson Reuters Financial & Risk.
   */
  REFINITIV,

  /**
   * The Reserve Bank of Australia.
   */
  RESERVE_BANK_AUSTRALIA,

  /**
   * The Reserve Bank of New Zealand.
   */
  RESERVE_BANK_NEW_ZEALAND,

  /**
   * Reuters Group Plc.
   */
  REUTERS,

  /**
   * South African Futures Exchange, or its successor.
   */
  SAFEX,

  /**
   * The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR.
   */
  TOKYOSWAP,

  /**
   * Telerate, Inc.
   */
  TELERATE
}
/**
 * The enumeration values indicating the BusinessEvent function associated input instructions.
 */
export enum InstructionFunctionEnum {

  COMPRESSION,

  CONTRACT_FORMATION,

  EXECUTION,

  QUANTITY_CHANGE,

  RENEGOTIATION
}
/**
 * Represents an enumeration list to indentify the type of an instrument.
 */
export enum InstrumentTypeEnum {

  /**
   * Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
   */
  CERTIFICATE,

  /**
   * Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
   */
  DEBT,

  /**
   * Identifies an instrument as an Equity value of holding of shares in listed company.
   */
  EQUITY,

  /**
   * Identifies an instrument as representing holding in an investment fund.
   */
  FUND,

  /**
   * Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
   */
  LETTER_OF_CREDIT,

  /**
   * Identifies an instrument as a listed derivative on an exchange.
   */
  LISTED_DERIVATIVE,

  /**
   * Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
   */
  WARRANT
}
/**
 * The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives.
 */
export enum InterestShortfallCapEnum {

  FIXED,

  VARIABLE
}
/**
 * The enumerated values to specify the interpolation method, e.g. linear.
 */
export enum InterpolationMethodEnum {

  /**
   * Linear Interpolation applicable.
   */
  LINEAR,

  /**
   * Linear Interpolation applicable.
   */
  LINEAR_ZERO_YIELD,

  /**
   * No Interpolation applicable.
   */
  NONE
}
/**
 * Represents an enumeration list to identify the type of entity issuing the asset.
 */
export enum IssuerTypeEnum {

  /**
   * Specifies debt issued Securities by corporate bodies including Banks.
   */
  CORPORATE,

  /**
   * Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
   */
  FUND,

  /**
   * Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
   */
  QUASI_GOVERNMENT,

  /**
   * Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities.
   */
  REGIONAL_GOVERNMENT,

  /**
   * Specifies Sovereign, Government Debt Securities including Central Banks.
   */
  SOVEREIGN_CENTRAL_BANK,

  /**
   * Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations.
   */
  SPECIAL_PURPOSE_VEHICLE,

  /**
   * Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks.
   */
  SUPRA_NATIONAL
}
/**
 * The enumerated values to specify the legal agreement publisher.
 */
export enum LegalAgreementPublisherEnum {

  /**
   * Association Française des Banques.
   */
  AFB,

  /**
   * BNY Mellon
   */
  BNYM,

  /**
   * Emerging Markets Traders Association
   */
  EMTA,

  /**
   * International Capital Markets Association
   */
  ICMA,

  /**
   * International Swaps and Derivatives Association, Inc.
   */
  ISDA,

  /**
   * ISDA and Clearstream
   */
  ISDA_CLEARSTREAM,

  /**
   * ISDA and Euroclear
   */
  ISDA_EUROCLEAR,

  /**
   * International Securities Lending Association
   */
  ISLA,

  /**
   * JP Morgan
   */
  JP_MORGAN,

  /**
   * The Foreign Exchange Committee
   */
  THE_FX_COMMITTEE
}
/**
 * The enumerated values to specify the legal agreement type.
 */
export enum LegalAgreementTypeEnum {

  /**
   * A Broker Confirmation.
   */
  BROKER_CONFIRMATION,

  /**
   * A Transaction Confirmation.
   */
  CONFIRMATION,

  /**
   * A Credit Support Agreement.
   */
  CREDIT_SUPPORT_AGREEMENT,

  /**
   * A Master Agreement.
   */
  MASTER_AGREEMENT,

  /**
   * A Master Confirmation.
   */
  MASTER_CONFIRMATION,

  /**
   * Another type of agreement.
   */
  OTHER,

  /**
   * A Security Agreement related to a Collateral Transfer Agreement (CTA).
   */
  SECURITY_AGREEMENT
}
/**
 * The enumerated values to specify the length unit in the Resource type.
 */
export enum LengthUnitEnum {

  PAGES,

  TIME_UNIT
}
/**
 * The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification.
 */
export enum LimitLevelEnum {

  /**
   * The limit is set in relation to the proprietary business undertaken by the clearing counterparty.
   */
  ACCOUNT,

  /**
   * The limit is set in relation to the customer business undertaken by the clearing counterparty.
   */
  CUSTOMER,

  /**
   * The limit is set at the account level in relation to the clearing counterparty.
   */
  HOUSE
}
/**
 * Specifies the load type of the delivery.
 */
export enum LoadTypeEnum {

  /**
   * Base load
   */
  BASE_LOAD,

  /**
   * Block Hours
   */
  BLOCK_HOURS,

  /**
   * Gas Day
   */
  GAS_DAY,

  /**
   * Off-peak load
   */
  OFF_PEAK,

  /**
   * Other
   */
  OTHER,

  /**
   * Peak load
   */
  PEAK_LOAD,

  /**
   * Shaped
   */
  SHAPED
}
/**
 * Represents the enumeration values to identify the collateral action instruction.
 */
export enum MarginCallActionEnum {

  /**
   * Indicates an instruction of a new collateral asset delivery.
   */
  DELIVERY,

  /**
   * Indicates an instruction for a return of a principals collateral asset delivery.
   */
  RETURN
}
/**
 * Represents the enumeration values to define the response type to a margin call.
 */
export enum MarginCallResponseTypeEnum {

  /**
   * Specifies a 'Full Agreement' to Margin Call.
   */
  AGREEIN_FULL,

  /**
   * Specifies a 'Full Dispute' to a Margin call.
   */
  DISPUTE,

  /**
   * Specifies a 'Partial agreement' to Margin Call.
   */
  PARTIALLY_AGREE
}
/**
 * This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
 */
export enum MarginTypeEnum {

  /**
   * When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
   */
  CASH,

  /**
   * When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the 'instrument' case, the haircut would be applied to the securities.
   */
  INSTRUMENT
}
/**
 * The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
 */
export enum MarketDisruptionEnum {

  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
   */
  MODIFIED_POSTPONEMENT,

  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
   */
  OMISSION,

  /**
   * As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
   */
  POSTPONEMENT
}
export enum MasterAgreementClauseIdentifierEnum {

  /**
   * Date of Agreement
   */
  ISLA_GMSLA_001,

  /**
   * Parties
   */
  ISLA_GMSLA_002,

  /**
   * Specific Roles
   */
  ISLA_GMSLA_003,

  /**
   * Eligible Collateral
   */
  ISLA_GMSLA_004,

  /**
   * Margin
   */
  ISLA_GMSLA_005,

  /**
   * Aggregation
   */
  ISLA_GMSLA_006,

  /**
   * Collateral Disapplication
   */
  ISLA_GMSLA_007,

  /**
   * Settlement Netting
   */
  ISLA_GMSLA_008,

  /**
   * Notification Time
   */
  ISLA_GMSLA_009,

  /**
   * Indemnity
   */
  ISLA_GMSLA_010,

  /**
   * Base Currency
   */
  ISLA_GMSLA_011,

  /**
   * Places of Business
   */
  ISLA_GMSLA_012,

  /**
   * Value
   */
  ISLA_GMSLA_013,

  /**
   * Automatic Early Termination
   */
  ISLA_GMSLA_014,

  /**
   * Designated Offices
   */
  ISLA_GMSLA_015,

  /**
   * Address for Notices
   */
  ISLA_GMSLA_016,

  /**
   * Process Agent
   */
  ISLA_GMSLA_017,

  /**
   * Party Acting as Agent
   */
  ISLA_GMSLA_018,

  /**
   * Pooled Principal Transactions 
   */
  ISLA_GMSLA_019,

  /**
   * Party Preparing the Agreement 
   */
  ISLA_GMSLA_020,

  /**
   * Default Interest Rate
   */
  ISLA_GMSLA_021,

  /**
   * Existing Transactions
   */
  ISLA_GMSLA_022,

  /**
   * Automation
   */
  ISLA_GMSLA_023,

  /**
   * Act of Insolvency
   */
  ISLA_GMSLA_024,

  /**
   * Buy-In
   */
  ISLA_GMSLA_025,

  /**
   * Currency Conversions
   */
  ISLA_GMSLA_026,

  /**
   * Scope
   */
  ISLA_GMSLA_027,

  /**
   * Collateral Delivery Timings
   */
  ISLA_GMSLA_028,

  /**
   * Delivery
   */
  ISLA_GMSLA_029,

  /**
   * Substitution of Collateral
   */
  ISLA_GMSLA_030,

  /**
   * Manufactured Payments
   */
  ISLA_GMSLA_031,

  /**
   * Corporate Actions
   */
  ISLA_GMSLA_032,

  /**
   * Payment of Rates
   */
  ISLA_GMSLA_033,

  /**
   * Rate Applicable to Loaned Securities
   */
  ISLA_GMSLA_034,

  /**
   * Lender's Right to Terminate a Loan
   */
  ISLA_GMSLA_035,

  /**
   * Borrower's Right to Terminate a Loan
   */
  ISLA_GMSLA_036,

  /**
   * Failure to Deliver Event of Default
   */
  ISLA_GMSLA_037,

  /**
   * Failure to Redeliver
   */
  ISLA_GMSLA_038,

  /**
   * Assets Transferred to a Trustee
   */
  ISLA_GMSLA_039,

  /**
   * Suspension Event of Default
   */
  ISLA_GMSLA_040,

  /**
   * Costs and Expenses
   */
  ISLA_GMSLA_041,

  /**
   * Set-Off
   */
  ISLA_GMSLA_042,

  /**
   * Default Market Value Fallbacks
   */
  ISLA_GMSLA_043,

  /**
   * Assignment
   */
  ISLA_GMSLA_044,

  /**
   * Telephone Recordings
   */
  ISLA_GMSLA_045,

  /**
   * Waiver of Immunity
   */
  ISLA_GMSLA_046,

  /**
   * Agreement to Deliver Documents
   */
  ISLA_GMSLA_047,

  /**
   * Collateral Transfer Details
   */
  ISLA_GMSLA_048,

  /**
   * Confidentiality
   */
  ISLA_GMSLA_049,

  /**
   * Correction
   */
  ISLA_GMSLA_050,

  /**
   * Minimum Collateral Transfer Amount
   */
  ISLA_GMSLA_051,

  /**
   * Non-Reliance Representation
   */
  ISLA_GMSLA_052,

  /**
   * Records and Statements
   */
  ISLA_GMSLA_053,

  /**
   * Recovery and Resolution
   */
  ISLA_GMSLA_054,

  /**
   * Security Agreement Details
   */
  ISLA_GMSLA_055,

  /**
   * Triparty Services
   */
  ISLA_GMSLA_056
}
/**
 * The enumerated values to specify the type of the master agreement governing the transaction.
 */
export enum MasterAgreementTypeEnum {

  /**
   * AFB Master Agreement for Foreign Exchange and Derivatives Transactions
   */
  AFB,

  /**
   * A Bespoke (custom) Master Agreement, including one-off agreements for transactions
   */
  BESPOKE,

  /**
   * Clearing Master Agreement
   */
  CMA,

  /**
   * Contrato Marco de Operaciones Financieras
   */
  CMOF,

  /**
   * EEI Master Power Purchase and Sale Agreement
   */
  EEI_POWER,

  /**
   * EFET General Agreement Concerning the Delivery and Acceptance of Electricity
   */
  EFET_ELECTRICITY,

  /**
   * EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
   */
  EFET_GAS,

  /**
   * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
   */
  EMA,

  /**
   * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
   */
  FBF,

  /**
   * ICMA Global Master Agreement for REPO Trades
   */
  GMRA,

  /**
   * ISLA Global Master Agreement for Securities Lending
   */
  GMSLA,

  /**
   * FOA Grid Trade Master Agreement
   */
  GTMA,

  /**
   * GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas
   */
  GAS_EDI,

  /**
   * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
   */
  GERMAN,

  /**
   * International Currency Options Market Master Agreement
   */
  ICOM,

  /**
   * International Emissions Trading Association Emissions Reduction Purchase Agreement
   */
  IETA_ERPA,

  /**
   * International Emissions Trading Association Emissions Trading Master Agreement
   */
  IETA_ETMA,

  /**
   * International Emissions Trading Association International Emissions Trading Master Agreement
   */
  IETA_IETMA,

  /**
   * International Foreign Exchange Master Agreement
   */
  IFEMA,

  /**
   * International Foreign Exchange and Options Master Agreement
   */
  IFEOMA,

  /**
   * ISDA-FIA Cleared Derivatives Execution Agreement
   */
  ISDAFIA_CDEA,

  /**
   * ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA)
   */
  ISDAIIFM_TMA,

  /**
   * ISDA Master Agreement
   */
  ISDA_MASTER,

  /**
   * Master agreement of Japan Securities Clearing Corporation
   */
  JSCC,

  /**
   * International Bullion Master Agreement Terms published by the London Bullion Market Association
   */
  LBMA,

  /**
   * Leadership in Energy Automated Processing
   */
  LEAP,

  /**
   * CTA Master Coal Purchase and Sales Agreement
   */
  MCPSA,

  /**
   * NAESB Base Contract for Sale and Purchase of Natural Gas
   */
  NAESB_GAS,

  /**
   * Short Term Flat NBP Trading Terms and Conditions
   */
  NBP,

  /**
   * Standard Documentation for Derivative Transactions on the Russian Financial Markets
   */
  RUSSIAN_DERIVATIVES,

  /**
   * Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market
   */
  RUSSIAN_REPO,

  /**
   * globalCOAL Standard Coal Trading Agreement
   */
  S_CO_TA,

  /**
   * Swiss Master Agreement for OTC Derivatives Instruments
   */
  SWISS,

  /**
   * TTF Hub Natural Gas Trading Terms and Conditions
   */
  TTF,

  /**
   * Zeebrugge Hub Natural Gas Trading Terms and Conditions
   */
  ZBT
}
export enum MasterAgreementVariantIdentifierEnum {

  /**
   * Agreement is Undated
   */
  ISLA_GMSLA_001_01,

  /**
   * Agreement is Dated
   */
  ISLA_GMSLA_001_02,

  /**
   * Name and Place of Incorporation
   */
  ISLA_GMSLA_002_01,

  /**
   * Names and Place of Incorporation plus Additional Information
   */
  ISLA_GMSLA_002_02,

  /**
   * Defining the Party's Role as Lender or Borrower
   */
  ISLA_GMSLA_002_03,

  /**
   * Non-specific Roles
   */
  ISLA_GMSLA_003_01,

  /**
   * Specific Roles
   */
  ISLA_GMSLA_003_02,

  /**
   * GMSLA Schedule
   */
  ISLA_GMSLA_004_01,

  /**
   * Outside of GMSLA
   */
  ISLA_GMSLA_004_02,

  /**
   * Additional Criteria
   */
  ISLA_GMSLA_004_03,

  /**
   * GMSLA Schedule
   */
  ISLA_GMSLA_005_01,

  /**
   * Outside of GMSLA
   */
  ISLA_GMSLA_005_02,

  /**
   * Aggregation Applies
   */
  ISLA_GMSLA_006_01,

  /**
   * Aggregation Does Not Apply
   */
  ISLA_GMSLA_006_02,

  /**
   * Aggregation Applies Separately to Loan Groups
   */
  ISLA_GMSLA_006_03,

  /**
   * Aggregation Applies to Some but Not All Loans
   */
  ISLA_GMSLA_006_04,

  /**
   * Neither Aggregation nor Loan by Loan Applies
   */
  ISLA_GMSLA_006_05,

  /**
   * Standard
   */
  ISLA_GMSLA_007_01,

  /**
   * Collateral Disapplied
   */
  ISLA_GMSLA_007_02,

  /**
   * Netting of Collateral Shall Apply
   */
  ISLA_GMSLA_008_01,

  /**
   * Netting of Collateral Shall Not Apply
   */
  ISLA_GMSLA_008_02,

  /**
   * Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
   */
  ISLA_GMSLA_008_03,

  /**
   * Netting of Collateral Shall Apply Separately per Group of Loans
   */
  ISLA_GMSLA_008_04,

  /**
   * Specified Time
   */
  ISLA_GMSLA_009_01,

  /**
   * Notification Time by Collateral Type
   */
  ISLA_GMSLA_009_02,

  /**
   * Notification Time as Agreed
   */
  ISLA_GMSLA_009_03,

  /**
   * No Notification Time
   */
  ISLA_GMSLA_009_04,

  /**
   * Indemnity Applies
   */
  ISLA_GMSLA_010_01,

  /**
   * Indemnity does not Apply
   */
  ISLA_GMSLA_010_02,

  /**
   * Single Base Currency
   */
  ISLA_GMSLA_011_01,

  /**
   * Single Base Currency with Fallback
   */
  ISLA_GMSLA_011_02,

  /**
   * Single Base Currency with Multiple Fallback Options
   */
  ISLA_GMSLA_011_03,

  /**
   * Locations are Specified Without Reference to Party
   */
  ISLA_GMSLA_012_01,

  /**
   * Locations are Specified Separately per Party
   */
  ISLA_GMSLA_012_02,

  /**
   * Not all Places of Business Have to be Open
   */
  ISLA_GMSLA_012_03,

  /**
   * Standard Bid Price
   */
  ISLA_GMSLA_013_01,

  /**
   * Standard Mid Price
   */
  ISLA_GMSLA_013_02,

  /**
   * 2018 Standard
   */
  ISLA_GMSLA_013_03,

  /**
   * Borrowers Agreement to Pricing Source
   */
  ISLA_GMSLA_013_04,

  /**
   * Pre-agreed Pricing Source
   */
  ISLA_GMSLA_013_05,

  /**
   * Time Variation
   */
  ISLA_GMSLA_013_06,

  /**
   * Automatic Early Termination does not Apply
   */
  ISLA_GMSLA_014_01,

  /**
   * Automatic Early Termination Applies
   */
  ISLA_GMSLA_014_02,

  /**
   * Automatic Early Termination Applies in Modified Form)
   */
  ISLA_GMSLA_014_03,

  /**
   * Automatic Early Termination is specified separately for each Principal
   */
  ISLA_GMSLA_014_04,

  /**
   * Automatic Early Termination is not applicable unless required due to the systems of law
   */
  ISLA_GMSLA_014_05,

  /**
   * Party Specifies a Single Designated Office
   */
  ISLA_GMSLA_015_01,

  /**
   * Party Specifies Multiple Designated Offices
   */
  ISLA_GMSLA_015_02,

  /**
   * 2000 Standard
   */
  ISLA_GMSLA_016_01,

  /**
   * 2010 Standard
   */
  ISLA_GMSLA_016_02,

  /**
   * 2018 Standard
   */
  ISLA_GMSLA_016_03,

  /**
   * Plus Email
   */
  ISLA_GMSLA_016_04,

  /**
   * Separate Address for Legal and Operational Notices
   */
  ISLA_GMSLA_016_05,

  /**
   * Special Instructions
   */
  ISLA_GMSLA_016_06,

  /**
   * No Process Agent
   */
  ISLA_GMSLA_017_01,

  /**
   * Process Agent Specified
   */
  ISLA_GMSLA_017_02,

  /**
   * Process Agent to be Appointed
   */
  ISLA_GMSLA_017_03,

  /**
   * A Party will not act as Agent
   */
  ISLA_GMSLA_018_01,

  /**
   * A Party may act as Agent
   */
  ISLA_GMSLA_018_02,

  /**
   * A Party will always act as Agent
   */
  ISLA_GMSLA_018_03,

  /**
   * Pooled Principal Transactions Shall Not Apply
   */
  ISLA_GMSLA_019_01,

  /**
   * Pooled Principal Transactions Shall  Apply
   */
  ISLA_GMSLA_019_02,

  /**
   * Pooled Principal Transactions May Apply
   */
  ISLA_GMSLA_019_03,

  /**
   * Simple Election
   */
  ISLA_GMSLA_020_01,

  /**
   * Election with Modifications
   */
  ISLA_GMSLA_020_02,

  /**
   * Term Rate
   */
  ISLA_GMSLA_021_01,

  /**
   * Overnight Rate
   */
  ISLA_GMSLA_021_02,

  /**
   * Risk Free Rate
   */
  ISLA_GMSLA_021_03,

  /**
   * Non-Defaulting Party Election
   */
  ISLA_GMSLA_021_04,

  /**
   * Spread
   */
  ISLA_GMSLA_021_05,

  /**
   * Agreement Covers Existing Loans
   */
  ISLA_GMSLA_022_01,

  /**
   * Agreement Does Not Cover Existing Loans
   */
  ISLA_GMSLA_022_02,

  /**
   * Automation Does Not Apply
   */
  ISLA_GMSLA_023_01,

  /**
   * Automation May Apply
   */
  ISLA_GMSLA_023_02,

  /**
   * Standard Pre-Print
   */
  ISLA_GMSLA_024_01,

  /**
   * Grace Period Amendment
   */
  ISLA_GMSLA_024_02,

  /**
   * Jurisdictional Amendments
   */
  ISLA_GMSLA_024_03,

  /**
   * Transferor Pays Costs and Expenses
   */
  ISLA_GMSLA_025_01,

  /**
   * Transferor Pays Costs and Expenses other than those arising from Negligence
   */
  ISLA_GMSLA_025_02,

  /**
   * Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
   */
  ISLA_GMSLA_025_03,

  /**
   * Buy-in Expanded to Cover Buy-in Exercised by an Exchange
   */
  ISLA_GMSLA_025_04,

  /**
   * Standard
   */
  ISLA_GMSLA_026_01,

  /**
   * Selecting Party other than Lender
   */
  ISLA_GMSLA_026_02,

  /**
   * Variation of Exchange Rate Source
   */
  ISLA_GMSLA_026_03,

  /**
   * Standard Scope
   */
  ISLA_GMSLA_027_01,

  /**
   * Limited Scope
   */
  ISLA_GMSLA_027_02,

  /**
   * Same Day
   */
  ISLA_GMSLA_028_01,

  /**
   * Alternative Delivery Time
   */
  ISLA_GMSLA_028_02,

  /**
   * Same Day with Notification Time
   */
  ISLA_GMSLA_028_03,

  /**
   * Alternative Delivery Time with Notification Time
   */
  ISLA_GMSLA_028_04,

  /**
   * Asset Dependent
   */
  ISLA_GMSLA_028_05,

  /**
   * Simultaneous delivery of securities and collateral
   */
  ISLA_GMSLA_029_01,

  /**
   * Collateral Delivery as specified in the Security Agreement
   */
  ISLA_GMSLA_029_02,

  /**
   * Lender to Deliver Securities once Collateral is Delivered
   */
  ISLA_GMSLA_029_03,

  /**
   * Borrower Request
   */
  ISLA_GMSLA_030_01,

  /**
   * Borrower Request/Lender Consent
   */
  ISLA_GMSLA_030_02,

  /**
   * Lender or Borrower Request
   */
  ISLA_GMSLA_030_03,

  /**
   * Pre-approval of Alternative Collateral
   */
  ISLA_GMSLA_030_04,

  /**
   * Manufactured Payment of Amount Such Party Would Be Entitled to Receive
   */
  ISLA_GMSLA_031_01,

  /**
   * Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
   */
  ISLA_GMSLA_031_02,

  /**
   * Manufactured Payment Only in Relation to Loaned Securities
   */
  ISLA_GMSLA_031_03,

  /**
   * Additional Sum to Be Paid to Cover Tax Relief
   */
  ISLA_GMSLA_031_04,

  /**
   * Notice Requirement
   */
  ISLA_GMSLA_031_05,

  /**
   * Standard
   */
  ISLA_GMSLA_032_01,

  /**
   * Reasonable Notice Defined
   */
  ISLA_GMSLA_032_02,

  /**
   * No Right to Instruct
   */
  ISLA_GMSLA_032_03,

  /**
   * Payment Within a Week
   */
  ISLA_GMSLA_033_01,

  /**
   * Payment Within 10 Days
   */
  ISLA_GMSLA_033_02,

  /**
   * Payment Upon Maturity
   */
  ISLA_GMSLA_033_03,

  /**
   * Such Rate as Agreed
   */
  ISLA_GMSLA_034_01,

  /**
   * VAT Added
   */
  ISLA_GMSLA_034_02,

  /**
   * No Deduction
   */
  ISLA_GMSLA_034_03,

  /**
   * No Rate Payable
   */
  ISLA_GMSLA_034_04,

  /**
   * Lender May Terminate a Loan at any Time
   */
  ISLA_GMSLA_035_01,

  /**
   * Lender May Not Terminate a Loan
   */
  ISLA_GMSLA_035_02,

  /**
   * Borrower May Terminate a Loan at Any Time
   */
  ISLA_GMSLA_036_01,

  /**
   * Borrower May Terminate a Loan Subject to Notice
   */
  ISLA_GMSLA_036_02,

  /**
   * Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
   */
  ISLA_GMSLA_036_03,

  /**
   * Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
   */
  ISLA_GMSLA_036_04,

  /**
   * Failure to Deliver Event of Default Applies
   */
  ISLA_GMSLA_037_01,

  /**
   * Failure to Deliver Event of Default does not Apply
   */
  ISLA_GMSLA_037_02,

  /**
   * Failure to Deliver Event of Default does not Apply to Lender
   */
  ISLA_GMSLA_037_03,

  /**
   * 2000 Standard
   */
  ISLA_GMSLA_038_01,

  /**
   * 2010 Standard
   */
  ISLA_GMSLA_038_02,

  /**
   * 2018 Standard
   */
  ISLA_GMSLA_038_03,

  /**
   * 2000 Modified No Lender Close Out
   */
  ISLA_GMSLA_038_04,

  /**
   * 2000 Standard
   */
  ISLA_GMSLA_039_01,

  /**
   * 2010/2018 Standard
   */
  ISLA_GMSLA_039_02,

  /**
   * Hybrid
   */
  ISLA_GMSLA_039_03,

  /**
   * 2000 Standard
   */
  ISLA_GMSLA_040_01,

  /**
   * 2010/2018 Standard
   */
  ISLA_GMSLA_040_02,

  /**
   * Hybrid
   */
  ISLA_GMSLA_040_03,

  /**
   * Standard Costs and Expenses
   */
  ISLA_GMSLA_041_01,

  /**
   * Limitation of Costs and Expenses
   */
  ISLA_GMSLA_041_02,

  /**
   * Expansion of Costs and Expenses
   */
  ISLA_GMSLA_041_03,

  /**
   * No Contractual Set-Off
   */
  ISLA_GMSLA_042_01,

  /**
   * Simple Contractual Set-Off
   */
  ISLA_GMSLA_042_02,

  /**
   * Set-Off with Unascertained Obligations Amendment
   */
  ISLA_GMSLA_042_03,

  /**
   * Standard Paragraph 11.2(a)
   */
  ISLA_GMSLA_043_01,

  /**
   * Amended Paragraph 11.2,(a) applies
   */
  ISLA_GMSLA_043_02,

  /**
   * Consent
   */
  ISLA_GMSLA_044_01,

  /**
   * Consent with Standard Exclusions
   */
  ISLA_GMSLA_044_02,

  /**
   * Consent with Additional Exclusions
   */
  ISLA_GMSLA_044_03,

  /**
   * Pre-approved Assignments
   */
  ISLA_GMSLA_044_04,

  /**
   * Parties May Record All Conversations
   */
  ISLA_GMSLA_045_01,

  /**
   * Parties Agree to Obtain Consent
   */
  ISLA_GMSLA_045_02,

  /**
   * Parties Limit the Conversations that May be Recorded
   */
  ISLA_GMSLA_045_03,

  /**
   * Submission as Evidence
   */
  ISLA_GMSLA_045_04,

  /**
   * Standard Waiver of Immunity Applies
   */
  ISLA_GMSLA_046_01,

  /**
   * Waiver of Immunity may Not Apply
   */
  ISLA_GMSLA_046_02,

  /**
   * No Additional Documentation Required
   */
  ISLA_GMSLA_047_01,

  /**
   * Additional Documentation Required
   */
  ISLA_GMSLA_047_02,

  /**
   * Collateral Transfer Details not included
   */
  ISLA_GMSLA_048_01,

  /**
   * Collateral Transfer Details included
   */
  ISLA_GMSLA_048_02,

  /**
   * Confidentiality Clause
   */
  ISLA_GMSLA_049_01,

  /**
   * Permitted Disclosure Clause
   */
  ISLA_GMSLA_049_02,

  /**
   * Paragraph 20.1 Amended to Refer  Paragraph 6
   */
  ISLA_GMSLA_050_01,

  /**
   * Paragraph 27.2 Amended to refer to the 2010 GMSLA
   */
  ISLA_GMSLA_050_02,

  /**
   * MCTA  Delivery only
   */
  ISLA_GMSLA_051_01,

  /**
   * MCTA  Delivery and Re-Delivery
   */
  ISLA_GMSLA_051_02,

  /**
   * MCTA  Drops to Zero for a Defaulting Party
   */
  ISLA_GMSLA_051_03,

  /**
   * No Non-Reliance Representation
   */
  ISLA_GMSLA_052_01,

  /**
   * Non-Reliance Representation Added
   */
  ISLA_GMSLA_052_02,

  /**
   * No Records and Statements Clause
   */
  ISLA_GMSLA_053_01,

  /**
   * Records and Statements Clause Added
   */
  ISLA_GMSLA_053_02,

  /**
   * Recovery and Resolution not Included
   */
  ISLA_GMSLA_054_01,

  /**
   * Recovery and Resolution Included in GMSLA
   */
  ISLA_GMSLA_054_02,

  /**
   * Recovery and Resolution Included by Protocol
   */
  ISLA_GMSLA_054_03,

  /**
   * Recovery and Resolution Incorporated by Reference
   */
  ISLA_GMSLA_054_04,

  /**
   * Security Agreement Details Included
   */
  ISLA_GMSLA_055_01,

  /**
   * Triparty Services Not Referenced
   */
  ISLA_GMSLA_056_01,

  /**
   * Triparty Services May Apply
   */
  ISLA_GMSLA_056_02
}
/**
 * The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction.
 */
export enum MasterConfirmationAnnexTypeEnum {

  /**
   * The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,

  /**
   * The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,

  /**
   * The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN,

  /**
   * The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN,

  /**
   * The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,

  /**
   * The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,

  /**
   * The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_OPTION_EUROPEAN,

  /**
   * The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN,

  /**
   * The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1,

  /**
   * The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN,

  /**
   * The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1,

  /**
   * The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_OPTION_JAPAN,

  /**
   * The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN,

  /**
   * The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_EUROPEAN_IS,

  /**
   * The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS,

  /**
   * The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_INDEX_SHARE_OPTION_AMERICAS,

  /**
   * The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER,

  /**
   * The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER,

  /**
   * The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_SHARE_SWAP_PAN_ASIA,

  /**
   * The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER,

  /**
   * The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER
}
/**
 * The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints.
 */
export enum MasterConfirmationTypeEnum {

  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation.
   */
  DJ_CDX_EM,

  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation.
   */
  DJ_CDX_EM_DIV,

  /**
   * Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO.
   */
  DJ_CDX_NA,

  /**
   * Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement.
   */
  DJ_I_TRAXX_EUROPE,

  /**
   * A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement.
   */
  EQUITY_AMERICAS,

  /**
   * A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement.
   */
  EQUITY_ASIA,

  /**
   * A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement.
   */
  EQUITY_EUROPEAN,

  /**
   * ISDA 1999 Master Credit Derivatives Confirmation Agreement
   */
  ISDA_1999_CREDIT,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_ASIA,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_EUROPEAN,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_JAPAN,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_NORTH_AMERICAN,

  /**
   * ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2003_CREDIT_SINGAPORE,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_ASIA,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_JAPAN,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST,

  /**
   * ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
   */
  ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign.
   */
  ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_EUROPEAN,

  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
   */
  ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign.
   */
  ISDA_2003_STANDARD_CREDIT_SINGAPORE,

  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_ASIA,

  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,

  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_JAPAN,

  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN,

  /**
   * ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement.
   */
  ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,

  /**
   * The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER,

  /**
   * The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,

  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
   */
  ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,

  /**
   * ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER,

  /**
   * Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2,

  /**
   * The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2005_EQUITY_JAPANESE_INTERDEALER,

  /**
   * ISDA 2006 Variance Swap Japanese Confirmation Agreement applies.
   */
  ISDA_2006_VARIANCE_SWAP_JAPANESE,

  /**
   * ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies.
   */
  ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER,

  /**
   * The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2007_EQUITY_EUROPEAN,

  /**
   * The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_AMERICAS,

  /**
   * The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN,

  /**
   * The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1,

  /**
   * The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2,

  /**
   * The ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_EUROPEAN,

  /**
   * The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
   */
  ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1,

  /**
   * The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
   */
  ISDA_2008_DIVIDEND_SWAP_JAPAN,

  /**
   * The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
   */
  ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1,

  /**
   * The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_AMERICAS,

  /**
   * The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN,

  /**
   * The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1,

  /**
   * The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2008_EQUITY_JAPAN,

  /**
   * The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_AMERICAS,

  /**
   * The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_EUROPEAN_INTERDEALER,

  /**
   * 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2009_EQUITY_PAN_ASIA,

  /**
   * The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
   */
  ISDA_2010_EQUITY_EMEA_INTERDEALER,

  /**
   * The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_AMERICAS,

  /**
   * The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN,

  /**
   * The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_EUROPEAN,

  /**
   * The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies.
   */
  ISDA_2013_VOLATILITY_SWAP_JAPANESE,

  /**
   * Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies.
   */
  _2003_CREDIT_INDEX,

  /**
   * A privately negotiated European Interdealer Master Confirmation Agreement applies.
   */
  _2004_EQUITY_EUROPEAN_INTERDEALER,

  /**
   * A privately negotiated European Interdealer Master Confirmation Agreement applies.
   */
  _2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER,

  /**
   * A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies.
   */
  _2006_DIVIDEND_SWAP_EUROPEAN,

  /**
   * A European Interdealer Master Confirmation Agreement not defined by ISDA applies.
   */
  _2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER,

  /**
   * Dummy MCA value mirroring the matrix term value AsiaCorporate.
   */
  _2014_CREDIT_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate.
   */
  _2014_CREDIT_ASIA_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate.
   */
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND,

  /**
   * Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate.
   */
  _2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value EuropeanCorporate.
   */
  _2014_CREDIT_EUROPEAN,

  /**
   * Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate.
   */
  _2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate.
   */
  _2014_CREDIT_EUROPEAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value JapanCorporate.
   */
  _2014_CREDIT_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value JapanFinancialCorporate.
   */
  _2014_CREDIT_JAPAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value NorthAmericanCorporate.
   */
  _2014_CREDIT_NORTH_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate.
   */
  _2014_CREDIT_NORTH_AMERICAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term values SingaporeCorporate.
   */
  _2014_CREDIT_SINGAPORE,

  /**
   * Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate.
   */
  _2014_CREDIT_SINGAPORE_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value AsiaSovereign.
   */
  _2014_CREDIT_SOVEREIGN_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign.
   */
  _2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,

  /**
   * Dummy MCA value mirroring the matrix term value JapanSovereign.
   */
  _2014_CREDIT_SOVEREIGN_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value LatinAmericaSovereign.
   */
  _2014_CREDIT_SOVEREIGN_LATIN_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign.
   */
  _2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
   */
  _2014_STANDARD_CREDIT_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_ASIA_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate.
   */
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND,

  /**
   * Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
   */
  _2014_STANDARD_CREDIT_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_JAPAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
   */
  _2014_STANDARD_CREDIT_NORTH_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate.
   */
  _2014_STANDARD_CREDIT_SINGAPORE,

  /**
   * Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate.
   */
  _2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL,

  /**
   * Dummy MCA value mirroring the matrix term value StandardAsiaSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_ASIA,

  /**
   * Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN,

  /**
   * Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_JAPAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN,

  /**
   * Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
   */
  _2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN
}
/**
 * The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix.
 */
export enum MatrixTermEnum {

  /**
   * Matrix Transaction Type of ASIA CORPORATE.
   */
  ASIA_CORPORATE,

  /**
   * Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
   */
  ASIA_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of ASIA SOVEREIGN.
   */
  ASIA_SOVEREIGN,

  /**
   * Matrix Transaction Type of AUSTRALIA CORPORATE.
   */
  AUSTRALIA_CORPORATE,

  /**
   * Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
   */
  AUSTRALIA_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of AUSTRALIA SOVEREIGN.
   */
  AUSTRALIA_SOVEREIGN,

  /**
   * Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
   */
  EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,

  /**
   * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
   */
  EMERGING_EUROPEAN_CORPORATE,

  /**
   * Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
   */
  EMERGING_EUROPEAN_CORPORATE_LPN,

  /**
   * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
   */
  EMERGING_EUROPEAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
   */
  EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN,

  /**
   * Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
   */
  EUROPEAN_CO_CO_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of EUROPEAN CORPORATE.
   */
  EUROPEAN_CORPORATE,

  /**
   * Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
   */
  EUROPEAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
   */
  EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE,

  /**
   * The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets.
   */
  IVS_1_OPEN_MARKETS,

  /**
   * Matrix Transaction Type of JAPAN CORPORATE.
   */
  JAPAN_CORPORATE,

  /**
   * Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
   */
  JAPAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of JAPAN SOVEREIGN.
   */
  JAPAN_SOVEREIGN,

  /**
   * Matrix Transaction Type of LATIN AMERICA CORPORATE.
   */
  LATIN_AMERICA_CORPORATE,

  /**
   * Matrix Transaction Type of LATIN AMERICA CORPORATE B.
   */
  LATIN_AMERICA_CORPORATE_BOND,

  /**
   * Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
   */
  LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,

  /**
   * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
   */
  LATIN_AMERICA_FINANCIAL_CORPORATE_BOND,

  /**
   * Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
   */
  LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN,

  /**
   * Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
   */
  LATIN_AMERICA_SOVEREIGN,

  /**
   * Matrix Transaction Type of NEW ZEALAND CORPORATE.
   */
  NEW_ZEALAND_CORPORATE,

  /**
   * Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
   */
  NEW_ZEALAND_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
   */
  NEW_ZEALAND_SOVEREIGN,

  /**
   * Matrix Transaction Type of NORTH AMERICAN CORPORATE.
   */
  NORTH_AMERICAN_CORPORATE,

  /**
   * Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
   */
  NORTH_AMERICAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of SINGAPORE CORPORATE.
   */
  SINGAPORE_CORPORATE,

  /**
   * Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
   */
  SINGAPORE_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of SINGAPORE SOVEREIGN.
   */
  SINGAPORE_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD ASIA CORPORATE.
   */
  STANDARD_ASIA_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
   */
  STANDARD_ASIA_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
   */
  STANDARD_ASIA_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
   */
  STANDARD_AUSTRALIA_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
   */
  STANDARD_AUSTRALIA_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
   */
  STANDARD_AUSTRALIA_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
   */
  STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
   */
  STANDARD_EMERGING_EUROPEAN_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
   */
  STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN,

  /**
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
   */
  STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
   */
  STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN,

  /**
   * Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
   */
  STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
   */
  STANDARD_EUROPEAN_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
   */
  STANDARD_EUROPEAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
   */
  STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD JAPAN CORPORATE.
   */
  STANDARD_JAPAN_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
   */
  STANDARD_JAPAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
   */
  STANDARD_JAPAN_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
   */
  STANDARD_LATIN_AMERICA_CORPORATE_BOND,

  /**
   * Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
   */
  STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,

  /**
   * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
   */
  STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND,

  /**
   * Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
   */
  STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN,

  /**
   * Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
   */
  STANDARD_LATIN_AMERICA_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
   */
  STANDARD_NEW_ZEALAND_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
   */
  STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
   */
  STANDARD_NEW_ZEALAND_SOVEREIGN,

  /**
   * Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
   */
  STANDARD_NORTH_AMERICAN_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
   */
  STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
   */
  STANDARD_SINGAPORE_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
   */
  STANDARD_SINGAPORE_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
   */
  STANDARD_SINGAPORE_SOVEREIGN,

  /**
   * Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
   */
  STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
   */
  STANDARD_SUKUK_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
   */
  STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT,

  /**
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
   */
  STANDARD_US_MUNICIPAL_GENERAL_FUND,

  /**
   * Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
   */
  STANDARD_US_MUNICIPAL_REVENUE,

  /**
   * Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
   */
  STANDARD_WESTERN_EUROPEAN_SOVEREIGN,

  /**
   * Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
   */
  SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,

  /**
   * Matrix Transaction Type of SUKUK CORPORATE.
   */
  SUKUK_CORPORATE,

  /**
   * Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
   */
  SUKUK_FINANCIAL_CORPORATE,

  /**
   * Matrix Transaction Type of SUKUK SOVEREIGN.
   */
  SUKUK_SOVEREIGN,

  /**
   * Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
   */
  US_MUNICIPAL_FULL_FAITH_AND_CREDIT,

  /**
   * Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
   */
  US_MUNICIPAL_GENERAL_FUND,

  /**
   * Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
   */
  US_MUNICIPAL_REVENUE,

  /**
   * Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
   */
  WESTERN_EUROPEAN_SOVEREIGN
}
/**
 * The enumerated values to specify the identification the form of applicable matrix.
 */
export enum MatrixTypeEnum {

  /**
   * The ISDA-published Credit Derivatives Physical Settlement Matrix.
   */
  CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX,

  /**
   * The ISDA-published Equity Derivatives Matrix.
   */
  EQUITY_DERIVATIVES_MATRIX,

  /**
   * The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions.
   */
  SETTLEMENT_MATRIX
}
/**
 * Represents an enumeration list to identify the Maturity.
 */
export enum MaturityTypeEnum {

  /**
   * Denotes a period from issuance date until now.
   */
  FROM_ISSUANCE,

  /**
   * Denotes a period from issuance until maturity date.
   */
  ORIGINAL_MATURITY,

  /**
   * Denotes a period from now until maturity date.
   */
  REMAINING_MATURITY
}
export enum MoneyMarketTypeEnum {

  CERTIFICATE_OF_DEPOSIT,

  COMMERCIAL_PAPER
}
/**
 * Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
 */
export enum NationalizationOrInsolvencyOrDelistingEventEnum {

  /**
   * The trade is terminated.
   */
  CANCELLATION_AND_PAYMENT,

  /**
   * The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
   */
  NEGOTIATED_CLOSEOUT
}
/**
 * The enumerated values for the natural person's role.
 */
export enum NaturalPersonRoleEnum {

  /**
   * The person who arranged with a client to execute the trade.
   */
  BROKER,

  /**
   * Acquirer of the legal title to the financial instrument.
   */
  BUYER,

  /**
   * The party or person with legal responsibility for authorization of the execution of the transaction.
   */
  DECISION_MAKER,

  /**
   * Person within the firm who is responsible for execution of the transaction.
   */
  EXECUTION_WITHIN_FIRM,

  /**
   * Person who is responsible for making the investment decision.
   */
  INVESTMENT_DECISION_MAKER,

  /**
   * Seller of the legal title to the financial instrument.
   */
  SELLER,

  /**
   * The person who executed the trade.
   */
  TRADER
}
/**
 * The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 */
export enum NegativeInterestRateTreatmentEnum {

  /**
   * Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c).
   */
  NEGATIVE_INTEREST_RATE_METHOD,

  /**
   * Per 2021 ISDA Definitions section 6.8.6
   */
  ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD,

  /**
   * Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e).
   */
  ZERO_INTEREST_RATE_METHOD
}
/**
 * The enumerated values to specify the treatment of Non-Cash Dividends.
 */
export enum NonCashDividendTreatmentEnum {

  /**
   * Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
   */
  CASH_EQUIVALENT,

  /**
   * The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
   */
  POTENTIAL_ADJUSTMENT_EVENT
}
/**
 * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
 */
export enum NotionalAdjustmentEnum {

  /**
   * The adjustments to the number of units are governed by an execution clause.
   */
  EXECUTION,

  /**
   * The adjustments to the number of units are governed by a portfolio rebalancing clause.
   */
  PORTFOLIO_REBALANCING,

  /**
   * The adjustments to the number of units are not governed by any specific clause.
   */
  STANDARD
}
/**
 * The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply.
 */
export enum ObligationCategoryEnum {

  /**
   * ISDA term 'Bond'.
   */
  BOND,

  /**
   * ISDA term 'Bond or Loan'.
   */
  BOND_OR_LOAN,

  /**
   * ISDA term 'Borrowed Money'.
   */
  BORROWED_MONEY,

  /**
   * ISDA term 'Loan'.
   */
  LOAN,

  /**
   * ISDA term 'Payment'.
   */
  PAYMENT,

  /**
   * ISDA term 'Reference Obligations Only'.
   */
  REFERENCE_OBLIGATIONS_ONLY
}
/**
 * The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 */
export enum ObservationPeriodDatesEnum {

  /**
   * Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
   */
  FIXING_DATE,

  /**
   * Calculations occur relative to the first day of a calculation period.
   */
  SET_IN_ADVANCE,

  /**
   * Calculations occur relative to the last day of a calculation period (set in arrears).
   */
  STANDARD
}
/**
 * The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
 */
export enum OptionExerciseStyleEnum {

  /**
   * Continuous exercise over a range of dates
   */
  AMERICAN,

  /**
   * Multiple specified exercise dates
   */
  BERMUDA,

  /**
   * Single Exercise
   */
  EUROPEAN
}
/**
 * The enumerated values to specify the type or strategy of the option.
 */
export enum OptionTypeEnum {

  /**
   * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
   */
  CALL,

  /**
   * A 'payer' option: If you buy a 'payer' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price payer and receive float.
   */
  PAYER,

  /**
   * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
   */
  PUT,

  /**
   * A 'receiver' option: If you buy a 'receiver' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price receiver and pay float.
   */
  RECEIVER,

  /**
   * A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
   */
  STRADDLE
}
/**
 * The enumerated values to specify how a calculation agent will be determined.
 */
export enum PartyDeterminationEnum {

  /**
   * The Calculation Agent is determined by reference to the relevant master agreement.
   */
  AS_SPECIFIED_IN_MASTER_AGREEMENT,

  /**
   * The Calculation Agent is determined by reference to the relevant standard terms supplement.
   */
  AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT,

  /**
   * Both parties with joined rights to be a calculation agent.
   */
  BOTH,

  /**
   * The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d).
   */
  EXERCISING_PARTY,

  /**
   * The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e).
   */
  NON_EXERCISING_PARTY
}
/**
 * The enumeration values associated with party identifier sources.
 */
export enum PartyIdentifierTypeEnum {

  /**
   * The Bank Identifier Code.
   */
  BIC,

  /**
   * The ISO 17442:2012 Legal Entity Identifier.
   */
  LEI,

  /**
   * The ISO 10383 Market Identifier Code (MIC).
   */
  MIC
}
/**
 * The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party.
 */
export enum PartyRoleEnum {

  /**
   * Organization responsible for preparing the accounting for the trade.
   */
  ACCOUNTANT,

  /**
   * An agent who lends securities of its principals under stock lending arrangements.
   */
  AGENT_LENDER,

  /**
   * The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations.
   */
  ALLOCATION_AGENT,

  /**
   * The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent.
   */
  ARRANGING_BROKER,

  /**
   * The party specified in the related confirmation as Barrier Determination Agent.
   */
  BARRIER_DETERMINATION_AGENT,

  /**
   * The party that lends out securities under stock lending arrangements via an Agent Lender.
   */
  BENEFICIAL_OWNER,

  /**
   * Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of 'Beneficiary' at the partyTradeInformation level.
   */
  BENEFICIARY,

  /**
   * The entity for which the organization supporting the trade's processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn't need to be reported but a firm still wants to specify their own side.
   */
  BOOKING_PARTY,

  /**
   * The party that borrows securities under stock lending arrangements.
   */
  BORROWER,

  /**
   * Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the 'Buy side'; for that, see the 'Client' role. Corresponds to 'Buyer' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9.
   */
  BUYER,

  /**
   * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to 'buyer decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Buy side'; for that, see the 'Client Decision Maker' role.
   */
  BUYER_DECISION_MAKER,

  /**
   * The party that provides credit support under English Law.
   */
  CHARGOR,

  /**
   * An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term 'client' refers to the organization's role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process.
   */
  CLEARING_CLIENT,

  /**
   * A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions.
   */
  CLEARING_EXCEPTION_PARTY,

  /**
   * Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use 'Clearing Broker' as synonym.
   */
  CLEARING_FIRM,

  /**
   * The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called 'ClearingService'. Some implementations also use the term 'Clearer'.
   */
  CLEARING_ORGANIZATION,

  /**
   * Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances.
   */
  CLIENT,

  /**
   * The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument.
   */
  CLIENT_DECISION_MAKER,

  /**
   * Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data.
   */
  CONFIRMATION_PLATFORM,

  /**
   * A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
   */
  CONTRACTUAL_PARTY,

  /**
   * Organization officially attached to the counterparty. e.g. partner, branch, subsidiary.
   */
  COUNTER_PARTY_AFFILIATE,

  /**
   * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
   */
  COUNTER_PARTY_ULTIMATE_PARENT,

  /**
   * An economic counterparty to the trade. Synonym: principal.
   */
  COUNTERPARTY,

  /**
   * Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation).
   */
  CREDIT_SUPPORT_PROVIDER,

  /**
   * Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal.
   */
  CUSTODIAN,

  /**
   * Entity submitting the transaction report to the competent authority.
   */
  DATA_SUBMITTER,

  /**
   * The party referenced is specified in the contract confirmation as Determination Party.
   */
  DETERMINING_PARTY,

  /**
   * Organization that is disputing the trade or transaction.
   */
  DISPUTING_PARTY,

  /**
   * A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
   */
  DOCUMENT_REPOSITORY,

  /**
   * The (generally sell-side) organization that executed the trade; the price-making party.
   */
  EXECUTING_BROKER,

  /**
   * Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent.
   */
  EXECUTING_ENTITY,

  /**
   * The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different.
   */
  EXECUTION_AGENT,

  /**
   * The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue.
   */
  EXECUTION_FACILITY,

  /**
   * Organization that backs (guarantees) the credit risk of the trade.
   */
  GUARANTOR,

  /**
   * The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract.
   */
  HEDGING_PARTY,

  /**
   * The party that lends out securities under stock lending arrangements as principal.
   */
  LENDER,

  /**
   * The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm.
   */
  ORDER_TRANSMITTER,

  /**
   * The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR
   */
  PTRR_SERVICE_PROVIDER,

  /**
   * The party that provides credit support under New York Law.
   */
  PLEDGOR,

  /**
   * The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism).
   */
  PRIME_BROKER,

  /**
   * The trade repository at which the trade was reported previous to the current trade repository.
   */
  PRIOR_TRADE_REPOSITORY,

  /**
   * The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade.
   */
  PUBLICATION_VENUE,

  /**
   * The party with the regulatory responsibility to report this trade.
   */
  REPORTING_PARTY,

  /**
   * Organization officially attached to the reporting party  e.g. partner, branch, subsidiary.
   */
  REPORTING_PARTY_AFFILIATE,

  /**
   * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
   */
  REPORTING_PARTY_ULTIMATE_PARENT,

  /**
   * The party that receives credit support under New York or English Law.
   */
  SECURED_PARTY,

  /**
   * A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the 'Sell side'; for that, see the 'Executing Broker' role. Corresponds to 'Seller' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16.
   */
  SELLER,

  /**
   * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to 'seller decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Sell side'; for that, see the 'Trader' person role.
   */
  SELLER_DECISION_MAKER,

  /**
   * The organization that makes or receives payments on behalf of the given principal party.
   */
  SETTLEMENT_AGENT,

  /**
   * A third-party providing custody, settlement, segregation and reporting services.
   */
  THIRD_PARTY_CUSTODIAN,

  /**
   * An organization that maintains records of the trade for regulatory reporting purposes.
   */
  TRADE_REPOSITORY,

  /**
   * The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR.
   */
  TRADE_SOURCE,

  /**
   * The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory.
   */
  TRADING_MANAGER,

  /**
   * An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions.
   */
  TRADING_PARTNER,

  /**
   * A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services.
   */
  TRIPARTY_AGENT
}
/**
 * The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date.
 */
export enum PayRelativeToEnum {

  /**
   * Payments will occur relative to the last day of each calculation period.
   */
  CALCULATION_PERIOD_END_DATE,

  /**
   * Payments will occur relative to the first day of each calculation period.
   */
  CALCULATION_PERIOD_START_DATE,

  /**
   * Payments will occur relative to the last Pricing Date of each Calculation Period.
   */
  LAST_PRICING_DATE,

  /**
   * Payments will occur relative to the reset date.
   */
  RESET_DATE,

  /**
   * Payments will occur relative to the valuation date.
   */
  VALUATION_DATE
}
/**
 * The enumerated values to specify an interest rate stream payer or receiver party.
 */
export enum PayerReceiverEnum {

  /**
   * The party identified as the stream payer.
   */
  PAYER,

  /**
   * The party identified as the stream receiver.
   */
  RECEIVER
}
/**
 * The enumerated values to specify the origin of a performance transfer
 */
export enum PerformanceTransferTypeEnum {

  COMMODITY,

  CORRELATION,

  DIVIDEND,

  EQUITY,

  INTEREST,

  VARIANCE,

  VOLATILITY
}
/**
 * The enumerated values to specify the period, e.g. day, week.
 */
export enum PeriodEnum {

  /**
   * Day
   */
  D,

  /**
   * Month
   */
  M,

  /**
   * Week
   */
  W,

  /**
   * Year
   */
  Y
}
/**
 * The enumerated values to specify a time period containing the additional value of Term.
 */
export enum PeriodExtendedEnum {

  /**
   * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
   */
  C,

  /**
   * Day
   */
  D,

  /**
   * Hour
   */
  H,

  /**
   * Month
   */
  M,

  /**
   * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
   */
  T,

  /**
   * Week
   */
  W,

  /**
   * Year
   */
  Y
}
/**
 * The enumeration values to specify a time period containing additional values such as Term.
 */
export enum PeriodTimeEnum {

  /**
   * Period measured in hours.
   */
  HOUR,

  /**
   * Period measured in minutes.
   */
  MINUTE,

  /**
   * Period measured in seconds.
   */
  SECOND
}
/**
 * The enumeration values associated with person identifier sources.
 */
export enum PersonIdentifierTypeEnum {

  /**
   * Alien Registration Number, number assigned by a social security agency to identify a non-resident person.
   */
  ARNU,

  /**
   * Passport Number, number assigned by an authority to identify the passport number of a person.
   */
  CCPT,

  /**
   * Customer Identification Number, number assigned by an issuer to identify a customer.
   */
  CUST,

  /**
   * Drivers License Number, number assigned by an authority to identify a driver's license.
   */
  DRLC,

  /**
   * Employee Identification Number, number assigned by a registration authority to an employee.
   */
  EMPL,

  /**
   * National Identity Number, number assigned by an authority to identify the national identity number of a person..
   */
  NIDN,

  /**
   * Natural Person Identifier. To identify the person who is acting as private individual, not as business entity. Used for regulatory reporting.
   */
  NPID,

  /**
   * Privacy Law Identifier. It refers to the DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
   */
  PLID,

  /**
   * Social Security Number, number assigned by an authority to identify the social security number of a person.
   */
  SOSE,

  /**
   * Tax Identification Number, number assigned by a tax authority to identify a person.
   */
  TXID
}
export enum PositionEventIntentEnum {

  /**
   * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
   */
  CORPORATE_ACTION_ADJUSTMENT,

  /**
   * The intent is to Decrease the quantity of the position.
   */
  DECREASE,

  /**
   * The intent is to Increase the quantity of the position.
   */
  INCREASE,

  /**
   * The intent is to Exercise a position or part of a position.
   */
  OPTION_EXERCISE,

  /**
   * The intent is to form a position from a fully formed contract.
   */
  POSITION_CREATION,

  /**
   * The intent is to transfer the position to another clearing member.
   */
  TRANSFER,

  /**
   * The intent is to update the valuation of the position.
   */
  VALUATION
}
/**
 * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
 */
export enum PositionStatusEnum {

  /**
   * The position has been cancelled, in case of a cancellation event following an execution.
   */
  CANCELLED,

  /**
   * The position has been closed, in case of a termination event.
   */
  CLOSED,

  /**
   * The position has been executed, which is the point at which risk has been transferred.
   */
  EXECUTED,

  /**
   * Contract has been formed, in case position is on a contractual product.
   */
  FORMED,

  /**
   * The position has settled, in case product is subject to settlement after execution, such as securities.
   */
  SETTLED
}
/**
 * The enumerated values to specify the premium type for forward start options.
 */
export enum PremiumTypeEnum {

  FIXED,

  POST_PAID,

  PRE_PAID,

  VARIABLE
}
/**
 * Enumerated values to specify whether the price is expressed in absolute or relative terms.
 */
export enum PriceExpressionEnum {

  /**
   * The price is expressed as an absolute amount.
   */
  ABSOLUTE_TERMS,

  /**
   * Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
   */
  PAR_VALUE_FRACTION,

  /**
   * Denotes a price expressed per number of options.
   */
  PER_OPTION,

  /**
   * The price is expressed in percentage of the notional amount.
   */
  PERCENTAGE_OF_NOTIONAL
}
export enum PriceOperandEnum {

  ACCRUED_INTEREST,

  COMMISSION,

  FORWARD_POINT
}
export enum PriceTimingEnum {

  /**
   * The last price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
   */
  CLOSING_PRICE,

  /**
   * The first price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
   */
  OPENING_PRICE
}
/**
 * Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations.
 */
export enum PriceTypeEnum {

  /**
   * Denotes a price expressed as a cash amount in a given currency to purchase a unit of an asset (e.g. a security or a commodity).
   */
  ASSET_PRICE,

  /**
   * Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500.
   */
  CASH_PRICE,

  /**
   * Denotes a price expressed as the weighted average of all pairwise correlation coefficients.
   */
  CORRELATION,

  /**
   * Denotes a price expressed as the dividend payment from a index or share.
   */
  DIVIDEND,

  /**
   * Denotes a rate to convert one currency or other measure of value to another. Foreign Exchange rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP.
   */
  EXCHANGE_RATE,

  /**
   * Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount.
   */
  INTEREST_RATE,

  /**
   * Denotes a price expressed as the the arithmetic average of the squared differences from the mean value of an observable price.
   */
  VARIANCE,

  /**
   * Denotes a price expressed as the the square root of the arithmetic average of the squared differences from the mean value of an observable price.
   */
  VOLATILITY
}
/**
 * Provides the enumerated values to specify the product identifier source.
 */
export enum ProductIdTypeEnum {

  /**
   * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
   */
  BBGID,

  /**
   * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
   */
  BBGTICKER,

  /**
   * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
   */
  CUSIP,

  /**
   * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
   */
  FIGI,

  /**
   * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
   */
  ISDACRP,

  /**
   * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
   */
  ISIN,

  /**
   * The name of the product.
   */
  NAME,

  /**
   * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
   */
  OTHER,

  /**
   * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
   */
  RIC,

  /**
   * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security's ISIN as well.
   */
  SEDOL,

  /**
   * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
   */
  SICOVAM,

  /**
   * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
   */
  UPI,

  /**
   * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
   */
  WERTPAPIER
}
/**
 * The enumerated values to specify the types of listed derivative options.
 */
export enum PutCallEnum {

  /**
   * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
   */
  CALL,

  /**
   * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
   */
  PUT
}
/**
 * Represents the enumerated values to specify a logical quantification, i.e. either All or Any.
 */
export enum QuantifierEnum {

  /**
   * Specifies that the condition in the scope of the quantifier is true of every member of the domain i.e. every one of the elements in scope.
   */
  ALL,

  /**
   * Specifies that the condition in the scope of the quantifier is true of at least one member of the domain i.e. one or more of the elements in scope.
   */
  ANY
}
/**
 * Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number.
 */
export enum QuantityChangeDirectionEnum {

  /**
   * When the quantity should go down by the specified amount.
   */
  DECREASE,

  /**
   * When the quantity should go up by the specified amount.
   */
  INCREASE,

  /**
   * When the quantity should be replaced by the specified amount.
   */
  REPLACE
}
/**
 * The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
 */
export enum QuotationRateTypeEnum {

  /**
   * An ask rate.
   */
  ASK,

  /**
   * A bid rate.
   */
  BID,

  /**
   * If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
   */
  EXERCISING_PARTY_PAYS,

  /**
   * A mid-market rate.
   */
  MID
}
/**
 * The enumerated values to specify the side from which perspective a value is quoted.
 */
export enum QuotationSideEnum {

  /**
   * Denotes a value as the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  AFTERNOON,

  /**
   * Denotes a value 'asked' by a seller for an asset, i.e. the value at which a seller is willing to sell.
   */
  ASK,

  /**
   * Denotes a value 'bid' by a buyer for an asset, i.e. the value a buyer is willing to pay.
   */
  BID,

  /**
   * Denotes a value as the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  CLOSING,

  /**
   * Denotes a value as the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  HIGH,

  /**
   * Denotes a value as the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  INDEX,

  /**
   * Denotes a value as the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  LOCATIONAL_MARGINAL,

  /**
   * Denotes a value as the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  LOW,

  /**
   * Denotes a value as the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MARGINAL_HOURLY,

  /**
   * Denotes a value as the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MARKET_CLEARING,

  /**
   * Denotes a value as the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MEAN_OF_BID_AND_ASK,

  /**
   * Denotes a value as the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MEAN_OF_HIGH_AND_LOW,

  /**
   * Denotes a value as the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MID,

  /**
   * Denotes a value as the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  MORNING,

  /**
   * Denotes a value as the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  NATIONAL_SINGLE,

  /**
   * Denotes a value as the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  OSP,

  /**
   * Denotes a value as the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  OFFICIAL,

  /**
   * Denotes a value as the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  OPENING,

  /**
   * Denotes a value as the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  SETTLEMENT,

  /**
   * Denotes a value as the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
   */
  SPOT,

  /**
   * Denotes a value as the Non-volume Weighted Average of prices effective on the Pricing Date.
   */
  UN_WEIGHTED_AVERAGE,

  /**
   * Denotes a value as the Volume Weighted Average of prices effective on the Pricing Date.
   */
  WEIGHTED_AVERAGE
}
/**
 * The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
 */
export enum QuotationStyleEnum {

  /**
   * When quotation style is 'PointsUpFront', the initialPoints element of the Credit Default Swap feeLeg should be populated
   */
  POINTS_UP_FRONT,

  /**
   * When quotation style is 'Price', the marketPrice element of the Credit Default Swap feeLeg should be populated
   */
  PRICE,

  /**
   * When quotation style is 'TradedSpread', the marketFixedRate element of the Credit Default Swap feeLeg should be populated
   */
  TRADED_SPREAD
}
/**
 * The enumerated values to specify how an exchange rate is quoted.
 */
export enum QuoteBasisEnum {

  /**
   * The amount of currency1 for one unit of currency2
   */
  CURRENCY_1_PER_CURRENCY_2,

  /**
   * The amount of currency2 for one unit of currency1
   */
  CURRENCY_2_PER_CURRENCY_1
}
/**
 * The enumerated values to specify the methods for converting rates from one basis to another.
 */
export enum RateTreatmentEnum {

  /**
   * Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g).
   */
  BOND_EQUIVALENT_YIELD,

  /**
   * Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h).
   */
  MONEY_MARKET_YIELD
}
/**
 * Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to 'Issuer', the rating in the 
 Issuer Criteria has priority or is used if there is no Asset criteria. If set to 'Asset', the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
 */
export enum RatingPriorityResolutionEnum {

  /**
   * Denotes that the Asset Criteria has priority.
   */
  ASSET,

  /**
   * Denotes that average rating should be used if several criteria apply.
   */
  AVERAGE,

  /**
   * Denotes that highest rating should be used if several criteria apply.
   */
  HIGHEST,

  /**
   * Denotes that the Issuer Criteria has priority.
   */
  ISSUER,

  /**
   * Denotes that lowest rating should be used if several criteria apply.
   */
  LOWEST
}
/**
 * The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors.
 */
export enum RealisedVarianceMethodEnum {

  /**
   * For a return on day T, the observed prices on both T and T-1 must be in range
   */
  BOTH,

  /**
   * For a return on day T, the observed price on T must be in range.
   */
  LAST,

  /**
   * For a return on day T, the observed price on T-1 must be in range.
   */
  PREVIOUS
}
/**
 * The enumeration of the account level for the billing summary.
 */
export enum RecordAmountTypeEnum {

  ACCOUNT_TOTAL,

  GRAND_TOTAL,

  PARENT_TOTAL
}
/**
 * Represents the enumeration values to specify the role of the party in relation to a regulatory initial margin call.
 */
export enum RegIMRoleEnum {

  /**
   * Indicates 'Pledgor' party of initial margin call.
   */
  PLEDGOR,

  /**
   * Indicates 'Secured' party of initial margin call.
   */
  SECURED
}
/**
 * Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation.
 */
export enum RegMarginTypeEnum {

  /**
   * Indicates Non Regulatory Initial margin or independent amount
   */
  NON_REG_IM,

  /**
   * Indicates Regulatory Initial Margin
   */
  REG_IM,

  /**
   * Indicates Variation Margin
   */
  VM
}
/**
 * A duration code for a Repo (or Securities Lending) transaction. There are many business and market rules that are derived from the duration of the transaction.
 */
export enum RepoDurationEnum {

  /**
   * Indicates that a contract is classified as overnight, meaning that there is one business day difference between the start and end date of the contract. Business rule: When the repo is overnight, the number of business days between the spot and forward value dates must be one. Forward leg must be specified.
   */
  OVERNIGHT,

  /**
   * Indicates that a contract is a regular term contract, with a start date and an end date. Business rule: When the repo is 'Term', both spot and forward legs must be specified.
   */
  TERM
}
/**
 * The enumerated values to specify whether resets occur relative to the first or last day of a calculation period.
 */
export enum ResetRelativeToEnum {

  /**
   * Resets occur relative to the last day of a calculation period.
   */
  CALCULATION_PERIOD_END_DATE,

  /**
   * Resets occur relative to the first day of a calculation period.
   */
  CALCULATION_PERIOD_START_DATE
}
/**
 * The enumerated values to specify the type of a resource (e.g. document).
 */
export enum ResourceTypeEnum {

  /**
   * Document describing the legal terms of a transaction.
   */
  CONFIRMATION,

  /**
   * Document providing supplemental material economic terms to the FpML data representation. The initial intended usage is to fulfill the CFTC Part 45 rule requirement to report ‘Any other terms(s) of the swap matched or affirmed by the counterparties in verifying the swap’ when the reporting is done via the generic FpML representation.
   */
  SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS,

  /**
   * Document describing the economic characteristics of a transaction.
   */
  TERM_SHEET
}
/**
 * The enumerated values to specify the form of the restructuring credit event that is applicable to the credit default swap.
 */
export enum RestructuringEnum {

  /**
   * Restructuring (Section 4.7) and Modified Restructuring Maturity Limitation and Conditionally Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
   */
  MOD_MOD_R,

  /**
   * Restructuring (Section 4.7) and Restructuring Maturity Limitation and Fully Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
   */
  MOD_R,

  /**
   * Restructuring as defined in the applicable ISDA Credit Derivatives Definitions. (2003 or 2014).
   */
  R
}
/**
 * The enumerated values to specify the type of return associated the equity payout.
 */
export enum ReturnTypeEnum {

  /**
   * Price return, i.e. excluding dividends.
   */
  PRICE,

  /**
   * Total return, i.e. including dividend and price components.
   */
  TOTAL
}
/**
 * The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month.
 */
export enum RollConventionEnum {

  /**
   * Rolls on month end dates irrespective of the length of the month and the previous roll day.
   */
  EOM,

  /**
   * Rolling weekly on a Friday
   */
  FRI,

  /**
   * Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions.
   */
  FRN,

  /**
   * IMM Settlement Dates. The third Wednesday of the (delivery) month.
   */
  IMM,

  /**
   * The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement.
   */
  IMMAUD,

  /**
   * The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers' Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification.
   */
  IMMCAD,

  /**
   * The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month.
   */
  IMMNZD,

  /**
   * Rolling weekly on a Monday.
   */
  MON,

  /**
   * The roll convention is not required. For example, in the case of a daily calculation frequency.
   */
  NONE,

  /**
   * Rolling weekly on a Saturday
   */
  SAT,

  /**
   * Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month
   */
  SFE,

  /**
   * Rolling weekly on a Sunday
   */
  SUN,

  /**
   * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday.
   */
  TBILL,

  /**
   * Rolling weekly on a Thursday
   */
  THU,

  /**
   * Rolling weekly on a Tuesday
   */
  TUE,

  /**
   * Rolling weekly on a Wednesday
   */
  WED,

  /**
   * Rolls on the 1st day of the month.
   */
  _1,

  /**
   * Rolls on the 10th day of the month.
   */
  _10,

  /**
   * Rolls on the 11th day of the month.
   */
  _11,

  /**
   * Rolls on the 12th day of the month.
   */
  _12,

  /**
   * Rolls on the 13th day of the month.
   */
  _13,

  /**
   * Rolls on the 14th day of the month.
   */
  _14,

  /**
   * Rolls on the 15th day of the month.
   */
  _15,

  /**
   * Rolls on the 16th day of the month.
   */
  _16,

  /**
   * Rolls on the 17th day of the month.
   */
  _17,

  /**
   * Rolls on the 18th day of the month.
   */
  _18,

  /**
   * Rolls on the 19th day of the month.
   */
  _19,

  /**
   * Rolls on the 2nd day of the month.
   */
  _2,

  /**
   * Rolls on the 20th day of the month.
   */
  _20,

  /**
   * Rolls on the 21st day of the month.
   */
  _21,

  /**
   * Rolls on the 22nd day of the month.
   */
  _22,

  /**
   * Rolls on the 23rd day of the month.
   */
  _23,

  /**
   * Rolls on the 24th day of the month.
   */
  _24,

  /**
   * Rolls on the 25th day of the month.
   */
  _25,

  /**
   * Rolls on the 26th day of the month.
   */
  _26,

  /**
   * Rolls on the 27th day of the month.
   */
  _27,

  /**
   * Rolls on the 28th day of the month.
   */
  _28,

  /**
   * Rolls on the 29th day of the month.
   */
  _29,

  /**
   * Rolls on the 3rd day of the month.
   */
  _3,

  /**
   * Rolls on the 30th day of the month.
   */
  _30,

  /**
   * Rolls on the 4th day of the month.
   */
  _4,

  /**
   * Rolls on the 5th day of the month.
   */
  _5,

  /**
   * Rolls on the 6th day of the month.
   */
  _6,

  /**
   * Rolls on the 7th day of the month.
   */
  _7,

  /**
   * Rolls on the 8th day of the month.
   */
  _8,

  /**
   * Rolls on the 9th day of the month.
   */
  _9
}
/**
 * Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
 */
export enum RollSourceCalendarEnum {

  FUTURE,

  LISTED_OPTION
}
/**
 * The enumerated values to specify the rounding direction and precision to be used in the rounding of a number.  Used by function cdm.base.math.RoundToPrecision.
 */
export enum RoundingDirectionEnum {

  /**
   * A fractional number will be rounded down to the specified number of decimal places (the precision). For example, 5.29 and 5.25 rounded down to 1 decimal place are 5.2 and 5.2 respectively.
   */
  DOWN,

  /**
   * A fractional number will be rounded either up or down to the specified number of decimal places (the precision) depending on its value. For example, 5.24 would be rounded down to 5.2 and 5.25 would be rounded up to 5.3 if a precision of 1 decimal place were specified.
   */
  NEAREST,

  /**
   * A fractional number will be rounded up to the specified number of decimal places (the precision). For example, 5.21 and 5.25 rounded up to 1 decimal place are 5.3 and 5.3 respectively.
   */
  UP
}
/**
 * How often is rounding performed
 */
export enum RoundingFrequencyEnum {

  /**
   * Rounding is done on each day
   */
  DAILY,

  /**
   * Rounding is done only at the end of the period
   */
  PERIOD_END
}
/**
 * The enumerated values to specify the rounding direction when rounding of a number to nearest.  Used by function cdm.base.math.RoundToNearest.
 */
export enum RoundingModeEnum {

  /**
   * A number will be rounded down to the specified nearest number. For example, 529 rounded down to the nearest 10 is 520.
   */
  DOWN,

  /**
   * A number will be rounded up to the specified nearest number. For example, 521 rounded up to the nearest 10 is 530.
   */
  UP
}
/**
 * The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events.
 */
export enum ScheduledTransferEnum {

  /**
   * A cash flow corresponding to a corporate action event.
   */
  CORPORATE_ACTION,

  /**
   * A cash flow corresponding to the periodic accrued interests.
   */
  COUPON,

  /**
   * A cashflow resulting from a credit event.
   */
  CREDIT_EVENT,

  /**
   * A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument.
   */
  DIVIDEND_RETURN,

  /**
   * A cash flow associated with an exercise lifecycle event.
   */
  EXERCISE,

  /**
   * A cash flow corresponding to the return of the fixed interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
   */
  FIXED_RATE_RETURN,

  /**
   * A cash flow corresponding to the return of the floating interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
   */
  FLOATING_RATE_RETURN,

  /**
   * A cash flow corresponding to the compensation for missing assets due to the rounding of digits in the original number of assets to be delivered as per payout calculation.
   */
  FRACTIONAL_AMOUNT,

  /**
   * A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
   */
  INTEREST_RETURN,

  /**
   * Net interest across payout components. Applicable to products such as interest rate swaps.
   */
  NET_INTEREST,

  /**
   * A cash flow corresponding to a performance return.  The settlementOrigin attribute on the Transfer should point to the relevant Payout defining the performance calculation.
   */
  PERFORMANCE,

  /**
   * A cashflow which amount typically corresponds to the notional amount of the contract for various business reasons e.g. PhysicalSettlement, PrincipalExchange etc. else to a portion of the notional amount interim payments e.g. for the purpose of resetting the Notional Amount of a Cross Currency Swap variying leg, as part of a final Principal Exchange related to a Non-Deliverable currency leg, etc.
   */
  PRINCIPAL_PAYMENT
}
/**
 * The enumerated values to specify the relevant settled entity matrix source.
 */
export enum SettledEntityMatrixSourceEnum {

  /**
   * The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation.
   */
  CONFIRMATION_ANNEX,

  /**
   * The term is not applicable.
   */
  NOT_APPLICABLE,

  /**
   * The Settled Entity Matrix published by the Index Publisher.
   */
  PUBLISHER
}
/**
 * Defines the settlement centre for a securities transaction.
 */
export enum SettlementCentreEnum {

  /**
   * ClearStream Banking Luxembourg
   */
  CLEARSTREAM_BANKING_LUXEMBOURG,

  /**
   * Euroclear Bank
   */
  EUROCLEAR_BANK
}
/**
 * The enumerated values to specify the settlement rate options as specified in the Annex A to the 1998 FX and Currency Options Definitions.
 */
export enum SettlementRateOptionEnum {

  /**
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Buenos Aires and New York) which appears on the Reuters Screen BNAR Page at the close of business in Buenos Aires on that Rate Calculation Date.
   */
  ARS_BNAR_ARS01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Indicative Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Argentine Peso/U.S. Dollar markets for the purpose of determining the EMTA ARS Indicative Survey Rate).
   */
  ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Industry Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions in Buenos Aires that are active participants in the Argentine Peso/U.S. Dollar spot markets for the purpose of determining the EMTA ARS Industry Survey Rate).
   */
  ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the volume weighted average Argentine Peso/U.S. Dollar Rate of all trades executed in the electronic market for a Rate Calculation Day expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, reported by the Mercado Abierto Electronico (the 'MAE') at approximately 3:00 pm, Buenos Aires time, and published on the FOREX-MAE Page as the 'PPN' rate ('Promedio Ponderado Noticiado') on www.mae.com.ar on that Rate Calculation Date.
   */
  ARS_MAE_ARS05,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day quoted by Banco de la Nacion (in accordance with the Convertibility Law of March 27, 1991 and Regulatory Decree No. 529/91 of April 1, 1991, as may be amended from time to time) for that Rate Calculation Date.
   */
  ARS_OFFICIAL_RATE_ARS02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) which appears on the Reuters Screen BRBY Page under the caption 'INTBK FLTING (LAST)' at approximately 11:00 a.m., Sao Paulo time, on that Rate Calculation Date.
   */
  BRL_BRBY_BRL01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 12:00 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Indicative Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Brazilian Real/U.S. Dollar markets for the purpose of determining the EMTA BRL Indicative Survey Rate).
   */
  BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA's web site (www.emta.org) at approximately 3:45 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Industry Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions in Brazil that are active participants in the Brazilian Real/U.S. Dollar spot markets for the purpose of determining the EMTA BRL Industry Survey Rate).
   */
  BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil in the 'Diario Oficial da Uniao' on the first Business Day following that Rate Calculation Date.
   */
  BRL_OFFICIAL_RATE_BRL02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
   */
  BRL_PCOT_COMMERCIAL_BRL03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
   */
  BRL_PCOT_FLOATING_BRL04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX-800 ('Consulta de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidade' or 'Rates for Accounting Purposes') by approximately 6:00 p.m., Sao Paulo time, on that Rate Calculation Date.
   */
  BRL_PTAX_BRL09,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date. 23
   */
  BRL_PTAX_COMMERCIAL_BRFR_BRL06,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'L' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Livre' and commonly known as 'Comercial') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
   */
  BRL_PTAX_COMMERCIAL_BRL05,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on the SISBACEN Data System which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date.
   */
  BRL_PTAX_FLOATING_BRFR_BRL08,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 ('Consultas de Cambio' or Exchange Rate Inquiry), Option 5 ('Cotacoes para Contabilidad' or Rates for Accounting Purposes) market type 'F' (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated 'Flutuante') as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
   */
  BRL_PTAX_FLOATING_BRL07,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen BCCH Page under the caption 'OBSERVADO' at 10:00 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
   */
  CLP_BCCH_CLP01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  CLP_CHILD_INFORMAL_CLP02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  CLP_CHILD_INTERBANK_CLP03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILD Page on the first Business Day following that Rate Calculation Date.
   */
  CLP_CHILD_OBSERVADO_CLP04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  CLP_CHILG_INFORMAL_CLP05,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  CLP_CHILG_INTERBANK_CLP06,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILG Page under 'OBSERVADO' at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
   */
  CLP_CHILG_OBSERVADO_CLP07,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar 'observado' rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Banco Central de Chile (www.bcentral.cl) as the 'Dolar Observado' (Dollar Observado) rate by not later than 10:30 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
   */
  CLP_DOLAR_OBS_CLP10,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Santiago time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA CLP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chilean Peso/U.S. Dollar markets for the purpose of determining the EMTA CLP Indicative Survey Rate).
   */
  CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate, expressed as the amount of Chilean Pesos per one U.S. Dollar (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York), calculated in accordance with Title I, Chapter 1 Number 6 of the Compendium of International Exchange Norms of the Banco Central de Chile and published by the Banco Central de Chile at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
   */
  CLP_OFFICIAL_RATE_CLP08,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Telerate Page 38942 opposite the caption 'Observado' at the Specified Time, if any, on the first Business Day following the Rate Calculation Date.
   */
  CLP_TELERATE_38942_CLP09,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar official fixing rate, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days reported by the People's Bank of China, Beijing, People's Republic of China, which appears on the Reuters Screen 'SAEC' Page opposite the symbol 'USDCNY=' at approximately 9:15 a.m., Beijing time, on that Rate Calculation Date.
   */
  CNY_SAEC_CNY01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC CNY Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chinese Renminbi/U.S. Dollar markets for the purpose of determining the SFEMC CNY Indicative Survey Rate).
   */
  CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day (unless such day is not a Business Day in New York, then for settlement on the first succeeding day that is a Business Day in Bogota and New York) reported by the Colombian Banking Superintendency which appears on the Reuters Screen CO/COL03 Page opposite the caption 'TRCM' ('Tasa de Cierre Representative del Mercado' or closing market price) at 12:00 noon, Bogota time, on the first Business Day following that Rate Calculation Date.
   */
  COP_CO_COL03_COP01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:30 a.m., Bogota time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA COP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Colombian Peso/U.S. Dollar markets for the purpose of determining the EMTA COP Indicative Survey Rate).
   */
  COP_EMTA_INDICATIVE_SURVEY_RATE_COP03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day reported by the Colombian Financial Superintendency (www.banrep.gov.co) as the 'Tasa Representativa del Mercado (TRM)' (also referred to as the 'Tasa de Cambio Representativa del Mercado' (TCRM)) by not later than 10:30 a.m., Bogota time, on the first Business Day following that Rate Calculation Date.
   */
  COP_TRM_COP02,

  /**
   * the Spot Rate for a Rate Calculation Date will be the Reference Currency/U.S. Dollar exchange rate, expressed as the amount of Reference Currency per one U.S. Dollar, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's price of a Specified Company's American Depositary Receipt or American Depositary Receipts (the 'ADR' or 'ADRs', as appropriate) and the price of the local share or shares of such Specified Company of the same type and in the same quantity represented by such ADR or ADRs, as the case may be (the 'Share' or 'Shares', as appropriate). The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of (A) in the case where one ADR represents less than one Share, its bid and offer price (in the Reference Currency) for one Share and its bid and offer price (in U.S. Dollars) for the number of ADRs which represent such Share and (B) in all other cases, its bid and offer price (in the Reference Currency) for the Share or Shares, as the case may be, and its bid and offer price (in U.S. Dollars) for one ADR. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (1) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Share or Shares, as the case may be, and (2) the arithmetic mean of the midpoint of the bid and offer prices quoted in U.S. Dollars by each Reference Dealer for such ADR or ADRs, as the case may be, subject to an adjustment, if any, by the Calculation Agent to reduce the effect of momentary disparities in the prices of the Share or Shares and the ADR or ADRs, as appropriate. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
   */
  CURRENCY_IMPLIED_RATE__ADR__CURA1,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency exchange rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date for that day's price of Local Assets. The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of its bid and offer price (in both the Reference Currency and the Settlement Currency) for an amount of Local Assets whose face value equals the Specified Amount. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (A) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Local Assets and (B) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Settlement Currency by each Reference Dealer for such Local Assets. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
   */
  CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency Specified Rate, expressed as the amount of the Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date agreed upon by the parties on or prior to that Rate Calculation Date (or, if different, the day on which rates for that date would, in the ordinary course, be published or announced).
   */
  CURRENCY_MUTUAL_AGREEMENT_CURA3,

  /**
   * The Spot Rate for a Rate Calculation Date will be determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date. The Calculation Agent will request the Specified Office of each of the Reference Dealers to provide a firm quotation of its Specified Rate for a transaction where the amount of Reference Currency equals the Specified Amount. If four quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates, without regard to the Specified Rates having the highest and lowest value. If exactly three quotations are provided, the rate for a Rate Calculation Date will be the Specified Rate provided by the Reference Dealer that remains after disregarding the Specified Rates having the highest and lowest values. For this purpose, if more than one quotation has the same highest value or lowest value, then the Specified Rate of one of such quotations shall be disregarded. If exactly two quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates. If only one quotation is provided, the rate for a Rate Calculation Date will be the Specified Rate quoted by that Reference Dealer. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on that Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
   */
  CURRENCY_REFERENCE_DEALERS_CURA4,

  /**
   * The Spot Rate for a Rate Calculation Date will be determined by the Calculation Agent on the basis of that day's Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, in a legal and customary wholesale market in which there is no, or minimal, Governmental Authority controls or interference, except as a participant in such market.
   */
  CURRENCY_WHOLESALE_MARKET_CURA5,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Ecuadorian Sucre/U.S. Dollar Specified Rate, expressed as the amount of Ecuadorian Sucres per one U.S. Dollar, for settlement in one Business Day (where such day is a Business Day in Guayaquil and New York) which appears on Reuters Screen DNRP Page at 12:00 noon, Guayaquil time, on that Rate Calculation Date.
   */
  ECS_DNRP_ECS01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'IDR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  IDR_ABS_IDR01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar weighted average spot rate in the interbank market based on traded IDR/USD spot foreign exchange transactions during a specified time period which are captured on a real time basis, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, published by Bank Indonesia at approximately 10:00 a.m., Jakarta time, on that Rate Calculation Date as the Jakarta Interbank Spot Dollar Rate USD - IDR on Bank Indonesia's website or otherwise made available by Bank Indonesia (or its successor as administrator).
   */
  IDR_JISDOR_IDR04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC IDR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indonesian Rupiah/U.S. Dollar markets for the purpose of determining the SFEMC IDR Indicative Survey Rate).
   */
  IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar implied spot rate expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of that rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  IDR_VWAP_IDR03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BOIJ Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
   */
  ILS_BOIJ_ILS01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen FXIL Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
   */
  ILS_FXIL_ILS02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, reported by Financial Benchmarks India Pvt. Ltd. (www.fbil.org.in) at approximately 1:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
   */
  INR_FBIL_INR01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days reported by the Reserve Bank of India which appears on the Reuters Screen RBIB Page at approximately 12:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
   */
  INR_RBIB_INR01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC INR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indian Rupee/U.S. Dollar markets for the purpose of determining the SFEMC INR Indicative Survey Rate).
   */
  INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen KEBEY Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  KRW_KEBEY_KRW01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on the Reuters Screen KFTC18 Page to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
   */
  KRW_KFTC18_KRW02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC KRW Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Korean Won/U.S. Dollar markets for the purpose of determining the SFEMC KRW Indicative Survey Rate).
   */
  KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on Telerate Page 45644 to the right of the caption 'USD Today' that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
   */
  KRW_TELERATE_45644_KRW03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 1:00 p.m., Almaty time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA KZT Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Kazakhstan Tenge/U.S. Dollar markets for the purpose of determining the EMTA KZT Indicative Survey Rate).
   */
  KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar weighted average rate, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day reported by the Kazakhstan Stock Exchange (www.kase.kz) at approximately 11:00 am, Almaty time, on that Rate Calculation Date.
   */
  KZT_KASE_KZT01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Lebanese Pound/U.S. Dollar Specified Rate, expressed as the amount of Lebanese Pounds per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BDLX Page as of 12:00 noon, Beirut time, on that Rate Calculation Date.
   */
  LBP_BDLX_LBP01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Moroccan Dirham/U.S. Dollar Specified Rate, expressed as the amount of Moroccan Dirham per one U.S. Dollar, for settlement in two Business Days reported by the Central Bank of Morocco as of 1:00 p.m., Rabat time, on that Rate Calculation Date.
   */
  MAD_OFFICIAL_RATE_MAD01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Mexican Pesos/U.S. Dollar Specified rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on the Reuters Screen BNMX Page opposite the caption 'Fix' at the close of business in Mexico City on that Rate Calculation Date.
   */
  MXP_BNMX_MXP01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by Banco de Mexico in the Official Gazette of the Federation pursuant to the 'Disposiciones aplicables a la determinacion del tipo de Cambio para solventar obligaciones denominadas en moneda extranjera pagaderas en la Republica Mexicana' (Rules applicable to determine the exchange rate to pay obligations denominated in foreign currency payable in Mexico) on the first Business Day following that Rate Calculation Date.
   */
  MXP_FIXING_RATE_MXP02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on Reuters Screen MEX01 Page under the heading 'MXNFIX=RR', at the close of business in Mexico City on that Rate Calculation Date.
   */
  MXP_MEX01_MXP03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by the Bolsa Mexicana de Valores, S.A. de C.V. (as established in Section 2 of the 'Resolution concerning the exchange rate applicable for calculating the Mexican Peso equivalent of principal and interest of Mexican Treasury Notes denominated in foreign currency and payable in Mexican Pesos' published in the Diario Oficial de la Federacion on November 11, 1991) in the Movimiento Diario del Mercado de Valores de la Bolsa Mexicana de Valores, S.A. de C.V. under the heading 'Movimiento Diario del Mercado de Valores' on that Rate Calculation Date.
   */
  MXP_PUBLISHED_MXP04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore, which appears on the Telerate Page 50157 to the right of the caption 'Spot' under the column 'MYR' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  MYR_ABS_MYR01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar reference rate, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, calculated and reported by Bank Negara Malaysia as its Kuala Lumpur USD/MYR Reference Rate, which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 3:30 p.m., Kuala Lumpur time, on that Rate Calculation Date.
   */
  MYR_KL_REF_MYR04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by Persatuan Pasaran Kewangan Malaysia (ACI - Malaysia), which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 11:10 a.m., Kuala Lumpur time, on that Rate Calculation Date.
   */
  MYR_PPKM_MYR03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC MYR Indicative Survey Methodology (which means a methodology, dated as of July 15, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Malaysian Ringgit/U.S. Dollar markets for the purpose of determining the SFEMC MYR Indicative Survey Rate).
   */
  MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Peruvian Soles per one U.S. Dollar, for settlement on the same day, as published on EMTA's web site (www.emta.org) at approximately 11:00 a.m., Lima time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA PEN Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Peruvian Sol/U.S. Dollar markets for the purpose of determining the EMTA PEN Indicative Survey Rate).
   */
  PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar average exchange rate in the interbank market expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day reported by the Banco Central de Reserva del Peru (www.bcrp.gob.pe) as the 'Tipo de Cambio Interbancario Promedio' at approximately 2:00 p.m., Lima time, on that Rate Calculation Date.
   */
  PEN_INTERBANK_AVE_PEN05,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar fixing rate (mid market last), expressed as the amount of Peruvian Sols per one U.S. Dollar, for settlement on that same day which appears on the Reuters Screen PDSB Page opposite the caption 'PEN=' as of 12:00 noon, Lima time, on that Rate Calculation Date.
   */
  PEN_PDSB_PEN01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the midpoint of the Peruvian Sol/U.S. Dollar closing weighted average bid and offer ('compra y venta') exchange rates expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day, reported by the Superintendencia de Banca, Seguros y AFP (www.sbs.gob.pe) of the Republic of Peru at approximately 5:00 p.m., Lima time, on that Rate Calculation Date.
   */
  PEN_WT_AVE_PEN03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, sponsored by Bankers Association of the Philippines (www.bap.org.ph) as its 'BAP AM Weighted Average Rate' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
   */
  PHP_BAPPESO_PHP06,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Philippine Dealing System PDEX which appears on the Reuters Screen PDSPESO Page to the right of the caption 'AM WT AVE' at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
   */
  PHP_PDSPESO_PHP06,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Reuters Screen PHPESO Page at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
   */
  PHP_PHPESO_PHP01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PHP Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Philippine Peso/U.S. Dollar markets for the purpose of determining the SFEMC PHP Indicative Survey Rate).
   */
  PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 15439 at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
   */
  PHP_TELERATE_15439_PHP03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 2920 at the Specified Time, if any, on that Rate Calculation Date.
   */
  PHP_TELERATE_2920_PHP02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar reference rate expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days reported by the State Bank of Pakistan (www.sbp.org.pk) at approximately 2:30 pm, Karachi time, on that Rate Calculation Date.
   */
  PKR_SBPK_PKR01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m. Singapore time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PKR Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Pakistani Rupee/U.S. Dollar markets for the purpose of determining the SFEMC PKR Indicative Survey Rate).
   */
  PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar Specified Rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPQ Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  PLZ_NBPQ_PLZ01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar fixing rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPR Page at the Specified Time, if any, on that Rate Calculation Date.
   */
  PLZ_NBPR_PLZ02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, calculated by the Chicago Mercantile Exchange ('CME') and as published on CME's website, which appears on the Reuters Screen EMTA Page, at approximately 1:30 p.m., Moscow time, on that Rate Calculation Date. The Spot Rate shall be calculated by the CME pursuant to the Chicago Mercantile Exchange / EMTA, Inc. Daily Russian Ruble Per U.S. Dollar Reference Rate Methodology (which means a methodology, effective as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions in Russia that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the RUB CME-EMTA Rate).
   */
  RUB_CME_EMTA_RUB03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, as published on EMTA's web site (www.emta.org) at approximately 2:45 p.m., Moscow time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA RUB Indicative Survey Methodology (which means a methodology dated as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the EMTA RUB Indicative Survey Rate).
   */
  RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MICEXFRX Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
   */
  RUB_MICEXFRX_RUB01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MMVB Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
   */
  RUB_MMVB_RUB02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Singapore Dollar/U.S. Dollar spot rate expressed as the amount of Singapore Dollar per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  SGD_VWAP_SGD3,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Slovak Koruna/U.S. Dollar Specified Rate, expressed as the amount of Slovak Koruna per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Slovakia which appears on the Reuters Screen NBSB Page as of 11:40 a.m., Bratislava time, on that Rate Calculation Date.
   */
  SKK_NBSB_SKK01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Thai Baht/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Thai Bhaht per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'THB' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  THB_ABS_THB01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Thai Baht / U.S. Dollar spot rate expressed as the amount of Thai Baht per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  THB_VWAP_THB01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC TWD Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Taiwanese Dollar/U.S. Dollar markets for the purpose of determining the SFEMC TWD Indicative Survey Rate).
   */
  TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Reuters Screen TAIFX1 Page under the heading 'Spot' as of 11:00 a.m. Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time on that Rate Calculation Date.
   */
  TWD_TAIFX1_TWD03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Telerate Page 6161 under the heading 'Spot' as of 11:00 a.m., Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time, on that Rate Calculation Date.
   */
  TWD_TELERATE_6161_TWD01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen TFEMA Page as of 11:00 a.m., Taipei time, on that Rate Calculation Date.
   */
  TWD_TFEMA_TWD02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA's website (www.emta.org) at approximately 2:00 p.m., Kiev time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA UAH Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Ukrainian Hryvnia / U.S. Dollar markets for the purpose of determining the EMTA UAH Indicative Survey Rate).
   */
  UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day calculated by Thomson Reuters pursuant to the EMTA UAH Industry Survey Methodology, which rate appears on EMTA's website (www.emta.org) and on Thomson Reuters Page EMTAUAHFIX at approximately 11:30 am, Kiev time, on that Rate Calculation Date. The 'EMTA UAH Industry Survey Methodology' as used herein means the methodology dated as of March 16, 2009, for a centralized industry wide survey of financial institutions in the Ukrainian Hryvnia/U.S. Dollar spot market for the purposes of determining the EMTA UAH Industry Survey Rate.
   */
  UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar spot rate, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day reported by GFI Brokers on Thomson Reuters Page GFIU by 9:30 am, London time, on that Rate Calculation Date.
   */
  UAH_GFI_UAH01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the midpoint of the Venezuelan Bolivar /U.S. Dollar Tipo de Cambio De Referencia buying and selling rates, expressed as the amount of Venezuelan Bolivar per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central de Venezuela (www.bcv.org.ve) at approximately 5:00 p.m., Caracas time, on that Rate Calculation Date.
   */
  VEF_FIX_VEF01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days reported by the Association of Banks in Singapore, which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption 'Spot' under the column 'VND' at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
   */
  VND_ABS_VND01,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days which appears on Reuters Screen VNDFIX=VN Page under the caption 'Spot' and to the right of the caption 'Average' at approximately 11:00 am, Hanoi time, on that Rate Calculation Date.
   */
  VND_FX_VND02,

  /**
   * The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC's website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon as thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC VND Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Vietnamese Dong/U.S. Dollar markets for the purpose of determining the SFEMC VND Indicative Survey Rate).
   */
  VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03
}
/**
 * The enumeration values to specify how the option is to be settled when exercised.
 */
export enum SettlementTypeEnum {

  /**
   * The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
   */
  CASH,

  /**
   * Allow use of either Cash or Physical settlement without prior Election.
   */
  CASH_OR_PHYSICAL,

  /**
   * Allow Election of either Cash or Physical settlement.
   */
  ELECTION,

  /**
   * The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
   */
  PHYSICAL
}
/**
 * The enumerated values to specify the consequences of extraordinary events relating to the underlying.
 */
export enum ShareExtraordinaryEventEnum {

  /**
   * The trade continues such that the underlying now consists of the New Shares and/or the Other Consideration, if any, and the proceeds of any redemption, if any, that the holder of the underlying Shares would have been entitled to.
   */
  ALTERNATIVE_OBLIGATION,

  /**
   * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments may not be made to account solely for changes in volatility, expected dividends, stock loan rate or liquidity.
   */
  CALCULATION_AGENT,

  /**
   * The trade is cancelled and a cancellation fee will be paid by one party to the other.
   */
  CANCELLATION_AND_PAYMENT,

  /**
   * If this is a Share-for-Combined merger event (Shares are replaced with New Shares and Other Consideration), then different treatment can be applied to each component if the parties have specified this.
   */
  COMPONENT,

  /**
   * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments to account for changes in volatility, expected dividends, stock loan rate or liquidity are allowed.
   */
  MODIFIED_CALCULATION_AGENT,

  /**
   * The trade will be adjusted by the Calculation Agent in accordance with the adjustments made by any exchange on which options on the underlying are listed.
   */
  OPTIONS_EXCHANGE,

  /**
   * Applies to Basket Transactions. The portion of the Basket made up by the affected Share will be cancelled and a cancellation fee will be paid from one party to the other. The remainder of the trade continues.
   */
  PARTIAL_CANCELLATION_AND_PAYMENT
}
/**
 * The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined.
 */
export enum SpecifiedEntityClauseEnum {

  BANKRUPTCY,

  CREDIT_EVENT_UPON_MERGER,

  CROSS_DEFAULT,

  DEFAULT_UNDER_SPECIFIED_TRANSACTION
}
/**
 * The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
 */
export enum SpecifiedEntityTermsEnum {

  /**
   * Any Affiliate is a Specified Entity.
   */
  ANY_AFFILIATE,

  /**
   * Any Material Subsidiary.
   */
  MATERIAL_SUBSIDIARY,

  /**
   * The Specified Entity is provided.
   */
  NAMED_SPECIFIED_ENTITY,

  /**
   * No Specified Entity is provided
   */
  NONE,

  /**
   * Non standard Specified Entity terms are provided.
   */
  OTHER_SPECIFIED_ENTITY
}
/**
 * Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
 */
export enum SpreadCalculationMethodEnum {

  PAR_PAR,

  PROCEEDS
}
/**
 * The enumerated values to specify a long or short spread value.
 */
export enum SpreadScheduleTypeEnum {

  /**
   * Represents a Long Spread Schedule. Spread schedules defined as 'Long' will be applied to Long Positions.
   */
  LONG,

  /**
   * Represents a Short Spread Schedule. Spread schedules defined as 'Short' will be applied to Short Positions.
   */
  SHORT
}
/**
 * The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
 */
export enum StandardSettlementStyleEnum {

  /**
   * This trade is a candidate for settlement netting.
   */
  NET,

  /**
   * These trades have been paired and are a candidate for settlement netting.
   */
  PAIR_AND_NET,

  /**
   * This trade will settle using standard predetermined funds settlement instructions.
   */
  STANDARD,

  /**
   * This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
   */
  STANDARD_AND_NET
}
export enum StandardizedScheduleAssetClassEnum {

  COMMODITY,

  CREDIT,

  EQUITY,

  FOREIGN_EXCHANGE,

  INTEREST_RATES
}
export enum StandardizedScheduleProductClassEnum {

  BASIS_SWAP,

  CONTRACT_FOR_DIFFERENCE,

  CORRELATION_SWAP,

  CREDIT_NTH_TO_DEFAULT,

  CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND,

  CROSS_CURRENCY_SWAP,

  DELIVERABLE_FORWARD,

  DELIVERABLE_OPTION,

  DELIVERABLE_OPTION_F,

  DELIVERABLE_SWAP,

  DIVIDEND_SWAP,

  FIXED_FLOAT_SWAP,

  FORWARD,

  FORWARD_RATE_AGREEMENT,

  IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG,

  INDEX_CDS,

  INDEX_TRANCHE,

  NON_DELIVERABLE_CROSS_CURRENCY_SWAP,

  NON_DELIVERABLE_FORWARD,

  NON_DELIVERABLE_OPTION,

  OPTION,

  SINGLE_NAME_CREDIT_DEFAULT_SWAP,

  SWAP,

  SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS,

  SWAPS_AND_PORTFOLIO_SWAPS,

  SWAPTION,

  SWAPTION_STRADDLE,

  VARIANCE_SWAP,

  VOLATILITY_SWAP
}
/**
 * The enumerated values to specify how to deal with a non standard calculation period within a swap stream.
 */
export enum StubPeriodTypeEnum {

  /**
   * If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period.
   */
  LONG_FINAL,

  /**
   * If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period.
   */
  LONG_INITIAL,

  /**
   * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream.
   */
  SHORT_FINAL,

  /**
   * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream.
   */
  SHORT_INITIAL
}
/**
 * Represents an enumeration list to identify the type of supranational entity issuing the asset.
 */
export enum SupraNationalIssuerTypeEnum {

  /**
   * Specifies International Financial Institution.
   */
  INTERNATIONAL_ORGANISATION,

  /**
   * Specifies Multilateral Bank or Multilateral Development Bank.
   */
  MULTILATERAL_BANK
}
/**
 * Represents the enumerated values to specify taxonomy sources.
 */
export enum TaxonomySourceEnum {

  /**
   * Represents the ISO 10962 Classification of Financial Instruments code.
   */
  CFI,

  /**
   * Represents the EMIR Article 9 Asset Definition Identifier code.
   */
  EMIR,

  /**
   * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules.
   */
  EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,

  /**
   * Represents the ISDA Collateral Asset Definition Identifier code.
   */
  ICAD,

  /**
   * Represents the ISDA product taxonomy.
   */
  ISDA,

  /**
   * Represents the Monetary Authority of Singapore (MAS) as a taxonomy source.
   */
  MAS,

  /**
   * Denotes a user-specific scheme or taxonomy or other external sources not listed here.
   */
  OTHER,

  /**
   * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities.Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
   */
  UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,

  /**
   * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
   */
  US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS
}
/**
 * The enumerated values to specify the type of telephone number, e.g. work vs. mobile.
 */
export enum TelephoneTypeEnum {

  /**
   * A number used primarily for work-related facsimile transmissions.
   */
  FAX,

  /**
   * A number on a mobile telephone that is often or usually used for work-related calls. This type of number can be used for urgent work related business when a work number is not sufficient to contact the person or firm.
   */
  MOBILE,

  /**
   * A number used primarily for non work-related calls. (Normally this type of number would be used only as an emergency backup number, not as a regular course of business).
   */
  PERSONAL,

  /**
   * A number used primarily for work-related calls. Includes home office numbers used primarily for work purposes.
   */
  WORK
}
export enum TerminationCurrencyConditionEnum {

  /**
   * A currency that is freely available.
   */
  FREELY_AVAILABLE,

  /**
   * A currency in which payments would be due under one or more Transactions.
   */
  PAYMENTS_DUE,

  /**
   * A currency in which payments would be due under one or more Transactions and that is freely available.
   */
  PAYMENTS_DUE_AND_FREELY_AVAILABLE,

  /**
   * Termination Currency Conditions are specified.
   */
  SPECIFIED
}
/**
 * The enumerated values to specify points in the day when option exercise and valuation can occur.
 */
export enum TimeTypeEnum {

  /**
   * The time is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION,

  /**
   * The official closing time of the exchange on the valuation date.
   */
  CLOSE,

  /**
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
   */
  DERIVATIVES_CLOSE,

  /**
   * The time at which the official settlement price is determined.
   */
  OSP,

  /**
   * The official opening time of the exchange on the valuation date.
   */
  OPEN,

  /**
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate).
   */
  SPECIFIC_TIME,

  /**
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
   */
  XETRA
}
/**
 * The enumeration values to qualify the allowed units of time.
 */
export enum TimeUnitEnum {

  /**
   * Day
   */
  DAY,

  /**
   * Hour
   */
  HOUR,

  /**
   * Minute
   */
  MINUTE,

  /**
   * Month
   */
  MONTH,

  /**
   * Second
   */
  SECOND,

  /**
   * Week
   */
  WEEK,

  /**
   * Year
   */
  YEAR
}
/**
 * Defines the enumerated values to specify the nature of a trade identifier.
 */
export enum TradeIdentifierTypeEnum {

  UNIQUE_SWAP_IDENTIFIER,

  UNIQUE_TRANSACTION_IDENTIFIER
}
/**
 * The enumeration values to specify how the transfer will settle, e.g. DvP.
 */
export enum TransferSettlementEnum {

  /**
   * Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
   */
  DELIVERY_VERSUS_DELIVERY,

  /**
   * Settlement in which the transfer of the asset and the cash settlement are simultaneous.
   */
  DELIVERY_VERSUS_PAYMENT,

  /**
   * No central settlement.
   */
  NOT_CENTRAL_SETTLEMENT,

  /**
   * Simultaneous transfer of cashflows.
   */
  PAYMENT_VERSUS_PAYMENT
}
/**
 * The enumeration values to specify the transfer status.
 */
export enum TransferStatusEnum {

  /**
   * The transfer is disputed.
   */
  DISPUTED,

  /**
   * The transfer has been instructed.
   */
  INSTRUCTED,

  /**
   * The transfer has been netted into a separate Transfer.
   */
  NETTED,

  /**
   * The transfer is pending instruction.
   */
  PENDING,

  /**
   * The transfer has been settled.
   */
  SETTLED
}
/**
 * The enumerated values to specify the time of day which would be considered for valuing the knock event.
 */
export enum TriggerTimeTypeEnum {

  /**
   * At any time during the Knock Determination period (continuous barrier).
   */
  ANYTIME,

  /**
   * The close of trading on a day would be considered for valuation.
   */
  CLOSING
}
/**
 * The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
 */
export enum TriggerTypeEnum {

  /**
   * The underlier price must be equal to the Trigger level.
   */
  EQUAL,

  /**
   * The underlier price must be equal to or greater than the Trigger level.
   */
  EQUAL_OR_GREATER,

  /**
   * The underlier price must be equal to or less than the Trigger level.
   */
  EQUAL_OR_LESS,

  /**
   * The underlier price must be greater than the Trigger level.
   */
  GREATER,

  /**
   * The underlier price must be less than the Trigger level.
   */
  LESS
}
/**
 * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
 */
export enum UK_EMIR_EligibleCollateralEnum {

  /**
   * Denotes cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
   */
  UK_EMIR_TYPE_A,

  /**
   * Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
   */
  UK_EMIR_TYPE_B,

  /**
   * Denotes debt securities issued by the central government of the United Kingdom or the Bank of England.
   */
  UK_EMIR_TYPE_C,

  /**
   * Denotes debt securities issued by United Kingdom regional governments or local authorities whose exposures are treated as exposures to the central government of the United Kingdom in accordance with Article 115(2) of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_D,

  /**
   * Denotes debt securities issued by United Kingdom public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of the United Kingdom in accordance with Article 116(4) of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_E,

  /**
   * Denotes debt securities issued by United Kingdom regional governments or local authorities other than those referred to in (TypeD).
   */
  UK_EMIR_TYPE_F,

  /**
   * Denotes debt securities issued by United Kingdom public sector entities other than those referred to in (TypeE).
   */
  UK_EMIR_TYPE_G,

  /**
   * Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_H,

  /**
   * Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_I,

  /**
   * Denotes debt securities issued by third countries' governments or central banks.
   */
  UK_EMIR_TYPE_J,

  /**
   * Denotes debt securities issued by third countries' regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
   */
  UK_EMIR_TYPE_K,

  /**
   * Denotes debt securities issued by third countries' regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
   */
  UK_EMIR_TYPE_L,

  /**
   * Denotes debt securities issued by credit institutions or investment firms including bonds admitted to the register of regulated covered bonds maintained under Regulation 7(1)(b) of the Regulated Covered Bonds Regulations 2008 (SI 2008/346).
   */
  UK_EMIR_TYPE_M,

  /**
   * Denotes corporate bonds.
   */
  UK_EMIR_TYPE_N,

  /**
   * Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
   */
  UK_EMIR_TYPE_O,

  /**
   * Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_P,

  /**
   * Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
   */
  UK_EMIR_TYPE_Q,

  /**
   * Denotes shares or units in undertakings for UK UCITS, provided that the conditions set out in Article 5 of EU Regulation 2016/2251 (as modified by the Technical Standards (European Market Infrastructure) (EU Exit) (No. 3) Instrument 2019) are met.
   */
  UK_EMIR_TYPE_R
}
/**
 * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
 */
export enum US_CFTC_PR_EligibleCollateralEnum {

  /**
   * Denotes immediately available cash funds denominated in USD, a major currency, a currency of settlement for the uncleared swap.
   */
  US_CFTC_PR_TYPE_1,

  /**
   * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury.
   */
  US_CFTC_PR_TYPE_2,

  /**
   * Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, a U.S. government agency (other than the U.S. Department of Treasury) whose obligations are fully guaranteed by the full faith and credit of the United States government.
   */
  US_CFTC_PR_TYPE_3,

  /**
   * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator.
   */
  US_CFTC_PR_TYPE_4,

  /**
   * Denotes a publicly traded debt security issued by, or an asset-backed security fully guaranteed as to the timely payment of principal and interest by, a U.S. Government-sponsored enterprise that is operating with capital support or another form of direct financial assistance received from the U.S. government that enables the repayments of the U.S. Government-sponsored enterprise's eligible securities.
   */
  US_CFTC_PR_TYPE_5_A,

  /**
   * Denotes a publicly traded debt security, but not an asset backed security, that is investment grade and issued by a U.S. Government-sponsored enterprise that is not operating with capital support or another form of direct financial assistance received from the U.S. government.
   */
  US_CFTC_PR_TYPE_5_B,

  /**
   * Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the Bank for International Settlements, the International Monetary Fund, or a multilateral development bank.
   */
  US_CFTC_PR_TYPE_6,

  /**
   * Denotes publicly-traded debt, but not an asset backed security, that is investment grade and is not a debt security issued by a  U.S. Government-sponsored enterprise. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
   */
  US_CFTC_PR_TYPE_7,

  /**
   * Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
   */
  US_CFTC_PR_TYPE_8_A,

  /**
   *  Denotes a publicly traded common equity security that is included in the Standard & Poor's Composite 1500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
   */
  US_CFTC_PR_TYPE_8_B,

  /**
   * Denotes a publicly traded common equity security that is included in an index that a regulated swap entity's supervisor in a foreign jurisdiction recognizes for purposes of including publicly traded common equity as initial margin under applicable regulatory policy, if held in that foreign jurisdiction. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
   */
  US_CFTC_PR_TYPE_8_C,

  /**
   * Denotes securities in the form of redeemable securities in a pooled investment fund representing the security-holder's proportional interest in the fund's net assets and that are issued and redeemed only on the basis of the market value of the fund's net assets prepared each business day after the security-holder makes its investment commitment or redemption request to the fund, if the fund's investments are limited to the following: (A) securities that are issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury, and immediately-available cash funds denominated in U.S. dollars; or (B) securities denominated in a common currency and issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator, and immediately-available cash funds denominated in the same currency; and (C) assets of the fund may not be transferred through securities lending, securities borrowing, repurchase agreements, reverse repurchase agreements, or other means that involve the fund having rights to acquire the same or similar assets from the transferee.
   */
  US_CFTC_PR_TYPE_9,

  /**
   * Denotes Gold.
   */
  US_CTFC_PR_TYPE_10
}
/**
 * The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement.
 */
export enum ValuationMethodEnum {

  AVERAGE_BLENDED_HIGHEST,

  AVERAGE_BLENDED_MARKET,

  AVERAGE_HIGHEST,

  AVERAGE_MARKET,

  BLENDED_HIGHEST,

  BLENDED_MARKET,

  HIGHEST,

  MARKET
}
/**
 * Source for the valuation of the transaction by the valuation party.
 */
export enum ValuationSourceEnum {

  /**
   * Central Counterparty's Valuation
   */
  CENTRAL_COUNTERPARTY
}
/**
 * Method used for the valuation of the transaction by the valuation party.
 */
export enum ValuationTypeEnum {

  /**
   * Mark-to-Market
   */
  MARK_TO_MARKET,

  /**
   * Mark-to-Model
   */
  MARK_TO_MODEL
}
export enum WarehouseIdentityEnum {

  /**
   * The DTCC Trade Information Warehouse Gold service
   */
  DTCC_TIW_GOLD
}
/**
 * Provides enumerated values for weather units, generally used in the context of defining quantities for commodities.
 */
export enum WeatherUnitEnum {

  /**
   * Denotes Cooling Degree Days as a standard unit.
   */
  CDD,

  /**
   * Denotes Critical Precipitation Day as a standard unit.
   */
  CPD,

  /**
   * Heating Degree Day as a standard unit.
   */
  HDD
}
/**
 * The enumerated values to specify the weekly roll day.
 */
export enum WeeklyRollConventionEnum {

  /**
   * Friday
   */
  FRI,

  /**
   * Monday
   */
  MON,

  /**
   * Saturday
   */
  SAT,

  /**
   * Sunday
   */
  SUN,

  /**
   * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday
   */
  TBILL,

  /**
   * Thursday
   */
  THU,

  /**
   * Tuesday
   */
  TUE,

  /**
   * Wednesday
   */
  WED
}
export enum WorkflowStatusEnum {

  ACCEPTED,

  AFFIRMED,

  ALLEGED,

  AMENDED,

  CANCELLED,

  CERTAIN,

  CLEARED,

  CONFIRMED,

  PENDING,

  REJECTED,

  SUBMITTED,

  TERMINATED,

  UNCERTAIN,

  UNCONFIRMED
}
