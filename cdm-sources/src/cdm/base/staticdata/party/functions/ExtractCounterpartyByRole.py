# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.Counterparty import Counterparty
from cdm.base.staticdata.party.CounterpartyRoleEnum import CounterpartyRoleEnum

__all__ = ['ExtractCounterpartyByRole']


@replaceable
def ExtractCounterpartyByRole(counterparties: list[Counterparty], roleEnumToExtract: CounterpartyRoleEnum) -> Counterparty:
    """
    Extracts from a list of Counterparty data types, the Counterparty that corresponds to the role i.e. Party1 or Party2.
    
    Parameters 
    ----------
    counterparties : Counterparty
    The list of counterparties to filter.
    
    roleEnumToExtract : CounterpartyRoleEnum
    The counterparty role enum to filter by.
    
    Returns
    -------
    counterparty : Counterparty
    
    """
    self = inspect.currentframe()
    
    
    counterparty =  (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "counterparties"), lambda item: all_elements(rosetta_resolve_attr(self, "role"), "=", rosetta_resolve_attr(self, "roleEnumToExtract"))))
    
    
    return counterparty

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
