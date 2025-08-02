package cdm.base.staticdata.asset.common.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;


@ImplementedBy(GetCashCurrency.GetCashCurrencyDefault.class)
public abstract class GetCashCurrency implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AssetIdentifierByType assetIdentifierByType;

	/**
	* @param cash 
	* @return currencyEnum 
	*/
	public CurrencyCodeEnum evaluate(Cash cash) {
		CurrencyCodeEnum currencyEnum = doEvaluate(cash);
		
		return currencyEnum;
	}

	protected abstract CurrencyCodeEnum doEvaluate(Cash cash);

	protected abstract MapperC<? extends AssetIdentifier> cashId(Cash cash);

	public static class GetCashCurrencyDefault extends GetCashCurrency {
		@Override
		protected CurrencyCodeEnum doEvaluate(Cash cash) {
			CurrencyCodeEnum currencyEnum = null;
			return assignOutput(currencyEnum, cash);
		}
		
		protected CurrencyCodeEnum assignOutput(CurrencyCodeEnum currencyEnum, Cash cash) {
			currencyEnum = cashId(cash).<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())
				.first().<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()).checkedMap("to-enum", CurrencyCodeEnum::fromDisplayName, IllegalArgumentException.class).get();
			
			return currencyEnum;
		}
		
		@Override
		protected MapperC<? extends AssetIdentifier> cashId(Cash cash) {
			return MapperC.<AssetIdentifier>of(assetIdentifierByType.evaluate(MapperS.of(cash).<AssetIdentifier>mapC("getIdentifier", _cash -> _cash.getIdentifier()).getMulti(), AssetIdTypeEnum.CURRENCY_CODE));
		}
	}
}
