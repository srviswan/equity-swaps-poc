# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MoneyMarketTypeEnum']

class MoneyMarketTypeEnum(Enum):
    CERTIFICATE_OF_DEPOSIT = "CertificateOfDeposit"
    COMMERCIAL_PAPER = "CommercialPaper"
