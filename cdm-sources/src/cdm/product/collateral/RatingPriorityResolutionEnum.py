# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RatingPriorityResolutionEnum']

class RatingPriorityResolutionEnum(Enum):
    """
    Represents an enumeration list to identify which Collateral Criteria type should have priority over others. If set to 'Issuer', the rating in the 
    Issuer Criteria has priority or is used if there is no Asset criteria. If set to 'Asset', the rating in the Asset Criteria has priority or is used if there is no Issuer rating.
    """
    ASSET = "Asset"
    """
    Denotes that the Asset Criteria has priority.
    """
    AVERAGE = "Average"
    """
    Denotes that average rating should be used if several criteria apply.
    """
    HIGHEST = "Highest"
    """
    Denotes that highest rating should be used if several criteria apply.
    """
    ISSUER = "Issuer"
    """
    Denotes that the Issuer Criteria has priority.
    """
    LOWEST = "Lowest"
    """
    Denotes that lowest rating should be used if several criteria apply.
    """
