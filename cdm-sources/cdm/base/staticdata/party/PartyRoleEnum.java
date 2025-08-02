package cdm.base.staticdata.party;

import cdm.base.staticdata.party.PartyRoleEnum;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.model.lib.annotations.RosettaEnumValue;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party.
 * @version 6.0.0
 */
@RosettaEnum("PartyRoleEnum")
public enum PartyRoleEnum {

	/**
	 * Organization responsible for preparing the accounting for the trade.
	 */
	@RosettaEnumValue(value = "Accountant") 
	ACCOUNTANT("Accountant", null),
	
	/**
	 * An agent who lends securities of its principals under stock lending arrangements.
	 */
	@RosettaEnumValue(value = "AgentLender") 
	AGENT_LENDER("AgentLender", null),
	
	/**
	 * The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations.
	 */
	@RosettaEnumValue(value = "AllocationAgent") 
	ALLOCATION_AGENT("AllocationAgent", null),
	
	/**
	 * The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent.
	 */
	@RosettaEnumValue(value = "ArrangingBroker") 
	ARRANGING_BROKER("ArrangingBroker", null),
	
	/**
	 * The party specified in the related confirmation as Barrier Determination Agent.
	 */
	@RosettaEnumValue(value = "BarrierDeterminationAgent") 
	BARRIER_DETERMINATION_AGENT("BarrierDeterminationAgent", null),
	
	/**
	 * The party that lends out securities under stock lending arrangements via an Agent Lender.
	 */
	@RosettaEnumValue(value = "BeneficialOwner") 
	BENEFICIAL_OWNER("BeneficialOwner", null),
	
	/**
	 * Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of &#39;Beneficiary&#39; at the partyTradeInformation level.
	 */
	@RosettaEnumValue(value = "Beneficiary") 
	BENEFICIARY("Beneficiary", null),
	
	/**
	 * The entity for which the organization supporting the trade&#39;s processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn&#39;t need to be reported but a firm still wants to specify their own side.
	 */
	@RosettaEnumValue(value = "BookingParty") 
	BOOKING_PARTY("BookingParty", null),
	
	/**
	 * The party that borrows securities under stock lending arrangements.
	 */
	@RosettaEnumValue(value = "Borrower") 
	BORROWER("Borrower", null),
	
	/**
	 * Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the &#39;Buy side&#39;; for that, see the &#39;Client&#39; role. Corresponds to &#39;Buyer&#39; as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9.
	 */
	@RosettaEnumValue(value = "Buyer") 
	BUYER("Buyer", null),
	
	/**
	 * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to &#39;buyer decision maker&#39; as defined in ESMA&#39;s MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the &#39;Buy side&#39;; for that, see the &#39;Client Decision Maker&#39; role.
	 */
	@RosettaEnumValue(value = "BuyerDecisionMaker") 
	BUYER_DECISION_MAKER("BuyerDecisionMaker", null),
	
	/**
	 * The party that provides credit support under English Law.
	 */
	@RosettaEnumValue(value = "Chargor") 
	CHARGOR("Chargor", null),
	
	/**
	 * An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term &#39;client&#39; refers to the organization&#39;s role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process.
	 */
	@RosettaEnumValue(value = "ClearingClient") 
	CLEARING_CLIENT("ClearingClient", null),
	
	/**
	 * A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions.
	 */
	@RosettaEnumValue(value = "ClearingExceptionParty") 
	CLEARING_EXCEPTION_PARTY("ClearingExceptionParty", null),
	
	/**
	 * Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use &#39;Clearing Broker&#39; as synonym.
	 */
	@RosettaEnumValue(value = "ClearingFirm") 
	CLEARING_FIRM("ClearingFirm", null),
	
	/**
	 * The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called &#39;ClearingService&#39;. Some implementations also use the term &#39;Clearer&#39;.
	 */
	@RosettaEnumValue(value = "ClearingOrganization") 
	CLEARING_ORGANIZATION("ClearingOrganization", null),
	
	/**
	 * Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances.
	 */
	@RosettaEnumValue(value = "Client") 
	CLIENT("Client", null),
	
