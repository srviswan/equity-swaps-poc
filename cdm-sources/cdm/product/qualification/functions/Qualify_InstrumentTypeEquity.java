package cdm.product.qualification.functions;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.InstrumentTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.util.InstrumentDeepPathUtil;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InstrumentTypeEquity.Qualify_InstrumentTypeEquityDefault.class)
public abstract class Qualify_InstrumentTypeEquity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected InstrumentDeepPathUtil instrumentDeepPathUtil;

	/**
	* @param instrument 
	* @return is_equity 
	*/
	public Boolean evaluate(Instrument instrument) {
		Boolean is_equity = doEvaluate(instrument);
		
		return is_equity;
	}

	protected abstract Boolean doEvaluate(Instrument instrument);

	protected abstract MapperS<InstrumentTypeEnum> instrumentType(Instrument instrument);

	public static class Qualify_InstrumentTypeEquityDefault extends Qualify_InstrumentTypeEquity {
		@Override
		protected Boolean doEvaluate(Instrument instrument) {
			Boolean is_equity = null;
			return assignOutput(is_equity, instrument);
		}
		
		protected Boolean assignOutput(Boolean is_equity, Instrument instrument) {
			is_equity = areEqual(instrumentType(instrument), MapperS.of(InstrumentTypeEnum.EQUITY), CardinalityOperator.All).or(areEqual(instrumentType(instrument), MapperS.of(InstrumentTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity()).<FundProductTypeEnum>map("getFundType", security -> security.getFundType()), MapperS.of(FundProductTypeEnum.EXCHANGE_TRADED_FUND), CardinalityOperator.All))).or(areEqual(instrumentType(instrument), MapperS.of(InstrumentTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(instrument).<Security>map("getSecurity", _instrument -> _instrument.getSecurity()).<FundProductTypeEnum>map("getFundType", security -> security.getFundType()), MapperS.of(FundProductTypeEnum.MUTUAL_FUND), CardinalityOperator.All))).or(areEqual(instrumentType(instrument), MapperS.of(InstrumentTypeEnum.WARRANT), CardinalityOperator.All)).get();
			
			return is_equity;
		}
		
		@Override
		protected MapperS<InstrumentTypeEnum> instrumentType(Instrument instrument) {
			return MapperS.of(instrument).<InstrumentTypeEnum>map("chooseInstrumentType", _instrument -> instrumentDeepPathUtil.chooseInstrumentType(_instrument));
		}
	}
}
