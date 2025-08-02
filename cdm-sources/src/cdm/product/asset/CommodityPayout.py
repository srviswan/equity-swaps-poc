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

__all__ = ['CommodityPayout']

from cdm.product.common.settlement.PayoutBase import PayoutBase

class CommodityPayout(PayoutBase):
    """
    Payout based on the averaged price of a referenced underlier. (e.g. Commodities). Can represent both average (average of many) & bullet (average of 1) pricing
    """
    averagingFeature: Optional[cdm.product.template.AveragingCalculation.AveragingCalculation] = Field(None, description="Indicates if the averaging calculation, when applicable, is weighted or unweighted.")
    """
    Indicates if the averaging calculation, when applicable, is weighted or unweighted.
    """
    commodityPriceReturnTerms: Optional[cdm.product.common.settlement.CommodityPriceReturnTerms.CommodityPriceReturnTerms] = Field(None, description="Defines parameters in which the commodity price is assessed.")
    """
    Defines parameters in which the commodity price is assessed.
    """
    pricingDates: cdm.product.common.settlement.PricingDates.PricingDates = Field(..., description="Specifies specific dates or parametric rules for the dates on which the price will be determined.")
    """
    Specifies specific dates or parametric rules for the dates on which the price will be determined.
    """
    schedule: Optional[cdm.product.template.CalculationSchedule.CalculationSchedule] = Field(None, description="Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.")
    """
    Allows the full representation of a payout by defining a set of schedule periods. It supports standard schedule customization by expressing all the dates, quantities, and pricing data in a non-parametric way.
    """
    calculationPeriodDates: Optional[cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDates] = Field(None, description="Defines the calculation period dates schedule.")
    """
    Defines the calculation period dates schedule.
    """
    paymentDates: cdm.product.common.schedule.PaymentDates.PaymentDates = Field(..., description="Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).")
    """
    Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).
    """
    underlier: cdm.product.template.Underlier.Underlier = Field(..., description="Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.")
    """
    Identifies the underlying product that is referenced for pricing of the applicable leg in a swap. Referenced in the '2018 ISDA CDM Equity Confirmation for Security Equity Swap' as Security.
    """
    fxFeature: Optional[cdm.product.template.FxFeature.FxFeature] = Field(None, description="Defines quanto or composite FX features that are included in the swap leg.")
    """
    Defines quanto or composite FX features that are included in the swap leg.
    """
    delivery: Optional[cdm.product.asset.AssetDeliveryInformation.AssetDeliveryInformation] = Field(None, description="Contains the information relative to the delivery of the asset.")
    """
    Contains the information relative to the delivery of the asset.
    """
    
    @rosetta_condition
    def condition_0_Quantity(self):
        """
        When there is an OptionPayout the quantity can be expressed as part of the payoutQuantity, or as part of the underlier in the case of a Swaption.  For all other payouts that extend PayoutBase the payoutQuantity is a mandatory attribute.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "priceQuantity"))
    
    @rosetta_condition
    def condition_1_CalculationPeriod(self):
        """
        The calculation periods are either specified parametrically via CalculationPeriodDates or non-parametrically via SchedulePeriod.
        """
        item = self
        return self.check_one_of_constraint('schedule', 'calculationPeriodDates', necessity=True)
    
    @rosetta_condition
    def condition_2_CommodityUnderlier(self):
        """
        The underlier for a CommodityPayout should be a commodity.
        """
        item = self
        def _then_fn2():
            return ObservableIsCommodity(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "TransferableProduct"), "economicTerms"), "payout")), "SettlementPayout"), "underlier"), "Observable"))
        
        def _else_fn2():
            return False
        
        def _then_fn1():
            return ObservableIsCommodity(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "TransferableProduct"), "economicTerms"), "payout")), "OptionPayout"), "underlier"), "Observable"))
        
        def _else_fn1():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "TransferableProduct"), "economicTerms"), "payout")), "SettlementPayout")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return ObservableIsCommodity(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Observable"))
        
        def _else_fn0():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Product"), "TransferableProduct"), "economicTerms"), "payout")), "OptionPayout")), _then_fn1, _else_fn1)
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "underlier"), "Observable")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_DeliveryCapacity(self):
        """
        Checks that only one of the representations of delivery capacity is present simultaneously.
        """
        item = self
        def _then_fn3():
            return (((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "deliveryCapacity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "deliveryCapacity")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "deliveryCapacity"))))
        
        def _else_fn3():
            return True
        
        def _then_fn2():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "deliveryCapacity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "deliveryCapacity"))))
        
        def _else_fn2():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "deliveryCapacity")), _then_fn3, _else_fn3)
        
        def _then_fn1():
            return (((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "deliveryCapacity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "deliveryCapacity")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "deliveryCapacity"))))
        
        def _else_fn1():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "deliveryCapacity")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return (((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "deliveryCapacity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "deliveryCapacity")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "deliveryCapacity"))))
        
        def _else_fn0():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "deliveryCapacity")), _then_fn1, _else_fn1)
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "deliveryCapacity")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_PriceTimeIntervalQuantity(self):
        """
        Checks that only one of the representations of price time interval quantity is present simultaneously.
        """
        item = self
        def _then_fn2():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "priceTimeIntervalQuantity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "priceTimeIntervalQuantity"))))
        
        def _else_fn2():
            return True
        
        def _then_fn1():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "priceTimeIntervalQuantity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "priceTimeIntervalQuantity"))))
        
        def _else_fn1():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "priceTimeIntervalQuantity")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "priceTimeIntervalQuantity"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "profile"), "block"), "priceTimeIntervalQuantity"))))
        
        def _else_fn0():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "delivery"), "periods"), "profile"), "block"), "priceTimeIntervalQuantity")), _then_fn1, _else_fn1)
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "schedulePeriod"), "deliveryPeriod"), "priceTimeIntervalQuantity")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.template.AveragingCalculation
import cdm.product.common.settlement.CommodityPriceReturnTerms
import cdm.product.common.settlement.PricingDates
import cdm.product.template.CalculationSchedule
import cdm.product.common.schedule.CalculationPeriodDates
import cdm.product.common.schedule.PaymentDates
import cdm.product.template.Underlier
import cdm.product.template.FxFeature
import cdm.product.asset.AssetDeliveryInformation
from cdm.observable.asset.functions.ObservableIsCommodity import ObservableIsCommodity
