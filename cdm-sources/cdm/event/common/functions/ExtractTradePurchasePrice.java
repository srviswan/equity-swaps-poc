package cdm.event.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(ExtractTradePurchasePrice.ExtractTradePurchasePriceDefault.class)
public abstract class ExtractTradePurchasePrice implements RosettaFunction {

	/**
	* @param tradableProduct 
	* @return value 
	*/
	public List<BigDecimal> evaluate(TradableProduct tradableProduct) {
		List<BigDecimal> value = doEvaluate(tradableProduct);
		
		return value;
	}

	protected abstract List<BigDecimal> doEvaluate(TradableProduct tradableProduct);

	public static class ExtractTradePurchasePriceDefault extends ExtractTradePurchasePrice {
		@Override
		protected List<BigDecimal> doEvaluate(TradableProduct tradableProduct) {
			List<BigDecimal> value = new ArrayList<>();
			return assignOutput(value, tradableProduct);
		}
		
		protected List<BigDecimal> assignOutput(List<BigDecimal> value, TradableProduct tradableProduct) {
			final MapperListOfLists<FieldWithMetaNonNegativeQuantitySchedule> thenArg0 = MapperS.of(MapperS.of(tradableProduct).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity())
				.mapItemToList(item -> item.<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()));
			final MapperC<FieldWithMetaNonNegativeQuantitySchedule> thenArg1 = thenArg0
				.flattenList();
			value = thenArg1
				.mapItem(item -> item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue())).getMulti();
			
			return value;
		}
	}
}
