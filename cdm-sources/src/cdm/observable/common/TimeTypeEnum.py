# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TimeTypeEnum']

class TimeTypeEnum(Enum):
    """
    The enumerated values to specify points in the day when option exercise and valuation can occur.
    """
    AS_SPECIFIED_IN_MASTER_CONFIRMATION = "AsSpecifiedInMasterConfirmation"
    """
    The time is determined as provided in the relevant Master Confirmation.
    """
    CLOSE = "Close"
    """
    The official closing time of the exchange on the valuation date.
    """
    DERIVATIVES_CLOSE = "DerivativesClose"
    """
    The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
    """
    OSP = "OSP"
    """
    The time at which the official settlement price is determined.
    """
    OPEN = "Open"
    """
    The official opening time of the exchange on the valuation date.
    """
    SPECIFIC_TIME = "SpecificTime"
    """
    The time specified in the element equityExpirationTime or valuationTime (as appropriate).
    """
    XETRA = "XETRA"
    """
    The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
    """
