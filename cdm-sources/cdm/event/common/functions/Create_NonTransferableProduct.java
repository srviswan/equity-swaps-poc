package cdm.event.common.functions;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.NonTransferableProduct.NonTransferableProductBuilder;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_NonTransferableProduct.Create_NonTransferableProductDefault.class)
public abstract class Create_NonTransferableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param underlier 
	* @param payerReceiver 
	* @return newProduct 
	*/
	public NonTransferableProduct evaluate(Underlier underlier, PayerReceiver payerReceiver) {
		NonTransferableProduct.NonTransferableProductBuilder newProductBuilder = doEvaluate(underlier, payerReceiver);
		
		final NonTransferableProduct newProduct;
		if (newProductBuilder == null) {
			newProduct = null;
		} else {
			newProduct = newProductBuilder.build();
			objectValidator.validate(NonTransferableProduct.class, newProduct);
		}
		
		return newProduct;
	}

	protected abstract NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Underlier underlier, PayerReceiver payerReceiver);

	public static class Create_NonTransferableProductDefault extends Create_NonTransferableProduct {
		@Override
		protected NonTransferableProduct.NonTransferableProductBuilder doEvaluate(Underlier underlier, PayerReceiver payerReceiver) {
			NonTransferableProduct.NonTransferableProductBuilder newProduct = NonTransferableProduct.builder();
			return assignOutput(newProduct, underlier, payerReceiver);
		}
		
		protected NonTransferableProduct.NonTransferableProductBuilder assignOutput(NonTransferableProduct.NonTransferableProductBuilder newProduct, Underlier underlier, PayerReceiver payerReceiver) {
			newProduct
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateSettlementPayout()
				.setUnderlier(underlier);
			
			newProduct
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateSettlementPayout()
				.setPayerReceiver(payerReceiver);
			
			return Optional.ofNullable(newProduct)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
