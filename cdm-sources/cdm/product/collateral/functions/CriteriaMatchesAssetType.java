package cdm.product.collateral.functions;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.NegativeCriteria;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CriteriaMatchesAssetType.CriteriaMatchesAssetTypeDefault.class)
public abstract class CriteriaMatchesAssetType implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected cdm.product.collateral.functions.CriteriaMatchesAssetType criteriaMatchesAssetType;

	/**
	* @param inputCriteria 
	* @param assetType 
	* @return matches 
	*/
	public Boolean evaluate(CollateralCriteria inputCriteria, InstrumentTypeEnum assetType) {
		Boolean matches = doEvaluate(inputCriteria, assetType);
		
		return matches;
	}

	protected abstract Boolean doEvaluate(CollateralCriteria inputCriteria, InstrumentTypeEnum assetType);

	public static class CriteriaMatchesAssetTypeDefault extends CriteriaMatchesAssetType {
		@Override
		protected Boolean doEvaluate(CollateralCriteria inputCriteria, InstrumentTypeEnum assetType) {
			Boolean matches = null;
			return assignOutput(matches, inputCriteria, assetType);
		}
		
		protected Boolean assignOutput(Boolean matches, CollateralCriteria inputCriteria, InstrumentTypeEnum assetType0) {
			matches = false;
			
			final MapperS<CollateralCriteria> switchArgument = MapperS.of(inputCriteria);
			if (switchArgument.get() == null) {
				matches = null;
			} else if (switchArgument.<AssetType>map("getAssetType", collateralCriteria -> collateralCriteria.getAssetType()).get() != null) {
				final MapperS<AssetType> assetType1 = switchArgument.<AssetType>map("getAssetType", collateralCriteria -> collateralCriteria.getAssetType());
				matches = areEqual(assetType1.<InstrumentTypeEnum>map("getSecurityType", assetType -> assetType.getSecurityType()), MapperS.of(assetType0), CardinalityOperator.All).get();
			} else if (switchArgument.<AllCriteria>map("getAllCriteria", collateralCriteria -> collateralCriteria.getAllCriteria()).get() != null) {
				final MapperS<AllCriteria> allCriteria = switchArgument.<AllCriteria>map("getAllCriteria", collateralCriteria -> collateralCriteria.getAllCriteria());
				final MapperC<Boolean> thenArg1 = allCriteria.<CollateralCriteria>mapC("getAllCriteria", _allCriteria -> _allCriteria.getAllCriteria())
					.mapItem(item -> MapperS.of(criteriaMatchesAssetType.evaluate(item.get(), assetType0)));
				matches = areEqual(thenArg1, MapperS.of(true), CardinalityOperator.All).asMapper().get();
			} else if (switchArgument.<AnyCriteria>map("getAnyCriteria", collateralCriteria -> collateralCriteria.getAnyCriteria()).get() != null) {
				final MapperS<AnyCriteria> anyCriteria = switchArgument.<AnyCriteria>map("getAnyCriteria", collateralCriteria -> collateralCriteria.getAnyCriteria());
				final MapperC<Boolean> thenArg0 = anyCriteria.<CollateralCriteria>mapC("getAnyCriteria", _anyCriteria -> _anyCriteria.getAnyCriteria())
					.mapItem(item -> MapperS.of(criteriaMatchesAssetType.evaluate(item.get(), assetType0)));
				matches = areEqual(thenArg0, MapperS.of(true), CardinalityOperator.Any).asMapper().get();
			} else if (switchArgument.<NegativeCriteria>map("getNegativeCriteria", collateralCriteria -> collateralCriteria.getNegativeCriteria()).get() != null) {
				final MapperS<NegativeCriteria> negativeCriteria = switchArgument.<NegativeCriteria>map("getNegativeCriteria", collateralCriteria -> collateralCriteria.getNegativeCriteria());
				matches = areEqual(MapperS.of(criteriaMatchesAssetType.evaluate(negativeCriteria.<CollateralCriteria>map("getNegativeCriteria", _negativeCriteria -> _negativeCriteria.getNegativeCriteria()).get(), assetType0)), MapperS.of(false), CardinalityOperator.All).get();
			} else {
				matches = false;
			}
			
			return matches;
		}
	}
}
