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

__all__ = ['ValuationMethod']


class ValuationMethod(BaseDataClass):
    """
    Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
    """
    valuationSource: cdm.observable.asset.ValuationSource.ValuationSource = Field(..., description="The source for obtaining a valuation. This may come from some information source (e.g. Reuters), from a rate option fixing (e.g. FX fixing for cross-currency settlement), or from a set of reference banks. This is a mandatory attribute as the valuation method relies on one of those sources to be specified.")
    """
    The source for obtaining a valuation. This may come from some information source (e.g. Reuters), from a rate option fixing (e.g. FX fixing for cross-currency settlement), or from a set of reference banks. This is a mandatory attribute as the valuation method relies on one of those sources to be specified.
    """
    quotationMethod: Optional[cdm.observable.asset.QuotationRateTypeEnum.QuotationRateTypeEnum] = Field(None, description="The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement, or which rate quote is to be observed for a fixing. For example, Bid, Offer, Mid-market or Exercising Party Pays. ISDA 2003 Term: Quotation Method. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j).")
    """
    The type of price quotations to be requested from dealers when determining the market value of the reference obligation for purposes of cash settlement, or which rate quote is to be observed for a fixing. For example, Bid, Offer, Mid-market or Exercising Party Pays. ISDA 2003 Term: Quotation Method. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j).
    """
    valuationMethod: Optional[cdm.observable.asset.ValuationMethodEnum.ValuationMethodEnum] = Field(None, description="The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.")
    """
    The ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement. (ISDA 2003 Term: Valuation Method). For example, Market, Highest etc.
    """
    quotationAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount.")
    """
    In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the quotation amount specifies an upper limit to the outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount equal to the floating rate payer calculation amount. ISDA 2003 Term: Quotation Amount.
    """
    minimumQuotationAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount.")
    """
    In the determination of a cash settlement amount, if weighted average quotations are to be obtained, the minimum quotation amount specifies a minimum intended threshold amount of outstanding principal balance of the reference obligation for which the quote should be obtained. If not specified, the ISDA definitions provide for a fallback amount of the lower of either USD 1,000,000 (or its equivalent in the relevant obligation currency) or the quotation amount. ISDA 2003 Term: Minimum Quotation Amount.
    """
    cashCollateralValuationMethod: Optional[cdm.observable.asset.CashCollateralValuationMethod.CashCollateralValuationMethod] = Field(None, description="Specifies the parameters representing several mid-market valuation and replacement value methods.")
    """
    Specifies the parameters representing several mid-market valuation and replacement value methods.
    """
    
    @rosetta_condition
    def condition_0_FpML_cd_37(self):
        """
        FpML validation rule cd-37 - If condition quotationAmount is true, and if condition minimumQuotationAmount is true, and if both amounts have the same-currency, then quotationAmount/amount must be greater or equal to minimumQuotationAmount/amount.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "quotationAmount"), "value"), ">", rosetta_resolve_attr(rosetta_resolve_attr(self, "minimumQuotationAmount"), "value"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(self, "quotationAmount")) and rosetta_attr_exists(rosetta_resolve_attr(self, "minimumQuotationAmount"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quotationAmount"), "unit"), "currency"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "minimumQuotationAmount"), "unit"), "currency"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_Dealer(self):
        """
        When a quotation amount is specified, the dealer from which to obtain the quotation must be specified in the valuation source. This is typically applicable to determine the recovery amount in a credit event.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationSource"), "dealerOrCCP"), "legalEntity"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "quotationAmount")) or rosetta_attr_exists(rosetta_resolve_attr(self, "minimumQuotationAmount"))), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.ValuationSource
import cdm.observable.asset.QuotationRateTypeEnum
import cdm.observable.asset.ValuationMethodEnum
import cdm.observable.asset.Money
import cdm.observable.asset.CashCollateralValuationMethod
