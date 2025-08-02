# pylint: disable=line-too-long, invalid-name, missing-function-docstring
# pylint: disable=bad-indentation, trailing-whitespace, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import
# pylint: disable=wildcard-import, wrong-import-order, missing-class-docstring
# pylint: disable=missing-module-docstring
from __future__ import annotations
from typing import List, Optional
import datetime
import inspect
from decimal import Decimal
from pydantic import Field
from rosetta.runtime.utils import (
    BaseDataClass, rosetta_condition, rosetta_resolve_attr
)
from rosetta.runtime.utils import *

__all__ = ['NaturalPerson']


class NaturalPerson(BaseDataClass):
    """
    A class to represent the attributes that are specific to a natural person.
    """
    personId: List[AttributeWithMeta[cdm.base.staticdata.party.PersonIdentifier.PersonIdentifier] | cdm.base.staticdata.party.PersonIdentifier.PersonIdentifier] = Field([], description="The identifier associated with a person, e.g. the internal identification code.")
    """
    The identifier associated with a person, e.g. the internal identification code.
    """
    honorific: Optional[str] = Field(None, description="An honorific title, such as Mr., Ms., Dr. etc.")
    """
    An honorific title, such as Mr., Ms., Dr. etc.
    """
    firstName: Optional[str] = Field(None, description="The natural person's first name. It is optional in FpML.")
    """
    The natural person's first name. It is optional in FpML.
    """
    middleName: List[str] = Field([], description="The natural person's middle name(s). If a middle name is provided then an initial should be absent.")
    """
    The natural person's middle name(s). If a middle name is provided then an initial should be absent.
    """
    initial: List[str] = Field([], description="The natural person's middle initial(s). If a middle initial is provided then a name should be absent.")
    """
    The natural person's middle initial(s). If a middle initial is provided then a name should be absent.
    """
    surname: Optional[str] = Field(None, description="The natural person's surname.")
    """
    The natural person's surname.
    """
    suffix: Optional[str] = Field(None, description="Name suffix, such as Jr., III, etc.")
    """
    Name suffix, such as Jr., III, etc.
    """
    dateOfBirth: Optional[datetime.date] = Field(None, description="The natural person's date of birth.")
    """
    The natural person's date of birth.
    """
    contactInformation: Optional[cdm.base.staticdata.party.ContactInformation.ContactInformation] = Field(None, description="The contact information for such person, when different from the contact information associated with the party.")
    """
    The contact information for such person, when different from the contact information associated with the party.
    """
    
    @rosetta_condition
    def condition_0_NameOrIdChoice(self):
        item = self
        return ((rosetta_attr_exists(rosetta_resolve_attr(self, "firstName")) and rosetta_attr_exists(rosetta_resolve_attr(self, "surname"))) or rosetta_attr_exists(rosetta_resolve_attr(self, "personId")))
    
    @rosetta_condition
    def condition_1_NaturalPersonChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('middleName', 'initial', necessity=False)

import cdm 
import cdm.base.staticdata.party.PersonIdentifier
import cdm.base.staticdata.party.ContactInformation
