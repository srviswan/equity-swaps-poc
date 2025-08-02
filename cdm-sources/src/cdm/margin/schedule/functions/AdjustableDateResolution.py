# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.AdjustableDate import AdjustableDate

__all__ = ['AdjustableDateResolution']


@replaceable
def AdjustableDateResolution(adjustableDate: AdjustableDate) -> datetime.date:
    """
    A fall back for unadjustedDate when adjustedDate is only available.
    
    Parameters 
    ----------
    adjustableDate : AdjustableDate
    
    Returns
    -------
    date : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableDate"), "unadjustedDate")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableDate"), "adjustedDate")
    
    date =  if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableDate"), "unadjustedDate")), _then_fn0, _else_fn0)
    
    
    return date

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
