package cdm.base.math;

import cdm.base.math.CapacityUnitEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
 * @version 6.0.0
 */
@RosettaEnum("CapacityUnitEnum")
public enum CapacityUnitEnum {

	/**
	 * Denotes Allowances as standard unit.
	 */
	@RosettaEnumValue(value = "ALW") 
	ALW("ALW", null),
	
	/**
	 * Denotes a Barrel as a standard unit.
	 */
	@RosettaEnumValue(value = "BBL") 
	BBL("BBL", null),
	
	/**
	 * Denotes Billion Cubic Feet as a standard unit.
	 */
	@RosettaEnumValue(value = "BCF") 
	BCF("BCF", null),
	
	/**
	 * Denotes Board Feet as a standard unit.
	 */
	@RosettaEnumValue(value = "BDFT") 
	BDFT("BDFT", null),
	
	/**
	 * Denotes Cubic Meters as a standard unit.
	 */
	@RosettaEnumValue(value = "CBM") 
	CBM("CBM", null),
	
	/**
	 * Denotes Certified Emissions Reduction as a standard unit.
	 */
	@RosettaEnumValue(value = "CER") 
	CER("CER", null),
	
	/**
	 * Denotes Climate Reserve Tonnes as a standard unit.
	 */
	@RosettaEnumValue(value = "CRT") 
	CRT("CRT", null),
	
	/**
	 * Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
	 */
	@RosettaEnumValue(value = "DAG") 
	DAG("DAG", null),
	
	/**
	 * Denotes a single day as a standard unit used in time charter trades.
	 */
	@RosettaEnumValue(value = "DAY") 
	DAY("DAY", null),
	
	/**
	 * Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
	 */
	@RosettaEnumValue(value = "DMTU") 
	DMTU("DMTU", null),
	
	/**
	 * Denotes Environmental Credit as a standard unit.
	 */
	@RosettaEnumValue(value = "ENVCRD") 
	ENVCRD("ENVCRD", null),
	
	/**
	 * Denotes Environmental Offset as a standard unit.
	 */
	@RosettaEnumValue(value = "ENVOFST") 
	ENVOFST("ENVOFST", null),
	
	/**
	 * Denotes a 40 ft. Equivalent Unit container as a standard unit.
	 */
	@RosettaEnumValue(value = "FEU") 
	FEU("FEU", null),
	
	/**
	 * Denotes a Gram as a standard unit.
	 */
	@RosettaEnumValue(value = "G") 
	G("G", null),
	
	/**
	 * Denotes a GB Bushel as a standard unit.
	 */
	@RosettaEnumValue(value = "GBBSH") 
	GBBSH("GBBSH", null),
	
	/**
	 * Denotes a GB British Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "GBBTU") 
	GBBTU("GBBTU", null),
	
	/**
	 * Denotes a GB Hundredweight unit as standard unit.
	 */
	@RosettaEnumValue(value = "GBCWT") 
	GBCWT("GBCWT", null),
	
	/**
	 * Denotes a GB Gallon unit as standard unit.
	 */
	@RosettaEnumValue(value = "GBGAL") 
	GBGAL("GBGAL", null),
	
	/**
	 * Denotes a Thousand GB British Thermal Units as a standard unit.
	 */
	@RosettaEnumValue(value = "GBMBTU") 
	GBMBTU("GBMBTU", null),
	
	/**
	 * Denotes a Million GB British Thermal Units as a standard unit.
	 */
	@RosettaEnumValue(value = "GBMMBTU") 
	GBMMBTU("GBMMBTU", null),
	
	/**
	 * Denotes a GB Ton as a standard unit.
	 */
	@RosettaEnumValue(value = "GBT") 
	GBT("GBT", null),
	
	/**
	 * Denotes a GB Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "GBTHM") 
	GBTHM("GBTHM", null),
	
	/**
	 * Denotes a Gigajoule as a standard unit.
	 */
	@RosettaEnumValue(value = "GJ") 
	GJ("GJ", null),
	
	/**
	 * Denotes a Gigawatt as a standard unit.
	 */
	@RosettaEnumValue(value = "GW") 
	GW("GW", null),
	
	/**
	 * Denotes a Gigawatt-hour as a standard unit.
	 */
	@RosettaEnumValue(value = "GWH") 
	GWH("GWH", null),
	
	/**
	 * Denotes a Hectolitre as a standard unit.
	 */
	@RosettaEnumValue(value = "HL") 
	HL("HL", null),
	
	/**
	 * Denotes a 100-troy ounces Gold Bar as a standard unit.
	 */
	@RosettaEnumValue(value = "HOGB") 
	HOGB("HOGB", null),
	
	/**
	 * Denotes an ISO British Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "ISOBTU") 
	ISOBTU("ISOBTU", null),
	
	/**
	 * Denotes a Thousand ISO British Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "ISOMBTU") 
	ISOMBTU("ISOMBTU", null),
	
	/**
	 * Denotes a Million ISO British Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "ISOMMBTU") 
	ISOMMBTU("ISOMMBTU", null),
	
	/**
	 * Denotes an ISO Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "ISOTHM") 
	ISOTHM("ISOTHM", null),
	
	/**
	 * Denotes a Joule as a standard unit.
	 */
	@RosettaEnumValue(value = "J") 
	J("J", null),
	
	/**
	 * Denotes a Kilogram as a standard unit.
	 */
	@RosettaEnumValue(value = "KG") 
	KG("KG", null),
	
	/**
	 * Denotes a Kilolitre as a standard unit.
	 */
	@RosettaEnumValue(value = "KL") 
	KL("KL", null),
	
