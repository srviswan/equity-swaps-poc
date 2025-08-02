# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ExecutionTypeEnum']

class ExecutionTypeEnum(Enum):
    """
    The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ...
    """
    ELECTRONIC = "Electronic"
    """
    Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message.
    """
    OFF_FACILITY = "OffFacility"
    """
    Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
    """
    ON_VENUE = "OnVenue"
    """
    Execution via a platform that may or may not be covered by a regulatory defintion. OnVenue is intended to distinguish trades executed on a trading platform from those executed via phone, email or messaging apps. The role and details of the venue are included in the party attribute of the trade. The general rule is that if the parties utilitzed the services of the platform to execute the trade then it would be considered OnVenue.
    """
