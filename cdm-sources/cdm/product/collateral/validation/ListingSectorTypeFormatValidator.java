package cdm.product.collateral.validation;

import cdm.product.collateral.ListingSector;
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

public class ListingSectorTypeFormatValidator implements Validator<ListingSector> {

	private List<ComparisonResult> getComparisonResults(ListingSector o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ListingSector> validate(RosettaPath path, ListingSector o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ListingSector", ValidationType.TYPE_FORMAT, "ListingSector", path, "", error);
		}
		return success("ListingSector", ValidationType.TYPE_FORMAT, "ListingSector", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListingSector o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListingSector", ValidationType.TYPE_FORMAT, "ListingSector", path, "", res.getError());
				}
				return success("ListingSector", ValidationType.TYPE_FORMAT, "ListingSector", path, "");
			})
			.collect(toList());
	}

}
