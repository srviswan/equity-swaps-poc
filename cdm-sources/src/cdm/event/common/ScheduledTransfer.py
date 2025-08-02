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

__all__ = ['ScheduledTransfer']


class ScheduledTransfer(BaseDataClass):
    transferType: cdm.product.common.settlement.ScheduledTransferEnum.ScheduledTransferEnum = Field(..., description="Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event")
    """
    Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
    """
    corporateActionTransferType: Optional[cdm.event.common.CorporateActionTypeEnum.CorporateActionTypeEnum] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_CorporateActionTransferTypeExists(self):
        """
        When transfer type is Performance or Transfer then the type of event must be specified.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "corporateActionTransferType"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "transferType"), "=", rosetta_resolve_attr(ScheduledTransferEnum, "CORPORATE_ACTION")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.settlement.ScheduledTransferEnum
import cdm.event.common.CorporateActionTypeEnum
from cdm.product.common.settlement.ScheduledTransferEnum import ScheduledTransferEnum
