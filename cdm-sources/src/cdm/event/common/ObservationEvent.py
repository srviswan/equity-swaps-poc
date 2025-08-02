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

__all__ = ['ObservationEvent']


class ObservationEvent(BaseDataClass):
    """
    Specifies the necessary information to create any observation event.
    """
    creditEvent: Optional[cdm.event.common.CreditEvent.CreditEvent] = Field(None, description="Specifies the necessary information to create a credit event.")
    """
    Specifies the necessary information to create a credit event.
    """
    corporateAction: Optional[cdm.event.common.CorporateAction.CorporateAction] = Field(None, description="Specifies the necessary information to create a corporate action.")
    """
    Specifies the necessary information to create a corporate action.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('creditEvent', 'corporateAction', necessity=True)

import cdm 
import cdm.event.common.CreditEvent
import cdm.event.common.CorporateAction
