package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.CommodityInformationPublisherEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg.
 * @version 6.0.0
 */
@RosettaEnum("CommodityInformationPublisherEnum")
public enum CommodityInformationPublisherEnum {

	@RosettaEnumValue(value = "Argus") 
	ARGUS("Argus", null),
	
	@RosettaEnumValue(value = "ArgusMcCloskeys") 
	ARGUS_MC_CLOSKEYS("ArgusMcCloskeys", null),
	
	@RosettaEnumValue(value = "ArgusAmericasCrudeReport") 
	ARGUS_AMERICAS_CRUDE_REPORT("ArgusAmericasCrudeReport", null),
	
	@RosettaEnumValue(value = "ArgusBiofuelReport") 
	ARGUS_BIOFUEL_REPORT("ArgusBiofuelReport", null),
	
	@RosettaEnumValue(value = "ArgusCrudeReport") 
	ARGUS_CRUDE_REPORT("ArgusCrudeReport", null),
	
	@RosettaEnumValue(value = "ArgusEuropeanProductsReport") 
	ARGUS_EUROPEAN_PRODUCTS_REPORT("ArgusEuropeanProductsReport", null),
	
	@RosettaEnumValue(value = "ArgusFMB") 
	ARGUS_FMB("ArgusFMB", null),
	
	@RosettaEnumValue(value = "ArgusInternationalLPGReport") 
	ARGUS_INTERNATIONAL_LPG_REPORT("ArgusInternationalLPGReport", null),
	
	@RosettaEnumValue(value = "ArgusLPG") 
	ARGUS_LPG("ArgusLPG", null),
	
	@RosettaEnumValue(value = "ArgusNatGas") 
	ARGUS_NAT_GAS("ArgusNatGas", null),
	
	@RosettaEnumValue(value = "AssocBanksSingapore") 
	ASSOC_BANKS_SINGAPORE("AssocBanksSingapore", null),
	
	@RosettaEnumValue(value = "BandD") 
	BAND_D("BandD", null),
	
	@RosettaEnumValue(value = "BalticExchange") 
	BALTIC_EXCHANGE("BalticExchange", null),
	
	@RosettaEnumValue(value = "BankOfCanada") 
	BANK_OF_CANADA("BankOfCanada", null),
	
	@RosettaEnumValue(value = "BankOfEngland") 
	BANK_OF_ENGLAND("BankOfEngland", null),
	
	@RosettaEnumValue(value = "BankOfJapan") 
	BANK_OF_JAPAN("BankOfJapan", null),
	
	@RosettaEnumValue(value = "Bloomberg") 
	BLOOMBERG("Bloomberg", null),
	
	@RosettaEnumValue(value = "BLUENEXT") 
	BLUENEXT("BLUENEXT", null),
	
	@RosettaEnumValue(value = "CAISO") 
	CAISO("CAISO", null),
	
	@RosettaEnumValue(value = "CanadianGasPriceReporter") 
	CANADIAN_GAS_PRICE_REPORTER("CanadianGasPriceReporter", null),
	
	@RosettaEnumValue(value = "CanadianGasReporter") 
	CANADIAN_GAS_REPORTER("CanadianGasReporter", null),
	
	@RosettaEnumValue(value = "ChemicalMarketsAssociation") 
	CHEMICAL_MARKETS_ASSOCIATION("ChemicalMarketsAssociation", null),
	
	@RosettaEnumValue(value = "CMAIAromaticsMarketReport") 
	CMAI_AROMATICS_MARKET_REPORT("CMAIAromaticsMarketReport", null),
	
	@RosettaEnumValue(value = "CMAIWeeklyMethanolMarketReport") 
	CMAI_WEEKLY_METHANOL_MARKET_REPORT("CMAIWeeklyMethanolMarketReport", null),
	
	@RosettaEnumValue(value = "CRUSteelLongProductMonitor") 
	CRU_STEEL_LONG_PRODUCT_MONITOR("CRUSteelLongProductMonitor", null),
	
