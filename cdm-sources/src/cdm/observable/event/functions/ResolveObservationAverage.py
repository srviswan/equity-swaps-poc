# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Price import Price
from cdm.observable.event.Observation import Observation

__all__ = ['ResolveObservationAverage']


@replaceable
def ResolveObservationAverage(observations: list[Observation]) -> Price:
    """
    Specifies the interface that should be used by implementors to resolve a single observation when provided many, applying the averaging method, if one is provided.
    
    Parameters 
    ----------
    observations : Observation
    
    Returns
    -------
    resetValue : Price
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_UnitsMatch(self):
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "observations"), "observedValue"), "unit"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "firstObservedValue"), "unit"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    firstObservedValue = rosetta_resolve_attr(rosetta_resolve_attr(self, "observations"), "observedValue")[0]
    resetValue = _get_rosetta_object('Price', 'value', (sum(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "observations"), "observedValue"), "value")) / rosetta_count(rosetta_resolve_attr(self, "observations"))))
    resetValue = set_rosetta_attr(rosetta_resolve_attr(self, 'resetValue'), 'unit', rosetta_resolve_attr(rosetta_resolve_attr(self, "firstObservedValue"), "unit"))
    resetValue = set_rosetta_attr(rosetta_resolve_attr(self, 'resetValue'), 'perUnitOf', rosetta_resolve_attr(rosetta_resolve_attr(self, "firstObservedValue"), "perUnitOf"))
    resetValue = set_rosetta_attr(rosetta_resolve_attr(self, 'resetValue'), 'priceExpression', rosetta_resolve_attr(rosetta_resolve_attr(self, "firstObservedValue"), "priceExpression"))
    resetValue = set_rosetta_attr(rosetta_resolve_attr(self, 'resetValue'), 'priceType', rosetta_resolve_attr(rosetta_resolve_attr(self, "firstObservedValue"), "priceType"))
    
    
    return resetValue

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
