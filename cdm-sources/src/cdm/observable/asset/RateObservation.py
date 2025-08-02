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

__all__ = ['RateObservation']


class RateObservation(BaseDataClass):
    """
    A class defining parameters associated with an individual observation or fixing. This class forms part of the cashflow representation of a stream.
    """
    resetDate: Optional[datetime.date] = Field(None, description="The reset date.")
    """
    The reset date.
    """
    adjustedFixingDate: Optional[datetime.date] = Field(None, description="The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.")
    """
    The adjusted fixing date, i.e. the actual date the rate is observed. The date should already be adjusted for any applicable business day convention.
    """
    observedRate: Optional[Decimal] = Field(None, description="The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.")
    """
    The actual observed rate before any required rate treatment is applied, e.g. before converting a rate quoted on a discount basis to an equivalent yield. An observed rate of 5% would be represented as 0.05.
    """
    treatedRate: Optional[Decimal] = Field(None, description="The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.")
    """
    The observed rate after any required rate treatment is applied. A treated rate of 5% would be represented as 0.05.
    """
    observationWeight: Optional[int] = Field(None, description="The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.")
    """
    The number of days weighting to be associated with the rate observation, i.e. the number of days such rate is in effect. This is applicable in the case of a weighted average method of calculation where more than one reset date is established for a single calculation period.
    """
    rateReference: Optional[AttributeWithReference | cdm.observable.asset.RateObservation.RateObservation] = Field(None, description="A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.")
    """
    A pointer style reference to a floating rate component defined as part of a stub calculation period amount component. It is only required when it is necessary to distinguish two rate observations for the same fixing date which could occur when linear interpolation of two different rates occurs for a stub calculation period.
    """
    forecastRate: Optional[Decimal] = Field(None, description="The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.")
    """
    The value representing the forecast rate used to calculate the forecast future value of the accrual period.A value of 1% should be represented as 0.01.
    """
    treatedForecastRate: Optional[Decimal] = Field(None, description="The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.")
    """
    The value representing the forecast rate after applying rate treatment rules. A value of 1% should be represented as 0.01.
    """
    
    @rosetta_condition
    def condition_0_PositiveObservationWeight(self):
        """
        FpML specifies observationWeight as a positive integer.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "observationWeight"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "observationWeight")), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.RateObservation
