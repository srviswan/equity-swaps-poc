package cdm.product.collateral.validation;

import cdm.product.collateral.IssuerCountryOfOrigin;
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

public class IssuerCountryOfOriginTypeFormatValidator implements Validator<IssuerCountryOfOrigin> {

	private List<ComparisonResult> getComparisonResults(IssuerCountryOfOrigin o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<IssuerCountryOfOrigin> validate(RosettaPath path, IssuerCountryOfOrigin o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerCountryOfOrigin", ValidationType.TYPE_FORMAT, "IssuerCountryOfOrigin", path, "", error);
		}
		return success("IssuerCountryOfOrigin", ValidationType.TYPE_FORMAT, "IssuerCountryOfOrigin", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerCountryOfOrigin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerCountryOfOrigin", ValidationType.TYPE_FORMAT, "IssuerCountryOfOrigin", path, "", res.getError());
				}
				return success("IssuerCountryOfOrigin", ValidationType.TYPE_FORMAT, "IssuerCountryOfOrigin", path, "");
			})
			.collect(toList());
	}

}
