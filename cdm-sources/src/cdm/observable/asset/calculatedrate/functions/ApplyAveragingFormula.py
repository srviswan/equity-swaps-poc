# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.calculatedrate.CalculatedRateDetails import CalculatedRateDetails

__all__ = ['ApplyAveragingFormula']


@replaceable
def ApplyAveragingFormula(observations: list[Decimal] | None, weights: list[Decimal] | None) -> CalculatedRateDetails:
    """
    Implements the weighted arithmetic averaging formula.  Sums the weighted rates and divides by the total weight.  This is used to support section 7.4 of the 2021 ISDA Definitions.
    
    Parameters 
    ----------
    observations : number
    a vector of observation value.
    
    weights : number
    a vector of weights (should be same size as observations, 1 weight per observation.
    
    Returns
    -------
    results : CalculatedRateDetails
    
    """
    self = inspect.currentframe()
    
    
    weightedObservations = VectorOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "MULTIPLY"), rosetta_resolve_attr(self, "observations"), rosetta_resolve_attr(self, "weights"))
    totalWeightedObservations = sum(rosetta_resolve_attr(self, "weightedObservations"))
    totalWeight = sum(rosetta_resolve_attr(self, "weights"))
    calculatedRate = (rosetta_resolve_attr(self, "totalWeightedObservations") / rosetta_resolve_attr(self, "totalWeight"))
    results = _get_rosetta_object('CalculatedRateDetails', 'aggregateValue', rosetta_resolve_attr(self, "totalWeightedObservations"))
    results = set_rosetta_attr(rosetta_resolve_attr(self, 'results'), 'aggregateWeight', rosetta_resolve_attr(self, "totalWeight"))
    results = set_rosetta_attr(rosetta_resolve_attr(self, 'results'), 'calculatedRate', rosetta_resolve_attr(self, "calculatedRate"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'weightedRates'), rosetta_resolve_attr(self, "weightedObservations"))
    
    
    return results

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
