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

__all__ = ['PercentageRule']


class PercentageRule(BaseDataClass):
    """
    A class defining a content model for a calculation rule defined as percentage of the notional amount.
    """
    paymentPercent: Decimal = Field(..., description="A percentage of the notional amount.")
    """
    A percentage of the notional amount.
    """
    notionalAmountReference: AttributeWithReference | cdm.observable.asset.Money.Money = Field(..., description="A reference to the notional amount.")
    """
    A reference to the notional amount.
    """

import cdm 
import cdm.observable.asset.Money
