# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MatrixTypeEnum']

class MatrixTypeEnum(Enum):
    """
    The enumerated values to specify the identification the form of applicable matrix.
    """
    CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX = "CreditDerivativesPhysicalSettlementMatrix"
    """
    The ISDA-published Credit Derivatives Physical Settlement Matrix.
    """
    EQUITY_DERIVATIVES_MATRIX = "EquityDerivativesMatrix"
    """
    The ISDA-published Equity Derivatives Matrix.
    """
    SETTLEMENT_MATRIX = "SettlementMatrix"
    """
    The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions.
    """
