package cdm.observable.asset.validation;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
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

public class InterestRateIndexValidator implements Validator<InterestRateIndex> {

	private List<ComparisonResult> getComparisonResults(InterestRateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("FloatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("InflationIndex", (InflationIndex) o.getInflationIndex() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InterestRateIndex> validate(RosettaPath path, InterestRateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestRateIndex", ValidationType.CARDINALITY, "InterestRateIndex", path, "", error);
		}
		return success("InterestRateIndex", ValidationType.CARDINALITY, "InterestRateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateIndex", ValidationType.CARDINALITY, "InterestRateIndex", path, "", res.getError());
				}
				return success("InterestRateIndex", ValidationType.CARDINALITY, "InterestRateIndex", path, "");
			})
			.collect(toList());
	}

}
