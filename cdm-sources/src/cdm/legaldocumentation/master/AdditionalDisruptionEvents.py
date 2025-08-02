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

__all__ = ['AdditionalDisruptionEvents']


class AdditionalDisruptionEvents(BaseDataClass):
    """
    A type for defining the Additional Disruption Events.
    """
    changeInLaw: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions: ")
    """
    Per 2002 ISDA Equity Derivatives Definitions: 
    """
    failureToDeliver: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions")
    """
    Per 2002 ISDA Equity Derivatives Definitions
    """
    insolvencyFiling: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions")
    """
    Per 2002 ISDA Equity Derivatives Definitions
    """
    hedgingDisruption: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions")
    """
    Per 2002 ISDA Equity Derivatives Definitions
    """
    increasedCostOfHedging: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions")
    """
    Per 2002 ISDA Equity Derivatives Definitions
    """
    foreignOwnershipEvent: Optional[bool] = Field(None, description="Per ISDA Def ")
    """
    Per ISDA Def 
    """
    lossOfStockBorrow: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions:")
    """
    Per 2002 ISDA Equity Derivatives Definitions:
    """
    maximumStockLoanRate: Optional[Decimal] = Field(None, description="Specifies the maximum stock loan rate for Loss of Stock Borrow. A percentage of 5% is represented as 0.05.")
    """
    Specifies the maximum stock loan rate for Loss of Stock Borrow. A percentage of 5% is represented as 0.05.
    """
    increasedCostOfStockBorrow: Optional[bool] = Field(None, description="Per 2002 ISDA Equity Derivatives Definitions")
    """
    Per 2002 ISDA Equity Derivatives Definitions
    """
    initialStockLoanRate: Optional[Decimal] = Field(None, description="Specifies the initial stock loan per ISDA Def. A percentage of 5% is represented as 0.05.")
    """
    Specifies the initial stock loan per ISDA Def. A percentage of 5% is represented as 0.05.
    """
    determiningParty: Optional[cdm.base.staticdata.party.AncillaryRoleEnum.AncillaryRoleEnum] = Field(None, description="Specifies the party which determines additional disruption events.")
    """
    Specifies the party which determines additional disruption events.
    """
    additionalBespokeTerms: List[cdm.legaldocumentation.master.Clause.Clause] = Field([], description="Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.")
    """
    Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
    """
    
    @rosetta_condition
    def condition_0_MaximumStockLoanRate(self):
        """
         FpML specifies the maximumStockLoanRate as a RestrictedPercentage, meaning that its value is comprised between 0 and 1.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "maximumStockLoanRate"), ">=", 0) and all_elements(rosetta_resolve_attr(self, "maximumStockLoanRate"), "<=", 1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "maximumStockLoanRate")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_InitialStockLoanRate(self):
        """
         FpML specifies the initialStockLoanRate as a RestrictedPercentage, meaning that its value is comprised between 0 and 1.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "initialStockLoanRate"), ">=", 0) and all_elements(rosetta_resolve_attr(self, "initialStockLoanRate"), "<=", 1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "initialStockLoanRate")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_DisruptionEventsDeterminingParty(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "determiningParty"), "=", rosetta_resolve_attr(AncillaryRoleEnum, "DISRUPTION_EVENTS_DETERMINING_PARTY"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "determiningParty")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.party.AncillaryRoleEnum
import cdm.legaldocumentation.master.Clause
from cdm.base.staticdata.party.AncillaryRoleEnum import AncillaryRoleEnum
