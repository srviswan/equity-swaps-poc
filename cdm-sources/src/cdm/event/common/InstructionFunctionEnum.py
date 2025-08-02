# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InstructionFunctionEnum']

class InstructionFunctionEnum(Enum):
    """
    The enumeration values indicating the BusinessEvent function associated input instructions.
    """
    COMPRESSION = "Compression"
    CONTRACT_FORMATION = "ContractFormation"
    EXECUTION = "Execution"
    QUANTITY_CHANGE = "QuantityChange"
    RENEGOTIATION = "Renegotiation"
