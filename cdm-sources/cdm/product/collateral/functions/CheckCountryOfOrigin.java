package cdm.product.collateral.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.EligibilityQuery;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckCountryOfOrigin.CheckCountryOfOriginDefault.class)
public abstract class CheckCountryOfOrigin implements RosettaFunction {

	/**
	* @param countryOfOrigin 
	* @param query 
	* @return isEqual 
	*/
	public Boolean evaluate(ISOCountryCodeEnum countryOfOrigin, EligibilityQuery query) {
		Boolean isEqual = doEvaluate(countryOfOrigin, query);
		
		return isEqual;
	}

	protected abstract Boolean doEvaluate(ISOCountryCodeEnum countryOfOrigin, EligibilityQuery query);

	public static class CheckCountryOfOriginDefault extends CheckCountryOfOrigin {
		@Override
		protected Boolean doEvaluate(ISOCountryCodeEnum countryOfOrigin, EligibilityQuery query) {
			Boolean isEqual = null;
			return assignOutput(isEqual, countryOfOrigin, query);
		}
		
		protected Boolean assignOutput(Boolean isEqual, ISOCountryCodeEnum countryOfOrigin, EligibilityQuery query) {
			isEqual = notExists(MapperS.of(countryOfOrigin)).or(contains(MapperS.of(countryOfOrigin), MapperS.of(query).<ISOCountryCodeEnum>map("getAssetCountryOfOrigin", eligibilityQuery -> eligibilityQuery.getAssetCountryOfOrigin()))).get();
			
			return isEqual;
		}
	}
}
