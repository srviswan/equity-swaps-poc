# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.QuantitySchedule import QuantitySchedule

__all__ = ['FilterQuantityByCurrency']


@replaceable
def FilterQuantityByCurrency(quantities: list[QuantitySchedule] | None, currency: str) -> QuantitySchedule:
    """
    Filter list of quantities based on unit type.
    
    Parameters 
    ----------
    quantities : QuantitySchedule
    List of quantities to filter.
    
    currency : string
    Currency unit type.
    
    Returns
    -------
    filteredQuantities : QuantitySchedule
    
    """
    self = inspect.currentframe()
    
    
    filteredQuantities = rosetta_filter(rosetta_resolve_attr(self, "quantities"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "unit"), "currency"), "=", rosetta_resolve_attr(self, "currency")))
    
    
    return filteredQuantities

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
