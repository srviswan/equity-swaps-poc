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

__all__ = ['ValuationSource']


class ValuationSource(BaseDataClass):
    """
    A class describing the method for obtaining a settlement rate, specified through either an information source (page), a settlement rate option (fixing) or by using quotes from reference banks.
    """
    quotedCurrencyPair: Optional[AttributeWithAddress[cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPair] | cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPair] = Field(None, description="Defines the two currencies for an FX trade and the quotation relationship between the two currencies. This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.")
    """
    Defines the two currencies for an FX trade and the quotation relationship between the two currencies.  This attribute was formerly part of 'fxSettlementTerms', which is now being harmonised into a common 'CashSettlementTerms' that includes a 'ValuationDate'.
    """
    informationSource: Optional[cdm.observable.asset.FxSpotRateSource.FxSpotRateSource] = Field(None, description="The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.")
    """
    The information source where a published or displayed market rate will be obtained, e.g. Telerate Page 3750.
    """
    settlementRateOption: Optional[cdm.observable.asset.SettlementRateOption.SettlementRateOption] = Field(None, description="The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.")
    """
    The rate option to use for the fixing. Currently only applicable to foreign exchange fixing in case of cross-currency settlement.
    """
    referenceBanks: Optional[cdm.base.staticdata.party.ReferenceBanks.ReferenceBanks] = Field(None, description="A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.")
    """
    A container for a set of reference institutions that may be called upon to provide rate quotations as part of the method to determine the applicable cash settlement amount. If institutions are not specified, it is assumed that reference institutions will be agreed between the parties on the exercise date, or in the case of swap transaction to which mandatory early termination is applicable, the cash settlement valuation date.
    """
    dealerOrCCP: Optional[cdm.base.staticdata.party.AncillaryEntity.AncillaryEntity] = Field(None, description="Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.")
    """
    Holds an identifier for the reference entity that is agreed by both parties as a basis for cash settlement calculations. This could be a dealer from whom quotations are obtained by the calculation agent on the reference obligation for purposes of cash settlement in a credit event. ISDA 2003 Term: Dealer. This could be the clearing organization (CCP, DCO) to which the trade should be cleared, as applicable for cash-settled swaptions.
    """
    
    @rosetta_condition
    def condition_0_InformationSource(self):
        """
        An information source must be provided.
        """
        item = self
        return self.check_one_of_constraint('informationSource', 'settlementRateOption', 'referenceBanks', 'dealerOrCCP', necessity=True)

import cdm 
import cdm.observable.asset.QuotedCurrencyPair
import cdm.observable.asset.FxSpotRateSource
import cdm.observable.asset.SettlementRateOption
import cdm.base.staticdata.party.ReferenceBanks
import cdm.base.staticdata.party.AncillaryEntity
