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

__all__ = ['Transfer']

from cdm.product.common.settlement.AssetFlowBase import AssetFlowBase

class Transfer(AssetFlowBase):
    """
    Defines the movement of an Asset (eg cash, securities or commodities) between two parties on a date.
    """
    identifier: List[AttributeWithMeta[cdm.base.staticdata.identifier.Identifier.Identifier] | cdm.base.staticdata.identifier.Identifier.Identifier] = Field([], description="Represents a unique reference to the transfer.")
    """
    Represents a unique reference to the transfer.
    """
    payerReceiver: cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiver = Field(..., description="Represents the parties to the transfer and their role.")
    """
    Represents the parties to the transfer and their role.
    """
    settlementOrigin: Optional[AttributeWithReference | cdm.product.template.Payout.Payout] = Field(None, description="Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.")
    """
    Represents the origin to the transfer as a reference for lineage purposes, whether it originated from trade level settlement terms or from payment terms on an economic payout.
    """
    resetOrigin: Optional[cdm.event.common.Reset.Reset] = Field(None, description="Represents the reset and observation values that were used to determine the transfer amount.")
    """
    Represents the reset and observation values that were used to determine the transfer amount.
    """
    transferExpression: cdm.event.common.TransferExpression.TransferExpression = Field(..., description="Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.")
    """
    Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
    """

import cdm 
import cdm.base.staticdata.identifier.Identifier
import cdm.base.staticdata.party.PartyReferencePayerReceiver
import cdm.product.template.Payout
import cdm.event.common.Reset
import cdm.event.common.TransferExpression
