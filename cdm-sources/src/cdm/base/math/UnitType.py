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

__all__ = ['UnitType']


class UnitType(BaseDataClass):
    """
    Defines the unit to be used for price, quantity, or other purposes
    """
    capacityUnit: Optional[cdm.base.math.CapacityUnitEnum.CapacityUnitEnum] = Field(None, description="Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.")
    """
    Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
    """
    weatherUnit: Optional[cdm.base.math.WeatherUnitEnum.WeatherUnitEnum] = Field(None, description="Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.")
    """
    Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
    """
    financialUnit: Optional[cdm.base.math.FinancialUnitEnum.FinancialUnitEnum] = Field(None, description="Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.")
    """
    Provides an enumerated value for financial units, generally used in the context of defining quantities for securities.
    """
    currency: Optional[AttributeWithMeta[str] | str] = Field(None, description="Defines the currency to be used as a unit for a price, quantity, or other purpose.")
    """
    Defines the currency to be used as a unit for a price, quantity, or other purpose.
    """
    
    @rosetta_condition
    def condition_0_UnitType(self):
        """
        Requires that a unit type must be set.
        """
        item = self
        return self.check_one_of_constraint('capacityUnit', 'weatherUnit', 'financialUnit', 'currency', necessity=True)

import cdm 
import cdm.base.math.CapacityUnitEnum
import cdm.base.math.WeatherUnitEnum
import cdm.base.math.FinancialUnitEnum
