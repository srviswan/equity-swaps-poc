# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AccountTypeEnum']

class AccountTypeEnum(Enum):
    """
    The enumeration values to qualify the type of account.
    """
    AGGREGATE_CLIENT = "AggregateClient"
    """
    Aggregate client account, as defined under ESMA MiFIR.
    """
    CLIENT = "Client"
    """
    The account contains trading activity or positions that belong to a client of the firm that opened the account.
    """
    HOUSE = "House"
    """
    The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
    """
