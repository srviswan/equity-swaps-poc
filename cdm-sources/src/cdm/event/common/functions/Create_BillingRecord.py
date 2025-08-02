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
from cdm.observable.event.functions.Create_AssetPayoutTradeStateWithObservations import Create_AssetPayoutTradeStateWithObservations
from cdm.event.common.functions.ResolveSecurityFinanceBillingAmount import ResolveSecurityFinanceBillingAmount
from cdm.event.common.BillingRecord import BillingRecord

__all__ = ['Create_BillingRecord']


@replaceable
def Create_BillingRecord(billingInstruction: BillingRecordInstruction) -> BillingRecord:
    """
    Creates an individual billing record to be included in a Security Lending Billing Invoice
    
    Parameters 
    ----------
    billingInstruction : BillingRecordInstruction
    Instruction for creating the billing records contained within the invoice
    
    Returns
    -------
    billingRecord : BillingRecord
    
    """
    self = inspect.currentframe()
    
    
    tradeState = Create_AssetPayoutTradeStateWithObservations(rosetta_resolve_attr(self, "billingInstruction"))
    billingAmount = ResolveSecurityFinanceBillingAmount(rosetta_resolve_attr(self, "tradeState"), get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "resetHistory")), rosetta_resolve_attr(rosetta_resolve_attr(self, "billingInstruction"), "recordStartDate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "billingInstruction"), "recordEndDate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "billingInstruction"), "settlementDate"))
    billingRecord = _get_rosetta_object('BillingRecord', 'recordStartDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "billingInstruction"), "recordStartDate"))
    billingRecord = set_rosetta_attr(rosetta_resolve_attr(self, 'billingRecord'), 'recordEndDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "billingInstruction"), "recordEndDate"))
    billingRecord = set_rosetta_attr(rosetta_resolve_attr(self, 'billingRecord'), 'tradeState', rosetta_resolve_attr(self, "tradeState"))
    billingRecord = set_rosetta_attr(rosetta_resolve_attr(self, 'billingRecord'), 'recordTransfer', rosetta_resolve_attr(self, "billingAmount"))
    
    
    return billingRecord

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
