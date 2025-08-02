# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.functions.CompareNumbers import CompareNumbers
from cdm.base.math.Quantity import Quantity
from cdm.base.math.CompareOp import CompareOp
from cdm.base.math.functions.FilterQuantity import FilterQuantity
from cdm.base.math.UnitType import UnitType

__all__ = ['CompareQuantityByUnitOfAmount']


@replaceable
def CompareQuantityByUnitOfAmount(quantity1: list[Quantity] | None, op: CompareOp, quantity2: list[Quantity] | None, unitOfAmount: UnitType) -> bool:
    """
    
    Parameters 
    ----------
    quantity1 : Quantity
    
    op : CompareOp
    
    quantity2 : Quantity
    
    unitOfAmount : UnitType
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  (lambda item: all_elements(flatten_list(item), "=", True))(map(lambda item: map(lambda item: CompareNumbers(rosetta_resolve_attr(rosetta_resolve_attr(self, "q1"), "value"), rosetta_resolve_attr(self, "op"), rosetta_resolve_attr(rosetta_resolve_attr(self, "q2"), "value")), FilterQuantity(rosetta_resolve_attr(self, "quantity2"), rosetta_resolve_attr(self, "unitOfAmount"))), FilterQuantity(rosetta_resolve_attr(self, "quantity1"), rosetta_resolve_attr(self, "unitOfAmount"))))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
