package cdm.product.collateral.validation;

import cdm.product.collateral.CollateralCriteria;
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

public class CollateralCriteriaTypeFormatValidator implements Validator<CollateralCriteria> {

	private List<ComparisonResult> getComparisonResults(CollateralCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<CollateralCriteria> validate(RosettaPath path, CollateralCriteria o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralCriteria", ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "", error);
		}
		return success("CollateralCriteria", ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralCriteria", ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "", res.getError());
				}
				return success("CollateralCriteria", ValidationType.TYPE_FORMAT, "CollateralCriteria", path, "");
			})
			.collect(toList());
	}

}
