# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.AveragingCalculationMethodEnum import AveragingCalculationMethodEnum
from cdm.product.template.AssetPayout import AssetPayout
from cdm.observable.event.functions.ResolveObservationAverage import ResolveObservationAverage
from cdm.event.common.Reset import Reset
from cdm.observable.event.Observation import Observation

__all__ = ['Create_AssetReset']


@replaceable
def Create_AssetReset(assetPayout: AssetPayout, observation: list[Observation], resetDate: datetime.date) -> Reset:
    """
    Defines how to resolve the reset value for an equity payout.
    
    Parameters 
    ----------
    assetPayout : AssetPayout
    Represents the AssetPayout to which the reset will apply.
    
    observation : Observation
    Represents the observations that will be used to compute the reset value.
    
    resetDate : date
    Specifies the date of the reset.
    
    Returns
    -------
    reset : Reset
    
    """
    self = inspect.currentframe()
    
    
    reset = _get_rosetta_object('Reset', 'resetValue', ResolveObservationAverage(rosetta_resolve_attr(self, "observation")))
    reset = set_rosetta_attr(rosetta_resolve_attr(self, 'reset'), 'resetDate', rosetta_resolve_attr(self, "resetDate"))
    reset.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, reset), 'observations'), rosetta_resolve_attr(self, "observation"))
    reset = set_rosetta_attr(rosetta_resolve_attr(self, 'reset'), 'averagingMethodology->averagingMethod->calculationMethod', rosetta_resolve_attr(AveragingCalculationMethodEnum, "ARITHMETIC"))
    
    
    return reset

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
