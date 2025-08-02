package cdm.product.collateral.functions;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.AssetAgencyRating;
import cdm.product.collateral.AssetCountryOfOrigin;
import cdm.product.collateral.AssetMaturity;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.EligibilityQuery;
import cdm.product.collateral.IssuerAgencyRating;
import cdm.product.collateral.IssuerCountryOfOrigin;
import cdm.product.collateral.IssuerName;
import cdm.product.collateral.NegativeCriteria;
import cdm.product.collateral.SovereignAgencyRating;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckCriteria.CheckCriteriaDefault.class)
public abstract class CheckCriteria implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CheckAgencyRating checkAgencyRating;
	@Inject protected CheckAssetType checkAssetType;
	@Inject protected CheckCountryOfOrigin checkCountryOfOrigin;
	@Inject protected cdm.product.collateral.functions.CheckCriteria checkCriteria;
	@Inject protected CheckDenominatedCurrency checkDenominatedCurrency;
	@Inject protected CheckIssuerName checkIssuerName;
	@Inject protected CheckIssuerType checkIssuerType;
	@Inject protected CheckMaturity checkMaturity;

	/**
	* @param inputCriteria 
	* @param query 
	* @return isEligible 
	*/
	public Boolean evaluate(CollateralCriteria inputCriteria, EligibilityQuery query) {
		Boolean isEligible = doEvaluate(inputCriteria, query);
		
		return isEligible;
	}

	protected abstract Boolean doEvaluate(CollateralCriteria inputCriteria, EligibilityQuery query);

	public static class CheckCriteriaDefault extends CheckCriteria {
		@Override
		protected Boolean doEvaluate(CollateralCriteria inputCriteria, EligibilityQuery query) {
			Boolean isEligible = null;
			return assignOutput(isEligible, inputCriteria, query);
		}
		
		protected Boolean assignOutput(Boolean isEligible, CollateralCriteria inputCriteria, EligibilityQuery query) {
			isEligible = false;
			
			final MapperS<CollateralCriteria> switchArgument = MapperS.of(inputCriteria);
			if (switchArgument.get() == null) {
				isEligible = null;
			} else if (switchArgument.<AllCriteria>map("getAllCriteria", collateralCriteria -> collateralCriteria.getAllCriteria()).get() != null) {
				final MapperS<AllCriteria> allCriteria = switchArgument.<AllCriteria>map("getAllCriteria", collateralCriteria -> collateralCriteria.getAllCriteria());
				final MapperC<Boolean> thenArg1 = allCriteria.<CollateralCriteria>mapC("getAllCriteria", _allCriteria -> _allCriteria.getAllCriteria())
					.mapItem(item -> MapperS.of(checkCriteria.evaluate(item.get(), query)));
				isEligible = areEqual(thenArg1, MapperS.of(true), CardinalityOperator.All).asMapper().get();
			} else if (switchArgument.<AnyCriteria>map("getAnyCriteria", collateralCriteria -> collateralCriteria.getAnyCriteria()).get() != null) {
				final MapperS<AnyCriteria> anyCriteria = switchArgument.<AnyCriteria>map("getAnyCriteria", collateralCriteria -> collateralCriteria.getAnyCriteria());
				final MapperC<Boolean> thenArg0 = anyCriteria.<CollateralCriteria>mapC("getAnyCriteria", _anyCriteria -> _anyCriteria.getAnyCriteria())
					.mapItem(item -> MapperS.of(checkCriteria.evaluate(item.get(), query)));
				isEligible = areEqual(thenArg0, MapperS.of(true), CardinalityOperator.Any).asMapper().get();
			} else if (switchArgument.<NegativeCriteria>map("getNegativeCriteria", collateralCriteria -> collateralCriteria.getNegativeCriteria()).get() != null) {
				final MapperS<NegativeCriteria> negativeCriteria = switchArgument.<NegativeCriteria>map("getNegativeCriteria", collateralCriteria -> collateralCriteria.getNegativeCriteria());
				isEligible = areEqual(MapperS.of(checkCriteria.evaluate(negativeCriteria.<CollateralCriteria>map("getNegativeCriteria", _negativeCriteria -> _negativeCriteria.getNegativeCriteria()).get(), query)), MapperS.of(false), CardinalityOperator.All).get();
			} else if (switchArgument.<CollateralIssuerType>map("getCollateralIssuerType", collateralCriteria -> collateralCriteria.getCollateralIssuerType()).get() != null) {
				final MapperS<CollateralIssuerType> collateralIssuerType = switchArgument.<CollateralIssuerType>map("getCollateralIssuerType", collateralCriteria -> collateralCriteria.getCollateralIssuerType());
				isEligible = checkIssuerType.evaluate(collateralIssuerType.get(), query);
			} else if (switchArgument.<AssetType>map("getAssetType", collateralCriteria -> collateralCriteria.getAssetType()).get() != null) {
				final MapperS<AssetType> assetType = switchArgument.<AssetType>map("getAssetType", collateralCriteria -> collateralCriteria.getAssetType());
				isEligible = checkAssetType.evaluate(assetType.get(), query);
			} else if (switchArgument.<IssuerCountryOfOrigin>map("getIssuerCountryOfOrigin", collateralCriteria -> collateralCriteria.getIssuerCountryOfOrigin()).get() != null) {
				final MapperS<IssuerCountryOfOrigin> issuerCountryOfOrigin = switchArgument.<IssuerCountryOfOrigin>map("getIssuerCountryOfOrigin", collateralCriteria -> collateralCriteria.getIssuerCountryOfOrigin());
				isEligible = checkCountryOfOrigin.evaluate(issuerCountryOfOrigin.<ISOCountryCodeEnum>map("getIssuerCountryOfOrigin", _issuerCountryOfOrigin -> _issuerCountryOfOrigin.getIssuerCountryOfOrigin()).get(), query);
			} else if (switchArgument.<AssetCountryOfOrigin>map("getAssetCountryOfOrigin", collateralCriteria -> collateralCriteria.getAssetCountryOfOrigin()).get() != null) {
				final MapperS<AssetCountryOfOrigin> assetCountryOfOrigin = switchArgument.<AssetCountryOfOrigin>map("getAssetCountryOfOrigin", collateralCriteria -> collateralCriteria.getAssetCountryOfOrigin());
				isEligible = checkCountryOfOrigin.evaluate(assetCountryOfOrigin.<ISOCountryCodeEnum>map("getAssetCountryOfOrigin", _assetCountryOfOrigin -> _assetCountryOfOrigin.getAssetCountryOfOrigin()).get(), query);
			} else if (switchArgument.<CurrencyCodeEnum>map("getCurrencyCodeEnum", collateralCriteria -> collateralCriteria.getCurrencyCodeEnum()).get() != null) {
				final MapperS<CurrencyCodeEnum> currencyCodeEnum = switchArgument.<CurrencyCodeEnum>map("getCurrencyCodeEnum", collateralCriteria -> collateralCriteria.getCurrencyCodeEnum());
				isEligible = checkDenominatedCurrency.evaluate(currencyCodeEnum.get(), query);
			} else if (switchArgument.<IssuerName>map("getIssuerName", collateralCriteria -> collateralCriteria.getIssuerName()).get() != null) {
				final MapperS<IssuerName> issuerName = switchArgument.<IssuerName>map("getIssuerName", collateralCriteria -> collateralCriteria.getIssuerName());
				isEligible = checkIssuerName.evaluate(issuerName.get(), query);
			} else if (switchArgument.<IssuerAgencyRating>map("getIssuerAgencyRating", collateralCriteria -> collateralCriteria.getIssuerAgencyRating()).get() != null) {
				final MapperS<IssuerAgencyRating> issuerAgencyRating = switchArgument.<IssuerAgencyRating>map("getIssuerAgencyRating", collateralCriteria -> collateralCriteria.getIssuerAgencyRating());
				isEligible = checkAgencyRating.evaluate(issuerAgencyRating.<AgencyRatingCriteria>map("getIssuerAgencyRating", _issuerAgencyRating -> _issuerAgencyRating.getIssuerAgencyRating()).get(), query);
			} else if (switchArgument.<SovereignAgencyRating>map("getSovereignAgencyRating", collateralCriteria -> collateralCriteria.getSovereignAgencyRating()).get() != null) {
				final MapperS<SovereignAgencyRating> sovereignAgencyRating = switchArgument.<SovereignAgencyRating>map("getSovereignAgencyRating", collateralCriteria -> collateralCriteria.getSovereignAgencyRating());
				isEligible = checkAgencyRating.evaluate(sovereignAgencyRating.<AgencyRatingCriteria>map("getSovereignAgencyRating", _sovereignAgencyRating -> _sovereignAgencyRating.getSovereignAgencyRating()).get(), query);
			} else if (switchArgument.<AssetAgencyRating>map("getAssetAgencyRating", collateralCriteria -> collateralCriteria.getAssetAgencyRating()).get() != null) {
				final MapperS<AssetAgencyRating> assetAgencyRating = switchArgument.<AssetAgencyRating>map("getAssetAgencyRating", collateralCriteria -> collateralCriteria.getAssetAgencyRating());
				isEligible = checkAgencyRating.evaluate(assetAgencyRating.<AgencyRatingCriteria>map("getAssetAgencyRating", _assetAgencyRating -> _assetAgencyRating.getAssetAgencyRating()).get(), query);
			} else if (switchArgument.<AssetMaturity>map("getAssetMaturity", collateralCriteria -> collateralCriteria.getAssetMaturity()).get() != null) {
				final MapperS<AssetMaturity> assetMaturity = switchArgument.<AssetMaturity>map("getAssetMaturity", collateralCriteria -> collateralCriteria.getAssetMaturity());
				isEligible = checkMaturity.evaluate(assetMaturity.get(), query);
			} else {
				isEligible = false;
			}
			
			return isEligible;
		}
	}
}
