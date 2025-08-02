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

__all__ = ['CreditIndex']

from cdm.observable.asset.IndexBase import IndexBase

class CreditIndex(IndexBase):
    """
    Specification of an index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
    """
    indexSeries: Optional[int] = Field(None, description="A CDS index series identifier, e.g. 1, 2, 3 etc.")
    """
    A CDS index series identifier, e.g. 1, 2, 3 etc.
    """
    indexAnnexVersion: Optional[int] = Field(None, description="A CDS index series version identifier, e.g. 1, 2, 3 etc.")
    """
    A CDS index series version identifier, e.g. 1, 2, 3 etc.
    """
    indexAnnexDate: Optional[datetime.date] = Field(None, description="A CDS index series annex date.")
    """
    A CDS index series annex date.
    """
    indexAnnexSource: Optional[AttributeWithMeta[cdm.product.asset.IndexAnnexSourceEnum.IndexAnnexSourceEnum] | cdm.product.asset.IndexAnnexSourceEnum.IndexAnnexSourceEnum] = Field(None, description="A CDS index series annex source.")
    """
    A CDS index series annex source.
    """
    excludedReferenceEntity: List[cdm.product.asset.ReferenceInformation.ReferenceInformation] = Field([], description="Excluded reference entity.")
    """
    Excluded reference entity.
    """
    tranche: Optional[cdm.product.asset.Tranche.Tranche] = Field(None, description="This element contains CDS tranche terms.")
    """
    This element contains CDS tranche terms.
    """
    settledEntityMatrix: Optional[cdm.product.asset.SettledEntityMatrix.SettledEntityMatrix] = Field(None, description="Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.")
    """
    Used to specify the Relevant Settled Entity Matrix when there are settled entities at the time of the trade.
    """
    indexFactor: Optional[Decimal] = Field(None, description="Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.")
    """
    Index Factor is the index version factor or percent, expressed as an absolute decimal value between 0 and 1, that multiplied by the original notional amount yields the notional amount covered by the seller of protection.
    """
    seniority: Optional[cdm.product.asset.CreditSeniorityEnum.CreditSeniorityEnum] = Field(None, description="Seniority of debt instruments comprising the index.")
    """
    Seniority of debt instruments comprising the index.
    """
    
    @rosetta_condition
    def condition_0_IndexSeries(self):
        """
        FpML specifies the type associated to indexSeries as a positive integer.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "indexSeries"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "indexSeries")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_IndexAnnexVersion(self):
        """
        FpML specifies the type associated to indexVersion as a positive integer.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "indexAnnexVersion"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "indexAnnexVersion")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_IndexFactor(self):
        """
        Index factor is expressed as a decimal and should be a positive number between o and 1.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "indexFactor"), ">=", 0) and all_elements(rosetta_resolve_attr(self, "indexFactor"), "<=", 1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "indexFactor")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_CreditAssetClass(self):
        """
        The asset class must be Credit.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(AssetClassEnum, "CREDIT"))

import cdm 
import cdm.product.asset.IndexAnnexSourceEnum
import cdm.product.asset.ReferenceInformation
import cdm.product.asset.Tranche
import cdm.product.asset.SettledEntityMatrix
import cdm.product.asset.CreditSeniorityEnum
from cdm.base.staticdata.asset.common.AssetClassEnum import AssetClassEnum
