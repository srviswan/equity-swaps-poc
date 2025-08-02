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

__all__ = ['PriceSourceDisruption']


class PriceSourceDisruption(BaseDataClass):
    """
    A data defining:  the parameters used to get a price quote to replace the settlement rate option that is disrupted.
    """
    fallbackReferencePrice: cdm.observable.asset.FallbackReferencePrice.FallbackReferencePrice = Field(..., description="The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.")
    """
    The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
    """

import cdm 
import cdm.observable.asset.FallbackReferencePrice
