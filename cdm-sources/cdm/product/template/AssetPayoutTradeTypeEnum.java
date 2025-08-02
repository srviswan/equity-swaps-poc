package cdm.product.template;

import cdm.product.template.AssetPayoutTradeTypeEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * An enumerator to differentiate the different trade types used in securities finance and modelled on an AssetPayout.
 * @version 6.0.0
 */
@RosettaEnum("AssetPayoutTradeTypeEnum")
public enum AssetPayoutTradeTypeEnum {

	/**
	 * In the case of a repurchase transaction, an immediate and equal income payment (often call a manufactured payment) is made by the buyer to the seller.
	 */
	@RosettaEnumValue(value = "Repo") 
	REPO("Repo", null),
	
	/**
	 * In the case of a buy/sell-back, there is no income payment between buyer and seller. Instead, the repurchase price to be paid on the repurchase date is reduced by the amount of the income payment on the collateral plus some extra interest to compensate the seller for the delay between the income payment date on the collateral and the repurchase date of the repo.
	 */
	@RosettaEnumValue(value = "BuySellBack", displayName = "Buy/Sell-Back") 
	BUY_SELL_BACK("BuySellBack", "Buy/Sell-Back")
;
	private static Map<String, AssetPayoutTradeTypeEnum> values;
	static {
        Map<String, AssetPayoutTradeTypeEnum> map = new ConcurrentHashMap<>();
		for (AssetPayoutTradeTypeEnum instance : AssetPayoutTradeTypeEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	AssetPayoutTradeTypeEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static AssetPayoutTradeTypeEnum fromDisplayName(String name) {
		AssetPayoutTradeTypeEnum value = values.get(name);
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
