# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.BillingRecordInstruction import BillingRecordInstruction
from cdm.event.common.functions.Create_BillingRecord import Create_BillingRecord
from cdm.event.common.BillingRecord import BillingRecord

__all__ = ['Create_BillingRecords']


@replaceable
def Create_BillingRecords(billingInstruction: list[BillingRecordInstruction]) -> BillingRecord:
    """
    Creates for each billing instruction an individual billing record to be included in a Security Lending Billing Invoice
    
    Parameters 
    ----------
    billingInstruction : BillingRecordInstruction
    Instruction for creating the billing records contained within the invoice
    
    Returns
    -------
    billingRecord : BillingRecord
    
    """
    self = inspect.currentframe()
    
    
    billingRecord = map(lambda item: Create_BillingRecord(item), rosetta_resolve_attr(self, "billingInstruction"))
    
    
    return billingRecord

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
