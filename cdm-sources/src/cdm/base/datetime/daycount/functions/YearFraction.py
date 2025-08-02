# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['YearFraction']


@replaceable
def YearFraction() -> None:
    """
    '2021 ISDA Definitions Section 4.6.1(x): if 'Calculation/252' is specified, the actual number of Calculation Days in the relevant Calculation Period or Compounding Period divided by 252, calculated as follows: [daysInPeriod/252], where 'daysInPeriod' is, unless otherwise specified in the Confirmation, in respect of the relevant Floating Amount or Fixed Amount to which this Day Count Fraction applies, the Business Days in the relevant Calculation Period or Compounding Period determined by reference to the Business Day and Business Day Convention applicable to the determination of such Floating Amount or Fixed Amount, as applicable.
    
    Parameters 
    ----------
    
    Returns
    -------
    No Return
    
    """
    self = inspect.currentframe()
    
    
    daysInPeriod = DateDifference(rosetta_resolve_attr(self, "startDate"), rosetta_resolve_attr(self, "endDate"))

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
