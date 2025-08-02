package cdm.observable.asset.validation;

import cdm.observable.asset.ForeignExchangeRateIndex;
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

public class ForeignExchangeRateIndexTypeFormatValidator implements Validator<ForeignExchangeRateIndex> {

	private List<ComparisonResult> getComparisonResults(ForeignExchangeRateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ForeignExchangeRateIndex> validate(RosettaPath path, ForeignExchangeRateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ForeignExchangeRateIndex", ValidationType.TYPE_FORMAT, "ForeignExchangeRateIndex", path, "", error);
		}
		return success("ForeignExchangeRateIndex", ValidationType.TYPE_FORMAT, "ForeignExchangeRateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForeignExchangeRateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ForeignExchangeRateIndex", ValidationType.TYPE_FORMAT, "ForeignExchangeRateIndex", path, "", res.getError());
				}
				return success("ForeignExchangeRateIndex", ValidationType.TYPE_FORMAT, "ForeignExchangeRateIndex", path, "");
			})
			.collect(toList());
	}

}
