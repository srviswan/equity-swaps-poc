package cdm.observable.asset.meta;

import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.validation.ForeignExchangeRateIndexTypeFormatValidator;
import cdm.observable.asset.validation.ForeignExchangeRateIndexValidator;
import cdm.observable.asset.validation.exists.ForeignExchangeRateIndexOnlyExistsValidator;
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
@RosettaMeta(model=ForeignExchangeRateIndex.class)
public class ForeignExchangeRateIndexMeta implements RosettaMetaData<ForeignExchangeRateIndex> {

	@Override
	public List<Validator<? super ForeignExchangeRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.ForeignExchangeRateIndex>create(cdm.observable.asset.validation.datarule.ForeignExchangeRateIndexFXAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super ForeignExchangeRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ForeignExchangeRateIndex> validator() {
		return new ForeignExchangeRateIndexValidator();
	}

	@Override
	public Validator<? super ForeignExchangeRateIndex> typeFormatValidator() {
		return new ForeignExchangeRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ForeignExchangeRateIndex, Set<String>> onlyExistsValidator() {
		return new ForeignExchangeRateIndexOnlyExistsValidator();
	}
}
