package cdm.product.template.validation.datarule;

import cdm.base.math.Quantity;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.AssetDeliveryProfileBlock;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.SchedulePeriod;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("SettlementPayoutDeliveryCapacity")
@ImplementedBy(SettlementPayoutDeliveryCapacity.Default.class)
public interface SettlementPayoutDeliveryCapacity extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutDeliveryCapacity";
	String DEFINITION = "if delivery -> deliveryCapacity exists then schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity exists then delivery -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if delivery -> periods -> profile -> block -> deliveryCapacity exists then schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity is absent else if schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> deliveryCapacity exists then delivery -> deliveryCapacity is absent and schedule -> schedulePeriod -> deliveryPeriod -> deliveryCapacity is absent and delivery -> periods -> profile -> block -> deliveryCapacity is absent";
	
	ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout);
	
	class Default implements SettlementPayoutDeliveryCapacity {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			ComparisonResult result = executeDataRule(settlementPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementPayout settlementPayout) {
			try {
				if (exists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).and(notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()))).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).and(notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()))).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				if (exists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity()))).and(notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutDeliveryCapacity {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
		}
	}
}
