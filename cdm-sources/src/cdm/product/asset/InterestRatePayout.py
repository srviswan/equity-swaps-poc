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

__all__ = ['InterestRatePayout']

from cdm.product.common.settlement.PayoutBase import PayoutBase

class InterestRatePayout(PayoutBase):
    """
     A class to specify all of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg). The associated globalKey denotes the ability to associate a hash value to the InterestRatePayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
    """
    rateSpecification: Optional[cdm.product.asset.RateSpecification.RateSpecification] = Field(None, description="The specification of the rate value(s) applicable to the contract using either a floating rate calculation, a single fixed rate, a fixed rate schedule, or an inflation rate calculation.")
    """
    The specification of the rate value(s) applicable to the contract using either a floating rate calculation, a single fixed rate, a fixed rate schedule, or an inflation rate calculation.
    """
    dayCountFraction: Optional[AttributeWithMeta[cdm.base.datetime.daycount.DayCountFractionEnum.DayCountFractionEnum] | cdm.base.datetime.daycount.DayCountFractionEnum.DayCountFractionEnum] = Field(None, description="The day count fraction. The cardinality has been relaxed when compared with the FpML interest rate swap for the purpose of accommodating standardized credit default swaps which DCF is not explicitly stated as part of the economic terms. The data rule InterestRatePayout_dayCountFraction requires that the DCF be stated for interest rate products.")
    """
    The day count fraction. The cardinality has been relaxed when compared with the FpML interest rate swap for the purpose of accommodating standardized credit default swaps which DCF is not explicitly stated as part of the economic terms. The data rule InterestRatePayout_dayCountFraction requires that the DCF be stated for interest rate products.
    """
    calculationPeriodDates: Optional[cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDates] = Field(None, description="The parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods.")
    """
    The parameters used to generate the calculation period dates schedule, including the specification of any initial or final stub calculation periods.
    """
    paymentDates: Optional[cdm.product.common.schedule.PaymentDates.PaymentDates] = Field(None, description="The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the reset dates).")
    """
    The payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the reset dates).
    """
    paymentDate: Optional[cdm.base.datetime.AdjustableDate.AdjustableDate] = Field(None, description="The payment date, where only one date is specified, as for the FRA product.")
    """
    The payment date, where only one date is specified, as for the FRA product.
    """
    paymentDelay: Optional[bool] = Field(None, description="Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.")
    """
    Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
    """
    resetDates: Optional[cdm.product.common.schedule.ResetDates.ResetDates] = Field(None, description="The reset dates schedule, i.e. the dates on which the new observed index value is applied for each period and the interest rate hence begins to accrue.")
    """
    The reset dates schedule, i.e. the dates on which the new observed index value is applied for each period and the interest rate hence begins to accrue.
    """
    discountingMethod: Optional[cdm.product.asset.DiscountingMethod.DiscountingMethod] = Field(None, description="The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.")
    """
    The parameters specifying any discounting conventions that may apply. This element must only be included if discounting applies.
    """
    compoundingMethod: Optional[cdm.product.asset.CompoundingMethodEnum.CompoundingMethodEnum] = Field(None, description="If one or more calculation period contributes to a single payment amount this element specifies whether compounding is applicable and, if so, what compounding method is to be used. This element must only be included when more than one calculation period contributes to a single payment amount.")
    """
    If one or more calculation period contributes to a single payment amount this element specifies whether compounding is applicable and, if so, what compounding method is to be used. This element must only be included when more than one calculation period contributes to a single payment amount.
    """
    cashflowRepresentation: Optional[cdm.product.asset.CashflowRepresentation.CashflowRepresentation] = Field(None, description="The cashflow representation of the swap stream.")
    """
    The cashflow representation of the swap stream.
    """
    stubPeriod: Optional[cdm.product.common.schedule.StubPeriod.StubPeriod] = Field(None, description="The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.")
    """
    The stub calculation period amount parameters. This element must only be included if there is an initial or final stub calculation period. Even then, it must only be included if either the stub references a different floating rate tenor to the regular calculation periods, or if the stub is calculated as a linear interpolation of two different floating rate tenors, or if a specific stub rate or stub amount has been negotiated.
    """
    bondReference: Optional[cdm.product.asset.BondReference.BondReference] = Field(None, description="Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.")
    """
    Reference to a bond underlier to represent an asset swap or Condition Precedent Bond.
    """
    fixedAmount: Optional[str] = Field(None, description="Fixed Amount Calculation")
    """
    Fixed Amount Calculation
    """
    floatingAmount: Optional[str] = Field(None, description="Floating Amount Calculation")
    """
    Floating Amount Calculation
    """
    spreadCalculationMethod: Optional[cdm.product.asset.SpreadCalculationMethodEnum.SpreadCalculationMethodEnum] = Field(None, description="Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.")
    """
    Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
    """
    
    @rosetta_condition
    def condition_0_Quantity(self):
        """
        When there is an OptionPayout the quantity can be expressed as part of the payoutQuantity, or as part of the underlier in the case of a Swaption.  For all other payouts that extend PayoutBase the payoutQuantity is a mandatory attribute.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "priceQuantity"))
    
    @rosetta_condition
    def condition_1_InterestRatePayoutChoice(self):
        """
        The paymentDates attributes is applicable to interest rate payouts with periodic payments, while the paymentDate reflects the FpML FRA implementation where one specific date is specified.
        """
        item = self
        return self.check_one_of_constraint('paymentDates', 'paymentDate', necessity=False)
    
    @rosetta_condition
    def condition_2_FutureValueNotional(self):
        """
        The BRL CDI future value notional only applies to a fixed Rate Schedule.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "futureValueNotional")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateSpecification"), "FixedRateSpecification"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_TerminationDate(self):
        """
        FpML states that the value date associated with the future value notional should match the adjusted termination date.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "futureValueNotional"), "valueDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "terminationDate"), "adjustableDate"), "adjustedDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "futureValueNotional")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_RateSpecification(self):
        """
        Zero Coupon Swaps with a Known Amount are expressed without the rate specification and the known amount expressed as a price. 
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "priceSchedule"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "rateSpecification"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_5_FpML_ird_6(self):
        """
        FpML validation rule ird-6 - If paymentDates/firstPaymentDate exists, and if calculationPeriodDates/effectiveDate exists, then paymentDates/firstPaymentDate must be after calculationPeriodDates/effectiveDate/unadjustedDate.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "firstPaymentDate"), ">", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "effectiveDate"), "adjustableDate"), "unadjustedDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "firstPaymentDate")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "effectiveDate"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_6_FpML_ird_23(self):
        """
        FpML validation rule ird-23 - If the initialStub exists, the calculationPeriodDates element referenced by the @href attribute of stubCalculationPeriodAmount/calculationPeriodDatesReference contains firstRegularPeriodStartDate.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "firstRegularPeriodStartDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "stubPeriod"), "initialStub")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_7_FpML_ird_24(self):
        """
        FpML validation rule ird-24 - The finalStub exists if and only if the calculationPeriodDates element referenced by calculationPeriodDates/@href contains a lastRegularPeriodEndDate.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "lastRegularPeriodEndDate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "stubPeriod"), "finalStub")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_8_InitialStubFinalStub(self):
        """
        Data rule to represent the FpML nested XML construct as part of StubCalculationPeriodAmount.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "stubPeriod"), "initialStub")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "stubPeriod"), "finalStub")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "stubPeriod")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_9_CashSettlementTerms(self):
        """
        Cash Settlements Terms must exist when the settlement currency is different to the notional currency of the trade.
        """
        item = self
        def _then_fn0():
            return ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementTerms"), "cashSettlementTerms"), "valuationMethod")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementTerms"), "cashSettlementTerms"), "valuationDate"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantityMultiplier"), "fxLinkedNotionalSchedule"), "fxSpotRateSource")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementTerms"), "settlementCurrency")) and (any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementTerms"), "settlementCurrency"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "unit"), "currency")) or any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "settlementTerms"), "settlementCurrency"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantityMultiplier"), "fxLinkedNotionalSchedule"), "varyingNotionalCurrency")))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_10_FpML_ird_7_1(self):
        """
        FpML validation rule ird-7 1/2 - The existence of compoundingMethod is prohibited when the calculation period and payment frequencies are the same.
        """
        item = self
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "compoundingMethod"))) or all_elements(rosetta_resolve_attr(self, "compoundingMethod"), "=", rosetta_resolve_attr(CompoundingMethodEnum, "NONE")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "period"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "period")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "periodMultiplier"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "periodMultiplier"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_11_FpML_ird_7_2(self):
        """
        FpML validation rule ird-7 2/2 - The existence of compoundingMethod is required when the calculation period and payment frequencies differ.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "compoundingMethod"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "period")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "period"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "period"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "period"))) or ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "periodMultiplier")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "periodMultiplier"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "periodMultiplier"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "calculationPeriodFrequency"), "periodMultiplier")))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_12_FpML_ird_9(self):
        """
        FpML validation rule ird-9 - If calculationPeriodAmount/calculation/compoundingMethod exists, then resetDates must exist.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "resetDates"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "compoundingMethod")) and any_elements(rosetta_resolve_attr(self, "compoundingMethod"), "<>", rosetta_resolve_attr(CompoundingMethodEnum, "NONE"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_13_FpML_ird_29(self):
        """
        FpML validation rule ird-29 - If compoundingMethod exists, then fixedRateSchedule must not exist.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateSpecification"), "FixedRateSpecification")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "compoundingMethod")) and any_elements(rosetta_resolve_attr(self, "compoundingMethod"), "<>", rosetta_resolve_attr(CompoundingMethodEnum, "NONE"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_14_CalculationPeriodDatesFirstCompoundingPeriodEndDate(self):
        """
        FpML specifies that the firstCompoundingPeriodEndDate must only be specified when the compounding method is specified and not equal to a value of None.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriodDates"), "firstCompoundingPeriodEndDate")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((not rosetta_attr_exists(rosetta_resolve_attr(self, "compoundingMethod"))) or all_elements(rosetta_resolve_attr(self, "compoundingMethod"), "=", rosetta_resolve_attr(CompoundingMethodEnum, "NONE"))), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.RateSpecification
import cdm.base.datetime.daycount.DayCountFractionEnum
import cdm.product.common.schedule.CalculationPeriodDates
import cdm.product.common.schedule.PaymentDates
import cdm.base.datetime.AdjustableDate
import cdm.product.common.schedule.ResetDates
import cdm.product.asset.DiscountingMethod
import cdm.product.asset.CompoundingMethodEnum
import cdm.product.asset.CashflowRepresentation
import cdm.product.common.schedule.StubPeriod
import cdm.product.asset.BondReference
import cdm.product.asset.SpreadCalculationMethodEnum
from cdm.product.asset.CompoundingMethodEnum import CompoundingMethodEnum
