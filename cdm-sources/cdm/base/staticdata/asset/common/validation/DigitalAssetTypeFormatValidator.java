package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.DigitalAsset;
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

public class DigitalAssetTypeFormatValidator implements Validator<DigitalAsset> {

	private List<ComparisonResult> getComparisonResults(DigitalAsset o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DigitalAsset> validate(RosettaPath path, DigitalAsset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DigitalAsset", ValidationType.TYPE_FORMAT, "DigitalAsset", path, "", error);
		}
		return success("DigitalAsset", ValidationType.TYPE_FORMAT, "DigitalAsset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DigitalAsset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DigitalAsset", ValidationType.TYPE_FORMAT, "DigitalAsset", path, "", res.getError());
				}
				return success("DigitalAsset", ValidationType.TYPE_FORMAT, "DigitalAsset", path, "");
			})
			.collect(toList());
	}

}
