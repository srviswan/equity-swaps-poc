# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.RateTreatmentEnum import RateTreatmentEnum
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase

__all__ = ['ApplyUSRateTreatment']


@replaceable
def ApplyUSRateTreatment(baseRate: Decimal, rateTreatment: RateTreatmentEnum, calculationPeriod: CalculationPeriodBase) -> Decimal:
    """
    Apply the US rate treatment logic where applicable (Bond Equivalent Yield, Money Market Yield, as described in the 2021 ISDA Definitions, section 6.9.
    
    Parameters 
    ----------
    baseRate : number
    Rate before treatment.
    
    rateTreatment : RateTreatmentEnum
    type of treatment.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period over which the rate is computed.
    
    Returns
    -------
    treatedRate : number
    
    """
    self = inspect.currentframe()
    
    
    treatedRate =  rosetta_resolve_attr(self, "baseRate")
    
    
    return treatedRate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
