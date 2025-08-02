# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.Create_BillingRecords import Create_BillingRecords
from cdm.event.common.SecurityLendingInvoice import SecurityLendingInvoice
from cdm.event.common.functions.Create_BillingSummary import Create_BillingSummary
from cdm.event.common.BillingInstruction import BillingInstruction

__all__ = ['Create_SecurityLendingInvoice']


@replaceable
def Create_SecurityLendingInvoice(instruction: BillingInstruction) -> SecurityLendingInvoice:
    """
    Defines the process of calculating and creating a Security Lending Invoice.
    
    Parameters 
    ----------
    instruction : BillingInstruction
    Specifies the instructions for creation of a Security Lending billing invoice.
    
    Returns
    -------
    invoice : SecurityLendingInvoice
    
    """
    self = inspect.currentframe()
    
    
    invoice = _get_rosetta_object('SecurityLendingInvoice', 'sendingParty', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "sendingParty"))
    invoice = set_rosetta_attr(rosetta_resolve_attr(self, 'invoice'), 'receivingParty', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "receivingParty"))
    invoice = set_rosetta_attr(rosetta_resolve_attr(self, 'invoice'), 'billingStartDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "billingStartDate"))
    invoice = set_rosetta_attr(rosetta_resolve_attr(self, 'invoice'), 'billingEndDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "billingEndDate"))
    invoice.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, invoice), 'billingRecord'), Create_BillingRecords(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "billingRecordInstruction")))
    invoice.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, invoice), 'billingSummary'), Create_BillingSummary(rosetta_resolve_attr(rosetta_resolve_attr(self, "invoice"), "billingRecord")))
    
    
    return invoice

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
