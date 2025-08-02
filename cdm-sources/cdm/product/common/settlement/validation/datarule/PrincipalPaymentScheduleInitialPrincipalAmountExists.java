package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.Money;
import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.PrincipalPaymentSchedule;
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
@RosettaDataRule("PrincipalPaymentScheduleInitialPrincipalAmountExists")
@ImplementedBy(PrincipalPaymentScheduleInitialPrincipalAmountExists.Default.class)
public interface PrincipalPaymentScheduleInitialPrincipalAmountExists extends Validator<PrincipalPaymentSchedule> {
	
	String NAME = "PrincipalPaymentScheduleInitialPrincipalAmountExists";
	String DEFINITION = "if initialPrincipalPayment exists then initialPrincipalPayment -> principalAmount exists or initialPrincipalPayment -> presentValuePrincipalAmount exists";
	
	ValidationResult<PrincipalPaymentSchedule> validate(RosettaPath path, PrincipalPaymentSchedule principalPaymentSchedule);
	
	class Default implements PrincipalPaymentScheduleInitialPrincipalAmountExists {
	
		@Override
		public ValidationResult<PrincipalPaymentSchedule> validate(RosettaPath path, PrincipalPaymentSchedule principalPaymentSchedule) {
			ComparisonResult result = executeDataRule(principalPaymentSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalPaymentSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PrincipalPaymentSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PrincipalPaymentSchedule principalPaymentSchedule) {
			try {
				if (exists(MapperS.of(principalPaymentSchedule).<PrincipalPayment>map("getInitialPrincipalPayment", _principalPaymentSchedule -> _principalPaymentSchedule.getInitialPrincipalPayment())).getOrDefault(false)) {
					return exists(MapperS.of(principalPaymentSchedule).<PrincipalPayment>map("getInitialPrincipalPayment", _principalPaymentSchedule -> _principalPaymentSchedule.getInitialPrincipalPayment()).<Money>map("getPrincipalAmount", principalPayment -> principalPayment.getPrincipalAmount())).or(exists(MapperS.of(principalPaymentSchedule).<PrincipalPayment>map("getInitialPrincipalPayment", _principalPaymentSchedule -> _principalPaymentSchedule.getInitialPrincipalPayment()).<Money>map("getPresentValuePrincipalAmount", principalPayment -> principalPayment.getPresentValuePrincipalAmount())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PrincipalPaymentScheduleInitialPrincipalAmountExists {
	
		@Override
		public ValidationResult<PrincipalPaymentSchedule> validate(RosettaPath path, PrincipalPaymentSchedule principalPaymentSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalPaymentSchedule", path, DEFINITION);
		}
	}
}
