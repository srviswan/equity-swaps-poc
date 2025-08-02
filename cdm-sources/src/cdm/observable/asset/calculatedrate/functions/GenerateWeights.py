# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.functions.PopOffDateList import PopOffDateList
from cdm.base.math.functions.AppendToVector import AppendToVector

__all__ = ['GenerateWeights']


@replaceable
def GenerateWeights(weightingDates: list[datetime.date] | None) -> Decimal:
    """
    Recursively creates a list of weights based on the date difference between successive days.
    
    Parameters 
    ----------
    weightingDates : date
    A list of dates for which weightings are require.
    
    Returns
    -------
    weights : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return AppendToVector(rosetta_resolve_attr(self, "remainingWeights"), (rosetta_resolve_attr(self, "diff") * 1.0))
    
    def _else_fn0():
        return True
    
    active = all_elements(rosetta_count(rosetta_resolve_attr(self, "weightingDates")), ">", 1)
    refDate = rosetta_resolve_attr(self, "weightingDates")[-1]
    remainingDates = PopOffDateList(rosetta_resolve_attr(self, "weightingDates"))
    prevDate = rosetta_resolve_attr(self, "remainingDates")[-1]
    diff = DateDifference(rosetta_resolve_attr(self, "prevDate"), rosetta_resolve_attr(self, "refDate"))
    remainingWeights = GenerateWeights(rosetta_resolve_attr(self, "remainingDates"))
    weights = if_cond_fn(rosetta_resolve_attr(self, "active"), _then_fn0, _else_fn0)
    
    
    return weights

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
