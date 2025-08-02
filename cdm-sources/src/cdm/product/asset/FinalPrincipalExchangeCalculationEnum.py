# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['FinalPrincipalExchangeCalculationEnum']

class FinalPrincipalExchangeCalculationEnum(Enum):
    """
    To be specified only for products that embed a redemption payment.
    """
    FLOORED = "Floored"
    """
    If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base).
    """
    NON_FLOORED = "NonFloored"
    """
    If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base.
    """
