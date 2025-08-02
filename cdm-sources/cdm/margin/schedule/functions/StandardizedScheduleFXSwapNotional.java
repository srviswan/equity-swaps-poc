package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleFXSwapNotional.StandardizedScheduleFXSwapNotionalDefault.class)
public abstract class StandardizedScheduleFXSwapNotional implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param farLeg 
	* @param tradeLot 
	* @return quantity 
	*/
	public NonNegativeQuantitySchedule evaluate(SettlementPayout farLeg, TradeLot tradeLot) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(farLeg, tradeLot);
		
		final NonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(SettlementPayout farLeg, TradeLot tradeLot);

	protected abstract MapperS<? extends PriceQuantity> priceQuantity(SettlementPayout farLeg, TradeLot tradeLot);

	protected abstract MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> exchangedCurrencies(SettlementPayout farLeg, TradeLot tradeLot);

	protected abstract MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> extractedExchangedCurrency(SettlementPayout farLeg, TradeLot tradeLot);

	public static class StandardizedScheduleFXSwapNotionalDefault extends StandardizedScheduleFXSwapNotional {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(SettlementPayout farLeg, TradeLot tradeLot) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity = NonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, farLeg, tradeLot);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity, SettlementPayout farLeg, TradeLot tradeLot) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = extractedExchangedCurrency(farLeg, tradeLot).get();
			if (fieldWithMetaNonNegativeQuantitySchedule == null) {
				quantity = null;
			} else {
				quantity = toBuilder(fieldWithMetaNonNegativeQuantitySchedule.getValue());
			}
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> priceQuantity(SettlementPayout farLeg, TradeLot tradeLot) {
			final MapperC<PriceQuantity> thenArg = MapperS.of(tradeLot).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity())
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()), MapperS.of(farLeg).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule.getValue()), CardinalityOperator.All).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> exchangedCurrencies(SettlementPayout farLeg, TradeLot tradeLot) {
			return priceQuantity(farLeg, tradeLot).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaNonNegativeQuantitySchedule> extractedExchangedCurrency(SettlementPayout farLeg, TradeLot tradeLot) {
			if (areEqual(exchangedCurrencies(farLeg, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("USD"), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = exchangedCurrencies(farLeg, tradeLot)
					.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("USD"), CardinalityOperator.All).get());
				return MapperS.of(thenArg0.get());
			}
			if (areEqual(exchangedCurrencies(farLeg, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("EUR"), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = exchangedCurrencies(farLeg, tradeLot)
					.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("EUR"), CardinalityOperator.All).get());
				return MapperS.of(thenArg1.get());
			}
			if (areEqual(exchangedCurrencies(farLeg, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("JPY"), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> thenArg2 = exchangedCurrencies(farLeg, tradeLot)
					.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("JPY"), CardinalityOperator.All).get());
				return MapperS.of(thenArg2.get());
			}
			if (areEqual(exchangedCurrencies(farLeg, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("GBP"), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> thenArg3 = exchangedCurrencies(farLeg, tradeLot)
					.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("GBP"), CardinalityOperator.All).get());
				return MapperS.of(thenArg3.get());
			}
			if (areEqual(exchangedCurrencies(farLeg, tradeLot).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of("CHF"), CardinalityOperator.Any).getOrDefault(false)) {
				final MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> thenArg4 = exchangedCurrencies(farLeg, tradeLot)
					.filterItemNullSafe(item -> areEqual(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("CHF"), CardinalityOperator.All).get());
				return MapperS.of(thenArg4.get());
			}
			return exchangedCurrencies(farLeg, tradeLot)
				.sort(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))
				.first();
		}
	}
}
