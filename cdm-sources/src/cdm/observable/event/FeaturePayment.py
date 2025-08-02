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

__all__ = ['FeaturePayment']


class FeaturePayment(BaseDataClass):
    """
    Payment made following trigger occurrence.
    """
    payerReceiver: cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiver = Field(..., description="This attribute doesn't exist as part of the FpML construct, which makes use of the PayerReceiver.model group.")
    """
    This attribute doesn't exist as part of the FpML construct, which makes use of the PayerReceiver.model group.
    """
    levelPercentage: Optional[Decimal] = Field(None, description="The trigger level percentage.")
    """
    The trigger level percentage.
    """
    amount: Optional[Decimal] = Field(None, description="The monetary quantity in currency units.")
    """
    The monetary quantity in currency units.
    """
    time: Optional[cdm.observable.common.TimeTypeEnum.TimeTypeEnum] = Field(None, description="The feature payment time.")
    """
    The feature payment time.
    """
    currency: Optional[AttributeWithMeta[str] | str] = Field(None, description="The currency in which an amount is denominated.")
    """
    The currency in which an amount is denominated.
    """
    paymentDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="The feature payment date.")
    """
    The feature payment date.
    """
    
    @rosetta_condition
    def condition_0_FeaturePaymentChoice(self):
        """
         Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('levelPercentage', 'amount', necessity=True)
    
    @rosetta_condition
    def condition_1_Amount(self):
        """
         The amount attribute is specified in FpML as non-negative decimal.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "amount"), ">=", 0.0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "amount")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.party.PartyReferencePayerReceiver
import cdm.observable.common.TimeTypeEnum
import cdm.base.datetime.AdjustableOrRelativeDate
