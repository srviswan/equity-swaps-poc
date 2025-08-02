# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DividendEntitlementEnum']

class DividendEntitlementEnum(Enum):
    """
    The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend.
    """
    EX_DATE = "ExDate"
    """
    Dividend entitlement is on the dividend ex-date.
    """
    RECORD_DATE = "RecordDate"
    """
    Dividend entitlement is on the dividend record date.
    """
