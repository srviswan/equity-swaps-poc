package cdm.observable.asset.validation;

import cdm.observable.asset.CreditIndex;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditIndexTypeFormatValidator implements Validator<CreditIndex> {

	private List<ComparisonResult> getComparisonResults(CreditIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("indexSeries", o.getIndexSeries(), empty(), of(0), empty(), empty()), 
				checkNumber("indexAnnexVersion", o.getIndexAnnexVersion(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditIndex", ValidationType.TYPE_FORMAT, "CreditIndex", path, "", error);
		}
		return success("CreditIndex", ValidationType.TYPE_FORMAT, "CreditIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditIndex", ValidationType.TYPE_FORMAT, "CreditIndex", path, "", res.getError());
				}
				return success("CreditIndex", ValidationType.TYPE_FORMAT, "CreditIndex", path, "");
			})
			.collect(toList());
	}

}
