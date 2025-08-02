package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ListedDerivative;
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

public class ListedDerivativeTypeFormatValidator implements Validator<ListedDerivative> {

	private List<ComparisonResult> getComparisonResults(ListedDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ListedDerivative> validate(RosettaPath path, ListedDerivative o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ListedDerivative", ValidationType.TYPE_FORMAT, "ListedDerivative", path, "", error);
		}
		return success("ListedDerivative", ValidationType.TYPE_FORMAT, "ListedDerivative", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListedDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListedDerivative", ValidationType.TYPE_FORMAT, "ListedDerivative", path, "", res.getError());
				}
				return success("ListedDerivative", ValidationType.TYPE_FORMAT, "ListedDerivative", path, "");
			})
			.collect(toList());
	}

}
