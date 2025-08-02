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

__all__ = ['ReferenceSwapCurve']


class ReferenceSwapCurve(BaseDataClass):
    """
    A complex type used to specify the option and convertible bond option strike when expressed in reference to a swap curve.
    """
    swapUnwindValue: cdm.observable.asset.SwapCurveValuation.SwapCurveValuation = Field(..., description="")
    makeWholeAmount: Optional[cdm.observable.asset.MakeWholeAmount.MakeWholeAmount] = Field(None, description="Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)")
    """
    Amount to be paid by the buyer of the option if the option is exercised prior to the Early Call Date. (The market practice in the convertible bond option space being that the buyer should be penalised if he/she exercises the option early on.)
    """

import cdm 
import cdm.observable.asset.SwapCurveValuation
import cdm.observable.asset.MakeWholeAmount
