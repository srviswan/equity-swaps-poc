package cdm.base.staticdata.party;

import cdm.base.staticdata.party.PersonIdentifierTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import com.rosetta.model.lib.annotations.RosettaSynonym;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumeration values associated with person identifier sources.
 * @version 6.0.0
 */
@RosettaEnum("PersonIdentifierTypeEnum")
public enum PersonIdentifierTypeEnum {

	/**
	 * Alien Registration Number, number assigned by a social security agency to identify a non-resident person.
	 */
	@RosettaSynonym(value = "ARNU", source = "ISO20022")
	@RosettaEnumValue(value = "ARNU") 
	ARNU("ARNU", null),
	
	/**
	 * Passport Number, number assigned by an authority to identify the passport number of a person.
	 */
	@RosettaSynonym(value = "CCPT", source = "ISO20022")
	@RosettaEnumValue(value = "CCPT") 
	CCPT("CCPT", null),
	
	/**
	 * Customer Identification Number, number assigned by an issuer to identify a customer.
	 */
	@RosettaSynonym(value = "CUST", source = "ISO20022")
	@RosettaEnumValue(value = "CUST") 
	CUST("CUST", null),
	
	/**
	 * Drivers License Number, number assigned by an authority to identify a driver&#39;s license.
	 */
	@RosettaSynonym(value = "DRLC", source = "ISO20022")
	@RosettaEnumValue(value = "DRLC") 
	DRLC("DRLC", null),
	
	/**
	 * Employee Identification Number, number assigned by a registration authority to an employee.
	 */
	@RosettaSynonym(value = "EMPL", source = "ISO20022")
	@RosettaEnumValue(value = "EMPL") 
	EMPL("EMPL", null),
	
	/**
	 * National Identity Number, number assigned by an authority to identify the national identity number of a person..
	 */
	@RosettaSynonym(value = "NIDN", source = "ISO20022")
	@RosettaEnumValue(value = "NIDN") 
	NIDN("NIDN", null),
	
	/**
	 * Social Security Number, number assigned by an authority to identify the social security number of a person.
	 */
	@RosettaSynonym(value = "SOSE", source = "ISO20022")
	@RosettaEnumValue(value = "SOSE") 
	SOSE("SOSE", null),
	
	/**
	 * Tax Identification Number, number assigned by a tax authority to identify a person.
	 */
	@RosettaSynonym(value = "TXID", source = "ISO20022")
	@RosettaEnumValue(value = "TXID") 
	TXID("TXID", null),
	
	/**
	 * Natural Person Identifier. To identify the person who is acting as private individual, not as business entity. Used for regulatory reporting.
	 */
	@RosettaEnumValue(value = "NPID") 
	NPID("NPID", null),
	
	/**
	 * Privacy Law Identifier. It refers to the DMO Letter No. 17-16, http://www.cftc.gov/idc/groups/public/@lrlettergeneral/documents/letter/17-16.pdf
	 */
	@RosettaEnumValue(value = "PLID") 
	PLID("PLID", null)
;
	private static Map<String, PersonIdentifierTypeEnum> values;
	static {
        Map<String, PersonIdentifierTypeEnum> map = new ConcurrentHashMap<>();
		for (PersonIdentifierTypeEnum instance : PersonIdentifierTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PersonIdentifierTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PersonIdentifierTypeEnum fromDisplayName(String name) {
		PersonIdentifierTypeEnum value = values.get(name);
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
