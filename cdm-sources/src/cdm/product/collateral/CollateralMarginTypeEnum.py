# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CollateralMarginTypeEnum']

class CollateralMarginTypeEnum(Enum):
    """
    The enumerated values to specify the type of margin for which a legal agreement is named.
    """
    INITIAL_MARGIN = "InitialMargin"
    """
    Denotes a margin agreement that is identified for use with Initial Margin/IM.
    """
    VARIATION_MARGIN = "VariationMargin"
    """
    Denotes a margin agreement that is identified for use with Variation Margin/VM.
    """
