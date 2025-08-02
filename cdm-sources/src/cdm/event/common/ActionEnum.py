# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ActionEnum']

class ActionEnum(Enum):
    """
    The enumeration values to specify the actions associated with transactions.
    """
    CANCEL = "Cancel"
    """
    A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
    """
    CORRECT = "Correct"
    """
    A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
    """
    NEW = "New"
    """
    A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
    """
