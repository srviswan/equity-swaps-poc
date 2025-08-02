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

__all__ = ['PrincipalPaymentSchedule']


class PrincipalPaymentSchedule(BaseDataClass):
    """
    Describe dates schedules for Principal Exchanges and related role of the parties when known.
    """
    initialPrincipalPayment: Optional[cdm.product.common.settlement.PrincipalPayment.PrincipalPayment] = Field(None, description="Principal Payment made at Trade inception.")
    """
    Principal Payment made at Trade inception.
    """
    intermediatePrincipalPayment: Optional[cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDates] = Field(None, description="Principal Payment as part of the Trade lifecycle e.g. as part of notional reset adjustements in a Cross Currency Swap with a varying notional leg.")
    """
    Principal Payment as part of the Trade lifecycle e.g. as part of notional reset adjustements in a Cross Currency Swap with a varying notional leg.
    """
    finalPrincipalPayment: Optional[cdm.product.common.settlement.PrincipalPayment.PrincipalPayment] = Field(None, description="Principal Payment at Trade maturity")
    """
    Principal Payment at Trade maturity
    """
    
    @rosetta_condition
    def condition_0_InitialPrincipalAmountExists(self):
        """
        When an initial principal payment is specified, the amount of that principal payment (or its present value) must be provided. This condition is implemented at the PrincipalPaymentSchedule level and not on PrincipalPayment, because it only applies to the initial principal payment.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "initialPrincipalPayment"), "principalAmount")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "initialPrincipalPayment"), "presentValuePrincipalAmount")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "initialPrincipalPayment")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.settlement.PrincipalPayment
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates
