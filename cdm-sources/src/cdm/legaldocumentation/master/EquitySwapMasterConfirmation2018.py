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

__all__ = ['EquitySwapMasterConfirmation2018']

from cdm.legaldocumentation.master.EquityMasterConfirmation import EquityMasterConfirmation

class EquitySwapMasterConfirmation2018(EquityMasterConfirmation):
    """
    Specification for the General Terms and Relationship Supplement Elections as provided in the 2018 ISDA CDM Equity Confirmation for Security Equity Swap.
    """
    typeOfSwapElection: cdm.product.asset.ReturnTypeEnum.ReturnTypeEnum = Field(..., description="Per Part 1 Section 4, 'Dividend Obligations', of the 2018 ISDA CDM Equity Confirmation, Para 4.2 'Dividend Returns'")
    """
    Per Part 1 Section 4, 'Dividend Obligations', of the 2018 ISDA CDM Equity Confirmation, Para 4.2 'Dividend Returns'
    """
    pricingMethodElection: cdm.product.asset.PriceReturnTerms.PriceReturnTerms = Field(..., description="Per Part 1 Section 5, 'Pricing', of the 2018 ISDA CDM Equity Confirmation, Para 5.1")
    """
    Per Part 1 Section 5, 'Pricing', of the 2018 ISDA CDM Equity Confirmation, Para 5.1
    """
    linearInterpolationElection: cdm.observable.asset.InterpolationMethodEnum.InterpolationMethodEnum = Field(..., description="Per Part 1 Section 3, 'Floating Obligations', of the 2018 ISDA CDM Equity Confirmation. Para 3.3")
    """
    Per Part 1 Section 3, 'Floating Obligations', of the 2018 ISDA CDM Equity Confirmation. Para 3.3
    """
    settlementTerms: cdm.product.common.settlement.SettlementTerms.SettlementTerms = Field(..., description="Per Part 1 Section 8, 'Settlement', of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap")
    """
    Per Part 1 Section 8, 'Settlement', of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
    """
    valuationDates: cdm.observable.asset.ValuationDates.ValuationDates = Field(..., description="The parameters used to generate the 'Equity Valuation Dates' schedule, including the Effective Date and Termination Date for the Swap.")
    """
    The parameters used to generate the 'Equity Valuation Dates' schedule, including the Effective Date and Termination Date for the Swap.
    """
    equityCashSettlementDates: cdm.product.common.schedule.PaymentDates.PaymentDates = Field(..., description="The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Per Part 1 Section 12, 'Definitions', of the 2018 ISDA CDM Equity Confirmation. Para 73")
    """
    The parameters used to generate the payment date schedule, relative to the equityCalculationPeriod. Per Part 1 Section 12, 'Definitions', of the 2018 ISDA CDM Equity Confirmation. Para 73
    """

import cdm 
import cdm.product.asset.ReturnTypeEnum
import cdm.product.asset.PriceReturnTerms
import cdm.observable.asset.InterpolationMethodEnum
import cdm.product.common.settlement.SettlementTerms
import cdm.observable.asset.ValuationDates
import cdm.product.common.schedule.PaymentDates
