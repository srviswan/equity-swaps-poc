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

__all__ = ['TaxonomyClassification']


class TaxonomyClassification(BaseDataClass):
    className: Optional[str] = Field(None, description="The name defined by the classification system for a specific attribute in the taxonomy")
    """
    The name defined by the classification system for a specific attribute in the taxonomy
    """
    value: str = Field(..., description="The value set by the taxonomy that is specific to the className attribute.")
    """
    The value set by the taxonomy that is specific to the className attribute.
    """
    description: Optional[str] = Field(None, description="A description of the class.")
    """
    A description of the class.
    """
    ordinal: Optional[int] = Field(None, description="In the case of multi-layered hierarchical classification systems such as commodity classification, the layer the value and className occupy in the classification hierarchy, where 1 represents the top-layer.")
    """
    In the case of multi-layered hierarchical classification systems such as commodity classification, the layer the value and className occupy in the classification hierarchy, where 1 represents the top-layer.
    """

import cdm 
