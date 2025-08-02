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

__all__ = ['CommodityReferenceFramework']


class CommodityReferenceFramework(BaseDataClass):
    """
    Specifies the type of commodity.
    """
    commodityName: str = Field(..., description="Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.")
    """
    Identifies the commodity more specifically. Where possible, this should follow the naming convention used in the 2005 ISDA Commodity Definitions SubAnnex A, including the subCommodity and additional qualifiers, but should be limited to 256 characters or less.
    """
    capacityUnit: Optional[cdm.base.math.CapacityUnitEnum.CapacityUnitEnum] = Field(None, description="Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.")
    """
    Provides an enumerated value for a capacity unit, generally used in the context of defining quantities for commodities.
    """
    weatherUnit: Optional[cdm.base.math.WeatherUnitEnum.WeatherUnitEnum] = Field(None, description="Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.")
    """
    Provides an enumerated values for a weather unit, generally used in the context of defining quantities for commodities.
    """
    currency: AttributeWithMeta[str] | str = Field(..., description="Defines the currency in which the commodity is priced.")
    """
    Defines the currency in which the commodity is priced.
    """
    
    @rosetta_condition
    def condition_0_CommodityReferenceFrameworkChoice(self):
        """
        Requires that either the capacity unit or weather unit is populated.
        """
        item = self
        return self.check_one_of_constraint('capacityUnit', 'weatherUnit', necessity=False)

import cdm 
import cdm.base.math.CapacityUnitEnum
import cdm.base.math.WeatherUnitEnum
