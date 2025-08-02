package cdm.observable.asset.validation;

import cdm.observable.asset.InflationIndex;
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

public class InflationIndexTypeFormatValidator implements Validator<InflationIndex> {

	private List<ComparisonResult> getComparisonResults(InflationIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InflationIndex> validate(RosettaPath path, InflationIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InflationIndex", ValidationType.TYPE_FORMAT, "InflationIndex", path, "", error);
		}
		return success("InflationIndex", ValidationType.TYPE_FORMAT, "InflationIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationIndex", ValidationType.TYPE_FORMAT, "InflationIndex", path, "", res.getError());
				}
				return success("InflationIndex", ValidationType.TYPE_FORMAT, "InflationIndex", path, "");
			})
			.collect(toList());
	}

}
