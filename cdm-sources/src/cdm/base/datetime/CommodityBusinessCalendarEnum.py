# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CommodityBusinessCalendarEnum']

class CommodityBusinessCalendarEnum(Enum):
    ADSM = "ADSM"
    """
    Abu Dhabi Securities Exchange https://www.adx.ae/
    """
    AGRUS_FMB = "AGRUS-FMB"
    """
    Argus Media Fertilizer Reports. http://www.argusmedia.com/Fertilizer
    """
    APPI = "APPI"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_CRUDE = "ARGUS-CRUDE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_EUROPEAN_GAS = "ARGUS-EUROPEAN-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_EUROPEAN_PRODUCTS = "ARGUS-EUROPEAN-PRODUCTS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_INTERNATIONAL_LPG = "ARGUS-INTERNATIONAL-LPG"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_MCCLOSKEYS_COAL_REPORT = "ARGUS-MCCLOSKEYS-COAL-REPORT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ARGUS_US_PRODUCTS = "ARGUS-US-PRODUCTS"
    """
    The Argus US Products report. http://www.argusmedia.com/Petroleum/Petroleum-Products/Argus-US-Products
    """
    ASX = "ASX"
    """
    Australian Securities Exchange http://www.asx.com.au/
    """
    AWB = "AWB"
    """
    Australian Wheat Board. www.awb.com.au
    """
    AWEX = "AWEX"
    """
    Australian Wool Exchange. http://www.awex.com.au/home.html
    """
    BALTIC_EXCHANGE = "BALTIC-EXCHANGE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE = "BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE"
    """
    The business calendar of the Bank Negara Malaysia Policy Committee.
    """
    BELPEX = "BELPEX"
    """
    The business calendar for the Belpex power exchange (www.belpex.be).
    """
    BLUENEXT = "BLUENEXT"
    """
    BlueNext Power Market.
    """
    BM_F = "BM&F"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    BURSA_MALAYSIA_SETTLEMENT = "BURSA-MALAYSIA-SETTLEMENT"
    """
    The settlement business calendar for Bursa Malaysia.
    """
    BURSA_MALAYSIA_TRADING = "BURSA-MALAYSIA-TRADING"
    """
    The trading business calendar for Bursa Malaysia.
    """
    CANADIAN_GAS_PRICE_REPORTER = "CANADIAN-GAS-PRICE-REPORTER"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CBOT_SOFT = "CBOT-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CMAI_AROMATICS_MARKET_REPORT = "CMAI-AROMATICS-MARKET-REPORT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT = "CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT"
    """
    CMAI Global Plastics and Polymers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
    """
    CMAI_METHANOL_MARKET_REPORT = "CMAI-METHANOL-MARKET-REPORT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CMAI_MONOMERS_MARKET_REPORT = "CMAI-MONOMERS-MARKET-REPORT"
    """
    CMAI Monomers Market Report. http://www.ihs.com/products/chemical/index.aspx?pu=1&rd=cmai
    """
    CME_DAIRY = "CME-DAIRY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CME_NON_DAIRY_SOFT = "CME-NON-DAIRY-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    COMEX = "COMEX"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CRU = "CRU"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    CRU_LONG = "CRU-LONG"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    DEPARTMENT_OF_ENERGY = "DEPARTMENT-OF-ENERGY"
    """
    The business calendar for statistical publications by the by the United States Department of Energy (DOE).
    """
    DEWITT_BENZENE_DERIVATIVES = "DEWITT-BENZENE-DERIVATIVES"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    DME = "DME"
    """
    Dubai Mercantile Exchange. http://www.dubaimerc.com/
    """
    DOW_JONES = "DOW-JONES"
    """
    Dow Jones US Calendar. http://www.dowjones.com/
    """
    DOW_JONES_ENERGY_SERVICE = "DOW-JONES-ENERGY-SERVICE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    DOW_JONES_POWER = "DowJonesPower"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    EEX_COAL = "EEX-COAL"
    """
    European Energy Exchange-Coal
    """
    EEX_EMISSIONS = "EEX-EMISSIONS"
    """
    European Energy Exchange-Emissions Rights
    """
    EEX_GAS = "EEX-GAS"
    """
    European Energy Exchange-Gas
    """
    EEX_POWER = "EEX-POWER"
    """
    European Energy Exchange-Power
    """
    EURONEX_MATIF = "EURONEX-MATIF"
    """
    TBD.
    """
    FERTECON = "FERTECON"
    """
    FERTECON Limited Information Services. http://fertecon.com/current_information_services.asp
    """
    FERTILIZER_WEEK = "FERTILIZER-WEEK"
    """
    Fertilizer Week. http://www.crugroup.com/market-analysis/products/fertilizerweek
    """
    GAS_DAILY = "GAS-DAILY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    GAS_DAILY_PRICE_GUIDE = "GAS-DAILY-PRICE-GUIDE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    GLOBALCOAL = "GLOBALCOAL"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    HEREN_REPORT = "HEREN-REPORT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICE_10X_DAILY = "ICE/10X-DAILY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICE_10X_MONTHLY = "ICE/10X-MONTHLY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICE_CANADA = "ICE-CANADA"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICE_ECX = "ICE-ECX"
    """
    European Climate Exchange.
    """
    ICE_GAS = "ICE-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICE_OIL = "ICE-OIL"
    """
    The business calendar oil and refined product contracts on ICE Futures Europe.
    """
    ICE_US_AGRICULTURAL = "ICE-US-AGRICULTURAL"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    ICIS_PRICING_BENZENE__EUROPE_ = "ICIS-PRICING-BENZENE-(EUROPE)"
    """
    The business calendar for publication of ICIS Benzene (Europe) data.
    """
    ICIS_PRICING_ETHYLENE__EUROPE_ = "ICIS-PRICING-ETHYLENE-(EUROPE)"
    """
    The business calendar for publication of ICIS Ethylene (Europe) data.
    """
    ICIS_PRICING_POLYPROPYLENE__EUROPE_ = "ICIS-PRICING-POLYPROPYLENE-(EUROPE)"
    """
    The business calendar for publication of ICIS Polyproylene (Europe) data.
    """
    INSIDE_FERC = "INSIDE-FERC"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    JAPAN_MOF_TSRR = "JAPAN-MOF-TSRR"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    KCBOT = "KCBOT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    KUALA_LUMPUR_BANK = "KUALA-LUMPUR-BANK"
    """
    The banking business calendar in Kuala Lumpur.
    """
    LABUAN_BANK = "LABUAN-BANK"
    """
    The business calendar for the Labuan Bank (Malaysia).
    """
    LIFFE_LONDON_SOFT = "LIFFE-LONDON-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    LME = "LME"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    LONDON_BULLION_MARKET = "LONDON-BULLION-MARKET"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    LONDON_BULLION_MARKET_GOLD_A_M_ONLY = "LONDON-BULLION-MARKET-GOLD-A.M-ONLY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    LONDON_PLATINUM_PALLADIUM_MARKET = "LONDON-PLATINUM-PALLADIUM-MARKET"
    """
    The London Platinum and Palladium Market in London on which members quote prices for the buying and selling of Platinum and Palladium.
    """
    MGEX = "MGEX"
    """
    Minneapolis Grain Exchange http://www.mgex.com/
    """
    N2EX = "N2EX"
    """
    The business calendar for the N2EX UK power exchange (https://www.n2ex.com/aboutn2ex).
    """
    NASDAQ_OMX = "NASDAQ-OMX"
    """
    NASDAQ-OMX (Formerly known as Nordpool). http://www.nasdaqomx.com/commodities
    """
    NATURAL_GAS_WEEK = "NATURAL-GAS-WEEK"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NERC = "NERC"
    """
    Per 2005 ISDA Commodity Definitions, Article XIV.
    """
    NGI = "NGI"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NGX = "NGX"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NUCLEAR_MARKET_REVIEW = "NUCLEAR-MARKET-REVIEW"
    """
    The Nuclear Market Review report as published by Trade tech. http://www.uranium.info/nuclear_market_review.php
    """
    NYMEX_ELECTRICITY = "NYMEX-ELECTRICITY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NYMEX_GAS = "NYMEX-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NYMEX_NATURAL_GAS = "NYMEX-NATURAL-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    NYMEX_OIL = "NYMEX-OIL"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    OFFICIAL_BOARD_MARKETS = "OFFICIAL-BOARD-MARKETS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    OPIS_LP_GAS = "OPIS-LP-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    OPIS_PROPANE = "OPIS-PROPANE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PAPER_PACKAGING_MONITOR = "PAPER-PACKAGING-MONITOR"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PAPER_TRADER = "PAPER-TRADER"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PERTAMINA = "PERTAMINA"
    """
    Pertamina-Indonesia. http://www.pertamina.com/
    """
    PETROCHEMWIRE = "PETROCHEMWIRE"
    """
    PetroChemWire Publication Calendar. http://www.petrochemwire.com/
    """
    PIX_PULP_BENCHMARK_INDICES = "PIX-PULP-BENCHMARK-INDICES"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_APAG_MARKETSCAN = "PLATTS-APAG-MARKETSCAN"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_BUNKERWIRE = "PLATTS-BUNKERWIRE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_CLEAN_TANKERWIRE = "PLATTS-CLEAN-TANKERWIRE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_CRUDE_OIL_MARKETWIRE = "PLATTS-CRUDE-OIL-MARKETWIRE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_DIRTY_TANKERWIRE = "PLATTS-DIRTY-TANKERWIRE"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_EUROPEAN_GAS = "PLATTS-EUROPEAN-GAS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_EUROPEAN_MARKETSCAN = "PLATTS-EUROPEAN-MARKETSCAN"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_METALS_ALERT = "PLATTS-METALS-ALERT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_OILGRAM = "PLATTS-OILGRAM"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PLATTS_TSI_IRON_ORE = "PLATTS-TSI-IRON-ORE"
    """
    The Steel Index Iron Ore Service. http://www.thesteelindex.com/en/iron-ore
    """
    PLATTS_TSI_SCRAP = "PLATTS-TSI-SCRAP"
    """
    The Steel Index Scrap Reference Prices. http://www.thesteelindex.com/en/scrapprices
    """
    PLATTS_TSI_STEEL = "PLATTS-TSI-STEEL"
    """
    The Steel Index. http://www.thesteelindex.com/en/price-specifications
    """
    PLATTS_US_MARKETSCAN = "PLATTS-US-MARKETSCAN"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PULP_AND_PAPER_INTERNATIONAL = "PULP-AND-PAPER-INTERNATIONAL"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    PULP_AND_PAPER_WEEK = "PULP-AND-PAPER-WEEK"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    RIM_PRODUCTS_INTELLIGENCE_DAILY = "RIM-PRODUCTS-INTELLIGENCE-DAILY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    SAFEX_SOFT = "SAFEX-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    SFE_SOFT = "SFE-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    SGX = "SGX"
    """
    Singapore Exchange. www.sgx.com
    """
    SICOM = "SICOM"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    SP_GSCI = "SP-GSCI"
    """
    Standard and Poor's GSCI. http://us.spindices.com/index-family/commodities/sp-gsci
    """
    STATISTICHES_BUNDESAMT = "STATISTICHES-BUNDESAMT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    TGE = "TGE"
    """
    Tokyo Grain Exchange. www.tge.or.jp
    """
    TOCOM_OIL = "TOCOM-OIL"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    TOCOM_PRECIOUS = "TOCOM-PRECIOUS"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    TOCOM_SOFT = "TOCOM-SOFT"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
    UX_WEEKLY = "UX-WEEKLY"
    """
    The Ux Consulting Company. http://www.uxc.com/products/uxw_overview.aspx
    """
    WORLD_PULP_MONTHLY = "WORLD-PULP-MONTHLY"
    """
    Per 2005 ISDA Commodity Definitions, Section 7.2 Certain Definitions Relating To Commodity Reference Prices.
    """
