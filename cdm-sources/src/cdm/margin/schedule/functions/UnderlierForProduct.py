# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.NonTransferableProduct import NonTransferableProduct
from cdm.product.template.Underlier import Underlier

__all__ = ['UnderlierForProduct']


@replaceable
def UnderlierForProduct(product: NonTransferableProduct) -> Underlier:
    """
    Extracts the underlier product.
    
    Parameters 
    ----------
    product : NonTransferableProduct
    
    Returns
    -------
    underlierProduct : Underlier
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "SettlementPayout")), "underlier")
    
    def _else_fn1():
        return True
    
    def _then_fn0():
        return rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "OptionPayout")), "underlier")
    
    def _else_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "SettlementPayout")), _then_fn1, _else_fn1)
    
    underlierProduct =  if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "product"), "economicTerms"), "payout"), "OptionPayout")), _then_fn0, _else_fn0)
    
    
    return underlierProduct

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
