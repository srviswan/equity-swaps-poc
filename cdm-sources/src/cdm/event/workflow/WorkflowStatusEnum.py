# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['WorkflowStatusEnum']

class WorkflowStatusEnum(Enum):
    ACCEPTED = "Accepted"
    AFFIRMED = "Affirmed"
    ALLEGED = "Alleged"
    AMENDED = "Amended"
    CANCELLED = "Cancelled"
    CERTAIN = "Certain"
    CLEARED = "Cleared"
    CONFIRMED = "Confirmed"
    PENDING = "Pending"
    REJECTED = "Rejected"
    SUBMITTED = "Submitted"
    TERMINATED = "Terminated"
    UNCERTAIN = "Uncertain"
    UNCONFIRMED = "Unconfirmed"
