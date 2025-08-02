# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DayTypeEnum']

class DayTypeEnum(Enum):
    """
    Lists the enumerated values to specify the day type classification used in counting the number of days between two dates.
    """
    BUSINESS = "Business"
    """
    Applies when calculating the number of days between two dates the count includes only business days.
    """
    CALENDAR = "Calendar"
    """
    Applies when calculating the number of days between two dates the count includes all calendar days.
    """
    CURRENCY_BUSINESS = "CurrencyBusiness"
    """
    Applies when calculating the number of days between two dates the count includes only currency business days.
    """
    EXCHANGE_BUSINESS = "ExchangeBusiness"
    """
    Applies when calculating the number of days between two dates the count includes only stock exchange business days.
    """
    SCHEDULED_TRADING_DAY = "ScheduledTradingDay"
    """
    Applies when calculating the number of days between two dates the count includes only scheduled trading days.
    """
