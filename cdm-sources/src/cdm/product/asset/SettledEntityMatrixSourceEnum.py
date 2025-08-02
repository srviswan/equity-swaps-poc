# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SettledEntityMatrixSourceEnum']

class SettledEntityMatrixSourceEnum(Enum):
    """
    The enumerated values to specify the relevant settled entity matrix source.
    """
    CONFIRMATION_ANNEX = "ConfirmationAnnex"
    """
    The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation.
    """
    NOT_APPLICABLE = "NotApplicable"
    """
    The term is not applicable.
    """
    PUBLISHER = "Publisher"
    """
    The Settled Entity Matrix published by the Index Publisher.
    """
