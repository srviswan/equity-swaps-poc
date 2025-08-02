package cdm.product.collateral.meta;

import cdm.product.collateral.DomesticCurrencyIssued;
import cdm.product.collateral.validation.DomesticCurrencyIssuedTypeFormatValidator;
import cdm.product.collateral.validation.DomesticCurrencyIssuedValidator;
import cdm.product.collateral.validation.exists.DomesticCurrencyIssuedOnlyExistsValidator;
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
@RosettaMeta(model=DomesticCurrencyIssued.class)
public class DomesticCurrencyIssuedMeta implements RosettaMetaData<DomesticCurrencyIssued> {

	@Override
	public List<Validator<? super DomesticCurrencyIssued>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DomesticCurrencyIssued, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DomesticCurrencyIssued> validator() {
		return new DomesticCurrencyIssuedValidator();
	}

	@Override
	public Validator<? super DomesticCurrencyIssued> typeFormatValidator() {
		return new DomesticCurrencyIssuedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DomesticCurrencyIssued, Set<String>> onlyExistsValidator() {
		return new DomesticCurrencyIssuedOnlyExistsValidator();
	}
}
