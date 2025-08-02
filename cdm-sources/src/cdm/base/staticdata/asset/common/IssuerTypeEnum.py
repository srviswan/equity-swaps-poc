# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['IssuerTypeEnum']

class IssuerTypeEnum(Enum):
    """
    Represents an enumeration list to identify the type of entity issuing the asset.
    """
    CORPORATE = "Corporate"
    """
    Specifies debt issued Securities by corporate bodies including Banks.
    """
    FUND = "Fund"
    """
    Specifies a vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
    """
    QUASI_GOVERNMENT = "QuasiGovernment"
    """
    Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
    """
    REGIONAL_GOVERNMENT = "RegionalGovernment"
    """
    Specifies Regional Government Issued Debt including states within countries, local authorities and municipalities.
    """
    SOVEREIGN_CENTRAL_BANK = "SovereignCentralBank"
    """
    Specifies Sovereign, Government Debt Securities including Central Banks.
    """
    SPECIAL_PURPOSE_VEHICLE = "SpecialPurposeVehicle"
    """
    Specifies a vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations.
    """
    SUPRA_NATIONAL = "SupraNational"
    """
    Specifies debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks.
    """
