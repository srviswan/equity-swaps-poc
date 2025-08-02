# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['QuoteBasisEnum']

class QuoteBasisEnum(Enum):
    """
    The enumerated values to specify how an exchange rate is quoted.
    """
    CURRENCY_1_PER_CURRENCY_2 = "Currency1PerCurrency2"
    """
    The amount of currency1 for one unit of currency2
    """
    CURRENCY_2_PER_CURRENCY_1 = "Currency2PerCurrency1"
    """
    The amount of currency2 for one unit of currency1
    """
