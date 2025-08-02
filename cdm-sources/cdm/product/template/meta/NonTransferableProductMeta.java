package cdm.product.template.meta;

import cdm.product.template.NonTransferableProduct;
import cdm.product.template.validation.NonTransferableProductTypeFormatValidator;
import cdm.product.template.validation.NonTransferableProductValidator;
import cdm.product.template.validation.exists.NonTransferableProductOnlyExistsValidator;
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
@RosettaMeta(model=NonTransferableProduct.class)
public class NonTransferableProductMeta implements RosettaMetaData<NonTransferableProduct> {

	@Override
	public List<Validator<? super NonTransferableProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.template.NonTransferableProduct>create(cdm.product.template.validation.datarule.NonTransferableProductPrimaryAssetClass.class)
		);
	}
	
	@Override
	public List<Function<? super NonTransferableProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonTransferableProduct> validator() {
		return new NonTransferableProductValidator();
	}

	@Override
	public Validator<? super NonTransferableProduct> typeFormatValidator() {
		return new NonTransferableProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonTransferableProduct, Set<String>> onlyExistsValidator() {
		return new NonTransferableProductOnlyExistsValidator();
	}
}
