# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DeliveryNearbyTypeEnum']

class DeliveryNearbyTypeEnum(Enum):
    CALCULATION_PERIOD = "CalculationPeriod"
    """
    Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
    """
    NEARBY_MONTH = "NearbyMonth"
    """
    Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
    """
    NEARBY_WEEK = "NearbyWeek"
    """
    Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
    """
