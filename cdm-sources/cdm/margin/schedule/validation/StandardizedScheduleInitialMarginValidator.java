package cdm.margin.schedule.validation;

import cdm.margin.schedule.StandardizedScheduleInitialMargin;
import cdm.observable.asset.Money;
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

public class StandardizedScheduleInitialMarginValidator implements Validator<StandardizedScheduleInitialMargin> {

	private List<ComparisonResult> getComparisonResults(StandardizedScheduleInitialMargin o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("netInitialMargin", (Money) o.getNetInitialMargin() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<StandardizedScheduleInitialMargin> validate(RosettaPath path, StandardizedScheduleInitialMargin o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StandardizedScheduleInitialMargin", ValidationType.CARDINALITY, "StandardizedScheduleInitialMargin", path, "", error);
		}
		return success("StandardizedScheduleInitialMargin", ValidationType.CARDINALITY, "StandardizedScheduleInitialMargin", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardizedScheduleInitialMargin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StandardizedScheduleInitialMargin", ValidationType.CARDINALITY, "StandardizedScheduleInitialMargin", path, "", res.getError());
				}
				return success("StandardizedScheduleInitialMargin", ValidationType.CARDINALITY, "StandardizedScheduleInitialMargin", path, "");
			})
			.collect(toList());
	}

}
