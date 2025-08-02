# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AlternativeToInterestAmountEnum']

class AlternativeToInterestAmountEnum(Enum):
    """
    If there is an alternative to interest amounts, how is it specified?
    """
    ACTUAL_AMOUNT_RECEIVED = "ActualAmountReceived"
    """
    The standard calculation of the Interest Amount is replaced with the amount of interest the secured party actually receives in relation to the Cash collateral.
    """
    OTHER = "Other"
    """
    An other alternative option outside these choices that can be described as an alternative provision.
    """
    STANDARD = "Standard"
    """
    Interest amount is not transferred if transfer would create or increase a delivery amount.
    """
    TRANSFER_IF_DELIVERY_AMOUNT_BELOW_MTA = "TransferIfDeliveryAmountBelowMTA"
    """
    Interest amount is not transferred if transfer would create or increase a delivery amount. (This is the 'Standard' provision). However, interest Amount will be transferred if Delivery Amount is below Minimum Transfer Amount.
    """
