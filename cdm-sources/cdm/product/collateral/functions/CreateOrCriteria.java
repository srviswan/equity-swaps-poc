package cdm.product.collateral.functions;

import cdm.product.collateral.CollateralCriteria;
import cdm.product.collateral.CollateralCriteria.CollateralCriteriaBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateOrCriteria.CreateOrCriteriaDefault.class)
public abstract class CreateOrCriteria implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param inputCriteria 
	* @return outputCriteria 
	*/
	public CollateralCriteria evaluate(List<? extends CollateralCriteria> inputCriteria) {
		CollateralCriteria.CollateralCriteriaBuilder outputCriteriaBuilder = doEvaluate(inputCriteria);
		
		final CollateralCriteria outputCriteria;
		if (outputCriteriaBuilder == null) {
			outputCriteria = null;
		} else {
			outputCriteria = outputCriteriaBuilder.build();
			objectValidator.validate(CollateralCriteria.class, outputCriteria);
		}
		
		return outputCriteria;
	}

	protected abstract CollateralCriteria.CollateralCriteriaBuilder doEvaluate(List<? extends CollateralCriteria> inputCriteria);

	public static class CreateOrCriteriaDefault extends CreateOrCriteria {
		@Override
		protected CollateralCriteria.CollateralCriteriaBuilder doEvaluate(List<? extends CollateralCriteria> inputCriteria) {
			if (inputCriteria == null) {
				inputCriteria = Collections.emptyList();
			}
			CollateralCriteria.CollateralCriteriaBuilder outputCriteria = CollateralCriteria.builder();
			return assignOutput(outputCriteria, inputCriteria);
		}
		
		protected CollateralCriteria.CollateralCriteriaBuilder assignOutput(CollateralCriteria.CollateralCriteriaBuilder outputCriteria, List<? extends CollateralCriteria> inputCriteria) {
			outputCriteria
				.getOrCreateAnyCriteria()
				.setAnyCriteria(inputCriteria);
			
			return Optional.ofNullable(outputCriteria)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
