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

__all__ = ['BondReference']


class BondReference(BaseDataClass):
    """
    Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
    """
    bond: cdm.base.staticdata.asset.common.Security.Security = Field(..., description="Reference to a bond underlier.")
    """
    Reference to a bond underlier.
    """
    conditionPrecedentBond: bool = Field(..., description="To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.")
    """
    To indicate whether the Condition Precedent Bond is applicable. The swap contract is only valid if the bond is issued and if there is any dispute over the terms of fixed stream then the bond terms would be used.
    """
    discrepancyClause: Optional[bool] = Field(None, description="To indicate whether the Discrepancy Clause is applicable.")
    """
    To indicate whether the Discrepancy Clause is applicable.
    """
    couponRate: Optional[cdm.product.asset.FixedRateSpecification.FixedRateSpecification] = Field(None, description="Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.")
    """
    Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
    """
    
    @rosetta_condition
    def condition_0_BondUnderlier(self):
        """
        The underlier should be a bond.
        """
        item = self
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "bond"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT"))

import cdm 
import cdm.base.staticdata.asset.common.Security
import cdm.product.asset.FixedRateSpecification
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum
