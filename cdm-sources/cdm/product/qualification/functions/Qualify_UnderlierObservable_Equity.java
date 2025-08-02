package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.observable.asset.Basket;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.util.IndexDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_UnderlierObservable_Equity.Qualify_UnderlierObservable_EquityDefault.class)
public abstract class Qualify_UnderlierObservable_Equity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected Qualify_InstrumentTypeEquity qualify_InstrumentTypeEquity;
	@Inject protected cdm.product.qualification.functions.Qualify_UnderlierObservable_Equity qualify_UnderlierObservable_Equity;

	/**
	* @param observable 
	* @return is_product 
	*/
	public Boolean evaluate(Observable observable) {
		Boolean is_product = doEvaluate(observable);
		
		return is_product;
	}

	protected abstract Boolean doEvaluate(Observable observable);

	public static class Qualify_UnderlierObservable_EquityDefault extends Qualify_UnderlierObservable_Equity {
		@Override
		protected Boolean doEvaluate(Observable observable) {
			Boolean is_product = null;
			return assignOutput(is_product, observable);
		}
		
		protected Boolean assignOutput(Boolean is_product, Observable observable) {
			is_product = ComparisonResult.of(MapperS.of(qualify_InstrumentTypeEquity.evaluate(MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).get()))).or(areEqual(MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All)).or(exists(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket())).and(areEqual(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
				.mapItem(item -> {
					final FieldWithMetaBasketConstituent fieldWithMetaBasketConstituent = item.get();
					return MapperS.of(qualify_UnderlierObservable_Equity.evaluate((fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue())));
				}), MapperS.of(true), CardinalityOperator.Any))).get();
			
			return is_product;
		}
	}
}
