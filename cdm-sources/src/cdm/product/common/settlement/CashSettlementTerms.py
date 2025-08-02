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

__all__ = ['CashSettlementTerms']


class CashSettlementTerms(BaseDataClass):
    """
    Defines the terms required to compute and settle a cash settlement amount according to a fixing value, including the fixing source, fixing method and fixing date. In FpML, PhysicalSettlementTerms and CashSettlementTerms extend SettlementTerms. In the CDM, this extension paradigm has not been used because SettlementTerms class has been used for purposes related to securities transactions, while it is not used as such in the FpML standard (i.e. only as an abstract construct.
    """
    cashSettlementMethod: Optional[cdm.product.common.settlement.CashSettlementMethodEnum.CashSettlementMethodEnum] = Field(None, description="Specifies the type of cash settlement method: cash price, yield curve etc.")
    """
    Specifies the type of cash settlement method: cash price, yield curve etc.
    """
    valuationMethod: Optional[cdm.observable.asset.ValuationMethod.ValuationMethod] = Field(None, description="Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.")
    """
    Specifies the parameters required to obtain a valuation, including the source, quotation method (bid, mid etc.) and any applicable quotation amount.
    """
    valuationDate: Optional[cdm.product.common.settlement.ValuationDate.ValuationDate] = Field(None, description="Defines the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.")
    """
    Defines the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
    """
    valuationTime: Optional[cdm.base.datetime.BusinessCenterTime.BusinessCenterTime] = Field(None, description="The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method, if the parties have not otherwise been able to agree the cash settlement amount. When using quations, this is the time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time.")
    """
    The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method, if the parties have not otherwise been able to agree the cash settlement amount. When using quations, this is the time of day in the specified business center when the calculation agent seeks quotations for an amount of the reference obligation for purposes of cash settlement. ISDA 2003 Term: Valuation Time.
    """
    cashSettlementAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.")
    """
    The amount paid by the seller to the buyer for cash settlement on the cash settlement date. If not otherwise specified, would typically be calculated as 100 (or the Reference Price) minus the price of the Reference Obligation (all expressed as a percentage) times Floating Rate Payer Calculation Amount. ISDA 2003 Term: Cash Settlement Amount.
    """
    recoveryFactor: Optional[Decimal] = Field(None, description="Used for fixed recovery, specifies the recovery level, determined at contract formation, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.")
    """
    Used for fixed recovery, specifies the recovery level, determined at contract formation, to be applied on a default. Used to calculate the amount paid by the seller to the buyer for cash settlement on the cash settlement date. Amount calculation is (1 minus the Recovery Factor) multiplied by the Floating Rate Payer Calculation Amount. The currency will be derived from the Floating Rate Payer Calculation Amount.
    """
    fixedSettlement: Optional[bool] = Field(None, description="Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and if Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.")
    """
    Used for Recovery Lock, to indicate whether fixed Settlement is Applicable or Not Applicable. If Buyer fails to deliver an effective Notice of Physical Settlement on or before the Buyer NOPS Cut-off Date, and if Seller fails to deliver an effective Seller NOPS on or before the Seller NOPS Cut-off Date, then either: (a) if Fixed Settlement is specified in the related Confirmation as not applicable, then the Seller NOPS Cut-off Date shall be the Termination Date; or (b) if Fixed Settlement is specified in the related Confirmation as applicable, then: (i) if the Fixed Settlement Amount is a positive number, Seller shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the Fixed Settlement Amount to Buyer on the Fixed Settlement Payment Date; and (ii) if the Fixed Settlement Amount is a negative number, Buyer shall, subject to Section 3.1 (except for the requirement of satisfaction of the Notice of Physical Settlement Condition to Settlement), pay the absolute value of the Fixed Settlement Amount to Seller on the Fixed Settlement Payment Date.
    """
    accruedInterest: Optional[bool] = Field(None, description="Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.")
    """
    Indicates whether accrued interest is included (true) or not (false). For cash settlement this specifies whether quotations should be obtained inclusive or not of accrued interest. For physical settlement this specifies whether the buyer should deliver the obligation with an outstanding principal balance that includes or excludes accrued interest. ISDA 2003 Term: Include/Exclude Accrued Interest.
    """
    
    @rosetta_condition
    def condition_0_CashSettlementTermsChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('cashSettlementAmount', 'recoveryFactor', necessity=False)
    
    @rosetta_condition
    def condition_1_RecoveryFactor(self):
        """
        FpML specifies recoveryFactor as a RestrictedPercentage, meaning that it is a decimal which value is restricted between 0 and 1.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "recoveryFactor"), ">=", 0.0) and all_elements(rosetta_resolve_attr(self, "recoveryFactor"), "<=", 1.0))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "recoveryFactor")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_CashCollateralMethod(self):
        """
        The cash collateral valuation method only applies to mid-market and replacement value methods.
        """
        item = self
        def _then_fn0():
            return ((((all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_INDICATIVE_QUOTATIONS")) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE"))) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_CALCULATION_AGENT_DETERMINATION"))) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "REPLACEMENT_VALUE_FIRM_QUOTATIONS"))) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_MidMarketValuationMethod(self):
        """
        Certain cash collateral valuation parameters only apply to the mid-market valuation methods.
        """
        item = self
        def _then_fn0():
            return ((all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_INDICATIVE_QUOTATIONS")) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE"))) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "MID_MARKET_CALCULATION_AGENT_DETERMINATION")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod"), "applicableCsa")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod"), "agreedDiscountRate"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod"), "cashCollateralInterestRate"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_ReplacementValueMethod(self):
        """
        Protected party can only be specified for replacement value methods.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "REPLACEMENT_VALUE_FIRM_QUOTATIONS")) or all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod"), "protectedParty")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_5_FirmQuotationMethod(self):
        """
        Prescribed documentation adjustment can only be specified for firm quotations method.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "cashSettlementMethod"), "=", rosetta_resolve_attr(CashSettlementMethodEnum, "REPLACEMENT_VALUE_FIRM_QUOTATIONS"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationMethod"), "cashCollateralValuationMethod"), "prescribedDocumentationAdjustment")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.settlement.CashSettlementMethodEnum
import cdm.observable.asset.ValuationMethod
import cdm.product.common.settlement.ValuationDate
import cdm.base.datetime.BusinessCenterTime
import cdm.observable.asset.Money
from cdm.product.common.settlement.CashSettlementMethodEnum import CashSettlementMethodEnum
