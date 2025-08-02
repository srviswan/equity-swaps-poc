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
from cdm.product.collateral.AgencyRatingCriteria import AgencyRatingCriteria

__all__ = ['CheckAgencyRating']


@replaceable
def CheckAgencyRating(agencyRatings: AgencyRatingCriteria | None, query: EligibilityQuery) -> bool:
    """
    
    Parameters 
    ----------
    agencyRatings : AgencyRatingCriteria
    
    query : EligibilityQuery
    
    Returns
    -------
    isEqual : boolean
    
    """
    self = inspect.currentframe()
    
    
    isEqual =  ((not rosetta_attr_exists(rosetta_resolve_attr(self, "agencyRatings"))) or (lambda item: rosetta_attr_exists(item))((lambda item: rosetta_filter(item, lambda item: ((not rosetta_attr_exists(rosetta_resolve_attr(self, "referenceAgency"))) or all_elements(rosetta_resolve_attr(self, "referenceAgency"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "agencyRating"), "referenceAgency")))))((lambda item: rosetta_filter(item, lambda item: contains(rosetta_resolve_attr(rosetta_resolve_attr(self, "creditNotation"), "notation"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "query"), "agencyRating"), "creditNotation"), "notation"))))(rosetta_resolve_attr(self, "agencyRatings")))))
    
    
    return isEqual

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
