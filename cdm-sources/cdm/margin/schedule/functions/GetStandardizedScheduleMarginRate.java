package cdm.margin.schedule.functions;

import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(GetStandardizedScheduleMarginRate.GetStandardizedScheduleMarginRateDefault.class)
public abstract class GetStandardizedScheduleMarginRate implements RosettaFunction {

	/**
	* @param assetClass 
	* @param durationInYears 
	* @return percentage 
	*/
	public BigDecimal evaluate(StandardizedScheduleAssetClassEnum assetClass, BigDecimal durationInYears) {
		BigDecimal percentage = doEvaluate(assetClass, durationInYears);
		
		return percentage;
	}

	protected abstract BigDecimal doEvaluate(StandardizedScheduleAssetClassEnum assetClass, BigDecimal durationInYears);

	public static class GetStandardizedScheduleMarginRateDefault extends GetStandardizedScheduleMarginRate {
		@Override
		protected BigDecimal doEvaluate(StandardizedScheduleAssetClassEnum assetClass, BigDecimal durationInYears) {
			BigDecimal percentage = null;
			return assignOutput(percentage, assetClass, durationInYears);
		}
		
		protected BigDecimal assignOutput(BigDecimal percentage, StandardizedScheduleAssetClassEnum assetClass, BigDecimal durationInYears) {
			if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.INTEREST_RATES), CardinalityOperator.All).getOrDefault(false)) {
				if (lessThanEquals(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(2)), CardinalityOperator.All).getOrDefault(false)) {
					percentage = new BigDecimal("1.0");
				} else if (greaterThan(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(2)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(5)), CardinalityOperator.All)).getOrDefault(false)) {
					percentage = new BigDecimal("2.0");
				} else if (greaterThan(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(5)), CardinalityOperator.All).getOrDefault(false)) {
					percentage = new BigDecimal("4.0");
				} else {
					percentage = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.CREDIT), CardinalityOperator.All).getOrDefault(false)) {
				if (lessThanEquals(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(2)), CardinalityOperator.All).getOrDefault(false)) {
					percentage = new BigDecimal("2.0");
				} else if (greaterThan(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(2)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(5)), CardinalityOperator.All)).getOrDefault(false)) {
					percentage = new BigDecimal("5.0");
				} else if (greaterThan(MapperS.of(durationInYears), MapperS.of(BigDecimal.valueOf(5)), CardinalityOperator.All).getOrDefault(false)) {
					percentage = new BigDecimal("10.0");
				} else {
					percentage = null;
				}
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				percentage = new BigDecimal("6.0");
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.EQUITY), CardinalityOperator.All).getOrDefault(false)) {
				percentage = new BigDecimal("15.0");
			} else if (areEqual(MapperS.of(assetClass), MapperS.of(StandardizedScheduleAssetClassEnum.COMMODITY), CardinalityOperator.All).getOrDefault(false)) {
				percentage = new BigDecimal("15.0");
			} else {
				percentage = null;
			}
			
			return percentage;
		}
	}
}
