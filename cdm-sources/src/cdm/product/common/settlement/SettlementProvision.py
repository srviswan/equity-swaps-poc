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

__all__ = ['SettlementProvision']


class SettlementProvision(BaseDataClass):
    """
    Defines parameters that regulate a settlement, for instance whether this settlement should be netted with other ones or broken-down into smaller amounts.
    """
    shapingProvisions: Optional[cdm.product.common.settlement.ShapingProvision.ShapingProvision] = Field(None, description="Defines the parameters that are necessary to 'shape' a settlement, i.e. break it down into smaller amounts.")
    """
    Defines the parameters that are necessary to 'shape' a settlement, i.e. break it down into smaller amounts.
    """

import cdm 
import cdm.product.common.settlement.ShapingProvision
