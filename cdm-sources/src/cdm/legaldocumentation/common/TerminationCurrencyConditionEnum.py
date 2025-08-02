# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TerminationCurrencyConditionEnum']

class TerminationCurrencyConditionEnum(Enum):
    FREELY_AVAILABLE = "FreelyAvailable"
    """
    A currency that is freely available.
    """
    PAYMENTS_DUE = "PaymentsDue"
    """
    A currency in which payments would be due under one or more Transactions.
    """
    PAYMENTS_DUE_AND_FREELY_AVAILABLE = "PaymentsDueAndFreelyAvailable"
    """
    A currency in which payments would be due under one or more Transactions and that is freely available.
    """
    SPECIFIED = "Specified"
    """
    Termination Currency Conditions are specified.
    """
