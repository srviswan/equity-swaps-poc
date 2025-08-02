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

__all__ = ['ExecutionInstruction']


class ExecutionInstruction(BaseDataClass):
    """
    Specifies instructions for execution of a transaction, consisting of a product, price, quantity, parties, trade identifier, execution details, and settlement terms.
    """
    product: cdm.product.template.NonTransferableProduct.NonTransferableProduct = Field(..., description="Defines the financial product to be executed and contract formed.")
    """
    Defines the financial product to be executed and contract formed.
    """
    priceQuantity: List[cdm.observable.asset.PriceQuantity.PriceQuantity] = Field([], description="Defines the prices (e.g. spread, equity price, FX rate), quantities (e.g. currency amount, no. shares) and settlement terms (e.g. initial fee, broker fee, up-front cds payment or option premium settlement) associated with the constituents of the transacted product.")
    """
    Defines the prices (e.g. spread, equity price, FX rate), quantities (e.g. currency amount, no. shares) and settlement terms (e.g. initial fee, broker fee, up-front cds payment or option premium settlement) associated with the constituents of the transacted product.
    """
    @rosetta_condition
    def cardinality_priceQuantity(self):
        return check_cardinality(self.priceQuantity, 1, None)
    
    counterparty: List[cdm.base.staticdata.party.Counterparty.Counterparty] = Field([], description="Maps two defined parties to counterparty enums for the transacted product.")
    """
    Maps two defined parties to counterparty enums for the transacted product.
    """
    @rosetta_condition
    def cardinality_counterparty(self):
        return check_cardinality(self.counterparty, 2, 2)
    
    ancillaryParty: List[cdm.base.staticdata.party.AncillaryParty.AncillaryParty] = Field([], description="Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.")
    """
    Maps any ancillary parties, e.g. parties involved in the transaction that are not one of the two principal parties.
    """
    parties: List[cdm.base.staticdata.party.Party.Party] = Field([], description="Defines all parties to that execution, including agents and brokers.")
    """
    Defines all parties to that execution, including agents and brokers.
    """
    @rosetta_condition
    def cardinality_parties(self):
        return check_cardinality(self.parties, 2, None)
    
    partyRoles: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="Defines the role(s) that party(ies) may have in relation to the execution.")
    """
    Defines the role(s) that party(ies) may have in relation to the execution.
    """
    executionDetails: cdm.event.common.ExecutionDetails.ExecutionDetails = Field(..., description="Specifies the type and venue of execution, e.g. via voice, or electronically.")
    """
    Specifies the type and venue of execution, e.g. via voice, or electronically.
    """
    tradeDate: AttributeWithMeta[datetime.date] | datetime.date = Field(..., description="Denotes the trade/execution date.")
    """
    Denotes the trade/execution date.
    """
    tradeTime: Optional[AttributeWithMeta[cdm.base.datetime.TimeZone.TimeZone] | cdm.base.datetime.TimeZone.TimeZone] = Field(None, description="Denotes the trade time and timezone as agreed by the parties to the trade.")
    """
    Denotes the trade time and timezone as agreed by the parties to the trade.
    """
    tradeIdentifier: List[cdm.event.common.TradeIdentifier.TradeIdentifier] = Field([], description="Denotes one or more identifiers associated with the transaction.")
    """
    Denotes one or more identifiers associated with the transaction.
    """
    @rosetta_condition
    def cardinality_tradeIdentifier(self):
        return check_cardinality(self.tradeIdentifier, 1, None)
    
    collateral: Optional[cdm.product.collateral.Collateral.Collateral] = Field(None, description="Detail the collateral requirement anticipated with the transaction.")
    """
    Detail the collateral requirement anticipated with the transaction.
    """
    lotIdentifier: Optional[cdm.base.staticdata.identifier.Identifier.Identifier] = Field(None, description="Lot Identifier associated with the transaction.")
    """
    Lot Identifier associated with the transaction.
    """

import cdm 
import cdm.product.template.NonTransferableProduct
import cdm.observable.asset.PriceQuantity
import cdm.base.staticdata.party.Counterparty
import cdm.base.staticdata.party.AncillaryParty
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRole
import cdm.event.common.ExecutionDetails
import cdm.base.datetime.TimeZone
import cdm.event.common.TradeIdentifier
import cdm.product.collateral.Collateral
import cdm.base.staticdata.identifier.Identifier
