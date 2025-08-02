# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DividendAmountTypeEnum']

class DividendAmountTypeEnum(Enum):
    """
    The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
    """
    AS_SPECIFIED_IN_MASTER_CONFIRMATION = "AsSpecifiedInMasterConfirmation"
    """
    The Amount is determined as provided in the relevant Master Confirmation.
    """
    EX_AMOUNT = "ExAmount"
    """
    The ex-date for a dividend occurs during a dividend period.
    """
    PAID_AMOUNT = "PaidAmount"
    """
    The payment date for a dividend occurs during a dividend period.
    """
    RECORD_AMOUNT = "RecordAmount"
    """
    The record date for a dividend occurs during a dividend period.
    """
