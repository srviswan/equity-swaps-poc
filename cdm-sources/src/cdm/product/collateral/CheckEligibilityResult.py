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

__all__ = ['CheckEligibilityResult']


class CheckEligibilityResult(BaseDataClass):
    """
    Result for the CheckEligibilityByDetails and CheckEligibilityForProduct functions
    """
    isEligible: bool = Field(..., description="a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible")
    """
    a simple boolean which is set to true if the asset described in the EligibilityQuery input is eligible
    """
    matchingEligibleCriteria: List[cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteria] = Field([], description="if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input")
    """
    if there was a match, this will be the one or more criteria that were supplied in the EligbilityCollateralSpecification which matched with the query input
    """
    eligibilityQuery: cdm.product.collateral.EligibilityQuery.EligibilityQuery = Field(..., description="a copy of the input query that was checked against the eligible collateral specification")
    """
    a copy of the input query that was checked against the eligible collateral specification
    """
    specification: cdm.product.collateral.EligibleCollateralSpecification.EligibleCollateralSpecification = Field(..., description="a copy of the input EligbilityCollateralSpecification that was checked against the query")
    """
    a copy of the input EligbilityCollateralSpecification that was checked against the query
    """

import cdm 
import cdm.product.collateral.EligibleCollateralCriteria
import cdm.product.collateral.EligibilityQuery
import cdm.product.collateral.EligibleCollateralSpecification
