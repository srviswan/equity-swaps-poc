package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQDefault.class)
public abstract class StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @return notionalCurrency 
	*/
	public String evaluate(ResolvablePriceQuantity priceQuantity) {
		String notionalCurrency = doEvaluate(priceQuantity);
		
		return notionalCurrency;
	}

	protected abstract String doEvaluate(ResolvablePriceQuantity priceQuantity);

	public static class StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQDefault extends StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ {
		@Override
		protected String doEvaluate(ResolvablePriceQuantity priceQuantity) {
			String notionalCurrency = null;
			return assignOutput(notionalCurrency, priceQuantity);
		}
		
		protected String assignOutput(String notionalCurrency, ResolvablePriceQuantity priceQuantity) {
			if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).and(exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()))).getOrDefault(false)) {
				if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
					final FieldWithMetaString fieldWithMetaString0 = MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<UnitType>map("getUnit", measure -> measure.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString0 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString0.getValue();
					}
				} else {
					final FieldWithMetaString fieldWithMetaString1 = MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
					if (fieldWithMetaString1 == null) {
						notionalCurrency = null;
					} else {
						notionalCurrency = fieldWithMetaString1.getValue();
					}
				}
			} else {
				notionalCurrency = null;
			}
			
			return notionalCurrency;
		}
	}
}
