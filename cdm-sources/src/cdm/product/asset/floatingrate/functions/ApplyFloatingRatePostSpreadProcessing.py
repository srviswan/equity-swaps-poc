# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.functions.ApplyCapsAndFloors import ApplyCapsAndFloors
from cdm.product.asset.floatingrate.functions.ApplyFinalRateRounding import ApplyFinalRateRounding
from cdm.product.asset.floatingrate.FloatingRateProcessingParameters import FloatingRateProcessingParameters

__all__ = ['ApplyFloatingRatePostSpreadProcessing']


@replaceable
def ApplyFloatingRatePostSpreadProcessing(inputRate: Decimal, processing: FloatingRateProcessingParameters) -> Decimal:
    """
    Perform post-spread rate treatments on floating rates, such as applying caps and floors, rounding, and negative interest treatment.  TODOO:  initialRate needs to be supported.  Also, to support compounding methods, it may be necessary to split the before spread and after spread values and return both, so that cashflows can be computed both ways.  This may require this function to be redesigned or split into pieces (e.g. factor out the post-spread processing).
    
    Parameters 
    ----------
    inputRate : number
    The floating rate prior to post-sprad, either a single term rate, or a calculated rate such as an OIS or lookback compounded rate.
    
    processing : FloatingRateProcessingParameters
    
    Returns
    -------
    processedRate : number
    
    """
    self = inspect.currentframe()
    
    
    cappedAndFlooredRate = ApplyCapsAndFloors(rosetta_resolve_attr(self, "processing"), rosetta_resolve_attr(self, "inputRate"))
    processedRate =  ApplyFinalRateRounding(rosetta_resolve_attr(self, "cappedAndFlooredRate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "rounding"))
    
    
    return processedRate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
