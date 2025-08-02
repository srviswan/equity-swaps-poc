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

__all__ = ['FxSettlementRateSource']


class FxSettlementRateSource(BaseDataClass):
    """
    The source of the Foreign Exchange settlement rate.
    """
    settlementRateOption: Optional[AttributeWithMeta[str] | str] = Field(None, description="Indicates that an officially defined rate settlement rate option will be the used for the fixing.")
    """
    Indicates that an officially defined rate settlement rate option will be the used for the fixing.
    """
    nonstandardSettlementRate: Optional[cdm.observable.asset.FxInformationSource.FxInformationSource] = Field(None, description="Indicates that a non-standard rate source will be used for the fixing.")
    """
    Indicates that a non-standard rate source will be used for the fixing.
    """
    
    @rosetta_condition
    def condition_0_FxSettlementRateSourceChoice(self):
        item = self
        return self.check_one_of_constraint('settlementRateOption', 'nonstandardSettlementRate', necessity=True)

import cdm 
import cdm.observable.asset.FxInformationSource
