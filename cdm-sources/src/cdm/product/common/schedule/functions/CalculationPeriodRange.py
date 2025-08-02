# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.CalculationPeriodData import CalculationPeriodData
from cdm.base.datetime.BusinessDayAdjustments import BusinessDayAdjustments

__all__ = ['CalculationPeriodRange']


@replaceable
def CalculationPeriodRange(startDate: datetime.date | None, endDate: datetime.date | None, dateAdjustments: BusinessDayAdjustments | None) -> CalculationPeriodData:
    """
    
    Parameters 
    ----------
    startDate : date
    
    endDate : date
    
    dateAdjustments : BusinessDayAdjustments
    
    Returns
    -------
    result : CalculationPeriodData
    
    """
    self = inspect.currentframe()
    
    
    result = rosetta_resolve_attr(self, "result")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
