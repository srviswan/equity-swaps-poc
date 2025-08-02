package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.functions.ExtractCounterpartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.PrimitiveInstruction.PrimitiveInstructionBuilder;
import cdm.event.common.ScheduledTransfer;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferState;
import cdm.observable.asset.Money;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.ScheduledTransferEnum;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_OnDemandInterestPaymentPrimitiveInstruction.Create_OnDemandInterestPaymentPrimitiveInstructionDefault.class)
public abstract class Create_OnDemandInterestPaymentPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractCounterpartyByRole extractCounterpartyByRole;

	/**
	* @param tradeState The original trade to be modified.
	* @param interestAmount 
	* @param settlementDate 
	* @return instruction Result is a Transfer Instruction.
	*/
	public PrimitiveInstruction evaluate(TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
		// pre-conditions
		conditionValidator.validate(() -> exists(interestRatePayout(tradeState, interestAmount, settlementDate)),
			"Only a contractual product with a single interest rate payout can have an on-demand interest payment.");
		
		conditionValidator.validate(() -> areEqual(MapperS.of(interestAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), interestRatePayout(tradeState, interestAmount, settlementDate).<ResolvablePriceQuantity>map("getPriceQuantity", _interestRatePayout -> _interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All),
			"The currency of the interest amount must match the currency of the original interest rate payout.");
		
		conditionValidator.validate(() -> exists(MapperS.of(settlementDate).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", _settlementDate -> _settlementDate.getAdjustableOrRelativeDate())),
			"The settlement date must be specified as an adjustable or relative date.");
		
		PrimitiveInstruction.PrimitiveInstructionBuilder instructionBuilder = doEvaluate(tradeState, interestAmount, settlementDate);
		
		final PrimitiveInstruction instruction;
		if (instructionBuilder == null) {
			instruction = null;
		} else {
			instruction = instructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, instruction);
		}
		
		return instruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, Money interestAmount, SettlementDate settlementDate);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Money interestAmount, SettlementDate settlementDate);

	protected abstract MapperS<? extends PartyReferencePayerReceiver> payerReceiver(TradeState tradeState, Money interestAmount, SettlementDate settlementDate);

	protected abstract MapperS<? extends Transfer> transfer(TradeState tradeState, Money interestAmount, SettlementDate settlementDate);

	public static class Create_OnDemandInterestPaymentPrimitiveInstructionDefault extends Create_OnDemandInterestPaymentPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
			PrimitiveInstruction.PrimitiveInstructionBuilder instruction = PrimitiveInstruction.builder();
			return assignOutput(instruction, tradeState, interestAmount, settlementDate);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder instruction, TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
			final TransferState transferState = TransferState.builder()
				.setTransfer(transfer(tradeState, interestAmount, settlementDate).get())
				.build();
			instruction = toBuilder(PrimitiveInstruction.builder()
				.setTransfer(TransferInstruction.builder()
					.setTransferState((transferState == null ? Collections.<TransferState>emptyList() : Collections.singletonList(transferState)))
					.build())
				.build());
			
			return Optional.ofNullable(instruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayout(TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
			return MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).get());
		}
		
		@Override
		protected MapperS<? extends PartyReferencePayerReceiver> payerReceiver(TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
			final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, interestAmount, settlementDate).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", _payerReceiver -> _payerReceiver.getPayer()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(extractCounterpartyByRole.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti(), interestRatePayout(tradeState, interestAmount, settlementDate).<PayerReceiver>map("getPayerReceiver", _interestRatePayout -> _interestRatePayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", _payerReceiver -> _payerReceiver.getReceiver()).get())).<ReferenceWithMetaParty>map("getPartyReference", counterparty -> counterparty.getPartyReference()).get();
			return MapperS.of(PartyReferencePayerReceiver.builder()
				.setPayerPartyReferenceValue((referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()))
				.setReceiverPartyReferenceValue((referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()))
				.build());
		}
		
		@Override
		protected MapperS<? extends Transfer> transfer(TradeState tradeState, Money interestAmount, SettlementDate settlementDate) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(interestAmount).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
			final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
				.setIdentifierValue((fieldWithMetaString == null ? null : fieldWithMetaString.getValue()))
				.setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE)
				.build();
			return MapperS.of(Transfer.builder()
				.setQuantity(NonNegativeQuantity.builder()
					.setValue(MapperS.of(interestAmount).<BigDecimal>map("getValue", money -> money.getValue()).get())
					.setUnit(MapperS.of(interestAmount).<UnitType>map("getUnit", money -> money.getUnit()).get())
					.build())
				.setAsset(Asset.builder()
					.setCash(Cash.builder()
						.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)))
						.build())
					.build())
				.setSettlementDate(MapperS.of(settlementDate).<AdjustableOrAdjustedOrRelativeDate>map("getAdjustableOrRelativeDate", _settlementDate -> _settlementDate.getAdjustableOrRelativeDate()).get())
				.setPayerReceiver(payerReceiver(tradeState, interestAmount, settlementDate).get())
				.setTransferExpression(TransferExpression.builder()
					.setScheduledTransfer(ScheduledTransfer.builder()
						.setTransferType(ScheduledTransferEnum.NET_INTEREST)
						.build())
					.build())
				.build());
		}
	}
}
