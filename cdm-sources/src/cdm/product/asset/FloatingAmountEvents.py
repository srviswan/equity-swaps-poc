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

__all__ = ['FloatingAmountEvents']


class FloatingAmountEvents(BaseDataClass):
    """
    A class to specify the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
    """
    failureToPayPrincipal: Optional[bool] = Field(None, description="A floating rate payment event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.")
    """
    A floating rate payment event. Corresponds to the failure by the Reference Entity to pay an expected principal amount or the payment of an actual principal amount that is less than the expected principal amount. ISDA 2003 Term: Failure to Pay Principal.
    """
    interestShortfall: Optional[cdm.product.asset.InterestShortFall.InterestShortFall] = Field(None, description="A floating rate payment event. With respect to any Reference Obligation Payment Date, either (a) the non-payment of an Expected Interest Amount or (b) the payment of an Actual Interest Amount that is less than the Expected Interest Amount. ISDA 2003 Term: Interest Shortfall.")
    """
    A floating rate payment event. With respect to any Reference Obligation Payment Date, either (a) the non-payment of an Expected Interest Amount or (b) the payment of an Actual Interest Amount that is less than the Expected Interest Amount. ISDA 2003 Term: Interest Shortfall.
    """
    writedown: Optional[bool] = Field(None, description="A floating rate payment event. Results from the fact that the underlier writes down its outstanding principal amount. ISDA 2003 Term: Writedown.")
    """
    A floating rate payment event. Results from the fact that the underlier writes down its outstanding principal amount. ISDA 2003 Term: Writedown.
    """
    impliedWritedown: Optional[bool] = Field(None, description="A floating rate payment event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.")
    """
    A floating rate payment event. Results from the fact that losses occur to the underlying instruments that do not result in reductions of the outstanding principal of the reference obligation.
    """
    floatingAmountProvisions: Optional[cdm.product.asset.FloatingAmountProvisions.FloatingAmountProvisions] = Field(None, description="Specifies the floating amount provisions associated with the floatingAmountEvents.")
    """
    Specifies the floating amount provisions associated with the floatingAmountEvents.
    """
    additionalFixedPayments: Optional[cdm.product.asset.AdditionalFixedPayments.AdditionalFixedPayments] = Field(None, description="Specifies the events that will give rise to the payment additional fixed payments.")
    """
    Specifies the events that will give rise to the payment additional fixed payments.
    """

import cdm 
import cdm.product.asset.InterestShortFall
import cdm.product.asset.FloatingAmountProvisions
import cdm.product.asset.AdditionalFixedPayments
