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

__all__ = ['SettlementRateOption']


class SettlementRateOption(BaseDataClass):
    """
    Defines the settlement rate option to use for fixing in case of cash settlement. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
    """
    settlementRateOption: AttributeWithMeta[cdm.observable.asset.SettlementRateOptionEnum.SettlementRateOptionEnum] | cdm.observable.asset.SettlementRateOptionEnum.SettlementRateOptionEnum = Field(..., description="The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.")
    """
    The rate source for the conversion to the settlement currency. This source is specified through a scheme that reflects the terms of the Annex A to the 1998 FX and Currency Option Definitions.
    """
    priceSourceDisruption: Optional[cdm.observable.asset.PriceSourceDisruption.PriceSourceDisruption] = Field(None, description="An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.")
    """
    An attribute defining the parameters to get a new quote when a settlement rate option is disrupted.
    """

import cdm 
import cdm.observable.asset.SettlementRateOptionEnum
import cdm.observable.asset.PriceSourceDisruption
