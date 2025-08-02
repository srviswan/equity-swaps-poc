# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditSupportDocumentTermsEnum']

class CreditSupportDocumentTermsEnum(Enum):
    """
    The enumerated values to specify the Credit Support Document Terms
    """
    ANY = "Any"
    """
    Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement.
    """
    NONE = "None"
    """
    No Credit Support Document is specified.
    """
    SPECIFIED = "Specified"
    """
    A specified Credit Support Document is provided
    """
