package cdm.product.collateral.functions;

import cdm.product.collateral.AllCriteria;
import cdm.product.collateral.AnyCriteria;
import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralTreatment;
import cdm.product.collateral.EligibleCollateralSpecification;
import cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder;
import cdm.product.collateral.NegativeCriteria;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CloneEligibleCollateralWithChangedTreatment.CloneEligibleCollateralWithChangedTreatmentDefault.class)
public abstract class CloneEligibleCollateralWithChangedTreatment implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param inputSpecification 
	* @param changedCriteria 
	* @param changedTreatment 
	* @return outputSpecification 
	*/
	public EligibleCollateralSpecification evaluate(EligibleCollateralSpecification inputSpecification, CollateralCriteria changedCriteria, CollateralTreatment changedTreatment) {
		// pre-conditions
		conditionValidator.validate(() -> notExists(MapperS.of(changedCriteria).<AllCriteria>map("getAllCriteria", collateralCriteria -> collateralCriteria.getAllCriteria())).and(notExists(MapperS.of(changedCriteria).<AnyCriteria>map("getAnyCriteria", collateralCriteria -> collateralCriteria.getAnyCriteria()))).and(notExists(MapperS.of(changedCriteria).<NegativeCriteria>map("getNegativeCriteria", collateralCriteria -> collateralCriteria.getNegativeCriteria()))),
			"");
		
		EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder outputSpecificationBuilder = doEvaluate(inputSpecification, changedCriteria, changedTreatment);
		
		final EligibleCollateralSpecification outputSpecification;
		if (outputSpecificationBuilder == null) {
			outputSpecification = null;
		} else {
			outputSpecification = outputSpecificationBuilder.build();
			objectValidator.validate(EligibleCollateralSpecification.class, outputSpecification);
		}
		
		return outputSpecification;
	}

	protected abstract EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder doEvaluate(EligibleCollateralSpecification inputSpecification, CollateralCriteria changedCriteria, CollateralTreatment changedTreatment);

	public static class CloneEligibleCollateralWithChangedTreatmentDefault extends CloneEligibleCollateralWithChangedTreatment {
		@Override
		protected EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder doEvaluate(EligibleCollateralSpecification inputSpecification, CollateralCriteria changedCriteria, CollateralTreatment changedTreatment) {
			EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder outputSpecification = EligibleCollateralSpecification.builder();
			return assignOutput(outputSpecification, inputSpecification, changedCriteria, changedTreatment);
		}
		
		protected EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder assignOutput(EligibleCollateralSpecification.EligibleCollateralSpecificationBuilder outputSpecification, EligibleCollateralSpecification inputSpecification, CollateralCriteria changedCriteria, CollateralTreatment changedTreatment) {
			outputSpecification = toBuilder(inputSpecification);
			
			outputSpecification
				.getOrCreateCriteria(0)
				.setTreatment(changedTreatment);
			
			return Optional.ofNullable(outputSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
