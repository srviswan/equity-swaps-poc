# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditSupportProviderTermsEnum']

class CreditSupportProviderTermsEnum(Enum):
    """
    The enumerated values to specify the Credit Support Provider Terms
    """
    ANY = "Any"
    """
    Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support.
    """
    NONE = "None"
    """
    No Credit Support Provider is specified.
    """
    SPECIFIED = "Specified"
    """
    A specified Credit Support Provider is provided
    """
