# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.CollateralPortfolio import CollateralPortfolio
from cdm.event.common.TradeState import TradeState
from cdm.event.common.functions.Create_SubstitutionInstruction import Create_SubstitutionInstruction
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_SubstitutionPrimitiveInstruction']


@replaceable
def Create_SubstitutionPrimitiveInstruction(tradeState: TradeState, effectiveDate: AdjustableOrRelativeDate, newCollateralPortfolio: CollateralPortfolio, priceQuantity: list[PriceQuantity]) -> PrimitiveInstruction:
    """
    Creates the primitive instructions for a substitution of collateral by replacing the assetpayout of the trade.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be for substitution of collateral.
    
    effectiveDate : AdjustableOrRelativeDate
    The date to close and open a new trade with new collateral.
    
    newCollateralPortfolio : CollateralPortfolio
    New collateral portfolio to subtitute for the original collateral.
    
    priceQuantity : PriceQuantity
    The price and quantity of the substituted product.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_SecurityFinance(self):
        """
        Only security finance products can substitute collateral.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), "economicTerms"), "collateral"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    instruction =  PrimitiveInstruction(quantityChange=QuantityChangeInstruction(change=rosetta_resolve_attr(self, "priceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]), termsChange=Create_SubstitutionInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), rosetta_resolve_attr(self, "effectiveDate"), rosetta_resolve_attr(self, "newCollateralPortfolio")))
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
