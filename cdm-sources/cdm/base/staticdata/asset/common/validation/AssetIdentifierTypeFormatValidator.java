package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.AssetIdentifier;
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

public class AssetIdentifierTypeFormatValidator implements Validator<AssetIdentifier> {

	private List<ComparisonResult> getComparisonResults(AssetIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AssetIdentifier> validate(RosettaPath path, AssetIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AssetIdentifier", ValidationType.TYPE_FORMAT, "AssetIdentifier", path, "", error);
		}
		return success("AssetIdentifier", ValidationType.TYPE_FORMAT, "AssetIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetIdentifier", ValidationType.TYPE_FORMAT, "AssetIdentifier", path, "", res.getError());
				}
				return success("AssetIdentifier", ValidationType.TYPE_FORMAT, "AssetIdentifier", path, "");
			})
			.collect(toList());
	}

}
