# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['LegalAgreementTypeEnum']

class LegalAgreementTypeEnum(Enum):
    """
    The enumerated values to specify the legal agreement type.
    """
    BROKER_CONFIRMATION = "BrokerConfirmation"
    """
    A Broker Confirmation.
    """
    CONFIRMATION = "Confirmation"
    """
    A Transaction Confirmation.
    """
    CREDIT_SUPPORT_AGREEMENT = "CreditSupportAgreement"
    """
    A Credit Support Agreement.
    """
    MASTER_AGREEMENT = "MasterAgreement"
    """
    A Master Agreement.
    """
    MASTER_CONFIRMATION = "MasterConfirmation"
    """
    A Master Confirmation.
    """
    OTHER = "Other"
    """
    Another type of agreement.
    """
    SECURITY_AGREEMENT = "SecurityAgreement"
    """
    A Security Agreement related to a Collateral Transfer Agreement (CTA).
    """
