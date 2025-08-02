# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PriceExpressionEnum']

class PriceExpressionEnum(Enum):
    """
    Enumerated values to specify whether the price is expressed in absolute or relative terms.
    """
    ABSOLUTE_TERMS = "AbsoluteTerms"
    """
    The price is expressed as an absolute amount.
    """
    PAR_VALUE_FRACTION = "ParValueFraction"
    """
    Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
    """
    PER_OPTION = "PerOption"
    """
    Denotes a price expressed per number of options.
    """
    PERCENTAGE_OF_NOTIONAL = "PercentageOfNotional"
    """
    The price is expressed in percentage of the notional amount.
    """
