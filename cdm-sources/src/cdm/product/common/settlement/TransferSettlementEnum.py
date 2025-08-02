# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TransferSettlementEnum']

class TransferSettlementEnum(Enum):
    """
    The enumeration values to specify how the transfer will settle, e.g. DvP.
    """
    DELIVERY_VERSUS_DELIVERY = "DeliveryVersusDelivery"
    """
    Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
    """
    DELIVERY_VERSUS_PAYMENT = "DeliveryVersusPayment"
    """
    Settlement in which the transfer of the asset and the cash settlement are simultaneous.
    """
    NOT_CENTRAL_SETTLEMENT = "NotCentralSettlement"
    """
    No central settlement.
    """
    PAYMENT_VERSUS_PAYMENT = "PaymentVersusPayment"
    """
    Simultaneous transfer of cashflows.
    """
