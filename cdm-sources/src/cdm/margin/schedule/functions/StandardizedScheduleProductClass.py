# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap import Qualify_BaseProduct_IRSwap
from cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance import Qualify_ForeignExchange_ParameterReturnVariance
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Index import Qualify_EquityOption_ParameterReturnVolatility_Index
from cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility import Qualify_ForeignExchange_ParameterReturnVolatility
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Basket import Qualify_EquityOption_ParameterReturnVolatility_Basket
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Basket import Qualify_EquityOption_ParameterReturnDividend_Basket
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index import Qualify_EquitySwap_ParameterReturnVolatility_Index
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_SingleName import Qualify_EquityOption_ParameterReturnVariance_SingleName
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index import Qualify_EquitySwap_ParameterReturnVariance_Index
from cdm.product.qualification.functions.Qualify_Commodity_Forward import Qualify_Commodity_Forward
from cdm.product.qualification.functions.Qualify_Commodity_Option import Qualify_Commodity_Option
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_SingleName import Qualify_EquitySwap_ParameterReturnDividend_SingleName
from cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap import Qualify_BaseProduct_EquitySwap
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Basket import Qualify_EquitySwap_ParameterReturnVolatility_Basket
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index import Qualify_EquitySwap_ParameterReturnDividend_Index
from cdm.product.qualification.functions.Qualify_ForeignExchange_Swap import Qualify_ForeignExchange_Swap
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Basket import Qualify_EquityOption_ParameterReturnVariance_Basket
from cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName import Qualify_CreditDefaultSwap_SingleName
from cdm.margin.schedule.functions.IsCreditNthToDefault import IsCreditNthToDefault
from cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index import Qualify_CreditDefaultSwap_Index
from cdm.product.qualification.functions.Qualify_ForeignExchange_NDF import Qualify_ForeignExchange_NDF
from cdm.product.qualification.functions.Qualify_ForeignExchange_NDS import Qualify_ForeignExchange_NDS
from cdm.product.qualification.functions.Qualify_CreditDefaultSwaption import Qualify_CreditDefaultSwaption
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Index import Qualify_EquityOption_ParameterReturnVariance_Index
from cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Basket import Qualify_EquityOption_PriceReturnBasicPerformance_Basket
from cdm.margin.schedule.StandardizedScheduleProductClassEnum import StandardizedScheduleProductClassEnum
from cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis import Qualify_Commodity_Swap_Basis
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Index import Qualify_EquityOption_ParameterReturnDividend_Index
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_SingleName import Qualify_EquityOption_ParameterReturnVolatility_SingleName
from cdm.product.qualification.functions.Qualify_BaseProduct_EquityForward import Qualify_BaseProduct_EquityForward
from cdm.margin.schedule.functions.IsFXNonDeliverableOption import IsFXNonDeliverableOption
from cdm.product.qualification.functions.Qualify_InterestRate_CapFloor import Qualify_InterestRate_CapFloor
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_SingleName import Qualify_EquityOption_ParameterReturnDividend_SingleName
from cdm.event.common.Trade import Trade
from cdm.product.qualification.functions.Qualify_Commodity_Swaption import Qualify_Commodity_Swaption
from cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward import Qualify_ForeignExchange_Spot_Forward
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_SingleName import Qualify_EquitySwap_ParameterReturnVolatility_SingleName
from cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche import Qualify_CreditDefaultSwap_IndexTranche
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Basket import Qualify_EquitySwap_ParameterReturnDividend_Basket
from cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat import Qualify_Commodity_Swap_FixedFloat
from cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnCorrelation_Basket import Qualify_EquityOption_ParameterReturnCorrelation_Basket
from cdm.margin.schedule.functions.IsIRSwaptionStraddle import IsIRSwaptionStraddle
from cdm.product.qualification.functions.Qualify_InterestRate_Fra import Qualify_InterestRate_Fra
from cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnCorrelation import Qualify_ForeignExchange_ParameterReturnCorrelation
from cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption import Qualify_InterestRate_Option_Swaption
from cdm.margin.schedule.functions.IsFXDeliverableOption import IsFXDeliverableOption
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Basket import Qualify_EquitySwap_ParameterReturnVariance_Basket
from cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_SingleName import Qualify_EquityOption_PriceReturnBasicPerformance_SingleName
from cdm.margin.schedule.functions.IsIRSwapWithCallableBermudanRightToEnterExitSwaps import IsIRSwapWithCallableBermudanRightToEnterExitSwaps
from cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index import Qualify_EquityOption_PriceReturnBasicPerformance_Index
from cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_SingleName import Qualify_EquitySwap_ParameterReturnVariance_SingleName
from cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency import Qualify_BaseProduct_CrossCurrency

__all__ = ['StandardizedScheduleProductClass']


