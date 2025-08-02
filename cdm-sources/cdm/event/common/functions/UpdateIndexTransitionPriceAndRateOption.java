package cdm.event.common.functions;

import cdm.observable.asset.Index;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(UpdateIndexTransitionPriceAndRateOption.UpdateIndexTransitionPriceAndRateOptionDefault.class)
public abstract class UpdateIndexTransitionPriceAndRateOption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity 
	* @param instruction 
	* @return updatedPriceQuantity 
	*/
	public PriceQuantity evaluate(PriceQuantity priceQuantity, PriceQuantity instruction) {
		PriceQuantity.PriceQuantityBuilder updatedPriceQuantityBuilder = doEvaluate(priceQuantity, instruction);
		
		final PriceQuantity updatedPriceQuantity;
		if (updatedPriceQuantityBuilder == null) {
			updatedPriceQuantity = null;
		} else {
			updatedPriceQuantity = updatedPriceQuantityBuilder.build();
			objectValidator.validate(PriceQuantity.class, updatedPriceQuantity);
		}
		
		return updatedPriceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(PriceQuantity priceQuantity, PriceQuantity instruction);

	public static class UpdateIndexTransitionPriceAndRateOptionDefault extends UpdateIndexTransitionPriceAndRateOption {
		@Override
		protected PriceQuantity.PriceQuantityBuilder doEvaluate(PriceQuantity priceQuantity, PriceQuantity instruction) {
			PriceQuantity.PriceQuantityBuilder updatedPriceQuantity = PriceQuantity.builder();
			return assignOutput(updatedPriceQuantity, priceQuantity, instruction);
		}
		
		protected PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder updatedPriceQuantity, PriceQuantity priceQuantity, PriceQuantity instruction) {
			updatedPriceQuantity = toBuilder(priceQuantity);
			
			final BigDecimal ifThenElseResult0;
			if (exists(MapperS.of(instruction)).getOrDefault(false)) {
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule0 = MapperS.of(priceQuantity).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).get();
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule1 = MapperS.of(instruction).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).get();
				ifThenElseResult0 = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add((fieldWithMetaPriceSchedule0 == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(fieldWithMetaPriceSchedule0.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()), (fieldWithMetaPriceSchedule1 == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(fieldWithMetaPriceSchedule1.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())).get();
			} else {
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule2 = MapperS.of(priceQuantity).<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).get();
				ifThenElseResult0 = (fieldWithMetaPriceSchedule2 == null ? MapperS.<PriceSchedule>ofNull() : MapperS.of(fieldWithMetaPriceSchedule2.getValue())).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()).get();
			}
			updatedPriceQuantity
				.getOrCreatePrice(0).getOrCreateValue()
				.setValue(ifThenElseResult0);
			
			final InterestRateIndex ifThenElseResult1;
			if (exists(MapperS.of(instruction)).getOrDefault(false)) {
				final FieldWithMetaInterestRateIndex fieldWithMetaInterestRateIndex0 = MapperS.of(instruction).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable0 -> fieldWithMetaObservable0 == null ? null : fieldWithMetaObservable0.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).get();
				ifThenElseResult1 = fieldWithMetaInterestRateIndex0 == null ? null : fieldWithMetaInterestRateIndex0.getValue();
			} else {
				final FieldWithMetaInterestRateIndex fieldWithMetaInterestRateIndex1 = MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable1 -> fieldWithMetaObservable1 == null ? null : fieldWithMetaObservable1.getValue()).<Index>map("getIndex", observable -> observable.getIndex()).<FieldWithMetaInterestRateIndex>map("getInterestRateIndex", index -> index.getInterestRateIndex()).get();
				ifThenElseResult1 = fieldWithMetaInterestRateIndex1 == null ? null : fieldWithMetaInterestRateIndex1.getValue();
			}
			updatedPriceQuantity
				.getOrCreateObservable().getOrCreateValue()
				.getOrCreateIndex()
				.setInterestRateIndexValue(ifThenElseResult1);
			
			return Optional.ofNullable(updatedPriceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
