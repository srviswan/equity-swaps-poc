package cdm.margin.schedule.functions;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(IsCreditNthToDefault.IsCreditNthToDefaultDefault.class)
public abstract class IsCreditNthToDefault implements RosettaFunction {

	/**
	* @param economicTerms 
	* @return is_Product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		Boolean is_Product = doEvaluate(economicTerms);
		
		return is_Product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);

	public static class IsCreditNthToDefaultDefault extends IsCreditNthToDefault {
		@Override
		protected Boolean doEvaluate(EconomicTerms economicTerms) {
			Boolean is_Product = null;
			return assignOutput(is_Product, economicTerms);
		}
		
		protected Boolean assignOutput(Boolean is_Product, EconomicTerms economicTerms) {
			is_Product = exists(MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<Integer>map("getNthToDefault", basketReferenceInformation -> basketReferenceInformation.getNthToDefault())).get();
			
			return is_Product;
		}
	}
}
