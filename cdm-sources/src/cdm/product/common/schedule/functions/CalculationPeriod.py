# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.CalculationPeriodDates import CalculationPeriodDates
from cdm.product.common.schedule.CalculationPeriodData import CalculationPeriodData

__all__ = ['CalculationPeriod']


@replaceable
def CalculationPeriod(calculationPeriodDates: CalculationPeriodDates, date: datetime.date) -> CalculationPeriodData:
    """
    2006 ISDA Definition Section 4.13. 'Calculation Period' means, in respect of a Swap Transaction and a party, each period from, and including, one Period End Date of that party to, but excluding, the next following applicable Period End Date during the Term of the Swap Transaction, except that (a) the initial Calculation Period for the party will commence on, and include, the Effective Date and (b) the final Calculation Period for the party will end on, but exclude, the Termination Date.
    
    Parameters 
    ----------
    calculationPeriodDates : CalculationPeriodDates
    
    date : date
    
    Returns
    -------
    result : CalculationPeriodData
    
    """
    self = inspect.currentframe()
    
    
    result = rosetta_resolve_attr(self, "result")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
