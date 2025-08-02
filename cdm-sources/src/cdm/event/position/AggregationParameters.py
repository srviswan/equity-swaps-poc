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

__all__ = ['AggregationParameters']


class AggregationParameters(BaseDataClass):
    """
     Parameters to be used to filter events that are relevant to a given portfolio in order to calculate the state of this portfolio. The attributes correspond to all the possible aggregation criteria that can be used and these criteria can be combined. All the attributes are optional.
    """
    dateTime: datetime.datetime = Field(..., description="To aggregate as of a particular date")
    """
    To aggregate as of a particular date
    """
    totalPosition: Optional[bool] = Field(None, description="Specifies whether to calculate total position to given date, or only daily position for the given date.")
    """
    Specifies whether to calculate total position to given date, or only daily position for the given date.
    """
    positionStatus: Optional[cdm.event.position.PositionStatusEnum.PositionStatusEnum] = Field(None, description="To aggregate based on position status (EXECUTED, SETTLED etc)")
    """
    To aggregate based on position status (EXECUTED, SETTLED etc)
    """
    party: List[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field([], description="To aggregate based on a selection of party(ies) / legal entity(ies).")
    """
    To aggregate based on a selection of party(ies) / legal entity(ies).
    """
    product: List[cdm.product.template.NonTransferableProduct.NonTransferableProduct] = Field([], description="To aggregate based on a selection of products.")
    """
    To aggregate based on a selection of products.
    """
    productQualifier: List[str] = Field([], description="To aggregate based on a selection of product type(s).")
    """
    To aggregate based on a selection of product type(s).
    """
    tradeReference: List[AttributeWithReference | cdm.event.common.Trade.Trade] = Field([], description="")

import cdm 
import cdm.event.position.PositionStatusEnum
import cdm.base.staticdata.party.Party
import cdm.product.template.NonTransferableProduct
import cdm.event.common.Trade
