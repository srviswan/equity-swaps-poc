package cdm.observable.asset.validation;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.OtherIndex;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OtherIndexValidator implements Validator<OtherIndex> {

	private List<ComparisonResult> getComparisonResults(OtherIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends AssetIdentifier>) o.getIdentifier() == null ? 0 : o.getIdentifier().size(), 1, 0), 
				checkCardinality("isExchangeListed", (Boolean) o.getIsExchangeListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchange", (LegalEntity) o.getExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (FieldWithMetaString) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("provider", (LegalEntity) o.getProvider() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetClass", (AssetClassEnum) o.getAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OtherIndex> validate(RosettaPath path, OtherIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OtherIndex", ValidationType.CARDINALITY, "OtherIndex", path, "", error);
		}
		return success("OtherIndex", ValidationType.CARDINALITY, "OtherIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherIndex", ValidationType.CARDINALITY, "OtherIndex", path, "", res.getError());
				}
				return success("OtherIndex", ValidationType.CARDINALITY, "OtherIndex", path, "");
			})
			.collect(toList());
	}

}
