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

__all__ = ['DividendPaymentDate']


class DividendPaymentDate(BaseDataClass):
    """
    A class describing the date on which the dividend will be paid/received. This class is also used to specify the date on which the FX rate will be determined, when applicable.
    """
    dividendDateReference: Optional[cdm.product.asset.DividendDateReference.DividendDateReference] = Field(None, description="")
    dividendDate: Optional[AttributeWithReference | cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('dividendDateReference', 'dividendDate', necessity=True)

import cdm 
import cdm.product.asset.DividendDateReference
import cdm.base.datetime.AdjustableOrRelativeDate
