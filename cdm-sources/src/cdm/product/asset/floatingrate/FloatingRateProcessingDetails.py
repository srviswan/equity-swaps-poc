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

__all__ = ['FloatingRateProcessingDetails']


class FloatingRateProcessingDetails(BaseDataClass):
    """
    Type for reporting the details of the rate treatment.  This could potentially be replaced by the existing FloatingRateDefinition type , but this is slightly more detailed.
    """
    rawRate: Decimal = Field(..., description="The raw or untreated rate, prior to any of the rate treatments.")
    """
    The raw or untreated rate, prior to any of the rate treatments.
    """
    processingParameters: Optional[cdm.product.asset.floatingrate.FloatingRateProcessingParameters.FloatingRateProcessingParameters] = Field(None, description="")
    processedRate: Decimal = Field(..., description="The value of the rate after processing.")
    """
    The value of the rate after processing.
    """
    spreadExclusiveRate: Decimal = Field(..., description="The value of the processed rate without the spread applied, for subsequent compounding, etc.")
    """
    The value of the processed rate without the spread applied, for subsequent compounding, etc.
    """

import cdm 
import cdm.product.asset.floatingrate.FloatingRateProcessingParameters
