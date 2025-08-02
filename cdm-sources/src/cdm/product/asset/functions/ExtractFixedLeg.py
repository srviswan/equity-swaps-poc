# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['ExtractFixedLeg']


@replaceable
def ExtractFixedLeg(interestRatePayouts: list[InterestRatePayout] | None) -> InterestRatePayout:
    """
    Extract interest rate payout containing fix rate specification.
    
    Parameters 
    ----------
    interestRatePayouts : InterestRatePayout
    
    Returns
    -------
    fixedRatePayout : InterestRatePayout
    
    """
    self = inspect.currentframe()
    
    
    fixedRatePayout =  (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "interestRatePayouts"), lambda item: rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateSpecification"), "FixedRateSpecification"))))
    
    
    return fixedRatePayout

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
