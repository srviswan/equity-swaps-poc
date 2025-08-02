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


@ImplementedBy(Create_CancellationTermChangeInstruction.Create_CancellationTermChangeInstructionDefault.class)
public abstract class Create_CancellationTermChangeInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product Contractual product of original trade
	* @param cancellationDate The new termination date.
	* @return termsChangeInstruction 
	*/
	public TermsChangeInstruction evaluate(NonTransferableProduct product, AdjustableOrRelativeDate cancellationDate) {
		TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstructionBuilder = doEvaluate(product, cancellationDate);
		
		final TermsChangeInstruction termsChangeInstruction;
		if (termsChangeInstructionBuilder == null) {
			termsChangeInstruction = null;
		} else {
			termsChangeInstruction = termsChangeInstructionBuilder.build();
			objectValidator.validate(TermsChangeInstruction.class, termsChangeInstruction);
		}
		
		return termsChangeInstruction;
	}

	protected abstract TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate cancellationDate);

	public static class Create_CancellationTermChangeInstructionDefault extends Create_CancellationTermChangeInstruction {
		@Override
		protected TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate cancellationDate) {
			TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction = TermsChangeInstruction.builder();
			return assignOutput(termsChangeInstruction, product, cancellationDate);
		}
		
		protected TermsChangeInstruction.TermsChangeInstructionBuilder assignOutput(TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction, NonTransferableProduct product, AdjustableOrRelativeDate cancellationDate) {
			termsChangeInstruction
				.setProduct(product);
			
			termsChangeInstruction
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.setTerminationDate(cancellationDate);
			
			return Optional.ofNullable(termsChangeInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
