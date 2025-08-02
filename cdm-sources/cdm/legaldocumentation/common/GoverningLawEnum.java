package cdm.legaldocumentation.common;

import cdm.legaldocumentation.common.GoverningLawEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import com.rosetta.model.lib.annotations.RosettaSynonym;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values to specify the law governing the contract or legal document.
 * @version 6.0.0
 */
@RosettaEnum("GoverningLawEnum")
public enum GoverningLawEnum {

	/**
	 * The Governing Law is determined by reference to the relevant master agreement.
	 */
	@RosettaEnumValue(value = "AsSpecifiedInMasterAgreement") 
	AS_SPECIFIED_IN_MASTER_AGREEMENT("AsSpecifiedInMasterAgreement", null),
	
	/**
	 * Belgian law
	 */
	@RosettaEnumValue(value = "BE") 
	BE("BE", null),
	
	/**
	 * Alberta law
	 */
	@RosettaEnumValue(value = "CAAB") 
	CAAB("CAAB", null),
	
	/**
	 * British Columbia Law
	 */
	@RosettaEnumValue(value = "CABC") 
	CABC("CABC", null),
	
	/**
	 * Manitoba law
	 */
	@RosettaEnumValue(value = "CAMN") 
	CAMN("CAMN", null),
	
	/**
	 * Ontario law
	 */
	@RosettaEnumValue(value = "CAON") 
	CAON("CAON", null),
	
	/**
	 * Quebec law
	 */
	@RosettaEnumValue(value = "CAQC") 
	CAQC("CAQC", null),
	
	/**
	 * German law
	 */
	@RosettaEnumValue(value = "DE") 
	DE("DE", null),
	
	/**
	 * French law
	 */
	@RosettaEnumValue(value = "FR") 
	FR("FR", null),
	
	/**
	 * English law
	 */
	@RosettaSynonym(value = "ENGLISH", source = "AcadiaSoft_AM_1_0")
	@RosettaEnumValue(value = "GBEN") 
	GBEN("GBEN", null),
	
	/**
	 * The law of the island of Guernsey
	 */
	@RosettaEnumValue(value = "GBGY") 
	GBGY("GBGY", null),
	
	/**
	 * The law of the Isle of Man
	 */
	@RosettaEnumValue(value = "GBIM") 
	GBIM("GBIM", null),
	
	/**
	 * The law of the island of Jersey
	 */
	@RosettaEnumValue(value = "GBJY") 
	GBJY("GBJY", null),
	
	/**
	 * Scottish law
	 */
	@RosettaEnumValue(value = "GBSC") 
	GBSC("GBSC", null),
	
	/**
	 * Irish law
	 */
	@RosettaEnumValue(value = "IE") 
	IE("IE", null),
	
	/**
	 * Japanese law
	 */
	@RosettaSynonym(value = "JAPAN", source = "AcadiaSoft_AM_1_0")
	@RosettaEnumValue(value = "JP") 
	JP("JP", null),
	
	/**
	 * Luxembourg law
	 */
	@RosettaEnumValue(value = "LU") 
	LU("LU", null),
	
	/**
	 * As agreed in the ISDA Master Agreement
	 */
	@RosettaEnumValue(value = "RelatedMasterAgreement") 
	RELATED_MASTER_AGREEMENT("RelatedMasterAgreement", null),
	
	/**
	 * Californian law
	 */
	@RosettaEnumValue(value = "USCA") 
	USCA("USCA", null),
	
	/**
	 * Delaware law
	 */
	@RosettaEnumValue(value = "USDE") 
	USDE("USDE", null),
	
	/**
	 * Illinois law
	 */
	@RosettaEnumValue(value = "USIL") 
	USIL("USIL", null),
	
	/**
	 * New York law
	 */
	@RosettaSynonym(value = "NY", source = "AcadiaSoft_AM_1_0")
	@RosettaEnumValue(value = "USNY") 
	USNY("USNY", null)
;
	private static Map<String, GoverningLawEnum> values;
	static {
        Map<String, GoverningLawEnum> map = new ConcurrentHashMap<>();
		for (GoverningLawEnum instance : GoverningLawEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	GoverningLawEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static GoverningLawEnum fromDisplayName(String name) {
		GoverningLawEnum value = values.get(name);
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
