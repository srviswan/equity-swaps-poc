package cdm.event.common.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.QuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.functions.FilterQuantityByFinancialUnit;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.util.AssetDeepPathUtil;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.collateral.Collateral;
import cdm.product.collateral.CollateralProvisions;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.CollateralValuationTreatment;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.TradeLot;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(SecurityFinanceCashSettlementAmount.SecurityFinanceCashSettlementAmountDefault.class)
public abstract class SecurityFinanceCashSettlementAmount implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetDeepPathUtil assetDeepPathUtil;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected FilterPrice filterPrice;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param tradeState 
	* @param date 
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @param payerReceiver 
	* @return cashSettlementAmount 
	*/
	public Transfer evaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
		// pre-conditions
		conditionValidator.validate(() -> {
			if (exists(MapperS.of(quantity)).getOrDefault(false)) {
				return areEqual(MapperS.of(quantity).<UnitType>map("getUnit", _quantity -> _quantity.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All);
			}
			return ComparisonResult.successEmptyOperand("");
		},
			"");
		
		conditionValidator.validate(() -> areEqual(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<AssetIdentifier>mapC("chooseIdentifier", asset -> assetDeepPathUtil.chooseIdentifier(asset)), assetPayout(tradeState, date, quantity, payerReceiver).<Asset>map("getUnderlier", _assetPayout -> _assetPayout.getUnderlier()).<AssetIdentifier>mapC("chooseIdentifier", asset -> assetDeepPathUtil.chooseIdentifier(asset)), CardinalityOperator.All),
			"");
		
		Transfer.TransferBuilder cashSettlementAmountBuilder = doEvaluate(tradeState, date, quantity, payerReceiver);
		
		final Transfer cashSettlementAmount;
		if (cashSettlementAmountBuilder == null) {
			cashSettlementAmount = null;
		} else {
			cashSettlementAmount = cashSettlementAmountBuilder.build();
			objectValidator.validate(Transfer.class, cashSettlementAmount);
		}
		
		return cashSettlementAmount;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<? extends Payout> payout(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<? extends AssetPayout> assetPayout(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<? extends Collateral> collateral(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<? extends QuantitySchedule> securityQuantity(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<? extends PriceSchedule> securityPrice(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	protected abstract MapperS<BigDecimal> marginRatio(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver);

	public static class SecurityFinanceCashSettlementAmountDefault extends SecurityFinanceCashSettlementAmount {
		@Override
		protected Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			Transfer.TransferBuilder cashSettlementAmount = Transfer.builder();
			return assignOutput(cashSettlementAmount, tradeState, date, quantity, payerReceiver);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder cashSettlementAmount, TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			cashSettlementAmount
				.getOrCreateQuantity()
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(securityPrice(tradeState, date, quantity, payerReceiver).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), securityQuantity(tradeState, date, quantity, payerReceiver).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue())), marginRatio(tradeState, date, quantity, payerReceiver)).get());
			
			final FieldWithMetaString fieldWithMetaString = securityPrice(tradeState, date, quantity, payerReceiver).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
			cashSettlementAmount
				.getOrCreateQuantity()
				.getOrCreateUnit()
				.setCurrencyValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()));
			
			final Party ifThenElseResult0;
			if (exists(MapperS.of(payerReceiver)).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult0 = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			} else if (exists(assetPayout(tradeState, date, quantity, payerReceiver).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), assetPayout(tradeState, date, quantity, payerReceiver).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult0 = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			} else {
				ifThenElseResult0 = null;
			}
			cashSettlementAmount
				.getOrCreatePayerReceiver()
				.setPayerPartyReferenceValue(ifThenElseResult0);
			
			final Party ifThenElseResult1;
			if (exists(MapperS.of(payerReceiver)).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty2 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), MapperS.of(payerReceiver).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult1 = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			} else if (exists(assetPayout(tradeState, date, quantity, payerReceiver).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty3 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), assetPayout(tradeState, date, quantity, payerReceiver).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult1 = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			} else {
				ifThenElseResult1 = null;
			}
			cashSettlementAmount
				.getOrCreatePayerReceiver()
				.setReceiverPartyReferenceValue(ifThenElseResult1);
			
			cashSettlementAmount
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(date);
			
			final Payout cashSettlementAmountSettlementOrigin = payout(tradeState, date, quantity, payerReceiver).get();
			cashSettlementAmount
				.setSettlementOrigin(ReferenceWithMetaPayout.builder()
					.setGlobalReference(Optional.ofNullable(cashSettlementAmountSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(cashSettlementAmountSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build()
				);
			
			return Optional.ofNullable(cashSettlementAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Payout> payout(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			final MapperC<Payout> thenArg = MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout())
				.filterItemNullSafe(item -> exists(item.<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout())).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends AssetPayout> assetPayout(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			return payout(tradeState, date, quantity, payerReceiver).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		}
		
		@Override
		protected MapperS<? extends Collateral> collateral(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Collateral>map("getCollateral", economicTerms -> economicTerms.getCollateral());
		}
		
		@Override
		protected MapperS<? extends QuantitySchedule> securityQuantity(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			if (exists(MapperS.of(quantity)).getOrDefault(false)) {
				return MapperS.of(quantity);
			}
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get());
		}
		
		@Override
		protected MapperS<? extends PriceSchedule> securityPrice(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			return MapperS.of(filterPrice.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti(), PriceTypeEnum.ASSET_PRICE, Collections.<ArithmeticOperationEnum>emptyList(), null));
		}
		
		@Override
		protected MapperS<BigDecimal> marginRatio(TradeState tradeState, Date date, Quantity quantity, PayerReceiver payerReceiver) {
			if (exists(MapperS.of(collateral(tradeState, date, quantity, payerReceiver).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getHaircutPercentage", collateralValuationTreatment -> collateralValuationTreatment.getHaircutPercentage())).getOrDefault(false)) {
				return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(BigDecimal.valueOf(1)), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(new BigDecimal("1.0")), MapperS.of(collateral(tradeState, date, quantity, payerReceiver).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getHaircutPercentage", collateralValuationTreatment -> collateralValuationTreatment.getHaircutPercentage())));
			}
			if (exists(MapperS.of(collateral(tradeState, date, quantity, payerReceiver).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getMarginPercentage", collateralValuationTreatment -> collateralValuationTreatment.getMarginPercentage())).getOrDefault(false)) {
				return MapperS.of(collateral(tradeState, date, quantity, payerReceiver).<CollateralProvisions>map("getCollateralProvisions", _collateral -> _collateral.getCollateralProvisions()).<EligibleCollateralCriteria>mapC("getEligibleCollateral", collateralProvisions -> collateralProvisions.getEligibleCollateral()).get()).<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<CollateralValuationTreatment>map("getValuationTreatment", collateralTreatment -> collateralTreatment.getValuationTreatment()).<BigDecimal>map("getMarginPercentage", collateralValuationTreatment -> collateralValuationTreatment.getMarginPercentage());
			}
			return MapperS.of(new BigDecimal("1.0"));
		}
	}
}
