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

__all__ = ['CustomisedWorkflow']


class CustomisedWorkflow(BaseDataClass):
    """
    In its initial iteration, this class is meant to support the DTCC TIW workflow information.
    """
    itemName: str = Field(..., description="In this initial iteration, this corresponds to the DTCC TIW element name.")
    """
    In this initial iteration, this corresponds to the DTCC TIW element name.
    """
    itemValue: str = Field(..., description="In this initial iteration, this corresponds to the DTCC value.")
    """
    In this initial iteration, this corresponds to the DTCC value.
    """

import cdm 
