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

__all__ = ['TermsChangeInstruction']


class TermsChangeInstruction(BaseDataClass):
    """
    Specifies instructions for terms change consisting of the new transaction terms, and the renegotiation fee.
    """
    product: Optional[cdm.product.template.NonTransferableProduct.NonTransferableProduct] = Field(None, description="product to be changed")
    """
    product to be changed
    """
    ancillaryParty: List[cdm.base.staticdata.party.AncillaryParty.AncillaryParty] = Field([], description="ancillary party to be changed")
    """
    ancillary party to be changed
    """
    adjustment: Optional[cdm.product.common.NotionalAdjustmentEnum.NotionalAdjustmentEnum] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_AtLeastOneOf(self):
        item = self
        return ((rosetta_attr_exists(rosetta_resolve_attr(self, "product")) or rosetta_attr_exists(rosetta_resolve_attr(self, "ancillaryParty"))) or rosetta_attr_exists(rosetta_resolve_attr(self, "adjustment")))

import cdm 
import cdm.product.template.NonTransferableProduct
import cdm.base.staticdata.party.AncillaryParty
import cdm.product.common.NotionalAdjustmentEnum
