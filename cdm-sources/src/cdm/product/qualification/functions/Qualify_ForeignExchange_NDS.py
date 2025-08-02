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

__all__ = ['Qualify_ForeignExchange_NDS']


@replaceable
def Qualify_ForeignExchange_NDS(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as Foreign Exchange NDS based on economic terms, which is defined as a contract in which one party borrows one currency from, and simultaneously lends another to, the second party. Each party uses the repayment obligation to its counterparty as collateral and the amount of repayment is fixed at the FX forward rate as of the start of the contract.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (((all_elements(Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")), "=", True) and SettlementPayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"))) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "SettlementPayout")), "=", 2)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "SettlementPayout"), "settlementTerms"), "cashSettlementTerms")))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
