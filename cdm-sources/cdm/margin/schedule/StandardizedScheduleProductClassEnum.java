package cdm.margin.schedule;

import cdm.margin.schedule.StandardizedScheduleProductClassEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @version 6.0.0
 */
@RosettaEnum("StandardizedScheduleProductClassEnum")
public enum StandardizedScheduleProductClassEnum {

	@RosettaEnumValue(value = "Swap") 
	SWAP("Swap", null),
	
	@RosettaEnumValue(value = "CrossCurrencySwap") 
	CROSS_CURRENCY_SWAP("CrossCurrencySwap", null),
	
	@RosettaEnumValue(value = "Swaption") 
	SWAPTION("Swaption", null),
	
	@RosettaEnumValue(value = "SwaptionStraddle") 
	SWAPTION_STRADDLE("SwaptionStraddle", null),
	
	@RosettaEnumValue(value = "SwapWithCallableBermudanRightToEnterExitSwaps") 
	SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS("SwapWithCallableBermudanRightToEnterExitSwaps", null),
	
	@RosettaEnumValue(value = "IRExoticSwapWithAnExoticCouponAgainstAFloatingLeg") 
	IR_EXOTIC_SWAP_WITH_AN_EXOTIC_COUPON_AGAINST_A_FLOATING_LEG("IRExoticSwapWithAnExoticCouponAgainstAFloatingLeg", null),
	
	@RosettaEnumValue(value = "Option") 
	OPTION("Option", null),
	
	@RosettaEnumValue(value = "ForwardRateAgreement") 
	FORWARD_RATE_AGREEMENT("ForwardRateAgreement", null),
	
	@RosettaEnumValue(value = "SingleNameCreditDefaultSwap") 
	SINGLE_NAME_CREDIT_DEFAULT_SWAP("SingleNameCreditDefaultSwap", null),
	
	@RosettaEnumValue(value = "IndexCDS") 
	INDEX_CDS("IndexCDS", null),
	
	@RosettaEnumValue(value = "IndexTranche") 
	INDEX_TRANCHE("IndexTranche", null),
	
	@RosettaEnumValue(value = "CreditNthToDefault") 
	CREDIT_NTH_TO_DEFAULT("CreditNthToDefault", null),
	
	@RosettaEnumValue(value = "CreditTotalReturnSwapOnABond") 
	CREDIT_TOTAL_RETURN_SWAP_ON_A_BOND("CreditTotalReturnSwapOnABond", null),
	
	@RosettaEnumValue(value = "DeliverableSwap") 
	DELIVERABLE_SWAP("DeliverableSwap", null),
	
	@RosettaEnumValue(value = "NonDeliverableCrossCurrencySwap") 
	NON_DELIVERABLE_CROSS_CURRENCY_SWAP("NonDeliverableCrossCurrencySwap", null),
	
	@RosettaEnumValue(value = "DeliverableForward") 
	DELIVERABLE_FORWARD("DeliverableForward", null),
	
	@RosettaEnumValue(value = "NonDeliverableForward") 
	NON_DELIVERABLE_FORWARD("NonDeliverableForward", null),
	
	@RosettaEnumValue(value = "DeliverableOption") 
	DELIVERABLE_OPTION("DeliverableOption", null),
	
	@RosettaEnumValue(value = "NonDeliverableOption") 
	NON_DELIVERABLE_OPTION("NonDeliverableOption", null),
	
	@RosettaEnumValue(value = "VarianceSwap") 
	VARIANCE_SWAP("VarianceSwap", null),
	
	@RosettaEnumValue(value = "VolatilitySwap") 
	VOLATILITY_SWAP("VolatilitySwap", null),
	
	@RosettaEnumValue(value = "CorrelationSwap") 
	CORRELATION_SWAP("CorrelationSwap", null),
	
	@RosettaEnumValue(value = "Forward") 
	FORWARD("Forward", null),
	
	@RosettaEnumValue(value = "DividendSwap") 
	DIVIDEND_SWAP("DividendSwap", null),
	
	@RosettaEnumValue(value = "DeliverableOptionF") 
	DELIVERABLE_OPTION_F("DeliverableOptionF", null),
	
	@RosettaEnumValue(value = "ContractForDifference") 
	CONTRACT_FOR_DIFFERENCE("ContractForDifference", null),
	
	@RosettaEnumValue(value = "SwapsAndPortfolioSwaps") 
	SWAPS_AND_PORTFOLIO_SWAPS("SwapsAndPortfolioSwaps", null),
	
	@RosettaEnumValue(value = "FixedFloatSwap") 
	FIXED_FLOAT_SWAP("FixedFloatSwap", null),
	
	@RosettaEnumValue(value = "BasisSwap") 
	BASIS_SWAP("BasisSwap", null)
;
	private static Map<String, StandardizedScheduleProductClassEnum> values;
	static {
        Map<String, StandardizedScheduleProductClassEnum> map = new ConcurrentHashMap<>();
		for (StandardizedScheduleProductClassEnum instance : StandardizedScheduleProductClassEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	StandardizedScheduleProductClassEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static StandardizedScheduleProductClassEnum fromDisplayName(String name) {
		StandardizedScheduleProductClassEnum value = values.get(name);
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