	@RosettaEnumValue(value = "CRUSteelSheetProductsMonitor") 
	CRU_STEEL_SHEET_PRODUCTS_MONITOR("CRUSteelSheetProductsMonitor", null),
	
	@RosettaEnumValue(value = "DowJonesEnergyService") 
	DOW_JONES_ENERGY_SERVICE("DowJonesEnergyService", null),
	
	@RosettaEnumValue(value = "DowJonesEnergyServiceScreen") 
	DOW_JONES_ENERGY_SERVICE_SCREEN("DowJonesEnergyServiceScreen", null),
	
	@RosettaEnumValue(value = "DowJonesNatGas") 
	DOW_JONES_NAT_GAS("DowJonesNatGas", null),
	
	@RosettaEnumValue(value = "EEX") 
	EEX("EEX", null),
	
	@RosettaEnumValue(value = "ERCOT") 
	ERCOT("ERCOT", null),
	
	@RosettaEnumValue(value = "EuroCentralBank") 
	EURO_CENTRAL_BANK("EuroCentralBank", null),
	
	@RosettaEnumValue(value = "EURONEXMATIF") 
	EURONEXMATIF("EURONEXMATIF", null),
	
	@RosettaEnumValue(value = "FederalReserve") 
	FEDERAL_RESERVE("FederalReserve", null),
	
	@RosettaEnumValue(value = "FERTECON") 
	FERTECON("FERTECON", null),
	
	@RosettaEnumValue(value = "FertilizerWeek") 
	FERTILIZER_WEEK("FertilizerWeek", null),
	
	@RosettaEnumValue(value = "FHLBSF") 
	FHLBSF("FHLBSF", null),
	
	@RosettaEnumValue(value = "GasDaily") 
	GAS_DAILY("GasDaily", null),
	
	@RosettaEnumValue(value = "GasDailyPriceGuide") 
	GAS_DAILY_PRICE_GUIDE("GasDailyPriceGuide", null),
	
	@RosettaEnumValue(value = "GlobalCoale") 
	GLOBAL_COALE("GlobalCoale", null),
	
	@RosettaEnumValue(value = "GME") 
	GME("GME", null),
	
	@RosettaEnumValue(value = "HerenReport") 
	HEREN_REPORT("HerenReport", null),
	
	@RosettaEnumValue(value = "ICE") 
	ICE("ICE", null),
	
	@RosettaEnumValue(value = "ICE10XDailyNaturalGas") 
	ICE_10_X_DAILY_NATURAL_GAS("ICE10XDailyNaturalGas", null),
	
	@RosettaEnumValue(value = "ICE10XDailyPower") 
	ICE_10_X_DAILY_POWER("ICE10XDailyPower", null),
	
	@RosettaEnumValue(value = "ICE10XMonthly") 
	ICE_10_X_MONTHLY("ICE10XMonthly", null),
	
	@RosettaEnumValue(value = "ICEDayAheadIndex") 
	ICE_DAY_AHEAD_INDEX("ICEDayAheadIndex", null),
	
	@RosettaEnumValue(value = "ICEECX") 
	ICEECX("ICEECX", null),
	
	@RosettaEnumValue(value = "ICIS") 
	ICIS("ICIS", null),
	
	@RosettaEnumValue(value = "InsideFERC") 
	INSIDE_FERC("InsideFERC", null),
	
	@RosettaEnumValue(value = "IPE") 
	IPE("IPE", null),
	
	@RosettaEnumValue(value = "ISDA") 
	ISDA("ISDA", null),
	
	@RosettaEnumValue(value = "ISONewEngland") 
	ISO_NEW_ENGLAND("ISONewEngland", null),
	
	@RosettaEnumValue(value = "JAPANMOFTSRR") 
	JAPANMOFTSRR("JAPANMOFTSRR", null),
	
