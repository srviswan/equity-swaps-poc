# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.PriceQuantity import PriceQuantity

__all__ = ['UpdateAmountForEachQuantity']


@replaceable
def UpdateAmountForEachQuantity(priceQuantity: list[PriceQuantity] | None, amount: Decimal) -> PriceQuantity:
    """
    Updates all quantities on each price quantity with the new amount.
    
    Parameters 
    ----------
    priceQuantity : PriceQuantity
    List of price quantities to update.
    
    amount : number
    The new amount.
    
    Returns
    -------
    updatedPriceQuantity : PriceQuantity
    
    """
    self = inspect.currentframe()
    
    
    updatedPriceQuantity = rosetta_resolve_attr(self, "updatedPriceQuantity")
    
    
    return updatedPriceQuantity

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
