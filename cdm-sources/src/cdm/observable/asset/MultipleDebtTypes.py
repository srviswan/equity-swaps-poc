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

__all__ = ['MultipleDebtTypes']


class MultipleDebtTypes(BaseDataClass):
    """
    Represents a class to specify multiple credit debt types alongside a conditional 'any' or 'all' qualifier.
    """
    condition: cdm.base.math.QuantifierEnum.QuantifierEnum = Field(..., description="An enumerated attribute, to qualify whether All or Any debt type applies.")
    """
    An enumerated attribute, to qualify whether All or Any debt type applies.
    """
    debtType: List[AttributeWithMeta[str] | str] = Field([], description="The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.")
    """
    The type of debt, e.g. long term debt, deposit, ... FpML doesn't specific a scheme value, hence no enumeration is specified as part of the CDM. At least two debt types much be specified.
    """
    @rosetta_condition
    def cardinality_debtType(self):
        return check_cardinality(self.debtType, 2, None)
    

import cdm 
import cdm.base.math.QuantifierEnum
