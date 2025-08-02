package cdm.event.common.functions;

import cdm.base.math.UnitType;
import cdm.base.math.functions.Abs;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Reset;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.asset.functions.ResolveEquityInitialPrice;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.TradeLot;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(EquityCashSettlementAmount.EquityCashSettlementAmountDefault.class)
public abstract class EquityCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected EquityPerformance equityPerformance0;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected ResolveCashSettlementDate resolveCashSettlementDate;
	@Inject protected ResolveEquityInitialPrice resolveEquityInitialPrice;

	/**
	* @param tradeState 
	* @param date 
	* @return equityCashSettlementAmount 
	*/
	public Transfer evaluate(TradeState tradeState, Date date) {
		Transfer.TransferBuilder equityCashSettlementAmountBuilder = doEvaluate(tradeState, date);
		
		final Transfer equityCashSettlementAmount;
		if (equityCashSettlementAmountBuilder == null) {
			equityCashSettlementAmount = null;
		} else {
			equityCashSettlementAmount = equityCashSettlementAmountBuilder.build();
			objectValidator.validate(Transfer.class, equityCashSettlementAmount);
		}
		
		return equityCashSettlementAmount;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date);

	protected abstract MapperS<? extends Payout> payout(TradeState tradeState, Date date);

	protected abstract MapperS<? extends PerformancePayout> equityPerformancePayout(TradeState tradeState, Date date);

	protected abstract MapperS<BigDecimal> equityPerformance1(TradeState tradeState, Date date);

	protected abstract MapperS<? extends ReferenceWithMetaParty> payer(TradeState tradeState, Date date);

	protected abstract MapperS<? extends ReferenceWithMetaParty> receiver(TradeState tradeState, Date date);

	public static class EquityCashSettlementAmountDefault extends EquityCashSettlementAmount {
		@Override
		protected Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date) {
			Transfer.TransferBuilder equityCashSettlementAmount = Transfer.builder();
			return assignOutput(equityCashSettlementAmount, tradeState, date);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder equityCashSettlementAmount, TradeState tradeState, Date date) {
			equityCashSettlementAmount
				.getOrCreateQuantity()
				.setValue(abs.evaluate(equityPerformance1(tradeState, date).get()));
			
			final FieldWithMetaString fieldWithMetaString = MapperS.of(resolveEquityInitialPrice.evaluate(MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti())).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
			equityCashSettlementAmount
				.getOrCreateQuantity()
				.getOrCreateUnit()
				.setCurrencyValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			final Party ifThenElseResult0;
			if (greaterThanEquals(equityPerformance1(tradeState, date), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = payer(tradeState, date).get();
				ifThenElseResult0 = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty1 = receiver(tradeState, date).get();
				ifThenElseResult0 = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			}
			equityCashSettlementAmount
				.getOrCreatePayerReceiver()
				.setPayerPartyReferenceValue(ifThenElseResult0);
			
			final Party ifThenElseResult1;
			if (greaterThanEquals(equityPerformance1(tradeState, date), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty2 = receiver(tradeState, date).get();
				ifThenElseResult1 = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty3 = payer(tradeState, date).get();
				ifThenElseResult1 = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			}
			equityCashSettlementAmount
				.getOrCreatePayerReceiver()
				.setReceiverPartyReferenceValue(ifThenElseResult1);
			
			equityCashSettlementAmount
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(resolveCashSettlementDate.evaluate(tradeState));
			
			final Payout equityCashSettlementAmountSettlementOrigin = payout(tradeState, date).get();
			equityCashSettlementAmount
				.setSettlementOrigin(ReferenceWithMetaPayout.builder()
					.setGlobalReference(Optional.ofNullable(equityCashSettlementAmountSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(equityCashSettlementAmountSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build()
				);
			
			return Optional.ofNullable(equityCashSettlementAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Payout> payout(TradeState tradeState, Date date) {
			final MapperC<Payout> thenArg = MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout())
				.filterItemNullSafe(item -> exists(item.<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout())).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends PerformancePayout> equityPerformancePayout(TradeState tradeState, Date date) {
			return payout(tradeState, date).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout());
		}
		
		@Override
		protected MapperS<BigDecimal> equityPerformance1(TradeState tradeState, Date date) {
			return MapperS.of(equityPerformance0.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get(), MapperS.of(MapperS.of(tradeState).<Reset>mapC("getResetHistory", _tradeState -> _tradeState.getResetHistory()).get()).<Price>map("getResetValue", reset -> reset.getResetValue()).get(), date));
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> payer(TradeState tradeState, Date date) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), equityPerformancePayout(tradeState, date).<PayerReceiver>map("getPayerReceiver", performancePayout -> performancePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> receiver(TradeState tradeState, Date date) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), equityPerformancePayout(tradeState, date).<PayerReceiver>map("getPayerReceiver", performancePayout -> performancePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
	}
}
