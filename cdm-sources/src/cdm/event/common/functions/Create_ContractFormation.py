# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ContractFormationInstruction import ContractFormationInstruction
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_ContractFormation']


@replaceable
def Create_ContractFormation(instruction: ContractFormationInstruction, execution: TradeState) -> TradeState:
    """
    Function specification that represents an executed trade for a contractual product that has been affirmed (or confirmed) by the two parties. The formed contract can reference a legal agreement for instance a master agreement, by using the optional legalAgreement input.
    
    Parameters 
    ----------
    instruction : ContractFormationInstruction
    Instructions to be used as an input to the function
    
    execution : TradeState
    
    Returns
    -------
    contractFormation : TradeState
    
    """
    self = inspect.currentframe()
    
    
    contractFormation =  rosetta_resolve_attr(self, "execution")
    contractFormation.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, contractFormation), 'trade'), 'contractDetails'), 'documentation'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "legalAgreement"))
    contractFormation = _get_rosetta_object('TradeState', 'state', _get_rosetta_object('State', 'positionState', rosetta_resolve_attr(PositionStatusEnum, "FORMED")))
    
    
    return contractFormation

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
