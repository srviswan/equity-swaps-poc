# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradeLot import TradeLot
from cdm.base.staticdata.identifier.Identifier import Identifier

__all__ = ['FilterTradeLot']


@replaceable
def FilterTradeLot(tradeLots: list[TradeLot] | None, lotIdentifier: list[Identifier] | None) -> TradeLot:
    """
    Filter list of TradeLot based on TradeLot->lotIdentifier.
    
    Parameters 
    ----------
    tradeLots : TradeLot
    List of TradeLots to filter.
    
    lotIdentifier : Identifier
    The lot Identifiers to filter by.
    
    Returns
    -------
    filteredTradeLots : TradeLot
    
    """
    self = inspect.currentframe()
    
    
    filteredTradeLots = rosetta_filter(rosetta_resolve_attr(self, "tradeLots"), lambda item: all_elements(rosetta_resolve_attr(item, "lotIdentifier"), "=", rosetta_resolve_attr(self, "lotIdentifier")))
    
    
    return filteredTradeLots

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
