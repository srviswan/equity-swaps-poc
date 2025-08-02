# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['NaturalPersonRoleEnum']

class NaturalPersonRoleEnum(Enum):
    """
    The enumerated values for the natural person's role.
    """
    BROKER = "Broker"
    """
    The person who arranged with a client to execute the trade.
    """
    BUYER = "Buyer"
    """
    Acquirer of the legal title to the financial instrument.
    """
    DECISION_MAKER = "DecisionMaker"
    """
    The party or person with legal responsibility for authorization of the execution of the transaction.
    """
    EXECUTION_WITHIN_FIRM = "ExecutionWithinFirm"
    """
    Person within the firm who is responsible for execution of the transaction.
    """
    INVESTMENT_DECISION_MAKER = "InvestmentDecisionMaker"
    """
    Person who is responsible for making the investment decision.
    """
    SELLER = "Seller"
    """
    Seller of the legal title to the financial instrument.
    """
    TRADER = "Trader"
    """
    The person who executed the trade.
    """
