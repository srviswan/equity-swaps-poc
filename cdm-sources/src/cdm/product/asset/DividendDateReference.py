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

__all__ = ['DividendDateReference']


class DividendDateReference(BaseDataClass):
    """
    A class to specify the dividend date by reference to another date, with the ability to apply and offset. This class doesn't exist in FpML and is meant to simplify the choice constraint associated with the DividendPaymentDate class.
    """
    dateReference: cdm.product.asset.DividendDateReferenceEnum.DividendDateReferenceEnum = Field(..., description="Specification of the dividend date using an enumeration, with values such as the pay date, the ex-date or the record date.")
    """
    Specification of the dividend date using an enumeration, with values such as the pay date, the ex-date or the record date.
    """
    paymentDateOffset: Optional[cdm.base.datetime.Offset.Offset] = Field(None, description="Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.")
    """
    Only to be used when SharePayment has been specified in the dividendDateReference element. The number of Currency Business Days following the day on which the Issuer of the Shares pays the relevant dividend to holders of record of the Shares.
    """
    
    @rosetta_condition
    def condition_0_PaymentDateOffset(self):
        """
         FpML specifies that paymentDateOffset is only to be used when SharePayment has been specified in the dividendDateReference element.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "dateReference"), "=", rosetta_resolve_attr(DividendDateReferenceEnum, "SHARE_PAYMENT"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "paymentDateOffset")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.DividendDateReferenceEnum
import cdm.base.datetime.Offset
from cdm.product.asset.DividendDateReferenceEnum import DividendDateReferenceEnum
