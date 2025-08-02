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

__all__ = ['Security']

from cdm.base.staticdata.asset.common.InstrumentBase import InstrumentBase

class Security(InstrumentBase):
    """
    Identifies a security by referencing an identifier and by specifying the sector.
    """
    debtType: Optional[cdm.base.staticdata.asset.common.DebtType.DebtType] = Field(None, description="Identifies the type of debt and selected debt economics.")
    """
    Identifies the type of debt and selected debt economics.
    """
    equityType: Optional[cdm.base.staticdata.asset.common.EquityTypeEnum.EquityTypeEnum] = Field(None, description="Identifies the type of equity.")
    """
    Identifies the type of equity.
    """
    fundType: Optional[cdm.base.staticdata.asset.common.FundProductTypeEnum.FundProductTypeEnum] = Field(None, description="Identifies the type of fund.")
    """
    Identifies the type of fund.
    """
    
    @rosetta_condition
    def condition_0_DebtSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "debtType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "instrumentType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_EquitySubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "equityType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "instrumentType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "EQUITY")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_FundSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "fundType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "instrumentType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "FUND")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.DebtType
import cdm.base.staticdata.asset.common.EquityTypeEnum
import cdm.base.staticdata.asset.common.FundProductTypeEnum
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum
