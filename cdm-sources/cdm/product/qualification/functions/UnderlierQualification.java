package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.template.Product;
import cdm.product.template.TransferableProduct;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(UnderlierQualification.UnderlierQualificationDefault.class)
public abstract class UnderlierQualification implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ObservableQualification observableQualification;

	/**
	* @param underlier An Underlier is an Observable (eg Asset, Basket or Index) or a Product.
	* @param securityType 
	* @param assetClass 
	* @return qualifies 
	*/
	public Boolean evaluate(Underlier underlier, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
		Boolean qualifies = doEvaluate(underlier, securityType, assetClass);
		
		return qualifies;
	}

	protected abstract Boolean doEvaluate(Underlier underlier, InstrumentTypeEnum securityType, AssetClassEnum assetClass);

	public static class UnderlierQualificationDefault extends UnderlierQualification {
		@Override
		protected Boolean doEvaluate(Underlier underlier, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
			Boolean qualifies = null;
			return assignOutput(qualifies, underlier, securityType, assetClass);
		}
		
		protected Boolean assignOutput(Boolean qualifies, Underlier underlier, InstrumentTypeEnum securityType, AssetClassEnum assetClass) {
			final ReferenceWithMetaObservable referenceWithMetaObservable = MapperS.of(underlier).<ReferenceWithMetaObservable>map("getObservable", _underlier -> _underlier.getObservable()).get();
			qualifies = ComparisonResult.of(MapperS.of(observableQualification.evaluate((referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()), securityType, assetClass))).or(areEqual(MapperS.of(underlier).<Product>map("getProduct", _underlier -> _underlier.getProduct()).<TransferableProduct>map("getTransferableProduct", product -> product.getTransferableProduct()).<Instrument>map("getInstrument", transferableProduct -> transferableProduct.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<InstrumentTypeEnum>map("getInstrumentType", security -> security.getInstrumentType()), MapperS.of(securityType), CardinalityOperator.All)).get();
			
			return qualifies;
		}
	}
}
