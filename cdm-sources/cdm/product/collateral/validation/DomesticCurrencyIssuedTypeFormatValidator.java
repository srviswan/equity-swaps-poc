package cdm.product.collateral.validation;

import cdm.product.collateral.DomesticCurrencyIssued;
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

public class DomesticCurrencyIssuedTypeFormatValidator implements Validator<DomesticCurrencyIssued> {

	private List<ComparisonResult> getComparisonResults(DomesticCurrencyIssued o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DomesticCurrencyIssued> validate(RosettaPath path, DomesticCurrencyIssued o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DomesticCurrencyIssued", ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "", error);
		}
		return success("DomesticCurrencyIssued", ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DomesticCurrencyIssued o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DomesticCurrencyIssued", ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "", res.getError());
				}
				return success("DomesticCurrencyIssued", ValidationType.TYPE_FORMAT, "DomesticCurrencyIssued", path, "");
			})
			.collect(toList());
	}

}
