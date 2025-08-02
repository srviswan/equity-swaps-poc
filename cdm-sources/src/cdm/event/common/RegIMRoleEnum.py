# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RegIMRoleEnum']

class RegIMRoleEnum(Enum):
    """
    Represents the enumeration values to specify the role of the party in relation to a regulatory initial margin call.
    """
    PLEDGOR = "Pledgor"
    """
    Indicates 'Pledgor' party of initial margin call.
    """
    SECURED = "Secured"
    """
    Indicates 'Secured' party of initial margin call.
    """
