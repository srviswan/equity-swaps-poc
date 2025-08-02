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

__all__ = ['ObservationInstruction']


class ObservationInstruction(BaseDataClass):
    """
    Specifies inputs needed to process an observation.
    """
    observationEvent: cdm.event.common.ObservationEvent.ObservationEvent = Field(..., description="Contains all information related to an observation.")
    """
    Contains all information related to an observation.
    """

import cdm 
import cdm.event.common.ObservationEvent
