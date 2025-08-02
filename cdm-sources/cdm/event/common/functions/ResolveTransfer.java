package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.CalculateTransferInstruction;
import cdm.event.common.Reset;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.template.AssetPayout;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolveTransfer.ResolveTransferDefault.class)
public abstract class ResolveTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EquityCashSettlementAmount equityCashSettlementAmount;
	@Inject protected InterestCashSettlementAmount interestCashSettlementAmount;
	@Inject protected SecurityFinanceCashSettlementAmount securityFinanceCashSettlementAmount;

	/**
	* @param instruction 
	* @return transfer 
	*/
	public Transfer evaluate(CalculateTransferInstruction instruction) {
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

	protected abstract MapperS<? extends ReferenceWithMetaPayout> payout(CalculateTransferInstruction instruction);

	public static class ResolveTransferDefault extends ResolveTransfer {
		@Override
		protected Transfer.TransferBuilder doEvaluate(CalculateTransferInstruction instruction) {
			Transfer.TransferBuilder transfer = Transfer.builder();
			return assignOutput(transfer, instruction);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, CalculateTransferInstruction instruction) {
			if (exists(payout(instruction).<Payout>map("Type coercion", referenceWithMetaPayout0 -> referenceWithMetaPayout0 == null ? null : referenceWithMetaPayout0.getValue()).<AssetPayout>map("getAssetPayout", _payout -> _payout.getAssetPayout())).getOrDefault(false)) {
				transfer = toBuilder(securityFinanceCashSettlementAmount.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).get(), MapperS.of(instruction).<Date>map("getDate", calculateTransferInstruction -> calculateTransferInstruction.getDate()).get(), MapperS.of(instruction).<Quantity>map("getQuantity", calculateTransferInstruction -> calculateTransferInstruction.getQuantity()).get(), MapperS.of(instruction).<PayerReceiver>map("getPayerReceiver", calculateTransferInstruction -> calculateTransferInstruction.getPayerReceiver()).get()));
			} else if (exists(payout(instruction).<Payout>map("Type coercion", referenceWithMetaPayout1 -> referenceWithMetaPayout1 == null ? null : referenceWithMetaPayout1.getValue()).<PerformancePayout>map("getPerformancePayout", _payout -> _payout.getPerformancePayout())).getOrDefault(false)) {
				transfer = toBuilder(equityCashSettlementAmount.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).get(), MapperS.of(instruction).<Date>map("getDate", calculateTransferInstruction -> calculateTransferInstruction.getDate()).get()));
			} else if (exists(payout(instruction).<Payout>map("Type coercion", referenceWithMetaPayout2 -> referenceWithMetaPayout2 == null ? null : referenceWithMetaPayout2.getValue()).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).or(exists(payout(instruction).<Payout>map("Type coercion", referenceWithMetaPayout3 -> referenceWithMetaPayout3 == null ? null : referenceWithMetaPayout3.getValue()).<InterestRatePayout>map("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification()))).getOrDefault(false)) {
				final ReferenceWithMetaPayout referenceWithMetaPayout4 = payout(instruction).get();
				transfer = toBuilder(interestCashSettlementAmount.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", calculateTransferInstruction -> calculateTransferInstruction.getTradeState()).get(), (referenceWithMetaPayout4 == null ? null : referenceWithMetaPayout4.getValue()), MapperS.of(instruction).<Reset>mapC("getResets", calculateTransferInstruction -> calculateTransferInstruction.getResets()).getMulti(), MapperS.of(instruction).<Date>map("getDate", calculateTransferInstruction -> calculateTransferInstruction.getDate()).get()));
			} else {
				transfer = null;
			}
			
			transfer
				.getOrCreateSettlementDate()
				.setAdjustedDateValue(MapperS.of(instruction).<Date>map("getDate", calculateTransferInstruction -> calculateTransferInstruction.getDate()).get());
			
			return Optional.ofNullable(transfer)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaPayout> payout(CalculateTransferInstruction instruction) {
			return MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", calculateTransferInstruction -> calculateTransferInstruction.getPayout());
		}
	}
}
