# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.CurrencyCodeEnum import CurrencyCodeEnum
from cdm.product.collateral.EligibilityQuery import EligibilityQuery

__all__ = ['CheckDenominatedCurrency']


@replaceable
def CheckDenominatedCurrency(denominatedCurrency: CurrencyCodeEnum | None, query: EligibilityQuery) -> bool:
    """
    
    Parameters 
    ----------
    denominatedCurrency : CurrencyCodeEnum
    
    query : EligibilityQuery
    
    Returns
    -------
    isEqual : boolean
    
    """
    self = inspect.currentframe()
    
    
    isEqual =  ((not rosetta_attr_exists(rosetta_resolve_attr(self, "denominatedCurrency"))) or contains(rosetta_resolve_attr(self, "denominatedCurrency"), rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "denominatedCurrency")))
    
    
    return isEqual

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
