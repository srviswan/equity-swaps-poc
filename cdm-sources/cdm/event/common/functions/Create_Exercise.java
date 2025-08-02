package cdm.event.common.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.ExerciseInstruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import cdm.product.template.metafields.ReferenceWithMetaOptionPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_Exercise.Create_ExerciseDefault.class)
public abstract class Create_Exercise implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_Execution create_Execution;
	@Inject protected Create_NonTransferableProduct create_NonTransferableProduct;
	@Inject protected Create_TradeState create_TradeState;
	@Inject protected Update_ProductDirection update_ProductDirection;

	/**
	* @param exerciseInstruction Instruction containing the terms of the option exercise.
	* @param originalTrade The original trade to be split, which must be of single cardinality.
	* @return exercise 
	*/
	public List<? extends TradeState> evaluate(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
		// pre-conditions
		conditionValidator.validate(() -> exists(optionPayout(exerciseInstruction, originalTrade)),
			"Requires that the original contract contains an option payout.");
		
		List<TradeState.TradeStateBuilder> exerciseBuilder = doEvaluate(exerciseInstruction, originalTrade);
		
		final List<? extends TradeState> exercise;
		if (exerciseBuilder == null) {
			exercise = null;
		} else {
			exercise = exerciseBuilder.stream().map(TradeState::build).collect(Collectors.toList());
			objectValidator.validate(TradeState.class, exercise);
		}
		
		return exercise;
	}

	protected abstract List<TradeState.TradeStateBuilder> doEvaluate(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	protected abstract MapperS<? extends OptionPayout> optionPayout(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	protected abstract MapperS<? extends Underlier> underlier(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	protected abstract MapperS<? extends NonTransferableProduct> resultProduct(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	protected abstract MapperS<? extends NonTransferableProduct> productWithDirection(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	protected abstract MapperS<? extends TradeState> execution(ExerciseInstruction exerciseInstruction, TradeState originalTrade);

	public static class Create_ExerciseDefault extends Create_Exercise {
		@Override
		protected List<TradeState.TradeStateBuilder> doEvaluate(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			List<TradeState.TradeStateBuilder> exercise = new ArrayList<>();
			return assignOutput(exercise, exerciseInstruction, originalTrade);
		}
		
		protected List<TradeState.TradeStateBuilder> assignOutput(List<TradeState.TradeStateBuilder> exercise, ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			final TradeState tradeState = create_TradeState.evaluate(MapperS.of(exerciseInstruction).<PrimitiveInstruction>map("getExerciseQuantity", _exerciseInstruction -> _exerciseInstruction.getExerciseQuantity()).get(), originalTrade);
			if (tradeState == null) {
				exercise.addAll(toBuilder(Collections.<TradeState>emptyList()));
			} else {
				exercise.addAll(toBuilder(Collections.singletonList(tradeState)));
			}
			
			exercise.addAll(toBuilder(execution(exerciseInstruction, originalTrade).getMulti()));
			
			return Optional.ofNullable(exercise)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends OptionPayout> optionPayout(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			if (exists(MapperS.of(exerciseInstruction).<ReferenceWithMetaOptionPayout>map("getExerciseOption", _exerciseInstruction -> _exerciseInstruction.getExerciseOption())).getOrDefault(false)) {
				return MapperS.of(exerciseInstruction).<ReferenceWithMetaOptionPayout>map("getExerciseOption", _exerciseInstruction -> _exerciseInstruction.getExerciseOption()).<OptionPayout>map("Type coercion", referenceWithMetaOptionPayout -> referenceWithMetaOptionPayout == null ? null : referenceWithMetaOptionPayout.getValue());
			}
			return MapperS.of(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get());
		}
		
		@Override
		protected MapperS<? extends Underlier> underlier(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			return optionPayout(exerciseInstruction, originalTrade).<Underlier>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier());
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> resultProduct(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			if (exists(underlier(exerciseInstruction, originalTrade).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct())).getOrDefault(false)) {
				return underlier(exerciseInstruction, originalTrade).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct());
			}
			return MapperS.of(create_NonTransferableProduct.evaluate(underlier(exerciseInstruction, originalTrade).get(), optionPayout(exerciseInstruction, originalTrade).<PayerReceiver>map("getPayerReceiver", _optionPayout -> _optionPayout.getPayerReceiver()).get()));
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> productWithDirection(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			if (areEqual(optionPayout(exerciseInstruction, originalTrade).<OptionTypeEnum>map("getOptionType", _optionPayout -> _optionPayout.getOptionType()), MapperS.of(OptionTypeEnum.PUT), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(update_ProductDirection.evaluate(resultProduct(exerciseInstruction, originalTrade).get(), optionPayout(exerciseInstruction, originalTrade).<PayerReceiver>map("getPayerReceiver", _optionPayout -> _optionPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getPayer", payerReceiver -> payerReceiver.getPayer()).get(), optionPayout(exerciseInstruction, originalTrade).<PayerReceiver>map("getPayerReceiver", _optionPayout -> _optionPayout.getPayerReceiver()).<CounterpartyRoleEnum>map("getReceiver", payerReceiver -> payerReceiver.getReceiver()).get()));
			}
			return resultProduct(exerciseInstruction, originalTrade);
		}
		
		@Override
		protected MapperS<? extends TradeState> execution(ExerciseInstruction exerciseInstruction, TradeState originalTrade) {
			final FieldWithMetaDate fieldWithMetaDate = MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<FieldWithMetaDate>map("getTradeDate", trade -> trade.getTradeDate()).get();
			return MapperS.of(create_Execution.evaluate(ExecutionInstruction.builder()
				.setProduct(productWithDirection(exerciseInstruction, originalTrade).get())
				.setPriceQuantity(MapperS.of(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).getMulti())
				.setCounterparty(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Counterparty>mapC("getCounterparty", trade -> trade.getCounterparty()).getMulti())
				.setAncillaryParty(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<AncillaryParty>mapC("getAncillaryParty", trade -> trade.getAncillaryParty()).getMulti())
				.setParties(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<Party>mapC("getParty", trade -> trade.getParty()).getMulti())
				.setPartyRoles(MapperS.of(originalTrade).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<PartyRole>mapC("getPartyRole", trade -> trade.getPartyRole()).getMulti())
				.setExecutionDetails(null)
				.setTradeDateValue((fieldWithMetaDate == null ? null : fieldWithMetaDate.getValue()))
				.setTradeIdentifier(MapperS.of(exerciseInstruction).<TradeIdentifier>mapC("getReplacementTradeIdentifier", _exerciseInstruction -> _exerciseInstruction.getReplacementTradeIdentifier()).getMulti())
				.build()));
		}
	}
}
