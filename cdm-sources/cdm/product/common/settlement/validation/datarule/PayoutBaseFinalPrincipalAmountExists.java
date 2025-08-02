package cdm.product.common.settlement.validation.datarule;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.PrincipalPaymentSchedule;
import cdm.product.common.settlement.PrincipalPayments;
import cdm.product.common.settlement.ResolvablePriceQuantity;
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
@RosettaDataRule("PayoutBaseFinalPrincipalAmountExists")
@ImplementedBy(PayoutBaseFinalPrincipalAmountExists.Default.class)
public interface PayoutBaseFinalPrincipalAmountExists extends Validator<PayoutBase> {
	
	String NAME = "PayoutBaseFinalPrincipalAmountExists";
	String DEFINITION = "if principalPayment -> principalPaymentSchedule -> finalPrincipalPayment exists and priceQuantity -> quantitySchedule exists and priceQuantity -> reset is absent then principalPayment -> principalPaymentSchedule -> finalPrincipalPayment -> principalAmount exists or principalPayment -> principalPaymentSchedule -> finalPrincipalPayment -> presentValuePrincipalAmount exists";
	
	ValidationResult<PayoutBase> validate(RosettaPath path, PayoutBase payoutBase);
	
	class Default implements PayoutBaseFinalPrincipalAmountExists {
	
		@Override
		public ValidationResult<PayoutBase> validate(RosettaPath path, PayoutBase payoutBase) {
			ComparisonResult result = executeDataRule(payoutBase);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutBase", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PayoutBase", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PayoutBase payoutBase) {
			try {
				if (exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment())).and(exists(MapperS.of(payoutBase).<ResolvablePriceQuantity>map("getPriceQuantity", _payoutBase -> _payoutBase.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()))).and(notExists(MapperS.of(payoutBase).<ResolvablePriceQuantity>map("getPriceQuantity", _payoutBase -> _payoutBase.getPriceQuantity()).<Boolean>map("getReset", resolvablePriceQuantity -> resolvablePriceQuantity.getReset()))).getOrDefault(false)) {
					return exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment()).<Money>map("getPrincipalAmount", principalPayment -> principalPayment.getPrincipalAmount())).or(exists(MapperS.of(payoutBase).<PrincipalPayments>map("getPrincipalPayment", _payoutBase -> _payoutBase.getPrincipalPayment()).<PrincipalPaymentSchedule>map("getPrincipalPaymentSchedule", principalPayments -> principalPayments.getPrincipalPaymentSchedule()).<PrincipalPayment>map("getFinalPrincipalPayment", principalPaymentSchedule -> principalPaymentSchedule.getFinalPrincipalPayment()).<Money>map("getPresentValuePrincipalAmount", principalPayment -> principalPayment.getPresentValuePrincipalAmount())));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutBaseFinalPrincipalAmountExists {
	
		@Override
		public ValidationResult<PayoutBase> validate(RosettaPath path, PayoutBase payoutBase) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutBase", path, DEFINITION);
		}
	}
}
