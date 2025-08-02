package cdm.product.collateral.validation;

import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.product.collateral.SpecificAsset;
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

public class SpecificAssetValidator implements Validator<SpecificAsset> {

	private List<ComparisonResult> getComparisonResults(SpecificAsset o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Cash", (Cash) o.getCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("Commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("DigitalAsset", (DigitalAsset) o.getDigitalAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("Instrument", (Instrument) o.getInstrument() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SpecificAsset> validate(RosettaPath path, SpecificAsset o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SpecificAsset", ValidationType.CARDINALITY, "SpecificAsset", path, "", error);
		}
		return success("SpecificAsset", ValidationType.CARDINALITY, "SpecificAsset", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpecificAsset o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpecificAsset", ValidationType.CARDINALITY, "SpecificAsset", path, "", res.getError());
				}
				return success("SpecificAsset", ValidationType.CARDINALITY, "SpecificAsset", path, "");
			})
			.collect(toList());
	}

}
