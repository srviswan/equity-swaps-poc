package cdm.observable.asset.meta;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.validation.CreditIndexTypeFormatValidator;
import cdm.observable.asset.validation.CreditIndexValidator;
import cdm.observable.asset.validation.exists.CreditIndexOnlyExistsValidator;
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
@RosettaMeta(model=CreditIndex.class)
public class CreditIndexMeta implements RosettaMetaData<CreditIndex> {

	@Override
	public List<Validator<? super CreditIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.CreditIndex>create(cdm.observable.asset.validation.datarule.CreditIndexIndexSeries.class),
			factory.<cdm.observable.asset.CreditIndex>create(cdm.observable.asset.validation.datarule.CreditIndexIndexAnnexVersion.class),
			factory.<cdm.observable.asset.CreditIndex>create(cdm.observable.asset.validation.datarule.CreditIndexIndexFactor.class),
			factory.<cdm.observable.asset.CreditIndex>create(cdm.observable.asset.validation.datarule.CreditIndexCreditAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super CreditIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditIndex> validator() {
		return new CreditIndexValidator();
	}

	@Override
	public Validator<? super CreditIndex> typeFormatValidator() {
		return new CreditIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditIndex, Set<String>> onlyExistsValidator() {
		return new CreditIndexOnlyExistsValidator();
	}
}
