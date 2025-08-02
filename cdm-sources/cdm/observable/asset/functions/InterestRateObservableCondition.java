package cdm.observable.asset.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(InterestRateObservableCondition.InterestRateObservableConditionDefault.class)
public abstract class InterestRateObservableCondition implements RosettaFunction {

	/**
	* @param pq 
	* @return valid 
	*/
	public Boolean evaluate(PriceQuantity pq) {
		Boolean valid = doEvaluate(pq);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(PriceQuantity pq);

	public static class InterestRateObservableConditionDefault extends InterestRateObservableCondition {
		@Override
		protected Boolean doEvaluate(PriceQuantity pq) {
			Boolean valid = null;
			return assignOutput(valid, pq);
		}
		
		protected Boolean assignOutput(Boolean valid, PriceQuantity pq) {
			if (exists(MapperS.of(pq).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable == null ? null : fieldWithMetaObservable.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex())).and(exists(MapperS.of(pq).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()))).getOrDefault(false)) {
				valid = areEqual(MapperS.of(pq).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice())
					.mapItem(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).and(exists(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).asMapper()), MapperS.of(true), CardinalityOperator.All).get();
			} else {
				valid = null;
			}
			
			return valid;
		}
	}
}
