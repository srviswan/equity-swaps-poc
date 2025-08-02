package cdm.margin.schedule;

import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.0.0
 */
@RosettaEnum("StandardizedScheduleAssetClassEnum")
public enum StandardizedScheduleAssetClassEnum {

	@RosettaEnumValue(value = "InterestRates") 
	INTEREST_RATES("InterestRates", null),
	
	@RosettaEnumValue(value = "Credit") 
	CREDIT("Credit", null),
	
	@RosettaEnumValue(value = "ForeignExchange") 
	FOREIGN_EXCHANGE("ForeignExchange", null),
	
	@RosettaEnumValue(value = "Equity") 
	EQUITY("Equity", null),
	
	@RosettaEnumValue(value = "Commodity") 
	COMMODITY("Commodity", null)
;
	private static Map<String, StandardizedScheduleAssetClassEnum> values;
	static {
        Map<String, StandardizedScheduleAssetClassEnum> map = new ConcurrentHashMap<>();
		for (StandardizedScheduleAssetClassEnum instance : StandardizedScheduleAssetClassEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StandardizedScheduleAssetClassEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StandardizedScheduleAssetClassEnum fromDisplayName(String name) {
		StandardizedScheduleAssetClassEnum value = values.get(name);
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
