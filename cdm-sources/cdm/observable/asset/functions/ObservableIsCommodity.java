package cdm.observable.asset.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Basket;
import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaBasketConstituent;
import cdm.observable.asset.util.IndexDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ObservableIsCommodity.ObservableIsCommodityDefault.class)
public abstract class ObservableIsCommodity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;

	/**
	* @param observable 
	* @return valid 
	*/
	public Boolean evaluate(Observable observable) {
		Boolean valid = doEvaluate(observable);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(Observable observable);

	public static class ObservableIsCommodityDefault extends ObservableIsCommodity {
		@Override
		protected Boolean doEvaluate(Observable observable) {
			Boolean valid = null;
			return assignOutput(valid, observable);
		}
		
		protected Boolean assignOutput(Boolean valid, Observable observable) {
			if (exists(MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset())).getOrDefault(false)) {
				valid = exists(MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).get();
			} else if (exists(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket())).getOrDefault(false)) {
				valid = areEqual(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
					.mapItem(item -> exists(item.<BasketConstituent>map("Type coercion", fieldWithMetaBasketConstituent -> fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue()).<Asset>map("getAsset", basketConstituent -> basketConstituent.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).asMapper()), MapperS.of(true), CardinalityOperator.All).get();
			} else if (exists(MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex())).getOrDefault(false)) {
				valid = areEqual(MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(AssetClassEnum.COMMODITY), CardinalityOperator.All).get();
			} else {
				valid = false;
			}
			
			return valid;
		}
	}
}
