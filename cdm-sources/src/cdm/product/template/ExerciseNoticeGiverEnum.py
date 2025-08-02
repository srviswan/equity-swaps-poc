# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ExerciseNoticeGiverEnum']

class ExerciseNoticeGiverEnum(Enum):
    """
    Defines the principal party to the trade that has the right to exercise.
    """
    AS_SPECIFIED_IN_MASTER_AGREEMENT = "AsSpecifiedInMasterAgreement"
    """
    Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
    """
    BOTH = "Both"
    """
    Specifies that both the option buyer and option seller has the right to exercise.
    """
    BUYER = "Buyer"
    """
    Specifies that only the option buyer has the right to exercise.
    """
    SELLER = "Seller"
    """
    Specifies that only the option seller has the right to exercise.
    """
