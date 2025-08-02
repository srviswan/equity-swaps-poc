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

__all__ = ['IndexBase']

from cdm.base.staticdata.asset.common.AssetBase import AssetBase

class IndexBase(AssetBase):
    """
    Identifies an index by referencing an identifier.
    """
    name: Optional[AttributeWithMeta[str] | str] = Field(None, description="A description of the Index.")
    """
    A description of the Index.
    """
    provider: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="The organisation that creates or maintains the Index.")
    """
    The organisation that creates or maintains the Index.
    """
    assetClass: Optional[cdm.base.staticdata.asset.common.AssetClassEnum.AssetClassEnum] = Field(None, description="The Asset Class of the Index.")
    """
    The Asset Class of the Index.
    """

import cdm 
import cdm.base.staticdata.party.LegalEntity
import cdm.base.staticdata.asset.common.AssetClassEnum
