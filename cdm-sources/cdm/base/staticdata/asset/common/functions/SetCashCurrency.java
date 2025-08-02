package cdm.base.staticdata.asset.common.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Cash;
import cdm.base.staticdata.asset.common.Cash.CashBuilder;
import cdm.base.staticdata.asset.common.CurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SetCashCurrency.SetCashCurrencyDefault.class)
public abstract class SetCashCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param cash 
	* @param currency 
	* @return cashOutput 
	*/
	public Cash evaluate(Cash cash, CurrencyCodeEnum currency) {
		Cash.CashBuilder cashOutputBuilder = doEvaluate(cash, currency);
		
		final Cash cashOutput;
		if (cashOutputBuilder == null) {
			cashOutput = null;
		} else {
			cashOutput = cashOutputBuilder.build();
			objectValidator.validate(Cash.class, cashOutput);
		}
		
		return cashOutput;
	}

	protected abstract Cash.CashBuilder doEvaluate(Cash cash, CurrencyCodeEnum currency);

	public static class SetCashCurrencyDefault extends SetCashCurrency {
		@Override
		protected Cash.CashBuilder doEvaluate(Cash cash, CurrencyCodeEnum currency) {
			Cash.CashBuilder cashOutput = Cash.builder();
			return assignOutput(cashOutput, cash, currency);
		}
		
		protected Cash.CashBuilder assignOutput(Cash.CashBuilder cashOutput, Cash cash, CurrencyCodeEnum currency) {
			final AssetIdentifier assetIdentifier = AssetIdentifier.builder()
				.setIdentifierValue(MapperS.of(currency).map("to-string", CurrencyCodeEnum::toDisplayString).get())
				.setIdentifierType(AssetIdTypeEnum.CURRENCY_CODE)
				.build();
			cashOutput
				.setIdentifier((assetIdentifier == null ? Collections.<AssetIdentifier>emptyList() : Collections.singletonList(assetIdentifier)));
			
			return Optional.ofNullable(cashOutput)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
