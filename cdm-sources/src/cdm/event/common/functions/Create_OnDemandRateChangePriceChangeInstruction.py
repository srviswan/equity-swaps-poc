# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.observable.asset.Price import Price

__all__ = ['Create_OnDemandRateChangePriceChangeInstruction']


@replaceable
def Create_OnDemandRateChangePriceChangeInstruction(priceQuantity: list[PriceQuantity], newRate: Decimal) -> QuantityChangeInstruction:
    """
    Creates a price change instruction for an on-demand rate change, based on a new rate provided as a single number by matching it to a single rate price.
    
    Parameters 
    ----------
    priceQuantity : PriceQuantity
    The original price / quantity to be modified with the new rate.
    
    newRate : number
    The new rate value, provided as a single number.
    
    Returns
    -------
    quantityChangeInstruction : QuantityChangeInstruction
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_OneRatePrice(self):
        """
        There should be 1 and only 1 rate type price in the current price.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(self, "currentRatePrice"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    currentRatePrice = (lambda item: get_only_element(item))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))))((lambda item: flatten_list(item))(map(lambda item: rosetta_resolve_attr(self, "price"), rosetta_resolve_attr(self, "priceQuantity")))))
    newPrice = Price(value=rosetta_resolve_attr(self, "newRate"), unit=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "unit"), perUnitOf=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "perUnitOf"), priceType=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "priceType"), priceExpression=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "priceExpression"), composite=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "composite"), arithmeticOperator=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "arithmeticOperator"), cashPrice=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentRatePrice"), "cashPrice"), datedValue=[])
    newPriceQuantity = PriceQuantity(price=rosetta_resolve_attr(self, "newPrice"))
    quantityChangeInstruction =  QuantityChangeInstruction(change=rosetta_resolve_attr(self, "newPriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[])
    
    
    return quantityChangeInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
