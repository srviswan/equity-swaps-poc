# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ClosedStateEnum']

class ClosedStateEnum(Enum):
    """
    The enumerated values to specify what led to the contract or execution closure.
    """
    ALLOCATED = "Allocated"
    """
    The execution or contract has been allocated.
    """
    CANCELLED = "Cancelled"
    """
    The execution or contract has been cancelled.
    """
    EXERCISED = "Exercised"
    """
    The (option) contract has been exercised.
    """
    EXPIRED = "Expired"
    """
    The (option) contract has expired without being exercised.
    """
    MATURED = "Matured"
    """
    The contract has reached its contractual termination date.
    """
    NOVATED = "Novated"
    """
    The contract has been novated. This state applies to the stepped-out contract component of the novation event.
    """
    TERMINATED = "Terminated"
    """
    The contract has been subject of an early termination event.
    """
