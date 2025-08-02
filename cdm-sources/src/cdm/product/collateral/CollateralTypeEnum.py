# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CollateralTypeEnum']

class CollateralTypeEnum(Enum):
    """
    Specifies the types of collateral that are accepted by the Lender
    """
    CASH = "Cash"
    """
    Security Lending Trades against Cash collateral
    """
    CASH_POOL = "CashPool"
    """
    Security Lending Trades against CashPool collateral
    """
    NON_CASH = "NonCash"
    """
    Security Lending Trades against NonCash collateral
    """
