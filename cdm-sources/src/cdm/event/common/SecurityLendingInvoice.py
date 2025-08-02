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

__all__ = ['SecurityLendingInvoice']


class SecurityLendingInvoice(BaseDataClass):
    """
    Specifies the information required for inclusion in a securities lending billing invoice.
    """
    sendingParty: cdm.base.staticdata.party.Party.Party = Field(..., description="The party issuing the invoice")
    """
    The party issuing the invoice
    """
    receivingParty: cdm.base.staticdata.party.Party.Party = Field(..., description="The party receiving the invoice")
    """
    The party receiving the invoice
    """
    billingStartDate: datetime.date = Field(..., description="The starting date of the period described by this invoice")
    """
    The starting date of the period described by this invoice
    """
    billingEndDate: datetime.date = Field(..., description="The ending date of the period described by this invoice")
    """
    The ending date of the period described by this invoice
    """
    billingRecord: List[cdm.event.common.BillingRecord.BillingRecord] = Field([], description="The billing records contained within the invoice")
    """
    The billing records contained within the invoice
    """
    @rosetta_condition
    def cardinality_billingRecord(self):
        return check_cardinality(self.billingRecord, 1, None)
    
    billingSummary: List[cdm.event.common.BillingSummary.BillingSummary] = Field([], description="The billing summaries contained within the invoice")
    """
    The billing summaries contained within the invoice
    """
    @rosetta_condition
    def cardinality_billingSummary(self):
        return check_cardinality(self.billingSummary, 1, None)
    

import cdm 
import cdm.base.staticdata.party.Party
import cdm.event.common.BillingRecord
import cdm.event.common.BillingSummary
