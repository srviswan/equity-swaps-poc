# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PartyRoleEnum']

class PartyRoleEnum(Enum):
    """
    The enumerated values for the party role. The enumerated values go beyond the FpML partyRoleScheme as they also include elements that are part of the FpML Trade, such as the Barrier Determination Agent and the Hedging Party.
    """
    ACCOUNTANT = "Accountant"
    """
    Organization responsible for preparing the accounting for the trade.
    """
    AGENT_LENDER = "AgentLender"
    """
    An agent who lends securities of its principals under stock lending arrangements.
    """
    ALLOCATION_AGENT = "AllocationAgent"
    """
    The organization responsible for supplying the allocations for a trade to be allocated to multiple accounts/organizations.
    """
    ARRANGING_BROKER = "ArrangingBroker"
    """
    The organization that arranged the trade, i.e. brought together the counterparties.  Synonyms/Alternatives: Inter-dealer broker, agent.
    """
    BARRIER_DETERMINATION_AGENT = "BarrierDeterminationAgent"
    """
    The party specified in the related confirmation as Barrier Determination Agent.
    """
    BENEFICIAL_OWNER = "BeneficialOwner"
    """
    The party that lends out securities under stock lending arrangements via an Agent Lender.
    """
    BENEFICIARY = "Beneficiary"
    """
    Organization that suffers the economic benefit of the trade.  The beneficiary may be distinct from the principal/counterparty - an example occurs when a hedge fund trades via a prime broker; in this case the principal is the prime broker, but the beneficiary is the hedge fund.  This can be represented as a payer/receiver account in the name of the hedge fund, but it is also possible to add the party role of 'Beneficiary' at the partyTradeInformation level.
    """
    BOOKING_PARTY = "BookingParty"
    """
    The entity for which the organization supporting the trade's processing has booked/recorded the trade. This is used in non-reporting workflows situations in which the trade doesn't need to be reported but a firm still wants to specify their own side.
    """
    BORROWER = "Borrower"
    """
    The party that borrows securities under stock lending arrangements.
    """
    BUYER = "Buyer"
    """
    Acquirer of the legal title to the financial instrument. In the case of an option, the buyer is the holder of the option. In the case of a swap or forward, the buyer will be determined by industry best practice.  This does not refer to an investor or investment manager or other organization on what is typically called  the 'Buy side'; for that, see the 'Client' role. Corresponds to 'Buyer' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 9.
    """
    BUYER_DECISION_MAKER = "BuyerDecisionMaker"
    """
    The party or person who, having legal authority to act on behalf of the trade counterparty acting as Buyer as defined in this coding scheme, made the decision to acquire the financial instrument. Corresponds to 'buyer decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Buy side'; for that, see the 'Client Decision Maker' role.
    """
    CHARGOR = "Chargor"
    """
    The party that provides credit support under English Law.
    """
    CLEARING_CLIENT = "ClearingClient"
    """
    An organization that clears trades through a clearing house, via a clearing broker (member of the clearing house) who acts as an agent on its behalf. The term 'client' refers to the organization's role in the clearing process in relation to its clearing broker, and not whether it is a price maker or taker in the execution process.
    """
    CLEARING_EXCEPTION_PARTY = "ClearingExceptionParty"
    """
    A party to the trade that claims a clearing exception, such as an end-user exception under Dodd-Frank Act provisions.
    """
    CLEARING_FIRM = "ClearingFirm"
    """
    Organization that submits the trade to a clearing house on behalf of the principal. Synonyms/alternates: Futures Commission Merchant (FCM), Clearing Broker, Clearing Member Firm. Some implementations use 'Clearing Broker' as synonym.
    """
    CLEARING_ORGANIZATION = "ClearingOrganization"
    """
    The organization that acts as a central counterparty to clear a derivatives contract.  This is used to represent the role of Central Counterparties (CCPs) or Derivative Clearing Organizations (DCOs).  Sometimes called 'ClearingService'. Some implementations also use the term 'Clearer'.
    """
    CLIENT = "Client"
    """
    Client as defined under ESMA MIFIR. This is generally the investor or other client of an investment firm, and is synonymous with the Beneficiary in many circumstances.
    """
    CLIENT_DECISION_MAKER = "ClientDecisionMaker"
    """
    The party or person who, having legal authority to act on behalf of a trade counterparty, made the decision to acquire or sell the financial instrument.
    """
    CONFIRMATION_PLATFORM = "ConfirmationPlatform"
    """
    Organization serving as a financial intermediary for the purposes of electronic confirmation or providing services for post-processing of transactional data.
    """
    CONTRACTUAL_PARTY = "ContractualParty"
    """
    A party to a contractual document.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
    """
    COUNTER_PARTY_AFFILIATE = "CounterPartyAffiliate"
    """
    Organization officially attached to the counterparty. e.g. partner, branch, subsidiary.
    """
    COUNTER_PARTY_ULTIMATE_PARENT = "CounterPartyUltimateParent"
    """
    The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
    """
    COUNTERPARTY = "Counterparty"
    """
    An economic counterparty to the trade. Synonym: principal.
    """
    CREDIT_SUPPORT_PROVIDER = "CreditSupportProvider"
    """
    Organization that enhances the credit of another organization (similar to guarantor, but may not fully guarantee the obligation).
    """
    CUSTODIAN = "Custodian"
    """
    Organization that maintains custody of the asset represented by the trade on behalf of the owner/principal.
    """
    DATA_SUBMITTER = "DataSubmitter"
    """
    Entity submitting the transaction report to the competent authority.
    """
    DETERMINING_PARTY = "DeterminingParty"
    """
    The party referenced is specified in the contract confirmation as Determination Party.
    """
    DISPUTING_PARTY = "DisputingParty"
    """
    Organization that is disputing the trade or transaction.
    """
    DOCUMENT_REPOSITORY = "DocumentRepository"
    """
    A marketplace organization which purpose is to maintain document records.  If the intended usage relates to the context of the trade lifecycle, more specific annotations have been defined which might be more appropriate.
    """
    EXECUTING_BROKER = "ExecutingBroker"
    """
    The (generally sell-side) organization that executed the trade; the price-making party.
    """
    EXECUTING_ENTITY = "ExecutingEntity"
    """
    Entity executing the transaction.  If the transaction is executed directly by the reporting party, it will be the reporting party.  If it is executed by an execution agent or an affiliated party on behalf of the reporting party, it will be that affiliate or agent.
    """
    EXECUTION_AGENT = "ExecutionAgent"
    """
    The (generally buy-side) organization that acts to execute trades on behalf of an investor. Typically this is an investment manager or asset manager, and also makes the investment decisions for the investor. If required, a separate InvestmentDecision role can be specified to distinguish that the party making the investment decision is different.
    """
    EXECUTION_FACILITY = "ExecutionFacility"
    """
    The facility, exchange, or market where the trade was executed. Synonym: Swap Execution Facility, Designated Contract Market, Execution Venue.
    """
    GUARANTOR = "Guarantor"
    """
    Organization that backs (guarantees) the credit risk of the trade.
    """
    HEDGING_PARTY = "HedgingParty"
    """
    The ISDA Hedging Party that is specified in the related confirmation as Hedging, or if no Hedging Party is specified, either party to the contract.
    """
    LENDER = "Lender"
    """
    The party that lends out securities under stock lending arrangements as principal.
    """
    ORDER_TRANSMITTER = "OrderTransmitter"
    """
    The entity transmitting the order to the reporting firm. Synonym: Transmitting Firm.
    """
    PTRR_SERVICE_PROVIDER = "PTRRServiceProvider"
    """
    The party that acts as either a portfolio compression or portfolio rebalancing service provider, as defined under ESMA MIFIR
    """
    PLEDGOR = "Pledgor"
    """
    The party that provides credit support under New York Law.
    """
    PRIME_BROKER = "PrimeBroker"
    """
    The organization that takes on or took on the credit risk for this trade by stepping in between the two economic parties (without a central counterparty clearing mechanism).
    """
    PRIOR_TRADE_REPOSITORY = "PriorTradeRepository"
    """
    The trade repository at which the trade was reported previous to the current trade repository.
    """
    PUBLICATION_VENUE = "PublicationVenue"
    """
    The reporting service (whether trade repository, market data service, or exchange/facility/venue data distribution service) that published the report of this trade.
    """
    REPORTING_PARTY = "ReportingParty"
    """
    The party with the regulatory responsibility to report this trade.
    """
    REPORTING_PARTY_AFFILIATE = "ReportingPartyAffiliate"
    """
    Organization officially attached to the reporting party  e.g. partner, branch, subsidiary.
    """
    REPORTING_PARTY_ULTIMATE_PARENT = "ReportingPartyUltimateParent"
    """
    The topmost entity or organization, within the corporate hierarchy, responsible for the reporting party.
    """
    SECURED_PARTY = "SecuredParty"
    """
    The party that receives credit support under New York or English Law.
    """
    SELLER = "Seller"
    """
    A counterparty in a trade, which performs in one of the following capacities: 1) it transfers or agrees to transfer in the future an instrument or title to that instrument in exchange for payment, 2) it writes a derivatives instrument such as an option or a swap in which it provides risk protection to the buyer. This does not refer to the broker/dealer or other organization on what is typically called  the 'Sell side'; for that, see the 'Executing Broker' role. Corresponds to 'Seller' as defined in certain regulations such as ESMA MiFID II/MIFIR RTS 22 field 16.
    """
    SELLER_DECISION_MAKER = "SellerDecisionMaker"
    """
    The party or person who, having legal authority to act on behalf of the trade counterparty acting as Seller as defined in this coding scheme, made the decision to sell the financial instrument. Corresponds to 'seller decision maker' as defined in ESMA's MIFIR RTS 23 report. This does not refer to the decision maker for what is traditionally called the 'Sell side'; for that, see the 'Trader' person role.
    """
    SETTLEMENT_AGENT = "SettlementAgent"
    """
    The organization that makes or receives payments on behalf of the given principal party.
    """
    THIRD_PARTY_CUSTODIAN = "ThirdPartyCustodian"
    """
    A third-party providing custody, settlement, segregation and reporting services.
    """
    TRADE_REPOSITORY = "TradeRepository"
    """
    An organization that maintains records of the trade for regulatory reporting purposes.
    """
    TRADE_SOURCE = "TradeSource"
    """
    The organization that originally supplied the record of the trade. In the context of regulatory reporting, it is the submitter of the trade record to a regulator or TR.
    """
    TRADING_MANAGER = "TradingManager"
    """
    The entity responsible for managing the assets/investments of this party.  Synonym:  Asset Manager, Investment Manager, Trading Advisory.
    """
    TRADING_PARTNER = "TradingPartner"
    """
    An entity with which this party trades from time to time, ie. with which it acts as a counterparty on some transactions.   This role is used for static reference data, not individual transactions.
    """
    TRIPARTY_AGENT = "TripartyAgent"
    """
    A third party entity that acts as an intermediary and provides automated clearing, settlement, allocation, valuation and reporting services.
    """
