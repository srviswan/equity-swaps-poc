# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['LegalAgreementPublisherEnum']

class LegalAgreementPublisherEnum(Enum):
    """
    The enumerated values to specify the legal agreement publisher.
    """
    AFB = "AFB"
    """
    Association Française des Banques.
    """
    BNYM = "BNYM"
    """
    BNY Mellon
    """
    EMTA = "EMTA"
    """
    Emerging Markets Traders Association
    """
    ICMA = "ICMA"
    """
    International Capital Markets Association
    """
    ISDA = "ISDA"
    """
    International Swaps and Derivatives Association, Inc.
    """
    ISDA_CLEARSTREAM = "ISDAClearstream"
    """
    ISDA and Clearstream
    """
    ISDA_EUROCLEAR = "ISDAEuroclear"
    """
    ISDA and Euroclear
    """
    ISLA = "ISLA"
    """
    International Securities Lending Association
    """
    JP_MORGAN = "JPMorgan"
    """
    JP Morgan
    """
    THE_FX_COMMITTEE = "TheFXCommittee"
    """
    The Foreign Exchange Committee
    """
