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

__all__ = ['CollateralTaxonomyValue']


class CollateralTaxonomyValue(BaseDataClass):
    """
    Specifies the collateral taxonomy value, either as a specified enumeration or as a string.
    """
    eu_EMIR_EligibleCollateral: List[cdm.base.staticdata.asset.common.EU_EMIR_EligibleCollateralEnum.EU_EMIR_EligibleCollateralEnum] = Field([], description="Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM")
    """
    Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM
    """
    uk_EMIR_EligibleCollateral: List[cdm.base.staticdata.asset.common.UK_EMIR_EligibleCollateralEnum.UK_EMIR_EligibleCollateralEnum] = Field([], description="Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.")
    """
    Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
    """
    us_CFTC_PR_EligibleCollateral: List[cdm.base.staticdata.asset.common.US_CFTC_PR_EligibleCollateralEnum.US_CFTC_PR_EligibleCollateralEnum] = Field([], description="Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators’ margin rules, the precise definitions or application of those rules could differ between the two rules.")
    """
    Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators’ margin rules, the precise definitions or application of those rules could differ between the two rules.
    """
    nonEnumeratedTaxonomyValue: List[AttributeWithMeta[str] | str] = Field([], description="Identifies the taxonomy value when not specified as an enumeration.")
    """
    Identifies the taxonomy value when not specified as an enumeration.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('eu_EMIR_EligibleCollateral', 'uk_EMIR_EligibleCollateral', 'us_CFTC_PR_EligibleCollateral', 'nonEnumeratedTaxonomyValue', necessity=True)

import cdm 
import cdm.base.staticdata.asset.common.EU_EMIR_EligibleCollateralEnum
import cdm.base.staticdata.asset.common.UK_EMIR_EligibleCollateralEnum
import cdm.base.staticdata.asset.common.US_CFTC_PR_EligibleCollateralEnum
