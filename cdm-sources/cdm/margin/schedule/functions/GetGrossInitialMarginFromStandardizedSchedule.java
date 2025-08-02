package cdm.margin.schedule.functions;

import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GetGrossInitialMarginFromStandardizedSchedule.GetGrossInitialMarginFromStandardizedScheduleDefault.class)
public abstract class GetGrossInitialMarginFromStandardizedSchedule implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetStandardizedScheduleMarginRate getStandardizedScheduleMarginRate;

	/**
	* @param standardizedSchedule 
	* @return grossInitialMargin 
	*/
	public Money evaluate(StandardizedSchedule standardizedSchedule) {
		Money.MoneyBuilder grossInitialMarginBuilder = doEvaluate(standardizedSchedule);
		
		final Money grossInitialMargin;
		if (grossInitialMarginBuilder == null) {
			grossInitialMargin = null;
		} else {
			grossInitialMargin = grossInitialMarginBuilder.build();
			objectValidator.validate(Money.class, grossInitialMargin);
		}
		
		// post-conditions
		conditionValidator.validate(() -> greaterThan(MapperS.of(grossInitialMargin).<BigDecimal>map("getValue", money -> money.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All),
			"Ensure gross initial margin is greater than 0");
		
		return grossInitialMargin;
	}

	protected abstract Money.MoneyBuilder doEvaluate(StandardizedSchedule standardizedSchedule);

	protected abstract MapperS<BigDecimal> initialMarginRequirement(StandardizedSchedule standardizedSchedule);

	public static class GetGrossInitialMarginFromStandardizedScheduleDefault extends GetGrossInitialMarginFromStandardizedSchedule {
		@Override
		protected Money.MoneyBuilder doEvaluate(StandardizedSchedule standardizedSchedule) {
			Money.MoneyBuilder grossInitialMargin = Money.builder();
			return assignOutput(grossInitialMargin, standardizedSchedule);
		}
		
		protected Money.MoneyBuilder assignOutput(Money.MoneyBuilder grossInitialMargin, StandardizedSchedule standardizedSchedule) {
			grossInitialMargin
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(standardizedSchedule).<BigDecimal>map("getNotional", _standardizedSchedule -> _standardizedSchedule.getNotional()), initialMarginRequirement(standardizedSchedule)), MapperS.of(new BigDecimal("0.01"))).get());
			
			grossInitialMargin
				.getOrCreateUnit()
				.setCurrencyValue(MapperS.of(standardizedSchedule).<String>map("getNotionalCurrency", _standardizedSchedule -> _standardizedSchedule.getNotionalCurrency()).get());
			
			return Optional.ofNullable(grossInitialMargin)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> initialMarginRequirement(StandardizedSchedule standardizedSchedule) {
			return MapperS.of(getStandardizedScheduleMarginRate.evaluate(MapperS.of(standardizedSchedule).<StandardizedScheduleAssetClassEnum>map("getAssetClass", _standardizedSchedule -> _standardizedSchedule.getAssetClass()).get(), MapperS.of(standardizedSchedule).<BigDecimal>map("getDurationInYears", _standardizedSchedule -> _standardizedSchedule.getDurationInYears()).get()));
		}
	}
}
