package cdm.observable.asset.meta;

import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.validation.InflationIndexTypeFormatValidator;
import cdm.observable.asset.validation.InflationIndexValidator;
import cdm.observable.asset.validation.exists.InflationIndexOnlyExistsValidator;
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
@RosettaMeta(model=InflationIndex.class)
public class InflationIndexMeta implements RosettaMetaData<InflationIndex> {

	@Override
	public List<Validator<? super InflationIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.InflationIndex>create(cdm.observable.asset.validation.datarule.InflationIndexInterestRateAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super InflationIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InflationIndex> validator() {
		return new InflationIndexValidator();
	}

	@Override
	public Validator<? super InflationIndex> typeFormatValidator() {
		return new InflationIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationIndex, Set<String>> onlyExistsValidator() {
		return new InflationIndexOnlyExistsValidator();
	}
}
