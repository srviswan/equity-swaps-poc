# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.InterestRateIndex import InterestRateIndex
from cdm.observable.asset.calculatedrate.functions.IndexValueObservation import IndexValueObservation

__all__ = ['IndexValueObservationMultiple']


@replaceable
def IndexValueObservationMultiple(observationDate: list[datetime.date] | None, interestRateIndex: InterestRateIndex) -> Decimal:
    """
    Retrieve the values of the supplied index on the specified observation dates.
    
    Parameters 
    ----------
    observationDate : date
    
    interestRateIndex : InterestRateIndex
    
    Returns
    -------
    observedValues : number
    
    """
    self = inspect.currentframe()
    
    
    observedValues = map(lambda item: IndexValueObservation(item, rosetta_resolve_attr(self, "interestRateIndex")), rosetta_resolve_attr(self, "observationDate"))
    
    
    return observedValues

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
