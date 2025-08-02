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

__all__ = ['CollateralIssuerType']


class CollateralIssuerType(BaseDataClass):
    """
    Represents a class to allow specification of the type of entity issuing the collateral.
    """
    issuerType: cdm.base.staticdata.asset.common.IssuerTypeEnum.IssuerTypeEnum = Field(..., description="Specifies the origin of entity issuing the collateral.")
    """
    Specifies the origin of entity issuing the collateral.
    """
    supraNationalType: Optional[cdm.base.staticdata.asset.common.SupraNationalIssuerTypeEnum.SupraNationalIssuerTypeEnum] = Field(None, description="Specifies debt issued by international organisations and multilateral banks.")
    """
    Specifies debt issued by international organisations and multilateral banks.
    """
    quasiGovernmentType: Optional[cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType.QuasiGovernmentIssuerType] = Field(None, description="Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.")
    """
    Specifies debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
    """
    regionalGovernmentType: Optional[cdm.base.staticdata.asset.common.RegionalGovernmentIssuerType.RegionalGovernmentIssuerType] = Field(None, description="Specifies Regional government, local authority or municipal.")
    """
    Specifies Regional government, local authority or municipal.
    """
    specialPurposeVehicleType: Optional[cdm.base.staticdata.asset.common.SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerType] = Field(None, description="Specifies a subsidiary company that is formed to undertake a specific business purpose of acquisition and financing of specific assets on a potentially limited recourse basis dependent of how it is designed. E.g. asset backed securities, including securitisations.")
    """
    Specifies a subsidiary company that is formed to undertake a specific business purpose of acquisition and financing of specific assets on a potentially limited recourse basis dependent of how it is designed. E.g. asset backed securities, including securitisations.
    """
    
    @rosetta_condition
    def condition_0_SupraNationalSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "supraNationalType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "issuerType"), "<>", rosetta_resolve_attr(IssuerTypeEnum, "SUPRA_NATIONAL")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_QuasiGovernmentSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "quasiGovernmentType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "issuerType"), "<>", rosetta_resolve_attr(IssuerTypeEnum, "QUASI_GOVERNMENT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_RegionalGovernmentSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "regionalGovernmentType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "issuerType"), "<>", rosetta_resolve_attr(IssuerTypeEnum, "REGIONAL_GOVERNMENT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_SpecialPurposeVehicleSubType(self):
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "specialPurposeVehicleType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(self, "issuerType"), "<>", rosetta_resolve_attr(IssuerTypeEnum, "SPECIAL_PURPOSE_VEHICLE")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.IssuerTypeEnum
import cdm.base.staticdata.asset.common.SupraNationalIssuerTypeEnum
import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType
import cdm.base.staticdata.asset.common.RegionalGovernmentIssuerType
import cdm.base.staticdata.asset.common.SpecialPurposeVehicleIssuerType
from cdm.base.staticdata.asset.common.IssuerTypeEnum import IssuerTypeEnum
