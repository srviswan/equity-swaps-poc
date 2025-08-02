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

__all__ = ['TaxonomyValue']


class TaxonomyValue(BaseDataClass):
    """
    Defines a taxonomy value as either a simple string or a more granular expression with class names and values for each class.
    """
    name: Optional[AttributeWithMeta[str] | str] = Field(None, description="Specifies the taxonomy value as a simple string, which may be associated to an external scheme.")
    """
    Specifies the taxonomy value as a simple string, which may be associated to an external scheme.
    """
    classification: List[cdm.base.staticdata.asset.common.TaxonomyClassification.TaxonomyClassification] = Field([], description="Specifies the taxonomy value as a set of class names and values for each class.")
    """
    Specifies the taxonomy value as a set of class names and values for each class.
    """
    
    @rosetta_condition
    def condition_0_ValueExists(self):
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "name")) or rosetta_attr_exists(rosetta_resolve_attr(self, "classification")))

import cdm 
import cdm.base.staticdata.asset.common.TaxonomyClassification
