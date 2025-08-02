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

__all__ = ['SettledEntityMatrix']


class SettledEntityMatrix(BaseDataClass):
    """
    A class to specify the Relevant Settled Entity Matrix.
    """
    matrixSource: AttributeWithMeta[cdm.product.asset.SettledEntityMatrixSourceEnum.SettledEntityMatrixSourceEnum] | cdm.product.asset.SettledEntityMatrixSourceEnum.SettledEntityMatrixSourceEnum = Field(..., description="Relevant settled entity matrix source.")
    """
    Relevant settled entity matrix source.
    """
    publicationDate: Optional[datetime.date] = Field(None, description="Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.")
    """
    Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
    """

import cdm 
import cdm.product.asset.SettledEntityMatrixSourceEnum
