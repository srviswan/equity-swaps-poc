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

__all__ = ['CollateralBalance']


class CollateralBalance(BaseDataClass):
    """
    Represents common attributes to define a collateral balance recorded by the principal as held or posted.
    """
    collateralBalanceStatus: Optional[cdm.event.common.CollateralStatusEnum.CollateralStatusEnum] = Field(None, description="Defines the collateral balance breakdown of settlement status.")
    """
    Defines the collateral balance breakdown of settlement status.
    """
    haircutIndicator: Optional[cdm.event.common.HaircutIndicatorEnum.HaircutIndicatorEnum] = Field(None, description="Indicates if the collateral balance amount is based on pre or post haircut, if a haircut is associated with the collateral asset")
    """
    Indicates if the collateral balance amount is based on pre or post haircut, if a haircut is associated with the collateral asset
    """
    amountBaseCurrency: cdm.observable.asset.Money.Money = Field(..., description="Specifies the collateral balance amount in base currency determined within a collateral legal agreement, or defined for reporting purposes.")
    """
    Specifies the collateral balance amount in base currency determined within a collateral legal agreement, or defined for reporting purposes.
    """
    payerReceiver: cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiver = Field(..., description="Specifies each of the parties in the collateral balance and its perspective with regards to the direction of the collateral balance, posted or received.")
    """
    Specifies each of the parties in the collateral balance and its perspective with regards to the direction of the collateral balance, posted or received.
    """

import cdm 
import cdm.event.common.CollateralStatusEnum
import cdm.event.common.HaircutIndicatorEnum
import cdm.observable.asset.Money
import cdm.base.staticdata.party.PartyReferencePayerReceiver
