# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['WarehouseIdentityEnum']

class WarehouseIdentityEnum(Enum):
    DTCC_TIW_GOLD = "DTCC_TIW_Gold"
    """
    The DTCC Trade Information Warehouse Gold service
    """
