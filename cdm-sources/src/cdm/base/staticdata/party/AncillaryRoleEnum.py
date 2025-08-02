# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AncillaryRoleEnum']

class AncillaryRoleEnum(Enum):
    """
    Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
    """
    CALCULATION_AGENT_FALLBACK = "CalculationAgentFallback"
    """
    Specifies the party responsible for deciding the fallback rate.
    """
    CALCULATION_AGENT_INDEPENDENT = "CalculationAgentIndependent"
    """
    Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition.
    """
    CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION = "CalculationAgentMandatoryEarlyTermination"
    """
    Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination.
    """
    CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION = "CalculationAgentOptionalEarlyTermination"
    """
    Specifies the party responsible for performing calculation agent duties associated with an optional early termination.
    """
    DISRUPTION_EVENTS_DETERMINING_PARTY = "DisruptionEventsDeterminingParty"
    """
    Specifies the party which determines additional disruption events.
    """
    EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION = "ExerciseNoticeReceiverPartyCancelableProvision"
    """
    Specifies the party to which notice of a cancelable provision exercise should be given.
    """
    EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION = "ExerciseNoticeReceiverPartyExtendibleProvision"
    """
    Specifies the party to which notice of a extendible provision exercise should be given.
    """
    EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL = "ExerciseNoticeReceiverPartyManual"
    """
    Specifies the party to which notice of a manual exercise should be given.
    """
    EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION = "ExerciseNoticeReceiverPartyOptionalEarlyTermination"
    """
    Specifies the party to which notice of a optional early termination exercise should be given.
    """
    EXTRAORDINARY_DIVIDENDS_PARTY = "ExtraordinaryDividendsParty"
    """
    Specifies the party which determines if dividends are extraordinary in relation to normal levels.
    """
    PREDETERMINED_CLEARING_ORGANIZATION_PARTY = "PredeterminedClearingOrganizationParty"
    """
    Specifies the clearing organization (CCP, DCO) which the trade should be cleared.
    """
