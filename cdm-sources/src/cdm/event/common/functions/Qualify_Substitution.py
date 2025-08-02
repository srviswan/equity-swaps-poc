# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_Substitution']


@replaceable
def Qualify_Substitution(businessEvent: BusinessEvent) -> bool:
    """
    Qualification of a collateral substitution event.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeEconomicterms = ExtractBeforeEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    openEconomicTerms = ExtractOpenEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    is_event =  (((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeEconomicterms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "payout"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "payout"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "collateral"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "collateral"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "effectiveDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
