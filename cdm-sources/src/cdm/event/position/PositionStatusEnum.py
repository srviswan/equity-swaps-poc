# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PositionStatusEnum']

class PositionStatusEnum(Enum):
    """
    Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
    """
    CANCELLED = "Cancelled"
    """
    The position has been cancelled, in case of a cancellation event following an execution.
    """
    CLOSED = "Closed"
    """
    The position has been closed, in case of a termination event.
    """
    EXECUTED = "Executed"
    """
    The position has been executed, which is the point at which risk has been transferred.
    """
    FORMED = "Formed"
    """
    Contract has been formed, in case position is on a contractual product.
    """
    SETTLED = "Settled"
    """
    The position has settled, in case product is subject to settlement after execution, such as securities.
    """
