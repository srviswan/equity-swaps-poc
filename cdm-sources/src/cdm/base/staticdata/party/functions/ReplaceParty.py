# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.Party import Party

__all__ = ['ReplaceParty']


@replaceable
def ReplaceParty(parties: list[Party] | None, oldParty: Party, newParty: Party) -> Party:
    """
    Removes the old party, and adds the new party.
    
    Parameters 
    ----------
    parties : Party
    Specifies the list of parties to update.
    
    oldParty : Party
    Specifies the party to be removed.
    
    newParty : Party
    Specifies the party to be added.
    
    Returns
    -------
    updatedParties : Party
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "newParty")
    
    def _else_fn0():
        return item
    
    updatedParties = (lambda item: set(item))(map(lambda item: if_cond_fn(all_elements(item, "=", rosetta_resolve_attr(self, "oldParty")), _then_fn0, _else_fn0), rosetta_resolve_attr(self, "parties")))
    
    
    return updatedParties

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
