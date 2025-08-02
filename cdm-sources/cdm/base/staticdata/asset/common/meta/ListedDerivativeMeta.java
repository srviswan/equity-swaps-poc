package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.ListedDerivative;
import cdm.base.staticdata.asset.common.validation.ListedDerivativeTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.ListedDerivativeValidator;
import cdm.base.staticdata.asset.common.validation.exists.ListedDerivativeOnlyExistsValidator;
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
@RosettaMeta(model=ListedDerivative.class)
public class ListedDerivativeMeta implements RosettaMetaData<ListedDerivative> {

	@Override
	public List<Validator<? super ListedDerivative>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.base.staticdata.asset.common.ListedDerivative>create(cdm.base.staticdata.asset.common.validation.datarule.ListedDerivativeOptions.class)
		);
	}
	
	@Override
	public List<Function<? super ListedDerivative, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ListedDerivative> validator() {
		return new ListedDerivativeValidator();
	}

	@Override
	public Validator<? super ListedDerivative> typeFormatValidator() {
		return new ListedDerivativeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ListedDerivative, Set<String>> onlyExistsValidator() {
		return new ListedDerivativeOnlyExistsValidator();
	}
}
