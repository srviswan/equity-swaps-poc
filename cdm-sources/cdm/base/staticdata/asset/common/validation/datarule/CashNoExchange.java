package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.party.LegalEntity;
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
@RosettaDataRule("CashNoExchange")
@ImplementedBy(CashNoExchange.Default.class)
public interface CashNoExchange extends Validator<Cash> {
	
	String NAME = "CashNoExchange";
	String DEFINITION = "exchange is absent and isExchangeListed is absent";
	
	ValidationResult<Cash> validate(RosettaPath path, Cash cash);
	
	class Default implements CashNoExchange {
	
		@Override
		public ValidationResult<Cash> validate(RosettaPath path, Cash cash) {
			ComparisonResult result = executeDataRule(cash);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Cash", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Cash cash) {
			try {
				return notExists(MapperS.of(cash).<LegalEntity>map("getExchange", _cash -> _cash.getExchange())).and(notExists(MapperS.of(cash).<Boolean>map("getIsExchangeListed", _cash -> _cash.getIsExchangeListed())));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashNoExchange {
	
		@Override
		public ValidationResult<Cash> validate(RosettaPath path, Cash cash) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Cash", path, DEFINITION);
		}
	}
}
