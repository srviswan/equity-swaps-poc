package cdm.product.collateral.functions;

import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.CreditRatingAgencyEnum;
import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.EligibilityQuery;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckAgencyRating.CheckAgencyRatingDefault.class)
public abstract class CheckAgencyRating implements RosettaFunction {

	/**
	* @param agencyRatings 
	* @param query 
	* @return isEqual 
	*/
	public Boolean evaluate(AgencyRatingCriteria agencyRatings, EligibilityQuery query) {
		Boolean isEqual = doEvaluate(agencyRatings, query);
		
		return isEqual;
	}

	protected abstract Boolean doEvaluate(AgencyRatingCriteria agencyRatings, EligibilityQuery query);

	public static class CheckAgencyRatingDefault extends CheckAgencyRating {
		@Override
		protected Boolean doEvaluate(AgencyRatingCriteria agencyRatings, EligibilityQuery query) {
			Boolean isEqual = null;
			return assignOutput(isEqual, agencyRatings, query);
		}
		
		protected Boolean assignOutput(Boolean isEqual, AgencyRatingCriteria agencyRatings, EligibilityQuery query) {
			final MapperS<AgencyRatingCriteria> thenArg0 = MapperS.of(agencyRatings);
			final MapperS<AgencyRatingCriteria> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> contains(item.<CreditNotation>map("getCreditNotation", agencyRatingCriteria -> agencyRatingCriteria.getCreditNotation()).<FieldWithMetaString>map("getNotation", creditNotation -> creditNotation.getNotation()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of(query).<AgencyRatingCriteria>map("getAgencyRating", eligibilityQuery -> eligibilityQuery.getAgencyRating()).<CreditNotation>map("getCreditNotation", agencyRatingCriteria -> agencyRatingCriteria.getCreditNotation()).<FieldWithMetaString>map("getNotation", creditNotation -> creditNotation.getNotation()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue())).get());
			final MapperS<AgencyRatingCriteria> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> notExists(item.<CreditRatingAgencyEnum>map("getReferenceAgency", agencyRatingCriteria -> agencyRatingCriteria.getReferenceAgency())).or(areEqual(item.<CreditRatingAgencyEnum>map("getReferenceAgency", agencyRatingCriteria -> agencyRatingCriteria.getReferenceAgency()), MapperS.of(query).<AgencyRatingCriteria>map("getAgencyRating", eligibilityQuery -> eligibilityQuery.getAgencyRating()).<CreditRatingAgencyEnum>map("getReferenceAgency", agencyRatingCriteria -> agencyRatingCriteria.getReferenceAgency()), CardinalityOperator.All)).get());
			isEqual = notExists(MapperS.of(agencyRatings)).or(ComparisonResult.of(exists(thenArg2).asMapper())).get();
			
			return isEqual;
		}
	}
}
