# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CallTypeEnum']

class CallTypeEnum(Enum):
    """
    Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call.
    """
    EXPECTED_CALL = "ExpectedCall"
    """
    Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement.
    """
    MARGIN_CALL = "MarginCall"
    """
    Identifies an actionable Margin Call.
    """
    NOTIFICATION = "Notification"
    """
    Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent.
    """
