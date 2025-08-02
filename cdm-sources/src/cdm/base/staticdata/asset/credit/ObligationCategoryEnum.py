# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ObligationCategoryEnum']

class ObligationCategoryEnum(Enum):
    """
    The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply.
    """
    BOND = "Bond"
    """
    ISDA term 'Bond'.
    """
    BOND_OR_LOAN = "BondOrLoan"
    """
    ISDA term 'Bond or Loan'.
    """
    BORROWED_MONEY = "BorrowedMoney"
    """
    ISDA term 'Borrowed Money'.
    """
    LOAN = "Loan"
    """
    ISDA term 'Loan'.
    """
    PAYMENT = "Payment"
    """
    ISDA term 'Payment'.
    """
    REFERENCE_OBLIGATIONS_ONLY = "ReferenceObligationsOnly"
    """
    ISDA term 'Reference Obligations Only'.
    """
