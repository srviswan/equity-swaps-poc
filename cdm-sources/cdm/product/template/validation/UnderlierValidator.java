package cdm.product.template.validation;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
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

public class UnderlierValidator implements Validator<Underlier> {

	private List<ComparisonResult> getComparisonResults(Underlier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Observable", (ReferenceWithMetaObservable) o.getObservable() != null ? 1 : 0, 0, 1), 
				checkCardinality("Product", (Product) o.getProduct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Underlier> validate(RosettaPath path, Underlier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Underlier", ValidationType.CARDINALITY, "Underlier", path, "", error);
		}
		return success("Underlier", ValidationType.CARDINALITY, "Underlier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Underlier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Underlier", ValidationType.CARDINALITY, "Underlier", path, "", res.getError());
				}
				return success("Underlier", ValidationType.CARDINALITY, "Underlier", path, "");
			})
			.collect(toList());
	}

}
