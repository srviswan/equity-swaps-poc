# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.daycount.functions.DayCountBasis import DayCountBasis
from cdm.base.datetime.daycount.DayCountFractionEnum import DayCountFractionEnum

__all__ = ['YearFractionForOneDay']


@replaceable
def YearFractionForOneDay(dcf: DayCountFractionEnum) -> Decimal:
    """
    Return the year fraction represented by a single day, i.e 1 / dayCountBasis, where daycountBasis represents the denominator of the day count fraction. This perhaps should take into account leap years, though the ISDA compounding formulas do not cover ACT basis at the moment.
    
    Parameters 
    ----------
    dcf : DayCountFractionEnum
    Supplied Day count fraction.
    
    Returns
    -------
    yearFrac : number
    
    """
    self = inspect.currentframe()
    
    
    yearFrac =  (1 / DayCountBasis(rosetta_resolve_attr(self, "dcf")))
    
    
    return yearFrac

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
