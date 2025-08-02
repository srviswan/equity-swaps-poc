package cdm.observable.event.functions;

import cdm.event.common.BillingRecordInstruction;
import cdm.event.common.CollateralPortfolio;
import cdm.event.common.CollateralPosition;
import cdm.event.common.Reset;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.event.common.metafields.ReferenceWithMetaCollateralPortfolio;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.event.Observation;
import cdm.product.collateral.Collateral;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.util.ProductDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_AssetPayoutTradeStateWithObservations.Create_AssetPayoutTradeStateWithObservationsDefault.class)
public abstract class Create_AssetPayoutTradeStateWithObservations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AssetReset create_AssetReset;
	@Inject protected ProductDeepPathUtil productDeepPathUtil;

	/**
	* @param billingInstruction 
	* @return tradeState 
	*/
	public TradeState evaluate(BillingRecordInstruction billingInstruction) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(billingInstruction);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(BillingRecordInstruction billingInstruction);

	protected abstract MapperS<? extends AssetPayout> assetPayout(BillingRecordInstruction billingInstruction);

	protected abstract MapperS<Date> date(BillingRecordInstruction billingInstruction);

	public static class Create_AssetPayoutTradeStateWithObservationsDefault extends Create_AssetPayoutTradeStateWithObservations {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(BillingRecordInstruction billingInstruction) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, billingInstruction);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, BillingRecordInstruction billingInstruction) {
			final ReferenceWithMetaTradeState referenceWithMetaTradeState = MapperS.of(billingInstruction).<ReferenceWithMetaTradeState>map("getTradeState", billingRecordInstruction -> billingRecordInstruction.getTradeState()).get();
			if (referenceWithMetaTradeState == null) {
				tradeState = null;
			} else {
				tradeState = toBuilder(referenceWithMetaTradeState.getValue());
			}
			
			final Reset reset = create_AssetReset.evaluate(assetPayout(billingInstruction).get(), MapperS.of(billingInstruction).<Observation>mapC("getObservation", billingRecordInstruction -> billingRecordInstruction.getObservation()).getMulti(), date(billingInstruction).get());
			tradeState
				.addResetHistory((reset == null ? Collections.<Reset>emptyList() : Collections.singletonList(reset)));
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends AssetPayout> assetPayout(BillingRecordInstruction billingInstruction) {
			return MapperS.of(MapperS.of(billingInstruction).<ReferenceWithMetaTradeState>map("getTradeState", billingRecordInstruction -> billingRecordInstruction.getTradeState()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Collateral>map("getCollateral", economicTerms -> economicTerms.getCollateral()).<ReferenceWithMetaCollateralPortfolio>mapC("getCollateralPortfolio", collateral -> collateral.getCollateralPortfolio()).<CollateralPortfolio>map("Type coercion", referenceWithMetaCollateralPortfolio -> referenceWithMetaCollateralPortfolio.getValue()).<CollateralPosition>mapC("getCollateralPosition", collateralPortfolio -> collateralPortfolio.getCollateralPosition()).<Product>map("getProduct", collateralPosition -> collateralPosition.getProduct()).<EconomicTerms>map("chooseEconomicTerms", product -> productDeepPathUtil.chooseEconomicTerms(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<AssetPayout>map("getAssetPayout", payout -> payout.getAssetPayout()).get());
		}
		
		@Override
		protected MapperS<Date> date(BillingRecordInstruction billingInstruction) {
			return MapperS.of(billingInstruction).<Date>map("getRecordEndDate", billingRecordInstruction -> billingRecordInstruction.getRecordEndDate());
		}
	}
}
