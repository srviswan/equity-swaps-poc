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

__all__ = ['TransactionAdditionalTerms']


class TransactionAdditionalTerms(BaseDataClass):
    """
    Additional specification for the extraordinary events that may affect a trade and the related contractual rights and obligation of the parties when this happens. Such terms are typically required to extend the economics terms, for the purpose of producing the final legal contractual form of the Transaction.
    """
    equityAdditionalTerms: Optional[cdm.legaldocumentation.master.EquityAdditionalTerms.EquityAdditionalTerms] = Field(None, description="")
    foreignExchangeAdditionalTerms: Optional[cdm.legaldocumentation.master.FxAdditionalTerms.FxAdditionalTerms] = Field(None, description="")
    commoditiesAdditionalTerms: Optional[str] = Field(None, description="")
    creditAdditionalTerms: Optional[str] = Field(None, description="")
    interestRateAdditionalTerms: Optional[str] = Field(None, description="")
    digitalAssetAdditionalTerms: Optional[str] = Field(None, description="")

import cdm 
import cdm.legaldocumentation.master.EquityAdditionalTerms
import cdm.legaldocumentation.master.FxAdditionalTerms
