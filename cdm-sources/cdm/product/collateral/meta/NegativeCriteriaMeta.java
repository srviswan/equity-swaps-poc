package cdm.product.collateral.meta;

import cdm.product.collateral.NegativeCriteria;
import cdm.product.collateral.validation.NegativeCriteriaTypeFormatValidator;
import cdm.product.collateral.validation.NegativeCriteriaValidator;
import cdm.product.collateral.validation.exists.NegativeCriteriaOnlyExistsValidator;
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
@RosettaMeta(model=NegativeCriteria.class)
public class NegativeCriteriaMeta implements RosettaMetaData<NegativeCriteria> {

	@Override
	public List<Validator<? super NegativeCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NegativeCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NegativeCriteria> validator() {
		return new NegativeCriteriaValidator();
	}

	@Override
	public Validator<? super NegativeCriteria> typeFormatValidator() {
		return new NegativeCriteriaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NegativeCriteria, Set<String>> onlyExistsValidator() {
		return new NegativeCriteriaOnlyExistsValidator();
	}
}
