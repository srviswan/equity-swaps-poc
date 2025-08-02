package cdm.margin.schedule.functions;

import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_Equity;
import cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(StandardizedScheduleAssetClass.StandardizedScheduleAssetClassDefault.class)
public abstract class StandardizedScheduleAssetClass implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_Equity qualify_AssetClass_Equity;
	@Inject protected Qualify_AssetClass_ForeignExchange qualify_AssetClass_ForeignExchange;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;

	/**
	* @param trade 
	* @return assetClass 
	*/
	public StandardizedScheduleAssetClassEnum evaluate(Trade trade) {
		StandardizedScheduleAssetClassEnum assetClass = doEvaluate(trade);
		
		return assetClass;
	}

	protected abstract StandardizedScheduleAssetClassEnum doEvaluate(Trade trade);

	protected abstract MapperS<? extends NonTransferableProduct> product(Trade trade);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(Trade trade);

	public static class StandardizedScheduleAssetClassDefault extends StandardizedScheduleAssetClass {
		@Override
		protected StandardizedScheduleAssetClassEnum doEvaluate(Trade trade) {
			StandardizedScheduleAssetClassEnum assetClass = null;
			return assignOutput(assetClass, trade);
		}
		
		protected StandardizedScheduleAssetClassEnum assignOutput(StandardizedScheduleAssetClassEnum assetClass, Trade trade) {
			final Boolean boolean0 = qualify_AssetClass_InterestRate.evaluate(economicTerms(trade).get());
			if ((boolean0 == null ? false : boolean0)) {
				assetClass = StandardizedScheduleAssetClassEnum.INTEREST_RATES;
			} else {
				final Boolean boolean1 = qualify_AssetClass_Credit.evaluate(economicTerms(trade).get());
				if ((boolean1 == null ? false : boolean1)) {
					assetClass = StandardizedScheduleAssetClassEnum.CREDIT;
				} else {
					final Boolean boolean2 = qualify_AssetClass_ForeignExchange.evaluate(economicTerms(trade).get());
					if ((boolean2 == null ? false : boolean2)) {
						assetClass = StandardizedScheduleAssetClassEnum.FOREIGN_EXCHANGE;
					} else {
						final Boolean boolean3 = qualify_AssetClass_Equity.evaluate(economicTerms(trade).get());
						if ((boolean3 == null ? false : boolean3)) {
							assetClass = StandardizedScheduleAssetClassEnum.EQUITY;
						} else {
							final Boolean boolean4 = qualify_AssetClass_Commodity.evaluate(economicTerms(trade).get());
							if ((boolean4 == null ? false : boolean4)) {
								assetClass = StandardizedScheduleAssetClassEnum.COMMODITY;
							} else {
								assetClass = null;
							}
						}
					}
				}
			}
			
			return assetClass;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(Trade trade) {
			return MapperS.of(trade).<NonTransferableProduct>map("getProduct", _trade -> _trade.getProduct());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(Trade trade) {
			return product(trade).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
	}
}
