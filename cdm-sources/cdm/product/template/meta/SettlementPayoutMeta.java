package cdm.product.template.meta;

import cdm.product.template.SettlementPayout;
import cdm.product.template.validation.SettlementPayoutTypeFormatValidator;
import cdm.product.template.validation.SettlementPayoutValidator;
import cdm.product.template.validation.exists.SettlementPayoutOnlyExistsValidator;
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
@RosettaMeta(model=SettlementPayout.class)
public class SettlementPayoutMeta implements RosettaMetaData<SettlementPayout> {

	@Override
	public List<Validator<? super SettlementPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.common.settlement.PayoutBase>create(cdm.product.common.settlement.validation.datarule.PayoutBaseFinalPrincipalAmountExists.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutUnderlier.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutBasket.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutIndex.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutSettlementTerms.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutDeliveryCapacity.class),
			factory.<cdm.product.template.SettlementPayout>create(cdm.product.template.validation.datarule.SettlementPayoutPriceTimeIntervalQuantity.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementPayout> validator() {
		return new SettlementPayoutValidator();
	}

	@Override
	public Validator<? super SettlementPayout> typeFormatValidator() {
		return new SettlementPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPayout, Set<String>> onlyExistsValidator() {
		return new SettlementPayoutOnlyExistsValidator();
	}
}
