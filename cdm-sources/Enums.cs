// This file is auto-generated from the ISDA Common Domain Model, do not edit.
//
// Version: 6.0.0
//
namespace Org.Isda.Cdm.Enums
{
    using System.Runtime.Serialization;
    using Rosetta.Lib.Attributes;
    
    /// <summary>
    /// The enumeration values to qualify the type of account.
    /// </summary>
    [CdmName("AccountTypeEnum")]
    public enum AccountType
    {
        /// <summary>
        /// Aggregate client account, as defined under ESMA MiFIR.
        /// </summary>
        [EnumMember(Value = "AGGREGATE_CLIENT")]
        AggregateClient,
        
        /// <summary>
        /// The account contains trading activity or positions that belong to a client of the firm that opened the account.
        /// </summary>
        [EnumMember(Value = "CLIENT")]
        Client,
        
        /// <summary>
        /// The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
        /// </summary>
        [EnumMember(Value = "HOUSE")]
        House
    }
    
    /// <summary>
    /// The enumeration values to specify the actions associated with transactions.
    /// </summary>
    [CdmName("ActionEnum")]
    public enum Action
    {
        /// <summary>
        /// A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
        /// </summary>
        [EnumMember(Value = "CANCEL")]
        Cancel,
        
        /// <summary>
        /// A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
        /// </summary>
        [EnumMember(Value = "CORRECT")]
        Correct,
        
        /// <summary>
        /// A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
        /// </summary>
        [EnumMember(Value = "NEW")]
        New
    }
    
    /// <summary>
    /// Enumeration for the different types of affirmation status.
    /// </summary>
    [CdmName("AffirmationStatusEnum")]
    public enum AffirmationStatus
    {
        [EnumMember(Value = "AFFIRMED")]
        Affirmed,
        
        [EnumMember(Value = "UNAFFIRMED")]
        Unaffirmed
    }
    
    /// <summary>
    /// If there is an alternative to interest amounts, how is it specified?
    /// </summary>
    [CdmName("AlternativeToInterestAmountEnum")]
    public enum AlternativeToInterestAmount
    {
        /// <summary>
        /// The standard calculation of the Interest Amount is replaced with the amount of interest the secured party actually receives in relation to the Cash collateral.
        /// </summary>
        [EnumMember(Value = "ACTUAL_AMOUNT_RECEIVED")]
        ActualAmountReceived,
        
        /// <summary>
        /// An other alternative option outside these choices that can be described as an alternative provision.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Interest amount is not transferred if transfer would create or increase a delivery amount.
        /// </summary>
        [EnumMember(Value = "STANDARD")]
        Standard,
        
        /// <summary>
        /// Interest amount is not transferred if transfer would create or increase a delivery amount. (This is the &apos;Standard&apos; provision). However, interest Amount will be transferred if Delivery Amount is below Minimum Transfer Amount.
        /// </summary>
        [EnumMember(Value = "TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA")]
        TransferIfDeliveryAmountBelowMTA
    }
    
    /// <summary>
    /// Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
    /// </summary>
    [CdmName("AncillaryRoleEnum")]
    public enum AncillaryRole
    {
        /// <summary>
        /// Specifies the party responsible for deciding the fallback rate.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_FALLBACK")]
        CalculationAgentFallback,
        
        /// <summary>
        /// Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_INDEPENDENT")]
        CalculationAgentIndependent,
        
        /// <summary>
        /// Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION")]
        CalculationAgentMandatoryEarlyTermination,
        
        /// <summary>
        /// Specifies the party responsible for performing calculation agent duties associated with an optional early termination.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION")]
        CalculationAgentOptionalEarlyTermination,
        
        /// <summary>
        /// Specifies the party which determines additional disruption events.
        /// </summary>
        [EnumMember(Value = "DISRUPTION_EVENTS_DETERMINING_PARTY")]
        DisruptionEventsDeterminingParty,
        
        /// <summary>
        /// Specifies the party to which notice of a cancelable provision exercise should be given.
        /// </summary>
        [EnumMember(Value = "EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION")]
        ExerciseNoticeReceiverPartyCancelableProvision,
        
        /// <summary>
        /// Specifies the party to which notice of a extendible provision exercise should be given.
        /// </summary>
        [EnumMember(Value = "EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION")]
        ExerciseNoticeReceiverPartyExtendibleProvision,
        
        /// <summary>
        /// Specifies the party to which notice of a manual exercise should be given.
        /// </summary>
        [EnumMember(Value = "EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL")]
        ExerciseNoticeReceiverPartyManual,
        
        /// <summary>
        /// Specifies the party to which notice of a optional early termination exercise should be given.
        /// </summary>
        [EnumMember(Value = "EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION")]
        ExerciseNoticeReceiverPartyOptionalEarlyTermination,
        
        /// <summary>
        /// Specifies the party which determines if dividends are extraordinary in relation to normal levels.
        /// </summary>
        [EnumMember(Value = "EXTRAORDINARY_DIVIDENDS_PARTY")]
        ExtraordinaryDividendsParty,
        
        /// <summary>
        /// Specifies the clearing organization (CCP, DCO) which the trade should be cleared.
        /// </summary>
        [EnumMember(Value = "PREDETERMINED_CLEARING_ORGANIZATION_PARTY")]
        PredeterminedClearingOrganizationParty
    }
    
    /// <summary>
    /// An arithmetic operator that can be passed to a function
    /// </summary>
    [CdmName("ArithmeticOperationEnum")]
    public enum ArithmeticOperation
    {
        /// <summary>
        /// Addition of 2 values
        /// </summary>
        [EnumMember(Value = "ADD")]
        Add,
        
        /// <summary>
        /// Division of 1st value by 2nd value
        /// </summary>
        [EnumMember(Value = "DIVIDE")]
        Divide,
        
        /// <summary>
        /// Maximum of 2 values
        /// </summary>
        [EnumMember(Value = "MAX")]
        Max,
        
        /// <summary>
        /// Minimum of 2 values
        /// </summary>
        [EnumMember(Value = "MIN")]
        Min,
        
        /// <summary>
        /// Multiplication of 2 values
        /// </summary>
        [EnumMember(Value = "MULTIPLY")]
        Multiply,
        
        /// <summary>
        /// Subtraction of 2nd value from 1st value
        /// </summary>
        [EnumMember(Value = "SUBTRACT")]
        Subtract
    }
    
    /// <summary>
    /// The enumerated values to specify the FpML asset class categorization.
    /// </summary>
    [CdmName("AssetClassEnum")]
    public enum AssetClass
    {
        /// <summary>
        /// Commodity.
        /// </summary>
        [EnumMember(Value = "COMMODITY")]
        Commodity,
        
        /// <summary>
        /// Credit.
        /// </summary>
        [EnumMember(Value = "CREDIT")]
        Credit,
        
        /// <summary>
        /// Equity.
        /// </summary>
        [EnumMember(Value = "EQUITY")]
        Equity,
        
        /// <summary>
        /// ForeignExchange.
        /// </summary>
        [EnumMember(Value = "FOREIGN_EXCHANGE")]
        ForeignExchange,
        
        /// <summary>
        /// InterestRate.
        /// </summary>
        [EnumMember(Value = "INTEREST_RATE")]
        InterestRate,
        
        /// <summary>
        /// Money Market Assets like CP and CD.
        /// </summary>
        [EnumMember(Value = "MONEY_MARKET")]
        MoneyMarket
    }
    
    /// <summary>
    /// Extends product identifiers with additional identifier sources for Assets.
    /// </summary>
    [CdmName("AssetIdTypeEnum")]
    public enum AssetIdType
    {
        /// <summary>
        /// Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
        /// </summary>
        BBGID,
        
        /// <summary>
        /// Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
        /// </summary>
        BBGTICKER,
        
        /// <summary>
        /// Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
        /// </summary>
        CUSIP,
        
        /// <summary>
        /// The identifier follows the symbology set by the clearing house which clears the asset.
        /// </summary>
        [EnumMember(Value = "CLEARING_CODE")]
        ClearingCode,
        
        /// <summary>
        /// Used to identify the currency of a Cash Asset.
        /// </summary>
        [EnumMember(Value = "CURRENCY_CODE")]
        CurrencyCode,
        
        /// <summary>
        /// The identifier follows the symbology set by the exchange which lists the asset.
        /// </summary>
        [EnumMember(Value = "EXCHANGE_CODE")]
        ExchangeCode,
        
        /// <summary>
        /// Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
        /// </summary>
        FIGI,
        
        /// <summary>
        /// Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
        /// </summary>
        ISDACRP,
        
        /// <summary>
        /// Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
        /// </summary>
        ISIN,
        
        /// <summary>
        /// The name of the product.
        /// </summary>
        [EnumMember(Value = "NAME")]
        Name,
        
        /// <summary>
        /// Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
        /// </summary>
        RIC,
        
        /// <summary>
        /// Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security&apos;s ISIN as well.
        /// </summary>
        SEDOL,
        
        /// <summary>
        /// Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
        /// </summary>
        [EnumMember(Value = "SICOVAM")]
        Sicovam,
        
        /// <summary>
        /// Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
        /// </summary>
        UPI,
        
        /// <summary>
        /// Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
        /// </summary>
        [EnumMember(Value = "WERTPAPIER")]
        Wertpapier
    }
    
    /// <summary>
    /// An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout.
    /// </summary>
    [CdmName("AssetPayoutTradeTypeEnum")]
    public enum AssetPayoutTradeType
    {
        /// <summary>
        /// In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo.
        /// </summary>
        [EnumMember(Value = "Buy/Sell-Back")]
        BuySellBack,
        
        /// <summary>
        /// In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller.
        /// </summary>
        [EnumMember(Value = "REPO")]
        Repo
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this AssetPayoutTradeType value)
        {
            return value switch
            {
                AssetPayoutTradeType.BuySellBack => "Buy/Sell-Back",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The qualification of the type of asset transfer.
    /// </summary>
    [CdmName("AssetTransferTypeEnum")]
    public enum AssetTransferType
    {
        /// <summary>
        /// The transfer of assets takes place without a corresponding exchange of payment.
        /// </summary>
        [EnumMember(Value = "FREE_OF_PAYMENT")]
        FreeOfPayment
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the asset type.
    /// </summary>
    [CdmName("AssetTypeEnum")]
    public enum AssetType
    {
        /// <summary>
        /// Indentifies cash in a currency form.
        /// </summary>
        [EnumMember(Value = "CASH")]
        Cash,
        
        /// <summary>
        /// Indentifies basic good used in commerce that is interchangeable with other goods of the same type.
        /// </summary>
        [EnumMember(Value = "COMMODITY")]
        Commodity,
        
        /// <summary>
        /// Indentifies other asset types.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Indentifies negotiable financial instrument of monetary value with an issue ownership position.
        /// </summary>
        [EnumMember(Value = "SECURITY")]
        Security
    }
    
    /// <summary>
    /// Enumeration to describe the type of AvailableInventory
    /// </summary>
    [CdmName("AvailableInventoryTypeEnum")]
    public enum AvailableInventoryType
    {
        /// <summary>
        /// Where a lender is broadcasting the securities that they have available to lend
        /// </summary>
        [EnumMember(Value = "AVAILABLE_TO_LEND")]
        AvailableToLend,
        
        /// <summary>
        /// Where a party is asking a lender if they have specific securities available for them to borrow
        /// </summary>
        [EnumMember(Value = "REQUEST_TO_BORROW")]
        RequestToBorrow
    }
    
    /// <summary>
    /// Indicates the type of equity average trading volume (single) the highest amount on one exchange, or (consolidated) volumes across more than one exchange.
    /// </summary>
    [CdmName("AverageTradingVolumeMethodologyEnum")]
    public enum AverageTradingVolumeMethodology
    {
        /// <summary>
        /// Consolidated volume across more than one exchange.
        /// </summary>
        [EnumMember(Value = "CONSOLIDATED")]
        Consolidated,
        
        /// <summary>
        /// Single, the highest amount on one exchange.
        /// </summary>
        [EnumMember(Value = "SINGLE")]
        Single
    }
    
    /// <summary>
    /// Specifies enumerations for the type of averaging calculation.
    /// </summary>
    [CdmName("AveragingCalculationMethodEnum")]
    public enum AveragingCalculationMethod
    {
        /// <summary>
        /// Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
        /// </summary>
        [EnumMember(Value = "ARITHMETIC")]
        Arithmetic,
        
        /// <summary>
        /// Refers to the calculation of an average by taking the nth root of the product of n observations.
        /// </summary>
        [EnumMember(Value = "GEOMETRIC")]
        Geometric,
        
        /// <summary>
        /// Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
        /// </summary>
        [EnumMember(Value = "HARMONIC")]
        Harmonic
    }
    
    /// <summary>
    /// The enumerated values to specify the type of averaging used in an Asian option.
    /// </summary>
    [CdmName("AveragingInOutEnum")]
    public enum AveragingInOut
    {
        /// <summary>
        /// The average price is used to derive both the strike and the expiration price.
        /// </summary>
        [EnumMember(Value = "BOTH")]
        Both,
        
        /// <summary>
        /// The average price is used to derive the strike price. Also known as &apos;Asian strike&apos; style option.
        /// </summary>
        [EnumMember(Value = "IN")]
        In,
        
        /// <summary>
        /// The average price is used to derive the expiration price. Also known as &apos;Asian price&apos; style option.
        /// </summary>
        [EnumMember(Value = "OUT")]
        Out
    }
    
    /// <summary>
    /// The enumerated values to specify the method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts.
    /// </summary>
    [CdmName("AveragingWeightingMethodEnum")]
    public enum AveragingWeightingMethod
    {
        /// <summary>
        /// The arithmetic mean of the relevant rates for each reset date.
        /// </summary>
        [EnumMember(Value = "UNWEIGHTED")]
        Unweighted,
        
        /// <summary>
        /// The arithmetic mean of the relevant rates in effect for each day in a calculation period calculated by multiplying each relevant rate by the number of days such relevant rate is in effect, determining the sum of such products and dividing such sum by the number of days in the calculation period.
        /// </summary>
        [EnumMember(Value = "WEIGHTED")]
        Weighted
    }
    
    /// <summary>
    /// Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles.
    /// </summary>
    [CdmName("BankHolidayTreatmentEnum")]
    public enum BankHolidayTreatment
    {
        /// <summary>
        /// Bank holidays treated as weekdays.
        /// </summary>
        [EnumMember(Value = "AS_WEEKDAY")]
        AsWeekday,
        
        /// <summary>
        /// Bank holidays treated as weekends.
        /// </summary>
        [EnumMember(Value = "AS_WEEKEND")]
        AsWeekend
    }
    
    /// <summary>
    /// The enumerated values to specify the business centers.
    /// </summary>
    [CdmName("BusinessCenterEnum")]
    public enum BusinessCenter
    {
        /// <summary>
        /// Abu Dhabi, Business Day (as defined in 2021 ISDA Definitions Section 2.1.10 (ii))
        /// </summary>
        AEAB,
        
        /// <summary>
        /// Abu Dhabi, Settlement Day (as defined in 2021 ISDA Definitions Section 2.1.10 (i))
        /// </summary>
        AEAD,
        
        /// <summary>
        /// Dubai, United Arab Emirates
        /// </summary>
        AEDU,
        
        /// <summary>
        /// Yerevan, Armenia
        /// </summary>
        AMYE,
        
        /// <summary>
        /// Luanda, Angola
        /// </summary>
        AOLU,
        
        /// <summary>
        /// Buenos Aires, Argentina
        /// </summary>
        ARBA,
        
        /// <summary>
        /// Vienna, Austria
        /// </summary>
        ATVI,
        
        /// <summary>
        /// Adelaide, Australia
        /// </summary>
        AUAD,
        
        /// <summary>
        /// Brisbane, Australia
        /// </summary>
        AUBR,
        
        /// <summary>
        /// Canberra, Australia
        /// </summary>
        AUCA,
        
        /// <summary>
        /// Darwin, Australia
        /// </summary>
        AUDA,
        
        /// <summary>
        /// Melbourne, Australia
        /// </summary>
        AUME,
        
        /// <summary>
        /// Perth, Australia
        /// </summary>
        AUPE,
        
        /// <summary>
        /// Sydney, Australia
        /// </summary>
        AUSY,
        
        /// <summary>
        /// Baku, Azerbaijan
        /// </summary>
        AZBA,
        
        /// <summary>
        /// Bridgetown, Barbados
        /// </summary>
        BBBR,
        
        /// <summary>
        /// Dhaka, Bangladesh
        /// </summary>
        BDDH,
        
        /// <summary>
        /// Brussels, Belgium
        /// </summary>
        BEBR,
        
        /// <summary>
        /// Sofia, Bulgaria
        /// </summary>
        BGSO,
        
        /// <summary>
        /// Manama, Bahrain
        /// </summary>
        BHMA,
        
        /// <summary>
        /// Hamilton, Bermuda
        /// </summary>
        BMHA,
        
        /// <summary>
        /// Bandar Seri Begawan, Brunei
        /// </summary>
        BNBS,
        
        /// <summary>
        /// La Paz, Bolivia
        /// </summary>
        BOLP,
        
        /// <summary>
        /// Brazil Business Day.
        /// </summary>
        BRBD,
        
        /// <summary>
        /// Brasilia, Brazil.
        /// </summary>
        BRBR,
        
        /// <summary>
        /// Rio de Janeiro, Brazil.
        /// </summary>
        BRRJ,
        
        /// <summary>
        /// Sao Paulo, Brazil.
        /// </summary>
        BRSP,
        
        /// <summary>
        /// Nassau, Bahamas
        /// </summary>
        BSNA,
        
        /// <summary>
        /// Gaborone, Botswana
        /// </summary>
        BWGA,
        
        /// <summary>
        /// Minsk, Belarus
        /// </summary>
        BYMI,
        
        /// <summary>
        /// Calgary, Canada
        /// </summary>
        CACL,
        
        /// <summary>
        /// Fredericton, Canada.
        /// </summary>
        CAFR,
        
        /// <summary>
        /// Montreal, Canada
        /// </summary>
        CAMO,
        
        /// <summary>
        /// Ottawa, Canada
        /// </summary>
        CAOT,
        
        /// <summary>
        /// Toronto, Canada
        /// </summary>
        CATO,
        
        /// <summary>
        /// Vancouver, Canada
        /// </summary>
        CAVA,
        
        /// <summary>
        /// Winnipeg, Canada
        /// </summary>
        CAWI,
        
        /// <summary>
        /// Basel, Switzerland
        /// </summary>
        CHBA,
        
        /// <summary>
        /// Geneva, Switzerland
        /// </summary>
        CHGE,
        
        /// <summary>
        /// Zurich, Switzerland
        /// </summary>
        CHZU,
        
        /// <summary>
        /// Abidjan, Cote d&apos;Ivoire
        /// </summary>
        CIAB,
        
        /// <summary>
        /// Santiago, Chile
        /// </summary>
        CLSA,
        
        /// <summary>
        /// Yaounde, Cameroon
        /// </summary>
        CMYA,
        
        /// <summary>
        /// Beijing, China
        /// </summary>
        CNBE,
        
        /// <summary>
        /// Shanghai, China
        /// </summary>
        CNSH,
        
        /// <summary>
        /// Bogota, Colombia
        /// </summary>
        COBO,
        
        /// <summary>
        /// San Jose, Costa Rica
        /// </summary>
        CRSJ,
        
        /// <summary>
        /// Willemstad, Curacao
        /// </summary>
        CWWI,
        
        /// <summary>
        /// Nicosia, Cyprus
        /// </summary>
        CYNI,
        
        /// <summary>
        /// Prague, Czech Republic
        /// </summary>
        CZPR,
        
        /// <summary>
        /// Cologne, Germany
        /// </summary>
        DECO,
        
        /// <summary>
        /// Dusseldorf, Germany
        /// </summary>
        DEDU,
        
        /// <summary>
        /// Frankfurt, Germany
        /// </summary>
        DEFR,
        
        /// <summary>
        /// Hannover, Germany
        /// </summary>
        DEHA,
        
        /// <summary>
        /// Hamburg, Germany
        /// </summary>
        DEHH,
        
        /// <summary>
        /// Leipzig, Germany
        /// </summary>
        DELE,
        
        /// <summary>
        /// Mainz, Germany
        /// </summary>
        DEMA,
        
        /// <summary>
        /// Munich, Germany
        /// </summary>
        DEMU,
        
        /// <summary>
        /// Stuttgart, Germany
        /// </summary>
        DEST,
        
        /// <summary>
        /// Copenhagen, Denmark
        /// </summary>
        DKCO,
        
        /// <summary>
        /// Santo Domingo, Dominican Republic
        /// </summary>
        DOSD,
        
        /// <summary>
        /// Algiers, Algeria
        /// </summary>
        DZAL,
        
        /// <summary>
        /// Guayaquil, Ecuador
        /// </summary>
        ECGU,
        
        /// <summary>
        /// Tallinn, Estonia
        /// </summary>
        EETA,
        
        /// <summary>
        /// Cairo, Egypt
        /// </summary>
        EGCA,
        
        /// <summary>
        /// ESAS Settlement Day (as defined in 2006 ISDA Definitions Section 7.1 and Supplement Number 15 to the 2000 ISDA Definitions)
        /// </summary>
        ESAS,
        
        /// <summary>
        /// Barcelona, Spain
        /// </summary>
        ESBA,
        
        /// <summary>
        /// Madrid, Spain
        /// </summary>
        ESMA,
        
        /// <summary>
        /// San Sebastian, Spain
        /// </summary>
        ESSS,
        
        /// <summary>
        /// Addis Ababa, Ethiopia
        /// </summary>
        ETAA,
        
        /// <summary>
        /// Publication dates for ICE Swap rates based on EUR-EURIBOR rates
        /// </summary>
        [EnumMember(Value = "EUR-ICESWAP")]
        EUR_ICESWAP,
        
        /// <summary>
        /// TARGET Settlement Day
        /// </summary>
        EUTA,
        
        /// <summary>
        /// Helsinki, Finland
        /// </summary>
        FIHE,
        
        /// <summary>
        /// Paris, France
        /// </summary>
        FRPA,
        
        /// <summary>
        /// Edinburgh, Scotland
        /// </summary>
        GBED,
        
        /// <summary>
        /// London, United Kingdom
        /// </summary>
        GBLO,
        
        /// <summary>
        /// Publication dates for GBP ICE Swap rates
        /// </summary>
        [EnumMember(Value = "GBP-ICESWAP")]
        GBP_ICESWAP,
        
        /// <summary>
        /// Tbilisi, Georgia
        /// </summary>
        GETB,
        
        /// <summary>
        /// Saint Peter Port, Guernsey
        /// </summary>
        GGSP,
        
        /// <summary>
        /// Accra, Ghana
        /// </summary>
        GHAC,
        
        /// <summary>
        /// Gibraltar, Gibraltar
        /// </summary>
        GIGI,
        
        /// <summary>
        /// Banjul, Gambia
        /// </summary>
        GMBA,
        
        /// <summary>
        /// Conakry, Guinea
        /// </summary>
        GNCO,
        
        /// <summary>
        /// Athens, Greece
        /// </summary>
        GRAT,
        
        /// <summary>
        /// Guatemala City, Guatemala
        /// </summary>
        GTGC,
        
        /// <summary>
        /// Guatemala City, Guatemala [DEPRECATED, to be removed in 2024. Replaced by GTGC.]
        /// </summary>
        GUGC,
        
        /// <summary>
        /// Hong Kong, Hong Kong
        /// </summary>
        HKHK,
        
        /// <summary>
        /// Tegucigalpa, Honduras
        /// </summary>
        HNTE,
        
        /// <summary>
        /// Zagreb, Republic of Croatia
        /// </summary>
        HRZA,
        
        /// <summary>
        /// Budapest, Hungary
        /// </summary>
        HUBU,
        
        /// <summary>
        /// Jakarta, Indonesia
        /// </summary>
        IDJA,
        
        /// <summary>
        /// Dublin, Ireland
        /// </summary>
        IEDU,
        
        /// <summary>
        /// Jerusalem, Israel
        /// </summary>
        ILJE,
        
        /// <summary>
        /// Publication dates of the ILS-TELBOR index.
        /// </summary>
        [EnumMember(Value = "ILS-TELBOR")]
        ILS_TELBOR,
        
        /// <summary>
        /// Tel Aviv, Israel
        /// </summary>
        ILTA,
        
        /// <summary>
        /// Ahmedabad, India
        /// </summary>
        INAH,
        
        /// <summary>
        /// Bangalore, India
        /// </summary>
        INBA,
        
        /// <summary>
        /// Chennai, India
        /// </summary>
        INCH,
        
        /// <summary>
        /// Hyderabad, India
        /// </summary>
        INHY,
        
        /// <summary>
        /// Kolkata, India
        /// </summary>
        INKO,
        
        /// <summary>
        /// Mumbai, India
        /// </summary>
        INMU,
        
        /// <summary>
        /// New Delhi, India
        /// </summary>
        INND,
        
        /// <summary>
        /// Baghdad, Iraq
        /// </summary>
        IQBA,
        
        /// <summary>
        /// Teheran, Iran
        /// </summary>
        IRTE,
        
        /// <summary>
        /// Reykjavik, Iceland
        /// </summary>
        ISRE,
        
        /// <summary>
        /// Milan, Italy
        /// </summary>
        ITMI,
        
        /// <summary>
        /// Rome, Italy
        /// </summary>
        ITRO,
        
        /// <summary>
        /// Turin, Italy
        /// </summary>
        ITTU,
        
        /// <summary>
        /// St. Helier, Channel Islands, Jersey
        /// </summary>
        JESH,
        
        /// <summary>
        /// Kingston, Jamaica
        /// </summary>
        JMKI,
        
        /// <summary>
        /// Amman, Jordan
        /// </summary>
        JOAM,
        
        /// <summary>
        /// Tokyo, Japan
        /// </summary>
        JPTO,
        
        /// <summary>
        /// Nairobi, Kenya
        /// </summary>
        KENA,
        
        /// <summary>
        /// Phnom Penh, Cambodia
        /// </summary>
        KHPP,
        
        /// <summary>
        /// Seoul, Republic of Korea
        /// </summary>
        KRSE,
        
        /// <summary>
        /// Kuwait City, Kuwait
        /// </summary>
        KWKC,
        
        /// <summary>
        /// George Town, Cayman Islands
        /// </summary>
        KYGE,
        
        /// <summary>
        /// Almaty, Kazakhstan
        /// </summary>
        KZAL,
        
        /// <summary>
        /// Vientiane, Laos
        /// </summary>
        LAVI,
        
        /// <summary>
        /// Beirut, Lebanon
        /// </summary>
        LBBE,
        
        /// <summary>
        /// Colombo, Sri Lanka
        /// </summary>
        LKCO,
        
        /// <summary>
        /// Luxembourg, Luxembourg
        /// </summary>
        LULU,
        
        /// <summary>
        /// Riga, Latvia
        /// </summary>
        LVRI,
        
        /// <summary>
        /// Casablanca, Morocco
        /// </summary>
        MACA,
        
        /// <summary>
        /// Rabat, Morocco
        /// </summary>
        MARA,
        
        /// <summary>
        /// Monaco, Monaco
        /// </summary>
        MCMO,
        
        /// <summary>
        /// Ulan Bator, Mongolia
        /// </summary>
        MNUB,
        
        /// <summary>
        /// Macau, Macao
        /// </summary>
        MOMA,
        
        /// <summary>
        /// Valletta, Malta
        /// </summary>
        MTVA,
        
        /// <summary>
        /// Port Louis, Mauritius
        /// </summary>
        MUPL,
        
        /// <summary>
        /// Male, Maldives
        /// </summary>
        MVMA,
        
        /// <summary>
        /// Lilongwe, Malawi
        /// </summary>
        MWLI,
        
        /// <summary>
        /// Mexico City, Mexico
        /// </summary>
        MXMC,
        
        /// <summary>
        /// Kuala Lumpur, Malaysia
        /// </summary>
        MYKL,
        
        /// <summary>
        /// Labuan, Malaysia
        /// </summary>
        MYLA,
        
        /// <summary>
        /// Maputo, Mozambique
        /// </summary>
        MZMA,
        
        /// <summary>
        /// Windhoek, Namibia
        /// </summary>
        NAWI,
        
        /// <summary>
        /// Abuja, Nigeria
        /// </summary>
        NGAB,
        
        /// <summary>
        /// Lagos, Nigeria
        /// </summary>
        NGLA,
        
        /// <summary>
        /// Amsterdam, Netherlands
        /// </summary>
        NLAM,
        
        /// <summary>
        /// Rotterdam, Netherlands
        /// </summary>
        NLRO,
        
        /// <summary>
        /// Oslo, Norway
        /// </summary>
        NOOS,
        
        /// <summary>
        /// Kathmandu, Nepal
        /// </summary>
        NPKA,
        
        /// <summary>
        /// New York Fed Business Day (as defined in 2006 ISDA Definitions Section 1.9, 2000 ISDA Definitions Section 1.9, and 2021 ISDA Definitions Section 2.1.7)
        /// </summary>
        NYFD,
        
        /// <summary>
        /// New York Stock Exchange Business Day (as defined in 2006 ISDA Definitions Section 1.10, 2000 ISDA Definitions Section 1.10, and 2021 ISDA Definitions Section 2.1.8)
        /// </summary>
        NYSE,
        
        /// <summary>
        /// Auckland, New Zealand
        /// </summary>
        NZAU,
        
        /// <summary>
        /// Wellington, New Zealand
        /// </summary>
        NZWE,
        
        /// <summary>
        /// Muscat, Oman
        /// </summary>
        OMMU,
        
        /// <summary>
        /// Panama City, Panama
        /// </summary>
        PAPC,
        
        /// <summary>
        /// Lima, Peru
        /// </summary>
        PELI,
        
        /// <summary>
        /// Manila, Philippines
        /// </summary>
        PHMA,
        
        /// <summary>
        /// Makati, Philippines
        /// </summary>
        PHMK,
        
        /// <summary>
        /// Karachi, Pakistan
        /// </summary>
        PKKA,
        
        /// <summary>
        /// Warsaw, Poland
        /// </summary>
        PLWA,
        
        /// <summary>
        /// San Juan, Puerto Rico
        /// </summary>
        PRSJ,
        
        /// <summary>
        /// Lisbon, Portugal
        /// </summary>
        PTLI,
        
        /// <summary>
        /// Doha, Qatar
        /// </summary>
        QADO,
        
        /// <summary>
        /// Bucharest, Romania
        /// </summary>
        ROBU,
        
        /// <summary>
        /// Belgrade, Serbia
        /// </summary>
        RSBE,
        
        /// <summary>
        /// Moscow, Russian Federation
        /// </summary>
        RUMO,
        
        /// <summary>
        /// Abha, Saudi Arabia
        /// </summary>
        SAAB,
        
        /// <summary>
        /// Jeddah, Saudi Arabia
        /// </summary>
        SAJE,
        
        /// <summary>
        /// Riyadh, Saudi Arabia
        /// </summary>
        SARI,
        
        /// <summary>
        /// Stockholm, Sweden
        /// </summary>
        SEST,
        
        /// <summary>
        /// Singapore, Singapore
        /// </summary>
        SGSI,
        
        /// <summary>
        /// Ljubljana, Slovenia
        /// </summary>
        SILJ,
        
        /// <summary>
        /// Bratislava, Slovakia
        /// </summary>
        SKBR,
        
        /// <summary>
        /// Freetown, Sierra Leone
        /// </summary>
        SLFR,
        
        /// <summary>
        /// Dakar, Senegal
        /// </summary>
        SNDA,
        
        /// <summary>
        /// San Salvador, El Salvador
        /// </summary>
        SVSS,
        
        /// <summary>
        /// Bangkok, Thailand
        /// </summary>
        THBA,
        
        /// <summary>
        /// Tunis, Tunisia
        /// </summary>
        TNTU,
        
        /// <summary>
        /// Ankara, Turkey
        /// </summary>
        TRAN,
        
        /// <summary>
        /// Istanbul, Turkey
        /// </summary>
        TRIS,
        
        /// <summary>
        /// Port of Spain, Trinidad and Tobago
        /// </summary>
        TTPS,
        
        /// <summary>
        /// Taipei, Taiwan
        /// </summary>
        TWTA,
        
        /// <summary>
        /// Dar es Salaam, Tanzania
        /// </summary>
        TZDA,
        
        /// <summary>
        /// Dodoma, Tanzania
        /// </summary>
        TZDO,
        
        /// <summary>
        /// Kiev, Ukraine
        /// </summary>
        UAKI,
        
        /// <summary>
        /// Kampala, Uganda
        /// </summary>
        UGKA,
        
        /// <summary>
        /// Boston, Massachusetts, United States
        /// </summary>
        USBO,
        
        /// <summary>
        /// Chicago, United States
        /// </summary>
        USCH,
        
        /// <summary>
        /// Charlotte, North Carolina, United States
        /// </summary>
        USCR,
        
        /// <summary>
        /// Washington, District of Columbia, United States
        /// </summary>
        USDC,
        
        /// <summary>
        /// Denver, United States
        /// </summary>
        USDN,
        
        /// <summary>
        /// Detroit, Michigan, United States
        /// </summary>
        USDT,
        
        /// <summary>
        /// Publication dates for ICE Swap rates based on USD-LIBOR rates
        /// </summary>
        [EnumMember(Value = "USD-ICESWAP")]
        USD_ICESWAP,
        
        /// <summary>
        /// Publication dates for the USD-Municipal Swap Index
        /// </summary>
        [EnumMember(Value = "USD-MUNI")]
        USD_MUNI,
        
        /// <summary>
        /// U.S. Government Securities Business Day (as defined in 2006 ISDA Definitions Section 1.11 and 2000 ISDA Definitions Section 1.11)
        /// </summary>
        USGS,
        
        /// <summary>
        /// Honolulu, Hawaii, United States
        /// </summary>
        USHL,
        
        /// <summary>
        /// Houston, United States
        /// </summary>
        USHO,
        
        /// <summary>
        /// Los Angeles, United States
        /// </summary>
        USLA,
        
        /// <summary>
        /// Mobile, Alabama, United States
        /// </summary>
        USMB,
        
        /// <summary>
        /// Minneapolis, United States
        /// </summary>
        USMN,
        
        /// <summary>
        /// New York, United States
        /// </summary>
        USNY,
        
        /// <summary>
        /// Portland, Oregon, United States
        /// </summary>
        USPO,
        
        /// <summary>
        /// Sacramento, California, United States
        /// </summary>
        USSA,
        
        /// <summary>
        /// Seattle, United States
        /// </summary>
        USSE,
        
        /// <summary>
        /// San Francisco, United States
        /// </summary>
        USSF,
        
        /// <summary>
        /// Wichita, United States
        /// </summary>
        USWT,
        
        /// <summary>
        /// Montevideo, Uruguay
        /// </summary>
        UYMO,
        
        /// <summary>
        /// Tashkent, Uzbekistan
        /// </summary>
        UZTA,
        
        /// <summary>
        /// Caracas, Venezuela
        /// </summary>
        VECA,
        
        /// <summary>
        /// Road Town, Virgin Islands (British)
        /// </summary>
        VGRT,
        
        /// <summary>
        /// Hanoi, Vietnam
        /// </summary>
        VNHA,
        
        /// <summary>
        /// Ho Chi Minh (formerly Saigon), Vietnam
        /// </summary>
        VNHC,
        
        /// <summary>
        /// Aden, Yemen
        /// </summary>
        YEAD,
        
        /// <summary>
        /// Johannesburg, South Africa
        /// </summary>
        ZAJO,
        
        /// <summary>
        /// Lusaka, Zambia
        /// </summary>
        ZMLU,
        
        /// <summary>
        /// Harare, Zimbabwe
        /// </summary>
        ZWHA
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this BusinessCenter value)
        {
            return value switch
            {
                BusinessCenter.EUR_ICESWAP => "EUR-ICESWAP",
                BusinessCenter.GBP_ICESWAP => "GBP-ICESWAP",
                BusinessCenter.ILS_TELBOR => "ILS-TELBOR",
                BusinessCenter.USD_ICESWAP => "USD-ICESWAP",
                BusinessCenter.USD_MUNI => "USD-MUNI",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumerated values to specify the convention for adjusting any relevant date if it would otherwise fall on a day that is not a valid business day.
    /// </summary>
    [CdmName("BusinessDayConventionEnum")]
    public enum BusinessDayConvention
    {
        /// <summary>
        /// The non-business date will be adjusted to the first following day that is a business day
        /// </summary>
        FOLLOWING,
        
        /// <summary>
        /// Per 2000 ISDA Definitions, Section 4.11. FRN Convention; Eurodollar Convention. FRN is included here as a type of business day convention although it does not strictly fall within ISDA&apos;s definition of a Business Day Convention and does not conform to the simple definition given above.
        /// </summary>
        FRN,
        
        /// <summary>
        /// The non-business date will be adjusted to the first following day that is a business day unless that day falls in the next calendar month, in which case that date will be the first preceding day that is a business day.
        /// </summary>
        MODFOLLOWING,
        
        /// <summary>
        /// The non-business date will be adjusted to the first preceding day that is a business day unless that day falls in the previous calendar month, in which case that date will be the first following day that us a business day.
        /// </summary>
        MODPRECEDING,
        
        /// <summary>
        /// The non-business date will be adjusted to the nearest day that is a business day - i.e. if the non-business day falls on any day other than a Sunday or a Monday, it will be the first preceding day that is a business day, and will be the first following business day if it falls on a Sunday or a Monday.
        /// </summary>
        NEAREST,
        
        /// <summary>
        /// The date will not be adjusted if it falls on a day that is not a business day.
        /// </summary>
        NONE,
        
        /// <summary>
        /// The date adjustments conventions are defined elsewhere, so it is not required to specify them here.
        /// </summary>
        [EnumMember(Value = "NOT_APPLICABLE")]
        NotApplicable,
        
        /// <summary>
        /// The non-business day will be adjusted to the first preceding day that is a business day.
        /// </summary>
        PRECEDING
    }
    
    /// <summary>
    /// What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
    /// </summary>
    [CdmName("CalculationMethodEnum")]
    public enum CalculationMethod
    {
        /// <summary>
        /// Averaging, i.e. arithmetic averaging.
        /// </summary>
        [EnumMember(Value = "AVERAGING")]
        Averaging,
        
        /// <summary>
        /// A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula.
        /// </summary>
        [EnumMember(Value = "COMPOUNDED_INDEX")]
        CompoundedIndex,
        
        /// <summary>
        /// Compounding, i.e. geometric averaging following an ISDA defined formula.
        /// </summary>
        [EnumMember(Value = "COMPOUNDING")]
        Compounding
    }
    
    /// <summary>
    ///  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
    /// </summary>
    [CdmName("CalculationShiftMethodEnum")]
    public enum CalculationShiftMethod
    {
        /// <summary>
        /// Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days.
        /// </summary>
        [EnumMember(Value = "LOOKBACK")]
        Lookback,
        
        /// <summary>
        /// calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style.
        /// </summary>
        [EnumMember(Value = "NO_SHIFT")]
        NoShift,
        
        /// <summary>
        /// the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period.
        /// </summary>
        [EnumMember(Value = "OBSERVATION_PERIOD_SHIFT")]
        ObservationPeriodShift,
        
        /// <summary>
        /// Calculations cut the rate off several business days prior to rate setting (Lockout).
        /// </summary>
        [EnumMember(Value = "RATE_CUT_OFF")]
        RateCutOff
    }
    
    /// <summary>
    /// Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call.
    /// </summary>
    [CdmName("CallTypeEnum")]
    public enum CallType
    {
        /// <summary>
        /// Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement.
        /// </summary>
        [EnumMember(Value = "EXPECTED_CALL")]
        ExpectedCall,
        
        /// <summary>
        /// Identifies an actionable Margin Call.
        /// </summary>
        [EnumMember(Value = "MARGIN_CALL")]
        MarginCall,
        
        /// <summary>
        /// Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent.
        /// </summary>
        [EnumMember(Value = "NOTIFICATION")]
        Notification
    }
    
    /// <summary>
    /// Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
    /// </summary>
    [CdmName("CallingPartyEnum")]
    public enum CallingParty
    {
        /// <summary>
        /// As defined in Master Agreement.
        /// </summary>
        [EnumMember(Value = "AS_DEFINED_IN_MASTER_AGREEMENT")]
        AsDefinedInMasterAgreement,
        
        /// <summary>
        /// Either, Buyer or Seller to the repo transaction.
        /// </summary>
        [EnumMember(Value = "EITHER")]
        Either,
        
        /// <summary>
        /// Initial buyer to the repo transaction.
        /// </summary>
        [EnumMember(Value = "INITIAL_BUYER")]
        InitialBuyer,
        
        /// <summary>
        /// Initial seller to the repo transaction.
        /// </summary>
        [EnumMember(Value = "INITIAL_SELLER")]
        InitialSeller
    }
    
    /// <summary>
    /// Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
    /// </summary>
    [CdmName("CapacityUnitEnum")]
    public enum CapacityUnit
    {
        /// <summary>
        /// Denotes Allowances as standard unit.
        /// </summary>
        ALW,
        
        /// <summary>
        /// Denotes a Barrel as a standard unit.
        /// </summary>
        BBL,
        
        /// <summary>
        /// Denotes Billion Cubic Feet as a standard unit.
        /// </summary>
        BCF,
        
        /// <summary>
        /// Denotes Board Feet as a standard unit.
        /// </summary>
        BDFT,
        
        /// <summary>
        /// Denotes Cubic Meters as a standard unit.
        /// </summary>
        CBM,
        
        /// <summary>
        /// Denotes Certified Emissions Reduction as a standard unit.
        /// </summary>
        CER,
        
        /// <summary>
        /// Denotes Climate Reserve Tonnes as a standard unit.
        /// </summary>
        CRT,
        
        /// <summary>
        /// Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
        /// </summary>
        DAG,
        
        /// <summary>
        /// Denotes a single day as a standard unit used in time charter trades.
        /// </summary>
        DAY,
        
        /// <summary>
        /// Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
        /// </summary>
        DMTU,
        
        /// <summary>
        /// Denotes Environmental Credit as a standard unit.
        /// </summary>
        ENVCRD,
        
        /// <summary>
        /// Denotes Environmental Offset as a standard unit.
        /// </summary>
        ENVOFST,
        
        /// <summary>
        /// Denotes a 40 ft. Equivalent Unit container as a standard unit.
        /// </summary>
        FEU,
        
        /// <summary>
        /// Denotes a Gram as a standard unit.
        /// </summary>
        G,
        
        /// <summary>
        /// Denotes a GB Bushel as a standard unit.
        /// </summary>
        GBBSH,
        
        /// <summary>
        /// Denotes a GB British Thermal Unit as a standard unit.
        /// </summary>
        GBBTU,
        
        /// <summary>
        /// Denotes a GB Hundredweight unit as standard unit.
        /// </summary>
        GBCWT,
        
        /// <summary>
        /// Denotes a GB Gallon unit as standard unit.
        /// </summary>
        GBGAL,
        
        /// <summary>
        /// Denotes a Thousand GB British Thermal Units as a standard unit.
        /// </summary>
        GBMBTU,
        
        /// <summary>
        /// Denotes a Million GB British Thermal Units as a standard unit.
        /// </summary>
        GBMMBTU,
        
        /// <summary>
        /// Denotes a GB Ton as a standard unit.
        /// </summary>
        GBT,
        
        /// <summary>
        /// Denotes a GB Thermal Unit as a standard unit.
        /// </summary>
        GBTHM,
        
        /// <summary>
        /// Denotes a Gigajoule as a standard unit.
        /// </summary>
        GJ,
        
        /// <summary>
        /// Denotes a Gigawatt as a standard unit.
        /// </summary>
        GW,
        
        /// <summary>
        /// Denotes a Gigawatt-hour as a standard unit.
        /// </summary>
        GWH,
        
        /// <summary>
        /// Denotes a Hectolitre as a standard unit.
        /// </summary>
        HL,
        
        /// <summary>
        /// Denotes a 100-troy ounces Gold Bar as a standard unit.
        /// </summary>
        HOGB,
        
        /// <summary>
        /// Denotes an ISO British Thermal Unit as a standard unit.
        /// </summary>
        ISOBTU,
        
        /// <summary>
        /// Denotes a Thousand ISO British Thermal Unit as a standard unit.
        /// </summary>
        ISOMBTU,
        
        /// <summary>
        /// Denotes a Million ISO British Thermal Unit as a standard unit.
        /// </summary>
        ISOMMBTU,
        
        /// <summary>
        /// Denotes an ISO Thermal Unit as a standard unit.
        /// </summary>
        ISOTHM,
        
        /// <summary>
        /// Denotes a Joule as a standard unit.
        /// </summary>
        J,
        
        /// <summary>
        /// Denotes a Kilogram as a standard unit.
        /// </summary>
        KG,
        
        /// <summary>
        /// Denotes a Kilolitre as a standard unit.
        /// </summary>
        KL,
        
        /// <summary>
        /// Denotes a Kilowatt as a standard unit.
        /// </summary>
        KW,
        
        /// <summary>
        /// Denotes a Kilowatt-day as a standard unit.
        /// </summary>
        KWD,
        
        /// <summary>
        /// Denotes a Kilowatt-hour as a standard unit.
        /// </summary>
        KWH,
        
        /// <summary>
        /// Denotes a Kilowatt-month as a standard unit.
        /// </summary>
        KWM,
        
        /// <summary>
        /// Denotes a Kilowatt-minute as a standard unit.
        /// </summary>
        KWMIN,
        
        /// <summary>
        /// Denotes a Kilowatt-year as a standard unit.
        /// </summary>
        KWY,
        
        /// <summary>
        /// Denotes a Litre as a standard unit.
        /// </summary>
        L,
        
        /// <summary>
        /// Denotes a Pound as a standard unit.
        /// </summary>
        LB,
        
        /// <summary>
        /// Denotes a Thousand Barrels as a standard unit.
        /// </summary>
        MB,
        
        /// <summary>
        /// Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
        /// </summary>
        MBF,
        
        /// <summary>
        /// Denotes a Megajoule as a standard unit.
        /// </summary>
        MJ,
        
        /// <summary>
        /// Denotes a Million Barrels as a standard unit.
        /// </summary>
        MMBBL,
        
        /// <summary>
        /// Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
        /// </summary>
        MMBF,
        
        /// <summary>
        /// Denotes a Thousand square feet as a standard unit.
        /// </summary>
        MSF,
        
        /// <summary>
        /// Denotes a Metric Ton as a standard unit.
        /// </summary>
        MT,
        
        /// <summary>
        /// Denotes a Megawatt as a standard unit.
        /// </summary>
        MW,
        
        /// <summary>
        /// Denotes a Megawatt-day as a standard unit.
        /// </summary>
        MWD,
        
        /// <summary>
        /// Denotes a Megawatt-hour as a standard unit.
        /// </summary>
        MWH,
        
        /// <summary>
        /// Denotes a Megawatt-month as a standard unit.
        /// </summary>
        MWM,
        
        /// <summary>
        /// Denotes a Megawatt-minute as a standard unit.
        /// </summary>
        MWMIN,
        
        /// <summary>
        /// Denotes a Megawatt-year as a standard unit.
        /// </summary>
        MWY,
        
        /// <summary>
        /// Denotes a Troy Ounce as a standard unit.
        /// </summary>
        OZT,
        
        /// <summary>
        /// Denotes a Standard Gold Bar as a standard unit.
        /// </summary>
        SGB,
        
        /// <summary>
        /// Denotes a 20 ft. Equivalent Unit container as a standard unit.
        /// </summary>
        TEU,
        
        /// <summary>
        /// Denotes a US Bushel as a standard unit.
        /// </summary>
        USBSH,
        
        /// <summary>
        /// Denotes a US British Thermal Unit as a standard unit.
        /// </summary>
        USBTU,
        
        /// <summary>
        /// Denotes US Hundredweight unit as a standard unit.
        /// </summary>
        USCWT,
        
        /// <summary>
        /// Denotes a US Gallon unit as a standard unit.
        /// </summary>
        USGAL,
        
        /// <summary>
        /// Denotes a Thousand US British Thermal Units as a standard unit.
        /// </summary>
        USMBTU,
        
        /// <summary>
        /// Denotes a Million US British Thermal Units as a standard unit.
        /// </summary>
        USMMBTU,
        
        /// <summary>
        /// Denotes a US Ton as a standard unit.
        /// </summary>
        UST,
        
        /// <summary>
        /// Denotes a US Thermal Unit as a standard unit.
        /// </summary>
        USTHM
    }
    
    /// <summary>
    /// Provides a list of possible types of cash prices, applicable when PriceTypeEnum is itself of type CashPrice.
    /// </summary>
    [CdmName("CashPriceTypeEnum")]
    public enum CashPriceType
    {
        /// <summary>
        /// Denotes a discount factor expressed as a decimal, e.g. 0.95.
        /// </summary>
        [EnumMember(Value = "DISCOUNT")]
        Discount,
        
        /// <summary>
        /// A generic term for describing a non-scheduled cashflow that can be associated either with the initial contract, with some later corrections to it (e.g. a correction to the day count fraction that has a cashflow impact) or with some lifecycle events. Fees that are specifically associated with termination and partial termination, increase, amendment, and exercise events are qualified accordingly.
        /// </summary>
        [EnumMember(Value = "FEE")]
        Fee,
        
        /// <summary>
        /// Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
        /// </summary>
        [EnumMember(Value = "PREMIUM")]
        Premium
    }
    
    /// <summary>
    /// Defines the different cash settlement methods for a product where cash settlement is applicable.
    /// </summary>
    [CdmName("CashSettlementMethodEnum")]
    public enum CashSettlementMethod
    {
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
        /// </summary>
        [EnumMember(Value = "CASH_PRICE_ALTERNATE_METHOD")]
        CashPriceAlternateMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
        /// </summary>
        [EnumMember(Value = "CASH_PRICE_METHOD")]
        CashPriceMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
        /// </summary>
        [EnumMember(Value = "COLLATERALIZED_CASH_PRICE_METHOD")]
        CollateralizedCashPriceMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
        /// </summary>
        [EnumMember(Value = "CROSS_CURRENCY_METHOD")]
        CrossCurrencyMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
        /// </summary>
        [EnumMember(Value = "MID_MARKET_CALCULATION_AGENT_DETERMINATION")]
        MidMarketCalculationAgentDetermination,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
        /// </summary>
        [EnumMember(Value = "MID_MARKET_INDICATIVE_QUOTATIONS")]
        MidMarketIndicativeQuotations,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
        /// </summary>
        [EnumMember(Value = "MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE")]
        MidMarketIndicativeQuotationsAlternate,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
        /// </summary>
        [EnumMember(Value = "PAR_YIELD_CURVE_ADJUSTED_METHOD")]
        ParYieldCurveAdjustedMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
        /// </summary>
        [EnumMember(Value = "PAR_YIELD_CURVE_UNADJUSTED_METHOD")]
        ParYieldCurveUnadjustedMethod,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
        /// </summary>
        [EnumMember(Value = "REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION")]
        ReplacementValueCalculationAgentDetermination,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
        /// </summary>
        [EnumMember(Value = "REPLACEMENT_VALUE_FIRM_QUOTATIONS")]
        ReplacementValueFirmQuotations,
        
        /// <summary>
        /// An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
        /// </summary>
        [EnumMember(Value = "ZERO_COUPON_YIELD_ADJUSTED_METHOD")]
        ZeroCouponYieldAdjustedMethod
    }
    
    /// <summary>
    /// The enumerated values to specify what led to the contract or execution closure.
    /// </summary>
    [CdmName("ClosedStateEnum")]
    public enum ClosedState
    {
        /// <summary>
        /// The execution or contract has been allocated.
        /// </summary>
        [EnumMember(Value = "ALLOCATED")]
        Allocated,
        
        /// <summary>
        /// The execution or contract has been cancelled.
        /// </summary>
        [EnumMember(Value = "CANCELLED")]
        Cancelled,
        
        /// <summary>
        /// The (option) contract has been exercised.
        /// </summary>
        [EnumMember(Value = "EXERCISED")]
        Exercised,
        
        /// <summary>
        /// The (option) contract has expired without being exercised.
        /// </summary>
        [EnumMember(Value = "EXPIRED")]
        Expired,
        
        /// <summary>
        /// The contract has reached its contractual termination date.
        /// </summary>
        [EnumMember(Value = "MATURED")]
        Matured,
        
        /// <summary>
        /// The contract has been novated. This state applies to the stepped-out contract component of the novation event.
        /// </summary>
        [EnumMember(Value = "NOVATED")]
        Novated,
        
        /// <summary>
        /// The contract has been subject of an early termination event.
        /// </summary>
        [EnumMember(Value = "TERMINATED")]
        Terminated
    }
    
    /// <summary>
    /// How is collateral interest to be handled?
    /// </summary>
    [CdmName("CollateralInterestHandlingEnum")]
    public enum CollateralInterestHandling
    {
        /// <summary>
        ///  Adjust the collateral balance to include the interest amount 
        /// </summary>
        [EnumMember(Value = "ADJUST")]
        Adjust,
        
        /// <summary>
        ///  Transfer the interest each period 
        /// </summary>
        [EnumMember(Value = "TRANSFER")]
        Transfer,
        
        /// <summary>
        ///  Transfer the interest if it meets certain criteria, or otherwise adjust the collateral balance to reflect the interest amount  
        /// </summary>
        [EnumMember(Value = "TRANSFER_OR_ADJUST")]
        Transfer_or_Adjust
    }
    
    /// <summary>
    /// The enumerated values to specify the type of margin for which a legal agreement is named.
    /// </summary>
    [CdmName("CollateralMarginTypeEnum")]
    public enum CollateralMarginType
    {
        /// <summary>
        /// Denotes a margin agreement that is identified for use with Initial Margin/IM.
        /// </summary>
        [EnumMember(Value = "INITIAL_MARGIN")]
        InitialMargin,
        
        /// <summary>
        /// Denotes a margin agreement that is identified for use with Variation Margin/VM.
        /// </summary>
        [EnumMember(Value = "VARIATION_MARGIN")]
        VariationMargin
    }
    
    /// <summary>
    /// Represents the enumeration list to identify the settlement status of the collateral.
    /// </summary>
    [CdmName("CollateralStatusEnum")]
    public enum CollateralStatus
    {
        /// <summary>
        /// Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement.
        /// </summary>
        [EnumMember(Value = "FULL_AMOUNT")]
        FullAmount,
        
        /// <summary>
        /// Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s.
        /// </summary>
        [EnumMember(Value = "IN_TRANSIT_AMOUNT")]
        InTransitAmount,
        
        /// <summary>
        /// Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s.
        /// </summary>
        [EnumMember(Value = "SETTLED_AMOUNT")]
        SettledAmount
    }
    
    /// <summary>
    /// Specifies the types of collateral that are accepted by the Lender
    /// </summary>
    [CdmName("CollateralTypeEnum")]
    public enum CollateralType
    {
        /// <summary>
        /// Security Lending Trades against Cash collateral
        /// </summary>
        [EnumMember(Value = "CASH")]
        Cash,
        
        /// <summary>
        /// Security Lending Trades against CashPool collateral
        /// </summary>
        [EnumMember(Value = "CASH_POOL")]
        CashPool,
        
        /// <summary>
        /// Security Lending Trades against NonCash collateral
        /// </summary>
        [EnumMember(Value = "NON_CASH")]
        NonCash
    }
    
    [CdmName("CommodityBusinessCalendarEnum")]
    public enum CommodityBusinessCalendar
    {
        /// <summary>
        /// Abu Dhabi Securities Exchange https://www.adx.ae/
        /// </summary>
        ADSM,
        
        /// <summary>
        /// Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer
        /// </summary>
        [EnumMember(Value = "AGRUS-FMB")]
        AGRUS_FMB,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        APPI,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ARGUS-CRUDE")]
        ARGUS_CRUDE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ARGUS-EUROPEAN-GAS")]
        ARGUS_EUROPEAN_GAS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ARGUS-EUROPEAN-PRODUCTS")]
        ARGUS_EUROPEAN_PRODUCTS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ARGUS-INTERNATIONAL-LPG")]
        ARGUS_INTERNATIONAL_LPG,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ARGUS-MCCLOSKEYS-COAL-REPORT")]
        ARGUS_MCCLOSKEYS_COAL_REPORT,
        
        /// <summary>
        /// The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products
        /// </summary>
        [EnumMember(Value = "ARGUS-US-PRODUCTS")]
        ARGUS_US_PRODUCTS,
        
        /// <summary>
        /// Australian Securities Exchange http://www.asx.com.au/
        /// </summary>
        ASX,
        
        /// <summary>
        /// Australian Wheat Board. www.awb.com.au
        /// </summary>
        AWB,
        
        /// <summary>
        /// Australian Wool Exchange. http://www.awex.com.au/home.html
        /// </summary>
        AWEX,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "BALTIC-EXCHANGE")]
        BALTIC_EXCHANGE,
        
        /// <summary>
        /// The business calendar of the Bank Negara Malaysia Policy Committee.
        /// </summary>
        [EnumMember(Value = "BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE")]
        BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE,
        
        /// <summary>
        /// The business calendar for the Belpex power exchange (www.belpex.be).
        /// </summary>
        BELPEX,
        
        /// <summary>
        /// BlueNext Power Market.
        /// </summary>
        BLUENEXT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "BM&F")]
        BM_F,
        
        /// <summary>
        /// The settlement business calendar for Bursa Malaysia.
        /// </summary>
        [EnumMember(Value = "BURSA-MALAYSIA-SETTLEMENT")]
        BURSA_MALAYSIA_SETTLEMENT,
        
        /// <summary>
        /// The trading business calendar for Bursa Malaysia.
        /// </summary>
        [EnumMember(Value = "BURSA-MALAYSIA-TRADING")]
        BURSA_MALAYSIA_TRADING,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CANADIAN-GAS-PRICE-REPORTER")]
        CANADIAN_GAS_PRICE_REPORTER,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CBOT-SOFT")]
        CBOT_SOFT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CMAI-AROMATICS-MARKET-REPORT")]
        CMAI_AROMATICS_MARKET_REPORT,
        
        /// <summary>
        /// CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&amp;rd=cmai
        /// </summary>
        [EnumMember(Value = "CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT")]
        CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CMAI-METHANOL-MARKET-REPORT")]
        CMAI_METHANOL_MARKET_REPORT,
        
        /// <summary>
        /// CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&amp;rd=cmai
        /// </summary>
        [EnumMember(Value = "CMAI-MONOMERS-MARKET-REPORT")]
        CMAI_MONOMERS_MARKET_REPORT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CME-DAIRY")]
        CME_DAIRY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CME-NON-DAIRY-SOFT")]
        CME_NON_DAIRY_SOFT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        COMEX,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        CRU,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "CRU-LONG")]
        CRU_LONG,
        
        /// <summary>
        /// The business calendar for statistical publications by the by the United States Department of Energy (DOE).
        /// </summary>
        [EnumMember(Value = "DEPARTMENT-OF-ENERGY")]
        DEPARTMENT_OF_ENERGY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "DEWITT-BENZENE-DERIVATIVES")]
        DEWITT_BENZENE_DERIVATIVES,
        
        /// <summary>
        /// Dubai Mercantile Exchange. http://www.dubaimerc.com/
        /// </summary>
        DME,
        
        /// <summary>
        /// Dow Jones US Calendar. http://www.dowjones.com/
        /// </summary>
        [EnumMember(Value = "DOW-JONES")]
        DOW_JONES,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "DOW-JONES-ENERGY-SERVICE")]
        DOW_JONES_ENERGY_SERVICE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "DOW_JONES_POWER")]
        DowJonesPower,
        
        /// <summary>
        /// European Energy Exchange-Coal
        /// </summary>
        [EnumMember(Value = "EEX-COAL")]
        EEX_COAL,
        
        /// <summary>
        /// European Energy Exchange-Emissions Rights
        /// </summary>
        [EnumMember(Value = "EEX-EMISSIONS")]
        EEX_EMISSIONS,
        
        /// <summary>
        /// European Energy Exchange-Gas
        /// </summary>
        [EnumMember(Value = "EEX-GAS")]
        EEX_GAS,
        
        /// <summary>
        /// European Energy Exchange-Power
        /// </summary>
        [EnumMember(Value = "EEX-POWER")]
        EEX_POWER,
        
        /// <summary>
        /// TBD.
        /// </summary>
        [EnumMember(Value = "EURONEX-MATIF")]
        EURONEX_MATIF,
        
        /// <summary>
        /// FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp
        /// </summary>
        FERTECON,
        
        /// <summary>
        /// Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek
        /// </summary>
        [EnumMember(Value = "FERTILIZER-WEEK")]
        FERTILIZER_WEEK,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "GAS-DAILY")]
        GAS_DAILY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "GAS-DAILY-PRICE-GUIDE")]
        GAS_DAILY_PRICE_GUIDE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        GLOBALCOAL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "HEREN-REPORT")]
        HEREN_REPORT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ICE/10X-DAILY")]
        ICE_10X_DAILY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ICE/10X-MONTHLY")]
        ICE_10X_MONTHLY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ICE-CANADA")]
        ICE_CANADA,
        
        /// <summary>
        /// European Climate Exchange.
        /// </summary>
        [EnumMember(Value = "ICE-ECX")]
        ICE_ECX,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ICE-GAS")]
        ICE_GAS,
        
        /// <summary>
        /// The business calendar oil and refined product contracts on ICE Futures Europe.
        /// </summary>
        [EnumMember(Value = "ICE-OIL")]
        ICE_OIL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "ICE-US-AGRICULTURAL")]
        ICE_US_AGRICULTURAL,
        
        /// <summary>
        /// The business calendar for publication of ICIS Benzene (Europe) data.
        /// </summary>
        [EnumMember(Value = "ICIS-PRICING-BENZENE-(EUROPE)")]
        ICIS_PRICING_BENZENE__EUROPE_,
        
        /// <summary>
        /// The business calendar for publication of ICIS Ethylene (Europe) data.
        /// </summary>
        [EnumMember(Value = "ICIS-PRICING-ETHYLENE-(EUROPE)")]
        ICIS_PRICING_ETHYLENE__EUROPE_,
        
        /// <summary>
        /// The business calendar for publication of ICIS Polyproylene (Europe) data.
        /// </summary>
        [EnumMember(Value = "ICIS-PRICING-POLYPROPYLENE-(EUROPE)")]
        ICIS_PRICING_POLYPROPYLENE__EUROPE_,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "INSIDE-FERC")]
        INSIDE_FERC,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "JAPAN-MOF-TSRR")]
        JAPAN_MOF_TSRR,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        KCBOT,
        
        /// <summary>
        /// The banking business calendar in Kuala Lumpur.
        /// </summary>
        [EnumMember(Value = "KUALA-LUMPUR-BANK")]
        KUALA_LUMPUR_BANK,
        
        /// <summary>
        /// The business calendar for the Labuan Bank (Malaysia).
        /// </summary>
        [EnumMember(Value = "LABUAN-BANK")]
        LABUAN_BANK,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "LIFFE-LONDON-SOFT")]
        LIFFE_LONDON_SOFT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        LME,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "LONDON-BULLION-MARKET")]
        LONDON_BULLION_MARKET,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "LONDON-BULLION-MARKET-GOLD-A.M-ONLY")]
        LONDON_BULLION_MARKET_GOLD_A_M_ONLY,
        
        /// <summary>
        /// The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium.
        /// </summary>
        [EnumMember(Value = "LONDON-PLATINUM-PALLADIUM-MARKET")]
        LONDON_PLATINUM_PALLADIUM_MARKET,
        
        /// <summary>
        /// Minneapolis Grain Exchange http://www.mgex.com/
        /// </summary>
        MGEX,
        
        /// <summary>
        /// The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex).
        /// </summary>
        N2EX,
        
        /// <summary>
        /// NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities
        /// </summary>
        [EnumMember(Value = "NASDAQ-OMX")]
        NASDAQ_OMX,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "NATURAL-GAS-WEEK")]
        NATURAL_GAS_WEEK,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Article XIV.
        /// </summary>
        NERC,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        NGI,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        NGX,
        
        /// <summary>
        /// The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php
        /// </summary>
        [EnumMember(Value = "NUCLEAR-MARKET-REVIEW")]
        NUCLEAR_MARKET_REVIEW,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "NYMEX-ELECTRICITY")]
        NYMEX_ELECTRICITY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "NYMEX-GAS")]
        NYMEX_GAS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "NYMEX-NATURAL-GAS")]
        NYMEX_NATURAL_GAS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "NYMEX-OIL")]
        NYMEX_OIL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "OFFICIAL-BOARD-MARKETS")]
        OFFICIAL_BOARD_MARKETS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "OPIS-LP-GAS")]
        OPIS_LP_GAS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "OPIS-PROPANE")]
        OPIS_PROPANE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PAPER-PACKAGING-MONITOR")]
        PAPER_PACKAGING_MONITOR,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PAPER-TRADER")]
        PAPER_TRADER,
        
        /// <summary>
        /// Pertamina-Indonesia. http://www.pertamina.com/
        /// </summary>
        PERTAMINA,
        
        /// <summary>
        /// PetroChemWire Publication Calendar. http://www.petrochemwire.com/
        /// </summary>
        PETROCHEMWIRE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PIX-PULP-BENCHMARK-INDICES")]
        PIX_PULP_BENCHMARK_INDICES,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-APAG-MARKETSCAN")]
        PLATTS_APAG_MARKETSCAN,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-BUNKERWIRE")]
        PLATTS_BUNKERWIRE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-CLEAN-TANKERWIRE")]
        PLATTS_CLEAN_TANKERWIRE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-CRUDE-OIL-MARKETWIRE")]
        PLATTS_CRUDE_OIL_MARKETWIRE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-DIRTY-TANKERWIRE")]
        PLATTS_DIRTY_TANKERWIRE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-EUROPEAN-GAS")]
        PLATTS_EUROPEAN_GAS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-EUROPEAN-MARKETSCAN")]
        PLATTS_EUROPEAN_MARKETSCAN,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-METALS-ALERT")]
        PLATTS_METALS_ALERT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-OILGRAM")]
        PLATTS_OILGRAM,
        
        /// <summary>
        /// The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore
        /// </summary>
        [EnumMember(Value = "PLATTS-TSI-IRON-ORE")]
        PLATTS_TSI_IRON_ORE,
        
        /// <summary>
        /// The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices
        /// </summary>
        [EnumMember(Value = "PLATTS-TSI-SCRAP")]
        PLATTS_TSI_SCRAP,
        
        /// <summary>
        /// The Steel Index. http://www.thesteelindex.com/en/price-specifications
        /// </summary>
        [EnumMember(Value = "PLATTS-TSI-STEEL")]
        PLATTS_TSI_STEEL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PLATTS-US-MARKETSCAN")]
        PLATTS_US_MARKETSCAN,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PULP-AND-PAPER-INTERNATIONAL")]
        PULP_AND_PAPER_INTERNATIONAL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "PULP-AND-PAPER-WEEK")]
        PULP_AND_PAPER_WEEK,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "RIM-PRODUCTS-INTELLIGENCE-DAILY")]
        RIM_PRODUCTS_INTELLIGENCE_DAILY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "SAFEX-SOFT")]
        SAFEX_SOFT,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "SFE-SOFT")]
        SFE_SOFT,
        
        /// <summary>
        /// Singapore Exchange. www.sgx.com
        /// </summary>
        SGX,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        SICOM,
        
        /// <summary>
        /// Standard and Poor&apos;s GSCI. http://us.spindices.com/index-family/commodities/sp-gsci
        /// </summary>
        [EnumMember(Value = "SP-GSCI")]
        SP_GSCI,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "STATISTICHES-BUNDESAMT")]
        STATISTICHES_BUNDESAMT,
        
        /// <summary>
        /// Tokyo Grain Exchange. www.tge.or.jp
        /// </summary>
        TGE,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "TOCOM-OIL")]
        TOCOM_OIL,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "TOCOM-PRECIOUS")]
        TOCOM_PRECIOUS,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "TOCOM-SOFT")]
        TOCOM_SOFT,
        
        /// <summary>
        /// The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx
        /// </summary>
        [EnumMember(Value = "UX-WEEKLY")]
        UX_WEEKLY,
        
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
        /// </summary>
        [EnumMember(Value = "WORLD-PULP-MONTHLY")]
        WORLD_PULP_MONTHLY
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this CommodityBusinessCalendar value)
        {
            return value switch
            {
                CommodityBusinessCalendar.AGRUS_FMB => "AGRUS-FMB",
                CommodityBusinessCalendar.ARGUS_CRUDE => "ARGUS-CRUDE",
                CommodityBusinessCalendar.ARGUS_EUROPEAN_GAS => "ARGUS-EUROPEAN-GAS",
                CommodityBusinessCalendar.ARGUS_EUROPEAN_PRODUCTS => "ARGUS-EUROPEAN-PRODUCTS",
                CommodityBusinessCalendar.ARGUS_INTERNATIONAL_LPG => "ARGUS-INTERNATIONAL-LPG",
                CommodityBusinessCalendar.ARGUS_MCCLOSKEYS_COAL_REPORT => "ARGUS-MCCLOSKEYS-COAL-REPORT",
                CommodityBusinessCalendar.ARGUS_US_PRODUCTS => "ARGUS-US-PRODUCTS",
                CommodityBusinessCalendar.BALTIC_EXCHANGE => "BALTIC-EXCHANGE",
                CommodityBusinessCalendar.BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE => "BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE",
                CommodityBusinessCalendar.BM_F => "BM&F",
                CommodityBusinessCalendar.BURSA_MALAYSIA_SETTLEMENT => "BURSA-MALAYSIA-SETTLEMENT",
                CommodityBusinessCalendar.BURSA_MALAYSIA_TRADING => "BURSA-MALAYSIA-TRADING",
                CommodityBusinessCalendar.CANADIAN_GAS_PRICE_REPORTER => "CANADIAN-GAS-PRICE-REPORTER",
                CommodityBusinessCalendar.CBOT_SOFT => "CBOT-SOFT",
                CommodityBusinessCalendar.CMAI_AROMATICS_MARKET_REPORT => "CMAI-AROMATICS-MARKET-REPORT",
                CommodityBusinessCalendar.CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT => "CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT",
                CommodityBusinessCalendar.CMAI_METHANOL_MARKET_REPORT => "CMAI-METHANOL-MARKET-REPORT",
                CommodityBusinessCalendar.CMAI_MONOMERS_MARKET_REPORT => "CMAI-MONOMERS-MARKET-REPORT",
                CommodityBusinessCalendar.CME_DAIRY => "CME-DAIRY",
                CommodityBusinessCalendar.CME_NON_DAIRY_SOFT => "CME-NON-DAIRY-SOFT",
                CommodityBusinessCalendar.CRU_LONG => "CRU-LONG",
                CommodityBusinessCalendar.DEPARTMENT_OF_ENERGY => "DEPARTMENT-OF-ENERGY",
                CommodityBusinessCalendar.DEWITT_BENZENE_DERIVATIVES => "DEWITT-BENZENE-DERIVATIVES",
                CommodityBusinessCalendar.DOW_JONES => "DOW-JONES",
                CommodityBusinessCalendar.DOW_JONES_ENERGY_SERVICE => "DOW-JONES-ENERGY-SERVICE",
                CommodityBusinessCalendar.EEX_COAL => "EEX-COAL",
                CommodityBusinessCalendar.EEX_EMISSIONS => "EEX-EMISSIONS",
                CommodityBusinessCalendar.EEX_GAS => "EEX-GAS",
                CommodityBusinessCalendar.EEX_POWER => "EEX-POWER",
                CommodityBusinessCalendar.EURONEX_MATIF => "EURONEX-MATIF",
                CommodityBusinessCalendar.FERTILIZER_WEEK => "FERTILIZER-WEEK",
                CommodityBusinessCalendar.GAS_DAILY => "GAS-DAILY",
                CommodityBusinessCalendar.GAS_DAILY_PRICE_GUIDE => "GAS-DAILY-PRICE-GUIDE",
                CommodityBusinessCalendar.HEREN_REPORT => "HEREN-REPORT",
                CommodityBusinessCalendar.ICE_10X_DAILY => "ICE/10X-DAILY",
                CommodityBusinessCalendar.ICE_10X_MONTHLY => "ICE/10X-MONTHLY",
                CommodityBusinessCalendar.ICE_CANADA => "ICE-CANADA",
                CommodityBusinessCalendar.ICE_ECX => "ICE-ECX",
                CommodityBusinessCalendar.ICE_GAS => "ICE-GAS",
                CommodityBusinessCalendar.ICE_OIL => "ICE-OIL",
                CommodityBusinessCalendar.ICE_US_AGRICULTURAL => "ICE-US-AGRICULTURAL",
                CommodityBusinessCalendar.ICIS_PRICING_BENZENE__EUROPE_ => "ICIS-PRICING-BENZENE-(EUROPE)",
                CommodityBusinessCalendar.ICIS_PRICING_ETHYLENE__EUROPE_ => "ICIS-PRICING-ETHYLENE-(EUROPE)",
                CommodityBusinessCalendar.ICIS_PRICING_POLYPROPYLENE__EUROPE_ => "ICIS-PRICING-POLYPROPYLENE-(EUROPE)",
                CommodityBusinessCalendar.INSIDE_FERC => "INSIDE-FERC",
                CommodityBusinessCalendar.JAPAN_MOF_TSRR => "JAPAN-MOF-TSRR",
                CommodityBusinessCalendar.KUALA_LUMPUR_BANK => "KUALA-LUMPUR-BANK",
                CommodityBusinessCalendar.LABUAN_BANK => "LABUAN-BANK",
                CommodityBusinessCalendar.LIFFE_LONDON_SOFT => "LIFFE-LONDON-SOFT",
                CommodityBusinessCalendar.LONDON_BULLION_MARKET => "LONDON-BULLION-MARKET",
                CommodityBusinessCalendar.LONDON_BULLION_MARKET_GOLD_A_M_ONLY => "LONDON-BULLION-MARKET-GOLD-A.M-ONLY",
                CommodityBusinessCalendar.LONDON_PLATINUM_PALLADIUM_MARKET => "LONDON-PLATINUM-PALLADIUM-MARKET",
                CommodityBusinessCalendar.NASDAQ_OMX => "NASDAQ-OMX",
                CommodityBusinessCalendar.NATURAL_GAS_WEEK => "NATURAL-GAS-WEEK",
                CommodityBusinessCalendar.NUCLEAR_MARKET_REVIEW => "NUCLEAR-MARKET-REVIEW",
                CommodityBusinessCalendar.NYMEX_ELECTRICITY => "NYMEX-ELECTRICITY",
                CommodityBusinessCalendar.NYMEX_GAS => "NYMEX-GAS",
                CommodityBusinessCalendar.NYMEX_NATURAL_GAS => "NYMEX-NATURAL-GAS",
                CommodityBusinessCalendar.NYMEX_OIL => "NYMEX-OIL",
                CommodityBusinessCalendar.OFFICIAL_BOARD_MARKETS => "OFFICIAL-BOARD-MARKETS",
                CommodityBusinessCalendar.OPIS_LP_GAS => "OPIS-LP-GAS",
                CommodityBusinessCalendar.OPIS_PROPANE => "OPIS-PROPANE",
                CommodityBusinessCalendar.PAPER_PACKAGING_MONITOR => "PAPER-PACKAGING-MONITOR",
                CommodityBusinessCalendar.PAPER_TRADER => "PAPER-TRADER",
                CommodityBusinessCalendar.PIX_PULP_BENCHMARK_INDICES => "PIX-PULP-BENCHMARK-INDICES",
                CommodityBusinessCalendar.PLATTS_APAG_MARKETSCAN => "PLATTS-APAG-MARKETSCAN",
                CommodityBusinessCalendar.PLATTS_BUNKERWIRE => "PLATTS-BUNKERWIRE",
                CommodityBusinessCalendar.PLATTS_CLEAN_TANKERWIRE => "PLATTS-CLEAN-TANKERWIRE",
                CommodityBusinessCalendar.PLATTS_CRUDE_OIL_MARKETWIRE => "PLATTS-CRUDE-OIL-MARKETWIRE",
                CommodityBusinessCalendar.PLATTS_DIRTY_TANKERWIRE => "PLATTS-DIRTY-TANKERWIRE",
                CommodityBusinessCalendar.PLATTS_EUROPEAN_GAS => "PLATTS-EUROPEAN-GAS",
                CommodityBusinessCalendar.PLATTS_EUROPEAN_MARKETSCAN => "PLATTS-EUROPEAN-MARKETSCAN",
                CommodityBusinessCalendar.PLATTS_METALS_ALERT => "PLATTS-METALS-ALERT",
                CommodityBusinessCalendar.PLATTS_OILGRAM => "PLATTS-OILGRAM",
                CommodityBusinessCalendar.PLATTS_TSI_IRON_ORE => "PLATTS-TSI-IRON-ORE",
                CommodityBusinessCalendar.PLATTS_TSI_SCRAP => "PLATTS-TSI-SCRAP",
                CommodityBusinessCalendar.PLATTS_TSI_STEEL => "PLATTS-TSI-STEEL",
                CommodityBusinessCalendar.PLATTS_US_MARKETSCAN => "PLATTS-US-MARKETSCAN",
                CommodityBusinessCalendar.PULP_AND_PAPER_INTERNATIONAL => "PULP-AND-PAPER-INTERNATIONAL",
                CommodityBusinessCalendar.PULP_AND_PAPER_WEEK => "PULP-AND-PAPER-WEEK",
                CommodityBusinessCalendar.RIM_PRODUCTS_INTELLIGENCE_DAILY => "RIM-PRODUCTS-INTELLIGENCE-DAILY",
                CommodityBusinessCalendar.SAFEX_SOFT => "SAFEX-SOFT",
                CommodityBusinessCalendar.SFE_SOFT => "SFE-SOFT",
                CommodityBusinessCalendar.SP_GSCI => "SP-GSCI",
                CommodityBusinessCalendar.STATISTICHES_BUNDESAMT => "STATISTICHES-BUNDESAMT",
                CommodityBusinessCalendar.TOCOM_OIL => "TOCOM-OIL",
                CommodityBusinessCalendar.TOCOM_PRECIOUS => "TOCOM-PRECIOUS",
                CommodityBusinessCalendar.TOCOM_SOFT => "TOCOM-SOFT",
                CommodityBusinessCalendar.UX_WEEKLY => "UX-WEEKLY",
                CommodityBusinessCalendar.WORLD_PULP_MONTHLY => "WORLD-PULP-MONTHLY",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg.
    /// </summary>
    [CdmName("CommodityInformationPublisherEnum")]
    public enum CommodityInformationPublisher
    {
        [EnumMember(Value = "ARGUS")]
        Argus,
        
        [EnumMember(Value = "ARGUS_AMERICAS_CRUDE_REPORT")]
        ArgusAmericasCrudeReport,
        
        [EnumMember(Value = "ARGUS_BIOFUEL_REPORT")]
        ArgusBiofuelReport,
        
        [EnumMember(Value = "ARGUS_CRUDE_REPORT")]
        ArgusCrudeReport,
        
        [EnumMember(Value = "ARGUS_EUROPEAN_PRODUCTS_REPORT")]
        ArgusEuropeanProductsReport,
        
        [EnumMember(Value = "ARGUS_FMB")]
        ArgusFMB,
        
        [EnumMember(Value = "ARGUS_INTERNATIONAL_LPG_REPORT")]
        ArgusInternationalLPGReport,
        
        [EnumMember(Value = "ARGUS_LPG")]
        ArgusLPG,
        
        [EnumMember(Value = "ARGUS_MC_CLOSKEYS")]
        ArgusMcCloskeys,
        
        [EnumMember(Value = "ARGUS_NAT_GAS")]
        ArgusNatGas,
        
        [EnumMember(Value = "ASSOC_BANKS_SINGAPORE")]
        AssocBanksSingapore,
        
        BLUENEXT,
        
        [EnumMember(Value = "BALTIC_EXCHANGE")]
        BalticExchange,
        
        [EnumMember(Value = "BAND_D")]
        BandD,
        
        [EnumMember(Value = "BANK_OF_CANADA")]
        BankOfCanada,
        
        [EnumMember(Value = "BANK_OF_ENGLAND")]
        BankOfEngland,
        
        [EnumMember(Value = "BANK_OF_JAPAN")]
        BankOfJapan,
        
        [EnumMember(Value = "BLOOMBERG")]
        Bloomberg,
        
        CAISO,
        
        [EnumMember(Value = "CMAI_AROMATICS_MARKET_REPORT")]
        CMAIAromaticsMarketReport,
        
        [EnumMember(Value = "CMAI_WEEKLY_METHANOL_MARKET_REPORT")]
        CMAIWeeklyMethanolMarketReport,
        
        [EnumMember(Value = "CRU_STEEL_LONG_PRODUCT_MONITOR")]
        CRUSteelLongProductMonitor,
        
        [EnumMember(Value = "CRU_STEEL_SHEET_PRODUCTS_MONITOR")]
        CRUSteelSheetProductsMonitor,
        
        [EnumMember(Value = "CANADIAN_GAS_PRICE_REPORTER")]
        CanadianGasPriceReporter,
        
        [EnumMember(Value = "CANADIAN_GAS_REPORTER")]
        CanadianGasReporter,
        
        [EnumMember(Value = "CHEMICAL_MARKETS_ASSOCIATION")]
        ChemicalMarketsAssociation,
        
        [EnumMember(Value = "DOW_JONES_ENERGY_SERVICE")]
        DowJonesEnergyService,
        
        [EnumMember(Value = "DOW_JONES_ENERGY_SERVICE_SCREEN")]
        DowJonesEnergyServiceScreen,
        
        [EnumMember(Value = "DOW_JONES_NAT_GAS")]
        DowJonesNatGas,
        
        EEX,
        
        ERCOT,
        
        EURONEXMATIF,
        
        [EnumMember(Value = "EURO_CENTRAL_BANK")]
        EuroCentralBank,
        
        FERTECON,
        
        FHLBSF,
        
        [EnumMember(Value = "FEDERAL_RESERVE")]
        FederalReserve,
        
        [EnumMember(Value = "FERTILIZER_WEEK")]
        FertilizerWeek,
        
        GME,
        
        [EnumMember(Value = "GAS_DAILY")]
        GasDaily,
        
        [EnumMember(Value = "GAS_DAILY_PRICE_GUIDE")]
        GasDailyPriceGuide,
        
        [EnumMember(Value = "GLOBAL_COALE")]
        GlobalCoale,
        
        [EnumMember(Value = "HEREN_REPORT")]
        HerenReport,
        
        ICE,
        
        [EnumMember(Value = "ICE_10_X_DAILY_NATURAL_GAS")]
        ICE10XDailyNaturalGas,
        
        [EnumMember(Value = "ICE_10_X_DAILY_POWER")]
        ICE10XDailyPower,
        
        [EnumMember(Value = "ICE_10_X_MONTHLY")]
        ICE10XMonthly,
        
        [EnumMember(Value = "ICE_DAY_AHEAD_INDEX")]
        ICEDayAheadIndex,
        
        ICEECX,
        
        ICIS,
        
        IPE,
        
        ISDA,
        
        [EnumMember(Value = "ISO_NEW_ENGLAND")]
        ISONewEngland,
        
        [EnumMember(Value = "INSIDE_FERC")]
        InsideFERC,
        
        JAPANMOFTSRR,
        
        LEBA,
        
        LONDONPLATINUMPALLADIUMMARKET,
        
        [EnumMember(Value = "LONDON_BULLION_MARKET_ASSOCIATION")]
        LondonBullionMarketAssociation,
        
        MISO,
        
        [EnumMember(Value = "MEGAWATT_DAILY")]
        MegawattDaily,
        
        [EnumMember(Value = "METAL_BULLETIN")]
        MetalBulletin,
        
        [EnumMember(Value = "NGI_BIDWEEK_SURVEY")]
        NGIBidweekSurvey,
        
        NYISO,
        
        [EnumMember(Value = "NATURAL_GAS_WEEK")]
        NaturalGasWeek,
        
        OBM,
        
        OMEL,
        
        OPIS,
        
        PIX,
        
        PJM,
        
        PPM,
        
        [EnumMember(Value = "PPM_EUROPE")]
        PPMEurope,
        
        PPW,
        
        [EnumMember(Value = "PAPER_TRADER")]
        PaperTrader,
        
        [EnumMember(Value = "PLATTS_ASIA_PACIFIC")]
        PlattsAsiaPacific,
        
        [EnumMember(Value = "PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN")]
        PlattsAsiaPacificArabMarketscan,
        
        [EnumMember(Value = "PLATTS_CLEAN_TANKERWIRE")]
        PlattsCleanTankerwire,
        
        [EnumMember(Value = "PLATTS_COAL_TRADER")]
        PlattsCoalTrader,
        
        [EnumMember(Value = "PLATTS_CRUDE_OIL_MARKETWIRE")]
        PlattsCrudeOilMarketwire,
        
        [EnumMember(Value = "PLATTS_DIRTY_TAKERWIRE")]
        PlattsDirtyTakerwire,
        
        [EnumMember(Value = "PLATTS_ENGR")]
        PlattsENGR,
        
        [EnumMember(Value = "PLATTS_EUROPEAN")]
        PlattsEuropean,
        
        [EnumMember(Value = "PLATTS_EUROPEAN_MARKETSCAN")]
        PlattsEuropeanMarketscan,
        
        [EnumMember(Value = "PLATTS_GAS_DAILY")]
        PlattsGasDaily,
        
        [EnumMember(Value = "PLATTS_GAS_DAILY_PRICE_GUIDE")]
        PlattsGasDailyPriceGuide,
        
        [EnumMember(Value = "PLATTS_INSIDE_FERC")]
        PlattsInsideFERC,
        
        [EnumMember(Value = "PLATTS_LPG")]
        PlattsLPG,
        
        [EnumMember(Value = "PLATTS_MARKETWIRE")]
        PlattsMarketwire,
        
        [EnumMember(Value = "PLATTS_MEGAWATT_DAILY")]
        PlattsMegawattDaily,
        
        [EnumMember(Value = "PLATTS_METALS_ALERT")]
        PlattsMetalsAlert,
        
        [EnumMember(Value = "PLATTS_OILGRAM")]
        PlattsOilgram,
        
        [EnumMember(Value = "PLATTS_OILGRAM_BUNKERWIRE")]
        PlattsOilgramBunkerwire,
        
        [EnumMember(Value = "PLATTS_POLYMERSCAN")]
        PlattsPolymerscan,
        
        [EnumMember(Value = "PLATTS_TSI_IRON_ORE")]
        PlattsTSIIronOre,
        
        [EnumMember(Value = "PLATTS_US")]
        PlattsUS,
        
        [EnumMember(Value = "PLATTS_US_MARKETSCAN")]
        PlattsUSMarketscan,
        
        [EnumMember(Value = "RIM_INTELLIGENCE_PRODUCTS")]
        RIMIntelligenceProducts,
        
        [EnumMember(Value = "RESERVE_BANK_AUSTRALIA")]
        ReserveBankAustralia,
        
        [EnumMember(Value = "RESERVE_BANK_NEW_ZEALAND")]
        ReserveBankNewZealand,
        
        [EnumMember(Value = "REUTERS")]
        Reuters,
        
        [EnumMember(Value = "REUTERS_SCREEN")]
        ReutersScreen,
        
        [EnumMember(Value = "SEA_PAC")]
        SeaPac,
        
        [EnumMember(Value = "TSI_SCRAP")]
        TSIScrap,
        
        [EnumMember(Value = "TSI_STEEL")]
        TSISteel,
        
        [EnumMember(Value = "TELERATE")]
        Telerate,
        
        [EnumMember(Value = "TELERATE_SCREEN")]
        TelerateScreen,
        
        UXWEEKLY,
        
        [EnumMember(Value = "WORLD_CRUDE_REPORT")]
        WorldCrudeReport,
        
        [EnumMember(Value = "WORLD_PULP_MONTHLY")]
        WorldPulpMonthly
    }
    
    /// <summary>
    /// Defines the enumerated values to specify the nature of a location identifier.
    /// </summary>
    [CdmName("CommodityLocationIdentifierTypeEnum")]
    public enum CommodityLocationIdentifierType
    {
        /// <summary>
        /// The hub code of the buyer.
        /// </summary>
        [EnumMember(Value = "BUYER_HUB")]
        BuyerHub,
        
        /// <summary>
        /// The physical or virtual point at which the commodity will be delivered.
        /// </summary>
        [EnumMember(Value = "DELIVERY_POINT")]
        DeliveryPoint,
        
        /// <summary>
        /// The zone covering potential delivery points for the commodity
        /// </summary>
        [EnumMember(Value = "DELIVERY_ZONE")]
        DeliveryZone,
        
        /// <summary>
        /// The physical or virtual point at which the commodity enters a transportation system.
        /// </summary>
        [EnumMember(Value = "ENTRY_POINT")]
        EntryPoint,
        
        /// <summary>
        /// Identification of the border(s) or border point(s) of a transportation contract.
        /// </summary>
        [EnumMember(Value = "INTERCONNECTION_POINT")]
        InterconnectionPoint,
        
        /// <summary>
        /// The hub code of the seller.
        /// </summary>
        [EnumMember(Value = "SELLER_HUB")]
        SellerHub,
        
        /// <summary>
        /// The physical or virtual point at which the commodity is withdrawn from a transportation system.
        /// </summary>
        [EnumMember(Value = "WITHDRAWAL_POINT")]
        WithdrawalPoint
    }
    
    /// <summary>
    /// The enumeration values to specify the Commodity Reference Prices specified in the Annex to the 2005 ISDA Commodity Definitions.
    /// </summary>
    [CdmName("CommodityReferencePriceEnum")]
    public enum CommodityReferencePrice
    {
        /// <summary>
        /// Per 2005 ISDA Commodity Definitions, Sub-Annex A, Section 7.1 Commodity Reference Prices, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ALUMINIUM ALLOY-LME 15 MONTH")]
        ALUMINIUM_ALLOY_LME_15_MONTH,
        
        /// <summary>
        /// A code for the NYMEX Central Appalachian Coal commodity
        /// </summary>
        [EnumMember(Value = "COAL-CENTRAL APPALACHIAN-NYMEX")]
        COAL_CENTRAL_APPALACHIAN_NYMEX,
        
        /// <summary>
        /// A code for the ICE Futures U.S. (‘ICUS’) Cocoa commodity
        /// </summary>
        [EnumMember(Value = "COCOA-ICE")]
        COCOA_ICE,
        
        /// <summary>
        /// A code for the ICUS Coffee C commodity
        /// </summary>
        [EnumMember(Value = "COFFEE ARABICA-ICE")]
        COFFEE_ARABICA_ICE,
        
        /// <summary>
        /// A code for the ICUS Coffee C commodity
        /// </summary>
        [EnumMember(Value = "COFFEE ROBUSTA-ICE")]
        COFFEE_ROBUSTA_ICE,
        
        /// <summary>
        /// A code for the COMEX (‘CMX’) Copper Grade #1 commodity
        /// </summary>
        [EnumMember(Value = "COPPER-COMEX")]
        COPPER_COMEX,
        
        /// <summary>
        /// A code for the Chicago Board of Trade (‘CBOT’) Corn commodity
        /// </summary>
        [EnumMember(Value = "CORN-CBOT")]
        CORN_CBOT,
        
        /// <summary>
        /// A code for the ICUS Cotton No. 2 commodity
        /// </summary>
        [EnumMember(Value = "COTTON NO. 2-ICE")]
        COTTON_NO__2_ICE,
        
        /// <summary>
        /// A code for the CBOT Ethanol commodity
        /// </summary>
        [EnumMember(Value = "ETHANOL-CBOT")]
        ETHANOL_CBOT,
        
        /// <summary>
        /// A code for the CME Feeder Cattle commodity
        /// </summary>
        [EnumMember(Value = "FEEDER CATTLE-CME")]
        FEEDER_CATTLE_CME,
        
        /// <summary>
        /// A code for the ICUS Frozen Concentrated Orange Juice commodity
        /// </summary>
        [EnumMember(Value = "FROZEN CONCENTRATED ORANGE JUICE NO. 1-ICE")]
        FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE,
        
        /// <summary>
        /// A code for the NYMEX Gasoline Blendstock (RBOB) commodity
        /// </summary>
        [EnumMember(Value = "GASOLINE-RBOB-NEW YORK-ICE")]
        GASOLINE_RBOB_NEW_YORK_ICE,
        
        /// <summary>
        /// A code for the NYMEX Gasoline Blendstock (RBOB) commodity
        /// </summary>
        [EnumMember(Value = "GASOLINE-RBOB-NEW YORK-NYMEX")]
        GASOLINE_RBOB_NEW_YORK_NYMEX,
        
        /// <summary>
        /// A code for the CMX Gold commodity
        /// </summary>
        [EnumMember(Value = "GOLD-COMEX")]
        GOLD_COMEX,
        
        /// <summary>
        /// A code for the NYMEX No. 2 Heating Oil, New York Harbor commodity
        /// </summary>
        [EnumMember(Value = "HEATING OIL-NEW YORK-NYMEX")]
        HEATING_OIL_NEW_YORK_NYMEX,
        
        /// <summary>
        /// A code for the CME Lean Hogs commodity
        /// </summary>
        [EnumMember(Value = "LEAN HOGS-CME")]
        LEAN_HOGS_CME,
        
        /// <summary>
        /// A code for the CME Live Cattle commodity
        /// </summary>
        [EnumMember(Value = "LIVE CATTLE-CME")]
        LIVE_CATTLE_CME,
        
        /// <summary>
        /// A code for the CME Random Length Lumber commodity
        /// </summary>
        [EnumMember(Value = "LUMBER-CME")]
        LUMBER_CME,
        
        /// <summary>
        /// A code for the CME Milk Class III commodity
        /// </summary>
        [EnumMember(Value = "MILK-CLASS III-CME")]
        MILK_CLASS_III_CME,
        
        /// <summary>
        /// A code for the CME Non Fat Dry Milk commodity
        /// </summary>
        [EnumMember(Value = "MILK-NONFAT-DRY-CME")]
        MILK_NONFAT_DRY_CME,
        
        /// <summary>
        /// A code for the NYMEX Natural Gas commodity
        /// </summary>
        [EnumMember(Value = "NATURAL GAS-NYMEX")]
        NATURAL_GAS_NYMEX,
        
        /// <summary>
        /// A code for the NYMEX Panhandle Basis Swap commodity
        /// </summary>
        [EnumMember(Value = "NATURAL GAS-PEPL (TEXOK MAINLINE)-INSIDE FERC")]
        NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC,
        
        /// <summary>
        /// A code for the NYMEX Waha Basis Swap commodity
        /// </summary>
        [EnumMember(Value = "NATURAL GAS-W. TEXAS (WAHA)-INSIDE FERC")]
        NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC,
        
        /// <summary>
        /// A code for the CBOT Oats commodity
        /// </summary>
        [EnumMember(Value = "OATS-CBOT")]
        OATS_CBOT,
        
        /// <summary>
        /// A code for the NYMEX Crude Oil, Light Sweet commodity
        /// </summary>
        [EnumMember(Value = "OIL-WTI-NYMEX")]
        OIL_WTI_NYMEX,
        
        /// <summary>
        /// A code for the NYMEX Palladium commodity
        /// </summary>
        [EnumMember(Value = "PALLADIUM-NYMEX")]
        PALLADIUM_NYMEX,
        
        /// <summary>
        /// A code for the NYMEX Platinum commodity
        /// </summary>
        [EnumMember(Value = "PLATINUM-NYMEX")]
        PLATINUM_NYMEX,
        
        /// <summary>
        /// A code for the CBOT Rough Rice commodity
        /// </summary>
        [EnumMember(Value = "RICE-CBOT")]
        RICE_CBOT,
        
        /// <summary>
        /// A code for the CMX Silver commodity
        /// </summary>
        [EnumMember(Value = "SILVER-COMEX")]
        SILVER_COMEX,
        
        /// <summary>
        /// A code for the CBOT Soybeans commodity
        /// </summary>
        [EnumMember(Value = "SOYBEANS-CBOT")]
        SOYBEANS_CBOT,
        
        /// <summary>
        /// A code for the CBOT Soybean Meal commodity
        /// </summary>
        [EnumMember(Value = "SOYBEAN MEAL-CBOT")]
        SOYBEAN_MEAL_CBOT,
        
        /// <summary>
        /// A code for the CBOT Soybean Oil commodity
        /// </summary>
        [EnumMember(Value = "SOYBEAN OIL-CBOT")]
        SOYBEAN_OIL_CBOT,
        
        /// <summary>
        /// A code for the ICUS Sugar No. 11 commodity
        /// </summary>
        [EnumMember(Value = "SUGAR # 11 (WORLD)-ICE")]
        SUGAR___11__WORLD__ICE,
        
        /// <summary>
        /// A code for the ICUS Sugar No. 16 commodity
        /// </summary>
        [EnumMember(Value = "SUGAR # 16 (US)-ICE")]
        SUGAR___16__US__ICE,
        
        /// <summary>
        /// A code for the CBOT Wheat commodity
        /// </summary>
        [EnumMember(Value = "WHEAT-CBOT")]
        WHEAT_CBOT,
        
        /// <summary>
        /// A code for the Kansas City Board of Trade (‘KCBT’)Wheat commodity
        /// </summary>
        [EnumMember(Value = "WHEAT HRW-KCBOT")]
        WHEAT_HRW_KCBOT,
        
        /// <summary>
        /// A code for the Wheat commodity
        /// </summary>
        [EnumMember(Value = "WHEAT RED SPRING-MGE")]
        WHEAT_RED_SPRING_MGE
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this CommodityReferencePrice value)
        {
            return value switch
            {
                CommodityReferencePrice.ALUMINIUM_ALLOY_LME_15_MONTH => "ALUMINIUM ALLOY-LME 15 MONTH",
                CommodityReferencePrice.COAL_CENTRAL_APPALACHIAN_NYMEX => "COAL-CENTRAL APPALACHIAN-NYMEX",
                CommodityReferencePrice.COCOA_ICE => "COCOA-ICE",
                CommodityReferencePrice.COFFEE_ARABICA_ICE => "COFFEE ARABICA-ICE",
                CommodityReferencePrice.COFFEE_ROBUSTA_ICE => "COFFEE ROBUSTA-ICE",
                CommodityReferencePrice.COPPER_COMEX => "COPPER-COMEX",
                CommodityReferencePrice.CORN_CBOT => "CORN-CBOT",
                CommodityReferencePrice.COTTON_NO__2_ICE => "COTTON NO. 2-ICE",
                CommodityReferencePrice.ETHANOL_CBOT => "ETHANOL-CBOT",
                CommodityReferencePrice.FEEDER_CATTLE_CME => "FEEDER CATTLE-CME",
                CommodityReferencePrice.FROZEN_CONCENTRATED_ORANGE_JUICE_NO__1_ICE => "FROZEN CONCENTRATED ORANGE JUICE NO. 1-ICE",
                CommodityReferencePrice.GASOLINE_RBOB_NEW_YORK_ICE => "GASOLINE-RBOB-NEW YORK-ICE",
                CommodityReferencePrice.GASOLINE_RBOB_NEW_YORK_NYMEX => "GASOLINE-RBOB-NEW YORK-NYMEX",
                CommodityReferencePrice.GOLD_COMEX => "GOLD-COMEX",
                CommodityReferencePrice.HEATING_OIL_NEW_YORK_NYMEX => "HEATING OIL-NEW YORK-NYMEX",
                CommodityReferencePrice.LEAN_HOGS_CME => "LEAN HOGS-CME",
                CommodityReferencePrice.LIVE_CATTLE_CME => "LIVE CATTLE-CME",
                CommodityReferencePrice.LUMBER_CME => "LUMBER-CME",
                CommodityReferencePrice.MILK_CLASS_III_CME => "MILK-CLASS III-CME",
                CommodityReferencePrice.MILK_NONFAT_DRY_CME => "MILK-NONFAT-DRY-CME",
                CommodityReferencePrice.NATURAL_GAS_NYMEX => "NATURAL GAS-NYMEX",
                CommodityReferencePrice.NATURAL_GAS_PEPL__TEXOK_MAINLINE__INSIDE_FERC => "NATURAL GAS-PEPL (TEXOK MAINLINE)-INSIDE FERC",
                CommodityReferencePrice.NATURAL_GAS_W__TEXAS__WAHA__INSIDE_FERC => "NATURAL GAS-W. TEXAS (WAHA)-INSIDE FERC",
                CommodityReferencePrice.OATS_CBOT => "OATS-CBOT",
                CommodityReferencePrice.OIL_WTI_NYMEX => "OIL-WTI-NYMEX",
                CommodityReferencePrice.PALLADIUM_NYMEX => "PALLADIUM-NYMEX",
                CommodityReferencePrice.PLATINUM_NYMEX => "PLATINUM-NYMEX",
                CommodityReferencePrice.RICE_CBOT => "RICE-CBOT",
                CommodityReferencePrice.SILVER_COMEX => "SILVER-COMEX",
                CommodityReferencePrice.SOYBEANS_CBOT => "SOYBEANS-CBOT",
                CommodityReferencePrice.SOYBEAN_MEAL_CBOT => "SOYBEAN MEAL-CBOT",
                CommodityReferencePrice.SOYBEAN_OIL_CBOT => "SOYBEAN OIL-CBOT",
                CommodityReferencePrice.SUGAR___11__WORLD__ICE => "SUGAR # 11 (WORLD)-ICE",
                CommodityReferencePrice.SUGAR___16__US__ICE => "SUGAR # 16 (US)-ICE",
                CommodityReferencePrice.WHEAT_CBOT => "WHEAT-CBOT",
                CommodityReferencePrice.WHEAT_HRW_KCBOT => "WHEAT HRW-KCBOT",
                CommodityReferencePrice.WHEAT_RED_SPRING_MGE => "WHEAT RED SPRING-MGE",
                _ => nameof(value)
            };
        }
    }
    
    [CdmName("CompareOp")]
    public enum CompareOp
    {
        [EnumMember(Value = "EQUALS")]
        Equals,
        
        [EnumMember(Value = "GREATER_THAN")]
        GreaterThan,
        
        [EnumMember(Value = "GREATER_THAN_OR_EQUALS")]
        GreaterThanOrEquals,
        
        [EnumMember(Value = "LESS_THAN")]
        LessThan,
        
        [EnumMember(Value = "LESS_THAN_OR_EQUALS")]
        LessThanOrEquals
    }
    
    /// <summary>
    /// The enumerated values to specify the type of compounding, e.g. flat, straight.
    /// </summary>
    [CdmName("CompoundingMethodEnum")]
    public enum CompoundingMethod
    {
        /// <summary>
        /// Flat compounding. Compounding excludes the spread. Note that the first compounding period has it&apos;s interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
        /// </summary>
        [EnumMember(Value = "FLAT")]
        Flat,
        
        /// <summary>
        /// No compounding is to be applied.
        /// </summary>
        [EnumMember(Value = "NONE")]
        None,
        
        /// <summary>
        /// Spread Exclusive compounding.
        /// </summary>
        [EnumMember(Value = "SPREAD_EXCLUSIVE")]
        SpreadExclusive,
        
        /// <summary>
        /// Straight compounding. Compounding includes the spread.
        /// </summary>
        [EnumMember(Value = "STRAIGHT")]
        Straight
    }
    
    /// <summary>
    /// The enumerated values to specify how the compounding calculation is done
    /// </summary>
    [CdmName("CompoundingTypeEnum")]
    public enum CompoundingType
    {
        /// <summary>
        /// Compounding is done only on business days, i.e. not compounded each day on weekends or holidays.
        /// </summary>
        [EnumMember(Value = "BUSINESS")]
        Business,
        
        /// <summary>
        /// Compounding is done on each calendar day.
        /// </summary>
        [EnumMember(Value = "CALENDAR")]
        Calendar,
        
        /// <summary>
        /// Compounding is not applicable
        /// </summary>
        [EnumMember(Value = "NONE")]
        None
    }
    
    /// <summary>
    /// Represents the enumerated values to identify where a concentration limit is applied.
    /// </summary>
    [CdmName("ConcentrationLimitTypeEnum")]
    public enum ConcentrationLimitType
    {
        /// <summary>
        /// Specifies a limit on a single asset in the portfolio
        /// </summary>
        [EnumMember(Value = "ASSET")]
        Asset,
        
        /// <summary>
        /// Specifies a limit on all cash valued in the base currency of the portfolio.
        /// </summary>
        [EnumMember(Value = "BASE_CURRENCY_EQUIVALENT")]
        BaseCurrencyEquivalent,
        
        /// <summary>
        /// Specifies a limit on a single industry sector in the portfolio.
        /// </summary>
        [EnumMember(Value = "INDUSTRY_SECTOR")]
        IndustrySector,
        
        /// <summary>
        /// Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
        /// </summary>
        [EnumMember(Value = "ISSUE_OUTSTANDING_AMOUNT")]
        IssueOutstandingAmount,
        
        /// <summary>
        /// Specifies a limit on a single issuer in the portfolio.
        /// </summary>
        [EnumMember(Value = "ISSUER")]
        Issuer,
        
        /// <summary>
        /// Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
        /// </summary>
        [EnumMember(Value = "MARKET_CAPITALISATION")]
        MarketCapitalisation,
        
        /// <summary>
        /// Specifies a limit on a single exchange in the portfolio.
        /// </summary>
        [EnumMember(Value = "PRIMARY_EXCHANGE")]
        PrimaryExchange,
        
        /// <summary>
        /// Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level.
        /// </summary>
        [EnumMember(Value = "ULTIMATE_PARENT_INSTITUTION")]
        UltimateParentInstitution
    }
    
    /// <summary>
    /// Enumeration for the different types of confirmation status.
    /// </summary>
    [CdmName("ConfirmationStatusEnum")]
    public enum ConfirmationStatus
    {
        [EnumMember(Value = "CONFIRMED")]
        Confirmed,
        
        [EnumMember(Value = "UNCONFIRMED")]
        Unconfirmed
    }
    
    /// <summary>
    /// The enumerated values to specify a set of standard contract definitions relevant to the transaction.
    /// </summary>
    [CdmName("ContractualDefinitionsEnum")]
    public enum ContractualDefinitions
    {
        /// <summary>
        /// ISDA 1991 Interest Rate Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1991_INTEREST_RATE")]
        ISDA1991InterestRate,
        
        /// <summary>
        /// ISDA 1993 Commodity Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1993_COMMODITY_DERIVATIVES")]
        ISDA1993CommodityDerivatives,
        
        /// <summary>
        /// ISDA 1996 Equity Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1996_EQUITY_DERIVATIVES")]
        ISDA1996EquityDerivatives,
        
        /// <summary>
        /// ISDA 1997 Bullion Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1997_BULLION")]
        ISDA1997Bullion,
        
        /// <summary>
        /// ISDA 1997 Government Bond Option Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1997_GOVERNMENT_BOND_OPTION")]
        ISDA1997GovernmentBondOption,
        
        /// <summary>
        /// ISDA 1998 FX and Currency Option Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1998_FX_AND_CURRENCY_OPTION")]
        ISDA1998FxAndCurrencyOption,
        
        /// <summary>
        /// ISDA 1999 Credit Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_1999_CREDIT_DERIVATIVES")]
        ISDA1999CreditDerivatives,
        
        /// <summary>
        /// ISDA 2000 Definitions
        /// </summary>
        ISDA2000,
        
        /// <summary>
        /// ISDA 2002 Equity Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2002_EQUITY_DERIVATIVES")]
        ISDA2002EquityDerivatives,
        
        /// <summary>
        /// ISDA 2003 Credit Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_DERIVATIVES")]
        ISDA2003CreditDerivatives,
        
        /// <summary>
        /// ISDA 2004 Novation Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2004_NOVATION")]
        ISDA2004Novation,
        
        /// <summary>
        /// ISDA 2005 Commodity Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2005_COMMODITY")]
        ISDA2005Commodity,
        
        /// <summary>
        /// ISDA 2006 Definitions
        /// </summary>
        ISDA2006,
        
        /// <summary>
        /// ISDA 2006 Inflation Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2006_INFLATION_DERIVATIVES")]
        ISDA2006InflationDerivatives,
        
        /// <summary>
        /// ISDA 2008 Inflation Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2008_INFLATION_DERIVATIVES")]
        ISDA2008InflationDerivatives,
        
        /// <summary>
        /// ISDA 2011 Equity Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2011_EQUITY_DERIVATIVES")]
        ISDA2011EquityDerivatives,
        
        /// <summary>
        /// ISDA 2014 Credit Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2014_CREDIT_DERIVATIVES")]
        ISDA2014CreditDerivatives,
        
        /// <summary>
        /// ISDA 2021 Interest Rate Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2021_INTEREST_RATE_DERIVATIVES")]
        ISDA2021InterestRateDerivatives,
        
        /// <summary>
        /// ISDA 2022 Verified Carbon Credit Transactions Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2022_VERIFIED_CARBON_CREDIT")]
        ISDA2022VerifiedCarbonCredit,
        
        /// <summary>
        /// ISDA 2023 Digital Asset Derivatives Definitions
        /// </summary>
        [EnumMember(Value = "ISDA_2023_DIGITAL_ASSET_DERIVATIVES")]
        ISDA2023DigitalAssetDerivatives
    }
    
    /// <summary>
    /// The enumerated values to define the supplements to a base set of ISDA Definitions that are applicable to the transaction.
    /// </summary>
    [CdmName("ContractualSupplementTypeEnum")]
    public enum ContractualSupplementType
    {
        /// <summary>
        /// Standard Terms Supplement for ABX Transactions.
        /// </summary>
        ABX,
        
        /// <summary>
        /// Standard Terms Supplement for Asset-Backed Tranche Transactions.
        /// </summary>
        [EnumMember(Value = "ABX_TRANCHE")]
        ABXTranche,
        
        /// <summary>
        /// ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Leveraged Loans.
        /// </summary>
        [EnumMember(Value = "CD_SON_LEVERAGED_LOANS")]
        CDSonLeveragedLoans,
        
        /// <summary>
        /// ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
        /// </summary>
        [EnumMember(Value = "CD_SON_MBS")]
        CDSonMBS,
        
        /// <summary>
        /// Standard Terms Supplement for CDX Untranched Transactions.
        /// </summary>
        CDX,
        
        /// <summary>
        /// Standard Terms Supplement for CDX Emerging Markets Untranched Transactions.
        /// </summary>
        [EnumMember(Value = "CDX_EMERGING_MARKETS")]
        CDXEmergingMarkets,
        
        /// <summary>
        /// Standard Terms Supplement for CDX Emerging Markets Diversified Untranched Transactions..
        /// </summary>
        [EnumMember(Value = "CDX_EMERGING_MARKETS_DIVERSIFIED")]
        CDXEmergingMarketsDiversified,
        
        /// <summary>
        /// Standard Terms Supplement for CDX Swaption Transactions.
        /// </summary>
        [EnumMember(Value = "CDX_SWAPTION")]
        CDXSwaption,
        
        /// <summary>
        /// Standard Terms Supplement for Dow Jones CDX Tranche Transactions.
        /// </summary>
        [EnumMember(Value = "CDX_TRANCHE")]
        CDXTranche,
        
        /// <summary>
        /// Standard Terms Supplement for CMBX Transactions.
        /// </summary>
        CMBX,
        
        /// <summary>
        /// Standard Terms Supplement for Single Name European CMBS Transactions.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_CMBS")]
        EuropeanCMBS,
        
        /// <summary>
        /// Standard Terms Supplement for Single Name European RMBS Transactions.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_RMBS")]
        EuropeanRMBS,
        
        /// <summary>
        /// Standard Terms Supplement for IOS Transactions.
        /// </summary>
        IOS,
        
        /// <summary>
        /// Supplement to the 1999 ISDA Credit Derivatives Definitions Relating to Convertible, Exchangeable or Accreting Obligations dated November 9, 2001.
        /// </summary>
        [EnumMember(Value = "ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS")]
        ISDA1999CreditConvertibleExchangeableAccretingObligations,
        
        /// <summary>
        /// Restructuring Supplement to the 1999 ISDA Credit Derivatives Definitions dated May 11, 2001.
        /// </summary>
        [EnumMember(Value = "ISDA_1999_CREDIT_RESTRUCTURING")]
        ISDA1999CreditRestructuring,
        
        /// <summary>
        /// Supplement Relating to Successor and Credit Events to the 1999 ISDA Credit Derivatives Definitions dated November 28, 2001.
        /// </summary>
        [EnumMember(Value = "ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS")]
        ISDA1999CreditSuccessorAndCreditEvents,
        
        /// <summary>
        /// Additional Provisions for LPN dated December 6, 2007.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_ADDITIONAL_PROVISIONS_LPN")]
        ISDA2003AdditionalProvisionsLPN,
        
        /// <summary>
        /// Additional Provisions for Contingent Credit Spread Transactions dated August 15, 2008.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION")]
        ISDA2003ContingentCreditSpreadTransaction,
        
        /// <summary>
        /// 2005 Matrix Supplement to the 2003 ISDA Credit Derivatives.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT")]
        ISDA2003Credit2005MatrixSupplement,
        
        /// <summary>
        /// Additional Provisions for the Argentine Republic: Excluded Obligations and Excluded Deliverable Obligations dated December 21, 2005.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_ARGENTINE_REPUBLIC")]
        ISDA2003CreditArgentineRepublic,
        
        /// <summary>
        /// ISDA Credit Derivatives Determinations Committees and Auction Settlement Supplement to the 2003 ISDA Credit Derivatives Definitions (published on [TBD]).
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_AUCTION_SUPPLEMENT")]
        ISDA2003CreditAuctionSupplement,
        
        /// <summary>
        /// May 2003 Supplement to the 2003 ISDA Credit Derivatives Definitions.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_MAY_2003")]
        ISDA2003CreditMay2003,
        
        /// <summary>
        /// Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated May 9, 2003.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_MONOLINE_INSURERS")]
        ISDA2003CreditMonolineInsurers,
        
        /// <summary>
        /// Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated January 21, 2005.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_MONOLINE_INSURERS_2005")]
        ISDA2003CreditMonolineInsurers2005,
        
        /// <summary>
        /// Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY")]
        ISDA2003CreditRepublicOfHungary,
        
        /// <summary>
        /// Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated February 14, 2005. 
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005")]
        ISDA2003CreditRepublicOfHungary2005,
        
        /// <summary>
        /// Additional Provisions for the Russian Federation: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_RUSSIAN_FEDERATION")]
        ISDA2003CreditRussianFederation,
        
        /// <summary>
        /// Additional Provisions for Credit Derivative Transactions - U.S. Municipal Entity as Reference Entity dated September 17, 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_US_MUNICIPALS")]
        ISDA2003CreditUSMunicipals,
        
        /// <summary>
        /// Additional Provisions for STMicroelectronics NV dated December 6, 2007.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_ST_MICROELECTRONICS_NV")]
        ISDA2003STMicroelectronicsNV,
        
        /// <summary>
        /// 2007 Full Lookthrough Depository Receipt Supplement to the 2002 Equity Derivatives Definitions.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT")]
        ISDA2007FullLookthroughDepositoryReceiptSupplement,
        
        /// <summary>
        /// 2007 Partial Lookthrough Depository Receipt Supplement to the 2002 ISDA Equity Derivatives Definitions.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT")]
        ISDA2007PartialLookthroughDepositoryReceiptSupplement,
        
        /// <summary>
        /// Additional Provisions for Physically Settled Default Swaps Monoline Insurer.
        /// </summary>
        [EnumMember(Value = "ISDA_CREDIT_MONOLINE_INSURERS")]
        ISDACreditMonolineInsurers,
        
        /// <summary>
        /// Additional Provisions for Fixed Recovery Credit Default Swap Transactions
        /// </summary>
        [EnumMember(Value = "ISDA_DELIVERY_RESTRICTIONS")]
        ISDADeliveryRestrictions,
        
        /// <summary>
        /// Additional Provisions for Fixed Recovery Credit Default Swap Transactions.
        /// </summary>
        [EnumMember(Value = "ISDA_FIXED_RECOVERY")]
        ISDAFixedRecovery,
        
        /// <summary>
        /// Additional Provisions for LPN Reference Entities.
        /// </summary>
        [EnumMember(Value = "ISDALPN_REFERENCE_ENTITIES")]
        ISDALPNReferenceEntities,
        
        /// <summary>
        /// Canadian Supplement to the 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement dated March 29, 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT")]
        ISDAMarch2004EquityCanadianSupplement,
        
        /// <summary>
        /// Additional Provisions for Recovery Lock Credit Default Swap Transactions.
        /// </summary>
        [EnumMember(Value = "ISDA_RECOVERY_LOCK")]
        ISDARecoveryLock,
        
        /// <summary>
        /// Additional Provisions for Secured Deliverable Obligation Characteristic.
        /// </summary>
        [EnumMember(Value = "ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC")]
        ISDASecuredDeliverableObligationCharacteristic,
        
        /// <summary>
        /// Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Transactions.
        /// </summary>
        LCDX,
        
        /// <summary>
        /// Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Tranche Transactions.
        /// </summary>
        [EnumMember(Value = "LCDX_TRANCHE")]
        LCDXTranche,
        
        /// <summary>
        /// Standard Terms Supplement for MBX Transactions.
        /// </summary>
        MBX,
        
        /// <summary>
        /// Standard Terms Supplement for Municipal CDX Untranched Transactions.
        /// </summary>
        MCDX,
        
        /// <summary>
        /// Standard Terms Supplement for PO Index Transactions.
        /// </summary>
        PO,
        
        /// <summary>
        /// Standard Terms Supplement for PrimeX Transactions.
        /// </summary>
        [EnumMember(Value = "PRIME_X")]
        PrimeX,
        
        /// <summary>
        /// Standard Terms Supplement for Standard CDX Tranche Transactions.
        /// </summary>
        [EnumMember(Value = "STANDARD_CDX_TRANCHE")]
        StandardCDXTranche,
        
        /// <summary>
        /// Standard Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
        /// </summary>
        [EnumMember(Value = "STANDARD_LCDS")]
        StandardLCDS,
        
        /// <summary>
        /// Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
        /// </summary>
        [EnumMember(Value = "STANDARD_LCDS_BULLET")]
        StandardLCDSBullet,
        
        /// <summary>
        /// Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
        /// </summary>
        [EnumMember(Value = "STANDARD_LCDX_BULLET")]
        StandardLCDXBullet,
        
        /// <summary>
        /// Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
        /// </summary>
        [EnumMember(Value = "STANDARD_LCDX_BULLET_TRANCHE")]
        StandardLCDXBulletTranche,
        
        /// <summary>
        /// Standard Terms Supplement for Standard iTraxx Europe Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "STANDARDI_TRAXX_EUROPE_TRANCHE")]
        StandardiTraxxEuropeTranche,
        
        /// <summary>
        /// Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
        /// </summary>
        [EnumMember(Value = "SYNDICATED_SECURED_LOAN_CDS")]
        SyndicatedSecuredLoanCDS,
        
        /// <summary>
        /// Standard Terms Supplement for TRX Transactions.
        /// </summary>
        TRX,
        
        /// <summary>
        /// Standard Terms Supplement for TRX.II Transactions.
        /// </summary>
        [EnumMember(Value = "TRX.II")]
        TRX_II,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Asia Excluding Japan.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_ASIA_EX_JAPAN")]
        ITraxxAsiaExJapan,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Asia Ex-Japan Swaption Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_ASIA_EX_JAPAN_SWAPTION")]
        ITraxxAsiaExJapanSwaption,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Asia Excluding Japan Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_ASIA_EX_JAPAN_TRANCHE")]
        ITraxxAsiaExJapanTranche,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Australia.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_AUSTRALIA")]
        ITraxxAustralia,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Australia Swaption Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_AUSTRALIA_SWAPTION")]
        ITraxxAustraliaSwaption,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Australia Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_AUSTRALIA_TRANCHE")]
        ITraxxAustraliaTranche,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx CJ.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_CJ")]
        ITraxxCJ,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx CJ Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_CJ_TRANCHE")]
        ITraxxCJTranche,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Europe Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_EUROPE")]
        ITraxxEurope,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Europe Dealer Form.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_EUROPE_DEALER")]
        ITraxxEuropeDealer,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Europe Non-Dealer Form.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_EUROPE_NON_DEALER")]
        ITraxxEuropeNonDealer,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Europe Swaption Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_EUROPE_SWAPTION")]
        ITraxxEuropeSwaption,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Europe Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_EUROPE_TRANCHE")]
        ITraxxEuropeTranche,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Japan.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_JAPAN")]
        ITraxxJapan,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Japan Swaption Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_JAPAN_SWAPTION")]
        ITraxxJapanSwaption,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx Japan Tranched Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_JAPAN_TRANCHE")]
        ITraxxJapanTranche,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx LevX.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_LEV_X")]
        ITraxxLevX,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx SDI 75 Dealer Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_SDI_75_DEALER")]
        ITraxxSDI75Dealer,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx SDI 75 Non-Dealer Transactions.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_SDI_75_NON_DEALER")]
        ITraxxSDI75NonDealer,
        
        /// <summary>
        /// Standard Terms Supplement for iTraxx SovX.
        /// </summary>
        [EnumMember(Value = "I_TRAXX_SOV_X")]
        ITraxxSovX
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this ContractualSupplementType value)
        {
            return value switch
            {
                ContractualSupplementType.TRX_II => "TRX.II",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumerated values to specify the origin of a corporate action transfer.
    /// </summary>
    [CdmName("CorporateActionTypeEnum")]
    public enum CorporateActionType
    {
        /// <summary>
        /// Corporate action triggered by a bonus issue. A bonus issue or bonus share is a free share of stock given to current shareholders in a company, based upon the number of shares that the shareholder already owns. While the issue of bonus shares increases the total number of shares issued and owned, it does not change the value of the company. The value maps closely to the ISO code (BONU) defined as a bonus, scrip or capitalisation issue. Security holders receive additional assets free of payment from the issuer, in proportion to their holding.
        /// </summary>
        [EnumMember(Value = "BONUS_ISSUE")]
        BonusIssue,
        
        /// <summary>
        /// Corporate action triggered by the distribution of a cash dividend.
        /// </summary>
        [EnumMember(Value = "CASH_DIVIDEND")]
        CashDividend,
        
        /// <summary>
        /// Corporate action triggered by a Class Action. An action where an individual represents a group in a court claim. The judgment from the suit is for all the members of the group (class). The value maps closely to the ISO code (CLSA) defined as the situation where interested parties seek restitution for financial loss. The security holder may be offered the opportunity to join a class action proceeding and would need to respond with an instruction.
        /// </summary>
        [EnumMember(Value = "CLASS_ACTION")]
        ClassAction,
        
        /// <summary>
        /// Corporate action triggered by the removal of a security from a stock exchange.
        /// </summary>
        [EnumMember(Value = "DELISTING")]
        Delisting,
        
        /// <summary>
        /// Corporate action triggered by an early redemption. The value maps closely to the ISO code (MCAL) defined as the redemption of an entire issue outstanding of securities, for example, bonds, preferred equity, funds, by the issuer or its agent, for example, asset manager, before final maturity.
        /// </summary>
        [EnumMember(Value = "EARLY_REDEMPTION")]
        EarlyRedemption,
        
        /// <summary>
        /// Corporate action triggered by a liquidation. When a business or firm is terminated or bankrupt, its assets are sold (liquidated) and the proceeds pay creditors. Any leftovers are distributed to shareholders. The value maps closely to the ISO code (LIQU) defined as a distribution of cash, assets or both. Debt may be paid in order of priority based on preferred claims to assets specified by the security.
        /// </summary>
        [EnumMember(Value = "LIQUIDATION")]
        Liquidation,
        
        /// <summary>
        /// Corporate action triggered by a merger. Mergers and acquisitions (abbreviated M&amp;A) is an aspect of corporate strategy, corporate finance and management dealing with the buying, selling, dividing and combining of different companies and similar entities that can help an enterprise grow rapidly in its sector or location of origin, or a new field or new location, without creating a subsidiary, other child entity or using a joint venture. The distinction between a merger and an acquisition has become increasingly blurred in various respects (particularly in terms of the ultimate economic outcome), although it has not completely disappeared in all situations. The value maps closely to the ISO code (MRGR) defined as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
        /// </summary>
        [EnumMember(Value = "MERGER")]
        Merger,
        
        /// <summary>
        /// Corporate action triggered by a reverse split. A reverse stock split or reverse split is a process by a company of issuing to each shareholder in that company a smaller number of new shares in proportion to that shareholder&apos;s original shares that are subsequently canceled. A reverse stock split is also called a stock merge. The reduction in the number of issued shares is accompanied by a proportional increase in the share price. The value maps closely to the ISO code (SPLR) defined as a decrease in a company&apos;s number of outstanding equities without any change in the shareholder&apos;s equity or the aggregate market value at the time of the split. Equity price and nominal value are increased accordingly.
        /// </summary>
        [EnumMember(Value = "REVERSE_STOCK_SPLIT")]
        ReverseStockSplit,
        
        /// <summary>
        /// Corporate action triggered by an issuance to shareholders of rights to purchase additional shares at a discount.
        /// </summary>
        [EnumMember(Value = "RIGHTS_ISSUE")]
        RightsIssue,
        
        /// <summary>
        /// Corporate action triggered by a spin Off. A spin-out, also known as a spin-off or a starburst, refers to a type of corporate action where a company splits off sections of itself as a separate business. The value maps closely to the ISO code (SOFF) defined as a a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares. Spin-off represents a form of divestiture usually resulting in an independent company or in an existing company. For example, demerger, distribution, unbundling.
        /// </summary>
        [EnumMember(Value = "SPIN_OFF")]
        SpinOff,
        
        /// <summary>
        /// Corporate action triggered by the distribution of a stock dividend.
        /// </summary>
        [EnumMember(Value = "STOCK_DIVIDEND")]
        StockDividend,
        
        /// <summary>
        /// Corporate action triggered by a change in the code used to trade the security.
        /// </summary>
        [EnumMember(Value = "STOCK_IDENTIFIER_CHANGE")]
        StockIdentifierChange,
        
        /// <summary>
        /// Corporate action triggered by a change in the name used to trade the security.
        /// </summary>
        [EnumMember(Value = "STOCK_NAME_CHANGE")]
        StockNameChange,
        
        /// <summary>
        /// Corporate action triggered by a Stock Reclassification.
        /// </summary>
        [EnumMember(Value = "STOCK_RECLASSIFICATION")]
        StockReclassification,
        
        /// <summary>
        /// Corporate action triggered by a stock split. A stock split or stock divide increases the number of shares in a public company. The price is adjusted such that the before and after market capitalization of the company remains the same and dilutiondoes not occur. The value maps closely to the ISO code (SPLF) defined as a distribution of subsidiary stock to the shareholders of the parent company without a surrender of shares.
        /// </summary>
        [EnumMember(Value = "STOCK_SPLIT")]
        StockSplit,
        
        /// <summary>
        /// Corporate action triggered by a takeover. A takeover is the purchase of onecompany (the target) by another (the acquirer, or bidder). The value maps to the ISO code (TEND) but is finer grained than TEND which emcompasses Tender/Acquisition/Takeover/Purchase Offer/Buyback. ISO defines the TEND code as an offer made to shareholders, normally by a third party, requesting them to sell (tender) or exchange their equities.
        /// </summary>
        [EnumMember(Value = "TAKEOVER")]
        Takeover
    }
    
    /// <summary>
    /// Defines the enumerated values to specify the two counterparties to the transaction.
    /// </summary>
    [CdmName("CounterpartyRoleEnum")]
    public enum CounterpartyRole
    {
        [EnumMember(Value = "PARTY_1")]
        Party1,
        
        [EnumMember(Value = "PARTY_2")]
        Party2
    }
    
    /// <summary>
    /// Represents the enumerated values to specify a credit event type.
    /// </summary>
    [CdmName("CreditEventTypeEnum")]
    public enum CreditEventType
    {
        /// <summary>
        /// The reference entity has been dissolved or has become insolvent. It also covers events that may be a precursor to insolvency such as instigation of bankruptcy or insolvency proceedings. Sovereign trades are not subject to Bankruptcy as &apos;technically&apos; a Sovereign cannot become bankrupt. ISDA 2003 Term: Bankruptcy.
        /// </summary>
        [EnumMember(Value = "BANKRUPTCY")]
        Bankruptcy,
        
        /// <summary>
        /// Results from the fact that the rating of the reference obligation is downgraded to a distressed rating level. From a usage standpoint, this credit event is typically not applicable in case of RMBS trades.
        /// </summary>
        [EnumMember(Value = "DISTRESSED_RATINGS_DOWNGRADE")]
        DistressedRatingsDowngrade,
        
        /// <summary>
        /// This credit event triggers, after the expiration of any applicable grace period, if the reference entity fails to make due payments in an aggregrate amount of not less than the payment requirement on one or more obligations (e.g. a missed coupon payment). ISDA 2003 Term: Failure to Pay.
        /// </summary>
        [EnumMember(Value = "FAILURE_TO_PAY")]
        FailureToPay,
        
        /// <summary>
        /// Corresponds to the failure by the Reference Entity to pay an expected interest amount or the payment of an actual interest amount that is less than the expected interest amount. ISDA 2003 Term: Failure to Pay Interest.
        /// </summary>
        [EnumMember(Value = "FAILURE_TO_PAY_INTEREST")]
        FailureToPayInterest,
        
        /// <summary>
        /// Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
        /// </summary>
        [EnumMember(Value = "FAILURE_TO_PAY_PRINCIPAL")]
        FailureToPayPrincipal,
        
        /// <summary>
        /// A governmental intervention is an event resulting from an action by a governmental authority that materially impacts the reference entity&apos;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2014 Term: Governmental Intervention.
        /// </summary>
        [EnumMember(Value = "GOVERNMENTAL_INTERVENTION")]
        GovernmentalIntervention,
        
        /// <summary>
        /// Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
        /// </summary>
        [EnumMember(Value = "IMPLIED_WRITEDOWN")]
        ImpliedWritedown,
        
        /// <summary>
        /// Results from the fact that the underlier fails to make principal payments as expected.
        /// </summary>
        [EnumMember(Value = "MATURITY_EXTENSION")]
        MaturityExtension,
        
        /// <summary>
        /// One or more of the obligations have been declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay (preferred by the market over Obligation Default, because more definitive and encompasses the definition of Obligation Default - this is more favorable to the Seller). Subject to the default requirement amount. ISDA 2003 Term: Obligation Acceleration.
        /// </summary>
        [EnumMember(Value = "OBLIGATION_ACCELERATION")]
        ObligationAcceleration,
        
        /// <summary>
        /// One or more of the obligations have become capable of being declared due and payable before they would otherwise have been due and payable as a result of, or on the basis of, the occurrence of a default, event of default or other similar condition or event other than failure to pay. ISDA 2003 Term: Obligation Default.
        /// </summary>
        [EnumMember(Value = "OBLIGATION_DEFAULT")]
        ObligationDefault,
        
        /// <summary>
        /// The reference entity, or a governmental authority, either refuses to recognise or challenges the validity of one or more obligations of the reference entity, or imposes a moratorium thereby postponing payments on one or more of the obligations of the reference entity. Subject to the default requirement amount. ISDA 2003 Term: Repudiation/Moratorium.
        /// </summary>
        [EnumMember(Value = "REPUDIATION_MORATORIUM")]
        RepudiationMoratorium,
        
        /// <summary>
        /// A restructuring is an event that materially impacts the reference entity&apos;s obligations, such as an interest rate reduction, principal reduction, deferral of interest or principal, change in priority ranking, or change in currency or composition of payment. ISDA 2003 Term: Restructuring.
        /// </summary>
        [EnumMember(Value = "RESTRUCTURING")]
        Restructuring,
        
        /// <summary>
        /// Results from the fact that the underlier writes down its outstanding principal amount.
        /// </summary>
        [EnumMember(Value = "WRITEDOWN")]
        Writedown
    }
    
    /// <summary>
    /// The enumeration values to qualify the type of credit limits.
    /// </summary>
    [CdmName("CreditLimitTypeEnum")]
    public enum CreditLimitType
    {
        /// <summary>
        /// The type of credit line expressed in CS01. The sensitivity with respect to changes in the CDS spread.
        /// </summary>
        CS01,
        
        /// <summary>
        /// The type of credit line expressed in DV01. The dollar value of a one basis point decrease in interest rates. It shows the change in a bond&apos;s price compared to a decrease in the bond&apos;s yield.
        /// </summary>
        DV01,
        
        /// <summary>
        /// The type of credit line expressed in Initial Margin value.
        /// </summary>
        IM,
        
        /// <summary>
        /// The type of credit line expressed as a Net Present Value.
        /// </summary>
        NPV,
        
        /// <summary>
        /// The type of credit line expressed in Notional amount.
        /// </summary>
        [EnumMember(Value = "NOTIONAL")]
        Notional,
        
        /// <summary>
        /// The type of credit line expressed in PV01. The value of a one dollar or one basis point annuity.
        /// </summary>
        PV01
    }
    
    /// <summary>
    /// Identifies an agency rating as a simple scale boundary of minimum or maximum.
    /// </summary>
    [CdmName("CreditNotationBoundaryEnum")]
    public enum CreditNotationBoundary
    {
        /// <summary>
        /// Denotes a maxiumum boundary
        /// </summary>
        [EnumMember(Value = "MAXIMUM")]
        Maximum,
        
        /// <summary>
        /// Denotes a minumum boundary
        /// </summary>
        [EnumMember(Value = "MINIMUM")]
        Minimum
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
    /// </summary>
    [CdmName("CreditNotationMismatchResolutionEnum")]
    public enum CreditNotationMismatchResolution
    {
        /// <summary>
        /// Denotes the average credit notation if several notations are listed.
        /// </summary>
        [EnumMember(Value = "AVERAGE")]
        Average,
        
        /// <summary>
        /// Denotes the highest credit notation if several notations are listed.
        /// </summary>
        [EnumMember(Value = "HIGHEST")]
        Highest,
        
        /// <summary>
        /// Denotes the lowest credit notation if several notations are listed.
        /// </summary>
        [EnumMember(Value = "LOWEST")]
        Lowest,
        
        /// <summary>
        /// Utilised where bespoke language represents the label characteristics of the rating.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
        /// </summary>
        [EnumMember(Value = "REFERENCE_AGENCY")]
        ReferenceAgency,
        
        /// <summary>
        /// Denotes the second best credit notation if several notations are listed.
        /// </summary>
        [EnumMember(Value = "SECOND_BEST")]
        SecondBest
    }
    
    /// <summary>
    /// Represents the enumerated values to specify the rating agencies.
    /// </summary>
    [CdmName("CreditRatingAgencyEnum")]
    public enum CreditRatingAgency
    {
        /// <summary>
        /// A. M. Best
        /// </summary>
        [EnumMember(Value = "AM_BEST")]
        AMBest,
        
        /// <summary>
        /// Canadian Bond Rating Service
        /// </summary>
        CBRS,
        
        /// <summary>
        /// Dominion Bond Rating Service
        /// </summary>
        [RosettaSynonym(Value = "DBRS", Source = "AcadiaSoft_AM_1_0")]
        DBRS,
        
        /// <summary>
        /// Fitch
        /// </summary>
        [RosettaSynonym(Value = "FITCH", Source = "AcadiaSoft_AM_1_0")]
        [EnumMember(Value = "FITCH")]
        Fitch,
        
        /// <summary>
        /// Japan Credit Rating Agency, Ltd.
        /// </summary>
        [EnumMember(Value = "JAPANAGENCY")]
        Japanagency,
        
        /// <summary>
        /// Moody&apos;s
        /// </summary>
        [RosettaSynonym(Value = "MOODYS", Source = "AcadiaSoft_AM_1_0")]
        [EnumMember(Value = "MOODYS")]
        Moodys,
        
        /// <summary>
        /// Rating And Investment Information, Inc.
        /// </summary>
        [EnumMember(Value = "RATING_AND_INVESTMENT_INFORMATION")]
        RatingAndInvestmentInformation,
        
        /// <summary>
        /// Standard And Poor&apos;s
        /// </summary>
        [RosettaSynonym(Value = "STANDARD_POORS", Source = "AcadiaSoft_AM_1_0")]
        [EnumMember(Value = "STANDARD_AND_POORS")]
        StandardAndPoors
    }
    
    /// <summary>
    /// Represents the enumerated values to specify the credit watch rating.
    /// </summary>
    [CdmName("CreditRatingCreditWatchEnum")]
    public enum CreditRatingCreditWatch
    {
        /// <summary>
        /// Denotes a rating may be raised, lowered, or affirmed.
        /// </summary>
        [EnumMember(Value = "DEVELOPING")]
        Developing,
        
        /// <summary>
        /// Denotes a rating may be lowered.
        /// </summary>
        [EnumMember(Value = "NEGATIVE")]
        Negative,
        
        /// <summary>
        /// Denotes a rating may be raised.
        /// </summary>
        [EnumMember(Value = "POSITIVE")]
        Positive
    }
    
    /// <summary>
    /// Represents the enumerated values to specify the credit rating outlook.
    /// </summary>
    [CdmName("CreditRatingOutlookEnum")]
    public enum CreditRatingOutlook
    {
        /// <summary>
        /// Denotes a rating may be raised, lowered, or affirmed.
        /// </summary>
        [EnumMember(Value = "DEVELOPING")]
        Developing,
        
        /// <summary>
        /// Denotes a rating may be lowered.
        /// </summary>
        [EnumMember(Value = "NEGATIVE")]
        Negative,
        
        /// <summary>
        /// Denotes a rating may be raised.
        /// </summary>
        [EnumMember(Value = "POSITIVE")]
        Positive,
        
        /// <summary>
        /// Denotes a rating is not likely to change.
        /// </summary>
        [EnumMember(Value = "STABLE")]
        Stable
    }
    
    /// <summary>
    /// Represents an enumeration list to identify tranched or untranched credit risk.
    /// </summary>
    [CdmName("CreditRiskEnum")]
    public enum CreditRisk
    {
        /// <summary>
        /// Indicates tranched credit risk, including securitizations.
        /// </summary>
        [EnumMember(Value = "TRANCHED_CREDIT_RISK")]
        TranchedCreditRisk,
        
        /// <summary>
        /// Indicates tranched credit risk, including repackagings.
        /// </summary>
        [EnumMember(Value = "UNTRANCHED_CREDIT_RISK")]
        UntranchedCreditRisk
    }
    
    /// <summary>
    /// Seniority of debt instruments comprising the index.
    /// </summary>
    [CdmName("CreditSeniorityEnum")]
    public enum CreditSeniority
    {
        /// <summary>
        /// Other as defined under EMIR.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC).
        /// </summary>
        [EnumMember(Value = "SENIOR_LOSS_ABSORBING_CAPACITY")]
        SeniorLossAbsorbingCapacity,
        
        /// <summary>
        /// Senior domestic (RED Tier Code: SECDOM).
        /// </summary>
        [EnumMember(Value = "SENIOR_SEC")]
        SeniorSec,
        
        /// <summary>
        /// Senior foreign (RED Tier Code: SNRFOR).
        /// </summary>
        [EnumMember(Value = "SENIOR_UN_SEC")]
        SeniorUnSec,
        
        /// <summary>
        /// Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2).
        /// </summary>
        [EnumMember(Value = "SUB_LOWER_TIER_2")]
        SubLowerTier2,
        
        /// <summary>
        /// Subordinate Tier 1 (RED Tier Code: PREFT1).
        /// </summary>
        [EnumMember(Value = "SUB_TIER_1")]
        SubTier1,
        
        /// <summary>
        /// Subordinate, Tier 3.
        /// </summary>
        [EnumMember(Value = "SUB_TIER_3")]
        SubTier3,
        
        /// <summary>
        /// Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2).
        /// </summary>
        [EnumMember(Value = "SUB_UPPER_TIER_2")]
        SubUpperTier2
    }
    
    /// <summary>
    /// The enumerated values to specify the type of Credit Support Agreement governing the transaction.
    /// </summary>
    [CdmName("CreditSupportAgreementTypeEnum")]
    public enum CreditSupportAgreementType
    {
        /// <summary>
        /// A Collateral Transfer Agreement
        /// </summary>
        [EnumMember(Value = "COLLATERAL_TRANSFER_AGREEMENT")]
        CollateralTransferAgreement,
        
        /// <summary>
        /// A Credit Support Annex legal agreement.
        /// </summary>
        [RosettaSynonym(Value = "CSA", Source = "AcadiaSoft_AM_1_0")]
        [EnumMember(Value = "CREDIT_SUPPORT_ANNEX")]
        CreditSupportAnnex,
        
        /// <summary>
        /// A Credit Support Deed legal agreement.
        /// </summary>
        [EnumMember(Value = "CREDIT_SUPPORT_DEED")]
        CreditSupportDeed
    }
    
    /// <summary>
    /// The enumerated values to specify the Credit Support Document Terms
    /// </summary>
    [CdmName("CreditSupportDocumentTermsEnum")]
    public enum CreditSupportDocumentTerms
    {
        /// <summary>
        /// Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement.
        /// </summary>
        [EnumMember(Value = "ANY")]
        Any,
        
        /// <summary>
        /// No Credit Support Document is specified.
        /// </summary>
        [EnumMember(Value = "NONE")]
        None,
        
        /// <summary>
        /// A specified Credit Support Document is provided
        /// </summary>
        [EnumMember(Value = "SPECIFIED")]
        Specified
    }
    
    /// <summary>
    /// The enumerated values to specify the Credit Support Provider Terms
    /// </summary>
    [CdmName("CreditSupportProviderTermsEnum")]
    public enum CreditSupportProviderTerms
    {
        /// <summary>
        /// Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support.
        /// </summary>
        [EnumMember(Value = "ANY")]
        Any,
        
        /// <summary>
        /// No Credit Support Provider is specified.
        /// </summary>
        [EnumMember(Value = "NONE")]
        None,
        
        /// <summary>
        /// A specified Credit Support Provider is provided
        /// </summary>
        [EnumMember(Value = "SPECIFIED")]
        Specified
    }
    
    /// <summary>
    /// How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1 
    /// </summary>
    [CdmName("CsaTypeEnum")]
    public enum CsaType
    {
        /// <summary>
        /// Thre is an existing Credit Support Annex
        /// </summary>
        [EnumMember(Value = "ExistingCSA")]
        ExistingCSA,
        
        /// <summary>
        /// There is no CSA applicable
        /// </summary>
        [EnumMember(Value = "NoCSA")]
        NoCSA,
        
        /// <summary>
        /// There is a bilateral Credit Support Annex specific to the transaction
        /// </summary>
        [EnumMember(Value = "ReferenceVMCSA")]
        ReferenceVMCSA
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this CsaType value)
        {
            return value switch
            {
                CsaType.ExistingCSA => "ExistingCSA",
                CsaType.NoCSA => "NoCSA",
                CsaType.ReferenceVMCSA => "ReferenceVMCSA",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016.
    /// </summary>
    [CdmName("CurrencyCodeEnum")]
    public enum CurrencyCode
    {
        /// <summary>
        /// UAE Dirham
        /// </summary>
        AED,
        
        /// <summary>
        /// Afghani
        /// </summary>
        AFN,
        
        /// <summary>
        /// Lek
        /// </summary>
        ALL,
        
        /// <summary>
        /// Armenian Dram
        /// </summary>
        AMD,
        
        /// <summary>
        /// Netherlands Antillean Guilder
        /// </summary>
        ANG,
        
        /// <summary>
        /// Kwanza
        /// </summary>
        AOA,
        
        /// <summary>
        /// Argentine Peso
        /// </summary>
        ARS,
        
        /// <summary>
        /// Australian Dollar
        /// </summary>
        AUD,
        
        /// <summary>
        /// Aruban Florin
        /// </summary>
        AWG,
        
        /// <summary>
        /// Azerbaijan Manat
        /// </summary>
        AZN,
        
        /// <summary>
        /// Convertible Mark
        /// </summary>
        BAM,
        
        /// <summary>
        /// Barbados Dollar
        /// </summary>
        BBD,
        
        /// <summary>
        /// Taka
        /// </summary>
        BDT,
        
        /// <summary>
        /// Bulgarian Lev
        /// </summary>
        BGN,
        
        /// <summary>
        /// Bahraini Dinar
        /// </summary>
        BHD,
        
        /// <summary>
        /// Burundi Franc
        /// </summary>
        BIF,
        
        /// <summary>
        /// Bermudian Dollar
        /// </summary>
        BMD,
        
        /// <summary>
        /// Brunei Dollar
        /// </summary>
        BND,
        
        /// <summary>
        /// Boliviano
        /// </summary>
        BOB,
        
        /// <summary>
        /// Mvdol
        /// </summary>
        BOV,
        
        /// <summary>
        /// Brazilian Real
        /// </summary>
        BRL,
        
        /// <summary>
        /// Bahamian Dollar
        /// </summary>
        BSD,
        
        /// <summary>
        /// Ngultrum
        /// </summary>
        BTN,
        
        /// <summary>
        /// Pula
        /// </summary>
        BWP,
        
        /// <summary>
        /// Belarusian Ruble
        /// </summary>
        BYN,
        
        /// <summary>
        /// Belize Dollar
        /// </summary>
        BZD,
        
        /// <summary>
        /// Canadian Dollar
        /// </summary>
        CAD,
        
        /// <summary>
        /// Congolese Franc
        /// </summary>
        CDF,
        
        /// <summary>
        /// WIR Euro
        /// </summary>
        CHE,
        
        /// <summary>
        /// Swiss Franc
        /// </summary>
        CHF,
        
        /// <summary>
        /// WIR Franc
        /// </summary>
        CHW,
        
        /// <summary>
        /// Unidad de Fomento
        /// </summary>
        CLF,
        
        /// <summary>
        /// Chilean Peso
        /// </summary>
        CLP,
        
        /// <summary>
        /// Offshore Chinese Yuan traded in Hong Kong.
        /// </summary>
        CNH,
        
        /// <summary>
        /// Offshore Chinese Yuan traded in Taiwan.
        /// </summary>
        CNT,
        
        /// <summary>
        /// Yuan Renminbi
        /// </summary>
        CNY,
        
        /// <summary>
        /// Colombian Peso
        /// </summary>
        COP,
        
        /// <summary>
        /// Unidad de Valor Real
        /// </summary>
        COU,
        
        /// <summary>
        /// Costa Rican Colon
        /// </summary>
        CRC,
        
        /// <summary>
        /// Peso Convertible
        /// </summary>
        CUC,
        
        /// <summary>
        /// Cuban Peso
        /// </summary>
        CUP,
        
        /// <summary>
        /// Cabo Verde Escudo
        /// </summary>
        CVE,
        
        /// <summary>
        /// Czech Koruna
        /// </summary>
        CZK,
        
        /// <summary>
        /// Djibouti Franc
        /// </summary>
        DJF,
        
        /// <summary>
        /// Danish Krone
        /// </summary>
        DKK,
        
        /// <summary>
        /// Dominican Peso
        /// </summary>
        DOP,
        
        /// <summary>
        /// Algerian Dinar
        /// </summary>
        DZD,
        
        /// <summary>
        /// Egyptian Pound
        /// </summary>
        EGP,
        
        /// <summary>
        /// Nakfa
        /// </summary>
        ERN,
        
        /// <summary>
        /// Ethiopian Birr
        /// </summary>
        ETB,
        
        /// <summary>
        /// Euro
        /// </summary>
        EUR,
        
        /// <summary>
        /// Fiji Dollar
        /// </summary>
        FJD,
        
        /// <summary>
        /// Falkland Islands Pound
        /// </summary>
        FKP,
        
        /// <summary>
        /// Pound Sterling
        /// </summary>
        GBP,
        
        /// <summary>
        /// Lari
        /// </summary>
        GEL,
        
        /// <summary>
        /// Guernsey Pound.
        /// </summary>
        GGP,
        
        /// <summary>
        /// Ghana Cedi
        /// </summary>
        GHS,
        
        /// <summary>
        /// Gibraltar Pound
        /// </summary>
        GIP,
        
        /// <summary>
        /// Dalasi
        /// </summary>
        GMD,
        
        /// <summary>
        /// Guinean Franc
        /// </summary>
        GNF,
        
        /// <summary>
        /// Quetzal
        /// </summary>
        GTQ,
        
        /// <summary>
        /// Guyana Dollar
        /// </summary>
        GYD,
        
        /// <summary>
        /// Hong Kong Dollar
        /// </summary>
        HKD,
        
        /// <summary>
        /// Lempira
        /// </summary>
        HNL,
        
        /// <summary>
        /// Gourde
        /// </summary>
        HTG,
        
        /// <summary>
        /// Forint
        /// </summary>
        HUF,
        
        /// <summary>
        /// Rupiah
        /// </summary>
        IDR,
        
        /// <summary>
        /// New Israeli Sheqel
        /// </summary>
        ILS,
        
        /// <summary>
        /// Isle of Man Pound.
        /// </summary>
        IMP,
        
        /// <summary>
        /// Indian Rupee
        /// </summary>
        INR,
        
        /// <summary>
        /// Iraqi Dinar
        /// </summary>
        IQD,
        
        /// <summary>
        /// Iranian Rial
        /// </summary>
        IRR,
        
        /// <summary>
        /// Iceland Krona
        /// </summary>
        ISK,
        
        /// <summary>
        /// Jersey Pound.
        /// </summary>
        JEP,
        
        /// <summary>
        /// Jamaican Dollar
        /// </summary>
        JMD,
        
        /// <summary>
        /// Jordanian Dinar
        /// </summary>
        JOD,
        
        /// <summary>
        /// Yen
        /// </summary>
        JPY,
        
        /// <summary>
        /// Kenyan Shilling
        /// </summary>
        KES,
        
        /// <summary>
        /// Som
        /// </summary>
        KGS,
        
        /// <summary>
        /// Riel
        /// </summary>
        KHR,
        
        /// <summary>
        /// Tuvaluan Dollar.
        /// </summary>
        KID,
        
        /// <summary>
        /// Comorian Franc 
        /// </summary>
        KMF,
        
        /// <summary>
        /// North Korean Won
        /// </summary>
        KPW,
        
        /// <summary>
        /// Won
        /// </summary>
        KRW,
        
        /// <summary>
        /// Kuwaiti Dinar
        /// </summary>
        KWD,
        
        /// <summary>
        /// Cayman Islands Dollar
        /// </summary>
        KYD,
        
        /// <summary>
        /// Tenge
        /// </summary>
        KZT,
        
        /// <summary>
        /// Lao Kip
        /// </summary>
        LAK,
        
        /// <summary>
        /// Lebanese Pound
        /// </summary>
        LBP,
        
        /// <summary>
        /// Sri Lanka Rupee
        /// </summary>
        LKR,
        
        /// <summary>
        /// Liberian Dollar
        /// </summary>
        LRD,
        
        /// <summary>
        /// Loti
        /// </summary>
        LSL,
        
        /// <summary>
        /// Libyan Dinar
        /// </summary>
        LYD,
        
        /// <summary>
        /// Moroccan Dirham
        /// </summary>
        MAD,
        
        /// <summary>
        /// Monegasque Franc.
        /// </summary>
        MCF,
        
        /// <summary>
        /// Moldovan Leu
        /// </summary>
        MDL,
        
        /// <summary>
        /// Malagasy Ariary
        /// </summary>
        MGA,
        
        /// <summary>
        /// Denar
        /// </summary>
        MKD,
        
        /// <summary>
        /// Kyat
        /// </summary>
        MMK,
        
        /// <summary>
        /// Tugrik
        /// </summary>
        MNT,
        
        /// <summary>
        /// Pataca
        /// </summary>
        MOP,
        
        /// <summary>
        /// Ouguiya
        /// </summary>
        MRU,
        
        /// <summary>
        /// Mauritius Rupee
        /// </summary>
        MUR,
        
        /// <summary>
        /// Rufiyaa
        /// </summary>
        MVR,
        
        /// <summary>
        /// Malawi Kwacha
        /// </summary>
        MWK,
        
        /// <summary>
        /// Mexican Peso
        /// </summary>
        MXN,
        
        /// <summary>
        /// Mexican Unidad de Inversion (UDI)
        /// </summary>
        MXV,
        
        /// <summary>
        /// Malaysian Ringgit
        /// </summary>
        MYR,
        
        /// <summary>
        /// Mozambique Metical
        /// </summary>
        MZN,
        
        /// <summary>
        /// Namibia Dollar
        /// </summary>
        NAD,
        
        /// <summary>
        /// Naira
        /// </summary>
        NGN,
        
        /// <summary>
        /// Cordoba Oro
        /// </summary>
        NIO,
        
        /// <summary>
        /// Norwegian Krone
        /// </summary>
        NOK,
        
        /// <summary>
        /// Nepalese Rupee
        /// </summary>
        NPR,
        
        /// <summary>
        /// New Zealand Dollar
        /// </summary>
        NZD,
        
        /// <summary>
        /// Rial Omani
        /// </summary>
        OMR,
        
        /// <summary>
        /// Balboa
        /// </summary>
        PAB,
        
        /// <summary>
        /// Sol
        /// </summary>
        PEN,
        
        /// <summary>
        /// Kina
        /// </summary>
        PGK,
        
        /// <summary>
        /// Philippine Peso
        /// </summary>
        PHP,
        
        /// <summary>
        /// Pakistan Rupee
        /// </summary>
        PKR,
        
        /// <summary>
        /// Zloty
        /// </summary>
        PLN,
        
        /// <summary>
        /// Guarani
        /// </summary>
        PYG,
        
        /// <summary>
        /// Qatari Rial
        /// </summary>
        QAR,
        
        /// <summary>
        /// Romanian Leu
        /// </summary>
        RON,
        
        /// <summary>
        /// Serbian Dinar
        /// </summary>
        RSD,
        
        /// <summary>
        /// Russian Ruble
        /// </summary>
        RUB,
        
        /// <summary>
        /// Rwanda Franc
        /// </summary>
        RWF,
        
        /// <summary>
        /// Saudi Riyal
        /// </summary>
        SAR,
        
        /// <summary>
        /// Solomon Islands Dollar
        /// </summary>
        SBD,
        
        /// <summary>
        /// Seychelles Rupee
        /// </summary>
        SCR,
        
        /// <summary>
        /// Sudanese Pound
        /// </summary>
        SDG,
        
        /// <summary>
        /// Swedish Krona
        /// </summary>
        SEK,
        
        /// <summary>
        /// Singapore Dollar
        /// </summary>
        SGD,
        
        /// <summary>
        /// Saint Helena Pound
        /// </summary>
        SHP,
        
        /// <summary>
        /// Leone
        /// </summary>
        SLE,
        
        /// <summary>
        /// Sammarinese Lira.
        /// </summary>
        SML,
        
        /// <summary>
        /// Somali Shilling
        /// </summary>
        SOS,
        
        /// <summary>
        /// Surinam Dollar
        /// </summary>
        SRD,
        
        /// <summary>
        /// South Sudanese Pound
        /// </summary>
        SSP,
        
        /// <summary>
        /// Dobra
        /// </summary>
        STN,
        
        /// <summary>
        /// El Salvador Colon
        /// </summary>
        SVC,
        
        /// <summary>
        /// Syrian Pound
        /// </summary>
        SYP,
        
        /// <summary>
        /// Lilangeni
        /// </summary>
        SZL,
        
        /// <summary>
        /// Baht
        /// </summary>
        THB,
        
        /// <summary>
        /// Somoni
        /// </summary>
        TJS,
        
        /// <summary>
        /// Turkmenistan New Manat
        /// </summary>
        TMT,
        
        /// <summary>
        /// Tunisian Dinar
        /// </summary>
        TND,
        
        /// <summary>
        /// Pa’anga
        /// </summary>
        TOP,
        
        /// <summary>
        /// Turkish Lira
        /// </summary>
        TRY,
        
        /// <summary>
        /// Trinidad and Tobago Dollar
        /// </summary>
        TTD,
        
        /// <summary>
        /// New Taiwan Dollar
        /// </summary>
        TWD,
        
        /// <summary>
        /// Tanzanian Shilling
        /// </summary>
        TZS,
        
        /// <summary>
        /// Hryvnia
        /// </summary>
        UAH,
        
        /// <summary>
        /// Uganda Shilling
        /// </summary>
        UGX,
        
        /// <summary>
        /// US Dollar
        /// </summary>
        USD,
        
        /// <summary>
        /// US Dollar (Next day)
        /// </summary>
        USN,
        
        /// <summary>
        /// Uruguay Peso en Unidades Indexadas (UI)
        /// </summary>
        UYI,
        
        /// <summary>
        /// Peso Uruguayo
        /// </summary>
        UYU,
        
        /// <summary>
        /// Unidad Previsional
        /// </summary>
        UYW,
        
        /// <summary>
        /// Uzbekistan Sum
        /// </summary>
        UZS,
        
        /// <summary>
        /// Vatican Lira.
        /// </summary>
        VAL,
        
        /// <summary>
        /// Bolívar Soberano
        /// </summary>
        VED,
        
        /// <summary>
        /// Bolívar Soberano
        /// </summary>
        VES,
        
        /// <summary>
        /// Dong
        /// </summary>
        VND,
        
        /// <summary>
        /// Vatu
        /// </summary>
        VUV,
        
        /// <summary>
        /// Tala
        /// </summary>
        WST,
        
        /// <summary>
        /// CFA Franc BEAC
        /// </summary>
        XAF,
        
        /// <summary>
        /// Silver
        /// </summary>
        XAG,
        
        /// <summary>
        /// Gold
        /// </summary>
        XAU,
        
        /// <summary>
        /// Bond Markets Unit European Composite Unit (EURCO)
        /// </summary>
        XBA,
        
        /// <summary>
        /// Bond Markets Unit European Monetary Unit (E.M.U.-6)
        /// </summary>
        XBB,
        
        /// <summary>
        /// Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
        /// </summary>
        XBC,
        
        /// <summary>
        /// Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
        /// </summary>
        XBD,
        
        /// <summary>
        /// East Caribbean Dollar
        /// </summary>
        XCD,
        
        /// <summary>
        /// SDR (Special Drawing Right)
        /// </summary>
        XDR,
        
        /// <summary>
        /// CFA Franc BCEAO
        /// </summary>
        XOF,
        
        /// <summary>
        /// Palladium
        /// </summary>
        XPD,
        
        /// <summary>
        /// CFP Franc
        /// </summary>
        XPF,
        
        /// <summary>
        /// Platinum
        /// </summary>
        XPT,
        
        /// <summary>
        /// Sucre
        /// </summary>
        XSU,
        
        /// <summary>
        /// Codes specifically reserved for testing purposes
        /// </summary>
        XTS,
        
        /// <summary>
        /// ADB Unit of Account
        /// </summary>
        XUA,
        
        /// <summary>
        /// The codes assigned for transactions where no currency is involved
        /// </summary>
        XXX,
        
        /// <summary>
        /// Yemeni Rial
        /// </summary>
        YER,
        
        /// <summary>
        /// Rand
        /// </summary>
        ZAR,
        
        /// <summary>
        /// Zambian Kwacha
        /// </summary>
        ZMW,
        
        /// <summary>
        /// Zimbabwe Gold
        /// </summary>
        ZWG
    }
    
    /// <summary>
    /// The enumerated values to specify the day count fraction.
    /// </summary>
    [CdmName("DayCountFractionEnum")]
    public enum DayCountFraction
    {
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (v), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (e) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (d).
        /// </summary>
        [EnumMember(Value = "ACT/360")]
        ACT_360,
        
        /// <summary>
        /// Per CFTC definitions.
        /// </summary>
        [EnumMember(Value = "ACT/364")]
        ACT_364,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ix), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (i).
        /// </summary>
        [EnumMember(Value = "ACT/365L")]
        ACT_365L,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iv), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (d) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (c).
        /// </summary>
        [EnumMember(Value = "ACT/365.FIXED")]
        ACT_365_FIXED,
        
        /// <summary>
        /// The Fixed/Floating Amount will be calculated in accordance with the &apos;BASE EXACT/EXACT&apos; day count fraction, as defined in the &apos;Definitions Communes plusieurs Additifs Techniques&apos; published by the Association Francaise des Banques in September 1994.
        /// </summary>
        [EnumMember(Value = "ACT/ACT.AFB")]
        ACT_ACT_AFB,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (iii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (c). This day count fraction code is applicable for transactions booked under the 2021 ISDA Definitions and the 2006 ISDA Definitions. Transactions under the 2000 ISDA Definitions should use the ACT/ACT.ISMA code instead.
        /// </summary>
        [EnumMember(Value = "ACT/ACT.ICMA")]
        ACT_ACT_ICMA,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (ii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (b) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (b). Note that going from FpML 2.0 Recommendation to the FpML 3.0 Trial Recommendation the code in FpML 2.0 &apos;ACT/365.ISDA&apos; became &apos;ACT/ACT.ISDA&apos;.
        /// </summary>
        [EnumMember(Value = "ACT/ACT.ISDA")]
        ACT_ACT_ISDA,
        
        /// <summary>
        /// The Fixed/Floating Amount will be calculated in accordance with Rule 251 of the statutes, by-laws, rules and recommendations of the International Securities Market Association, as published in April 1999, as applied to straight and convertible bonds issued after December 31, 1998, as though the Fixed/Floating Amount were the interest coupon on such a bond. This day count fraction code is applicable for transactions booked under the 2000 ISDA Definitions. Transactions under the 2021 ISDA Definitions and the 2006 ISDA Definitions should use the ACT/ACT.ICMA code instead.
        /// </summary>
        [EnumMember(Value = "ACT/ACT.ISMA")]
        ACT_ACT_ISMA,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (x). Supercedes BUS/252, the number of Business Days in the Calculation Period or Compounding Period in respect of which payment is being made divided by 252.
        /// </summary>
        [EnumMember(Value = "CAL/252")]
        CAL_252,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (xi), the calculation mechanics are driven deterministically by the Calculation Period Frequency (i.e. 0.25 if it is three months, 0.5 if it is 6 months, 1 if it is a year), except that if the first Calculation Period or the final Calculation Period is less than the Calculation Period Frequency, Actual/Actual (ISDA) shall apply to that Calculation Period
        /// </summary>
        [EnumMember(Value = "RBA Bond Basis")]
        RBA_BOND_BASIS,
        
        /// <summary>
        /// Per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (a) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (a).
        /// </summary>
        [EnumMember(Value = "1/1")]
        _1_1,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (g) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (f). Note that the algorithm defined for this day count fraction has changed between the 2000 ISDA Definitions and 2006 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
        /// </summary>
        [EnumMember(Value = "30E/360")]
        _30E_360,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (viii), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (h). Note the algorithm for this day count fraction under the 2006 ISDA Definitions is designed to yield the same results in practice as the version of the 30E/360 day count fraction defined in the 2000 ISDA Definitions. See Introduction to the 2006 ISDA Definitions for further information relating to this change.
        /// </summary>
        [EnumMember(Value = "30E/360.ISDA")]
        _30E_360_ISDA,
        
        /// <summary>
        /// Per 2021 ISDA Definitions, Section 4.6.1 Day Count Fraction, paragraph (vi), per 2006 ISDA Definitions, Section 4.16. Day Count Fraction, paragraph (f) or Annex to the 2000 ISDA Definitions (June 2000 Version), Section 4.16. Day Count Fraction, paragraph (e).
        /// </summary>
        [EnumMember(Value = "30/360")]
        _30_360
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this DayCountFraction value)
        {
            return value switch
            {
                DayCountFraction.ACT_360 => "ACT/360",
                DayCountFraction.ACT_364 => "ACT/364",
                DayCountFraction.ACT_365L => "ACT/365L",
                DayCountFraction.ACT_365_FIXED => "ACT/365.FIXED",
                DayCountFraction.ACT_ACT_AFB => "ACT/ACT.AFB",
                DayCountFraction.ACT_ACT_ICMA => "ACT/ACT.ICMA",
                DayCountFraction.ACT_ACT_ISDA => "ACT/ACT.ISDA",
                DayCountFraction.ACT_ACT_ISMA => "ACT/ACT.ISMA",
                DayCountFraction.CAL_252 => "CAL/252",
                DayCountFraction.RBA_BOND_BASIS => "RBA Bond Basis",
                DayCountFraction._1_1 => "1/1",
                DayCountFraction._30E_360 => "30E/360",
                DayCountFraction._30E_360_ISDA => "30E/360.ISDA",
                DayCountFraction._30_360 => "30/360",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Denotes the method by which the pricing days are distributed across the pricing period.
    /// </summary>
    [CdmName("DayDistributionEnum")]
    public enum DayDistribution
    {
        [EnumMember(Value = "ALL")]
        All,
        
        [EnumMember(Value = "FIRST")]
        First,
        
        [EnumMember(Value = "LAST")]
        Last,
        
        [EnumMember(Value = "PENULTIMATE")]
        Penultimate
    }
    
    /// <summary>
    /// The enumerated values to specify a day of the seven-day week.
    /// </summary>
    [CdmName("DayOfWeekEnum")]
    public enum DayOfWeek
    {
        /// <summary>
        /// Friday
        /// </summary>
        FRI,
        
        /// <summary>
        /// Monday
        /// </summary>
        MON,
        
        /// <summary>
        /// Saturday
        /// </summary>
        SAT,
        
        /// <summary>
        /// Sunday
        /// </summary>
        SUN,
        
        /// <summary>
        /// Thursday
        /// </summary>
        THU,
        
        /// <summary>
        /// Tuesday
        /// </summary>
        TUE,
        
        /// <summary>
        /// Wednesday
        /// </summary>
        WED
    }
    
    /// <summary>
    /// Lists the enumerated values to specify the day type classification used in counting the number of days between two dates.
    /// </summary>
    [CdmName("DayTypeEnum")]
    public enum DayType
    {
        /// <summary>
        /// Applies when calculating the number of days between two dates the count includes only business days.
        /// </summary>
        [EnumMember(Value = "BUSINESS")]
        Business,
        
        /// <summary>
        /// Applies when calculating the number of days between two dates the count includes all calendar days.
        /// </summary>
        [EnumMember(Value = "CALENDAR")]
        Calendar,
        
        /// <summary>
        /// Applies when calculating the number of days between two dates the count includes only currency business days.
        /// </summary>
        [EnumMember(Value = "CURRENCY_BUSINESS")]
        CurrencyBusiness,
        
        /// <summary>
        /// Applies when calculating the number of days between two dates the count includes only stock exchange business days.
        /// </summary>
        [EnumMember(Value = "EXCHANGE_BUSINESS")]
        ExchangeBusiness,
        
        /// <summary>
        /// Applies when calculating the number of days between two dates the count includes only scheduled trading days.
        /// </summary>
        [EnumMember(Value = "SCHEDULED_TRADING_DAY")]
        ScheduledTradingDay
    }
    
    /// <summary>
    /// Represents an enumeration list that identifies the type of debt.
    /// </summary>
    [CdmName("DebtClassEnum")]
    public enum DebtClass
    {
        /// <summary>
        /// Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations.
        /// </summary>
        [EnumMember(Value = "ASSET_BACKED")]
        AssetBacked,
        
        /// <summary>
        /// Identifies a debt instrument that can be converted into common shares.
        /// </summary>
        [EnumMember(Value = "CONVERTIBLE")]
        Convertible,
        
        /// <summary>
        /// Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer.
        /// </summary>
        [EnumMember(Value = "HOLDER_CONVERTIBLE")]
        HolderConvertible,
        
        /// <summary>
        /// Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer.
        /// </summary>
        [EnumMember(Value = "HOLDER_EXCHANGEABLE")]
        HolderExchangeable,
        
        /// <summary>
        /// Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
        /// </summary>
        [EnumMember(Value = "ISSUER_CONVERTIBLE")]
        IssuerConvertible,
        
        /// <summary>
        /// Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable.
        /// </summary>
        [EnumMember(Value = "ISSUER_EXCHANGEABLE")]
        IssuerExchangeable,
        
        /// <summary>
        /// Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
        /// </summary>
        [EnumMember(Value = "REG_CAP")]
        RegCap,
        
        /// <summary>
        /// Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
        /// </summary>
        [EnumMember(Value = "STRUCTURED")]
        Structured,
        
        /// <summary>
        /// Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
        /// </summary>
        [EnumMember(Value = "VANILLA")]
        Vanilla
    }
    
    /// <summary>
    /// Represents an enumeration list that specifies the general rule for periodic interest rate payment.
    /// </summary>
    [CdmName("DebtInterestEnum")]
    public enum DebtInterest
    {
        /// <summary>
        /// Denotes payment calculated with reference to a fixed interest rate.
        /// </summary>
        [EnumMember(Value = "FIXED")]
        Fixed,
        
        /// <summary>
        /// Denotes payment calculated with reference to a floating interest rate.
        /// </summary>
        [EnumMember(Value = "FLOATING")]
        Floating,
        
        /// <summary>
        /// Denotes payment calculated with reference to one or more price or other indices (other than inflation rates).
        /// </summary>
        [EnumMember(Value = "INDEX_LINKED")]
        IndexLinked,
        
        /// <summary>
        /// Denotes payment calculated with reference to one or more specified inflation rates.
        /// </summary>
        [EnumMember(Value = "INFLATION_LINKED")]
        InflationLinked,
        
        /// <summary>
        /// Denotes a stripped bond representing only the interest component.
        /// </summary>
        [EnumMember(Value = "INTEREST_ONLY")]
        InterestOnly,
        
        /// <summary>
        /// Denotes payment calculated with reference to the inverse of a floating interest rate.
        /// </summary>
        [EnumMember(Value = "INVERSE_FLOATING")]
        InverseFloating,
        
        /// <summary>
        /// Denotes payment calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
        /// </summary>
        [EnumMember(Value = "OTHER_STRUCTURED")]
        OtherStructured,
        
        /// <summary>
        /// Denotes a zero coupon bond that does not pay intetrest.
        /// </summary>
        [EnumMember(Value = "ZERO_COUPON")]
        ZeroCoupon
    }
    
    /// <summary>
    /// Represents an enumeration list that specifies the general rule for repayment of principal.
    /// </summary>
    [CdmName("DebtPrincipalEnum")]
    public enum DebtPrincipal
    {
        /// <summary>
        /// Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
        /// </summary>
        [EnumMember(Value = "AMORTISING")]
        Amortising,
        
        /// <summary>
        /// Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
        /// </summary>
        [EnumMember(Value = "BULLET")]
        Bullet,
        
        /// <summary>
        /// Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
        /// </summary>
        [EnumMember(Value = "CALLABLE")]
        Callable,
        
        /// <summary>
        /// Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
        /// </summary>
        [EnumMember(Value = "INDEX_LINKED")]
        IndexLinked,
        
        /// <summary>
        /// Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
        /// </summary>
        [EnumMember(Value = "INFLATION_LINKED")]
        InflationLinked,
        
        /// <summary>
        /// Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
        /// </summary>
        [EnumMember(Value = "OTHER_STRUCTURED")]
        OtherStructured,
        
        /// <summary>
        /// Denotes a stripped bond representing only the principal component.
        /// </summary>
        [EnumMember(Value = "PRINCIPAL_ONLY")]
        PrincipalOnly,
        
        /// <summary>
        /// Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
        /// </summary>
        [EnumMember(Value = "PUTTABLE")]
        Puttable
    }
    
    /// <summary>
    /// Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
    /// </summary>
    [CdmName("DebtSeniorityEnum")]
    public enum DebtSeniority
    {
        /// <summary>
        /// Denotes debt which is secured over assets of the issuer or a related party (eg guarantor).
        /// </summary>
        [EnumMember(Value = "SECURED")]
        Secured,
        
        /// <summary>
        /// Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer.
        /// </summary>
        [EnumMember(Value = "SENIOR")]
        Senior,
        
        /// <summary>
        /// Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met.
        /// </summary>
        [EnumMember(Value = "SUBORDINATED")]
        Subordinated
    }
    
    /// <summary>
    /// The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language.
    /// </summary>
    [CdmName("DeliveryAmountElectionEnum")]
    public enum DeliveryAmountElection
    {
        /// <summary>
        /// The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.`
        /// </summary>
        [EnumMember(Value = "LAST_AND_ANY_LOCAL_BUSINESS_DAY")]
        LastAndAnyLocalBusinessDay,
        
        /// <summary>
        /// The delivery only includes `Transfer on last Local Business Day.
        /// </summary>
        [EnumMember(Value = "LAST_LOCAL_BUSINESS_DAY")]
        LastLocalBusinessDay
    }
    
    /// <summary>
    /// Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
    /// </summary>
    [CdmName("DeliveryMethodEnum")]
    public enum DeliveryMethod
    {
        /// <summary>
        /// Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other.
        /// </summary>
        [EnumMember(Value = "DELIVERY_VERSUS_PAYMENT")]
        DeliveryVersusPayment,
        
        /// <summary>
        /// Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa.
        /// </summary>
        [EnumMember(Value = "FREE_OF_PAYMENT")]
        FreeOfPayment,
        
        /// <summary>
        /// Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment.
        /// </summary>
        [EnumMember(Value = "PRE_DELIVERY")]
        PreDelivery,
        
        /// <summary>
        /// Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment.
        /// </summary>
        [EnumMember(Value = "PRE_PAYMENT")]
        PrePayment
    }
    
    [CdmName("DeliveryNearbyTypeEnum")]
    public enum DeliveryNearbyType
    {
        /// <summary>
        /// Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
        /// </summary>
        [EnumMember(Value = "CALCULATION_PERIOD")]
        CalculationPeriod,
        
        /// <summary>
        /// Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
        /// </summary>
        [EnumMember(Value = "NEARBY_MONTH")]
        NearbyMonth,
        
        /// <summary>
        /// Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
        /// </summary>
        [EnumMember(Value = "NEARBY_WEEK")]
        NearbyWeek
    }
    
    /// <summary>
    /// The enumerated values to specify the method according to which an amount or a date is determined.
    /// </summary>
    [CdmName("DeterminationMethodEnum")]
    public enum DeterminationMethod
    {
        /// <summary>
        /// Agreed separately between the parties.
        /// </summary>
        [EnumMember(Value = "AGREED_INITIAL_PRICE")]
        AgreedInitialPrice,
        
        /// <summary>
        /// As specified in Master Confirmation.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_CONFIRMATION")]
        AsSpecifiedInMasterConfirmation,
        
        /// <summary>
        /// Determined by the Calculation Agent.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT")]
        CalculationAgent,
        
        /// <summary>
        /// Official Closing Price.
        /// </summary>
        [EnumMember(Value = "CLOSING_PRICE")]
        ClosingPrice,
        
        /// <summary>
        /// Determined by the Currency of Equity Dividends.
        /// </summary>
        [EnumMember(Value = "DIVIDEND_CURRENCY")]
        DividendCurrency,
        
        /// <summary>
        /// The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
        /// </summary>
        [EnumMember(Value = "EXPIRING_CONTRACT_LEVEL")]
        ExpiringContractLevel,
        
        /// <summary>
        /// Determined by the Hedging Party.
        /// </summary>
        [EnumMember(Value = "HEDGE_EXECUTION")]
        HedgeExecution,
        
        /// <summary>
        /// Issuer Payment Currency.
        /// </summary>
        [EnumMember(Value = "ISSUER_PAYMENT_CURRENCY")]
        IssuerPaymentCurrency,
        
        /// <summary>
        /// Net Asset Value.
        /// </summary>
        NAV,
        
        /// <summary>
        /// OSP Price.
        /// </summary>
        [EnumMember(Value = "OSP_PRICE")]
        OSPPrice,
        
        /// <summary>
        /// Opening Price of the Market.
        /// </summary>
        [EnumMember(Value = "OPEN_PRICE")]
        OpenPrice,
        
        /// <summary>
        /// Settlement Currency.
        /// </summary>
        [EnumMember(Value = "SETTLEMENT_CURRENCY")]
        SettlementCurrency,
        
        /// <summary>
        /// Date on which the strike is determined in respect of a forward starting swap.
        /// </summary>
        [EnumMember(Value = "STRIKE_DATE_DETERMINATION")]
        StrikeDateDetermination,
        
        /// <summary>
        /// Official TWAP Price.
        /// </summary>
        [EnumMember(Value = "TWAP_PRICE")]
        TWAPPrice,
        
        /// <summary>
        /// Official VWAP Price.
        /// </summary>
        [EnumMember(Value = "VWAP_PRICE")]
        VWAPPrice,
        
        /// <summary>
        /// Price determined at valuation time.
        /// </summary>
        [EnumMember(Value = "VALUATION_TIME")]
        ValuationTime
    }
    
    /// <summary>
    /// The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
    /// </summary>
    [CdmName("DiscountingTypeEnum")]
    public enum DiscountingType
    {
        /// <summary>
        /// As specified by the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
        /// </summary>
        AFMA,
        
        /// <summary>
        /// As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
        /// </summary>
        FRA,
        
        /// <summary>
        /// As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
        /// </summary>
        [EnumMember(Value = "FRA_YIELD")]
        FRAYield,
        
        /// <summary>
        /// As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
        /// </summary>
        [EnumMember(Value = "STANDARD")]
        Standard
    }
    
    /// <summary>
    /// The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
    /// </summary>
    [CdmName("DividendAmountTypeEnum")]
    public enum DividendAmountType
    {
        /// <summary>
        /// The Amount is determined as provided in the relevant Master Confirmation.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_CONFIRMATION")]
        AsSpecifiedInMasterConfirmation,
        
        /// <summary>
        /// The ex-date for a dividend occurs during a dividend period.
        /// </summary>
        [EnumMember(Value = "EX_AMOUNT")]
        ExAmount,
        
        /// <summary>
        /// The payment date for a dividend occurs during a dividend period.
        /// </summary>
        [EnumMember(Value = "PAID_AMOUNT")]
        PaidAmount,
        
        /// <summary>
        /// The record date for a dividend occurs during a dividend period.
        /// </summary>
        [EnumMember(Value = "RECORD_AMOUNT")]
        RecordAmount
    }
    
    /// <summary>
    /// The enumerated values to specify how the composition of Dividends is to be determined.
    /// </summary>
    [CdmName("DividendCompositionEnum")]
    public enum DividendComposition
    {
        /// <summary>
        /// The Calculation Agent determines the composition of dividends (subject to conditions).
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_ELECTION")]
        CalculationAgentElection,
        
        /// <summary>
        /// The Equity Amount Receiver determines the composition of dividends (subject to conditions).
        /// </summary>
        [EnumMember(Value = "EQUITY_AMOUNT_RECEIVER_ELECTION")]
        EquityAmountReceiverElection
    }
    
    /// <summary>
    /// The enumerated values to specify the date by reference to which the dividend will be paid.
    /// </summary>
    [CdmName("DividendDateReferenceEnum")]
    public enum DividendDateReference
    {
        /// <summary>
        /// The dividend date will be specified ad-hoc by the parties, typically on the dividend ex-date.
        /// </summary>
        [EnumMember(Value = "AD_HOC_DATE")]
        AdHocDate,
        
        /// <summary>
        /// If &apos;Dividend Payment Date(s)&apos; is specified in the Transaction Supplement as &apos;Cash Settlement Payment Date – Ex Dividend&apos;&apos;, then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading &apos;ex&apos; the relevant dividend on the Exchange.
        /// </summary>
        [EnumMember(Value = "CASH_SETTLE_PAYMENT_DATE_EX_DIV")]
        CashSettlePaymentDateExDiv,
        
        /// <summary>
        /// If &apos;Dividend Payment Date(s)&apos; is specified in the Transaction Supplement as &apos;Cash Settlement Payment Date – Issuer Payment&apos;, then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the issuer pays the relevant dividend to a holder of record provided that in the case where the Equity Amount Payer is the party specified to be the sole Hedging Party and the Hedging Party has not received the Dividend Amount by such date, then the date falling a number of Currency Business Days as specified in the Cash Settlement Payment Date after actual receipt by the Hedging Party of the Received Ex Amount or Paid Ex Amount (as applicable).
        /// </summary>
        [EnumMember(Value = "CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT")]
        CashSettlePaymentDateIssuerPayment,
        
        /// <summary>
        /// If &apos;Dividend Payment Date(s)&apos; is specified in the Transaction Supplement as &apos;Cash Settlement Payment Date&apos;, then the Dividend Payment Date in respect of a Dividend Amount shall be the Cash Settlement Payment Date relating to the end of the Dividend Period during which the Shares commenced trading &apos;ex&apos; the relevant dividend on the Exchange.
        /// </summary>
        [EnumMember(Value = "CASH_SETTLEMENT_PAYMENT_DATE")]
        CashSettlementPaymentDate,
        
        /// <summary>
        /// Total of dividends which go ex, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_EQUITY_EX_DIV")]
        CumulativeEquityExDiv,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Ex Date, unless the Dividend Ex Date is between the Equity Valuation and Payment Date in which case the dividend is deferred to the following Equity Payment Date
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_EQUITY_EX_DIV_BEFORE_RESET")]
        CumulativeEquityExDivBeforeReset,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_EQUITY_PAID")]
        CumulativeEquityPaid,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_EQUITY_PAID_BEFORE_RESET")]
        CumulativeEquityPaidBeforeReset,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Equity Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Equity Payment Date
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_EQUITY_PAID_INCL_RESET")]
        CumulativeEquityPaidInclReset,
        
        /// <summary>
        /// Total of dividends which go ex, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the Shares commence trading ex-dividend on the Exchange, or where the date on which the Shares commence trading ex-dividend is a Payment Date, such Payment Date.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_INTEREST_EX_DIV")]
        CumulativeInterestExDiv,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Period during which the dividend is paid by the Issuer to the holders of record of a Share.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_INTEREST_PAID")]
        CumulativeInterestPaid,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (not including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_INTEREST_PAID_BEFORE_RESET")]
        CumulativeInterestPaidBeforeReset,
        
        /// <summary>
        /// Total of paid dividends, paid on next following Interest Payment Date, which is immediately following the Dividend Pay Date, unless the Dividend Pay Date is between the Equity Valuation and Payment Date (including the Valuation Date) in which case the dividend is deferred to the following Interest Payment Date.
        /// </summary>
        [EnumMember(Value = "CUMULATIVE_INTEREST_PAID_INCL_RESET")]
        CumulativeInterestPaidInclReset,
        
        /// <summary>
        /// Date on which the dividend will be paid by the issuer.
        /// </summary>
        [EnumMember(Value = "DIVIDEND_PAYMENT_DATE")]
        DividendPaymentDate,
        
        /// <summary>
        /// In respect of each Dividend Period, the relevant Dividend Valuation Date.
        /// </summary>
        [EnumMember(Value = "DIVIDEND_VALUATION_DATE")]
        DividendValuationDate,
        
        /// <summary>
        /// Equity payment date of the swap.
        /// </summary>
        [EnumMember(Value = "EQUITY_PAYMENT_DATE")]
        EquityPaymentDate,
        
        /// <summary>
        /// Date on which a holder of the security is entitled to the dividend.
        /// </summary>
        [EnumMember(Value = "EX_DATE")]
        ExDate,
        
        /// <summary>
        /// If &apos;Dividend Payment Date(s)&apos; is specified in the Transaction Supplement as &apos;Floating Amount Payment Date&apos;, then the Dividend Payment Date in respect of a Dividend Amount shall be the first Payment Date falling at least one Settlement Cycle after the date that the Shares have commenced trading &apos;ex&apos; the relevant dividend on the Exchange.
        /// </summary>
        [EnumMember(Value = "FLOATING_AMOUNT_PAYMENT_DATE")]
        FloatingAmountPaymentDate,
        
        /// <summary>
        /// The next payment date of the swap.
        /// </summary>
        [EnumMember(Value = "FOLLOWING_PAYMENT_DATE")]
        FollowingPaymentDate,
        
        /// <summary>
        /// Date on which the dividend will be recorded in the books of the paying agent.
        /// </summary>
        [EnumMember(Value = "RECORD_DATE")]
        RecordDate,
        
        /// <summary>
        /// If &apos;Dividend Payment Date(s)&apos; is specified in the Transaction Supplement as &apos;Share Payment&apos;, then the Dividend Payment Date in respect of a Dividend Amount shall fall on a date on or before the date that is two (or any other number that is specified in the Transaction Supplement) Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
        /// </summary>
        [EnumMember(Value = "SHARE_PAYMENT")]
        SharePayment,
        
        /// <summary>
        /// Termination date of the swap.
        /// </summary>
        [EnumMember(Value = "TERMINATION_DATE")]
        TerminationDate,
        
        /// <summary>
        /// Trade date of the swap
        /// </summary>
        [EnumMember(Value = "TRADE_DATE")]
        TradeDate,
        
        /// <summary>
        /// Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until trade is fully unwound.
        /// </summary>
        [EnumMember(Value = "UNWIND_EX_DIV")]
        UnwindExDiv,
        
        /// <summary>
        /// Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
        /// </summary>
        [EnumMember(Value = "UNWIND_OR_EQUITY_EX_DIV")]
        UnwindOrEquityExDiv,
        
        /// <summary>
        /// Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Equity Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
        /// </summary>
        [EnumMember(Value = "UNWIND_OR_EQUITY_PAID")]
        UnwindOrEquityPaid,
        
        /// <summary>
        /// Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Ex Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Ex Date. This will be whichever date comes first or a combination of both.
        /// </summary>
        [EnumMember(Value = "UNWIND_OR_INTEREST_EX_DIV")]
        UnwindOrInterestExDiv,
        
        /// <summary>
        /// Pays a fraction of the Dividend Amount on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until position is fully unwound OR on the next Interest Pay Date after the Dividend Pay Date. This will be whichever date comes first or a combination of both.
        /// </summary>
        [EnumMember(Value = "UNWIND_OR_INTEREST_PAID")]
        UnwindOrInterestPaid,
        
        /// <summary>
        /// Pays a fraction of the total on each Unwind Trade Settlement Date which occurs after the Dividend Pay Date, until trade is fully unwound.
        /// </summary>
        [EnumMember(Value = "UNWIND_PAID")]
        UnwindPaid
    }
    
    /// <summary>
    /// The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend.
    /// </summary>
    [CdmName("DividendEntitlementEnum")]
    public enum DividendEntitlement
    {
        /// <summary>
        /// Dividend entitlement is on the dividend ex-date.
        /// </summary>
        [EnumMember(Value = "EX_DATE")]
        ExDate,
        
        /// <summary>
        /// Dividend entitlement is on the dividend record date.
        /// </summary>
        [RosettaSynonym(Value = "RecordDate", Source = "FIX_5_0_SP2")]
        [EnumMember(Value = "RECORD_DATE")]
        RecordDate
    }
    
    /// <summary>
    /// 2002 ISDA Equity Derivatives Definitions: First Period, Second Period |
    /// </summary>
    [CdmName("DividendPeriodEnum")]
    public enum DividendPeriod
    {
        /// <summary>
        /// 2002 ISDA Equity Derivatives Definitions: First Period means each period from, and including, one Cash Settlement Payment Date or Settlement Date, as the case may be, to, but excluding, the next following Cash Settlement Payment Date or Settlement Date, as the case may be, except that (i) the initial Dividend Period will commence on, and include, the Clearance System Business Day that is one Settlement Cycle following the Trade Date and (ii) the final Dividend Period will end on, but exclude, the final Cash Settlement Payment Date or Settlement Date, as the case may be.
        /// </summary>
        [EnumMember(Value = "FIRST_PERIOD")]
        FirstPeriod,
        
        /// <summary>
        /// 2002 ISDA Equity Derivatives Definitions: Second Period means each period from, but excluding, one Valuation Date to, and including, the next Valuation Date, except that (i) the initial Dividend Period will commence on, but exclude, the Trade Date and (ii) the final Dividend Period will end on, and include, the final Valuation Date or, in respect of a Physically-settled Forward Transaction to which Variable Obligation is not applicable, the date that is one Settlement Cycle prior to the Settlement Date.
        /// </summary>
        [EnumMember(Value = "SECOND_PERIOD")]
        SecondPeriod
    }
    
    /// <summary>
    /// Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
    /// </summary>
    [CdmName("EU_EMIR_EligibleCollateralEnum")]
    public enum EU_EMIR_EligibleCollateral
    {
        /// <summary>
        /// Denotes Cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_A")]
        EU_EMIRTypeA,
        
        /// <summary>
        ///  Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_B")]
        EU_EMIRTypeB,
        
        /// <summary>
        ///  Denotes debt securities issued by Member States&apos; central governments or central banks.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_C")]
        EU_EMIRTypeC,
        
        /// <summary>
        ///  Denotes debt securities issued by Member States&apos; regional governments or local authorities whose exposures are treated as exposures to the central government of that Member State in accordance with Article 115(2) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_D")]
        EU_EMIRTypeD,
        
        /// <summary>
        ///  Denotes debt securities issued by Member States&apos; public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of that Member State in accordance with Article 116(4) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_E")]
        EU_EMIRTypeE,
        
        /// <summary>
        ///  Denotes debt securities issued by Member States&apos; regional governments or local authorities other than those referred to in (TypeD.)
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_F")]
        EU_EMIRTypeF,
        
        /// <summary>
        ///  Denotes debt securities issued by Member States&apos; public sector entities other than those referred to in (TypeE).
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_G")]
        EU_EMIRTypeG,
        
        /// <summary>
        ///  Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_H")]
        EU_EMIRTypeH,
        
        /// <summary>
        ///  Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_I")]
        EU_EMIRTypeI,
        
        /// <summary>
        ///  Denotes debt securities issued by third countries&apos; governments or central banks.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_J")]
        EU_EMIRTypeJ,
        
        /// <summary>
        ///  Denotes debt securities issued by third countries&apos; regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_K")]
        EU_EMIRTypeK,
        
        /// <summary>
        ///  Denotes debt securities issued by third countries&apos; regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_L")]
        EU_EMIRTypeL,
        
        /// <summary>
        ///  Denotes debt securities issued by credit institutions or investment firms including bonds referred to in Article 52(4) of Directive 2009/65/EC of the European Parliament and of the Council.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_M")]
        EU_EMIRTypeM,
        
        /// <summary>
        ///  Denotes corporate bonds.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_N")]
        EU_EMIRTypeN,
        
        /// <summary>
        ///  Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_O")]
        EU_EMIRTypeO,
        
        /// <summary>
        ///  Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_P")]
        EU_EMIRTypeP,
        
        /// <summary>
        ///  Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_Q")]
        EU_EMIRTypeQ,
        
        /// <summary>
        ///  Denotes shares or units in undertakings for collective investments in transferable securities (UCITS), provided that the conditions set out in Article 5 of EU Regulation 2016/2251 are met.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_TYPE_R")]
        EU_EMIRTypeR
    }
    
    /// <summary>
    /// The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation.
    /// </summary>
    [CdmName("EntityTypeEnum")]
    public enum EntityType
    {
        /// <summary>
        /// Entity Type of Asian.
        /// </summary>
        [EnumMember(Value = "ASIAN")]
        Asian,
        
        /// <summary>
        /// Entity Type of Australian and New Zealand.
        /// </summary>
        [EnumMember(Value = "AUSTRALIAN_AND_NEW_ZEALAND")]
        AustralianAndNewZealand,
        
        /// <summary>
        /// Entity Type of European Emerging Markets.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_EMERGING_MARKETS")]
        EuropeanEmergingMarkets,
        
        /// <summary>
        /// Entity Type of Japanese.
        /// </summary>
        [EnumMember(Value = "JAPANESE")]
        Japanese,
        
        /// <summary>
        /// Entity Type of North American High Yield.
        /// </summary>
        [EnumMember(Value = "NORTH_AMERICAN_HIGH_YIELD")]
        NorthAmericanHighYield,
        
        /// <summary>
        /// Entity Type of North American Insurance.
        /// </summary>
        [EnumMember(Value = "NORTH_AMERICAN_INSURANCE")]
        NorthAmericanInsurance,
        
        /// <summary>
        /// Entity Type of North American Investment Grade.
        /// </summary>
        [EnumMember(Value = "NORTH_AMERICAN_INVESTMENT_GRADE")]
        NorthAmericanInvestmentGrade,
        
        /// <summary>
        /// Entity Type of Singaporean.
        /// </summary>
        [EnumMember(Value = "SINGAPOREAN")]
        Singaporean,
        
        /// <summary>
        /// Entity Type of Western European.
        /// </summary>
        [EnumMember(Value = "WESTERN_EUROPEAN")]
        WesternEuropean,
        
        /// <summary>
        /// Entity Type of Western European Insurance.
        /// </summary>
        [EnumMember(Value = "WESTERN_EUROPEAN_INSURANCE")]
        WesternEuropeanInsurance
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the type of Equity.
    /// </summary>
    [CdmName("EquityTypeEnum")]
    public enum EquityType
    {
        /// <summary>
        /// Identifies an Equity of Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation.
        /// </summary>
        [EnumMember(Value = "NON_CONVERTIBLE_PREFERENCE")]
        NonConvertiblePreference,
        
        /// <summary>
        /// Identifies an Equity of Common stocks and shares.
        /// </summary>
        [EnumMember(Value = "ORDINARY")]
        Ordinary
    }
    
    /// <summary>
    /// The enumeration values to qualify the intent associated with a transaction event.
    /// </summary>
    [CdmName("EventIntentEnum")]
    public enum EventIntent
    {
        /// <summary>
        /// The intent is to allocate one or more trades as part of an allocated block trade.
        /// </summary>
        [EnumMember(Value = "ALLOCATION")]
        Allocation,
        
        /// <summary>
        /// The intent is to designate a stand-alone cash transfer as a result of Trade contracual terms e.g. incurred by payout for instance a Performance Amount or a Floating Rate Amount. The particular CashFlow at stake shall be further specified in priceTransferEnum or transferTypeEnum. For clarity, such intentEnum value shall not be used whenever a cash transfer is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. Decrease with Fees, Cross-Currency Notional Reset, etc. or any other Event whenever including a cash transfer with other features. For clarity, a principal payment related to a Principal Exhange is excluded as well, because a dedicated intentEnum value exists for this event i.e. PrincipalExchange value.
        /// </summary>
        [EnumMember(Value = "CASH_FLOW")]
        CashFlow,
        
        /// <summary>
        /// The intent is to clear the contract.
        /// </summary>
        [EnumMember(Value = "CLEARING")]
        Clearing,
        
        /// <summary>
        /// The intent is to compress multiple trades as part of a netting or compression event.
        /// </summary>
        [EnumMember(Value = "COMPRESSION")]
        Compression,
        
        /// <summary>
        /// The intent is to form a contract from an execution.
        /// </summary>
        [EnumMember(Value = "CONTRACT_FORMATION")]
        ContractFormation,
        
        /// <summary>
        /// The intent is to amend the terms of the contract through renegotiation.
        /// </summary>
        [EnumMember(Value = "CONTRACT_TERMS_AMENDMENT")]
        ContractTermsAmendment,
        
        /// <summary>
        /// The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
        /// </summary>
        [EnumMember(Value = "CORPORATE_ACTION_ADJUSTMENT")]
        CorporateActionAdjustment,
        
        /// <summary>
        /// The intent is to take into effect the occurrence of a Credit Event.
        /// </summary>
        [EnumMember(Value = "CREDIT_EVENT")]
        CreditEvent,
        
        /// <summary>
        /// The intent is to Decrease the quantity or notional of the contract.
        /// </summary>
        [EnumMember(Value = "DECREASE")]
        Decrease,
        
        /// <summary>
        /// The intent is to fully unwind the Trade, as a result of the application of Trade contractual terms (e.g. an obligation to do so before Termination Date as part of any kind of Early Termination terms) as defined within the CDM EarlyTerminationProvision data type. Accordingly, increase and decrease of positions which result from negotiation by the parties shall not be designated by such intentEnum. For clarity, partial exercise of an option before its expiration date is excluded as well, though related to Trade contract terms, because a dedicated intentEnum value exists for this event i.e. OptionExercise value.
        /// </summary>
        [EnumMember(Value = "EARLY_TERMINATION_PROVISION")]
        EarlyTerminationProvision,
        
        /// <summary>
        /// The intent is to Increase the quantity or notional of the contract.
        /// </summary>
        [EnumMember(Value = "INCREASE")]
        Increase,
        
        /// <summary>
        /// The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any). 
        /// </summary>
        [EnumMember(Value = "INDEX_TRANSITION")]
        IndexTransition,
        
        /// <summary>
        /// The intent is to increase or to decrease the notional of the Trade, in accordance with Notional Reset features e.g. could apply for Cross Currency Swaps, Equity Performance Swaps, etc.
        /// </summary>
        [EnumMember(Value = "NOTIONAL_RESET")]
        NotionalReset,
        
        /// <summary>
        /// The intent is to increase or to decrease the notional of the Trade, in accordance with Step features attached to a Payout Quantity.
        /// </summary>
        [EnumMember(Value = "NOTIONAL_STEP")]
        NotionalStep,
        
        /// <summary>
        /// The intent is to novate the contract.
        /// </summary>
        [EnumMember(Value = "NOVATION")]
        Novation,
        
        /// <summary>
        /// The intent is to record any kind of stand-alone obervervations e.g. internal data recording, usage of CDM for recording and/or exchanging data as part of pricing &apos;consensus&apos; processing, etc. For clarity, such intentEnum value shall not be used whenever an observation is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. CashFlow to which an observation of prices is associated, etc.
        /// </summary>
        [EnumMember(Value = "OBSERVATION_RECORD")]
        ObservationRecord,
        
        /// <summary>
        /// The intent is to Exercise a contract that is made of one or several option payout legs. For clarity, such intentEnum value shall not be used whenever an optional right is exercised in relation with a Trade which composition includes other types of payout legs e.g. right to call or to cancel before Termination Date as part of any kind of Early Termination terms other than genuine bermuda or american style features described in option payout. 
        /// </summary>
        [EnumMember(Value = "OPTION_EXERCISE")]
        OptionExercise,
        
        /// <summary>
        /// The intent is to cancel the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
        /// </summary>
        [EnumMember(Value = "OPTIONAL_CANCELLATION")]
        OptionalCancellation,
        
        /// <summary>
        /// The intent is to extend the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
        /// </summary>
        [EnumMember(Value = "OPTIONAL_EXTENSION")]
        OptionalExtension,
        
        /// <summary>
        /// The intent is to rebalance a portfolio, by inserting new derivatives transactions into portfolios of participants to reduce risks linked to those trades. These are offsetting trades that rebalance relationships between different counterparties when it comes to exposure of portfolios to certain types of risk, such as interest rate risk.
        /// </summary>
        [EnumMember(Value = "PORTFOLIO_REBALANCING")]
        PortfolioRebalancing,
        
        /// <summary>
        /// The intent is to pay or to receive a cash transfer, in accordance with Principal Exchange features.
        /// </summary>
        [EnumMember(Value = "PRINCIPAL_EXCHANGE")]
        PrincipalExchange,
        
        /// <summary>
        /// The intent is to reallocate one or more trades as part of an allocated block trade.
        /// </summary>
        [EnumMember(Value = "REALLOCATION")]
        Reallocation,
        
        /// <summary>
        /// The intent is to close a repo transaction through repurchase.
        /// </summary>
        [EnumMember(Value = "REPURCHASE")]
        Repurchase
    }
    
    /// <summary>
    /// The enumeration values to qualify the timestamps that can be associated with a lifecycle event. The reason for such approach is that the experience of integrating the DTCC and CME data representations suggests that a wide set of timestamps are currently utilized among service providers, while there is not at present an objective set of criteria that could help suggest a defined set of timestamps as part of the CDM. Implementers are expected to evaluate the current enumeration values to determine whether those meet their requirements. If not, they are expected to engage with the CDM team to evaluate the addition of further value(s) to this enumeration, which will then participate to the development of a compendium for further evaluation at a later point in order to determine whether this modeling is appropriate.
    /// </summary>
    [CdmName("EventTimestampQualificationEnum")]
    public enum EventTimestampQualification
    {
        /// <summary>
        /// The date and time on which trade was confirmed as cleared.
        /// </summary>
        [EnumMember(Value = "CLEARING_CONFIRMATION_DATE_TIME")]
        ClearingConfirmationDateTime,
        
        /// <summary>
        /// The date and time on the trade was cleared.
        /// </summary>
        [EnumMember(Value = "CLEARING_DATE_TIME")]
        ClearingDateTime,
        
        /// <summary>
        /// The date and time on which trade was received by Clearing Body.
        /// </summary>
        [EnumMember(Value = "CLEARING_RECEIPT_DATE_TIME")]
        ClearingReceiptDateTime,
        
        /// <summary>
        /// The date and time on which the event was submitted for clearing.
        /// </summary>
        [EnumMember(Value = "CLEARING_SUBMISSION_DATE_TIME")]
        ClearingSubmissionDateTime,
        
        /// <summary>
        /// The date and time on which the event was confirmed.
        /// </summary>
        [EnumMember(Value = "CONFIRMATION_DATE_TIME")]
        ConfirmationDateTime,
        
        /// <summary>
        /// The date and time on which the event was created.
        /// </summary>
        [EnumMember(Value = "EVENT_CREATION_DATE_TIME")]
        EventCreationDateTime,
        
        /// <summary>
        /// The date and time on which the event will be considered expired.
        /// </summary>
        [EnumMember(Value = "EVENT_EXPIRATION_DATE_TIME")]
        EventExpirationDateTime,
        
        /// <summary>
        /// The date and time on which the event was processed.
        /// </summary>
        [EnumMember(Value = "EVENT_PROCESSING_DATE_TIME")]
        EventProcessingDateTime,
        
        /// <summary>
        /// The date and time on which the event was sent.
        /// </summary>
        [EnumMember(Value = "EVENT_SENT_DATE_TIME")]
        EventSentDateTime,
        
        /// <summary>
        /// The date and time on which the event was submitted.
        /// </summary>
        [EnumMember(Value = "EVENT_SUBMITTED_DATE_TIME")]
        EventSubmittedDateTime,
        
        /// <summary>
        /// The date and time on which the trade execution was performed.
        /// </summary>
        [EnumMember(Value = "EXECUTION_DATE_TIME")]
        ExecutionDateTime,
        
        /// <summary>
        /// The date and time on which the transaction has been created. This timestamp is specified as such by the CME ClearPort Matched IRS Trade submission API specification: &apos;The transaction date time of the trade. Represents the date &amp; time on which the trade was initially generated either by CME Clearing or firm. The transaction date time may be assigned by CME Clearing at the point the trade is reported as cleared. Transaction date time can also be provided by an external submitter of the trade at the point the trade is submitted.&apos;
        /// </summary>
        [EnumMember(Value = "TRANSACTION_CREATION_DATE_TIME")]
        TransactionCreationDateTime
    }
    
    /// <summary>
    /// The enumerated values to specify the Execution Location of a Security Agreement
    /// </summary>
    [CdmName("ExecutionLocationEnum")]
    public enum ExecutionLocation
    {
        /// <summary>
        /// The Agreement was executed outside of Belgium
        /// </summary>
        [EnumMember(Value = "EXECUTED_IN_BELGIUM")]
        ExecutedInBelgium,
        
        /// <summary>
        /// The Agreement was executed outside of Belgium
        /// </summary>
        [EnumMember(Value = "EXECUTED_OUTSIDE_BELGIUM")]
        ExecutedOutsideBelgium,
        
        /// <summary>
        /// An alternative approach is described in the document as follows.
        /// </summary>
        [EnumMember(Value = "OTHER_LOCATION")]
        OtherLocation
    }
    
    /// <summary>
    /// The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ...
    /// </summary>
    [CdmName("ExecutionTypeEnum")]
    public enum ExecutionType
    {
        /// <summary>
        /// Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message.
        /// </summary>
        [EnumMember(Value = "ELECTRONIC")]
        Electronic,
        
        /// <summary>
        /// Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
        /// </summary>
        [EnumMember(Value = "OFF_FACILITY")]
        OffFacility,
        
        /// <summary>
        /// Execution via a platform that may or may not be covered by a regulatory defintion. OnVenue is intended to distinguish trades executed on a trading platform from those executed via phone, email or messaging apps. The role and details of the venue are included in the party attribute of the trade. The general rule is that if the parties utilitzed the services of the platform to execute the trade then it would be considered OnVenue.
        /// </summary>
        [EnumMember(Value = "ON_VENUE")]
        OnVenue
    }
    
    /// <summary>
    /// Defines the principal party to the trade that has the right to exercise.
    /// </summary>
    [CdmName("ExerciseNoticeGiverEnum")]
    public enum ExerciseNoticeGiver
    {
        /// <summary>
        /// Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_AGREEMENT")]
        AsSpecifiedInMasterAgreement,
        
        /// <summary>
        /// Specifies that both the option buyer and option seller has the right to exercise.
        /// </summary>
        [EnumMember(Value = "BOTH")]
        Both,
        
        /// <summary>
        /// Specifies that only the option buyer has the right to exercise.
        /// </summary>
        [EnumMember(Value = "BUYER")]
        Buyer,
        
        /// <summary>
        /// Specifies that only the option seller has the right to exercise.
        /// </summary>
        [EnumMember(Value = "SELLER")]
        Seller
    }
    
    /// <summary>
    /// The time of day at which the equity option expires, for example the official closing time of the exchange.
    /// </summary>
    [CdmName("ExpirationTimeTypeEnum")]
    public enum ExpirationTimeType
    {
        /// <summary>
        /// The time is determined as provided in the relevant Master Confirmation.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_CONFIRMATION")]
        AsSpecifiedInMasterConfirmation,
        
        /// <summary>
        /// The official closing time of the exchange on the valuation date.
        /// </summary>
        [EnumMember(Value = "CLOSE")]
        Close,
        
        /// <summary>
        /// The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlyer.
        /// </summary>
        [EnumMember(Value = "DERIVATIVES_CLOSE")]
        DerivativesClose,
        
        /// <summary>
        /// The time at which the official settlement price is determined.
        /// </summary>
        OSP,
        
        /// <summary>
        /// The official opening time of the exchange on the valuation date.
        /// </summary>
        [EnumMember(Value = "OPEN")]
        Open,
        
        /// <summary>
        /// The time specified in the element equityExpirationTime or valuationTime (as appropriate)
        /// </summary>
        [EnumMember(Value = "SPECIFIC_TIME")]
        SpecificTime,
        
        /// <summary>
        /// The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
        /// </summary>
        XETRA
    }
    
    /// <summary>
    /// Specifies the fallback provisions in respect to the applicable Futures Price Valuation.
    /// </summary>
    [CdmName("FPVFinalPriceElectionFallbackEnum")]
    public enum FPVFinalPriceElectionFallback
    {
        /// <summary>
        /// In respect of the Early Final Valuation Date, the provisions for FPV Close shall apply.
        /// </summary>
        [EnumMember(Value = "FPV_CLOSE")]
        FPVClose,
        
        /// <summary>
        /// In respect of the Early Final Valuation Date, the provisions for FPV Hedge Execution shall apply.
        /// </summary>
        [EnumMember(Value = "FPV_HEDGE_EXECUTION")]
        FPVHedgeExecution
    }
    
    /// <summary>
    /// The enumerated values to specify an event that has given rise to a fee.
    /// </summary>
    [CdmName("FeeTypeEnum")]
    public enum FeeType
    {
        /// <summary>
        /// A cash flow resulting from the assignment of a contract to a new counterparty.
        /// </summary>
        [EnumMember(Value = "ASSIGNMENT")]
        Assignment,
        
        /// <summary>
        /// The brokerage commission.
        /// </summary>
        [EnumMember(Value = "BROKERAGE_COMMISSION")]
        BrokerageCommission,
        
        /// <summary>
        /// A cash flow associated with a corporate action
        /// </summary>
        [EnumMember(Value = "CORPORATE_ACTION")]
        CorporateAction,
        
        /// <summary>
        /// A cash flow associated with a credit event.
        /// </summary>
        [EnumMember(Value = "CREDIT_EVENT")]
        CreditEvent,
        
        /// <summary>
        /// A cash flow associated with an increase lifecycle event.
        /// </summary>
        [EnumMember(Value = "INCREASE")]
        Increase,
        
        /// <summary>
        /// The novation fee.
        /// </summary>
        [EnumMember(Value = "NOVATION")]
        Novation,
        
        /// <summary>
        /// A cash flow associated with a partial termination lifecycle event.
        /// </summary>
        [EnumMember(Value = "PARTIAL_TERMINATION")]
        PartialTermination,
        
        /// <summary>
        /// Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
        /// </summary>
        [EnumMember(Value = "PREMIUM")]
        Premium,
        
        /// <summary>
        /// A cash flow associated with a renegotiation lifecycle event.
        /// </summary>
        [EnumMember(Value = "RENEGOTIATION")]
        Renegotiation,
        
        /// <summary>
        /// A cash flow associated with a termination lifecycle event.
        /// </summary>
        [EnumMember(Value = "TERMINATION")]
        Termination,
        
        /// <summary>
        /// An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
        /// </summary>
        [EnumMember(Value = "UPFRONT")]
        Upfront
    }
    
    /// <summary>
    /// To be specified only for products that embed a redemption payment.
    /// </summary>
    [CdmName("FinalPrincipalExchangeCalculationEnum")]
    public enum FinalPrincipalExchangeCalculation
    {
        /// <summary>
        /// If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base).
        /// </summary>
        [EnumMember(Value = "FLOORED")]
        Floored,
        
        /// <summary>
        /// If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base.
        /// </summary>
        [EnumMember(Value = "NON_FLOORED")]
        NonFloored
    }
    
    /// <summary>
    /// Provides enumerated values for financial units, generally used in the context of defining quantities for securities.
    /// </summary>
    [CdmName("FinancialUnitEnum")]
    public enum FinancialUnit
    {
        /// <summary>
        /// Denotes financial contracts, such as listed futures and options.
        /// </summary>
        [EnumMember(Value = "CONTRACT")]
        Contract,
        
        /// <summary>
        /// Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount.
        /// </summary>
        [EnumMember(Value = "CONTRACTUAL_PRODUCT")]
        ContractualProduct,
        
        /// <summary>
        /// Denotes a price expressed in index points, e.g. for a stock index.
        /// </summary>
        [EnumMember(Value = "INDEX_UNIT")]
        IndexUnit,
        
        /// <summary>
        /// Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month.
        /// </summary>
        [EnumMember(Value = "LOG_NORMAL_VOLATILITY")]
        LogNormalVolatility,
        
        /// <summary>
        /// Denotes the number of units of financial stock shares.
        /// </summary>
        [EnumMember(Value = "SHARE")]
        Share,
        
        /// <summary>
        /// Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names.
        /// </summary>
        [EnumMember(Value = "VALUE_PER_DAY")]
        ValuePerDay,
        
        /// <summary>
        /// Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk.
        /// </summary>
        [EnumMember(Value = "VALUE_PER_PERCENT")]
        ValuePerPercent,
        
        /// <summary>
        /// Denotes a quantity (expressed as a decimal value) represented the weight of a component in a basket.
        /// </summary>
        [EnumMember(Value = "WEIGHT")]
        Weight
    }
    
    /// <summary>
    /// 3rd level ISDA FRO category.
    /// </summary>
    [CdmName("FloatingRateIndexCalculationMethodEnum")]
    public enum FloatingRateIndexCalculationMethod
    {
        [EnumMember(Value = "All-In Compounded Index")]
        AllInCompounded,
        
        /// <summary>
        /// A calculation methodology using the arithmetic mean.
        /// </summary>
        [EnumMember(Value = "Overnight Averaging")]
        Average,
        
        [EnumMember(Value = "Compounded Index")]
        Compounded,
        
        /// <summary>
        /// A calculation methodology using the ISDA-defined OIS compounding formula.
        /// </summary>
        [EnumMember(Value = "OIS Compounding")]
        OISCompound
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this FloatingRateIndexCalculationMethod value)
        {
            return value switch
            {
                FloatingRateIndexCalculationMethod.AllInCompounded => "All-In Compounded Index",
                FloatingRateIndexCalculationMethod.Average => "Overnight Averaging",
                FloatingRateIndexCalculationMethod.Compounded => "Compounded Index",
                FloatingRateIndexCalculationMethod.OISCompound => "OIS Compounding",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Top level ISDA FRO category.
    /// </summary>
    [CdmName("FloatingRateIndexCategoryEnum")]
    public enum FloatingRateIndexCategory
    {
        /// <summary>
        /// The rate is calculated by the calculation agents from multiple observations.
        /// </summary>
        [EnumMember(Value = "Calculated Rate")]
        Calculated,
        
        /// <summary>
        /// The rate is obtained by polling several other banks.
        /// </summary>
        [EnumMember(Value = "Reference Banks Rate")]
        ReferenceBanks,
        
        /// <summary>
        /// The rate is observed directly from a screen.
        /// </summary>
        [EnumMember(Value = "Screen Rate")]
        ScreenRate
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this FloatingRateIndexCategory value)
        {
            return value switch
            {
                FloatingRateIndexCategory.Calculated => "Calculated Rate",
                FloatingRateIndexCategory.ReferenceBanks => "Reference Banks Rate",
                FloatingRateIndexCategory.ScreenRate => "Screen Rate",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumerated values to specify the list of floating rate index.
    /// </summary>
    [CdmName("FloatingRateIndexEnum")]
    public enum FloatingRateIndex
    {
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AED-EBOR-Reuters")]
        AED_EBOR_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AED-EIBOR")]
        AED_EIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-AONIA")]
        AUD_AONIA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-AONIA-OIS-COMPOUND")]
        AUD_AONIA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-AONIA-OIS-COMPOUND-SwapMarker")]
        AUD_AONIA_OIS_COMPOUND_SwapMarker,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-AONIA-OIS Compound")]
        AUD_AONIA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBR-AUBBSW")]
        AUD_BBR_AUBBSW,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBR-BBSW")]
        AUD_BBR_BBSW,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBR-BBSW-Bloomberg")]
        AUD_BBR_BBSW_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBR-BBSY (BID)")]
        AUD_BBR_BBSY__BID_,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBR-ISDC")]
        AUD_BBR_ISDC,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBSW")]
        AUD_BBSW,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBSW Quarterly Swap Rate ICAP")]
        AUD_BBSW_Quarterly_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBSW Semi Annual Swap Rate ICAP")]
        AUD_BBSW_Semi_Annual_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-BBSY Bid")]
        AUD_BBSY_Bid,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-LIBOR-BBA")]
        AUD_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-LIBOR-BBA-Bloomberg")]
        AUD_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-LIBOR-Reference Banks")]
        AUD_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Quarterly Swap Rate-ICAP")]
        AUD_Quarterly_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Quarterly Swap Rate-ICAP-Reference Banks")]
        AUD_Quarterly_Swap_Rate_ICAP_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        AUD_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")]
        AUD_Semi_Annual_Swap_Rate_BGCANTOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Semi-Annual Swap Rate-ICAP-Reference Banks")]
        AUD_Semi_Annual_Swap_Rate_ICAP_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Semi-annual Swap Rate-ICAP")]
        AUD_Semi_annual_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "AUD-Swap Rate-Reuters")]
        AUD_Swap_Rate_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "BRL-CDI")]
        BRL_CDI,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-CDOR")]
        CAD_BA_CDOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-CDOR-Bloomberg")]
        CAD_BA_CDOR_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-ISDD")]
        CAD_BA_ISDD,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-Reference Banks")]
        CAD_BA_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-Reuters")]
        CAD_BA_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-BA-Telerate")]
        CAD_BA_Telerate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CDOR")]
        CAD_CDOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CORRA")]
        CAD_CORRA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CORRA CanDeal TMX Term")]
        CAD_CORRA_CanDeal_TMX_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CORRA Compounded Index")]
        CAD_CORRA_Compounded_Index,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CORRA-OIS-COMPOUND")]
        CAD_CORRA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-CORRA-OIS Compound")]
        CAD_CORRA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-ISDA-Swap Rate")]
        CAD_ISDA_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-LIBOR-BBA")]
        CAD_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-LIBOR-BBA-Bloomberg")]
        CAD_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-LIBOR-BBA-SwapMarker")]
        CAD_LIBOR_BBA_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-LIBOR-Reference Banks")]
        CAD_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-REPO-CORRA")]
        CAD_REPO_CORRA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-TBILL-ISDD")]
        CAD_TBILL_ISDD,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-TBILL-Reference Banks")]
        CAD_TBILL_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-TBILL-Reuters")]
        CAD_TBILL_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CAD-TBILL-Telerate")]
        CAD_TBILL_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-3M LIBOR SWAP-CME vs LCH-ICAP")]
        CHF_3M_LIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        CHF_3M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP")]
        CHF_3M_LIBOR_SWAP_EUREX_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")]
        CHF_3M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-6M LIBORSWAP-CME vs LCH-ICAP-Bloomberg")]
        CHF_6M_LIBORSWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-6M LIBOR SWAP-CME vs LCH-ICAP")]
        CHF_6M_LIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP")]
        CHF_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")]
        CHF_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-Annual Swap Rate")]
        CHF_Annual_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-Annual Swap Rate-11:00-ICAP")]
        CHF_Annual_Swap_Rate_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-Annual Swap Rate-Reference Banks")]
        CHF_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-Basis Swap-3m vs 6m-LIBOR-11:00-ICAP")]
        CHF_Basis_Swap_3m_vs_6m_LIBOR_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-ISDAFIX-Swap Rate")]
        CHF_ISDAFIX_Swap_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-LIBOR")]
        CHF_LIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-LIBOR-BBA")]
        CHF_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-LIBOR-BBA-Bloomberg")]
        CHF_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-LIBOR-ISDA")]
        CHF_LIBOR_ISDA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-LIBOR-Reference Banks")]
        CHF_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-OIS-11:00-ICAP")]
        CHF_OIS_11_00_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON")]
        CHF_SARON,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 12M")]
        CHF_SARON_Average_12M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 1M")]
        CHF_SARON_Average_1M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 1W")]
        CHF_SARON_Average_1W,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 2M")]
        CHF_SARON_Average_2M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 3M")]
        CHF_SARON_Average_3M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 6M")]
        CHF_SARON_Average_6M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Average 9M")]
        CHF_SARON_Average_9M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON Compounded Index")]
        CHF_SARON_Compounded_Index,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON-OIS-COMPOUND")]
        CHF_SARON_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-SARON-OIS Compound")]
        CHF_SARON_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF-TOIS-OIS-COMPOUND")]
        CHF_TOIS_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CHF USD-Basis Swaps-11:00-ICAP")]
        CHF_USD_Basis_Swaps_11_00_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CLP-ICP")]
        CLP_ICP,
        
        /// <summary>
        /// Refers to the Indice Camara Promedio (&apos;ICP&apos;) rate for Chilean Pesos which, for a Reset Date, is determined and published by the Asociacion de Bancos e Instituciones Financieras de Chile A.G. (&apos;ABIF&apos;) in accordance with the &apos;Reglamento Indice de Camara Promedio&apos; of the ABIF as published in the Diario Oficial de la Republica de Chile (the &apos;ICP Rules&apos;) and which is reported on the ABIF website by not later than 10:00 a.m., Santiago time, on that Reset Date.
        /// </summary>
        [EnumMember(Value = "CLP-TNA")]
        CLP_TNA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CL-CLICP-Bloomberg")]
        CL_CLICP_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNH-HIBOR")]
        CNH_HIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNH-HIBOR-Reference Banks")]
        CNH_HIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNH-HIBOR-TMA")]
        CNH_HIBOR_TMA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY 7-Repo Compounding Date")]
        CNY_7_Repo_Compounding_Date,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-CNREPOFIX=CFXS-Reuters")]
        CNY_CNREPOFIX_CFXS_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Deposit Rate")]
        CNY_Deposit_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Fixing Repo Rate")]
        CNY_Fixing_Repo_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-LPR")]
        CNY_LPR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-PBOCB-Reuters")]
        CNY_PBOCB_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Quarterly 7D Repo NDS Rate Tradition")]
        CNY_Quarterly_7D_Repo_NDS_Rate_Tradition,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION")]
        CNY_Quarterly_7_day_Repo_Non_Deliverable_Swap_Rate_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION-Reference Banks")]
        CNY_Quarterly_7_day_Repo_Non_Deliverable_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-SHIBOR")]
        CNY_SHIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-SHIBOR-OIS Compound")]
        CNY_SHIBOR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction..
        /// </summary>
        [EnumMember(Value = "CNY-SHIBOR-Reuters")]
        CNY_SHIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        CNY_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Semi-Annual Swap Rate-Reference Banks")]
        CNY_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CNY-Shibor-OIS-Compounding")]
        CNY_Shibor_OIS_Compounding,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "COP-IBR-OIS-COMPOUND")]
        COP_IBR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "COP-IBR-OIS Compound")]
        COP_IBR_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-Annual Swap Rate-11:00-BGCANTOR")]
        CZK_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-Annual Swap Rate-Reference Banks")]
        CZK_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-CZEONIA")]
        CZK_CZEONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-CZEONIA-OIS Compound")]
        CZK_CZEONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-PRIBOR")]
        CZK_PRIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-PRIBOR-PRBO")]
        CZK_PRIBOR_PRBO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "CZK-PRIBOR-Reference Banks")]
        CZK_PRIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR")]
        DKK_CIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR2")]
        DKK_CIBOR2,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR2-Bloomberg")]
        DKK_CIBOR2_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR2-DKNA13")]
        DKK_CIBOR2_DKNA13,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR-DKNA13")]
        DKK_CIBOR_DKNA13,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR-DKNA13-Bloomberg")]
        DKK_CIBOR_DKNA13_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CIBOR-Reference Banks")]
        DKK_CIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CITA")]
        DKK_CITA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-CITA-DKNA14-COMPOUND")]
        DKK_CITA_DKNA14_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-DESTR")]
        DKK_DESTR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-DESTR Compounded Index")]
        DKK_DESTR_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-DESTR-OIS Compound")]
        DKK_DESTR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-DKKOIS-OIS-COMPOUND")]
        DKK_DKKOIS_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "DKK-Tom Next-OIS Compound")]
        DKK_Tom_Next_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-3M EURIBOR SWAP-CME vs LCH-ICAP")]
        EUR_3M_EURIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-3M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        EUR_3M_EURIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP")]
        EUR_3M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")]
        EUR_3M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-6M EURIBOR SWAP-CME vs LCH-ICAP")]
        EUR_6M_EURIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-6M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        EUR_6M_EURIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP")]
        EUR_6M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")]
        EUR_6M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00")]
        EUR_Annual_Swap_Rate_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00-BGCANTOR")]
        EUR_Annual_Swap_Rate_10_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00-Bloomberg")]
        EUR_Annual_Swap_Rate_10_00_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00-ICAP")]
        EUR_Annual_Swap_Rate_10_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00-SwapMarker")]
        EUR_Annual_Swap_Rate_10_00_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-10:00-TRADITION")]
        EUR_Annual_Swap_Rate_10_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-11:00")]
        EUR_Annual_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-11:00-Bloomberg")]
        EUR_Annual_Swap_Rate_11_00_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-11:00-ICAP")]
        EUR_Annual_Swap_Rate_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-11:00-SwapMarker")]
        EUR_Annual_Swap_Rate_11_00_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-3 Month")]
        EUR_Annual_Swap_Rate_3_Month,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-3 Month-SwapMarker")]
        EUR_Annual_Swap_Rate_3_Month_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-4:15-TRADITION")]
        EUR_Annual_Swap_Rate_4_15_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-Annual Swap Rate-Reference Banks")]
        EUR_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR Basis Swap-EONIA vs 3m EUR+IBOR Swap Rates-A/360-10:00-ICAP")]
        EUR_Basis_Swap_EONIA_vs_3m_EUR_IBOR_Swap_Rates_A_360_10_00_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-CNO TEC10")]
        EUR_CNO_TEC10,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA")]
        EUR_EONIA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-AVERAGE")]
        EUR_EONIA_AVERAGE_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-Average")]
        EUR_EONIA_Average,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-10:00-BGCANTOR")]
        EUR_EONIA_OIS_10_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-10:00-ICAP")]
        EUR_EONIA_OIS_10_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-10:00-TRADITION")]
        EUR_EONIA_OIS_10_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-11:00-ICAP")]
        EUR_EONIA_OIS_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-4:15-TRADITION")]
        EUR_EONIA_OIS_4_15_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-COMPOUND")]
        EUR_EONIA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS-COMPOUND-Bloomberg")]
        EUR_EONIA_OIS_COMPOUND_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-OIS Compound")]
        EUR_EONIA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EONIA-Swap-Index")]
        EUR_EONIA_Swap_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR")]
        EUR_EURIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR-Act/365")]
        EUR_EURIBOR_Act_365,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR-Act/365-Bloomberg")]
        EUR_EURIBOR_Act_365_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR EURIBOR-Annual Bond Swap vs 1m-11:00-ICAP")]
        EUR_EURIBOR_Annual_Bond_Swap_vs_1m_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR EURIBOR-Basis Swap-1m vs 3m-Euribor-11:00-ICAP")]
        EUR_EURIBOR_Basis_Swap_1m_vs_3m_Euribor_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR EURIBOR-Basis Swap-3m vs 6m-11:00-ICAP")]
        EUR_EURIBOR_Basis_Swap_3m_vs_6m_11_00_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR ICE Swap Rate-11:00")]
        EUR_EURIBOR_ICE_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR ICE Swap Rate-12:00")]
        EUR_EURIBOR_ICE_Swap_Rate_12_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR-Reference Banks")]
        EUR_EURIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR-Reuters")]
        EUR_EURIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURIBOR-Telerate")]
        EUR_EURIBOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURONIA-OIS-COMPOUND")]
        EUR_EURONIA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EURONIA-OIS Compound")]
        EUR_EURONIA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR")]
        EUR_EuroSTR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Average 12M")]
        EUR_EuroSTR_Average_12M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Average 1M")]
        EUR_EuroSTR_Average_1M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Average 1W")]
        EUR_EuroSTR_Average_1W,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Average 3M")]
        EUR_EuroSTR_Average_3M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Average 6M")]
        EUR_EuroSTR_Average_6M,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR-COMPOUND")]
        EUR_EuroSTR_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Compounded Index")]
        EUR_EuroSTR_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR FTSE Term")]
        EUR_EuroSTR_FTSE_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index")]
        EUR_EuroSTR_ICE_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index 0 Floor")]
        EUR_EuroSTR_ICE_Compounded_Index_0_Floor,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index 0 Floor 2D Lag")]
        EUR_EuroSTR_ICE_Compounded_Index_0_Floor_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index 0 Floor 5D Lag")]
        EUR_EuroSTR_ICE_Compounded_Index_0_Floor_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index 2D Lag")]
        EUR_EuroSTR_ICE_Compounded_Index_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Compounded Index 5D Lag")]
        EUR_EuroSTR_ICE_Compounded_Index_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR ICE Swap Rate")]
        EUR_EuroSTR_ICE_Swap_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR-OIS Compound")]
        EUR_EuroSTR_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-EuroSTR Term")]
        EUR_EuroSTR_Term,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-ISDA-EURIBOR Swap Rate-11:00")]
        EUR_ISDA_EURIBOR_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-ISDA-EURIBOR Swap Rate-12:00")]
        EUR_ISDA_EURIBOR_Swap_Rate_12_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-ISDA-LIBOR Swap Rate-10:00")]
        EUR_ISDA_LIBOR_Swap_Rate_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-ISDA-LIBOR Swap Rate-11:00")]
        EUR_ISDA_LIBOR_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-LIBOR")]
        EUR_LIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-LIBOR-BBA")]
        EUR_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-LIBOR-BBA-Bloomberg")]
        EUR_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-LIBOR-Reference Banks")]
        EUR_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TAM-CDC")]
        EUR_TAM_CDC,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC10-CNO")]
        EUR_TEC10_CNO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC10-CNO-SwapMarker")]
        EUR_TEC10_CNO_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC10-Reference Banks")]
        EUR_TEC10_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC5-CNO")]
        EUR_TEC5_CNO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC5-CNO-SwapMarker")]
        EUR_TEC5_CNO_SwapMarker,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TEC5-Reference Banks")]
        EUR_TEC5_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR-TMM-CDC-COMPOUND")]
        EUR_TMM_CDC_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "EUR USD-Basis Swaps-11:00-ICAP")]
        EUR_USD_Basis_Swaps_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-6M LIBOR SWAP-CME vs LCH-ICAP")]
        GBP_6M_LIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        GBP_6M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP")]
        GBP_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg")]
        GBP_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-ISDA-Swap Rate")]
        GBP_ISDA_Swap_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR")]
        GBP_LIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR-BBA")]
        GBP_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR-BBA-Bloomberg")]
        GBP_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR ICE Swap Rate")]
        GBP_LIBOR_ICE_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR-ISDA")]
        GBP_LIBOR_ISDA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-LIBOR-Reference Banks")]
        GBP_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-RONIA")]
        GBP_RONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-RONIA-OIS Compound")]
        GBP_RONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA")]
        GBP_SONIA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA-COMPOUND")]
        GBP_SONIA_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA Compounded Index")]
        GBP_SONIA_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA FTSE Term")]
        GBP_SONIA_FTSE_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index")]
        GBP_SONIA_ICE_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index 0 Floor")]
        GBP_SONIA_ICE_Compounded_Index_0_Floor,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index 0 Floor 2D Lag")]
        GBP_SONIA_ICE_Compounded_Index_0_Floor_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index 0 Floor 5D Lag")]
        GBP_SONIA_ICE_Compounded_Index_0_Floor_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index 2D Lag")]
        GBP_SONIA_ICE_Compounded_Index_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Compounded Index 5D Lag")]
        GBP_SONIA_ICE_Compounded_Index_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Swap Rate")]
        GBP_SONIA_ICE_Swap_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA ICE Term")]
        GBP_SONIA_ICE_Term,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA-OIS-11:00-ICAP")]
        GBP_SONIA_OIS_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA-OIS-11:00-TRADITION")]
        GBP_SONIA_OIS_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA-OIS-4:15-TRADITION")]
        GBP_SONIA_OIS_4_15_TRADITION,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA-OIS Compound")]
        GBP_SONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-SONIA Swap Rate")]
        GBP_SONIA_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi-Annual Swap Rate")]
        GBP_Semi_Annual_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi-Annual Swap Rate-11:00-ICAP")]
        GBP_Semi_Annual_Swap_Rate_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi Annual Swap Rate-11:00-TRADITION")]
        GBP_Semi_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi Annual Swap Rate-4:15-TRADITION")]
        GBP_Semi_Annual_Swap_Rate_4_15_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi-Annual Swap Rate-Reference Banks")]
        GBP_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-Semi-Annual Swap Rate-SwapMarker26")]
        GBP_Semi_Annual_Swap_Rate_SwapMarker26,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-UK Base Rate")]
        GBP_UK_Base_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP USD-Basis Swaps-11:00-ICAP")]
        GBP_USD_Basis_Swaps_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-WMBA-RONIA-COMPOUND")]
        GBP_WMBA_RONIA_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GBP-WMBA-SONIA-COMPOUND")]
        GBP_WMBA_SONIA_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GRD-ATHIBOR-ATHIBOR")]
        GRD_ATHIBOR_ATHIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GRD-ATHIBOR-Reference Banks")]
        GRD_ATHIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GRD-ATHIBOR-Telerate")]
        GRD_ATHIBOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GRD-ATHIMID-Reference Banks")]
        GRD_ATHIMID_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "GRD-ATHIMID-Reuters")]
        GRD_ATHIMID_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR")]
        HKD_HIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-HIBOR=")]
        HKD_HIBOR_HIBOR_,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-HIBOR-Bloomberg")]
        HKD_HIBOR_HIBOR_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-HKAB")]
        HKD_HIBOR_HKAB,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-HKAB-Bloomberg")]
        HKD_HIBOR_HKAB_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-ISDC")]
        HKD_HIBOR_ISDC,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HIBOR-Reference Banks")]
        HKD_HIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HONIA")]
        HKD_HONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HONIA-OIS Compound")]
        HKD_HONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-HONIX-OIS-COMPOUND")]
        HKD_HONIX_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-ISDA-Swap Rate-11:00")]
        HKD_ISDA_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-ISDA-Swap Rate-4:00")]
        HKD_ISDA_Swap_Rate_4_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")]
        HKD_Quarterly_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Annual Swap Rate-11:00-TRADITION")]
        HKD_Quarterly_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Annual Swap Rate-4:00-BGCANTOR")]
        HKD_Quarterly_Annual_Swap_Rate_4_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Annual Swap Rate-Reference Banks")]
        HKD_Quarterly_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Quarterly Swap Rate-11:00-ICAP")]
        HKD_Quarterly_Quarterly_Swap_Rate_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Quarterly Swap Rate-4:00-ICAP")]
        HKD_Quarterly_Quarterly_Swap_Rate_4_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HKD-Quarterly-Quarterly Swap Rate-Reference Banks")]
        HKD_Quarterly_Quarterly_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HUF-BUBOR")]
        HUF_BUBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HUF-BUBOR-Reference Banks")]
        HUF_BUBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HUF-BUBOR-Reuters")]
        HUF_BUBOR_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HUF-HUFONIA")]
        HUF_HUFONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "HUF-HUFONIA-OIS Compound")]
        HUF_HUFONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-IDMA-Bloomberg")]
        IDR_IDMA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-IDRFIX")]
        IDR_IDRFIX,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-INDONIA")]
        IDR_INDONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-INDONIA-OIS Compound")]
        IDR_INDONIA_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-JIBOR")]
        IDR_JIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-JIBOR-Reuters")]
        IDR_JIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-SBI-Reuters")]
        IDR_SBI_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-SOR-Reference Banks")]
        IDR_SOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-SOR-Reuters")]
        IDR_SOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-SOR-Telerate")]
        IDR_SOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        IDR_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")]
        IDR_Semi_Annual_Swap_Rate_Non_deliverable_16_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "IDR-Semi-Annual Swap Rate-Reference Banks")]
        IDR_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ILS-SHIR")]
        ILS_SHIR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ILS-SHIR-OIS Compound")]
        ILS_SHIR_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ILS-TELBOR")]
        ILS_TELBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ILS-TELBOR01-Reuters")]
        ILS_TELBOR01_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ILS-TELBOR-Reference Banks")]
        ILS_TELBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-BMK")]
        INR_BMK,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-CMT")]
        INR_CMT,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-FBIL-MIBOR-OIS-COMPOUND")]
        INR_FBIL_MIBOR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-INBMK-REUTERS")]
        INR_INBMK_REUTERS,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MIBOR OIS")]
        INR_MIBOR_OIS,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MIBOR-OIS-COMPOUND")]
        INR_MIBOR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MIBOR-OIS Compound")]
        INR_MIBOR_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MIFOR")]
        INR_MIFOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MIOIS")]
        INR_MIOIS,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-MITOR-OIS-COMPOUND")]
        INR_MITOR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-Modified MIFOR")]
        INR_Modified_MIFOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-Reference Banks")]
        INR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-Semi-Annual Swap Rate-11:30-BGCANTOR")]
        INR_Semi_Annual_Swap_Rate_11_30_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon")]
        INR_Semi_Annual_Swap_Rate_Non_deliverable_16_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "INR-Semi-Annual Swap Rate-Reference Banks")]
        INR_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ISK-REIBOR")]
        ISK_REIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ISK-REIBOR-Reference Banks")]
        ISK_REIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ISK-REIBOR-Reuters")]
        ISK_REIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-Annual Swap Rate-11:00-TRADITION")]
        JPY_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-Annual Swap Rate-3:00-TRADITION")]
        JPY_Annual_Swap_Rate_3_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-BBSF-Bloomberg-10:00")]
        JPY_BBSF_Bloomberg_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-BBSF-Bloomberg-15:00")]
        JPY_BBSF_Bloomberg_15_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-Euroyen TIBOR")]
        JPY_Euroyen_TIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-ISDA-Swap Rate-10:00")]
        JPY_ISDA_Swap_Rate_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-ISDA-Swap Rate-15:00")]
        JPY_ISDA_Swap_Rate_15_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR")]
        JPY_LIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR-BBA")]
        JPY_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR-BBA-Bloomberg")]
        JPY_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR-FRASETT")]
        JPY_LIBOR_FRASETT,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR-ISDA")]
        JPY_LIBOR_ISDA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR-Reference Banks")]
        JPY_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR TSR-10:00")]
        JPY_LIBOR_TSR_10_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LIBOR TSR-15:00")]
        JPY_LIBOR_TSR_15_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LTPR MHBK")]
        JPY_LTPR_MHBK,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LTPR-MHCB")]
        JPY_LTPR_MHCB,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-LTPR-TBC")]
        JPY_LTPR_TBC,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-MUTANCALL-TONAR")]
        JPY_MUTANCALL_TONAR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-OIS-11:00-ICAP")]
        JPY_OIS_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-OIS-11:00-TRADITION")]
        JPY_OIS_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-OIS-3:00-TRADITION")]
        JPY_OIS_3_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-Quoting Banks-LIBOR")]
        JPY_Quoting_Banks_LIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-STPR-Quoting Banks")]
        JPY_STPR_Quoting_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR")]
        JPY_TIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-17096")]
        JPY_TIBOR_17096,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-17097")]
        JPY_TIBOR_17097,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-DTIBOR01")]
        JPY_TIBOR_DTIBOR01,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM")]
        JPY_TIBOR_TIBM,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM-Reference Banks")]
        JPY_TIBOR_TIBM_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM (10 Banks)")]
        JPY_TIBOR_TIBM__10_Banks_,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM (5 Banks)")]
        JPY_TIBOR_TIBM__5_Banks_,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM (All Banks)")]
        JPY_TIBOR_TIBM__All_Banks_,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-TIBM (All Banks)-Bloomberg")]
        JPY_TIBOR_TIBM__All_Banks__Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TIBOR-ZTIBOR")]
        JPY_TIBOR_ZTIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA")]
        JPY_TONA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA Average 180D")]
        JPY_TONA_Average_180D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA Average 30D")]
        JPY_TONA_Average_30D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA Average 90D")]
        JPY_TONA_Average_90D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA Compounded Index")]
        JPY_TONA_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index")]
        JPY_TONA_ICE_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index 0 Floor")]
        JPY_TONA_ICE_Compounded_Index_0_Floor,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index 0 Floor 2D Lag")]
        JPY_TONA_ICE_Compounded_Index_0_Floor_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index 0 Floor 5D Lag")]
        JPY_TONA_ICE_Compounded_Index_0_Floor_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index 2D Lag")]
        JPY_TONA_ICE_Compounded_Index_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA ICE Compounded Index 5D Lag")]
        JPY_TONA_ICE_Compounded_Index_5D_Lag,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA-OIS-COMPOUND")]
        JPY_TONA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA-OIS Compound")]
        JPY_TONA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA TSR-10:00")]
        JPY_TONA_TSR_10_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TONA TSR-15:00")]
        JPY_TONA_TSR_15_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TORF QUICK")]
        JPY_TORF_QUICK,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TSR-Reference Banks")]
        JPY_TSR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TSR-Reuters-10:00")]
        JPY_TSR_Reuters_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TSR-Reuters-15:00")]
        JPY_TSR_Reuters_15_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TSR-Telerate-10:00")]
        JPY_TSR_Telerate_10_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY-TSR-Telerate-15:00")]
        JPY_TSR_Telerate_15_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "JPY USD-Basis Swaps-11:00-ICAP")]
        JPY_USD_Basis_Swaps_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-Bond-3222")]
        KRW_Bond_3222,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-CD-3220")]
        KRW_CD_3220,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-CD 91D")]
        KRW_CD_91D,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-CD-KSDA-Bloomberg")]
        KRW_CD_KSDA_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-KOFR")]
        KRW_KOFR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-KOFR-OIS Compound")]
        KRW_KOFR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "KRW-Quarterly Annual Swap Rate-3:30-ICAP")]
        KRW_Quarterly_Annual_Swap_Rate_3_30_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE")]
        MXN_TIIE,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE-Banxico")]
        MXN_TIIE_Banxico,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE-Banxico-Bloomberg")]
        MXN_TIIE_Banxico_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE-Banxico-Reference Banks")]
        MXN_TIIE_Banxico_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE ON")]
        MXN_TIIE_ON,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE ON-OIS Compound")]
        MXN_TIIE_ON_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MXN-TIIE-Reference Banks")]
        MXN_TIIE_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-KLIBOR")]
        MYR_KLIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-KLIBOR-BNM")]
        MYR_KLIBOR_BNM,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-KLIBOR-Reference Banks")]
        MYR_KLIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-MYOR")]
        MYR_MYOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-MYOR-OIS Compound")]
        MYR_MYOR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-Quarterly Swap Rate-11:00-TRADITION")]
        MYR_Quarterly_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "MYR-Quarterly Swap Rate-TRADITION-Reference Banks")]
        MYR_Quarterly_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR")]
        NOK_NIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR-NIBR")]
        NOK_NIBOR_NIBR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR-NIBR-Bloomberg")]
        NOK_NIBOR_NIBR_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR-NIBR-Reference Banks")]
        NOK_NIBOR_NIBR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR-OIBOR")]
        NOK_NIBOR_OIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NIBOR-Reference Banks")]
        NOK_NIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NOWA")]
        NOK_NOWA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NOK-NOWA-OIS Compound")]
        NOK_NOWA_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BBR-BID")]
        NZD_BBR_BID,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BBR-FRA")]
        NZD_BBR_FRA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BBR-ISDC")]
        NZD_BBR_ISDC,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BBR-Reference Banks")]
        NZD_BBR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BBR-Telerate")]
        NZD_BBR_Telerate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BKBM Bid")]
        NZD_BKBM_Bid,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BKBM FRA")]
        NZD_BKBM_FRA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-BKBM FRA Swap Rate ICAP")]
        NZD_BKBM_FRA_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-NZIONA")]
        NZD_NZIONA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-NZIONA-OIS-COMPOUND")]
        NZD_NZIONA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-NZIONA-OIS Compound")]
        NZD_NZIONA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        NZD_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks")]
        NZD_Semi_Annual_Swap_Rate_BGCANTOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-Swap Rate-ICAP")]
        NZD_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "NZD-Swap Rate-ICAP-Reference Banks")]
        NZD_Swap_Rate_ICAP_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-ORR")]
        PHP_ORR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-PHIREF")]
        PHP_PHIREF,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-PHIREF-BAP")]
        PHP_PHIREF_BAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-PHIREF-Bloomberg")]
        PHP_PHIREF_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-PHIREF-Reference Banks")]
        PHP_PHIREF_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        PHP_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PHP-Semi-Annual Swap Rate-Reference Banks")]
        PHP_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-POLONIA")]
        PLN_POLONIA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-POLONIA-OIS-COMPOUND")]
        PLN_POLONIA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-POLONIA-OIS Compound")]
        PLN_POLONIA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIBID")]
        PLN_WIBID,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIBOR")]
        PLN_WIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIBOR-Reference Banks")]
        PLN_WIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIBOR-WIBO")]
        PLN_WIBOR_WIBO,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIRON")]
        PLN_WIRON,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLN-WIRON-OIS Compound")]
        PLN_WIRON_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLZ-WIBOR-Reference Banks")]
        PLZ_WIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "PLZ-WIBOR-WIBO")]
        PLZ_WIBOR_WIBO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "REPOFUNDS RATE-FRANCE-OIS-COMPOUND")]
        REPOFUNDS_RATE_FRANCE_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "REPOFUNDS RATE-GERMANY-OIS-COMPOUND")]
        REPOFUNDS_RATE_GERMANY_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "REPOFUNDS RATE-ITALY-OIS-COMPOUND")]
        REPOFUNDS_RATE_ITALY_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RON-Annual Swap Rate-11:00-BGCANTOR")]
        RON_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RON-Annual Swap Rate-Reference Banks")]
        RON_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RON-RBOR-Reuters")]
        RON_RBOR_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RON-ROBID")]
        RON_ROBID,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RON-ROBOR")]
        RON_ROBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Annual Swap Rate-11:00-BGCANTOR")]
        RUB_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Annual Swap Rate-12:45-TRADITION")]
        RUB_Annual_Swap_Rate_12_45_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Annual Swap Rate-4:15-TRADITION")]
        RUB_Annual_Swap_Rate_4_15_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Annual Swap Rate-Reference Banks")]
        RUB_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Annual Swap Rate-TRADITION-Reference Banks")]
        RUB_Annual_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-Key Rate CBRF")]
        RUB_Key_Rate_CBRF,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-MOSPRIME-NFEA")]
        RUB_MOSPRIME_NFEA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-MOSPRIME-Reference Banks")]
        RUB_MOSPRIME_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-MosPrime")]
        RUB_MosPrime,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-RUONIA")]
        RUB_RUONIA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-RUONIA-OIS-COMPOUND")]
        RUB_RUONIA_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "RUB-RUONIA-OIS Compound")]
        RUB_RUONIA_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SAR-SAIBOR")]
        SAR_SAIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SAR-SRIOR-Reference Banks")]
        SAR_SRIOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SAR-SRIOR-SUAA")]
        SAR_SRIOR_SUAA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-Annual Swap Rate")]
        SEK_Annual_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-Annual Swap Rate-SESWFI")]
        SEK_Annual_Swap_Rate_SESWFI,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SIOR-OIS-COMPOUND")]
        SEK_SIOR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-STIBOR")]
        SEK_STIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-STIBOR-Bloomberg")]
        SEK_STIBOR_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-STIBOR-OIS Compound")]
        SEK_STIBOR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-STIBOR-Reference Banks")]
        SEK_STIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-STIBOR-SIDE")]
        SEK_STIBOR_SIDE,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR")]
        SEK_SWESTR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Average 1M")]
        SEK_SWESTR_Average_1M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Average 1W")]
        SEK_SWESTR_Average_1W,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Average 2M")]
        SEK_SWESTR_Average_2M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Average 3M")]
        SEK_SWESTR_Average_3M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Average 6M")]
        SEK_SWESTR_Average_6M,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR Compounded Index")]
        SEK_SWESTR_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SEK-SWESTR-OIS Compound")]
        SEK_SWESTR_OIS_Compound,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SIBOR")]
        SGD_SIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SIBOR-Reference Banks")]
        SGD_SIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SIBOR-Reuters")]
        SGD_SIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SIBOR-Telerate")]
        SGD_SIBOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SONAR-OIS-COMPOUND")]
        SGD_SONAR_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SONAR-OIS-VWAP-COMPOUND")]
        SGD_SONAR_OIS_VWAP_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR")]
        SGD_SOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SORA")]
        SGD_SORA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SORA-COMPOUND")]
        SGD_SORA_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SORA-OIS Compound")]
        SGD_SORA_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR-Reference Banks")]
        SGD_SOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR-Reuters")]
        SGD_SOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR-Telerate")]
        SGD_SOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR-VWAP")]
        SGD_SOR_VWAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-SOR-VWAP-Reference Banks")]
        SGD_SOR_VWAP_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Currency Basis Swap Rate-11:00-Tullett Prebon")]
        SGD_Semi_Annual_Currency_Basis_Swap_Rate_11_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Currency Basis Swap Rate-16:00-Tullett Prebon")]
        SGD_Semi_Annual_Currency_Basis_Swap_Rate_16_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        SGD_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-11.00-TRADITION")]
        SGD_Semi_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-11:00-Tullett Prebon")]
        SGD_Semi_Annual_Swap_Rate_11_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-16:00-Tullett Prebon")]
        SGD_Semi_Annual_Swap_Rate_16_00_Tullett_Prebon,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-ICAP")]
        SGD_Semi_Annual_Swap_Rate_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-ICAP-Reference Banks")]
        SGD_Semi_Annual_Swap_Rate_ICAP_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-Reference Banks")]
        SGD_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SGD-Semi-Annual Swap Rate-TRADITION-Reference Banks")]
        SGD_Semi_Annual_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SKK-BRIBOR-BRBO")]
        SKK_BRIBOR_BRBO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SKK-BRIBOR-Bloomberg")]
        SKK_BRIBOR_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SKK-BRIBOR-NBSK07")]
        SKK_BRIBOR_NBSK07,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "SKK-BRIBOR-Reference Banks")]
        SKK_BRIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-SOR-Reference Banks")]
        THB_SOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-SOR-Reuters")]
        THB_SOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-SOR-Telerate")]
        THB_SOR_Telerate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        THB_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-Semi-Annual Swap Rate-Reference Banks")]
        THB_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THBFIX")]
        THB_THBFIX,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THBFIX-Reference Banks")]
        THB_THBFIX_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THBFIX-Reuters")]
        THB_THBFIX_Reuters,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THOR")]
        THB_THOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THOR-COMPOUND")]
        THB_THOR_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "THB-THOR-OIS Compound")]
        THB_THOR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY Annual Swap Rate-11:00-TRADITION")]
        TRY_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-Annual Swap Rate-11:15-BGCANTOR")]
        TRY_Annual_Swap_Rate_11_15_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-Annual Swap Rate-Reference Banks")]
        TRY_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-Semi-Annual Swap Rate-TRADITION-Reference Banks")]
        TRY_Semi_Annual_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TLREF")]
        TRY_TLREF,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TLREF-OIS-COMPOUND")]
        TRY_TLREF_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TLREF-OIS Compound")]
        TRY_TLREF_OIS_Compound_1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TRLIBOR")]
        TRY_TRLIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TRYIBOR-Reference Banks")]
        TRY_TRYIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TRY-TRYIBOR-Reuters")]
        TRY_TRYIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-Quarterly-Annual Swap Rate-11:00-BGCANTOR")]
        TWD_Quarterly_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-Quarterly-Annual Swap Rate-Reference Banks")]
        TWD_Quarterly_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-Reference Dealers")]
        TWD_Reference_Dealers,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-Reuters-6165")]
        TWD_Reuters_6165,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TAIBIR01")]
        TWD_TAIBIR01,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TAIBIR02")]
        TWD_TAIBIR02,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TAIBOR")]
        TWD_TAIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TAIBOR-Bloomberg")]
        TWD_TAIBOR_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TAIBOR-Reuters")]
        TWD_TAIBOR_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-TWCPBA")]
        TWD_TWCPBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "TWD-Telerate-6165")]
        TWD_Telerate_6165,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "UK Base Rate")]
        UK_Base_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-3M LIBOR SWAP-CME vs LCH-ICAP")]
        USD_3M_LIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        USD_3M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-6M LIBOR SWAP-CME vs LCH-ICAP")]
        USD_6M_LIBOR_SWAP_CME_vs_LCH_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg")]
        USD_6M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AMERIBOR")]
        USD_AMERIBOR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AMERIBOR Average 30D")]
        USD_AMERIBOR_Average_30D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AMERIBOR Average 90D")]
        USD_AMERIBOR_Average_90D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AMERIBOR Term")]
        USD_AMERIBOR_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AMERIBOR Term Structure")]
        USD_AMERIBOR_Term_Structure,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-AXI Term")]
        USD_AXI_Term,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Annual Swap Rate-11:00-BGCANTOR")]
        USD_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Annual Swap Rate-11:00-TRADITION")]
        USD_Annual_Swap_Rate_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Annual Swap Rate-4:00-TRADITION")]
        USD_Annual_Swap_Rate_4_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-BA-H.15")]
        USD_BA_H_15,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-BA-Reference Dealers")]
        USD_BA_Reference_Dealers,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-BMA Municipal Swap Index")]
        USD_BMA_Municipal_Swap_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-BSBY")]
        USD_BSBY,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CD-H.15")]
        USD_CD_H_15,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CD-Reference Dealers")]
        USD_CD_Reference_Dealers,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMS-Reference Banks")]
        USD_CMS_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMS-Reference Banks-ICAP SwapPX")]
        USD_CMS_Reference_Banks_ICAP_SwapPX,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMS-Reuters")]
        USD_CMS_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMS-Telerate")]
        USD_CMS_Telerate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMT")]
        USD_CMT,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMT Average 1W")]
        USD_CMT_Average_1W,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMT-T7051")]
        USD_CMT_T7051,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CMT-T7052")]
        USD_CMT_T7052,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-COF11-FHLBSF")]
        USD_COF11_FHLBSF,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-COF11-Reuters")]
        USD_COF11_Reuters,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-COF11-Telerate")]
        USD_COF11_Telerate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-COFI")]
        USD_COFI,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CP-H.15")]
        USD_CP_H_15,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CP-Money Market Yield")]
        USD_CP_Money_Market_Yield,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CP-Reference Dealers")]
        USD_CP_Reference_Dealers,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-CRITR")]
        USD_CRITR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-FFCB-DISCO")]
        USD_FFCB_DISCO,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-FXI Term")]
        USD_FXI_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds")]
        USD_Federal_Funds,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds-H.15")]
        USD_Federal_Funds_H_15,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds-H.15-Bloomberg")]
        USD_Federal_Funds_H_15_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds-H.15-OIS-COMPOUND")]
        USD_Federal_Funds_H_15_OIS_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds-OIS Compound")]
        USD_Federal_Funds_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Federal Funds-Reference Dealers")]
        USD_Federal_Funds_Reference_Dealers,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-ISDAFIX3-Swap Rate")]
        USD_ISDAFIX3_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-ISDAFIX3-Swap Rate-3:00")]
        USD_ISDAFIX3_Swap_Rate_3_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-ISDA-Swap Rate")]
        USD_ISDA_Swap_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-ISDA-Swap Rate-3:00")]
        USD_ISDA_Swap_Rate_3_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR")]
        USD_LIBOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR-BBA")]
        USD_LIBOR_BBA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR-BBA-Bloomberg")]
        USD_LIBOR_BBA_Bloomberg,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR ICE Swap Rate-11:00")]
        USD_LIBOR_ICE_Swap_Rate_11_00,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR ICE Swap Rate-15:00")]
        USD_LIBOR_ICE_Swap_Rate_15_00,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR-ISDA")]
        USD_LIBOR_ISDA,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR-LIBO")]
        USD_LIBOR_LIBO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-LIBOR-Reference Banks")]
        USD_LIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Municipal Swap Index")]
        USD_Municipal_Swap_Index,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Municipal Swap Libor Ratio-11:00-ICAP")]
        USD_Municipal_Swap_Libor_Ratio_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Municipal Swap Rate-11:00-ICAP")]
        USD_Municipal_Swap_Rate_11_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-11:00-BGCANTOR")]
        USD_OIS_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-11:00-LON-ICAP")]
        USD_OIS_11_00_LON_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-11:00-NY-ICAP")]
        USD_OIS_11_00_NY_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-11:00-TRADITION")]
        USD_OIS_11_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-3:00-BGCANTOR")]
        USD_OIS_3_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-3:00-NY-ICAP")]
        USD_OIS_3_00_NY_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-OIS-4:00-TRADITION")]
        USD_OIS_4_00_TRADITION,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Overnight Bank Funding Rate")]
        USD_Overnight_Bank_Funding_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Prime")]
        USD_Prime,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Prime-H.15")]
        USD_Prime_H_15,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Prime-Reference Banks")]
        USD_Prime_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SIBOR-Reference Banks")]
        USD_SIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SIBOR-SIBO")]
        USD_SIBOR_SIBO,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SIFMA Municipal Swap Index")]
        USD_SIFMA_Municipal_Swap_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR")]
        USD_SOFR,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR Average 180D")]
        USD_SOFR_Average_180D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR Average 30D")]
        USD_SOFR_Average_30D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR Average 90D")]
        USD_SOFR_Average_90D,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR CME Term")]
        USD_SOFR_CME_Term,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR-COMPOUND")]
        USD_SOFR_COMPOUND,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR Compounded Index")]
        USD_SOFR_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index")]
        USD_SOFR_ICE_Compounded_Index,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index 0 Floor")]
        USD_SOFR_ICE_Compounded_Index_0_Floor,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index 0 Floor 2D Lag")]
        USD_SOFR_ICE_Compounded_Index_0_Floor_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index 0 Floor 5D Lag")]
        USD_SOFR_ICE_Compounded_Index_0_Floor_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index 2D Lag")]
        USD_SOFR_ICE_Compounded_Index_2D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Compounded Index 5D Lag")]
        USD_SOFR_ICE_Compounded_Index_5D_Lag,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix and 2006 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Swap Rate")]
        USD_SOFR_ICE_Swap_Rate,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Swap Rate Spreads")]
        USD_SOFR_ICE_Swap_Rate_Spreads,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR ICE Term")]
        USD_SOFR_ICE_Term,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SOFR-OIS Compound")]
        USD_SOFR_OIS_Compound,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-S&P Index-High Grade")]
        USD_S_P_Index_High_Grade,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-SandP Index High Grade")]
        USD_SandP_Index_High_Grade,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD Swap Rate-BCMP1")]
        USD_Swap_Rate_BCMP1,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TBILL Auction High Rate")]
        USD_TBILL_Auction_High_Rate,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TBILL-H.15")]
        USD_TBILL_H_15,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TBILL-H.15-Bloomberg")]
        USD_TBILL_H_15_Bloomberg,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TBILL-Secondary Market")]
        USD_TBILL_Secondary_Market,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TBILL Secondary Market-Bond Equivalent Yield")]
        USD_TBILL_Secondary_Market_Bond_Equivalent_Yield,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TIBOR-ISDC")]
        USD_TIBOR_ISDC,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-TIBOR-Reference Banks")]
        USD_TIBOR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury-19901-3:00-ICAP")]
        USD_Treasury_19901_3_00_ICAP,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD Treasury Rate-BCMP1")]
        USD_Treasury_Rate_BCMP1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury Rate-ICAP BrokerTec")]
        USD_Treasury_Rate_ICAP_BrokerTec,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury Rate-SwapMarker100")]
        USD_Treasury_Rate_SwapMarker100,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury Rate-SwapMarker99")]
        USD_Treasury_Rate_SwapMarker99,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury Rate-T19901")]
        USD_Treasury_Rate_T19901,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "USD-Treasury Rate-T500")]
        USD_Treasury_Rate_T500,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "VND-Semi-Annual Swap Rate-11:00-BGCANTOR")]
        VND_Semi_Annual_Swap_Rate_11_00_BGCANTOR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "VND-Semi-Annual Swap Rate-Reference Banks")]
        VND_Semi_Annual_Swap_Rate_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-DEPOSIT-Reference Banks")]
        ZAR_DEPOSIT_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-DEPOSIT-SAFEX")]
        ZAR_DEPOSIT_SAFEX,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-JIBAR")]
        ZAR_JIBAR,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-JIBAR-Reference Banks")]
        ZAR_JIBAR_Reference_Banks,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-JIBAR-SAFEX")]
        ZAR_JIBAR_SAFEX,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-PRIME-AVERAGE")]
        ZAR_PRIME_AVERAGE,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-PRIME-AVERAGE-Reference Banks")]
        ZAR_PRIME_AVERAGE_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-Prime Average")]
        ZAR_Prime_Average_1,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-Quarterly Swap Rate-1:00-TRADITION")]
        ZAR_Quarterly_Swap_Rate_1_00_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-Quarterly Swap Rate-5:30-TRADITION")]
        ZAR_Quarterly_Swap_Rate_5_30_TRADITION,
        
        /// <summary>
        /// Per 2006 ISDA Definitions or Annex to the 2000 ISDA Definitions, Section 7.1 Rate Options, as amended and supplemented through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-Quarterly Swap Rate-TRADITION-Reference Banks")]
        ZAR_Quarterly_Swap_Rate_TRADITION_Reference_Banks,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-ZARONIA")]
        ZAR_ZARONIA,
        
        /// <summary>
        /// Per 2021 ISDA Interest Rate Derivatives Definitions Floating Rate Matrix, as amended through the date on which parties enter into the relevant transaction.
        /// </summary>
        [EnumMember(Value = "ZAR-ZARONIA-OIS Compound")]
        ZAR_ZARONIA_OIS_Compound
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this FloatingRateIndex value)
        {
            return value switch
            {
                FloatingRateIndex.AED_EBOR_Reuters => "AED-EBOR-Reuters",
                FloatingRateIndex.AED_EIBOR => "AED-EIBOR",
                FloatingRateIndex.AUD_AONIA => "AUD-AONIA",
                FloatingRateIndex.AUD_AONIA_OIS_COMPOUND => "AUD-AONIA-OIS-COMPOUND",
                FloatingRateIndex.AUD_AONIA_OIS_COMPOUND_SwapMarker => "AUD-AONIA-OIS-COMPOUND-SwapMarker",
                FloatingRateIndex.AUD_AONIA_OIS_Compound_1 => "AUD-AONIA-OIS Compound",
                FloatingRateIndex.AUD_BBR_AUBBSW => "AUD-BBR-AUBBSW",
                FloatingRateIndex.AUD_BBR_BBSW => "AUD-BBR-BBSW",
                FloatingRateIndex.AUD_BBR_BBSW_Bloomberg => "AUD-BBR-BBSW-Bloomberg",
                FloatingRateIndex.AUD_BBR_BBSY__BID_ => "AUD-BBR-BBSY (BID)",
                FloatingRateIndex.AUD_BBR_ISDC => "AUD-BBR-ISDC",
                FloatingRateIndex.AUD_BBSW => "AUD-BBSW",
                FloatingRateIndex.AUD_BBSW_Quarterly_Swap_Rate_ICAP => "AUD-BBSW Quarterly Swap Rate ICAP",
                FloatingRateIndex.AUD_BBSW_Semi_Annual_Swap_Rate_ICAP => "AUD-BBSW Semi Annual Swap Rate ICAP",
                FloatingRateIndex.AUD_BBSY_Bid => "AUD-BBSY Bid",
                FloatingRateIndex.AUD_LIBOR_BBA => "AUD-LIBOR-BBA",
                FloatingRateIndex.AUD_LIBOR_BBA_Bloomberg => "AUD-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.AUD_LIBOR_Reference_Banks => "AUD-LIBOR-Reference Banks",
                FloatingRateIndex.AUD_Quarterly_Swap_Rate_ICAP => "AUD-Quarterly Swap Rate-ICAP",
                FloatingRateIndex.AUD_Quarterly_Swap_Rate_ICAP_Reference_Banks => "AUD-Quarterly Swap Rate-ICAP-Reference Banks",
                FloatingRateIndex.AUD_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "AUD-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.AUD_Semi_Annual_Swap_Rate_BGCANTOR_Reference_Banks => "AUD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks",
                FloatingRateIndex.AUD_Semi_Annual_Swap_Rate_ICAP_Reference_Banks => "AUD-Semi-Annual Swap Rate-ICAP-Reference Banks",
                FloatingRateIndex.AUD_Semi_annual_Swap_Rate_ICAP => "AUD-Semi-annual Swap Rate-ICAP",
                FloatingRateIndex.AUD_Swap_Rate_Reuters => "AUD-Swap Rate-Reuters",
                FloatingRateIndex.BRL_CDI => "BRL-CDI",
                FloatingRateIndex.CAD_BA_CDOR => "CAD-BA-CDOR",
                FloatingRateIndex.CAD_BA_CDOR_Bloomberg => "CAD-BA-CDOR-Bloomberg",
                FloatingRateIndex.CAD_BA_ISDD => "CAD-BA-ISDD",
                FloatingRateIndex.CAD_BA_Reference_Banks => "CAD-BA-Reference Banks",
                FloatingRateIndex.CAD_BA_Reuters => "CAD-BA-Reuters",
                FloatingRateIndex.CAD_BA_Telerate => "CAD-BA-Telerate",
                FloatingRateIndex.CAD_CDOR => "CAD-CDOR",
                FloatingRateIndex.CAD_CORRA => "CAD-CORRA",
                FloatingRateIndex.CAD_CORRA_CanDeal_TMX_Term => "CAD-CORRA CanDeal TMX Term",
                FloatingRateIndex.CAD_CORRA_Compounded_Index => "CAD-CORRA Compounded Index",
                FloatingRateIndex.CAD_CORRA_OIS_COMPOUND => "CAD-CORRA-OIS-COMPOUND",
                FloatingRateIndex.CAD_CORRA_OIS_Compound_1 => "CAD-CORRA-OIS Compound",
                FloatingRateIndex.CAD_ISDA_Swap_Rate => "CAD-ISDA-Swap Rate",
                FloatingRateIndex.CAD_LIBOR_BBA => "CAD-LIBOR-BBA",
                FloatingRateIndex.CAD_LIBOR_BBA_Bloomberg => "CAD-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.CAD_LIBOR_BBA_SwapMarker => "CAD-LIBOR-BBA-SwapMarker",
                FloatingRateIndex.CAD_LIBOR_Reference_Banks => "CAD-LIBOR-Reference Banks",
                FloatingRateIndex.CAD_REPO_CORRA => "CAD-REPO-CORRA",
                FloatingRateIndex.CAD_TBILL_ISDD => "CAD-TBILL-ISDD",
                FloatingRateIndex.CAD_TBILL_Reference_Banks => "CAD-TBILL-Reference Banks",
                FloatingRateIndex.CAD_TBILL_Reuters => "CAD-TBILL-Reuters",
                FloatingRateIndex.CAD_TBILL_Telerate => "CAD-TBILL-Telerate",
                FloatingRateIndex.CHF_3M_LIBOR_SWAP_CME_vs_LCH_ICAP => "CHF-3M LIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.CHF_3M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "CHF-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.CHF_3M_LIBOR_SWAP_EUREX_vs_LCH_ICAP => "CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP",
                FloatingRateIndex.CHF_3M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg => "CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.CHF_6M_LIBORSWAP_CME_vs_LCH_ICAP_Bloomberg => "CHF-6M LIBORSWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.CHF_6M_LIBOR_SWAP_CME_vs_LCH_ICAP => "CHF-6M LIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.CHF_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP => "CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP",
                FloatingRateIndex.CHF_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg => "CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.CHF_Annual_Swap_Rate => "CHF-Annual Swap Rate",
                FloatingRateIndex.CHF_Annual_Swap_Rate_11_00_ICAP => "CHF-Annual Swap Rate-11:00-ICAP",
                FloatingRateIndex.CHF_Annual_Swap_Rate_Reference_Banks => "CHF-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.CHF_Basis_Swap_3m_vs_6m_LIBOR_11_00_ICAP => "CHF-Basis Swap-3m vs 6m-LIBOR-11:00-ICAP",
                FloatingRateIndex.CHF_ISDAFIX_Swap_Rate => "CHF-ISDAFIX-Swap Rate",
                FloatingRateIndex.CHF_LIBOR => "CHF-LIBOR",
                FloatingRateIndex.CHF_LIBOR_BBA => "CHF-LIBOR-BBA",
                FloatingRateIndex.CHF_LIBOR_BBA_Bloomberg => "CHF-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.CHF_LIBOR_ISDA => "CHF-LIBOR-ISDA",
                FloatingRateIndex.CHF_LIBOR_Reference_Banks => "CHF-LIBOR-Reference Banks",
                FloatingRateIndex.CHF_OIS_11_00_ICAP => "CHF-OIS-11:00-ICAP",
                FloatingRateIndex.CHF_SARON => "CHF-SARON",
                FloatingRateIndex.CHF_SARON_Average_12M => "CHF-SARON Average 12M",
                FloatingRateIndex.CHF_SARON_Average_1M => "CHF-SARON Average 1M",
                FloatingRateIndex.CHF_SARON_Average_1W => "CHF-SARON Average 1W",
                FloatingRateIndex.CHF_SARON_Average_2M => "CHF-SARON Average 2M",
                FloatingRateIndex.CHF_SARON_Average_3M => "CHF-SARON Average 3M",
                FloatingRateIndex.CHF_SARON_Average_6M => "CHF-SARON Average 6M",
                FloatingRateIndex.CHF_SARON_Average_9M => "CHF-SARON Average 9M",
                FloatingRateIndex.CHF_SARON_Compounded_Index => "CHF-SARON Compounded Index",
                FloatingRateIndex.CHF_SARON_OIS_COMPOUND => "CHF-SARON-OIS-COMPOUND",
                FloatingRateIndex.CHF_SARON_OIS_Compound_1 => "CHF-SARON-OIS Compound",
                FloatingRateIndex.CHF_TOIS_OIS_COMPOUND => "CHF-TOIS-OIS-COMPOUND",
                FloatingRateIndex.CHF_USD_Basis_Swaps_11_00_ICAP => "CHF USD-Basis Swaps-11:00-ICAP",
                FloatingRateIndex.CLP_ICP => "CLP-ICP",
                FloatingRateIndex.CLP_TNA => "CLP-TNA",
                FloatingRateIndex.CL_CLICP_Bloomberg => "CL-CLICP-Bloomberg",
                FloatingRateIndex.CNH_HIBOR => "CNH-HIBOR",
                FloatingRateIndex.CNH_HIBOR_Reference_Banks => "CNH-HIBOR-Reference Banks",
                FloatingRateIndex.CNH_HIBOR_TMA => "CNH-HIBOR-TMA",
                FloatingRateIndex.CNY_7_Repo_Compounding_Date => "CNY 7-Repo Compounding Date",
                FloatingRateIndex.CNY_CNREPOFIX_CFXS_Reuters => "CNY-CNREPOFIX=CFXS-Reuters",
                FloatingRateIndex.CNY_Deposit_Rate => "CNY-Deposit Rate",
                FloatingRateIndex.CNY_Fixing_Repo_Rate => "CNY-Fixing Repo Rate",
                FloatingRateIndex.CNY_LPR => "CNY-LPR",
                FloatingRateIndex.CNY_PBOCB_Reuters => "CNY-PBOCB-Reuters",
                FloatingRateIndex.CNY_Quarterly_7D_Repo_NDS_Rate_Tradition => "CNY-Quarterly 7D Repo NDS Rate Tradition",
                FloatingRateIndex.CNY_Quarterly_7_day_Repo_Non_Deliverable_Swap_Rate_TRADITION => "CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION",
                FloatingRateIndex.CNY_Quarterly_7_day_Repo_Non_Deliverable_Swap_Rate_TRADITION_Reference_Banks => "CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.CNY_SHIBOR => "CNY-SHIBOR",
                FloatingRateIndex.CNY_SHIBOR_OIS_Compound => "CNY-SHIBOR-OIS Compound",
                FloatingRateIndex.CNY_SHIBOR_Reuters => "CNY-SHIBOR-Reuters",
                FloatingRateIndex.CNY_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "CNY-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.CNY_Semi_Annual_Swap_Rate_Reference_Banks => "CNY-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.CNY_Shibor_OIS_Compounding => "CNY-Shibor-OIS-Compounding",
                FloatingRateIndex.COP_IBR_OIS_COMPOUND => "COP-IBR-OIS-COMPOUND",
                FloatingRateIndex.COP_IBR_OIS_Compound_1 => "COP-IBR-OIS Compound",
                FloatingRateIndex.CZK_Annual_Swap_Rate_11_00_BGCANTOR => "CZK-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.CZK_Annual_Swap_Rate_Reference_Banks => "CZK-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.CZK_CZEONIA => "CZK-CZEONIA",
                FloatingRateIndex.CZK_CZEONIA_OIS_Compound => "CZK-CZEONIA-OIS Compound",
                FloatingRateIndex.CZK_PRIBOR => "CZK-PRIBOR",
                FloatingRateIndex.CZK_PRIBOR_PRBO => "CZK-PRIBOR-PRBO",
                FloatingRateIndex.CZK_PRIBOR_Reference_Banks => "CZK-PRIBOR-Reference Banks",
                FloatingRateIndex.DKK_CIBOR => "DKK-CIBOR",
                FloatingRateIndex.DKK_CIBOR2 => "DKK-CIBOR2",
                FloatingRateIndex.DKK_CIBOR2_Bloomberg => "DKK-CIBOR2-Bloomberg",
                FloatingRateIndex.DKK_CIBOR2_DKNA13 => "DKK-CIBOR2-DKNA13",
                FloatingRateIndex.DKK_CIBOR_DKNA13 => "DKK-CIBOR-DKNA13",
                FloatingRateIndex.DKK_CIBOR_DKNA13_Bloomberg => "DKK-CIBOR-DKNA13-Bloomberg",
                FloatingRateIndex.DKK_CIBOR_Reference_Banks => "DKK-CIBOR-Reference Banks",
                FloatingRateIndex.DKK_CITA => "DKK-CITA",
                FloatingRateIndex.DKK_CITA_DKNA14_COMPOUND => "DKK-CITA-DKNA14-COMPOUND",
                FloatingRateIndex.DKK_DESTR => "DKK-DESTR",
                FloatingRateIndex.DKK_DESTR_Compounded_Index => "DKK-DESTR Compounded Index",
                FloatingRateIndex.DKK_DESTR_OIS_Compound => "DKK-DESTR-OIS Compound",
                FloatingRateIndex.DKK_DKKOIS_OIS_COMPOUND => "DKK-DKKOIS-OIS-COMPOUND",
                FloatingRateIndex.DKK_Tom_Next_OIS_Compound => "DKK-Tom Next-OIS Compound",
                FloatingRateIndex.EUR_3M_EURIBOR_SWAP_CME_vs_LCH_ICAP => "EUR-3M EURIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.EUR_3M_EURIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "EUR-3M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.EUR_3M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP => "EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP",
                FloatingRateIndex.EUR_3M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg => "EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.EUR_6M_EURIBOR_SWAP_CME_vs_LCH_ICAP => "EUR-6M EURIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.EUR_6M_EURIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "EUR-6M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.EUR_6M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP => "EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP",
                FloatingRateIndex.EUR_6M_EURIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg => "EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00 => "EUR-Annual Swap Rate-10:00",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00_BGCANTOR => "EUR-Annual Swap Rate-10:00-BGCANTOR",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00_Bloomberg => "EUR-Annual Swap Rate-10:00-Bloomberg",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00_ICAP => "EUR-Annual Swap Rate-10:00-ICAP",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00_SwapMarker => "EUR-Annual Swap Rate-10:00-SwapMarker",
                FloatingRateIndex.EUR_Annual_Swap_Rate_10_00_TRADITION => "EUR-Annual Swap Rate-10:00-TRADITION",
                FloatingRateIndex.EUR_Annual_Swap_Rate_11_00 => "EUR-Annual Swap Rate-11:00",
                FloatingRateIndex.EUR_Annual_Swap_Rate_11_00_Bloomberg => "EUR-Annual Swap Rate-11:00-Bloomberg",
                FloatingRateIndex.EUR_Annual_Swap_Rate_11_00_ICAP => "EUR-Annual Swap Rate-11:00-ICAP",
                FloatingRateIndex.EUR_Annual_Swap_Rate_11_00_SwapMarker => "EUR-Annual Swap Rate-11:00-SwapMarker",
                FloatingRateIndex.EUR_Annual_Swap_Rate_3_Month => "EUR-Annual Swap Rate-3 Month",
                FloatingRateIndex.EUR_Annual_Swap_Rate_3_Month_SwapMarker => "EUR-Annual Swap Rate-3 Month-SwapMarker",
                FloatingRateIndex.EUR_Annual_Swap_Rate_4_15_TRADITION => "EUR-Annual Swap Rate-4:15-TRADITION",
                FloatingRateIndex.EUR_Annual_Swap_Rate_Reference_Banks => "EUR-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.EUR_Basis_Swap_EONIA_vs_3m_EUR_IBOR_Swap_Rates_A_360_10_00_ICAP => "EUR Basis Swap-EONIA vs 3m EUR+IBOR Swap Rates-A/360-10:00-ICAP",
                FloatingRateIndex.EUR_CNO_TEC10 => "EUR-CNO TEC10",
                FloatingRateIndex.EUR_EONIA => "EUR-EONIA",
                FloatingRateIndex.EUR_EONIA_AVERAGE_1 => "EUR-EONIA-AVERAGE",
                FloatingRateIndex.EUR_EONIA_Average => "EUR-EONIA-Average",
                FloatingRateIndex.EUR_EONIA_OIS_10_00_BGCANTOR => "EUR-EONIA-OIS-10:00-BGCANTOR",
                FloatingRateIndex.EUR_EONIA_OIS_10_00_ICAP => "EUR-EONIA-OIS-10:00-ICAP",
                FloatingRateIndex.EUR_EONIA_OIS_10_00_TRADITION => "EUR-EONIA-OIS-10:00-TRADITION",
                FloatingRateIndex.EUR_EONIA_OIS_11_00_ICAP => "EUR-EONIA-OIS-11:00-ICAP",
                FloatingRateIndex.EUR_EONIA_OIS_4_15_TRADITION => "EUR-EONIA-OIS-4:15-TRADITION",
                FloatingRateIndex.EUR_EONIA_OIS_COMPOUND => "EUR-EONIA-OIS-COMPOUND",
                FloatingRateIndex.EUR_EONIA_OIS_COMPOUND_Bloomberg => "EUR-EONIA-OIS-COMPOUND-Bloomberg",
                FloatingRateIndex.EUR_EONIA_OIS_Compound_1 => "EUR-EONIA-OIS Compound",
                FloatingRateIndex.EUR_EONIA_Swap_Index => "EUR-EONIA-Swap-Index",
                FloatingRateIndex.EUR_EURIBOR => "EUR-EURIBOR",
                FloatingRateIndex.EUR_EURIBOR_Act_365 => "EUR-EURIBOR-Act/365",
                FloatingRateIndex.EUR_EURIBOR_Act_365_Bloomberg => "EUR-EURIBOR-Act/365-Bloomberg",
                FloatingRateIndex.EUR_EURIBOR_Annual_Bond_Swap_vs_1m_11_00_ICAP => "EUR EURIBOR-Annual Bond Swap vs 1m-11:00-ICAP",
                FloatingRateIndex.EUR_EURIBOR_Basis_Swap_1m_vs_3m_Euribor_11_00_ICAP => "EUR EURIBOR-Basis Swap-1m vs 3m-Euribor-11:00-ICAP",
                FloatingRateIndex.EUR_EURIBOR_Basis_Swap_3m_vs_6m_11_00_ICAP => "EUR EURIBOR-Basis Swap-3m vs 6m-11:00-ICAP",
                FloatingRateIndex.EUR_EURIBOR_ICE_Swap_Rate_11_00 => "EUR-EURIBOR ICE Swap Rate-11:00",
                FloatingRateIndex.EUR_EURIBOR_ICE_Swap_Rate_12_00 => "EUR-EURIBOR ICE Swap Rate-12:00",
                FloatingRateIndex.EUR_EURIBOR_Reference_Banks => "EUR-EURIBOR-Reference Banks",
                FloatingRateIndex.EUR_EURIBOR_Reuters => "EUR-EURIBOR-Reuters",
                FloatingRateIndex.EUR_EURIBOR_Telerate => "EUR-EURIBOR-Telerate",
                FloatingRateIndex.EUR_EURONIA_OIS_COMPOUND => "EUR-EURONIA-OIS-COMPOUND",
                FloatingRateIndex.EUR_EURONIA_OIS_Compound_1 => "EUR-EURONIA-OIS Compound",
                FloatingRateIndex.EUR_EuroSTR => "EUR-EuroSTR",
                FloatingRateIndex.EUR_EuroSTR_Average_12M => "EUR-EuroSTR Average 12M",
                FloatingRateIndex.EUR_EuroSTR_Average_1M => "EUR-EuroSTR Average 1M",
                FloatingRateIndex.EUR_EuroSTR_Average_1W => "EUR-EuroSTR Average 1W",
                FloatingRateIndex.EUR_EuroSTR_Average_3M => "EUR-EuroSTR Average 3M",
                FloatingRateIndex.EUR_EuroSTR_Average_6M => "EUR-EuroSTR Average 6M",
                FloatingRateIndex.EUR_EuroSTR_COMPOUND => "EUR-EuroSTR-COMPOUND",
                FloatingRateIndex.EUR_EuroSTR_Compounded_Index => "EUR-EuroSTR Compounded Index",
                FloatingRateIndex.EUR_EuroSTR_FTSE_Term => "EUR-EuroSTR FTSE Term",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index => "EUR-EuroSTR ICE Compounded Index",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index_0_Floor => "EUR-EuroSTR ICE Compounded Index 0 Floor",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index_0_Floor_2D_Lag => "EUR-EuroSTR ICE Compounded Index 0 Floor 2D Lag",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index_0_Floor_5D_Lag => "EUR-EuroSTR ICE Compounded Index 0 Floor 5D Lag",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index_2D_Lag => "EUR-EuroSTR ICE Compounded Index 2D Lag",
                FloatingRateIndex.EUR_EuroSTR_ICE_Compounded_Index_5D_Lag => "EUR-EuroSTR ICE Compounded Index 5D Lag",
                FloatingRateIndex.EUR_EuroSTR_ICE_Swap_Rate => "EUR-EuroSTR ICE Swap Rate",
                FloatingRateIndex.EUR_EuroSTR_OIS_Compound => "EUR-EuroSTR-OIS Compound",
                FloatingRateIndex.EUR_EuroSTR_Term => "EUR-EuroSTR Term",
                FloatingRateIndex.EUR_ISDA_EURIBOR_Swap_Rate_11_00 => "EUR-ISDA-EURIBOR Swap Rate-11:00",
                FloatingRateIndex.EUR_ISDA_EURIBOR_Swap_Rate_12_00 => "EUR-ISDA-EURIBOR Swap Rate-12:00",
                FloatingRateIndex.EUR_ISDA_LIBOR_Swap_Rate_10_00 => "EUR-ISDA-LIBOR Swap Rate-10:00",
                FloatingRateIndex.EUR_ISDA_LIBOR_Swap_Rate_11_00 => "EUR-ISDA-LIBOR Swap Rate-11:00",
                FloatingRateIndex.EUR_LIBOR => "EUR-LIBOR",
                FloatingRateIndex.EUR_LIBOR_BBA => "EUR-LIBOR-BBA",
                FloatingRateIndex.EUR_LIBOR_BBA_Bloomberg => "EUR-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.EUR_LIBOR_Reference_Banks => "EUR-LIBOR-Reference Banks",
                FloatingRateIndex.EUR_TAM_CDC => "EUR-TAM-CDC",
                FloatingRateIndex.EUR_TEC10_CNO => "EUR-TEC10-CNO",
                FloatingRateIndex.EUR_TEC10_CNO_SwapMarker => "EUR-TEC10-CNO-SwapMarker",
                FloatingRateIndex.EUR_TEC10_Reference_Banks => "EUR-TEC10-Reference Banks",
                FloatingRateIndex.EUR_TEC5_CNO => "EUR-TEC5-CNO",
                FloatingRateIndex.EUR_TEC5_CNO_SwapMarker => "EUR-TEC5-CNO-SwapMarker",
                FloatingRateIndex.EUR_TEC5_Reference_Banks => "EUR-TEC5-Reference Banks",
                FloatingRateIndex.EUR_TMM_CDC_COMPOUND => "EUR-TMM-CDC-COMPOUND",
                FloatingRateIndex.EUR_USD_Basis_Swaps_11_00_ICAP => "EUR USD-Basis Swaps-11:00-ICAP",
                FloatingRateIndex.GBP_6M_LIBOR_SWAP_CME_vs_LCH_ICAP => "GBP-6M LIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.GBP_6M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "GBP-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.GBP_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP => "GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP",
                FloatingRateIndex.GBP_6M_LIBOR_SWAP_EUREX_vs_LCH_ICAP_Bloomberg => "GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.GBP_ISDA_Swap_Rate => "GBP-ISDA-Swap Rate",
                FloatingRateIndex.GBP_LIBOR => "GBP-LIBOR",
                FloatingRateIndex.GBP_LIBOR_BBA => "GBP-LIBOR-BBA",
                FloatingRateIndex.GBP_LIBOR_BBA_Bloomberg => "GBP-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.GBP_LIBOR_ICE_Swap_Rate => "GBP-LIBOR ICE Swap Rate",
                FloatingRateIndex.GBP_LIBOR_ISDA => "GBP-LIBOR-ISDA",
                FloatingRateIndex.GBP_LIBOR_Reference_Banks => "GBP-LIBOR-Reference Banks",
                FloatingRateIndex.GBP_RONIA => "GBP-RONIA",
                FloatingRateIndex.GBP_RONIA_OIS_Compound => "GBP-RONIA-OIS Compound",
                FloatingRateIndex.GBP_SONIA => "GBP-SONIA",
                FloatingRateIndex.GBP_SONIA_COMPOUND => "GBP-SONIA-COMPOUND",
                FloatingRateIndex.GBP_SONIA_Compounded_Index => "GBP-SONIA Compounded Index",
                FloatingRateIndex.GBP_SONIA_FTSE_Term => "GBP-SONIA FTSE Term",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index => "GBP-SONIA ICE Compounded Index",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index_0_Floor => "GBP-SONIA ICE Compounded Index 0 Floor",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index_0_Floor_2D_Lag => "GBP-SONIA ICE Compounded Index 0 Floor 2D Lag",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index_0_Floor_5D_Lag => "GBP-SONIA ICE Compounded Index 0 Floor 5D Lag",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index_2D_Lag => "GBP-SONIA ICE Compounded Index 2D Lag",
                FloatingRateIndex.GBP_SONIA_ICE_Compounded_Index_5D_Lag => "GBP-SONIA ICE Compounded Index 5D Lag",
                FloatingRateIndex.GBP_SONIA_ICE_Swap_Rate => "GBP-SONIA ICE Swap Rate",
                FloatingRateIndex.GBP_SONIA_ICE_Term => "GBP-SONIA ICE Term",
                FloatingRateIndex.GBP_SONIA_OIS_11_00_ICAP => "GBP-SONIA-OIS-11:00-ICAP",
                FloatingRateIndex.GBP_SONIA_OIS_11_00_TRADITION => "GBP-SONIA-OIS-11:00-TRADITION",
                FloatingRateIndex.GBP_SONIA_OIS_4_15_TRADITION => "GBP-SONIA-OIS-4:15-TRADITION",
                FloatingRateIndex.GBP_SONIA_OIS_Compound => "GBP-SONIA-OIS Compound",
                FloatingRateIndex.GBP_SONIA_Swap_Rate => "GBP-SONIA Swap Rate",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate => "GBP-Semi-Annual Swap Rate",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate_11_00_ICAP => "GBP-Semi-Annual Swap Rate-11:00-ICAP",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate_11_00_TRADITION => "GBP-Semi Annual Swap Rate-11:00-TRADITION",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate_4_15_TRADITION => "GBP-Semi Annual Swap Rate-4:15-TRADITION",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate_Reference_Banks => "GBP-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.GBP_Semi_Annual_Swap_Rate_SwapMarker26 => "GBP-Semi-Annual Swap Rate-SwapMarker26",
                FloatingRateIndex.GBP_UK_Base_Rate => "GBP-UK Base Rate",
                FloatingRateIndex.GBP_USD_Basis_Swaps_11_00_ICAP => "GBP USD-Basis Swaps-11:00-ICAP",
                FloatingRateIndex.GBP_WMBA_RONIA_COMPOUND => "GBP-WMBA-RONIA-COMPOUND",
                FloatingRateIndex.GBP_WMBA_SONIA_COMPOUND => "GBP-WMBA-SONIA-COMPOUND",
                FloatingRateIndex.GRD_ATHIBOR_ATHIBOR => "GRD-ATHIBOR-ATHIBOR",
                FloatingRateIndex.GRD_ATHIBOR_Reference_Banks => "GRD-ATHIBOR-Reference Banks",
                FloatingRateIndex.GRD_ATHIBOR_Telerate => "GRD-ATHIBOR-Telerate",
                FloatingRateIndex.GRD_ATHIMID_Reference_Banks => "GRD-ATHIMID-Reference Banks",
                FloatingRateIndex.GRD_ATHIMID_Reuters => "GRD-ATHIMID-Reuters",
                FloatingRateIndex.HKD_HIBOR => "HKD-HIBOR",
                FloatingRateIndex.HKD_HIBOR_HIBOR_ => "HKD-HIBOR-HIBOR=",
                FloatingRateIndex.HKD_HIBOR_HIBOR_Bloomberg => "HKD-HIBOR-HIBOR-Bloomberg",
                FloatingRateIndex.HKD_HIBOR_HKAB => "HKD-HIBOR-HKAB",
                FloatingRateIndex.HKD_HIBOR_HKAB_Bloomberg => "HKD-HIBOR-HKAB-Bloomberg",
                FloatingRateIndex.HKD_HIBOR_ISDC => "HKD-HIBOR-ISDC",
                FloatingRateIndex.HKD_HIBOR_Reference_Banks => "HKD-HIBOR-Reference Banks",
                FloatingRateIndex.HKD_HONIA => "HKD-HONIA",
                FloatingRateIndex.HKD_HONIA_OIS_Compound => "HKD-HONIA-OIS Compound",
                FloatingRateIndex.HKD_HONIX_OIS_COMPOUND => "HKD-HONIX-OIS-COMPOUND",
                FloatingRateIndex.HKD_ISDA_Swap_Rate_11_00 => "HKD-ISDA-Swap Rate-11:00",
                FloatingRateIndex.HKD_ISDA_Swap_Rate_4_00 => "HKD-ISDA-Swap Rate-4:00",
                FloatingRateIndex.HKD_Quarterly_Annual_Swap_Rate_11_00_BGCANTOR => "HKD-Quarterly-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.HKD_Quarterly_Annual_Swap_Rate_11_00_TRADITION => "HKD-Quarterly-Annual Swap Rate-11:00-TRADITION",
                FloatingRateIndex.HKD_Quarterly_Annual_Swap_Rate_4_00_BGCANTOR => "HKD-Quarterly-Annual Swap Rate-4:00-BGCANTOR",
                FloatingRateIndex.HKD_Quarterly_Annual_Swap_Rate_Reference_Banks => "HKD-Quarterly-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.HKD_Quarterly_Quarterly_Swap_Rate_11_00_ICAP => "HKD-Quarterly-Quarterly Swap Rate-11:00-ICAP",
                FloatingRateIndex.HKD_Quarterly_Quarterly_Swap_Rate_4_00_ICAP => "HKD-Quarterly-Quarterly Swap Rate-4:00-ICAP",
                FloatingRateIndex.HKD_Quarterly_Quarterly_Swap_Rate_Reference_Banks => "HKD-Quarterly-Quarterly Swap Rate-Reference Banks",
                FloatingRateIndex.HUF_BUBOR => "HUF-BUBOR",
                FloatingRateIndex.HUF_BUBOR_Reference_Banks => "HUF-BUBOR-Reference Banks",
                FloatingRateIndex.HUF_BUBOR_Reuters => "HUF-BUBOR-Reuters",
                FloatingRateIndex.HUF_HUFONIA => "HUF-HUFONIA",
                FloatingRateIndex.HUF_HUFONIA_OIS_Compound => "HUF-HUFONIA-OIS Compound",
                FloatingRateIndex.IDR_IDMA_Bloomberg => "IDR-IDMA-Bloomberg",
                FloatingRateIndex.IDR_IDRFIX => "IDR-IDRFIX",
                FloatingRateIndex.IDR_INDONIA => "IDR-INDONIA",
                FloatingRateIndex.IDR_INDONIA_OIS_Compound => "IDR-INDONIA-OIS Compound",
                FloatingRateIndex.IDR_JIBOR => "IDR-JIBOR",
                FloatingRateIndex.IDR_JIBOR_Reuters => "IDR-JIBOR-Reuters",
                FloatingRateIndex.IDR_SBI_Reuters => "IDR-SBI-Reuters",
                FloatingRateIndex.IDR_SOR_Reference_Banks => "IDR-SOR-Reference Banks",
                FloatingRateIndex.IDR_SOR_Reuters => "IDR-SOR-Reuters",
                FloatingRateIndex.IDR_SOR_Telerate => "IDR-SOR-Telerate",
                FloatingRateIndex.IDR_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "IDR-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.IDR_Semi_Annual_Swap_Rate_Non_deliverable_16_00_Tullett_Prebon => "IDR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon",
                FloatingRateIndex.IDR_Semi_Annual_Swap_Rate_Reference_Banks => "IDR-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.ILS_SHIR => "ILS-SHIR",
                FloatingRateIndex.ILS_SHIR_OIS_Compound => "ILS-SHIR-OIS Compound",
                FloatingRateIndex.ILS_TELBOR => "ILS-TELBOR",
                FloatingRateIndex.ILS_TELBOR01_Reuters => "ILS-TELBOR01-Reuters",
                FloatingRateIndex.ILS_TELBOR_Reference_Banks => "ILS-TELBOR-Reference Banks",
                FloatingRateIndex.INR_BMK => "INR-BMK",
                FloatingRateIndex.INR_CMT => "INR-CMT",
                FloatingRateIndex.INR_FBIL_MIBOR_OIS_COMPOUND => "INR-FBIL-MIBOR-OIS-COMPOUND",
                FloatingRateIndex.INR_INBMK_REUTERS => "INR-INBMK-REUTERS",
                FloatingRateIndex.INR_MIBOR_OIS => "INR-MIBOR OIS",
                FloatingRateIndex.INR_MIBOR_OIS_COMPOUND => "INR-MIBOR-OIS-COMPOUND",
                FloatingRateIndex.INR_MIBOR_OIS_Compound_1 => "INR-MIBOR-OIS Compound",
                FloatingRateIndex.INR_MIFOR => "INR-MIFOR",
                FloatingRateIndex.INR_MIOIS => "INR-MIOIS",
                FloatingRateIndex.INR_MITOR_OIS_COMPOUND => "INR-MITOR-OIS-COMPOUND",
                FloatingRateIndex.INR_Modified_MIFOR => "INR-Modified MIFOR",
                FloatingRateIndex.INR_Reference_Banks => "INR-Reference Banks",
                FloatingRateIndex.INR_Semi_Annual_Swap_Rate_11_30_BGCANTOR => "INR-Semi-Annual Swap Rate-11:30-BGCANTOR",
                FloatingRateIndex.INR_Semi_Annual_Swap_Rate_Non_deliverable_16_00_Tullett_Prebon => "INR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon",
                FloatingRateIndex.INR_Semi_Annual_Swap_Rate_Reference_Banks => "INR-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.ISK_REIBOR => "ISK-REIBOR",
                FloatingRateIndex.ISK_REIBOR_Reference_Banks => "ISK-REIBOR-Reference Banks",
                FloatingRateIndex.ISK_REIBOR_Reuters => "ISK-REIBOR-Reuters",
                FloatingRateIndex.JPY_Annual_Swap_Rate_11_00_TRADITION => "JPY-Annual Swap Rate-11:00-TRADITION",
                FloatingRateIndex.JPY_Annual_Swap_Rate_3_00_TRADITION => "JPY-Annual Swap Rate-3:00-TRADITION",
                FloatingRateIndex.JPY_BBSF_Bloomberg_10_00 => "JPY-BBSF-Bloomberg-10:00",
                FloatingRateIndex.JPY_BBSF_Bloomberg_15_00 => "JPY-BBSF-Bloomberg-15:00",
                FloatingRateIndex.JPY_Euroyen_TIBOR => "JPY-Euroyen TIBOR",
                FloatingRateIndex.JPY_ISDA_Swap_Rate_10_00 => "JPY-ISDA-Swap Rate-10:00",
                FloatingRateIndex.JPY_ISDA_Swap_Rate_15_00 => "JPY-ISDA-Swap Rate-15:00",
                FloatingRateIndex.JPY_LIBOR => "JPY-LIBOR",
                FloatingRateIndex.JPY_LIBOR_BBA => "JPY-LIBOR-BBA",
                FloatingRateIndex.JPY_LIBOR_BBA_Bloomberg => "JPY-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.JPY_LIBOR_FRASETT => "JPY-LIBOR-FRASETT",
                FloatingRateIndex.JPY_LIBOR_ISDA => "JPY-LIBOR-ISDA",
                FloatingRateIndex.JPY_LIBOR_Reference_Banks => "JPY-LIBOR-Reference Banks",
                FloatingRateIndex.JPY_LIBOR_TSR_10_00 => "JPY-LIBOR TSR-10:00",
                FloatingRateIndex.JPY_LIBOR_TSR_15_00 => "JPY-LIBOR TSR-15:00",
                FloatingRateIndex.JPY_LTPR_MHBK => "JPY-LTPR MHBK",
                FloatingRateIndex.JPY_LTPR_MHCB => "JPY-LTPR-MHCB",
                FloatingRateIndex.JPY_LTPR_TBC => "JPY-LTPR-TBC",
                FloatingRateIndex.JPY_MUTANCALL_TONAR => "JPY-MUTANCALL-TONAR",
                FloatingRateIndex.JPY_OIS_11_00_ICAP => "JPY-OIS-11:00-ICAP",
                FloatingRateIndex.JPY_OIS_11_00_TRADITION => "JPY-OIS-11:00-TRADITION",
                FloatingRateIndex.JPY_OIS_3_00_TRADITION => "JPY-OIS-3:00-TRADITION",
                FloatingRateIndex.JPY_Quoting_Banks_LIBOR => "JPY-Quoting Banks-LIBOR",
                FloatingRateIndex.JPY_STPR_Quoting_Banks => "JPY-STPR-Quoting Banks",
                FloatingRateIndex.JPY_TIBOR => "JPY-TIBOR",
                FloatingRateIndex.JPY_TIBOR_17096 => "JPY-TIBOR-17096",
                FloatingRateIndex.JPY_TIBOR_17097 => "JPY-TIBOR-17097",
                FloatingRateIndex.JPY_TIBOR_DTIBOR01 => "JPY-TIBOR-DTIBOR01",
                FloatingRateIndex.JPY_TIBOR_TIBM => "JPY-TIBOR-TIBM",
                FloatingRateIndex.JPY_TIBOR_TIBM_Reference_Banks => "JPY-TIBOR-TIBM-Reference Banks",
                FloatingRateIndex.JPY_TIBOR_TIBM__10_Banks_ => "JPY-TIBOR-TIBM (10 Banks)",
                FloatingRateIndex.JPY_TIBOR_TIBM__5_Banks_ => "JPY-TIBOR-TIBM (5 Banks)",
                FloatingRateIndex.JPY_TIBOR_TIBM__All_Banks_ => "JPY-TIBOR-TIBM (All Banks)",
                FloatingRateIndex.JPY_TIBOR_TIBM__All_Banks__Bloomberg => "JPY-TIBOR-TIBM (All Banks)-Bloomberg",
                FloatingRateIndex.JPY_TIBOR_ZTIBOR => "JPY-TIBOR-ZTIBOR",
                FloatingRateIndex.JPY_TONA => "JPY-TONA",
                FloatingRateIndex.JPY_TONA_Average_180D => "JPY-TONA Average 180D",
                FloatingRateIndex.JPY_TONA_Average_30D => "JPY-TONA Average 30D",
                FloatingRateIndex.JPY_TONA_Average_90D => "JPY-TONA Average 90D",
                FloatingRateIndex.JPY_TONA_Compounded_Index => "JPY-TONA Compounded Index",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index => "JPY-TONA ICE Compounded Index",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index_0_Floor => "JPY-TONA ICE Compounded Index 0 Floor",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index_0_Floor_2D_Lag => "JPY-TONA ICE Compounded Index 0 Floor 2D Lag",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index_0_Floor_5D_Lag => "JPY-TONA ICE Compounded Index 0 Floor 5D Lag",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index_2D_Lag => "JPY-TONA ICE Compounded Index 2D Lag",
                FloatingRateIndex.JPY_TONA_ICE_Compounded_Index_5D_Lag => "JPY-TONA ICE Compounded Index 5D Lag",
                FloatingRateIndex.JPY_TONA_OIS_COMPOUND => "JPY-TONA-OIS-COMPOUND",
                FloatingRateIndex.JPY_TONA_OIS_Compound_1 => "JPY-TONA-OIS Compound",
                FloatingRateIndex.JPY_TONA_TSR_10_00 => "JPY-TONA TSR-10:00",
                FloatingRateIndex.JPY_TONA_TSR_15_00 => "JPY-TONA TSR-15:00",
                FloatingRateIndex.JPY_TORF_QUICK => "JPY-TORF QUICK",
                FloatingRateIndex.JPY_TSR_Reference_Banks => "JPY-TSR-Reference Banks",
                FloatingRateIndex.JPY_TSR_Reuters_10_00 => "JPY-TSR-Reuters-10:00",
                FloatingRateIndex.JPY_TSR_Reuters_15_00 => "JPY-TSR-Reuters-15:00",
                FloatingRateIndex.JPY_TSR_Telerate_10_00 => "JPY-TSR-Telerate-10:00",
                FloatingRateIndex.JPY_TSR_Telerate_15_00 => "JPY-TSR-Telerate-15:00",
                FloatingRateIndex.JPY_USD_Basis_Swaps_11_00_ICAP => "JPY USD-Basis Swaps-11:00-ICAP",
                FloatingRateIndex.KRW_Bond_3222 => "KRW-Bond-3222",
                FloatingRateIndex.KRW_CD_3220 => "KRW-CD-3220",
                FloatingRateIndex.KRW_CD_91D => "KRW-CD 91D",
                FloatingRateIndex.KRW_CD_KSDA_Bloomberg => "KRW-CD-KSDA-Bloomberg",
                FloatingRateIndex.KRW_KOFR => "KRW-KOFR",
                FloatingRateIndex.KRW_KOFR_OIS_Compound => "KRW-KOFR-OIS Compound",
                FloatingRateIndex.KRW_Quarterly_Annual_Swap_Rate_3_30_ICAP => "KRW-Quarterly Annual Swap Rate-3:30-ICAP",
                FloatingRateIndex.MXN_TIIE => "MXN-TIIE",
                FloatingRateIndex.MXN_TIIE_Banxico => "MXN-TIIE-Banxico",
                FloatingRateIndex.MXN_TIIE_Banxico_Bloomberg => "MXN-TIIE-Banxico-Bloomberg",
                FloatingRateIndex.MXN_TIIE_Banxico_Reference_Banks => "MXN-TIIE-Banxico-Reference Banks",
                FloatingRateIndex.MXN_TIIE_ON => "MXN-TIIE ON",
                FloatingRateIndex.MXN_TIIE_ON_OIS_Compound => "MXN-TIIE ON-OIS Compound",
                FloatingRateIndex.MXN_TIIE_Reference_Banks => "MXN-TIIE-Reference Banks",
                FloatingRateIndex.MYR_KLIBOR => "MYR-KLIBOR",
                FloatingRateIndex.MYR_KLIBOR_BNM => "MYR-KLIBOR-BNM",
                FloatingRateIndex.MYR_KLIBOR_Reference_Banks => "MYR-KLIBOR-Reference Banks",
                FloatingRateIndex.MYR_MYOR => "MYR-MYOR",
                FloatingRateIndex.MYR_MYOR_OIS_Compound => "MYR-MYOR-OIS Compound",
                FloatingRateIndex.MYR_Quarterly_Swap_Rate_11_00_TRADITION => "MYR-Quarterly Swap Rate-11:00-TRADITION",
                FloatingRateIndex.MYR_Quarterly_Swap_Rate_TRADITION_Reference_Banks => "MYR-Quarterly Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.NOK_NIBOR => "NOK-NIBOR",
                FloatingRateIndex.NOK_NIBOR_NIBR => "NOK-NIBOR-NIBR",
                FloatingRateIndex.NOK_NIBOR_NIBR_Bloomberg => "NOK-NIBOR-NIBR-Bloomberg",
                FloatingRateIndex.NOK_NIBOR_NIBR_Reference_Banks => "NOK-NIBOR-NIBR-Reference Banks",
                FloatingRateIndex.NOK_NIBOR_OIBOR => "NOK-NIBOR-OIBOR",
                FloatingRateIndex.NOK_NIBOR_Reference_Banks => "NOK-NIBOR-Reference Banks",
                FloatingRateIndex.NOK_NOWA => "NOK-NOWA",
                FloatingRateIndex.NOK_NOWA_OIS_Compound => "NOK-NOWA-OIS Compound",
                FloatingRateIndex.NZD_BBR_BID => "NZD-BBR-BID",
                FloatingRateIndex.NZD_BBR_FRA => "NZD-BBR-FRA",
                FloatingRateIndex.NZD_BBR_ISDC => "NZD-BBR-ISDC",
                FloatingRateIndex.NZD_BBR_Reference_Banks => "NZD-BBR-Reference Banks",
                FloatingRateIndex.NZD_BBR_Telerate => "NZD-BBR-Telerate",
                FloatingRateIndex.NZD_BKBM_Bid => "NZD-BKBM Bid",
                FloatingRateIndex.NZD_BKBM_FRA => "NZD-BKBM FRA",
                FloatingRateIndex.NZD_BKBM_FRA_Swap_Rate_ICAP => "NZD-BKBM FRA Swap Rate ICAP",
                FloatingRateIndex.NZD_NZIONA => "NZD-NZIONA",
                FloatingRateIndex.NZD_NZIONA_OIS_COMPOUND => "NZD-NZIONA-OIS-COMPOUND",
                FloatingRateIndex.NZD_NZIONA_OIS_Compound_1 => "NZD-NZIONA-OIS Compound",
                FloatingRateIndex.NZD_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "NZD-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.NZD_Semi_Annual_Swap_Rate_BGCANTOR_Reference_Banks => "NZD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks",
                FloatingRateIndex.NZD_Swap_Rate_ICAP => "NZD-Swap Rate-ICAP",
                FloatingRateIndex.NZD_Swap_Rate_ICAP_Reference_Banks => "NZD-Swap Rate-ICAP-Reference Banks",
                FloatingRateIndex.PHP_ORR => "PHP-ORR",
                FloatingRateIndex.PHP_PHIREF => "PHP-PHIREF",
                FloatingRateIndex.PHP_PHIREF_BAP => "PHP-PHIREF-BAP",
                FloatingRateIndex.PHP_PHIREF_Bloomberg => "PHP-PHIREF-Bloomberg",
                FloatingRateIndex.PHP_PHIREF_Reference_Banks => "PHP-PHIREF-Reference Banks",
                FloatingRateIndex.PHP_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "PHP-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.PHP_Semi_Annual_Swap_Rate_Reference_Banks => "PHP-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.PLN_POLONIA => "PLN-POLONIA",
                FloatingRateIndex.PLN_POLONIA_OIS_COMPOUND => "PLN-POLONIA-OIS-COMPOUND",
                FloatingRateIndex.PLN_POLONIA_OIS_Compound_1 => "PLN-POLONIA-OIS Compound",
                FloatingRateIndex.PLN_WIBID => "PLN-WIBID",
                FloatingRateIndex.PLN_WIBOR => "PLN-WIBOR",
                FloatingRateIndex.PLN_WIBOR_Reference_Banks => "PLN-WIBOR-Reference Banks",
                FloatingRateIndex.PLN_WIBOR_WIBO => "PLN-WIBOR-WIBO",
                FloatingRateIndex.PLN_WIRON => "PLN-WIRON",
                FloatingRateIndex.PLN_WIRON_OIS_Compound => "PLN-WIRON-OIS Compound",
                FloatingRateIndex.PLZ_WIBOR_Reference_Banks => "PLZ-WIBOR-Reference Banks",
                FloatingRateIndex.PLZ_WIBOR_WIBO => "PLZ-WIBOR-WIBO",
                FloatingRateIndex.REPOFUNDS_RATE_FRANCE_OIS_COMPOUND => "REPOFUNDS RATE-FRANCE-OIS-COMPOUND",
                FloatingRateIndex.REPOFUNDS_RATE_GERMANY_OIS_COMPOUND => "REPOFUNDS RATE-GERMANY-OIS-COMPOUND",
                FloatingRateIndex.REPOFUNDS_RATE_ITALY_OIS_COMPOUND => "REPOFUNDS RATE-ITALY-OIS-COMPOUND",
                FloatingRateIndex.RON_Annual_Swap_Rate_11_00_BGCANTOR => "RON-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.RON_Annual_Swap_Rate_Reference_Banks => "RON-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.RON_RBOR_Reuters => "RON-RBOR-Reuters",
                FloatingRateIndex.RON_ROBID => "RON-ROBID",
                FloatingRateIndex.RON_ROBOR => "RON-ROBOR",
                FloatingRateIndex.RUB_Annual_Swap_Rate_11_00_BGCANTOR => "RUB-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.RUB_Annual_Swap_Rate_12_45_TRADITION => "RUB-Annual Swap Rate-12:45-TRADITION",
                FloatingRateIndex.RUB_Annual_Swap_Rate_4_15_TRADITION => "RUB-Annual Swap Rate-4:15-TRADITION",
                FloatingRateIndex.RUB_Annual_Swap_Rate_Reference_Banks => "RUB-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.RUB_Annual_Swap_Rate_TRADITION_Reference_Banks => "RUB-Annual Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.RUB_Key_Rate_CBRF => "RUB-Key Rate CBRF",
                FloatingRateIndex.RUB_MOSPRIME_NFEA => "RUB-MOSPRIME-NFEA",
                FloatingRateIndex.RUB_MOSPRIME_Reference_Banks => "RUB-MOSPRIME-Reference Banks",
                FloatingRateIndex.RUB_MosPrime => "RUB-MosPrime",
                FloatingRateIndex.RUB_RUONIA => "RUB-RUONIA",
                FloatingRateIndex.RUB_RUONIA_OIS_COMPOUND => "RUB-RUONIA-OIS-COMPOUND",
                FloatingRateIndex.RUB_RUONIA_OIS_Compound_1 => "RUB-RUONIA-OIS Compound",
                FloatingRateIndex.SAR_SAIBOR => "SAR-SAIBOR",
                FloatingRateIndex.SAR_SRIOR_Reference_Banks => "SAR-SRIOR-Reference Banks",
                FloatingRateIndex.SAR_SRIOR_SUAA => "SAR-SRIOR-SUAA",
                FloatingRateIndex.SEK_Annual_Swap_Rate => "SEK-Annual Swap Rate",
                FloatingRateIndex.SEK_Annual_Swap_Rate_SESWFI => "SEK-Annual Swap Rate-SESWFI",
                FloatingRateIndex.SEK_SIOR_OIS_COMPOUND => "SEK-SIOR-OIS-COMPOUND",
                FloatingRateIndex.SEK_STIBOR => "SEK-STIBOR",
                FloatingRateIndex.SEK_STIBOR_Bloomberg => "SEK-STIBOR-Bloomberg",
                FloatingRateIndex.SEK_STIBOR_OIS_Compound => "SEK-STIBOR-OIS Compound",
                FloatingRateIndex.SEK_STIBOR_Reference_Banks => "SEK-STIBOR-Reference Banks",
                FloatingRateIndex.SEK_STIBOR_SIDE => "SEK-STIBOR-SIDE",
                FloatingRateIndex.SEK_SWESTR => "SEK-SWESTR",
                FloatingRateIndex.SEK_SWESTR_Average_1M => "SEK-SWESTR Average 1M",
                FloatingRateIndex.SEK_SWESTR_Average_1W => "SEK-SWESTR Average 1W",
                FloatingRateIndex.SEK_SWESTR_Average_2M => "SEK-SWESTR Average 2M",
                FloatingRateIndex.SEK_SWESTR_Average_3M => "SEK-SWESTR Average 3M",
                FloatingRateIndex.SEK_SWESTR_Average_6M => "SEK-SWESTR Average 6M",
                FloatingRateIndex.SEK_SWESTR_Compounded_Index => "SEK-SWESTR Compounded Index",
                FloatingRateIndex.SEK_SWESTR_OIS_Compound => "SEK-SWESTR-OIS Compound",
                FloatingRateIndex.SGD_SIBOR => "SGD-SIBOR",
                FloatingRateIndex.SGD_SIBOR_Reference_Banks => "SGD-SIBOR-Reference Banks",
                FloatingRateIndex.SGD_SIBOR_Reuters => "SGD-SIBOR-Reuters",
                FloatingRateIndex.SGD_SIBOR_Telerate => "SGD-SIBOR-Telerate",
                FloatingRateIndex.SGD_SONAR_OIS_COMPOUND => "SGD-SONAR-OIS-COMPOUND",
                FloatingRateIndex.SGD_SONAR_OIS_VWAP_COMPOUND => "SGD-SONAR-OIS-VWAP-COMPOUND",
                FloatingRateIndex.SGD_SOR => "SGD-SOR",
                FloatingRateIndex.SGD_SORA => "SGD-SORA",
                FloatingRateIndex.SGD_SORA_COMPOUND => "SGD-SORA-COMPOUND",
                FloatingRateIndex.SGD_SORA_OIS_Compound => "SGD-SORA-OIS Compound",
                FloatingRateIndex.SGD_SOR_Reference_Banks => "SGD-SOR-Reference Banks",
                FloatingRateIndex.SGD_SOR_Reuters => "SGD-SOR-Reuters",
                FloatingRateIndex.SGD_SOR_Telerate => "SGD-SOR-Telerate",
                FloatingRateIndex.SGD_SOR_VWAP => "SGD-SOR-VWAP",
                FloatingRateIndex.SGD_SOR_VWAP_Reference_Banks => "SGD-SOR-VWAP-Reference Banks",
                FloatingRateIndex.SGD_Semi_Annual_Currency_Basis_Swap_Rate_11_00_Tullett_Prebon => "SGD-Semi-Annual Currency Basis Swap Rate-11:00-Tullett Prebon",
                FloatingRateIndex.SGD_Semi_Annual_Currency_Basis_Swap_Rate_16_00_Tullett_Prebon => "SGD-Semi-Annual Currency Basis Swap Rate-16:00-Tullett Prebon",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "SGD-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_11_00_TRADITION => "SGD-Semi-Annual Swap Rate-11.00-TRADITION",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_11_00_Tullett_Prebon => "SGD-Semi-Annual Swap Rate-11:00-Tullett Prebon",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_16_00_Tullett_Prebon => "SGD-Semi-Annual Swap Rate-16:00-Tullett Prebon",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_ICAP => "SGD-Semi-Annual Swap Rate-ICAP",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_ICAP_Reference_Banks => "SGD-Semi-Annual Swap Rate-ICAP-Reference Banks",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_Reference_Banks => "SGD-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.SGD_Semi_Annual_Swap_Rate_TRADITION_Reference_Banks => "SGD-Semi-Annual Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.SKK_BRIBOR_BRBO => "SKK-BRIBOR-BRBO",
                FloatingRateIndex.SKK_BRIBOR_Bloomberg => "SKK-BRIBOR-Bloomberg",
                FloatingRateIndex.SKK_BRIBOR_NBSK07 => "SKK-BRIBOR-NBSK07",
                FloatingRateIndex.SKK_BRIBOR_Reference_Banks => "SKK-BRIBOR-Reference Banks",
                FloatingRateIndex.THB_SOR_Reference_Banks => "THB-SOR-Reference Banks",
                FloatingRateIndex.THB_SOR_Reuters => "THB-SOR-Reuters",
                FloatingRateIndex.THB_SOR_Telerate => "THB-SOR-Telerate",
                FloatingRateIndex.THB_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "THB-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.THB_Semi_Annual_Swap_Rate_Reference_Banks => "THB-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.THB_THBFIX => "THB-THBFIX",
                FloatingRateIndex.THB_THBFIX_Reference_Banks => "THB-THBFIX-Reference Banks",
                FloatingRateIndex.THB_THBFIX_Reuters => "THB-THBFIX-Reuters",
                FloatingRateIndex.THB_THOR => "THB-THOR",
                FloatingRateIndex.THB_THOR_COMPOUND => "THB-THOR-COMPOUND",
                FloatingRateIndex.THB_THOR_OIS_Compound => "THB-THOR-OIS Compound",
                FloatingRateIndex.TRY_Annual_Swap_Rate_11_00_TRADITION => "TRY Annual Swap Rate-11:00-TRADITION",
                FloatingRateIndex.TRY_Annual_Swap_Rate_11_15_BGCANTOR => "TRY-Annual Swap Rate-11:15-BGCANTOR",
                FloatingRateIndex.TRY_Annual_Swap_Rate_Reference_Banks => "TRY-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.TRY_Semi_Annual_Swap_Rate_TRADITION_Reference_Banks => "TRY-Semi-Annual Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.TRY_TLREF => "TRY-TLREF",
                FloatingRateIndex.TRY_TLREF_OIS_COMPOUND => "TRY-TLREF-OIS-COMPOUND",
                FloatingRateIndex.TRY_TLREF_OIS_Compound_1 => "TRY-TLREF-OIS Compound",
                FloatingRateIndex.TRY_TRLIBOR => "TRY-TRLIBOR",
                FloatingRateIndex.TRY_TRYIBOR_Reference_Banks => "TRY-TRYIBOR-Reference Banks",
                FloatingRateIndex.TRY_TRYIBOR_Reuters => "TRY-TRYIBOR-Reuters",
                FloatingRateIndex.TWD_Quarterly_Annual_Swap_Rate_11_00_BGCANTOR => "TWD-Quarterly-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.TWD_Quarterly_Annual_Swap_Rate_Reference_Banks => "TWD-Quarterly-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.TWD_Reference_Dealers => "TWD-Reference Dealers",
                FloatingRateIndex.TWD_Reuters_6165 => "TWD-Reuters-6165",
                FloatingRateIndex.TWD_TAIBIR01 => "TWD-TAIBIR01",
                FloatingRateIndex.TWD_TAIBIR02 => "TWD-TAIBIR02",
                FloatingRateIndex.TWD_TAIBOR => "TWD-TAIBOR",
                FloatingRateIndex.TWD_TAIBOR_Bloomberg => "TWD-TAIBOR-Bloomberg",
                FloatingRateIndex.TWD_TAIBOR_Reuters => "TWD-TAIBOR-Reuters",
                FloatingRateIndex.TWD_TWCPBA => "TWD-TWCPBA",
                FloatingRateIndex.TWD_Telerate_6165 => "TWD-Telerate-6165",
                FloatingRateIndex.UK_Base_Rate => "UK Base Rate",
                FloatingRateIndex.USD_3M_LIBOR_SWAP_CME_vs_LCH_ICAP => "USD-3M LIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.USD_3M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "USD-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.USD_6M_LIBOR_SWAP_CME_vs_LCH_ICAP => "USD-6M LIBOR SWAP-CME vs LCH-ICAP",
                FloatingRateIndex.USD_6M_LIBOR_SWAP_CME_vs_LCH_ICAP_Bloomberg => "USD-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg",
                FloatingRateIndex.USD_AMERIBOR => "USD-AMERIBOR",
                FloatingRateIndex.USD_AMERIBOR_Average_30D => "USD-AMERIBOR Average 30D",
                FloatingRateIndex.USD_AMERIBOR_Average_90D => "USD-AMERIBOR Average 90D",
                FloatingRateIndex.USD_AMERIBOR_Term => "USD-AMERIBOR Term",
                FloatingRateIndex.USD_AMERIBOR_Term_Structure => "USD-AMERIBOR Term Structure",
                FloatingRateIndex.USD_AXI_Term => "USD-AXI Term",
                FloatingRateIndex.USD_Annual_Swap_Rate_11_00_BGCANTOR => "USD-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.USD_Annual_Swap_Rate_11_00_TRADITION => "USD-Annual Swap Rate-11:00-TRADITION",
                FloatingRateIndex.USD_Annual_Swap_Rate_4_00_TRADITION => "USD-Annual Swap Rate-4:00-TRADITION",
                FloatingRateIndex.USD_BA_H_15 => "USD-BA-H.15",
                FloatingRateIndex.USD_BA_Reference_Dealers => "USD-BA-Reference Dealers",
                FloatingRateIndex.USD_BMA_Municipal_Swap_Index => "USD-BMA Municipal Swap Index",
                FloatingRateIndex.USD_BSBY => "USD-BSBY",
                FloatingRateIndex.USD_CD_H_15 => "USD-CD-H.15",
                FloatingRateIndex.USD_CD_Reference_Dealers => "USD-CD-Reference Dealers",
                FloatingRateIndex.USD_CMS_Reference_Banks => "USD-CMS-Reference Banks",
                FloatingRateIndex.USD_CMS_Reference_Banks_ICAP_SwapPX => "USD-CMS-Reference Banks-ICAP SwapPX",
                FloatingRateIndex.USD_CMS_Reuters => "USD-CMS-Reuters",
                FloatingRateIndex.USD_CMS_Telerate => "USD-CMS-Telerate",
                FloatingRateIndex.USD_CMT => "USD-CMT",
                FloatingRateIndex.USD_CMT_Average_1W => "USD-CMT Average 1W",
                FloatingRateIndex.USD_CMT_T7051 => "USD-CMT-T7051",
                FloatingRateIndex.USD_CMT_T7052 => "USD-CMT-T7052",
                FloatingRateIndex.USD_COF11_FHLBSF => "USD-COF11-FHLBSF",
                FloatingRateIndex.USD_COF11_Reuters => "USD-COF11-Reuters",
                FloatingRateIndex.USD_COF11_Telerate => "USD-COF11-Telerate",
                FloatingRateIndex.USD_COFI => "USD-COFI",
                FloatingRateIndex.USD_CP_H_15 => "USD-CP-H.15",
                FloatingRateIndex.USD_CP_Money_Market_Yield => "USD-CP-Money Market Yield",
                FloatingRateIndex.USD_CP_Reference_Dealers => "USD-CP-Reference Dealers",
                FloatingRateIndex.USD_CRITR => "USD-CRITR",
                FloatingRateIndex.USD_FFCB_DISCO => "USD-FFCB-DISCO",
                FloatingRateIndex.USD_FXI_Term => "USD-FXI Term",
                FloatingRateIndex.USD_Federal_Funds => "USD-Federal Funds",
                FloatingRateIndex.USD_Federal_Funds_H_15 => "USD-Federal Funds-H.15",
                FloatingRateIndex.USD_Federal_Funds_H_15_Bloomberg => "USD-Federal Funds-H.15-Bloomberg",
                FloatingRateIndex.USD_Federal_Funds_H_15_OIS_COMPOUND => "USD-Federal Funds-H.15-OIS-COMPOUND",
                FloatingRateIndex.USD_Federal_Funds_OIS_Compound => "USD-Federal Funds-OIS Compound",
                FloatingRateIndex.USD_Federal_Funds_Reference_Dealers => "USD-Federal Funds-Reference Dealers",
                FloatingRateIndex.USD_ISDAFIX3_Swap_Rate => "USD-ISDAFIX3-Swap Rate",
                FloatingRateIndex.USD_ISDAFIX3_Swap_Rate_3_00 => "USD-ISDAFIX3-Swap Rate-3:00",
                FloatingRateIndex.USD_ISDA_Swap_Rate => "USD-ISDA-Swap Rate",
                FloatingRateIndex.USD_ISDA_Swap_Rate_3_00 => "USD-ISDA-Swap Rate-3:00",
                FloatingRateIndex.USD_LIBOR => "USD-LIBOR",
                FloatingRateIndex.USD_LIBOR_BBA => "USD-LIBOR-BBA",
                FloatingRateIndex.USD_LIBOR_BBA_Bloomberg => "USD-LIBOR-BBA-Bloomberg",
                FloatingRateIndex.USD_LIBOR_ICE_Swap_Rate_11_00 => "USD-LIBOR ICE Swap Rate-11:00",
                FloatingRateIndex.USD_LIBOR_ICE_Swap_Rate_15_00 => "USD-LIBOR ICE Swap Rate-15:00",
                FloatingRateIndex.USD_LIBOR_ISDA => "USD-LIBOR-ISDA",
                FloatingRateIndex.USD_LIBOR_LIBO => "USD-LIBOR-LIBO",
                FloatingRateIndex.USD_LIBOR_Reference_Banks => "USD-LIBOR-Reference Banks",
                FloatingRateIndex.USD_Municipal_Swap_Index => "USD-Municipal Swap Index",
                FloatingRateIndex.USD_Municipal_Swap_Libor_Ratio_11_00_ICAP => "USD-Municipal Swap Libor Ratio-11:00-ICAP",
                FloatingRateIndex.USD_Municipal_Swap_Rate_11_00_ICAP => "USD-Municipal Swap Rate-11:00-ICAP",
                FloatingRateIndex.USD_OIS_11_00_BGCANTOR => "USD-OIS-11:00-BGCANTOR",
                FloatingRateIndex.USD_OIS_11_00_LON_ICAP => "USD-OIS-11:00-LON-ICAP",
                FloatingRateIndex.USD_OIS_11_00_NY_ICAP => "USD-OIS-11:00-NY-ICAP",
                FloatingRateIndex.USD_OIS_11_00_TRADITION => "USD-OIS-11:00-TRADITION",
                FloatingRateIndex.USD_OIS_3_00_BGCANTOR => "USD-OIS-3:00-BGCANTOR",
                FloatingRateIndex.USD_OIS_3_00_NY_ICAP => "USD-OIS-3:00-NY-ICAP",
                FloatingRateIndex.USD_OIS_4_00_TRADITION => "USD-OIS-4:00-TRADITION",
                FloatingRateIndex.USD_Overnight_Bank_Funding_Rate => "USD-Overnight Bank Funding Rate",
                FloatingRateIndex.USD_Prime => "USD-Prime",
                FloatingRateIndex.USD_Prime_H_15 => "USD-Prime-H.15",
                FloatingRateIndex.USD_Prime_Reference_Banks => "USD-Prime-Reference Banks",
                FloatingRateIndex.USD_SIBOR_Reference_Banks => "USD-SIBOR-Reference Banks",
                FloatingRateIndex.USD_SIBOR_SIBO => "USD-SIBOR-SIBO",
                FloatingRateIndex.USD_SIFMA_Municipal_Swap_Index => "USD-SIFMA Municipal Swap Index",
                FloatingRateIndex.USD_SOFR => "USD-SOFR",
                FloatingRateIndex.USD_SOFR_Average_180D => "USD-SOFR Average 180D",
                FloatingRateIndex.USD_SOFR_Average_30D => "USD-SOFR Average 30D",
                FloatingRateIndex.USD_SOFR_Average_90D => "USD-SOFR Average 90D",
                FloatingRateIndex.USD_SOFR_CME_Term => "USD-SOFR CME Term",
                FloatingRateIndex.USD_SOFR_COMPOUND => "USD-SOFR-COMPOUND",
                FloatingRateIndex.USD_SOFR_Compounded_Index => "USD-SOFR Compounded Index",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index => "USD-SOFR ICE Compounded Index",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index_0_Floor => "USD-SOFR ICE Compounded Index 0 Floor",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index_0_Floor_2D_Lag => "USD-SOFR ICE Compounded Index 0 Floor 2D Lag",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index_0_Floor_5D_Lag => "USD-SOFR ICE Compounded Index 0 Floor 5D Lag",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index_2D_Lag => "USD-SOFR ICE Compounded Index 2D Lag",
                FloatingRateIndex.USD_SOFR_ICE_Compounded_Index_5D_Lag => "USD-SOFR ICE Compounded Index 5D Lag",
                FloatingRateIndex.USD_SOFR_ICE_Swap_Rate => "USD-SOFR ICE Swap Rate",
                FloatingRateIndex.USD_SOFR_ICE_Swap_Rate_Spreads => "USD-SOFR ICE Swap Rate Spreads",
                FloatingRateIndex.USD_SOFR_ICE_Term => "USD-SOFR ICE Term",
                FloatingRateIndex.USD_SOFR_OIS_Compound => "USD-SOFR-OIS Compound",
                FloatingRateIndex.USD_S_P_Index_High_Grade => "USD-S&P Index-High Grade",
                FloatingRateIndex.USD_SandP_Index_High_Grade => "USD-SandP Index High Grade",
                FloatingRateIndex.USD_Swap_Rate_BCMP1 => "USD Swap Rate-BCMP1",
                FloatingRateIndex.USD_TBILL_Auction_High_Rate => "USD-TBILL Auction High Rate",
                FloatingRateIndex.USD_TBILL_H_15 => "USD-TBILL-H.15",
                FloatingRateIndex.USD_TBILL_H_15_Bloomberg => "USD-TBILL-H.15-Bloomberg",
                FloatingRateIndex.USD_TBILL_Secondary_Market => "USD-TBILL-Secondary Market",
                FloatingRateIndex.USD_TBILL_Secondary_Market_Bond_Equivalent_Yield => "USD-TBILL Secondary Market-Bond Equivalent Yield",
                FloatingRateIndex.USD_TIBOR_ISDC => "USD-TIBOR-ISDC",
                FloatingRateIndex.USD_TIBOR_Reference_Banks => "USD-TIBOR-Reference Banks",
                FloatingRateIndex.USD_Treasury_19901_3_00_ICAP => "USD-Treasury-19901-3:00-ICAP",
                FloatingRateIndex.USD_Treasury_Rate_BCMP1 => "USD Treasury Rate-BCMP1",
                FloatingRateIndex.USD_Treasury_Rate_ICAP_BrokerTec => "USD-Treasury Rate-ICAP BrokerTec",
                FloatingRateIndex.USD_Treasury_Rate_SwapMarker100 => "USD-Treasury Rate-SwapMarker100",
                FloatingRateIndex.USD_Treasury_Rate_SwapMarker99 => "USD-Treasury Rate-SwapMarker99",
                FloatingRateIndex.USD_Treasury_Rate_T19901 => "USD-Treasury Rate-T19901",
                FloatingRateIndex.USD_Treasury_Rate_T500 => "USD-Treasury Rate-T500",
                FloatingRateIndex.VND_Semi_Annual_Swap_Rate_11_00_BGCANTOR => "VND-Semi-Annual Swap Rate-11:00-BGCANTOR",
                FloatingRateIndex.VND_Semi_Annual_Swap_Rate_Reference_Banks => "VND-Semi-Annual Swap Rate-Reference Banks",
                FloatingRateIndex.ZAR_DEPOSIT_Reference_Banks => "ZAR-DEPOSIT-Reference Banks",
                FloatingRateIndex.ZAR_DEPOSIT_SAFEX => "ZAR-DEPOSIT-SAFEX",
                FloatingRateIndex.ZAR_JIBAR => "ZAR-JIBAR",
                FloatingRateIndex.ZAR_JIBAR_Reference_Banks => "ZAR-JIBAR-Reference Banks",
                FloatingRateIndex.ZAR_JIBAR_SAFEX => "ZAR-JIBAR-SAFEX",
                FloatingRateIndex.ZAR_PRIME_AVERAGE => "ZAR-PRIME-AVERAGE",
                FloatingRateIndex.ZAR_PRIME_AVERAGE_Reference_Banks => "ZAR-PRIME-AVERAGE-Reference Banks",
                FloatingRateIndex.ZAR_Prime_Average_1 => "ZAR-Prime Average",
                FloatingRateIndex.ZAR_Quarterly_Swap_Rate_1_00_TRADITION => "ZAR-Quarterly Swap Rate-1:00-TRADITION",
                FloatingRateIndex.ZAR_Quarterly_Swap_Rate_5_30_TRADITION => "ZAR-Quarterly Swap Rate-5:30-TRADITION",
                FloatingRateIndex.ZAR_Quarterly_Swap_Rate_TRADITION_Reference_Banks => "ZAR-Quarterly Swap Rate-TRADITION-Reference Banks",
                FloatingRateIndex.ZAR_ZARONIA => "ZAR-ZARONIA",
                FloatingRateIndex.ZAR_ZARONIA_OIS_Compound => "ZAR-ZARONIA-OIS Compound",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// This enumeration provides guidance on how to process a given floating rate index.  It&apos;s based on the ISDA Floating Rate Index information, but transforms it into the specific categories needed for calculation 
    /// </summary>
    [CdmName("FloatingRateIndexProcessingTypeEnum")]
    public enum FloatingRateIndexProcessingType
    {
        /// <summary>
        /// A published index calculated using compounding; the implied rate must be backed out.
        /// </summary>
        [EnumMember(Value = "COMPOUND_INDEX")]
        CompoundIndex,
        
        /// <summary>
        /// These are calculated by the calculation agent based on deal-specific parameters (e.g. lookback compound based on an RFR).
        /// </summary>
        [EnumMember(Value = "MODULAR")]
        Modular,
        
        /// <summary>
        /// These are calculated by the calculation agent based on a standard OIS FRO definition.
        /// </summary>
        OIS,
        
        /// <summary>
        /// These are calculated by the calculation agent based on a standard overnight averaging FRO definition.
        /// </summary>
        [EnumMember(Value = "OVERNIGHT_AVG")]
        OvernightAvg,
        
        /// <summary>
        /// These must be looked up using a manual process
        /// </summary>
        [EnumMember(Value = "REF_BANKS")]
        RefBanks,
        
        /// <summary>
        /// These values are just looked up from the screen and applied.
        /// </summary>
        [EnumMember(Value = "SCREEN")]
        Screen
    }
    
    /// <summary>
    /// Second level ISDA FRO category.
    /// </summary>
    [CdmName("FloatingRateIndexStyleEnum")]
    public enum FloatingRateIndexStyle
    {
        /// <summary>
        /// An ISDA-defined calculated rate done using arithmetic averaging.
        /// </summary>
        [EnumMember(Value = "Average FRO")]
        AverageFRO,
        
        /// <summary>
        /// An ISDA-defined calculated rate done using arithmetic averaging.
        /// </summary>
        [EnumMember(Value = "Compounded FRO")]
        CompoundedFRO,
        
        /// <summary>
        /// A published index calculated using compounding.
        /// </summary>
        [EnumMember(Value = "Compounded Index")]
        CompoundedIndex,
        
        /// <summary>
        /// A published index using a methodology defined by the publisher, e.g. S&amp;P 500.
        /// </summary>
        [EnumMember(Value = "Index")]
        Index,
        
        [EnumMember(Value = "Other")]
        Other,
        
        [EnumMember(Value = "Overnight Rate")]
        Overnight,
        
        /// <summary>
        ///  A published rate computed using an averaging methodology.
        /// </summary>
        [EnumMember(Value = "Published Average Rate")]
        PublishedAverage,
        
        [EnumMember(Value = "Specified Formula")]
        SpecifiedFormula,
        
        /// <summary>
        /// A rate representing the market rate for swaps of a given maturity.
        /// </summary>
        [EnumMember(Value = "Swap Rate")]
        SwapRate,
        
        /// <summary>
        /// A rate specified over a given term, such as a libor-type rate.
        /// </summary>
        [EnumMember(Value = "Term Rate")]
        TermRate
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this FloatingRateIndexStyle value)
        {
            return value switch
            {
                FloatingRateIndexStyle.AverageFRO => "Average FRO",
                FloatingRateIndexStyle.CompoundedFRO => "Compounded FRO",
                FloatingRateIndexStyle.CompoundedIndex => "Compounded Index",
                FloatingRateIndexStyle.Index => "Index",
                FloatingRateIndexStyle.Other => "Other",
                FloatingRateIndexStyle.Overnight => "Overnight Rate",
                FloatingRateIndexStyle.PublishedAverage => "Published Average Rate",
                FloatingRateIndexStyle.SpecifiedFormula => "Specified Formula",
                FloatingRateIndexStyle.SwapRate => "Swap Rate",
                FloatingRateIndexStyle.TermRate => "Term Rate",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the fund product type.
    /// </summary>
    [CdmName("FundProductTypeEnum")]
    public enum FundProductType
    {
        /// <summary>
        /// Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange.
        /// </summary>
        [EnumMember(Value = "EXCHANGE_TRADED_FUND")]
        ExchangeTradedFund,
        
        /// <summary>
        /// Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity.
        /// </summary>
        [EnumMember(Value = "MONEY_MARKET_FUND")]
        MoneyMarketFund,
        
        /// <summary>
        /// Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager.
        /// </summary>
        [EnumMember(Value = "MUTUAL_FUND")]
        MutualFund,
        
        /// <summary>
        /// Denotes a fund that is not an Exchange Traded Fund, Money Market Fund or Mutual Fund.
        /// </summary>
        [EnumMember(Value = "OTHER_FUND")]
        OtherFund
    }
    
    /// <summary>
    /// The enumerated values to specify the law governing the contract or legal document.
    /// </summary>
    [CdmName("GoverningLawEnum")]
    public enum GoverningLaw
    {
        /// <summary>
        /// The Governing Law is determined by reference to the relevant master agreement.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_AGREEMENT")]
        AsSpecifiedInMasterAgreement,
        
        /// <summary>
        /// Belgian law
        /// </summary>
        BE,
        
        /// <summary>
        /// Alberta law
        /// </summary>
        CAAB,
        
        /// <summary>
        /// British Columbia Law
        /// </summary>
        CABC,
        
        /// <summary>
        /// Manitoba law
        /// </summary>
        CAMN,
        
        /// <summary>
        /// Ontario law
        /// </summary>
        CAON,
        
        /// <summary>
        /// Quebec law
        /// </summary>
        CAQC,
        
        /// <summary>
        /// German law
        /// </summary>
        DE,
        
        /// <summary>
        /// French law
        /// </summary>
        FR,
        
        /// <summary>
        /// English law
        /// </summary>
        [RosettaSynonym(Value = "ENGLISH", Source = "AcadiaSoft_AM_1_0")]
        GBEN,
        
        /// <summary>
        /// The law of the island of Guernsey
        /// </summary>
        GBGY,
        
        /// <summary>
        /// The law of the Isle of Man
        /// </summary>
        GBIM,
        
        /// <summary>
        /// The law of the island of Jersey
        /// </summary>
        GBJY,
        
        /// <summary>
        /// Scottish law
        /// </summary>
        GBSC,
        
        /// <summary>
        /// Irish law
        /// </summary>
        IE,
        
        /// <summary>
        /// Japanese law
        /// </summary>
        [RosettaSynonym(Value = "JAPAN", Source = "AcadiaSoft_AM_1_0")]
        JP,
        
        /// <summary>
        /// Luxembourg law
        /// </summary>
        LU,
        
        /// <summary>
        /// As agreed in the ISDA Master Agreement
        /// </summary>
        [EnumMember(Value = "RELATED_MASTER_AGREEMENT")]
        RelatedMasterAgreement,
        
        /// <summary>
        /// Californian law
        /// </summary>
        USCA,
        
        /// <summary>
        /// Delaware law
        /// </summary>
        USDE,
        
        /// <summary>
        /// Illinois law
        /// </summary>
        USIL,
        
        /// <summary>
        /// New York law
        /// </summary>
        [RosettaSynonym(Value = "NY", Source = "AcadiaSoft_AM_1_0")]
        USNY
    }
    
    /// <summary>
    /// Represents the enumeration indicators to specify if an asset or group of assets valuation is based on any valuation treatment haircut.
    /// </summary>
    [CdmName("HaircutIndicatorEnum")]
    public enum HaircutIndicator
    {
        /// <summary>
        /// Indicates Post haircut value
        /// </summary>
        [EnumMember(Value = "POST_HAIRCUT")]
        PostHaircut,
        
        /// <summary>
        /// Indicates Pre haircut value
        /// </summary>
        [EnumMember(Value = "PRE_HAIRCUT")]
        PreHaircut
    }
    
    /// <summary>
    /// The enumerated values to specify standard currency codes according to the International Standards Organization (ISO). The set of codes in this enumerated list is sourced from ISO Standard 3166 (ISO-3166-1alpha-2)(https://www.iso.org/iso-3166-country-codes.html) as at 14-Aug-23.
    /// </summary>
    [CdmName("ISOCountryCodeEnum")]
    public enum ISOCountryCode
    {
        /// <summary>
        /// Andorra
        /// </summary>
        AD,
        
        /// <summary>
        /// United Arab Emirates (the)
        /// </summary>
        AE,
        
        /// <summary>
        /// Afghanistan
        /// </summary>
        AF,
        
        /// <summary>
        /// Antigua and Barbuda
        /// </summary>
        AG,
        
        /// <summary>
        /// Anguilla
        /// </summary>
        AI,
        
        /// <summary>
        /// Albania
        /// </summary>
        AL,
        
        /// <summary>
        /// Armenia
        /// </summary>
        AM,
        
        /// <summary>
        /// Angola
        /// </summary>
        AO,
        
        /// <summary>
        /// Antarctica
        /// </summary>
        AQ,
        
        /// <summary>
        /// Argentina
        /// </summary>
        AR,
        
        /// <summary>
        /// American Samoa
        /// </summary>
        AS,
        
        /// <summary>
        /// Austria
        /// </summary>
        AT,
        
        /// <summary>
        /// Australia
        /// </summary>
        AU,
        
        /// <summary>
        /// Aruba
        /// </summary>
        AW,
        
        /// <summary>
        /// Aland Islands
        /// </summary>
        AX,
        
        /// <summary>
        /// Azerbaijan
        /// </summary>
        AZ,
        
        /// <summary>
        /// Bosnia and Herzegovina
        /// </summary>
        BA,
        
        /// <summary>
        /// Barbados
        /// </summary>
        BB,
        
        /// <summary>
        /// Bangladesh
        /// </summary>
        BD,
        
        /// <summary>
        /// Belgium
        /// </summary>
        BE,
        
        /// <summary>
        /// Burkina Faso
        /// </summary>
        BF,
        
        /// <summary>
        /// Bulgaria
        /// </summary>
        BG,
        
        /// <summary>
        /// Bahrain
        /// </summary>
        BH,
        
        /// <summary>
        /// Burundi
        /// </summary>
        BI,
        
        /// <summary>
        /// Benin
        /// </summary>
        BJ,
        
        /// <summary>
        /// Saint Barthlemy
        /// </summary>
        BL,
        
        /// <summary>
        /// Bermuda
        /// </summary>
        BM,
        
        /// <summary>
        /// Brunei Darussalam
        /// </summary>
        BN,
        
        /// <summary>
        /// Bolivia (Plurinational State of)
        /// </summary>
        BO,
        
        /// <summary>
        /// Bonaire, Sint Eustatius and Saba
        /// </summary>
        BQ,
        
        /// <summary>
        /// Brazil
        /// </summary>
        BR,
        
        /// <summary>
        /// Bahamas (the)
        /// </summary>
        BS,
        
        /// <summary>
        /// Bhutan
        /// </summary>
        BT,
        
        /// <summary>
        /// Bouvet Island
        /// </summary>
        BV,
        
        /// <summary>
        /// Botswana
        /// </summary>
        BW,
        
        /// <summary>
        /// Belarus
        /// </summary>
        BY,
        
        /// <summary>
        /// Belize
        /// </summary>
        BZ,
        
        /// <summary>
        /// Canada
        /// </summary>
        CA,
        
        /// <summary>
        /// Cocos (Keeling) Islands (the)
        /// </summary>
        CC,
        
        /// <summary>
        /// Congo (the Democratic Republic of the)
        /// </summary>
        CD,
        
        /// <summary>
        /// Central African Republic (the)
        /// </summary>
        CF,
        
        /// <summary>
        /// Congo (the)
        /// </summary>
        CG,
        
        /// <summary>
        /// Switzerland
        /// </summary>
        CH,
        
        /// <summary>
        /// Cte d&apos;Ivoire
        /// </summary>
        CI,
        
        /// <summary>
        /// Cook Islands (the)
        /// </summary>
        CK,
        
        /// <summary>
        /// Chile
        /// </summary>
        CL,
        
        /// <summary>
        /// Cameroon
        /// </summary>
        CM,
        
        /// <summary>
        /// China
        /// </summary>
        CN,
        
        /// <summary>
        /// Colombia
        /// </summary>
        CO,
        
        /// <summary>
        /// Costa Rica
        /// </summary>
        CR,
        
        /// <summary>
        /// Cuba
        /// </summary>
        CU,
        
        /// <summary>
        /// Cabo Verde
        /// </summary>
        CV,
        
        /// <summary>
        /// Curaao
        /// </summary>
        CW,
        
        /// <summary>
        /// Christmas Island
        /// </summary>
        CX,
        
        /// <summary>
        /// Cyprus
        /// </summary>
        CY,
        
        /// <summary>
        /// Czechia
        /// </summary>
        CZ,
        
        /// <summary>
        /// Germany
        /// </summary>
        DE,
        
        /// <summary>
        /// Djibouti
        /// </summary>
        DJ,
        
        /// <summary>
        /// Denmark
        /// </summary>
        DK,
        
        /// <summary>
        /// Dominica
        /// </summary>
        DM,
        
        /// <summary>
        /// Dominican Republic (the)
        /// </summary>
        DO,
        
        /// <summary>
        /// Algeria
        /// </summary>
        DZ,
        
        /// <summary>
        /// Ecuador
        /// </summary>
        EC,
        
        /// <summary>
        /// Estonia
        /// </summary>
        EE,
        
        /// <summary>
        /// Egypt
        /// </summary>
        EG,
        
        /// <summary>
        /// Western Sahara*
        /// </summary>
        EH,
        
        /// <summary>
        /// Eritrea
        /// </summary>
        ER,
        
        /// <summary>
        /// Spain
        /// </summary>
        ES,
        
        /// <summary>
        /// Ethiopia
        /// </summary>
        ET,
        
        /// <summary>
        /// Finland
        /// </summary>
        FI,
        
        /// <summary>
        /// Fiji
        /// </summary>
        FJ,
        
        /// <summary>
        /// Falkland Islands (the) [Malvinas]
        /// </summary>
        FK,
        
        /// <summary>
        /// Micronesia (Federated States of)
        /// </summary>
        FM,
        
        /// <summary>
        /// Faroe Islands (the)
        /// </summary>
        FO,
        
        /// <summary>
        /// France
        /// </summary>
        FR,
        
        /// <summary>
        /// Gabon
        /// </summary>
        GA,
        
        /// <summary>
        /// United Kingdom of Great Britain and Northern Ireland (the)
        /// </summary>
        GB,
        
        /// <summary>
        /// Grenada
        /// </summary>
        GD,
        
        /// <summary>
        /// Georgia
        /// </summary>
        GE,
        
        /// <summary>
        /// French Guiana
        /// </summary>
        GF,
        
        /// <summary>
        /// Guernsey
        /// </summary>
        GG,
        
        /// <summary>
        /// Ghana
        /// </summary>
        GH,
        
        /// <summary>
        /// Gibraltar
        /// </summary>
        GI,
        
        /// <summary>
        /// Greenland
        /// </summary>
        GL,
        
        /// <summary>
        /// Gambia (the)
        /// </summary>
        GM,
        
        /// <summary>
        /// Guinea
        /// </summary>
        GN,
        
        /// <summary>
        /// Guadeloupe
        /// </summary>
        GP,
        
        /// <summary>
        /// Equatorial Guinea
        /// </summary>
        GQ,
        
        /// <summary>
        /// Greece
        /// </summary>
        GR,
        
        /// <summary>
        /// South Georgia and the South Sandwich Islands
        /// </summary>
        GS,
        
        /// <summary>
        /// Guatemala
        /// </summary>
        GT,
        
        /// <summary>
        /// Guam
        /// </summary>
        GU,
        
        /// <summary>
        /// Guinea-Bissau
        /// </summary>
        GW,
        
        /// <summary>
        /// Guyana
        /// </summary>
        GY,
        
        /// <summary>
        /// Hong Kong
        /// </summary>
        HK,
        
        /// <summary>
        /// Heard Island and McDonald Islands
        /// </summary>
        HM,
        
        /// <summary>
        /// Honduras
        /// </summary>
        HN,
        
        /// <summary>
        /// Croatia
        /// </summary>
        HR,
        
        /// <summary>
        /// Haiti
        /// </summary>
        HT,
        
        /// <summary>
        /// Hungary
        /// </summary>
        HU,
        
        /// <summary>
        /// Indonesia
        /// </summary>
        ID,
        
        /// <summary>
        /// Ireland
        /// </summary>
        IE,
        
        /// <summary>
        /// Israel
        /// </summary>
        IL,
        
        /// <summary>
        /// Isle of Man
        /// </summary>
        IM,
        
        /// <summary>
        /// India
        /// </summary>
        IN,
        
        /// <summary>
        /// British Indian Ocean Territory (the)
        /// </summary>
        IO,
        
        /// <summary>
        /// Iraq
        /// </summary>
        IQ,
        
        /// <summary>
        /// Iran (Islamic Republic of)
        /// </summary>
        IR,
        
        /// <summary>
        /// Iceland
        /// </summary>
        IS,
        
        /// <summary>
        /// Italy
        /// </summary>
        IT,
        
        /// <summary>
        /// Jersey
        /// </summary>
        JE,
        
        /// <summary>
        /// Jamaica
        /// </summary>
        JM,
        
        /// <summary>
        /// Jordan
        /// </summary>
        JO,
        
        /// <summary>
        /// Japan
        /// </summary>
        JP,
        
        /// <summary>
        /// Kenya
        /// </summary>
        KE,
        
        /// <summary>
        /// Kyrgyzstan
        /// </summary>
        KG,
        
        /// <summary>
        /// Cambodia
        /// </summary>
        KH,
        
        /// <summary>
        /// Kiribati
        /// </summary>
        KI,
        
        /// <summary>
        /// Comoros (the)
        /// </summary>
        KM,
        
        /// <summary>
        /// Saint Kitts and Nevis
        /// </summary>
        KN,
        
        /// <summary>
        /// Korea (the Democratic People&apos;s Republic of)
        /// </summary>
        KP,
        
        /// <summary>
        /// Korea (the Republic of)
        /// </summary>
        KR,
        
        /// <summary>
        /// Kuwait
        /// </summary>
        KW,
        
        /// <summary>
        /// Cayman Islands (the)
        /// </summary>
        KY,
        
        /// <summary>
        /// Kazakhstan
        /// </summary>
        KZ,
        
        /// <summary>
        /// Lao People&apos;s Democratic Republic (the)
        /// </summary>
        LA,
        
        /// <summary>
        /// Lebanon
        /// </summary>
        LB,
        
        /// <summary>
        /// Saint Lucia
        /// </summary>
        LC,
        
        /// <summary>
        /// Liechtenstein
        /// </summary>
        LI,
        
        /// <summary>
        /// Sri Lanka
        /// </summary>
        LK,
        
        /// <summary>
        /// Liberia
        /// </summary>
        LR,
        
        /// <summary>
        /// Lesotho
        /// </summary>
        LS,
        
        /// <summary>
        /// Lithuania
        /// </summary>
        LT,
        
        /// <summary>
        /// Luxembourg
        /// </summary>
        LU,
        
        /// <summary>
        /// Latvia
        /// </summary>
        LV,
        
        /// <summary>
        /// Libya
        /// </summary>
        LY,
        
        /// <summary>
        /// Morocco
        /// </summary>
        MA,
        
        /// <summary>
        /// Monaco
        /// </summary>
        MC,
        
        /// <summary>
        /// Moldova (the Republic of)
        /// </summary>
        MD,
        
        /// <summary>
        /// Montenegro
        /// </summary>
        ME,
        
        /// <summary>
        /// Saint Martin (French part)
        /// </summary>
        MF,
        
        /// <summary>
        /// Madagascar
        /// </summary>
        MG,
        
        /// <summary>
        /// Marshall Islands (the)
        /// </summary>
        MH,
        
        /// <summary>
        /// North Macedonia
        /// </summary>
        MK,
        
        /// <summary>
        /// Mali
        /// </summary>
        ML,
        
        /// <summary>
        /// Myanmar
        /// </summary>
        MM,
        
        /// <summary>
        /// Mongolia
        /// </summary>
        MN,
        
        /// <summary>
        /// Macao
        /// </summary>
        MO,
        
        /// <summary>
        /// Northern Mariana Islands (the)
        /// </summary>
        MP,
        
        /// <summary>
        /// Martinique
        /// </summary>
        MQ,
        
        /// <summary>
        /// Mauritania
        /// </summary>
        MR,
        
        /// <summary>
        /// Montserrat
        /// </summary>
        MS,
        
        /// <summary>
        /// Malta
        /// </summary>
        MT,
        
        /// <summary>
        /// Mauritius
        /// </summary>
        MU,
        
        /// <summary>
        /// Maldives
        /// </summary>
        MV,
        
        /// <summary>
        /// Malawi
        /// </summary>
        MW,
        
        /// <summary>
        /// Mexico
        /// </summary>
        MX,
        
        /// <summary>
        /// Malaysia
        /// </summary>
        MY,
        
        /// <summary>
        /// Mozambique
        /// </summary>
        MZ,
        
        /// <summary>
        /// Namibia
        /// </summary>
        NA,
        
        /// <summary>
        /// New Caledonia
        /// </summary>
        NC,
        
        /// <summary>
        /// Niger (the)
        /// </summary>
        NE,
        
        /// <summary>
        /// Norfolk Island
        /// </summary>
        NF,
        
        /// <summary>
        /// Nigeria
        /// </summary>
        NG,
        
        /// <summary>
        /// Nicaragua
        /// </summary>
        NI,
        
        /// <summary>
        /// Netherlands (Kingdom of the)
        /// </summary>
        NL,
        
        /// <summary>
        /// Norway
        /// </summary>
        NO,
        
        /// <summary>
        /// Nepal
        /// </summary>
        NP,
        
        /// <summary>
        /// Nauru
        /// </summary>
        NR,
        
        /// <summary>
        /// Niue
        /// </summary>
        NU,
        
        /// <summary>
        /// New Zealand
        /// </summary>
        NZ,
        
        /// <summary>
        /// Oman
        /// </summary>
        OM,
        
        /// <summary>
        /// Panama
        /// </summary>
        PA,
        
        /// <summary>
        /// Peru
        /// </summary>
        PE,
        
        /// <summary>
        /// French Polynesia
        /// </summary>
        PF,
        
        /// <summary>
        /// Papua New Guinea
        /// </summary>
        PG,
        
        /// <summary>
        /// Philippines (the)
        /// </summary>
        PH,
        
        /// <summary>
        /// Pakistan
        /// </summary>
        PK,
        
        /// <summary>
        /// Poland
        /// </summary>
        PL,
        
        /// <summary>
        /// Saint Pierre and Miquelon
        /// </summary>
        PM,
        
        /// <summary>
        /// Pitcairn
        /// </summary>
        PN,
        
        /// <summary>
        /// Puerto Rico
        /// </summary>
        PR,
        
        /// <summary>
        /// Palestine, State of
        /// </summary>
        PS,
        
        /// <summary>
        /// Portugal
        /// </summary>
        PT,
        
        /// <summary>
        /// Palau
        /// </summary>
        PW,
        
        /// <summary>
        /// Paraguay
        /// </summary>
        PY,
        
        /// <summary>
        /// Qatar
        /// </summary>
        QA,
        
        /// <summary>
        /// Runion
        /// </summary>
        RE,
        
        /// <summary>
        /// Romania
        /// </summary>
        RO,
        
        /// <summary>
        /// Serbia
        /// </summary>
        RS,
        
        /// <summary>
        /// Russian Federation (the)
        /// </summary>
        RU,
        
        /// <summary>
        /// Rwanda
        /// </summary>
        RW,
        
        /// <summary>
        /// Saudi Arabia
        /// </summary>
        SA,
        
        /// <summary>
        /// Solomon Islands
        /// </summary>
        SB,
        
        /// <summary>
        /// Seychelles
        /// </summary>
        SC,
        
        /// <summary>
        /// Sudan (the)
        /// </summary>
        SD,
        
        /// <summary>
        /// Sweden
        /// </summary>
        SE,
        
        /// <summary>
        /// Singapore
        /// </summary>
        SG,
        
        /// <summary>
        /// Saint Helena, Ascension and Tristan da Cunha
        /// </summary>
        SH,
        
        /// <summary>
        /// Slovenia
        /// </summary>
        SI,
        
        /// <summary>
        /// Svalbard and Jan Mayen
        /// </summary>
        SJ,
        
        /// <summary>
        /// Slovakia
        /// </summary>
        SK,
        
        /// <summary>
        /// Sierra Leone
        /// </summary>
        SL,
        
        /// <summary>
        /// San Marino
        /// </summary>
        SM,
        
        /// <summary>
        /// Senegal
        /// </summary>
        SN,
        
        /// <summary>
        /// Somalia
        /// </summary>
        SO,
        
        /// <summary>
        /// Suriname
        /// </summary>
        SR,
        
        /// <summary>
        /// South Sudan
        /// </summary>
        SS,
        
        /// <summary>
        /// Sao Tome and Principe
        /// </summary>
        ST,
        
        /// <summary>
        /// El Salvador
        /// </summary>
        SV,
        
        /// <summary>
        /// Sint Maarten (Dutch part)
        /// </summary>
        SX,
        
        /// <summary>
        /// Syrian Arab Republic (the)
        /// </summary>
        SY,
        
        /// <summary>
        /// Eswatini
        /// </summary>
        SZ,
        
        /// <summary>
        /// Turks and Caicos Islands (the)
        /// </summary>
        TC,
        
        /// <summary>
        /// Chad
        /// </summary>
        TD,
        
        /// <summary>
        /// French Southern Territories (the)
        /// </summary>
        TF,
        
        /// <summary>
        /// Togo
        /// </summary>
        TG,
        
        /// <summary>
        /// Thailand
        /// </summary>
        TH,
        
        /// <summary>
        /// Tajikistan
        /// </summary>
        TJ,
        
        /// <summary>
        /// Tokelau
        /// </summary>
        TK,
        
        /// <summary>
        /// Timor-Leste
        /// </summary>
        TL,
        
        /// <summary>
        /// Turkmenistan
        /// </summary>
        TM,
        
        /// <summary>
        /// Tunisia
        /// </summary>
        TN,
        
        /// <summary>
        /// Tonga
        /// </summary>
        TO,
        
        /// <summary>
        /// Trkiye
        /// </summary>
        TR,
        
        /// <summary>
        /// Trinidad and Tobago
        /// </summary>
        TT,
        
        /// <summary>
        /// Tuvalu
        /// </summary>
        TV,
        
        /// <summary>
        /// Taiwan (Province of China)
        /// </summary>
        TW,
        
        /// <summary>
        /// Tanzania, the United Republic of
        /// </summary>
        TZ,
        
        /// <summary>
        /// Ukraine
        /// </summary>
        UA,
        
        /// <summary>
        /// Uganda
        /// </summary>
        UG,
        
        /// <summary>
        /// United States Minor Outlying Islands (the)
        /// </summary>
        UM,
        
        /// <summary>
        /// United States of America (the)
        /// </summary>
        US,
        
        /// <summary>
        /// Uruguay
        /// </summary>
        UY,
        
        /// <summary>
        /// Uzbekistan
        /// </summary>
        UZ,
        
        /// <summary>
        /// Holy See (the)
        /// </summary>
        VA,
        
        /// <summary>
        /// Saint Vincent and the Grenadines
        /// </summary>
        VC,
        
        /// <summary>
        /// Venezuela (Bolivarian Republic of)
        /// </summary>
        VE,
        
        /// <summary>
        /// Virgin Islands (British)
        /// </summary>
        VG,
        
        /// <summary>
        /// Virgin Islands (U.S.)
        /// </summary>
        VI,
        
        /// <summary>
        /// Viet Nam
        /// </summary>
        VN,
        
        /// <summary>
        /// Vanuatu
        /// </summary>
        VU,
        
        /// <summary>
        /// Wallis and Futuna
        /// </summary>
        WF,
        
        /// <summary>
        /// Samoa
        /// </summary>
        WS,
        
        /// <summary>
        /// Yemen
        /// </summary>
        YE,
        
        /// <summary>
        /// Mayotte
        /// </summary>
        YT,
        
        /// <summary>
        /// South Africa
        /// </summary>
        ZA,
        
        /// <summary>
        /// Zambia
        /// </summary>
        ZM,
        
        /// <summary>
        /// Zimbabwe
        /// </summary>
        ZW
    }
    
    /// <summary>
    /// The enumerated values to specify standard currency codes according to the International Standards Organization (ISO).  The set of codes in this enumerated list is sourced from ISO Standard 4217 (https://www.currency-iso.org/en/home/tables/table-a1.html), as of 29-Aug-18.
    /// </summary>
    [CdmName("ISOCurrencyCodeEnum")]
    public enum ISOCurrencyCode
    {
        /// <summary>
        /// UAE Dirham
        /// </summary>
        AED,
        
        /// <summary>
        /// Afghani
        /// </summary>
        AFN,
        
        /// <summary>
        /// Lek
        /// </summary>
        ALL,
        
        /// <summary>
        /// Armenian Dram
        /// </summary>
        AMD,
        
        /// <summary>
        /// Netherlands Antillean Guilder
        /// </summary>
        ANG,
        
        /// <summary>
        /// Kwanza
        /// </summary>
        AOA,
        
        /// <summary>
        /// Argentine Peso
        /// </summary>
        ARS,
        
        /// <summary>
        /// Australian Dollar
        /// </summary>
        AUD,
        
        /// <summary>
        /// Aruban Florin
        /// </summary>
        AWG,
        
        /// <summary>
        /// Azerbaijan Manat
        /// </summary>
        AZN,
        
        /// <summary>
        /// Convertible Mark
        /// </summary>
        BAM,
        
        /// <summary>
        /// Barbados Dollar
        /// </summary>
        BBD,
        
        /// <summary>
        /// Taka
        /// </summary>
        BDT,
        
        /// <summary>
        /// Bulgarian Lev
        /// </summary>
        BGN,
        
        /// <summary>
        /// Bahraini Dinar
        /// </summary>
        BHD,
        
        /// <summary>
        /// Burundi Franc
        /// </summary>
        BIF,
        
        /// <summary>
        /// Bermudian Dollar
        /// </summary>
        BMD,
        
        /// <summary>
        /// Brunei Dollar
        /// </summary>
        BND,
        
        /// <summary>
        /// Boliviano
        /// </summary>
        BOB,
        
        /// <summary>
        /// Mvdol
        /// </summary>
        BOV,
        
        /// <summary>
        /// Brazilian Real
        /// </summary>
        BRL,
        
        /// <summary>
        /// Bahamian Dollar
        /// </summary>
        BSD,
        
        /// <summary>
        /// Ngultrum
        /// </summary>
        BTN,
        
        /// <summary>
        /// Pula
        /// </summary>
        BWP,
        
        /// <summary>
        /// Belarusian Ruble
        /// </summary>
        BYN,
        
        /// <summary>
        /// Belize Dollar
        /// </summary>
        BZD,
        
        /// <summary>
        /// Canadian Dollar
        /// </summary>
        CAD,
        
        /// <summary>
        /// Congolese Franc
        /// </summary>
        CDF,
        
        /// <summary>
        /// WIR Euro
        /// </summary>
        CHE,
        
        /// <summary>
        /// Swiss Franc
        /// </summary>
        CHF,
        
        /// <summary>
        /// WIR Franc
        /// </summary>
        CHW,
        
        /// <summary>
        /// Unidad de Fomento
        /// </summary>
        CLF,
        
        /// <summary>
        /// Chilean Peso
        /// </summary>
        CLP,
        
        /// <summary>
        /// Yuan Renminbi
        /// </summary>
        CNY,
        
        /// <summary>
        /// Colombian Peso
        /// </summary>
        COP,
        
        /// <summary>
        /// Unidad de Valor Real
        /// </summary>
        COU,
        
        /// <summary>
        /// Costa Rican Colon
        /// </summary>
        CRC,
        
        /// <summary>
        /// Peso Convertible
        /// </summary>
        CUC,
        
        /// <summary>
        /// Cuban Peso
        /// </summary>
        CUP,
        
        /// <summary>
        /// Cabo Verde Escudo
        /// </summary>
        CVE,
        
        /// <summary>
        /// Czech Koruna
        /// </summary>
        CZK,
        
        /// <summary>
        /// Djibouti Franc
        /// </summary>
        DJF,
        
        /// <summary>
        /// Danish Krone
        /// </summary>
        DKK,
        
        /// <summary>
        /// Dominican Peso
        /// </summary>
        DOP,
        
        /// <summary>
        /// Algerian Dinar
        /// </summary>
        DZD,
        
        /// <summary>
        /// Egyptian Pound
        /// </summary>
        EGP,
        
        /// <summary>
        /// Nakfa
        /// </summary>
        ERN,
        
        /// <summary>
        /// Ethiopian Birr
        /// </summary>
        ETB,
        
        /// <summary>
        /// Euro
        /// </summary>
        EUR,
        
        /// <summary>
        /// Fiji Dollar
        /// </summary>
        FJD,
        
        /// <summary>
        /// Falkland Islands Pound
        /// </summary>
        FKP,
        
        /// <summary>
        /// Pound Sterling
        /// </summary>
        GBP,
        
        /// <summary>
        /// Lari
        /// </summary>
        GEL,
        
        /// <summary>
        /// Ghana Cedi
        /// </summary>
        GHS,
        
        /// <summary>
        /// Gibraltar Pound
        /// </summary>
        GIP,
        
        /// <summary>
        /// Dalasi
        /// </summary>
        GMD,
        
        /// <summary>
        /// Guinean Franc
        /// </summary>
        GNF,
        
        /// <summary>
        /// Quetzal
        /// </summary>
        GTQ,
        
        /// <summary>
        /// Guyana Dollar
        /// </summary>
        GYD,
        
        /// <summary>
        /// Hong Kong Dollar
        /// </summary>
        HKD,
        
        /// <summary>
        /// Lempira
        /// </summary>
        HNL,
        
        /// <summary>
        /// Gourde
        /// </summary>
        HTG,
        
        /// <summary>
        /// Forint
        /// </summary>
        HUF,
        
        /// <summary>
        /// Rupiah
        /// </summary>
        IDR,
        
        /// <summary>
        /// New Israeli Sheqel
        /// </summary>
        ILS,
        
        /// <summary>
        /// Indian Rupee
        /// </summary>
        INR,
        
        /// <summary>
        /// Iraqi Dinar
        /// </summary>
        IQD,
        
        /// <summary>
        /// Iranian Rial
        /// </summary>
        IRR,
        
        /// <summary>
        /// Iceland Krona
        /// </summary>
        ISK,
        
        /// <summary>
        /// Jamaican Dollar
        /// </summary>
        JMD,
        
        /// <summary>
        /// Jordanian Dinar
        /// </summary>
        JOD,
        
        /// <summary>
        /// Yen
        /// </summary>
        JPY,
        
        /// <summary>
        /// Kenyan Shilling
        /// </summary>
        KES,
        
        /// <summary>
        /// Som
        /// </summary>
        KGS,
        
        /// <summary>
        /// Riel
        /// </summary>
        KHR,
        
        /// <summary>
        /// Comorian Franc 
        /// </summary>
        KMF,
        
        /// <summary>
        /// North Korean Won
        /// </summary>
        KPW,
        
        /// <summary>
        /// Won
        /// </summary>
        KRW,
        
        /// <summary>
        /// Kuwaiti Dinar
        /// </summary>
        KWD,
        
        /// <summary>
        /// Cayman Islands Dollar
        /// </summary>
        KYD,
        
        /// <summary>
        /// Tenge
        /// </summary>
        KZT,
        
        /// <summary>
        /// Lao Kip
        /// </summary>
        LAK,
        
        /// <summary>
        /// Lebanese Pound
        /// </summary>
        LBP,
        
        /// <summary>
        /// Sri Lanka Rupee
        /// </summary>
        LKR,
        
        /// <summary>
        /// Liberian Dollar
        /// </summary>
        LRD,
        
        /// <summary>
        /// Loti
        /// </summary>
        LSL,
        
        /// <summary>
        /// Libyan Dinar
        /// </summary>
        LYD,
        
        /// <summary>
        /// Moroccan Dirham
        /// </summary>
        MAD,
        
        /// <summary>
        /// Moldovan Leu
        /// </summary>
        MDL,
        
        /// <summary>
        /// Malagasy Ariary
        /// </summary>
        MGA,
        
        /// <summary>
        /// Denar
        /// </summary>
        MKD,
        
        /// <summary>
        /// Kyat
        /// </summary>
        MMK,
        
        /// <summary>
        /// Tugrik
        /// </summary>
        MNT,
        
        /// <summary>
        /// Pataca
        /// </summary>
        MOP,
        
        /// <summary>
        /// Ouguiya
        /// </summary>
        MRU,
        
        /// <summary>
        /// Mauritius Rupee
        /// </summary>
        MUR,
        
        /// <summary>
        /// Rufiyaa
        /// </summary>
        MVR,
        
        /// <summary>
        /// Malawi Kwacha
        /// </summary>
        MWK,
        
        /// <summary>
        /// Mexican Peso
        /// </summary>
        MXN,
        
        /// <summary>
        /// Mexican Unidad de Inversion (UDI)
        /// </summary>
        MXV,
        
        /// <summary>
        /// Malaysian Ringgit
        /// </summary>
        MYR,
        
        /// <summary>
        /// Mozambique Metical
        /// </summary>
        MZN,
        
        /// <summary>
        /// Namibia Dollar
        /// </summary>
        NAD,
        
        /// <summary>
        /// Naira
        /// </summary>
        NGN,
        
        /// <summary>
        /// Cordoba Oro
        /// </summary>
        NIO,
        
        /// <summary>
        /// Norwegian Krone
        /// </summary>
        NOK,
        
        /// <summary>
        /// Nepalese Rupee
        /// </summary>
        NPR,
        
        /// <summary>
        /// New Zealand Dollar
        /// </summary>
        NZD,
        
        /// <summary>
        /// Rial Omani
        /// </summary>
        OMR,
        
        /// <summary>
        /// Balboa
        /// </summary>
        PAB,
        
        /// <summary>
        /// Sol
        /// </summary>
        PEN,
        
        /// <summary>
        /// Kina
        /// </summary>
        PGK,
        
        /// <summary>
        /// Philippine Peso
        /// </summary>
        PHP,
        
        /// <summary>
        /// Pakistan Rupee
        /// </summary>
        PKR,
        
        /// <summary>
        /// Zloty
        /// </summary>
        PLN,
        
        /// <summary>
        /// Guarani
        /// </summary>
        PYG,
        
        /// <summary>
        /// Qatari Rial
        /// </summary>
        QAR,
        
        /// <summary>
        /// Romanian Leu
        /// </summary>
        RON,
        
        /// <summary>
        /// Serbian Dinar
        /// </summary>
        RSD,
        
        /// <summary>
        /// Russian Ruble
        /// </summary>
        RUB,
        
        /// <summary>
        /// Rwanda Franc
        /// </summary>
        RWF,
        
        /// <summary>
        /// Saudi Riyal
        /// </summary>
        SAR,
        
        /// <summary>
        /// Solomon Islands Dollar
        /// </summary>
        SBD,
        
        /// <summary>
        /// Seychelles Rupee
        /// </summary>
        SCR,
        
        /// <summary>
        /// Sudanese Pound
        /// </summary>
        SDG,
        
        /// <summary>
        /// Swedish Krona
        /// </summary>
        SEK,
        
        /// <summary>
        /// Singapore Dollar
        /// </summary>
        SGD,
        
        /// <summary>
        /// Saint Helena Pound
        /// </summary>
        SHP,
        
        /// <summary>
        /// Leone
        /// </summary>
        SLE,
        
        /// <summary>
        /// Somali Shilling
        /// </summary>
        SOS,
        
        /// <summary>
        /// Surinam Dollar
        /// </summary>
        SRD,
        
        /// <summary>
        /// South Sudanese Pound
        /// </summary>
        SSP,
        
        /// <summary>
        /// Dobra
        /// </summary>
        STN,
        
        /// <summary>
        /// El Salvador Colon
        /// </summary>
        SVC,
        
        /// <summary>
        /// Syrian Pound
        /// </summary>
        SYP,
        
        /// <summary>
        /// Lilangeni
        /// </summary>
        SZL,
        
        /// <summary>
        /// Baht
        /// </summary>
        THB,
        
        /// <summary>
        /// Somoni
        /// </summary>
        TJS,
        
        /// <summary>
        /// Turkmenistan New Manat
        /// </summary>
        TMT,
        
        /// <summary>
        /// Tunisian Dinar
        /// </summary>
        TND,
        
        /// <summary>
        /// Pa’anga
        /// </summary>
        TOP,
        
        /// <summary>
        /// Turkish Lira
        /// </summary>
        TRY,
        
        /// <summary>
        /// Trinidad and Tobago Dollar
        /// </summary>
        TTD,
        
        /// <summary>
        /// New Taiwan Dollar
        /// </summary>
        TWD,
        
        /// <summary>
        /// Tanzanian Shilling
        /// </summary>
        TZS,
        
        /// <summary>
        /// Hryvnia
        /// </summary>
        UAH,
        
        /// <summary>
        /// Uganda Shilling
        /// </summary>
        UGX,
        
        /// <summary>
        /// US Dollar
        /// </summary>
        USD,
        
        /// <summary>
        /// US Dollar (Next day)
        /// </summary>
        USN,
        
        /// <summary>
        /// Uruguay Peso en Unidades Indexadas (UI)
        /// </summary>
        UYI,
        
        /// <summary>
        /// Peso Uruguayo
        /// </summary>
        UYU,
        
        /// <summary>
        /// Unidad Previsional
        /// </summary>
        UYW,
        
        /// <summary>
        /// Uzbekistan Sum
        /// </summary>
        UZS,
        
        /// <summary>
        /// Bolívar Soberano
        /// </summary>
        VED,
        
        /// <summary>
        /// Bolívar Soberano
        /// </summary>
        VES,
        
        /// <summary>
        /// Dong
        /// </summary>
        VND,
        
        /// <summary>
        /// Vatu
        /// </summary>
        VUV,
        
        /// <summary>
        /// Tala
        /// </summary>
        WST,
        
        /// <summary>
        /// CFA Franc BEAC
        /// </summary>
        XAF,
        
        /// <summary>
        /// Silver
        /// </summary>
        XAG,
        
        /// <summary>
        /// Gold
        /// </summary>
        XAU,
        
        /// <summary>
        /// Bond Markets Unit European Composite Unit (EURCO)
        /// </summary>
        XBA,
        
        /// <summary>
        /// Bond Markets Unit European Monetary Unit (E.M.U.-6)
        /// </summary>
        XBB,
        
        /// <summary>
        /// Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
        /// </summary>
        XBC,
        
        /// <summary>
        /// Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
        /// </summary>
        XBD,
        
        /// <summary>
        /// East Caribbean Dollar
        /// </summary>
        XCD,
        
        /// <summary>
        /// SDR (Special Drawing Right)
        /// </summary>
        XDR,
        
        /// <summary>
        /// CFA Franc BCEAO
        /// </summary>
        XOF,
        
        /// <summary>
        /// Palladium
        /// </summary>
        XPD,
        
        /// <summary>
        /// CFP Franc
        /// </summary>
        XPF,
        
        /// <summary>
        /// Platinum
        /// </summary>
        XPT,
        
        /// <summary>
        /// Sucre
        /// </summary>
        XSU,
        
        /// <summary>
        /// Codes specifically reserved for testing purposes
        /// </summary>
        XTS,
        
        /// <summary>
        /// ADB Unit of Account
        /// </summary>
        XUA,
        
        /// <summary>
        /// The codes assigned for transactions where no currency is involved
        /// </summary>
        XXX,
        
        /// <summary>
        /// Yemeni Rial
        /// </summary>
        YER,
        
        /// <summary>
        /// Rand
        /// </summary>
        ZAR,
        
        /// <summary>
        /// Zambian Kwacha
        /// </summary>
        ZMW,
        
        /// <summary>
        /// Zimbabwe Gold
        /// </summary>
        ZWG
    }
    
    /// <summary>
    /// The enumerated values to specify the CDX index annex source.
    /// </summary>
    [CdmName("IndexAnnexSourceEnum")]
    public enum IndexAnnexSource
    {
        /// <summary>
        /// As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
        /// </summary>
        [EnumMember(Value = "MASTER_CONFIRMATION")]
        MasterConfirmation,
        
        /// <summary>
        /// As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
        /// </summary>
        [EnumMember(Value = "PUBLISHER")]
        Publisher
    }
    
    /// <summary>
    /// The enumerated values to specify the consequences of Index Events.
    /// </summary>
    [CdmName("IndexEventConsequenceEnum")]
    public enum IndexEventConsequence
    {
        /// <summary>
        /// Calculation Agent Adjustment.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT_ADJUSTMENT")]
        CalculationAgentAdjustment,
        
        /// <summary>
        /// Cancellation and Payment.
        /// </summary>
        [EnumMember(Value = "CANCELLATION_AND_PAYMENT")]
        CancellationAndPayment,
        
        /// <summary>
        /// Negotiated Close Out.
        /// </summary>
        [EnumMember(Value = "NEGOTIATED_CLOSE_OUT")]
        NegotiatedCloseOut,
        
        /// <summary>
        /// Related Exchange.
        /// </summary>
        [EnumMember(Value = "RELATED_EXCHANGE")]
        RelatedExchange
    }
    
    /// <summary>
    /// Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
    /// </summary>
    [CdmName("InflationCalculationMethodEnum")]
    public enum InflationCalculationMethod
    {
        /// <summary>
        /// (Inflation Index Final / Inflation Index Base). Inflation Index Final is inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interpolation). Inflation Index Base subject to the Calculation Style. Used in inflation asset swaps to calculate the inflation coupons and principal exchange.
        /// </summary>
        [EnumMember(Value = "RATIO")]
        Ratio,
        
        /// <summary>
        /// (Inflation Index Final / Inflation Index Base -1). Inflation Index Final is the inflation index for Reference Month that is the Lag number of months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Used in market standard ZC Inflation swaps.
        /// </summary>
        [EnumMember(Value = "RETURN")]
        Return,
        
        /// <summary>
        /// Inflation Index Final - Inflation Index Base). Inflation Index Final is Index for Ref month the Lag months prior to Payment Date (subject to interp). Inflation Index Base subject to the Calculation Style. Typically used for fixing locks.
        /// </summary>
        [EnumMember(Value = "SPREAD")]
        Spread
    }
    
    /// <summary>
    /// Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
    /// </summary>
    [CdmName("InflationCalculationStyleEnum")]
    public enum InflationCalculationStyle
    {
        /// <summary>
        /// YearOnYear means Inflation Index Base is the inflation index for Reference Month that is 12 months prior to Inflation Index Final (subject to interpolation). Inflation Index Base is cashflow dependent.
        /// </summary>
        [EnumMember(Value = "YEAR_ON_YEAR")]
        YearOnYear,
        
        /// <summary>
        /// ZeroCoupon means Inflation Index Base used in the CalculationMethod is the inflation index for the Reference Month that is the lag number of months prior to Effective Date in the case of a swap, or Bond Interest Accrual Date in the case of an Asset Swap (subject to interpolation). Inflation Index Base has the same value for each inflation cashflow and Principal Exchange calculation within the trade.
        /// </summary>
        [EnumMember(Value = "ZERO_COUPON")]
        ZeroCoupon
    }
    
    /// <summary>
    /// The enumerated values to specify the list of inflation rate indices.
    /// </summary>
    [CdmName("InflationRateIndexEnum")]
    public enum InflationRateIndex
    {
        /// <summary>
        /// Australia: AUD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "AUD-CPI")]
        AUD_CPI,
        
        /// <summary>
        /// Austria: AUS - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "AUS-CPI")]
        AUS_CPI,
        
        /// <summary>
        /// Austria: AUS - Non-revised Harmonised Indices of Consumer Prices (HICP)
        /// </summary>
        [EnumMember(Value = "AUS-HICP")]
        AUS_HICP,
        
        /// <summary>
        /// Belgium: BLG - Non-revised Consumer Price Index - General Index (CPI)
        /// </summary>
        [EnumMember(Value = "BLG-CPI-GI")]
        BLG_CPI_GI,
        
        /// <summary>
        /// Belgium: BLG - Non-revised Consumer Price Index - Health Index (CPI)
        /// </summary>
        [EnumMember(Value = "BLG-CPI-HI")]
        BLG_CPI_HI,
        
        /// <summary>
        /// Belgium: BLG - Non-revised Harmonised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "BLG-HICP")]
        BLG_HICP,
        
        /// <summary>
        /// Brazil: BRL - Non-revised Price Index (IGP-M)
        /// </summary>
        [EnumMember(Value = "BRL-IGPM")]
        BRL_IGPM,
        
        /// <summary>
        /// Brazil: BRL - Non-revised Consumer Price Index (IPCA)
        /// </summary>
        [EnumMember(Value = "BRL-IPCA")]
        BRL_IPCA,
        
        /// <summary>
        /// Canada: CAD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "CAD-CPI")]
        CAD_CPI,
        
        /// <summary>
        /// Chile: CLP - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "CLP-CPI")]
        CLP_CPI,
        
        /// <summary>
        /// China: CNY - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "CNY-CPI")]
        CNY_CPI,
        
        /// <summary>
        /// Czech Republic: CZK - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "CZK-CPI")]
        CZK_CPI,
        
        /// <summary>
        /// Denmark: DEK - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "DEK-CPI")]
        DEK_CPI,
        
        /// <summary>
        /// Denmark: DEK - Non-revised Harmonised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "DEK-HICP")]
        DEK_HICP,
        
        /// <summary>
        /// Germany: DEM - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "DEM-CPI")]
        DEM_CPI,
        
        /// <summary>
        /// Germany: DEM - Non-revised Consumer Price Index for North Rhine-Westphalia
        /// </summary>
        [EnumMember(Value = "DEM-CPI-NRW")]
        DEM_CPI_NRW,
        
        /// <summary>
        /// Germany: DEM - Non-revised Harmonised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "DEM-HICP")]
        DEM_HICP,
        
        /// <summary>
        /// Spain: ESP - National-Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "ESP-CPI")]
        ESP_CPI,
        
        /// <summary>
        /// Spain: ESP - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "ESP-HICP")]
        ESP_HICP,
        
        /// <summary>
        /// Spain: ESP - National-Revised Consumer Price Index (CPI).
        /// </summary>
        [EnumMember(Value = "ESP-R-CPI")]
        ESP_R_CPI,
        
        /// <summary>
        /// Spain: ESP - Harmonised-Revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "ESP-R-HICP")]
        ESP_R_HICP,
        
        /// <summary>
        /// European Union: EUR - All Items-Non-revised Consumer Price Index
        /// </summary>
        [EnumMember(Value = "EUR-AI-CPI")]
        EUR_AI_CPI,
        
        /// <summary>
        /// European Union: EUR - All Items-Revised Consumer Price Index
        /// </summary>
        [EnumMember(Value = "EUR-AI-R-CPI")]
        EUR_AI_R_CPI,
        
        /// <summary>
        /// European Union: EUR - Excluding Tobacco-Non-revised Consumer Price Index
        /// </summary>
        [EnumMember(Value = "EUR-EXT-CPI")]
        EUR_EXT_CPI,
        
        /// <summary>
        /// European Union: EUR - Excluding Tobacco-Revised Consumer Price Index
        /// </summary>
        [EnumMember(Value = "EUR-EXT-R-CPI")]
        EUR_EXT_R_CPI,
        
        /// <summary>
        /// Finland: FIN - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "FIN-CPI")]
        FIN_CPI,
        
        /// <summary>
        /// Finland: FIN - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "FIN-HICP")]
        FIN_HICP,
        
        /// <summary>
        /// France: FRC - Excluding Tobacco-Non-Revised Consumer Price Index
        /// </summary>
        [EnumMember(Value = "FRC-EXT-CPI")]
        FRC_EXT_CPI,
        
        /// <summary>
        /// France: FRC - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "FRC-HICP")]
        FRC_HICP,
        
        /// <summary>
        /// Greece: GRD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "GRD-CPI")]
        GRD_CPI,
        
        /// <summary>
        /// Greece: GRD - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "GRD-HICP")]
        GRD_HICP,
        
        /// <summary>
        /// Hong Kong: HKD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "HKD-CPI")]
        HKD_CPI,
        
        /// <summary>
        /// Hungary: HUF - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "HUF-CPI")]
        HUF_CPI,
        
        /// <summary>
        /// Indonesia: IDR - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "IDR-CPI")]
        IDR_CPI,
        
        /// <summary>
        /// Israel: ILS - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "ILS-CPI")]
        ILS_CPI,
        
        /// <summary>
        /// Ireland: IRL - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "IRL-CPI")]
        IRL_CPI,
        
        /// <summary>
        /// Ireland: IRL - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "IRL-HICP")]
        IRL_HICP,
        
        /// <summary>
        /// Iceland: ISK - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "ISK-CPI")]
        ISK_CPI,
        
        /// <summary>
        /// Iceland: ISK - Harmonised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "ISK-HICP")]
        ISK_HICP,
        
        /// <summary>
        /// Italy: ITL - Inflation for Blue Collar Workers and Employees-Excluding Tobacco Consumer Price Index
        /// </summary>
        [EnumMember(Value = "ITL-BC-EXT-CPI")]
        ITL_BC_EXT_CPI,
        
        /// <summary>
        /// Italy: ITL - Inflation for Blue Collar Workers and Employees-Including Tobacco Consumer Price Index
        /// </summary>
        [EnumMember(Value = "ITL-BC-INT-CPI")]
        ITL_BC_INT_CPI,
        
        /// <summary>
        /// Italy: ITL - Non-revised Harmonised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "ITL-HICP")]
        ITL_HICP,
        
        /// <summary>
        /// Italy: ITL - Whole Community - Excluding Tobacco Consumer Price Index
        /// </summary>
        [EnumMember(Value = "ITL-WC-EXT-CPI")]
        ITL_WC_EXT_CPI,
        
        /// <summary>
        /// Italy: ITL - Whole Community - Including Tobacco Consumer Price Index
        /// </summary>
        [EnumMember(Value = "ITL-WC-INT-CPI")]
        ITL_WC_INT_CPI,
        
        /// <summary>
        /// Japan: JPY - Non-revised Consumer Price Index Nationwide General Excluding Fresh Food (CPI)
        /// </summary>
        [EnumMember(Value = "JPY-CPI-EXF")]
        JPY_CPI_EXF,
        
        /// <summary>
        /// South Korea: KRW - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "KRW-CPI")]
        KRW_CPI,
        
        /// <summary>
        /// Luxembourg: LUX - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "LUX-CPI")]
        LUX_CPI,
        
        /// <summary>
        /// Luxembourg: LUX - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "LUX-HICP")]
        LUX_HICP,
        
        /// <summary>
        /// Mexico: MXN - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "MXN-CPI")]
        MXN_CPI,
        
        /// <summary>
        /// Mexico: MXN - Unidad de Inversion Index (UDI)
        /// </summary>
        [EnumMember(Value = "MXN-UDI")]
        MXN_UDI,
        
        /// <summary>
        /// Malaysia: MYR - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "MYR-CPI")]
        MYR_CPI,
        
        /// <summary>
        /// Netherlands: NLG - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "NLG-CPI")]
        NLG_CPI,
        
        /// <summary>
        /// Netherlands: NLG - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "NLG-HICP")]
        NLG_HICP,
        
        /// <summary>
        /// Norway: NOK - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "NOK-CPI")]
        NOK_CPI,
        
        /// <summary>
        /// New Zealand: NZD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "NZD-CPI")]
        NZD_CPI,
        
        /// <summary>
        /// Peru: PER - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "PER-CPI")]
        PER_CPI,
        
        /// <summary>
        /// Poland: PLN - Non-Revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "PLN-CPI")]
        PLN_CPI,
        
        /// <summary>
        /// Portugal: POR - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "POR-CPI")]
        POR_CPI,
        
        /// <summary>
        /// Portugal: POR - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "POR-HICP")]
        POR_HICP,
        
        /// <summary>
        /// Russia: RUB - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "RUB-CPI")]
        RUB_CPI,
        
        /// <summary>
        /// Sweden: SEK - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "SEK-CPI")]
        SEK_CPI,
        
        /// <summary>
        /// Singapore: SGD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "SGD-CPI")]
        SGD_CPI,
        
        /// <summary>
        /// Switzerland: SWF - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "SWF-CPI")]
        SWF_CPI,
        
        /// <summary>
        /// Turkey: TRY - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "TRY-CPI")]
        TRY_CPI,
        
        /// <summary>
        /// Taiwan: TWD - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "TWD-CPI")]
        TWD_CPI,
        
        /// <summary>
        /// United Kingdom: GBP - Non-revised Consumer Prices Index including Housing (UKCPIH)
        /// </summary>
        [EnumMember(Value = "UK-CPIH")]
        UK_CPIH,
        
        /// <summary>
        /// United Kingdom: GBP - Harmonised-Non-revised Consumer Price Index (HICP)
        /// </summary>
        [EnumMember(Value = "UK-HICP")]
        UK_HICP,
        
        /// <summary>
        /// United Kingdom: GBP - Non-revised Retail Price Index (UKRPI)
        /// </summary>
        [EnumMember(Value = "UK-RPI")]
        UK_RPI,
        
        /// <summary>
        /// United Kingdom: GBP - Non-revised Retail Price Index Excluding Mortgage Interest Payments (UKRPIX)
        /// </summary>
        [EnumMember(Value = "UK-RPIX")]
        UK_RPIX,
        
        /// <summary>
        /// United States: USA - Non-revised Consumer Price Index - Urban (CPI-U)
        /// </summary>
        [EnumMember(Value = "USA-CPI-U")]
        USA_CPI_U,
        
        /// <summary>
        /// South Africa: ZAR - Non-revised Consumer Price Index (CPI)
        /// </summary>
        [EnumMember(Value = "ZAR-CPI")]
        ZAR_CPI,
        
        /// <summary>
        /// South Africa: ZAR - Non-revised Consumer Price Index Excluding Mortgages (CPIX)
        /// </summary>
        [EnumMember(Value = "ZAR-CPIX")]
        ZAR_CPIX
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this InflationRateIndex value)
        {
            return value switch
            {
                InflationRateIndex.AUD_CPI => "AUD-CPI",
                InflationRateIndex.AUS_CPI => "AUS-CPI",
                InflationRateIndex.AUS_HICP => "AUS-HICP",
                InflationRateIndex.BLG_CPI_GI => "BLG-CPI-GI",
                InflationRateIndex.BLG_CPI_HI => "BLG-CPI-HI",
                InflationRateIndex.BLG_HICP => "BLG-HICP",
                InflationRateIndex.BRL_IGPM => "BRL-IGPM",
                InflationRateIndex.BRL_IPCA => "BRL-IPCA",
                InflationRateIndex.CAD_CPI => "CAD-CPI",
                InflationRateIndex.CLP_CPI => "CLP-CPI",
                InflationRateIndex.CNY_CPI => "CNY-CPI",
                InflationRateIndex.CZK_CPI => "CZK-CPI",
                InflationRateIndex.DEK_CPI => "DEK-CPI",
                InflationRateIndex.DEK_HICP => "DEK-HICP",
                InflationRateIndex.DEM_CPI => "DEM-CPI",
                InflationRateIndex.DEM_CPI_NRW => "DEM-CPI-NRW",
                InflationRateIndex.DEM_HICP => "DEM-HICP",
                InflationRateIndex.ESP_CPI => "ESP-CPI",
                InflationRateIndex.ESP_HICP => "ESP-HICP",
                InflationRateIndex.ESP_R_CPI => "ESP-R-CPI",
                InflationRateIndex.ESP_R_HICP => "ESP-R-HICP",
                InflationRateIndex.EUR_AI_CPI => "EUR-AI-CPI",
                InflationRateIndex.EUR_AI_R_CPI => "EUR-AI-R-CPI",
                InflationRateIndex.EUR_EXT_CPI => "EUR-EXT-CPI",
                InflationRateIndex.EUR_EXT_R_CPI => "EUR-EXT-R-CPI",
                InflationRateIndex.FIN_CPI => "FIN-CPI",
                InflationRateIndex.FIN_HICP => "FIN-HICP",
                InflationRateIndex.FRC_EXT_CPI => "FRC-EXT-CPI",
                InflationRateIndex.FRC_HICP => "FRC-HICP",
                InflationRateIndex.GRD_CPI => "GRD-CPI",
                InflationRateIndex.GRD_HICP => "GRD-HICP",
                InflationRateIndex.HKD_CPI => "HKD-CPI",
                InflationRateIndex.HUF_CPI => "HUF-CPI",
                InflationRateIndex.IDR_CPI => "IDR-CPI",
                InflationRateIndex.ILS_CPI => "ILS-CPI",
                InflationRateIndex.IRL_CPI => "IRL-CPI",
                InflationRateIndex.IRL_HICP => "IRL-HICP",
                InflationRateIndex.ISK_CPI => "ISK-CPI",
                InflationRateIndex.ISK_HICP => "ISK-HICP",
                InflationRateIndex.ITL_BC_EXT_CPI => "ITL-BC-EXT-CPI",
                InflationRateIndex.ITL_BC_INT_CPI => "ITL-BC-INT-CPI",
                InflationRateIndex.ITL_HICP => "ITL-HICP",
                InflationRateIndex.ITL_WC_EXT_CPI => "ITL-WC-EXT-CPI",
                InflationRateIndex.ITL_WC_INT_CPI => "ITL-WC-INT-CPI",
                InflationRateIndex.JPY_CPI_EXF => "JPY-CPI-EXF",
                InflationRateIndex.KRW_CPI => "KRW-CPI",
                InflationRateIndex.LUX_CPI => "LUX-CPI",
                InflationRateIndex.LUX_HICP => "LUX-HICP",
                InflationRateIndex.MXN_CPI => "MXN-CPI",
                InflationRateIndex.MXN_UDI => "MXN-UDI",
                InflationRateIndex.MYR_CPI => "MYR-CPI",
                InflationRateIndex.NLG_CPI => "NLG-CPI",
                InflationRateIndex.NLG_HICP => "NLG-HICP",
                InflationRateIndex.NOK_CPI => "NOK-CPI",
                InflationRateIndex.NZD_CPI => "NZD-CPI",
                InflationRateIndex.PER_CPI => "PER-CPI",
                InflationRateIndex.PLN_CPI => "PLN-CPI",
                InflationRateIndex.POR_CPI => "POR-CPI",
                InflationRateIndex.POR_HICP => "POR-HICP",
                InflationRateIndex.RUB_CPI => "RUB-CPI",
                InflationRateIndex.SEK_CPI => "SEK-CPI",
                InflationRateIndex.SGD_CPI => "SGD-CPI",
                InflationRateIndex.SWF_CPI => "SWF-CPI",
                InflationRateIndex.TRY_CPI => "TRY-CPI",
                InflationRateIndex.TWD_CPI => "TWD-CPI",
                InflationRateIndex.UK_CPIH => "UK-CPIH",
                InflationRateIndex.UK_HICP => "UK-HICP",
                InflationRateIndex.UK_RPI => "UK-RPI",
                InflationRateIndex.UK_RPIX => "UK-RPIX",
                InflationRateIndex.USA_CPI_U => "USA-CPI-U",
                InflationRateIndex.ZAR_CPI => "ZAR-CPI",
                InflationRateIndex.ZAR_CPIX => "ZAR-CPIX",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumerated values to specify the list of information providers.
    /// </summary>
    [CdmName("InformationProviderEnum")]
    public enum InformationProvider
    {
        /// <summary>
        /// The Association of Banks in Singapore.
        /// </summary>
        [EnumMember(Value = "ASSOC_BANKS_SINGAPORE")]
        AssocBanksSingapore,
        
        /// <summary>
        /// The central bank of Chile.
        /// </summary>
        [EnumMember(Value = "BANCO_CENTRAL_CHILE")]
        BancoCentralChile,
        
        /// <summary>
        /// The central bank of Canada.
        /// </summary>
        [EnumMember(Value = "BANK_OF_CANADA")]
        BankOfCanada,
        
        /// <summary>
        /// The Bank Of England.
        /// </summary>
        [EnumMember(Value = "BANK_OF_ENGLAND")]
        BankOfEngland,
        
        /// <summary>
        /// The central bank of Japan.
        /// </summary>
        [EnumMember(Value = "BANK_OF_JAPAN")]
        BankOfJapan,
        
        /// <summary>
        /// Bloomberg LP.
        /// </summary>
        [EnumMember(Value = "BLOOMBERG")]
        Bloomberg,
        
        /// <summary>
        /// The European Central Bank.
        /// </summary>
        [EnumMember(Value = "EURO_CENTRAL_BANK")]
        EuroCentralBank,
        
        /// <summary>
        /// The Federal Home Loan Bank of San Francisco, or its successor.
        /// </summary>
        FHLBSF,
        
        /// <summary>
        /// The Federal Reserve, the central bank of the United States.
        /// </summary>
        [EnumMember(Value = "FEDERAL_RESERVE")]
        FederalReserve,
        
        /// <summary>
        /// ICESWAP Rate Administrator which means ICE Benchmark Administration, or any successor thereto, as administrator of the ICE Swap Rate.
        /// </summary>
        ICESWAP,
        
        /// <summary>
        /// International Swaps and Derivatives Association, Inc.
        /// </summary>
        ISDA,
        
        /// <summary>
        /// Refinitiv, formerly Thomson Reuters Financial &amp; Risk.
        /// </summary>
        [EnumMember(Value = "REFINITIV")]
        Refinitiv,
        
        /// <summary>
        /// The Reserve Bank of Australia.
        /// </summary>
        [EnumMember(Value = "RESERVE_BANK_AUSTRALIA")]
        ReserveBankAustralia,
        
        /// <summary>
        /// The Reserve Bank of New Zealand.
        /// </summary>
        [EnumMember(Value = "RESERVE_BANK_NEW_ZEALAND")]
        ReserveBankNewZealand,
        
        /// <summary>
        /// Reuters Group Plc.
        /// </summary>
        [EnumMember(Value = "REUTERS")]
        Reuters,
        
        /// <summary>
        /// South African Futures Exchange, or its successor.
        /// </summary>
        SAFEX,
        
        /// <summary>
        /// The Tokyo Swap Reference Rate (or TSR) Administrator, which means Refinitiv Asia Pacific Limited, or any successor thereto, as administrator of the TSR.
        /// </summary>
        TOKYOSWAP,
        
        /// <summary>
        /// Telerate, Inc.
        /// </summary>
        [EnumMember(Value = "TELERATE")]
        Telerate
    }
    
    /// <summary>
    /// The enumeration values indicating the BusinessEvent function associated input instructions.
    /// </summary>
    [CdmName("InstructionFunctionEnum")]
    public enum InstructionFunction
    {
        [EnumMember(Value = "COMPRESSION")]
        Compression,
        
        [EnumMember(Value = "CONTRACT_FORMATION")]
        ContractFormation,
        
        [EnumMember(Value = "EXECUTION")]
        Execution,
        
        [EnumMember(Value = "QUANTITY_CHANGE")]
        QuantityChange,
        
        [EnumMember(Value = "RENEGOTIATION")]
        Renegotiation
    }
    
    /// <summary>
    /// Represents an enumeration list to indentify the type of an instrument.
    /// </summary>
    [CdmName("InstrumentTypeEnum")]
    public enum InstrumentType
    {
        /// <summary>
        /// Identifies an instrument as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
        /// </summary>
        [EnumMember(Value = "CERTIFICATE")]
        Certificate,
        
        /// <summary>
        /// Identifies an instrument as a fixed income instrument of debt issued and securitized as a tradable asset.
        /// </summary>
        [EnumMember(Value = "DEBT")]
        Debt,
        
        /// <summary>
        /// Identifies an instrument as an Equity value of holding of shares in listed company.
        /// </summary>
        [EnumMember(Value = "EQUITY")]
        Equity,
        
        /// <summary>
        /// Identifies an instrument as representing holding in an investment fund.
        /// </summary>
        [EnumMember(Value = "FUND")]
        Fund,
        
        /// <summary>
        /// Identifies an instrument as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
        /// </summary>
        [EnumMember(Value = "LETTER_OF_CREDIT")]
        LetterOfCredit,
        
        /// <summary>
        /// Identifies an instrument as a listed derivative on an exchange.
        /// </summary>
        [EnumMember(Value = "LISTED_DERIVATIVE")]
        ListedDerivative,
        
        /// <summary>
        /// Identifies an instrument as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
        /// </summary>
        [EnumMember(Value = "WARRANT")]
        Warrant
    }
    
    /// <summary>
    /// The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives.
    /// </summary>
    [CdmName("InterestShortfallCapEnum")]
    public enum InterestShortfallCap
    {
        [EnumMember(Value = "FIXED")]
        Fixed,
        
        [EnumMember(Value = "VARIABLE")]
        Variable
    }
    
    /// <summary>
    /// The enumerated values to specify the interpolation method, e.g. linear.
    /// </summary>
    [CdmName("InterpolationMethodEnum")]
    public enum InterpolationMethod
    {
        /// <summary>
        /// Linear Interpolation applicable.
        /// </summary>
        [EnumMember(Value = "LINEAR")]
        Linear,
        
        /// <summary>
        /// Linear Interpolation applicable.
        /// </summary>
        [EnumMember(Value = "LINEAR_ZERO_YIELD")]
        LinearZeroYield,
        
        /// <summary>
        /// No Interpolation applicable.
        /// </summary>
        [EnumMember(Value = "NONE")]
        None
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the type of entity issuing the asset.
    /// </summary>
    [CdmName("IssuerTypeEnum")]
    public enum IssuerType
    {
        /// <summary>
        /// Specifies debt issued Securities by corporate bodies including Banks.
        /// </summary>
        [EnumMember(Value = "CORPORATE")]
        Corporate,
        
        /// <summary>
        /// Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
        /// </summary>
        [EnumMember(Value = "FUND")]
        Fund,
        
        /// <summary>
        /// Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
        /// </summary>
        [EnumMember(Value = "QUASI_GOVERNMENT")]
        QuasiGovernment,
        
        /// <summary>
        /// Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities.
        /// </summary>
        [EnumMember(Value = "REGIONAL_GOVERNMENT")]
        RegionalGovernment,
        
        /// <summary>
        /// Specifies Sovereign, Government Debt Securities including Central Banks.
        /// </summary>
        [EnumMember(Value = "SOVEREIGN_CENTRAL_BANK")]
        SovereignCentralBank,
        
        /// <summary>
        /// Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations.
        /// </summary>
        [EnumMember(Value = "SPECIAL_PURPOSE_VEHICLE")]
        SpecialPurposeVehicle,
        
        /// <summary>
        /// Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks.
        /// </summary>
        [EnumMember(Value = "SUPRA_NATIONAL")]
        SupraNational
    }
    
    /// <summary>
    /// The enumerated values to specify the legal agreement publisher.
    /// </summary>
    [CdmName("LegalAgreementPublisherEnum")]
    public enum LegalAgreementPublisher
    {
        /// <summary>
        /// Association Française des Banques.
        /// </summary>
        AFB,
        
        /// <summary>
        /// BNY Mellon
        /// </summary>
        BNYM,
        
        /// <summary>
        /// Emerging Markets Traders Association
        /// </summary>
        EMTA,
        
        /// <summary>
        /// International Capital Markets Association
        /// </summary>
        ICMA,
        
        /// <summary>
        /// International Swaps and Derivatives Association, Inc.
        /// </summary>
        [RosettaSynonym(Value = "ISDA", Source = "AcadiaSoft_AM_1_0")]
        ISDA,
        
        /// <summary>
        /// ISDA and Clearstream
        /// </summary>
        [EnumMember(Value = "ISDA_CLEARSTREAM")]
        ISDAClearstream,
        
        /// <summary>
        /// ISDA and Euroclear
        /// </summary>
        [EnumMember(Value = "ISDA_EUROCLEAR")]
        ISDAEuroclear,
        
        /// <summary>
        /// International Securities Lending Association
        /// </summary>
        ISLA,
        
        /// <summary>
        /// JP Morgan
        /// </summary>
        [EnumMember(Value = "JP_MORGAN")]
        JPMorgan,
        
        /// <summary>
        /// The Foreign Exchange Committee
        /// </summary>
        [EnumMember(Value = "THE_FX_COMMITTEE")]
        TheFXCommittee
    }
    
    /// <summary>
    /// The enumerated values to specify the legal agreement type.
    /// </summary>
    [CdmName("LegalAgreementTypeEnum")]
    public enum LegalAgreementType
    {
        /// <summary>
        /// A Broker Confirmation.
        /// </summary>
        [EnumMember(Value = "BROKER_CONFIRMATION")]
        BrokerConfirmation,
        
        /// <summary>
        /// A Transaction Confirmation.
        /// </summary>
        [EnumMember(Value = "CONFIRMATION")]
        Confirmation,
        
        /// <summary>
        /// A Credit Support Agreement.
        /// </summary>
        [EnumMember(Value = "CREDIT_SUPPORT_AGREEMENT")]
        CreditSupportAgreement,
        
        /// <summary>
        /// A Master Agreement.
        /// </summary>
        [EnumMember(Value = "MASTER_AGREEMENT")]
        MasterAgreement,
        
        /// <summary>
        /// A Master Confirmation.
        /// </summary>
        [EnumMember(Value = "MASTER_CONFIRMATION")]
        MasterConfirmation,
        
        /// <summary>
        /// Another type of agreement.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// A Security Agreement related to a Collateral Transfer Agreement (CTA).
        /// </summary>
        [EnumMember(Value = "SECURITY_AGREEMENT")]
        SecurityAgreement
    }
    
    /// <summary>
    /// The enumerated values to specify the length unit in the Resource type.
    /// </summary>
    [CdmName("LengthUnitEnum")]
    public enum LengthUnit
    {
        [EnumMember(Value = "PAGES")]
        Pages,
        
        [EnumMember(Value = "TIME_UNIT")]
        TimeUnit
    }
    
    /// <summary>
    /// The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification.
    /// </summary>
    [CdmName("LimitLevelEnum")]
    public enum LimitLevel
    {
        /// <summary>
        /// The limit is set in relation to the proprietary business undertaken by the clearing counterparty.
        /// </summary>
        [EnumMember(Value = "ACCOUNT")]
        Account,
        
        /// <summary>
        /// The limit is set in relation to the customer business undertaken by the clearing counterparty.
        /// </summary>
        [EnumMember(Value = "CUSTOMER")]
        Customer,
        
        /// <summary>
        /// The limit is set at the account level in relation to the clearing counterparty.
        /// </summary>
        [EnumMember(Value = "HOUSE")]
        House
    }
    
    /// <summary>
    /// Specifies the load type of the delivery.
    /// </summary>
    [CdmName("LoadTypeEnum")]
    public enum LoadType
    {
        /// <summary>
        /// Base load
        /// </summary>
        [EnumMember(Value = "BASE_LOAD")]
        BaseLoad,
        
        /// <summary>
        /// Block Hours
        /// </summary>
        [EnumMember(Value = "BLOCK_HOURS")]
        BlockHours,
        
        /// <summary>
        /// Gas Day
        /// </summary>
        [EnumMember(Value = "GAS_DAY")]
        GasDay,
        
        /// <summary>
        /// Off-peak load
        /// </summary>
        [EnumMember(Value = "OFF_PEAK")]
        OffPeak,
        
        /// <summary>
        /// Other
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Peak load
        /// </summary>
        [EnumMember(Value = "PEAK_LOAD")]
        PeakLoad,
        
        /// <summary>
        /// Shaped
        /// </summary>
        [EnumMember(Value = "SHAPED")]
        Shaped
    }
    
    /// <summary>
    /// Represents the enumeration values to identify the collateral action instruction.
    /// </summary>
    [CdmName("MarginCallActionEnum")]
    public enum MarginCallAction
    {
        /// <summary>
        /// Indicates an instruction of a new collateral asset delivery.
        /// </summary>
        [EnumMember(Value = "DELIVERY")]
        Delivery,
        
        /// <summary>
        /// Indicates an instruction for a return of a principals collateral asset delivery.
        /// </summary>
        [EnumMember(Value = "RETURN")]
        Return
    }
    
    /// <summary>
    /// Represents the enumeration values to define the response type to a margin call.
    /// </summary>
    [CdmName("MarginCallResponseTypeEnum")]
    public enum MarginCallResponseType
    {
        /// <summary>
        /// Specifies a &apos;Full Agreement&apos; to Margin Call.
        /// </summary>
        [EnumMember(Value = "AGREEIN_FULL")]
        AgreeinFull,
        
        /// <summary>
        /// Specifies a &apos;Full Dispute&apos; to a Margin call.
        /// </summary>
        [EnumMember(Value = "DISPUTE")]
        Dispute,
        
        /// <summary>
        /// Specifies a &apos;Partial agreement&apos; to Margin Call.
        /// </summary>
        [EnumMember(Value = "PARTIALLY_AGREE")]
        PartiallyAgree
    }
    
    /// <summary>
    /// This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
    /// </summary>
    [CdmName("MarginTypeEnum")]
    public enum MarginType
    {
        /// <summary>
        /// When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
        /// </summary>
        [EnumMember(Value = "CASH")]
        Cash,
        
        /// <summary>
        /// When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the &apos;instrument&apos; case, the haircut would be applied to the securities.
        /// </summary>
        [EnumMember(Value = "INSTRUMENT")]
        Instrument
    }
    
    /// <summary>
    /// The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
    /// </summary>
    [CdmName("MarketDisruptionEnum")]
    public enum MarketDisruption
    {
        /// <summary>
        /// As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
        /// </summary>
        [EnumMember(Value = "MODIFIED_POSTPONEMENT")]
        ModifiedPostponement,
        
        /// <summary>
        /// As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
        /// </summary>
        [EnumMember(Value = "OMISSION")]
        Omission,
        
        /// <summary>
        /// As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
        /// </summary>
        [EnumMember(Value = "POSTPONEMENT")]
        Postponement
    }
    
    [CdmName("MasterAgreementClauseIdentifierEnum")]
    public enum MasterAgreementClauseIdentifier
    {
        /// <summary>
        /// Date of Agreement
        /// </summary>
        ISLA_GMSLA_001,
        
        /// <summary>
        /// Parties
        /// </summary>
        ISLA_GMSLA_002,
        
        /// <summary>
        /// Specific Roles
        /// </summary>
        ISLA_GMSLA_003,
        
        /// <summary>
        /// Eligible Collateral
        /// </summary>
        ISLA_GMSLA_004,
        
        /// <summary>
        /// Margin
        /// </summary>
        ISLA_GMSLA_005,
        
        /// <summary>
        /// Aggregation
        /// </summary>
        ISLA_GMSLA_006,
        
        /// <summary>
        /// Collateral Disapplication
        /// </summary>
        ISLA_GMSLA_007,
        
        /// <summary>
        /// Settlement Netting
        /// </summary>
        ISLA_GMSLA_008,
        
        /// <summary>
        /// Notification Time
        /// </summary>
        ISLA_GMSLA_009,
        
        /// <summary>
        /// Indemnity
        /// </summary>
        ISLA_GMSLA_010,
        
        /// <summary>
        /// Base Currency
        /// </summary>
        ISLA_GMSLA_011,
        
        /// <summary>
        /// Places of Business
        /// </summary>
        ISLA_GMSLA_012,
        
        /// <summary>
        /// Value
        /// </summary>
        ISLA_GMSLA_013,
        
        /// <summary>
        /// Automatic Early Termination
        /// </summary>
        ISLA_GMSLA_014,
        
        /// <summary>
        /// Designated Offices
        /// </summary>
        ISLA_GMSLA_015,
        
        /// <summary>
        /// Address for Notices
        /// </summary>
        ISLA_GMSLA_016,
        
        /// <summary>
        /// Process Agent
        /// </summary>
        ISLA_GMSLA_017,
        
        /// <summary>
        /// Party Acting as Agent
        /// </summary>
        ISLA_GMSLA_018,
        
        /// <summary>
        /// Pooled Principal Transactions 
        /// </summary>
        ISLA_GMSLA_019,
        
        /// <summary>
        /// Party Preparing the Agreement 
        /// </summary>
        ISLA_GMSLA_020,
        
        /// <summary>
        /// Default Interest Rate
        /// </summary>
        ISLA_GMSLA_021,
        
        /// <summary>
        /// Existing Transactions
        /// </summary>
        ISLA_GMSLA_022,
        
        /// <summary>
        /// Automation
        /// </summary>
        ISLA_GMSLA_023,
        
        /// <summary>
        /// Act of Insolvency
        /// </summary>
        ISLA_GMSLA_024,
        
        /// <summary>
        /// Buy-In
        /// </summary>
        ISLA_GMSLA_025,
        
        /// <summary>
        /// Currency Conversions
        /// </summary>
        ISLA_GMSLA_026,
        
        /// <summary>
        /// Scope
        /// </summary>
        ISLA_GMSLA_027,
        
        /// <summary>
        /// Collateral Delivery Timings
        /// </summary>
        ISLA_GMSLA_028,
        
        /// <summary>
        /// Delivery
        /// </summary>
        ISLA_GMSLA_029,
        
        /// <summary>
        /// Substitution of Collateral
        /// </summary>
        ISLA_GMSLA_030,
        
        /// <summary>
        /// Manufactured Payments
        /// </summary>
        ISLA_GMSLA_031,
        
        /// <summary>
        /// Corporate Actions
        /// </summary>
        ISLA_GMSLA_032,
        
        /// <summary>
        /// Payment of Rates
        /// </summary>
        ISLA_GMSLA_033,
        
        /// <summary>
        /// Rate Applicable to Loaned Securities
        /// </summary>
        ISLA_GMSLA_034,
        
        /// <summary>
        /// Lender&apos;s Right to Terminate a Loan
        /// </summary>
        ISLA_GMSLA_035,
        
        /// <summary>
        /// Borrower&apos;s Right to Terminate a Loan
        /// </summary>
        ISLA_GMSLA_036,
        
        /// <summary>
        /// Failure to Deliver Event of Default
        /// </summary>
        ISLA_GMSLA_037,
        
        /// <summary>
        /// Failure to Redeliver
        /// </summary>
        ISLA_GMSLA_038,
        
        /// <summary>
        /// Assets Transferred to a Trustee
        /// </summary>
        ISLA_GMSLA_039,
        
        /// <summary>
        /// Suspension Event of Default
        /// </summary>
        ISLA_GMSLA_040,
        
        /// <summary>
        /// Costs and Expenses
        /// </summary>
        ISLA_GMSLA_041,
        
        /// <summary>
        /// Set-Off
        /// </summary>
        ISLA_GMSLA_042,
        
        /// <summary>
        /// Default Market Value Fallbacks
        /// </summary>
        ISLA_GMSLA_043,
        
        /// <summary>
        /// Assignment
        /// </summary>
        ISLA_GMSLA_044,
        
        /// <summary>
        /// Telephone Recordings
        /// </summary>
        ISLA_GMSLA_045,
        
        /// <summary>
        /// Waiver of Immunity
        /// </summary>
        ISLA_GMSLA_046,
        
        /// <summary>
        /// Agreement to Deliver Documents
        /// </summary>
        ISLA_GMSLA_047,
        
        /// <summary>
        /// Collateral Transfer Details
        /// </summary>
        ISLA_GMSLA_048,
        
        /// <summary>
        /// Confidentiality
        /// </summary>
        ISLA_GMSLA_049,
        
        /// <summary>
        /// Correction
        /// </summary>
        ISLA_GMSLA_050,
        
        /// <summary>
        /// Minimum Collateral Transfer Amount
        /// </summary>
        ISLA_GMSLA_051,
        
        /// <summary>
        /// Non-Reliance Representation
        /// </summary>
        ISLA_GMSLA_052,
        
        /// <summary>
        /// Records and Statements
        /// </summary>
        ISLA_GMSLA_053,
        
        /// <summary>
        /// Recovery and Resolution
        /// </summary>
        ISLA_GMSLA_054,
        
        /// <summary>
        /// Security Agreement Details
        /// </summary>
        ISLA_GMSLA_055,
        
        /// <summary>
        /// Triparty Services
        /// </summary>
        ISLA_GMSLA_056
    }
    
    /// <summary>
    /// The enumerated values to specify the type of the master agreement governing the transaction.
    /// </summary>
    [CdmName("MasterAgreementTypeEnum")]
    public enum MasterAgreementType
    {
        /// <summary>
        /// AFB Master Agreement for Foreign Exchange and Derivatives Transactions
        /// </summary>
        AFB,
        
        /// <summary>
        /// A Bespoke (custom) Master Agreement, including one-off agreements for transactions
        /// </summary>
        [EnumMember(Value = "BESPOKE")]
        Bespoke,
        
        /// <summary>
        /// Clearing Master Agreement
        /// </summary>
        CMA,
        
        /// <summary>
        /// Contrato Marco de Operaciones Financieras
        /// </summary>
        CMOF,
        
        /// <summary>
        /// EEI Master Power Purchase and Sale Agreement
        /// </summary>
        [EnumMember(Value = "EEI_POWER")]
        EEIPower,
        
        /// <summary>
        /// EFET General Agreement Concerning the Delivery and Acceptance of Electricity
        /// </summary>
        [EnumMember(Value = "EFET_ELECTRICITY")]
        EFETElectricity,
        
        /// <summary>
        /// EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
        /// </summary>
        [EnumMember(Value = "EFET_GAS")]
        EFETGas,
        
        /// <summary>
        /// European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
        /// </summary>
        EMA,
        
        /// <summary>
        /// Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
        /// </summary>
        FBF,
        
        /// <summary>
        /// ICMA Global Master Agreement for REPO Trades
        /// </summary>
        GMRA,
        
        /// <summary>
        /// ISLA Global Master Agreement for Securities Lending
        /// </summary>
        GMSLA,
        
        /// <summary>
        /// FOA Grid Trade Master Agreement
        /// </summary>
        GTMA,
        
        /// <summary>
        /// GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas
        /// </summary>
        [EnumMember(Value = "GAS_EDI")]
        GasEDI,
        
        /// <summary>
        /// German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
        /// </summary>
        [EnumMember(Value = "GERMAN")]
        German,
        
        /// <summary>
        /// International Currency Options Market Master Agreement
        /// </summary>
        ICOM,
        
        /// <summary>
        /// International Emissions Trading Association Emissions Reduction Purchase Agreement
        /// </summary>
        [EnumMember(Value = "IETA-ERPA")]
        IETA_ERPA,
        
        /// <summary>
        /// International Emissions Trading Association Emissions Trading Master Agreement
        /// </summary>
        [EnumMember(Value = "IETA-ETMA")]
        IETA_ETMA,
        
        /// <summary>
        /// International Emissions Trading Association International Emissions Trading Master Agreement
        /// </summary>
        [EnumMember(Value = "IETA-IETMA")]
        IETA_IETMA,
        
        /// <summary>
        /// International Foreign Exchange Master Agreement
        /// </summary>
        IFEMA,
        
        /// <summary>
        /// International Foreign Exchange and Options Master Agreement
        /// </summary>
        IFEOMA,
        
        /// <summary>
        /// ISDA-FIA Cleared Derivatives Execution Agreement
        /// </summary>
        [EnumMember(Value = "ISDAFIA-CDEA")]
        ISDAFIA_CDEA,
        
        /// <summary>
        /// ISDA/IIFM Tahawwut (Hedging) Master Agreement (TMA)
        /// </summary>
        [EnumMember(Value = "ISDAIIFM-TMA")]
        ISDAIIFM_TMA,
        
        /// <summary>
        /// ISDA Master Agreement
        /// </summary>
        [EnumMember(Value = "ISDA_MASTER")]
        ISDAMaster,
        
        /// <summary>
        /// Master agreement of Japan Securities Clearing Corporation
        /// </summary>
        JSCC,
        
        /// <summary>
        /// International Bullion Master Agreement Terms published by the London Bullion Market Association
        /// </summary>
        LBMA,
        
        /// <summary>
        /// Leadership in Energy Automated Processing
        /// </summary>
        LEAP,
        
        /// <summary>
        /// CTA Master Coal Purchase and Sales Agreement
        /// </summary>
        MCPSA,
        
        /// <summary>
        /// NAESB Base Contract for Sale and Purchase of Natural Gas
        /// </summary>
        [EnumMember(Value = "NAESB_GAS")]
        NAESBGas,
        
        /// <summary>
        /// Short Term Flat NBP Trading Terms and Conditions
        /// </summary>
        NBP,
        
        /// <summary>
        /// Standard Documentation for Derivative Transactions on the Russian Financial Markets
        /// </summary>
        [EnumMember(Value = "RUSSIAN_DERIVATIVES")]
        RussianDerivatives,
        
        /// <summary>
        /// Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market
        /// </summary>
        [EnumMember(Value = "RUSSIAN_REPO")]
        RussianRepo,
        
        /// <summary>
        /// globalCOAL Standard Coal Trading Agreement
        /// </summary>
        [EnumMember(Value = "S_CO_TA")]
        SCoTA,
        
        /// <summary>
        /// Swiss Master Agreement for OTC Derivatives Instruments
        /// </summary>
        [EnumMember(Value = "SWISS")]
        Swiss,
        
        /// <summary>
        /// TTF Hub Natural Gas Trading Terms and Conditions
        /// </summary>
        TTF,
        
        /// <summary>
        /// Zeebrugge Hub Natural Gas Trading Terms and Conditions
        /// </summary>
        ZBT
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this MasterAgreementType value)
        {
            return value switch
            {
                MasterAgreementType.IETA_ERPA => "IETA-ERPA",
                MasterAgreementType.IETA_ETMA => "IETA-ETMA",
                MasterAgreementType.IETA_IETMA => "IETA-IETMA",
                MasterAgreementType.ISDAFIA_CDEA => "ISDAFIA-CDEA",
                MasterAgreementType.ISDAIIFM_TMA => "ISDAIIFM-TMA",
                _ => nameof(value)
            };
        }
    }
    
    [CdmName("MasterAgreementVariantIdentifierEnum")]
    public enum MasterAgreementVariantIdentifier
    {
        /// <summary>
        /// Agreement is Undated
        /// </summary>
        ISLA_GMSLA_001_01,
        
        /// <summary>
        /// Agreement is Dated
        /// </summary>
        ISLA_GMSLA_001_02,
        
        /// <summary>
        /// Name and Place of Incorporation
        /// </summary>
        ISLA_GMSLA_002_01,
        
        /// <summary>
        /// Names and Place of Incorporation plus Additional Information
        /// </summary>
        ISLA_GMSLA_002_02,
        
        /// <summary>
        /// Defining the Party&apos;s Role as Lender or Borrower
        /// </summary>
        ISLA_GMSLA_002_03,
        
        /// <summary>
        /// Non-specific Roles
        /// </summary>
        ISLA_GMSLA_003_01,
        
        /// <summary>
        /// Specific Roles
        /// </summary>
        ISLA_GMSLA_003_02,
        
        /// <summary>
        /// GMSLA Schedule
        /// </summary>
        ISLA_GMSLA_004_01,
        
        /// <summary>
        /// Outside of GMSLA
        /// </summary>
        ISLA_GMSLA_004_02,
        
        /// <summary>
        /// Additional Criteria
        /// </summary>
        ISLA_GMSLA_004_03,
        
        /// <summary>
        /// GMSLA Schedule
        /// </summary>
        ISLA_GMSLA_005_01,
        
        /// <summary>
        /// Outside of GMSLA
        /// </summary>
        ISLA_GMSLA_005_02,
        
        /// <summary>
        /// Aggregation Applies
        /// </summary>
        ISLA_GMSLA_006_01,
        
        /// <summary>
        /// Aggregation Does Not Apply
        /// </summary>
        ISLA_GMSLA_006_02,
        
        /// <summary>
        /// Aggregation Applies Separately to Loan Groups
        /// </summary>
        ISLA_GMSLA_006_03,
        
        /// <summary>
        /// Aggregation Applies to Some but Not All Loans
        /// </summary>
        ISLA_GMSLA_006_04,
        
        /// <summary>
        /// Neither Aggregation nor Loan by Loan Applies
        /// </summary>
        ISLA_GMSLA_006_05,
        
        /// <summary>
        /// Standard
        /// </summary>
        ISLA_GMSLA_007_01,
        
        /// <summary>
        /// Collateral Disapplied
        /// </summary>
        ISLA_GMSLA_007_02,
        
        /// <summary>
        /// Netting of Collateral Shall Apply
        /// </summary>
        ISLA_GMSLA_008_01,
        
        /// <summary>
        /// Netting of Collateral Shall Not Apply
        /// </summary>
        ISLA_GMSLA_008_02,
        
        /// <summary>
        /// Netting of Collateral Shall Apply with Multiple Payments or Delivery Options
        /// </summary>
        ISLA_GMSLA_008_03,
        
        /// <summary>
        /// Netting of Collateral Shall Apply Separately per Group of Loans
        /// </summary>
        ISLA_GMSLA_008_04,
        
        /// <summary>
        /// Specified Time
        /// </summary>
        ISLA_GMSLA_009_01,
        
        /// <summary>
        /// Notification Time by Collateral Type
        /// </summary>
        ISLA_GMSLA_009_02,
        
        /// <summary>
        /// Notification Time as Agreed
        /// </summary>
        ISLA_GMSLA_009_03,
        
        /// <summary>
        /// No Notification Time
        /// </summary>
        ISLA_GMSLA_009_04,
        
        /// <summary>
        /// Indemnity Applies
        /// </summary>
        ISLA_GMSLA_010_01,
        
        /// <summary>
        /// Indemnity does not Apply
        /// </summary>
        ISLA_GMSLA_010_02,
        
        /// <summary>
        /// Single Base Currency
        /// </summary>
        ISLA_GMSLA_011_01,
        
        /// <summary>
        /// Single Base Currency with Fallback
        /// </summary>
        ISLA_GMSLA_011_02,
        
        /// <summary>
        /// Single Base Currency with Multiple Fallback Options
        /// </summary>
        ISLA_GMSLA_011_03,
        
        /// <summary>
        /// Locations are Specified Without Reference to Party
        /// </summary>
        ISLA_GMSLA_012_01,
        
        /// <summary>
        /// Locations are Specified Separately per Party
        /// </summary>
        ISLA_GMSLA_012_02,
        
        /// <summary>
        /// Not all Places of Business Have to be Open
        /// </summary>
        ISLA_GMSLA_012_03,
        
        /// <summary>
        /// Standard Bid Price
        /// </summary>
        ISLA_GMSLA_013_01,
        
        /// <summary>
        /// Standard Mid Price
        /// </summary>
        ISLA_GMSLA_013_02,
        
        /// <summary>
        /// 2018 Standard
        /// </summary>
        ISLA_GMSLA_013_03,
        
        /// <summary>
        /// Borrowers Agreement to Pricing Source
        /// </summary>
        ISLA_GMSLA_013_04,
        
        /// <summary>
        /// Pre-agreed Pricing Source
        /// </summary>
        ISLA_GMSLA_013_05,
        
        /// <summary>
        /// Time Variation
        /// </summary>
        ISLA_GMSLA_013_06,
        
        /// <summary>
        /// Automatic Early Termination does not Apply
        /// </summary>
        ISLA_GMSLA_014_01,
        
        /// <summary>
        /// Automatic Early Termination Applies
        /// </summary>
        ISLA_GMSLA_014_02,
        
        /// <summary>
        /// Automatic Early Termination Applies in Modified Form)
        /// </summary>
        ISLA_GMSLA_014_03,
        
        /// <summary>
        /// Automatic Early Termination is specified separately for each Principal
        /// </summary>
        ISLA_GMSLA_014_04,
        
        /// <summary>
        /// Automatic Early Termination is not applicable unless required due to the systems of law
        /// </summary>
        ISLA_GMSLA_014_05,
        
        /// <summary>
        /// Party Specifies a Single Designated Office
        /// </summary>
        ISLA_GMSLA_015_01,
        
        /// <summary>
        /// Party Specifies Multiple Designated Offices
        /// </summary>
        ISLA_GMSLA_015_02,
        
        /// <summary>
        /// 2000 Standard
        /// </summary>
        ISLA_GMSLA_016_01,
        
        /// <summary>
        /// 2010 Standard
        /// </summary>
        ISLA_GMSLA_016_02,
        
        /// <summary>
        /// 2018 Standard
        /// </summary>
        ISLA_GMSLA_016_03,
        
        /// <summary>
        /// Plus Email
        /// </summary>
        ISLA_GMSLA_016_04,
        
        /// <summary>
        /// Separate Address for Legal and Operational Notices
        /// </summary>
        ISLA_GMSLA_016_05,
        
        /// <summary>
        /// Special Instructions
        /// </summary>
        ISLA_GMSLA_016_06,
        
        /// <summary>
        /// No Process Agent
        /// </summary>
        ISLA_GMSLA_017_01,
        
        /// <summary>
        /// Process Agent Specified
        /// </summary>
        ISLA_GMSLA_017_02,
        
        /// <summary>
        /// Process Agent to be Appointed
        /// </summary>
        ISLA_GMSLA_017_03,
        
        /// <summary>
        /// A Party will not act as Agent
        /// </summary>
        ISLA_GMSLA_018_01,
        
        /// <summary>
        /// A Party may act as Agent
        /// </summary>
        ISLA_GMSLA_018_02,
        
        /// <summary>
        /// A Party will always act as Agent
        /// </summary>
        ISLA_GMSLA_018_03,
        
        /// <summary>
        /// Pooled Principal Transactions Shall Not Apply
        /// </summary>
        ISLA_GMSLA_019_01,
        
        /// <summary>
        /// Pooled Principal Transactions Shall  Apply
        /// </summary>
        ISLA_GMSLA_019_02,
        
        /// <summary>
        /// Pooled Principal Transactions May Apply
        /// </summary>
        ISLA_GMSLA_019_03,
        
        /// <summary>
        /// Simple Election
        /// </summary>
        ISLA_GMSLA_020_01,
        
        /// <summary>
        /// Election with Modifications
        /// </summary>
        ISLA_GMSLA_020_02,
        
        /// <summary>
        /// Term Rate
        /// </summary>
        ISLA_GMSLA_021_01,
        
        /// <summary>
        /// Overnight Rate
        /// </summary>
        ISLA_GMSLA_021_02,
        
        /// <summary>
        /// Risk Free Rate
        /// </summary>
        ISLA_GMSLA_021_03,
        
        /// <summary>
        /// Non-Defaulting Party Election
        /// </summary>
        ISLA_GMSLA_021_04,
        
        /// <summary>
        /// Spread
        /// </summary>
        ISLA_GMSLA_021_05,
        
        /// <summary>
        /// Agreement Covers Existing Loans
        /// </summary>
        ISLA_GMSLA_022_01,
        
        /// <summary>
        /// Agreement Does Not Cover Existing Loans
        /// </summary>
        ISLA_GMSLA_022_02,
        
        /// <summary>
        /// Automation Does Not Apply
        /// </summary>
        ISLA_GMSLA_023_01,
        
        /// <summary>
        /// Automation May Apply
        /// </summary>
        ISLA_GMSLA_023_02,
        
        /// <summary>
        /// Standard Pre-Print
        /// </summary>
        ISLA_GMSLA_024_01,
        
        /// <summary>
        /// Grace Period Amendment
        /// </summary>
        ISLA_GMSLA_024_02,
        
        /// <summary>
        /// Jurisdictional Amendments
        /// </summary>
        ISLA_GMSLA_024_03,
        
        /// <summary>
        /// Transferor Pays Costs and Expenses
        /// </summary>
        ISLA_GMSLA_025_01,
        
        /// <summary>
        /// Transferor Pays Costs and Expenses other than those arising from Negligence
        /// </summary>
        ISLA_GMSLA_025_02,
        
        /// <summary>
        /// Transferor only Liable for Cost and Expenses if Reasonable Notice of Buy-in
        /// </summary>
        ISLA_GMSLA_025_03,
        
        /// <summary>
        /// Buy-in Expanded to Cover Buy-in Exercised by an Exchange
        /// </summary>
        ISLA_GMSLA_025_04,
        
        /// <summary>
        /// Standard
        /// </summary>
        ISLA_GMSLA_026_01,
        
        /// <summary>
        /// Selecting Party other than Lender
        /// </summary>
        ISLA_GMSLA_026_02,
        
        /// <summary>
        /// Variation of Exchange Rate Source
        /// </summary>
        ISLA_GMSLA_026_03,
        
        /// <summary>
        /// Standard Scope
        /// </summary>
        ISLA_GMSLA_027_01,
        
        /// <summary>
        /// Limited Scope
        /// </summary>
        ISLA_GMSLA_027_02,
        
        /// <summary>
        /// Same Day
        /// </summary>
        ISLA_GMSLA_028_01,
        
        /// <summary>
        /// Alternative Delivery Time
        /// </summary>
        ISLA_GMSLA_028_02,
        
        /// <summary>
        /// Same Day with Notification Time
        /// </summary>
        ISLA_GMSLA_028_03,
        
        /// <summary>
        /// Alternative Delivery Time with Notification Time
        /// </summary>
        ISLA_GMSLA_028_04,
        
        /// <summary>
        /// Asset Dependent
        /// </summary>
        ISLA_GMSLA_028_05,
        
        /// <summary>
        /// Simultaneous delivery of securities and collateral
        /// </summary>
        ISLA_GMSLA_029_01,
        
        /// <summary>
        /// Collateral Delivery as specified in the Security Agreement
        /// </summary>
        ISLA_GMSLA_029_02,
        
        /// <summary>
        /// Lender to Deliver Securities once Collateral is Delivered
        /// </summary>
        ISLA_GMSLA_029_03,
        
        /// <summary>
        /// Borrower Request
        /// </summary>
        ISLA_GMSLA_030_01,
        
        /// <summary>
        /// Borrower Request/Lender Consent
        /// </summary>
        ISLA_GMSLA_030_02,
        
        /// <summary>
        /// Lender or Borrower Request
        /// </summary>
        ISLA_GMSLA_030_03,
        
        /// <summary>
        /// Pre-approval of Alternative Collateral
        /// </summary>
        ISLA_GMSLA_030_04,
        
        /// <summary>
        /// Manufactured Payment of Amount Such Party Would Be Entitled to Receive
        /// </summary>
        ISLA_GMSLA_031_01,
        
        /// <summary>
        /// Manufactured Payment of Amount Such Lender Would Be Entitled to Receive
        /// </summary>
        ISLA_GMSLA_031_02,
        
        /// <summary>
        /// Manufactured Payment Only in Relation to Loaned Securities
        /// </summary>
        ISLA_GMSLA_031_03,
        
        /// <summary>
        /// Additional Sum to Be Paid to Cover Tax Relief
        /// </summary>
        ISLA_GMSLA_031_04,
        
        /// <summary>
        /// Notice Requirement
        /// </summary>
        ISLA_GMSLA_031_05,
        
        /// <summary>
        /// Standard
        /// </summary>
        ISLA_GMSLA_032_01,
        
        /// <summary>
        /// Reasonable Notice Defined
        /// </summary>
        ISLA_GMSLA_032_02,
        
        /// <summary>
        /// No Right to Instruct
        /// </summary>
        ISLA_GMSLA_032_03,
        
        /// <summary>
        /// Payment Within a Week
        /// </summary>
        ISLA_GMSLA_033_01,
        
        /// <summary>
        /// Payment Within 10 Days
        /// </summary>
        ISLA_GMSLA_033_02,
        
        /// <summary>
        /// Payment Upon Maturity
        /// </summary>
        ISLA_GMSLA_033_03,
        
        /// <summary>
        /// Such Rate as Agreed
        /// </summary>
        ISLA_GMSLA_034_01,
        
        /// <summary>
        /// VAT Added
        /// </summary>
        ISLA_GMSLA_034_02,
        
        /// <summary>
        /// No Deduction
        /// </summary>
        ISLA_GMSLA_034_03,
        
        /// <summary>
        /// No Rate Payable
        /// </summary>
        ISLA_GMSLA_034_04,
        
        /// <summary>
        /// Lender May Terminate a Loan at any Time
        /// </summary>
        ISLA_GMSLA_035_01,
        
        /// <summary>
        /// Lender May Not Terminate a Loan
        /// </summary>
        ISLA_GMSLA_035_02,
        
        /// <summary>
        /// Borrower May Terminate a Loan at Any Time
        /// </summary>
        ISLA_GMSLA_036_01,
        
        /// <summary>
        /// Borrower May Terminate a Loan Subject to Notice
        /// </summary>
        ISLA_GMSLA_036_02,
        
        /// <summary>
        /// Borrower May Terminate a Loan Subject to Limitations Concerning Corporate Actions
        /// </summary>
        ISLA_GMSLA_036_03,
        
        /// <summary>
        /// Borrower May Terminate a Loan Subject to Paying the Rate for the Full Term
        /// </summary>
        ISLA_GMSLA_036_04,
        
        /// <summary>
        /// Failure to Deliver Event of Default Applies
        /// </summary>
        ISLA_GMSLA_037_01,
        
        /// <summary>
        /// Failure to Deliver Event of Default does not Apply
        /// </summary>
        ISLA_GMSLA_037_02,
        
        /// <summary>
        /// Failure to Deliver Event of Default does not Apply to Lender
        /// </summary>
        ISLA_GMSLA_037_03,
        
        /// <summary>
        /// 2000 Standard
        /// </summary>
        ISLA_GMSLA_038_01,
        
        /// <summary>
        /// 2010 Standard
        /// </summary>
        ISLA_GMSLA_038_02,
        
        /// <summary>
        /// 2018 Standard
        /// </summary>
        ISLA_GMSLA_038_03,
        
        /// <summary>
        /// 2000 Modified No Lender Close Out
        /// </summary>
        ISLA_GMSLA_038_04,
        
        /// <summary>
        /// 2000 Standard
        /// </summary>
        ISLA_GMSLA_039_01,
        
        /// <summary>
        /// 2010/2018 Standard
        /// </summary>
        ISLA_GMSLA_039_02,
        
        /// <summary>
        /// Hybrid
        /// </summary>
        ISLA_GMSLA_039_03,
        
        /// <summary>
        /// 2000 Standard
        /// </summary>
        ISLA_GMSLA_040_01,
        
        /// <summary>
        /// 2010/2018 Standard
        /// </summary>
        ISLA_GMSLA_040_02,
        
        /// <summary>
        /// Hybrid
        /// </summary>
        ISLA_GMSLA_040_03,
        
        /// <summary>
        /// Standard Costs and Expenses
        /// </summary>
        ISLA_GMSLA_041_01,
        
        /// <summary>
        /// Limitation of Costs and Expenses
        /// </summary>
        ISLA_GMSLA_041_02,
        
        /// <summary>
        /// Expansion of Costs and Expenses
        /// </summary>
        ISLA_GMSLA_041_03,
        
        /// <summary>
        /// No Contractual Set-Off
        /// </summary>
        ISLA_GMSLA_042_01,
        
        /// <summary>
        /// Simple Contractual Set-Off
        /// </summary>
        ISLA_GMSLA_042_02,
        
        /// <summary>
        /// Set-Off with Unascertained Obligations Amendment
        /// </summary>
        ISLA_GMSLA_042_03,
        
        /// <summary>
        /// Standard Paragraph 11.2(a)
        /// </summary>
        ISLA_GMSLA_043_01,
        
        /// <summary>
        /// Amended Paragraph 11.2,(a) applies
        /// </summary>
        ISLA_GMSLA_043_02,
        
        /// <summary>
        /// Consent
        /// </summary>
        ISLA_GMSLA_044_01,
        
        /// <summary>
        /// Consent with Standard Exclusions
        /// </summary>
        ISLA_GMSLA_044_02,
        
        /// <summary>
        /// Consent with Additional Exclusions
        /// </summary>
        ISLA_GMSLA_044_03,
        
        /// <summary>
        /// Pre-approved Assignments
        /// </summary>
        ISLA_GMSLA_044_04,
        
        /// <summary>
        /// Parties May Record All Conversations
        /// </summary>
        ISLA_GMSLA_045_01,
        
        /// <summary>
        /// Parties Agree to Obtain Consent
        /// </summary>
        ISLA_GMSLA_045_02,
        
        /// <summary>
        /// Parties Limit the Conversations that May be Recorded
        /// </summary>
        ISLA_GMSLA_045_03,
        
        /// <summary>
        /// Submission as Evidence
        /// </summary>
        ISLA_GMSLA_045_04,
        
        /// <summary>
        /// Standard Waiver of Immunity Applies
        /// </summary>
        ISLA_GMSLA_046_01,
        
        /// <summary>
        /// Waiver of Immunity may Not Apply
        /// </summary>
        ISLA_GMSLA_046_02,
        
        /// <summary>
        /// No Additional Documentation Required
        /// </summary>
        ISLA_GMSLA_047_01,
        
        /// <summary>
        /// Additional Documentation Required
        /// </summary>
        ISLA_GMSLA_047_02,
        
        /// <summary>
        /// Collateral Transfer Details not included
        /// </summary>
        ISLA_GMSLA_048_01,
        
        /// <summary>
        /// Collateral Transfer Details included
        /// </summary>
        ISLA_GMSLA_048_02,
        
        /// <summary>
        /// Confidentiality Clause
        /// </summary>
        ISLA_GMSLA_049_01,
        
        /// <summary>
        /// Permitted Disclosure Clause
        /// </summary>
        ISLA_GMSLA_049_02,
        
        /// <summary>
        /// Paragraph 20.1 Amended to Refer  Paragraph 6
        /// </summary>
        ISLA_GMSLA_050_01,
        
        /// <summary>
        /// Paragraph 27.2 Amended to refer to the 2010 GMSLA
        /// </summary>
        ISLA_GMSLA_050_02,
        
        /// <summary>
        /// MCTA  Delivery only
        /// </summary>
        ISLA_GMSLA_051_01,
        
        /// <summary>
        /// MCTA  Delivery and Re-Delivery
        /// </summary>
        ISLA_GMSLA_051_02,
        
        /// <summary>
        /// MCTA  Drops to Zero for a Defaulting Party
        /// </summary>
        ISLA_GMSLA_051_03,
        
        /// <summary>
        /// No Non-Reliance Representation
        /// </summary>
        ISLA_GMSLA_052_01,
        
        /// <summary>
        /// Non-Reliance Representation Added
        /// </summary>
        ISLA_GMSLA_052_02,
        
        /// <summary>
        /// No Records and Statements Clause
        /// </summary>
        ISLA_GMSLA_053_01,
        
        /// <summary>
        /// Records and Statements Clause Added
        /// </summary>
        ISLA_GMSLA_053_02,
        
        /// <summary>
        /// Recovery and Resolution not Included
        /// </summary>
        ISLA_GMSLA_054_01,
        
        /// <summary>
        /// Recovery and Resolution Included in GMSLA
        /// </summary>
        ISLA_GMSLA_054_02,
        
        /// <summary>
        /// Recovery and Resolution Included by Protocol
        /// </summary>
        ISLA_GMSLA_054_03,
        
        /// <summary>
        /// Recovery and Resolution Incorporated by Reference
        /// </summary>
        ISLA_GMSLA_054_04,
        
        /// <summary>
        /// Security Agreement Details Included
        /// </summary>
        ISLA_GMSLA_055_01,
        
        /// <summary>
        /// Triparty Services Not Referenced
        /// </summary>
        ISLA_GMSLA_056_01,
        
        /// <summary>
        /// Triparty Services May Apply
        /// </summary>
        ISLA_GMSLA_056_02
    }
    
    /// <summary>
    /// The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction.
    /// </summary>
    [CdmName("MasterConfirmationAnnexTypeEnum")]
    public enum MasterConfirmationAnnexType
    {
        /// <summary>
        /// The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER")]
        ISDA2004IndexVarianceSwapAmericasInterdealer,
        
        /// <summary>
        /// The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER")]
        ISDA2004ShareVarianceSwapAmericasInterdealer,
        
        /// <summary>
        /// The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN")]
        ISDA2007DispersionVarianceSwapEuropean,
        
        /// <summary>
        /// The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN")]
        ISDA2007EquityFinanceSwapEuropean,
        
        /// <summary>
        /// The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER")]
        ISDA2007IndexVarianceSwapAmericasInterdealer,
        
        /// <summary>
        /// The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER")]
        ISDA2007ShareVarianceSwapAmericasInterdealer,
        
        /// <summary>
        /// The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_OPTION_EUROPEAN")]
        ISDA2007VarianceOptionEuropean,
        
        /// <summary>
        /// The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN")]
        ISDA2008EquityFinanceSwapAsiaExcludingJapan,
        
        /// <summary>
        /// The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1")]
        ISDA2008EquityFinanceSwapAsiaExcludingJapanRev1,
        
        /// <summary>
        /// The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN")]
        ISDA2008EquityOptionAsiaExcludingJapan,
        
        /// <summary>
        /// The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1")]
        ISDA2008EquityOptionAsiaExcludingJapanRev1,
        
        /// <summary>
        /// The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_OPTION_JAPAN")]
        ISDA2008EquityOptionJapan,
        
        /// <summary>
        /// The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN")]
        ISDA2009ClosedMarketsOptionsAsiaExcludingJapan,
        
        /// <summary>
        /// The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_EQUITY_EUROPEAN_IS")]
        ISDA2009EquityEuropeanIS,
        
        /// <summary>
        /// The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS")]
        ISDA2009EquityEuropeanInterdealerSS,
        
        /// <summary>
        /// The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_INDEX_SHARE_OPTION_AMERICAS")]
        ISDA2009IndexShareOptionAmericas,
        
        /// <summary>
        /// The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER")]
        ISDA2009IndexSwapEuropeanInterdealer,
        
        /// <summary>
        /// The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER")]
        ISDA2009IndexSwapPanAsiaInterdealer,
        
        /// <summary>
        /// The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_SHARE_SWAP_PAN_ASIA")]
        ISDA2009ShareSwapPanAsia,
        
        /// <summary>
        /// The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER")]
        ISDA2010FairValueShareSwapEuropeanInterdealer,
        
        /// <summary>
        /// The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER")]
        ISDA2010IndexShareOptionEMEAInterdealer
    }
    
    /// <summary>
    /// The enumerated values to specify the type of master confirmation agreement governing the transaction. While FpML positions the date a prefix, the CDM positions it as the suffix to handle grammar type constraints.
    /// </summary>
    [CdmName("MasterConfirmationTypeEnum")]
    public enum MasterConfirmationType
    {
        /// <summary>
        /// Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Master Confirmation.
        /// </summary>
        [EnumMember(Value = "DJ.CDX.EM")]
        DJ_CDX_EM,
        
        /// <summary>
        /// Used for CDS Index trades executed under the Dow Jones CDX Emerging Markets Diversified Master Confirmation.
        /// </summary>
        [EnumMember(Value = "DJ.CDX.EM.DIV")]
        DJ_CDX_EM_DIV,
        
        /// <summary>
        /// Used for CDS Index trades executed under the Dow Jones CDX Master Confirmation that covers CDX.NA.IG, CDX.NA.HY, and CDX.NA.XO.
        /// </summary>
        [EnumMember(Value = "DJ.CDX.NA")]
        DJ_CDX_NA,
        
        /// <summary>
        /// Used for CDS Index trades executed under the Dow Jones iTraxx Europe Master Confirmation Agreement.
        /// </summary>
        [EnumMember(Value = "DJ.iTraxx.Europe")]
        DJ_iTraxx_Europe,
        
        /// <summary>
        /// A general reference to the types of Americas Master Confirmation Agreements. Use the more specific values to reference a specific type of Americas Master Confirmation Agreement.
        /// </summary>
        [EnumMember(Value = "EQUITY_AMERICAS")]
        EquityAmericas,
        
        /// <summary>
        /// A general reference to the types of Asia Master Confirmation Agreements. Use the more specific values to reference a specific type of Asia Master Confirmation Agreement.
        /// </summary>
        [EnumMember(Value = "EQUITY_ASIA")]
        EquityAsia,
        
        /// <summary>
        /// A general reference to the types of European Master Confirmation Agreements. Use the more specific values to reference a specific type of European Master Confirmation Agreement.
        /// </summary>
        [EnumMember(Value = "EQUITY_EUROPEAN")]
        EquityEuropean,
        
        /// <summary>
        /// ISDA 1999 Master Credit Derivatives Confirmation Agreement
        /// </summary>
        [EnumMember(Value = "ISDA_1999_CREDIT")]
        ISDA1999Credit,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_ASIA")]
        ISDA2003CreditAsia,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Australia and New Zealand had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND")]
        ISDA2003CreditAustraliaNewZealand,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if European had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_EUROPEAN")]
        ISDA2003CreditEuropean,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_JAPAN")]
        ISDA2003CreditJapan,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if North American had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_NORTH_AMERICAN")]
        ISDA2003CreditNorthAmerican,
        
        /// <summary>
        /// ISDA 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Singapore had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SINGAPORE")]
        ISDA2003CreditSingapore,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_ASIA")]
        ISDA2003CreditSovereignAsia,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Central and Eastern Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE")]
        ISDA2003CreditSovereignCentralAndEasternEurope,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_JAPAN")]
        ISDA2003CreditSovereignJapan,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Latin America had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA")]
        ISDA2003CreditSovereignLatinAmerica,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Middle East had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST")]
        ISDA2003CreditSovereignMiddleEast,
        
        /// <summary>
        /// ISDA Sovereign 2003 Master Credit Derivatives Confirmation Agreement interpreted as if Western Europe had been specified as the relevant Transaction Type in the Transaction Supplement. The 2003 Sovereign Master Confirmation has been superceded by the 2004.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE")]
        ISDA2003CreditSovereignWesternEurope,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_ASIA")]
        ISDA2003StandardCreditAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate/Sovereign and StandardNewZealandCorporate/Sovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND")]
        ISDA2003StandardCreditAustraliaNewZealand,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_EUROPEAN")]
        ISDA2003StandardCreditEuropean,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_JAPAN")]
        ISDA2003StandardCreditJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN")]
        ISDA2003StandardCreditNorthAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate/Sovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2003_STANDARD_CREDIT_SINGAPORE")]
        ISDA2003StandardCreditSingapore,
        
        /// <summary>
        /// ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Asia had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_CREDIT_SOVEREIGN_ASIA")]
        ISDA2004CreditSovereignAsia,
        
        /// <summary>
        /// ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Emerging European and Middle Eastern had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN")]
        ISDA2004CreditSovereignEmergingEuropeanAndMiddleEastern,
        
        /// <summary>
        /// ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Japan had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_CREDIT_SOVEREIGN_JAPAN")]
        ISDA2004CreditSovereignJapan,
        
        /// <summary>
        /// ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Latin American had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN")]
        ISDA2004CreditSovereignLatinAmerican,
        
        /// <summary>
        /// ISDA Sovereign 2004 Master Credit Derivatives Confirmation Agreement interpreted as if Western European had been specified as the relevant Transaction Type in the Transaction Supplement.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN")]
        ISDA2004CreditSovereignWesternEuropean,
        
        /// <summary>
        /// The ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_EQUITY_AMERICAS_INTERDEALER")]
        ISDA2004EquityAmericasInterdealer,
        
        /// <summary>
        /// The Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1")]
        ISDA2004EquityAmericasInterdealerRev1,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAsiaSovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA")]
        ISDA2004StandardCreditSovereignAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN")]
        ISDA2004StandardCreditSovereignEmergingEuropeanAndMiddleEastern,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN")]
        ISDA2004StandardCreditSovereignJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN")]
        ISDA2004StandardCreditSovereignLatinAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
        /// </summary>
        [EnumMember(Value = "ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN")]
        ISDA2004StandardCreditSovereignWesternEuropean,
        
        /// <summary>
        /// ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER")]
        ISDA2005EquityAsiaExcludingJapanInterdealer,
        
        /// <summary>
        /// Second Revised ISDA 2005 AEJ (Asia Excluding Japan) Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2")]
        ISDA2005EquityAsiaExcludingJapanInterdealerRev2,
        
        /// <summary>
        /// The ISDA 2005 Japanese Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2005_EQUITY_JAPANESE_INTERDEALER")]
        ISDA2005EquityJapaneseInterdealer,
        
        /// <summary>
        /// ISDA 2006 Variance Swap Japanese Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2006_VARIANCE_SWAP_JAPANESE")]
        ISDA2006VarianceSwapJapanese,
        
        /// <summary>
        /// ISDA 2006 Variance Swap Japanese Interdealer Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER")]
        ISDA2006VarianceSwapJapaneseInterdealer,
        
        /// <summary>
        /// The ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_EQUITY_EUROPEAN")]
        ISDA2007EquityEuropean,
        
        /// <summary>
        /// The ISDA 2007 Americas Master Variance Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_AMERICAS")]
        ISDA2007VarianceSwapAmericas,
        
        /// <summary>
        /// The ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN")]
        ISDA2007VarianceSwapAsiaExcludingJapan,
        
        /// <summary>
        /// The Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1")]
        ISDA2007VarianceSwapAsiaExcludingJapanRev1,
        
        /// <summary>
        /// The Second Revised ISDA 2007 AEJ Master Variance Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2")]
        ISDA2007VarianceSwapAsiaExcludingJapanRev2,
        
        /// <summary>
        /// The ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_EUROPEAN")]
        ISDA2007VarianceSwapEuropean,
        
        /// <summary>
        /// The Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1")]
        ISDA2007VarianceSwapEuropeanRev1,
        
        /// <summary>
        /// The ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_DIVIDEND_SWAP_JAPAN")]
        ISDA2008DividendSwapJapan,
        
        /// <summary>
        /// The Revised ISDA 2008 Japanese Dividend Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1")]
        ISDA2008DividendSwapJapaneseRev1,
        
        /// <summary>
        /// The ISDA 2008 Americas Master Designated/Exchange-Traded Contract Option Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_AMERICAS")]
        ISDA2008EquityAmericas,
        
        /// <summary>
        /// The ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN")]
        ISDA2008EquityAsiaExcludingJapan,
        
        /// <summary>
        /// The Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1")]
        ISDA2008EquityAsiaExcludingJapanRev1,
        
        /// <summary>
        /// The ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2008_EQUITY_JAPAN")]
        ISDA2008EquityJapan,
        
        /// <summary>
        /// The ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_EQUITY_AMERICAS")]
        ISDA2009EquityAmericas,
        
        /// <summary>
        /// The ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_EQUITY_EUROPEAN_INTERDEALER")]
        ISDA2009EquityEuropeanInterdealer,
        
        /// <summary>
        /// 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2009_EQUITY_PAN_ASIA")]
        ISDA2009EquityPanAsia,
        
        /// <summary>
        /// The ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2010_EQUITY_EMEA_INTERDEALER")]
        ISDA2010EquityEMEAInterdealer,
        
        /// <summary>
        /// The ISDA 2013 Americas Master Volatility Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2013_VOLATILITY_SWAP_AMERICAS")]
        ISDA2013VolatilitySwapAmericas,
        
        /// <summary>
        /// The ISDA 2013 AEJ Master Volatility Swap Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN")]
        ISDA2013VolatilitySwapAsiaExcludingJapan,
        
        /// <summary>
        /// The ISDA 2013 European Volatility Swap Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2013_VOLATILITY_SWAP_EUROPEAN")]
        ISDA2013VolatilitySwapEuropean,
        
        /// <summary>
        /// The ISDA 2013 Volatility Swap Japanese Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "ISDA_2013_VOLATILITY_SWAP_JAPANESE")]
        ISDA2013VolatilitySwapJapanese,
        
        /// <summary>
        /// Used for CDS Index trades. Relevant Master Confirmation determined by the contents of the creditDefaultSwap element. Best practice is to use the most specific code that applies.
        /// </summary>
        [EnumMember(Value = "2003CreditIndex")]
        _2003CreditIndex,
        
        /// <summary>
        /// A privately negotiated European Interdealer Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "2004EquityEuropeanInterdealer")]
        _2004EquityEuropeanInterdealer,
        
        /// <summary>
        /// A privately negotiated European Interdealer Master Confirmation Agreement applies.
        /// </summary>
        [EnumMember(Value = "2005VarianceSwapEuropeanInterdealer")]
        _2005VarianceSwapEuropeanInterdealer,
        
        /// <summary>
        /// A European Interdealer Master Confirmation Agreement not defined by ISDA, and modified by the parties to the transaction applies.
        /// </summary>
        [EnumMember(Value = "2006DividendSwapEuropean")]
        _2006DividendSwapEuropean,
        
        /// <summary>
        /// A European Interdealer Master Confirmation Agreement not defined by ISDA applies.
        /// </summary>
        [EnumMember(Value = "2006DividendSwapEuropeanInterdealer")]
        _2006DividendSwapEuropeanInterdealer,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value AsiaCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditAsia")]
        _2014CreditAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value AsiaFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditAsiaFinancial")]
        _2014CreditAsiaFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value AustraliaCorporate/NewZealandCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditAustraliaNewZealand")]
        _2014CreditAustraliaNewZealand,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value AustraliaFinancialCorporate/NewZealandFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditAustraliaNewZealandFinancial")]
        _2014CreditAustraliaNewZealandFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value EuropeanCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditEuropean")]
        _2014CreditEuropean,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value EuropeanCoCoFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditEuropeanCoCoFinancial")]
        _2014CreditEuropeanCoCoFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value EuropeanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditEuropeanFinancial")]
        _2014CreditEuropeanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value JapanCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditJapan")]
        _2014CreditJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value JapanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditJapanFinancial")]
        _2014CreditJapanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value NorthAmericanCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditNorthAmerican")]
        _2014CreditNorthAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value NorthAmericanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditNorthAmericanFinancial")]
        _2014CreditNorthAmericanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values SingaporeCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditSingapore")]
        _2014CreditSingapore,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values SingaporeFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014CreditSingaporeFinancial")]
        _2014CreditSingaporeFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value AsiaSovereign.
        /// </summary>
        [EnumMember(Value = "2014CreditSovereignAsia")]
        _2014CreditSovereignAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value EmergingEuropeanAndMiddleEasternSovereign.
        /// </summary>
        [EnumMember(Value = "2014CreditSovereignEmergingEuropeanAndMiddleEastern")]
        _2014CreditSovereignEmergingEuropeanAndMiddleEastern,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value JapanSovereign.
        /// </summary>
        [EnumMember(Value = "2014CreditSovereignJapan")]
        _2014CreditSovereignJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value LatinAmericaSovereign.
        /// </summary>
        [EnumMember(Value = "2014CreditSovereignLatinAmerican")]
        _2014CreditSovereignLatinAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value WesternEuropeanSovereign.
        /// </summary>
        [EnumMember(Value = "2014CreditSovereignWesternEuropean")]
        _2014CreditSovereignWesternEuropean,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAsiaCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditAsia")]
        _2014StandardCreditAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAsiaFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditAsiaFinancial")]
        _2014StandardCreditAsiaFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAustraliaCorporate and StandardNewZealandCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditAustraliaNewZealand")]
        _2014StandardCreditAustraliaNewZealand,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardAustraliaFinancialCorporate and StandardNewZealandFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditAustraliaNewZealandFinancial")]
        _2014StandardCreditAustraliaNewZealandFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEuropeanCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditEuropean")]
        _2014StandardCreditEuropean,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEuropeanCoCoFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditEuropeanCoCoFinancial")]
        _2014StandardCreditEuropeanCoCoFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEuropeanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditEuropeanFinancial")]
        _2014StandardCreditEuropeanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardJapanCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditJapan")]
        _2014StandardCreditJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardJapanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditJapanFinancial")]
        _2014StandardCreditJapanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardNorthAmericanCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditNorthAmerican")]
        _2014StandardCreditNorthAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value standardNorthAmericanFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditNorthAmericanFinancial")]
        _2014StandardCreditNorthAmericanFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardSingaporeCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSingapore")]
        _2014StandardCreditSingapore,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardSingaporeFinancialCorporate.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSingaporeFinancial")]
        _2014StandardCreditSingaporeFinancial,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardAsiaSovereign.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSovereignAsia")]
        _2014StandardCreditSovereignAsia,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardEmergingEuropeanAndMiddleEasternSovereign.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern")]
        _2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term values StandardJapanSovereign.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSovereignJapan")]
        _2014StandardCreditSovereignJapan,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardLatinAmericaSovereign.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSovereignLatinAmerican")]
        _2014StandardCreditSovereignLatinAmerican,
        
        /// <summary>
        /// Dummy MCA value mirroring the matrix term value StandardWesternEuropeanSovereign.
        /// </summary>
        [EnumMember(Value = "2014StandardCreditSovereignWesternEuropean")]
        _2014StandardCreditSovereignWesternEuropean
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this MasterConfirmationType value)
        {
            return value switch
            {
                MasterConfirmationType.DJ_CDX_EM => "DJ.CDX.EM",
                MasterConfirmationType.DJ_CDX_EM_DIV => "DJ.CDX.EM.DIV",
                MasterConfirmationType.DJ_CDX_NA => "DJ.CDX.NA",
                MasterConfirmationType.DJ_iTraxx_Europe => "DJ.iTraxx.Europe",
                MasterConfirmationType._2003CreditIndex => "2003CreditIndex",
                MasterConfirmationType._2004EquityEuropeanInterdealer => "2004EquityEuropeanInterdealer",
                MasterConfirmationType._2005VarianceSwapEuropeanInterdealer => "2005VarianceSwapEuropeanInterdealer",
                MasterConfirmationType._2006DividendSwapEuropean => "2006DividendSwapEuropean",
                MasterConfirmationType._2006DividendSwapEuropeanInterdealer => "2006DividendSwapEuropeanInterdealer",
                MasterConfirmationType._2014CreditAsia => "2014CreditAsia",
                MasterConfirmationType._2014CreditAsiaFinancial => "2014CreditAsiaFinancial",
                MasterConfirmationType._2014CreditAustraliaNewZealand => "2014CreditAustraliaNewZealand",
                MasterConfirmationType._2014CreditAustraliaNewZealandFinancial => "2014CreditAustraliaNewZealandFinancial",
                MasterConfirmationType._2014CreditEuropean => "2014CreditEuropean",
                MasterConfirmationType._2014CreditEuropeanCoCoFinancial => "2014CreditEuropeanCoCoFinancial",
                MasterConfirmationType._2014CreditEuropeanFinancial => "2014CreditEuropeanFinancial",
                MasterConfirmationType._2014CreditJapan => "2014CreditJapan",
                MasterConfirmationType._2014CreditJapanFinancial => "2014CreditJapanFinancial",
                MasterConfirmationType._2014CreditNorthAmerican => "2014CreditNorthAmerican",
                MasterConfirmationType._2014CreditNorthAmericanFinancial => "2014CreditNorthAmericanFinancial",
                MasterConfirmationType._2014CreditSingapore => "2014CreditSingapore",
                MasterConfirmationType._2014CreditSingaporeFinancial => "2014CreditSingaporeFinancial",
                MasterConfirmationType._2014CreditSovereignAsia => "2014CreditSovereignAsia",
                MasterConfirmationType._2014CreditSovereignEmergingEuropeanAndMiddleEastern => "2014CreditSovereignEmergingEuropeanAndMiddleEastern",
                MasterConfirmationType._2014CreditSovereignJapan => "2014CreditSovereignJapan",
                MasterConfirmationType._2014CreditSovereignLatinAmerican => "2014CreditSovereignLatinAmerican",
                MasterConfirmationType._2014CreditSovereignWesternEuropean => "2014CreditSovereignWesternEuropean",
                MasterConfirmationType._2014StandardCreditAsia => "2014StandardCreditAsia",
                MasterConfirmationType._2014StandardCreditAsiaFinancial => "2014StandardCreditAsiaFinancial",
                MasterConfirmationType._2014StandardCreditAustraliaNewZealand => "2014StandardCreditAustraliaNewZealand",
                MasterConfirmationType._2014StandardCreditAustraliaNewZealandFinancial => "2014StandardCreditAustraliaNewZealandFinancial",
                MasterConfirmationType._2014StandardCreditEuropean => "2014StandardCreditEuropean",
                MasterConfirmationType._2014StandardCreditEuropeanCoCoFinancial => "2014StandardCreditEuropeanCoCoFinancial",
                MasterConfirmationType._2014StandardCreditEuropeanFinancial => "2014StandardCreditEuropeanFinancial",
                MasterConfirmationType._2014StandardCreditJapan => "2014StandardCreditJapan",
                MasterConfirmationType._2014StandardCreditJapanFinancial => "2014StandardCreditJapanFinancial",
                MasterConfirmationType._2014StandardCreditNorthAmerican => "2014StandardCreditNorthAmerican",
                MasterConfirmationType._2014StandardCreditNorthAmericanFinancial => "2014StandardCreditNorthAmericanFinancial",
                MasterConfirmationType._2014StandardCreditSingapore => "2014StandardCreditSingapore",
                MasterConfirmationType._2014StandardCreditSingaporeFinancial => "2014StandardCreditSingaporeFinancial",
                MasterConfirmationType._2014StandardCreditSovereignAsia => "2014StandardCreditSovereignAsia",
                MasterConfirmationType._2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern => "2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern",
                MasterConfirmationType._2014StandardCreditSovereignJapan => "2014StandardCreditSovereignJapan",
                MasterConfirmationType._2014StandardCreditSovereignLatinAmerican => "2014StandardCreditSovereignLatinAmerican",
                MasterConfirmationType._2014StandardCreditSovereignWesternEuropean => "2014StandardCreditSovereignWesternEuropean",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumerated values to specify a scheme of transaction types specified in the Equity Derivatives Settlement Matrix.
    /// </summary>
    [CdmName("MatrixTermEnum")]
    public enum MatrixTerm
    {
        /// <summary>
        /// Matrix Transaction Type of ASIA CORPORATE.
        /// </summary>
        [EnumMember(Value = "ASIA_CORPORATE")]
        AsiaCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of ASIA FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "ASIA_FINANCIAL_CORPORATE")]
        AsiaFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of ASIA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "ASIA_SOVEREIGN")]
        AsiaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of AUSTRALIA CORPORATE.
        /// </summary>
        [EnumMember(Value = "AUSTRALIA_CORPORATE")]
        AustraliaCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of AUSTRALIA FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "AUSTRALIA_FINANCIAL_CORPORATE")]
        AustraliaFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of AUSTRALIA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "AUSTRALIA_SOVEREIGN")]
        AustraliaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN")]
        EmergingEuropeanAndMiddleEasternSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of EMERGING EUROPEAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "EMERGING_EUROPEAN_CORPORATE")]
        EmergingEuropeanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of EMERGING EUROPEAN CORPORATE LPN.
        /// </summary>
        [EnumMember(Value = "EMERGING_EUROPEAN_CORPORATE_LPN")]
        EmergingEuropeanCorporateLPN,
        
        /// <summary>
        /// Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "EMERGING_EUROPEAN_FINANCIAL_CORPORATE")]
        EmergingEuropeanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
        /// </summary>
        [EnumMember(Value = "EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN")]
        EmergingEuropeanFinancialCorporateLPN,
        
        /// <summary>
        /// Matrix Transaction Type of EUROPEAN COCO FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_CO_CO_FINANCIAL_CORPORATE")]
        EuropeanCoCoFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of EUROPEAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_CORPORATE")]
        EuropeanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of EUROPEAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_FINANCIAL_CORPORATE")]
        EuropeanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE")]
        EuropeanSeniorNonPreferredFinancialCorporate,
        
        /// <summary>
        /// The ISDA-published 2011 Index Volatility Swap Agreement for Open Markets.
        /// </summary>
        [EnumMember(Value = "IVS_1_OPEN_MARKETS")]
        IVS1OpenMarkets,
        
        /// <summary>
        /// Matrix Transaction Type of JAPAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "JAPAN_CORPORATE")]
        JapanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of JAPAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "JAPAN_FINANCIAL_CORPORATE")]
        JapanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of JAPAN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "JAPAN_SOVEREIGN")]
        JapanSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA CORPORATE.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_CORPORATE")]
        LatinAmericaCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA CORPORATE B.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_CORPORATE_BOND")]
        LatinAmericaCorporateBond,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA CORPORATE BL.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_CORPORATE_BOND_OR_LOAN")]
        LatinAmericaCorporateBondOrLoan,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE B.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_FINANCIAL_CORPORATE_BOND")]
        LatinAmericaFinancialCorporateBond,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA FINANCIAL CORPORATE BL.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN")]
        LatinAmericaFinancialCorporateBondOrLoan,
        
        /// <summary>
        /// Matrix Transaction Type of LATIN AMERICA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "LATIN_AMERICA_SOVEREIGN")]
        LatinAmericaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of NEW ZEALAND CORPORATE.
        /// </summary>
        [EnumMember(Value = "NEW_ZEALAND_CORPORATE")]
        NewZealandCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of NEW ZEALAND FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "NEW_ZEALAND_FINANCIAL_CORPORATE")]
        NewZealandFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of NEW ZEALAND SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "NEW_ZEALAND_SOVEREIGN")]
        NewZealandSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of NORTH AMERICAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "NORTH_AMERICAN_CORPORATE")]
        NorthAmericanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of NORTH AMERICAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "NORTH_AMERICAN_FINANCIAL_CORPORATE")]
        NorthAmericanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SINGAPORE CORPORATE.
        /// </summary>
        [EnumMember(Value = "SINGAPORE_CORPORATE")]
        SingaporeCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SINGAPORE FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "SINGAPORE_FINANCIAL_CORPORATE")]
        SingaporeFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SINGAPORE SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "SINGAPORE_SOVEREIGN")]
        SingaporeSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD ASIA CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_ASIA_CORPORATE")]
        StandardAsiaCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD ASIA FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_ASIA_FINANCIAL_CORPORATE")]
        StandardAsiaFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD ASIA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_ASIA_SOVEREIGN")]
        StandardAsiaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD AUSTRALIA CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_AUSTRALIA_CORPORATE")]
        StandardAustraliaCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD AUSTRALIA FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_AUSTRALIA_FINANCIAL_CORPORATE")]
        StandardAustraliaFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD AUSTRALIA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_AUSTRALIA_SOVEREIGN")]
        StandardAustraliaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN")]
        StandardEmergingEuropeanAndMiddleEasternSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EMERGING_EUROPEAN_CORPORATE")]
        StandardEmergingEuropeanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
        /// </summary>
        [EnumMember(Value = "STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN")]
        StandardEmergingEuropeanCorporateLPN,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE")]
        StandardEmergingEuropeanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EMERGING EUROPEAN FINANCIAL CORPORATE LPN.
        /// </summary>
        [EnumMember(Value = "STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN")]
        StandardEmergingEuropeanFinancialCorporateLPN,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EUROPEAN COCO FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE")]
        StandardEuropeanCoCoFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EUROPEAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EUROPEAN_CORPORATE")]
        StandardEuropeanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EUROPEAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EUROPEAN_FINANCIAL_CORPORATE")]
        StandardEuropeanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD EUROPEAN SENIOR NON PREFERRED FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE")]
        StandardEuropeanSeniorNonPreferredFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD JAPAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_JAPAN_CORPORATE")]
        StandardJapanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD JAPAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_JAPAN_FINANCIAL_CORPORATE")]
        StandardJapanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD JAPAN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_JAPAN_SOVEREIGN")]
        StandardJapanSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE B.
        /// </summary>
        [EnumMember(Value = "STANDARD_LATIN_AMERICA_CORPORATE_BOND")]
        StandardLatinAmericaCorporateBond,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD LATIN AMERICA CORPORATE BL.
        /// </summary>
        [EnumMember(Value = "STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN")]
        StandardLatinAmericaCorporateBondOrLoan,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE B.
        /// </summary>
        [EnumMember(Value = "STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND")]
        StandardLatinAmericaFinancialCorporateBond,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD LATIN AMERICA FINANCIAL CORPORATE BL.
        /// </summary>
        [EnumMember(Value = "STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN")]
        StandardLatinAmericaFinancialCorporateBondOrLoan,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD LATIN AMERICA SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_LATIN_AMERICA_SOVEREIGN")]
        StandardLatinAmericaSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD NEW ZEALAND CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_NEW_ZEALAND_CORPORATE")]
        StandardNewZealandCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD NEW ZEALAND FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE")]
        StandardNewZealandFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD NEW ZEALAND SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_NEW_ZEALAND_SOVEREIGN")]
        StandardNewZealandSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD NORTH AMERICAN CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_NORTH_AMERICAN_CORPORATE")]
        StandardNorthAmericanCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD NORTH AMERICAN FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE")]
        StandardNorthAmericanFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD SINGAPORE CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_SINGAPORE_CORPORATE")]
        StandardSingaporeCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD SINGAPORE FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_SINGAPORE_FINANCIAL_CORPORATE")]
        StandardSingaporeFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD SINGAPORE SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_SINGAPORE_SOVEREIGN")]
        StandardSingaporeSovereign,
        
        /// <summary>
        /// Transaction Type of STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE")]
        StandardSubordinatedEuropeanInsuranceCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD SUKUK FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "STANDARD_SUKUK_FINANCIAL_CORPORATE")]
        StandardSukukFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD U.S. MUNICIPAL FULL FAITH AND CREDIT.
        /// </summary>
        [EnumMember(Value = "STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT")]
        StandardUSMunicipalFullFaithAndCredit,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD U.S. MUNICIPAL GENERAL FUND.
        /// </summary>
        [EnumMember(Value = "STANDARD_US_MUNICIPAL_GENERAL_FUND")]
        StandardUSMunicipalGeneralFund,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD U.S. MUNICIPAL REVENUE.
        /// </summary>
        [EnumMember(Value = "STANDARD_US_MUNICIPAL_REVENUE")]
        StandardUSMunicipalRevenue,
        
        /// <summary>
        /// Matrix Transaction Type of STANDARD WESTERN EUROPEAN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "STANDARD_WESTERN_EUROPEAN_SOVEREIGN")]
        StandardWesternEuropeanSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of SUBORDINATED EUROPEAN INSURANCE CORPORATE.
        /// </summary>
        [EnumMember(Value = "SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE")]
        SubordinatedEuropeanInsuranceCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SUKUK CORPORATE.
        /// </summary>
        [EnumMember(Value = "SUKUK_CORPORATE")]
        SukukCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SUKUK FINANCIAL CORPORATE.
        /// </summary>
        [EnumMember(Value = "SUKUK_FINANCIAL_CORPORATE")]
        SukukFinancialCorporate,
        
        /// <summary>
        /// Matrix Transaction Type of SUKUK SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "SUKUK_SOVEREIGN")]
        SukukSovereign,
        
        /// <summary>
        /// Matrix Transaction Type of U.S. MUNICIPAL FULL FAITH AND CREDIT.
        /// </summary>
        [EnumMember(Value = "US_MUNICIPAL_FULL_FAITH_AND_CREDIT")]
        USMunicipalFullFaithAndCredit,
        
        /// <summary>
        /// Matrix Transaction Type of U.S. MUNICIPAL GENERAL FUND.
        /// </summary>
        [EnumMember(Value = "US_MUNICIPAL_GENERAL_FUND")]
        USMunicipalGeneralFund,
        
        /// <summary>
        /// Matrix Transaction Type of U.S. MUNICIPAL REVENUE.
        /// </summary>
        [EnumMember(Value = "US_MUNICIPAL_REVENUE")]
        USMunicipalRevenue,
        
        /// <summary>
        /// Matrix Transaction Type of WESTERN EUROPEAN SOVEREIGN.
        /// </summary>
        [EnumMember(Value = "WESTERN_EUROPEAN_SOVEREIGN")]
        WesternEuropeanSovereign
    }
    
    /// <summary>
    /// The enumerated values to specify the identification the form of applicable matrix.
    /// </summary>
    [CdmName("MatrixTypeEnum")]
    public enum MatrixType
    {
        /// <summary>
        /// The ISDA-published Credit Derivatives Physical Settlement Matrix.
        /// </summary>
        [EnumMember(Value = "CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX")]
        CreditDerivativesPhysicalSettlementMatrix,
        
        /// <summary>
        /// The ISDA-published Equity Derivatives Matrix.
        /// </summary>
        [EnumMember(Value = "EQUITY_DERIVATIVES_MATRIX")]
        EquityDerivativesMatrix,
        
        /// <summary>
        /// The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions.
        /// </summary>
        [EnumMember(Value = "SETTLEMENT_MATRIX")]
        SettlementMatrix
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the Maturity.
    /// </summary>
    [CdmName("MaturityTypeEnum")]
    public enum MaturityType
    {
        /// <summary>
        /// Denotes a period from issuance date until now.
        /// </summary>
        [EnumMember(Value = "FROM_ISSUANCE")]
        FromIssuance,
        
        /// <summary>
        /// Denotes a period from issuance until maturity date.
        /// </summary>
        [EnumMember(Value = "ORIGINAL_MATURITY")]
        OriginalMaturity,
        
        /// <summary>
        /// Denotes a period from now until maturity date.
        /// </summary>
        [EnumMember(Value = "REMAINING_MATURITY")]
        RemainingMaturity
    }
    
    [CdmName("MoneyMarketTypeEnum")]
    public enum MoneyMarketType
    {
        [EnumMember(Value = "CERTIFICATE_OF_DEPOSIT")]
        CertificateOfDeposit,
        
        [EnumMember(Value = "COMMERCIAL_PAPER")]
        CommercialPaper
    }
    
    /// <summary>
    /// Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
    /// </summary>
    [CdmName("NationalizationOrInsolvencyOrDelistingEventEnum")]
    public enum NationalizationOrInsolvencyOrDelistingEvent
    {
        /// <summary>
        /// The trade is terminated.
        /// </summary>
        [EnumMember(Value = "CANCELLATION_AND_PAYMENT")]
        CancellationAndPayment,
        
        /// <summary>
        /// The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
        /// </summary>
        [EnumMember(Value = "NEGOTIATED_CLOSEOUT")]
        NegotiatedCloseout
    }
    
    /// <summary>
    /// The enumerated values for the natural person&apos;s role.
    /// </summary>
    [CdmName("NaturalPersonRoleEnum")]
    public enum NaturalPersonRole
    {
        /// <summary>
        /// The person who arranged with a client to execute the trade.
        /// </summary>
        [EnumMember(Value = "BROKER")]
        Broker,
        
        /// <summary>
        /// Acquirer of the legal title to the financial instrument.
        /// </summary>
        [EnumMember(Value = "BUYER")]
        Buyer,
        
        /// <summary>
        /// The party or person with legal responsibility for authorization of the execution of the transaction.
        /// </summary>
        [EnumMember(Value = "DECISION_MAKER")]
        DecisionMaker,
        
        /// <summary>
        /// Person within the firm who is responsible for execution of the transaction.
        /// </summary>
        [EnumMember(Value = "EXECUTION_WITHIN_FIRM")]
        ExecutionWithinFirm,
        
        /// <summary>
        /// Person who is responsible for making the investment decision.
        /// </summary>
        [EnumMember(Value = "INVESTMENT_DECISION_MAKER")]
        InvestmentDecisionMaker,
        
        /// <summary>
        /// Seller of the legal title to the financial instrument.
        /// </summary>
        [EnumMember(Value = "SELLER")]
        Seller,
        
        /// <summary>
        /// The person who executed the trade.
        /// </summary>
        [EnumMember(Value = "TRADER")]
        Trader
    }
    
    /// <summary>
    /// The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
    /// </summary>
    [CdmName("NegativeInterestRateTreatmentEnum")]
    public enum NegativeInterestRateTreatment
    {
        /// <summary>
        /// Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c).
        /// </summary>
        [EnumMember(Value = "NEGATIVE_INTEREST_RATE_METHOD")]
        NegativeInterestRateMethod,
        
        /// <summary>
        /// Per 2021 ISDA Definitions section 6.8.6
        /// </summary>
        [EnumMember(Value = "ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD")]
        ZeroInterestRateExcludingSpreadMethod,
        
        /// <summary>
        /// Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e).
        /// </summary>
        [EnumMember(Value = "ZERO_INTEREST_RATE_METHOD")]
        ZeroInterestRateMethod
    }
    
    /// <summary>
    /// The enumerated values to specify the treatment of Non-Cash Dividends.
    /// </summary>
    [CdmName("NonCashDividendTreatmentEnum")]
    public enum NonCashDividendTreatment
    {
        /// <summary>
        /// Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
        /// </summary>
        [EnumMember(Value = "CASH_EQUIVALENT")]
        CashEquivalent,
        
        /// <summary>
        /// The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
        /// </summary>
        [EnumMember(Value = "POTENTIAL_ADJUSTMENT_EVENT")]
        PotentialAdjustmentEvent
    }
    
    /// <summary>
    /// The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
    /// </summary>
    [CdmName("NotionalAdjustmentEnum")]
    public enum NotionalAdjustment
    {
        /// <summary>
        /// The adjustments to the number of units are governed by an execution clause.
        /// </summary>
        [EnumMember(Value = "EXECUTION")]
        Execution,
        
        /// <summary>
        /// The adjustments to the number of units are governed by a portfolio rebalancing clause.
        /// </summary>
        [EnumMember(Value = "PORTFOLIO_REBALANCING")]
        PortfolioRebalancing,
        
        /// <summary>
        /// The adjustments to the number of units are not governed by any specific clause.
        /// </summary>
        [EnumMember(Value = "STANDARD")]
        Standard
    }
    
    /// <summary>
    /// The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply.
    /// </summary>
    [CdmName("ObligationCategoryEnum")]
    public enum ObligationCategory
    {
        /// <summary>
        /// ISDA term &apos;Bond&apos;.
        /// </summary>
        [EnumMember(Value = "BOND")]
        Bond,
        
        /// <summary>
        /// ISDA term &apos;Bond or Loan&apos;.
        /// </summary>
        [EnumMember(Value = "BOND_OR_LOAN")]
        BondOrLoan,
        
        /// <summary>
        /// ISDA term &apos;Borrowed Money&apos;.
        /// </summary>
        [EnumMember(Value = "BORROWED_MONEY")]
        BorrowedMoney,
        
        /// <summary>
        /// ISDA term &apos;Loan&apos;.
        /// </summary>
        [EnumMember(Value = "LOAN")]
        Loan,
        
        /// <summary>
        /// ISDA term &apos;Payment&apos;.
        /// </summary>
        [EnumMember(Value = "PAYMENT")]
        Payment,
        
        /// <summary>
        /// ISDA term &apos;Reference Obligations Only&apos;.
        /// </summary>
        [EnumMember(Value = "REFERENCE_OBLIGATIONS_ONLY")]
        ReferenceObligationsOnly
    }
    
    /// <summary>
    /// The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
    /// </summary>
    [CdmName("ObservationPeriodDatesEnum")]
    public enum ObservationPeriodDates
    {
        /// <summary>
        /// Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
        /// </summary>
        [EnumMember(Value = "FIXING_DATE")]
        FixingDate,
        
        /// <summary>
        /// Calculations occur relative to the first day of a calculation period.
        /// </summary>
        [EnumMember(Value = "SET_IN_ADVANCE")]
        SetInAdvance,
        
        /// <summary>
        /// Calculations occur relative to the last day of a calculation period (set in arrears).
        /// </summary>
        [EnumMember(Value = "STANDARD")]
        Standard
    }
    
    /// <summary>
    /// The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
    /// </summary>
    [CdmName("OptionExerciseStyleEnum")]
    public enum OptionExerciseStyle
    {
        /// <summary>
        /// Continuous exercise over a range of dates
        /// </summary>
        [EnumMember(Value = "AMERICAN")]
        American,
        
        /// <summary>
        /// Multiple specified exercise dates
        /// </summary>
        [EnumMember(Value = "BERMUDA")]
        Bermuda,
        
        /// <summary>
        /// Single Exercise
        /// </summary>
        [EnumMember(Value = "EUROPEAN")]
        European
    }
    
    /// <summary>
    /// The enumerated values to specify the type or strategy of the option.
    /// </summary>
    [CdmName("OptionTypeEnum")]
    public enum OptionType
    {
        /// <summary>
        /// A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
        /// </summary>
        [EnumMember(Value = "CALL")]
        Call,
        
        /// <summary>
        /// A &apos;payer&apos; option: If you buy a &apos;payer&apos; option you have the right but not the obligation to enter into the underlying swap transaction as the &apos;fixed&apos; rate/price payer and receive float.
        /// </summary>
        [EnumMember(Value = "PAYER")]
        Payer,
        
        /// <summary>
        /// A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
        /// </summary>
        [EnumMember(Value = "PUT")]
        Put,
        
        /// <summary>
        /// A &apos;receiver&apos; option: If you buy a &apos;receiver&apos; option you have the right but not the obligation to enter into the underlying swap transaction as the &apos;fixed&apos; rate/price receiver and pay float.
        /// </summary>
        [EnumMember(Value = "RECEIVER")]
        Receiver,
        
        /// <summary>
        /// A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
        /// </summary>
        [EnumMember(Value = "STRADDLE")]
        Straddle
    }
    
    /// <summary>
    /// The enumerated values to specify how a calculation agent will be determined.
    /// </summary>
    [CdmName("PartyDeterminationEnum")]
    public enum PartyDetermination
    {
        /// <summary>
        /// The Calculation Agent is determined by reference to the relevant master agreement.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_AGREEMENT")]
        AsSpecifiedInMasterAgreement,
        
        /// <summary>
        /// The Calculation Agent is determined by reference to the relevant standard terms supplement.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT")]
        AsSpecifiedInStandardTermsSupplement,
        
        /// <summary>
        /// Both parties with joined rights to be a calculation agent.
        /// </summary>
        [EnumMember(Value = "BOTH")]
        Both,
        
        /// <summary>
        /// The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d).
        /// </summary>
        [EnumMember(Value = "EXERCISING_PARTY")]
        ExercisingParty,
        
        /// <summary>
        /// The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e).
        /// </summary>
        [EnumMember(Value = "NON_EXERCISING_PARTY")]
        NonExercisingParty
    }
    
    /// <summary>
    /// The enumeration values associated with party identifier sources.
    /// </summary>
    [CdmName("PartyIdentifierTypeEnum")]
    public enum PartyIdentifierType
    {
        /// <summary>
        /// The Bank Identifier Code.
        /// </summary>
        BIC,
        
        /// <summary>
        /// The ISO 17442:2012 Legal Entity Identifier.
        /// </summary>
        LEI,
        
        /// <summary>
        /// The ISO 10383 Market Identifier Code (MIC).
        /// </summary>
        MIC
    }
    
    /// <summary>
    /// The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party.
    /// </summary>
    [CdmName("PartyRoleEnum")]
    public enum PartyRole
    {
        /// <summary>
        /// Organization responsible for preparing the accounting for the trade.
        /// </summary>
        [EnumMember(Value = "ACCOUNTANT")]
        Accountant,
        
        /// <summary>
        /// An agent who lends securities of its principals under stock lending arrangements.
        /// </summary>
        [EnumMember(Value = "AGENT_LENDER")]
        AgentLender,
        
        /// <summary>
        /// The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations.
        /// </summary>
        [EnumMember(Value = "ALLOCATION_AGENT")]
        AllocationAgent,
        
        /// <summary>
        /// The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent.
        /// </summary>
        [EnumMember(Value = "ARRANGING_BROKER")]
        ArrangingBroker,
        
        /// <summary>
        /// The party specified in the related confirmation as Barrier Determination Agent.
        /// </summary>
        [EnumMember(Value = "BARRIER_DETERMINATION_AGENT")]
        BarrierDeterminationAgent,
        
        /// <summary>
        /// The party that lends out securities under stock lending arrangements via an Agent Lender.
        /// </summary>
        [EnumMember(Value = "BENEFICIAL_OWNER")]
        BeneficialOwner,
        
        /// <summary>
        /// Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of &apos;Beneficiary&apos; at the partyTradeInformation level.
        /// </summary>
        [EnumMember(Value = "BENEFICIARY")]
        Beneficiary,
        
        /// <summary>
        /// The entity for which the organization supporting the trade&apos;s processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn&apos;t need to be reported but a firm still wants to specify their own side.
        /// </summary>
        [EnumMember(Value = "BOOKING_PARTY")]
        BookingParty,
        
        /// <summary>
        /// The party that borrows securities under stock lending arrangements.
        /// </summary>
        [EnumMember(Value = "BORROWER")]
        Borrower,
        
        /// <summary>
        /// Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the &apos;Buy side&apos;; for that, see the &apos;Client&apos; role. Corresponds to &apos;Buyer&apos; as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9.
        /// </summary>
        [EnumMember(Value = "BUYER")]
        Buyer,
        
        /// <summary>
        /// The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to &apos;buyer decision maker&apos; as defined in ESMA&apos;s MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the &apos;Buy side&apos;; for that, see the &apos;Client Decision Maker&apos; role.
        /// </summary>
        [EnumMember(Value = "BUYER_DECISION_MAKER")]
        BuyerDecisionMaker,
        
        /// <summary>
        /// The party that provides credit support under English Law.
        /// </summary>
        [EnumMember(Value = "CHARGOR")]
        Chargor,
        
        /// <summary>
        /// An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term &apos;client&apos; refers to the organization&apos;s role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process.
        /// </summary>
        [EnumMember(Value = "CLEARING_CLIENT")]
        ClearingClient,
        
        /// <summary>
        /// A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions.
        /// </summary>
        [EnumMember(Value = "CLEARING_EXCEPTION_PARTY")]
        ClearingExceptionParty,
        
        /// <summary>
        /// Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use &apos;Clearing Broker&apos; as synonym.
        /// </summary>
        [EnumMember(Value = "CLEARING_FIRM")]
        ClearingFirm,
        
        /// <summary>
        /// The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called &apos;ClearingService&apos;. Some implementations also use the term &apos;Clearer&apos;.
        /// </summary>
        [EnumMember(Value = "CLEARING_ORGANIZATION")]
        ClearingOrganization,
        
        /// <summary>
        /// Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances.
        /// </summary>
        [EnumMember(Value = "CLIENT")]
        Client,
        
        /// <summary>
        /// The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument.
        /// </summary>
        [EnumMember(Value = "CLIENT_DECISION_MAKER")]
        ClientDecisionMaker,
        
        /// <summary>
        /// Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data.
        /// </summary>
        [EnumMember(Value = "CONFIRMATION_PLATFORM")]
        ConfirmationPlatform,
        
        /// <summary>
        /// A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
        /// </summary>
        [EnumMember(Value = "CONTRACTUAL_PARTY")]
        ContractualParty,
        
        /// <summary>
        /// Organization officially attached to the counterparty. e.g. partner, branch, subsidiary.
        /// </summary>
        [EnumMember(Value = "COUNTER_PARTY_AFFILIATE")]
        CounterPartyAffiliate,
        
        /// <summary>
        /// The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
        /// </summary>
        [EnumMember(Value = "COUNTER_PARTY_ULTIMATE_PARENT")]
        CounterPartyUltimateParent,
        
        /// <summary>
        /// An economic counterparty to the trade. Synonym: principal.
        /// </summary>
        [EnumMember(Value = "COUNTERPARTY")]
        Counterparty,
        
        /// <summary>
        /// Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation).
        /// </summary>
        [EnumMember(Value = "CREDIT_SUPPORT_PROVIDER")]
        CreditSupportProvider,
        
        /// <summary>
        /// Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal.
        /// </summary>
        [EnumMember(Value = "CUSTODIAN")]
        Custodian,
        
        /// <summary>
        /// Entity submitting the transaction report to the competent authority.
        /// </summary>
        [EnumMember(Value = "DATA_SUBMITTER")]
        DataSubmitter,
        
        /// <summary>
        /// The party referenced is specified in the contract confirmation as Determination Party.
        /// </summary>
        [EnumMember(Value = "DETERMINING_PARTY")]
        DeterminingParty,
        
        /// <summary>
        /// Organization that is disputing the trade or transaction.
        /// </summary>
        [EnumMember(Value = "DISPUTING_PARTY")]
        DisputingParty,
        
        /// <summary>
        /// A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
        /// </summary>
        [EnumMember(Value = "DOCUMENT_REPOSITORY")]
        DocumentRepository,
        
        /// <summary>
        /// The (generally sell-side) organization that executed the trade; the price-making party.
        /// </summary>
        [EnumMember(Value = "EXECUTING_BROKER")]
        ExecutingBroker,
        
        /// <summary>
        /// Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent.
        /// </summary>
        [EnumMember(Value = "EXECUTING_ENTITY")]
        ExecutingEntity,
        
        /// <summary>
        /// The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different.
        /// </summary>
        [EnumMember(Value = "EXECUTION_AGENT")]
        ExecutionAgent,
        
        /// <summary>
        /// The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue.
        /// </summary>
        [EnumMember(Value = "EXECUTION_FACILITY")]
        ExecutionFacility,
        
        /// <summary>
        /// Organization that backs (guarantees) the credit risk of the trade.
        /// </summary>
        [EnumMember(Value = "GUARANTOR")]
        Guarantor,
        
        /// <summary>
        /// The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract.
        /// </summary>
        [EnumMember(Value = "HEDGING_PARTY")]
        HedgingParty,
        
        /// <summary>
        /// The party that lends out securities under stock lending arrangements as principal.
        /// </summary>
        [EnumMember(Value = "LENDER")]
        Lender,
        
        /// <summary>
        /// The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm.
        /// </summary>
        [EnumMember(Value = "ORDER_TRANSMITTER")]
        OrderTransmitter,
        
        /// <summary>
        /// The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR
        /// </summary>
        [EnumMember(Value = "PTRR_SERVICE_PROVIDER")]
        PTRRServiceProvider,
        
        /// <summary>
        /// The party that provides credit support under New York Law.
        /// </summary>
        [EnumMember(Value = "PLEDGOR")]
        Pledgor,
        
        /// <summary>
        /// The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism).
        /// </summary>
        [EnumMember(Value = "PRIME_BROKER")]
        PrimeBroker,
        
        /// <summary>
        /// The trade repository at which the trade was reported previous to the current trade repository.
        /// </summary>
        [EnumMember(Value = "PRIOR_TRADE_REPOSITORY")]
        PriorTradeRepository,
        
        /// <summary>
        /// The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade.
        /// </summary>
        [EnumMember(Value = "PUBLICATION_VENUE")]
        PublicationVenue,
        
        /// <summary>
        /// The party with the regulatory responsibility to report this trade.
        /// </summary>
        [EnumMember(Value = "REPORTING_PARTY")]
        ReportingParty,
        
        /// <summary>
        /// Organization officially attached to the reporting party  e.g. partner, branch, subsidiary.
        /// </summary>
        [EnumMember(Value = "REPORTING_PARTY_AFFILIATE")]
        ReportingPartyAffiliate,
        
        /// <summary>
        /// The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
        /// </summary>
        [EnumMember(Value = "REPORTING_PARTY_ULTIMATE_PARENT")]
        ReportingPartyUltimateParent,
        
        /// <summary>
        /// The party that receives credit support under New York or English Law.
        /// </summary>
        [EnumMember(Value = "SECURED_PARTY")]
        SecuredParty,
        
        /// <summary>
        /// A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the &apos;Sell side&apos;; for that, see the &apos;Executing Broker&apos; role. Corresponds to &apos;Seller&apos; as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16.
        /// </summary>
        [EnumMember(Value = "SELLER")]
        Seller,
        
        /// <summary>
        /// The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to &apos;seller decision maker&apos; as defined in ESMA&apos;s MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the &apos;Sell side&apos;; for that, see the &apos;Trader&apos; person role.
        /// </summary>
        [EnumMember(Value = "SELLER_DECISION_MAKER")]
        SellerDecisionMaker,
        
        /// <summary>
        /// The organization that makes or receives payments on behalf of the given principal party.
        /// </summary>
        [EnumMember(Value = "SETTLEMENT_AGENT")]
        SettlementAgent,
        
        /// <summary>
        /// A third-party providing custody, settlement, segregation and reporting services.
        /// </summary>
        [EnumMember(Value = "THIRD_PARTY_CUSTODIAN")]
        ThirdPartyCustodian,
        
        /// <summary>
        /// An organization that maintains records of the trade for regulatory reporting purposes.
        /// </summary>
        [EnumMember(Value = "TRADE_REPOSITORY")]
        TradeRepository,
        
        /// <summary>
        /// The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR.
        /// </summary>
        [EnumMember(Value = "TRADE_SOURCE")]
        TradeSource,
        
        /// <summary>
        /// The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory.
        /// </summary>
        [EnumMember(Value = "TRADING_MANAGER")]
        TradingManager,
        
        /// <summary>
        /// An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions.
        /// </summary>
        [EnumMember(Value = "TRADING_PARTNER")]
        TradingPartner,
        
        /// <summary>
        /// A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services.
        /// </summary>
        [EnumMember(Value = "TRIPARTY_AGENT")]
        TripartyAgent
    }
    
    /// <summary>
    /// The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date.
    /// </summary>
    [CdmName("PayRelativeToEnum")]
    public enum PayRelativeTo
    {
        /// <summary>
        /// Payments will occur relative to the last day of each calculation period.
        /// </summary>
        [EnumMember(Value = "CALCULATION_PERIOD_END_DATE")]
        CalculationPeriodEndDate,
        
        /// <summary>
        /// Payments will occur relative to the first day of each calculation period.
        /// </summary>
        [EnumMember(Value = "CALCULATION_PERIOD_START_DATE")]
        CalculationPeriodStartDate,
        
        /// <summary>
        /// Payments will occur relative to the last Pricing Date of each Calculation Period.
        /// </summary>
        [EnumMember(Value = "LAST_PRICING_DATE")]
        LastPricingDate,
        
        /// <summary>
        /// Payments will occur relative to the reset date.
        /// </summary>
        [EnumMember(Value = "RESET_DATE")]
        ResetDate,
        
        /// <summary>
        /// Payments will occur relative to the valuation date.
        /// </summary>
        [EnumMember(Value = "VALUATION_DATE")]
        ValuationDate
    }
    
    /// <summary>
    /// The enumerated values to specify an interest rate stream payer or receiver party.
    /// </summary>
    [CdmName("PayerReceiverEnum")]
    public enum PayerReceiver
    {
        /// <summary>
        /// The party identified as the stream payer.
        /// </summary>
        [EnumMember(Value = "PAYER")]
        Payer,
        
        /// <summary>
        /// The party identified as the stream receiver.
        /// </summary>
        [EnumMember(Value = "RECEIVER")]
        Receiver
    }
    
    /// <summary>
    /// The enumerated values to specify the origin of a performance transfer
    /// </summary>
    [CdmName("PerformanceTransferTypeEnum")]
    public enum PerformanceTransferType
    {
        [EnumMember(Value = "COMMODITY")]
        Commodity,
        
        [EnumMember(Value = "CORRELATION")]
        Correlation,
        
        [EnumMember(Value = "DIVIDEND")]
        Dividend,
        
        [EnumMember(Value = "EQUITY")]
        Equity,
        
        [EnumMember(Value = "INTEREST")]
        Interest,
        
        [EnumMember(Value = "VARIANCE")]
        Variance,
        
        [EnumMember(Value = "VOLATILITY")]
        Volatility
    }
    
    /// <summary>
    /// The enumerated values to specify the period, e.g. day, week.
    /// </summary>
    [CdmName("PeriodEnum")]
    public enum Period
    {
        /// <summary>
        /// Day
        /// </summary>
        D,
        
        /// <summary>
        /// Month
        /// </summary>
        M,
        
        /// <summary>
        /// Week
        /// </summary>
        W,
        
        /// <summary>
        /// Year
        /// </summary>
        Y
    }
    
    /// <summary>
    /// The enumerated values to specify a time period containing the additional value of Term.
    /// </summary>
    [CdmName("PeriodExtendedEnum")]
    public enum PeriodExtended
    {
        /// <summary>
        /// CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
        /// </summary>
        C,
        
        /// <summary>
        /// Day
        /// </summary>
        D,
        
        /// <summary>
        /// Hour
        /// </summary>
        H,
        
        /// <summary>
        /// Month
        /// </summary>
        M,
        
        /// <summary>
        /// Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
        /// </summary>
        T,
        
        /// <summary>
        /// Week
        /// </summary>
        W,
        
        /// <summary>
        /// Year
        /// </summary>
        Y
    }
    
    /// <summary>
    /// The enumeration values to specify a time period containing additional values such as Term.
    /// </summary>
    [CdmName("PeriodTimeEnum")]
    public enum PeriodTime
    {
        /// <summary>
        /// Period measured in hours.
        /// </summary>
        [EnumMember(Value = "HOUR")]
        Hour,
        
        /// <summary>
        /// Period measured in minutes.
        /// </summary>
        [EnumMember(Value = "MINUTE")]
        Minute,
        
        /// <summary>
        /// Period measured in seconds.
        /// </summary>
        [EnumMember(Value = "SECOND")]
        Second
    }
    
    /// <summary>
    /// The enumeration values associated with person identifier sources.
    /// </summary>
    [CdmName("PersonIdentifierTypeEnum")]
    public enum PersonIdentifierType
    {
        /// <summary>
        /// Alien Registration Number, number assigned by a social security agency to identify a non-resident person.
        /// </summary>
        [RosettaSynonym(Value = "ARNU", Source = "ISO20022")]
        ARNU,
        
        /// <summary>
        /// Passport Number, number assigned by an authority to identify the passport number of a person.
        /// </summary>
        [RosettaSynonym(Value = "CCPT", Source = "ISO20022")]
        CCPT,
        
        /// <summary>
        /// Customer Identification Number, number assigned by an issuer to identify a customer.
        /// </summary>
        [RosettaSynonym(Value = "CUST", Source = "ISO20022")]
        CUST,
        
        /// <summary>
        /// Drivers License Number, number assigned by an authority to identify a driver&apos;s license.
        /// </summary>
        [RosettaSynonym(Value = "DRLC", Source = "ISO20022")]
        DRLC,
        
        /// <summary>
        /// Employee Identification Number, number assigned by a registration authority to an employee.
        /// </summary>
        [RosettaSynonym(Value = "EMPL", Source = "ISO20022")]
        EMPL,
        
        /// <summary>
        /// National Identity Number, number assigned by an authority to identify the national identity number of a person..
        /// </summary>
        [RosettaSynonym(Value = "NIDN", Source = "ISO20022")]
        NIDN,
        
        /// <summary>
        /// Natural Person Identifier. To identify the person who is acting as private individual, not as business entity. Used for regulatory reporting.
        /// </summary>
        NPID,
        
        /// <summary>
        /// Privacy Law Identifier. It refers to the DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
        /// </summary>
        PLID,
        
        /// <summary>
        /// Social Security Number, number assigned by an authority to identify the social security number of a person.
        /// </summary>
        [RosettaSynonym(Value = "SOSE", Source = "ISO20022")]
        SOSE,
        
        /// <summary>
        /// Tax Identification Number, number assigned by a tax authority to identify a person.
        /// </summary>
        [RosettaSynonym(Value = "TXID", Source = "ISO20022")]
        TXID
    }
    
    [CdmName("PositionEventIntentEnum")]
    public enum PositionEventIntent
    {
        /// <summary>
        /// The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
        /// </summary>
        [EnumMember(Value = "CORPORATE_ACTION_ADJUSTMENT")]
        CorporateActionAdjustment,
        
        /// <summary>
        /// The intent is to Decrease the quantity of the position.
        /// </summary>
        [EnumMember(Value = "DECREASE")]
        Decrease,
        
        /// <summary>
        /// The intent is to Increase the quantity of the position.
        /// </summary>
        [EnumMember(Value = "INCREASE")]
        Increase,
        
        /// <summary>
        /// The intent is to Exercise a position or part of a position.
        /// </summary>
        [EnumMember(Value = "OPTION_EXERCISE")]
        OptionExercise,
        
        /// <summary>
        /// The intent is to form a position from a fully formed contract.
        /// </summary>
        [EnumMember(Value = "POSITION_CREATION")]
        PositionCreation,
        
        /// <summary>
        /// The intent is to transfer the position to another clearing member.
        /// </summary>
        [EnumMember(Value = "TRANSFER")]
        Transfer,
        
        /// <summary>
        /// The intent is to update the valuation of the position.
        /// </summary>
        [EnumMember(Value = "VALUATION")]
        Valuation
    }
    
    /// <summary>
    /// Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
    /// </summary>
    [CdmName("PositionStatusEnum")]
    public enum PositionStatus
    {
        /// <summary>
        /// The position has been cancelled, in case of a cancellation event following an execution.
        /// </summary>
        [EnumMember(Value = "CANCELLED")]
        Cancelled,
        
        /// <summary>
        /// The position has been closed, in case of a termination event.
        /// </summary>
        [EnumMember(Value = "CLOSED")]
        Closed,
        
        /// <summary>
        /// The position has been executed, which is the point at which risk has been transferred.
        /// </summary>
        [EnumMember(Value = "EXECUTED")]
        Executed,
        
        /// <summary>
        /// Contract has been formed, in case position is on a contractual product.
        /// </summary>
        [EnumMember(Value = "FORMED")]
        Formed,
        
        /// <summary>
        /// The position has settled, in case product is subject to settlement after execution, such as securities.
        /// </summary>
        [EnumMember(Value = "SETTLED")]
        Settled
    }
    
    /// <summary>
    /// The enumerated values to specify the premium type for forward start options.
    /// </summary>
    [CdmName("PremiumTypeEnum")]
    public enum PremiumType
    {
        [EnumMember(Value = "FIXED")]
        Fixed,
        
        [EnumMember(Value = "POST_PAID")]
        PostPaid,
        
        [EnumMember(Value = "PRE_PAID")]
        PrePaid,
        
        [EnumMember(Value = "VARIABLE")]
        Variable
    }
    
    /// <summary>
    /// Enumerated values to specify whether the price is expressed in absolute or relative terms.
    /// </summary>
    [CdmName("PriceExpressionEnum")]
    public enum PriceExpression
    {
        /// <summary>
        /// The price is expressed as an absolute amount.
        /// </summary>
        [EnumMember(Value = "ABSOLUTE_TERMS")]
        AbsoluteTerms,
        
        /// <summary>
        /// Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
        /// </summary>
        [EnumMember(Value = "PAR_VALUE_FRACTION")]
        ParValueFraction,
        
        /// <summary>
        /// Denotes a price expressed per number of options.
        /// </summary>
        [EnumMember(Value = "PER_OPTION")]
        PerOption,
        
        /// <summary>
        /// The price is expressed in percentage of the notional amount.
        /// </summary>
        [EnumMember(Value = "PERCENTAGE_OF_NOTIONAL")]
        PercentageOfNotional
    }
    
    [CdmName("PriceOperandEnum")]
    public enum PriceOperand
    {
        [EnumMember(Value = "ACCRUED_INTEREST")]
        AccruedInterest,
        
        [EnumMember(Value = "COMMISSION")]
        Commission,
        
        [EnumMember(Value = "FORWARD_POINT")]
        ForwardPoint
    }
    
    [CdmName("PriceTimingEnum")]
    public enum PriceTiming
    {
        /// <summary>
        /// The last price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
        /// </summary>
        [EnumMember(Value = "CLOSING_PRICE")]
        ClosingPrice,
        
        /// <summary>
        /// The first price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
        /// </summary>
        [EnumMember(Value = "OPENING_PRICE")]
        OpeningPrice
    }
    
    /// <summary>
    /// Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations.
    /// </summary>
    [CdmName("PriceTypeEnum")]
    public enum PriceType
    {
        /// <summary>
        /// Denotes a price expressed as a cash amount in a given currency to purchase a unit of an asset (e.g. a security or a commodity).
        /// </summary>
        [EnumMember(Value = "ASSET_PRICE")]
        AssetPrice,
        
        /// <summary>
        /// Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500.
        /// </summary>
        [EnumMember(Value = "CASH_PRICE")]
        CashPrice,
        
        /// <summary>
        /// Denotes a price expressed as the weighted average of all pairwise correlation coefficients.
        /// </summary>
        [EnumMember(Value = "CORRELATION")]
        Correlation,
        
        /// <summary>
        /// Denotes a price expressed as the dividend payment from a index or share.
        /// </summary>
        [EnumMember(Value = "DIVIDEND")]
        Dividend,
        
        /// <summary>
        /// Denotes a rate to convert one currency or other measure of value to another. Foreign Exchange rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP.
        /// </summary>
        [EnumMember(Value = "EXCHANGE_RATE")]
        ExchangeRate,
        
        /// <summary>
        /// Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount.
        /// </summary>
        [EnumMember(Value = "INTEREST_RATE")]
        InterestRate,
        
        /// <summary>
        /// Denotes a price expressed as the the arithmetic average of the squared differences from the mean value of an observable price.
        /// </summary>
        [EnumMember(Value = "VARIANCE")]
        Variance,
        
        /// <summary>
        /// Denotes a price expressed as the the square root of the arithmetic average of the squared differences from the mean value of an observable price.
        /// </summary>
        [EnumMember(Value = "VOLATILITY")]
        Volatility
    }
    
    /// <summary>
    /// Provides the enumerated values to specify the product identifier source.
    /// </summary>
    [CdmName("ProductIdTypeEnum")]
    public enum ProductIdType
    {
        /// <summary>
        /// Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
        /// </summary>
        BBGID,
        
        /// <summary>
        /// Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
        /// </summary>
        BBGTICKER,
        
        /// <summary>
        /// Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
        /// </summary>
        CUSIP,
        
        /// <summary>
        /// Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
        /// </summary>
        FIGI,
        
        /// <summary>
        /// Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
        /// </summary>
        ISDACRP,
        
        /// <summary>
        /// Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
        /// </summary>
        ISIN,
        
        /// <summary>
        /// The name of the product.
        /// </summary>
        [EnumMember(Value = "NAME")]
        Name,
        
        /// <summary>
        /// Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
        /// </summary>
        RIC,
        
        /// <summary>
        /// Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security&apos;s ISIN as well.
        /// </summary>
        SEDOL,
        
        /// <summary>
        /// Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
        /// </summary>
        [EnumMember(Value = "SICOVAM")]
        Sicovam,
        
        /// <summary>
        /// Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
        /// </summary>
        UPI,
        
        /// <summary>
        /// Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
        /// </summary>
        [EnumMember(Value = "WERTPAPIER")]
        Wertpapier
    }
    
    /// <summary>
    /// The enumerated values to specify the types of listed derivative options.
    /// </summary>
    [CdmName("PutCallEnum")]
    public enum PutCall
    {
        /// <summary>
        /// A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
        /// </summary>
        [EnumMember(Value = "CALL")]
        Call,
        
        /// <summary>
        /// A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
        /// </summary>
        [EnumMember(Value = "PUT")]
        Put
    }
    
    /// <summary>
    /// Represents the enumerated values to specify a logical quantification, i.e. either All or Any.
    /// </summary>
    [CdmName("QuantifierEnum")]
    public enum Quantifier
    {
        /// <summary>
        /// Specifies that the condition in the scope of the quantifier is true of every member of the domain i.e. every one of the elements in scope.
        /// </summary>
        [EnumMember(Value = "ALL")]
        All,
        
        /// <summary>
        /// Specifies that the condition in the scope of the quantifier is true of at least one member of the domain i.e. one or more of the elements in scope.
        /// </summary>
        [EnumMember(Value = "ANY")]
        Any
    }
    
    /// <summary>
    /// Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number.
    /// </summary>
    [CdmName("QuantityChangeDirectionEnum")]
    public enum QuantityChangeDirection
    {
        /// <summary>
        /// When the quantity should go down by the specified amount.
        /// </summary>
        [EnumMember(Value = "DECREASE")]
        Decrease,
        
        /// <summary>
        /// When the quantity should go up by the specified amount.
        /// </summary>
        [EnumMember(Value = "INCREASE")]
        Increase,
        
        /// <summary>
        /// When the quantity should be replaced by the specified amount.
        /// </summary>
        [EnumMember(Value = "REPLACE")]
        Replace
    }
    
    /// <summary>
    /// The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
    /// </summary>
    [CdmName("QuotationRateTypeEnum")]
    public enum QuotationRateType
    {
        /// <summary>
        /// An ask rate.
        /// </summary>
        [EnumMember(Value = "ASK")]
        Ask,
        
        /// <summary>
        /// A bid rate.
        /// </summary>
        [EnumMember(Value = "BID")]
        Bid,
        
        /// <summary>
        /// If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
        /// </summary>
        [EnumMember(Value = "EXERCISING_PARTY_PAYS")]
        ExercisingPartyPays,
        
        /// <summary>
        /// A mid-market rate.
        /// </summary>
        [EnumMember(Value = "MID")]
        Mid
    }
    
    /// <summary>
    /// The enumerated values to specify the side from which perspective a value is quoted.
    /// </summary>
    [CdmName("QuotationSideEnum")]
    public enum QuotationSide
    {
        /// <summary>
        /// Denotes a value as the Afternoon fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "AFTERNOON")]
        Afternoon,
        
        /// <summary>
        /// Denotes a value &apos;asked&apos; by a seller for an asset, i.e. the value at which a seller is willing to sell.
        /// </summary>
        [EnumMember(Value = "ASK")]
        Ask,
        
        /// <summary>
        /// Denotes a value &apos;bid&apos; by a buyer for an asset, i.e. the value a buyer is willing to pay.
        /// </summary>
        [EnumMember(Value = "BID")]
        Bid,
        
        /// <summary>
        /// Denotes a value as the Closing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "CLOSING")]
        Closing,
        
        /// <summary>
        /// Denotes a value as the High price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "HIGH")]
        High,
        
        /// <summary>
        /// Denotes a value as the Index price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "INDEX")]
        Index,
        
        /// <summary>
        /// Denotes a value as the Locational Marginal price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "LOCATIONAL_MARGINAL")]
        LocationalMarginal,
        
        /// <summary>
        /// Denotes a value as the Low price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "LOW")]
        Low,
        
        /// <summary>
        /// Denotes a value as the Marginal Hourly price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MARGINAL_HOURLY")]
        MarginalHourly,
        
        /// <summary>
        /// Denotes a value as the Market Clearing price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MARKET_CLEARING")]
        MarketClearing,
        
        /// <summary>
        /// Denotes a value as the Average of the Bid and Ask prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MEAN_OF_BID_AND_ASK")]
        MeanOfBidAndAsk,
        
        /// <summary>
        /// Denotes a value as the Average of the High and Low prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MEAN_OF_HIGH_AND_LOW")]
        MeanOfHighAndLow,
        
        /// <summary>
        /// Denotes a value as the Average of the Midpoint of prices reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MID")]
        Mid,
        
        /// <summary>
        /// Denotes a value as the Morning fixing reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "MORNING")]
        Morning,
        
        /// <summary>
        /// Denotes a value as the National Single price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "NATIONAL_SINGLE")]
        NationalSingle,
        
        /// <summary>
        /// Denotes a value as the Official Settlement Price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        OSP,
        
        /// <summary>
        /// Denotes a value as the Official price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "OFFICIAL")]
        Official,
        
        /// <summary>
        /// Denotes a value as the Opening price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "OPENING")]
        Opening,
        
        /// <summary>
        /// Denotes a value as the Settlement price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "SETTLEMENT")]
        Settlement,
        
        /// <summary>
        /// Denotes a value as the Spot price reported in or by the relevant Price Source as specified in the relevant Confirmation.
        /// </summary>
        [EnumMember(Value = "SPOT")]
        Spot,
        
        /// <summary>
        /// Denotes a value as the Non-volume Weighted Average of prices effective on the Pricing Date.
        /// </summary>
        [EnumMember(Value = "UN_WEIGHTED_AVERAGE")]
        UnWeightedAverage,
        
        /// <summary>
        /// Denotes a value as the Volume Weighted Average of prices effective on the Pricing Date.
        /// </summary>
        [EnumMember(Value = "WEIGHTED_AVERAGE")]
        WeightedAverage
    }
    
    /// <summary>
    /// The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
    /// </summary>
    [CdmName("QuotationStyleEnum")]
    public enum QuotationStyle
    {
        /// <summary>
        /// When quotation style is &apos;PointsUpFront&apos;, the initialPoints element of the Credit Default Swap feeLeg should be populated
        /// </summary>
        [EnumMember(Value = "POINTS_UP_FRONT")]
        PointsUpFront,
        
        /// <summary>
        /// When quotation style is &apos;Price&apos;, the marketPrice element of the Credit Default Swap feeLeg should be populated
        /// </summary>
        [EnumMember(Value = "PRICE")]
        Price,
        
        /// <summary>
        /// When quotation style is &apos;TradedSpread&apos;, the marketFixedRate element of the Credit Default Swap feeLeg should be populated
        /// </summary>
        [EnumMember(Value = "TRADED_SPREAD")]
        TradedSpread
    }
    
    /// <summary>
    /// The enumerated values to specify how an exchange rate is quoted.
    /// </summary>
    [CdmName("QuoteBasisEnum")]
    public enum QuoteBasis
    {
        /// <summary>
        /// The amount of currency1 for one unit of currency2
        /// </summary>
        [EnumMember(Value = "CURRENCY_1_PER_CURRENCY_2")]
        Currency1PerCurrency2,
        
        /// <summary>
        /// The amount of currency2 for one unit of currency1
        /// </summary>
        [EnumMember(Value = "CURRENCY_2_PER_CURRENCY_1")]
        Currency2PerCurrency1
    }
    
    /// <summary>
    /// The enumerated values to specify the methods for converting rates from one basis to another.
    /// </summary>
    [CdmName("RateTreatmentEnum")]
    public enum RateTreatment
    {
        /// <summary>
        /// Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g).
        /// </summary>
        [EnumMember(Value = "BOND_EQUIVALENT_YIELD")]
        BondEquivalentYield,
        
        /// <summary>
        /// Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h).
        /// </summary>
        [EnumMember(Value = "MONEY_MARKET_YIELD")]
        MoneyMarketYield
    }
    
    /// <summary>
    /// Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to &apos;Issuer&apos;, the rating in the 
    /// Issuer Criteria has priority or is used if there is no Asset criteria. If set to &apos;Asset&apos;, the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
    /// </summary>
    [CdmName("RatingPriorityResolutionEnum")]
    public enum RatingPriorityResolution
    {
        /// <summary>
        /// Denotes that the Asset Criteria has priority.
        /// </summary>
        [EnumMember(Value = "ASSET")]
        Asset,
        
        /// <summary>
        /// Denotes that average rating should be used if several criteria apply.
        /// </summary>
        [EnumMember(Value = "AVERAGE")]
        Average,
        
        /// <summary>
        /// Denotes that highest rating should be used if several criteria apply.
        /// </summary>
        [EnumMember(Value = "HIGHEST")]
        Highest,
        
        /// <summary>
        /// Denotes that the Issuer Criteria has priority.
        /// </summary>
        [EnumMember(Value = "ISSUER")]
        Issuer,
        
        /// <summary>
        /// Denotes that lowest rating should be used if several criteria apply.
        /// </summary>
        [EnumMember(Value = "LOWEST")]
        Lowest
    }
    
    /// <summary>
    /// The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors.
    /// </summary>
    [CdmName("RealisedVarianceMethodEnum")]
    public enum RealisedVarianceMethod
    {
        /// <summary>
        /// For a return on day T, the observed prices on both T and T-1 must be in range
        /// </summary>
        [EnumMember(Value = "BOTH")]
        Both,
        
        /// <summary>
        /// For a return on day T, the observed price on T must be in range.
        /// </summary>
        [EnumMember(Value = "LAST")]
        Last,
        
        /// <summary>
        /// For a return on day T, the observed price on T-1 must be in range.
        /// </summary>
        [EnumMember(Value = "PREVIOUS")]
        Previous
    }
    
    /// <summary>
    /// The enumeration of the account level for the billing summary.
    /// </summary>
    [CdmName("RecordAmountTypeEnum")]
    public enum RecordAmountType
    {
        [EnumMember(Value = "ACCOUNT_TOTAL")]
        AccountTotal,
        
        [EnumMember(Value = "GRAND_TOTAL")]
        GrandTotal,
        
        [EnumMember(Value = "PARENT_TOTAL")]
        ParentTotal
    }
    
    /// <summary>
    /// Represents the enumeration values to specify the role of the party in relation to a regulatory initial margin call.
    /// </summary>
    [CdmName("RegIMRoleEnum")]
    public enum RegIMRole
    {
        /// <summary>
        /// Indicates &apos;Pledgor&apos; party of initial margin call.
        /// </summary>
        [EnumMember(Value = "PLEDGOR")]
        Pledgor,
        
        /// <summary>
        /// Indicates &apos;Secured&apos; party of initial margin call.
        /// </summary>
        [EnumMember(Value = "SECURED")]
        Secured
    }
    
    /// <summary>
    /// Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation.
    /// </summary>
    [CdmName("RegMarginTypeEnum")]
    public enum RegMarginType
    {
        /// <summary>
        /// Indicates Non Regulatory Initial margin or independent amount
        /// </summary>
        [EnumMember(Value = "NON_REG_IM")]
        NonRegIM,
        
        /// <summary>
        /// Indicates Regulatory Initial Margin
        /// </summary>
        [EnumMember(Value = "REG_IM")]
        RegIM,
        
        /// <summary>
        /// Indicates Variation Margin
        /// </summary>
        VM
    }
    
    /// <summary>
    /// A duration code for a Repo (or Securities Lending) transaction. There are many business and market rules that are derived from the duration of the transaction.
    /// </summary>
    [CdmName("RepoDurationEnum")]
    public enum RepoDuration
    {
        /// <summary>
        /// Indicates that a contract is classified as overnight, meaning that there is one business day difference between the start and end date of the contract. Business rule: When the repo is overnight, the number of business days between the spot and forward value dates must be one. Forward leg must be specified.
        /// </summary>
        [EnumMember(Value = "OVERNIGHT")]
        Overnight,
        
        /// <summary>
        /// Indicates that a contract is a regular term contract, with a start date and an end date. Business rule: When the repo is &apos;Term&apos;, both spot and forward legs must be specified.
        /// </summary>
        [EnumMember(Value = "TERM")]
        Term
    }
    
    /// <summary>
    /// The enumerated values to specify whether resets occur relative to the first or last day of a calculation period.
    /// </summary>
    [CdmName("ResetRelativeToEnum")]
    public enum ResetRelativeTo
    {
        /// <summary>
        /// Resets occur relative to the last day of a calculation period.
        /// </summary>
        [EnumMember(Value = "CALCULATION_PERIOD_END_DATE")]
        CalculationPeriodEndDate,
        
        /// <summary>
        /// Resets occur relative to the first day of a calculation period.
        /// </summary>
        [EnumMember(Value = "CALCULATION_PERIOD_START_DATE")]
        CalculationPeriodStartDate
    }
    
    /// <summary>
    /// The enumerated values to specify the type of a resource (e.g. document).
    /// </summary>
    [CdmName("ResourceTypeEnum")]
    public enum ResourceType
    {
        /// <summary>
        /// Document describing the legal terms of a transaction.
        /// </summary>
        [EnumMember(Value = "CONFIRMATION")]
        Confirmation,
        
        /// <summary>
        /// Document providing supplemental material economic terms to the FpML data representation. The initial intended usage is to fulfill the CFTC Part 45 rule requirement to report ‘Any other terms(s) of the swap matched or affirmed by the counterparties in verifying the swap’ when the reporting is done via the generic FpML representation.
        /// </summary>
        [EnumMember(Value = "SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS")]
        SupplementalMaterialEconomicTerms,
        
        /// <summary>
        /// Document describing the economic characteristics of a transaction.
        /// </summary>
        [EnumMember(Value = "TERM_SHEET")]
        TermSheet
    }
    
    /// <summary>
    /// The enumerated values to specify the form of the restructuring credit event that is applicable to the credit default swap.
    /// </summary>
    [CdmName("RestructuringEnum")]
    public enum Restructuring
    {
        /// <summary>
        /// Restructuring (Section 4.7) and Modified Restructuring Maturity Limitation and Conditionally Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
        /// </summary>
        [EnumMember(Value = "MOD_MOD_R")]
        ModModR,
        
        /// <summary>
        /// Restructuring (Section 4.7) and Restructuring Maturity Limitation and Fully Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
        /// </summary>
        [EnumMember(Value = "MOD_R")]
        ModR,
        
        /// <summary>
        /// Restructuring as defined in the applicable ISDA Credit Derivatives Definitions. (2003 or 2014).
        /// </summary>
        R
    }
    
    /// <summary>
    /// The enumerated values to specify the type of return associated the equity payout.
    /// </summary>
    [CdmName("ReturnTypeEnum")]
    public enum ReturnType
    {
        /// <summary>
        /// Price return, i.e. excluding dividends.
        /// </summary>
        [EnumMember(Value = "PRICE")]
        Price,
        
        /// <summary>
        /// Total return, i.e. including dividend and price components.
        /// </summary>
        [EnumMember(Value = "TOTAL")]
        Total
    }
    
    /// <summary>
    /// The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month.
    /// </summary>
    [CdmName("RollConventionEnum")]
    public enum RollConvention
    {
        /// <summary>
        /// Rolls on month end dates irrespective of the length of the month and the previous roll day.
        /// </summary>
        EOM,
        
        /// <summary>
        /// Rolling weekly on a Friday
        /// </summary>
        FRI,
        
        /// <summary>
        /// Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions.
        /// </summary>
        FRN,
        
        /// <summary>
        /// IMM Settlement Dates. The third Wednesday of the (delivery) month.
        /// </summary>
        IMM,
        
        /// <summary>
        /// The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement.
        /// </summary>
        IMMAUD,
        
        /// <summary>
        /// The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers&apos; Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification.
        /// </summary>
        IMMCAD,
        
        /// <summary>
        /// The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month.
        /// </summary>
        IMMNZD,
        
        /// <summary>
        /// Rolling weekly on a Monday.
        /// </summary>
        MON,
        
        /// <summary>
        /// The roll convention is not required. For example, in the case of a daily calculation frequency.
        /// </summary>
        NONE,
        
        /// <summary>
        /// Rolling weekly on a Saturday
        /// </summary>
        SAT,
        
        /// <summary>
        /// Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month
        /// </summary>
        SFE,
        
        /// <summary>
        /// Rolling weekly on a Sunday
        /// </summary>
        SUN,
        
        /// <summary>
        /// 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday.
        /// </summary>
        TBILL,
        
        /// <summary>
        /// Rolling weekly on a Thursday
        /// </summary>
        THU,
        
        /// <summary>
        /// Rolling weekly on a Tuesday
        /// </summary>
        TUE,
        
        /// <summary>
        /// Rolling weekly on a Wednesday
        /// </summary>
        WED,
        
        /// <summary>
        /// Rolls on the 1st day of the month.
        /// </summary>
        [EnumMember(Value = "1")]
        _1,
        
        /// <summary>
        /// Rolls on the 10th day of the month.
        /// </summary>
        [EnumMember(Value = "10")]
        _10,
        
        /// <summary>
        /// Rolls on the 11th day of the month.
        /// </summary>
        [EnumMember(Value = "11")]
        _11,
        
        /// <summary>
        /// Rolls on the 12th day of the month.
        /// </summary>
        [EnumMember(Value = "12")]
        _12,
        
        /// <summary>
        /// Rolls on the 13th day of the month.
        /// </summary>
        [EnumMember(Value = "13")]
        _13,
        
        /// <summary>
        /// Rolls on the 14th day of the month.
        /// </summary>
        [EnumMember(Value = "14")]
        _14,
        
        /// <summary>
        /// Rolls on the 15th day of the month.
        /// </summary>
        [EnumMember(Value = "15")]
        _15,
        
        /// <summary>
        /// Rolls on the 16th day of the month.
        /// </summary>
        [EnumMember(Value = "16")]
        _16,
        
        /// <summary>
        /// Rolls on the 17th day of the month.
        /// </summary>
        [EnumMember(Value = "17")]
        _17,
        
        /// <summary>
        /// Rolls on the 18th day of the month.
        /// </summary>
        [EnumMember(Value = "18")]
        _18,
        
        /// <summary>
        /// Rolls on the 19th day of the month.
        /// </summary>
        [EnumMember(Value = "19")]
        _19,
        
        /// <summary>
        /// Rolls on the 2nd day of the month.
        /// </summary>
        [EnumMember(Value = "2")]
        _2,
        
        /// <summary>
        /// Rolls on the 20th day of the month.
        /// </summary>
        [EnumMember(Value = "20")]
        _20,
        
        /// <summary>
        /// Rolls on the 21st day of the month.
        /// </summary>
        [EnumMember(Value = "21")]
        _21,
        
        /// <summary>
        /// Rolls on the 22nd day of the month.
        /// </summary>
        [EnumMember(Value = "22")]
        _22,
        
        /// <summary>
        /// Rolls on the 23rd day of the month.
        /// </summary>
        [EnumMember(Value = "23")]
        _23,
        
        /// <summary>
        /// Rolls on the 24th day of the month.
        /// </summary>
        [EnumMember(Value = "24")]
        _24,
        
        /// <summary>
        /// Rolls on the 25th day of the month.
        /// </summary>
        [EnumMember(Value = "25")]
        _25,
        
        /// <summary>
        /// Rolls on the 26th day of the month.
        /// </summary>
        [EnumMember(Value = "26")]
        _26,
        
        /// <summary>
        /// Rolls on the 27th day of the month.
        /// </summary>
        [EnumMember(Value = "27")]
        _27,
        
        /// <summary>
        /// Rolls on the 28th day of the month.
        /// </summary>
        [EnumMember(Value = "28")]
        _28,
        
        /// <summary>
        /// Rolls on the 29th day of the month.
        /// </summary>
        [EnumMember(Value = "29")]
        _29,
        
        /// <summary>
        /// Rolls on the 3rd day of the month.
        /// </summary>
        [EnumMember(Value = "3")]
        _3,
        
        /// <summary>
        /// Rolls on the 30th day of the month.
        /// </summary>
        [EnumMember(Value = "30")]
        _30,
        
        /// <summary>
        /// Rolls on the 4th day of the month.
        /// </summary>
        [EnumMember(Value = "4")]
        _4,
        
        /// <summary>
        /// Rolls on the 5th day of the month.
        /// </summary>
        [EnumMember(Value = "5")]
        _5,
        
        /// <summary>
        /// Rolls on the 6th day of the month.
        /// </summary>
        [EnumMember(Value = "6")]
        _6,
        
        /// <summary>
        /// Rolls on the 7th day of the month.
        /// </summary>
        [EnumMember(Value = "7")]
        _7,
        
        /// <summary>
        /// Rolls on the 8th day of the month.
        /// </summary>
        [EnumMember(Value = "8")]
        _8,
        
        /// <summary>
        /// Rolls on the 9th day of the month.
        /// </summary>
        [EnumMember(Value = "9")]
        _9
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this RollConvention value)
        {
            return value switch
            {
                RollConvention._1 => "1",
                RollConvention._10 => "10",
                RollConvention._11 => "11",
                RollConvention._12 => "12",
                RollConvention._13 => "13",
                RollConvention._14 => "14",
                RollConvention._15 => "15",
                RollConvention._16 => "16",
                RollConvention._17 => "17",
                RollConvention._18 => "18",
                RollConvention._19 => "19",
                RollConvention._2 => "2",
                RollConvention._20 => "20",
                RollConvention._21 => "21",
                RollConvention._22 => "22",
                RollConvention._23 => "23",
                RollConvention._24 => "24",
                RollConvention._25 => "25",
                RollConvention._26 => "26",
                RollConvention._27 => "27",
                RollConvention._28 => "28",
                RollConvention._29 => "29",
                RollConvention._3 => "3",
                RollConvention._30 => "30",
                RollConvention._4 => "4",
                RollConvention._5 => "5",
                RollConvention._6 => "6",
                RollConvention._7 => "7",
                RollConvention._8 => "8",
                RollConvention._9 => "9",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// Used in conjunction with an exchange-based pricing source. Identifies a date source calendar from which the pricing dates and thus roll to the next contract will be based off (e.g. pricing is based on the NYMEX WTI First Nearby Futures Contract, if Future is chosen, the pricing will roll to the next futures contract on expiration, if ListedOption is chosen, the pricing will roll to the next futures contract on the Option expiration date which is three business days before the expiration of the NYMEX WTI futures contract.) Omitting this element will result in the default behavior expected with the pricing source described within the commodity element.
    /// </summary>
    [CdmName("RollSourceCalendarEnum")]
    public enum RollSourceCalendar
    {
        [EnumMember(Value = "FUTURE")]
        Future,
        
        [EnumMember(Value = "LISTED_OPTION")]
        ListedOption
    }
    
    /// <summary>
    /// The enumerated values to specify the rounding direction and precision to be used in the rounding of a number.  Used by function cdm.base.math.RoundToPrecision.
    /// </summary>
    [CdmName("RoundingDirectionEnum")]
    public enum RoundingDirection
    {
        /// <summary>
        /// A fractional number will be rounded down to the specified number of decimal places (the precision). For example, 5.29 and 5.25 rounded down to 1 decimal place are 5.2 and 5.2 respectively.
        /// </summary>
        [EnumMember(Value = "DOWN")]
        Down,
        
        /// <summary>
        /// A fractional number will be rounded either up or down to the specified number of decimal places (the precision) depending on its value. For example, 5.24 would be rounded down to 5.2 and 5.25 would be rounded up to 5.3 if a precision of 1 decimal place were specified.
        /// </summary>
        [EnumMember(Value = "NEAREST")]
        Nearest,
        
        /// <summary>
        /// A fractional number will be rounded up to the specified number of decimal places (the precision). For example, 5.21 and 5.25 rounded up to 1 decimal place are 5.3 and 5.3 respectively.
        /// </summary>
        [EnumMember(Value = "UP")]
        Up
    }
    
    /// <summary>
    /// How often is rounding performed
    /// </summary>
    [CdmName("RoundingFrequencyEnum")]
    public enum RoundingFrequency
    {
        /// <summary>
        /// Rounding is done on each day
        /// </summary>
        [EnumMember(Value = "DAILY")]
        Daily,
        
        /// <summary>
        /// Rounding is done only at the end of the period
        /// </summary>
        [EnumMember(Value = "PERIOD_END")]
        PeriodEnd
    }
    
    /// <summary>
    /// The enumerated values to specify the rounding direction when rounding of a number to nearest.  Used by function cdm.base.math.RoundToNearest.
    /// </summary>
    [CdmName("RoundingModeEnum")]
    public enum RoundingMode
    {
        /// <summary>
        /// A number will be rounded down to the specified nearest number. For example, 529 rounded down to the nearest 10 is 520.
        /// </summary>
        [EnumMember(Value = "DOWN")]
        Down,
        
        /// <summary>
        /// A number will be rounded up to the specified nearest number. For example, 521 rounded up to the nearest 10 is 530.
        /// </summary>
        [EnumMember(Value = "UP")]
        Up
    }
    
    /// <summary>
    /// The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events.
    /// </summary>
    [CdmName("ScheduledTransferEnum")]
    public enum ScheduledTransfer
    {
        /// <summary>
        /// A cash flow corresponding to a corporate action event.
        /// </summary>
        [EnumMember(Value = "CORPORATE_ACTION")]
        CorporateAction,
        
        /// <summary>
        /// A cash flow corresponding to the periodic accrued interests.
        /// </summary>
        [EnumMember(Value = "COUPON")]
        Coupon,
        
        /// <summary>
        /// A cashflow resulting from a credit event.
        /// </summary>
        [EnumMember(Value = "CREDIT_EVENT")]
        CreditEvent,
        
        /// <summary>
        /// A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument.
        /// </summary>
        [EnumMember(Value = "DIVIDEND_RETURN")]
        DividendReturn,
        
        /// <summary>
        /// A cash flow associated with an exercise lifecycle event.
        /// </summary>
        [EnumMember(Value = "EXERCISE")]
        Exercise,
        
        /// <summary>
        /// A cash flow corresponding to the return of the fixed interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
        /// </summary>
        [EnumMember(Value = "FIXED_RATE_RETURN")]
        FixedRateReturn,
        
        /// <summary>
        /// A cash flow corresponding to the return of the floating interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
        /// </summary>
        [EnumMember(Value = "FLOATING_RATE_RETURN")]
        FloatingRateReturn,
        
        /// <summary>
        /// A cash flow corresponding to the compensation for missing assets due to the rounding of digits in the original number of assets to be delivered as per payout calculation.
        /// </summary>
        [EnumMember(Value = "FRACTIONAL_AMOUNT")]
        FractionalAmount,
        
        /// <summary>
        /// A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
        /// </summary>
        [EnumMember(Value = "INTEREST_RETURN")]
        InterestReturn,
        
        /// <summary>
        /// Net interest across payout components. Applicable to products such as interest rate swaps.
        /// </summary>
        [EnumMember(Value = "NET_INTEREST")]
        NetInterest,
        
        /// <summary>
        /// A cash flow corresponding to a performance return.  The settlementOrigin attribute on the Transfer should point to the relevant Payout defining the performance calculation.
        /// </summary>
        [EnumMember(Value = "PERFORMANCE")]
        Performance,
        
        /// <summary>
        /// A cashflow which amount typically corresponds to the notional amount of the contract for various business reasons e.g. PhysicalSettlement, PrincipalExchange etc. else to a portion of the notional amount interim payments e.g. for the purpose of resetting the Notional Amount of a Cross Currency Swap variying leg, as part of a final Principal Exchange related to a Non-Deliverable currency leg, etc.
        /// </summary>
        [EnumMember(Value = "PRINCIPAL_PAYMENT")]
        PrincipalPayment
    }
    
    /// <summary>
    /// The enumerated values to specify the relevant settled entity matrix source.
    /// </summary>
    [CdmName("SettledEntityMatrixSourceEnum")]
    public enum SettledEntityMatrixSource
    {
        /// <summary>
        /// The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation.
        /// </summary>
        [EnumMember(Value = "CONFIRMATION_ANNEX")]
        ConfirmationAnnex,
        
        /// <summary>
        /// The term is not applicable.
        /// </summary>
        [EnumMember(Value = "NOT_APPLICABLE")]
        NotApplicable,
        
        /// <summary>
        /// The Settled Entity Matrix published by the Index Publisher.
        /// </summary>
        [EnumMember(Value = "PUBLISHER")]
        Publisher
    }
    
    /// <summary>
    /// Defines the settlement centre for a securities transaction.
    /// </summary>
    [CdmName("SettlementCentreEnum")]
    public enum SettlementCentre
    {
        /// <summary>
        /// ClearStream Banking Luxembourg
        /// </summary>
        [EnumMember(Value = "CLEARSTREAM_BANKING_LUXEMBOURG")]
        ClearstreamBankingLuxembourg,
        
        /// <summary>
        /// Euroclear Bank
        /// </summary>
        [EnumMember(Value = "EUROCLEAR_BANK")]
        EuroclearBank
    }
    
    /// <summary>
    /// The enumerated values to specify the settlement rate options as specified in the Annex A to the 1998 FX and Currency Options Definitions.
    /// </summary>
    [CdmName("SettlementRateOptionEnum")]
    public enum SettlementRateOption
    {
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Buenos Aires and New York) which appears on the Reuters Screen BNAR Page at the close of business in Buenos Aires on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ARS.BNAR/ARS01")]
        ARS_BNAR_ARS01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA&apos;s web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Indicative Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Argentine Peso/U.S. Dollar markets for the purpose of determining the EMTA ARS Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "ARS.EMTA.INDICATIVE.SURVEY.RATE/ARS04")]
        ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA&apos;s web site (www.emta.org) at approximately 1:00 p.m. (Buenos Aires time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA ARS Industry Survey Methodology (which means a methodology, dated as of January 2, 2003, as amended from time to time, for a centralized industry-wide survey of financial institutions in Buenos Aires that are active participants in the Argentine Peso/U.S. Dollar spot markets for the purpose of determining the EMTA ARS Industry Survey Rate).
        /// </summary>
        [EnumMember(Value = "ARS.EMTA.INDUSTRY.SURVEY.RATE/ARS03")]
        ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the volume weighted average Argentine Peso/U.S. Dollar Rate of all trades executed in the electronic market for a Rate Calculation Day expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day, reported by the Mercado Abierto Electronico (the &apos;MAE&apos;) at approximately 3:00 pm, Buenos Aires time, and published on the FOREX-MAE Page as the &apos;PPN&apos; rate (&apos;Promedio Ponderado Noticiado&apos;) on www.mae.com.ar on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ARS.MAE/ARS05")]
        ARS_MAE_ARS05,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Argentine Peso/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Argentine Pesos per one U.S. Dollar, for settlement on the same day quoted by Banco de la Nacion (in accordance with the Convertibility Law of March 27, 1991 and Regulatory Decree No. 529/91 of April 1, 1991, as may be amended from time to time) for that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ARS.OFFICIAL.RATE/ARS02")]
        ARS_OFFICIAL_RATE_ARS02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) which appears on the Reuters Screen BRBY Page under the caption &apos;INTBK FLTING (LAST)&apos; at approximately 11:00 a.m., Sao Paulo time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.BRBY/BRL01")]
        BRL_BRBY_BRL01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA&apos;s web site (www.emta.org) at approximately 12:00 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Indicative Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Brazilian Real/U.S. Dollar markets for the purpose of determining the EMTA BRL Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "BRL.EMTA.INDICATIVE.SURVEY.RATE/BRL13")]
        BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days, as published on EMTA&apos;s web site (www.emta.org) at approximately 3:45 p.m. (Sao Paulo time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA BRL Industry Survey Methodology (which means a methodology, dated as of March 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions in Brazil that are active participants in the Brazilian Real/U.S. Dollar spot markets for the purpose of determining the EMTA BRL Industry Survey Rate).
        /// </summary>
        [EnumMember(Value = "BRL.EMTA.INDUSTRY.SURVEY.RATE/BRL12")]
        BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar Specified Rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil in the &apos;Diario Oficial da Uniao&apos; on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.OFFICIAL.RATE/BRL02")]
        BRL_OFFICIAL_RATE_BRL02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PCOT-COMMERCIAL/BRL03")]
        BRL_PCOT_COMMERCIAL_BRL03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PCOT- 390, Option 3, at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PCOT-FLOATING/BRL04")]
        BRL_PCOT_FLOATING_BRL04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar offered rate for U.S. Dollars, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX-800 (&apos;Consulta de Cambio&apos; or Exchange Rate Inquiry), Option 5 (&apos;Cotacoes para Contabilidade&apos; or &apos;Rates for Accounting Purposes&apos;) by approximately 6:00 p.m., Sao Paulo time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PTAX/BRL09")]
        BRL_PTAX_BRL09,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date. 23
        /// </summary>
        [EnumMember(Value = "BRL.PTAX-COMMERCIAL.BRFR/BRL06")]
        BRL_PTAX_COMMERCIAL_BRFR_BRL06,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar commercial rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 (&apos;Consultas de Cambio&apos; or Exchange Rate Inquiry), Option 5 (&apos;Cotacoes para Contabilidad&apos; or Rates for Accounting Purposes) market type &apos;L&apos; (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated &apos;Livre&apos; and commonly known as &apos;Comercial&apos;) as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PTAX-COMMERCIAL/BRL05")]
        BRL_PTAX_COMMERCIAL_BRL05,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on the SISBACEN Data System which appears on the Reuters Screen BRFR Page at PTAX-800 as of 11:00 a.m., Sao Paulo time, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PTAX-FLOATING.BRFR/BRL08")]
        BRL_PTAX_FLOATING_BRFR_BRL08,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Brazilian Real/U.S. Dollar floating rate, expressed as the amount of Brazilian Reais per one U.S. Dollar, for settlement in two Business Days (where such days are Business Days in both Sao Paulo and New York) reported by the Banco Central do Brasil on SISBACEN Data System under transaction code PTAX- 800 (&apos;Consultas de Cambio&apos; or Exchange Rate Inquiry), Option 5 (&apos;Cotacoes para Contabilidad&apos; or Rates for Accounting Purposes) market type &apos;F&apos; (corresponding to U.S. Dollars traded in the foreign exchange market segment officially denominated &apos;Flutuante&apos;) as of 7:30 p.m., Sao Paulo time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "BRL.PTAX-FLOATING/BRL07")]
        BRL_PTAX_FLOATING_BRL07,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen BCCH Page under the caption &apos;OBSERVADO&apos; at 10:00 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.BCCH/CLP01")]
        CLP_BCCH_CLP01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILD-INFORMAL/CLP02")]
        CLP_CHILD_INFORMAL_CLP02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILD Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILD-INTERBANK/CLP03")]
        CLP_CHILD_INTERBANK_CLP03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILD Page on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILD-OBSERVADO/CLP04")]
        CLP_CHILD_OBSERVADO_CLP04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar informal rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) of the informal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILG-INFORMAL/CLP05")]
        CLP_CHILG_INFORMAL_CLP05,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar interbank rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile for the formal exchange market which appears on the Reuters Screen CHILG Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILG-INTERBANK/CLP06")]
        CLP_CHILG_INTERBANK_CLP06,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Reuters Screen CHILG Page under &apos;OBSERVADO&apos; at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.CHILG-OBSERVADO/CLP07")]
        CLP_CHILG_OBSERVADO_CLP07,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar &apos;observado&apos; rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Banco Central de Chile (www.bcentral.cl) as the &apos;Dolar Observado&apos; (Dollar Observado) rate by not later than 10:30 a.m., Santiago time, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.DOLAR.OBS/CLP10")]
        CLP_DOLAR_OBS_CLP10,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA&apos;s web site (www.emta.org) at approximately 11:00 a.m., Santiago time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA CLP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chilean Peso/U.S. Dollar markets for the purpose of determining the EMTA CLP Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "CLP.EMTA.INDICATIVE.SURVEY.RATE/CLP11")]
        CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar Specified Rate, expressed as the amount of Chilean Pesos per one U.S. Dollar (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York), calculated in accordance with Title I, Chapter 1 Number 6 of the Compendium of International Exchange Norms of the Banco Central de Chile and published by the Banco Central de Chile at the Specified Time, if any, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.OFFICIAL.RATE/CLP08")]
        CLP_OFFICIAL_RATE_CLP08,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chilean Peso/U.S. Dollar observado rate, expressed as the amount of Chilean Pesos per one U.S. Dollar, for settlement on the same day (or, if such day is not a Business Day in New York, for settlement on the first succeeding day that is a Business Day in both Santiago and New York) reported by the Banco Central de Chile which appears on the Telerate Page 38942 opposite the caption &apos;Observado&apos; at the Specified Time, if any, on the first Business Day following the Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CLP.TELERATE.38942/CLP09")]
        CLP_TELERATE_38942_CLP09,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar official fixing rate, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days reported by the People&apos;s Bank of China, Beijing, People&apos;s Republic of China, which appears on the Reuters Screen &apos;SAEC&apos; Page opposite the symbol &apos;USDCNY=&apos; at approximately 9:15 a.m., Beijing time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "CNY.SAEC/CNY01")]
        CNY_SAEC_CNY01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Chinese Renminbi/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Chinese Renminbi per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC CNY Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Chinese Renminbi/U.S. Dollar markets for the purpose of determining the SFEMC CNY Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "CNY.SFEMC.INDICATIVE.SURVEY.RATE/CNY02")]
        CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day (unless such day is not a Business Day in New York, then for settlement on the first succeeding day that is a Business Day in Bogota and New York) reported by the Colombian Banking Superintendency which appears on the Reuters Screen CO/COL03 Page opposite the caption &apos;TRCM&apos; (&apos;Tasa de Cierre Representative del Mercado&apos; or closing market price) at 12:00 noon, Bogota time, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "COP.CO/COL03/COP01")]
        COP_CO_COL03_COP01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day, as published on EMTA&apos;s web site (www.emta.org) at approximately 11:30 a.m., Bogota time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA COP Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Colombian Peso/U.S. Dollar markets for the purpose of determining the EMTA COP Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "COP.EMTA.INDICATIVE.SURVEY.RATE/COP03")]
        COP_EMTA_INDICATIVE_SURVEY_RATE_COP03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Colombian Peso/U.S. Dollar fixing rate, expressed as the amount of Colombian Pesos per one U.S. Dollar, for settlement on the same day reported by the Colombian Financial Superintendency (www.banrep.gov.co) as the &apos;Tasa Representativa del Mercado (TRM)&apos; (also referred to as the &apos;Tasa de Cambio Representativa del Mercado&apos; (TCRM)) by not later than 10:30 a.m., Bogota time, on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "COP.TRM/COP02")]
        COP_TRM_COP02,
        
        /// <summary>
        /// the Spot Rate for a Rate Calculation Date will be the Reference Currency/U.S. Dollar exchange rate, expressed as the amount of Reference Currency per one U.S. Dollar, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day&apos;s price of a Specified Company&apos;s American Depositary Receipt or American Depositary Receipts (the &apos;ADR&apos; or &apos;ADRs&apos;, as appropriate) and the price of the local share or shares of such Specified Company of the same type and in the same quantity represented by such ADR or ADRs, as the case may be (the &apos;Share&apos; or &apos;Shares&apos;, as appropriate). The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of (A) in the case where one ADR represents less than one Share, its bid and offer price (in the Reference Currency) for one Share and its bid and offer price (in U.S. Dollars) for the number of ADRs which represent such Share and (B) in all other cases, its bid and offer price (in the Reference Currency) for the Share or Shares, as the case may be, and its bid and offer price (in U.S. Dollars) for one ADR. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (1) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Share or Shares, as the case may be, and (2) the arithmetic mean of the midpoint of the bid and offer prices quoted in U.S. Dollars by each Reference Dealer for such ADR or ADRs, as the case may be, subject to an adjustment, if any, by the Calculation Agent to reduce the effect of momentary disparities in the prices of the Share or Shares and the ADR or ADRs, as appropriate. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
        /// </summary>
        [EnumMember(Value = "CURRENCY-IMPLIED.RATE.(ADR)/CURA1")]
        CURRENCY_IMPLIED_RATE__ADR__CURA1,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency exchange rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date for that day&apos;s price of Local Assets. The Calculation Agent will request each of the Reference Dealers to provide a firm quotation of its bid and offer price (in both the Reference Currency and the Settlement Currency) for an amount of Local Assets whose face value equals the Specified Amount. If one or more quotations are provided, the rate for a Rate Calculation Date will equal the ratio of (A) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Reference Currency by each Reference Dealer for such Local Assets and (B) the arithmetic mean of the midpoint of the bid and offer prices quoted in the Settlement Currency by each Reference Dealer for such Local Assets. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on the Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
        /// </summary>
        [EnumMember(Value = "CURRENCY-IMPLIED.RATE.(LOCAL.ASSET)/CURA2")]
        CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Reference Currency/Settlement Currency Specified Rate, expressed as the amount of the Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date agreed upon by the parties on or prior to that Rate Calculation Date (or, if different, the day on which rates for that date would, in the ordinary course, be published or announced).
        /// </summary>
        [EnumMember(Value = "CURRENCY-MUTUAL.AGREEMENT/CURA3")]
        CURRENCY_MUTUAL_AGREEMENT_CURA3,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be determined on the basis of quotations provided by Reference Dealers on that Rate Calculation Date of that day&apos;s Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, for settlement on the Settlement Date. The Calculation Agent will request the Specified Office of each of the Reference Dealers to provide a firm quotation of its Specified Rate for a transaction where the amount of Reference Currency equals the Specified Amount. If four quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates, without regard to the Specified Rates having the highest and lowest value. If exactly three quotations are provided, the rate for a Rate Calculation Date will be the Specified Rate provided by the Reference Dealer that remains after disregarding the Specified Rates having the highest and lowest values. For this purpose, if more than one quotation has the same highest value or lowest value, then the Specified Rate of one of such quotations shall be disregarded. If exactly two quotations are provided, the rate for a Rate Calculation Date will be the arithmetic mean of the Specified Rates. If only one quotation is provided, the rate for a Rate Calculation Date will be the Specified Rate quoted by that Reference Dealer. The quotations used to determine the Spot Rate for a Rate Calculation Date will be determined in each case at the Specified Time on that Rate Calculation Date or, if no such time is specified, the time chosen by the Calculation Agent.
        /// </summary>
        [EnumMember(Value = "CURRENCY-REFERENCE.DEALERS/CURA4")]
        CURRENCY_REFERENCE_DEALERS_CURA4,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be determined by the Calculation Agent on the basis of that day&apos;s Specified Rate, expressed as the amount of Reference Currency per one unit of Settlement Currency, in a legal and customary wholesale market in which there is no, or minimal, Governmental Authority controls or interference, except as a participant in such market.
        /// </summary>
        [EnumMember(Value = "CURRENCY-WHOLESALE.MARKET/CURA5")]
        CURRENCY_WHOLESALE_MARKET_CURA5,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Ecuadorian Sucre/U.S. Dollar Specified Rate, expressed as the amount of Ecuadorian Sucres per one U.S. Dollar, for settlement in one Business Day (where such day is a Business Day in Guayaquil and New York) which appears on Reuters Screen DNRP Page at 12:00 noon, Guayaquil time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ECS.DNRP/ECS01")]
        ECS_DNRP_ECS01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Telerate Page 50157 to the right of the caption &apos;Spot&apos; under the column &apos;IDR&apos; at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "IDR.ABS/IDR01")]
        IDR_ABS_IDR01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar weighted average spot rate in the interbank market based on traded IDR/USD spot foreign exchange transactions during a specified time period which are captured on a real time basis, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, published by Bank Indonesia at approximately 10:00 a.m., Jakarta time, on that Rate Calculation Date as the Jakarta Interbank Spot Dollar Rate USD - IDR on Bank Indonesia&apos;s website or otherwise made available by Bank Indonesia (or its successor as administrator).
        /// </summary>
        [EnumMember(Value = "IDR.JISDOR/IDR04")]
        IDR_JISDOR_IDR04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC IDR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indonesian Rupiah/U.S. Dollar markets for the purpose of determining the SFEMC IDR Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "IDR.SFEMC.INDICATIVE.SURVEY.RATE/IDR02")]
        IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indonesian Rupiah/U.S. Dollar implied spot rate expressed as the amount of Indonesian Rupiah per one U.S. Dollar, for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of that rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "IDR.VWAP/IDR03")]
        IDR_VWAP_IDR03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BOIJ Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ILS.BOIJ/ILS01")]
        ILS_BOIJ_ILS01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Israeli Shekel/U.S. Dollar Specified Rate, expressed as the amount of Israeli Shekels per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen FXIL Page as of 1:00 p.m., Tel Aviv time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "ILS.FXIL/ILS02")]
        ILS_FXIL_ILS02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, reported by Financial Benchmarks India Pvt. Ltd. (www.fbil.org.in) at approximately 1:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "INR.FBIL/INR01")]
        INR_FBIL_INR01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar reference rate, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days reported by the Reserve Bank of India which appears on the Reuters Screen RBIB Page at approximately 12:30 p.m., Mumbai time, or as soon thereafter as practicable, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "INR.RBIB/INR01")]
        INR_RBIB_INR01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Indian Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Indian Rupee per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m. (Singapore time), or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC INR Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Indian Rupee/U.S. Dollar markets for the purpose of determining the SFEMC INR Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "INR.SFEMC.INDICATIVE.SURVEY.RATE/INR02")]
        INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen KEBEY Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "KRW.KEBEY/KRW01")]
        KRW_KEBEY_KRW01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on the Reuters Screen KFTC18 Page to the right of the caption &apos;USD Today&apos; that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
        /// </summary>
        [EnumMember(Value = "KRW.KFTC18/KRW02")]
        KRW_KFTC18_KRW02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC KRW Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Korean Won/U.S. Dollar markets for the purpose of determining the SFEMC KRW Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "KRW.SFEMC.INDICATIVE.SURVEY.RATE/KRW04")]
        KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Korean Won/U.S. Dollar market average rate, expressed as the amount of Korean Won per one U.S. Dollar, for settlement in two Business Days reported by the Korea Financial Telecommunications and Clearing Corporation which appears on Telerate Page 45644 to the right of the caption &apos;USD Today&apos; that is available at approximately 3:30 p.m., Seoul time, on the Rate Calculation Date or as soon thereafter as practicable.
        /// </summary>
        [EnumMember(Value = "KRW.TELERATE.45644/KRW03")]
        KRW_TELERATE_45644_KRW03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA&apos;s website (www.emta.org) at approximately 1:00 p.m., Almaty time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA KZT Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Kazakhstan Tenge/U.S. Dollar markets for the purpose of determining the EMTA KZT Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "KZT.EMTA.INDICATIVE.SURVEY.RATE/KZT02")]
        KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Kazakhstan Tenge / U.S. Dollar weighted average rate, expressed as the amount of Kazakhstan Tenge per one U.S. Dollar, for settlement on the same Business Day reported by the Kazakhstan Stock Exchange (www.kase.kz) at approximately 11:00 am, Almaty time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "KZT.KASE/KZT01")]
        KZT_KASE_KZT01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Lebanese Pound/U.S. Dollar Specified Rate, expressed as the amount of Lebanese Pounds per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen BDLX Page as of 12:00 noon, Beirut time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "LBP.BDLX/LBP01")]
        LBP_BDLX_LBP01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Moroccan Dirham/U.S. Dollar Specified Rate, expressed as the amount of Moroccan Dirham per one U.S. Dollar, for settlement in two Business Days reported by the Central Bank of Morocco as of 1:00 p.m., Rabat time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MAD.OFFICIAL.RATE/MAD01")]
        MAD_OFFICIAL_RATE_MAD01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Mexican Pesos/U.S. Dollar Specified rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on the Reuters Screen BNMX Page opposite the caption &apos;Fix&apos; at the close of business in Mexico City on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MXP.BNMX/MXP01")]
        MXP_BNMX_MXP01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by Banco de Mexico in the Official Gazette of the Federation pursuant to the &apos;Disposiciones aplicables a la determinacion del tipo de Cambio para solventar obligaciones denominadas en moneda extranjera pagaderas en la Republica Mexicana&apos; (Rules applicable to determine the exchange rate to pay obligations denominated in foreign currency payable in Mexico) on the first Business Day following that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MXP.FIXING.RATE/MXP02")]
        MXP_FIXING_RATE_MXP02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days reported by Banco de Mexico which appears on Reuters Screen MEX01 Page under the heading &apos;MXNFIX=RR&apos;, at the close of business in Mexico City on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MXP.MEX01/MXP03")]
        MXP_MEX01_MXP03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Mexican Peso/U.S. Dollar fixing rate, expressed as the amount of Mexican Pesos per one U.S. Dollar, for settlement in two Business Days which is published by the Bolsa Mexicana de Valores, S.A. de C.V. (as established in Section 2 of the &apos;Resolution concerning the exchange rate applicable for calculating the Mexican Peso equivalent of principal and interest of Mexican Treasury Notes denominated in foreign currency and payable in Mexican Pesos&apos; published in the Diario Oficial de la Federacion on November 11, 1991) in the Movimiento Diario del Mercado de Valores de la Bolsa Mexicana de Valores, S.A. de C.V. under the heading &apos;Movimiento Diario del Mercado de Valores&apos; on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MXP.PUBLISHED/MXP04")]
        MXP_PUBLISHED_MXP04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore, which appears on the Telerate Page 50157 to the right of the caption &apos;Spot&apos; under the column &apos;MYR&apos; at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MYR.ABS/MYR01")]
        MYR_ABS_MYR01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar reference rate, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, calculated and reported by Bank Negara Malaysia as its Kuala Lumpur USD/MYR Reference Rate, which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 3:30 p.m., Kuala Lumpur time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MYR.KL.REF/MYR04")]
        MYR_KL_REF_MYR04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar spot rate expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, reported by Persatuan Pasaran Kewangan Malaysia (ACI - Malaysia), which appears on Thomson Reuters Screen MYRFIX2 Page at approximately 11:10 a.m., Kuala Lumpur time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "MYR.PPKM/MYR03")]
        MYR_PPKM_MYR03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Malaysian Ringgit/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Malaysian Ringgit per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC MYR Indicative Survey Methodology (which means a methodology, dated as of July 15, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Malaysian Ringgit/U.S. Dollar markets for the purpose of determining the SFEMC MYR Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "MYR.SFEMC.INDICATIVE.SURVEY.RATE/MYR02")]
        MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Peruvian Soles per one U.S. Dollar, for settlement on the same day, as published on EMTA&apos;s web site (www.emta.org) at approximately 11:00 a.m., Lima time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA PEN Indicative Survey Methodology (which means a methodology, dated as of August 1, 2006, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Peruvian Sol/U.S. Dollar markets for the purpose of determining the EMTA PEN Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "PEN.EMTA.INDICATIVE.SURVEY.RATE/PEN04")]
        PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar average exchange rate in the interbank market expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day reported by the Banco Central de Reserva del Peru (www.bcrp.gob.pe) as the &apos;Tipo de Cambio Interbancario Promedio&apos; at approximately 2:00 p.m., Lima time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PEN.INTERBANK.AVE/PEN05")]
        PEN_INTERBANK_AVE_PEN05,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Peruvian Sol/U.S. Dollar fixing rate (mid market last), expressed as the amount of Peruvian Sols per one U.S. Dollar, for settlement on that same day which appears on the Reuters Screen PDSB Page opposite the caption &apos;PEN=&apos; as of 12:00 noon, Lima time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PEN.PDSB/PEN01")]
        PEN_PDSB_PEN01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the midpoint of the Peruvian Sol/U.S. Dollar closing weighted average bid and offer (&apos;compra y venta&apos;) exchange rates expressed as the amount of Peruvian New Soles per one U.S. Dollar for settlement on the same day, reported by the Superintendencia de Banca, Seguros y AFP (www.sbs.gob.pe) of the Republic of Peru at approximately 5:00 p.m., Lima time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PEN.WT.AVE/PEN03")]
        PEN_WT_AVE_PEN03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, sponsored by Bankers Association of the Philippines (www.bap.org.ph) as its &apos;BAP AM Weighted Average Rate&apos; at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PHP.BAPPESO/PHP06")]
        PHP_BAPPESO_PHP06,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar morning weighted average rate for that Rate Calculation Date, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day reported by the Philippine Dealing System PDEX which appears on the Reuters Screen PDSPESO Page to the right of the caption &apos;AM WT AVE&apos; at approximately 11:30 a.m., Manila time, or as soon thereafter as practicable, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PHP.PDSPESO/PHP06")]
        PHP_PDSPESO_PHP06,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Reuters Screen PHPESO Page at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PHP.PHPESO/PHP01")]
        PHP_PHPESO_PHP01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PHP Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Philippine Peso/U.S. Dollar markets for the purpose of determining the SFEMC PHP Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "PHP.SFEMC.INDICATIVE.SURVEY.RATE/PHP05")]
        PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar tom rate (mid market), expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 15439 at approximately 11:00 a.m., Manila time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PHP.TELERATE.15439/PHP03")]
        PHP_TELERATE_15439_PHP03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Philippine Peso/U.S. Dollar Specified Rate, expressed as the amount of Philippine Pesos per one U.S. Dollar, for settlement in one Business Day which appears on the Telerate Page 2920 at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PHP.TELERATE.2920/PHP02")]
        PHP_TELERATE_2920_PHP02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar reference rate expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days reported by the State Bank of Pakistan (www.sbp.org.pk) at approximately 2:30 pm, Karachi time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PKR.SBPK/PKR01")]
        PKR_SBPK_PKR01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Pakistani Rupee/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Pakistani Rupees per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m. Singapore time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC PKR Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Pakistani Rupee/U.S. Dollar markets for the purpose of determining the SFEMC PKR Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "PKR.SFEMC.INDICATIVE.SURVEY.RATE/PKR02")]
        PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar Specified Rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPQ Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PLZ.NBPQ/PLZ01")]
        PLZ_NBPQ_PLZ01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Polish Zloty/U.S. Dollar fixing rate, expressed as the amount of Polish Zloty per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Poland which appears on the Reuters Screen NBPR Page at the Specified Time, if any, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "PLZ.NBPR/PLZ02")]
        PLZ_NBPR_PLZ02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, calculated by the Chicago Mercantile Exchange (&apos;CME&apos;) and as published on CME&apos;s website, which appears on the Reuters Screen EMTA Page, at approximately 1:30 p.m., Moscow time, on that Rate Calculation Date. The Spot Rate shall be calculated by the CME pursuant to the Chicago Mercantile Exchange / EMTA, Inc. Daily Russian Ruble Per U.S. Dollar Reference Rate Methodology (which means a methodology, effective as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions in Russia that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the RUB CME-EMTA Rate).
        /// </summary>
        [EnumMember(Value = "RUB.CME-EMTA/RUB03")]
        RUB_CME_EMTA_RUB03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Russian Rubles per one U.S. Dollar, for settlement in one Business Day, as published on EMTA&apos;s web site (www.emta.org) at approximately 2:45 p.m., Moscow time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA RUB Indicative Survey Methodology (which means a methodology dated as of June 16, 2005, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Russian Ruble/U.S. Dollar spot market for the purpose of determining the EMTA RUB Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "RUB.EMTA.INDICATIVE.SURVEY.RATE/RUB04")]
        RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MICEXFRX Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "RUB.MICEXFRX/RUB01")]
        RUB_MICEXFRX_RUB01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Russian Ruble/U.S. Dollar Specified Rate, expressed as the amount of Russian Rubies per one U.S. Dollar, for settlement on the same day reported by the Moscow Interbank Currency Exchange which appears on the Reuters Screen MMVB Page as of 10:30 a.m., Moscow time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "RUB.MMVB/RUB02")]
        RUB_MMVB_RUB02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Singapore Dollar/U.S. Dollar spot rate expressed as the amount of Singapore Dollar per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "SGD.VWAP/SGD3")]
        SGD_VWAP_SGD3,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Slovak Koruna/U.S. Dollar Specified Rate, expressed as the amount of Slovak Koruna per one U.S. Dollar, for settlement in two Business Days reported by the National Bank of Slovakia which appears on the Reuters Screen NBSB Page as of 11:40 a.m., Bratislava time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "SKK.NBSB/SKK01")]
        SKK_NBSB_SKK01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Thai Baht/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Thai Bhaht per one U.S. Dollar, for settlement in two Business Days, reported by the Association of Banks in Singapore which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption &apos;Spot&apos; under the column &apos;THB&apos; at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "THB.ABS/THB01")]
        THB_ABS_THB01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Thai Baht / U.S. Dollar spot rate expressed as the amount of Thai Baht per one U.S. Dollar for settlement in two Business Days, reported by ABS Benchmarks Administration Co Pte. Ltd. (or its successor as administrator or sponsor of the rate), which appears on Thomson Reuters Screen ABSFIX01 Page at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "THB.VWAP/THB01")]
        THB_VWAP_THB01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon thereafter as practicable, on such Rate Calculation Date. The Spot Rate will be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC TWD Indicative Survey Methodology (which means a methodology, dated as of December 1, 2004, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Taiwanese Dollar/U.S. Dollar markets for the purpose of determining the SFEMC TWD Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "TWD.SFEMC.INDICATIVE.SURVEY.RATE/TWD04")]
        TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Reuters Screen TAIFX1 Page under the heading &apos;Spot&apos; as of 11:00 a.m. Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "TWD.TAIFX1/TWD03")]
        TWD_TAIFX1_TWD03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar spot rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days, reported by the Taipei Forex Inc. which appears on the Telerate Page 6161 under the heading &apos;Spot&apos; as of 11:00 a.m., Taipei time, on that Rate Calculation Date, or if no rate appears as of 11:00 a.m., Taipei time, the rate that first appears in any of the next succeeding 15 minute intervals after such time, up to and including 12:00 noon, Taipei time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "TWD.TELERATE.6161/TWD01")]
        TWD_TELERATE_6161_TWD01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Taiwanese Dollar/U.S. Dollar Specified Rate, expressed as the amount of Taiwanese Dollars per one U.S. Dollar, for settlement in two Business Days which appears on the Reuters Screen TFEMA Page as of 11:00 a.m., Taipei time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "TWD.TFEMA/TWD02")]
        TWD_TFEMA_TWD02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day, as published on EMTA&apos;s website (www.emta.org) at approximately 2:00 p.m., Kiev time, or as soon thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by EMTA (or a service provider EMTA may select in its sole discretion) pursuant to the EMTA UAH Indicative Survey Methodology (which means a methodology, dated as of March 16, 2009, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Ukrainian Hryvnia / U.S. Dollar markets for the purpose of determining the EMTA UAH Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "UAH.EMTA.INDICATIVE.SURVEY.RATE/UAH03")]
        UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar Specified Rate for U.S. Dollars expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day calculated by Thomson Reuters pursuant to the EMTA UAH Industry Survey Methodology, which rate appears on EMTA&apos;s website (www.emta.org) and on Thomson Reuters Page EMTAUAHFIX at approximately 11:30 am, Kiev time, on that Rate Calculation Date. The &apos;EMTA UAH Industry Survey Methodology&apos; as used herein means the methodology dated as of March 16, 2009, for a centralized industry wide survey of financial institutions in the Ukrainian Hryvnia/U.S. Dollar spot market for the purposes of determining the EMTA UAH Industry Survey Rate.
        /// </summary>
        [EnumMember(Value = "UAH.EMTA.INDUSTRY.SURVEY.RATE/UAH02")]
        UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Ukrainian Hryvnia/U.S. Dollar spot rate, expressed as the amount of Ukrainian Hryvnia per one U.S. Dollar, for settlement on the same Business Day reported by GFI Brokers on Thomson Reuters Page GFIU by 9:30 am, London time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "UAH.GFI/UAH01")]
        UAH_GFI_UAH01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the midpoint of the Venezuelan Bolivar /U.S. Dollar Tipo de Cambio De Referencia buying and selling rates, expressed as the amount of Venezuelan Bolivar per one U.S. Dollar, for settlement in two Business Days reported by the Banco Central de Venezuela (www.bcv.org.ve) at approximately 5:00 p.m., Caracas time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "VEF.FIX/VEF01")]
        VEF_FIX_VEF01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate at 11:00 a.m., Singapore time, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days reported by the Association of Banks in Singapore, which appears on the Reuters Screen ABSIRFIX01 Page to the right of the caption &apos;Spot&apos; under the column &apos;VND&apos; at approximately 11:30 a.m., Singapore time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "VND.ABS/VND01")]
        VND_ABS_VND01,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar spot rate expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days which appears on Reuters Screen VNDFIX=VN Page under the caption &apos;Spot&apos; and to the right of the caption &apos;Average&apos; at approximately 11:00 am, Hanoi time, on that Rate Calculation Date.
        /// </summary>
        [EnumMember(Value = "VND.FX/VND02")]
        VND_FX_VND02,
        
        /// <summary>
        /// The Spot Rate for a Rate Calculation Date will be the Vietnamese Dong/U.S. Dollar Specified Rate for U.S. Dollars, expressed as the amount of Vietnamese Dong per one U.S. Dollar, for settlement in two Business Days, as published on SFEMC&apos;s website (www.sfemc.org) at approximately 3:30 p.m., Singapore time, or as soon as thereafter as practicable, on that Rate Calculation Date. The Spot Rate shall be calculated by SFEMC (or a service provider SFEMC may select in its sole discretion) pursuant to the SFEMC VND Indicative Survey Methodology (which means a methodology, dated as of July 14, 2008, as amended from time to time, for a centralized industry-wide survey of financial institutions that are active participants in the Vietnamese Dong/U.S. Dollar markets for the purpose of determining the SFEMC VND Indicative Survey Rate).
        /// </summary>
        [EnumMember(Value = "VND.SFEMC.INDICATIVE.SURVEY.RATE/VND03")]
        VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03
    }
    
    public static partial class Extension
    {
        public static string GetDisplayName(this SettlementRateOption value)
        {
            return value switch
            {
                SettlementRateOption.ARS_BNAR_ARS01 => "ARS.BNAR/ARS01",
                SettlementRateOption.ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04 => "ARS.EMTA.INDICATIVE.SURVEY.RATE/ARS04",
                SettlementRateOption.ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03 => "ARS.EMTA.INDUSTRY.SURVEY.RATE/ARS03",
                SettlementRateOption.ARS_MAE_ARS05 => "ARS.MAE/ARS05",
                SettlementRateOption.ARS_OFFICIAL_RATE_ARS02 => "ARS.OFFICIAL.RATE/ARS02",
                SettlementRateOption.BRL_BRBY_BRL01 => "BRL.BRBY/BRL01",
                SettlementRateOption.BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13 => "BRL.EMTA.INDICATIVE.SURVEY.RATE/BRL13",
                SettlementRateOption.BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12 => "BRL.EMTA.INDUSTRY.SURVEY.RATE/BRL12",
                SettlementRateOption.BRL_OFFICIAL_RATE_BRL02 => "BRL.OFFICIAL.RATE/BRL02",
                SettlementRateOption.BRL_PCOT_COMMERCIAL_BRL03 => "BRL.PCOT-COMMERCIAL/BRL03",
                SettlementRateOption.BRL_PCOT_FLOATING_BRL04 => "BRL.PCOT-FLOATING/BRL04",
                SettlementRateOption.BRL_PTAX_BRL09 => "BRL.PTAX/BRL09",
                SettlementRateOption.BRL_PTAX_COMMERCIAL_BRFR_BRL06 => "BRL.PTAX-COMMERCIAL.BRFR/BRL06",
                SettlementRateOption.BRL_PTAX_COMMERCIAL_BRL05 => "BRL.PTAX-COMMERCIAL/BRL05",
                SettlementRateOption.BRL_PTAX_FLOATING_BRFR_BRL08 => "BRL.PTAX-FLOATING.BRFR/BRL08",
                SettlementRateOption.BRL_PTAX_FLOATING_BRL07 => "BRL.PTAX-FLOATING/BRL07",
                SettlementRateOption.CLP_BCCH_CLP01 => "CLP.BCCH/CLP01",
                SettlementRateOption.CLP_CHILD_INFORMAL_CLP02 => "CLP.CHILD-INFORMAL/CLP02",
                SettlementRateOption.CLP_CHILD_INTERBANK_CLP03 => "CLP.CHILD-INTERBANK/CLP03",
                SettlementRateOption.CLP_CHILD_OBSERVADO_CLP04 => "CLP.CHILD-OBSERVADO/CLP04",
                SettlementRateOption.CLP_CHILG_INFORMAL_CLP05 => "CLP.CHILG-INFORMAL/CLP05",
                SettlementRateOption.CLP_CHILG_INTERBANK_CLP06 => "CLP.CHILG-INTERBANK/CLP06",
                SettlementRateOption.CLP_CHILG_OBSERVADO_CLP07 => "CLP.CHILG-OBSERVADO/CLP07",
                SettlementRateOption.CLP_DOLAR_OBS_CLP10 => "CLP.DOLAR.OBS/CLP10",
                SettlementRateOption.CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11 => "CLP.EMTA.INDICATIVE.SURVEY.RATE/CLP11",
                SettlementRateOption.CLP_OFFICIAL_RATE_CLP08 => "CLP.OFFICIAL.RATE/CLP08",
                SettlementRateOption.CLP_TELERATE_38942_CLP09 => "CLP.TELERATE.38942/CLP09",
                SettlementRateOption.CNY_SAEC_CNY01 => "CNY.SAEC/CNY01",
                SettlementRateOption.CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02 => "CNY.SFEMC.INDICATIVE.SURVEY.RATE/CNY02",
                SettlementRateOption.COP_CO_COL03_COP01 => "COP.CO/COL03/COP01",
                SettlementRateOption.COP_EMTA_INDICATIVE_SURVEY_RATE_COP03 => "COP.EMTA.INDICATIVE.SURVEY.RATE/COP03",
                SettlementRateOption.COP_TRM_COP02 => "COP.TRM/COP02",
                SettlementRateOption.CURRENCY_IMPLIED_RATE__ADR__CURA1 => "CURRENCY-IMPLIED.RATE.(ADR)/CURA1",
                SettlementRateOption.CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2 => "CURRENCY-IMPLIED.RATE.(LOCAL.ASSET)/CURA2",
                SettlementRateOption.CURRENCY_MUTUAL_AGREEMENT_CURA3 => "CURRENCY-MUTUAL.AGREEMENT/CURA3",
                SettlementRateOption.CURRENCY_REFERENCE_DEALERS_CURA4 => "CURRENCY-REFERENCE.DEALERS/CURA4",
                SettlementRateOption.CURRENCY_WHOLESALE_MARKET_CURA5 => "CURRENCY-WHOLESALE.MARKET/CURA5",
                SettlementRateOption.ECS_DNRP_ECS01 => "ECS.DNRP/ECS01",
                SettlementRateOption.IDR_ABS_IDR01 => "IDR.ABS/IDR01",
                SettlementRateOption.IDR_JISDOR_IDR04 => "IDR.JISDOR/IDR04",
                SettlementRateOption.IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02 => "IDR.SFEMC.INDICATIVE.SURVEY.RATE/IDR02",
                SettlementRateOption.IDR_VWAP_IDR03 => "IDR.VWAP/IDR03",
                SettlementRateOption.ILS_BOIJ_ILS01 => "ILS.BOIJ/ILS01",
                SettlementRateOption.ILS_FXIL_ILS02 => "ILS.FXIL/ILS02",
                SettlementRateOption.INR_FBIL_INR01 => "INR.FBIL/INR01",
                SettlementRateOption.INR_RBIB_INR01 => "INR.RBIB/INR01",
                SettlementRateOption.INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02 => "INR.SFEMC.INDICATIVE.SURVEY.RATE/INR02",
                SettlementRateOption.KRW_KEBEY_KRW01 => "KRW.KEBEY/KRW01",
                SettlementRateOption.KRW_KFTC18_KRW02 => "KRW.KFTC18/KRW02",
                SettlementRateOption.KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04 => "KRW.SFEMC.INDICATIVE.SURVEY.RATE/KRW04",
                SettlementRateOption.KRW_TELERATE_45644_KRW03 => "KRW.TELERATE.45644/KRW03",
                SettlementRateOption.KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02 => "KZT.EMTA.INDICATIVE.SURVEY.RATE/KZT02",
                SettlementRateOption.KZT_KASE_KZT01 => "KZT.KASE/KZT01",
                SettlementRateOption.LBP_BDLX_LBP01 => "LBP.BDLX/LBP01",
                SettlementRateOption.MAD_OFFICIAL_RATE_MAD01 => "MAD.OFFICIAL.RATE/MAD01",
                SettlementRateOption.MXP_BNMX_MXP01 => "MXP.BNMX/MXP01",
                SettlementRateOption.MXP_FIXING_RATE_MXP02 => "MXP.FIXING.RATE/MXP02",
                SettlementRateOption.MXP_MEX01_MXP03 => "MXP.MEX01/MXP03",
                SettlementRateOption.MXP_PUBLISHED_MXP04 => "MXP.PUBLISHED/MXP04",
                SettlementRateOption.MYR_ABS_MYR01 => "MYR.ABS/MYR01",
                SettlementRateOption.MYR_KL_REF_MYR04 => "MYR.KL.REF/MYR04",
                SettlementRateOption.MYR_PPKM_MYR03 => "MYR.PPKM/MYR03",
                SettlementRateOption.MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02 => "MYR.SFEMC.INDICATIVE.SURVEY.RATE/MYR02",
                SettlementRateOption.PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04 => "PEN.EMTA.INDICATIVE.SURVEY.RATE/PEN04",
                SettlementRateOption.PEN_INTERBANK_AVE_PEN05 => "PEN.INTERBANK.AVE/PEN05",
                SettlementRateOption.PEN_PDSB_PEN01 => "PEN.PDSB/PEN01",
                SettlementRateOption.PEN_WT_AVE_PEN03 => "PEN.WT.AVE/PEN03",
                SettlementRateOption.PHP_BAPPESO_PHP06 => "PHP.BAPPESO/PHP06",
                SettlementRateOption.PHP_PDSPESO_PHP06 => "PHP.PDSPESO/PHP06",
                SettlementRateOption.PHP_PHPESO_PHP01 => "PHP.PHPESO/PHP01",
                SettlementRateOption.PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05 => "PHP.SFEMC.INDICATIVE.SURVEY.RATE/PHP05",
                SettlementRateOption.PHP_TELERATE_15439_PHP03 => "PHP.TELERATE.15439/PHP03",
                SettlementRateOption.PHP_TELERATE_2920_PHP02 => "PHP.TELERATE.2920/PHP02",
                SettlementRateOption.PKR_SBPK_PKR01 => "PKR.SBPK/PKR01",
                SettlementRateOption.PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02 => "PKR.SFEMC.INDICATIVE.SURVEY.RATE/PKR02",
                SettlementRateOption.PLZ_NBPQ_PLZ01 => "PLZ.NBPQ/PLZ01",
                SettlementRateOption.PLZ_NBPR_PLZ02 => "PLZ.NBPR/PLZ02",
                SettlementRateOption.RUB_CME_EMTA_RUB03 => "RUB.CME-EMTA/RUB03",
                SettlementRateOption.RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04 => "RUB.EMTA.INDICATIVE.SURVEY.RATE/RUB04",
                SettlementRateOption.RUB_MICEXFRX_RUB01 => "RUB.MICEXFRX/RUB01",
                SettlementRateOption.RUB_MMVB_RUB02 => "RUB.MMVB/RUB02",
                SettlementRateOption.SGD_VWAP_SGD3 => "SGD.VWAP/SGD3",
                SettlementRateOption.SKK_NBSB_SKK01 => "SKK.NBSB/SKK01",
                SettlementRateOption.THB_ABS_THB01 => "THB.ABS/THB01",
                SettlementRateOption.THB_VWAP_THB01 => "THB.VWAP/THB01",
                SettlementRateOption.TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04 => "TWD.SFEMC.INDICATIVE.SURVEY.RATE/TWD04",
                SettlementRateOption.TWD_TAIFX1_TWD03 => "TWD.TAIFX1/TWD03",
                SettlementRateOption.TWD_TELERATE_6161_TWD01 => "TWD.TELERATE.6161/TWD01",
                SettlementRateOption.TWD_TFEMA_TWD02 => "TWD.TFEMA/TWD02",
                SettlementRateOption.UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03 => "UAH.EMTA.INDICATIVE.SURVEY.RATE/UAH03",
                SettlementRateOption.UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02 => "UAH.EMTA.INDUSTRY.SURVEY.RATE/UAH02",
                SettlementRateOption.UAH_GFI_UAH01 => "UAH.GFI/UAH01",
                SettlementRateOption.VEF_FIX_VEF01 => "VEF.FIX/VEF01",
                SettlementRateOption.VND_ABS_VND01 => "VND.ABS/VND01",
                SettlementRateOption.VND_FX_VND02 => "VND.FX/VND02",
                SettlementRateOption.VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03 => "VND.SFEMC.INDICATIVE.SURVEY.RATE/VND03",
                _ => nameof(value)
            };
        }
    }
    
    /// <summary>
    /// The enumeration values to specify how the option is to be settled when exercised.
    /// </summary>
    [CdmName("SettlementTypeEnum")]
    public enum SettlementType
    {
        /// <summary>
        /// The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
        /// </summary>
        [EnumMember(Value = "CASH")]
        Cash,
        
        /// <summary>
        /// Allow use of either Cash or Physical settlement without prior Election.
        /// </summary>
        [EnumMember(Value = "CASH_OR_PHYSICAL")]
        CashOrPhysical,
        
        /// <summary>
        /// Allow Election of either Cash or Physical settlement.
        /// </summary>
        [EnumMember(Value = "ELECTION")]
        Election,
        
        /// <summary>
        /// The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
        /// </summary>
        [EnumMember(Value = "PHYSICAL")]
        Physical
    }
    
    /// <summary>
    /// The enumerated values to specify the consequences of extraordinary events relating to the underlying.
    /// </summary>
    [CdmName("ShareExtraordinaryEventEnum")]
    public enum ShareExtraordinaryEvent
    {
        /// <summary>
        /// The trade continues such that the underlying now consists of the New Shares and/or the Other Consideration, if any, and the proceeds of any redemption, if any, that the holder of the underlying Shares would have been entitled to.
        /// </summary>
        [EnumMember(Value = "ALTERNATIVE_OBLIGATION")]
        AlternativeObligation,
        
        /// <summary>
        /// The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments may not be made to account solely for changes in volatility, expected dividends, stock loan rate or liquidity.
        /// </summary>
        [EnumMember(Value = "CALCULATION_AGENT")]
        CalculationAgent,
        
        /// <summary>
        /// The trade is cancelled and a cancellation fee will be paid by one party to the other.
        /// </summary>
        [EnumMember(Value = "CANCELLATION_AND_PAYMENT")]
        CancellationAndPayment,
        
        /// <summary>
        /// If this is a Share-for-Combined merger event (Shares are replaced with New Shares and Other Consideration), then different treatment can be applied to each component if the parties have specified this.
        /// </summary>
        [EnumMember(Value = "COMPONENT")]
        Component,
        
        /// <summary>
        /// The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments to account for changes in volatility, expected dividends, stock loan rate or liquidity are allowed.
        /// </summary>
        [EnumMember(Value = "MODIFIED_CALCULATION_AGENT")]
        ModifiedCalculationAgent,
        
        /// <summary>
        /// The trade will be adjusted by the Calculation Agent in accordance with the adjustments made by any exchange on which options on the underlying are listed.
        /// </summary>
        [EnumMember(Value = "OPTIONS_EXCHANGE")]
        OptionsExchange,
        
        /// <summary>
        /// Applies to Basket Transactions. The portion of the Basket made up by the affected Share will be cancelled and a cancellation fee will be paid from one party to the other. The remainder of the trade continues.
        /// </summary>
        [EnumMember(Value = "PARTIAL_CANCELLATION_AND_PAYMENT")]
        PartialCancellationAndPayment
    }
    
    /// <summary>
    /// The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined.
    /// </summary>
    [CdmName("SpecifiedEntityClauseEnum")]
    public enum SpecifiedEntityClause
    {
        [EnumMember(Value = "BANKRUPTCY")]
        Bankruptcy,
        
        [EnumMember(Value = "CREDIT_EVENT_UPON_MERGER")]
        CreditEventUponMerger,
        
        [EnumMember(Value = "CROSS_DEFAULT")]
        CrossDefault,
        
        [EnumMember(Value = "DEFAULT_UNDER_SPECIFIED_TRANSACTION")]
        DefaultUnderSpecifiedTransaction
    }
    
    /// <summary>
    /// The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
    /// </summary>
    [CdmName("SpecifiedEntityTermsEnum")]
    public enum SpecifiedEntityTerms
    {
        /// <summary>
        /// Any Affiliate is a Specified Entity.
        /// </summary>
        [EnumMember(Value = "ANY_AFFILIATE")]
        AnyAffiliate,
        
        /// <summary>
        /// Any Material Subsidiary.
        /// </summary>
        [EnumMember(Value = "MATERIAL_SUBSIDIARY")]
        MaterialSubsidiary,
        
        /// <summary>
        /// The Specified Entity is provided.
        /// </summary>
        [EnumMember(Value = "NAMED_SPECIFIED_ENTITY")]
        NamedSpecifiedEntity,
        
        /// <summary>
        /// No Specified Entity is provided
        /// </summary>
        [EnumMember(Value = "NONE")]
        None,
        
        /// <summary>
        /// Non standard Specified Entity terms are provided.
        /// </summary>
        [EnumMember(Value = "OTHER_SPECIFIED_ENTITY")]
        OtherSpecifiedEntity
    }
    
    /// <summary>
    /// Method by which spread is calculated. For example on an asset swap: &apos;ParPar&apos; or &apos;Proceeds&apos; may be the method indicated.
    /// </summary>
    [CdmName("SpreadCalculationMethodEnum")]
    public enum SpreadCalculationMethod
    {
        [EnumMember(Value = "PAR_PAR")]
        ParPar,
        
        [EnumMember(Value = "PROCEEDS")]
        Proceeds
    }
    
    /// <summary>
    /// The enumerated values to specify a long or short spread value.
    /// </summary>
    [CdmName("SpreadScheduleTypeEnum")]
    public enum SpreadScheduleType
    {
        /// <summary>
        /// Represents a Long Spread Schedule. Spread schedules defined as &apos;Long&apos; will be applied to Long Positions.
        /// </summary>
        [EnumMember(Value = "LONG")]
        Long,
        
        /// <summary>
        /// Represents a Short Spread Schedule. Spread schedules defined as &apos;Short&apos; will be applied to Short Positions.
        /// </summary>
        [EnumMember(Value = "SHORT")]
        Short
    }
    
    /// <summary>
    /// The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
    /// </summary>
    [CdmName("StandardSettlementStyleEnum")]
    public enum StandardSettlementStyle
    {
        /// <summary>
        /// This trade is a candidate for settlement netting.
        /// </summary>
        [EnumMember(Value = "NET")]
        Net,
        
        /// <summary>
        /// These trades have been paired and are a candidate for settlement netting.
        /// </summary>
        [EnumMember(Value = "PAIR_AND_NET")]
        PairAndNet,
        
        /// <summary>
        /// This trade will settle using standard predetermined funds settlement instructions.
        /// </summary>
        [EnumMember(Value = "STANDARD")]
        Standard,
        
        /// <summary>
        /// This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
        /// </summary>
        [EnumMember(Value = "STANDARD_AND_NET")]
        StandardAndNet
    }
    
    [CdmName("StandardizedScheduleAssetClassEnum")]
    public enum StandardizedScheduleAssetClass
    {
        [EnumMember(Value = "COMMODITY")]
        Commodity,
        
        [EnumMember(Value = "CREDIT")]
        Credit,
        
        [EnumMember(Value = "EQUITY")]
        Equity,
        
        [EnumMember(Value = "FOREIGN_EXCHANGE")]
        ForeignExchange,
        
        [EnumMember(Value = "INTEREST_RATES")]
        InterestRates
    }
    
    [CdmName("StandardizedScheduleProductClassEnum")]
    public enum StandardizedScheduleProductClass
    {
        [EnumMember(Value = "BASIS_SWAP")]
        BasisSwap,
        
        [EnumMember(Value = "CONTRACT_FOR_DIFFERENCE")]
        ContractForDifference,
        
        [EnumMember(Value = "CORRELATION_SWAP")]
        CorrelationSwap,
        
        [EnumMember(Value = "CREDIT_NTH_TO_DEFAULT")]
        CreditNthToDefault,
        
        [EnumMember(Value = "CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND")]
        CreditTotalReturnSwapOnABond,
        
        [EnumMember(Value = "CROSS_CURRENCY_SWAP")]
        CrossCurrencySwap,
        
        [EnumMember(Value = "DELIVERABLE_FORWARD")]
        DeliverableForward,
        
        [EnumMember(Value = "DELIVERABLE_OPTION")]
        DeliverableOption,
        
        [EnumMember(Value = "DELIVERABLE_OPTION_F")]
        DeliverableOptionF,
        
        [EnumMember(Value = "DELIVERABLE_SWAP")]
        DeliverableSwap,
        
        [EnumMember(Value = "DIVIDEND_SWAP")]
        DividendSwap,
        
        [EnumMember(Value = "FIXED_FLOAT_SWAP")]
        FixedFloatSwap,
        
        [EnumMember(Value = "FORWARD")]
        Forward,
        
        [EnumMember(Value = "FORWARD_RATE_AGREEMENT")]
        ForwardRateAgreement,
        
        [EnumMember(Value = "IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG")]
        IRExoticSwapWithAnExoticCouponAgainstAFloatingLeg,
        
        [EnumMember(Value = "INDEX_CDS")]
        IndexCDS,
        
        [EnumMember(Value = "INDEX_TRANCHE")]
        IndexTranche,
        
        [EnumMember(Value = "NON_DELIVERABLE_CROSS_CURRENCY_SWAP")]
        NonDeliverableCrossCurrencySwap,
        
        [EnumMember(Value = "NON_DELIVERABLE_FORWARD")]
        NonDeliverableForward,
        
        [EnumMember(Value = "NON_DELIVERABLE_OPTION")]
        NonDeliverableOption,
        
        [EnumMember(Value = "OPTION")]
        Option,
        
        [EnumMember(Value = "SINGLE_NAME_CREDIT_DEFAULT_SWAP")]
        SingleNameCreditDefaultSwap,
        
        [EnumMember(Value = "SWAP")]
        Swap,
        
        [EnumMember(Value = "SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS")]
        SwapWithCallableBermudanRightToEnterExitSwaps,
        
        [EnumMember(Value = "SWAPS_AND_PORTFOLIO_SWAPS")]
        SwapsAndPortfolioSwaps,
        
        [EnumMember(Value = "SWAPTION")]
        Swaption,
        
        [EnumMember(Value = "SWAPTION_STRADDLE")]
        SwaptionStraddle,
        
        [EnumMember(Value = "VARIANCE_SWAP")]
        VarianceSwap,
        
        [EnumMember(Value = "VOLATILITY_SWAP")]
        VolatilitySwap
    }
    
    /// <summary>
    /// The enumerated values to specify how to deal with a non standard calculation period within a swap stream.
    /// </summary>
    [CdmName("StubPeriodTypeEnum")]
    public enum StubPeriodType
    {
        /// <summary>
        /// If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period.
        /// </summary>
        [EnumMember(Value = "LONG_FINAL")]
        LongFinal,
        
        /// <summary>
        /// If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period.
        /// </summary>
        [EnumMember(Value = "LONG_INITIAL")]
        LongInitial,
        
        /// <summary>
        /// If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream.
        /// </summary>
        [EnumMember(Value = "SHORT_FINAL")]
        ShortFinal,
        
        /// <summary>
        /// If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream.
        /// </summary>
        [EnumMember(Value = "SHORT_INITIAL")]
        ShortInitial
    }
    
    /// <summary>
    /// Represents an enumeration list to identify the type of supranational entity issuing the asset.
    /// </summary>
    [CdmName("SupraNationalIssuerTypeEnum")]
    public enum SupraNationalIssuerType
    {
        /// <summary>
        /// Specifies International Financial Institution.
        /// </summary>
        [EnumMember(Value = "INTERNATIONAL_ORGANISATION")]
        InternationalOrganisation,
        
        /// <summary>
        /// Specifies Multilateral Bank or Multilateral Development Bank.
        /// </summary>
        [EnumMember(Value = "MULTILATERAL_BANK")]
        MultilateralBank
    }
    
    /// <summary>
    /// Represents the enumerated values to specify taxonomy sources.
    /// </summary>
    [CdmName("TaxonomySourceEnum")]
    public enum TaxonomySource
    {
        /// <summary>
        /// Represents the ISO 10962 Classification of Financial Instruments code.
        /// </summary>
        CFI,
        
        /// <summary>
        /// Represents the EMIR Article 9 Asset Definition Identifier code.
        /// </summary>
        EMIR,
        
        /// <summary>
        /// Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules.
        /// </summary>
        [EnumMember(Value = "EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")]
        EU_EMIR_EligibleCollateralAssetClass,
        
        /// <summary>
        /// Represents the ISDA Collateral Asset Definition Identifier code.
        /// </summary>
        ICAD,
        
        /// <summary>
        /// Represents the ISDA product taxonomy.
        /// </summary>
        ISDA,
        
        /// <summary>
        /// Represents the Monetary Authority of Singapore (MAS) as a taxonomy source.
        /// </summary>
        MAS,
        
        /// <summary>
        /// Denotes a user-specific scheme or taxonomy or other external sources not listed here.
        /// </summary>
        [EnumMember(Value = "OTHER")]
        Other,
        
        /// <summary>
        /// Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities.Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")]
        UK_EMIR_EligibleCollateralAssetClass,
        
        /// <summary>
        /// Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS")]
        US_CFTC_PR_EligibleCollateralAssetClass
    }
    
    /// <summary>
    /// The enumerated values to specify the type of telephone number, e.g. work vs. mobile.
    /// </summary>
    [CdmName("TelephoneTypeEnum")]
    public enum TelephoneType
    {
        /// <summary>
        /// A number used primarily for work-related facsimile transmissions.
        /// </summary>
        [EnumMember(Value = "FAX")]
        Fax,
        
        /// <summary>
        /// A number on a mobile telephone that is often or usually used for work-related calls. This type of number can be used for urgent work related business when a work number is not sufficient to contact the person or firm.
        /// </summary>
        [EnumMember(Value = "MOBILE")]
        Mobile,
        
        /// <summary>
        /// A number used primarily for non work-related calls. (Normally this type of number would be used only as an emergency backup number, not as a regular course of business).
        /// </summary>
        [EnumMember(Value = "PERSONAL")]
        Personal,
        
        /// <summary>
        /// A number used primarily for work-related calls. Includes home office numbers used primarily for work purposes.
        /// </summary>
        [EnumMember(Value = "WORK")]
        Work
    }
    
    [CdmName("TerminationCurrencyConditionEnum")]
    public enum TerminationCurrencyCondition
    {
        /// <summary>
        /// A currency that is freely available.
        /// </summary>
        [EnumMember(Value = "FREELY_AVAILABLE")]
        FreelyAvailable,
        
        /// <summary>
        /// A currency in which payments would be due under one or more Transactions.
        /// </summary>
        [EnumMember(Value = "PAYMENTS_DUE")]
        PaymentsDue,
        
        /// <summary>
        /// A currency in which payments would be due under one or more Transactions and that is freely available.
        /// </summary>
        [EnumMember(Value = "PAYMENTS_DUE_AND_FREELY_AVAILABLE")]
        PaymentsDueAndFreelyAvailable,
        
        /// <summary>
        /// Termination Currency Conditions are specified.
        /// </summary>
        [EnumMember(Value = "SPECIFIED")]
        Specified
    }
    
    /// <summary>
    /// The enumerated values to specify points in the day when option exercise and valuation can occur.
    /// </summary>
    [CdmName("TimeTypeEnum")]
    public enum TimeType
    {
        /// <summary>
        /// The time is determined as provided in the relevant Master Confirmation.
        /// </summary>
        [EnumMember(Value = "AS_SPECIFIED_IN_MASTER_CONFIRMATION")]
        AsSpecifiedInMasterConfirmation,
        
        /// <summary>
        /// The official closing time of the exchange on the valuation date.
        /// </summary>
        [EnumMember(Value = "CLOSE")]
        Close,
        
        /// <summary>
        /// The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
        /// </summary>
        [EnumMember(Value = "DERIVATIVES_CLOSE")]
        DerivativesClose,
        
        /// <summary>
        /// The time at which the official settlement price is determined.
        /// </summary>
        OSP,
        
        /// <summary>
        /// The official opening time of the exchange on the valuation date.
        /// </summary>
        [EnumMember(Value = "OPEN")]
        Open,
        
        /// <summary>
        /// The time specified in the element equityExpirationTime or valuationTime (as appropriate).
        /// </summary>
        [EnumMember(Value = "SPECIFIC_TIME")]
        SpecificTime,
        
        /// <summary>
        /// The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
        /// </summary>
        XETRA
    }
    
    /// <summary>
    /// The enumeration values to qualify the allowed units of time.
    /// </summary>
    [CdmName("TimeUnitEnum")]
    public enum TimeUnit
    {
        /// <summary>
        /// Day
        /// </summary>
        [EnumMember(Value = "DAY")]
        Day,
        
        /// <summary>
        /// Hour
        /// </summary>
        [EnumMember(Value = "HOUR")]
        Hour,
        
        /// <summary>
        /// Minute
        /// </summary>
        [EnumMember(Value = "MINUTE")]
        Minute,
        
        /// <summary>
        /// Month
        /// </summary>
        [EnumMember(Value = "MONTH")]
        Month,
        
        /// <summary>
        /// Second
        /// </summary>
        [EnumMember(Value = "SECOND")]
        Second,
        
        /// <summary>
        /// Week
        /// </summary>
        [EnumMember(Value = "WEEK")]
        Week,
        
        /// <summary>
        /// Year
        /// </summary>
        [EnumMember(Value = "YEAR")]
        Year
    }
    
    /// <summary>
    /// Defines the enumerated values to specify the nature of a trade identifier.
    /// </summary>
    [CdmName("TradeIdentifierTypeEnum")]
    public enum TradeIdentifierType
    {
        [EnumMember(Value = "UNIQUE_SWAP_IDENTIFIER")]
        UniqueSwapIdentifier,
        
        [EnumMember(Value = "UNIQUE_TRANSACTION_IDENTIFIER")]
        UniqueTransactionIdentifier
    }
    
    /// <summary>
    /// The enumeration values to specify how the transfer will settle, e.g. DvP.
    /// </summary>
    [CdmName("TransferSettlementEnum")]
    public enum TransferSettlement
    {
        /// <summary>
        /// Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
        /// </summary>
        [EnumMember(Value = "DELIVERY_VERSUS_DELIVERY")]
        DeliveryVersusDelivery,
        
        /// <summary>
        /// Settlement in which the transfer of the asset and the cash settlement are simultaneous.
        /// </summary>
        [EnumMember(Value = "DELIVERY_VERSUS_PAYMENT")]
        DeliveryVersusPayment,
        
        /// <summary>
        /// No central settlement.
        /// </summary>
        [EnumMember(Value = "NOT_CENTRAL_SETTLEMENT")]
        NotCentralSettlement,
        
        /// <summary>
        /// Simultaneous transfer of cashflows.
        /// </summary>
        [EnumMember(Value = "PAYMENT_VERSUS_PAYMENT")]
        PaymentVersusPayment
    }
    
    /// <summary>
    /// The enumeration values to specify the transfer status.
    /// </summary>
    [CdmName("TransferStatusEnum")]
    public enum TransferStatus
    {
        /// <summary>
        /// The transfer is disputed.
        /// </summary>
        [EnumMember(Value = "DISPUTED")]
        Disputed,
        
        /// <summary>
        /// The transfer has been instructed.
        /// </summary>
        [EnumMember(Value = "INSTRUCTED")]
        Instructed,
        
        /// <summary>
        /// The transfer has been netted into a separate Transfer.
        /// </summary>
        [EnumMember(Value = "NETTED")]
        Netted,
        
        /// <summary>
        /// The transfer is pending instruction.
        /// </summary>
        [EnumMember(Value = "PENDING")]
        Pending,
        
        /// <summary>
        /// The transfer has been settled.
        /// </summary>
        [EnumMember(Value = "SETTLED")]
        Settled
    }
    
    /// <summary>
    /// The enumerated values to specify the time of day which would be considered for valuing the knock event.
    /// </summary>
    [CdmName("TriggerTimeTypeEnum")]
    public enum TriggerTimeType
    {
        /// <summary>
        /// At any time during the Knock Determination period (continuous barrier).
        /// </summary>
        [EnumMember(Value = "ANYTIME")]
        Anytime,
        
        /// <summary>
        /// The close of trading on a day would be considered for valuation.
        /// </summary>
        [EnumMember(Value = "CLOSING")]
        Closing
    }
    
    /// <summary>
    /// The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
    /// </summary>
    [CdmName("TriggerTypeEnum")]
    public enum TriggerType
    {
        /// <summary>
        /// The underlier price must be equal to the Trigger level.
        /// </summary>
        [EnumMember(Value = "EQUAL")]
        Equal,
        
        /// <summary>
        /// The underlier price must be equal to or greater than the Trigger level.
        /// </summary>
        [EnumMember(Value = "EQUAL_OR_GREATER")]
        EqualOrGreater,
        
        /// <summary>
        /// The underlier price must be equal to or less than the Trigger level.
        /// </summary>
        [EnumMember(Value = "EQUAL_OR_LESS")]
        EqualOrLess,
        
        /// <summary>
        /// The underlier price must be greater than the Trigger level.
        /// </summary>
        [EnumMember(Value = "GREATER")]
        Greater,
        
        /// <summary>
        /// The underlier price must be less than the Trigger level.
        /// </summary>
        [EnumMember(Value = "LESS")]
        Less
    }
    
    /// <summary>
    /// Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
    /// </summary>
    [CdmName("UK_EMIR_EligibleCollateralEnum")]
    public enum UK_EMIR_EligibleCollateral
    {
        /// <summary>
        /// Denotes cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_A")]
        UK_EMIRTypeA,
        
        /// <summary>
        /// Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_B")]
        UK_EMIRTypeB,
        
        /// <summary>
        /// Denotes debt securities issued by the central government of the United Kingdom or the Bank of England.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_C")]
        UK_EMIRTypeC,
        
        /// <summary>
        /// Denotes debt securities issued by United Kingdom regional governments or local authorities whose exposures are treated as exposures to the central government of the United Kingdom in accordance with Article 115(2) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_D")]
        UK_EMIRTypeD,
        
        /// <summary>
        /// Denotes debt securities issued by United Kingdom public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of the United Kingdom in accordance with Article 116(4) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_E")]
        UK_EMIRTypeE,
        
        /// <summary>
        /// Denotes debt securities issued by United Kingdom regional governments or local authorities other than those referred to in (TypeD).
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_F")]
        UK_EMIRTypeF,
        
        /// <summary>
        /// Denotes debt securities issued by United Kingdom public sector entities other than those referred to in (TypeE).
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_G")]
        UK_EMIRTypeG,
        
        /// <summary>
        /// Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_H")]
        UK_EMIRTypeH,
        
        /// <summary>
        /// Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_I")]
        UK_EMIRTypeI,
        
        /// <summary>
        /// Denotes debt securities issued by third countries&apos; governments or central banks.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_J")]
        UK_EMIRTypeJ,
        
        /// <summary>
        /// Denotes debt securities issued by third countries&apos; regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_K")]
        UK_EMIRTypeK,
        
        /// <summary>
        /// Denotes debt securities issued by third countries&apos; regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_L")]
        UK_EMIRTypeL,
        
        /// <summary>
        /// Denotes debt securities issued by credit institutions or investment firms including bonds admitted to the register of regulated covered bonds maintained under Regulation 7(1)(b) of the Regulated Covered Bonds Regulations 2008 (SI 2008/346).
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_M")]
        UK_EMIRTypeM,
        
        /// <summary>
        /// Denotes corporate bonds.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_N")]
        UK_EMIRTypeN,
        
        /// <summary>
        /// Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_O")]
        UK_EMIRTypeO,
        
        /// <summary>
        /// Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_P")]
        UK_EMIRTypeP,
        
        /// <summary>
        /// Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_Q")]
        UK_EMIRTypeQ,
        
        /// <summary>
        /// Denotes shares or units in undertakings for UK UCITS, provided that the conditions set out in Article 5 of EU Regulation 2016/2251 (as modified by the Technical Standards (European Market Infrastructure) (EU Exit) (No. 3) Instrument 2019) are met.
        /// </summary>
        [EnumMember(Value = "UK_EMIR_TYPE_R")]
        UK_EMIRTypeR
    }
    
    /// <summary>
    /// Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
    /// </summary>
    [CdmName("US_CFTC_PR_EligibleCollateralEnum")]
    public enum US_CFTC_PR_EligibleCollateral
    {
        /// <summary>
        /// Denotes immediately available cash funds denominated in USD, a major currency, a currency of settlement for the uncleared swap.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_1")]
        US_CFTC_PRType1,
        
        /// <summary>
        /// Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_2")]
        US_CFTC_PRType2,
        
        /// <summary>
        /// Denotes a security that is issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, a U.S. government agency (other than the U.S. Department of Treasury) whose obligations are fully guaranteed by the full faith and credit of the United States government.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_3")]
        US_CFTC_PRType3,
        
        /// <summary>
        /// Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_4")]
        US_CFTC_PRType4,
        
        /// <summary>
        /// Denotes a publicly traded debt security issued by, or an asset-backed security fully guaranteed as to the timely payment of principal and interest by, a U.S. Government-sponsored enterprise that is operating with capital support or another form of direct financial assistance received from the U.S. government that enables the repayments of the U.S. Government-sponsored enterprise&apos;s eligible securities.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_5_A")]
        US_CFTC_PRType5A,
        
        /// <summary>
        /// Denotes a publicly traded debt security, but not an asset backed security, that is investment grade and issued by a U.S. Government-sponsored enterprise that is not operating with capital support or another form of direct financial assistance received from the U.S. government.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_5_B")]
        US_CFTC_PRType5B,
        
        /// <summary>
        /// Denotes a security that is issued by, or fully guaranteed as to the payment of principal and interest by, the Bank for International Settlements, the International Monetary Fund, or a multilateral development bank.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_6")]
        US_CFTC_PRType6,
        
        /// <summary>
        /// Denotes publicly-traded debt, but not an asset backed security, that is investment grade and is not a debt security issued by a  U.S. Government-sponsored enterprise. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_7")]
        US_CFTC_PRType7,
        
        /// <summary>
        /// Denotes a publicly traded common equity security that is included in the Standard &amp; Poor&apos;s Composite 500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_8_A")]
        US_CFTC_PRType8A,
        
        /// <summary>
        ///  Denotes a publicly traded common equity security that is included in the Standard &amp; Poor&apos;s Composite 1500 Index or related indexes. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_8_B")]
        US_CFTC_PRType8B,
        
        /// <summary>
        /// Denotes a publicly traded common equity security that is included in an index that a regulated swap entity&apos;s supervisor in a foreign jurisdiction recognizes for purposes of including publicly traded common equity as initial margin under applicable regulatory policy, if held in that foreign jurisdiction. This category excludes a security issued by a non-bank financial institution supervised by the board of governors of the Federal Reserve System under Title I of the Dodd-Frank Wall Street Reform and Consumer Protection Act. This category also excludes a security issued by any of the following entities, by a company that would be any of the following entities if it were the organized under the laws of the United States or any State, or in either case by an affiliate of such an entity: the party posting the collateral, a bank holding company, a savings and loan holding company, a U.S. intermediate holding company, a foreign bank, a depositary institution, a securities holding company, a broker, a dealer, a futures commission merchant, a swap dealer, or a security-based swap dealer.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_8_C")]
        US_CFTC_PRType8C,
        
        /// <summary>
        /// Denotes securities in the form of redeemable securities in a pooled investment fund representing the security-holder&apos;s proportional interest in the fund&apos;s net assets and that are issued and redeemed only on the basis of the market value of the fund&apos;s net assets prepared each business day after the security-holder makes its investment commitment or redemption request to the fund, if the fund&apos;s investments are limited to the following: (A) securities that are issued by, or unconditionally guaranteed as to the timely payment of principal and interest by, the U.S. Department of the Treasury, and immediately-available cash funds denominated in U.S. dollars; or (B) securities denominated in a common currency and issued by, or fully guaranteed as to the payment of principal and interest by, the European Central Bank or a sovereign entity that is assigned no higher than a 20 percent risk weight under the capital rules applicable to swap dealers subject to regulation by a prudential regulator, and immediately-available cash funds denominated in the same currency; and (C) assets of the fund may not be transferred through securities lending, securities borrowing, repurchase agreements, reverse repurchase agreements, or other means that involve the fund having rights to acquire the same or similar assets from the transferee.
        /// </summary>
        [EnumMember(Value = "US_CFTC_PR_TYPE_9")]
        US_CFTC_PRType9,
        
        /// <summary>
        /// Denotes Gold.
        /// </summary>
        [EnumMember(Value = "US_CTFC_PR_TYPE_10")]
        US_CTFC_PRType10
    }
    
    /// <summary>
    /// The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement.
    /// </summary>
    [CdmName("ValuationMethodEnum")]
    public enum ValuationMethod
    {
        [EnumMember(Value = "AVERAGE_BLENDED_HIGHEST")]
        AverageBlendedHighest,
        
        [EnumMember(Value = "AVERAGE_BLENDED_MARKET")]
        AverageBlendedMarket,
        
        [EnumMember(Value = "AVERAGE_HIGHEST")]
        AverageHighest,
        
        [EnumMember(Value = "AVERAGE_MARKET")]
        AverageMarket,
        
        [EnumMember(Value = "BLENDED_HIGHEST")]
        BlendedHighest,
        
        [EnumMember(Value = "BLENDED_MARKET")]
        BlendedMarket,
        
        [EnumMember(Value = "HIGHEST")]
        Highest,
        
        [EnumMember(Value = "MARKET")]
        Market
    }
    
    /// <summary>
    /// Source for the valuation of the transaction by the valuation party.
    /// </summary>
    [CdmName("ValuationSourceEnum")]
    public enum ValuationSource
    {
        /// <summary>
        /// Central Counterparty&apos;s Valuation
        /// </summary>
        [EnumMember(Value = "CENTRAL_COUNTERPARTY")]
        CentralCounterparty
    }
    
    /// <summary>
    /// Method used for the valuation of the transaction by the valuation party.
    /// </summary>
    [CdmName("ValuationTypeEnum")]
    public enum ValuationType
    {
        /// <summary>
        /// Mark-to-Market
        /// </summary>
        [EnumMember(Value = "MARK_TO_MARKET")]
        MarkToMarket,
        
        /// <summary>
        /// Mark-to-Model
        /// </summary>
        [EnumMember(Value = "MARK_TO_MODEL")]
        MarkToModel
    }
    
    [CdmName("WarehouseIdentityEnum")]
    public enum WarehouseIdentity
    {
        /// <summary>
        /// The DTCC Trade Information Warehouse Gold service
        /// </summary>
        [EnumMember(Value = "DTCC_TIW_GOLD")]
        DTCC_TIW_Gold
    }
    
    /// <summary>
    /// Provides enumerated values for weather units, generally used in the context of defining quantities for commodities.
    /// </summary>
    [CdmName("WeatherUnitEnum")]
    public enum WeatherUnit
    {
        /// <summary>
        /// Denotes Cooling Degree Days as a standard unit.
        /// </summary>
        CDD,
        
        /// <summary>
        /// Denotes Critical Precipitation Day as a standard unit.
        /// </summary>
        CPD,
        
        /// <summary>
        /// Heating Degree Day as a standard unit.
        /// </summary>
        HDD
    }
    
    /// <summary>
    /// The enumerated values to specify the weekly roll day.
    /// </summary>
    [CdmName("WeeklyRollConventionEnum")]
    public enum WeeklyRollConvention
    {
        /// <summary>
        /// Friday
        /// </summary>
        FRI,
        
        /// <summary>
        /// Monday
        /// </summary>
        MON,
        
        /// <summary>
        /// Saturday
        /// </summary>
        SAT,
        
        /// <summary>
        /// Sunday
        /// </summary>
        SUN,
        
        /// <summary>
        /// 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday
        /// </summary>
        TBILL,
        
        /// <summary>
        /// Thursday
        /// </summary>
        THU,
        
        /// <summary>
        /// Tuesday
        /// </summary>
        TUE,
        
        /// <summary>
        /// Wednesday
        /// </summary>
        WED
    }
    
    [CdmName("WorkflowStatusEnum")]
    public enum WorkflowStatus
    {
        [EnumMember(Value = "ACCEPTED")]
        Accepted,
        
        [EnumMember(Value = "AFFIRMED")]
        Affirmed,
        
        [EnumMember(Value = "ALLEGED")]
        Alleged,
        
        [EnumMember(Value = "AMENDED")]
        Amended,
        
        [EnumMember(Value = "CANCELLED")]
        Cancelled,
        
        [EnumMember(Value = "CERTAIN")]
        Certain,
        
        [EnumMember(Value = "CLEARED")]
        Cleared,
        
        [EnumMember(Value = "CONFIRMED")]
        Confirmed,
        
        [EnumMember(Value = "PENDING")]
        Pending,
        
        [EnumMember(Value = "REJECTED")]
        Rejected,
        
        [EnumMember(Value = "SUBMITTED")]
        Submitted,
        
        [EnumMember(Value = "TERMINATED")]
        Terminated,
        
        [EnumMember(Value = "UNCERTAIN")]
        Uncertain,
        
        [EnumMember(Value = "UNCONFIRMED")]
        Unconfirmed
    }
}
