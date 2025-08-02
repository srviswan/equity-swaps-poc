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

__all__ = ['Valuation']


class Valuation(BaseDataClass):
    """
    Defines the value of an investment, asset, or security
    """
    amount: cdm.observable.asset.Money.Money = Field(..., description="Current value of the outstanding contract")
    """
    Current value of the outstanding contract
    """
    timestamp: datetime.datetime = Field(..., description="Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs.")
    """
    Date and time of the last valuation marked to market, provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs.
    """
    method: Optional[cdm.event.common.ValuationTypeEnum.ValuationTypeEnum] = Field(None, description="Method used for the valuation of the transaction by the valuation party.")
    """
    Method used for the valuation of the transaction by the valuation party.
    """
    source: Optional[cdm.event.common.ValuationSourceEnum.ValuationSourceEnum] = Field(None, description="Source of the valuation of the transaction by the valuation party.")
    """
    Source of the valuation of the transaction by the valuation party.
    """
    delta: Optional[Decimal] = Field(None, description="The ratio of the change in the price of a derivative transaction to the change in the price of the underlying. This field is applicable only to options and swaptions.")
    """
    The ratio of the change in the price of a derivative transaction to the change in the price of the underlying. This field is applicable only to options and swaptions.
    """
    valuationTiming: Optional[cdm.event.common.PriceTimingEnum.PriceTimingEnum] = Field(None, description="Denotes when the valuation was sourced during a business day.")
    """
    Denotes when the valuation was sourced during a business day.
    """
    priceComponent: Optional[cdm.observable.asset.Price.Price] = Field(None, description="Denotes the price used to compute the valuation.")
    """
    Denotes the price used to compute the valuation.
    """
    
    @rosetta_condition
    def condition_0_ValuationType(self):
        """
        The below condition ensures one and only one of the two attributes: 'Valuation Method' or 'Valuation Source' is allowed. Valuation of a trade or a portfolio is either internally calculated (via M2Market or M2Model methods) or supplied from an external source (e.g Central Counterparty's Valuation). Valuation cannot be based upon internal calculations and external source at the same time.
        """
        item = self
        return self.check_one_of_constraint('method', 'source', necessity=True)

import cdm 
import cdm.observable.asset.Money
import cdm.event.common.ValuationTypeEnum
import cdm.event.common.ValuationSourceEnum
import cdm.event.common.PriceTimingEnum
import cdm.observable.asset.Price
