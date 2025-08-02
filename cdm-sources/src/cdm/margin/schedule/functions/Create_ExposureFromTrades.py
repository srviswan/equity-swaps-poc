# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.Product import Product
from cdm.event.common.TradeState import TradeState
from cdm.event.position.Position import Position
from cdm.event.common.Exposure import Exposure

__all__ = ['Create_ExposureFromTrades']


@replaceable
def Create_ExposureFromTrades(trades: list[TradeState] | None) -> Exposure:
    """
    Builds an Exposure structure from a collection of trades.
    
    Parameters 
    ----------
    trades : TradeState
    
    Returns
    -------
    exposure : Exposure
    
    """
    self = inspect.currentframe()
    
    
    exposure = map(lambda item: Position(cashBalance=[], priceQuantity=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeLot"), "priceQuantity"), tradeReference=[], product=Product(NonTransferableProduct=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "product"))), rosetta_resolve_attr(self, "trades"))
    exposure = _get_rosetta_object('Exposure', 'tradePortfolio', _get_rosetta_object('PortfolioState', 'lineage', _get_rosetta_object('Lineage', 'tradeReference', rosetta_resolve_attr(rosetta_resolve_attr(self, "trades"), "trade")[0])))
    
    
    return exposure

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
