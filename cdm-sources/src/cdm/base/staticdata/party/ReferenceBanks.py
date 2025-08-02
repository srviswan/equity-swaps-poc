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

__all__ = ['ReferenceBanks']


class ReferenceBanks(BaseDataClass):
    """
    A class defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
    """
    referenceBank: List[cdm.base.staticdata.party.ReferenceBank.ReferenceBank] = Field([], description="An institution (party) identified by means of a coding scheme and an optional name.")
    """
    An institution (party) identified by means of a coding scheme and an optional name.
    """
    @rosetta_condition
    def cardinality_referenceBank(self):
        return check_cardinality(self.referenceBank, 1, None)
    

import cdm 
import cdm.base.staticdata.party.ReferenceBank
