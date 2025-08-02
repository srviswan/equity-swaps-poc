# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.AveragingCalculationMethod import AveragingCalculationMethod
from cdm.observable.event.ObservationIdentifier import ObservationIdentifier
from cdm.observable.event.Observation import Observation

__all__ = ['ResolveObservation']


@replaceable
def ResolveObservation(identifiers: list[ObservationIdentifier], averagingMethod: AveragingCalculationMethod | None) -> Observation:
    """
    Specifies the interface that should be used by implementors to resolve a single observation when provided many, applying the averaging method, if one is provided.
    
    Parameters 
    ----------
    identifiers : ObservationIdentifier
    
    averagingMethod : AveragingCalculationMethod
    
    Returns
    -------
    observation : Observation
    
    """
    self = inspect.currentframe()
    
    
    observation = rosetta_resolve_attr(self, "observation")
    
    
    return observation

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
