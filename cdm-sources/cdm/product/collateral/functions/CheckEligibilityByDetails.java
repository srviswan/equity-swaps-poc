package cdm.product.collateral.functions;

import cdm.product.collateral.CheckEligibilityResult;
import cdm.product.collateral.CheckEligibilityResult.CheckEligibilityResultBuilder;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.EligibilityQuery;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralSpecification;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CheckEligibilityByDetails.CheckEligibilityByDetailsDefault.class)
public abstract class CheckEligibilityByDetails implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CheckCriteria checkCriteria;

	/**
	* @param specification Specifications that determine which collateral meets the eligibility and can be used/posted for delivery. For ICMA usecase - this is the basket(s). For ISDA usecase these are the Eligibility Schedule Lists.
	* @param query The eligibility query defines the criteria to filter the specifications that will be used to find the eligibility result. For ICMA usecase - The asset infomation related to potential collateral available in your inventory you can use for the Repo trade. For ISDA - the questions related to the asset infomation you can post as collateral. For ICMA usecase - The issuer infomation related to the potential collateral available in your inventory you can use for the Repo trade. For ISDA - the questions related to the issuer infomation you can post as collateral.
	* @return eligibilityResult 
	*/
	public CheckEligibilityResult evaluate(EligibleCollateralSpecification specification, EligibilityQuery query) {
		CheckEligibilityResult.CheckEligibilityResultBuilder eligibilityResultBuilder = doEvaluate(specification, query);
		
		final CheckEligibilityResult eligibilityResult;
		if (eligibilityResultBuilder == null) {
			eligibilityResult = null;
		} else {
			eligibilityResult = eligibilityResultBuilder.build();
			objectValidator.validate(CheckEligibilityResult.class, eligibilityResult);
		}
		
		return eligibilityResult;
	}

	protected abstract CheckEligibilityResult.CheckEligibilityResultBuilder doEvaluate(EligibleCollateralSpecification specification, EligibilityQuery query);

	protected abstract MapperC<? extends EligibleCollateralCriteria> filteredCriteria(EligibleCollateralSpecification specification, EligibilityQuery query);

	protected abstract MapperC<? extends EligibleCollateralCriteria> checkedCriteria(EligibleCollateralSpecification specification, EligibilityQuery query);

	public static class CheckEligibilityByDetailsDefault extends CheckEligibilityByDetails {
		@Override
		protected CheckEligibilityResult.CheckEligibilityResultBuilder doEvaluate(EligibleCollateralSpecification specification, EligibilityQuery query) {
			CheckEligibilityResult.CheckEligibilityResultBuilder eligibilityResult = CheckEligibilityResult.builder();
			return assignOutput(eligibilityResult, specification, query);
		}
		
		protected CheckEligibilityResult.CheckEligibilityResultBuilder assignOutput(CheckEligibilityResult.CheckEligibilityResultBuilder eligibilityResult, EligibleCollateralSpecification specification, EligibilityQuery query) {
			eligibilityResult
				.setIsEligible(greaterThan(MapperS.of(checkedCriteria(specification, query).resultCount()), MapperS.of(0), CardinalityOperator.All).get());
			
			eligibilityResult
				.setEligibilityQuery(query);
			
			eligibilityResult
				.setSpecification(specification);
			
			eligibilityResult
				.addMatchingEligibleCriteria(checkedCriteria(specification, query).getMulti());
			
			return Optional.ofNullable(eligibilityResult)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends EligibleCollateralCriteria> filteredCriteria(EligibleCollateralSpecification specification, EligibilityQuery query) {
			return MapperS.of(specification).<EligibleCollateralCriteria>mapC("getCriteria", eligibleCollateralSpecification -> eligibleCollateralSpecification.getCriteria())
				.filterItemNullSafe(item -> item.<CollateralTreatment>map("getTreatment", eligibleCollateralCriteria -> eligibleCollateralCriteria.getTreatment()).<Boolean>map("getIsIncluded", collateralTreatment -> collateralTreatment.getIsIncluded()).get());
		}
		
		@Override
		protected MapperC<? extends EligibleCollateralCriteria> checkedCriteria(EligibleCollateralSpecification specification, EligibilityQuery query) {
			return filteredCriteria(specification, query)
				.filterItemNullSafe(item -> checkCriteria.evaluate(item.<CollateralCriteria>map("getCollateralCriteria", eligibleCollateralCriteria -> eligibleCollateralCriteria.getCollateralCriteria()).get(), query));
		}
	}
}
