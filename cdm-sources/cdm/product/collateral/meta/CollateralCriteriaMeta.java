package cdm.product.collateral.meta;

import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.validation.CollateralCriteriaTypeFormatValidator;
import cdm.product.collateral.validation.CollateralCriteriaValidator;
import cdm.product.collateral.validation.exists.CollateralCriteriaOnlyExistsValidator;
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
@RosettaMeta(model=CollateralCriteria.class)
public class CollateralCriteriaMeta implements RosettaMetaData<CollateralCriteria> {

	@Override
	public List<Validator<? super CollateralCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.collateral.CollateralCriteria>create(cdm.product.collateral.validation.datarule.CollateralCriteriaChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralCriteria> validator() {
		return new CollateralCriteriaValidator();
	}

	@Override
	public Validator<? super CollateralCriteria> typeFormatValidator() {
		return new CollateralCriteriaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralCriteria, Set<String>> onlyExistsValidator() {
		return new CollateralCriteriaOnlyExistsValidator();
	}
}
