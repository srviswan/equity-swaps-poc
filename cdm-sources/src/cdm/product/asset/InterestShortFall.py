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

__all__ = ['InterestShortFall']


class InterestShortFall(BaseDataClass):
    """
    A class to specify the interest shortfall floating rate payment event.
    """
    interestShortfallCap: cdm.product.asset.InterestShortfallCapEnum.InterestShortfallCapEnum = Field(..., description="Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.")
    """
    Specifies the nature of the interest Shortfall cap (i.e. Fixed Cap or Variable Cap) in the case where it is applicable. ISDA 2003 Term: Interest Shortfall Cap.
    """
    compounding: bool = Field(..., description="")
    rateSource: Optional[AttributeWithMeta[cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] | cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] = Field(None, description="The rate source in the case of a variable cap.")
    """
    The rate source in the case of a variable cap.
    """

import cdm 
import cdm.product.asset.InterestShortfallCapEnum
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
