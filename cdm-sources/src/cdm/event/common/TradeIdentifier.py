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

__all__ = ['TradeIdentifier']

from cdm.base.staticdata.identifier.Identifier import Identifier

class TradeIdentifier(Identifier):
    """
    Defines a trade identifier as a special case of the generic identifier type, that also includes the trade identifier class.
    """
    identifierType: Optional[cdm.base.staticdata.identifier.TradeIdentifierTypeEnum.TradeIdentifierTypeEnum] = Field(None, description="The enumerated classification of the identifier. Optional as a trade identifier may be party-specific, in which case it may not correspond to any established classification.")
    """
    The enumerated classification of the identifier. Optional as a trade identifier may be party-specific, in which case it may not correspond to any established classification.
    """

import cdm 
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum
