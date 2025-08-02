# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.identifier.Identifier import Identifier
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.Instruction import Instruction
from cdm.event.common.functions.Create_PackageExecutionDetails import Create_PackageExecutionDetails
from cdm.event.common.TradeState import TradeState
from cdm.event.common.ExecutionInstruction import ExecutionInstruction
from cdm.event.common.functions.Create_ContractFormationInstruction import Create_ContractFormationInstruction

__all__ = ['Create_PairOffInstruction']


@replaceable
def Create_PairOffInstruction(tradeState: list[TradeState], pairReference: Identifier) -> Instruction:
    """
    Creates a set of instructions to pair-off a set of trades based on a pair reference. A package component is created based on that pair reference and the list of identifiers for the underlying trades. That package component is then added onto the execution details of every underlying trade. The existing trades are not terminated.
    
    Parameters 
    ----------
    tradeState : TradeState
    The trades to pair-off. There must be at least 2.
    
    pairReference : Identifier
    The reference ID of the paired trades.
    
    Returns
    -------
    instruction : Instruction
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return Create_ContractFormationInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "contractDetails"), "documentation"))
    
    def _else_fn0():
        return True
    
    componentId = map(lambda item: get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeIdentifier")), rosetta_resolve_attr(self, "tradeState"))
    instruction =  map(lambda item: Instruction(before=item, primitiveInstruction=PrimitiveInstruction(contractFormation=if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "state"), "positionState"), "=", rosetta_resolve_attr(PositionStatusEnum, "FORMED")), _then_fn0, _else_fn0), execution=ExecutionInstruction(product=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "product"), priceQuantity=rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeLot")), "priceQuantity"), counterparty=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "counterparty"), ancillaryParty=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "ancillaryParty"), parties=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "party"), partyRoles=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "partyRole"), executionDetails=Create_PackageExecutionDetails(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "executionDetails"), rosetta_resolve_attr(self, "pairReference"), rosetta_resolve_attr(self, "componentId")), tradeDate=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeDate"), tradeIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeIdentifier")))), rosetta_resolve_attr(self, "tradeState"))
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
