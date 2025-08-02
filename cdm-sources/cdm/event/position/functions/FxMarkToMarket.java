package cdm.event.position.functions;

import cdm.base.math.QuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByCurrency;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.Trade;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(FxMarkToMarket.FxMarkToMarketDefault.class)
public abstract class FxMarkToMarket implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterQuantityByCurrency filterQuantityByCurrency;
	@Inject protected InterpolateForwardRate interpolateForwardRate;

	/**
	* @param trade 
	* @return value 
	*/
	public BigDecimal evaluate(Trade trade) {
		// pre-conditions
		conditionValidator.validate(() -> exists(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout())),
			"The settlementPayout on the contract must exist.");
		
		BigDecimal value = doEvaluate(trade);
		
		return value;
	}

	protected abstract BigDecimal doEvaluate(Trade trade);

	protected abstract MapperS<? extends SettlementPayout> settlementPayout(Trade trade);

	protected abstract MapperS<? extends FieldWithMetaString> quotedCurrency(Trade trade);

	protected abstract MapperS<? extends FieldWithMetaString> baseCurrency(Trade trade);

	protected abstract MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> quantities(Trade trade);

	protected abstract MapperS<BigDecimal> quotedQuantity(Trade trade);

	protected abstract MapperS<BigDecimal> baseQuantity(Trade trade);

	protected abstract MapperS<BigDecimal> interpolatedRate(Trade trade);

	public static class FxMarkToMarketDefault extends FxMarkToMarket {
		@Override
		protected BigDecimal doEvaluate(Trade trade) {
			BigDecimal value = null;
			return assignOutput(value, trade);
		}
		
		protected BigDecimal assignOutput(BigDecimal value, Trade trade) {
			value = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(quotedQuantity(trade), interpolatedRate(trade)), baseQuantity(trade)), interpolatedRate(trade)).get();
			
			return value;
		}
		
		@Override
		protected MapperS<? extends SettlementPayout> settlementPayout(Trade trade) {
			return MapperS.of(MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> quotedCurrency(Trade trade) {
			return MapperS.of(distinct(MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> baseCurrency(Trade trade) {
			return MapperS.of(distinct(MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).get());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaNonNegativeQuantitySchedule> quantities(Trade trade) {
			return MapperS.of(MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity());
		}
		
		@Override
		protected MapperS<BigDecimal> quotedQuantity(Trade trade) {
			final FieldWithMetaString fieldWithMetaString = quotedCurrency(trade).get();
			return MapperS.of(MapperC.of(filterQuantityByCurrency.evaluate(quantities(trade).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), (fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))).get()).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> baseQuantity(Trade trade) {
			final FieldWithMetaString fieldWithMetaString = baseCurrency(trade).get();
			return MapperS.of(MapperC.of(filterQuantityByCurrency.evaluate(quantities(trade).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), (fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))).get()).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> interpolatedRate(Trade trade) {
			return MapperS.of(interpolateForwardRate.evaluate(settlementPayout(trade).get()));
		}
	}
}
