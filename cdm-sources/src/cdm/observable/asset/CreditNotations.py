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

__all__ = ['CreditNotations']


class CreditNotations(BaseDataClass):
    """
    Represents the credit rating notation higher level construct, which provides the ability to specify multiple rating notations.
    """
    creditNotation: Optional[cdm.observable.asset.CreditNotation.CreditNotation] = Field(None, description="Specifies only one credit notation is determined.")
    """
    Specifies only one credit notation is determined.
    """
    creditNotations: Optional[cdm.observable.asset.MultipleCreditNotations.MultipleCreditNotations] = Field(None, description="Specifies if several credit notations exist, alongside an 'any' or 'all' or all condition.")
    """
    Specifies if several credit notations exist, alongside an 'any' or 'all' or all condition.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('creditNotation', 'creditNotations', necessity=True)

import cdm 
import cdm.observable.asset.CreditNotation
import cdm.observable.asset.MultipleCreditNotations
