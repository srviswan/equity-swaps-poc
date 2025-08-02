# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DividendCompositionEnum']

class DividendCompositionEnum(Enum):
    """
    The enumerated values to specify how the composition of Dividends is to be determined.
    """
    CALCULATION_AGENT_ELECTION = "CalculationAgentElection"
    """
    The Calculation Agent determines the composition of dividends (subject to conditions).
    """
    EQUITY_AMOUNT_RECEIVER_ELECTION = "EquityAmountReceiverElection"
    """
    The Equity Amount Receiver determines the composition of dividends (subject to conditions).
    """
