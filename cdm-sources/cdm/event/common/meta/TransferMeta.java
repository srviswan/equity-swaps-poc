package cdm.event.common.meta;

import cdm.event.common.Transfer;
import cdm.event.common.validation.TransferTypeFormatValidator;
import cdm.event.common.validation.TransferValidator;
import cdm.event.common.validation.exists.TransferOnlyExistsValidator;
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
@RosettaMeta(model=Transfer.class)
public class TransferMeta implements RosettaMetaData<Transfer> {

	@Override
	public List<Validator<? super Transfer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.common.settlement.AssetFlowBase>create(cdm.product.common.settlement.validation.datarule.AssetFlowBaseQuantityUnitExists.class)
		);
	}
	
	@Override
	public List<Function<? super Transfer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Transfer> validator() {
		return new TransferValidator();
	}

	@Override
	public Validator<? super Transfer> typeFormatValidator() {
		return new TransferTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Transfer, Set<String>> onlyExistsValidator() {
		return new TransferOnlyExistsValidator();
	}
}
