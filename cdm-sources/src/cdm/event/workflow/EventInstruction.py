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

__all__ = ['EventInstruction']


class EventInstruction(BaseDataClass):
    """
    Specifies instructions to create a BusinessEvent.
    """
    intent: Optional[cdm.event.common.EventIntentEnum.EventIntentEnum] = Field(None, description="The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.")
    """
    The intent attribute is meant to be specified when the event qualification cannot be programmatically inferred from the event features. As a result it is only associated with those primitives that can give way to such ambiguity, the quantityChange being one of those. An example of such is a reduction in the trade notional, which could be interpreted as either a trade correction (unless a maximum period of time post-event is specified as part of the qualification), a partial termination or a portfolio rebalancing in the case of an equity swap. On the other hand, an event such as the exercise is not expected to have an associated intent as there should not be ambiguity.
    """
    corporateActionIntent: Optional[cdm.event.common.CorporateActionTypeEnum.CorporateActionTypeEnum] = Field(None, description="")
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
    instruction: List[cdm.event.common.Instruction.Instruction] = Field([], description="Specifies the instructions to create the Business Event.")
    """
    Specifies the instructions to create the Business Event.
    """
    
    @rosetta_condition
    def condition_0_CorporateAction(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "CORPORATE_ACTION_ADJUSTMENT"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "corporateActionIntent")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.EventIntentEnum
import cdm.event.common.CorporateActionTypeEnum
import cdm.base.staticdata.identifier.IdentifiedList
import cdm.event.common.Instruction
from cdm.event.common.EventIntentEnum import EventIntentEnum
