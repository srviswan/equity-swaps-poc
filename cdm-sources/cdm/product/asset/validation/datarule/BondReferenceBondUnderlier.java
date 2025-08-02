package cdm.product.asset.validation.datarule;

import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.product.asset.BondReference;
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
@RosettaDataRule("BondReferenceBondUnderlier")
@ImplementedBy(BondReferenceBondUnderlier.Default.class)
public interface BondReferenceBondUnderlier extends Validator<BondReference> {
	
	String NAME = "BondReferenceBondUnderlier";
	String DEFINITION = "bond -> instrumentType = InstrumentTypeEnum -> Debt";
	
	ValidationResult<BondReference> validate(RosettaPath path, BondReference bondReference);
	
	class Default implements BondReferenceBondUnderlier {
	
		@Override
		public ValidationResult<BondReference> validate(RosettaPath path, BondReference bondReference) {
			ComparisonResult result = executeDataRule(bondReference);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondReference", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BondReference", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BondReference bondReference) {
			try {
				return areEqual(MapperS.of(bondReference).<Security>map("getBond", _bondReference -> _bondReference.getBond()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(InstrumentTypeEnum.DEBT), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondReferenceBondUnderlier {
	
		@Override
		public ValidationResult<BondReference> validate(RosettaPath path, BondReference bondReference) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondReference", path, DEFINITION);
		}
	}
}
