package cdm.observable.asset.validation;

import cdm.observable.asset.OtherIndex;
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

public class OtherIndexTypeFormatValidator implements Validator<OtherIndex> {

	private List<ComparisonResult> getComparisonResults(OtherIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OtherIndex> validate(RosettaPath path, OtherIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OtherIndex", ValidationType.TYPE_FORMAT, "OtherIndex", path, "", error);
		}
		return success("OtherIndex", ValidationType.TYPE_FORMAT, "OtherIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherIndex", ValidationType.TYPE_FORMAT, "OtherIndex", path, "", res.getError());
				}
				return success("OtherIndex", ValidationType.TYPE_FORMAT, "OtherIndex", path, "");
			})
			.collect(toList());
	}

}
