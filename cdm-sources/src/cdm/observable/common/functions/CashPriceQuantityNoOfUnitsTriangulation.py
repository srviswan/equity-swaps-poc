# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule
from cdm.observable.asset.PriceSchedule import PriceSchedule

__all__ = ['CashPriceQuantityNoOfUnitsTriangulation']


@replaceable
def CashPriceQuantityNoOfUnitsTriangulation(quantity: list[NonNegativeQuantitySchedule] | None, price: list[PriceSchedule] | None) -> bool:
    """
    Data rule to check the relationship between cash price, notional and number of units.
    
    Parameters 
    ----------
    quantity : NonNegativeQuantitySchedule
    
    price : PriceSchedule
    
    Returns
    -------
    success : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return all_elements((rosetta_resolve_attr(self, "cashPrice") * rosetta_resolve_attr(self, "noOfUnits")), "=", rosetta_resolve_attr(self, "notional"))
    
    def _else_fn0():
        return True
    
    notional = (lambda item: get_only_element(item))((lambda item: set(item))(map(lambda item: rosetta_resolve_attr(self, "value"), FilterQuantityByCurrencyExists(rosetta_resolve_attr(self, "quantity")))))
    noOfUnits = (lambda item: get_only_element(item))(map(lambda item: rosetta_resolve_attr(self, "value"), FilterQuantityByFinancialUnit(rosetta_resolve_attr(self, "quantity"), rosetta_resolve_attr(FinancialUnitEnum, "SHARE"))))
    cashPrice = (lambda item: get_only_element(item))((lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))(rosetta_filter(rosetta_resolve_attr(self, "price"), lambda item: all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE")))))
    success =  if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(self, "cashPrice")) and rosetta_attr_exists(rosetta_resolve_attr(self, "noOfUnits"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "notional"))), _then_fn0, _else_fn0)
    
    
    return success

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
