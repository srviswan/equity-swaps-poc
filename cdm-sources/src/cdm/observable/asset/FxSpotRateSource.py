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

__all__ = ['FxSpotRateSource']


class FxSpotRateSource(BaseDataClass):
    """
    A class defining the rate source and fixing time for an FX rate.
    """
    primarySource: cdm.observable.asset.InformationSource.InformationSource = Field(..., description="The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.")
    """
    The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
    """
    secondarySource: Optional[cdm.observable.asset.InformationSource.InformationSource] = Field(None, description="An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.")
    """
    An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
    """

import cdm 
import cdm.observable.asset.InformationSource
