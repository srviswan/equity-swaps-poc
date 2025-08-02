package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.DebtPrincipalEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Represents an enumeration list that specifies the general rule for repayment of principal.
 * @version 6.0.0
 */
@RosettaEnum("DebtPrincipalEnum")
public enum DebtPrincipalEnum {

	/**
	 * Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
	 */
	@RosettaEnumValue(value = "Bullet") 
	BULLET("Bullet", null),
	
	/**
	 * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
	 */
	@RosettaEnumValue(value = "Callable") 
	CALLABLE("Callable", null),
	
	/**
	 * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
	 */
	@RosettaEnumValue(value = "Puttable") 
	PUTTABLE("Puttable", null),
	
	/**
	 * Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
	 */
	@RosettaEnumValue(value = "Amortising") 
	AMORTISING("Amortising", null),
	
	/**
	 * Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
	 */
	@RosettaEnumValue(value = "InflationLinked") 
	INFLATION_LINKED("InflationLinked", null),
	
	/**
	 * Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
	 */
	@RosettaEnumValue(value = "IndexLinked") 
	INDEX_LINKED("IndexLinked", null),
	
	/**
	 * Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
	 */
	@RosettaEnumValue(value = "OtherStructured") 
	OTHER_STRUCTURED("OtherStructured", null),
	
	/**
	 * Denotes a stripped bond representing only the principal component.
	 */
	@RosettaEnumValue(value = "PrincipalOnly") 
	PRINCIPAL_ONLY("PrincipalOnly", null)
;
	private static Map<String, DebtPrincipalEnum> values;
	static {
        Map<String, DebtPrincipalEnum> map = new ConcurrentHashMap<>();
		for (DebtPrincipalEnum instance : DebtPrincipalEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	DebtPrincipalEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static DebtPrincipalEnum fromDisplayName(String name) {
		DebtPrincipalEnum value = values.get(name);
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
