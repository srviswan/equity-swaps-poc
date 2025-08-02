package cdm.product.collateral.validation.exists;

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
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralCriteriaOnlyExistsValidator implements ValidatorWithArg<CollateralCriteria, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralCriteria> ValidationResult<CollateralCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("AllCriteria", ExistenceChecker.isSet((AllCriteria) o.getAllCriteria()))
				.put("AnyCriteria", ExistenceChecker.isSet((AnyCriteria) o.getAnyCriteria()))
				.put("NegativeCriteria", ExistenceChecker.isSet((NegativeCriteria) o.getNegativeCriteria()))
				.put("CollateralIssuerType", ExistenceChecker.isSet((CollateralIssuerType) o.getCollateralIssuerType()))
				.put("AssetType", ExistenceChecker.isSet((AssetType) o.getAssetType()))
				.put("IssuerCountryOfOrigin", ExistenceChecker.isSet((IssuerCountryOfOrigin) o.getIssuerCountryOfOrigin()))
				.put("AssetCountryOfOrigin", ExistenceChecker.isSet((AssetCountryOfOrigin) o.getAssetCountryOfOrigin()))
				.put("CurrencyCodeEnum", ExistenceChecker.isSet((CurrencyCodeEnum) o.getCurrencyCodeEnum()))
				.put("IssuerName", ExistenceChecker.isSet((IssuerName) o.getIssuerName()))
				.put("IssuerAgencyRating", ExistenceChecker.isSet((IssuerAgencyRating) o.getIssuerAgencyRating()))
				.put("SovereignAgencyRating", ExistenceChecker.isSet((SovereignAgencyRating) o.getSovereignAgencyRating()))
				.put("AssetAgencyRating", ExistenceChecker.isSet((AssetAgencyRating) o.getAssetAgencyRating()))
				.put("AssetMaturity", ExistenceChecker.isSet((AssetMaturity) o.getAssetMaturity()))
				.put("SpecificAsset", ExistenceChecker.isSet((SpecificAsset) o.getSpecificAsset()))
				.put("CollateralTaxonomy", ExistenceChecker.isSet((CollateralTaxonomy) o.getCollateralTaxonomy()))
				.put("ListingExchange", ExistenceChecker.isSet((ListingExchange) o.getListingExchange()))
				.put("ListingSector", ExistenceChecker.isSet((ListingSector) o.getListingSector()))
				.put("Index", ExistenceChecker.isSet((Index) o.getIndex()))
				.put("CounterpartyOwnIssuePermitted", ExistenceChecker.isSet((CounterpartyOwnIssuePermitted) o.getCounterpartyOwnIssuePermitted()))
				.put("DomesticCurrencyIssued", ExistenceChecker.isSet((DomesticCurrencyIssued) o.getDomesticCurrencyIssued()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralCriteria", ValidationType.ONLY_EXISTS, "CollateralCriteria", path, "");
		}
		return failure("CollateralCriteria", ValidationType.ONLY_EXISTS, "CollateralCriteria", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
