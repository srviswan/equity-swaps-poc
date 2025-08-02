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

__all__ = ['CounterpartyPositionBusinessEvent']


class CounterpartyPositionBusinessEvent(BaseDataClass):
    """
    A business event represents a life cycle event of a position. The combination of the state changes results in a qualifiable life cycle event.
    """
    intent: cdm.event.common.PositionEventIntentEnum.PositionEventIntentEnum = Field(..., description="The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those.")
    """
    The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those.
    """
    corporateActionIntent: Optional[cdm.event.common.CorporateActionTypeEnum.CorporateActionTypeEnum] = Field(None, description="The intent of a corporate action on the position.")
    """
    The intent of a corporate action on the position.
    """
    eventDate: Optional[datetime.date] = Field(None, description="Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution. However it can be different from the trade date, for example in the case of a partial termination.")
    """
    Specifies the date on which the event is taking place. This date is equal to the trade date in the case of a simple execution.  However it can be different from the trade date, for example in the case of a partial termination.
    """
    effectiveDate: Optional[datetime.date] = Field(None, description="The date on which the event contractually takes effect, when different from the event date.")
    """
    The date on which the event contractually takes effect, when different from the event date.
    """
    packageInformation: Optional[cdm.base.staticdata.identifier.IdentifiedList.IdentifiedList] = Field(None, description="Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.")
    """
    Specifies the package information in case the business event represents several trades executed as a package (hence this attribute is optional). The package information is only instantiated once at the business event level to preserve referential integrity, whereas individual trades make reference to it to identify that they are part of a package.
    """
    after: List[cdm.event.common.CounterpartyPositionState.CounterpartyPositionState] = Field([], description="Specifies the after position state(s) created.")
    """
    Specifies the after position state(s) created.
    """

import cdm 
import cdm.event.common.PositionEventIntentEnum
import cdm.event.common.CorporateActionTypeEnum
import cdm.base.staticdata.identifier.IdentifiedList
import cdm.event.common.CounterpartyPositionState
