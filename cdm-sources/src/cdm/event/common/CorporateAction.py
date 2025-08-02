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

__all__ = ['CorporateAction']


class CorporateAction(BaseDataClass):
    """
    Specifies the relevant data regarding a corporate action.
    """
    corporateActionType: cdm.event.common.CorporateActionTypeEnum.CorporateActionTypeEnum = Field(..., description="The type of corporate action taking place.")
    """
    The type of corporate action taking place.
    """
    exDate: datetime.date = Field(..., description="The date on which the corporate action is known to have taken place.")
    """
    The date on which the corporate action is known to have taken place.
    """
    payDate: datetime.date = Field(..., description="The date on which resulting from the corporate action are delivered.")
    """
    The date on which resulting from the corporate action are delivered.
    """
    underlier: cdm.product.template.Underlier.Underlier = Field(..., description="The underlier impacted by the corporate action.")
    """
    The underlier impacted by the corporate action.
    """

import cdm 
import cdm.event.common.CorporateActionTypeEnum
import cdm.product.template.Underlier
