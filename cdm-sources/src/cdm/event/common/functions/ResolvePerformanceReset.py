# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Reset import Reset
from cdm.observable.event.Observation import Observation
from cdm.product.template.PerformancePayout import PerformancePayout

__all__ = ['ResolvePerformanceReset']


@replaceable
def ResolvePerformanceReset(performancePayout: PerformancePayout, observation: Observation, date: datetime.date) -> Reset:
    """
    Defines how to resolve the reset value for a performance payout.
    
    Parameters 
    ----------
    performancePayout : PerformancePayout
    Represents the PerformancePayout to which the reset will apply.
    
    observation : Observation
    Represents the observation that will be used to compute the reset value.
    
    date : date
    Specifies the date of the reset.
    
    Returns
    -------
    reset : Reset
    
    """
    self = inspect.currentframe()
    
    
    reset = _get_rosetta_object('Reset', 'resetValue', rosetta_resolve_attr(rosetta_resolve_attr(self, "observation"), "observedValue"))
    reset = set_rosetta_attr(rosetta_resolve_attr(self, 'reset'), 'resetDate', rosetta_resolve_attr(self, "date"))
    reset.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, reset), 'observations'), rosetta_resolve_attr(self, "observation"))
    
    
    return reset

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
