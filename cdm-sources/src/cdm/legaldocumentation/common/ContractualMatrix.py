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

__all__ = ['ContractualMatrix']


class ContractualMatrix(BaseDataClass):
    matrixType: AttributeWithMeta[cdm.legaldocumentation.common.MatrixTypeEnum.MatrixTypeEnum] | cdm.legaldocumentation.common.MatrixTypeEnum.MatrixTypeEnum = Field(..., description="Identifies the form of applicable matrix.")
    """
    Identifies the form of applicable matrix.
    """
    matrixTerm: Optional[AttributeWithMeta[cdm.legaldocumentation.common.MatrixTermEnum.MatrixTermEnum] | cdm.legaldocumentation.common.MatrixTermEnum.MatrixTermEnum] = Field(None, description="Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.")
    """
    Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.
    """

import cdm 
import cdm.legaldocumentation.common.MatrixTypeEnum
import cdm.legaldocumentation.common.MatrixTermEnum
