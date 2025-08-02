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

__all__ = ['ObservationTerms']


class ObservationTerms(BaseDataClass):
    """
    Class containing terms that are associated with observing a price/benchmark/index across either single or multiple observations. 
    """
    observationTime: Optional[cdm.base.datetime.BusinessCenterTime.BusinessCenterTime] = Field(None, description="Defines time in respect to a business calendar location that the price/benchmark/index is observed")
    """
    Defines time in respect to a business calendar location that the price/benchmark/index is observed
    """
    observationTimeType: Optional[cdm.observable.common.TimeTypeEnum.TimeTypeEnum] = Field(None, description="The enumerated values to specify points in the day when option exercise and valuation can occur.")
    """
    The enumerated values to specify points in the day when option exercise and valuation can occur.
    """
    informationSource: Optional[cdm.observable.asset.FxSpotRateSource.FxSpotRateSource] = Field(None, description="The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.")
    """
    The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
    """
    precision: Optional[cdm.base.math.Rounding.Rounding] = Field(None, description="Defines rounding rules and precision to be used in the rounding of observations.")
    """
    Defines rounding rules and precision to be used in the rounding of observations.
    """
    calculationPeriodDates: Optional[cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDates] = Field(None, description="Defines parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.")
    """
    Defines parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods. A calculation period schedule consists of an optional initial stub calculation period, one or more regular calculation periods and an optional final stub calculation period. In the absence of any initial or final stub calculation periods, the regular part of the calculation period schedule is assumed to be between the effective date and the termination date. No implicit stubs are allowed, i.e. stubs must be explicitly specified using an appropriate combination of firstPeriodStartDate, firstRegularPeriodStartDate and lastRegularPeriodEndDate.
    """
    observationDates: cdm.product.common.schedule.ObservationDates.ObservationDates = Field(..., description="Describes date details for a set of observation dates in parametric or non-parametric form.")
    """
    Describes date details for a set of observation dates in parametric or non-parametric form.
    """
    numberOfObservationDates: Optional[int] = Field(None, description="The number of observation dates between observation start date and observation end date.")
    """
    The number of observation dates between observation start date and observation end date.
    """
    
    @rosetta_condition
    def condition_0_ObservationTime(self):
        """
        Checks that an observation time is specified either explicitly (through the observation time) or implicitly (through a observation time type different to Specific Time). If Specific Time is defined as observation time type (i.e. no implicit time value), the condition checks that an explicit observation time is provided.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "observationTime"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "observationTimeType"), "=", rosetta_resolve_attr(TimeTypeEnum, "SPECIFIC_TIME")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.BusinessCenterTime
import cdm.observable.common.TimeTypeEnum
import cdm.observable.asset.FxSpotRateSource
import cdm.base.math.Rounding
import cdm.product.common.schedule.CalculationPeriodDates
import cdm.product.common.schedule.ObservationDates
from cdm.observable.common.TimeTypeEnum import TimeTypeEnum
