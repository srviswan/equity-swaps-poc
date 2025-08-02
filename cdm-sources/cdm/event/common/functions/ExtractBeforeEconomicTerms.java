package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EconomicTerms.EconomicTermsBuilder;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ExtractBeforeEconomicTerms.ExtractBeforeEconomicTermsDefault.class)
public abstract class ExtractBeforeEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param businessEvent 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(BusinessEvent businessEvent) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(businessEvent);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(BusinessEvent businessEvent);

	public static class ExtractBeforeEconomicTermsDefault extends ExtractBeforeEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(BusinessEvent businessEvent) {
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, businessEvent);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, BusinessEvent businessEvent) {
			economicTerms = toBuilder(MapperS.of(MapperS.of(businessEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).get()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
