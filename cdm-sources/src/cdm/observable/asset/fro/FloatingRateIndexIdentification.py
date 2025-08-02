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

__all__ = ['FloatingRateIndexIdentification']


class FloatingRateIndexIdentification(BaseDataClass):
    floatingRateIndex: Optional[AttributeWithMeta[cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] | cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] = Field(None, description="The reference index that is used to specify the floating interest rate. The FpML standard maintains the list of such indices, which are positioned as enumeration values as part of the CDM.")
    """
    The reference index that is used to specify the floating interest rate. The FpML standard maintains the list of such indices, which are positioned as enumeration values as part of the CDM.
    """
    currency: Optional[cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum.ISOCurrencyCodeEnum] = Field(None, description="FRO currency - 3 character ISO currrency code")
    """
    FRO currency - 3 character ISO currrency code
    """
    froType: Optional[str] = Field(None, description="FRO type (e.g. OIS)")
    """
    FRO type (e.g. OIS)
    """

import cdm 
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum
