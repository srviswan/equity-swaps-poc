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

__all__ = ['ReferencePoolItem']


class ReferencePoolItem(BaseDataClass):
    """
    This type contains all the constituent weight and reference information.
    """
    constituentWeight: Optional[cdm.product.template.ConstituentWeight.ConstituentWeight] = Field(None, description="Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.")
    """
    Describes the weight of each of the constituents within the basket. If not provided, it is assumed to be equal weighted.
    """
    referencePair: cdm.product.asset.ReferencePair.ReferencePair = Field(..., description="")
    protectionTermsReference: Optional[AttributeWithReference | cdm.product.asset.ProtectionTerms.ProtectionTerms] = Field(None, description="Reference to the documentation terms applicable to this item.")
    """
    Reference to the documentation terms applicable to this item.
    """
    cashSettlementTermsReference: Optional[AttributeWithReference | cdm.product.common.settlement.CashSettlementTerms.CashSettlementTerms] = Field(None, description="Reference to the cash settlement terms applicable to this item.")
    """
    Reference to the cash settlement terms applicable to this item.
    """
    physicalSettlementTermsReference: Optional[AttributeWithReference | cdm.product.common.settlement.PhysicalSettlementTerms.PhysicalSettlementTerms] = Field(None, description="Reference to the physical settlement terms applicable to this item.")
    """
    Reference to the physical settlement terms applicable to this item.
    """
    
    @rosetta_condition
    def condition_0_SettlementChoice(self):
        """
        A choice rule between a reference to the cash or physical settlement terms.
        """
        item = self
        return self.check_one_of_constraint('cashSettlementTermsReference', 'physicalSettlementTermsReference', necessity=False)

import cdm 
import cdm.product.template.ConstituentWeight
import cdm.product.asset.ReferencePair
import cdm.product.asset.ProtectionTerms
import cdm.product.common.settlement.CashSettlementTerms
import cdm.product.common.settlement.PhysicalSettlementTerms
