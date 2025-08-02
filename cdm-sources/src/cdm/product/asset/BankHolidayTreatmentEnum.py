# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['BankHolidayTreatmentEnum']

class BankHolidayTreatmentEnum(Enum):
    """
    Defines whether the bank holidays are treated as weekdays or weekends in terms of delivery profile in the context of commodity products, in particular those with peak or off-peak delivery profiles.
    """
    AS_WEEKDAY = "AsWeekday"
    """
    Bank holidays treated as weekdays.
    """
    AS_WEEKEND = "AsWeekend"
    """
    Bank holidays treated as weekends.
    """
