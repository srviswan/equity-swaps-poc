# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradableProduct import TradableProduct

__all__ = ['ExtractTradeCollateralPrice']


@replaceable
def ExtractTradeCollateralPrice(tradableProduct: TradableProduct) -> Decimal:
    """
    
    Parameters 
    ----------
    tradableProduct : TradableProduct
    
    Returns
    -------
    value : number
    
    """
    self = inspect.currentframe()
    
    
    value =  (lambda item: map(lambda item: rosetta_resolve_attr(item, "value"), item))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(item, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE"))))((lambda item: flatten_list(item))(map(lambda item: rosetta_resolve_attr(item, "price"), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradableProduct"), "tradeLot")), "priceQuantity")))))
    
    
    return value

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
