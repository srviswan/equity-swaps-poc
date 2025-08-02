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

__all__ = ['FallbackReferencePrice']


class FallbackReferencePrice(BaseDataClass):
    """
    The method, prioritised by the order it is listed in this element, to get a replacement rate for the disrupted settlement rate option.
    """
    valuationPostponement: Optional[cdm.observable.asset.ValuationPostponement.ValuationPostponement] = Field(None, description="Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.")
    """
    Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
    """
    fallBackSettlementRateOption: List[AttributeWithMeta[cdm.observable.asset.SettlementRateOptionEnum.SettlementRateOptionEnum] | cdm.observable.asset.SettlementRateOptionEnum.SettlementRateOptionEnum] = Field([], description="This settlement rate option will be used in its place.")
    """
    This settlement rate option will be used in its place.
    """
    fallbackSurveyValuationPostponement: Optional[bool] = Field(None, description="Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.")
    """
    Request rate quotes from the market. This element is set as type Empty in FpML. When present, the FpML synonym is mapped to a value True in the CDM.
    """
    calculationAgentDetermination: Optional[cdm.observable.asset.CalculationAgent.CalculationAgent] = Field(None, description="The calculation agent will decide the rate.")
    """
    The calculation agent will decide the rate.
    """
    
    @rosetta_condition
    def condition_0_MaximumDaysOfPostponement(self):
        """
        FpML specifies maximumDaysOfPostponement as a positive integer.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationPostponement"), "maximumDaysOfPostponement"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "valuationPostponement")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_FallbackCalculationAgent(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationAgentDetermination"), "calculationAgentParty"), "=", rosetta_resolve_attr(AncillaryRoleEnum, "CALCULATION_AGENT_FALLBACK"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationAgentDetermination"), "calculationAgentParty")), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.ValuationPostponement
import cdm.observable.asset.SettlementRateOptionEnum
import cdm.observable.asset.CalculationAgent
from cdm.base.staticdata.party.AncillaryRoleEnum import AncillaryRoleEnum
