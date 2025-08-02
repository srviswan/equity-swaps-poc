# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RegMarginTypeEnum']

class RegMarginTypeEnum(Enum):
    """
    Represents the enumeration values to specify the margin type in relation to bilateral or regulatory obligation.
    """
    NON_REG_IM = "NonRegIM"
    """
    Indicates Non Regulatory Initial margin or independent amount
    """
    REG_IM = "RegIM"
    """
    Indicates Regulatory Initial Margin
    """
    VM = "VM"
    """
    Indicates Variation Margin
    """
