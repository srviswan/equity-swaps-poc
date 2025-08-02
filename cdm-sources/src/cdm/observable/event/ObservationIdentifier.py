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

__all__ = ['ObservationIdentifier']


class ObservationIdentifier(BaseDataClass):
    """
    Defines the parameters needed to uniquely identify a piece of data among the population of all available market data.
    """
    observable: cdm.observable.asset.Observable.Observable = Field(..., description="Represents the asset or rate to which the observation relates.")
    """
    Represents the asset or rate to which the observation relates.
    """
    observationDate: datetime.date = Field(..., description="Specifies the date value to use when resolving the market data.")
    """
    Specifies the date value to use when resolving the market data.
    """
    observationTime: Optional[cdm.base.datetime.TimeZone.TimeZone] = Field(None, description="Represents the time and time-zone.")
    """
    Represents the time and time-zone.
    """
    informationSource: Optional[cdm.observable.asset.InformationSource.InformationSource] = Field(None, description="Represents where the market data published and should be observed.")
    """
    Represents where the market data published and should be observed.
    """
    determinationMethodology: Optional[cdm.observable.event.DeterminationMethodology.DeterminationMethodology] = Field(None, description="Specifies the method according to which an amount or a date is determined.")
    """
    Specifies the method according to which an amount or a date is determined.
    """

import cdm 
import cdm.observable.asset.Observable
import cdm.base.datetime.TimeZone
import cdm.observable.asset.InformationSource
import cdm.observable.event.DeterminationMethodology
