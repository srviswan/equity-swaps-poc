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

__all__ = ['PayoutBase']


class PayoutBase(BaseDataClass):
    """
    A data type that contains the common attributes (e.g. payer and receiver parties) and validation conditions that apply across all payout types
    """
    payerReceiver: cdm.base.staticdata.party.PayerReceiver.PayerReceiver = Field(..., description="Canonical representation of the payer and receiver parties applicable to each payout leg.")
    """
    Canonical representation of the payer and receiver parties applicable to each payout leg.
    """
    priceQuantity: Optional[cdm.product.common.settlement.ResolvablePriceQuantity.ResolvablePriceQuantity] = Field(None, description="Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).")
    """
    Each payout leg must implement the quantity concept as a 'resolvable' type, which allows for different payout legs to be linked to each other (e.g. in the case of cross-curreny products).
    """
    principalPayment: Optional[cdm.product.common.settlement.PrincipalPayments.PrincipalPayments] = Field(None, description="The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.")
    """
    The specification of the principal exchange. Optional as only applicable in the case of cross-currency or zero-coupon swaps with a final payment.
    """
    settlementTerms: Optional[cdm.product.common.settlement.SettlementTerms.SettlementTerms] = Field(None, description="Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.")
    """
    Each payout leg must specifies its settlement terms, including the delivery type (i.e. cash vs physical, and their respective terms), the transfer type (DvP etc.) and settlement date, if any.
    """
    
    @rosetta_condition
    def condition_0_FinalPrincipalAmountExists(self):
        """
        When a final principal payment is specified, and as long as the quantity is not resettable, the amount of that principal payment (or its present value) must be provided. This condition is implemented at the Payout level and not on PrincipalPayment, because it needs to check whether the quantity may be resettable.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "principalPayment"), "principalPaymentSchedule"), "finalPrincipalPayment"), "principalAmount")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "principalPayment"), "principalPaymentSchedule"), "finalPrincipalPayment"), "presentValuePrincipalAmount")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "principalPayment"), "principalPaymentSchedule"), "finalPrincipalPayment")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "reset")))), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.party.PayerReceiver
import cdm.product.common.settlement.ResolvablePriceQuantity
import cdm.product.common.settlement.PrincipalPayments
import cdm.product.common.settlement.SettlementTerms
