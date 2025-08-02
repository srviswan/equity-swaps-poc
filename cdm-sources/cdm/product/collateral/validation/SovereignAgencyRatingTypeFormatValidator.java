package cdm.product.collateral.validation;

import cdm.product.collateral.SovereignAgencyRating;
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

public class SovereignAgencyRatingTypeFormatValidator implements Validator<SovereignAgencyRating> {

	private List<ComparisonResult> getComparisonResults(SovereignAgencyRating o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SovereignAgencyRating> validate(RosettaPath path, SovereignAgencyRating o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SovereignAgencyRating", ValidationType.TYPE_FORMAT, "SovereignAgencyRating", path, "", error);
		}
		return success("SovereignAgencyRating", ValidationType.TYPE_FORMAT, "SovereignAgencyRating", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SovereignAgencyRating o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SovereignAgencyRating", ValidationType.TYPE_FORMAT, "SovereignAgencyRating", path, "", res.getError());
				}
				return success("SovereignAgencyRating", ValidationType.TYPE_FORMAT, "SovereignAgencyRating", path, "");
			})
			.collect(toList());
	}

}
