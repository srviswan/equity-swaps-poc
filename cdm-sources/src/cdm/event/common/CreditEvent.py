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

__all__ = ['CreditEvent']


class CreditEvent(BaseDataClass):
    """
    Specifies the relevant data regarding a credit event.
    """
    creditEventType: cdm.event.common.CreditEventTypeEnum.CreditEventTypeEnum = Field(..., description="The type of credit event taking place.")
    """
    The type of credit event taking place.
    """
    eventDeterminationDate: datetime.date = Field(..., description="The date in which the credit event is determined by the Credit Derivatives Determinations Comitee.")
    """
    The date in which the credit event is determined by the Credit Derivatives Determinations Comitee.
    """
    auctionDate: Optional[datetime.date] = Field(None, description="The date on which the auction is scheduled to occur.")
    """
    The date on which the auction is scheduled to occur.
    """
    finalPrice: Optional[cdm.observable.asset.Price.Price] = Field(None, description="The final price resulting from the auction.")
    """
    The final price resulting from the auction.
    """
    recoveryPercent: Optional[Decimal] = Field(None, description="The percentage of the original value of the asset affected by the credit event that can be recovered.")
    """
    The percentage of the original value of the asset affected by the credit event that can be recovered.
    """
    publiclyAvailableInformation: List[cdm.legaldocumentation.common.Resource.Resource] = Field([], description="A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.")
    """
    A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
    """
    referenceInformation: cdm.product.asset.ReferenceInformation.ReferenceInformation = Field(..., description="The reference entity, part of a credit basket, impacted by the credit event.")
    """
    The reference entity, part of a credit basket, impacted by the credit event.
    """

import cdm 
import cdm.event.common.CreditEventTypeEnum
import cdm.observable.asset.Price
import cdm.legaldocumentation.common.Resource
import cdm.product.asset.ReferenceInformation
