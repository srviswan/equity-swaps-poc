# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SpecifiedEntityTermsEnum']

class SpecifiedEntityTermsEnum(Enum):
    """
    The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
    """
    ANY_AFFILIATE = "AnyAffiliate"
    """
    Any Affiliate is a Specified Entity.
    """
    MATERIAL_SUBSIDIARY = "MaterialSubsidiary"
    """
    Any Material Subsidiary.
    """
    NAMED_SPECIFIED_ENTITY = "NamedSpecifiedEntity"
    """
    The Specified Entity is provided.
    """
    NONE = "None"
    """
    No Specified Entity is provided
    """
    OTHER_SPECIFIED_ENTITY = "OtherSpecifiedEntity"
    """
    Non standard Specified Entity terms are provided.
    """
