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

__all__ = ['PrincipalPayment']


class PrincipalPayment(BaseDataClass):
    """
    Any kind of principal payments when the amount is known and thus fixed.
    """
    principalPaymentDate: Optional[cdm.base.datetime.AdjustableDate.AdjustableDate] = Field(None, description="The date where the PrincipalPayment shall be settled.")
    """
    The date where the PrincipalPayment shall be settled.
    """
    payerReceiver: Optional[cdm.base.staticdata.party.PayerReceiver.PayerReceiver] = Field(None, description="Specifies the parties responsible for making and receiving payments defined by this structure.")
    """
    Specifies the parties responsible for making and receiving payments defined by this structure.
    """
    principalAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="When known at the time the transaction is made, the cash amount to be paid.")
    """
    When known at the time the transaction is made, the cash amount to be paid.
    """
    discountFactor: Optional[Decimal] = Field(None, description="The value representing the discount factor used to calculate the present value of the principal payment amount.")
    """
    The value representing the discount factor used to calculate the present value of the principal payment amount.
    """
    presentValuePrincipalAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="The amount representing the present value of the principal payment.")
    """
    The amount representing the present value of the principal payment.
    """
    
    @rosetta_condition
    def condition_0_PrincipalAmount(self):
        item = self
        return self.check_one_of_constraint('principalAmount', 'presentValuePrincipalAmount', necessity=False)
    
    @rosetta_condition
    def condition_1_DiscountFactor(self):
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "discountFactor"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "presentValuePrincipalAmount")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.AdjustableDate
import cdm.base.staticdata.party.PayerReceiver
import cdm.observable.asset.Money
