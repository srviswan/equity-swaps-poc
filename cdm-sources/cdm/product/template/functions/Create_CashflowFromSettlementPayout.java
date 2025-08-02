package cdm.product.template.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.Cashflow.CashflowBuilder;
import cdm.product.common.settlement.CashflowType;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ScheduledTransferEnum;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_CashflowFromSettlementPayout.Create_CashflowFromSettlementPayoutDefault.class)
public abstract class Create_CashflowFromSettlementPayout implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payout The settlement payout from which the cashflows are generated.
	* @return cashflows The two generated cashflows (asset leg and price leg) going in opposite directions.
	*/
	public List<? extends Cashflow> evaluate(SettlementPayout payout) {
		// pre-conditions
		conditionValidator.validate(() -> exists(MapperS.of(payout).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset())),
			"Restricts the function's applicability to a single asset for the underlier.");
		
		conditionValidator.validate(() -> exists(MapperS.of(payout).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate())),
			"Restricts the function's applicability to the adjustable or relative date for the settlement date.");
		
		conditionValidator.validate(() -> {
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).get();
			return exists(MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).and(exists((referenceWithMetaPriceSchedule == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(referenceWithMetaPriceSchedule.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())));
		},
			"Restricts the function's applicability to a single quantity and price.");
		
		List<Cashflow.CashflowBuilder> cashflowsBuilder = doEvaluate(payout);
		
		final List<? extends Cashflow> cashflows;
		if (cashflowsBuilder == null) {
			cashflows = null;
		} else {
			cashflows = cashflowsBuilder.stream().map(Cashflow::build).collect(Collectors.toList());
			objectValidator.validate(Cashflow.class, cashflows);
		}
		
		return cashflows;
	}

	protected abstract List<Cashflow.CashflowBuilder> doEvaluate(SettlementPayout payout);

	protected abstract MapperS<? extends Cashflow> assetLeg(SettlementPayout payout);

	protected abstract MapperS<BigDecimal> priceLegAmount(SettlementPayout payout);

	protected abstract MapperS<? extends FieldWithMetaString> priceLegCurrency(SettlementPayout payout);

	protected abstract MapperS<? extends PayerReceiver> priceLegPayerReceiver(SettlementPayout payout);

	protected abstract MapperS<? extends Cashflow> priceLeg(SettlementPayout payout);

	public static class Create_CashflowFromSettlementPayoutDefault extends Create_CashflowFromSettlementPayout {
		@Override
		protected List<Cashflow.CashflowBuilder> doEvaluate(SettlementPayout payout) {
			List<Cashflow.CashflowBuilder> cashflows = new ArrayList<>();
			return assignOutput(cashflows, payout);
		}
		
		protected List<Cashflow.CashflowBuilder> assignOutput(List<Cashflow.CashflowBuilder> cashflows, SettlementPayout payout) {
			cashflows = toBuilder(MapperC.<Cashflow>of(assetLeg(payout), priceLeg(payout)).getMulti());
			
			return Optional.ofNullable(cashflows)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Cashflow> assetLeg(SettlementPayout payout) {
			return MapperS.of(Cashflow.builder()
				.setQuantity(NonNegativeQuantity.builder()
					.setValue(MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get())
					.setUnit(MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.build())
				.setAsset(MapperS.of(payout).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).get())
				.setSettlementDate(MapperS.of(payout).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()).get())
				.setPayerReceiver(MapperS.of(payout).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).get())
				.setCashflowType(CashflowType.builder()
					.setCashflowType(ScheduledTransferEnum.PRINCIPAL_PAYMENT)
					.build())
				.build());
		}
		
		@Override
		protected MapperS<BigDecimal> priceLegAmount(SettlementPayout payout) {
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).get();
			return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), (referenceWithMetaPriceSchedule == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(referenceWithMetaPriceSchedule.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> priceLegCurrency(SettlementPayout payout) {
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = MapperS.of(payout).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaPriceSchedule>mapC("getPriceSchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getPriceSchedule()).get();
			return (referenceWithMetaPriceSchedule == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(referenceWithMetaPriceSchedule.getValue())).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency());
		}
		
		@Override
		protected MapperS<? extends PayerReceiver> priceLegPayerReceiver(SettlementPayout payout) {
			return MapperS.of(PayerReceiver.builder()
				.setPayer(MapperS.of(payout).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())
				.setReceiver(MapperS.of(payout).<PayerReceiver>map("getPayerReceiver", settlementPayout -> settlementPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())
				.build());
		}
		
		@Override
		protected MapperS<? extends Cashflow> priceLeg(SettlementPayout payout) {
			final FieldWithMetaString fieldWithMetaString0 = priceLegCurrency(payout).get();
			final FieldWithMetaString fieldWithMetaString1 = priceLegCurrency(payout).get();
			final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
				.setIdentifierValue((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()))
				.setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE)
				.build();
			return MapperS.of(Cashflow.builder()
				.setQuantity(NonNegativeQuantity.builder()
					.setValue(priceLegAmount(payout).get())
					.setUnit(UnitType.builder()
						.setCurrencyValue((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()))
						.build())
					.build())
				.setAsset(Asset.builder()
					.setCash(Cash.builder()
						.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
						.build())
					.build())
				.setSettlementDate(MapperS.of(payout).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", settlementTerms -> settlementTerms.getSettlementDate()).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", settlementDate -> settlementDate.getAdjustableOrRelativeDate()).get())
				.setPayerReceiver(priceLegPayerReceiver(payout).get())
				.setCashflowType(CashflowType.builder()
					.setCashflowType(ScheduledTransferEnum.PRINCIPAL_PAYMENT)
					.build())
				.build());
		}
	}
}
