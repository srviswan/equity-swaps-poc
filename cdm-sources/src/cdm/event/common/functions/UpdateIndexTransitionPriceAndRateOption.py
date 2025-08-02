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

__all__ = ['UpdateIndexTransitionPriceAndRateOption']


@replaceable
def UpdateIndexTransitionPriceAndRateOption(priceQuantity: PriceQuantity, instruction: PriceQuantity | None) -> PriceQuantity:
    """
    
    Parameters 
    ----------
    priceQuantity : PriceQuantity
    
    instruction : PriceQuantity
    
    Returns
    -------
    updatedPriceQuantity : PriceQuantity
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return (rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "price")), "value") + rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "price")), "value"))
    
    def _else_fn0():
        return rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "price")), "value")
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "observable"), "Index"), "InterestRateIndex")
    
    def _else_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "observable"), "Index"), "InterestRateIndex")
    
    updatedPriceQuantity =  rosetta_resolve_attr(self, "priceQuantity")
    updatedPriceQuantity = _get_rosetta_object('PriceQuantity', 'price', _get_rosetta_object('PriceSchedule', 'value', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "instruction")), _then_fn1, _else_fn1)))
    updatedPriceQuantity = set_rosetta_attr(rosetta_resolve_attr(self, 'updatedPriceQuantity'), 'observable->Index->InterestRateIndex', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "instruction")), _then_fn2, _else_fn2))
    
    
    return updatedPriceQuantity

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
