package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InterestRate_Option_DebtOption.Qualify_InterestRate_Option_DebtOptionDefault.class)
public abstract class Qualify_InterestRate_Option_DebtOption implements RosettaFunction,IQualifyFunctionExtension<EconomicTerms> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ObservableQualification observableQualification;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;

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

	protected abstract MapperC<? extends OptionPayout> optionPayout(EconomicTerms economicTerms);

	public static class Qualify_InterestRate_Option_DebtOptionDefault extends Qualify_InterestRate_Option_DebtOption {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_product = null;
			return assignOutput(is_product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
			is_product = areEqual(MapperS.of(qualify_AssetClass_InterestRate.evaluate(economicTerms)), MapperS.of(true), CardinalityOperator.All).and(exists(MapperS.of(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).get()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()))).and(areEqual(optionPayout(economicTerms).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable())
				.mapItem(item -> {
					final ReferenceWithMetaObservable referenceWithMetaObservable = item.get();
					return MapperS.of(observableQualification.evaluate((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()), InstrumentTypeEnum.DEBT, null));
				}), MapperS.of(true), CardinalityOperator.All)).get();
			
			return is_product;
		}
		
		@Override
		protected MapperC<? extends OptionPayout> optionPayout(EconomicTerms economicTerms) {
			return MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout());
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
