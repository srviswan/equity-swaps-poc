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

__all__ = ['ProductIdentifier']


class ProductIdentifier(BaseDataClass):
    """
    Comprises an identifier and a source. The associated metadata key denotes the ability to associate a hash value to the ProductIdentifier instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
    """
    identifier: AttributeWithMeta[str] | str = Field(..., description="Provides an identifier associated with a specific product. The identifier is unique within the public source specified in the source attribute.")
    """
    Provides an identifier associated with a specific product.  The identifier is unique within the public source specified in the source attribute.
    """
    source: cdm.base.staticdata.asset.common.ProductIdTypeEnum.ProductIdTypeEnum = Field(..., description="Defines the source of the identifier.")
    """
    Defines the source of the identifier.
    """

import cdm 
import cdm.base.staticdata.asset.common.ProductIdTypeEnum
