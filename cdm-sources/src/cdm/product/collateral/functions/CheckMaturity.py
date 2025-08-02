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
from cdm.product.collateral.AssetMaturity import AssetMaturity

__all__ = ['CheckMaturity']


@replaceable
def CheckMaturity(maturityRange: AssetMaturity | None, query: EligibilityQuery) -> bool:
    """
    
    Parameters 
    ----------
    maturityRange : AssetMaturity
    
    query : EligibilityQuery
    
    Returns
    -------
    isEqual : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "upperBound"), "period"), "periodMultiplier"), ">=", rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "maturity"))
    
    def _else_fn1():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "upperBound"), "period"), "periodMultiplier"), ">", rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "maturity"))
    
    def _then_fn0():
        return True
    
    def _else_fn0():
        return if_cond_fn((rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "upperBound"), "inclusive") or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "upperBound"), "inclusive")))), _then_fn1, _else_fn1)
    
    def _then_fn2():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "lowerBound"), "period"), "periodMultiplier"), "<=", rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "maturity"))
    
    def _else_fn2():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "lowerBound"), "period"), "periodMultiplier"), ">", rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "maturity"))
    
    def _then_fn1():
        return True
    
    def _else_fn1():
        return if_cond_fn((rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "lowerBound"), "inclusive") or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "lowerBound"), "inclusive")))), _then_fn2, _else_fn2)
    
    upperBoundCheck = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "upperBound"), "period"))), _then_fn0, _else_fn0)
    lowerBoundCheck = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "maturityRange"), "maturityRange"), "lowerBound"), "period"))), _then_fn1, _else_fn1)
    isEqual =  ((not rosetta_attr_exists(rosetta_resolve_attr(self, "maturityRange"))) or (rosetta_resolve_attr(self, "upperBoundCheck") and rosetta_resolve_attr(self, "lowerBoundCheck")))
    
    
    return isEqual

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
