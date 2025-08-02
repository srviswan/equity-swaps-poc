# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CurrencyCodeEnum']

class CurrencyCodeEnum(Enum):
    """
    Union of the enumerated values defined by the International Standards Organization (ISO) and the FpML nonISOCurrencyScheme which consists of offshore and historical currencies (https://www.fpml.org/coding-scheme/non-iso-currency), as of 28-Oct-2016.
    """
    AED = "AED"
    """
    UAE Dirham
    """
    AFN = "AFN"
    """
    Afghani
    """
    ALL = "ALL"
    """
    Lek
    """
    AMD = "AMD"
    """
    Armenian Dram
    """
    ANG = "ANG"
    """
    Netherlands Antillean Guilder
    """
    AOA = "AOA"
    """
    Kwanza
    """
    ARS = "ARS"
    """
    Argentine Peso
    """
    AUD = "AUD"
    """
    Australian Dollar
    """
    AWG = "AWG"
    """
    Aruban Florin
    """
    AZN = "AZN"
    """
    Azerbaijan Manat
    """
    BAM = "BAM"
    """
    Convertible Mark
    """
    BBD = "BBD"
    """
    Barbados Dollar
    """
    BDT = "BDT"
    """
    Taka
    """
    BGN = "BGN"
    """
    Bulgarian Lev
    """
    BHD = "BHD"
    """
    Bahraini Dinar
    """
    BIF = "BIF"
    """
    Burundi Franc
    """
    BMD = "BMD"
    """
    Bermudian Dollar
    """
    BND = "BND"
    """
    Brunei Dollar
    """
    BOB = "BOB"
    """
    Boliviano
    """
    BOV = "BOV"
    """
    Mvdol
    """
    BRL = "BRL"
    """
    Brazilian Real
    """
    BSD = "BSD"
    """
    Bahamian Dollar
    """
    BTN = "BTN"
    """
    Ngultrum
    """
    BWP = "BWP"
    """
    Pula
    """
    BYN = "BYN"
    """
    Belarusian Ruble
    """
    BZD = "BZD"
    """
    Belize Dollar
    """
    CAD = "CAD"
    """
    Canadian Dollar
    """
    CDF = "CDF"
    """
    Congolese Franc
    """
    CHE = "CHE"
    """
    WIR Euro
    """
    CHF = "CHF"
    """
    Swiss Franc
    """
    CHW = "CHW"
    """
    WIR Franc
    """
    CLF = "CLF"
    """
    Unidad de Fomento
    """
    CLP = "CLP"
    """
    Chilean Peso
    """
    CNH = "CNH"
    """
    Offshore Chinese Yuan traded in Hong Kong.
    """
    CNT = "CNT"
    """
    Offshore Chinese Yuan traded in Taiwan.
    """
    CNY = "CNY"
    """
    Yuan Renminbi
    """
    COP = "COP"
    """
    Colombian Peso
    """
    COU = "COU"
    """
    Unidad de Valor Real
    """
    CRC = "CRC"
    """
    Costa Rican Colon
    """
    CUC = "CUC"
    """
    Peso Convertible
    """
    CUP = "CUP"
    """
    Cuban Peso
    """
    CVE = "CVE"
    """
    Cabo Verde Escudo
    """
    CZK = "CZK"
    """
    Czech Koruna
    """
    DJF = "DJF"
    """
    Djibouti Franc
    """
    DKK = "DKK"
    """
    Danish Krone
    """
    DOP = "DOP"
    """
    Dominican Peso
    """
    DZD = "DZD"
    """
    Algerian Dinar
    """
    EGP = "EGP"
    """
    Egyptian Pound
    """
    ERN = "ERN"
    """
    Nakfa
    """
    ETB = "ETB"
    """
    Ethiopian Birr
    """
    EUR = "EUR"
    """
    Euro
    """
    FJD = "FJD"
    """
    Fiji Dollar
    """
    FKP = "FKP"
    """
    Falkland Islands Pound
    """
    GBP = "GBP"
    """
    Pound Sterling
    """
    GEL = "GEL"
    """
    Lari
    """
    GGP = "GGP"
    """
    Guernsey Pound.
    """
    GHS = "GHS"
    """
    Ghana Cedi
    """
    GIP = "GIP"
    """
    Gibraltar Pound
    """
    GMD = "GMD"
    """
    Dalasi
    """
    GNF = "GNF"
    """
    Guinean Franc
    """
    GTQ = "GTQ"
    """
    Quetzal
    """
    GYD = "GYD"
    """
    Guyana Dollar
    """
    HKD = "HKD"
    """
    Hong Kong Dollar
    """
    HNL = "HNL"
    """
    Lempira
    """
    HTG = "HTG"
    """
    Gourde
    """
    HUF = "HUF"
    """
    Forint
    """
    IDR = "IDR"
    """
    Rupiah
    """
    ILS = "ILS"
    """
    New Israeli Sheqel
    """
    IMP = "IMP"
    """
    Isle of Man Pound.
    """
    INR = "INR"
    """
    Indian Rupee
    """
    IQD = "IQD"
    """
    Iraqi Dinar
    """
    IRR = "IRR"
    """
    Iranian Rial
    """
    ISK = "ISK"
    """
    Iceland Krona
    """
    JEP = "JEP"
    """
    Jersey Pound.
    """
    JMD = "JMD"
    """
    Jamaican Dollar
    """
    JOD = "JOD"
    """
    Jordanian Dinar
    """
    JPY = "JPY"
    """
    Yen
    """
    KES = "KES"
    """
    Kenyan Shilling
    """
    KGS = "KGS"
    """
    Som
    """
    KHR = "KHR"
    """
    Riel
    """
    KID = "KID"
    """
    Tuvaluan Dollar.
    """
    KMF = "KMF"
    """
    Comorian Franc 
    """
    KPW = "KPW"
    """
    North Korean Won
    """
    KRW = "KRW"
    """
    Won
    """
    KWD = "KWD"
    """
    Kuwaiti Dinar
    """
    KYD = "KYD"
    """
    Cayman Islands Dollar
    """
    KZT = "KZT"
    """
    Tenge
    """
    LAK = "LAK"
    """
    Lao Kip
    """
    LBP = "LBP"
    """
    Lebanese Pound
    """
    LKR = "LKR"
    """
    Sri Lanka Rupee
    """
    LRD = "LRD"
    """
    Liberian Dollar
    """
    LSL = "LSL"
    """
    Loti
    """
    LYD = "LYD"
    """
    Libyan Dinar
    """
    MAD = "MAD"
    """
    Moroccan Dirham
    """
    MCF = "MCF"
    """
    Monegasque Franc.
    """
    MDL = "MDL"
    """
    Moldovan Leu
    """
    MGA = "MGA"
    """
    Malagasy Ariary
    """
    MKD = "MKD"
    """
    Denar
    """
    MMK = "MMK"
    """
    Kyat
    """
    MNT = "MNT"
    """
    Tugrik
    """
    MOP = "MOP"
    """
    Pataca
    """
    MRU = "MRU"
    """
    Ouguiya
    """
    MUR = "MUR"
    """
    Mauritius Rupee
    """
    MVR = "MVR"
    """
    Rufiyaa
    """
    MWK = "MWK"
    """
    Malawi Kwacha
    """
    MXN = "MXN"
    """
    Mexican Peso
    """
    MXV = "MXV"
    """
    Mexican Unidad de Inversion (UDI)
    """
    MYR = "MYR"
    """
    Malaysian Ringgit
    """
    MZN = "MZN"
    """
    Mozambique Metical
    """
    NAD = "NAD"
    """
    Namibia Dollar
    """
    NGN = "NGN"
    """
    Naira
    """
    NIO = "NIO"
    """
    Cordoba Oro
    """
    NOK = "NOK"
    """
    Norwegian Krone
    """
    NPR = "NPR"
    """
    Nepalese Rupee
    """
    NZD = "NZD"
    """
    New Zealand Dollar
    """
    OMR = "OMR"
    """
    Rial Omani
    """
    PAB = "PAB"
    """
    Balboa
    """
    PEN = "PEN"
    """
    Sol
    """
    PGK = "PGK"
    """
    Kina
    """
    PHP = "PHP"
    """
    Philippine Peso
    """
    PKR = "PKR"
    """
    Pakistan Rupee
    """
    PLN = "PLN"
    """
    Zloty
    """
    PYG = "PYG"
    """
    Guarani
    """
    QAR = "QAR"
    """
    Qatari Rial
    """
    RON = "RON"
    """
    Romanian Leu
    """
    RSD = "RSD"
    """
    Serbian Dinar
    """
    RUB = "RUB"
    """
    Russian Ruble
    """
    RWF = "RWF"
    """
    Rwanda Franc
    """
    SAR = "SAR"
    """
    Saudi Riyal
    """
    SBD = "SBD"
    """
    Solomon Islands Dollar
    """
    SCR = "SCR"
    """
    Seychelles Rupee
    """
    SDG = "SDG"
    """
    Sudanese Pound
    """
    SEK = "SEK"
    """
    Swedish Krona
    """
    SGD = "SGD"
    """
    Singapore Dollar
    """
    SHP = "SHP"
    """
    Saint Helena Pound
    """
    SLE = "SLE"
    """
    Leone
    """
    SML = "SML"
    """
    Sammarinese Lira.
    """
    SOS = "SOS"
    """
    Somali Shilling
    """
    SRD = "SRD"
    """
    Surinam Dollar
    """
    SSP = "SSP"
    """
    South Sudanese Pound
    """
    STN = "STN"
    """
    Dobra
    """
    SVC = "SVC"
    """
    El Salvador Colon
    """
    SYP = "SYP"
    """
    Syrian Pound
    """
    SZL = "SZL"
    """
    Lilangeni
    """
    THB = "THB"
    """
    Baht
    """
    TJS = "TJS"
    """
    Somoni
    """
    TMT = "TMT"
    """
    Turkmenistan New Manat
    """
    TND = "TND"
    """
    Tunisian Dinar
    """
    TOP = "TOP"
    """
    Pa’anga
    """
    TRY = "TRY"
    """
    Turkish Lira
    """
    TTD = "TTD"
    """
    Trinidad and Tobago Dollar
    """
    TWD = "TWD"
    """
    New Taiwan Dollar
    """
    TZS = "TZS"
    """
    Tanzanian Shilling
    """
    UAH = "UAH"
    """
    Hryvnia
    """
    UGX = "UGX"
    """
    Uganda Shilling
    """
    USD = "USD"
    """
    US Dollar
    """
    USN = "USN"
    """
    US Dollar (Next day)
    """
    UYI = "UYI"
    """
    Uruguay Peso en Unidades Indexadas (UI)
    """
    UYU = "UYU"
    """
    Peso Uruguayo
    """
    UYW = "UYW"
    """
    Unidad Previsional
    """
    UZS = "UZS"
    """
    Uzbekistan Sum
    """
    VAL = "VAL"
    """
    Vatican Lira.
    """
    VED = "VED"
    """
    Bolívar Soberano
    """
    VES = "VES"
    """
    Bolívar Soberano
    """
    VND = "VND"
    """
    Dong
    """
    VUV = "VUV"
    """
    Vatu
    """
    WST = "WST"
    """
    Tala
    """
    XAF = "XAF"
    """
    CFA Franc BEAC
    """
    XAG = "XAG"
    """
    Silver
    """
    XAU = "XAU"
    """
    Gold
    """
    XBA = "XBA"
    """
    Bond Markets Unit European Composite Unit (EURCO)
    """
    XBB = "XBB"
    """
    Bond Markets Unit European Monetary Unit (E.M.U.-6)
    """
    XBC = "XBC"
    """
    Bond Markets Unit European Unit of Account 9 (E.U.A.-9)
    """
    XBD = "XBD"
    """
    Bond Markets Unit European Unit of Account 17 (E.U.A.-17)
    """
    XCD = "XCD"
    """
    East Caribbean Dollar
    """
    XDR = "XDR"
    """
    SDR (Special Drawing Right)
    """
    XOF = "XOF"
    """
    CFA Franc BCEAO
    """
    XPD = "XPD"
    """
    Palladium
    """
    XPF = "XPF"
    """
    CFP Franc
    """
    XPT = "XPT"
    """
    Platinum
    """
    XSU = "XSU"
    """
    Sucre
    """
    XTS = "XTS"
    """
    Codes specifically reserved for testing purposes
    """
    XUA = "XUA"
    """
    ADB Unit of Account
    """
    XXX = "XXX"
    """
    The codes assigned for transactions where no currency is involved
    """
    YER = "YER"
    """
    Yemeni Rial
    """
    ZAR = "ZAR"
    """
    Rand
    """
    ZMW = "ZMW"
    """
    Zambian Kwacha
    """
    ZWG = "ZWG"
    """
    Zimbabwe Gold
    """
