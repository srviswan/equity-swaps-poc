# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditRiskEnum']

class CreditRiskEnum(Enum):
    """
    Represents an enumeration list to identify tranched or untranched credit risk.
    """
    TRANCHED_CREDIT_RISK = "TranchedCreditRisk"
    """
    Indicates tranched credit risk, including securitizations.
    """
    UNTRANCHED_CREDIT_RISK = "UntranchedCreditRisk"
    """
    Indicates tranched credit risk, including repackagings.
    """
