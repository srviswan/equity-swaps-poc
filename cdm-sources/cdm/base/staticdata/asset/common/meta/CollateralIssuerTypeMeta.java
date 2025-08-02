package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.validation.CollateralIssuerTypeTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.CollateralIssuerTypeValidator;
import cdm.base.staticdata.asset.common.validation.exists.CollateralIssuerTypeOnlyExistsValidator;
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
@RosettaMeta(model=CollateralIssuerType.class)
public class CollateralIssuerTypeMeta implements RosettaMetaData<CollateralIssuerType> {

	@Override
	public List<Validator<? super CollateralIssuerType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.CollateralIssuerType>create(cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeSupraNationalSubType.class),
			factory.<cdm.base.staticdata.asset.common.CollateralIssuerType>create(cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeQuasiGovernmentSubType.class),
			factory.<cdm.base.staticdata.asset.common.CollateralIssuerType>create(cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeRegionalGovernmentSubType.class),
			factory.<cdm.base.staticdata.asset.common.CollateralIssuerType>create(cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeSpecialPurposeVehicleSubType.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralIssuerType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralIssuerType> validator() {
		return new CollateralIssuerTypeValidator();
	}

	@Override
	public Validator<? super CollateralIssuerType> typeFormatValidator() {
		return new CollateralIssuerTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralIssuerType, Set<String>> onlyExistsValidator() {
		return new CollateralIssuerTypeOnlyExistsValidator();
	}
}
