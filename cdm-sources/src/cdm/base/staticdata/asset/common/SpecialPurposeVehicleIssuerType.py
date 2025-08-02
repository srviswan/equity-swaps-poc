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

__all__ = ['SpecialPurposeVehicleIssuerType']


class SpecialPurposeVehicleIssuerType(BaseDataClass):
    """
    Represents a class to allow specification of different types of special purpose vehicle (SPV) collateral.
    """
    creditRisk: Optional[cdm.base.staticdata.asset.common.CreditRiskEnum.CreditRiskEnum] = Field(None, description="Indicates tranched or untranched credit risk.")
    """
    Indicates tranched or untranched credit risk.
    """

import cdm 
import cdm.base.staticdata.asset.common.CreditRiskEnum
