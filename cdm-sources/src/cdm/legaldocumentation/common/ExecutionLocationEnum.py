# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ExecutionLocationEnum']

class ExecutionLocationEnum(Enum):
    """
    The enumerated values to specify the Execution Location of a Security Agreement
    """
    EXECUTED_IN_BELGIUM = "ExecutedInBelgium"
    """
    The Agreement was executed outside of Belgium
    """
    EXECUTED_OUTSIDE_BELGIUM = "ExecutedOutsideBelgium"
    """
    The Agreement was executed outside of Belgium
    """
    OTHER_LOCATION = "OtherLocation"
    """
    An alternative approach is described in the document as follows.
    """
