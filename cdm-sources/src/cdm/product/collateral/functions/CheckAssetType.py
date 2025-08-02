# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.AssetType import AssetType
from cdm.product.collateral.EligibilityQuery import EligibilityQuery

__all__ = ['CheckAssetType']


@replaceable
def CheckAssetType(collateralAssetTypes: AssetType | None, query: EligibilityQuery) -> bool:
    """
    
    Parameters 
    ----------
    collateralAssetTypes : AssetType
    
    query : EligibilityQuery
    
    Returns
    -------
    isEqual : boolean
    
    """
    self = inspect.currentframe()
    
    
    isEqual =  ((not rosetta_attr_exists(rosetta_resolve_attr(self, "collateralAssetTypes"))) or (lambda item: rosetta_attr_exists(item))((lambda item: rosetta_filter(item, lambda item: ((not rosetta_attr_exists(rosetta_resolve_attr(self, "securityType"))) or all_elements(rosetta_resolve_attr(self, "securityType"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "collateralAssetType"), "securityType")))))((lambda item: rosetta_filter(item, lambda item: ((not rosetta_attr_exists(rosetta_resolve_attr(self, "debtType"))) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "debtType"), "debtClass"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "collateralAssetType"), "debtType"), "debtClass")))))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(self, "assetType"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "collateralAssetType"), "assetType"))))(rosetta_resolve_attr(self, "collateralAssetTypes"))))))
    
    
    return isEqual

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
