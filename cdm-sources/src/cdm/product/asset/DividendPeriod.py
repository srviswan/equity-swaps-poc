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

__all__ = ['DividendPeriod']


class DividendPeriod(BaseDataClass):
    """
    Time bounded dividend payment periods, each with a dividend payment date per period.
    """
    startDate: Optional[cdm.product.asset.DividendPaymentDate.DividendPaymentDate] = Field(None, description="Dividend period start date.")
    """
    Dividend period start date.
    """
    endDate: Optional[cdm.product.asset.DividendPaymentDate.DividendPaymentDate] = Field(None, description="Dividend period end date.")
    """
    Dividend period end date.
    """
    dateAdjustments: cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments = Field(..., description="Date adjustments for all unadjusted dates in this dividend period.")
    """
    Date adjustments for all unadjusted dates in this dividend period.
    """
    basketConstituent: Optional[AttributeWithAddress[cdm.observable.asset.BasketConstituent.BasketConstituent] | cdm.observable.asset.BasketConstituent.BasketConstituent] = Field(None, description="For basket underliers, reference to the basket component which is paying dividends in the specified period.")
    """
    For basket underliers, reference to the basket component which is paying dividends in the specified period.
    """
    dividendPaymentDate: cdm.product.asset.DividendPaymentDate.DividendPaymentDate = Field(..., description="Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.")
    """
    Specifies when the dividend will be paid to the receiver of the equity return. Has the meaning as defined in the ISDA 2002 Equity Derivatives Definitions. Is not applicable in the case of a dividend reinvestment election.
    """
    dividendValuationDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="Specifies the dividend valuation dates of the swap.")
    """
    Specifies the dividend valuation dates of the swap.
    """

import cdm 
import cdm.product.asset.DividendPaymentDate
import cdm.base.datetime.BusinessDayAdjustments
import cdm.observable.asset.BasketConstituent
import cdm.base.datetime.AdjustableOrRelativeDate
