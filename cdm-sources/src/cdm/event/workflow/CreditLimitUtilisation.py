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

__all__ = ['CreditLimitUtilisation']


class CreditLimitUtilisation(BaseDataClass):
    """
    Credit limit utilisation breakdown by executed trades and pending orders.
    """
    executed: Optional[cdm.event.workflow.CreditLimitUtilisationPosition.CreditLimitUtilisationPosition] = Field(None, description="Credit limit utilisation attributable to executed trades.")
    """
    Credit limit utilisation attributable to executed trades.
    """
    pending: Optional[cdm.event.workflow.CreditLimitUtilisationPosition.CreditLimitUtilisationPosition] = Field(None, description="Credit limit utilisation attributable to pending unexecuted orders.")
    """
    Credit limit utilisation attributable to pending unexecuted orders.
    """

import cdm 
import cdm.event.workflow.CreditLimitUtilisationPosition
