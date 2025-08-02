package cdm.product.collateral.validation;

import cdm.product.collateral.AnyCriteria;
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

public class AnyCriteriaTypeFormatValidator implements Validator<AnyCriteria> {

	private List<ComparisonResult> getComparisonResults(AnyCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AnyCriteria> validate(RosettaPath path, AnyCriteria o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AnyCriteria", ValidationType.TYPE_FORMAT, "AnyCriteria", path, "", error);
		}
		return success("AnyCriteria", ValidationType.TYPE_FORMAT, "AnyCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnyCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnyCriteria", ValidationType.TYPE_FORMAT, "AnyCriteria", path, "", res.getError());
				}
				return success("AnyCriteria", ValidationType.TYPE_FORMAT, "AnyCriteria", path, "");
			})
			.collect(toList());
	}

}
