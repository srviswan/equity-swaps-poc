# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DeterminationMethodEnum']

class DeterminationMethodEnum(Enum):
    """
    The enumerated values to specify the method according to which an amount or a date is determined.
    """
    AGREED_INITIAL_PRICE = "AgreedInitialPrice"
    """
    Agreed separately between the parties.
    """
    AS_SPECIFIED_IN_MASTER_CONFIRMATION = "AsSpecifiedInMasterConfirmation"
    """
    As specified in Master Confirmation.
    """
    CALCULATION_AGENT = "CalculationAgent"
    """
    Determined by the Calculation Agent.
    """
    CLOSING_PRICE = "ClosingPrice"
    """
    Official Closing Price.
    """
    DIVIDEND_CURRENCY = "DividendCurrency"
    """
    Determined by the Currency of Equity Dividends.
    """
    EXPIRING_CONTRACT_LEVEL = "ExpiringContractLevel"
    """
    The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
    """
    HEDGE_EXECUTION = "HedgeExecution"
    """
    Determined by the Hedging Party.
    """
    ISSUER_PAYMENT_CURRENCY = "IssuerPaymentCurrency"
    """
    Issuer Payment Currency.
    """
    NAV = "NAV"
    """
    Net Asset Value.
    """
    OSP_PRICE = "OSPPrice"
    """
    OSP Price.
    """
    OPEN_PRICE = "OpenPrice"
    """
    Opening Price of the Market.
    """
    SETTLEMENT_CURRENCY = "SettlementCurrency"
    """
    Settlement Currency.
    """
    STRIKE_DATE_DETERMINATION = "StrikeDateDetermination"
    """
    Date on which the strike is determined in respect of a forward starting swap.
    """
    TWAP_PRICE = "TWAPPrice"
    """
    Official TWAP Price.
    """
    VWAP_PRICE = "VWAPPrice"
    """
    Official VWAP Price.
    """
    VALUATION_TIME = "ValuationTime"
    """
    Price determined at valuation time.
    """
