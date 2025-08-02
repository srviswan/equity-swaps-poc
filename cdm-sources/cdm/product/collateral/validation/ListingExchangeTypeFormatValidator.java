package cdm.product.collateral.validation;

import cdm.product.collateral.ListingExchange;
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

public class ListingExchangeTypeFormatValidator implements Validator<ListingExchange> {

	private List<ComparisonResult> getComparisonResults(ListingExchange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ListingExchange> validate(RosettaPath path, ListingExchange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ListingExchange", ValidationType.TYPE_FORMAT, "ListingExchange", path, "", error);
		}
		return success("ListingExchange", ValidationType.TYPE_FORMAT, "ListingExchange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ListingExchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ListingExchange", ValidationType.TYPE_FORMAT, "ListingExchange", path, "", res.getError());
				}
				return success("ListingExchange", ValidationType.TYPE_FORMAT, "ListingExchange", path, "");
			})
			.collect(toList());
	}

}
