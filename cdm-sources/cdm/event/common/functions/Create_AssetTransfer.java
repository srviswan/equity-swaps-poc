package cdm.event.common.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantity;
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
import cdm.event.common.CalculateTransferInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.product.template.AssetPayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.TradeLot;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_AssetTransfer.Create_AssetTransferDefault.class)
public abstract class Create_AssetTransfer implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetDeepPathUtil assetDeepPathUtil;
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;
	@Inject protected FilterPrice filterPrice;
	@Inject protected FilterQuantityByFinancialUnit filterQuantityByFinancialUnit;

	/**
	* @param instruction 
	* @return transfer 
	*/
	public Transfer evaluate(CalculateTransferInstruction instruction) {
		// pre-conditions
		conditionValidator.validate(() -> {
			if (exists(MapperS.of(instruction).<Quantity>map("getQuantity", calculateTransferInstruction -> calculateTransferInstruction.getQuantity())).getOrDefault(false)) {
				return areEqual(MapperS.of(instruction).<Quantity>map("getQuantity", calculateTransferInstruction -> calculateTransferInstruction.getQuantity()).<UnitType>map("getUnit", quantity -> quantity.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()), MapperS.of(FinancialUnitEnum.SHARE), CardinalityOperator.All);
			}
			return ComparisonResult.successEmptyOperand("");
		},
			"");
		
		Transfer.TransferBuilder transferBuilder = doEvaluate(instruction);
		
		final Transfer transfer;
		if (transferBuilder == null) {
			transfer = null;
		} else {
			transfer = transferBuilder.build();
			objectValidator.validate(Transfer.class, transfer);
		}
		
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(CalculateTransferInstruction instruction);

	protected abstract MapperS<? extends Payout> payout(CalculateTransferInstruction instruction);

	protected abstract MapperS<? extends AssetPayout> assetPayout(CalculateTransferInstruction instruction);

	protected abstract MapperS<? extends QuantitySchedule> tradeQuantity(CalculateTransferInstruction instruction);

	protected abstract MapperS<? extends Quantity> securityQuantity(CalculateTransferInstruction instruction);

	protected abstract MapperS<? extends PriceSchedule> securityPrice(CalculateTransferInstruction instruction);

	public static class Create_AssetTransferDefault extends Create_AssetTransfer {
		@Override
		protected Transfer.TransferBuilder doEvaluate(CalculateTransferInstruction instruction) {
			Transfer.TransferBuilder transfer = Transfer.builder();
			return assignOutput(transfer, instruction);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, CalculateTransferInstruction instruction) {
			transfer
				.setQuantity(NonNegativeQuantity.builder()
					.setValue(securityQuantity(instruction).<BigDecimal>map("getValue", quantity -> quantity.getValue()).get())
					.setUnit(securityQuantity(instruction).<UnitType>map("getUnit", quantity -> quantity.getUnit()).get())
					.build());
			
			transfer
				.getOrCreateAsset()
				.getOrCreateInstrument()
				.getOrCreateSecurity()
				.addIdentifier(assetPayout(instruction).<Asset>map("getUnderlier", _assetPayout -> _assetPayout.getUnderlier()).<AssetIdentifier>mapC("chooseIdentifier", asset -> assetDeepPathUtil.chooseIdentifier(asset)).getMulti());
			
			final Party ifThenElseResult0;
			if (exists(MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", calculateTransferInstruction -> calculateTransferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", calculateTransferInstruction -> calculateTransferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult0 = referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue();
			} else if (exists(assetPayout(instruction).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), assetPayout(instruction).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult0 = referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue();
			} else {
				ifThenElseResult0 = null;
			}
			transfer
				.getOrCreatePayerReceiver()
				.setPayerPartyReferenceValue(ifThenElseResult0);
			
			final Party ifThenElseResult1;
			if (exists(MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", calculateTransferInstruction -> calculateTransferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty2 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", calculateTransferInstruction -> calculateTransferInstruction.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult1 = referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue();
			} else if (exists(assetPayout(instruction).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty3 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), assetPayout(instruction).<PayerReceiver>map("getPayerReceiver", _assetPayout -> _assetPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
				ifThenElseResult1 = referenceWithMetaParty3 == null ? null : referenceWithMetaParty3.getValue();
			} else {
				ifThenElseResult1 = null;
			}
			transfer
				.getOrCreatePayerReceiver()
				.setReceiverPartyReferenceValue(ifThenElseResult1);
			
			transfer
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(MapperS.of(instruction).<Date>map("getDate", calculateTransferInstruction -> calculateTransferInstruction.getDate()).get());
			
			final Payout transferSettlementOrigin = payout(instruction).get();
			transfer
				.setSettlementOrigin(ReferenceWithMetaPayout.builder()
					.setGlobalReference(Optional.ofNullable(transferSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null))
					.setExternalReference(Optional.ofNullable(transferSettlementOrigin)
						.map(r -> r.getMeta())
						.map(m -> m.getExternalKey())
						.orElse(null))
					.build()
				);
			
			return Optional.ofNullable(transfer)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Payout> payout(CalculateTransferInstruction instruction) {
			final MapperC<Payout> thenArg = MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout())
				.filterItemNullSafe(item -> exists(item.<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout())).get());
			return MapperS.of(thenArg.get());
		}
		
		@Override
		protected MapperS<? extends AssetPayout> assetPayout(CalculateTransferInstruction instruction) {
			return payout(instruction).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout());
		}
		
		@Override
		protected MapperS<? extends QuantitySchedule> tradeQuantity(CalculateTransferInstruction instruction) {
			return MapperS.of(MapperC.of(filterQuantityByFinancialUnit.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<QuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).getMulti(), FinancialUnitEnum.SHARE)).get());
		}
		
		@Override
		protected MapperS<? extends Quantity> securityQuantity(CalculateTransferInstruction instruction) {
			if (exists(MapperS.of(instruction).<Quantity>map("getQuantity", calculateTransferInstruction -> calculateTransferInstruction.getQuantity())).getOrDefault(false)) {
				return MapperS.of(instruction).<Quantity>map("getQuantity", calculateTransferInstruction -> calculateTransferInstruction.getQuantity());
			}
			return MapperS.of(NonNegativeQuantity.builder()
				.setValue(tradeQuantity(instruction).<BigDecimal>map("getValue", quantitySchedule -> quantitySchedule.getValue()).get())
				.setUnit(tradeQuantity(instruction).<UnitType>map("getUnit", quantitySchedule -> quantitySchedule.getUnit()).get())
				.build());
		}
		
		@Override
		protected MapperS<? extends PriceSchedule> securityPrice(CalculateTransferInstruction instruction) {
			return MapperS.of(filterPrice.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaPriceSchedule>mapC("getPrice", priceQuantity -> priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).getMulti(), PriceTypeEnum.ASSET_PRICE, Collections.<ArithmeticOperationEnum>emptyList(), null));
		}
	}
}
