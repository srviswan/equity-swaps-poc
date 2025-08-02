package cdm.margin.schedule.validation.datarule;

import cdm.base.math.UnitType;
import cdm.margin.schedule.StandardizedScheduleTradeInfo;
import cdm.observable.asset.Money;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("StandardizedScheduleTradeInfoSameCurrencies")
@ImplementedBy(StandardizedScheduleTradeInfoSameCurrencies.Default.class)
public interface StandardizedScheduleTradeInfoSameCurrencies extends Validator<StandardizedScheduleTradeInfo> {
	
	String NAME = "StandardizedScheduleTradeInfoSameCurrencies";
	String DEFINITION = "grossInitialMargin -> unit -> currency = markToMarketValue -> unit -> currency";
	
	ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo);
	
	class Default implements StandardizedScheduleTradeInfoSameCurrencies {
	
		@Override
		public ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			ComparisonResult result = executeDataRule(standardizedScheduleTradeInfo);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			try {
				return areEqual(MapperS.of(standardizedScheduleTradeInfo).<Money>map("getGrossInitialMargin", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getGrossInitialMargin()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of(standardizedScheduleTradeInfo).<Money>map("getMarkToMarketValue", _standardizedScheduleTradeInfo -> _standardizedScheduleTradeInfo.getMarkToMarketValue()).<UnitType>map("getUnit", money -> money.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StandardizedScheduleTradeInfoSameCurrencies {
	
		@Override
		public ValidationResult<StandardizedScheduleTradeInfo> validate(RosettaPath path, StandardizedScheduleTradeInfo standardizedScheduleTradeInfo) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StandardizedScheduleTradeInfo", path, DEFINITION);
		}
	}
}
