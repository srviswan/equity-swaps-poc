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

__all__ = ['ValuationTerms']


class ValuationTerms(BaseDataClass):
    futuresPriceValuation: Optional[bool] = Field(None, description="The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.")
    """
    The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions.
    """
    optionsPriceValuation: Optional[bool] = Field(None, description="The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions")
    """
    The official settlement price as announced by the related exchange is applicable, in accordance with the ISDA 2002 definitions
    """
    numberOfValuationDates: Optional[int] = Field(None, description="The number of valuation dates between valuation start date and valuation end date.")
    """
    The number of valuation dates between valuation start date and valuation end date.
    """
    dividendValuationDates: Optional[cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDates] = Field(None, description="Specifies the dividend valuation dates of the swap.")
    """
    Specifies the dividend valuation dates of the swap.
    """
    fPVFinalPriceElectionFallback: Optional[cdm.product.asset.FPVFinalPriceElectionFallbackEnum.FPVFinalPriceElectionFallbackEnum] = Field(None, description="Specifies the fallback provisions for Hedging Party in the determination of the Final Price.")
    """
    Specifies the fallback provisions for Hedging Party in the determination of the Final Price.
    """
    multipleExchangeIndexAnnexFallback: Optional[bool] = Field(None, description="For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.")
    """
    For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
    """
    componentSecurityIndexAnnexFallback: Optional[bool] = Field(None, description="For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.")
    """
    For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
    """
    
    @rosetta_condition
    def condition_0_PositiveNumberOfValuationDates(self):
        """
        The number of valuation dates must be positive.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "numberOfValuationDates"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "numberOfValuationDates")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates
import cdm.product.asset.FPVFinalPriceElectionFallbackEnum
