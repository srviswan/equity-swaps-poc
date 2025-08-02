package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.event.common.TermsChangeInstruction;
import cdm.event.common.TermsChangeInstruction.TermsChangeInstructionBuilder;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_EffectiveOrTerminationDateTermChangeInstruction.Create_EffectiveOrTerminationDateTermChangeInstructionDefault.class)
public abstract class Create_EffectiveOrTerminationDateTermChangeInstruction implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product The original contractual product to be rolled.
	* @param effectiveRollDate The date to close and open a new position.
	* @param terminationDate The new termination date.
	* @return termsChangeInstruction The relevant primitive instruction for the roll, which is a terms change.
	*/
	public TermsChangeInstruction evaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveRollDate, AdjustableOrRelativeDate terminationDate) {
		// pre-conditions
		conditionValidator.validate(() -> exists(MapperS.of(effectiveRollDate)).or(exists(MapperS.of(terminationDate))),
			"");
		
		TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstructionBuilder = doEvaluate(product, effectiveRollDate, terminationDate);
		
		final TermsChangeInstruction termsChangeInstruction;
		if (termsChangeInstructionBuilder == null) {
			termsChangeInstruction = null;
		} else {
			termsChangeInstruction = termsChangeInstructionBuilder.build();
			objectValidator.validate(TermsChangeInstruction.class, termsChangeInstruction);
		}
		
		return termsChangeInstruction;
	}

	protected abstract TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveRollDate, AdjustableOrRelativeDate terminationDate);

	public static class Create_EffectiveOrTerminationDateTermChangeInstructionDefault extends Create_EffectiveOrTerminationDateTermChangeInstruction {
		@Override
		protected TermsChangeInstruction.TermsChangeInstructionBuilder doEvaluate(NonTransferableProduct product, AdjustableOrRelativeDate effectiveRollDate, AdjustableOrRelativeDate terminationDate) {
			TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction = TermsChangeInstruction.builder();
			return assignOutput(termsChangeInstruction, product, effectiveRollDate, terminationDate);
		}
		
		protected TermsChangeInstruction.TermsChangeInstructionBuilder assignOutput(TermsChangeInstruction.TermsChangeInstructionBuilder termsChangeInstruction, NonTransferableProduct product, AdjustableOrRelativeDate effectiveRollDate, AdjustableOrRelativeDate terminationDate) {
			termsChangeInstruction
				.setProduct(product);
			
			final AdjustableOrRelativeDate ifThenElseResult0;
			if (exists(MapperS.of(effectiveRollDate)).getOrDefault(false)) {
				ifThenElseResult0 = effectiveRollDate;
			} else {
				ifThenElseResult0 = MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", economicTerms -> economicTerms.getEffectiveDate()).get();
			}
			termsChangeInstruction
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.setEffectiveDate(ifThenElseResult0);
			
			final AdjustableOrRelativeDate ifThenElseResult1;
			if (exists(MapperS.of(terminationDate)).getOrDefault(false)) {
				ifThenElseResult1 = terminationDate;
			} else {
				ifThenElseResult1 = MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getTerminationDate", economicTerms -> economicTerms.getTerminationDate()).get();
			}
			termsChangeInstruction
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.setTerminationDate(ifThenElseResult1);
			
			return Optional.ofNullable(termsChangeInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