	/**
	 * The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument.
	 */
	@RosettaEnumValue(value = "ClientDecisionMaker") 
	CLIENT_DECISION_MAKER("ClientDecisionMaker", null),
	
	/**
	 * Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data.
	 */
	@RosettaEnumValue(value = "ConfirmationPlatform") 
	CONFIRMATION_PLATFORM("ConfirmationPlatform", null),
	
	/**
	 * A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
	 */
	@RosettaEnumValue(value = "ContractualParty") 
	CONTRACTUAL_PARTY("ContractualParty", null),
	
	/**
	 * Organization officially attached to the counterparty. e.g. partner, branch, subsidiary.
	 */
	@RosettaEnumValue(value = "CounterPartyAffiliate") 
	COUNTER_PARTY_AFFILIATE("CounterPartyAffiliate", null),
	
	/**
	 * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
	 */
	@RosettaEnumValue(value = "CounterPartyUltimateParent") 
	COUNTER_PARTY_ULTIMATE_PARENT("CounterPartyUltimateParent", null),
	
	/**
	 * An economic counterparty to the trade. Synonym: principal.
	 */
	@RosettaEnumValue(value = "Counterparty") 
	COUNTERPARTY("Counterparty", null),
	
	/**
	 * Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation).
	 */
	@RosettaEnumValue(value = "CreditSupportProvider") 
	CREDIT_SUPPORT_PROVIDER("CreditSupportProvider", null),
	
	/**
	 * Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal.
	 */
	@RosettaEnumValue(value = "Custodian") 
	CUSTODIAN("Custodian", null),
	
	/**
	 * Entity submitting the transaction report to the competent authority.
	 */
	@RosettaEnumValue(value = "DataSubmitter") 
	DATA_SUBMITTER("DataSubmitter", null),
	
	/**
	 * The party referenced is specified in the contract confirmation as Determination Party.
	 */
	@RosettaEnumValue(value = "DeterminingParty") 
	DETERMINING_PARTY("DeterminingParty", null),
	
	/**
	 * Organization that is disputing the trade or transaction.
	 */
	@RosettaEnumValue(value = "DisputingParty") 
	DISPUTING_PARTY("DisputingParty", null),
	
	/**
	 * A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
	 */
	@RosettaEnumValue(value = "DocumentRepository") 
	DOCUMENT_REPOSITORY("DocumentRepository", null),
	
	/**
	 * The (generally sell-side) organization that executed the trade; the price-making party.
	 */
	@RosettaEnumValue(value = "ExecutingBroker") 
	EXECUTING_BROKER("ExecutingBroker", null),
	
	/**
	 * Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent.
	 */
	@RosettaEnumValue(value = "ExecutingEntity") 
	EXECUTING_ENTITY("ExecutingEntity", null),
	
	/**
	 * The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different.
	 */
	@RosettaEnumValue(value = "ExecutionAgent") 
	EXECUTION_AGENT("ExecutionAgent", null),
	
	/**
	 * The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue.
	 */
	@RosettaEnumValue(value = "ExecutionFacility") 
	EXECUTION_FACILITY("ExecutionFacility", null),
	
	/**
	 * Organization that backs (guarantees) the credit risk of the trade.
	 */
	@RosettaEnumValue(value = "Guarantor") 
	GUARANTOR("Guarantor", null),
	
	/**
	 * The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract.
	 */
	@RosettaEnumValue(value = "HedgingParty") 
	HEDGING_PARTY("HedgingParty", null),
	
	/**
	 * The party that lends out securities under stock lending arrangements as principal.
	 */
	@RosettaEnumValue(value = "Lender") 
	LENDER("Lender", null),
	
	/**
	 * The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm.
	 */
	@RosettaEnumValue(value = "OrderTransmitter") 
	ORDER_TRANSMITTER("OrderTransmitter", null),
	
	/**
	 * The party that provides credit support under New York Law.
	 */
	@RosettaEnumValue(value = "Pledgor") 
	PLEDGOR("Pledgor", null),
	
	/**
	 * The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism).
	 */
	@RosettaEnumValue(value = "PrimeBroker") 
	PRIME_BROKER("PrimeBroker", null),
	
