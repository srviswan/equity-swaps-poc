package cdm.observable.asset.meta;

import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.validation.EquityIndexTypeFormatValidator;
import cdm.observable.asset.validation.EquityIndexValidator;
import cdm.observable.asset.validation.exists.EquityIndexOnlyExistsValidator;
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
@RosettaMeta(model=EquityIndex.class)
public class EquityIndexMeta implements RosettaMetaData<EquityIndex> {

	@Override
	public List<Validator<? super EquityIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.EquityIndex>create(cdm.observable.asset.validation.datarule.EquityIndexEquityAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super EquityIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityIndex> validator() {
		return new EquityIndexValidator();
	}

	@Override
	public Validator<? super EquityIndex> typeFormatValidator() {
		return new EquityIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityIndex, Set<String>> onlyExistsValidator() {
		return new EquityIndexOnlyExistsValidator();
	}
}
