# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradeLot import TradeLot
from cdm.product.template.TradableProduct import TradableProduct

__all__ = ['AddTradeLot']


@replaceable
def AddTradeLot(tradableProduct: TradableProduct, newTradeLot: TradeLot) -> TradableProduct:
    """
    Add a TradeLot to an existing list of TradeLots.
    
    Parameters 
    ----------
    tradableProduct : TradableProduct
    Input list of TradeLots.
    
    newTradeLot : TradeLot
    The TradeLot to append to the list.
    
    Returns
    -------
    updatedTradableProduct : TradableProduct
    
    """
    self = inspect.currentframe()
    
    
    updatedTradableProduct =  rosetta_resolve_attr(self, "tradableProduct")
    updatedTradableProduct.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, updatedTradableProduct), 'tradeLot'), rosetta_resolve_attr(self, "newTradeLot"))
    
    
    return updatedTradableProduct

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
