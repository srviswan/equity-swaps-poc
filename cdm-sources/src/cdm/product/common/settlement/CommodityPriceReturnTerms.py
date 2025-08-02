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

__all__ = ['CommodityPriceReturnTerms']


class CommodityPriceReturnTerms(BaseDataClass):
    """
    Defines parameters in which the commodity price is assessed.
    """
    rounding: Optional[cdm.base.math.Rounding.Rounding] = Field(None, description="Defines rounding rules and precision to be used in the rounding of a number.")
    """
    Defines rounding rules and precision to be used in the rounding of a number.
    """
    spread: Optional[cdm.product.asset.SpreadSchedule.SpreadSchedule] = Field(None, description="Defines a spread value for one or more defined dates.")
    """
    Defines a spread value for one or more defined dates.
    """
    rollFeature: Optional[cdm.product.common.settlement.RollFeature.RollFeature] = Field(None, description="Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. ")
    """
    Used in conjunction with an exchange-based pricing source. Identifies a way in which the futures contracts referenced will roll between periods. 
    """
    conversionFactor: Optional[Decimal] = Field(None, description="Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.")
    """
    Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
    """

import cdm 
import cdm.base.math.Rounding
import cdm.product.asset.SpreadSchedule
import cdm.product.common.settlement.RollFeature
