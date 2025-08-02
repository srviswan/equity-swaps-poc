# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PartyDeterminationEnum']

class PartyDeterminationEnum(Enum):
    """
    The enumerated values to specify how a calculation agent will be determined.
    """
    AS_SPECIFIED_IN_MASTER_AGREEMENT = "AsSpecifiedInMasterAgreement"
    """
    The Calculation Agent is determined by reference to the relevant master agreement.
    """
    AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT = "AsSpecifiedInStandardTermsSupplement"
    """
    The Calculation Agent is determined by reference to the relevant standard terms supplement.
    """
    BOTH = "Both"
    """
    Both parties with joined rights to be a calculation agent.
    """
    EXERCISING_PARTY = "ExercisingParty"
    """
    The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d).
    """
    NON_EXERCISING_PARTY = "NonExercisingParty"
    """
    The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e).
    """
