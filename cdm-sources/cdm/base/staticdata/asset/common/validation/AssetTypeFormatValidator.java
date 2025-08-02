package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Asset;
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

public class AssetTypeFormatValidator implements Validator<Asset> {

	private List<ComparisonResult> getComparisonResults(Asset o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Asset> validate(RosettaPath path, Asset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Asset", ValidationType.TYPE_FORMAT, "Asset", path, "", error);
		}
		return success("Asset", ValidationType.TYPE_FORMAT, "Asset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Asset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Asset", ValidationType.TYPE_FORMAT, "Asset", path, "", res.getError());
				}
				return success("Asset", ValidationType.TYPE_FORMAT, "Asset", path, "");
			})
			.collect(toList());
	}

}
