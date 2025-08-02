package cdm.event.position.validation.datarule;

import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
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
@RosettaDataRule("PortfolioStateNonTransferable")
@ImplementedBy(PortfolioStateNonTransferable.Default.class)
public interface PortfolioStateNonTransferable extends Validator<PortfolioState> {
	
	String NAME = "PortfolioStateNonTransferable";
	String DEFINITION = "positions -> product -> NonTransferableProduct exists";
	
	ValidationResult<PortfolioState> validate(RosettaPath path, PortfolioState portfolioState);
	
	class Default implements PortfolioStateNonTransferable {
	
		@Override
		public ValidationResult<PortfolioState> validate(RosettaPath path, PortfolioState portfolioState) {
			ComparisonResult result = executeDataRule(portfolioState);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PortfolioState portfolioState) {
			try {
				return exists(MapperS.of(portfolioState).<Position>mapC("getPositions", _portfolioState -> _portfolioState.getPositions()).<Product>map("getProduct", position -> position.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioStateNonTransferable {
	
		@Override
		public ValidationResult<PortfolioState> validate(RosettaPath path, PortfolioState portfolioState) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION);
		}
	}
}
