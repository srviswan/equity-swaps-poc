package cdm.product.template.validation;

import cdm.product.template.TransferableProduct;
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

public class TransferableProductTypeFormatValidator implements Validator<TransferableProduct> {

	private List<ComparisonResult> getComparisonResults(TransferableProduct o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TransferableProduct> validate(RosettaPath path, TransferableProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransferableProduct", ValidationType.TYPE_FORMAT, "TransferableProduct", path, "", error);
		}
		return success("TransferableProduct", ValidationType.TYPE_FORMAT, "TransferableProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransferableProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransferableProduct", ValidationType.TYPE_FORMAT, "TransferableProduct", path, "", res.getError());
				}
				return success("TransferableProduct", ValidationType.TYPE_FORMAT, "TransferableProduct", path, "");
			})
			.collect(toList());
	}

}
