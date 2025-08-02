# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CompareOp']

class CompareOp(Enum):
    EQUALS = "Equals"
    GREATER_THAN = "GreaterThan"
    GREATER_THAN_OR_EQUALS = "GreaterThanOrEquals"
    LESS_THAN = "LessThan"
    LESS_THAN_OR_EQUALS = "LessThanOrEquals"
