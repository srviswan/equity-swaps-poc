package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.InstrumentBase;
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

public class InstrumentBaseTypeFormatValidator implements Validator<InstrumentBase> {

	private List<ComparisonResult> getComparisonResults(InstrumentBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InstrumentBase> validate(RosettaPath path, InstrumentBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentBase", ValidationType.TYPE_FORMAT, "InstrumentBase", path, "", error);
		}
		return success("InstrumentBase", ValidationType.TYPE_FORMAT, "InstrumentBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentBase", ValidationType.TYPE_FORMAT, "InstrumentBase", path, "", res.getError());
				}
				return success("InstrumentBase", ValidationType.TYPE_FORMAT, "InstrumentBase", path, "");
			})
			.collect(toList());
	}

}
