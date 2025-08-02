package cdm.product.collateral.meta;

import cdm.product.collateral.CounterpartyOwnIssuePermitted;
import cdm.product.collateral.validation.CounterpartyOwnIssuePermittedTypeFormatValidator;
import cdm.product.collateral.validation.CounterpartyOwnIssuePermittedValidator;
import cdm.product.collateral.validation.exists.CounterpartyOwnIssuePermittedOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.0.0
 */
@RosettaMeta(model=CounterpartyOwnIssuePermitted.class)
public class CounterpartyOwnIssuePermittedMeta implements RosettaMetaData<CounterpartyOwnIssuePermitted> {

	@Override
	public List<Validator<? super CounterpartyOwnIssuePermitted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CounterpartyOwnIssuePermitted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CounterpartyOwnIssuePermitted> validator() {
		return new CounterpartyOwnIssuePermittedValidator();
	}

	@Override
	public Validator<? super CounterpartyOwnIssuePermitted> typeFormatValidator() {
		return new CounterpartyOwnIssuePermittedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CounterpartyOwnIssuePermitted, Set<String>> onlyExistsValidator() {
		return new CounterpartyOwnIssuePermittedOnlyExistsValidator();
	}
}
