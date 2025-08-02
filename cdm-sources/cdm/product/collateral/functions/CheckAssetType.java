package cdm.product.collateral.functions;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.AssetTypeEnum;
import cdm.base.staticdata.asset.common.DebtClassEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.product.collateral.EligibilityQuery;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckAssetType.CheckAssetTypeDefault.class)
public abstract class CheckAssetType implements RosettaFunction {

	/**
	* @param collateralAssetTypes 
	* @param query 
	* @return isEqual 
	*/
	public Boolean evaluate(AssetType collateralAssetTypes, EligibilityQuery query) {
		Boolean isEqual = doEvaluate(collateralAssetTypes, query);
		
		return isEqual;
	}

	protected abstract Boolean doEvaluate(AssetType collateralAssetTypes, EligibilityQuery query);

	public static class CheckAssetTypeDefault extends CheckAssetType {
		@Override
		protected Boolean doEvaluate(AssetType collateralAssetTypes, EligibilityQuery query) {
			Boolean isEqual = null;
			return assignOutput(isEqual, collateralAssetTypes, query);
		}
		
		protected Boolean assignOutput(Boolean isEqual, AssetType collateralAssetTypes, EligibilityQuery query) {
			final MapperS<AssetType> thenArg0 = MapperS.of(collateralAssetTypes);
			final MapperS<AssetType> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(item.<AssetTypeEnum>map("getAssetType", assetType -> assetType.getAssetType()), MapperS.of(query).<AssetType>map("getCollateralAssetType", eligibilityQuery -> eligibilityQuery.getCollateralAssetType()).<AssetTypeEnum>map("getAssetType", assetType -> assetType.getAssetType()), CardinalityOperator.All).get());
			final MapperS<AssetType> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> notExists(item.<DebtType>map("getDebtType", assetType -> assetType.getDebtType())).or(areEqual(item.<DebtType>map("getDebtType", assetType -> assetType.getDebtType()).<DebtClassEnum>map("getDebtClass", debtType -> debtType.getDebtClass()), MapperS.of(query).<AssetType>map("getCollateralAssetType", eligibilityQuery -> eligibilityQuery.getCollateralAssetType()).<DebtType>map("getDebtType", assetType -> assetType.getDebtType()).<DebtClassEnum>map("getDebtClass", debtType -> debtType.getDebtClass()), CardinalityOperator.All)).get());
			final MapperS<AssetType> thenArg3 = thenArg2
				.filterSingleNullSafe(item -> notExists(item.<InstrumentTypeEnum>map("getSecurityType", assetType -> assetType.getSecurityType())).or(areEqual(item.<InstrumentTypeEnum>map("getSecurityType", assetType -> assetType.getSecurityType()), MapperS.of(query).<AssetType>map("getCollateralAssetType", eligibilityQuery -> eligibilityQuery.getCollateralAssetType()).<InstrumentTypeEnum>map("getSecurityType", assetType -> assetType.getSecurityType()), CardinalityOperator.All)).get());
			isEqual = notExists(MapperS.of(collateralAssetTypes)).or(ComparisonResult.of(exists(thenArg3).asMapper())).get();
			
			return isEqual;
		}
	}
}
