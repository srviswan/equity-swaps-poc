# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.EconomicTerms import EconomicTerms

__all__ = ['Qualify_ForeignExchange_NDF']


@replaceable
def Qualify_ForeignExchange_NDF(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as Foreign Exchange Non-Deliverable Forward based on economic terms, which is defined as a Forward transaction where the notional amount of one of the currencies (the reference currency) is converted into the other currency (the settlement currency) at a spot foreign exchange rate that is observed on a valuation date prior to the settlement date, and a single net payment in the settlement currency is made on the settlement date. No payment or account transfer takes place in the reference currency.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((all_elements(Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "SettlementPayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "SettlementPayout"), "settlementTerms"), "cashSettlementTerms")))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
