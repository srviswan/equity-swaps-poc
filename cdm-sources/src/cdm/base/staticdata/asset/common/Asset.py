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

__all__ = ['Asset']


class Asset(BaseDataClass):
    """
    An Asset is defined as something that can be owned and transferred in the financial markets. As a choice data type, one and only one of the attributes must be used.
    """
    Cash: Optional[cdm.base.staticdata.asset.common.Cash.Cash] = Field(None, description="An Asset that consists solely of a monetary holding in a currency.")
    """
    An Asset that consists solely of a monetary holding in a currency.
    """
    Commodity: Optional[cdm.base.staticdata.asset.common.Commodity.Commodity] = Field(None, description="An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.")
    """
    An Asset comprised of raw or refined materials or agricultural products, eg gold, oil or wheat.
    """
    DigitalAsset: Optional[cdm.base.staticdata.asset.common.DigitalAsset.DigitalAsset] = Field(None, description="An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.")
    """
    An Asset that exists only in digital form, eg Bitcoin or Ethereum; excludes the digital representation of other Assets.
    """
    Instrument: Optional[cdm.base.staticdata.asset.common.Instrument.Instrument] = Field(None, description="An asset that is issued by one party to one or more others; Instrument is also a choice data type.")
    """
    An asset that is issued by one party to one or more others; Instrument is also a choice data type.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('Cash', 'Commodity', 'DigitalAsset', 'Instrument', necessity=True)

import cdm 
import cdm.base.staticdata.asset.common.Cash
import cdm.base.staticdata.asset.common.Commodity
import cdm.base.staticdata.asset.common.DigitalAsset
import cdm.base.staticdata.asset.common.Instrument