	/**
	 * The trade repository at which the trade was reported previous to the current trade repository.
	 */
	@RosettaEnumValue(value = "PriorTradeRepository") 
	PRIOR_TRADE_REPOSITORY("PriorTradeRepository", null),
	
	/**
	 * The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR
	 */
	@RosettaEnumValue(value = "PTRRServiceProvider") 
	PTRR_SERVICE_PROVIDER("PTRRServiceProvider", null),
	
	/**
	 * The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade.
	 */
	@RosettaEnumValue(value = "PublicationVenue") 
	PUBLICATION_VENUE("PublicationVenue", null),
	
	/**
	 * The party with the regulatory responsibility to report this trade.
	 */
	@RosettaEnumValue(value = "ReportingParty") 
	REPORTING_PARTY("ReportingParty", null),
	
	/**
	 * Organization officially attached to the reporting party  e.g. partner, branch, subsidiary.
	 */
	@RosettaEnumValue(value = "ReportingPartyAffiliate") 
	REPORTING_PARTY_AFFILIATE("ReportingPartyAffiliate", null),
	
	/**
	 * The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
	 */
	@RosettaEnumValue(value = "ReportingPartyUltimateParent") 
	REPORTING_PARTY_ULTIMATE_PARENT("ReportingPartyUltimateParent", null),
	
	/**
	 * A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the &#39;Sell side&#39;; for that, see the &#39;Executing Broker&#39; role. Corresponds to &#39;Seller&#39; as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16.
	 */
	@RosettaEnumValue(value = "Seller") 
	SELLER("Seller", null),
	
	/**
	 * The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to &#39;seller decision maker&#39; as defined in ESMA&#39;s MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the &#39;Sell side&#39;; for that, see the &#39;Trader&#39; person role.
	 */
	@RosettaEnumValue(value = "SellerDecisionMaker") 
	SELLER_DECISION_MAKER("SellerDecisionMaker", null),
	
	/**
	 * The party that receives credit support under New York or English Law.
	 */
	@RosettaEnumValue(value = "SecuredParty") 
	SECURED_PARTY("SecuredParty", null),
	
	/**
	 * The organization that makes or receives payments on behalf of the given principal party.
	 */
	@RosettaEnumValue(value = "SettlementAgent") 
	SETTLEMENT_AGENT("SettlementAgent", null),
	
	/**
	 * An organization that maintains records of the trade for regulatory reporting purposes.
	 */
	@RosettaEnumValue(value = "TradeRepository") 
	TRADE_REPOSITORY("TradeRepository", null),
	
	/**
	 * The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR.
	 */
	@RosettaEnumValue(value = "TradeSource") 
	TRADE_SOURCE("TradeSource", null),
	
	/**
	 * The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory.
	 */
	@RosettaEnumValue(value = "TradingManager") 
	TRADING_MANAGER("TradingManager", null),
	
	/**
	 * An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions.
	 */
	@RosettaEnumValue(value = "TradingPartner") 
	TRADING_PARTNER("TradingPartner", null),
	
	/**
	 * A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services.
	 */
	@RosettaEnumValue(value = "TripartyAgent") 
	TRIPARTY_AGENT("TripartyAgent", null),
	
	/**
	 * A third-party providing custody, settlement, segregation and reporting services.
	 */
	@RosettaEnumValue(value = "ThirdPartyCustodian") 
	THIRD_PARTY_CUSTODIAN("ThirdPartyCustodian", null)
;
	private static Map<String, PartyRoleEnum> values;
	static {
        Map<String, PartyRoleEnum> map = new ConcurrentHashMap<>();
		for (PartyRoleEnum instance : PartyRoleEnum.values()) {
			map.put(instance.toDisplayString(), instance);
		}
		values = Collections.unmodifiableMap(map);
    }

	private final String rosettaName;
	private final String displayName;

	PartyRoleEnum(String rosettaName, String displayName) {
		this.rosettaName = rosettaName;
		this.displayName = displayName;
	}

	public static PartyRoleEnum fromDisplayName(String name) {
		PartyRoleEnum value = values.get(name);
		if (value == null) {
			throw new IllegalArgumentException("No enum constant with display name \"" + name + "\".");
		}
		return value;
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	public String toDisplayString() {
		return displayName != null ?  displayName : rosettaName;
	}
}
