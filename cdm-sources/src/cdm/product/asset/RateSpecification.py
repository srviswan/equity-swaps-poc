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

__all__ = ['RateSpecification']


class RateSpecification(BaseDataClass):
    """
     A data type to specify the fixed interest rate, floating interest rate or inflation rate.
    """
    FixedRateSpecification: Optional[cdm.product.asset.FixedRateSpecification.FixedRateSpecification] = Field(None, description="The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.")
    """
    The fixed rate or fixed rate specification expressed as explicit fixed rates and dates.
    """
    FloatingRateSpecification: Optional[cdm.product.asset.FloatingRateSpecification.FloatingRateSpecification] = Field(None, description="The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.")
    """
    The floating interest rate specification, which includes the definition of the floating rate index. the tenor, the initial value, and, when applicable, the spread, the rounding convention, the averaging method and the negative interest rate treatment.
    """
    InflationRateSpecification: Optional[cdm.product.asset.InflationRateSpecification.InflationRateSpecification] = Field(None, description="An inflation rate calculation definition.")
    """
    An inflation rate calculation definition.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('FixedRateSpecification', 'FloatingRateSpecification', 'InflationRateSpecification', necessity=True)

import cdm 
import cdm.product.asset.FixedRateSpecification
import cdm.product.asset.FloatingRateSpecification
import cdm.product.asset.InflationRateSpecification
