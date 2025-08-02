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

__all__ = ['FxInformationSource']

from cdm.observable.asset.InformationSource import InformationSource

class FxInformationSource(InformationSource):
    """
    Information source specific to Foreign Exchange products.
    """
    fixingTime: Optional[cdm.base.datetime.BusinessCenterTime.BusinessCenterTime] = Field(None, description="The time that the fixing will be taken along with a business center to define the time zone.")
    """
    The time that the fixing will be taken along with a business center to define the time zone.
    """

import cdm 
import cdm.base.datetime.BusinessCenterTime
