# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DebtInterestEnum']

class DebtInterestEnum(Enum):
    """
    Represents an enumeration list that specifies the general rule for periodic interest rate payment.
    """
    FIXED = "Fixed"
    """
    Denotes payment calculated with reference to a fixed interest rate.
    """
    FLOATING = "Floating"
    """
    Denotes payment calculated with reference to a floating interest rate.
    """
    INDEX_LINKED = "IndexLinked"
    """
    Denotes payment calculated with reference to one or more price or other indices (other than inflation rates).
    """
    INFLATION_LINKED = "InflationLinked"
    """
    Denotes payment calculated with reference to one or more specified inflation rates.
    """
    INTEREST_ONLY = "InterestOnly"
    """
    Denotes a stripped bond representing only the interest component.
    """
    INVERSE_FLOATING = "InverseFloating"
    """
    Denotes payment calculated with reference to the inverse of a floating interest rate.
    """
    OTHER_STRUCTURED = "OtherStructured"
    """
    Denotes payment calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
    """
    ZERO_COUPON = "ZeroCoupon"
    """
    Denotes a zero coupon bond that does not pay intetrest.
    """
