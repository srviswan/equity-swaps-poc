package cdm.event.common.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.QuantityChangeInstruction.QuantityChangeInstructionBuilder;
import cdm.observable.asset.CashPrice;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceExpressionEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_OnDemandRateChangePriceChangeInstruction.Create_OnDemandRateChangePriceChangeInstructionDefault.class)
public abstract class Create_OnDemandRateChangePriceChangeInstruction implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity The original price / quantity to be modified with the new rate.
	* @param newRate The new rate value, provided as a single number.
	* @return quantityChangeInstruction 
	*/
	public QuantityChangeInstruction evaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
		// pre-conditions
		conditionValidator.validate(() -> exists(currentRatePrice(priceQuantity, newRate)),
			"There should be 1 and only 1 rate type price in the current price.");
		
		QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChangeInstructionBuilder = doEvaluate(priceQuantity, newRate);
		
		final QuantityChangeInstruction quantityChangeInstruction;
		if (quantityChangeInstructionBuilder == null) {
			quantityChangeInstruction = null;
		} else {
			quantityChangeInstruction = quantityChangeInstructionBuilder.build();
			objectValidator.validate(QuantityChangeInstruction.class, quantityChangeInstruction);
		}
		
		return quantityChangeInstruction;
	}

	protected abstract QuantityChangeInstruction.QuantityChangeInstructionBuilder doEvaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate);

	protected abstract MapperS<? extends FieldWithMetaPriceSchedule> currentRatePrice(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate);

	protected abstract MapperS<? extends Price> newPrice(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate);

	protected abstract MapperS<? extends PriceQuantity> newPriceQuantity(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate);

	public static class Create_OnDemandRateChangePriceChangeInstructionDefault extends Create_OnDemandRateChangePriceChangeInstruction {
		@Override
		protected QuantityChangeInstruction.QuantityChangeInstructionBuilder doEvaluate(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
			if (priceQuantity == null) {
				priceQuantity = Collections.emptyList();
			}
			QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChangeInstruction = QuantityChangeInstruction.builder();
			return assignOutput(quantityChangeInstruction, priceQuantity, newRate);
		}
		
		protected QuantityChangeInstruction.QuantityChangeInstructionBuilder assignOutput(QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChangeInstruction, List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
			quantityChangeInstruction = toBuilder(QuantityChangeInstruction.builder()
				.setChange(new ArrayList<>(newPriceQuantity(priceQuantity, newRate).getMulti()))
				.setDirection(QuantityChangeDirectionEnum.REPLACE)
				.setLotIdentifier(Collections.<Identifier>emptyList())
				.build());
			
			return Optional.ofNullable(quantityChangeInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaPriceSchedule> currentRatePrice(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
			final MapperListOfLists<FieldWithMetaPriceSchedule> thenArg0 = MapperC.<PriceQuantity>of(priceQuantity)
				.mapItemToList(item -> item.<FieldWithMetaPriceSchedule>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()));
			final MapperC<FieldWithMetaPriceSchedule> thenArg1 = thenArg0
				.flattenList();
			final MapperC<FieldWithMetaPriceSchedule> thenArg2 = thenArg1
				.filterItemNullSafe(item -> areEqual(item.<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule -> fieldWithMetaPriceSchedule == null ? null : fieldWithMetaPriceSchedule.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.INTEREST_RATE), CardinalityOperator.All).get());
			return MapperS.of(thenArg2.get());
		}
		
		@Override
		protected MapperS<? extends Price> newPrice(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
			return MapperS.of(Price.builder()
				.setValue(newRate)
				.setUnit(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule0 -> fieldWithMetaPriceSchedule0 == null ? null : fieldWithMetaPriceSchedule0.getValue()).<UnitType>map("getUnit", priceSchedule -> priceSchedule.getUnit()).get())
				.setPerUnitOf(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule1 -> fieldWithMetaPriceSchedule1 == null ? null : fieldWithMetaPriceSchedule1.getValue()).<UnitType>map("getPerUnitOf", priceSchedule -> priceSchedule.getPerUnitOf()).get())
				.setPriceType(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule2 -> fieldWithMetaPriceSchedule2 == null ? null : fieldWithMetaPriceSchedule2.getValue()).<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()).get())
				.setPriceExpression(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule3 -> fieldWithMetaPriceSchedule3 == null ? null : fieldWithMetaPriceSchedule3.getValue()).<PriceExpressionEnum>map("getPriceExpression", priceSchedule -> priceSchedule.getPriceExpression()).get())
				.setComposite(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule4 -> fieldWithMetaPriceSchedule4 == null ? null : fieldWithMetaPriceSchedule4.getValue()).<PriceComposite>map("getComposite", priceSchedule -> priceSchedule.getComposite()).get())
				.setArithmeticOperator(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule5 -> fieldWithMetaPriceSchedule5 == null ? null : fieldWithMetaPriceSchedule5.getValue()).<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()).get())
				.setCashPrice(currentRatePrice(priceQuantity, newRate).<PriceSchedule>map("Type coercion", fieldWithMetaPriceSchedule6 -> fieldWithMetaPriceSchedule6 == null ? null : fieldWithMetaPriceSchedule6.getValue()).<CashPrice>map("getCashPrice", priceSchedule -> priceSchedule.getCashPrice()).get())
				.setDatedValue(Collections.<DatedValue>emptyList())
				.build());
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> newPriceQuantity(List<? extends PriceQuantity> priceQuantity, BigDecimal newRate) {
			return MapperS.of(PriceQuantity.builder()
				.setPriceValue(new ArrayList<>(newPrice(priceQuantity, newRate).getMulti()))
				.build());
		}
	}
}
