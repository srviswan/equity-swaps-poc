# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Price import Price

__all__ = ['EquityNotionalAmount']


@replaceable
def EquityNotionalAmount(numberOfSecurities: Decimal, price: Price) -> Decimal:
    """
    Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 74. 'Equity Notional Amount' means the Number Of Securities times the Initial Price, adjusted, if applicable, as provided in Part 1 Section 2.2, 'Equity Notional Reset'. If 'With Reset' is the Equity Notional Reset Election, then in respect of each Equity Cash Settlement Date: (i) the Equity Notional Amount applicable in respect of the first Equity Cash Settlement Date will be the amount specified as such in the definition of Equity Notional Amount; (ii) the Equity Notional Amount applicable in respect of each subsequent Equity Cash Settlement Date will be the sum of (a) the Equity Notional Amount in respect of the prior Equity Cash Settlement Date and (b) the Equity Performance, whether positive or negative, in respect of the prior Equity Cash Settlement Date; and (iii)	the Floating Notional Amount will be adjusted as provided in sub-clauses (i) and (ii) above as though it were an Equity Notional Amount.
    
    Parameters 
    ----------
    numberOfSecurities : number
    
    price : Price
    
    Returns
    -------
    equityNotionalAmount : number
    
    """
    self = inspect.currentframe()
    
    
    priceValue = rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "value")
    equityNotionalAmount =  (rosetta_resolve_attr(self, "numberOfSecurities") * rosetta_resolve_attr(self, "priceValue"))
    
    
    return equityNotionalAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