	@RosettaEnumValue(value = "LEBA") 
	LEBA("LEBA", null),
	
	@RosettaEnumValue(value = "LondonBullionMarketAssociation") 
	LONDON_BULLION_MARKET_ASSOCIATION("LondonBullionMarketAssociation", null),
	
	@RosettaEnumValue(value = "LONDONPLATINUMPALLADIUMMARKET") 
	LONDONPLATINUMPALLADIUMMARKET("LONDONPLATINUMPALLADIUMMARKET", null),
	
	@RosettaEnumValue(value = "MegawattDaily") 
	MEGAWATT_DAILY("MegawattDaily", null),
	
	@RosettaEnumValue(value = "MetalBulletin") 
	METAL_BULLETIN("MetalBulletin", null),
	
	@RosettaEnumValue(value = "MISO") 
	MISO("MISO", null),
	
	@RosettaEnumValue(value = "NaturalGasWeek") 
	NATURAL_GAS_WEEK("NaturalGasWeek", null),
	
	@RosettaEnumValue(value = "NGIBidweekSurvey") 
	NGI_BIDWEEK_SURVEY("NGIBidweekSurvey", null),
	
	@RosettaEnumValue(value = "NYISO") 
	NYISO("NYISO", null),
	
	@RosettaEnumValue(value = "OBM") 
	OBM("OBM", null),
	
	@RosettaEnumValue(value = "OMEL") 
	OMEL("OMEL", null),
	
	@RosettaEnumValue(value = "OPIS") 
	OPIS("OPIS", null),
	
	@RosettaEnumValue(value = "PaperTrader") 
	PAPER_TRADER("PaperTrader", null),
	
	@RosettaEnumValue(value = "PIX") 
	PIX("PIX", null),
	
	@RosettaEnumValue(value = "PJM") 
	PJM("PJM", null),
	
	@RosettaEnumValue(value = "PlattsAsiaPacific") 
	PLATTS_ASIA_PACIFIC("PlattsAsiaPacific", null),
	
	@RosettaEnumValue(value = "PlattsAsiaPacificArabMarketscan") 
	PLATTS_ASIA_PACIFIC_ARAB_MARKETSCAN("PlattsAsiaPacificArabMarketscan", null),
	
	@RosettaEnumValue(value = "PlattsCleanTankerwire") 
	PLATTS_CLEAN_TANKERWIRE("PlattsCleanTankerwire", null),
	
	@RosettaEnumValue(value = "PlattsCoalTrader") 
	PLATTS_COAL_TRADER("PlattsCoalTrader", null),
	
	@RosettaEnumValue(value = "PlattsCrudeOilMarketwire") 
	PLATTS_CRUDE_OIL_MARKETWIRE("PlattsCrudeOilMarketwire", null),
	
	@RosettaEnumValue(value = "PlattsDirtyTakerwire") 
	PLATTS_DIRTY_TAKERWIRE("PlattsDirtyTakerwire", null),
	
	@RosettaEnumValue(value = "PlattsENGR") 
	PLATTS_ENGR("PlattsENGR", null),
	
	@RosettaEnumValue(value = "PlattsEuropean") 
	PLATTS_EUROPEAN("PlattsEuropean", null),
	
	@RosettaEnumValue(value = "PlattsEuropeanMarketscan") 
	PLATTS_EUROPEAN_MARKETSCAN("PlattsEuropeanMarketscan", null),
	
	@RosettaEnumValue(value = "PlattsGasDaily") 
	PLATTS_GAS_DAILY("PlattsGasDaily", null),
	
	@RosettaEnumValue(value = "PlattsGasDailyPriceGuide") 
	PLATTS_GAS_DAILY_PRICE_GUIDE("PlattsGasDailyPriceGuide", null),
	
	@RosettaEnumValue(value = "PlattsInsideFERC") 
	PLATTS_INSIDE_FERC("PlattsInsideFERC", null),
	
