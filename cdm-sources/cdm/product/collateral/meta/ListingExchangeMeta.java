package cdm.product.collateral.meta;

import cdm.product.collateral.ListingExchange;
import cdm.product.collateral.validation.ListingExchangeTypeFormatValidator;
import cdm.product.collateral.validation.ListingExchangeValidator;
import cdm.product.collateral.validation.exists.ListingExchangeOnlyExistsValidator;
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
@RosettaMeta(model=ListingExchange.class)
public class ListingExchangeMeta implements RosettaMetaData<ListingExchange> {

	@Override
	public List<Validator<? super ListingExchange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ListingExchange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ListingExchange> validator() {
		return new ListingExchangeValidator();
	}

	@Override
	public Validator<? super ListingExchange> typeFormatValidator() {
		return new ListingExchangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ListingExchange, Set<String>> onlyExistsValidator() {
		return new ListingExchangeOnlyExistsValidator();
	}
}
