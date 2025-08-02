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

__all__ = ['PrincipalPayments']


class PrincipalPayments(BaseDataClass):
    """
    A class defining which principal exchanges occur for the stream.
    """
    initialPayment: bool = Field(..., description="A true/false flag to indicate whether there is an initial exchange of principal on the effective date.")
    """
    A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
    """
    finalPayment: bool = Field(..., description="A true/false flag to indicate whether there is a final exchange of principal on the termination date.")
    """
    A true/false flag to indicate whether there is a final exchange of principal on the termination date.
    """
    intermediatePayment: bool = Field(..., description="A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.")
    """
    A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
    """
    varyingLegNotionalCurrency: List[str] = Field([], description="Indicate the Payout legs which nominal amount may vary in regards of FX Fixing dates as determined in the product terms.")
    """
    Indicate the Payout legs which nominal amount may vary in regards of FX Fixing dates as determined in the product terms.
    """
    principalPaymentSchedule: Optional[cdm.product.common.settlement.PrincipalPaymentSchedule.PrincipalPaymentSchedule] = Field(None, description="Describe dates schedules for Principal Exchanges and related role of the parties when known.")
    """
    Describe dates schedules for Principal Exchanges and related role of the parties when known.
    """

import cdm 
import cdm.product.common.settlement.PrincipalPaymentSchedule
