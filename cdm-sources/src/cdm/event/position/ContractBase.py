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

__all__ = ['ContractBase']


class ContractBase(BaseDataClass):
    """
    Encapsulates data features common to trade and position.
    """
    contractDetails: Optional[AttributeWithReference | cdm.event.common.ContractDetails.ContractDetails] = Field(None, description="Represents information specific to trades or positions involving contractual products.")
    """
    Represents information specific to trades or positions involving contractual products.
    """
    executionDetails: Optional[AttributeWithReference | cdm.event.common.ExecutionDetails.ExecutionDetails] = Field(None, description="Defines specific attributes that relate to trade or position executions.")
    """
    Defines specific attributes that relate to trade or position executions.
    """
    collateral: Optional[AttributeWithReference | cdm.product.collateral.Collateral.Collateral] = Field(None, description="Represents the collateral obligations of a party.")
    """
    Represents the collateral obligations of a party.
    """

import cdm 
import cdm.event.common.ContractDetails
import cdm.event.common.ExecutionDetails
import cdm.product.collateral.Collateral
