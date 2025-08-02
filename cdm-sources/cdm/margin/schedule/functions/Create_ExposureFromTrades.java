package cdm.margin.schedule.functions;

import cdm.event.common.Exposure;
import cdm.event.common.Exposure.ExposureBuilder;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.position.Position;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Product;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_ExposureFromTrades.Create_ExposureFromTradesDefault.class)
public abstract class Create_ExposureFromTrades implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trades 
	* @return exposure 
	*/
	public Exposure evaluate(List<? extends TradeState> trades) {
		Exposure.ExposureBuilder exposureBuilder = doEvaluate(trades);
		
		final Exposure exposure;
		if (exposureBuilder == null) {
			exposure = null;
		} else {
			exposure = exposureBuilder.build();
			objectValidator.validate(Exposure.class, exposure);
		}
		
		return exposure;
	}

	protected abstract Exposure.ExposureBuilder doEvaluate(List<? extends TradeState> trades);

	public static class Create_ExposureFromTradesDefault extends Create_ExposureFromTrades {
		@Override
		protected Exposure.ExposureBuilder doEvaluate(List<? extends TradeState> trades) {
			if (trades == null) {
				trades = Collections.emptyList();
			}
			Exposure.ExposureBuilder exposure = Exposure.builder();
			return assignOutput(exposure, trades);
		}
		
		protected Exposure.ExposureBuilder assignOutput(Exposure.ExposureBuilder exposure, List<? extends TradeState> trades) {
			exposure
				.getOrCreateTradePortfolio().getOrCreateValue()
				.addPositions(MapperC.<TradeState>of(trades)
					.mapItem(item -> MapperS.of(Position.builder()
						.setCashBalance(null)
						.setPriceQuantity(item.<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).getMulti())
						.setTradeReferenceValue(null)
						.setProduct(Product.builder()
							.setNonTransferableProduct(item.<Trade>map("getTrade", tradeState -> tradeState.getTrade()).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get())
							.build())
						.build())).getMulti());
			
			exposure
				.getOrCreateTradePortfolio().getOrCreateValue()
				.getOrCreateLineage()
				.setTradeReferenceValue(MapperC.<TradeState>of(trades).<Trade>map("getTrade", tradeState -> tradeState.getTrade())
					.first().getMulti());
			
			return Optional.ofNullable(exposure)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
