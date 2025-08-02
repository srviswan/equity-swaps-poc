# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RecordAmountTypeEnum']

class RecordAmountTypeEnum(Enum):
    """
    The enumeration of the account level for the billing summary.
    """
    ACCOUNT_TOTAL = "AccountTotal"
    GRAND_TOTAL = "GrandTotal"
    PARENT_TOTAL = "ParentTotal"
