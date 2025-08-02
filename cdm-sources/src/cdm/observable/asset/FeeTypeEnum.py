# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['FeeTypeEnum']

class FeeTypeEnum(Enum):
    """
    The enumerated values to specify an event that has given rise to a fee.
    """
    ASSIGNMENT = "Assignment"
    """
    A cash flow resulting from the assignment of a contract to a new counterparty.
    """
    BROKERAGE_COMMISSION = "BrokerageCommission"
    """
    The brokerage commission.
    """
    CORPORATE_ACTION = "CorporateAction"
    """
    A cash flow associated with a corporate action
    """
    CREDIT_EVENT = "CreditEvent"
    """
    A cash flow associated with a credit event.
    """
    INCREASE = "Increase"
    """
    A cash flow associated with an increase lifecycle event.
    """
    NOVATION = "Novation"
    """
    The novation fee.
    """
    PARTIAL_TERMINATION = "PartialTermination"
    """
    A cash flow associated with a partial termination lifecycle event.
    """
    PREMIUM = "Premium"
    """
    Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
    """
    RENEGOTIATION = "Renegotiation"
    """
    A cash flow associated with a renegotiation lifecycle event.
    """
    TERMINATION = "Termination"
    """
    A cash flow associated with a termination lifecycle event.
    """
    UPFRONT = "Upfront"
    """
    An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
    """
