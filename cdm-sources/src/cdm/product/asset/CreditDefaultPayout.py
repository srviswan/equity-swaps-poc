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

__all__ = ['CreditDefaultPayout']

from cdm.product.common.settlement.PayoutBase import PayoutBase

class CreditDefaultPayout(PayoutBase):
    """
     The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
    """
    generalTerms: cdm.product.asset.GeneralTerms.GeneralTerms = Field(..., description="The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.")
    """
    The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
    """
    protectionTerms: List[cdm.product.asset.ProtectionTerms.ProtectionTerms] = Field([], description="Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.")
    """
    Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
    """
    transactedPrice: Optional[cdm.observable.asset.TransactedPrice.TransactedPrice] = Field(None, description="The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.")
    """
    The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
    """
    
    @rosetta_condition
    def condition_0_FpML_cd_12(self):
        """
        FpML validation rule cd-12 - If referencePrice exists, referencePrice must be greater or equal to 0
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "generalTerms"), "referenceInformation"), "referencePrice"), "value"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "generalTerms"), "referenceInformation"), "referencePrice")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_Quantity(self):
        """
        When there is an OptionPayout the quantity can be expressed as part of the payoutQuantity, or as part of the underlier in the case of a Swaption.  For all other payouts that extend PayoutBase the payoutQuantity is a mandatory attribute.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "priceQuantity"))

import cdm 
import cdm.product.asset.GeneralTerms
import cdm.product.asset.ProtectionTerms
import cdm.observable.asset.TransactedPrice
