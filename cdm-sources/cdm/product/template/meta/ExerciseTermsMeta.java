package cdm.product.template.meta;

import cdm.product.template.ExerciseTerms;
import cdm.product.template.validation.ExerciseTermsTypeFormatValidator;
import cdm.product.template.validation.ExerciseTermsValidator;
import cdm.product.template.validation.exists.ExerciseTermsOnlyExistsValidator;
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
@RosettaMeta(model=ExerciseTerms.class)
public class ExerciseTermsMeta implements RosettaMetaData<ExerciseTerms> {

	@Override
	public List<Validator<? super ExerciseTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsExerciseDateExpirationDateChoice.class),
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsCommencementAndExpirationDate.class),
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsAmericanExercise.class),
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsEuropeanExercise.class),
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsBermudaExercise.class),
			factory.<cdm.product.template.ExerciseTerms>create(cdm.product.template.validation.datarule.ExerciseTermsExpirationTimeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExerciseTerms> validator() {
		return new ExerciseTermsValidator();
	}

	@Override
	public Validator<? super ExerciseTerms> typeFormatValidator() {
		return new ExerciseTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseTerms, Set<String>> onlyExistsValidator() {
		return new ExerciseTermsOnlyExistsValidator();
	}
}
