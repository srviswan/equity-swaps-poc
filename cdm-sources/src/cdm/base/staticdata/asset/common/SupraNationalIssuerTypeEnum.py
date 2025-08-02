# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SupraNationalIssuerTypeEnum']

class SupraNationalIssuerTypeEnum(Enum):
    """
    Represents an enumeration list to identify the type of supranational entity issuing the asset.
    """
    INTERNATIONAL_ORGANISATION = "InternationalOrganisation"
    """
    Specifies International Financial Institution.
    """
    MULTILATERAL_BANK = "MultilateralBank"
    """
    Specifies Multilateral Bank or Multilateral Development Bank.
    """
