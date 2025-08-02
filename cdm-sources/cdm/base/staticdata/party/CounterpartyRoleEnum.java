package cdm.base.staticdata.party;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Defines the enumerated values to specify the two counterparties to the transaction.
 * @version 6.0.0
 */
@RosettaEnum("CounterpartyRoleEnum")
public enum CounterpartyRoleEnum {

	@RosettaEnumValue(value = "Party1") 
	PARTY_1("Party1", null),
	
	@RosettaEnumValue(value = "Party2") 
	PARTY_2("Party2", null)
;
	private static Map<String, CounterpartyRoleEnum> values;
	static {
        Map<String, CounterpartyRoleEnum> map = new ConcurrentHashMap<>();
		for (CounterpartyRoleEnum instance : CounterpartyRoleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	CounterpartyRoleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static CounterpartyRoleEnum fromDisplayName(String name) {
		CounterpartyRoleEnum value = values.get(name);
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
