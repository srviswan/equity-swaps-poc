package cdm.product.collateral.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.product.collateral.EligibilityQuery;
import cdm.product.collateral.IssuerName;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckIssuerName.CheckIssuerNameDefault.class)
public abstract class CheckIssuerName implements RosettaFunction {

	/**
	* @param issuerName 
	* @param query 
	* @return isEqual 
	*/
	public Boolean evaluate(IssuerName issuerName, EligibilityQuery query) {
		Boolean isEqual = doEvaluate(issuerName, query);
		
		return isEqual;
	}

	protected abstract Boolean doEvaluate(IssuerName issuerName, EligibilityQuery query);

	public static class CheckIssuerNameDefault extends CheckIssuerName {
		@Override
		protected Boolean doEvaluate(IssuerName issuerName, EligibilityQuery query) {
			Boolean isEqual = null;
			return assignOutput(isEqual, issuerName, query);
		}
		
		protected Boolean assignOutput(Boolean isEqual, IssuerName issuerName, EligibilityQuery query) {
			isEqual = notExists(MapperS.of(issuerName)).or(contains(MapperS.of(issuerName).<LegalEntity>map("getIssuerName", _issuerName -> _issuerName.getIssuerName()), MapperS.of(query).<LegalEntity>map("getIssuerName", eligibilityQuery -> eligibilityQuery.getIssuerName()))).get();
			
			return isEqual;
		}
	}
}
