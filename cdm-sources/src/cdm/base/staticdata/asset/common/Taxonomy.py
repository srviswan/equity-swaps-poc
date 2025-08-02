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

__all__ = ['Taxonomy']


class Taxonomy(BaseDataClass):
    """
    Defines the taxonomy of an object by combining a taxonomy source (i.e. the rules to classify the object) and a value (i.e. the output of those rules on the object).
    """
    source: Optional[cdm.base.staticdata.asset.common.TaxonomySourceEnum.TaxonomySourceEnum] = Field(None, description="The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.")
    """
    The source of the taxonomy that defines the rules for classifying the object. The taxonomy source is taken from a enumerated list of taxonomy names. Optional as the taxonomy source may not be provided.
    """
    value: Optional[cdm.base.staticdata.asset.common.TaxonomyValue.TaxonomyValue] = Field(None, description="The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.")
    """
    The value according to that taxonomy. Optional as it may not be possible to classify the object in that taxonomy.
    """
    
    @rosetta_condition
    def condition_0_DifferentOrdinals(self):
        """
        Prevents several identical ordinals from being specified in the same commodity classification, since classification values for each classification layer are mutually exclusive (i.e.: only a value can exist for each layer).
        """
        item = self
        def _then_fn0():
            return DifferentOrdinalsCondition(item)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "value"), "classification"), "ordinal")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.TaxonomySourceEnum
import cdm.base.staticdata.asset.common.TaxonomyValue
from cdm.base.staticdata.asset.common.functions.DifferentOrdinalsCondition import DifferentOrdinalsCondition
