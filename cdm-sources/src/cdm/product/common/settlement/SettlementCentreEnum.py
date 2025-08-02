# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SettlementCentreEnum']

class SettlementCentreEnum(Enum):
    """
    Defines the settlement centre for a securities transaction.
    """
    CLEARSTREAM_BANKING_LUXEMBOURG = "ClearstreamBankingLuxembourg"
    """
    ClearStream Banking Luxembourg
    """
    EUROCLEAR_BANK = "EuroclearBank"
    """
    Euroclear Bank
    """
