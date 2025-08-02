package cdm.event.qualification.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import cdm.event.common.functions.FilterCashTransfers;
import cdm.event.common.functions.FilterSecurityTransfers;
import cdm.event.common.functions.TransfersForDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_CashAndSecurityTransfer.Qualify_CashAndSecurityTransferDefault.class)
public abstract class Qualify_CashAndSecurityTransfer implements RosettaFunction,IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterCashTransfers filterCashTransfers;
	@Inject protected FilterSecurityTransfers filterSecurityTransfers;
	@Inject protected TransfersForDate transfersForDate0;

	/**
	* @param businessEvent 
	* @return is_event 
	*/
	@Override
	public Boolean evaluate(BusinessEvent businessEvent) {
		Boolean is_event = doEvaluate(businessEvent);
		
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);

	protected abstract MapperC<? extends Transfer> transfersForDate1(BusinessEvent businessEvent);

	public static class Qualify_CashAndSecurityTransferDefault extends Qualify_CashAndSecurityTransfer {
		@Override
		protected Boolean doEvaluate(BusinessEvent businessEvent) {
			Boolean is_event = null;
			return assignOutput(is_event, businessEvent);
		}
		
		protected Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
			is_event = exists(transfersForDate1(businessEvent).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).and(exists(transfersForDate1(businessEvent).<NonNegativeQuantity>map("getQuantity", transfer -> transfer.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FinancialUnitEnum>map("getFinancialUnit", unitType -> unitType.getFinancialUnit()))).and(areEqual(MapperS.of(transfersForDate1(businessEvent).resultCount()), MapperS.of(2), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperC.of(filterCashTransfers.evaluate(transfersForDate1(businessEvent).getMulti())).get()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), MapperS.of(MapperC.of(filterSecurityTransfers.evaluate(transfersForDate1(businessEvent).getMulti())).get()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("Type coercion", referenceWithMetaParty1 -> referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()), CardinalityOperator.All)).get();
			
			return is_event;
		}
		
		@Override
		protected MapperC<? extends Transfer> transfersForDate1(BusinessEvent businessEvent) {
			return MapperC.<Transfer>of(transfersForDate0.evaluate(MapperS.of(businessEvent).<TradeState>mapC("getAfter", _businessEvent -> _businessEvent.getAfter()).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory()).<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).getMulti(), MapperS.of(businessEvent).<Date>map("getEventDate", _businessEvent -> _businessEvent.getEventDate()).get()));
		}
	}
		
		@Override
		public String getNamePrefix() {
			return "Qualify";
		}
}
