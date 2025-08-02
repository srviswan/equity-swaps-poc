# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditSeniorityEnum']

class CreditSeniorityEnum(Enum):
    """
    Seniority of debt instruments comprising the index.
    """
    OTHER = "Other"
    """
    Other as defined under EMIR.
    """
    SENIOR_LOSS_ABSORBING_CAPACITY = "SeniorLossAbsorbingCapacity"
    """
    Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC).
    """
    SENIOR_SEC = "SeniorSec"
    """
    Senior domestic (RED Tier Code: SECDOM).
    """
    SENIOR_UN_SEC = "SeniorUnSec"
    """
    Senior foreign (RED Tier Code: SNRFOR).
    """
    SUB_LOWER_TIER_2 = "SubLowerTier2"
    """
    Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2).
    """
    SUB_TIER_1 = "SubTier1"
    """
    Subordinate Tier 1 (RED Tier Code: PREFT1).
    """
    SUB_TIER_3 = "SubTier3"
    """
    Subordinate, Tier 3.
    """
    SUB_UPPER_TIER_2 = "SubUpperTier2"
    """
    Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2).
    """
