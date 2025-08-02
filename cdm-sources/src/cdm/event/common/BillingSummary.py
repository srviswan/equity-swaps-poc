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

__all__ = ['BillingSummary']


class BillingSummary(BaseDataClass):
    """
    Specifies individual summaries within a billing invoice.
    """
    summaryTransfer: Optional[cdm.event.common.Transfer.Transfer] = Field(None, description="The settlement terms for the billing summary")
    """
    The settlement terms for the billing summary
    """
    summaryAmountType: cdm.event.common.RecordAmountTypeEnum.RecordAmountTypeEnum = Field(..., description="The account level for the billing summary.")
    """
    The account level for the billing summary.
    """
    
    @rosetta_condition
    def condition_0_GrandTotal(self):
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "summaryTransfer")) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "summaryAmountType"), "=", rosetta_resolve_attr(RecordAmountTypeEnum, "GRAND_TOTAL")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_ParentTotal(self):
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver")) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver"), "payerAccountReference")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver"), "receiverAccountReference"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "summaryAmountType"), "=", rosetta_resolve_attr(RecordAmountTypeEnum, "PARENT_TOTAL")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_AccountTotal(self):
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver"), "payerAccountReference")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "summaryTransfer"), "payerReceiver"), "receiverAccountReference")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "summaryAmountType"), "=", rosetta_resolve_attr(RecordAmountTypeEnum, "ACCOUNT_TOTAL")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.Transfer
import cdm.event.common.RecordAmountTypeEnum
from cdm.event.common.RecordAmountTypeEnum import RecordAmountTypeEnum
