package cdm.product.template.validation.datarule;

import cdm.observable.asset.Price;
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
@RosettaDataRule("SettlementPayoutPriceTimeIntervalQuantity")
@ImplementedBy(SettlementPayoutPriceTimeIntervalQuantity.Default.class)
public interface SettlementPayoutPriceTimeIntervalQuantity extends Validator<SettlementPayout> {
	
	String NAME = "SettlementPayoutPriceTimeIntervalQuantity";
	String DEFINITION = "if schedule -> schedulePeriod -> deliveryPeriod -> priceTimeIntervalQuantity exists then delivery -> periods -> profile -> block -> priceTimeIntervalQuantity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> priceTimeIntervalQuantity is absent else if delivery -> periods -> profile -> block -> priceTimeIntervalQuantity exists then schedule -> schedulePeriod -> deliveryPeriod -> priceTimeIntervalQuantity is absent and schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> priceTimeIntervalQuantity is absent else if schedule -> schedulePeriod -> deliveryPeriod -> profile -> block -> priceTimeIntervalQuantity exists then schedule -> schedulePeriod -> deliveryPeriod -> priceTimeIntervalQuantity is absent and delivery -> periods -> profile -> block -> priceTimeIntervalQuantity is absent";
	
	ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout);
	
	class Default implements SettlementPayoutPriceTimeIntervalQuantity {
	
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
				if (exists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())));
				}
				if (exists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity())).and(notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())));
				}
				if (exists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
					return notExists(MapperS.of(settlementPayout).<CalculationSchedule>map("getSchedule", _settlementPayout -> _settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity())).and(notExists(MapperS.of(settlementPayout).<AssetDeliveryInformation>map("getDelivery", _settlementPayout -> _settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile()).<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock()).<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPayoutPriceTimeIntervalQuantity {
	
		@Override
		public ValidationResult<SettlementPayout> validate(RosettaPath path, SettlementPayout settlementPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPayout", path, DEFINITION);
		}
	}
}
