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

__all__ = ['InflationRateSpecification']

from cdm.product.asset.FloatingRateSpecification import FloatingRateSpecification

class InflationRateSpecification(FloatingRateSpecification):
    """
    A data to:  specify the inflation rate.
    """
    inflationLag: cdm.base.datetime.Offset.Offset = Field(..., description="An off-setting period from the payment date which determines the reference period for which the inflation index is observed.")
    """
    An off-setting period from the payment date which determines the reference period for which the inflation index is observed.
    """
    indexSource: AttributeWithMeta[str] | str = Field(..., description="The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.")
    """
    The reference source such as Reuters or Bloomberg. FpML specifies indexSource to be of type rateSourcePageScheme, but without specifying actual values.
    """
    mainPublication: AttributeWithMeta[str] | str = Field(..., description="The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.")
    """
    The current main publication source such as relevant web site or a government body. FpML specifies mainPublication to be of type mainPublicationSource, but without specifying actual values.
    """
    interpolationMethod: AttributeWithMeta[cdm.observable.asset.InterpolationMethodEnum.InterpolationMethodEnum] | cdm.observable.asset.InterpolationMethodEnum.InterpolationMethodEnum = Field(..., description="The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.")
    """
    The method used when calculating the Inflation Index Level from multiple points. The most common is Linear.
    """
    initialIndexLevel: Optional[Decimal] = Field(None, description="Initial known index level for the first calculation period.")
    """
    Initial known index level for the first calculation period.
    """
    fallbackBondApplicable: bool = Field(..., description="The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.")
    """
    The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
    """
    calculationMethod: Optional[cdm.observable.asset.calculatedrate.InflationCalculationMethodEnum.InflationCalculationMethodEnum] = Field(None, description="Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap")
    """
    Indicates how to use the inflation index to calculate the payment (e.g. Ratio, Return, Spread). Added for Inflation Asset Swap
    """
    calculationStyle: Optional[cdm.observable.asset.calculatedrate.InflationCalculationStyleEnum.InflationCalculationStyleEnum] = Field(None, description="Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).")
    """
    Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
    """
    finalPrincipalExchangeCalculation: Optional[cdm.product.asset.FinalPrincipalExchangeCalculationEnum.FinalPrincipalExchangeCalculationEnum] = Field(None, description="To be specified only for products that embed a redemption payment.")
    """
    To be specified only for products that embed a redemption payment.
    """
    
    @rosetta_condition
    def condition_0_InflationIndex(self):
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "rateOption"), "InflationIndex"))

import cdm 
import cdm.base.datetime.Offset
import cdm.observable.asset.InterpolationMethodEnum
import cdm.observable.asset.calculatedrate.InflationCalculationMethodEnum
import cdm.observable.asset.calculatedrate.InflationCalculationStyleEnum
import cdm.product.asset.FinalPrincipalExchangeCalculationEnum
