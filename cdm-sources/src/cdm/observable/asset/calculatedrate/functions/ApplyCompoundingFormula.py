# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.functions.VectorOperation import VectorOperation
from cdm.base.math.functions.VectorGrowthOperation import VectorGrowthOperation
from cdm.observable.asset.calculatedrate.CalculatedRateDetails import CalculatedRateDetails

__all__ = ['ApplyCompoundingFormula']


@replaceable
def ApplyCompoundingFormula(observations: list[Decimal] | None, weights: list[Decimal] | None, yearFrac: Decimal) -> CalculatedRateDetails:
    """
    Implements the compounding formula:   Product of ( 1 + (rate * weight) / basis), then backs out the final rate. This is used to support section 7.3 of the 2021 ISDA Definitions.
    
    Parameters 
    ----------
    observations : number
    A vector of observation value.
    
    weights : number
    A vector of weights (should be same size as observations, 1 weight per observation.
    
    yearFrac : number
    Year fraction of a single day (i.e. 1/basis.
    
    Returns
    -------
    results : CalculatedRateDetails
    
    """
    self = inspect.currentframe()
    
    
    weightedObservations = VectorOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "MULTIPLY"), rosetta_resolve_attr(self, "observations"), rosetta_resolve_attr(self, "weights"))
    scaledAndWeightedObservations = VectorScalarOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "MULTIPLY"), rosetta_resolve_attr(self, "weightedObservations"), rosetta_resolve_attr(self, "yearFrac"))
    growthFactors = VectorScalarOperation(rosetta_resolve_attr(ArithmeticOperationEnum, "ADD"), rosetta_resolve_attr(self, "scaledAndWeightedObservations"), 1.0)
    growthCurve = VectorGrowthOperation(1.0, rosetta_resolve_attr(self, "growthFactors"))
    finalValue = rosetta_resolve_attr(self, "growthCurve")[-1]
    totalWeight = sum(rosetta_resolve_attr(self, "weights"))
    overallYearFrac = (rosetta_resolve_attr(self, "totalWeight") * rosetta_resolve_attr(self, "yearFrac"))
    calculatedRate = ((rosetta_resolve_attr(self, "finalValue") - 1) / rosetta_resolve_attr(self, "overallYearFrac"))
    results = _get_rosetta_object('CalculatedRateDetails', 'aggregateValue', rosetta_resolve_attr(self, "finalValue"))
    results = set_rosetta_attr(rosetta_resolve_attr(self, 'results'), 'aggregateWeight', rosetta_resolve_attr(self, "totalWeight"))
    results = set_rosetta_attr(rosetta_resolve_attr(self, 'results'), 'calculatedRate', rosetta_resolve_attr(self, "calculatedRate"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'compoundedGrowth'), rosetta_resolve_attr(self, "growthCurve"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'growthFactor'), rosetta_resolve_attr(self, "growthFactors"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'weightedRates'), rosetta_resolve_attr(self, "weightedObservations"))
    
    
    return results

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
