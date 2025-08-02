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

__all__ = ['ResetDates']


class ResetDates(BaseDataClass):
    """
    A data defining:  the parameters used to generate the reset dates schedule and associated fixing dates. The reset dates are the dates on which the new index value (which is observed on the fixing date) is applied for each period and on which the interest rate hence begins to accrue.
    """
    calculationPeriodDatesReference: Optional[AttributeWithReference | cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDates] = Field(None, description="A pointer style reference to the associated calculation period dates component defined elsewhere in the document.")
    """
    A pointer style reference to the associated calculation period dates component defined elsewhere in the document.
    """
    resetRelativeTo: Optional[cdm.product.common.schedule.ResetRelativeToEnum.ResetRelativeToEnum] = Field(None, description="Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.")
    """
    Specifies whether the reset dates are determined with respect to each adjusted calculation period start date or adjusted calculation period end date. If the reset frequency is specified as daily this element must not be included.
    """
    initialFixingDate: Optional[cdm.product.common.schedule.InitialFixingDate.InitialFixingDate] = Field(None, description="The initial fixing date.")
    """
    The initial fixing date.
    """
    fixingDates: Optional[cdm.base.datetime.RelativeDateOffset.RelativeDateOffset] = Field(None, description="The fixing dates are the dates on which the index values are observed. The fixing dates are specified by reference to the reset date through business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction.")
    """
    The fixing dates are the dates on which the index values are observed. The fixing dates are specified by reference to the reset date through business days offset and an associated set of financial business centers. Normally these offset calculation rules will be those specified in the ISDA definition for the relevant floating rate index (ISDA's Floating Rate Option). However, non-standard offset calculation rules may apply for a trade if mutually agreed by the principal parties to the transaction.
    """
    finalFixingDate: Optional[cdm.base.datetime.AdjustableDate.AdjustableDate] = Field(None, description="This attribute is not part of the FpML ResetDate, and has been added as part of the CDM to support the credit derivatives final fixing date.")
    """
    This attribute is not part of the FpML ResetDate, and has been added as part of the CDM to support the credit derivatives final fixing date.
    """
    rateCutOffDaysOffset: Optional[cdm.base.datetime.Offset.Offset] = Field(None, description="Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.")
    """
    Specifies the number of business days before the period end date when the rate cut-off date is assumed to apply. The financial business centers associated with determining the rate cut-off date are those specified in the reset dates adjustments. The rate cut-off number of days must be a negative integer (a value of zero would imply no rate cut off applies in which case the rateCutOffDaysOffset element should not be included). The relevant rate for each reset date in the period from, and including, a rate cut-off date to, but excluding, the next applicable period end date (or, in the case of the last calculation period, the termination date) will (solely for purposes of calculating the floating amount payable on the next applicable payment date) be deemed to be the relevant rate in effect on that rate cut-off date. For example, if rate cut-off days for a daily averaging deal is -2 business days, then the refix rate applied on (period end date - 2 days) will also be applied as the reset on (period end date - 1 day), i.e. the actual number of reset dates remains the same but from the rate cut-off date until the period end date, the same refix rate is applied. Note that in the case of several calculation periods contributing to a single payment, the rate cut-off is assumed only to apply to the final calculation period contributing to that payment. The day type associated with the offset must imply a business days offset.
    """
    resetFrequency: Optional[cdm.product.common.schedule.ResetFrequency.ResetFrequency] = Field(None, description="The frequency at which the reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset is established for each calculation period and some form of rate averaging is applicable.")
    """
    The frequency at which the reset dates occur. In the case of a weekly reset frequency, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency then this implies that more than one reset is established for each calculation period and some form of rate averaging is applicable.
    """
    resetDatesAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The definition of the business day convention and financial business centers used for adjusting the reset date if it would otherwise fall on a day that is not a business day in the specified business center.")
    """
    The definition of the business day convention and financial business centers used for adjusting the reset date if it would otherwise fall on a day that is not a business day in the specified business center.
    """
    
    @rosetta_condition
    def condition_0_RateCutOffDaysOffset(self):
        """
        FpML specifies that the rate cut-off number of days must be a negative integer with a value of zero would implying that no rate cut off applies, in which case the rateCutOffDaysOffset element should not be included.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateCutOffDaysOffset"), "periodMultiplier"), "<", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "rateCutOffDaysOffset")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_WeeklyPeriod(self):
        """
        FpML specifies that the weeklyRollConvention must be specified as part of the reset frequency if and only if the reset frequency is defined as weekly. This data rule is focused on the first part of the assertion.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetFrequency"), "weeklyRollConvention"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetFrequency"), "period"), "=", rosetta_resolve_attr(PeriodExtendedEnum, "W")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_NonWeeklyPeriod(self):
        """
        FpML specifies that the weeklyRollConvention must be specified as part of the reset frequency if and only if the reset frequency is defined as weekly. This data rule is focused on the latter part of the assertion.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetFrequency"), "weeklyRollConvention")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetFrequency"), "period"), "<>", rosetta_resolve_attr(PeriodExtendedEnum, "W")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.schedule.CalculationPeriodDates
import cdm.product.common.schedule.ResetRelativeToEnum
import cdm.product.common.schedule.InitialFixingDate
import cdm.base.datetime.RelativeDateOffset
import cdm.base.datetime.AdjustableDate
import cdm.base.datetime.Offset
import cdm.product.common.schedule.ResetFrequency
import cdm.base.datetime.BusinessDayAdjustments
from cdm.base.datetime.PeriodExtendedEnum import PeriodExtendedEnum
