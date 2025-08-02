# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PositionEventIntentEnum']

class PositionEventIntentEnum(Enum):
    CORPORATE_ACTION_ADJUSTMENT = "CorporateActionAdjustment"
    """
    The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
    """
    DECREASE = "Decrease"
    """
    The intent is to Decrease the quantity of the position.
    """
    INCREASE = "Increase"
    """
    The intent is to Increase the quantity of the position.
    """
    OPTION_EXERCISE = "OptionExercise"
    """
    The intent is to Exercise a position or part of a position.
    """
    POSITION_CREATION = "PositionCreation"
    """
    The intent is to form a position from a fully formed contract.
    """
    TRANSFER = "Transfer"
    """
    The intent is to transfer the position to another clearing member.
    """
    VALUATION = "Valuation"
    """
    The intent is to update the valuation of the position.
    """
