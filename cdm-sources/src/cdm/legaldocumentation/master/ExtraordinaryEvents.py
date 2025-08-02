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

__all__ = ['ExtraordinaryEvents']


class ExtraordinaryEvents(BaseDataClass):
    """
    Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
    """
    additionalBespokeTerms: List[cdm.legaldocumentation.master.Clause.Clause] = Field([], description="Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.")
    """
    Where parties may optionnaly describe any extra bespoke agreements, in regards of the standardized Extraordinary Events.
    """
    mergerEvents: Optional[cdm.legaldocumentation.master.EquityCorporateEvents.EquityCorporateEvents] = Field(None, description="Per the 2018 ISDA CDM Equity Confirmation for Security Equity Swap")
    """
    Per the 2018 ISDA CDM Equity Confirmation for Security Equity Swap
    """
    tenderOfferEvents: Optional[cdm.legaldocumentation.master.EquityCorporateEvents.EquityCorporateEvents] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions: ")
    """
    Per the 2002 ISDA Equity Derivatives Definitions: 
    """
    compositionOfCombinedConsideration: Optional[bool] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions: ")
    """
    Per the 2002 ISDA Equity Derivatives Definitions: 
    """
    indexAdjustmentEvents: Optional[cdm.legaldocumentation.master.IndexAdjustmentEvents.IndexAdjustmentEvents] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions: Adjustments to Indices ")
    """
    Per the 2002 ISDA Equity Derivatives Definitions: Adjustments to Indices 
    """
    additionalDisruptionEvents: Optional[cdm.legaldocumentation.master.AdditionalDisruptionEvents.AdditionalDisruptionEvents] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swaps")
    """
    Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swaps
    """
    failureToDeliver: Optional[bool] = Field(None, description="If true, failure to deliver is applicable.")
    """
    If true, failure to deliver is applicable.
    """
    representations: Optional[cdm.legaldocumentation.master.Representations.Representations] = Field(None, description="")
    nationalizationOrInsolvency: Optional[cdm.legaldocumentation.master.NationalizationOrInsolvencyOrDelistingEventEnum.NationalizationOrInsolvencyOrDelistingEventEnum] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap")
    """
    Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap
    """
    delisting: Optional[cdm.legaldocumentation.master.NationalizationOrInsolvencyOrDelistingEventEnum.NationalizationOrInsolvencyOrDelistingEventEnum] = Field(None, description="Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap:")
    """
    Per the 2002 ISDA Equity Derivatives Definitions | 2018 ISDA CDM Equity Confirmation for Security Equity Swap:
    """
    
    @rosetta_condition
    def condition_0_ExtraordinaryEventsChoice(self):
        """
        condition to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('additionalDisruptionEvents', 'failureToDeliver', necessity=True)

import cdm 
import cdm.legaldocumentation.master.Clause
import cdm.legaldocumentation.master.EquityCorporateEvents
import cdm.legaldocumentation.master.IndexAdjustmentEvents
import cdm.legaldocumentation.master.AdditionalDisruptionEvents
import cdm.legaldocumentation.master.Representations
import cdm.legaldocumentation.master.NationalizationOrInsolvencyOrDelistingEventEnum
