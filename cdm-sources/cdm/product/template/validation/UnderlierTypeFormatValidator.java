package cdm.product.template.validation;

import cdm.product.template.Underlier;
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

public class UnderlierTypeFormatValidator implements Validator<Underlier> {

	private List<ComparisonResult> getComparisonResults(Underlier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Underlier> validate(RosettaPath path, Underlier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Underlier", ValidationType.TYPE_FORMAT, "Underlier", path, "", error);
		}
		return success("Underlier", ValidationType.TYPE_FORMAT, "Underlier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Underlier", ValidationType.TYPE_FORMAT, "Underlier", path, "", res.getError());
				}
				return success("Underlier", ValidationType.TYPE_FORMAT, "Underlier", path, "");
			})
			.collect(toList());
	}

}
