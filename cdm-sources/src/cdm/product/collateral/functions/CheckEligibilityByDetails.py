# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.collateral.EligibilityQuery import EligibilityQuery
from cdm.product.collateral.CheckEligibilityResult import CheckEligibilityResult
from cdm.product.collateral.functions.CheckCriteria import CheckCriteria
from cdm.product.collateral.EligibleCollateralSpecification import EligibleCollateralSpecification

__all__ = ['CheckEligibilityByDetails']


@replaceable
def CheckEligibilityByDetails(specification: EligibleCollateralSpecification, query: EligibilityQuery) -> CheckEligibilityResult:
    """
    This function when presented with a set of Asset and Issuer details to be potentially posted as collateral, will check against a set of given Eligibility Criteria or Basket (EligibleCollateralSpecification) to determine which collateral meets the eligibility and can be used/posted for delivery.
    
    Parameters 
    ----------
    specification : EligibleCollateralSpecification
    Specifications that determine which collateral meets the eligibility and can be used/posted for delivery. For ICMA usecase - this is the basket(s). For ISDA usecase these are the Eligibility Schedule Lists.
    
    query : EligibilityQuery
    The eligibility query defines the criteria to filter the specifications that will be used to find the eligibility result. For ICMA usecase - The asset infomation related to potential collateral available in your inventory you can use for the Repo trade. For ISDA - the questions related to the asset infomation you can post as collateral. For ICMA usecase - The issuer infomation related to the potential collateral available in your inventory you can use for the Repo trade. For ISDA - the questions related to the issuer infomation you can post as collateral.
    
    Returns
    -------
    eligibilityResult : CheckEligibilityResult
    
    """
    self = inspect.currentframe()
    
    
    filteredCriteria = rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(self, "specification"), "criteria"), lambda item: rosetta_resolve_attr(rosetta_resolve_attr(self, "treatment"), "isIncluded"))
    checkedCriteria = rosetta_filter(rosetta_resolve_attr(self, "filteredCriteria"), lambda item: CheckCriteria(rosetta_resolve_attr(item, "collateralCriteria"), rosetta_resolve_attr(self, "query")))
    eligibilityResult = _get_rosetta_object('CheckEligibilityResult', 'isEligible', all_elements(rosetta_count(rosetta_resolve_attr(self, "checkedCriteria")), ">", 0))
    eligibilityResult = set_rosetta_attr(rosetta_resolve_attr(self, 'eligibilityResult'), 'eligibilityQuery', rosetta_resolve_attr(self, "query"))
    eligibilityResult = set_rosetta_attr(rosetta_resolve_attr(self, 'eligibilityResult'), 'specification', rosetta_resolve_attr(self, "specification"))
    eligibilityResult.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, eligibilityResult), 'matchingEligibleCriteria'), rosetta_resolve_attr(self, "checkedCriteria"))
    
    
    return eligibilityResult

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
