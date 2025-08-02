# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.identifier.Identifier import Identifier
from cdm.event.common.ExecutionDetails import ExecutionDetails

__all__ = ['Create_PackageExecutionDetails']


@replaceable
def Create_PackageExecutionDetails(executionDetails: ExecutionDetails | None, listId: Identifier, componentId: list[Identifier]) -> ExecutionDetails:
    """
    Add a package component to an execution details object. This package component is constructed using an identifier for the package and the list of identifiers for its components.
    
    Parameters 
    ----------
    executionDetails : ExecutionDetails
    The original execution details. These may be empty.
    
    listId : Identifier
    The identifier for the package.
    
    componentId : Identifier
    The list of identifiers for the package components. There must be at least 2.
    
    Returns
    -------
    newExecutionDetails : ExecutionDetails
    
    """
    self = inspect.currentframe()
    
    
    newExecutionDetails = _get_rosetta_object('ExecutionDetails', 'executionType', rosetta_resolve_attr(rosetta_resolve_attr(self, "executionDetails"), "executionType"))
    newExecutionDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'newExecutionDetails'), 'executionVenue', rosetta_resolve_attr(rosetta_resolve_attr(self, "executionDetails"), "executionVenue"))
    newExecutionDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'newExecutionDetails'), 'packageReference->listId', rosetta_resolve_attr(self, "listId"))
    newExecutionDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'newExecutionDetails'), 'packageReference->componentId', rosetta_resolve_attr(self, "componentId"))
    
    
    return newExecutionDetails

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
