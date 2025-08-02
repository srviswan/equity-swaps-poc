# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.collateral.CheckEligibilityResult import CheckEligibilityResult
from cdm.product.collateral.EligibleCollateralSpecification import EligibleCollateralSpecification
from cdm.product.template.TransferableProduct import TransferableProduct

__all__ = ['CheckEligibilityForProduct']


@replaceable
def CheckEligibilityForProduct(specifications: list[EligibleCollateralSpecification], product: TransferableProduct | None) -> CheckEligibilityResult:
    """
    
    Parameters 
    ----------
    specifications : EligibleCollateralSpecification
    Specifications that determine which collateral meets the eligibility and can be used/posted for delivery. For ICMA usecase - this is the basket(s). For ISDA usecase these are the Elegibility Schedule Lists.
    
    product : TransferableProduct
    
    Returns
    -------
    eligibilityResult : CheckEligibilityResult
    
    """
    self = inspect.currentframe()
    
    
    eligibilityResult = rosetta_resolve_attr(self, "eligibilityResult")
    
    
    return eligibilityResult

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
