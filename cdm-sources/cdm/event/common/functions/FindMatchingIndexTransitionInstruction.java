package cdm.event.common.functions;

import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Index;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import cdm.observable.asset.util.InterestRateIndexDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(FindMatchingIndexTransitionInstruction.FindMatchingIndexTransitionInstructionDefault.class)
public abstract class FindMatchingIndexTransitionInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected InterestRateIndexDeepPathUtil interestRateIndexDeepPathUtil;

	/**
	* @param instructions 
	* @param priceQuantity 
	* @return matchingInstruction 
	*/
	public PriceQuantity evaluate(List<? extends PriceQuantity> instructions, PriceQuantity priceQuantity) {
		PriceQuantity.PriceQuantityBuilder matchingInstructionBuilder = doEvaluate(instructions, priceQuantity);
		
		final PriceQuantity matchingInstruction;
		if (matchingInstructionBuilder == null) {
			matchingInstruction = null;
		} else {
			matchingInstruction = matchingInstructionBuilder.build();
			objectValidator.validate(PriceQuantity.class, matchingInstruction);
		}
		
		return matchingInstruction;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends PriceQuantity> instructions, PriceQuantity priceQuantity);

	public static class FindMatchingIndexTransitionInstructionDefault extends FindMatchingIndexTransitionInstruction {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends PriceQuantity> instructions, PriceQuantity priceQuantity) {
			if (instructions == null) {
				instructions = Collections.emptyList();
			}
			PriceQuantity.PriceQuantityBuilder matchingInstruction = PriceQuantity.builder();
			return assignOutput(matchingInstruction, instructions, priceQuantity);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder matchingInstruction, List<? extends PriceQuantity> instructions, PriceQuantity priceQuantity) {
			final MapperC<PriceQuantity> thenArg = MapperC.<PriceQuantity>of(instructions)
				.filterItemNullSafe(item -> areEqual(item.<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable0 -> fieldWithMetaObservable0 == null ? null : fieldWithMetaObservable0.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex0 -> fieldWithMetaInterestRateIndex0 == null ? null : fieldWithMetaInterestRateIndex0.getValue()).<Period>map("chooseIndexTenor", interestRateIndex -> interestRateIndexDeepPathUtil.chooseIndexTenor(interestRateIndex)).<PeriodEnum>map("getPeriod", period -> period.getPeriod()), MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable1 -> fieldWithMetaObservable1 == null ? null : fieldWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex1 -> fieldWithMetaInterestRateIndex1 == null ? null : fieldWithMetaInterestRateIndex1.getValue()).<Period>map("chooseIndexTenor", interestRateIndex -> interestRateIndexDeepPathUtil.chooseIndexTenor(interestRateIndex)).<PeriodEnum>map("getPeriod", period -> period.getPeriod()), CardinalityOperator.All).and(areEqual(item.<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable2 -> fieldWithMetaObservable2 == null ? null : fieldWithMetaObservable2.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex2 -> fieldWithMetaInterestRateIndex2 == null ? null : fieldWithMetaInterestRateIndex2.getValue()).<Period>map("chooseIndexTenor", interestRateIndex -> interestRateIndexDeepPathUtil.chooseIndexTenor(interestRateIndex)).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()), MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable3 -> fieldWithMetaObservable3 == null ? null : fieldWithMetaObservable3.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).<InterestRateIndex>map("Type coercion", fieldWithMetaInterestRateIndex3 -> fieldWithMetaInterestRateIndex3 == null ? null : fieldWithMetaInterestRateIndex3.getValue()).<Period>map("chooseIndexTenor", interestRateIndex -> interestRateIndexDeepPathUtil.chooseIndexTenor(interestRateIndex)).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()), CardinalityOperator.All)).and(areEqual(item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), CardinalityOperator.All).or(areEqual(item.<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), MapperS.of(priceQuantity).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), CardinalityOperator.All))).get());
			matchingInstruction = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(matchingInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
