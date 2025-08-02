package cdm.product.collateral.validation;

import cdm.product.collateral.IssuerName;
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

public class IssuerNameTypeFormatValidator implements Validator<IssuerName> {

	private List<ComparisonResult> getComparisonResults(IssuerName o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<IssuerName> validate(RosettaPath path, IssuerName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerName", ValidationType.TYPE_FORMAT, "IssuerName", path, "", error);
		}
		return success("IssuerName", ValidationType.TYPE_FORMAT, "IssuerName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerName", ValidationType.TYPE_FORMAT, "IssuerName", path, "", res.getError());
				}
				return success("IssuerName", ValidationType.TYPE_FORMAT, "IssuerName", path, "");
			})
			.collect(toList());
	}

}
