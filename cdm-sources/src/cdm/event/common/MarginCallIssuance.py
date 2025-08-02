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

__all__ = ['MarginCallIssuance']

from cdm.event.common.MarginCallBase import MarginCallBase

class MarginCallIssuance(MarginCallBase):
    """
    Represents common attributes required for a Margin Call Issuance under a legal agreement such as a credit support document or equivalent.
    """
    callAmountInBaseCurrency: cdm.observable.asset.Money.Money = Field(..., description="Specifies the amount of margin being called for which accounts for margin calculation inclusive of exposure, independent amount,threshold,collateral balance, MTA, rounding increments (in base currency detailed in supporting collateral agreement).")
    """
    Specifies the amount of margin being called for which accounts for margin calculation inclusive of exposure, independent amount,threshold,collateral balance, MTA, rounding increments (in base currency detailed in supporting collateral agreement).
    """
    recallNonCashCollateralDescription: List[cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteria] = Field([], description="Specifies the details to describe or identify non-cash collateral eligible assets for recall purposes.")
    """
    Specifies the details to describe or identify non-cash collateral eligible assets for recall purposes.
    """

import cdm 
import cdm.observable.asset.Money
import cdm.product.collateral.EligibleCollateralCriteria
