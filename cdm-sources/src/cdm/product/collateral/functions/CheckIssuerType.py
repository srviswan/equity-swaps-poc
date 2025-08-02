# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.collateral.EligibilityQuery import EligibilityQuery
from cdm.base.staticdata.asset.common.CollateralIssuerType import CollateralIssuerType

__all__ = ['CheckIssuerType']


@replaceable
def CheckIssuerType(issuerType: CollateralIssuerType | None, query: EligibilityQuery) -> bool:
    """
    
    Parameters 
    ----------
    issuerType : CollateralIssuerType
    
    query : EligibilityQuery
    
    Returns
    -------
    isEqual : boolean
    
    """
    self = inspect.currentframe()
    
    
    isEqual =  ((not rosetta_attr_exists(rosetta_resolve_attr(self, "issuerType"))) or contains(rosetta_resolve_attr(self, "issuerType"), rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "issuerType")))
    
    
    return isEqual

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
