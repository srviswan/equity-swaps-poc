package cdm.product.template.validation;

import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
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

public class NonTransferableProductValidator implements Validator<NonTransferableProduct> {

	private List<ComparisonResult> getComparisonResults(NonTransferableProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("economicTerms", (EconomicTerms) o.getEconomicTerms() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<NonTransferableProduct> validate(RosettaPath path, NonTransferableProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonTransferableProduct", ValidationType.CARDINALITY, "NonTransferableProduct", path, "", error);
		}
		return success("NonTransferableProduct", ValidationType.CARDINALITY, "NonTransferableProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonTransferableProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonTransferableProduct", ValidationType.CARDINALITY, "NonTransferableProduct", path, "", res.getError());
				}
				return success("NonTransferableProduct", ValidationType.CARDINALITY, "NonTransferableProduct", path, "");
			})
			.collect(toList());
	}

}
