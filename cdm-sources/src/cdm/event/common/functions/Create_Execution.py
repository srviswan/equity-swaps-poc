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
from cdm.event.common.TradeState import TradeState
from cdm.event.common.ExecutionInstruction import ExecutionInstruction
from cdm.event.position.PositionStatusEnum import PositionStatusEnum

__all__ = ['Create_Execution']


@replaceable
def Create_Execution(instruction: ExecutionInstruction) -> TradeState:
    """
    Specifies the function to compose an execution based on a minimum required set of inputs: product, quantity, parties, etc.
    
    Parameters 
    ----------
    instruction : ExecutionInstruction
    Instructions to be used as an input to the function
    
    Returns
    -------
    execution : TradeState
    
    """
    self = inspect.currentframe()
    
    
    execution = _get_rosetta_object('TradeState', 'trade', _get_rosetta_object('Trade', 'product', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "product")))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'tradeLot'), TradeLot(priceQuantity=rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "priceQuantity"), lotIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "lotIdentifier")))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'counterparty'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "counterparty"))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'ancillaryParty'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "ancillaryParty"))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'party'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "parties"))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'partyRole'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "partyRoles"))
    execution = set_rosetta_attr(rosetta_resolve_attr(self, 'execution'), 'trade->executionDetails', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "executionDetails"))
    execution = set_rosetta_attr(rosetta_resolve_attr(self, 'execution'), 'trade->tradeDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "tradeDate"))
    execution.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, execution), 'trade'), 'tradeIdentifier'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "tradeIdentifier"))
    execution = set_rosetta_attr(rosetta_resolve_attr(self, 'execution'), 'state->positionState', rosetta_resolve_attr(PositionStatusEnum, "EXECUTED"))
    execution = set_rosetta_attr(rosetta_resolve_attr(self, 'execution'), 'trade->collateral', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "collateral"))
    
    
    return execution

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
