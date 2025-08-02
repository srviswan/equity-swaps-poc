package cdm.product.collateral.validation;

import cdm.product.collateral.NegativeCriteria;
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

public class NegativeCriteriaTypeFormatValidator implements Validator<NegativeCriteria> {

	private List<ComparisonResult> getComparisonResults(NegativeCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NegativeCriteria> validate(RosettaPath path, NegativeCriteria o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NegativeCriteria", ValidationType.TYPE_FORMAT, "NegativeCriteria", path, "", error);
		}
		return success("NegativeCriteria", ValidationType.TYPE_FORMAT, "NegativeCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NegativeCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NegativeCriteria", ValidationType.TYPE_FORMAT, "NegativeCriteria", path, "", res.getError());
				}
				return success("NegativeCriteria", ValidationType.TYPE_FORMAT, "NegativeCriteria", path, "");
			})
			.collect(toList());
	}

}
