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

__all__ = ['CollateralPosition']

from cdm.event.position.Position import Position

class CollateralPosition(Position):
    """
    Specifies the individual components of collateral positions.
    """
    treatment: Optional[cdm.product.collateral.CollateralTreatment.CollateralTreatment] = Field(None, description="Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.")
    """
    Specifies if there is any treatment to be applied to collateral, such as percentage discount which will impact collateral value.
    """
    collateralPositionStatus: Optional[cdm.event.common.CollateralStatusEnum.CollateralStatusEnum] = Field(None, description="Indicates the collateral positions settlement status.")
    """
    Indicates the collateral positions settlement status.
    """
    
    @rosetta_condition
    def condition_0_CollateralPositionStatusSettledOrInTransitOnly(self):
        """
        Represents a condition to ensure that if a status is defined for a collateral position you must only indicate 'Settled Amount' or 'In Transit' amount from the available enumerations.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "collateralPositionStatus"), "=", rosetta_resolve_attr(CollateralStatusEnum, "SETTLED_AMOUNT")) or all_elements(rosetta_resolve_attr(self, "collateralPositionStatus"), "=", rosetta_resolve_attr(CollateralStatusEnum, "IN_TRANSIT_AMOUNT")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "collateralPositionStatus")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.collateral.CollateralTreatment
import cdm.event.common.CollateralStatusEnum
from cdm.event.common.CollateralStatusEnum import CollateralStatusEnum
