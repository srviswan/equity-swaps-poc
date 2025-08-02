# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['DividendCashSettlementAmount']


@replaceable
def DividendCashSettlementAmount(numberOfSecurities: Decimal, declaredDividend: Decimal) -> Decimal:
    """
    Based on the following legal text: means, in respect of a Dividend Period and the related Dividend Cash Settlement Date, an amount in the Settlement Currency determined by the Calculation Agent for such Dividend Period to which the Dividend Cash Settlement Amount relates, pursuant to the following formula: Dividend Cash Settlement Amount = Record Amount × Number Of Securities.
    
    Parameters 
    ----------
    numberOfSecurities : number
    
    declaredDividend : number
    
    Returns
    -------
    dividendCashSettlementAmount : number
    
    """
    self = inspect.currentframe()
    
    
    dividendCashSettlementAmount =  (rosetta_resolve_attr(self, "declaredDividend") * rosetta_resolve_attr(self, "numberOfSecurities"))
    
    
    return dividendCashSettlementAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
