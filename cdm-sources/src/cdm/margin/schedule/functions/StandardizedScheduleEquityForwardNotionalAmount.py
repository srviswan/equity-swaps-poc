# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.SettlementPayout import SettlementPayout

__all__ = ['StandardizedScheduleEquityForwardNotionalAmount']


@replaceable
def StandardizedScheduleEquityForwardNotionalAmount(settlementPayout: SettlementPayout | None) -> Decimal:
    """
    Extracts the notional amount of an EQ forward.
    
    Parameters 
    ----------
    settlementPayout : SettlementPayout
    
    Returns
    -------
    amount : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return (rosetta_resolve_attr(self, "value") * rosetta_resolve_attr(rosetta_resolve_attr(self, "multiplier"), "value"))
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "value")
    
    forwardPrice = rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementPayout"), "priceQuantity"), "priceSchedule")), "value")
    notionalQuantity = (lambda item: if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "multiplier")), _then_fn0, _else_fn0))(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementPayout"), "priceQuantity"), "quantitySchedule"))
    amount =  (rosetta_resolve_attr(self, "forwardPrice") * rosetta_resolve_attr(self, "notionalQuantity"))
    
    
    return amount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
