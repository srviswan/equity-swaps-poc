package cdm.product.template.validation;

import cdm.product.template.ExerciseTerms;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExerciseTermsTypeFormatValidator implements Validator<ExerciseTerms> {

	private List<ComparisonResult> getComparisonResults(ExerciseTerms o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ExerciseTerms> validate(RosettaPath path, ExerciseTerms o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExerciseTerms", ValidationType.TYPE_FORMAT, "ExerciseTerms", path, "", error);
		}
		return success("ExerciseTerms", ValidationType.TYPE_FORMAT, "ExerciseTerms", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExerciseTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExerciseTerms", ValidationType.TYPE_FORMAT, "ExerciseTerms", path, "", res.getError());
				}
				return success("ExerciseTerms", ValidationType.TYPE_FORMAT, "ExerciseTerms", path, "");
			})
			.collect(toList());
	}

}
