# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MarketDisruptionEnum']

class MarketDisruptionEnum(Enum):
    """
    The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
    """
    MODIFIED_POSTPONEMENT = "ModifiedPostponement"
    """
    As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
    """
    OMISSION = "Omission"
    """
    As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
    """
    POSTPONEMENT = "Postponement"
    """
    As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
    """
