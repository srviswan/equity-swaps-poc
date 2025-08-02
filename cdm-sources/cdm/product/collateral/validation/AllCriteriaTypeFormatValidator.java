package cdm.product.collateral.validation;

import cdm.product.collateral.AllCriteria;
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

public class AllCriteriaTypeFormatValidator implements Validator<AllCriteria> {

	private List<ComparisonResult> getComparisonResults(AllCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AllCriteria> validate(RosettaPath path, AllCriteria o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AllCriteria", ValidationType.TYPE_FORMAT, "AllCriteria", path, "", error);
		}
		return success("AllCriteria", ValidationType.TYPE_FORMAT, "AllCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AllCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AllCriteria", ValidationType.TYPE_FORMAT, "AllCriteria", path, "", res.getError());
				}
				return success("AllCriteria", ValidationType.TYPE_FORMAT, "AllCriteria", path, "");
			})
			.collect(toList());
	}

}
