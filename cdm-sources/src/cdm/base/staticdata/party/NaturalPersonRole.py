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

__all__ = ['NaturalPersonRole']


class NaturalPersonRole(BaseDataClass):
    """
    A class to specify the role(s) that natural person(s) may have in relation to the contract.
    """
    personReference: AttributeWithReference | cdm.base.staticdata.party.NaturalPerson.NaturalPerson = Field(..., description="A reference to the natural person to whom the role refers to.")
    """
    A reference to the natural person to whom the role refers to.
    """
    role: List[AttributeWithMeta[cdm.base.staticdata.party.NaturalPersonRoleEnum.NaturalPersonRoleEnum] | cdm.base.staticdata.party.NaturalPersonRoleEnum.NaturalPersonRoleEnum] = Field([], description="FpML specifies a person role that is distinct from the party role.")
    """
    FpML specifies a person role that is distinct from the party role.
    """

import cdm 
import cdm.base.staticdata.party.NaturalPerson
import cdm.base.staticdata.party.NaturalPersonRoleEnum
