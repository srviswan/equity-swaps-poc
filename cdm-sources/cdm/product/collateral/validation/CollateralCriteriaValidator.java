package cdm.product.collateral.validation;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.observable.asset.Index;
import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.AssetAgencyRating;
import cdm.product.collateral.AssetCountryOfOrigin;
import cdm.product.collateral.AssetMaturity;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CounterpartyOwnIssuePermitted;
import cdm.product.collateral.DomesticCurrencyIssued;
import cdm.product.collateral.IssuerAgencyRating;
import cdm.product.collateral.IssuerCountryOfOrigin;
import cdm.product.collateral.IssuerName;
import cdm.product.collateral.ListingExchange;
import cdm.product.collateral.ListingSector;
import cdm.product.collateral.NegativeCriteria;
import cdm.product.collateral.SovereignAgencyRating;
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

public class CollateralCriteriaValidator implements Validator<CollateralCriteria> {

	private List<ComparisonResult> getComparisonResults(CollateralCriteria o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("AllCriteria", (AllCriteria) o.getAllCriteria() != null ? 1 : 0, 0, 1), 
				checkCardinality("AnyCriteria", (AnyCriteria) o.getAnyCriteria() != null ? 1 : 0, 0, 1), 
				checkCardinality("NegativeCriteria", (NegativeCriteria) o.getNegativeCriteria() != null ? 1 : 0, 0, 1), 
				checkCardinality("CollateralIssuerType", (CollateralIssuerType) o.getCollateralIssuerType() != null ? 1 : 0, 0, 1), 
				checkCardinality("AssetType", (AssetType) o.getAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("IssuerCountryOfOrigin", (IssuerCountryOfOrigin) o.getIssuerCountryOfOrigin() != null ? 1 : 0, 0, 1), 
				checkCardinality("AssetCountryOfOrigin", (AssetCountryOfOrigin) o.getAssetCountryOfOrigin() != null ? 1 : 0, 0, 1), 
				checkCardinality("CurrencyCodeEnum", (CurrencyCodeEnum) o.getCurrencyCodeEnum() != null ? 1 : 0, 0, 1), 
				checkCardinality("IssuerName", (IssuerName) o.getIssuerName() != null ? 1 : 0, 0, 1), 
				checkCardinality("IssuerAgencyRating", (IssuerAgencyRating) o.getIssuerAgencyRating() != null ? 1 : 0, 0, 1), 
				checkCardinality("SovereignAgencyRating", (SovereignAgencyRating) o.getSovereignAgencyRating() != null ? 1 : 0, 0, 1), 
				checkCardinality("AssetAgencyRating", (AssetAgencyRating) o.getAssetAgencyRating() != null ? 1 : 0, 0, 1), 
				checkCardinality("AssetMaturity", (AssetMaturity) o.getAssetMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("SpecificAsset", (SpecificAsset) o.getSpecificAsset() != null ? 1 : 0, 0, 1), 
				checkCardinality("CollateralTaxonomy", (CollateralTaxonomy) o.getCollateralTaxonomy() != null ? 1 : 0, 0, 1), 
				checkCardinality("ListingExchange", (ListingExchange) o.getListingExchange() != null ? 1 : 0, 0, 1), 
				checkCardinality("ListingSector", (ListingSector) o.getListingSector() != null ? 1 : 0, 0, 1), 
				checkCardinality("Index", (Index) o.getIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("CounterpartyOwnIssuePermitted", (CounterpartyOwnIssuePermitted) o.getCounterpartyOwnIssuePermitted() != null ? 1 : 0, 0, 1), 
				checkCardinality("DomesticCurrencyIssued", (DomesticCurrencyIssued) o.getDomesticCurrencyIssued() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CollateralCriteria> validate(RosettaPath path, CollateralCriteria o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CollateralCriteria", ValidationType.CARDINALITY, "CollateralCriteria", path, "", error);
		}
		return success("CollateralCriteria", ValidationType.CARDINALITY, "CollateralCriteria", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralCriteria o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralCriteria", ValidationType.CARDINALITY, "CollateralCriteria", path, "", res.getError());
				}
				return success("CollateralCriteria", ValidationType.CARDINALITY, "CollateralCriteria", path, "");
			})
			.collect(toList());
	}

}
