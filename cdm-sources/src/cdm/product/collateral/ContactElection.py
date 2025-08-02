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

__all__ = ['ContactElection']


class ContactElection(BaseDataClass):
    """
    A class to specify the parties' election to specify contact information, in relation to elections such as the Addresses for Transfer or the Demand and Notices as specified in the ISDA Credit Support Annex agreement.
    """
    partyElection: List[cdm.base.staticdata.party.PartyContactInformation.PartyContactInformation] = Field([], description="The parties' contact information election.")
    """
    The parties' contact information election.
    """
    @rosetta_condition
    def cardinality_partyElection(self):
        return check_cardinality(self.partyElection, 2, 2)
    

import cdm 
import cdm.base.staticdata.party.PartyContactInformation
