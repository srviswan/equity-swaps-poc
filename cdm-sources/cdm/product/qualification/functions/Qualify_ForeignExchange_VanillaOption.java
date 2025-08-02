package cdm.product.qualification.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_ForeignExchange_VanillaOption.Qualify_ForeignExchange_VanillaOptionDefault.class)
public abstract class Qualify_ForeignExchange_VanillaOption implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;

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

	protected abstract MapperS<? extends OptionPayout> optionPayout(EconomicTerms economicTerms);

	public static class Qualify_ForeignExchange_VanillaOptionDefault extends Qualify_ForeignExchange_VanillaOption {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = ComparisonResult.of(MapperS.of(qualify_AssetClass_ForeignExchange.evaluate(economicTerms))).and(exists(optionPayout(economicTerms))).and(notEqual(optionPayout(economicTerms).<ExerciseTerms>map("getExerciseTerms", _optionPayout -> _optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle()), MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.Any)).and(notExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature())).or(onlyExists(optionPayout(economicTerms).<OptionFeature>map("getFeature", _optionPayout -> _optionPayout.getFeature()), Arrays.asList("fxFeature", "strategyFeature", "averagingFeature", "barrier", "knock", "passThrough"), Arrays.asList("averagingFeature")))).get();
			
			return is_product;
		}
		
		@Override
		protected MapperS<? extends OptionPayout> optionPayout(EconomicTerms economicTerms) {
			return MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
