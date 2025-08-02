package cdm.margin.schedule.functions;

import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(IsIRSwaptionStraddle.IsIRSwaptionStraddleDefault.class)
public abstract class IsIRSwaptionStraddle implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;

	/**
	* @param economicTerms 
	* @return is_Product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_Product = doEvaluate(economicTerms);
		
		return is_Product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class IsIRSwaptionStraddleDefault extends IsIRSwaptionStraddle {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_Product = null;
			return assignOutput(is_Product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_Product, EconomicTerms economicTerms) {
			is_Product = ComparisonResult.of(MapperS.of(qualify_InterestRate_Option_Swaption.evaluate(economicTerms))).and(areEqual(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionTypeEnum>map("getOptionType", optionPayout -> optionPayout.getOptionType()), MapperS.of(OptionTypeEnum.STRADDLE), CardinalityOperator.All)).get();
			
			return is_Product;
		}
	}
}
