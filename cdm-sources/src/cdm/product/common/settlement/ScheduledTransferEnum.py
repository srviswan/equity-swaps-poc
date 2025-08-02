# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ScheduledTransferEnum']

class ScheduledTransferEnum(Enum):
    """
    The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events.
    """
    CORPORATE_ACTION = "CorporateAction"
    """
    A cash flow corresponding to a corporate action event.
    """
    COUPON = "Coupon"
    """
    A cash flow corresponding to the periodic accrued interests.
    """
    CREDIT_EVENT = "CreditEvent"
    """
    A cashflow resulting from a credit event.
    """
    DIVIDEND_RETURN = "DividendReturn"
    """
    A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument.
    """
    EXERCISE = "Exercise"
    """
    A cash flow associated with an exercise lifecycle event.
    """
    FIXED_RATE_RETURN = "FixedRateReturn"
    """
    A cash flow corresponding to the return of the fixed interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    """
    FLOATING_RATE_RETURN = "FloatingRateReturn"
    """
    A cash flow corresponding to the return of the floating interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    """
    FRACTIONAL_AMOUNT = "FractionalAmount"
    """
    A cash flow corresponding to the compensation for missing assets due to the rounding of digits in the original number of assets to be delivered as per payout calculation.
    """
    INTEREST_RETURN = "InterestReturn"
    """
    A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
    """
    NET_INTEREST = "NetInterest"
    """
    Net interest across payout components. Applicable to products such as interest rate swaps.
    """
    PERFORMANCE = "Performance"
    """
    A cash flow corresponding to a performance return.  The settlementOrigin attribute on the Transfer should point to the relevant Payout defining the performance calculation.
    """
    PRINCIPAL_PAYMENT = "PrincipalPayment"
    """
    A cashflow which amount typically corresponds to the notional amount of the contract for various business reasons e.g. PhysicalSettlement, PrincipalExchange etc. else to a portion of the notional amount interim payments e.g. for the purpose of resetting the Notional Amount of a Cross Currency Swap variying leg, as part of a final Principal Exchange related to a Non-Deliverable currency leg, etc.
    """
