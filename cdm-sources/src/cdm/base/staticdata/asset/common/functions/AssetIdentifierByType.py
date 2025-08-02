# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.common.AssetIdTypeEnum import AssetIdTypeEnum
from cdm.base.staticdata.asset.common.AssetIdentifier import AssetIdentifier

__all__ = ['AssetIdentifierByType']


@replaceable
def AssetIdentifierByType(identifiers: list[AssetIdentifier] | None, idType: AssetIdTypeEnum) -> AssetIdentifier:
    """
    Returns all the Asset Identifiers of a certain Identifier Type.
    
    Parameters 
    ----------
    identifiers : AssetIdentifier
    
    idType : AssetIdTypeEnum
    
    Returns
    -------
    filteredIdentifier : AssetIdentifier
    
    """
    self = inspect.currentframe()
    
    
    filteredIdentifier = rosetta_filter(rosetta_resolve_attr(self, "identifiers"), lambda item: all_elements(rosetta_resolve_attr(item, "identifierType"), "=", rosetta_resolve_attr(self, "idType")))
    
    
    return filteredIdentifier

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
