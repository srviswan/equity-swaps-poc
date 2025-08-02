# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PriceOperandEnum']

class PriceOperandEnum(Enum):
    ACCRUED_INTEREST = "AccruedInterest"
    COMMISSION = "Commission"
    FORWARD_POINT = "ForwardPoint"
