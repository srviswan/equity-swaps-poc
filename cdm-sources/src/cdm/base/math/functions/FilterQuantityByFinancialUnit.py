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
from cdm.base.math.FinancialUnitEnum import FinancialUnitEnum

__all__ = ['FilterQuantityByFinancialUnit']


@replaceable
def FilterQuantityByFinancialUnit(quantities: list[QuantitySchedule] | None, financialUnit: FinancialUnitEnum) -> QuantitySchedule:
    """
    Filter list of quantities based on unit type.
    
    Parameters 
    ----------
    quantities : QuantitySchedule
    List of quantities to filter.
    
    financialUnit : FinancialUnitEnum
    FinancialUnitEnum unit type.
    
    Returns
    -------
    filteredQuantities : QuantitySchedule
    
    """
    self = inspect.currentframe()
    
    
    filteredQuantities = rosetta_filter(rosetta_resolve_attr(self, "quantities"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "unit"), "financialUnit"), "=", rosetta_resolve_attr(self, "financialUnit")))
    
    
    return filteredQuantities

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
