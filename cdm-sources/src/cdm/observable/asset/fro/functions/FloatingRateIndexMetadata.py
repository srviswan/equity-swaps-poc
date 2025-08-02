# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.rates.FloatingRateIndexEnum import FloatingRateIndexEnum
from cdm.observable.asset.fro.FloatingRateIndexDefinition import FloatingRateIndexDefinition

__all__ = ['FloatingRateIndexMetadata']


@replaceable
def FloatingRateIndexMetadata(floatingRateIndexName: FloatingRateIndexEnum) -> FloatingRateIndexDefinition:
    """
    Retrieve all available metadata for the floating rate index.
    
    Parameters 
    ----------
    floatingRateIndexName : FloatingRateIndexEnum
    The name of the floating rate index.
    
    Returns
    -------
    floatingRateIndexDescription : FloatingRateIndexDefinition
    
    """
    self = inspect.currentframe()
    
    
    floatingRateIndexDescription = rosetta_resolve_attr(self, "floatingRateIndexDescription")
    
    
    return floatingRateIndexDescription

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
