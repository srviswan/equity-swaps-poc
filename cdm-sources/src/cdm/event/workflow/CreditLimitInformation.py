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

__all__ = ['CreditLimitInformation']


class CreditLimitInformation(BaseDataClass):
    """
    A class to represent the credit limit utilisation information.
    """
    limitApplicable: List[cdm.event.workflow.LimitApplicableExtended.LimitApplicableExtended] = Field([], description="")
    @rosetta_condition
    def cardinality_limitApplicable(self):
        return check_cardinality(self.limitApplicable, 1, None)
    

import cdm 
import cdm.event.workflow.LimitApplicableExtended
