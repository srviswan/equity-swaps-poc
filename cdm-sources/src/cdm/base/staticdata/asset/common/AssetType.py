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

__all__ = ['AssetType']


class AssetType(BaseDataClass):
    """
    Represents a class to allow specification of the asset product type.
    """
    assetType: cdm.base.staticdata.asset.common.AssetTypeEnum.AssetTypeEnum = Field(..., description="Represents a filter based on the type of collateral asset.")
    """
    Represents a filter based on the type of collateral asset.
    """
    securityType: Optional[cdm.base.staticdata.asset.common.InstrumentTypeEnum.InstrumentTypeEnum] = Field(None, description="Represents a filter based on the type of security.")
    """
    Represents a filter based on the type of security.
    """
    debtType: Optional[cdm.base.staticdata.asset.common.DebtType.DebtType] = Field(None, description="Represents a filter based on the type of bond.")
    """
    Represents a filter based on the type of bond.
    """
    equityType: Optional[cdm.base.staticdata.asset.common.EquityTypeEnum.EquityTypeEnum] = Field(None, description="Represents a filter based on the type of equity.")
    """
    Represents a filter based on the type of equity.
    """
    fundType: Optional[cdm.base.staticdata.asset.common.FundProductTypeEnum.FundProductTypeEnum] = Field(None, description="Represents a filter based on the type of fund.")
    """
    Represents a filter based on the type of fund.
    """
    otherAssetType: List[str] = Field([], description="Specifies the eligible asset type when not enumerated.")
    """
    Specifies the eligible asset type when not enumerated.
    """
    
    @rosetta_condition
    def condition_0_SecuritySubType(self):
        item = self
        def _then_fn0():
            return ((((not rosetta_attr_exists(rosetta_resolve_attr(self, "securityType"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "debtType")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "equityType")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "fundType"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "assetType"), "<>", rosetta_resolve_attr(AssetTypeEnum, "SECURITY")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_BondSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "debtType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "securityType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "DEBT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_EquitySubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "equityType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "securityType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "EQUITY")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_FundSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "fundType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "securityType"), "<>", rosetta_resolve_attr(InstrumentTypeEnum, "FUND")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_OtherAssetSubType(self):
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "otherAssetType"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetType"), "=", rosetta_resolve_attr(AssetTypeEnum, "OTHER")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.AssetTypeEnum
import cdm.base.staticdata.asset.common.InstrumentTypeEnum
import cdm.base.staticdata.asset.common.DebtType
import cdm.base.staticdata.asset.common.EquityTypeEnum
import cdm.base.staticdata.asset.common.FundProductTypeEnum
from cdm.base.staticdata.asset.common.AssetTypeEnum import AssetTypeEnum
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum
