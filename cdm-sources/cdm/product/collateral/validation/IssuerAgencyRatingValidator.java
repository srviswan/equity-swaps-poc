package cdm.product.collateral.validation;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.IssuerAgencyRating;
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

public class IssuerAgencyRatingValidator implements Validator<IssuerAgencyRating> {

	private List<ComparisonResult> getComparisonResults(IssuerAgencyRating o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerAgencyRating", (AgencyRatingCriteria) o.getIssuerAgencyRating() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<IssuerAgencyRating> validate(RosettaPath path, IssuerAgencyRating o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerAgencyRating", ValidationType.CARDINALITY, "IssuerAgencyRating", path, "", error);
		}
		return success("IssuerAgencyRating", ValidationType.CARDINALITY, "IssuerAgencyRating", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerAgencyRating o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerAgencyRating", ValidationType.CARDINALITY, "IssuerAgencyRating", path, "", res.getError());
				}
				return success("IssuerAgencyRating", ValidationType.CARDINALITY, "IssuerAgencyRating", path, "");
			})
			.collect(toList());
	}

}
