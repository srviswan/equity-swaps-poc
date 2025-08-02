package cdm.observable.asset.validation;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.CreditIndex;
import cdm.product.asset.CreditSeniorityEnum;
import cdm.product.asset.SettledEntityMatrix;
import cdm.product.asset.Tranche;
import cdm.product.asset.metafields.FieldWithMetaIndexAnnexSourceEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditIndexValidator implements Validator<CreditIndex> {

	private List<ComparisonResult> getComparisonResults(CreditIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", (List<? extends AssetIdentifier>) o.getIdentifier() == null ? 0 : o.getIdentifier().size(), 1, 0), 
				checkCardinality("isExchangeListed", (Boolean) o.getIsExchangeListed() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchange", (LegalEntity) o.getExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (FieldWithMetaString) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("provider", (LegalEntity) o.getProvider() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetClass", (AssetClassEnum) o.getAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSeries", (Integer) o.getIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexVersion", (Integer) o.getIndexAnnexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexDate", (Date) o.getIndexAnnexDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexSource", (FieldWithMetaIndexAnnexSourceEnum) o.getIndexAnnexSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("tranche", (Tranche) o.getTranche() != null ? 1 : 0, 0, 1), 
				checkCardinality("settledEntityMatrix", (SettledEntityMatrix) o.getSettledEntityMatrix() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniorityEnum) o.getSeniority() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditIndex> validate(RosettaPath path, CreditIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditIndex", ValidationType.CARDINALITY, "CreditIndex", path, "", error);
		}
		return success("CreditIndex", ValidationType.CARDINALITY, "CreditIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditIndex", ValidationType.CARDINALITY, "CreditIndex", path, "", res.getError());
				}
				return success("CreditIndex", ValidationType.CARDINALITY, "CreditIndex", path, "");
			})
			.collect(toList());
	}

}
