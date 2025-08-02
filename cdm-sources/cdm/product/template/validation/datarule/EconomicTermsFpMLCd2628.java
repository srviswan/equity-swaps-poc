package cdm.product.template.validation.datarule;

import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;


/**
 * @version 6.0.0
 */
@RosettaDataRule("EconomicTermsFpML_cd_26_28")
@ImplementedBy(EconomicTermsFpMLCd2628.Default.class)
public interface EconomicTermsFpMLCd2628 extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsFpML_cd_26_28";
	String DEFINITION = "True";
	
	ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms);
	
	class Default implements EconomicTermsFpMLCd2628 {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				return ComparisonResult.of(MapperS.of(true));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsFpMLCd2628 {
	
		@Override
		public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION);
		}
	}
}
