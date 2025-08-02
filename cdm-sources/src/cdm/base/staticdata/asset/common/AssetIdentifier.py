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

__all__ = ['AssetIdentifier']


class AssetIdentifier(BaseDataClass):
    """
    The unique identifier for an Asset, specified using an Asset Identifier Type enumerator.
    """
    identifier: AttributeWithMeta[str] | str = Field(..., description="The identifier value.")
    """
    The identifier value.
    """
    identifierType: cdm.base.staticdata.asset.common.AssetIdTypeEnum.AssetIdTypeEnum = Field(..., description="Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.")
    """
    Defines the symbology source of the Asset Identifier, eg CUSIP, ISIN, etc.
    """

import cdm 
import cdm.base.staticdata.asset.common.AssetIdTypeEnum
