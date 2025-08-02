package cdm.observable.asset.validation.datarule;

import cdm.base.math.CapacityUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.MapperMaths;
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
@RosettaDataRule("PriceQuantityNonCurrencyQuantities")
@ImplementedBy(PriceQuantityNonCurrencyQuantities.Default.class)
public interface PriceQuantityNonCurrencyQuantities extends Validator<PriceQuantity> {
	
	String NAME = "PriceQuantityNonCurrencyQuantities";
	String DEFINITION = "(quantity count - quantity -> unit -> currency count) <= 1 or (observable -> Asset -> Commodity exists and quantity -> unit -> capacityUnit exists and (quantity count - quantity -> unit -> currency count) <= 2)";
	
	ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity);
	
	class Default implements PriceQuantityNonCurrencyQuantities {
	
		@Override
		public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
			ComparisonResult result = executeDataRule(priceQuantity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PriceQuantity priceQuantity) {
			try {
				return lessThanEquals(MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).resultCount()), MapperS.of(MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).resultCount())), MapperS.of(1), CardinalityOperator.All).or(exists(MapperS.of(priceQuantity).<FieldWithMetaObservable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable == null ? null : fieldWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).and(exists(MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<CapacityUnitEnum>map("getCapacityUnit", unitType -> unitType.getCapacityUnit()))).and(lessThanEquals(MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).resultCount()), MapperS.of(MapperS.of(priceQuantity).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).resultCount())), MapperS.of(2), CardinalityOperator.All)));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceQuantityNonCurrencyQuantities {
	
		@Override
		public ValidationResult<PriceQuantity> validate(RosettaPath path, PriceQuantity priceQuantity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceQuantity", path, DEFINITION);
		}
	}
}
