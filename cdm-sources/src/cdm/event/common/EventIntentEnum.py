# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['EventIntentEnum']

class EventIntentEnum(Enum):
    """
    The enumeration values to qualify the intent associated with a transaction event.
    """
    ALLOCATION = "Allocation"
    """
    The intent is to allocate one or more trades as part of an allocated block trade.
    """
    CASH_FLOW = "CashFlow"
    """
    The intent is to designate a stand-alone cash transfer as a result of Trade contracual terms e.g. incurred by payout for instance a Performance Amount or a Floating Rate Amount. The particular CashFlow at stake shall be further specified in priceTransferEnum or transferTypeEnum. For clarity, such intentEnum value shall not be used whenever a cash transfer is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. Decrease with Fees, Cross-Currency Notional Reset, etc. or any other Event whenever including a cash transfer with other features. For clarity, a principal payment related to a Principal Exhange is excluded as well, because a dedicated intentEnum value exists for this event i.e. PrincipalExchange value.
    """
    CLEARING = "Clearing"
    """
    The intent is to clear the contract.
    """
    COMPRESSION = "Compression"
    """
    The intent is to compress multiple trades as part of a netting or compression event.
    """
    CONTRACT_FORMATION = "ContractFormation"
    """
    The intent is to form a contract from an execution.
    """
    CONTRACT_TERMS_AMENDMENT = "ContractTermsAmendment"
    """
    The intent is to amend the terms of the contract through renegotiation.
    """
    CORPORATE_ACTION_ADJUSTMENT = "CorporateActionAdjustment"
    """
    The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
    """
    CREDIT_EVENT = "CreditEvent"
    """
    The intent is to take into effect the occurrence of a Credit Event.
    """
    DECREASE = "Decrease"
    """
    The intent is to Decrease the quantity or notional of the contract.
    """
    EARLY_TERMINATION_PROVISION = "EarlyTerminationProvision"
    """
    The intent is to fully unwind the Trade, as a result of the application of Trade contractual terms (e.g. an obligation to do so before Termination Date as part of any kind of Early Termination terms) as defined within the CDM EarlyTerminationProvision data type. Accordingly, increase and decrease of positions which result from negotiation by the parties shall not be designated by such intentEnum. For clarity, partial exercise of an option before its expiration date is excluded as well, though related to Trade contract terms, because a dedicated intentEnum value exists for this event i.e. OptionExercise value.
    """
    INCREASE = "Increase"
    """
    The intent is to Increase the quantity or notional of the contract.
    """
    INDEX_TRANSITION = "IndexTransition"
    """
    The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any). 
    """
    NOTIONAL_RESET = "NotionalReset"
    """
    The intent is to increase or to decrease the notional of the Trade, in accordance with Notional Reset features e.g. could apply for Cross Currency Swaps, Equity Performance Swaps, etc.
    """
    NOTIONAL_STEP = "NotionalStep"
    """
    The intent is to increase or to decrease the notional of the Trade, in accordance with Step features attached to a Payout Quantity.
    """
    NOVATION = "Novation"
    """
    The intent is to novate the contract.
    """
    OBSERVATION_RECORD = "ObservationRecord"
    """
    The intent is to record any kind of stand-alone obervervations e.g. internal data recording, usage of CDM for recording and/or exchanging data as part of pricing 'consensus' processing, etc. For clarity, such intentEnum value shall not be used whenever an observation is not stand-alone but is instead embedded in another Event as part of the composable modelling e.g. CashFlow to which an observation of prices is associated, etc.
    """
    OPTION_EXERCISE = "OptionExercise"
    """
    The intent is to Exercise a contract that is made of one or several option payout legs. For clarity, such intentEnum value shall not be used whenever an optional right is exercised in relation with a Trade which composition includes other types of payout legs e.g. right to call or to cancel before Termination Date as part of any kind of Early Termination terms other than genuine bermuda or american style features described in option payout. 
    """
    OPTIONAL_CANCELLATION = "OptionalCancellation"
    """
    The intent is to cancel the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
    """
    OPTIONAL_EXTENSION = "OptionalExtension"
    """
    The intent is to extend the trade through exercise of an optional right as defined within the CDM OptionProvision data type.
    """
    PORTFOLIO_REBALANCING = "PortfolioRebalancing"
    """
    The intent is to rebalance a portfolio, by inserting new derivatives transactions into portfolios of participants to reduce risks linked to those trades. These are offsetting trades that rebalance relationships between different counterparties when it comes to exposure of portfolios to certain types of risk, such as interest rate risk.
    """
    PRINCIPAL_EXCHANGE = "PrincipalExchange"
    """
    The intent is to pay or to receive a cash transfer, in accordance with Principal Exchange features.
    """
    REALLOCATION = "Reallocation"
    """
    The intent is to reallocate one or more trades as part of an allocated block trade.
    """
    REPURCHASE = "Repurchase"
    """
    The intent is to close a repo transaction through repurchase.
    """
