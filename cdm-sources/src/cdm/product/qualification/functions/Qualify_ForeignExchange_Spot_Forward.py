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

__all__ = ['Qualify_ForeignExchange_Spot_Forward']


@replaceable
def Qualify_ForeignExchange_Spot_Forward(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as Foreign Exchange based on economic terms, which is defined as an agreement to buy one currency against the delivery of another currency at a rate set on the trade date for settlement on a specified date in the future.  Dependent on conventions specific to local markets the product could be considered either Spot or Forward.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((all_elements(Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "SettlementPayout"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "SettlementPayout"), "settlementTerms"), "cashSettlementTerms"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