@replaceable
def StandardizedScheduleProductClass(trade: Trade) -> StandardizedScheduleProductClassEnum:
    """
    Identifies the product class of a trade from qualifying functions, according to the standardized schedule classification.
    
    Parameters 
    ----------
    trade : Trade
    
    Returns
    -------
    productClass : StandardizedScheduleProductClassEnum
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn31():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAPTION")
    
    def _else_fn31():
        return True
    
    def _then_fn30():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "BASIS_SWAP")
    
    def _else_fn30():
        return if_cond_fn(Qualify_Commodity_Swaption(rosetta_resolve_attr(self, "economicTerms")), _then_fn31, _else_fn31)
    
    def _then_fn29():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "FIXED_FLOAT_SWAP")
    
    def _else_fn29():
        return if_cond_fn(Qualify_Commodity_Swap_Basis(rosetta_resolve_attr(self, "economicTerms")), _then_fn30, _else_fn30)
    
    def _then_fn28():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "OPTION")
    
    def _else_fn28():
        return if_cond_fn(Qualify_Commodity_Swap_FixedFloat(rosetta_resolve_attr(self, "economicTerms")), _then_fn29, _else_fn29)
    
    def _then_fn27():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "FORWARD")
    
    def _else_fn27():
        return if_cond_fn(Qualify_Commodity_Option(rosetta_resolve_attr(self, "economicTerms")), _then_fn28, _else_fn28)
    
    def _then_fn26():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAPS_AND_PORTFOLIO_SWAPS")
    
    def _else_fn26():
        return if_cond_fn(Qualify_Commodity_Forward(rosetta_resolve_attr(self, "economicTerms")), _then_fn27, _else_fn27)
    
    def _then_fn25():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "VOLATILITY_SWAP")
    
    def _else_fn25():
        return if_cond_fn(Qualify_BaseProduct_EquitySwap(rosetta_resolve_attr(self, "economicTerms")), _then_fn26, _else_fn26)
    
    def _then_fn24():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "VARIANCE_SWAP")
    
    def _else_fn24():
        return if_cond_fn(((Qualify_EquitySwap_ParameterReturnVolatility_Basket(rosetta_resolve_attr(self, "economicTerms")) or Qualify_EquitySwap_ParameterReturnVolatility_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquitySwap_ParameterReturnVolatility_SingleName(rosetta_resolve_attr(self, "economicTerms"))), _then_fn25, _else_fn25)
    
    def _then_fn23():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "DIVIDEND_SWAP")
    
    def _else_fn23():
        return if_cond_fn(((Qualify_EquitySwap_ParameterReturnVariance_Basket(rosetta_resolve_attr(self, "economicTerms")) or Qualify_EquitySwap_ParameterReturnVariance_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquitySwap_ParameterReturnVariance_SingleName(rosetta_resolve_attr(self, "economicTerms"))), _then_fn24, _else_fn24)
    
    def _then_fn22():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "FORWARD")
    
    def _else_fn22():
        return if_cond_fn(((Qualify_EquitySwap_ParameterReturnDividend_Basket(rosetta_resolve_attr(self, "economicTerms")) or Qualify_EquitySwap_ParameterReturnDividend_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquitySwap_ParameterReturnDividend_SingleName(rosetta_resolve_attr(self, "economicTerms"))), _then_fn23, _else_fn23)
    
    def _then_fn21():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "OPTION")
    
    def _else_fn21():
        return if_cond_fn(Qualify_BaseProduct_EquityForward(rosetta_resolve_attr(self, "economicTerms")), _then_fn22, _else_fn22)
    
    def _then_fn20():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "CORRELATION_SWAP")
    
    def _else_fn20():
        return if_cond_fn(((((((((((((Qualify_EquityOption_PriceReturnBasicPerformance_Basket(rosetta_resolve_attr(self, "economicTerms")) or Qualify_EquityOption_PriceReturnBasicPerformance_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_PriceReturnBasicPerformance_SingleName(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVolatility_Basket(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVolatility_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVolatility_SingleName(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVariance_Basket(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVariance_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnVariance_SingleName(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnCorrelation_Basket(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnDividend_Basket(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnDividend_Index(rosetta_resolve_attr(self, "economicTerms"))) or Qualify_EquityOption_ParameterReturnDividend_SingleName(rosetta_resolve_attr(self, "economicTerms"))), _then_fn21, _else_fn21)
    
    def _then_fn19():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "VOLATILITY_SWAP")
    
    def _else_fn19():
        return if_cond_fn(Qualify_ForeignExchange_ParameterReturnCorrelation(rosetta_resolve_attr(self, "economicTerms")), _then_fn20, _else_fn20)
    
    def _then_fn18():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "VARIANCE_SWAP")
    
    def _else_fn18():
        return if_cond_fn(Qualify_ForeignExchange_ParameterReturnVolatility(rosetta_resolve_attr(self, "economicTerms")), _then_fn19, _else_fn19)
    
    def _then_fn17():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "NON_DELIVERABLE_OPTION")
    
    def _else_fn17():
        return if_cond_fn(Qualify_ForeignExchange_ParameterReturnVariance(rosetta_resolve_attr(self, "economicTerms")), _then_fn18, _else_fn18)
    
    def _then_fn16():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "DELIVERABLE_OPTION")
    
    def _else_fn16():
        return if_cond_fn(IsFXNonDeliverableOption(rosetta_resolve_attr(self, "economicTerms")), _then_fn17, _else_fn17)
    
    def _then_fn15():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "NON_DELIVERABLE_FORWARD")
    
    def _else_fn15():
        return if_cond_fn(IsFXDeliverableOption(rosetta_resolve_attr(self, "economicTerms")), _then_fn16, _else_fn16)
    
    def _then_fn14():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "DELIVERABLE_FORWARD")
    
    def _else_fn14():
        return if_cond_fn(Qualify_ForeignExchange_NDF(rosetta_resolve_attr(self, "economicTerms")), _then_fn15, _else_fn15)
    
    def _then_fn13():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "NON_DELIVERABLE_CROSS_CURRENCY_SWAP")
    
    def _else_fn13():
        return if_cond_fn(Qualify_ForeignExchange_Spot_Forward(rosetta_resolve_attr(self, "economicTerms")), _then_fn14, _else_fn14)
    
    def _then_fn12():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "DELIVERABLE_SWAP")
    
    def _else_fn12():
        return if_cond_fn(Qualify_ForeignExchange_NDS(rosetta_resolve_attr(self, "economicTerms")), _then_fn13, _else_fn13)
    
    def _then_fn11():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "CREDIT_NTH_TO_DEFAULT")
    
    def _else_fn11():
        return if_cond_fn(Qualify_ForeignExchange_Swap(rosetta_resolve_attr(self, "economicTerms")), _then_fn12, _else_fn12)
    
    def _then_fn10():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAPTION")
    
    def _else_fn10():
        return if_cond_fn(IsCreditNthToDefault(rosetta_resolve_attr(self, "economicTerms")), _then_fn11, _else_fn11)
    
    def _then_fn9():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "INDEX_TRANCHE")
    
    def _else_fn9():
        return if_cond_fn(Qualify_CreditDefaultSwaption(rosetta_resolve_attr(self, "economicTerms")), _then_fn10, _else_fn10)
    
    def _then_fn8():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "INDEX_CDS")
    
    def _else_fn8():
        return if_cond_fn(Qualify_CreditDefaultSwap_IndexTranche(rosetta_resolve_attr(self, "economicTerms")), _then_fn9, _else_fn9)
    
    def _then_fn7():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SINGLE_NAME_CREDIT_DEFAULT_SWAP")
    
    def _else_fn7():
        return if_cond_fn(Qualify_CreditDefaultSwap_Index(rosetta_resolve_attr(self, "economicTerms")), _then_fn8, _else_fn8)
    
    def _then_fn6():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "FORWARD_RATE_AGREEMENT")
    
    def _else_fn6():
        return if_cond_fn(Qualify_CreditDefaultSwap_SingleName(rosetta_resolve_attr(self, "economicTerms")), _then_fn7, _else_fn7)
    
    def _then_fn5():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "OPTION")
    
    def _else_fn5():
        return if_cond_fn(Qualify_InterestRate_Fra(rosetta_resolve_attr(self, "economicTerms")), _then_fn6, _else_fn6)
    
    def _then_fn4():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAPTION")
    
    def _else_fn4():
        return if_cond_fn(Qualify_InterestRate_CapFloor(rosetta_resolve_attr(self, "economicTerms")), _then_fn5, _else_fn5)
    
    def _then_fn3():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAPTION_STRADDLE")
    
    def _else_fn3():
        return if_cond_fn(Qualify_InterestRate_Option_Swaption(rosetta_resolve_attr(self, "economicTerms")), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "CROSS_CURRENCY_SWAP")
    
    def _else_fn2():
        return if_cond_fn(IsIRSwaptionStraddle(rosetta_resolve_attr(self, "economicTerms")), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAP")
    
    def _else_fn1():
        return if_cond_fn(Qualify_BaseProduct_CrossCurrency(rosetta_resolve_attr(self, "economicTerms")), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return rosetta_resolve_attr(StandardizedScheduleProductClassEnum, "SWAP_WITH_CALLABLE_BERMUDAN_RIGHT_TO_ENTER_EXIT_SWAPS")
    
    def _else_fn0():
        return if_cond_fn(Qualify_BaseProduct_IRSwap(rosetta_resolve_attr(self, "economicTerms")), _then_fn1, _else_fn1)
    
    product = rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product")
    economicTerms = rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms")
    productClass =  if_cond_fn(IsIRSwapWithCallableBermudanRightToEnterExitSwaps(rosetta_resolve_attr(self, "economicTerms")), _then_fn0, _else_fn0)
    
    
    return productClass

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
