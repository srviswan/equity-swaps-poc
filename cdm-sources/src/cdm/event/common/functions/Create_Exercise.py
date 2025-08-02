# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ExerciseInstruction import ExerciseInstruction
from cdm.product.template.OptionTypeEnum import OptionTypeEnum
from cdm.event.common.TradeState import TradeState
from cdm.event.common.functions.Update_ProductDirection import Update_ProductDirection
from cdm.event.common.ExecutionInstruction import ExecutionInstruction
from cdm.event.common.functions.Create_NonTransferableProduct import Create_NonTransferableProduct
from cdm.event.common.functions.Create_Execution import Create_Execution

__all__ = ['Create_Exercise']


@replaceable
def Create_Exercise(exerciseInstruction: ExerciseInstruction, originalTrade: TradeState) -> TradeState:
    """
    Defines the process of putting into effect the rights specified in an options contract, such as to buy or sell a security.  Once exercised the option contract is terminated.
    
    Parameters 
    ----------
    exerciseInstruction : ExerciseInstruction
    Instruction containing the terms of the option exercise.
    
    originalTrade : TradeState
    The original trade to be split, which must be of single cardinality.
    
    Returns
    -------
    exercise : TradeState
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_OptionPayoutExists(self):
        """
        Requires that the original contract contains an option payout.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(self, "optionPayout"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "exerciseInstruction"), "exerciseOption")
    
    def _else_fn0():
        return get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "product"), "economicTerms"), "payout"), "OptionPayout"))
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "NonTransferableProduct")
    
    def _else_fn1():
        return Create_NonTransferableProduct(rosetta_resolve_attr(self, "underlier"), rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "payerReceiver"))
    
    def _then_fn2():
        return Update_ProductDirection(rosetta_resolve_attr(self, "resultProduct"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "payerReceiver"), "payer"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "payerReceiver"), "receiver"))
    
    def _else_fn2():
        return rosetta_resolve_attr(self, "resultProduct")
    
    optionPayout = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "exerciseInstruction"), "exerciseOption")), _then_fn0, _else_fn0)
    underlier = rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "underlier")
    resultProduct = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "NonTransferableProduct")), _then_fn1, _else_fn1)
    productWithDirection = if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "optionType"), "=", rosetta_resolve_attr(OptionTypeEnum, "PUT")), _then_fn2, _else_fn2)
    execution = Create_Execution(ExecutionInstruction(product=rosetta_resolve_attr(self, "productWithDirection"), priceQuantity=rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "tradeLot")), "priceQuantity"), counterparty=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "counterparty"), ancillaryParty=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "ancillaryParty"), parties=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "party"), partyRoles=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "partyRole"), executionDetails=[], tradeDate=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "tradeDate"), tradeIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(self, "exerciseInstruction"), "replacementTradeIdentifier")))
    exercise = Create_TradeState(rosetta_resolve_attr(rosetta_resolve_attr(self, "exerciseInstruction"), "exerciseQuantity"), rosetta_resolve_attr(self, "originalTrade"))
    exercise.add_rosetta_attr(self, rosetta_resolve_attr(self, "execution"))
    
    
    return exercise

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
