# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['IndexEventConsequenceEnum']

class IndexEventConsequenceEnum(Enum):
    """
    The enumerated values to specify the consequences of Index Events.
    """
    CALCULATION_AGENT_ADJUSTMENT = "CalculationAgentAdjustment"
    """
    Calculation Agent Adjustment.
    """
    CANCELLATION_AND_PAYMENT = "CancellationAndPayment"
    """
    Cancellation and Payment.
    """
    NEGOTIATED_CLOSE_OUT = "NegotiatedCloseOut"
    """
    Negotiated Close Out.
    """
    RELATED_EXCHANGE = "RelatedExchange"
    """
    Related Exchange.
    """
