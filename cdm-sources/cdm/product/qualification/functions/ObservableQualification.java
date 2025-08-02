package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
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

@ImplementedBy(ObservableQualification.ObservableQualificationDefault.class)
public abstract class ObservableQualification implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IndexDeepPathUtil indexDeepPathUtil;
	@Inject protected cdm.product.qualification.functions.ObservableQualification observableQualification;

	/**
	* @param observable An Observable is an Asset, Basket or Index.
	* @param securityType 
	* @param assetClass 
	* @return qualifies 
	*/
	public Boolean evaluate(Observable observable, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
		Boolean qualifies = doEvaluate(observable, securityType, assetClass);
		
		return qualifies;
	}

	protected abstract Boolean doEvaluate(Observable observable, InstrumentTypeEnum securityType, AssetClassEnum assetClass);

	public static class ObservableQualificationDefault extends ObservableQualification {
		@Override
		protected Boolean doEvaluate(Observable observable, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
			Boolean qualifies = null;
			return assignOutput(qualifies, observable, securityType, assetClass);
		}
		
		protected Boolean assignOutput(Boolean qualifies, Observable observable, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
			final ComparisonResult ifThenElseResult;
			if (exists(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket())).getOrDefault(false)) {
				ifThenElseResult = areEqual(MapperS.of(observable).<Basket>map("getBasket", _observable -> _observable.getBasket()).<FieldWithMetaBasketConstituent>mapC("getBasketConstituent", basket -> basket.getBasketConstituent())
					.mapItem(item -> {
						final FieldWithMetaBasketConstituent fieldWithMetaBasketConstituent = item.get();
						return MapperS.of(observableQualification.evaluate((fieldWithMetaBasketConstituent == null ? null : fieldWithMetaBasketConstituent.getValue()), securityType, assetClass));
					}), MapperS.of(true), CardinalityOperator.All);
			} else {
				ifThenElseResult = ComparisonResult.of(MapperS.of(false));
			}
			qualifies = areEqual(MapperS.of(observable).<Asset>map("getAsset", _observable -> _observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(securityType), CardinalityOperator.All).or(areEqual(MapperS.of(observable).<Index>map("getIndex", _observable -> _observable.getIndex()).<AssetClassEnum>map("chooseAssetClass", index -> indexDeepPathUtil.chooseAssetClass(index)), MapperS.of(assetClass), CardinalityOperator.All)).or(ifThenElseResult).get();
			
			return qualifies;
		}
	}
}
