package cdm.product.collateral.meta;

import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.validation.AnyCriteriaTypeFormatValidator;
import cdm.product.collateral.validation.AnyCriteriaValidator;
import cdm.product.collateral.validation.exists.AnyCriteriaOnlyExistsValidator;
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
@RosettaMeta(model=AnyCriteria.class)
public class AnyCriteriaMeta implements RosettaMetaData<AnyCriteria> {

	@Override
	public List<Validator<? super AnyCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnyCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AnyCriteria> validator() {
		return new AnyCriteriaValidator();
	}

	@Override
	public Validator<? super AnyCriteria> typeFormatValidator() {
		return new AnyCriteriaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnyCriteria, Set<String>> onlyExistsValidator() {
		return new AnyCriteriaOnlyExistsValidator();
	}
}
