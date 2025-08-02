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

__all__ = ['Cashflow']

from cdm.product.common.settlement.AssetFlowBase import AssetFlowBase

class Cashflow(AssetFlowBase):
    """
    Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it. The associated globalKey denotes the ability to associate a hash value to the Cashflow instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
    """
    payerReceiver: cdm.base.staticdata.party.PayerReceiver.PayerReceiver = Field(..., description="Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.")
    """
    Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.
    """
    cashflowType: cdm.product.common.settlement.CashflowType.CashflowType = Field(..., description="The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.")
    """
    The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.
    """
    paymentDiscounting: Optional[cdm.product.common.settlement.PaymentDiscounting.PaymentDiscounting] = Field(None, description="FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.")
    """
    FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
    """

import cdm 
import cdm.base.staticdata.party.PayerReceiver
import cdm.product.common.settlement.CashflowType
import cdm.product.common.settlement.PaymentDiscounting
