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

__all__ = ['ContractualTermsSupplement']


class ContractualTermsSupplement(BaseDataClass):
    """
    A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
    """
    contractualTermsSupplementType: AttributeWithMeta[cdm.legaldocumentation.common.ContractualSupplementTypeEnum.ContractualSupplementTypeEnum] | cdm.legaldocumentation.common.ContractualSupplementTypeEnum.ContractualSupplementTypeEnum = Field(..., description="Identifies the form of applicable contractual supplement.")
    """
    Identifies the form of applicable contractual supplement.
    """
    publicationDate: Optional[datetime.date] = Field(None, description="Specifies the publication date of the applicable version of the contractual supplement.")
    """
    Specifies the publication date of the applicable version of the contractual supplement.
    """

import cdm 
import cdm.legaldocumentation.common.ContractualSupplementTypeEnum
