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
from cdm.event.common.TradeState import TradeState
from cdm.observable.asset.Price import Price
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_AdjustmentPrimitiveInstruction']


@replaceable
def Create_AdjustmentPrimitiveInstruction(tradeState: TradeState, newAllinPrice: Decimal, newAssetQuantity: Decimal, effectiveRepriceDate: AdjustableOrRelativeDate) -> PrimitiveInstruction:
    """
    Creates the primitive instructions for a repricing that alters the collateral quantity and value of the trade. Transaction value and variation margin are processed separately as are transfers of cash and securities.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade state and trade to be repriced.
    
    newAllinPrice : number
    The collateral new all-in price.
    
    newAssetQuantity : number
    The collateral new quantity.
    
    effectiveRepriceDate : AdjustableOrRelativeDate
    The date to reprice the collateral
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_SingleTradeLot(self):
        """
        This repricing function applies only to trades with a single lot.
        """
        return all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "=", 1)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    oldPriceQuantity = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot"), "priceQuantity")
    currentAssetPrice = (lambda item: get_only_element(item))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE"))))((lambda item: flatten_list(item))(map(lambda item: rosetta_resolve_attr(self, "price"), rosetta_resolve_attr(self, "oldPriceQuantity")))))
    newPrice = Price(value=rosetta_resolve_attr(self, "newAllinPrice"), unit=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "unit"), perUnitOf=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "perUnitOf"), priceType=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "priceType"), priceExpression=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "priceExpression"), composite=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "composite"), arithmeticOperator=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "arithmeticOperator"), cashPrice=rosetta_resolve_attr(rosetta_resolve_attr(self, "currentAssetPrice"), "cashPrice"), datedValue=[])
    changeQuantity = (lambda item: set(item))(map(lambda item: NonNegativeQuantitySchedule(value=rosetta_resolve_attr(self, "newAssetQuantity"), unit=rosetta_resolve_attr(self, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity"), "quantity")))
    newPriceQuantity = PriceQuantity(price=[rosetta_resolve_attr(self, "newPrice")], quantity=rosetta_resolve_attr(self, "changeQuantity"))
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, instruction), 'split'), 'breakdown'), [PrimitiveInstruction(quantityChange=QuantityChangeInstruction(change=[rosetta_resolve_attr(self, "newPriceQuantity")], direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]), termsChange=Create_EffectiveOrTerminationDateTermChangeInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), rosetta_resolve_attr(self, "effectiveRepriceDate"), []))])
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
