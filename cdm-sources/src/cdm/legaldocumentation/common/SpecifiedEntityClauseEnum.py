# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SpecifiedEntityClauseEnum']

class SpecifiedEntityClauseEnum(Enum):
    """
    The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined.
    """
    BANKRUPTCY = "Bankruptcy"
    CREDIT_EVENT_UPON_MERGER = "CreditEventUponMerger"
    CROSS_DEFAULT = "CrossDefault"
    DEFAULT_UNDER_SPECIFIED_TRANSACTION = "DefaultUnderSpecifiedTransaction"
