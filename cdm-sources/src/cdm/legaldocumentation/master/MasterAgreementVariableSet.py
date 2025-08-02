# pylint: disable=line-too-long, invalid-name, missing-function-docstring
# pylint: disable=bad-indentation, trailing-whitespace, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import
# pylint: disable=wildcard-import, wrong-import-order, missing-class-docstring
# pylint: disable=missing-module-docstring
from __future__ import annotations
from typing import List, Optional
import datetime
import inspect
from decimal import Decimal
from pydantic import Field
from rosetta.runtime.utils import (
    BaseDataClass, rosetta_condition, rosetta_resolve_attr
)
from rosetta.runtime.utils import *

__all__ = ['MasterAgreementVariableSet']


class MasterAgreementVariableSet(BaseDataClass):
    """
    Defines a type where additional variables associated to clauses and their variants can be described.
    """
    variableSet: List[cdm.legaldocumentation.master.MasterAgreementVariableSet.MasterAgreementVariableSet] = Field([], description="For some variants a table of variables is required. To support this use case we need to be able to specify variables within variables. Including a variable set here gives us infinite nesting opportunities - realistically we are only ever expecting that a table would need to be defined for any particular clause, so we would expect two levels of nesting as a maximum i.e. variableSet->variableSet->name/value.")
    """
    For some variants a table of variables is required. To support this use case we need to be able to specify variables within variables. Including a variable set here gives us infinite nesting opportunities - realistically we are only ever expecting that a table would need to be defined for any particular clause, so we would expect two levels of nesting as a maximum i.e. variableSet->variableSet->name/value.
    """
    name: Optional[str] = Field(None, description="The name of the variable")
    """
    The name of the variable
    """
    value: Optional[str] = Field(None, description="The value for this variable")
    """
    The value for this variable
    """
    
    @rosetta_condition
    def condition_0_VariableSetExists(self):
        """
        If we have a variableSet then we must not have any name/value pairs at this level.
        """
        item = self
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "name"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "value"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "variableSet")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_VariableSetNesting(self):
        """
        We are only allowing two levels of nesting of variableSet for the time being. This is because we only need to support tables of data in the master agreement variants. This condition can be modified or deleted if we find we need more levels of nesting.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "variableSet"), "variableSet"), "variableSet")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "variableSet"), "variableSet")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_NameMustExist(self):
        """
        If we have a name then we must also have a value.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "value"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "name")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_ValueMustExist(self):
        """
        If we have a value then we must also have a name.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "name"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "value")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.master.MasterAgreementVariableSet
