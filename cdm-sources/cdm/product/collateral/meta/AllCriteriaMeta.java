package cdm.product.collateral.meta;

import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.validation.AllCriteriaTypeFormatValidator;
import cdm.product.collateral.validation.AllCriteriaValidator;
import cdm.product.collateral.validation.exists.AllCriteriaOnlyExistsValidator;
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
@RosettaMeta(model=AllCriteria.class)
public class AllCriteriaMeta implements RosettaMetaData<AllCriteria> {

	@Override
	public List<Validator<? super AllCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllCriteria> validator() {
		return new AllCriteriaValidator();
	}

	@Override
	public Validator<? super AllCriteria> typeFormatValidator() {
		return new AllCriteriaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllCriteria, Set<String>> onlyExistsValidator() {
		return new AllCriteriaOnlyExistsValidator();
	}
}
