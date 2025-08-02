package cdm.margin.schedule.functions;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.qualification.functions.Qualify_ForeignExchange_VanillaOption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(IsFXDeliverableOption.IsFXDeliverableOptionDefault.class)
public abstract class IsFXDeliverableOption implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_ForeignExchange_VanillaOption qualify_ForeignExchange_VanillaOption;

	/**
	* @param economicTerms 
	* @return is_Product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_Product = doEvaluate(economicTerms);
		
		return is_Product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class IsFXDeliverableOptionDefault extends IsFXDeliverableOption {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_Product = null;
			return assignOutput(is_Product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_Product, EconomicTerms economicTerms) {
			is_Product = ComparisonResult.of(MapperS.of(qualify_ForeignExchange_VanillaOption.evaluate(economicTerms))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.PHYSICAL), CardinalityOperator.All)).get();
			
			return is_Product;
		}
	}
}
