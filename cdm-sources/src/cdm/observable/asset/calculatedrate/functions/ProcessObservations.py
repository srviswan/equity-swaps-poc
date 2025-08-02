# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.functions.VectorScalarOperation import VectorScalarOperation
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['ProcessObservations']


@replaceable
def ProcessObservations(calculationParameters: FloatingRateCalculationParameters, rawObservations: list[Decimal] | None) -> Decimal:
    """
    Apply daily observation parameters to rate observation.  These are discussed in the 2021 ISDA Definitions, section 7.2.3 and 7.2.4.
    
    Parameters 
    ----------
    calculationParameters : FloatingRateCalculationParameters
    Floating rate definition for the calculated rate.
    
    rawObservations : number
    
    Returns
    -------
    processedObservations : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "params"), "observationCapRate")
    
    def _else_fn0():
        return True
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "params"), "observationFloorRate")
    
    def _else_fn1():
        return True
    
    def _then_fn2():
        return VectorScalarOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "MIN"), rosetta_resolve_attr(self, "rawObservations"), rosetta_resolve_attr(self, "cap"))
    
    def _else_fn2():
        return rosetta_resolve_attr(self, "rawObservations")
    
    def _then_fn3():
        return VectorScalarOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "MAX"), rosetta_resolve_attr(self, "cappedObservations"), rosetta_resolve_attr(self, "floor"))
    
    def _else_fn3():
        return rosetta_resolve_attr(self, "cappedObservations")
    
    params = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParameters"), "observationParameters")
    cap = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "params")), _then_fn0, _else_fn0)
    floor = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "params")), _then_fn1, _else_fn1)
    cappedObservations = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "cap")), _then_fn2, _else_fn2)
    flooredObservations = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "floor")), _then_fn3, _else_fn3)
    processedObservations = rosetta_resolve_attr(self, "flooredObservations")
    
    
    return processedObservations

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
