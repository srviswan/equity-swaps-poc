# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018 import EquitySwapMasterConfirmation2018
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['NewFloatingPayout']


@replaceable
def NewFloatingPayout(masterConfirmation: EquitySwapMasterConfirmation2018 | None) -> InterestRatePayout:
    """
    Function specification to create the interest rate (floating) payout part of an Equity Swap according to the 2018 ISDA CDM Equity Confirmation template.
    
    Parameters 
    ----------
    masterConfirmation : EquitySwapMasterConfirmation2018
    
    Returns
    -------
    interestRatePayout : InterestRatePayout
    
    """
    _post_registry = {}
    self = inspect.currentframe()
    
    
    interestRatePayout = rosetta_resolve_attr(self, "interestRatePayout")
    
    # post-conditions
    
    @rosetta_local_condition(_post_registry)
    def condition_0_InterestRatePayoutTerms(self):
        """
        Interest rate payout must inherit terms from the Master Confirmation Agreement when it exists.
        """
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "paymentDates"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "masterConfirmation"), "equityCashSettlementDates"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmation")), _then_fn0, _else_fn0)
    # Execute all registered post-conditions
    execute_local_conditions(_post_registry, 'Post-condition')
    
    return interestRatePayout

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
