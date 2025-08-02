# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.common.schedule.CalculationPeriodData import CalculationPeriodData

__all__ = ['Create_CalculationPeriodBase']


@replaceable
def Create_CalculationPeriodBase(calcPeriodData: CalculationPeriodData) -> CalculationPeriodBase:
    """
    Create a CalculationPeriodBase type from CalculationPeriodData type.
    
    Parameters 
    ----------
    calcPeriodData : CalculationPeriodData
    A supplied CalculationPeriodData structure.
    
    Returns
    -------
    calcPeriod : CalculationPeriodBase
    
    """
    self = inspect.currentframe()
    
    
    calcPeriod = _get_rosetta_object('CalculationPeriodBase', 'adjustedStartDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "calcPeriodData"), "startDate"))
    calcPeriod = set_rosetta_attr(rosetta_resolve_attr(self, 'calcPeriod'), 'adjustedEndDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "calcPeriodData"), "endDate"))
    
    
    return calcPeriod

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
