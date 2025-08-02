# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['InterestRatePayoutCurrency']


@replaceable
def InterestRatePayoutCurrency(interestRatePayouts: list[InterestRatePayout] | None) -> str:
    """
    
    Parameters 
    ----------
    interestRatePayouts : InterestRatePayout
    List of interest rate payouts.
    
    Returns
    -------
    currency : string
    
    """
    self = inspect.currentframe()
    
    
    currency = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayouts"), "priceQuantity"), "quantitySchedule"), "unit"), "currency")
    currency.add_rosetta_attr(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayouts"), "priceQuantity"), "quantityMultiplier"), "fxLinkedNotionalSchedule"), "varyingNotionalCurrency"))
    
    
    return currency

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
