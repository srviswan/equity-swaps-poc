package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.event.common.TermsChangeInstruction;
import cdm.event.common.TermsChangeInstruction.TermsChangeInstructionBuilder;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_OnDemandRateChangeTermsChangeInstruction.Create_OnDemandRateChangeTermsChangeInstructionDefault.class)
public abstract class Create_OnDemandRateChangeTermsChangeInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product The original contractual product whose rate is changed.
	* @param effectiveDate The date to open the new position.
	* @return termsChangeInstruction 
	*/
	public TermsChangeInstruction evaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveDate) {
		TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstructionBuilder = doEvaluate(product, effectiveDate);
		
		final TermsChangeInstruction termsChangeInstruction;
		if (termsChangeInstructionBuilder == null) {
			termsChangeInstruction = null;
		} else {
			termsChangeInstruction = termsChangeInstructionBuilder.build();
			objectValidator.validate(TermsChangeInstruction.class, termsChangeInstruction);
		}
		
		return termsChangeInstruction;
	}

	protected abstract TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveDate);

	public static class Create_OnDemandRateChangeTermsChangeInstructionDefault extends Create_OnDemandRateChangeTermsChangeInstruction {
		@Override
		protected TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveDate) {
			TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction = TermsChangeInstruction.builder();
			return assignOutput(termsChangeInstruction, product, effectiveDate);
		}
		
		protected TermsChangeInstruction.TermsChangeInstructionBuilder assignOutput(TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction, NonTransferableProduct product, AdjustableOrRelativeDate effectiveDate) {
			termsChangeInstruction
				.setProduct(product);
			
			termsChangeInstruction
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.setEffectiveDate(effectiveDate);
			
			return Optional.ofNullable(termsChangeInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
