# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.BillingSummary import BillingSummary
from cdm.event.common.BillingRecord import BillingRecord

__all__ = ['Create_BillingSummary']


@replaceable
def Create_BillingSummary(billingRecord: list[BillingRecord]) -> BillingSummary:
    """
    Creates a billing summary to be included in a Security Lending Billing Invoice.
    
    Parameters 
    ----------
    billingRecord : BillingRecord
    
    Returns
    -------
    billingSummary : BillingSummary
    
    """
    self = inspect.currentframe()
    
    
    billingSummary = rosetta_resolve_attr(self, "billingSummary")
    
    
    return billingSummary

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
