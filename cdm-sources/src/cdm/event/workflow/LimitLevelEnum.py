# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['LimitLevelEnum']

class LimitLevelEnum(Enum):
    """
    The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification.
    """
    ACCOUNT = "Account"
    """
    The limit is set in relation to the proprietary business undertaken by the clearing counterparty.
    """
    CUSTOMER = "Customer"
    """
    The limit is set in relation to the customer business undertaken by the clearing counterparty.
    """
    HOUSE = "House"
    """
    The limit is set at the account level in relation to the clearing counterparty.
    """
