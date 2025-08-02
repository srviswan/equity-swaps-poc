package cdm.product.template.validation.exists;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.BusinessCenterTime;
import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseFeeSchedule;
import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExpirationTimeTypeEnum;
import cdm.product.template.MultipleExercise;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.PartialExercise;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExerciseTermsOnlyExistsValidator implements ValidatorWithArg<ExerciseTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExerciseTerms> ValidationResult<ExerciseTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("style", ExistenceChecker.isSet((OptionExerciseStyleEnum) o.getStyle()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCommencementDate()))
				.put("exerciseDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getExerciseDates()))
				.put("expirationDate", ExistenceChecker.isSet((List<? extends AdjustableOrRelativeDate>) o.getExpirationDate()))
				.put("relevantUnderlyingDate", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getRelevantUnderlyingDate()))
				.put("earliestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getEarliestExerciseTime()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("expirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpirationTime()))
				.put("expirationTimeType", ExistenceChecker.isSet((ExpirationTimeTypeEnum) o.getExpirationTimeType()))
				.put("multipleExercise", ExistenceChecker.isSet((MultipleExercise) o.getMultipleExercise()))
				.put("exerciseFeeSchedule", ExistenceChecker.isSet((ExerciseFeeSchedule) o.getExerciseFeeSchedule()))
				.put("exerciseProcedure", ExistenceChecker.isSet((ExerciseProcedure) o.getExerciseProcedure()))
				.put("exerciseFee", ExistenceChecker.isSet((ExerciseFee) o.getExerciseFee()))
				.put("partialExercise", ExistenceChecker.isSet((PartialExercise) o.getPartialExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExerciseTerms", ValidationType.ONLY_EXISTS, "ExerciseTerms", path, "");
		}
		return failure("ExerciseTerms", ValidationType.ONLY_EXISTS, "ExerciseTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
