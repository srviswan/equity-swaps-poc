# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['NationalizationOrInsolvencyOrDelistingEventEnum']

class NationalizationOrInsolvencyOrDelistingEventEnum(Enum):
    """
    Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
    """
    CANCELLATION_AND_PAYMENT = "CancellationAndPayment"
    """
    The trade is terminated.
    """
    NEGOTIATED_CLOSEOUT = "NegotiatedCloseout"
    """
    The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
    """
