# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DebtPrincipalEnum']

class DebtPrincipalEnum(Enum):
    """
    Represents an enumeration list that specifies the general rule for repayment of principal.
    """
    AMORTISING = "Amortising"
    """
    Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
    """
    BULLET = "Bullet"
    """
    Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
    """
    CALLABLE = "Callable"
    """
    Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
    """
    INDEX_LINKED = "IndexLinked"
    """
    Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
    """
    INFLATION_LINKED = "InflationLinked"
    """
    Denotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
    """
    OTHER_STRUCTURED = "OtherStructured"
    """
    Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
    """
    PRINCIPAL_ONLY = "PrincipalOnly"
    """
    Denotes a stripped bond representing only the principal component.
    """
    PUTTABLE = "Puttable"
    """
    Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
    """
