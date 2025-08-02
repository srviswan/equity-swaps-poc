package cdm.observable.asset.meta;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.validation.FloatingRateIndexTypeFormatValidator;
import cdm.observable.asset.validation.FloatingRateIndexValidator;
import cdm.observable.asset.validation.exists.FloatingRateIndexOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndex.class)
public class FloatingRateIndexMeta implements RosettaMetaData<FloatingRateIndex> {

	@Override
	public List<Validator<? super FloatingRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.FloatingRateIndex>create(cdm.observable.asset.validation.datarule.FloatingRateIndexInterestRateAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateIndex> validator() {
		return new FloatingRateIndexValidator();
	}

	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator() {
		return new FloatingRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndex, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexOnlyExistsValidator();
	}
}
