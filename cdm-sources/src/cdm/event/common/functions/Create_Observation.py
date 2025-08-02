# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ObservationInstruction import ObservationInstruction
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_Observation']


@replaceable
def Create_Observation(instruction: ObservationInstruction, before: TradeState) -> TradeState:
    """
    Function specification to create an observation that incorporates an observation event into the observation history of a given trade state.
    
    Parameters 
    ----------
    instruction : ObservationInstruction
    
    before : TradeState
    Specifies the trade to be updated.
    
    Returns
    -------
    after : TradeState
    
    """
    self = inspect.currentframe()
    
    
    after =  rosetta_resolve_attr(self, "before")
    after.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, after), 'observationHistory'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "observationEvent"))
    
    
    return after

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
