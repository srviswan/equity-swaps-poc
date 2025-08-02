# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditSupportAgreementTypeEnum']

class CreditSupportAgreementTypeEnum(Enum):
    """
    The enumerated values to specify the type of Credit Support Agreement governing the transaction.
    """
    COLLATERAL_TRANSFER_AGREEMENT = "CollateralTransferAgreement"
    """
    A Collateral Transfer Agreement
    """
    CREDIT_SUPPORT_ANNEX = "CreditSupportAnnex"
    """
    A Credit Support Annex legal agreement.
    """
    CREDIT_SUPPORT_DEED = "CreditSupportDeed"
    """
    A Credit Support Deed legal agreement.
    """
