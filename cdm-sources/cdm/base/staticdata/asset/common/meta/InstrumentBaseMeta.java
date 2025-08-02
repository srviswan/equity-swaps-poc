package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.InstrumentBase;
import cdm.base.staticdata.asset.common.validation.InstrumentBaseTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.InstrumentBaseValidator;
import cdm.base.staticdata.asset.common.validation.exists.InstrumentBaseOnlyExistsValidator;
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
@RosettaMeta(model=InstrumentBase.class)
public class InstrumentBaseMeta implements RosettaMetaData<InstrumentBase> {

	@Override
	public List<Validator<? super InstrumentBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseExchangeListed.class),
			factory.<cdm.base.staticdata.asset.common.AssetBase>create(cdm.base.staticdata.asset.common.validation.datarule.AssetBaseRelatedExchange.class)
		);
	}
	
	@Override
	public List<Function<? super InstrumentBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentBase> validator() {
		return new InstrumentBaseValidator();
	}

	@Override
	public Validator<? super InstrumentBase> typeFormatValidator() {
		return new InstrumentBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentBase, Set<String>> onlyExistsValidator() {
		return new InstrumentBaseOnlyExistsValidator();
	}
}
