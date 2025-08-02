# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['MapGenericProductToForwardPayout']


@replaceable
def MapGenericProductToForwardPayout(synonymPath: str, modelPath: str, productType: list[str] | None) -> bool:
    """
    Func that is invoked from a synonym 'set when' condition.
    
    Parameters 
    ----------
    synonymPath : string
    The xml path from which the func is called.
    
    modelPath : string
    The cdm path that is being mapped.
    
    productType : string
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  contains(rosetta_resolve_attr(self, "productType"), "InterestRate:Forward:Debt")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
