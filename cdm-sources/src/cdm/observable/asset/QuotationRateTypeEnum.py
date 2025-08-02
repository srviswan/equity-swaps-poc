# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['QuotationRateTypeEnum']

class QuotationRateTypeEnum(Enum):
    """
    The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
    """
    ASK = "Ask"
    """
    An ask rate.
    """
    BID = "Bid"
    """
    A bid rate.
    """
    EXERCISING_PARTY_PAYS = "ExercisingPartyPays"
    """
    If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
    """
    MID = "Mid"
    """
    A mid-market rate.
    """
