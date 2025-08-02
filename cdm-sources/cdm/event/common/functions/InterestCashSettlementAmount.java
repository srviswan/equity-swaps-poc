package cdm.event.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
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
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.functions.FixedAmount;
import cdm.product.asset.functions.FloatingAmount;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(InterestCashSettlementAmount.InterestCashSettlementAmountDefault.class)
public abstract class InterestCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected FixedAmount fixedAmount;
	@Inject protected FloatingAmount floatingAmount;

	/**
	* @param tradeState 
	* @param payout 
	* @param resets 
	* @param date 
	* @return interestCashSettlementAmount 
	*/
	public Transfer evaluate(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
		// pre-conditions
		conditionValidator.validate(() -> exists(MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())),
			"Payout must be an InterestRatePayout.");
		
		Transfer.TransferBuilder interestCashSettlementAmountBuilder = doEvaluate(tradeState, payout, resets, date);
		
		final Transfer interestCashSettlementAmount;
		if (interestCashSettlementAmountBuilder == null) {
			interestCashSettlementAmount = null;
		} else {
			interestCashSettlementAmount = interestCashSettlementAmountBuilder.build();
			objectValidator.validate(Transfer.class, interestCashSettlementAmount);
		}
		
		return interestCashSettlementAmount;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date);

	protected abstract MapperS<BigDecimal> performance(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date);

	protected abstract MapperS<? extends ReferenceWithMetaParty> payer(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date);

	protected abstract MapperS<? extends ReferenceWithMetaParty> receiver(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date);

	public static class InterestCashSettlementAmountDefault extends InterestCashSettlementAmount {
		@Override
		protected Transfer.TransferBuilder doEvaluate(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			if (resets == null) {
				resets = Collections.emptyList();
			}
			Transfer.TransferBuilder interestCashSettlementAmount = Transfer.builder();
			return assignOutput(interestCashSettlementAmount, tradeState, payout, resets, date);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder interestCashSettlementAmount, TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			interestCashSettlementAmount
				.getOrCreateQuantity()
				.setValue(performance(tradeState, payout, resets, date).get());
			
			final FieldWithMetaString fieldWithMetaString = interestRatePayout(tradeState, payout, resets, date).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
			interestCashSettlementAmount
				.getOrCreateQuantity()
				.getOrCreateUnit()
				.setCurrencyValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			final Party ifThenElseResult0;
			if (greaterThanEquals(performance(tradeState, payout, resets, date), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = payer(tradeState, payout, resets, date).get();
				ifThenElseResult0 = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty1 = receiver(tradeState, payout, resets, date).get();
				ifThenElseResult0 = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			}
			interestCashSettlementAmount
				.getOrCreatePayerReceiver()
				.setPayerPartyReferenceValue(ifThenElseResult0);
			
			final Party ifThenElseResult1;
			if (greaterThanEquals(performance(tradeState, payout, resets, date), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty2 = receiver(tradeState, payout, resets, date).get();
				ifThenElseResult1 = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty3 = payer(tradeState, payout, resets, date).get();
				ifThenElseResult1 = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			}
			interestCashSettlementAmount
				.getOrCreatePayerReceiver()
				.setReceiverPartyReferenceValue(ifThenElseResult1);
			
			interestCashSettlementAmount
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(date);
			
			interestCashSettlementAmount
				.setSettlementOrigin(ReferenceWithMetaPayout.builder()
					.setGlobalReference(Optional.ofNullable(payout)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(payout)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build()
				);
			
			return Optional.ofNullable(interestCashSettlementAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			return MapperS.of(payout).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout());
		}
		
		@Override
		protected MapperS<BigDecimal> performance(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			if (exists(interestRatePayout(tradeState, payout, resets, date).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification())).getOrDefault(false)) {
				return MapperS.of(fixedAmount.evaluate(interestRatePayout(tradeState, payout, resets, date).get(), interestRatePayout(tradeState, payout, resets, date).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get(), date, null));
			}
			if (exists(interestRatePayout(tradeState, payout, resets, date).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				return MapperS.of(floatingAmount.evaluate(interestRatePayout(tradeState, payout, resets, date).get(), MapperS.of(MapperC.of(resets).get()).<Price>map("getResetValue", reset -> reset.getResetValue()).<BigDecimal>map("getValue", price -> price.getValue()).get(), interestRatePayout(tradeState, payout, resets, date).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get(), date, null));
			}
			return MapperS.<BigDecimal>ofNull();
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> payer(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, payout, resets, date).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> receiver(TradeState tradeState, Payout payout, List<? extends Reset> resets, Date date) {
			return MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, payout, resets, date).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference());
		}
	}
}
