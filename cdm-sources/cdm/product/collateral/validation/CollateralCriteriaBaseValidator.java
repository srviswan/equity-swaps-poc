package cdm.product.collateral.validation;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteriaBase;
import cdm.product.collateral.CollateralMarginTypeEnum;
import cdm.product.collateral.RatingPriorityResolutionEnum;
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

public class CollateralCriteriaBaseValidator implements Validator<CollateralCriteriaBase> {

	private List<ComparisonResult> getComparisonResults(CollateralCriteriaBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralCriteria", (CollateralCriteria) o.getCollateralCriteria() != null ? 1 : 0, 1, 1), 
				checkCardinality("appliesTo", (List<CounterpartyRoleEnum>) o.getAppliesTo() == null ? 0 : o.getAppliesTo().size(), 0, 2), 
				checkCardinality("restrictTo", (CollateralMarginTypeEnum) o.getRestrictTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("ratingPriorityResolution", (RatingPriorityResolutionEnum) o.getRatingPriorityResolution() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CollateralCriteriaBase> validate(RosettaPath path, CollateralCriteriaBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralCriteriaBase", ValidationType.CARDINALITY, "CollateralCriteriaBase", path, "", error);
		}
		return success("CollateralCriteriaBase", ValidationType.CARDINALITY, "CollateralCriteriaBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralCriteriaBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralCriteriaBase", ValidationType.CARDINALITY, "CollateralCriteriaBase", path, "", res.getError());
				}
				return success("CollateralCriteriaBase", ValidationType.CARDINALITY, "CollateralCriteriaBase", path, "");
			})
			.collect(toList());
	}

}
