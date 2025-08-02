package cdm.product.collateral.functions;

import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import cdm.product.collateral.EligibilityQuery;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckDenominatedCurrency.CheckDenominatedCurrencyDefault.class)
public abstract class CheckDenominatedCurrency implements RosettaFunction {

	/**
	* @param denominatedCurrency 
	* @param query 
	* @return isEqual 
	*/
	public Boolean evaluate(CurrencyCodeEnum denominatedCurrency, EligibilityQuery query) {
		Boolean isEqual = doEvaluate(denominatedCurrency, query);
		
		return isEqual;
	}

	protected abstract Boolean doEvaluate(CurrencyCodeEnum denominatedCurrency, EligibilityQuery query);

	public static class CheckDenominatedCurrencyDefault extends CheckDenominatedCurrency {
		@Override
		protected Boolean doEvaluate(CurrencyCodeEnum denominatedCurrency, EligibilityQuery query) {
			Boolean isEqual = null;
			return assignOutput(isEqual, denominatedCurrency, query);
		}
		
		protected Boolean assignOutput(Boolean isEqual, CurrencyCodeEnum denominatedCurrency, EligibilityQuery query) {
			isEqual = notExists(MapperS.of(denominatedCurrency)).or(contains(MapperS.of(denominatedCurrency), MapperS.of(query).<CurrencyCodeEnum>map("getDenominatedCurrency", eligibilityQuery -> eligibilityQuery.getDenominatedCurrency()))).get();
			
			return isEqual;
		}
	}
}
