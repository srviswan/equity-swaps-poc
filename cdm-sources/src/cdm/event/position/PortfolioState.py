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

__all__ = ['PortfolioState']


class PortfolioState(BaseDataClass):
    """
    State-full representation of a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state
    """
    positions: List[cdm.event.position.Position.Position] = Field([], description="The list of positions, each containing a Quantity and a Product.")
    """
    The list of positions, each containing a Quantity and a Product.
    """
    lineage: cdm.event.common.Lineage.Lineage = Field(..., description="Pointer to the previous PortfolioState and new Event(s) leading to the current (new) state. Previous PortfolioState in the Lineage can be Null in case this is the start of the chain of Events.")
    """
    Pointer to the previous PortfolioState and new Event(s) leading to the current (new) state. Previous PortfolioState in the Lineage can be Null in case this is the start of the chain of Events.
    """
    
    @rosetta_condition
    def condition_0_Initialisation(self):
        """
        When the PortfolioState is the starting state of the Portfolio, as identified by a Null state in the Lineage, Positions must be empty and the reference to the latest Event is also empty. This is how a Portfolio gets initialised.
        """
        item = self
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "positions"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "lineage"), "eventReference"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "lineage"), "portfolioStateReference"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_NonTransferable(self):
        """
        The Product in a PortfolioState should be a nonTransferableProduct.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "positions"), "product"), "NonTransferableProduct"))

import cdm 
import cdm.event.position.Position
import cdm.event.common.Lineage
