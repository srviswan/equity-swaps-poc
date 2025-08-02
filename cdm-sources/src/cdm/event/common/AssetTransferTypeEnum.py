# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AssetTransferTypeEnum']

class AssetTransferTypeEnum(Enum):
    """
    The qualification of the type of asset transfer.
    """
    FREE_OF_PAYMENT = "FreeOfPayment"
    """
    The transfer of assets takes place without a corresponding exchange of payment.
    """
