# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CommodityLocationIdentifierTypeEnum']

class CommodityLocationIdentifierTypeEnum(Enum):
    """
    Defines the enumerated values to specify the nature of a location identifier.
    """
    BUYER_HUB = "BuyerHub"
    """
    The hub code of the buyer.
    """
    DELIVERY_POINT = "DeliveryPoint"
    """
    The physical or virtual point at which the commodity will be delivered.
    """
    DELIVERY_ZONE = "DeliveryZone"
    """
    The zone covering potential delivery points for the commodity
    """
    ENTRY_POINT = "EntryPoint"
    """
    The physical or virtual point at which the commodity enters a transportation system.
    """
    INTERCONNECTION_POINT = "InterconnectionPoint"
    """
    Identification of the border(s) or border point(s) of a transportation contract.
    """
    SELLER_HUB = "SellerHub"
    """
    The hub code of the seller.
    """
    WITHDRAWAL_POINT = "WithdrawalPoint"
    """
    The physical or virtual point at which the commodity is withdrawn from a transportation system.
    """
