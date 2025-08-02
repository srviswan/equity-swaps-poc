# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.PerformancePayout import PerformancePayout

__all__ = ['StandardizedScheduleFXVarianceNotionalAmount']


@replaceable
def StandardizedScheduleFXVarianceNotionalAmount(performancePayout: PerformancePayout | None) -> Decimal:
    """
    Extracts the notional amount of an FX variance swap.
    
    Parameters 
    ----------
    performancePayout : PerformancePayout
    
    Returns
    -------
    amount : number
    
    """
    self = inspect.currentframe()
    
    
    varianceReturnTerms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "returnTerms"), "varianceReturnTerms")
    vegaNotionalAmount = rosetta_resolve_attr(rosetta_resolve_attr(self, "varianceReturnTerms"), "vegaNotionalAmount")
    fixedRate = rosetta_resolve_attr(rosetta_resolve_attr(self, "varianceReturnTerms"), "varianceStrikePrice")
    amount =  (rosetta_resolve_attr(rosetta_resolve_attr(self, "vegaNotionalAmount"), "value") / (0.02 * rosetta_resolve_attr(rosetta_resolve_attr(self, "fixedRate"), "value")))
    
    
    return amount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
