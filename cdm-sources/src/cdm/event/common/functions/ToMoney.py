# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Money import Money
from cdm.base.math.Quantity import Quantity

__all__ = ['ToMoney']


@replaceable
def ToMoney(quantity: Quantity) -> Money:
    """
    
    Parameters 
    ----------
    quantity : Quantity
    
    Returns
    -------
    money : Money
    
    """
    self = inspect.currentframe()
    
    
    money = _get_rosetta_object('Money', 'value', rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "value"))
    money = set_rosetta_attr(rosetta_resolve_attr(self, 'money'), 'unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "currency"))
    
    
    return money

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
