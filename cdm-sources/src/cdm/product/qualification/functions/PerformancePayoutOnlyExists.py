# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.Payout import Payout

__all__ = ['PerformancePayoutOnlyExists']


@replaceable
def PerformancePayoutOnlyExists(payouts: list[Payout] | None) -> bool:
    """
    At least one PerformancePayout exists and no other payouts exist.
    
    Parameters 
    ----------
    payouts : Payout
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  (lambda item: (item default False))((lambda item: all_elements(item, "=", True))(map(lambda item: rosetta_attr_exists(rosetta_resolve_attr(self, "PerformancePayout")), rosetta_resolve_attr(self, "payouts"))))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
