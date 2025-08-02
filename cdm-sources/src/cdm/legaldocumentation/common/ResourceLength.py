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

__all__ = ['ResourceLength']


class ResourceLength(BaseDataClass):
    """
    A class to indicate the length of the resource.
    """
    lengthUnit: cdm.legaldocumentation.common.LengthUnitEnum.LengthUnitEnum = Field(..., description="The length unit of the resource. For example, pages (pdf, text documents) or time (audio, video files).")
    """
    The length unit of the resource. For example, pages (pdf, text documents) or time (audio, video files).
    """
    lengthValue: Decimal = Field(..., description="The length value of the resource.")
    """
    The length value of the resource.
    """

import cdm 
import cdm.legaldocumentation.common.LengthUnitEnum
