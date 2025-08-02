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

__all__ = ['CollateralTaxonomy']


class CollateralTaxonomy(BaseDataClass):
    """
    Specifies the collateral taxonomy, which is composed of a taxonomy value and a taxonomy source.
    """
    taxonomyValue: cdm.base.staticdata.asset.common.CollateralTaxonomyValue.CollateralTaxonomyValue = Field(..., description="Specifies the taxonomy value.")
    """
    Specifies the taxonomy value.
    """
    taxonomySource: cdm.base.staticdata.asset.common.TaxonomySourceEnum.TaxonomySourceEnum = Field(..., description="Specifies the taxonomy source.")
    """
    Specifies the taxonomy source.
    """
    
    @rosetta_condition
    def condition_0_Eu_EligibleCollateralTaxonomy(self):
        """
        If the Taxonomy Source is specified as EU EMIR Eligible Collateral then the enumeration must be EU EMIR Eligible Collateral.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomyValue"), "eu_EMIR_EligibleCollateral"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "taxonomySource"), "=", rosetta_resolve_attr(TaxonomySourceEnum, "EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_UkEligibleCollateralTaxonomy(self):
        """
        If the Taxonomy Source is specified as UK EMIR Eligible Collateral then the enumeration must be UK EMIR Eligible Collateral.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomyValue"), "uk_EMIR_EligibleCollateral"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "taxonomySource"), "=", rosetta_resolve_attr(TaxonomySourceEnum, "UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_UsEligibleCollateralTaxonomy(self):
        """
        If the Taxonomy Source is specified as US CFTCPR Eligbile Collateral then the enumeration must be US CFTCPR Eligible Collateral.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomyValue"), "us_CFTC_PR_EligibleCollateral"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "taxonomySource"), "=", rosetta_resolve_attr(TaxonomySourceEnum, "US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_TaxonomyValue(self):
        """
        If the Taxonomy Value is specified as a string then the taxonomy Source cannot be either EU Eligible Collateral or Uk Eligible Collateral or US Eligible Collateral.
        """
        item = self
        def _then_fn0():
            return ((any_elements(rosetta_resolve_attr(self, "taxonomySource"), "<>", rosetta_resolve_attr(TaxonomySourceEnum, "EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS")) and any_elements(rosetta_resolve_attr(self, "taxonomySource"), "<>", rosetta_resolve_attr(TaxonomySourceEnum, "UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS"))) and any_elements(rosetta_resolve_attr(self, "taxonomySource"), "<>", rosetta_resolve_attr(TaxonomySourceEnum, "US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomyValue"), "nonEnumeratedTaxonomyValue")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue
import cdm.base.staticdata.asset.common.TaxonomySourceEnum
from cdm.base.staticdata.asset.common.TaxonomySourceEnum import TaxonomySourceEnum
