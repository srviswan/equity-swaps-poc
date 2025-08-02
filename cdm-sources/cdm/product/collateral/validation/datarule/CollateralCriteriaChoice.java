package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.CollateralCriteria;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0
 */
@RosettaDataRule("CollateralCriteriaChoice")
@ImplementedBy(CollateralCriteriaChoice.Default.class)
public interface CollateralCriteriaChoice extends Validator<CollateralCriteria> {
	
	String NAME = "CollateralCriteriaChoice";
	String DEFINITION = "";
	
	ValidationResult<CollateralCriteria> validate(RosettaPath path, CollateralCriteria collateralCriteria);
	
	class Default implements CollateralCriteriaChoice {
	
		@Override
		public ValidationResult<CollateralCriteria> validate(RosettaPath path, CollateralCriteria collateralCriteria) {
			ComparisonResult result = executeDataRule(collateralCriteria);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralCriteria", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CollateralCriteria", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CollateralCriteria collateralCriteria) {
			try {
				return choice(MapperS.of(collateralCriteria), Arrays.asList("AllCriteria", "AnyCriteria", "NegativeCriteria", "CollateralIssuerType", "AssetType", "IssuerCountryOfOrigin", "AssetCountryOfOrigin", "CurrencyCodeEnum", "IssuerName", "IssuerAgencyRating", "SovereignAgencyRating", "AssetAgencyRating", "AssetMaturity", "SpecificAsset", "CollateralTaxonomy", "ListingExchange", "ListingSector", "Index", "CounterpartyOwnIssuePermitted", "DomesticCurrencyIssued"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralCriteriaChoice {
	
		@Override
		public ValidationResult<CollateralCriteria> validate(RosettaPath path, CollateralCriteria collateralCriteria) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralCriteria", path, DEFINITION);
		}
	}
}
