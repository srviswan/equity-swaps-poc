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

__all__ = ['SettlementTerms']

from cdm.product.common.settlement.SettlementBase import SettlementBase

class SettlementTerms(SettlementBase):
    """
    Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
    """
    cashSettlementTerms: List[cdm.product.common.settlement.CashSettlementTerms.CashSettlementTerms] = Field([], description="Specifies the parameters associated with the cash settlement procedure.")
    """
    Specifies the parameters associated with the cash settlement procedure.
    """
    physicalSettlementTerms: Optional[cdm.product.common.settlement.PhysicalSettlementTerms.PhysicalSettlementTerms] = Field(None, description="Specifies the physical settlement terms which apply to the transaction.")
    """
    Specifies the physical settlement terms which apply to the transaction.
    """
    
    @rosetta_condition
    def condition_0_OptionSettlementChoice(self):
        """
        The option settlement cannot combine both physical and cash terms specification.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "settlementType"), "=", rosetta_resolve_attr(SettlementTypeEnum, "ELECTION")) or all_elements(rosetta_resolve_attr(self, "settlementType"), "=", rosetta_resolve_attr(SettlementTypeEnum, "CASH_OR_PHYSICAL")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "cashSettlementTerms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "physicalSettlementTerms"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_CashSettlementTerms(self):
        """
        If the cash settlement terms are specified, then the settlementType can either be Cash, Election or CashOrPhysical
        """
        item = self
        def _then_fn0():
            return any_elements(rosetta_resolve_attr(self, "settlementType"), "<>", rosetta_resolve_attr(SettlementTypeEnum, "PHYSICAL"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "cashSettlementTerms")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_PhysicalSettlementTerms(self):
        """
        If the physical settlement terms are specified, then the settlementType can either be Physical, Election or CashOrPhysical
        """
        item = self
        def _then_fn0():
            return any_elements(rosetta_resolve_attr(self, "settlementType"), "<>", rosetta_resolve_attr(SettlementTypeEnum, "CASH"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "physicalSettlementTerms")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.settlement.CashSettlementTerms
import cdm.product.common.settlement.PhysicalSettlementTerms
from cdm.product.common.settlement.SettlementTypeEnum import SettlementTypeEnum
