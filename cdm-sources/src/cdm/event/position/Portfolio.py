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

__all__ = ['Portfolio']


class Portfolio(BaseDataClass):
    """
     A Portfolio represents an aggregation of multiple Positions, by describing the parameters that this Portfolio should be aggregated based on. The resulting PortfolioState is calculated using these aggregation parameters as inputs, by aggregating all the Events that are relevant to this Portfolio. The concept of Portfolio works at all levels in the model: from the highest for a given LegalEntity for instance, to the lowest to account for security substitutions in a secutity financing transaction. As such, Portfolio can be used either above or below the Contract level.
    """
    aggregationParameters: cdm.event.position.AggregationParameters.AggregationParameters = Field(..., description="Describes the portfolio by describing how to aggregate all its relevant Events.")
    """
    Describes the portfolio by describing how to aggregate all its relevant Events.
    """
    portfolioState: cdm.event.position.PortfolioState.PortfolioState = Field(..., description="Describes the state of the Portfolio as a list of Positions resulting from the aggregation.")
    """
    Describes the state of the Portfolio as a list of Positions resulting from the aggregation.
    """

import cdm 
import cdm.event.position.AggregationParameters
import cdm.event.position.PortfolioState
