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

__all__ = ['PaymentCalculationPeriod']


class PaymentCalculationPeriod(BaseDataClass):
    """
    A data defining:  the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This data forms:  part of the cashflow representation of a swap stream.
    """
    unadjustedPaymentDate: Optional[datetime.date] = Field(None, description="The unadjusted payment date.")
    """
    The unadjusted payment date.
    """
    adjustedPaymentDate: Optional[datetime.date] = Field(None, description="The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.")
    """
    The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
    """
    calculationPeriod: List[cdm.product.common.schedule.CalculationPeriod.CalculationPeriod] = Field([], description="The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calculation periods is still regarded as a conformant document.")
    """
    The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calculation periods is still regarded as a conformant document.
    """
    @rosetta_condition
    def cardinality_calculationPeriod(self):
        return check_cardinality(self.calculationPeriod, 1, None)
    
    fixedPaymentAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="A known fixed payment amount.")
    """
    A known fixed payment amount.
    """
    discountFactor: Optional[Decimal] = Field(None, description="A decimal value representing the discount factor used to calculate the present value of cash flow.")
    """
    A decimal value representing the discount factor used to calculate the present value of cash flow.
    """
    forecastPaymentAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="A monetary amount representing the forecast of the future value of the payment.")
    """
    A monetary amount representing the forecast of the future value of the payment.
    """
    presentValueAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="A monetary amount representing the present value of the forecast payment.")
    """
    A monetary amount representing the present value of the forecast payment.
    """
    
    @rosetta_condition
    def condition_0_CalculationPeriodNumberOfDays(self):
        """
        FpML specifies calculationPeriodNumberOfDays as a positive integer.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "calculationPeriodNumberOfDays"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "calculationPeriodNumberOfDays")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_PaymentCalculationPeriodChoice(self):
        """
        condition to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('calculationPeriod', 'fixedPaymentAmount', necessity=True)
    
    @rosetta_condition
    def condition_2_FpML_ird_34(self):
        """
        FpML validation rule ird-34 - Either unadjustedPaymentDate or adjustedPaymentDate must exist.
        """
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedPaymentDate")) or rosetta_attr_exists(rosetta_resolve_attr(self, "adjustedPaymentDate")))

import cdm 
import cdm.product.common.schedule.CalculationPeriod
import cdm.observable.asset.Money
