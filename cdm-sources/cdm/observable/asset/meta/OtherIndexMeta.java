package cdm.observable.asset.meta;

import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.validation.OtherIndexTypeFormatValidator;
import cdm.observable.asset.validation.OtherIndexValidator;
import cdm.observable.asset.validation.exists.OtherIndexOnlyExistsValidator;
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
@RosettaMeta(model=OtherIndex.class)
public class OtherIndexMeta implements RosettaMetaData<OtherIndex> {

	@Override
	public List<Validator<? super OtherIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class),
			factory.<cdm.observable.asset.OtherIndex>create(cdm.observable.asset.validation.datarule.OtherIndexAssetClassRequired.class)
		);
	}
	
	@Override
	public List<Function<? super OtherIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OtherIndex> validator() {
		return new OtherIndexValidator();
	}

	@Override
	public Validator<? super OtherIndex> typeFormatValidator() {
		return new OtherIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherIndex, Set<String>> onlyExistsValidator() {
		return new OtherIndexOnlyExistsValidator();
	}
}