	@RosettaEnumValue(value = "PlattsLPG") 
	PLATTS_LPG("PlattsLPG", null),
	
	@RosettaEnumValue(value = "PlattsMarketwire") 
	PLATTS_MARKETWIRE("PlattsMarketwire", null),
	
	@RosettaEnumValue(value = "PlattsMegawattDaily") 
	PLATTS_MEGAWATT_DAILY("PlattsMegawattDaily", null),
	
	@RosettaEnumValue(value = "PlattsMetalsAlert") 
	PLATTS_METALS_ALERT("PlattsMetalsAlert", null),
	
	@RosettaEnumValue(value = "PlattsOilgram") 
	PLATTS_OILGRAM("PlattsOilgram", null),
	
	@RosettaEnumValue(value = "PlattsOilgramBunkerwire") 
	PLATTS_OILGRAM_BUNKERWIRE("PlattsOilgramBunkerwire", null),
	
	@RosettaEnumValue(value = "PlattsPolymerscan") 
	PLATTS_POLYMERSCAN("PlattsPolymerscan", null),
	
	@RosettaEnumValue(value = "PlattsTSIIronOre") 
	PLATTS_TSI_IRON_ORE("PlattsTSIIronOre", null),
	
	@RosettaEnumValue(value = "TSIScrap") 
	TSI_SCRAP("TSIScrap", null),
	
	@RosettaEnumValue(value = "TSISteel") 
	TSI_STEEL("TSISteel", null),
	
	@RosettaEnumValue(value = "PlattsUS") 
	PLATTS_US("PlattsUS", null),
	
	@RosettaEnumValue(value = "PlattsUSMarketscan") 
	PLATTS_US_MARKETSCAN("PlattsUSMarketscan", null),
	
	@RosettaEnumValue(value = "PPM") 
	PPM("PPM", null),
	
	@RosettaEnumValue(value = "PPMEurope") 
	PPM_EUROPE("PPMEurope", null),
	
	@RosettaEnumValue(value = "PPW") 
	PPW("PPW", null),
	
	@RosettaEnumValue(value = "ReserveBankAustralia") 
	RESERVE_BANK_AUSTRALIA("ReserveBankAustralia", null),
	
	@RosettaEnumValue(value = "ReserveBankNewZealand") 
	RESERVE_BANK_NEW_ZEALAND("ReserveBankNewZealand", null),
	
	@RosettaEnumValue(value = "Reuters") 
	REUTERS("Reuters", null),
	
	@RosettaEnumValue(value = "ReutersScreen") 
	REUTERS_SCREEN("ReutersScreen", null),
	
	@RosettaEnumValue(value = "RIMIntelligenceProducts") 
	RIM_INTELLIGENCE_PRODUCTS("RIMIntelligenceProducts", null),
	
	@RosettaEnumValue(value = "SeaPac") 
	SEA_PAC("SeaPac", null),
	
	@RosettaEnumValue(value = "Telerate") 
	TELERATE("Telerate", null),
	
	@RosettaEnumValue(value = "TelerateScreen") 
	TELERATE_SCREEN("TelerateScreen", null),
	
	@RosettaEnumValue(value = "UXWEEKLY") 
	UXWEEKLY("UXWEEKLY", null),
	
	@RosettaEnumValue(value = "WorldCrudeReport") 
	WORLD_CRUDE_REPORT("WorldCrudeReport", null),
	
	@RosettaEnumValue(value = "WorldPulpMonthly") 
	WORLD_PULP_MONTHLY("WorldPulpMonthly", null)
;
	private static Map<String, CommodityInformationPublisherEnum> values;
	static {
        Map<String, CommodityInformationPublisherEnum> map = new ConcurrentHashMap<>();
		for (CommodityInformationPublisherEnum instance : CommodityInformationPublisherEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CommodityInformationPublisherEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CommodityInformationPublisherEnum fromDisplayName(String name) {
		CommodityInformationPublisherEnum value = values.get(name);
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
