package cdm.product.collateral.validation;

import cdm.base.datetime.PeriodRange;
import cdm.base.staticdata.asset.common.MaturityTypeEnum;
import cdm.product.collateral.AssetMaturity;
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

public class AssetMaturityValidator implements Validator<AssetMaturity> {

	private List<ComparisonResult> getComparisonResults(AssetMaturity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("maturityType", (MaturityTypeEnum) o.getMaturityType() != null ? 1 : 0, 1, 1), 
				checkCardinality("maturityRange", (PeriodRange) o.getMaturityRange() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AssetMaturity> validate(RosettaPath path, AssetMaturity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AssetMaturity", ValidationType.CARDINALITY, "AssetMaturity", path, "", error);
		}
		return success("AssetMaturity", ValidationType.CARDINALITY, "AssetMaturity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetMaturity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AssetMaturity", ValidationType.CARDINALITY, "AssetMaturity", path, "", res.getError());
				}
				return success("AssetMaturity", ValidationType.CARDINALITY, "AssetMaturity", path, "");
			})
			.collect(toList());
	}

}
