# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DeliveryMethodEnum']

class DeliveryMethodEnum(Enum):
    """
    Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
    """
    DELIVERY_VERSUS_PAYMENT = "DeliveryVersusPayment"
    """
    Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other.
    """
    FREE_OF_PAYMENT = "FreeOfPayment"
    """
    Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa.
    """
    PRE_DELIVERY = "PreDelivery"
    """
    Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment.
    """
    PRE_PAYMENT = "PrePayment"
    """
    Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment.
    """
