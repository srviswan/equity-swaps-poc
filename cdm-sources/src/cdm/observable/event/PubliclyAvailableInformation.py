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

__all__ = ['PubliclyAvailableInformation']


class PubliclyAvailableInformation(BaseDataClass):
    standardPublicSources: Optional[bool] = Field(None, description="If this element is specified and set to 'true', indicates that ISDA defined Standard Public Sources are applicable.")
    """
    If this element is specified and set to 'true', indicates that ISDA defined Standard Public Sources are applicable.
    """
    publicSource: List[str] = Field([], description="A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred. ISDA 2003 Term: Public Source.")
    """
    A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred. ISDA 2003 Term: Public Source.
    """
    specifiedNumber: Optional[int] = Field(None, description="The minimum number of the specified public information sources that must publish information that reasonably confirms that a credit event has occurred. The market convention is two. ISDA 2003 Term: Specified Number.")
    """
    The minimum number of the specified public information sources that must publish information that reasonably confirms that a credit event has occurred. The market convention is two. ISDA 2003 Term: Specified Number.
    """
    
    @rosetta_condition
    def condition_0_SourceChoice(self):
        """
         FpML validation rule cd-36 - Context: PubliclyAvailableInformation (complex type). Either standardPublicSources or at least one publicSource element must exist.
        """
        item = self
        return self.check_one_of_constraint('standardPublicSources', 'publicSource', necessity=True)
    
    @rosetta_condition
    def condition_1_PositiveSpecifiedNumber(self):
        """
         FpML specifies specifiedNumber as a positiveInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "specifiedNumber"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "specifiedNumber")), _then_fn0, _else_fn0)

import cdm 
