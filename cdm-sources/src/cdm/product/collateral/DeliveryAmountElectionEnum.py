# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DeliveryAmountElectionEnum']

class DeliveryAmountElectionEnum(Enum):
    """
    The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language.
    """
    LAST_AND_ANY_LOCAL_BUSINESS_DAY = "LastAndAnyLocalBusinessDay"
    """
    The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.`
    """
    LAST_LOCAL_BUSINESS_DAY = "LastLocalBusinessDay"
    """
    The delivery only includes `Transfer on last Local Business Day.
    """
