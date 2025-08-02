# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.ResolvePerformanceObservationIdentifiers import ResolvePerformanceObservationIdentifiers
from cdm.event.common.functions.ResolvePerformanceReset import ResolvePerformanceReset
from cdm.observable.event.functions.ResolveObservation import ResolveObservation
from cdm.event.common.functions.ResolveInterestRateObservationIdentifiers import ResolveInterestRateObservationIdentifiers
from cdm.event.common.functions.ResolveInterestRateReset import ResolveInterestRateReset
from cdm.event.common.TradeState import TradeState
from cdm.event.common.ResetInstruction import ResetInstruction

__all__ = ['Create_Reset']


@replaceable
def Create_Reset(instruction: ResetInstruction, tradeState: TradeState) -> TradeState:
    """
    Defines how a Reset should be constructed.
    
    Parameters 
    ----------
    instruction : ResetInstruction
    Specifies the reset instructions.
    
    tradeState : TradeState
    Specifies the trade that is resetting.
    
    Returns
    -------
    reset : TradeState
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "rateRecordDate")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "resetDate")
    
    def _then_fn2():
        return ResolveInterestRateObservationIdentifiers(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout")), rosetta_resolve_attr(self, "observationDate"))
    
    def _else_fn2():
        return True
    
    def _then_fn1():
        return ResolvePerformanceObservationIdentifiers(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "resetDate"))
    
    def _else_fn1():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout")), _then_fn2, _else_fn2)
    
    def _then_fn3():
        return ResolveInterestRateReset(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout"), rosetta_resolve_attr(self, "observation"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "resetDate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "rateRecordDate"))
    
    def _else_fn3():
        return True
    
    def _then_fn2():
        return ResolvePerformanceReset(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")), rosetta_resolve_attr(self, "observation"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "resetDate"))
    
    def _else_fn2():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout")), _then_fn3, _else_fn3)
    
    payout = rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout")
    observationDate = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "rateRecordDate")), _then_fn0, _else_fn0)
    observationIdentifiers = if_cond_fn(all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")), "=", 1), _then_fn1, _else_fn1)
    observation = ResolveObservation([rosetta_resolve_attr(self, "observationIdentifiers")], [])
    reset =  rosetta_resolve_attr(self, "tradeState")
    reset.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, reset), 'resetHistory'), if_cond_fn(all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")), "=", 1), _then_fn0, _else_fn0))
    
    
    return reset

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
