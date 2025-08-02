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

__all__ = ['ProductTaxonomy']

from cdm.base.staticdata.asset.common.Taxonomy import Taxonomy

class ProductTaxonomy(Taxonomy):
    """
    Specifies the product taxonomy, which is composed of a taxonomy value and a taxonomy source.
    """
    primaryAssetClass: Optional[AttributeWithMeta[cdm.base.staticdata.asset.common.AssetClassEnum.AssetClassEnum] | cdm.base.staticdata.asset.common.AssetClassEnum.AssetClassEnum] = Field(None, description="Classifies the most important risk class of the trade.")
    """
    Classifies the most important risk class of the trade.
    """
    secondaryAssetClass: List[AttributeWithMeta[cdm.base.staticdata.asset.common.AssetClassEnum.AssetClassEnum] | cdm.base.staticdata.asset.common.AssetClassEnum.AssetClassEnum] = Field([], description=" Classifies additional risk classes of the trade, if any.")
    """
     Classifies additional risk classes of the trade, if any.
    """
    productQualifier: Optional[str] = Field(None, description="Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.")
    """
    Derived from the product payout features using a CDM product qualification function that determines the product type based on the product payout features.
    """
    
    @rosetta_condition
    def condition_0_TaxonomyType(self):
        """
        Requires a taxonomy type to be chosen, either from a taxonomy source or using asset classes.
        """
        item = self
        return self.check_one_of_constraint('source', 'primaryAssetClass', 'secondaryAssetClass', necessity=True)
    
    @rosetta_condition
    def condition_1_TaxonomySource(self):
        """
        A taxonomy source can only be associated with a taxonomy value or productQualifier
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "value")) or rosetta_attr_exists(rosetta_resolve_attr(self, "productQualifier")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "source")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_TaxonomyValue(self):
        """
        A taxonomy value and product qualifier are mutually exclusive. Choice is optional as it only applies when source exists.
        """
        item = self
        return self.check_one_of_constraint('value', 'productQualifier', necessity=False)

import cdm 
import cdm.base.staticdata.asset.common.AssetClassEnum
