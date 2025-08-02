# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradeLot import TradeLot
from cdm.base.staticdata.identifier.Identifier import Identifier
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.event.common.TradeState import TradeState
from cdm.event.common.ExecutionInstruction import ExecutionInstruction

__all__ = ['Create_ShapingInstruction']


@replaceable
def Create_ShapingInstruction(tradeState: TradeState, tradeLots: list[TradeLot], shapeIdentifier: Identifier) -> PrimitiveInstruction:
    """
    Creates a set of instructions to shape a trade based on shaped quantities and a package ID. The original trade is closed and split into (smaller) shaped trades based on a set of trade lots containing the shaped quantities and an identifier for each shaped trade. A package component is created based on the package ID and the list of identifiers for the shaped trades. That package component is then added onto the execution details of every shaped trade.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be shaped.
    
    tradeLots : TradeLot
    The shaped quantities provided as full set of trade lots with price and quantity. Each trade lot also contains an identifier to associate to the corresponding shaped trade. Shaping must result in at least 2 shaped trades.
    
    shapeIdentifier : Identifier
    The package ID of the shaped trades.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return Create_ContractFormationInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "contractDetails"), "documentation"))
    
    def _else_fn0():
        return True
    
    componentId = map(lambda item: get_only_element(rosetta_resolve_attr(item, "lotIdentifier")), rosetta_resolve_attr(self, "tradeLots"))
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, instruction), 'split'), 'breakdown'), (lambda item: map(lambda item: PrimitiveInstruction(contractFormation=if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "state"), "positionState"), "=", rosetta_resolve_attr(PositionStatusEnum, "FORMED")), _then_fn0, _else_fn0), execution=ExecutionInstruction(product=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), priceQuantity=rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity"), counterparty=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"), ancillaryParty=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "ancillaryParty"), parties=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "party"), partyRoles=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "partyRole"), executionDetails=Create_PackageExecutionDetails(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "executionDetails"), rosetta_resolve_attr(self, "shapeIdentifier"), rosetta_resolve_attr(self, "componentId")), tradeDate=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeDate"), tradeIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeIdentifier")), quantityChange=QuantityChangeInstruction(change=item, direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[])), item))(map(lambda item: rosetta_resolve_attr(self, "priceQuantity"), rosetta_resolve_attr(self, "tradeLots"))))
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
