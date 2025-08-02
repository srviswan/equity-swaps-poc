# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ExecutionDetails import ExecutionDetails

__all__ = ['EmptyExecutionDetails']


@replaceable
def EmptyExecutionDetails() -> ExecutionDetails:
    """
    
    Parameters 
    ----------
    
    Returns
    -------
    executionDetails : ExecutionDetails
    
    """
    self = inspect.currentframe()
    
    
    executionDetails = rosetta_resolve_attr(self, "executionDetails")
    
    
    return executionDetails

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
