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

__all__ = ['ObservationParameters']


class ObservationParameters(BaseDataClass):
    """
    Parameters on daily observed computed rates, specifically daily caps and floors. This type is used to represent modular computed rates in interestRatePayouts.
    """
    observationCapRate: Optional[Decimal] = Field(None, description="A daily observation cap rate.")
    """
    A daily observation cap rate.
    """
    observationFloorRate: Optional[Decimal] = Field(None, description="A daily observation floor rate.")
    """
    A daily observation floor rate.
    """

import cdm 
