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

__all__ = ['DividendReturnTerms']


class DividendReturnTerms(BaseDataClass):
    """
    A class describing the conditions governing the payment of dividends to the receiver of the equity return, with the exception of the dividend payout ratio, which is defined for each of the underlying components.
    """
    dividendPayoutRatio: List[cdm.product.asset.DividendPayoutRatio.DividendPayoutRatio] = Field([], description="Specifies the dividend payout ratio associated with each underlier. In FpML 5.10 the payout is positioned at the underlier level, although there is an intent to reconsider this approach and position it at the leg level. This is approach adopted by the CDM.")
    """
    Specifies the dividend payout ratio associated with each underlier. In FpML 5.10 the payout is positioned at the underlier level, although there is an intent to reconsider this approach and position it at the leg level. This is approach adopted by the CDM.
    """
    dividendReinvestment: Optional[bool] = Field(None, description="Boolean element that defines whether the dividend will be reinvested or not.")
    """
    Boolean element that defines whether the dividend will be reinvested or not.
    """
    dividendEntitlement: Optional[cdm.product.asset.DividendEntitlementEnum.DividendEntitlementEnum] = Field(None, description="Defines the date on which the receiver of the equity return is entitled to the dividend.")
    """
    Defines the date on which the receiver of the equity return is entitled to the dividend.
    """
    dividendAmountType: Optional[cdm.product.asset.DividendAmountTypeEnum.DividendAmountTypeEnum] = Field(None, description="Specifies whether the dividend is paid with respect to the Dividend Period.")
    """
    Specifies whether the dividend is paid with respect to the Dividend Period.
    """
    performance: Optional[str] = Field(None, description="Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.")
    """
    Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
    """
    firstOrSecondPeriod: Optional[cdm.product.asset.DividendPeriodEnum.DividendPeriodEnum] = Field(None, description="2002 ISDA Equity Derivatives Definitions: Dividend Period as either the First Period or the Second Period. | ")
    """
    2002 ISDA Equity Derivatives Definitions: Dividend Period as either the First Period or the Second Period. | 
    """
    extraordinaryDividendsParty: Optional[cdm.base.staticdata.party.AncillaryRoleEnum.AncillaryRoleEnum] = Field(None, description="Specifies the party which determines if dividends are extraordinary in relation to normal levels.")
    """
    Specifies the party which determines if dividends are extraordinary in relation to normal levels.
    """
    excessDividendAmount: Optional[cdm.product.asset.DividendAmountTypeEnum.DividendAmountTypeEnum] = Field(None, description="Determination of Gross Cash Dividend per Share.")
    """
    Determination of Gross Cash Dividend per Share.
    """
    dividendCurrency: Optional[cdm.product.asset.DividendCurrency.DividendCurrency] = Field(None, description="Specifies the currency in which the dividend will be denominated, e.g. the dividend currency, or a specified currency. This class is not specified as such in FpML, which makes use of the CurrencyAndDeterminationMethod.model to specify such terms.")
    """
    Specifies the currency in which the dividend will be denominated, e.g. the dividend currency, or a specified currency. This class is not specified as such in FpML, which makes use of the CurrencyAndDeterminationMethod.model to specify such terms.
    """
    nonCashDividendTreatment: Optional[cdm.product.asset.NonCashDividendTreatmentEnum.NonCashDividendTreatmentEnum] = Field(None, description="Specifies the treatment of Non-Cash Dividends.")
    """
    Specifies the treatment of Non-Cash Dividends.
    """
    dividendComposition: Optional[cdm.product.asset.DividendCompositionEnum.DividendCompositionEnum] = Field(None, description="Specifies how the composition of Dividends is to be determined.")
    """
    Specifies how the composition of Dividends is to be determined.
    """
    specialDividends: Optional[bool] = Field(None, description="Specifies the method according to which special dividends are determined.")
    """
    Specifies the method according to which special dividends are determined.
    """
    materialDividend: Optional[bool] = Field(None, description="If present and true, then material non cash dividends are applicable.")
    """
    If present and true, then material non cash dividends are applicable.
    """
    dividendPeriod: List[cdm.product.asset.DividendPeriod.DividendPeriod] = Field([], description="One to many time bounded dividend payment periods, each with a dividend payment date per period.")
    """
    One to many time bounded dividend payment periods, each with a dividend payment date per period.
    """
    
    @rosetta_condition
    def condition_0_DividendPeriod(self):
        """
        FpML specifies a choice between dividendPeriod on one end, and dividendPeriodEffectiveDate and dividendPeriodEndDate on the other end.
        """
        item = self
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "dividendPeriod"), "startDate"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "dividendPeriod"), "endDate"))))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "firstOrSecondPeriod")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_ExtraordinaryDividendsParty(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "extraordinaryDividendsParty"), "=", rosetta_resolve_attr(AncillaryRoleEnum, "EXTRAORDINARY_DIVIDENDS_PARTY"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "extraordinaryDividendsParty")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.DividendPayoutRatio
import cdm.product.asset.DividendEntitlementEnum
import cdm.product.asset.DividendAmountTypeEnum
import cdm.product.asset.DividendPeriodEnum
import cdm.base.staticdata.party.AncillaryRoleEnum
import cdm.product.asset.DividendCurrency
import cdm.product.asset.NonCashDividendTreatmentEnum
import cdm.product.asset.DividendCompositionEnum
import cdm.product.asset.DividendPeriod
from cdm.base.staticdata.party.AncillaryRoleEnum import AncillaryRoleEnum
