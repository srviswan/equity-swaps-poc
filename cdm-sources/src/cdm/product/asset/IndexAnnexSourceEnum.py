# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['IndexAnnexSourceEnum']

class IndexAnnexSourceEnum(Enum):
    """
    The enumerated values to specify the CDX index annex source.
    """
    MASTER_CONFIRMATION = "MasterConfirmation"
    """
    As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
    """
    PUBLISHER = "Publisher"
    """
    As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
    """
