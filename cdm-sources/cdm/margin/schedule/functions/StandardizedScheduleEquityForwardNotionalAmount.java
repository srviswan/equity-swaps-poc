package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleEquityForwardNotionalAmount.StandardizedScheduleEquityForwardNotionalAmountDefault.class)
public abstract class StandardizedScheduleEquityForwardNotionalAmount implements RosettaFunction {

	/**
	* @param settlementPayout 
	* @return amount 
	*/
	public BigDecimal evaluate(SettlementPayout settlementPayout) {
		BigDecimal amount = doEvaluate(settlementPayout);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(SettlementPayout settlementPayout);

	protected abstract MapperS<BigDecimal> forwardPrice(SettlementPayout settlementPayout);

	protected abstract MapperS<BigDecimal> notionalQuantity(SettlementPayout settlementPayout);

	public static class StandardizedScheduleEquityForwardNotionalAmountDefault extends StandardizedScheduleEquityForwardNotionalAmount {
		@Override
		protected BigDecimal doEvaluate(SettlementPayout settlementPayout) {
			BigDecimal amount = null;
			return assignOutput(amount, settlementPayout);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, SettlementPayout settlementPayout) {
			amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(forwardPrice(settlementPayout), notionalQuantity(settlementPayout)).get();
			
			return amount;
		}
		
		@Override
		protected MapperS<BigDecimal> forwardPrice(SettlementPayout settlementPayout) {
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = MapperS.of(settlementPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _settlementPayout -> _settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).get();
			return (referenceWithMetaPriceSchedule == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(referenceWithMetaPriceSchedule.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> notionalQuantity(SettlementPayout settlementPayout) {
			final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg = MapperS.of(settlementPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _settlementPayout -> _settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
			final MapperS<BigDecimal> ifThenElseResult;
			if (exists(thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
				ifThenElseResult = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule2 -> referenceWithMetaNonNegativeQuantitySchedule2 == null ? null : referenceWithMetaNonNegativeQuantitySchedule2.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
			} else {
				ifThenElseResult = thenArg.<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule3 -> referenceWithMetaNonNegativeQuantitySchedule3 == null ? null : referenceWithMetaNonNegativeQuantitySchedule3.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
			}
			return ifThenElseResult;
		}
	}
}
