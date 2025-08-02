package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_EquityOption_ParameterReturnVariance_SingleName.Qualify_EquityOption_ParameterReturnVariance_SingleNameDefault.class)
public abstract class Qualify_EquityOption_ParameterReturnVariance_SingleName implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ProductDeepPathUtil productDeepPathUtil;
	@Inject protected Qualify_EquitySwap_ParameterReturnVariance_SingleName qualify_EquitySwap_ParameterReturnVariance_SingleName;

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	@Override
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_product = doEvaluate(economicTerms);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	protected abstract MapperS<? extends EconomicTerms> underlierEconomicTerms(EconomicTerms economicTerms);

	public static class Qualify_EquityOption_ParameterReturnVariance_SingleNameDefault extends Qualify_EquityOption_ParameterReturnVariance_SingleName {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout())).and(areEqual(MapperS.of(qualify_EquitySwap_ParameterReturnVariance_SingleName.evaluate(underlierEconomicTerms(economicTerms).get())), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> underlierEconomicTerms(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).get());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
