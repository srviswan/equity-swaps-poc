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

__all__ = ['MarginCallResponseAction']


class MarginCallResponseAction(BaseDataClass):
    """
    Specifies the margin call action details, including collateral to be moved and its direction.
    """
    collateralPositionComponent: List[cdm.event.common.CollateralPosition.CollateralPosition] = Field([], description="Specifies the collateral to be moved and its direction.")
    """
    Specifies the collateral to be moved and its direction.
    """
    @rosetta_condition
    def cardinality_collateralPositionComponent(self):
        return check_cardinality(self.collateralPositionComponent, 1, None)
    
    marginCallAction: cdm.event.common.MarginCallActionEnum.MarginCallActionEnum = Field(..., description="Specifies the margin call action details, specified as either Delivery or Return.")
    """
    Specifies the margin call action details, specified as either Delivery or Return.
    """

import cdm 
import cdm.event.common.CollateralPosition
import cdm.event.common.MarginCallActionEnum
