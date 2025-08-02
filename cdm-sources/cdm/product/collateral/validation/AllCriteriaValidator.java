package cdm.product.collateral.validation;

import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.CollateralCriteria;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AllCriteriaValidator implements Validator<AllCriteria> {

	private List<ComparisonResult> getComparisonResults(AllCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("allCriteria", (List<? extends CollateralCriteria>) o.getAllCriteria() == null ? 0 : o.getAllCriteria().size(), 2, 0)
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
			return failure("AllCriteria", ValidationType.CARDINALITY, "AllCriteria", path, "", error);
		}
		return success("AllCriteria", ValidationType.CARDINALITY, "AllCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AllCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AllCriteria", ValidationType.CARDINALITY, "AllCriteria", path, "", res.getError());
				}
				return success("AllCriteria", ValidationType.CARDINALITY, "AllCriteria", path, "");
			})
			.collect(toList());
	}

}
