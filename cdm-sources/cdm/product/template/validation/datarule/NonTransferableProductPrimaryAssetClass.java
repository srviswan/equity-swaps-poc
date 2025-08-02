package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("NonTransferableProductPrimaryAssetClass")
@ImplementedBy(NonTransferableProductPrimaryAssetClass.Default.class)
public interface NonTransferableProductPrimaryAssetClass extends Validator<NonTransferableProduct> {
	
	String NAME = "NonTransferableProductPrimaryAssetClass";
	String DEFINITION = "if economicTerms -> nonStandardisedTerms = True then taxonomy -> primaryAssetClass exists";
	
	ValidationResult<NonTransferableProduct> validate(RosettaPath path, NonTransferableProduct nonTransferableProduct);
	
	class Default implements NonTransferableProductPrimaryAssetClass {
	
		@Override
		public ValidationResult<NonTransferableProduct> validate(RosettaPath path, NonTransferableProduct nonTransferableProduct) {
			ComparisonResult result = executeDataRule(nonTransferableProduct);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonTransferableProduct", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NonTransferableProduct", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NonTransferableProduct nonTransferableProduct) {
			try {
				if (areEqual(MapperS.of(nonTransferableProduct).<EconomicTerms>map("getEconomicTerms", _nonTransferableProduct -> _nonTransferableProduct.getEconomicTerms()).<Boolean>map("getNonStandardisedTerms", economicTerms -> economicTerms.getNonStandardisedTerms()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return exists(MapperS.of(nonTransferableProduct).<ProductTaxonomy>mapC("getTaxonomy", _nonTransferableProduct -> _nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass()));
				}
				return ComparisonResult.successEmptyOperand("");
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonTransferableProductPrimaryAssetClass {
	
		@Override
		public ValidationResult<NonTransferableProduct> validate(RosettaPath path, NonTransferableProduct nonTransferableProduct) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonTransferableProduct", path, DEFINITION);
		}
	}
}
