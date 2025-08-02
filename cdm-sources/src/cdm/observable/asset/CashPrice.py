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

__all__ = ['CashPrice']


class CashPrice(BaseDataClass):
    """
    Specifies the nature of a cash price either as a fee type, cash price type, or premium expression.
    """
    cashPriceType: cdm.observable.asset.CashPriceTypeEnum.CashPriceTypeEnum = Field(..., description="Specifies the type of Cash Price.")
    """
    Specifies the type of Cash Price.
    """
    premiumExpression: Optional[cdm.observable.asset.PremiumExpression.PremiumExpression] = Field(None, description="Specifies a premium when expressed in a way other than an amount, and any required forward starting price definition.")
    """
    Specifies a premium when expressed in a way other than an amount, and any required forward starting price definition.
    """
    feeType: Optional[cdm.observable.asset.FeeTypeEnum.FeeTypeEnum] = Field(None, description="Specifies the event type associated with a fee.")
    """
    Specifies the event type associated with a fee.
    """
    
    @rosetta_condition
    def condition_0_PremiumType(self):
        """
        Premium type can only be specified when the cash price type is a premium.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "cashPriceType"), "=", rosetta_resolve_attr(CashPriceTypeEnum, "PREMIUM"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "premiumExpression")), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.CashPriceTypeEnum
import cdm.observable.asset.PremiumExpression
import cdm.observable.asset.FeeTypeEnum
from cdm.observable.asset.CashPriceTypeEnum import CashPriceTypeEnum
