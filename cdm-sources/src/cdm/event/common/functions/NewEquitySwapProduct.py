# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.NewFloatingPayout import NewFloatingPayout
from cdm.product.template.NonTransferableProduct import NonTransferableProduct
from cdm.product.template.Payout import Payout
from cdm.event.common.functions.NewSingleNameEquityPerformancePayout import NewSingleNameEquityPerformancePayout
from cdm.base.staticdata.asset.common.Security import Security
from cdm.legaldocumentation.master.EquitySwapMasterConfirmation2018 import EquitySwapMasterConfirmation2018
from cdm.base.staticdata.asset.common.InstrumentTypeEnum import InstrumentTypeEnum

__all__ = ['NewEquitySwapProduct']


@replaceable
def NewEquitySwapProduct(security: Security, masterConfirmation: EquitySwapMasterConfirmation2018 | None) -> NonTransferableProduct:
    """
    Function specification to create an Equity Swap according to the 2018 ISDA CDM Equity Confirmation Template, based on a minimum set of inputs which can (optionally) include a Master Confirmation Agreement. The inputs represent the minimum set of inputs required to create an Equity Swap, either based on an existing Master Confirmation Agreement or as a stand-alone Equity Swap
    
    Parameters 
    ----------
    security : Security
    The underlying Equity asset for the swap.
    
    masterConfirmation : EquitySwapMasterConfirmation2018
    An (optional) pointer to the Master Confirmation Agreement, if any, that holds further inputs to the Equity Swap
    
    Returns
    -------
    product : NonTransferableProduct
    
    """
    _pre_registry = {}
    _post_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_EquitySecurityType(self):
        """
        Security must be equity (single name).
        """
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "security"), "instrumentType"), "=", rosetta_resolve_attr(InstrumentTypeEnum, "EQUITY"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return Payout(InterestRatePayout=NewFloatingPayout(rosetta_resolve_attr(self, "masterConfirmation")))
    
    def _else_fn0():
        return True
    
    product = Payout(PerformancePayout=NewSingleNameEquityPerformancePayout(rosetta_resolve_attr(self, "security"), rosetta_resolve_attr(self, "masterConfirmation")))
    product.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, product), 'economicTerms'), 'payout'), if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmation")), _then_fn1, _else_fn1))
    
    # post-conditions
    
    @rosetta_local_condition(_post_registry)
    def condition_0_PayoutType(self):
        """
        Other payout types must be absent.
        """
        def _then_fn0():
            return (lambda item: all_elements(item, "=", True))(map(lambda item: rosetta_attr_exists(rosetta_resolve_attr(self, "PerformancePayout")), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "masterConfirmation"))), _then_fn0, _else_fn0)
    # Execute all registered post-conditions
    execute_local_conditions(_post_registry, 'Post-condition')
    
    return product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
