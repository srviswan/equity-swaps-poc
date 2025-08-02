# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditNotationMismatchResolutionEnum']

class CreditNotationMismatchResolutionEnum(Enum):
    """
    Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
    """
    AVERAGE = "Average"
    """
    Denotes the average credit notation if several notations are listed.
    """
    HIGHEST = "Highest"
    """
    Denotes the highest credit notation if several notations are listed.
    """
    LOWEST = "Lowest"
    """
    Denotes the lowest credit notation if several notations are listed.
    """
    OTHER = "Other"
    """
    Utilised where bespoke language represents the label characteristics of the rating.
    """
    REFERENCE_AGENCY = "ReferenceAgency"
    """
    Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
    """
    SECOND_BEST = "SecondBest"
    """
    Denotes the second best credit notation if several notations are listed.
    """
