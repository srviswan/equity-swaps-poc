# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.qualification.functions.Qualify_AssetClass_Equity import Qualify_AssetClass_Equity
from cdm.event.common.Trade import Trade
from cdm.margin.schedule.StandardizedScheduleAssetClassEnum import StandardizedScheduleAssetClassEnum
from cdm.product.qualification.functions.Qualify_AssetClass_InterestRate import Qualify_AssetClass_InterestRate
from cdm.product.qualification.functions.Qualify_AssetClass_Credit import Qualify_AssetClass_Credit
from cdm.product.qualification.functions.Qualify_AssetClass_Commodity import Qualify_AssetClass_Commodity
from cdm.product.qualification.functions.Qualify_AssetClass_ForeignExchange import Qualify_AssetClass_ForeignExchange

__all__ = ['StandardizedScheduleAssetClass']


@replaceable
def StandardizedScheduleAssetClass(trade: Trade) -> StandardizedScheduleAssetClassEnum:
    """
    Identifies the asset class of a trade from qualifying functions, according to the standardized schedule classification.
    
    Parameters 
    ----------
    trade : Trade
    
    Returns
    -------
    assetClass : StandardizedScheduleAssetClassEnum
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn4():
        return rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "COMMODITY")
    
    def _else_fn4():
        return True
    
    def _then_fn3():
        return rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "EQUITY")
    
    def _else_fn3():
        return if_cond_fn(Qualify_AssetClass_Commodity(rosetta_resolve_attr(self, "economicTerms")), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "FOREIGN_EXCHANGE")
    
    def _else_fn2():
        return if_cond_fn(Qualify_AssetClass_Equity(rosetta_resolve_attr(self, "economicTerms")), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "CREDIT")
    
    def _else_fn1():
        return if_cond_fn(Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "INTEREST_RATES")
    
    def _else_fn0():
        return if_cond_fn(Qualify_AssetClass_Credit(rosetta_resolve_attr(self, "economicTerms")), _then_fn1, _else_fn1)
    
    product = rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product")
    economicTerms = rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms")
    assetClass =  if_cond_fn(Qualify_AssetClass_InterestRate(rosetta_resolve_attr(self, "economicTerms")), _then_fn0, _else_fn0)
    
    
    return assetClass

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
