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

__all__ = ['ReferenceBank']


class ReferenceBank(BaseDataClass):
    """
    A class to describe an institution (party) identified by means of a coding scheme and an optional name.
    """
    referenceBankId: AttributeWithMeta[str] | str = Field(..., description="An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.")
    """
    An institution (party) identifier, e.g. a bank identifier code (BIC). FpML specifies a referenceBankIdScheme.
    """
    referenceBankName: Optional[str] = Field(None, description="The name of the institution (party). A free format string. FpML does not define usage rules for the element.")
    """
    The name of the institution (party). A free format string. FpML does not define usage rules for the element.
    """

import cdm 
