package cdm.observable.asset.validation;

import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Basket;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
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

public class BasketValidator implements Validator<Basket> {

	private List<ComparisonResult> getComparisonResults(Basket o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends AssetIdentifier>) o.getIdentifier() == null ? 0 : o.getIdentifier().size(), 1, 0), 
				checkCardinality("isExchangeListed", (Boolean) o.getIsExchangeListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchange", (LegalEntity) o.getExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("basketConstituent", (List<? extends FieldWithMetaBasketConstituent>) o.getBasketConstituent() == null ? 0 : o.getBasketConstituent().size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Basket> validate(RosettaPath path, Basket o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Basket", ValidationType.CARDINALITY, "Basket", path, "", error);
		}
		return success("Basket", ValidationType.CARDINALITY, "Basket", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Basket o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Basket", ValidationType.CARDINALITY, "Basket", path, "", res.getError());
				}
				return success("Basket", ValidationType.CARDINALITY, "Basket", path, "");
			})
			.collect(toList());
	}

}
