package cdm.product.collateral.validation;

import cdm.product.collateral.AssetCountryOfOrigin;
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

public class AssetCountryOfOriginTypeFormatValidator implements Validator<AssetCountryOfOrigin> {

	private List<ComparisonResult> getComparisonResults(AssetCountryOfOrigin o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AssetCountryOfOrigin> validate(RosettaPath path, AssetCountryOfOrigin o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AssetCountryOfOrigin", ValidationType.TYPE_FORMAT, "AssetCountryOfOrigin", path, "", error);
		}
		return success("AssetCountryOfOrigin", ValidationType.TYPE_FORMAT, "AssetCountryOfOrigin", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetCountryOfOrigin o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetCountryOfOrigin", ValidationType.TYPE_FORMAT, "AssetCountryOfOrigin", path, "", res.getError());
				}
				return success("AssetCountryOfOrigin", ValidationType.TYPE_FORMAT, "AssetCountryOfOrigin", path, "");
			})
			.collect(toList());
	}

}
