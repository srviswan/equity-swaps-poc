# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.EmptyTransferHistory import EmptyTransferHistory
from cdm.base.staticdata.party.Counterparty import Counterparty
from cdm.base.staticdata.party.AncillaryParty import AncillaryParty
from cdm.base.staticdata.party.CounterpartyRoleEnum import CounterpartyRoleEnum
from cdm.base.staticdata.party.PartyRole import PartyRole
from cdm.event.common.TradeIdentifier import TradeIdentifier
from cdm.base.staticdata.party.functions.ReplaceParty import ReplaceParty
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_PartyChange']


@replaceable
def Create_PartyChange(counterparty: Counterparty, ancillaryParty: AncillaryParty | None, partyRole: PartyRole | None, tradeId: list[TradeIdentifier], originalTrade: TradeState) -> TradeState:
    """
    Defines the logic for changing one of the counterparties on a trade. A new trade identifier must be specified as a change of party results in a new trade. An ancillary party can also be specified, for instance to refer to the original executing party on the new trade.
    
    Parameters 
    ----------
    counterparty : Counterparty
    The counterparty to change and the role it plays in the transaction.
    
    ancillaryParty : AncillaryParty
    Optional ancillary party, which can be used to keep a reference to the original executing party, for instance.
    
    partyRole : PartyRole
    
    tradeId : TradeIdentifier
    A mandatory trade identifier must be specified, as the chnage of party results in a new trade.
    
    originalTrade : TradeState
    The original trade on which to update the counterparty. The original trade will be terminated.
    
    Returns
    -------
    newTrade : TradeState
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return Counterparty(partyReference={rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "partyReference"): True}, role=rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "role"))
    
    def _else_fn0():
        return ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "counterparty"), rosetta_resolve_attr(CounterpartyRoleEnum, "PARTY_1"))
    
    def _then_fn1():
        return Counterparty(partyReference={rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "partyReference"): True}, role=rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "role"))
    
    def _else_fn1():
        return ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "counterparty"), rosetta_resolve_attr(CounterpartyRoleEnum, "PARTY_2"))
    
    counterparty1 = if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "role"), "=", rosetta_resolve_attr(CounterpartyRoleEnum, "PARTY_1")), _then_fn0, _else_fn0)
    counterparty2 = if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "role"), "=", rosetta_resolve_attr(CounterpartyRoleEnum, "PARTY_2")), _then_fn1, _else_fn1)
    partyToRemove = rosetta_resolve_attr(ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "role")), "partyReference")
    newTrade =  rosetta_resolve_attr(self, "originalTrade")
    newTrade = _get_rosetta_object('TradeState', 'trade', _get_rosetta_object('Trade', 'counterparty', [rosetta_resolve_attr(self, "counterparty1"), rosetta_resolve_attr(self, "counterparty2")]))
    newTrade = set_rosetta_attr(rosetta_resolve_attr(self, 'newTrade'), 'trade->party', ReplaceParty(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "originalTrade"), "trade"), "party"), rosetta_resolve_attr(self, "partyToRemove"), rosetta_resolve_attr(rosetta_resolve_attr(self, "counterparty"), "partyReference")))
    newTrade = set_rosetta_attr(rosetta_resolve_attr(self, 'newTrade'), 'trade->tradeIdentifier', rosetta_resolve_attr(self, "tradeId"))
    newTrade.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, newTrade), 'trade'), 'party'), rosetta_resolve_attr(rosetta_resolve_attr(self, "ancillaryParty"), "partyReference"))
    newTrade.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, newTrade), 'trade'), 'ancillaryParty'), rosetta_resolve_attr(self, "ancillaryParty"))
    newTrade.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, newTrade), 'trade'), 'party'), rosetta_resolve_attr(rosetta_resolve_attr(self, "partyRole"), "partyReference"))
    newTrade.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, newTrade), 'trade'), 'partyRole'), rosetta_resolve_attr(self, "partyRole"))
    newTrade = set_rosetta_attr(rosetta_resolve_attr(self, 'newTrade'), 'transferHistory', EmptyTransferHistory())
    
    
    return newTrade

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
