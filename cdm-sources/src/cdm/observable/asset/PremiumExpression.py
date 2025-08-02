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

__all__ = ['PremiumExpression']


class PremiumExpression(BaseDataClass):
    """
    This class corresponds to the FpML Premium.model group for representing the option premium when expressed in a way other than an amount.
    """
    premiumType: Optional[cdm.observable.asset.PremiumTypeEnum.PremiumTypeEnum] = Field(None, description="Forward start premium type")
    """
    Forward start premium type
    """
    pricePerOption: Optional[cdm.observable.asset.Money.Money] = Field(None, description="The amount of premium to be paid expressed as a function of the number of options.")
    """
    The amount of premium to be paid expressed as a function of the number of options.
    """
    percentageOfNotional: Optional[Decimal] = Field(None, description="The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.")
    """
    The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
    """

import cdm 
import cdm.observable.asset.PremiumTypeEnum
import cdm.observable.asset.Money
