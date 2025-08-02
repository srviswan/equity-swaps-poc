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

__all__ = ['CounterpartyPosition']

from cdm.event.position.ContractBase import ContractBase

class CounterpartyPosition(ContractBase):
    """
    A Position describes the accumulated effect of a set of securities or financial transactions.
    """
    positionIdentifier: List[cdm.event.common.PositionIdentifier.PositionIdentifier] = Field([], description="Represents the identifier(s) that uniquely identify a position for an identity issuer. A position can include multiple identifiers, for example an internal position identifer and a UTI (Unique Trade Identifier).")
    """
    Represents the identifier(s) that uniquely identify a position for an identity issuer. A position can include multiple identifiers, for example an internal position identifer and a UTI (Unique Trade Identifier).
    """
    openDateTime: Optional[datetime.datetime] = Field(None, description="The date and time when the position was opened.")
    """
    The date and time when the position was opened.
    """
    tradeReference: List[AttributeWithReference | cdm.event.common.TradeState.TradeState] = Field([], description="Reference to all the trades that constitute the position.")
    """
    Reference to all the trades that constitute the position.
    """
    party: List[cdm.base.staticdata.party.Party.Party] = Field([], description="The parties involved in the position, including the Clearing Organization.")
    """
    The parties involved in the position, including the Clearing Organization.
    """
    partyRole: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="Represents the role each specified party takes in the position.")
    """
    Represents the role each specified party takes in the position.
    """
    positionBase: cdm.product.template.TradableProduct.TradableProduct = Field(..., description="Encapsulates the core constituents that characterize a position.")
    """
    Encapsulates the core constituents that characterize a position.
    """

import cdm 
import cdm.event.common.PositionIdentifier
import cdm.event.common.TradeState
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRole
import cdm.product.template.TradableProduct
