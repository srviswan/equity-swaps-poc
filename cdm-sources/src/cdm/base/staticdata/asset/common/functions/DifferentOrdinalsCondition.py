# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.Taxonomy import Taxonomy

__all__ = ['DifferentOrdinalsCondition']


@replaceable
def DifferentOrdinalsCondition(taxonomy: Taxonomy) -> bool:
    """
    
    Parameters 
    ----------
    taxonomy : Taxonomy
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  all_elements(map(lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "classification"), "ordinal"), "=", set(rosetta_resolve_attr(rosetta_resolve_attr(self, "classification"), "ordinal"))), rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomy"), "value")), "=", True)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