	/**
	 * Denotes a Kilowatt as a standard unit.
	 */
	@RosettaEnumValue(value = "KW") 
	KW("KW", null),
	
	/**
	 * Denotes a Kilowatt-day as a standard unit.
	 */
	@RosettaEnumValue(value = "KWD") 
	KWD("KWD", null),
	
	/**
	 * Denotes a Kilowatt-hour as a standard unit.
	 */
	@RosettaEnumValue(value = "KWH") 
	KWH("KWH", null),
	
	/**
	 * Denotes a Kilowatt-month as a standard unit.
	 */
	@RosettaEnumValue(value = "KWM") 
	KWM("KWM", null),
	
	/**
	 * Denotes a Kilowatt-minute as a standard unit.
	 */
	@RosettaEnumValue(value = "KWMIN") 
	KWMIN("KWMIN", null),
	
	/**
	 * Denotes a Kilowatt-year as a standard unit.
	 */
	@RosettaEnumValue(value = "KWY") 
	KWY("KWY", null),
	
	/**
	 * Denotes a Litre as a standard unit.
	 */
	@RosettaEnumValue(value = "L") 
	L("L", null),
	
	/**
	 * Denotes a Pound as a standard unit.
	 */
	@RosettaEnumValue(value = "LB") 
	LB("LB", null),
	
	/**
	 * Denotes a Thousand Barrels as a standard unit.
	 */
	@RosettaEnumValue(value = "MB") 
	MB("MB", null),
	
	/**
	 * Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
	 */
	@RosettaEnumValue(value = "MBF") 
	MBF("MBF", null),
	
	/**
	 * Denotes a Megajoule as a standard unit.
	 */
	@RosettaEnumValue(value = "MJ") 
	MJ("MJ", null),
	
	/**
	 * Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
	 */
	@RosettaEnumValue(value = "MMBF") 
	MMBF("MMBF", null),
	
	/**
	 * Denotes a Million Barrels as a standard unit.
	 */
	@RosettaEnumValue(value = "MMBBL") 
	MMBBL("MMBBL", null),
	
	/**
	 * Denotes a Thousand square feet as a standard unit.
	 */
	@RosettaEnumValue(value = "MSF") 
	MSF("MSF", null),
	
	/**
	 * Denotes a Metric Ton as a standard unit.
	 */
	@RosettaEnumValue(value = "MT") 
	MT("MT", null),
	
	/**
	 * Denotes a Megawatt as a standard unit.
	 */
	@RosettaEnumValue(value = "MW") 
	MW("MW", null),
	
	/**
	 * Denotes a Megawatt-day as a standard unit.
	 */
	@RosettaEnumValue(value = "MWD") 
	MWD("MWD", null),
	
	/**
	 * Denotes a Megawatt-hour as a standard unit.
	 */
	@RosettaEnumValue(value = "MWH") 
	MWH("MWH", null),
	
	/**
	 * Denotes a Megawatt-month as a standard unit.
	 */
	@RosettaEnumValue(value = "MWM") 
	MWM("MWM", null),
	
	/**
	 * Denotes a Megawatt-minute as a standard unit.
	 */
	@RosettaEnumValue(value = "MWMIN") 
	MWMIN("MWMIN", null),
	
	/**
	 * Denotes a Megawatt-year as a standard unit.
	 */
	@RosettaEnumValue(value = "MWY") 
	MWY("MWY", null),
	
	/**
	 * Denotes a Troy Ounce as a standard unit.
	 */
	@RosettaEnumValue(value = "OZT") 
	OZT("OZT", null),
	
	/**
	 * Denotes a Standard Gold Bar as a standard unit.
	 */
	@RosettaEnumValue(value = "SGB") 
	SGB("SGB", null),
	
	/**
	 * Denotes a 20 ft. Equivalent Unit container as a standard unit.
	 */
	@RosettaEnumValue(value = "TEU") 
	TEU("TEU", null),
	
	/**
	 * Denotes a US Bushel as a standard unit.
	 */
	@RosettaEnumValue(value = "USBSH") 
	USBSH("USBSH", null),
	
	/**
	 * Denotes a US British Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "USBTU") 
	USBTU("USBTU", null),
	
	/**
	 * Denotes US Hundredweight unit as a standard unit.
	 */
	@RosettaEnumValue(value = "USCWT") 
	USCWT("USCWT", null),
	
	/**
	 * Denotes a US Gallon unit as a standard unit.
	 */
	@RosettaEnumValue(value = "USGAL") 
	USGAL("USGAL", null),
	
	/**
	 * Denotes a Thousand US British Thermal Units as a standard unit.
	 */
	@RosettaEnumValue(value = "USMBTU") 
	USMBTU("USMBTU", null),
	
	/**
	 * Denotes a Million US British Thermal Units as a standard unit.
	 */
	@RosettaEnumValue(value = "USMMBTU") 
	USMMBTU("USMMBTU", null),
	
	/**
	 * Denotes a US Ton as a standard unit.
	 */
	@RosettaEnumValue(value = "UST") 
	UST("UST", null),
	
	/**
	 * Denotes a US Thermal Unit as a standard unit.
	 */
	@RosettaEnumValue(value = "USTHM") 
	USTHM("USTHM", null)
;
	private static Map<String, CapacityUnitEnum> values;
	static {
        Map<String, CapacityUnitEnum> map = new ConcurrentHashMap<>();
		for (CapacityUnitEnum instance : CapacityUnitEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CapacityUnitEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CapacityUnitEnum fromDisplayName(String name) {
		CapacityUnitEnum value = values.get(name);
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
