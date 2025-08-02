# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.collateral.CollateralCriteria import CollateralCriteria

__all__ = ['CreateOrCriteria']


@replaceable
def CreateOrCriteria(inputCriteria: list[CollateralCriteria]) -> CollateralCriteria:
    """
    Combines multiple CollateralCriteria together using OR logic.
    
    Parameters 
    ----------
    inputCriteria : CollateralCriteria
    
    Returns
    -------
    outputCriteria : CollateralCriteria
    
    """
    self = inspect.currentframe()
    
    
    outputCriteria = _get_rosetta_object('CollateralCriteria', 'AnyCriteria', _get_rosetta_object('AnyCriteria', 'anyCriteria', rosetta_resolve_attr(self, "inputCriteria")))
    
    
    return outputCriteria

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
