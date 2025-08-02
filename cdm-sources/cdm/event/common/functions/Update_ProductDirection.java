package cdm.event.common.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Update_ProductDirection.Update_ProductDirectionDefault.class)
public abstract class Update_ProductDirection implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param before 
	* @param originalPayer 
	* @param originalReceiver 
	* @return after 
	*/
	public NonTransferableProduct evaluate(NonTransferableProduct before, CounterpartyRoleEnum originalPayer, CounterpartyRoleEnum originalReceiver) {
		NonTransferableProduct.NonTransferableProductBuilder afterBuilder = doEvaluate(before, originalPayer, originalReceiver);
		
		final NonTransferableProduct after;
		if (afterBuilder == null) {
			after = null;
		} else {
			after = afterBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, after);
		}
		
		return after;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(NonTransferableProduct before, CounterpartyRoleEnum originalPayer, CounterpartyRoleEnum originalReceiver);

	public static class Update_ProductDirectionDefault extends Update_ProductDirection {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(NonTransferableProduct before, CounterpartyRoleEnum originalPayer, CounterpartyRoleEnum originalReceiver) {
			NonTransferableProduct.NonTransferableProductBuilder after = NonTransferableProduct.builder();
			return assignOutput(after, before, originalPayer, originalReceiver);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder after, NonTransferableProduct before, CounterpartyRoleEnum originalPayer, CounterpartyRoleEnum originalReceiver) {
			after = toBuilder(before);
			
			after
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateOptionPayout()
				.getOrCreatePayerReceiver()
				.setPayer(originalReceiver);
			
			after
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateOptionPayout()
				.getOrCreatePayerReceiver()
				.setReceiver(originalPayer);
			
			return Optional.ofNullable(after)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
