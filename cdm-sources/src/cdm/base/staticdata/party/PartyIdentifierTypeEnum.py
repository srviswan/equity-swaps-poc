# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PartyIdentifierTypeEnum']

class PartyIdentifierTypeEnum(Enum):
    """
    The enumeration values associated with party identifier sources.
    """
    BIC = "BIC"
    """
    The Bank Identifier Code.
    """
    LEI = "LEI"
    """
    The ISO 17442:2012 Legal Entity Identifier.
    """
    MIC = "MIC"
    """
    The ISO 10383 Market Identifier Code (MIC).
    """
