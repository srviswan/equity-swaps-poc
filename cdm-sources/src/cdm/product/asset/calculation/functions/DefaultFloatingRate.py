# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.FloatingRateProcessingDetails import FloatingRateProcessingDetails

__all__ = ['DefaultFloatingRate']


@replaceable
def DefaultFloatingRate(suppliedRate: Decimal) -> FloatingRateProcessingDetails:
    """
    
    Parameters 
    ----------
    suppliedRate : number
    
    Returns
    -------
    processedRateDetails : FloatingRateProcessingDetails
    
    """
    self = inspect.currentframe()
    
    
    processedRateDetails = _get_rosetta_object('FloatingRateProcessingDetails', 'processedRate', rosetta_resolve_attr(self, "suppliedRate"))
    
    
    return processedRateDetails

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
