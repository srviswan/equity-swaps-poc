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

__all__ = ['CreditNotation']


class CreditNotation(BaseDataClass):
    """
    Represents a class to specify the credit notation as the combination of agency, notation, scale and debt type qualifications.
    """
    agency: cdm.observable.asset.CreditRatingAgencyEnum.CreditRatingAgencyEnum = Field(..., description="Specifies The credit agency to which the other variables (notation, scale, debt type) refer to.")
    """
    Specifies The credit agency to which the other variables (notation, scale, debt type) refer to.
    """
    notation: AttributeWithMeta[str] | str = Field(..., description="Specifies The credit rating notation. As it varies among credit rating agencies, FpML doesn't specify a default scheme.")
    """
    Specifies The credit rating notation. As it varies among credit rating agencies, FpML doesn't specify a default scheme.
    """
    scale: Optional[AttributeWithMeta[str] | str] = Field(None, description="Specifies the credit rating scale, with a typical distinction between short term, long term. FpML doesn't specify a default scheme, which is hence not specified as an enumeration as part of the CDM.")
    """
    Specifies the credit rating scale, with a typical distinction between short term, long term. FpML doesn't specify a default scheme, which is hence not specified as an enumeration as part of the CDM.
    """
    debt: Optional[cdm.observable.asset.CreditRatingDebt.CreditRatingDebt] = Field(None, description="Specifies the credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.")
    """
    Specifies the credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.
    """
    outlook: Optional[cdm.observable.asset.CreditRatingOutlookEnum.CreditRatingOutlookEnum] = Field(None, description="Assesses the potential direction of a long-term credit rating over the intermediate term, which is generally up to two years for investment grade and generally up to one year for speculative grade.")
    """
    Assesses the potential direction of a long-term credit rating over the intermediate term, which is generally up to two years for investment grade and generally up to one year for speculative grade.
    """
    creditWatch: Optional[cdm.observable.asset.CreditRatingCreditWatchEnum.CreditRatingCreditWatchEnum] = Field(None, description="Indicates the potential direction of a short-term or long-term rating. It focuses on identifiable events and short-term trends that cause ratings to be placed under special surveillance.")
    """
    Indicates the potential direction of a short-term or long-term rating. It focuses on identifiable events and short-term trends that cause ratings to be placed under special surveillance.
    """

import cdm 
import cdm.observable.asset.CreditRatingAgencyEnum
import cdm.observable.asset.CreditRatingDebt
import cdm.observable.asset.CreditRatingOutlookEnum
import cdm.observable.asset.CreditRatingCreditWatchEnum
