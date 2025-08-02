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

__all__ = ['InformationSource']


class InformationSource(BaseDataClass):
    """
    A class defining the source for a piece of information (e.g. a rate fix or an FX fixing). The attribute names have been adjusted from FpML to address the fact that the information is not limited to rates.
    """
    sourceProvider: AttributeWithMeta[cdm.observable.asset.InformationProviderEnum.InformationProviderEnum] | cdm.observable.asset.InformationProviderEnum.InformationProviderEnum = Field(..., description="An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.")
    """
    An information source for obtaining a market data point. For example Bloomberg, Reuters, Telerate, etc.
    """
    sourcePage: Optional[AttributeWithMeta[str] | str] = Field(None, description="A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.")
    """
    A specific page for the source for obtaining a market data point. In FpML, this is specified as a scheme, rateSourcePageScheme, for which no coding Scheme or URI is specified.
    """
    sourcePageHeading: Optional[str] = Field(None, description="The heading for the source on a given source page.")
    """
    The heading for the source on a given source page.
    """

import cdm 
import cdm.observable.asset.InformationProviderEnum
