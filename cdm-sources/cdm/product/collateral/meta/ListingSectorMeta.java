package cdm.product.collateral.meta;

import cdm.product.collateral.ListingSector;
import cdm.product.collateral.validation.ListingSectorTypeFormatValidator;
import cdm.product.collateral.validation.ListingSectorValidator;
import cdm.product.collateral.validation.exists.ListingSectorOnlyExistsValidator;
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
@RosettaMeta(model=ListingSector.class)
public class ListingSectorMeta implements RosettaMetaData<ListingSector> {

	@Override
	public List<Validator<? super ListingSector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ListingSector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ListingSector> validator() {
		return new ListingSectorValidator();
	}

	@Override
	public Validator<? super ListingSector> typeFormatValidator() {
		return new ListingSectorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ListingSector, Set<String>> onlyExistsValidator() {
		return new ListingSectorOnlyExistsValidator();
	}
}
