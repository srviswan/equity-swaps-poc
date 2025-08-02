package cdm.product.template.meta;

import cdm.product.template.TransferableProduct;
import cdm.product.template.validation.TransferableProductTypeFormatValidator;
import cdm.product.template.validation.TransferableProductValidator;
import cdm.product.template.validation.exists.TransferableProductOnlyExistsValidator;
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
@RosettaMeta(model=TransferableProduct.class)
public class TransferableProductMeta implements RosettaMetaData<TransferableProduct> {

	@Override
	public List<Validator<? super TransferableProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.base.staticdata.asset.common.Asset>create(cdm.base.staticdata.asset.common.validation.datarule.AssetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TransferableProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransferableProduct> validator() {
		return new TransferableProductValidator();
	}

	@Override
	public Validator<? super TransferableProduct> typeFormatValidator() {
		return new TransferableProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferableProduct, Set<String>> onlyExistsValidator() {
		return new TransferableProductOnlyExistsValidator();
	}
}
